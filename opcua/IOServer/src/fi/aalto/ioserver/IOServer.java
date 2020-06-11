/*******************************************************************************
 * Copyright 2020 Information Technologies in Industrial Automation, Aalto Univeristy
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package fi.aalto.ioserver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beust.jcommander.JCommander;
import com.prosysopc.ua.ApplicationIdentity;
import com.prosysopc.ua.UaApplication.Protocol;
import com.prosysopc.ua.UserTokenPolicies;
import com.prosysopc.ua.server.NodeManagerListener;
import com.prosysopc.ua.server.UaServer;
import com.prosysopc.ua.server.UaServerException;
import com.prosysopc.ua.stack.builtintypes.DateTime;
import com.prosysopc.ua.stack.builtintypes.LocalizedText;
import com.prosysopc.ua.stack.cert.DefaultCertificateValidator;
import com.prosysopc.ua.stack.cert.DefaultCertificateValidatorListener;
import com.prosysopc.ua.stack.cert.PkiDirectoryCertificateStore;
import com.prosysopc.ua.stack.core.ApplicationDescription;
import com.prosysopc.ua.stack.core.ApplicationType;
import com.prosysopc.ua.stack.core.MessageSecurityMode;
import com.prosysopc.ua.stack.transport.security.KeyPair;
import com.prosysopc.ua.stack.transport.security.SecurityMode;
import com.prosysopc.ua.stack.transport.security.SecurityPolicy;
import com.prosysopc.ua.types.opcua.server.BuildInfoTypeNode;

import fi.aalto.ioserver.opcua.MyCertificateValidationListener;
import fi.aalto.ioserver.opcua.MyUserValidator;
import fi.aalto.ioserver.opcua.di.server.ServerInformationModel;
import fi.aalto.ioserver.opcua.IONodeManager;
import fi.aalto.ioserver.opcua.IONodeManagerListener;
import fi.aalto.ioserver.tcpio.TcpServer;

/**
 * AFOF IO Server
 * 
 * OPC UA server providing the OPC UA part of the IO Bridge. Acts as a bridge
 * between the IO of the IceBlocks and their OPC UA representation.
 * Based on the Prosys OPC UA SDK for Java and provided examples.
 * 
 * Based heavily on the SKillServer application with modifications mainly 
 * to the class/variable names and IOBridge class.
 * 
 * Copyright 2020 Aalto University
 * 
 */

public class IOServer {

	public final static String APP_NAME = "IOServer";

	private final Logger logger = LoggerFactory.getLogger(IOServer.class);
	private MyUserValidator userValidator;
	private final DefaultCertificateValidatorListener validationListener = new MyCertificateValidationListener();
	private static IONodeManager ioNodeManager;
	private NodeManagerListener ioNodeManagerListener = new IONodeManagerListener();
	private ServerArguments startArgs = new ServerArguments();
	private SuicideThread restartThread = new SuicideThread();

	protected UaServer server;
	protected static TcpServer tcpServer;

	/**
	 * Main IO Server program Parses startup arguments, initialises the OPC UA
	 * server and starts the server.
	 * 
	 * @param args Command line arguments given at startup.
	 */
	public static void main(String[] args) {
		System.out.println("App " + APP_NAME + " started!");
		try {
			IOServer ioServer = new IOServer();
			JCommander.newBuilder().addObject(ioServer.startArgs).build().parse(args);
			ioServer.initialize();
			ioServer.createAddressSpace();
			ioServer.initTcp();
			ioServer.run();
		} catch (Exception e) {
			System.out.println("Fatal error: " + e.toString());
		}
	}

	/**
	 * Creates the TCP server thread.
	 */
	private void initTcp() {
		tcpServer = new TcpServer(startArgs.tcpPort, ioNodeManager);
	}

	/**
	 * Starts the OPC UA and TCP servers and then waits for exit.
	 * 
	 * @throws UaServerException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	private void run() throws UaServerException, IOException, InterruptedException {
		server.start();
		tcpServer.start();

		while(!restartThread.doShutdown) {
			Thread.sleep(5000);
		}

		logger.info("Shutting down...");
		tcpServer.close();
		tcpServer.join();
		server.shutdown(1, new LocalizedText("IO server shutting down"));
		logger.warn("IOServer shutdown complete.");

	}
	
	/**
	 * Registers the Server Information Model and creates the Node Manager for the
	 * IceBlock nodes.
	 */
	private void createAddressSpace() {
		loadInformationModels();
		ioNodeManager = new IONodeManager(server, IONodeManager.NAMESPACE);
		ioNodeManager.addListener(ioNodeManagerListener);

	}

