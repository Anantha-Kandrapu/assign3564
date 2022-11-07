import javax.swing.JPanel;

/**
 * This class is a part of the Decorator pattern.
 */

public class DecoratorPlot extends JPanel implements Drawable {
    Drawable simplePlot;
    int[] points;

    public DecoratorPlot(Drawable s) {
        simplePlot = s;
    }

    @Override
    public JPanel plotPoints(JPanel j) {
        return simplePlot.plotPoints(j);
    }
}
