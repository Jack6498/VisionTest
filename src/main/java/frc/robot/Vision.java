// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Vision extends SubsystemBase {
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
NetworkTableEntry tx = table.getEntry("tx");
NetworkTableEntry ty = table.getEntry("ty");
NetworkTableEntry ta = table.getEntry("ta");

//read values periodically
double x = tx.getDouble(0.0);
double y = ty.getDouble(0.0);
double area = ta.getDouble(0.0);

//post to smart dashboard periodically
  /** Creates a new Vision. */
PhotonCamera camera = new PhotonCamera(null, getName());
  public Vision() {
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", area);
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
