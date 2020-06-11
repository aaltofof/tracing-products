# Simulation in Visual Components
- One integral part of this project is a virtual 3D model of the [Aalto Factory of the Future (AFOF)](https://www.aalto.fi/en/futurefactory) developed at Aalto University. The visual model accurately replicates the physical setup and serves as an interactive simulation environment communicating with a controller via OPC UA. 
- Created using the [Visual Components](https://www.visualcomponents.com/) framework.  All the components of the simulation model are packaged into a single binary file stored in this repository under: `Visualization\PoductionTracing2020.vcmx`.
- The individual graphical designs of the 3D objects used in the model were created in the Solid Edge software. Some of them are stored in this repository under: `Visualization\SolidEdge_models`.

## Requirements

### Software tools
* Visual Components
    - requires a license that supports OPC UA connectivity feature.  

### Setting up dependencies 
* As a part of the simulation, there is the event logging functionality that relies on the service functions that had to be placed to an external file. This file must be made available to the simulation for the animation scripts to run without errors. 
*  Follow the steps below:
    1) Make sure Visual Components software is installed but not running.
    2) Copy-paste the file located in the repository `Visualization/Python scripts/AFOF.py` to the following path on your computer: `<VisualComponents_installation_path>\Python\Commands\`

## Usage
* Now that the Visual components software installed and the depedencies are taken care of as per the instructions above, it is time to launch the simulation.
    1) Get the NXT program `EnAS 2020 VC with Skills.sln` running.
        - For more details on how set up and launch the NXT program, please refer to the corresponding _readme_ file in the `nxt` section of this repository.
    2) Open the file `PoductionTracing2020.vcmx` in Visual Components.
    3) In the CONNECTIVITY tab, establish connection to the OPC UA server of the nxt application named `nxtOPCUA_Server`. Make sure the communication is successful.
        - if you have difficulty finding the CONNECTIVITY tab or don't know how to test the connection, check this [video tutorial](https://academy.visualcomponents.com/lessons/connect-a-remote-opc-ua-server/) from the Visual Components Academy.
    4) Having ensured that communication with the _nxt control program works_, press the simulation **play** button.
    5) From this point on, the simulation should respond to the commands from the control program. Various production routines could be launched from the _nxt program HMI_ in _nxt Studio_ software. 
        - Instructions on that can be found in the corresponding _readme_ file.

## License
This project is licensed under the terms of the __Apache 2__ license.