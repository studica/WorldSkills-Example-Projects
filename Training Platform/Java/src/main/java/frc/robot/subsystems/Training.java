package frc.robot.subsystems;

//WPI imports
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;

//Java imports
import java.util.Map;

//Vendor imports
import com.kauailabs.navx.frc.AHRS;
import com.studica.frc.TitanQuad;
import com.studica.frc.Cobra;
import com.studica.frc.Servo;
import com.studica.frc.ServoContinuous;

public class Training extends SubsystemBase
{
    /**
     * Motors
     */
    private TitanQuad motor;
    private Servo servo;
    private ServoContinuous servoC;

    /**
     * Sensors
     */
    private Cobra cobra;
    private Ultrasonic sonic;
    private AnalogInput sharp;
    private AHRS gyro;

    /**
     * Shuffleboard
     */
    private ShuffleboardTab tab = Shuffleboard.getTab("Training");
    private NetworkTableEntry servoPos = tab.add("Servo Position", 0)
                                            .withWidget(BuiltInWidgets.kNumberSlider)
                                            .withProperties(Map.of("min", 0, "max", 300))
                                            .getEntry();
    private NetworkTableEntry servoSpeed = tab.add("Servo Speed", 0)
                                            .withWidget(BuiltInWidgets.kNumberSlider)
                                            .withProperties(Map.of("min", -1, "max", 1))
                                            .getEntry();
    private NetworkTableEntry sharpDistance = tab.add("Sharp IR Distance", 0.0)
                                                .getEntry();
    private NetworkTableEntry sonicDistance = tab.add("Ultrasonic Distance", 0.0)
                                                .getEntry();                    
    private NetworkTableEntry cobraRaw = tab.add("Cobra Raw", 0.0)
                                                .getEntry();
    private NetworkTableEntry cobraVoltage = tab.add("Cobra Voltage", 0.0)
                                                .getEntry();
    private NetworkTableEntry yaw = tab.add("NavX Yaw", 0.0)
                                                .withWidget(BuiltInWidgets.kGyro)
                                                .withProperties(Map.of("min", -180, "max", 180))
                                                .getEntry();

    public Training()
    {
        //Motors
        motor = new TitanQuad(Constants.TITAN_ID, Constants.MOTOR);
        servo = new Servo(Constants.SERVO);
        servoC = new ServoContinuous(Constants.SERVO_C);

        //Sensors
        cobra = new Cobra();
        sharp = new AnalogInput(Constants.SHARP);
        sonic = new Ultrasonic(Constants.SONIC_TRIGG, Constants.SONIC_ECHO);
        gyro = new AHRS(SPI.Port.kMXP);
    }

    public int getCobraRawValue(int channel)
    {
        return cobra.getRawValue(channel);
    }

    public double getCobraVoltage(int channel)
    {
        return cobra.getVoltage(channel);
    }

    public double getIRDistance()
    {
        return (Math.pow(sharp.getAverageVoltage(), -1.2045) * 27.726);
    }

    public double getSonicDistance()
    {
        sonic.ping();
        Timer.delay(0.005);
        return sonic.getRangeInches();
    }

    public double getYaw()
    {
        return gyro.getYaw();
    }

    public void resetGyro()
    {
        gyro.zeroYaw();
    }

    public void setServoAngle()
    {
        servo.setAngle(servoPos.getDouble(0.0));
    }

    public void setServoAngle(double degrees)
    {
        servo.setAngle(degrees);
    }

    public void setServoSpeed()
    {
        servoC.set(servoSpeed.getDouble(0.0));
    }

    public void setServoSpeed(double speed)
    {
        servoC.set(speed);
    }

    public void setMotorSpeed(double speed)
    {
        motor.set(speed);
    }

    @Override
    public void periodic()
    {
        sharpDistance.setDouble(getIRDistance());
        sonicDistance.setDouble(getSonicDistance());
        cobraRaw.setDouble(getCobraRawValue(0));
        cobraVoltage.setDouble(getCobraVoltage(0));
        yaw.setDouble(getYaw());
    }
}