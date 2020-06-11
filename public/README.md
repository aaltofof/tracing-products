# Tracing Products in Flexible Production Systems
This repo contains the source code for the software and visualization developed and used by group 1-4 in the 
__ELEC-E8004 - Project work__ course, year 2020.  
A public wiki page describing the project is available [here](https://wiki.aalto.fi/display/AEEproject/Tracing+products+in+flexible+production+systems).


## Project structure
The files of the project are grouped and archived with the following logic:  
- `nxtSolution.zip` - Contains the NXT Studio solution used by the project.
- `Visualization.zip` - Contains the Visual Components model used in the project together with the used Python scripts and SolidEdge models.  
- `SkillServer.zip` - Contains the Skill Server Eclipse Java project together with the NXT parts of the Skill implementation.
- `IOServer.zip` - Contains the IO Server Eclipse Java project. This was not used in the final version of the project and could contain unidentified issues etc.


## Usage
Each part of the project contains its own README that contains instructions specific to that part.  

## Requirements
To successfully compile and run all parts of the project the following software must be installed:
* Visual Components
    - Requires a license that supports the OPC UA connectivity feature
* nxtSTUDIO V3.0 SP1
* Java 8 JDK
* Prosys OPC UA for Java SDK 4.2.0
* Eclipse IDE
* Unified Automation UaModeler 1.6.3

The nxtSTUDIO V3.0 SP1 application, along with the OPCUASERVER license is needed to compile and run the control solution.
Contact nxtCONTROL ([info@nxtcontrol.com](mailto:info@nxtcontrol.com)) on how to obtain it.

The Prosys SDK library needed to compile and run this application must be obtained separately.
Contact Prosys ([sales@prosysopc.com](mailto:sales@prosysopc.com)) on how to obtain it.  

## License
This project is licensed under the terms of the __Apache 2__ license.
