#pragma once

#include <frc2/command/CommandBase.h>
#include <frc2/command/CommandHelper.h>

#include "subsystems/Training.h"
#include "gamepad/OI.h"

class Drive : public frc2::CommandHelper<frc2::CommandBase, Drive> 
{
    public:
        explicit Drive(Training* training, OI* oi);

        void Initialize() override;
        void Execute() override;
        void End(bool interrupted) override;
        bool IsFinished() override;
    
    private:
        double inputLeftY = 0;
        double inputLeftX = 0;
        double inputRightY = 0;
        double inputRightX = 0;

        double deltaLeftY = 0;
        double deltaLeftX = 0;
        double deltaRightX = 0;
        double deltaRightY = 0;
        double prevRightX = 0;
        double prevRightY = 0;
        double prevLeftX = 0;
        double prevLeftY = 0;

        static constexpr double RAMP_UP = 0.05;

        static constexpr double RAMP_DOWN = 0.05;

        static constexpr double DELTA_LIMIT = 0.075;

        Training* train;
        OI* oi;
};