#pragma once

#include <frc2/command/SubsystemBase.h>
#include <frc/Ultrasonic.h>
#include <frc/AnalogInput.h>
#include <frc/smartdashboard/SmartDashboard.h>
#include <cmath>
#include "Constants.h"
#include "studica/TitanQuad.h"
#include "studica/Cobra.h"
#include "studica/Servo.h"
#include "studica/ServoContinuous.h"
#include "AHRS.h"

class Training : public frc2::SubsystemBase
{
    public:
        Training();
        void Periodic() override;
        int GetCobraRawValue(int channel);
        double GetCobraVoltage(int channel);
        double GetIRDistance(void);
        double GetSonicDistance(bool metric);
        double GetYaw(void);
        void ResetYaw(void);
        void SetServoAngle(double degrees);
        void SetServoSpeed(double speed);
        void SetMotorSpeed(double speed);

    private:
        studica::TitanQuad motor{constant::TITAN_ID, 15600, constant::M2};
        studica::Cobra cobra{};
        studica::Servo servo{constant::SERVO};
        studica::ServoContinuous servoC{constant::SERVO_C};
        frc::Ultrasonic sonic{constant::SONIC_TRIGG, constant::SONIC_ECHO};
        frc::AnalogInput sharp{constant::SHARP};
        AHRS *gyro;
};
