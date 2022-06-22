#include "commands/DriveLengthOfCourt.h"
#include "commands/robotCommands/DriveWithPID.h"
#include <frc2/command/ParallelRaceGroup.h>
DriveLengthOfCourt::DriveLengthOfCourt(Training* drive)
{
    AddCommands
    (
        DriveWithPID(drive, 0.0, 2000, 0.0, 0.0, 10, 1.0).WithTimeout(15.0_s)
    );
}