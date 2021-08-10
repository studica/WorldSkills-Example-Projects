#include "commands/ServoOnly.h"
#include "commands/robotCommands/DriveServo.h"

ServoOnly::ServoOnly(DriveTrain* driveTrain)
{
    AddCommands
    (
        DriveServo(driveTrain, 300)
    );
}