package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class Controller extends CommandXboxController {
    public Controller(int port) {
        super(port);
    }

    public double getSpeed() {
        return getRightTriggerAxis() - getLeftTriggerAxis();
    }

    public double getRotation() {
        return getLeftX();
    }
}
