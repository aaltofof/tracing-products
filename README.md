# Tracing Products in Flexible Production Systems

- Tracing Products in Flexible Production Systems is a modular production plant that consists of a EnAS demonstrator that presents a small scale product automation system, Festo Robotino that extends the EnAS by adding an additional mobile conveyor and a ABB IRB14000 Yumi two armed robot that is mounted on a Milvus automated guided vehicle or AGV.
- This repository includes visualization of the plant, control of the system in NXT Studio and the OPC UA implementation.
- Full documentation of the project can be read from the project [wiki](https://wiki.aalto.fi/display/AEEproject/Tracing+products+in+flexible+production+systems)

## Requirements
To successfully compile and run all parts of the project the following software must be installed:
* Visual Components
    - Requires a license that supports the OPC UA connectivity feature
* nxtSTUDIO V3.0 SP1
* Java 8 JDK
* Prosys OPC UA for Java SDK 4.2.0
* Eclipse IDE

The nxtSTUDIO V3.0 SP1 application, along with the OPCUASERVER license is needed to compile and run the control solution.
Contact nxtCONTROL ([info@nxtcontrol.com](mailto:info@nxtcontrol.com)) on how to obtain it.

The Prosys SDK library needed to compile and run this application must be obtained separately.
Contact Prosys ([sales@prosysopc.com](mailto:sales@prosysopc.com)) on how to obtain it. 

## Usage
Each directory in this repository has its own README that contains specific instructions for that part of the project. There are two ways the simulation can be interacted with:

1. From the HMI of the nxt program.
    - Launch the NXT solution program as per the instructions in the [README](nxt/README.md).
    - Start the simulation in Visual Components as per the instructions in the [README](Visualization/README.md).
2. From an OPC UA client using the application Skill interface.
    - Start by first configuring and starting the Skill Server application as described in the [README](opcua/SkillServer/README.md) of the Skill Server project.
    - Follow the instructions in the NXT [README](nxt/README.md) and start the control program.
    - Start the visualization by following its [instructions](Visualization/README.md).
    - Now everything is running and you should be able to connect to the Skill Server with an OPC UA client (e.g. UAExpert) and control the plant using the skills. You might need to enable remote control from the HMI of the NXT solution for full control.

The [IO Server](opcua/IOServer/README.md) was developed for the physical IceBlock controllers and is not utilized in the final version of the project. It is still included as it might come in handy in the future.

## License
This project is licensed under the terms of the [Apache 2](https://www.apache.org/licenses/LICENSE-2.0) license.