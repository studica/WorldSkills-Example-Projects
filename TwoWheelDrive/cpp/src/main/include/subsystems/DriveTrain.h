#pragma once

#include <frc2/command/SubsystemBase.h>
#include "Constants.h"
#include "studica/TitanQuad.h"
#include "AHRS.h"

class DriveTrain : public frc2::SubsystemBase
{
    public:
        DriveTrain();
        float GetYaw();
        double GetAngle();
        void ResetYaw();
        void Drive(double leftSpeed, double rightSpeed);
    private:
        studica::TitanQuad leftMotor{constant::TITAN_ID, constant::LEFT_MOTOR};
        studica::TitanQuad rightMotor{constant::TITAN_ID, constant::RIGHT_MOTOR};
        AHRS navX{frc::SPI::Port::kMXP};
};