package frc.robot.subsystems.leds;

import edu.wpi.first.math.MathUtil;

public class Color {
    public final int r;
    public final int g;
    public final int b;

    public Color(int r, int g, int b, double opacity) {
        this.r = processChannel(r, opacity);
        this.g = processChannel(g, opacity);
        this.b = processChannel(b, opacity);
    }

    public Color(int r, int g, int b) {
        this.r = clampChannel(r);
        this.g = clampChannel(g);
        this.b = clampChannel(b);
    }

    private int processChannel(int channel, double opacity) {
        return clampChannel((int) Math.round(r * opacity));
    }

    private int clampChannel(int channel) {
        return MathUtil.clamp(channel, 0, 255);
    }

    public Color addColor(Color color) {
        return new Color(r + color.r, g + color.g, b + color.b);
    }

    public Color applyOpacity(double opacity) {
        return new Color(r, g, b, opacity);
    }
}
