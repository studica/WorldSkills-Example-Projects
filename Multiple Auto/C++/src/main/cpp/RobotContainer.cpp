/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

#include "RobotContainer.h"

RobotContainer::RobotContainer()
{
  //Add commands to the auto chooser
  chooser.AddOption("Drive Only", &m_driveOnly);
  chooser.AddOption("Servo Only", &m_servoOnly);
  chooser.AddOption("Multiple", &m_multiple);

  //Add the auto chooser to the Shuffleboard
  frc::Shuffleboard::GetTab("Autonomous").Add(chooser);
}


frc2::Command* RobotContainer::GetAutonomousCommand() 
{
  return chooser.GetSelected();
}
