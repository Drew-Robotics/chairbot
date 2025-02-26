package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class Controller extends CommandXboxController {
    public Controller(int port) {
        super(port);
    }

    public double getLeftSpeed() {
        return getLeftTriggerAxis() * (leftBumper().getAsBoolean() ? -1 : 1);
    }

    public double getRightSpeed() {
        return getRightTriggerAxis() * (rightBumper().getAsBoolean() ? -1 : 1);
    }
}
