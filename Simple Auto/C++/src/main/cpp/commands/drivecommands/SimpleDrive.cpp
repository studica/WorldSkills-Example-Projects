#include "commands/drivecommands/SimpleDrive.h"

/**
 * SimpleDrive class
 * <p>
 * This class drives a motor at 50% speed until the command is ended
 */
SimpleDrive::SimpleDrive(DriveTrain* driveTrain) : drive{driveTrain}
{
    AddRequirements({driveTrain});
}

/**
 * Runs once when command is started
 */
void SimpleDrive::Initialize(){}

/**
 * Called continously until command is ended
 */
void SimpleDrive::Execute()
{
    drive->SetMotorSpeed(0.5);
}

/**
 * Called when the command is told to end or is interrupted
 */
void SimpleDrive::End(bool interrupted)
{
    drive->SetMotorSpeed(0.0);
}

/**
 * Creates an isFinished condition if needed
 */
bool SimpleDrive::IsFinished()
{
    return false;
}