/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.Teleop;
import frc.robot.gamepad.OI;
import frc.robot.subsystems.DriveTrain;

public class RobotContainer 
{
  /**
   * Create the objects for the subsystems and other utilities 
   */
  public static DriveTrain driveTrain;
  public static OI oi;

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() 
  {
    //Create new instances
    driveTrain = new DriveTrain();
    oi = new OI();

    driveTrain.setDefaultCommand(new Teleop());
  }
}
