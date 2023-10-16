#include "subsystems/LidarTest.h"

#define DEBUG true

LidarTest::LidarTest()
{
    //useless constructor 
}

/**
 * Starts the lidar
 */ 
void LidarTest::StartLidar()
{
    lidar.Start();
    lidarRunning = true;
}

/**
 * Stops the lidar. This will free up minimal CPU and RAM space
 */ 
void LidarTest::StopLidar()
{
    lidar.Stop();
    lidarRunning = false;
}

void LidarTest::Periodic()
{
    if (lidarRunning)
        scanData = lidar.GetData(); // Update scanData struct
    #if DEBUG //Print out sensor info
        frc::SmartDashboard::PutNumber("Angle", scanData.angle[60]);
        frc::SmartDashboard::PutNumber("Distance", scanData.distance[60]);
    #endif
}