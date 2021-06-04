#include "subsystems/VisionSubsystem.h"

VisionSubsystem::VisionSubsystem()
{
    auto inst = nt::NetworkTableInstance::GetDefault();
    auto table = inst.GetTable("Vision");
    data = table->GetEntry("barcodeData");
    newBarcode = table->GetEntry("readBarcode");
    frc::SmartDashboard::PutBoolean("Get New Barcode", false);
}

void VisionSubsystem::ReadBarcode()
{
    newBarcode.SetBoolean(true);
}

void VisionSubsystem::PrintBarcode()
{
    frc::SmartDashboard::PutString("Barcode Data", data.GetString("Nothing was read"));
}

void VisionSubsystem::Periodic()
{
    PrintBarcode();
}