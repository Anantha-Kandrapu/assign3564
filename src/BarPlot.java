import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 * This class participates in the Decorator pattern. It takes the BasePlot and adds
 * features to it to make it a BarPlot.
 */

public class BarPlot extends DecoratorPlot {
    JPanel panel;
    Drawable s;

    public BarPlot(Drawable s) {
        super(s);
        this.s = s;
    }

    @Override
    public JPanel plotPoints(JPanel finalPanel) {
        finalPanel = super.plotPoints(finalPanel);
        drawPoints();
        finalPanel.add(panel);
        return finalPanel;
    }

    // This method draws the rectangle on the GUI and fills the colour to make it visible.
    
    @Override
    public void paint(Graphics g) {
        int height = 500;
        super.paint(g);
        g.setColor(Color.YELLOW);
        int points[] = DataSource.getDataSource().getData();
        int avg = Evaluator.getEvaluator().findAvg();
        g.drawLine(0, height - avg, 1000, height - avg);
        int prevX = 0;
        for (int i = 0; i < points.length - 1; ++i) {
            g.drawLine(prevX, height - points[i], prevX + 20, height - points[i + 1]);
            g.fillRect(prevX, height - points[i] - 2, 5, height);
            prevX = prevX + 20;
        }
    }

    private void drawPoints() {
        panel = new BarPlot(s);
        panel.setPreferredSize(new Dimension(500, 500));
        panel.setBackground(Color.BLACK);
    }
}
