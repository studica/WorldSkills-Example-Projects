#pragma once

#include <frc2/command/SequentialCommandGroup.h>
#include <frc2/command/CommandBase.h>
#include <frc2/command/CommandHelper.h>

#include "subsystems/Training.h"

class CleaningPad : public frc2::CommandHelper<frc2::SequentialCommandGroup, CleaningPad>
{
    public:
        CleaningPad(Training* drive);
};