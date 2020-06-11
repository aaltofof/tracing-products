from vcScript import *
import AFOF
# retrieve references to generic objects
app = getApplication()
comp = getComponent()
# define and retrieve joint elements
servo = comp.findBehaviour("servo_controller_name")
joint = servo.getJoint(0)
# signal interface
MoveCommand = comp.getBehaviour("command_name")
VAL = MoveCommand.Value
# outputs
Extended = comp.getProperty("property_name")
Retracted = comp.getProperty("property_name")

def OnSignal( signal ):
  global VAL 
  VAL = signal.Value  
  msg = comp.Name + " return cmd"
  AFOF.log(msg, [VAL])
  resumeRun()

# joint status signals
def UpdateOutputSignals(CheckOnEdges):
  if CheckOnEdges == True :
    Extended.Value = round(joint.CurrentValue,2) == round( float(joint.MaxValue), 2)
    Retracted.Value = round(joint.CurrentValue,2) == round( float(joint.MinValue), 2)    
  else :
    Extended.Value = False
    Retracted.Value = False


def OnStart():
  UpdateOutputSignals(False)  # reset the outputs
  
  
def OnRun():

  while (app.Simulation.IsRunning):
    UpdateOutputSignals(False) # reset the outputs
    if (VAL):
      servo.moveJoint(0,120.0)
      condition(lambda: [round(servo.getJointTarget(0),2) == round(servo.getJointValue(0),2)])
      msg = comp.Name + " extended"
      AFOF.log(msg)
    else:
      servo.moveJoint(0,0.0)
      condition(lambda: [round(servo.getJointTarget(0),2) == round(servo.getJointValue(0),2)])
      msg = comp.Name + " retracted"
      AFOF.log(msg)
    
    UpdateOutputSignals(True) # update the outputs
    suspendRun()