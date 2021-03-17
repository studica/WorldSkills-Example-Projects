#pragma once

#include <frc2/command/SubsystemBase.h>
#include <frc/smartdashboard/SmartDashboard.h>
#include "Constants.h"
#include "studica/TitanQuad.h"
#include "studica/TitanQuadEncoder.h"

class Elevator : public frc2::SubsystemBase
{
    public:
        Elevator();
        void Periodic() override;
        void SetMotorSpeed(double speed);
        double GetDistance(void);

    private:
        studica::TitanQuad motor{constant::TITAN_ID, 15600, constant::M2};
        studica::TitanQuadEncoder encoder{motor, constant::ENCODER_NUM, constant::DIST_PER_TICK};
};