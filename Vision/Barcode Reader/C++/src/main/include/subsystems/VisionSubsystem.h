#pragma once

#include <frc2/command/SubsystemBase.h>
#include <frc/smartdashboard/SmartDashboard.h>
#include <networktables/NetworkTable.h>
#include <networktables/NetworkTableEntry.h>
#include <networkTables/NetworkTableInstance.h>

class VisionSubsystem : public frc2::SubsystemBase
{
    public:
        VisionSubsystem();
        void ReadBarcode(void);
        void PrintBarcode(void);
        void Periodic() override;
    private:
        nt::NetworkTableEntry data; 
        nt::NetworkTableEntry newBarcode;
};