package frc.robot.commands.driveCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class SimpleDrive extends CommandBase
{
    private static final DriveTrain drive = RobotContainer.driveTrain;

    private double x;
    private double y;
    private double z;

    public SimpleDrive(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        addRequirements(drive);
    }

    @Override
    public void initialize()
    {}

    @Override
    public void execute()
    {
        drive.holonomicDrive(x, y, z);
    }

    @Override
    public void end (boolean interrupted)
    {
        drive.setDriveMotorSpeeds(0.0, 0.0, 0.0);;
    }

    @Override
    public boolean isFinished()
    {
        return false;
    }
}