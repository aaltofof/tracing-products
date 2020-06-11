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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SuicideThread
 * 
 * Thread that can be used to exit application after a set time.
 * 
 */
public class SuicideThread extends Thread {

	private static Logger logger = LoggerFactory.getLogger(SuicideThread.class);
	public boolean doShutdown = false;
	private int waitSeconds = 0;

	public SuicideThread() {
		this.setName("SuicideThread");
	}

	public void setTime(int seconds) {
		if (seconds > 0)
			waitSeconds = seconds;
	}

	public void run() {
		if (waitSeconds > 0) {
			logger.warn("SuicideThread started! Time: {} sec.", waitSeconds);
			try {
				sleep(waitSeconds * 1000);
			} catch (InterruptedException e) {
				logger.error("SuicideThread sleep interrupted!");
			}
			logger.error("SuicideThread will now stop the main thread!");
			doShutdown = true;
		} else
			logger.error("Tried to start SuicideThread with invalid time set!");
	}

}
