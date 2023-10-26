#include "subsystems/DriveTrain.h"

DriveTrain::DriveTrain()
{
    // Motor Flags (change to false or true if backwards)
    leftMotor.SetInverted(false);
    rightMotor.SetInverted(true);
}

/**
 * Grabs the current angle from internal navx
 * <p>
 * @return the angle in degrees. Range -180° to 180°.
 */ 
float DriveTrain::GetYaw()
{
    return navX.GetYaw();
}

/**
 * Grabs the continuous angle from internal navx
 * <p>
 * @return the continuous angle.
 */ 
double DriveTrain::GetAngle()
{
    return navX.GetAngle();
}

/**
 * Resets the angle back to 0°
 */ 
void DriveTrain::ResetYaw()
{
    navX.ZeroYaw();
}

/**
 * Sets the motor speeds
 * Range -1.0 to 1.0 
 * <p>
 * @param leftSpeed the left motor speed
 * @param rightSpeed the right motor speed
 */ 
void DriveTrain::Drive(double leftSpeed, double rightSpeed)
{
    leftMotor.Set(leftSpeed);
    rightMotor.Set(rightSpeed);
}