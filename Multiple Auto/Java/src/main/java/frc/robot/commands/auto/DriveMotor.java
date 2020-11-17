package frc.robot.commands.auto;

// import the commands
import frc.robot.commands.driveCommands.SimpleDrive;
import frc.robot.commands.driveCommands.StopMotors;

/**
 * DriveMotor class
 * <p>
 * This class creates the inline auto command to drive the motor
 */
public class DriveMotor extends AutoCommand
{
    /**
     * Constructor
     */
    public DriveMotor()
    {
        /**
         * Calls SimpleDrive at a speed of 50% waits 5 seconds and stops the motors
         */
        super(new SimpleDrive(0.5).withTimeout(5),
        new StopMotors()); 
    }
}