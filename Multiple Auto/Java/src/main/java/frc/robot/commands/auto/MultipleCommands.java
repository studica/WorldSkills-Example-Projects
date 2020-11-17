package frc.robot.commands.auto;

// import the commands
import frc.robot.commands.driveCommands.SimpleDrive;
import frc.robot.commands.driveCommands.SimpleServo;
import frc.robot.commands.driveCommands.StopMotors;

/**
 * MultipleCommands class
 * <p>
 * This class creates the inline auto command to control and use multiple commands
 */
public class MultipleCommands extends AutoCommand
{
    /**
     * Constructor
     */
    public MultipleCommands()
    {
        /**
         * Calls SimpleDrive at a speed of 50% waits 5 seconds
         * Calls SimpleDrive and SimpleServo in parallel at a speed of 100% for 5 seconds
         * Calls SimpleDrive and SimpleServo in parallel at a speed of -50% for 5 seconds
         * Stops the motors
         */
        super(new SimpleDrive(0.5).withTimeout(5),
            parallel(new SimpleDrive(1).withTimeout(5),
                new SimpleServo(1).withTimeout(5)),
            parallel(new SimpleDrive(-0.5).withTimeout(5),
                new SimpleServo(-0.5).withTimeout(5)),
            new StopMotors()); 
    }
}