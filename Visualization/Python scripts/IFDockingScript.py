from vcScript import *
import AFOF

comp = getComponent()
DockingDoneFlag = comp.getProperty("DockedToEnAS")
# docking interface 
inIF = comp.getBehaviour("InInterface")
outIF = comp.getBehaviour("OutInterface")


def OnSignal( signal ):
  AFOF.log(comp, "docking sensor", [signal, signal.Value])
  
  if signal.Value is not None:
    # check for a valid entry interface
    entryIF = signal.Value.findBehaviour("EntryInterface")
    AFOF.log(comp, "attempting docking with a peer", [entryIF]) 
    
    if entryIF:
      outIF.connect(entryIF)
    
    if (outIF.ConnectedComponent):
      AFOF.log(comp, "docked with", [outIF.ConnectedComponent, outIF.ConnectedComponent.Name])
      DockingDoneFlag.Value = True
      AFOF.log(comp, "docking complete", [DockingDoneFlag, DockingDoneFlag.Value])
      
  else:
    outIF.disconnect() # clear interface connections
    DockingDoneFlag.Value = False;
    AFOF.log(comp, "disconnected outIF", [outIF])
  

def OnRun():
  pass


def OnStart():
  DockingDoneFlag.Value = False

def OnMatch(other_interface):
  AFOF.log(comp, "Matched interface", [other_interface])