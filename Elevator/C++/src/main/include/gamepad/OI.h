#pragma once
#include <frc2/command/SubsystemBase.h>

class OI : public frc2::SubsystemBase
{
    public: 
        double GetRightDriveY(void);
    
    private:
        //Controller Port
        #define DRIVE_USB_PORT              0

        //Joystick Map
        #define RIGHT_ANALOG_Y              5
};