package frc.robot.subsystems;

import com.studica.frc.Lidar;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LidarTest extends SubsystemBase
{

    // Lidar Library
    private Lidar lidar;
    // Lidar Scan Data Storage Class
    private Lidar.ScanData scanData;
    // Dashboard flag to prevent updating when not scanning
    public boolean scanning = true;

    public LidarTest ()
    {
        /**
         * Top USB 2.0 port of VMX = kUSB1
         * Bottom USB 2.0 port of VMX = kUSB2
         */
        lidar = new Lidar(Lidar.Port.kUSB1); //Lidar will start spinning the moment this is called

        // Configure filters
        lidar.clusterConfig(50.0f, 5);
        // lidar.kalmanConfig(1e-5f, 1e-1f, 1.0f);
        // lidar.movingAverageConfig(5);
        // lidar.medianConfig(5);
        // lidar.jitterConfig(50.0f);

        // Enable Filter
        lidar.enableFilter(Lidar.Filter.kCLUSTER, true);
    }

    /**
     * Starts the lidar if it was stopped
     */
    public void startScan()
    {
        lidar.start();
        scanning = true;
    }

    /**
     * Stops the lidar if needed. This will reduce the overhead of CPU and RAM by very little. 
     */
    public void stopScan()
    {
        lidar.stop();
        scanning = false;
    }

    @Override
    public void periodic ()
    {
        if (scanning)
        {
            //Update scanData class
            scanData = lidar.getData();
            //Print out Angle and distance at 60 degrees
            SmartDashboard.putNumber("Angle",  scanData.angle[60]);
            SmartDashboard.putNumber("Distance", scanData.distance[60]);
        }
    }
}