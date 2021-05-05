package frc.robot.commands.auto;

import frc.robot.commands.driveCommands.SimpleDrive;

public class DriveForward extends AutoCommand
{
    public DriveForward ()
    {
        super(new SimpleDrive(0.0, 0.5, 0.0).withTimeout(5));
            
    }
}