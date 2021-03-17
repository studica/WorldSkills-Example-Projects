#pragma once
#define _USE_MATH_DEFINES
#include <math.h>

namespace constant
{
    //Motor
    static constexpr int TITAN_ID  = 42;
    static constexpr int M2 = 2;

    //Encoder
    static constexpr int ENCODER_NUM                = 2;
    static constexpr double PULLEY_RADIUS           = 7.85; //mm
    static constexpr double PULSE_PER_REVOLUTION    = 1440;
    static constexpr double GEAR_RATIO              = 2/1;
    static constexpr double ENCODER_PULSE_RATIO     = PULSE_PER_REVOLUTION * GEAR_RATIO;
    static constexpr double DIST_PER_TICK           = (M_PI * 2 * PULLEY_RADIUS) / ENCODER_PULSE_RATIO;
}