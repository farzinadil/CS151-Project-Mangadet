import java.awt.Color;
public class Style2 implements Style {
    private boolean hasBackground = true;
    public Color getPitColor() {
        return Color.RED;
    }

    public Color getStoneColorP1() {
        return Color.decode("#00aefd");
    }

    public Color getStoneColorP2() {
        return Color.decode("#ff7231");
    }

}
