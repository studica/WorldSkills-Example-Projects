package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.VisionSubsystem;

public class VisionCommand extends CommandBase
{
    private static final VisionSubsystem vision = RobotContainer.vision;

    boolean getNewBarcode;

    public VisionCommand ()
    {
        addRequirements(vision);
    }

    @Override
    public void initialize(){}
    
    @Override
    public void execute()
    {
        getNewBarcode = SmartDashboard.getBoolean("Get New Barcode", false);

        if (getNewBarcode)
        {
            vision.readBarcode();
            SmartDashboard.putBoolean("Get New Barcode", false);
        }
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished()
    {
        return false;
    }
}