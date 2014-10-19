import sys
import os

try:
    for p in os.environ['PYTHONPATH'].split(':'):
        if not p in sys.path:
            sys.path.append(p)
except:
    pass
    
try:
    sys.path.append(os.path.join(os.environ['MONKEYRUNNER_SCRIPT'], 'src'))
except:
    pass

from utils.deviceScreenChooser import DeviceScreenChooser
from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

# Connects to the current device, returning a MonkeyDevice object
device = MonkeyRunner.waitForConnection(10)

# initialization
deviceSceen = None;
deviceModel = None;

# initialization
def initDisplayValues():
    global deviceSceen;
    global deviceModel;

    print("----- displayWidth = " + device.getProperty("display.width"));        
    print("----- displayHeight = " + device.getProperty("display.height"));        
    deviceModel = device.getProperty("build.model");
    print ("----- deviceModel = " + deviceModel);
    androidOSVersion = device.getProperty("build.version.release");
    print ("----- androidOSVersion = " + androidOSVersion);
    
    dsc = DeviceScreenChooser(deviceModel, androidOSVersion);
    deviceSceen = dsc.getDeviceSceen();
        
    return
 
def takePhoto():
    print("----- pressDone takePhoto()")
    
    if(str(deviceModel) == "HTC Desire"):
        device.press('KEYCODE_DPAD_CENTER', MonkeyDevice.DOWN_AND_UP)        
    else:
        print("----- Take a picture button X = " + str(deviceSceen.TAKE_PICTURE_BUTTON_X));
        print("----- Take a picture button Y = " + str(deviceSceen.TAKE_PICTURE_BUTTON_Y));
        device.touch(deviceSceen.TAKE_PICTURE_BUTTON_X, deviceSceen.TAKE_PICTURE_BUTTON_Y, MonkeyDevice.DOWN_AND_UP)
        
    MonkeyRunner.sleep(3);
    
    return

def pressDone():
    print("----- pressDone button")
    print("----- Done button X = " + str(deviceSceen.CAMERA_SAVE_BUTTON_X))
    print("----- Done button Y = " + str(deviceSceen.CAMERA_SAVE_BUTTON_Y))
    device.touch(deviceSceen.CAMERA_SAVE_BUTTON_X, deviceSceen.CAMERA_SAVE_BUTTON_Y, MonkeyDevice.DOWN_AND_UP)
    MonkeyRunner.sleep(3);    
    return

# Invoke actions in specified order
print("----- START TEST");
initDisplayValues();
takePhoto();
pressDone();
print("----- END TEST");
