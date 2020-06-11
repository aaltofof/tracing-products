from vcScript import *
import AFOF
import vcVector
import vcMatrix

comp = getComponent()
vehicle = comp.getBehaviour("Vehicle")
moveCMD = comp.getBehaviour("DockToEnAS")
starting_position = vcVector.new(-1100, 271, 0)
enas_docking_pos = vcVector.new(-700, 271, 0)
target_position = starting_position
  
# frequently required routine
# otherwise, vehicle behavior is easy to mess up
def resetVehicleSettings():
  vehicle.clearMove()
  vehicle.OffsetMatrix = None

def setMotionPars(reverseON):
  global target_position
  resetVehicleSettings()
  vehicle.Acceleration = 100.0
  vehicle.Deceleration = 100.0
  vehicle.MaxSpeed = 100
  
  if (reverseON): # change vehicle orientation to go reverse
    m = vcMatrix.new() 
    m.rotateRelZ(180)
    vehicle.OffsetMatrix = m
    target_position = starting_position
  else: # move forwards to EnAS
    target_position = enas_docking_pos 

def OnSignal( signal ):
  AFOF.log(comp, "move cmd", [signal, signal.Value])
  resumeRun()


# primary method where the movement can happen
def OnRun():
  global target_position
  while(True):
    suspendRun()
    
    # check the actual command
    setMotionPars(not moveCMD.Value)
    # set component in motion 
    vehicle.addControlPoint(target_position)
    AFOF.log(comp, "motion started", [vehicle, vehicle.PathLength, vehicle.TotalTime])
    delay(vehicle.TotalTime)
    AFOF.log(comp, "motion complete", [vehicle])


def OnStart():
  resetVehicleSettings()
  
def OnReset():
  resetVehicleSettings()

# this event for some reason is not working.. :(
def OnMovementFinished(component, time):
  AFOF.log(comp, "reached destination", [veh_ref, ev_time])
  
  
