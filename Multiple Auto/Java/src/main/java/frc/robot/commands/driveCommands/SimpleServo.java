package frc.robot.commands.driveCommands;

//WPI imports
import edu.wpi.first.wpilibj2.command.CommandBase;

//RobotContainer import
import frc.robot.RobotContainer;

//Subsystem imports
import frc.robot.subsystems.DriveTrain;

/**
 * SimpleServo class
 * <p>
 * This class drives a continuous servo motor
 */
public class SimpleServo extends CommandBase
{
    //Grab the subsystem instance from RobotContainer
    private static final DriveTrain drive = RobotContainer.drive;

    double speed;

    /**
     * Constructor
     */
    public SimpleServo(double speed)
    {
        this.speed = speed;
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
        drive.setServoSpeed(speed);
    }

    /**
     * Called when the command is told to end or is interrupted
     */
    @Override
    public void end(boolean interrupted)
    {
        
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