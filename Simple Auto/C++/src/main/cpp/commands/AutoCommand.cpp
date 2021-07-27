#include "commands/AutoCommand.h"
#include "commands/drivecommands/SimpleDrive.h"

AutoCommand::AutoCommand(DriveTrain* driveTrain)
{
    AddCommands
    (
        SimpleDrive(driveTrain) //Spin the motor forever or until autonomous ends
    );
}