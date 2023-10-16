#include "commands/StartStop.h"

StartStop::StartStop(LidarTest* lidar, OI* oi)
{
    AddRequirements({lidar, oi});
    this->lidar = lidar;
    this->oi = oi;
}

void StartStop::Initialize(){}

void StartStop::Execute()
{
    // Simple way to show stopping and starting lidar
    if (oi->GetDriveXButton())
    {
        std::cout<<"Start Lidar\n";
        lidar->StartLidar();
    }
    else if (oi->GetDriveTriangleButton())
    {
        std::cout<<"Stop Lidar\n";
        lidar->StopLidar();
    }
}

void StartStop::End(bool interrupted)
{
    lidar->StopLidar();
}

bool StartStop::IsFinished()
{
    return false;
}