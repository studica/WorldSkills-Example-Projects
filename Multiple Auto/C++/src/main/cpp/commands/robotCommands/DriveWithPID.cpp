#include "commands/robotCommands/DriveWithPID.h"

DriveWithPID::DriveWithPID(DriveTrain* driveTrain, double setPointDistance, double epsilonDistance) : drive{driveTrain}, setPointDistance{setPointDistance}, epsilonDistance{epsilonDistance}
{
    AddRequirements({driveTrain});
}

/**
 * Runs once when command is started
 */
void DriveWithPID::Initialize()
{
    pid.SetTolerance(epsilonDistance);
    drive->ResetEncoder();
}

/**
 * Called continously until command is ended
 */
void DriveWithPID::Execute()
{
    drive->SetMotorSpeed(std::clamp(pid.Calculate(drive->GetDistance(), setPointDistance), -1.0, 1.0));
}

/**
 * Called when the command is told to end or is interrupted
 */
void DriveWithPID::End(bool interrupted)
{
    drive->SetMotorSpeed(0.0);
}

/**
 * Creates an isFinished condition if needed
 */
bool DriveWithPID::IsFinished()
{
    return pid.AtSetpoint();
}