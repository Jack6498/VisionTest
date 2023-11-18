// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Turn extends SubsystemBase {
  public WPI_TalonSRX motor1 = new WPI_TalonSRX(1);
  /** Creates a new Turn. */
  public Turn() {
    motor1.config_kP(0, 0.1);
    motor1.config_kI(0, 0);
    motor1.config_kD(0, 0);
  }

  public Command followTarget(double targetOffset) {
    return new RunCommand(()-> {
      motor1.set(ControlMode.Position, (360/2480) * targetOffset);
    });
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
