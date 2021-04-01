package frc.robot;

public class RobotOutput {

    // private static final double rampUpCount = 4.0;

    public static void ManageOutput(RomiDrivetrain driveTrain, RobotCommand robotCommand) {
        double driveSpeed = robotCommand.driveSpeed;
        // if (driveSpeed != 0) {
        //     if (Math.signum(robotCommand.lastDriveSpeed) != Math.signum(driveSpeed)) {
        //         robotCommand.driveCycle = 0;
        //     }
        //     if (robotCommand.driveCycle < rampUpCount) {
        //         robotCommand.driveCycle += 1;
        //         driveSpeed = driveSpeed * robotCommand.driveCycle / rampUpCount;
        //     }
        // }
        driveTrain.arcadeDrive(driveSpeed, robotCommand.turnSpeed);
        robotCommand.lastDriveSpeed = robotCommand.driveSpeed;
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
