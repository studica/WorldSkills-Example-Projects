#include "commands/VisionCommand.h"

VisionCommand::VisionCommand(VisionSubsystem* vision)
{
    AddRequirements({vision});
    this->vision = vision;
}

void VisionCommand::Initialize() {}

void VisionCommand::Execute()
{
    getNewBarcode = frc::SmartDashboard::GetBoolean("Get New Barcode", false);

    if (getNewBarcode)
    {
        vision->ReadBarcode();
        frc::SmartDashboard::PutBoolean("Get New Barcode", false);
    }
}

void VisionCommand::End(bool interrupted) {}

bool VisionCommand::IsFinished()
{
    return false;
}