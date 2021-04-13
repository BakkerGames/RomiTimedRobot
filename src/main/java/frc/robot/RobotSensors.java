package frc.robot;

public class RobotSensors {

    private static final double gyroFactor = 3.0;

    public double gyroValue;
    public double leftEncoder;
    public double rightEncoder;
    public double timerValue;

    private double gyroOffset;
    private double leftEncoderOffset;
    private double rightEncoderOffset;

    public void resetEncoders() {
        leftEncoderOffset = leftEncoder;
        rightEncoderOffset = rightEncoder;
    }

    public double getLeftEncoderValue() {
        return leftEncoder - leftEncoderOffset;
    }

    public double getRightEncoderValue() {
        return rightEncoder - rightEncoderOffset;
    }

    public double getAvgEncoderValue(){
        return (getLeftEncoderValue() + getRightEncoderValue()) / 2.0;
    }

    public void resetGyro() {
        gyroOffset = gyroValue;
    }

    public double gyroAngle() {
        return ((gyroValue - gyroOffset) * gyroFactor) % 360.0;
    }
}
