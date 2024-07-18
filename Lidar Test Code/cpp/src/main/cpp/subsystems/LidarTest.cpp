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
    // Configure filter
    lidar.ClusterConfig(50.0f, 5);
    // lidar.KalmanConfig(1e-5f, 1e-1f, 1.0f);
    // lidar.MovingAverageConfig(5);
    // lidar.MedianConfig(5);
    // lidar.JitterConfig(50.0f);
    // enable filter
    lidar.EnableFilter(studica::Lidar::Filter::kCLUSTER, true);
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