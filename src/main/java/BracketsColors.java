import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class BracketsColors {

    private static final List<Color> colors = Arrays.asList(
            Color.CYAN,
            Color.RED,
            Color.YELLOW,
            Color.MAGENTA,
            Color.BLUE,
            Color.GREEN,
            Color.ORANGE,
            Color.PINK

    );

    public void addColor(Color color) {
        colors.add(color);
    }

    public void deleteColor(Color color) {
        colors.remove(color);
    }

    public Color getColor(int index) {
        return colors.get(index);
    }

    public int getLength() {
        return colors.size();
    }

}
