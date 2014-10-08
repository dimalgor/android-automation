class Desire:    
    
    def __init__(self, androidOSVersion, deviceModel): 
        print("----- init deviceModel = " + str(deviceModel));
        print("----- init androidOSVersion = " + str(androidOSVersion));
        
        if(deviceModel == "GT-I9100"):
            print("----- deviceModel == Samsung Galaxy SII aka GT-I9100");
            self.TAKE_PICTURE_BUTTON_WIDTH_PERCENT = 96 
            self.TAKE_PICTURE_BUTTON_HEIGHT_PERCENT = 50
            