	protected void loadInformationModels() {
		server.registerModel(ServerInformationModel.MODEL);
		try {
			server.getAddressSpace().loadModel(ServerInformationModel.getLocationURI());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		server.registerModel(fi.aalto.ioserver.opcua.iceblocktype.server.ServerInformationModel.MODEL);
		try {
			server.getAddressSpace().loadModel(fi.aalto.ioserver.opcua.iceblocktype.server.ServerInformationModel.getLocationURI());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Generates/loads certificates ands sets security settings.
	 * @throws Exception
	 */
	private void initialize() throws Exception {
		initLogger();
		logger.info("IO Server started!");
		if(startArgs.doSuicide) {
			
			restartThread.setTime(110*60);
			restartThread.start();
		}
		logger.info("Creating OPC UA Server...");
		server = new UaServer();
		server.setEnableIPv6(false);

		final PkiDirectoryCertificateStore certificateStore = new PkiDirectoryCertificateStore();
		final DefaultCertificateValidator validator = new DefaultCertificateValidator(certificateStore);
		server.setCertificateValidator(validator);
		validator.setValidationListener(validationListener);

		// *** Application Description is sent to the clients
		ApplicationDescription appDescription = new ApplicationDescription();
		// 'localhost' (all lower case) in the ApplicationName and
		// ApplicationURI is converted to the actual host name of the computer
		// (including the possible domain part) in which the application is run.
		// (as available from ApplicationIdentity.getActualHostName())
		// 'hostname' is converted to the host name without the domain part.
		// (as available from
		// ApplicationIdentity.getActualHostNameWithoutDomain())
		appDescription.setApplicationName(new LocalizedText(APP_NAME + "@hostname"));
		appDescription.setApplicationUri("urn:localhost:OPCUA:" + APP_NAME);
		appDescription.setProductUri("urn:aalto.fi:OPCUA:" + APP_NAME);
		appDescription.setApplicationType(ApplicationType.Server);

		server.setPort(Protocol.OpcTcp, startArgs.uaPort);

		// optional server name part of the URI (default for all protocols)
		server.setServerName("OPCUA/" + APP_NAME);

		logger.info("Loading certificates..");
		File privatePath = new File(certificateStore.getBaseDir(), "private");
		@SuppressWarnings("unused")
		KeyPair issuerCertificate = ApplicationIdentity.loadOrCreateIssuerCertificate("IOServerCA", privatePath,
				"opcua", 3650, false);

		final ApplicationIdentity identity = ApplicationIdentity.loadOrCreateCertificate(appDescription, "AFoF",
				"opcua", privatePath, null, null, true);

		server.setApplicationIdentity(identity);

		Set<SecurityPolicy> supportedSecurityPolicies = new HashSet<SecurityPolicy>();
		if (startArgs.noSecurity) {
			supportedSecurityPolicies.add(SecurityPolicy.NONE);
		} else {
			// supportedSecurityPolicies.addAll(SecurityPolicy.ALL_SECURE_101);
			// supportedSecurityPolicies.addAll(SecurityPolicy.ALL_SECURE_102);
			// supportedSecurityPolicies.addAll(SecurityPolicy.ALL_SECURE_103);
			supportedSecurityPolicies.addAll(SecurityPolicy.ALL_SECURE_104);
		}

		Set<MessageSecurityMode> supportedMessageSecurityModes = new HashSet<MessageSecurityMode>();
		if (startArgs.noSecurity) {
			supportedMessageSecurityModes.add(MessageSecurityMode.None);
		} else {
			supportedMessageSecurityModes.add(MessageSecurityMode.SignAndEncrypt);
		}

		server.getSecurityModes()
				.addAll(SecurityMode.combinations(supportedMessageSecurityModes, supportedSecurityPolicies));

		// Define the supported user authentication methods
		if (!startArgs.noSecurity && !startArgs.userListStr.isEmpty()) {
			server.addUserTokenPolicy(UserTokenPolicies.SECURE_USERNAME_PASSWORD);
			userValidator = new MyUserValidator();
			userValidator.loadUsers(startArgs.userListStr);
			server.setUserValidator(userValidator);
		} else {
			server.addUserTokenPolicy(UserTokenPolicies.ANONYMOUS);

		}

		server.init();

		initBuildInfo();

	}

	/**
	 * Initialises the logging subsystem.
	 */
	private void initLogger() {
		PatternLayout layout = new PatternLayout();
		String conversionPattern = "%d{dd.MM.yyyy HH:mm:ss.SSS} [%t] %p %c - %m%n";
		layout.setConversionPattern(conversionPattern);

		ConsoleAppender consoleAppender = new ConsoleAppender();
		consoleAppender.setLayout(layout);
		consoleAppender.setThreshold(startArgs.getConsoleLevel());
		consoleAppender.activateOptions();

		org.apache.log4j.Logger rootLogger = org.apache.log4j.Logger.getRootLogger();
		org.apache.log4j.Logger.getLogger("com.prosysopc.ua").setLevel(startArgs.getUaLevel());
		org.apache.log4j.Logger.getLogger("com.prosysopc.ua.stack").setLevel(startArgs.getStackLevel());

		rootLogger.setLevel(Level.ALL);
		rootLogger.addAppender(consoleAppender);

		if (!startArgs.logFileStr.isEmpty()) {
			FileAppender fileAppender = new FileAppender();
			fileAppender.setFile(startArgs.logFileStr);
			fileAppender.setLayout(layout);
			fileAppender.setThreshold(startArgs.getFileLevel());
			fileAppender.activateOptions();
			rootLogger.addAppender(fileAppender);
		}

	}

	/**
	 * Populates build information available in the Server node.
	 */
	private void initBuildInfo() {
		final BuildInfoTypeNode buildInfo = server.getNodeManagerRoot().getServerData().getServerStatusNode()
				.getBuildInfoNode();
		buildInfo.setProductName(APP_NAME);
		buildInfo.setManufacturerName("Aalto University");
		buildInfo.setSoftwareVersion("1.0.0");
		buildInfo.setBuildNumber("100");

		final URL classFile = UaServer.class.getResource("/fi/aalto/ioserver/IOServer.class");
		if (classFile != null && classFile.getFile() != null) {
			final File mfFile = new File(classFile.getFile());
			GregorianCalendar c = new GregorianCalendar();
			c.setTimeInMillis(mfFile.lastModified());
			buildInfo.setBuildDate(new DateTime(c));
		}
	}

}
