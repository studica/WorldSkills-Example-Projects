package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.studica.frc.TitanQuad;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase
{
    /**
     * Motors
     */
    private TitanQuad leftMotor;
    private TitanQuad rightMotor;

    /**
     * Sensors
     */
    private AHRS navX;

    /**
     * Drive Class
     */
    public DriveTrain()
    {
        /**
         * Motor Init
         */
        leftMotor = new TitanQuad(Constants.TITAN_ID, Constants.LEFT_MOTOR);
        rightMotor = new TitanQuad(Constants.TITAN_ID, Constants.RIGHT_MOTOR);

        // Wait 1 sec for Titan to configure
        Timer.delay(1);

        // Print some diagnostics
        System.out.println("Titan Serial number: " + leftMotor.getSerialNumber());
        System.out.println("Titan ID: " + leftMotor.getID());
        System.out.println("Titan " + leftMotor.getFirmwareVersion());
        System.out.println("Titan " + leftMotor.getHardwareVersion());

        // Flags (change to false or true if going backwards)
        leftMotor.setInverted(false);
        rightMotor.setInverted(true);

        /**
         * Sensor Init
         */
        navX = new AHRS(SPI.Port.kMXP);
    }

    /**
     * Call to reset navX yaw angle to 0
     */
    public void resetYaw()
    {
        navX.zeroYaw();
    }

    /**
     * Call for the current angle from the internal NavX
     * <p>
     * @return yaw angle in degrees range -180° to 180°
     */
    public float getYaw()
    {
        return navX.getYaw();
    }

    /**
     * Call for the continuous angle from the internal NavX
     * <p>
     * @return the continuous angle in degrees
     */
    public double getAngle()
    {
        return navX.getAngle();
    }

    /**
     * Call to drive the robot
     * <p>
     * Range of input -1.0 to 1.0
     * <p>
     * @param leftSpeed the speed of the left motor
     * @param rightSpeed the speed of the right motor
     */
    public void drive(double leftSpeed, double rightSpeed)
    {
        leftMotor.set(leftSpeed);
        rightMotor.set(rightSpeed);
    }
}