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

	@Parameter(names = "no-security")
	public boolean noSecurity = false;

	@Parameter(names = "ua-port")
	public int uaPort = 4840;

	@Parameter(names = "tcp-port")
	public int tcpPort = 4000;

	@Parameter(names = "user-list")
	public String userListStr = "";

	@Parameter(names = "log-file")
	public String logFileStr = "";

	@Parameter(names = "loglevel-file")
	private String fileLogLevel = "DEBUG";

	@Parameter(names = "loglevel-ua")
	private String uaLogLevel = "INFO";

	@Parameter(names = "loglevel-uastack")
	private String uaStackLogLevel = "WARN";

	@Parameter(names = "loglevel-console")
	private String consoleLogLevel = "INFO";
	
	@Parameter(names = "autorestart")
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
