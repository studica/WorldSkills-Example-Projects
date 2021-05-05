package frc.robot.commands.driveCommands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class DriveWithPID extends CommandBase
{
    //Bring in the Drive Train subsystem
    private static final DriveTrain drive = RobotContainer.driveTrain;

    private double setpointDistance;
    private double setpointYaw; 

    //Create two PID Controllers
    PIDController pidYAxis;
    PIDController pidZAxis;

    public DriveWithPID(double setpointDistance, double epsilonDistance, double setpointYaw, double epsilonYaw)
    {
        this.setpointDistance = setpointDistance;
        this.setpointYaw = setpointYaw;
        addRequirements(drive);

        pidYAxis = new PIDController(1, 0, 0);
        pidYAxis.setTolerance(epsilonDistance);

        pidZAxis = new PIDController(0.1, 0, 0);
        pidZAxis.setTolerance(epsilonYaw);
    }

    @Override
    public void initialize()
    {
        drive.resetEncoders();
        drive.resetYaw();
        pidYAxis.reset();
        pidZAxis.reset();
    }

    @Override
    public void execute()
    {
        drive.holonomicDrive(0.0,
         MathUtil.clamp(pidYAxis.calculate(drive.getAverageForwardEncoderDistance(), setpointDistance), -0.5, 0.5),
         MathUtil.clamp(pidZAxis.calculate(drive.getYaw(), setpointYaw), -1, 1));
    }

    @Override
    public void end (boolean interrupted)
    {
        drive.setDriveMotorSpeeds(0.0, 0.0, 0.0);;
    }

    @Override
    public boolean isFinished()
    {
        return pidYAxis.atSetpoint();
    }
}