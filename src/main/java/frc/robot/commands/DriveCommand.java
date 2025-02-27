package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer.subsystems;

public class DriveCommand extends Command {
    private DoubleSupplier m_speed;
    private DoubleSupplier m_rotation;

    public DriveCommand(DoubleSupplier speed, DoubleSupplier rotation) {
        m_speed = speed;
        m_rotation = rotation;

        addRequirements(subsystems.drive);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        subsystems.drive.gtaDrive(
            m_speed.getAsDouble(), 
            m_rotation.getAsDouble()
        );
    }

    @Override
    public void end(boolean interrupted) {
        subsystems.drive.gtaDrive(0,0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
