#include "commands/DriveOnly.h"
#include "commands/robotCommands/DriveWithPID.h"
#include <frc2/command/ParallelRaceGroup.h>
DriveOnly::DriveOnly(DriveTrain* driveTrain)
{
    AddCommands
    (
        DriveWithPID(driveTrain, 1000, 10)
    );
}