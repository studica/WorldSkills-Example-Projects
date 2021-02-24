#include "subsystems/Training.h"

Training::Training()
{
    sonic.SetAutomaticMode(true);
    gyro = new AHRS(frc::SPI::Port::kMXP);
    frc::SmartDashboard::PutNumber("Set Servo Angle", 0.0);
    frc::SmartDashboard::PutNumber("Set Servo Speed", 0.0);
}

void Training::Periodic()
{
    frc::SmartDashboard::PutNumber("Cobra Raw Value", GetCobraRawValue(constant::COBRA_CHANNEL));
    frc::SmartDashboard::PutNumber("Cobra Raw Voltage", GetCobraVoltage(constant::COBRA_CHANNEL));
    frc::SmartDashboard::PutNumber("IR Distance", GetIRDistance());
    frc::SmartDashboard::PutNumber("UltraSonic Distance", GetSonicDistance(true));
    frc::SmartDashboard::PutNumber("Yaw", GetYaw());
    SetServoAngle(frc::SmartDashboard::GetNumber("Set Servo Angle", 0.0));
    SetServoSpeed(frc::SmartDashboard::GetNumber("Set Servo Speed", 0.0));
}

int Training::GetCobraRawValue(int channel)
{
    return cobra.GetRawValue(channel);
}

double Training::GetCobraVoltage(int channel)
{
    return cobra.GetVoltage(channel);
}

double Training::GetIRDistance(void)
{
    return(pow(sharp.GetAverageVoltage(), -1.2045)) * 27.726;
}

double Training::GetSonicDistance(bool metric)
{
    return metric ? sonic.GetRangeMM() : sonic.GetRangeInches();
}

double Training::GetYaw(void)
{
    return gyro->GetYaw();
}

void Training::ResetYaw(void)
{
    gyro->ZeroYaw();
}

void Training::SetServoAngle(double degrees)
{
    servo.SetAngle(degrees);
}

void Training::SetServoSpeed(double speed)
{
    servoC.Set(speed);
}

void Training::SetMotorSpeed(double speed)
{
    motor.Set(speed);
}


