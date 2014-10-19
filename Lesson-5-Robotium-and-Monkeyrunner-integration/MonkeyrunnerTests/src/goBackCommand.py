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

from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

# Connects to the current device, returning a MonkeyDevice object
device = MonkeyRunner.waitForConnection(10)

def goBack():
    print("----- goBack()")
    device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
    return


# Invoke actions in specified order
print("----- START TEST");
goBack();
print("----- END TEST");
