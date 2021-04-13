// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.hal.SimDevice;
import edu.wpi.first.hal.SimDevice.Direction;
import edu.wpi.first.hal.SimDouble;

public class Robot extends TimedRobot {
  static final String kDefaultAuto = "Default";
  static final String kCustomAuto = "My Auto";
  String m_autoSelected;
  final SendableChooser<String> m_chooser = new SendableChooser<>();

  final RomiDrivetrain m_drivetrain = new RomiDrivetrain();

  XboxController xboxController = new XboxController(0);
  RobotSensors sensors = new RobotSensors();
  RobotCommand robotCommand = new RobotCommand();

  SimDouble gyro;
  double gyroOffset = 0.0;
  // double gyroTurningScale = 90.0;
  // double targetEncoder = 0.0;

  Timer timer = new Timer();

  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    SimDevice gyroSimDevice = SimDevice.create("Gyro:RomiGyro");

    if (gyroSimDevice != null) {
      gyroSimDevice.createBoolean("init", Direction.kOutput, true);
      gyro = gyroSimDevice.createDouble("angle_z", Direction.kInput, 0.0);
    }

    timer.start();
  }

  @Override
  public void robotPeriodic() {
    double leftEncoder = m_drivetrain.getLeftDistanceInch();
    double rightEncoder = m_drivetrain.getRightDistanceInch();

    // SmartDashboard.putNumber("Drive Y", driveY);
    // SmartDashboard.putNumber("Drive X", driveX);
    SmartDashboard.putNumber("Left Encoder", leftEncoder);
    SmartDashboard.putNumber("Right Encoder", rightEncoder);
    // SmartDashboard.putNumber("Angle", getGyroAngle());
    SmartDashboard.putNumber("Raw Angle", gyro.get());
    SmartDashboard.putNumber("Gryo Offset", gyroOffset);
    // SmartDashboard.putNumber("Gryo Turning Scale", gyroTurningScale);
    // SmartDashboard.putNumber("Auto Stage", autoStage);
  }

  @Override
  public void autonomousInit() {
    // m_autoSelected = m_chooser.getSelected();
    // // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    // System.out.println("Auto selected: " + m_autoSelected);
    ResetSensors();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    GetSensorData(sensors);
    AutonomousLogic.ManageLogic(sensors, robotCommand);
    RobotOutput.ManageOutput(m_drivetrain, robotCommand);
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    ResetSensors();
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    ControllerInput.ManageInput(xboxController, robotCommand);
    RobotOutput.ManageOutput(m_drivetrain, robotCommand);
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {
  }

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {
  }

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
  }

  public void ResetSensors() {
    m_drivetrain.resetEncoders();
    gyroOffset = gyro.get();
    timer.reset();
    robotCommand.autonomousStep = 0;
    sensors.gyroValue = gyro.get();
  }

  public void GetSensorData(RobotSensors sensors) {
    sensors.gyroValue = gyro.get();
    sensors.leftEncoder = m_drivetrain.getLeftDistanceInch();
    sensors.rightEncoder = m_drivetrain.getRightDistanceInch();
    sensors.timerValue = timer.get();
  }
}
