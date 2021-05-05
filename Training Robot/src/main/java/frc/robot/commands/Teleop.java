package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;
import frc.robot.gamepad.OI;

public class Teleop extends CommandBase 
{

    /**
     * Bring in DriveTrain and OI
     */
    private static final DriveTrain driveTrain = RobotContainer.driveTrain;
    private static final OI oi = RobotContainer.oi;

    /**
     * Joystick inputs
     */
    double inputLeftY = 0;
    double inputLeftX = 0;
    double inputRightX = 0;

    /**
     * Ramp Variables
     */
    double deltaLeftY = 0;
    double deltaLeftX = 0;
    double deltaRightX = 0;
    double prevLeftY = 0;
    double prevLeftX = 0;
    double prevRightX = 0;

    /**
     * Motor Variables
     */
    double leftMotor = 0;
    double rightMotor = 0;
    double backMotor = 0;
    double max = 0;

    /**
     * Ramp up Constant
     */
    private static final double RAMP_UP     = 0.05;

    /**
     * Ramp down Constant
     */
    private static final double RAMP_DOWN   = 0.05;

    /**
     * Delta Limit
     */
    private static final double DELTA_LIMIT = 0.075;

    /**
     * Constructor
     */
    public Teleop ()
    {
        addRequirements(driveTrain);
    }

    /**
     * Code here will run once when the command is called for the first time
     */
    @Override
    public void initialize()
    {
        driveTrain.resetEncoders();
    }

    /**
     * Code here will run continously every robot loop until the command is stopped
     */
    @Override
    public void execute()
    {
        /**
         * Get Joystick data
         */
        inputLeftX = oi.getLeftDriveX();
        inputLeftY = - oi.getLeftDriveY();
        inputRightX = oi.getRightDriveX();

        /**
         * Ramp
         */
        deltaLeftX = inputLeftX - prevLeftX;
        deltaLeftY = inputLeftY - prevLeftY;
        deltaRightX = inputRightX - prevRightX;
        if(deltaLeftX >= DELTA_LIMIT)
            inputLeftX += RAMP_UP;
        else if (deltaLeftX <= -DELTA_LIMIT)
            inputLeftX -= RAMP_DOWN;
        if(deltaLeftY >= DELTA_LIMIT)
            inputLeftY += RAMP_UP;
        else if (deltaLeftY <= -DELTA_LIMIT)
            inputLeftY -= RAMP_DOWN;
        if(deltaRightX >= DELTA_LIMIT)
            inputRightX += RAMP_UP;
        else if (deltaRightX <= -DELTA_LIMIT)
            inputRightX -= RAMP_DOWN;
        prevLeftY = inputLeftY;
        prevLeftX = inputLeftX;
        prevRightX = inputRightX;

        /**
         * Holonomic Conversion
         */
        driveTrain.holonomicDrive(inputLeftX, inputLeftY, inputRightX);
    }

    /**
     * When the comamnd is stopped or interrupted this code is run
     * <p>
     * Good place to stop motors in case of an error
     */
    @Override
    public void end(boolean interrupted)
    {
        driveTrain.setDriveMotorSpeeds(0.0, 0.0, 0.0);
    }

    /**
     * Check to see if command is finished
     */
    @Override
    public boolean isFinished()
    {
        return false;
    } 
}