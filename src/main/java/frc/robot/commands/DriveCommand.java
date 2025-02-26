package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer.subsystems;

public class DriveCommand extends Command {
    private DoubleSupplier m_leftSpeed;
    private DoubleSupplier m_rightSpeed;

    public DriveCommand(DoubleSupplier leftSpeed, DoubleSupplier rightSpeed) {
        m_leftSpeed = leftSpeed;
        m_rightSpeed = rightSpeed;

        addRequirements(subsystems.drive);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        subsystems.drive.drive(
            m_leftSpeed.getAsDouble(), 
            m_rightSpeed.getAsDouble()
        );
    }

    @Override
    public void end(boolean interrupted) {
        subsystems.drive.drive(0,0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
