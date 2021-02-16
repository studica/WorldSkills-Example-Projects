package frc.robot.gamepad;

import edu.wpi.first.wpilibj.Joystick;

public class OI
{
    //Create the joystick
    Joystick drivePad;

    public OI()
    {
        //initialize the joystick
        drivePad = new Joystick(GamepadConstants.DRIVE_USB_PORT);
    }

    /**
     * @return the y-axis value from the drivePad right joystick
     */
    public double getRightDriveY()
    {
        double joy = drivePad.getRawAxis(GamepadConstants.RIGHT_ANALOG_Y);
        return Math.abs(joy) < 0.05 ? 0.0 : joy;
    }
}