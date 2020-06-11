from vcScript import *
import AFOF
app = getApplication()
comp = getComponent()
path = comp.getBehaviour("LinearPath")
creator = comp.findBehaviour("ComponentCreator")
creator.TemplateComponent = app.findComponent("empty_cup_template")


def OnStart():
  creator.Limit = 0;
  creator.Interval = 99999;


def OnSignal( signal ):
  AFOF.log(comp, "create new cup cmd", [signal, signal.Value])
  
  if (signal.Value):
    creator.Limit = 1
    new_cup = creator.create()
    if new_cup is not None:
      AFOF.log(comp, "created a new cup", [creator, new_cup])
      comp.attach(new_cup)
      resumeRun() # actual path connection is done inside OnRun method
    else: # coulnd't create a new cup
      AFOF.log(comp, "couldn't create a cup", [creator])
    
  else:
    creator.Limit = 0



# for some incredible reason, 
# putting components on path doesn't work 
# unless put inside the OnRun() method...
def OnRun():
  delay(AFOF.INIT_DELAY) # necessary for proper initialiation
  while (app.Simulation.IsRunning):
    suspendRun()
    if comp.ComponentChildren: 
      for i in range(0, len(comp.ComponentChildren)):
        path.grab(comp.ChildComponents[i])
