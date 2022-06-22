/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

#include "Robot.h"

#include <frc/smartdashboard/SmartDashboard.h>
#include <frc2/command/CommandScheduler.h>

int count;
bool prev;

void Robot::RobotInit() 
{
    m_container.training.SetRunningLED(false);
    m_container.training.SetStoppedLED(false);
    count = 1;
    prev = true;
}

/**
 * This function is called every robot packet, no matter the mode. Use
 * this for items like diagnostics that you want to run during disabled,
 * autonomous, teleoperated and test.
 *
 * <p> This runs after the mode specific periodic functions, but before
 * LiveWindow and SmartDashboard integrated updating.
 */
void Robot::RobotPeriodic() 
{ 
  frc2::CommandScheduler::GetInstance().Run(); 
}

/**
 * This function is called once each time the robot enters Disabled mode. You
 * can use it to reset any subsystem information you want to clear when the
 * robot is disabled.
 */
void Robot::DisabledInit() 
{
    m_container.training.SetStoppedLED(true);
    m_container.training.SetRunningLED(false);
}

void Robot::DisabledPeriodic() {}

/**
 * This autonomous runs the autonomous command selected by your {@link
 * RobotContainer} class.
 */
void Robot::AutonomousInit() 
{
    m_container.training.SetStoppedLED(false);
    m_autonomousCommand = m_container.GetAutonomousCommand();

    if (m_autonomousCommand != nullptr)
    {
        m_autonomousCommand->Schedule();
    }
}

void Robot::AutonomousPeriodic() 
{
    RunningLED();
}

void Robot::TeleopInit() 
{
    if (m_autonomousCommand != nullptr)
    {
        m_autonomousCommand->Cancel();
        m_autonomousCommand = nullptr;
    }
    m_container.training.SetStoppedLED(false);
}

/**
 * This function is called periodically during operator control.
 */
void Robot::TeleopPeriodic() 
{
    RunningLED();
}   

/**
 * This function is called periodically during test mode.
 */
void Robot::TestPeriodic() {}

#ifndef RUNNING_FRC_TESTS
int main() { return frc::StartRobot<Robot>(); }
#endif


void Robot::RunningLED()
{
    if ((count % 25) == 0)
    {
        if (prev)
        {
            m_container.training.SetRunningLED(false);
            prev = false;
        }
        else
        {
            m_container.training.SetRunningLED(true);
            prev = true;
        }
        count = 1;   
    }
    else
    {
        count++;
    }
}