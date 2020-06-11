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
package fi.aalto.skillserver.opcua;

import java.io.*;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.server.ServerUserIdentity;
import com.prosysopc.ua.server.Session;
import com.prosysopc.ua.server.UserValidator;
import com.prosysopc.ua.stack.core.UserIdentityToken;
import com.prosysopc.ua.stack.core.UserTokenType;

/**
 * MyUserValidator
 * 
 * UserValidatior implementation used by the OPC UA server.
 * Reads username - password combinations from file,
 * stores them in a list and uses them to verify incoming 
 * connections.
 *
 */
public class MyUserValidator implements UserValidator {
	private final Logger logger = LoggerFactory.getLogger(MyUserValidator.class);
	private final HashMap<String, String> userList = new HashMap<String, String>();

	@Override
	public boolean onValidate(Session session, ServerUserIdentity userIdentity) throws StatusException {
		// Return true, if the user is allowed access to the server
		if (userIdentity.getType().equals(UserTokenType.UserName)) {
			if (!userList.isEmpty()) {
				String pw = userList.get(userIdentity.getName());
				if (pw != null) {
					if (userIdentity.getPassword().equals(pw)) {
						logger.info("User '{}' validated!", userIdentity.getName());
						return true;						
					}
					else {
						logger.info("User '{}' validation failed: wrong password!", userIdentity.getName());						
					}					
				}
				else {
					logger.info("User '{}' validation failed: unknown username!", userIdentity.getName());
				}
			}
			else {
				logger.warn("User '{}' validation failed: user list empty!", userIdentity.getName());
			}
		}
		return false;
	}

	@Override
	public void onValidationError(Session session, UserIdentityToken userToken, Exception exception) {
		
	}

	/**
	 * Load users and passwords from file.
	 * 
	 * @param userListStr Path to user list.
	 * @throws Exception
	 */
	public void loadUsers(String userListStr) throws Exception {
		logger.info("Loading users from file: " + userListStr);
		File userFile = new File(userListStr);
		BufferedReader userReader = new BufferedReader(new FileReader(userFile));
		String line;
		while ((line = userReader.readLine()) != null) {
			String[] parts = line.split(":");
			if (parts.length >= 2) {
				if (!parts[0].isEmpty() && !parts[1].isEmpty()) {
					userList.put(parts[0], parts[1]);
				}
			}
		}
		userReader.close();
		if (userList.isEmpty())
			throw new Exception("Error while adding users: User list file " + userListStr
					+ " was empty. Use format username:password");

	}

}
