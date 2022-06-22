/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

#include "RobotContainer.h"

RobotContainer::RobotContainer()
{
  training.SetDefaultCommand(ManualDrive(&training, &oi));

  //Add Commands to the auto chooser
  chooser.AddOption("Drive Lenght of Court", &m_lengthOfCourt);
  chooser.AddOption("Rotate 720", &m_cleaningPad);

  frc::Shuffleboard::GetTab("Autonomous Options").Add(chooser);
}

frc2::Command* RobotContainer::GetAutonomousCommand()
{
  return chooser.GetSelected();
}
