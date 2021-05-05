/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Teleop;
import frc.robot.commands.TeleopOMS;
import frc.robot.commands.auto.AutoCommand;
import frc.robot.commands.auto.DriveForward;
import frc.robot.gamepad.OI;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.OMS;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer
{
  // The robot's subsystems and commands are defined here...

  public static DriveTrain driveTrain;
  public static OMS oms;
  public static OI oi;


  public static SendableChooser<String> autoChooser;
  public static Map<String, AutoCommand> autoMode = new HashMap<>();

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() 
  {
    //Create new instances
    driveTrain = new DriveTrain();
    oms = new OMS();
    oi = new OI();

    //Set default command for the drive train subsystem
    driveTrain.setDefaultCommand(new Teleop());
    oms.setDefaultCommand(new TeleopOMS());
  }

  public Command getAutonomousCommand()
  {
    String mode = autoChooser.getSelected();
    return autoMode.getOrDefault(mode, new DriveForward());
  }

}
