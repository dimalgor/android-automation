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
displayWidth = None;
displayHeight = None;
displayDensity = None;
deviceSceen = None;

# initialization
def initDisplayValues():
    global deviceSceen;

    deviceModel = device.getProperty("build.model");
    androidOSVersion = device.getProperty("build.version.release");
        
    print("----- displayWidth = " + displayWidth);        
    print("----- displayHeight = " + displayHeight);        
    print ("----- deviceModel = " + deviceModel);
    print ("----- androidOSVersion = " + androidOSVersion);
    
    dsc = DeviceScreenChooser(deviceModel, androidOSVersion);
    deviceSceen = dsc.getDeviceSceen();
        
    return

# Press on  KEYCODE_DPAD_DOWN 
def takePhoto():
    if(deviceSceen.OPTICAL_TRACK_PAD == True):
        print("----- press on optical trackball")
        device.press('KEYCODE_DPAD_CENTER', MonkeyDevice.DOWN_AND_UP)
    else:
        print("----- press on take photo button")
        # We don't need to distinguish between landscape and portrait here
        # because the button remains on the same place only [X,Y] system
        # changes -> the change is done in screen resolution class
        print("----- Take a picture button X = " + str(deviceSceen.TAKE_PICTURE_BUTTON_X));
        print("----- Take a picture button Y = " + str(deviceSceen.TAKE_PICTURE_BUTTON_Y));
        device.touch(deviceSceen.TAKE_PICTURE_BUTTON_X, deviceSceen.TAKE_PICTURE_BUTTON_Y, MonkeyDevice.DOWN_AND_UP)
    # photo processing can take few seconds ... better to wait
    MonkeyRunner.sleep(5);
    return

# Press on  Done button
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
