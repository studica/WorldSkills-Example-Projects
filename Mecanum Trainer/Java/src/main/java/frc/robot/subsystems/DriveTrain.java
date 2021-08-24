package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.studica.frc.TitanQuad;
import com.studica.frc.TitanQuadEncoder;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase
{
    /**
     * Motors
     */
    private TitanQuad leftBack;     //M0
    private TitanQuad leftFront;    //M1
    private TitanQuad rightBack;    //M2
    private TitanQuad rightFront;   //M3

    /**
     * Sensors
     */
    private AHRS navX;
    private TitanQuadEncoder leftBackEncoder;
    private TitanQuadEncoder leftFrontEncoder;
    private TitanQuadEncoder rightBackEncoder;
    private TitanQuadEncoder rightFrontEncoder;

    /**
     * Drive Class
     */
    private MecanumDrive robotDrive;

    public DriveTrain()
    {
        /**
         * Motor init
         */
        leftBack = new TitanQuad(Constants.TITAN_ID, Constants.M0);
        leftFront = new TitanQuad(Constants.TITAN_ID, Constants.M1);
        rightBack = new TitanQuad(Constants.TITAN_ID, Constants.M2);
        rightFront = new TitanQuad(Constants.TITAN_ID, Constants.M3);

        //Wait 1 sec for Titan to configure and startup comm process
        Timer.delay(1);

        //Printout Titan Diagnostic data
        System.out.println("Titan Serial number: " + leftBack.getSerialNumber());
        System.out.println("Titan ID: " + leftBack.getID());
        System.out.println("Titan " + leftBack.getFirmwareVersion());
        System.out.println("Titan " + leftBack.getHardwareVersion());

        /**
         * Sensor init
         */
        leftBackEncoder = new TitanQuadEncoder(leftBack, Constants.M0, Constants.DIST_PER_TICK);
        leftFrontEncoder = new TitanQuadEncoder(leftFront, Constants.M1, Constants.DIST_PER_TICK);
        rightBackEncoder = new TitanQuadEncoder(rightBack, Constants.M2, Constants.DIST_PER_TICK);
        rightFrontEncoder = new TitanQuadEncoder(rightFront, Constants.M3, Constants.DIST_PER_TICK);
        navX = new AHRS(SPI.Port.kMXP);

        /**
         * Set Flags, comment out if necessary 
         */
        //Encoder Direction
        leftBackEncoder.setReverseDirection();
        leftFrontEncoder.setReverseDirection();
        //rightBackEncoder.setReverseDirection();
        //rightFrontEncoder.setReverseDirection();

        //RPM Direction
        //leftBack.invertRPM();
        //leftFront.invertRPM();
        rightBack.invertRPM();
        rightFront.invertRPM();

        //Motor Direction
        leftFront.setInverted(true);
        leftBack.setInverted(true);
        rightFront.setInverted(true);
        rightBack.setInverted(true);

        /**
         * Drive Setup
         */
        robotDrive = new MecanumDrive(leftFront, leftBack, rightFront, rightBack);
        robotDrive.setDeadband(0.05); //Increase the deadband to 5% this is optional

        /**
         * Reset Encoders
         */
        resetEncoders();
    }

    /**
     * Call to reset encoder counts to 0
     */
    public void resetEncoders()
    {
        leftBackEncoder.reset();
        leftFrontEncoder.reset();
        rightBackEncoder.reset();
        rightFrontEncoder.reset();
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
     * Call to drive the robot in a mecanum holonomic way.
     * Note that this uses NED convention 
     * <p>
     * @param x axis, forward backwards movement
     * @param y axis, left right movement
     * @param z axis, rotational movement
     */
    public void drive(double x, double y, double z)
    {
        robotDrive.driveCartesian(y, x, z); //Normal Holonomic Drive
        //robotDrive.driveCartesian(x, y, z, getYaw()); //Field Oriented Drive
    }

    /**
     * Call to get the distance travelled by the left back motor
     * <p>
     * @return distance travelled
     */
    public double getLeftBackEncoderDistance()
    {
        return leftBackEncoder.getEncoderDistance();
    }

    /**
     * Call to get the distance travelled by the left front motor
     * <p>
     * @return distance travelled
     */
    public double getLeftFrontEncoderDistance()
    {
        return leftFrontEncoder.getEncoderDistance();
    }

    /**
     * Call to get the distance travelled by the right back motor
     * <p>
     * @return distance travelled
     */
    public double getRightBackEncoderDistance()
    {
        return rightBackEncoder.getEncoderDistance();
    }

    /**
     * Call to get the distance travelled by the right front motor
     * <p>
     * @return distance travelled
     */
    public double getRightFrontEncoderDistance()
    {
        return rightFrontEncoder.getEncoderDistance();
    }

    /**
     * Call to get the RPM of the left back motor
     * <p>
     * @return the rpm of the motor
     */
    public double getLeftBackRPM()
    {
        return leftBack.getRPM();
    }

    /**
     * Call to get the RPM of the left front motor
     * <p>
     * @return the rpm of the motor
     */
    public double getLeftFrontRPM()
    {
        return leftFront.getRPM();
    }


    /**
     * Call to get the RPM of the right back motor
     * <p>
     * @return the rpm of the motor
     */
    public double getRightBackRPM()
    {
        return rightBack.getRPM();
    }

    /**
     * Call to get the RPM of the right front motor
     * <p>
     * @return the rpm of the motor
     */
    public double getRightFrontRPM()
    {
        return rightFront.getRPM();
    }

    /**
     * Code that runs once every robot loop
     */
    @Override
    public void periodic()
    {
        SmartDashboard.putNumber("NavX Yaw", getYaw());
        SmartDashboard.putNumber("Left Back Encoder", getLeftBackEncoderDistance());
        SmartDashboard.putNumber("Left Back RPM", getLeftBackRPM());
        SmartDashboard.putNumber("Left Front Encoder", getLeftFrontEncoderDistance());
        SmartDashboard.putNumber("Left Front RPM", getLeftFrontRPM());
        SmartDashboard.putNumber("Right Back Encoder", getRightBackEncoderDistance());
        SmartDashboard.putNumber("Right Back RPM", getRightBackRPM());
        SmartDashboard.putNumber("Right Front Encoder", getRightFrontEncoderDistance());
        SmartDashboard.putNumber("Right Front RPM", getRightFrontRPM());
    }
}