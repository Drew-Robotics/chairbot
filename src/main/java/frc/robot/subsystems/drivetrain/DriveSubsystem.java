package frc.robot.subsystems.drivetrain;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.subsystems.SubsystemAbstract;

public class DriveSubsystem extends SubsystemAbstract {
    private final List<Motor> m_leftMotors;
    private final List<Motor> m_rightMotors;

    private double m_currentRotation;

    private static DriveSubsystem m_instance;
    public static DriveSubsystem getInstance() {
        if (m_instance == null)
            m_instance = new DriveSubsystem();
        return m_instance;
    }

    public DriveSubsystem() {
        super();

        m_leftMotors = List.of(
            new Motor("Front Left Motor", Constants.CANIDs.frontLeftMotor), 
            new Motor("Back Left Motor", Constants.CANIDs.backLeftMotor)
        );

        m_rightMotors = List.of(
            new Motor("Front Right Motor", Constants.CANIDs.frontRightMotor), 
            new Motor("Back Right Motor", Constants.CANIDs.backRightMotor)
        );
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        setLeft(leftSpeed);
        setRight(rightSpeed);
    }

    public void gtaDrive(double speed, double rotation) {
        m_currentRotation = (rotation * Constants.kRotationScalar);

        setLeft(speed + rotation);
        setRight(speed - rotation);
    }

    private void setLeft(double speed) {
        m_leftMotors.forEach(motor -> motor.set(-speed + Constants.kLeftOffset));
    }

    private void setRight(double speed) {
        m_rightMotors.forEach(motor -> motor.set(speed));
    }

    /* Overrides */
    protected void dashboardInit() {}

    protected void dashboardPeriodic() {
        Stream.of(m_leftMotors, m_rightMotors).flatMap(Collection::stream).forEach(motor -> motor.log());

        SmartDashboard.putNumber("Rotation", m_currentRotation);
    }

    protected void publishInit() {}
    protected void publishPeriodic() {}
}
