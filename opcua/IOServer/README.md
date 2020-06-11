# IO Server
IO Server is a Java application developed as part of the ELEC-E8004 Project Work course.
It provides an OPC UA representation of IceBlock devices with the primary purpose of providing access (currently read only) to the port states of the devices.
It was developed to provide the realtime status of control signals to a digital twin of the production plant .
As such the application together with the NXT implementation provides an OPC UA IO bridge between the real device and its digital twin.
The NXT implementation of the IO Bridge is also included in the `IOBridgeDev` solution file.
For a complete description, refer to the project documentation. 

__Please note that this software was not utilized in the final version of the project work (2020) and thus, can still have unidentified bugs and issues.__



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
 2. Open Eclipse and import the project: File -> Import... -> General -> Projects from Folder or Archive, select the IOServer folder and import the project.
 3. Make sure the project compiles and works by running it in Eclipse.
 4. In the Package Explorer, right-click on the project and select Export...
 5. In the Export window, choose Java -> Runnable JAR file.
 6. Set the Export destination to `IOServer\export\IOServer.jar` and make sure "Package required libraries into generated JAR" is selected.

The content of the `export` folder can now be deployed to the Raspberry Pi. The folder should have the following content:
 - `IOServer.jar` - The exported application.
 - `IOServer.bat` - Launch script for running the application on Windows.
 - `IOServer.sh` - Launch script for running the application on Linux. Assumes running on Raspbian and that the files are located in `/home/pi/ioserver`.
 - `ioserver.service` - systemd unit-file for running the application as a service on Raspbian/Linux. Uses `IOServer.sh`.
 - `launchparams.cfg` - Application configuration.
 - `UserList.cfg` - User configuration for OPC UA.

### Configuration
The application can be configured by modifying the `launchparams.cfg` configuration file.
It contains the following settings:
 - `ua-port` - Port used by the OPC UA server. Default: 4840
 - `tcp-port` - Port used by the TCP server. Default: 4000
 - `user-list` - Path to the user list containing user-password combinations in the format `user:password`. Default: UserList.cfg
 - `log-file` - Path to the logfile created by the application. Default: IOServer.log
 - `loglevel-file` - Verbosity level of the logfile. Default: DEBUG
 - `loglevel-console` - Verbosity level for the console. Default: INFO
 - `loglevel-ua` - Verbosity level of the UA server. Default: INFO
 - `loglevel-uastack` - Verbosity level of the UA Stack. Default: WARN
 - `autorestart` - If present, application shuts down after 110 minutes.
 - `no-security` - If present, disables all security features: user authentication and secure connections.

## OPC UA Address Space Model
The IO Server address space utilizes the UA for devices address space model and defines a custom DeviceType for the IceBlocks.
The IceBlockType has been modelled with UaModeler by Unified Automation.
The model is located in the `iceblocktype.tt2pro` file in the `iceblockmodel` folder.

## NXT Implementation
The NXT part of the IO Bridge implementation was developed inside the IOBridgeDev NXT project, located in `iobridgefb\IOBridgeDev.sln.zip`
This project contains the whole IOBridge implementation as would have been used in the main NXT solution of the project work.

## License
This project is licensed under the terms of the __Apache 2__ license.

