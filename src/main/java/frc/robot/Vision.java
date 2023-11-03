// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Vision extends SubsystemBase {
  /** Creates a new Vision. */
  PhotonCamera camera = new PhotonCamera(null, getName());
  public Vision() {
    
  }
  public double getCurrentYaw() {
    var target = camera.getLatestResult().getBestTarget();
    return target.getYaw();
  }
  public double getCurrentPitch() {
    var target = camera.getLatestResult().getBestTarget();
    return target.getPitch();
  }
  public double getCurrentDist() {
    return PhotonUtils.calculateDistanceToTargetMeters(1, 1.5, Units.degreesToRadians(12), 0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
