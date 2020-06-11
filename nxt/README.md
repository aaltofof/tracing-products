# nxtSTUDIO IEC61499 Control Application 
The 'EnAS 2020 VC with Skills.sln' has been developed using the IEC 61499 Standard on NXT Studio. 
The application is developed as part of the ELEC-E8004 Project Work Course done along with the Aalto Factory of Future. 
The application provides an control solution to flexible production scenarios, which can be triggered using the developed HMI. 
The control solution communicates to a 3D visual model of the EnAS demonstrator developed on Visual Components, using the industry standard OPC-UA communication techonology.  

For a complete description, refer to the project documentation. 




## Requirements
This application was created with:
 * nxtSTUDIO V3.0 SP1

The nxtSTUDIO V3.0 SP1 application, along with the OPAUASERVER license is needed to compile and run this control solution, the application and license must be obtained separately.
Contact nxtCONTROL ([info@nxtcontrol.com](mailto:info@nxtcontrol.com)) on how to obtain it.

## Usage
These instructions assume you are nxtSTUDIO V3.0 SP1 along with the required OPCUASERVER License.

### Compiling and Running

 1. Download the "EnAS 2020 VC with Skills.sln" file and store it in your desired locations 
 2. Open the nxtSTUDIO software, unarchive and open the project: File -> Unarchive Solution -> "Select the downloaded file" -> Open Imported Solution
 3. Run the soft PLC: System -> Devices -> Active Network Profile "Local Test" -> Right Click DEV0 -> Start Soft PLC 
 4. Deploy the solution: Right Click DEV0 -> Deploy using ('Local Test') Profile
 5. Onced the deployed the OPC UA Server will be running and will be ready to communicate to the VC Model. 
 6. Deploy and Run HMI: Solution Overview -> Canvases -> Right Click 800x450 -> Test HMI Runtime on Local Computer.
 7. Depending on the order placed, the VC model would respond to the commands sent via the NXT control solution. 

## License
This project is licensed under the terms of the __Apache 2__ license.

