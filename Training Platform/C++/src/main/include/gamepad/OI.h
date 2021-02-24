#pragma once
#include <frc2/command/SubsystemBase.h>

class OI : public frc2::SubsystemBase
{
    public: 
        double GetRightDriveY(void);
        double GetRightDriveX(void);
        double GetLeftDriveY(void);
        double GetLeftDriveX(void);
        bool GetDriveRightTrigger(void);
        bool GetDriveRightBumper(void);
        bool getDriveLeftTrigger(void);
        bool GetDriveLeftBumper(void);
        bool GetDriveXButton(void);
        bool GetDriveSquareButton(void);
        bool GetDriveCircleButton(void);
        bool GetDriveTriangleButton(void);
        bool GetDriveOptionsButton(void);
        bool GetDriveShareButton(void);
        bool GetDriveRightAnalogButton(void);
        bool GetDriveLeftAnalogButton(void);
        bool GetDrivePS4Button(void);
        bool GetDriveTouchpadButton(void);
    
    private:
        //Controller Port
        #define DRIVE_USB_PORT              0

        //Button Map
        #define X_BUTTON                    2
        #define SQUARE_BUTTON               1
        #define CIRCLE_BUTTON               3
        #define TRIANGLE_BUTTON             4
        #define LEFT_BUMPER                 5
        #define RIGHT_BUMPER                6
        #define LEFT_TRIGGER                7
        #define RIGHT_TRIGGER               8
        #define SHARE_BUTTON                9
        #define OPTIONS_BUTTON              10
        #define LEFT_ANALOG_BUTTON          11
        #define RIGHT_ANALOG_BUTTON         12
        #define PS4_BUTTON                  13
        #define TOUCHPAD_BUTTON             14

        //Joystick Map
        #define LEFT_ANALOG_X               0
        #define LEFT_ANALOG_Y               1
        #define RIGHT_ANALOG_X              2
        #define RIGHT_ANALOG_Y              5
};