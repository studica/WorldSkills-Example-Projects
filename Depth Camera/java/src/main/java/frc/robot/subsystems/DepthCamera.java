package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// Imports
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.orbbec.obsensor.*;

public class DepthCamera extends SubsystemBase
{
    /**
     * Object Declarations
     */
    private OBContext obContext;
    private final Object pipeLock = new Object();
    private Pipeline pipeline;

    /**
     * Subsystem Constructor
     */
    public DepthCamera()
    {
        initCamera();
    }

    /**
     * Setup the Orbbec SDK and register the device connection status callback
     */
    private void initCamera()
    {
        // Init ObContext and regist the device status listnener
        obContext = new OBContext(new DeviceChangedCallback(){
            @Override
            public void onDeviceAttach(DeviceList deviceList)
            {
                // New devices attached
                // init the pipeline
                initPipeline(deviceList);
                startStreams();

                // Release the device list.
                deviceList.close();
            }

            @Override
            public void onDeviceDetach(DeviceList deviceList)
            {
                // Devices detached
                // Release the pipeline when the device is detached
                stopStreams();
                deInitPipeline();

                // Release the device list.
                deviceList.close();
            }
        });

        DeviceList deviceList = obContext.queryDevices();
        if (null != deviceList)
        {
            if (deviceList.getDeviceCount() > 0)
            {
                initPipeline(deviceList);
                startStreams();
            }
            deviceList.close();
        }
    }

