#pragma once

#include <frc2/command/SequentialCommandGroup.h>
#include <frc2/command/CommandBase.h>
#include <frc2/command/CommandHelper.h>

#include "subsystems/DriveTrain.h"

class ServoOnly : public frc2::CommandHelper<frc2::SequentialCommandGroup, ServoOnly>
{
    public:
        ServoOnly(DriveTrain* driveTrain);
};