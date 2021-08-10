#include "commands/Multiple.h"
#include "commands/robotCommands/DriveWithPID.h"
#include "commands/robotCommands/DriveServo.h"
#include <frc2/command/WaitCommand.h>
#include <frc2/command/ParallelRaceGroup.h>
#include <frc2/command/ParallelCommandGroup.h>

Multiple::Multiple(DriveTrain* driveTrain)
{
    AddCommands
    (
        DriveWithPID(driveTrain, 1000, 10).WithTimeout(5.0_s), //Drive forward 1M
        DriveServo(driveTrain, 0).WithTimeout(2.0_s), //Put the Servo to 0 degrees
        DriveServo(driveTrain, 300).WithTimeout(2.0_s), // Put the servo to 300 degrees
        frc2::WaitCommand(3.0_s), //Wait 3 seconds
        frc2::ParallelCommandGroup{ //Run the next commands in parrallel
            DriveWithPID(driveTrain, 1000, 10).WithTimeout(2.0_s), //Drive forward 1M
            DriveServo(driveTrain, 0).WithTimeout(2.0_s)} //Move the servo back to 0 degrees
    );
}