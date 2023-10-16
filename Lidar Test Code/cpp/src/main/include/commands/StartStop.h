#pragma once

#include <frc2/command/CommandBase.h>
#include <frc2/command/CommandHelper.h>

#include "subsystems/LidarTest.h"
#include "gamepad/OI.h"

class StartStop : public frc2::CommandHelper<frc2::CommandBase, StartStop> 
{
    public:
        explicit StartStop(LidarTest* lidar, OI* oi);

        void Initialize() override;
        void Execute() override;
        void End(bool interrupted) override;
        bool IsFinished() override;
    
    private:
        LidarTest* lidar;
        OI* oi;
};