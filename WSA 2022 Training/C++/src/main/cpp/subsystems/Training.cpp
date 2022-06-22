#include "subsystems/Training.h"

#define DEBUG true

Training::Training()
{
    ResetEncoders();
    ResetYaw();

    //Motor Invert Flags comment out when needed
    // frontLeft.SetInverted(true);
    frontLeft.InvertRPM();
    // frontLeftEncoder.SetReverseDirection();

    // backLeft.SetInverted(true);
    backLeft.InvertRPM();
    // backLeftEncoder.SetReverseDirection();

    frontRight.SetInverted(true);
    //frontRight.InvertRPM();
    frontRightEncoder.SetReverseDirection();

    backRight.SetInverted(true);
    //backRight.InvertRPM();
    backRightEncoder.SetReverseDirection();
}

void Training::Periodic()
{
    //Only want this data for testing. Using during robot runtime would be extra overhead not needed.
    #if DEBUG
        frc::SmartDashboard::PutNumber("Yaw", GetYaw());
        frc::SmartDashboard::PutNumber("Angle", GetAngle());
        frc::SmartDashboard::PutNumber("Front Left Encoder", GetFrontLeftEncoder());
        frc::SmartDashboard::PutNumber("Back Left Encoder", GetBackLeftEncoder());
        frc::SmartDashboard::PutNumber("Front Right Encoder", GetFrontRightEncoder());
        frc::SmartDashboard::PutNumber("Back Right Encoder", GetBackRightEncoder());
        frc::SmartDashboard::PutNumber("Front Left RPM", frontLeft.GetRPM());
        frc::SmartDashboard::PutNumber("Back Left RPM", backLeft.GetRPM());
        frc::SmartDashboard::PutNumber("Front Right RPM", frontRight.GetRPM());
        frc::SmartDashboard::PutNumber("Back Right RPM", backRight.GetRPM());
    #endif
}

void Training::ResetEncoders()
{
    frontLeftEncoder.Reset();
    backLeftEncoder.Reset();
    frontRightEncoder.Reset();
    backRightEncoder.Reset();
}

void Training::ResetYaw()
{
    navX.ZeroYaw();
}

void Training::HolonomicDrive(double x, double y, double z)
{
    denomonator = fmax(fabs(y) + fabs(x) + fabs(z), 1.0);
    frontLeft.Set(y + (x * 1.1) + z / denomonator);
    backLeft.Set(y - (x * 1.1) + z / denomonator);
    frontRight.Set(y - (x * 1.1) - z / denomonator);
    backRight.Set(y + (x * 1.1) - z / denomonator);
}

void Training::SetRunningLED(bool on)
{
    runningLED.Set(on);
}

void Training::SetStoppedLED(bool on)
{
    stoppedLED.Set(on);
}

double Training::GetFrontLeftEncoder()
{
    return frontLeftEncoder.GetEncoderDistance();
}

double Training::GetBackLeftEncoder()
{
    return backLeftEncoder.GetEncoderDistance();
}

double Training::GetFrontRightEncoder()
{
    return frontRightEncoder.GetEncoderDistance();
}

double Training::GetBackRightEncoder()
{
    return backRightEncoder.GetEncoderDistance();
}

double Training::GetAverageEncoderY()
{
    return (((GetFrontLeftEncoder() + GetBackLeftEncoder()) / 2) + ((GetFrontRightEncoder() + GetBackRightEncoder()) / 2)) / 2;
}

double Training::GetYaw()
{
    return navX.GetYaw();
}

double Training::GetAngle()
{
    return navX.GetAngle();
}