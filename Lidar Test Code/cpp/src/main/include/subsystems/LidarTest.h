#pragma once

#include "studica/Lidar.h"

#include <frc2/command/SubsystemBase.h>
#include <frc/smartdashboard/SmartDashboard.h>

class LidarTest : public frc2::SubsystemBase
{
    public:
        LidarTest();
        void Periodic() override;
        void StartLidar();
        void StopLidar();
    private:
        /**
         * kUSB1 = Top USB 2.0 port of VMX
         * kUSB2 = Bottom USB 2.0 port of VMX
         */ 
        studica::Lidar lidar{studica::Lidar::Port::kUSB1};
        // Scan data struct
        studica::Lidar::ScanData scanData;
        // Flag to prevent unessary updating of dashboard when not scanning
        bool lidarRunning = true;
};