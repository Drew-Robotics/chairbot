// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.drivetrain.DriveSubsystem;

public class RobotContainer {
  public static final Controller m_controller = new Controller(Constants.kControllerPort);

  public RobotContainer() {
    configureBindings();
  }

  public final class subsystems {
    public static final DriveSubsystem drive = DriveSubsystem.getInstance();
  }

  private void configureBindings() {
    subsystems.drive.setDefaultCommand(
      new DriveCommand(
        m_controller::getSpeed, 
        m_controller::getRotation
      )
    );
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
