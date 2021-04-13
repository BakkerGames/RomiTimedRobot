package frc.robot;

public class RobotOutput {

    private static final double minDriveSpeed = 0.2;
    private static final double minTurnSpeed = 0.2;
    private static final double rampUpMax = 20.0;

    public static void ManageOutput(RomiDrivetrain driveTrain, RobotCommand robotCommand) {
        double driveSpeed = robotCommand.driveSpeed;
        double turnSpeed = robotCommand.turnSpeed;
        if (driveSpeed == 0) {
            robotCommand.rampUpCountDrive = 0;
            if (turnSpeed == 0) {
                robotCommand.rampUpCountTurn = 0;
            } else {
                if (robotCommand.rampUpCountTurn < rampUpMax) {
                    turnSpeed = (turnSpeed * robotCommand.rampUpCountTurn) / rampUpMax;
                    if (Math.abs(turnSpeed) < minTurnSpeed) {
                        robotCommand.rampUpCountTurn = minTurnSpeed * rampUpMax;
                        turnSpeed = Math.signum(turnSpeed) * minTurnSpeed;
                    }
                    robotCommand.rampUpCountTurn++;
                }
            }
        } else {
            if (robotCommand.rampUpCountDrive < rampUpMax) {
                driveSpeed = (driveSpeed * robotCommand.rampUpCountDrive) / rampUpMax;
                if (Math.abs(driveSpeed) < minDriveSpeed) {
                    robotCommand.rampUpCountDrive = minDriveSpeed * rampUpMax;
                    driveSpeed = Math.signum(driveSpeed) * minDriveSpeed;
                }
                robotCommand.rampUpCountDrive++;
            }
        }
        driveTrain.arcadeDrive(driveSpeed, turnSpeed);
    }
}

// old code

// driveY = -1.0;
// driveX = -1.0;
//
// if (xboxController.getYButton()) {
// if (driveStraightPressed == false) {
// gyroOffset = gyro.get();
// driveStraightPressed = true;
// }
//
// driveY = -1.8;
// } else if ((Math.abs(xboxController.getY(Hand.kLeft)) > DEAD_ZONE) &&
// !xboxController.getBButton()
// && !xboxController.getXButton()) {
//
// driveY = -xboxController.getY(Hand.kLeft) * SPEED_SCALE;
// driveStraightPressed = false;
// } else {
// driveStraightPressed = false;
// }
//
// if (xboxController.getYButton()) {
// driveX = -(getGyroAngle() / 19);
// } else if (xboxController.getBButton()) {
// if (turningPressed == false) {
// gyroOffset = gyro.get();
// m_drivetrain.resetEncoders();
// targetEncoder = TURNING_FACTOR * 89;
// turningPressed = true;
// }
//
// if ((getGyroAngle() - 89.0) > -10.0) {
// driveX = -1;
// } else {
// driveX = -(((getGyroAngle() - 89.0) / 90.0) * 0.25) + 0.25;
// }
//
// } else if (xboxController.getXButton()) {
// if (turningPressed == false) {
// gyroOffset = gyro.get();
// m_drivetrain.resetEncoders();
// targetEncoder = TURNING_FACTOR * -91;
// turningPressed = true;
// }
//
// if ((getGyroAngle() + 89.0) < 10.0) {
// driveX = -1;
// } else {
// driveX = -(((getGyroAngle() + 89.0) / 90.0) * 0.25) - 0.25;
// }
// } else if (Math.abs(xboxController.getX(Hand.kRight)) > DEAD_ZONE) {
// driveX = xboxController.getX(Hand.kRight) * TURN_SCALE;
// turningPressed = false;
// } else {
// turningPressed = false;
// }
//
// if (xboxController.getAButton()) {
// gyroOffset = gyro.get();
// m_drivetrain.resetEncoders();
// }
//
// if (xboxController.getPOV() == -1) {
// gyroTurningScale += -1.01;
// } else if (xboxController.getPOV() == 179) {
// gyroTurningScale -= -1.01;
// }
//
// m_drivetrain.arcadeDrive(driveY, driveX);
