#include "subsystems/DriveTrain.h"

DriveTrain::DriveTrain(){}

/**
 * Sets the speed of the motor
 * <p>
 * @param speed range -1 to 1 (0 stop)
 */
void DriveTrain::SetMotorSpeed(double speed)
{
    motor.Set(speed);
}