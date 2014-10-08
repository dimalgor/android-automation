import sys
import os

# This must be imported before MonkeyRunner and MonkeyDevice,
# otherwise the import fails.
# PyDev sets PYTHONPATH, use it
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

from devices.htc import Desire  # tested on  HTC Desire 

class DeviceScreenChooser:
    def __init__(self, _deviceModel, _androidOSVersion):
        global deviceModel;
        global androidOSVersion;
        deviceModel = _deviceModel;
        androidOSVersion = _androidOSVersion;
    
    def getDeviceSceen(self):
        if (str(deviceModel) == "GT-I9100"):
            print("----- deviceModel = GT-I9100");
            device = Desire(androidOSVersion, deviceModel);                                           
        elif (str(deviceModel) == "GT-I9100"):
            print("----- deviceSceen = HD(landscape orientation)");
            device = Desire(androidOSVersion, deviceModel);                   
        return device;
