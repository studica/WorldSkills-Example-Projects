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
    private NetworkTableEntry sharpIR = tab.add("Sharp IR", 0)
                                            .getEntry();
    private NetworkTableEntry ultraSonic = tab.add("Ultrasonic", 0)
                                            .getEntry();
    private NetworkTableEntry cobraRaw = tab.add("Cobra Raw", 0)
                                            .getEntry();
    private NetworkTableEntry cobraVoltage = tab.add("Cobra Voltage", 0)
                                            .getEntry();
    private NetworkTableEntry navX = tab.add("NavX Yaw", 0)
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

    /**
     * Call for the raw ADC value
     * <p>
     * @param channel range 0 - 3 (matches what is on the adc)
     * @return value between 0 and 2047 (11-bit)
     */
    public int getCobraRawValue(int channel)
    {
        return cobra.getRawValue(channel);
    }

    /**
     * Call for the voltage from the ADC
     * <p>
     * @param channel range 0 - 3 (matches what is on the adc)
     * @return voltage between 0 - 5V (0 - 3.3V if the constructor Cobra(3.3F) is used)
     */
    public double getCobraVoltage(int channel)
    {
        return cobra.getVoltage(channel);
    }

    /**
     * Call for the distance measured by the Sharp IR Sensor
     * <p>
     * @return value between 0 - 100 (valid data range is 10cm - 80cm)
     */
    public double getIRDistance()
    {
        return (Math.pow(sharp.getAverageVoltage(), -1.2045) * 27.726);
    }

    /**
     * Call for the distance measured by the Ultrasonic Sensor
     * <p>
     * @param metric true or false for metric output
     * @return distance in mm when metric is true, and inches when metric is false
     */
    public double getSonicDistance(boolean metric)
    {
        sonic.ping();
        Timer.delay(0.005);
        if (metric)
            return sonic.getRangeMM();
        else
            return sonic.getRangeInches();
    }

    /**
     * Call for the current angle from the internal NavX
     * <p>
     * @return yaw angle in degrees range -180° to 180°
     */
    public double getYaw()
    {
        return gyro.getYaw();
    }

    /**
     * Resets the yaw angle back to zero
     */
    public void resetGyro()
    {
        gyro.zeroYaw();
    }

    /**
     * Sets the servo angle based on the input from the shuffleboard widget 
     */
    public void setServoAngle()
    {
        servo.setAngle(servoPos.getDouble(0.0));
    }

    /**
     * Sets the servo angle 
     * <p>
     * @param degrees degree to set the servo to, range 0° - 300°
     */
    public void setServoAngle(double degrees)
    {
        servo.setAngle(degrees);
    }

    /**
     * Sets the servo speed based on the input from the shuffleboard widget
     */
    public void setServoSpeed()
    {
        servoC.set(servoSpeed.getDouble(0.0));
    }

    /**
     * Sets the servo speed
     * <p>
     * @param speed sets the speed of the servo in continous mode, range -1 to 1
     */
    public void setServoSpeed(double speed)
    {
        servoC.set(speed);
    }

    /**
     * Sets the speed of the motor
     * <p>
     * @param speed range -1 to 1 (0 stop)
     */
    public void setMotorSpeed(double speed)
    {
        motor.set(speed);
    }

    /**
     * Code that runs once every robot loop
     */
    @Override
    public void periodic()
    {
        setServoAngle(); // Updates the servo

        /**
         * Updates for outputs to the shuffleboard
         */
        sharpIR.setDouble(getIRDistance());
        ultraSonic.setDouble(getSonicDistance(true)); //set to true because we want metric
        cobraRaw.setDouble(getCobraRawValue(0)); //Just going to use channel 0 for demo
        cobraVoltage.setDouble(getCobraVoltage(0));
        navX.setDouble(getYaw());
    }
}