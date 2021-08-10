#include "subsystems/DriveTrain.h"

DriveTrain::DriveTrain()
{
    //Reverse count direction 
    encoder.SetReverseDirection(); 
}

/**
 * Sets the speed of the motor
 * <p>
 * @param speed range -1 to 1 (0 stop)
 */
void DriveTrain::SetMotorSpeed(double speed)
{
    motor.Set(speed);
}

/**
 * Sets the speed of the continuous servo motor 
 * <p>
 * @param speed range -1 to 1 (0 stop)
 */
void DriveTrain::SetServoAngle(double angle)
{
    servo.SetAngle(angle);
}

/**
 * Gets the distance traveled in mm by the encoder
 */
double DriveTrain::GetDistance()
{
    return encoder.GetEncoderDistance();
}

/**
 * Resets the encoder count to 0
 */ 
void DriveTrain::ResetEncoder()
{
    encoder.Reset();
}

/**
 * Periodic loop that runs every robot loop
 */ 
void DriveTrain::Periodic()
{
    frc::SmartDashboard::PutNumber("Encoder Distance (mm)", GetDistance());
}