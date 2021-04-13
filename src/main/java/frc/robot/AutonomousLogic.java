package frc.robot;

public class AutonomousLogic {

    public static void ManageLogic(RobotSensors sensors, RobotCommand command) {
        // clear all command fields so robot doesn't do anything
        command.driveSpeed = 0;
        command.turnSpeed = 0;
        command.buttonA = false;
        command.buttonB = false;
        command.buttonX = false;
        command.buttonY = false;
        command.bumperLeft = false;
        command.bumperRight = false;
        // Color Conundrum Game 3
        AutoLogic_ColorConundrum3(sensors, command);
    }

    private static void AutoLogic_ColorConundrum3(RobotSensors sensors, RobotCommand command) {
        switch (command.autonomousStep) {
            case 0:
                command.autonomousStep++;
                // drop through to case 1
            case 1:
                // drive 10 inches
                if (sensors.avgEncoder < 10.0) {
                    command.driveSpeed = 1.0;
                } else {
                    command.autonomousStep++;
                }
                break;
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