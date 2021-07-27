#pragma once

#include <frc2/command/SubsystemBase.h>
#include "Constants.h"
#include "studica/TitanQuad.h"

class DriveTrain : public frc2::SubsystemBase
{
    public:
        DriveTrain();
        void SetMotorSpeed(double speed);
        
    private:
        studica::TitanQuad motor{constant::TITAN_ID, constant::M2};
};