package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.gamepad.OI;
import frc.robot.subsystems.Elevator;

public class ElevatorCMD extends CommandBase
{
    /**
     * Bring in the Subsystem and Gamepad code
     */
    private static final Elevator elevator = RobotContainer.elevator;
    private static final OI oi = RobotContainer.oi;

    /**
     * Joystick constant
     */
    double inputRightY = 0;

    /**
     * Ramp Variables
     */
    double deltaRightY = 0;
    double prevRightY = 0;

    /**
     * Ramp Constants
     */
    private static final double RAMP_UP     = 0.05;
    private static final double RAMP_DOWN   = 0.05;
    private static final double DELTA_LIMIT = 0.075;


    public ElevatorCMD()
    {
        addRequirements(elevator);
    }

    @Override
    public void initialize(){}

    @Override
    public void execute()
    {
        /**
         * Get joystick data
         */
        inputRightY = oi.getRightDriveY();

        /**
         * Ramp
         */
        deltaRightY = inputRightY - prevRightY;
        if(deltaRightY >= DELTA_LIMIT)
            inputRightY += RAMP_UP;
        else if (deltaRightY <= -DELTA_LIMIT)
            inputRightY -= RAMP_DOWN;
        prevRightY = inputRightY;

        /**
         * Set motor speed
         */
        elevator.setMotorSpeed(inputRightY);
    }

    @Override
    public void end(boolean interrupted){
        elevator.setMotorSpeed(0.0);
    }

    @Override
    public boolean isFinished()
    {
        return false;
    }
}