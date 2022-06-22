#include "commands/robotCommands/Rotate720.h"

Rotate720::Rotate720(Training* train) : drive{train}
{
    AddRequirements({train});
}

/**
 * Runs once when command is started
 */
void Rotate720::Initialize()
{
    pid.SetTolerance(1.0);
    drive->ResetYaw();
}

/**
 * Called continously until command is ended
 */
void Rotate720::Execute()
{
    drive->HolonomicDrive(0.0,
    0.0,
    std::clamp(pid.Calculate(drive->GetAngle(), 720.0), -0.5, 0.5));
}

/**
 * Called when the command is told to end or is interrupted
 */
void Rotate720::End(bool interrupted)
{
    drive->HolonomicDrive(0.0, 0.0, 0.0);
}

/**
 * Creates an isFinished condition if needed
 */
bool Rotate720::IsFinished()
{
    return pid.AtSetpoint();
}