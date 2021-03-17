#include "gamepad/OI.h"
#include "frc/Joystick.h"
#include <cmath>

frc::Joystick drivePad(DRIVE_USB_PORT);

/**
 * @return the y-axis value from the drivePad right joystick
 */
double OI::GetRightDriveY(void)
{
    double joy = drivePad.GetRawAxis(RIGHT_ANALOG_Y);
    if(fabs(joy) < 0.05)
        return 0.0;
    else
        return joy;
}