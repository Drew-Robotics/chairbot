package frc.robot.subsystems.drivetrain;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import edu.wpi.first.units.Units;

public class Motor {
    private final SparkMax m_motorController;
    private final RelativeEncoder m_encoder;
    
    private final String m_name;

    public Motor(String name, int canID) {
        m_name = name;

        m_motorController = new SparkMax(canID, MotorType.kBrushed);
        m_encoder = m_motorController.getEncoder();

        SparkMaxConfig config = new SparkMaxConfig();

        config
            .smartCurrentLimit((int) Constants.kDrivingMotorCurrentLimit.in(Units.Amps))
            .idleMode(IdleMode.kBrake);
            
        m_motorController.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void log() { 
        SmartDashboard.putNumber(m_name + " Velocity", m_encoder.getVelocity());
    }

    public void set(double speed) {
        m_motorController.set(speed * Constants.kDriveScalar);
    }
}
