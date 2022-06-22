#pragma once

#include <frc2/command/CommandBase.h>
#include <frc2/command/CommandHelper.h>
#include <frc/controller/PIDController.h>

#include "subsystems/Training.h"
#include "RobotContainer.h"

class DriveWithPID : public frc2::CommandHelper<frc2::CommandBase, DriveWithPID>
{
    public:
        DriveWithPID(Training* train, double setPointX, double setPointY, double setPointZ, double epsilonX, double epsilonY, double epsilonZ);
        void Initialize() override;
        void Execute() override;
        void End(bool interrupted) override;
        bool IsFinished() override;
    
    private: 
        Training* drive;
        double setPointX, setPointY, setPointZ;
        double epsilonX, epsilonY, epsilonZ;
        double kPx = 1;
        double kIx = 0;
        double kDx = 0;
        double kPy = 1;
        double kIy = 0;
        double kDy = 0;
        double kPz = 1;
        double kIz = 0;
        double kDz = 0;

        frc2::PIDController pidX{kPx, kIx, kDx};
        frc2::PIDController pidY{kPy, kIy, kDy};
        frc2::PIDController pidZ{kPz, kIz, kDz};
};