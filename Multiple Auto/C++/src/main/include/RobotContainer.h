/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

#pragma once

#include <frc2/command/Command.h>
#include <frc/smartdashboard/SendableChooser.h>
#include <frc/shuffleboard/Shuffleboard.h>

#include "subsystems/DriveTrain.h"
#include "commands/DriveOnly.h"
#include "commands/ServoOnly.h"
#include "commands/Multiple.h"

/**
 * This class is where the bulk of the robot should be declared.  Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls).  Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
class RobotContainer 
{
  public:
    RobotContainer();

    frc2::Command* GetAutonomousCommand();

  private:
    //Subsystems
    DriveTrain driveTrain;

    //Commands
    DriveOnly m_driveOnly{&driveTrain};
    ServoOnly m_servoOnly{&driveTrain};
    Multiple m_multiple{&driveTrain};
    
    //Auto Chooser
    frc::SendableChooser<frc2::Command*> chooser;
};
