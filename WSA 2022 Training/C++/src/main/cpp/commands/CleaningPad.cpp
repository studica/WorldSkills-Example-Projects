#include "commands/CleaningPad.h"
#include "commands/robotCommands/Rotate720.h"
#include <frc2/command/ParallelRaceGroup.h>
CleaningPad::CleaningPad(Training* drive)
{
    AddCommands
    (
        Rotate720(drive).WithTimeout(15.0_s)
    );
}