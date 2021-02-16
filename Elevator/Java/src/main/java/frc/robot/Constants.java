package frc.robot;


public final class Constants
{
    /**
     * Motor Constants
     */

    public static final int TITAN_ID    = 42;
    public static final int ELEVATOR    = 2;

    /**
     * Encoder Constants
     */

    //Radius of the belt pulley 
    public static final double pulleyRadius                 = 7.85; //mm

    //Encoder pulses per revolution 
    public static final double pulsePerRevolution           = 1440;

    //Gear Ratio bettween encoder and pulley
    public static final double gearRatio                    = 2/1; 

    //Pulse per revolution of the pulley
    public static final double encoderPulseRatio            = pulsePerRevolution * gearRatio;

    //Distance per tick
    public static final double distPerTick                  = (Math.PI * 2 * pulleyRadius) / encoderPulseRatio;
}
