#include "commands/ElevatorCMD.h"

ElevatorCMD::ElevatorCMD(Elevator* elevator, OI* oi)
{
    AddRequirements({elevator, oi});
    this->elevator = elevator;
    this->oi = oi;
}

//Nothing to initialize
void ElevatorCMD::Initialize(){}

//Executes everytime this command is called
void ElevatorCMD::Execute()
{
    //Get Joystick data
    inputRightY = oi->GetRightDriveY();

    //Ramp
    deltaRightY = inputRightY - prevRightY;
    if(deltaRightY >= DELTA_LIMIT)
        inputRightY += RAMP_UP;
    else if (deltaRightY <= -DELTA_LIMIT)
        inputRightY -= RAMP_DOWN;
    prevRightY = inputRightY;

    //Set motor speed
    elevator->SetMotorSpeed(inputRightY);
}

//Called when command is ended
void ElevatorCMD::End(bool interrupted)
{
    elevator->SetMotorSpeed(0.0);
}

//Can be used for an end condition
bool ElevatorCMD::IsFinished()
{
    return false;
}