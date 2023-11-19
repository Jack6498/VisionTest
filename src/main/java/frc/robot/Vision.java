// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Vision extends SubsystemBase {
PhotonCamera camera;
PhotonPipelineResult currentResult;
  public Vision() {
    camera = new PhotonCamera("limelight");
  }
  public PhotonTrackedTarget getBestTarget() {
    return currentResult.getBestTarget();
  }
  public double getCurrentYaw() {
    return getBestTarget().getYaw();
  }
  public double getCurrentPitch() {
    return getBestTarget().getPitch();
  }
  public double getCurrentDist() {
    return PhotonUtils.calculateDistanceToTargetMeters(
      1, 
      1.5, 
      Units.degreesToRadians(12), 
      Units.degreesToRadians(getBestTarget().getPitch())
      );
  }
  @Override
  public void periodic() {
    currentResult = camera.getLatestResult();
  }
}
