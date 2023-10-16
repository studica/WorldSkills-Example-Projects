package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

import frc.robot.subsystems.LidarTest;
import frc.robot.gamepad.OI;

public class StartStop extends CommandBase
{
    private static final LidarTest lidar = RobotContainer.lidar;
    private static final OI oi = RobotContainer.oi;


    public StartStop ()
    {
        addRequirements(lidar);
    }


    @Override
    public void initialize()
    {}

    @Override
    public void execute()
    {
        // Simple way to show starting and stopping of lidar
        if (oi.getDriveXButton())
        {
            lidar.startScan();
        }
        else if (oi.getDriveYButton())
        {
            lidar.stopScan();
        }
    }

    @Override
    public void end (boolean interrupted)
    {
        lidar.stopScan();
    }

    @Override
    public boolean isFinished()
    {
        return false;
    }
}