package frc.robot.gamepad;

import edu.wpi.first.wpilibj.Joystick;

public class OI
{
    Joystick drivePad;

    public OI()
    {
        drivePad = new Joystick(GamepadConstants.DRIVE_USB_PORT);
    }

    /**
     * Drive Controller
     */

        /**
         * @return the y-axis value from the drivePad right joystick
         */
        public double getRightDriveY()
        {
            double joy = drivePad.getRawAxis(GamepadConstants.RIGHT_ANALOG_Y);
            if(Math.abs(joy) < 0.05)
                return 0.0;
            else  
                return joy;
        }

        /**
         * @return the x-axis value from the drivePad right Joystick
         */
        public double getRightDriveX()
        {
            double joy = drivePad.getRawAxis(GamepadConstants.RIGHT_ANALOG_X);
            if(Math.abs(joy) < 0.05)
                return 0.0;
            else
                return joy;
        }

        /**
         * @return the y-axis value from the drivePad left joystick
         */
        public double getLeftDriveY()
        {
            double joy = drivePad.getRawAxis(GamepadConstants.LEFT_ANALOG_Y);
            if(Math.abs(joy) < 0.05)
                return 0.0;
            else  
                return joy;
        }
    
        /**
         * @return the x-axis value from the drivePad left Joystick
         */
        public double getLeftDriveX()
        {
            double joy = drivePad.getRawAxis(GamepadConstants.LEFT_ANALOG_X);
            if(Math.abs(joy) < 0.05)
                return 0.0;
            else
                return joy;
        }

        /**
         * @return a true or false depending on the input
         */
        public boolean getDriveRightTrigger()
        {
            return drivePad.getRawButton(GamepadConstants.RIGHT_TRIGGER);
        }

        /**
         * @return a true or false depending on the input
         */
        public boolean getDriveRightBumper()
        {
            return drivePad.getRawButton(GamepadConstants.RIGHT_BUMPER);
        }

        /**
         * @return a true or false depending on the input
         */
        public boolean getDriveLeftTrigger()
        {
            return drivePad.getRawButton(GamepadConstants.LEFT_TRIGGER);
        }

        /**
         * @return a true or false depending on the input
         */
        public boolean getDriveLeftBumper()
        {
            return drivePad.getRawButton(GamepadConstants.LEFT_BUMPER);
        }

        /**
         * @return a true or false depending on the input
         */
        public boolean getDriveDPadX()
        {
            return drivePad.getRawButton(GamepadConstants.DPAD_X);
        }

        /**
         * @return a true or false depending on the input
         */
        public boolean getDriveDPadY()
        {
            return drivePad.getRawButton(GamepadConstants.DPAD_Y);
        }

        /**
         * @return a true or false depending on the input
         */
        public boolean getDriveXButton()
        {
            return drivePad.getRawButton(GamepadConstants.SHARE_BUTTON);
        }

        /**
         * @return a true or false depending on the input
         */
        public boolean getDriveYButton()
        {
            return drivePad.getRawButton(GamepadConstants.TRIANGLE_BUTTON);
        }

        /**
         * @return a true or false depending on the input
         */
        public boolean getDriveBButton()
        {
            return drivePad.getRawButton(GamepadConstants.CIRCLE_BUTTON);
        }

        /**
         * @return a true or false depending on the input
         */
        public boolean getDriveAButton()
        {
            return drivePad.getRawButton(GamepadConstants.X_BUTTON);
        }

        /**
         * @return a true or false depending on the input
         */
        public boolean getDriveBackButton()
        {
            return drivePad.getRawButton(GamepadConstants.SHARE_BUTTON);
        }

        /**
         * @return a true or false depending on the input
         */
        public boolean getDriveStartButton()
        {
            return drivePad.getRawButton(GamepadConstants.OPTIONS_BUTTON);
        }

        /**
         * @return a true or false depending on the input
         */
        public boolean getDriveRightAnalogButton()
        {
            return drivePad.getRawButton(GamepadConstants.RIGHT_ANALOG_BUTTON);
        }

        /**
         * @return a true or false depending on the input
         */
        public boolean getDriveLeftAnalogButton()
        {
            return drivePad.getRawButton(GamepadConstants.LEFT_ANALOG_BUTTON);
        }
}