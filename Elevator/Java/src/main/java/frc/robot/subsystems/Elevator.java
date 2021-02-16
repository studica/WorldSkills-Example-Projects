package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
//WPI Imports
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

//Vendor Imports
import com.studica.frc.TitanQuad;
import com.studica.frc.TitanQuadEncoder;

public class Elevator extends SubsystemBase
{
    /**
     * Motors
     */
    private TitanQuad motor;

    /**
     * Sensors
     */
    private TitanQuadEncoder elevatorEncoder;

    /**
     * Shuffleboard
     */
    private ShuffleboardTab tab = Shuffleboard.getTab("Elevator");
    private NetworkTableEntry encoder = tab.add("Elevator Encoder", 0).getEntry();

    public Elevator()
    {
        //Motors
        motor = new TitanQuad(Constants.TITAN_ID, 15600, Constants.ELEVATOR);

        //Sensors
        elevatorEncoder = new TitanQuadEncoder(motor, Constants.ELEVATOR, Constants.distPerTick);
        elevatorEncoder.reset();
    }

    /**
     * Sets the speed of the Elevator Motor
     * <p>
     * @param speed range -1 to 1 (0 Stop)
     */
    public void setMotorSpeed(double speed)
    {
        motor.set(speed);
    }

    public double getEncoderDistance()
    {
        return elevatorEncoder.getEncoderDistance() * -1.0; // Need to reverse the encoder count
    }

    /**
     * Code that will run every robot loop
     */
    @Override
    public void periodic()
    {
        /**
         * Update Shuffleboard
         */
        encoder.setDouble(getEncoderDistance());
    }
}