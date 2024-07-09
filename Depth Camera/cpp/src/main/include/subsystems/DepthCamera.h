#pragma once

#include <libobsensor/ObSensor.hpp>
#include <frc2/command/SubsystemBase.h>
#include <map>

typedef struct PipelineHolder_t {
    std::shared_ptr<ob::Pipeline>   pipeline;
    std::shared_ptr<ob::DeviceInfo> deviceInfo;
    bool                            isStarted;
} PipelineHolder;

typedef struct FramePrintInfo_t {
    uint32_t colorCount;
    uint32_t irCount;
    uint32_t irLeftCount;
    uint32_t irRightCount;
    uint32_t depthCount;
} FramePrintInfo;

class DepthCamera : public frc2::SubsystemBase {
public:
    DepthCamera();
    ~DepthCamera();

    void Periodic() override;

private:
    void handleDeviceConnected(std::shared_ptr<ob::DeviceList> connectList);
    void handleDeviceDisconnected(std::shared_ptr<ob::DeviceList> disconnectList);
    void rebootDevices();
    void startStream(std::shared_ptr<PipelineHolder> holder);
    void stopStream(std::shared_ptr<PipelineHolder> holder);
    void setupOrbbecSDK();
    void teardownOrbbecSDK();
    void processFrameset(std::string deviceSN, std::shared_ptr<FramePrintInfo> printInfo, std::shared_ptr<ob::FrameSet> frameSet);

private:
    std::shared_ptr<ob::Context>                           obContex_;
    std::recursive_mutex                                   pipelineHolderMutex_;
    std::map<std::string, std::shared_ptr<PipelineHolder>> pipelineHolderMap_;
};