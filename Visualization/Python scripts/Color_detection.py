from vcScript import *
import AFOF

comp = getComponent()
compSignal = comp.findBehaviour("SensorComponentSignal")
color_code = comp.getProperty("WP_color_code")
colors={ 'green_matte': 1, 'red_matte': 2}


# returns a string = name of the material of the 1st component inside the cup (expected to be a workpiece)
# - detectedComponent: reference to a component (expected to be a cup) 
def detectedWPColor(detectedComponent):
  cup_content = detectedComponent.ComponentChildren
  if (len(cup_content) == 0): # cup is empty
    wp_material = "empty"
    color_code.Value = 0 # means nothing is there
  else: # there is something on that cup
    wp_material = cup_content[0].Material.Name
    color_code.Value = colors.get(wp_material, 0)
  return wp_material


# check the detected component (expected to be a cup) and updates the color_code property
# - comp_sig: component signal carrying information about the detected component 
def testComponentSignal(comp_sig):
  if comp_sig.Value is None:
    color_code.Value = 0 # means nothing is there
  else: # sensor detected some component
    AFOF.log(comp, "detected", [comp_sig, comp_sig.Value.Name, detectedWPColor(comp_sig.Value)])


def OnSignal( signal ):
  testComponentSignal(compSignal)

def OnStart():
  testComponentSignal(compSignal)

def OnRun():
  pass