    /**
     * Release the cameara when not used anymore
     */
    private void destroyCamera()
    {
        try 
        {
            if (null != obContext)
            {
                obContext.close();
                obContext = null;
            }
        } 
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Init the pipeline
     * 
     * @param deviceList new attached device list
     */
    private void initPipeline(DeviceList deviceList)
    {
        synchronized(pipeLock) 
        {
            if (null != pipeline)
            {
                pipeline.close();
            }

            // Create the new attached device, default for index 0
            try(Device device = deviceList.getDevice(0))
            {
                pipeline = new Pipeline(device);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }


    /**
     * Release the pipeline
     */
    private void deInitPipeline()
    {
        synchronized(pipeLock)
        {
            try
            {
                if (null != pipeline)
                {
                    pipeline.close();
                    pipeline = null;
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * Start streams, this function shows for streams config and starting streams by pipeline
     */
    public void startStreams()
    {
        synchronized(pipeLock)
        {
            if (null == pipeline)
            {
                System.out.println("Camera Failed! No device connected!");
                return;
            }

            // Create the config for starting streams
            Config config = new Config();

            // Config for color stream
            try (StreamProfileList colorProfileList = pipeline.getStreamProfileList(SensorType.COLOR))
            {
                // For example: You can also get StreamProfile this way.
                // for (int i = 0, N = colorProfileList.getStreamProfileCount(); i < N; i++) {
                //     VideoStreamProfile vsp = colorProfileList.getStreamProfile(i).as(StreamType.VIDEO);
                //     printVideoStreamProfile(vsp);
                // }

                // Filter out the StreamProfile you want based on specified arguments.
                //VideoStreamProfile colorProfile =  colorProfileList.getVideoStreamProfile(640, 480, Format.MJPG, 30);
                VideoStreamProfile colorProfile =  colorProfileList.getStreamProfile(0).as(StreamType.VIDEO);
                if (null == colorProfile) 
                {
                    throw new OBException("get color stream profile failed, no matched color stream profile!");
                }
                // print the color stream profile information.
                printVideoStreamProfile(colorProfile, SensorType.COLOR);
                // enable color stream
                config.enableStream(colorProfile);
                // release the color stream profile.
                colorProfile.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            // Config for depth stream.
            try (StreamProfileList depthProfileList = pipeline.getStreamProfileList(SensorType.DEPTH)) 
            {
                // For example: You can also get StreamProfile this way.
                // for (int i = 0, N = depthProfileList.getStreamProfileCount(); i < N; i++) {
                //     VideoStreamProfile vsp = depthProfileList.getStreamProfile(i).as(StreamType.VIDEO);
                //     printVideoStreamProfile(vsp);
                // }

                // Filter out the StreamProfile you want based on specified arguments.
                //VideoStreamProfile depthProfile = depthProfileList.getVideoStreamProfile(640, 480, Format.Y16, 30);
                VideoStreamProfile depthProfile = depthProfileList.getStreamProfile(0).as(StreamType.VIDEO);
                if (null == depthProfile) 
                {
                    throw new OBException("get depth stream profile failed, no matched depth stream profile!");
                }
                // print the depth stream profile information.
                printVideoStreamProfile(depthProfile, SensorType.DEPTH);
                // enable depth stream.
                config.enableStream(depthProfile);
                // release the depth stream profile.
                depthProfile.close();
            } 
            catch(Exception e) 
            {
                e.printStackTrace();
            }

            // Config for ir stream.
            try (StreamProfileList irProfileList = pipeline.getStreamProfileList(SensorType.IR)) 
            {
                // For example: You can also get StreamProfile this way.
                // for (int i = 0, N = irProfileList.getStreamProfileCount(); i < N; i++) {
                //     VideoStreamProfile vsp = irProfileList.getStreamProfile(i).as(StreamType.VIDEO);
                //     printVideoStreamProfile(vsp);
                // }

                // Filter out the StreamProfile you want based on specified arguments.
                // VideoStreamProfile irProfile = irProfileList.getVideoStreamProfile(640, 480, Format.Y16, 30);
                VideoStreamProfile irProfile = irProfileList.getStreamProfile(0).as(StreamType.VIDEO);
                if (null == irProfile) 
                {
                    throw new OBException("get ir stream profile failed, no matched ir streamm profile!");
                }
                // print the ir stream profile information.
                printVideoStreamProfile(irProfile, SensorType.IR);
                // enable ir stream.
                config.enableStream(irProfile);
                // release the ir stream profile.
                irProfile.close();
            } 
            catch(Exception e) 
            {
                e.printStackTrace();
            }

            // For example: You can enable hardware depth align to color if you want.
            // config.setAlignMode(AlignMode.ALIGN_D2C_HW_ENABLE);
            
            // For example: You can enable frame synchronization if you want.
            // pipeline.enableFrameSync();

            try
            {
                pipeline.start(config, new FrameSetCallback()
                {
                    @Override
                    public void onFrameSet(FrameSet frameSet) 
                    {
                        // process the frame set
                        processFrameSet(frameSet);
                        frameSet.close();
                    }
                });
                config.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }


    /**
     * Stop all the steams.
     */
    public void stopStreams()
    {
        synchronized(pipeLock)
        {
            try
            {
                if (null != pipeline)
                {
                    pipeline.stop();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * Print the video stream profile's information
     * 
     * @param vsp video stream profile
     */
    private void printVideoStreamProfile(VideoStreamProfile vsp, SensorType type)
    {
        StringBuilder sb = new StringBuilder()
        .append(" StreamType: " + vsp.getType() + "\n")
        .append(" Width: " + vsp.getWidth() + "\n")
        .append(" Height: " + vsp.getHeight() + "\n")
        .append(" FrameRate: " + vsp.getFrameRate() + "\n")
        .append(" Format: " + vsp.getFormat() + "\n");
        if (type == SensorType.COLOR)
            SmartDashboard.putString("Video Stream Profile Color", sb.toString());
        if (type == SensorType.DEPTH)
            SmartDashboard.putString("Video Stream Profile Depth", sb.toString());
        if (type == SensorType.IR)
            SmartDashboard.putString("Video Stream Profile IR", sb.toString());
    }

    /**
     * Print the video frame's information
     * 
     * @param vf video frame
     */
    private void printVideoFrame(VideoFrame vf, SensorType type)
    {
        StringBuilder sb = new StringBuilder()
        .append("FrameType: " + vf.getStreamType() + "\n")
        .append(" Width: " + vf.getWidth() + "\n")
        .append(" Height: " + vf.getHeight() + "\n")
        .append(" Format: " + vf.getFormat() + "\n")
        .append(" Index: " + vf.getFrameIndex() + "\n")
        .append(" Timestamp: " + vf.getTimeStamp() + "\n")
        .append(" SysTimestamp: " + vf.getSystemTimeStamp() + "\n");
        if (type == SensorType.COLOR)
            SmartDashboard.putString("Video Frame Color", sb.toString());
        if (type == SensorType.DEPTH)
            SmartDashboard.putString("Video Frame Depth", sb.toString());
        if (type == SensorType.IR)
            SmartDashboard.putString("Video Frame IR", sb.toString());
    }

    /**
     * Process the frame set
     * 
     * @param frameSet new frame set
     */
    private void processFrameSet(FrameSet frameSet)
    {
        // Get the color frame in frameSet.
        try (ColorFrame colorFrame = frameSet.getFrame(FrameType.COLOR)) 
        {
            if (null != colorFrame) 
            {
                // print the color frame's information.
                printVideoFrame(colorFrame, SensorType.COLOR);
            }
        } 
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        // Get the depth frame in frameSet.
        try (DepthFrame depthFrame = frameSet.getFrame(FrameType.DEPTH)) 
        {
            if (null != depthFrame) 
            {
                // print the depth frame's information.
                printVideoFrame(depthFrame, SensorType.DEPTH);
            }
        } 
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        // Get the ir frame in frameSet.
        try (IRFrame irFrame = frameSet.getFrame(FrameType.IR)) 
        {
            if (null != irFrame) 
            {
                // print the ir frame's information.
                printVideoFrame(irFrame, SensorType.IR);
            }
        } 
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
}