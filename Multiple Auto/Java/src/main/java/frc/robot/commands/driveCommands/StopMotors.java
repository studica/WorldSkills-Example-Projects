package frc.robot.commands.driveCommands;

//WPI imports
import edu.wpi.first.wpilibj2.command.CommandBase;

//RobotContainer import
import frc.robot.RobotContainer;

//Subsystem imports
import frc.robot.subsystems.DriveTrain;

/**
 * StopMotors class
 * <p>
 * This class stops all motors
 */
public class StopMotors extends CommandBase
{
    //Grab the subsystem instance from RobotContainer
    private static final DriveTrain drive = RobotContainer.drive;

    /**
     * Constructor
     */
    public StopMotors()
    {
        addRequirements(drive); // Adds the subsystem to the command
    }

    /**
     * Runs before execute
     */
    @Override
    public void initialize()
    {

    }

    /**
     * Called continously until command is ended
     */
    @Override
    public void execute()
    {
        drive.setMotorSpeed(0.0); // Stop motor
        drive.setServoSpeed(0.0); // Stop servo
    }

    /**
     * Called when the command is told to end or is interrupted
     */
    @Override
    public void end(boolean interrupted)
    {
        drive.setMotorSpeed(0.0); // Stop motor
        drive.setServoSpeed(0.0); // Stop servo
    }

    /**
     * Creates an isFinished condition if needed
     */
    @Override
    public boolean isFinished()
    {
        return false;
    }

}