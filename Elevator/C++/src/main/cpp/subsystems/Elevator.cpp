#include "subsystems/Elevator.h"

/**
 * Constructor
 */ 
Elevator::Elevator()
{
    encoder.Reset();
}

/**
 * Periodic loop
 * 
 * Good place to put sensor outputs for user to view
 */
void Elevator::Periodic()
{
    frc::SmartDashboard::PutNumber("Encoder Distance (mm)", GetDistance());
}

/**
 * Sets the motor speed
 * 
 * @param speed -1 to 1 (0 stop)
 */ 
void Elevator::SetMotorSpeed(double speed)
{
    motor.Set(speed);
}

/**
 * Get distance elevator has traveled
 * 
 * @return encoder distance
 * 
 * This will return distance in mm as the PULLEY_RADIUS in Constants.h is in mm.
 */ 
double Elevator::GetDistance()
{
   return encoder.GetEncoderDistance();
}