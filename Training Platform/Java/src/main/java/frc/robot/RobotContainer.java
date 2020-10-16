/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.gamepad.OI;
import frc.robot.subsystems.Training;
import frc.robot.commands.Drive;

public class RobotContainer {

  public static Training train;
  public static OI oi;

  public RobotContainer()
  {
      train = new Training();
      oi = new OI();
      train.setDefaultCommand(new Drive());
  }
}
