/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

#pragma once

namespace constant
{
    //Titan CAN ID
    static constexpr int TITAN_ID   = 42;

    //Motor
    static constexpr int M2         = 2; //M2 on Titan

    //Servo
    static constexpr int SERVO      = 0; //PWM 0

    //Encoder
    static constexpr int ENCODER_NUM                = 2;
    static constexpr double WHEEL_RADIUS            = 51; //mm
    static constexpr double PULSE_PER_REVOLUTION    = 1440;
    static constexpr double GEAR_RATIO              = 1/1;
    static constexpr double ENCODER_PULSE_RATIO     = PULSE_PER_REVOLUTION * GEAR_RATIO;
    static constexpr double DIST_PER_TICK           = (M_PI * 2 * WHEEL_RADIUS) / ENCODER_PULSE_RATIO;
}
