#pragma once

#include <frc2/command/CommandBase.h>
#include <frc2/command/CommandHelper.h>
#include <frc/controller/PIDController.h>

#include "subsystems/Training.h"
#include "RobotContainer.h"

class Rotate720 : public frc2::CommandHelper<frc2::CommandBase, Rotate720>
{
    public:
        Rotate720(Training* train);
        void Initialize() override;
        void Execute() override;
        void End(bool interrupted) override;
        bool IsFinished() override;
    
    private: 
        Training* drive;
        double kP = 1;
        double kI = 0;
        double kD = 0;

        frc2::PIDController pid{kP, kI, kD};
};