#pragma once

#include <frc2/command/SubsystemBase.h>
#include <frc/smartdashboard/SmartDashboard.h>
#include <frc/DigitalInput.h>
#include <frc/DigitalOutput.h>
#include "Constants.h"
#include "studica/TitanQuad.h"
#include "studica/TitanQuadEncoder.h"
#include "AHRS.h"
#include <math.h>


class Training : public frc2::SubsystemBase
{
    public:
        Training();
        void Periodic() override;
        double GetFrontLeftEncoder(void);
        double GetBackLeftEncoder(void);
        double GetFrontRightEncoder(void);
        double GetBackRightEncoder(void);
        double GetAverageEncoderY(void);
        double GetYaw(void);
        double GetAngle(void);
        void ResetYaw(void);
        void ResetEncoders(void);
        void HolonomicDrive(double x, double y, double z);
        void SetRunningLED(bool on);
        void SetStoppedLED(bool on);
    private:
        studica::TitanQuad frontLeft{constant::TITAN_ID, 15600, constant::FRONT_LEFT};
        studica::TitanQuad backLeft{constant::TITAN_ID, 15600, constant::BACK_LEFT};
        studica::TitanQuad frontRight{constant::TITAN_ID, 15600, constant::FRONT_RIGHT};
        studica::TitanQuad backRight{constant::TITAN_ID, 15600, constant::BACK_RIGHT};
        studica::TitanQuadEncoder frontLeftEncoder{frontLeft, constant::FRONT_LEFT, constant::DIST_PER_TICK};
        studica::TitanQuadEncoder backLeftEncoder{backLeft, constant::BACK_LEFT, constant::DIST_PER_TICK};
        studica::TitanQuadEncoder frontRightEncoder{frontRight, constant::FRONT_RIGHT, constant::DIST_PER_TICK};
        studica::TitanQuadEncoder backRightEncoder{backRight, constant::BACK_RIGHT, constant::DIST_PER_TICK};
        AHRS navX{frc::SPI::Port::kMXP};
        frc::DigitalInput startButton{constant::START_BUTTON};
        frc::DigitalInput stopButton{constant::STOP_BUTTON};
        frc::DigitalOutput runningLED{constant::RUNNING_LED};
        frc::DigitalOutput stoppedLED{constant::STOPPED_LED};

        //Holonomic Variables
        double front_left = 0;
        double back_left = 0;
        double front_right = 0;
        double back_right = 0;
        double denomonator = 0;
};