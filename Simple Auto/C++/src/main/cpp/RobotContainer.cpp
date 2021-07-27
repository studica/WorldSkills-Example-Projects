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
  chooser.AddOption("Auto", &m_auto); 

  //Add the auto chooser to Shuffleboard
  frc::Shuffleboard::GetTab("Autonomous").Add(chooser);
  
}

frc2::Command* RobotContainer::GetAutonomousCommand() {
  // An example command will be run in autonomous
  return chooser.GetSelected();
}

