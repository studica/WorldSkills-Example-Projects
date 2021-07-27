#pragma once

#include <frc2/command/CommandBase.h>
#include <frc2/command/CommandHelper.h>

#include "subsystems/DriveTrain.h"
#include "RobotContainer.h"

class SimpleDrive : public frc2::CommandHelper<frc2::CommandBase, SimpleDrive>
{
    public:
        SimpleDrive(DriveTrain* driveTrain);
        void Initialize() override;
        void Execute() override;
        void End(bool interrupted) override;
        bool IsFinished() override;
    
    private: 
        DriveTrain* drive;
};