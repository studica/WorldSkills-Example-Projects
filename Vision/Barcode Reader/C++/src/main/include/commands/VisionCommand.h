#pragma once

#include <frc2/command/CommandBase.h>
#include <frc2/command/CommandHelper.h>
#include <frc/smartdashboard/SmartDashboard.h>
#include "subsystems/VisionSubsystem.h"

class VisionCommand : public frc2::CommandHelper<frc2::CommandBase, VisionCommand> 
{
    public:
        explicit VisionCommand(VisionSubsystem* vision);

        void Initialize() override;
        void Execute() override;
        void End(bool interrupted) override;
        bool IsFinished() override;
    private:
        VisionSubsystem* vision;
        bool getNewBarcode;
};