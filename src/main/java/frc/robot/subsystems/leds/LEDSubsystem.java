package frc.robot.subsystems.leds;

import java.util.List;

import frc.robot.Constants;
import frc.robot.subsystems.SubsystemAbstract;

public class LEDSubsystem extends SubsystemAbstract {
    private final CANdle m_candle;

    public LEDSubsystem() {
        super();

        m_candle = new CANdle(Constants.CANIDs.CANdle);
    }

    public void setLEDs(List<Color> colors) {
        for (Color c : colors)
            m_candle.setLEDs(c.r, c.g, c.b);
    }

    /* Overrides */
    protected void dashboardInit() {}

    protected void dashboardPeriodic() {}

    protected void publishInit() {}
    protected void publishPeriodic() {}
    
}
