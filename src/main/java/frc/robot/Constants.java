package frc.robot;

import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.Current;

public class Constants {
    public static final class CANIDs {
        public static final int frontLeftMotor = 3;
        public static final int backLeftMotor = 1;

        public static final int frontRightMotor = 4;
        public static final int backRightMotor = 2;

        public static final int CANdle = 0;
    }

    public static final double kDriveScalar = 0.8;
    public static final double kRotationScalar = 0.8;
    public static final double kLeftOffset = 0.1;

    public static final int kControllerPort = 0;    
    public static final Current kDrivingMotorCurrentLimit = Units.Amps.of(40);
}
