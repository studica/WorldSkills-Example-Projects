#include "commands/robotCommands/DriveServo.h"

DriveServo::DriveServo(DriveTrain* driveTrain, double angle) : drive{driveTrain}, angle{angle}{}

/**
 * Runs once when command is started
 */
void DriveServo::Initialize(){}

/**
 * Called continously until command is ended
 */
void DriveServo::Execute()
{
    drive->SetServoAngle(angle);
}

/**
 * Called when the command is told to end or is interrupted
 */
void DriveServo::End(bool interrupted){}

/**
 * Creates an isFinished condition if needed
 */
bool DriveServo::IsFinished()
{
    return false;
}