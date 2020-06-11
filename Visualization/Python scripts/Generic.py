from vcScript import *
import AFOF


app = getApplication()


def OnStart():
  app.clearMessages()
  print("---------- NEW SIMULATION RUN STARTED ------------")

  try: # attempt to create a logger for this simulation session
    AFOF.logger.initNewLog()
    
    if not AFOF.logger.initStatus :
      print("Logger failed to initialize on path: ", AFOF.logger.filePath)
    else:
      print("Logger successfylly initialized on path: ", AFOF.logger.filePath)
  
  except AssertionError as error: # something didn't work
    errormsg = "Error: logger file was not created for the following reason: " 
    print(errormsg)
    print(error)
  
  


def OnSignal( signal ):
  pass


def OnRun():
  pass
