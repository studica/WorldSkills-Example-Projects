#pragma once

#include <frc2/command/CommandBase.h>
#include <frc2/command/CommandHelper.h>

#include "subsystems/Elevator.h"
#include "gamepad/OI.h"

class ElevatorCMD : public frc2::CommandHelper<frc2::CommandBase, ElevatorCMD> 
{
    public:
        explicit ElevatorCMD(Elevator* elevator, OI* oi);
        void Initialize() override;
        void Execute() override;
        void End(bool interrupted) override;
        bool IsFinished() override;

    private:
        double inputRightY = 0;
        double deltaRightY = 0;
        double prevRightY = 0;
        static constexpr double RAMP_UP = 0.05;
        static constexpr double RAMP_DOWN = 0.05;
        static constexpr double DELTA_LIMIT = 0.075;
        
        Elevator* elevator;
        OI* oi;
};