# Skill Server
Skill Server is a Java application developed as part of the ELEC-E8004 Project Work course.
It provides the OPC UA part of the NXT skill implementation by serving as a TCP to OPC UA bridge.
The NXT implementation of the skill is also included in the `SkillBridgeDev` solution file.
For a complete description, refer to the project documentation. 
Generated Javadoc is also available in the `doc` folder.


## Requirements
This application was created with:
 * Java 8 JDK
 * Prosys OPC UA for Java SDK 4.2.0
 * Eclipse IDE
 * Unified Automation UaModeler 1.6.3

The Prosys SDK library needed to compile and run this application must be obtained separately.
Contact Prosys ([sales@prosysopc.com](mailto:sales@prosysopc.com)) on how to obtain it.

## Usage
These instructions assume you are using the Eclipse IDE for development.
Once the files have been unzipped, follow these instructions to compile
the application and export the jar file for deployment to a Raspberry Pi.

### Compiling

 1. Place the Prosys library `prosys-opc-ua-sdk-client-server-evaluation-4.2.0-955.jar` into the `lib`folder. Optionally
also copy the Javadoc archive into the `javadoc` folder.
 2. Open Eclipse and import the project: File -> Import... -> General -> Projects from Folder or Archive, select the SkillServer folder and import the project.
 3. Make sure the project compiles and works by running it in Eclipse.
 4. In the Package Explorer, right-click on the project and select Export...
 5. In the Export window, choose Java -> Runnable JAR file.
 6. Set the Export destination to `SkillServer\export\SkillServer.jar` and make sure "Package required libraries into generated JAR" is selected.

The content of the `export` folder can now be deployed to the Raspberry Pi. The folder should have the following content:
 - `SkillServer.jar` - The exported application.
 - `SkillServer.bat` - Launch script for running the application on Windows.
 - `SkillServer.sh` - Launch script for running the application on Linux. Assumes running on Raspbian and that the files are located in `/home/pi/skillserver`.
 - `skilserver.service` - systemd unit-file for running the application as a service on Raspbian/Linux. Uses `SkillServer.sh`.
 - `launchparams.cfg` - Application configuration.
 - `UserList.cfg` - User configuration for OPC UA.

### Configuration
The application can be configured by modifying the `launchparams.cfg` configuration file.
It contains the following settings:
 - `ua-port` - Port used by the OPC UA server. Default: 4840
 - `tcp-port` - Port used by the TCP server. Default: 4000
 - `user-list` - Path to the user list containing user-password combinations in the format `user:password`. Default: UserList.cfg
 - `log-file` - Path to the logfile created by the application. Default: SkillServer.log
 - `loglevel-file` - Verbosity level of the logfile. Default: DEBUG
 - `loglevel-console` - Verbosity level for the console. Default: INFO
 - `loglevel-ua` - Verbosity level of the UA server. Default: INFO
 - `loglevel-uastack` - Verbosity level of the UA Stack. Default: WARN
 - `autorestart` - If present, application shuts down after 110 minutes.
 - `no-security` - If present, disables all security features: user authentication and secure connections.

## OPC UA Address Space Model
The OPC UA address space model constructed for the skill profile has been modelled with UaModeler by Unified Automation.
The model is located in the `skillprofile.tt2pro` file in the `skillmodel` folder.
The Prosys SDK code-gen configuration file is also located in this folder together with the exported address space model in XML format.

## NXT Implementation
The NXT part of the skill profile implementation was developed inside the SkillBridgeDev NXT project, located in `skillbridgefb\SkillBridgeDev.sln.zip`
This project contains the whole skill implementation as used in the main NXT solution of the project work.

## License
This project is licensed under the terms of the __Apache 2__ license.

