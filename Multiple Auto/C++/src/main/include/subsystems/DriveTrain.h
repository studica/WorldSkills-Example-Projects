#pragma once

#include <frc2/command/SubsystemBase.h>
#include <frc/smartdashboard/SmartDashboard.h>
#include "Constants.h"
#include "studica/TitanQuad.h"
#include "studica/TitanQuadEncoder.h"
#include "studica/Servo.h"

class DriveTrain : public frc2::SubsystemBase
{
    public:
        DriveTrain();
        void Periodic() override;
        void SetMotorSpeed(double speed);
        void SetServoAngle(double angle);
        double GetDistance(void);
        void ResetEncoder(void);
        
    private:
        studica::TitanQuad motor{constant::TITAN_ID, constant::M2};
        studica::TitanQuadEncoder encoder{motor, constant::ENCODER_NUM, constant::DIST_PER_TICK};
        studica::Servo servo{constant::SERVO};
};
