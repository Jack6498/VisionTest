// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  /** Creates a new Drive. */
  WPI_TalonFX front_left, front_right, back_left, back_right;
  DifferentialDrive drive;
  MotorControllerGroup rightDrive, leftDrive;
  public Drive() {
    front_left = new WPI_TalonFX(1);
    front_right = new WPI_TalonFX(2);
    back_left = new WPI_TalonFX(3);
    back_right = new WPI_TalonFX(4);
    rightDrive = new MotorControllerGroup(front_left, back_left);
    leftDrive = new MotorControllerGroup(front_right, back_right);
    drive = new DifferentialDrive(leftDrive, rightDrive);
  }
  public void setDrive(double throttle, double turn){
    drive.arcadeDrive(throttle, turn, true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
