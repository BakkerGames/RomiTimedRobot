package frc.robot;

import edu.wpi.first.wpilibj.Timer;

public class AutonomousLogic {

    public static void ManageLogic(Timer timer, RobotCommand command) {
        command.driveSpeed = 0;
        command.turnSpeed = 0;
        command.buttonA = false;
        command.buttonB = false;
        command.buttonX = false;
        command.buttonY = false;
        command.bumperLeft = false;
        command.bumperRight = false;
        double timerValue = timer.get();
        if (timerValue <= 5) {
            command.driveSpeed = 1;
        }
    }

}
// switch (autoStage) {
// case 1:
// drive(13);
// break;
// case 2:
// turn(-70);
// break;
// case 3:
// drive(13.5);
// break;
// case 4:
// turn(-88);
// break;
// case 5:
// drive(6);
// break;
// case 6:
// turn(-40);
// break;
// case 7:
// drive(7);
// break;
// case 8:
// turn(45);
// break;
// case 9:
// drive(7);
// break;
// case 10:
// turn(100);
// break;
// case 11:
// drive(13.5);
// break;
// case 12:
// turn(95);
// break;
// case 13:
// drive(14);
// break;
// default:
// driveY = 0.0;
// driveX = 0.0;
// break;
// }
//