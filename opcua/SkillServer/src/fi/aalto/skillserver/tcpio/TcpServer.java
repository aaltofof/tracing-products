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
package fi.aalto.skillserver.tcpio;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.aalto.skillserver.opcua.SkillNodeManager;

/**
 * TcpServer
 * 
 * The TCP server runs in its own thread and
 * accepts incoming connections on the set port.
 * A SkillBridge is created for every connection.
 *
 */
public class TcpServer extends Thread {

	private final int port;
	private final SkillNodeManager nodeManager;
	private ServerSocket serverSocket;
	private List<SkillBridge> bridges = new ArrayList<SkillBridge>();
	private static Logger logger = LoggerFactory.getLogger(TcpServer.class);

	/**
	 * Initialises the server.
	 * 
	 * @param port The TCP port number to listen on.
	 * @param nodemanager Nodemanager instance managing the skills.
	 */
	public TcpServer(int port, SkillNodeManager nodemanager) {
		this.port = port;
		this.nodeManager = nodemanager;
		this.setName("TcpServerThread");
	}

	/**
	 * This function runs when the thread is started.
	 * Listens for incoming connections and assigns
	 * bridge instances to them.
	 */
	public void run() {
		try {
			// Create the server socket on the specified port
			serverSocket = new ServerSocket(port);
			logger.info("TCP Server started on port {}!",port);
			while (true) {
				/* serverSocket.accept() returns when a new client connects to the server.
				 * The returned socket is sent to the new SkillBridge instance to take care of.
				 * All bridge instances are added to a list to keep track of them.
				 */
				bridges.add(new SkillBridge(serverSocket.accept(), nodeManager));
				bridges.get(bridges.size() - 1).start();
			}

		} catch (Exception e) {
			if (e.getMessage().toLowerCase().contentEquals("socket closed")) {
				logger.warn("TCP Server down! Reason: {}", e.getMessage());
			} else {
				logger.error("TCP Server thread caught an unhandled exception!");
				logger.error("Details: {}", e.getMessage());
			}
		}
	}

	/**
	 * Stop the TCP server, close open connections and shutdown
	 * bridges.
	 */
	public void close() {
		try {
			logger.info("TCP Server stopping!");
			serverSocket.close();
			if (!bridges.isEmpty()) {
				for (SkillBridge sb : bridges) {
					if (sb != null && sb.isAlive()) {
						sb.close();
						sb.join();
					}
				}
			}
			logger.info("TCP Server STOPPED!");

		} catch (Exception e) {
			logger.error("TCP Server close failed!");
			logger.error("Details: {}", e.getMessage());
		}
	}

}
