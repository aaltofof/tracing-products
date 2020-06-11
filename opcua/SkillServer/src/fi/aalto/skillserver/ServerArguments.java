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
package fi.aalto.skillserver;

import java.util.Locale;

import org.apache.log4j.Level;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

/**
 * ServerArguments
 * 
 * Class for storing and parsing arguments given at startup.
 *
 */
@Parameters(separators = "=")
public class ServerArguments {

	@Parameter(names = "no-security", description = "Disables all security features")
	public boolean noSecurity = false;

	@Parameter(names = "ua-port", description = "Port used for OPC UA communications")
	public int uaPort = 4840;

	@Parameter(names = "tcp-port", description = "Port used for TCP connections")
	public int tcpPort = 4000;

	@Parameter(names = "user-list", description = "Path to list containing user-password combos")
	public String userListStr = "";

	@Parameter(names = "log-file", description = "Path to log file")
	public String logFileStr = "";

	@Parameter(names = "loglevel-file", description = "Level of verbosity for log file")
	private String fileLogLevel = "DEBUG";

	@Parameter(names = "loglevel-ua", description = "Level of verbosity for UA Server")
	private String uaLogLevel = "INFO";

	@Parameter(names = "loglevel-uastack", description = "Level of verbosity for UA Stack")
	private String uaStackLogLevel = "WARN";

	@Parameter(names = "loglevel-console", description = "Level of verbosity for console")
	private String consoleLogLevel = "INFO";
	
	@Parameter(names = "autorestart", description = "Enable automatic program termination after 110 minutes of runtime")
	public boolean doSuicide = false;

	public Level getUaLevel() {
		return parseLevel(uaLogLevel);
	}

	public Level getStackLevel() {
		return parseLevel(uaStackLogLevel);
	}

	public Level getConsoleLevel() {
		return parseLevel(consoleLogLevel);
	}

	public Level getFileLevel() {
		return parseLevel(fileLogLevel);
	}

	private Level parseLevel(String levelStr) {
		Level ret = Level.OFF;
		switch (levelStr.toLowerCase(Locale.ROOT)) {
		case "all":
			ret = Level.ALL;
			break;

		case "debug":
			ret = Level.DEBUG;
			break;

		case "error":
			ret = Level.ERROR;
			break;

		case "fatal":
			ret = Level.FATAL;
			break;

		case "info":
			ret = Level.INFO;
			break;

		case "off":
			ret = Level.OFF;
			break;

		case "trace":
			ret = Level.TRACE;
			break;

		case "warn":
			ret = Level.WARN;
			break;

		default:
			break;
		}
		return ret;
	}

}
