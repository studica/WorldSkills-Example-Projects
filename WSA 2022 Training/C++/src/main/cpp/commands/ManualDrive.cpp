#include "commands/ManualDrive.h"

ManualDrive::ManualDrive(Training* training, OI* oi)
{
    AddRequirements({training, oi});
    train = training;
    this->oi = oi;
}

void ManualDrive::Initialize(){}

void ManualDrive::Execute()
{
    /**
     * Get Joystick Data
     */
    inputLeftY = oi->GetLeftDriveY();
    inputLeftX = oi->GetLeftDriveX();
    inputRightY = oi->GetRightDriveY();
    inputRightX = oi->GetRightDriveX();
    
    /**
     * Ramp
     */ 
    deltaLeftX = inputLeftX - prevLeftX;
    deltaLeftY = inputLeftY - prevLeftY;
    deltaRightX = inputRightX - prevRightX;
    deltaRightY = inputRightY - prevRightY;
    if(deltaLeftX >= DELTA_LIMIT)
        inputLeftX += RAMP_UP;
    else if (deltaLeftX <= -DELTA_LIMIT)
        inputLeftX -= RAMP_DOWN;
    if(deltaLeftY >= DELTA_LIMIT)
        inputLeftY += RAMP_UP;
    else if (deltaLeftY <= -DELTA_LIMIT)
        inputLeftY -= RAMP_DOWN;
    if(deltaRightX >= DELTA_LIMIT)
        inputRightX += RAMP_UP;
    else if (deltaRightX <= -DELTA_LIMIT)
        inputRightX -= RAMP_DOWN;
    if(deltaRightY >= DELTA_LIMIT)
        inputRightY += RAMP_UP;
    else if (deltaRightY <= -DELTA_LIMIT)
        inputRightY -= RAMP_DOWN;
    prevLeftY = inputLeftY;
    prevLeftX = inputLeftX;
    prevRightY = inputRightY;
    prevRightX = inputRightX;

    train->HolonomicDrive(inputLeftX, -inputLeftY, inputRightX);
}

void ManualDrive::End(bool interrupted)
{
    train->HolonomicDrive(0, 0, 0);
}

bool ManualDrive::IsFinished()
{
    return false;
}