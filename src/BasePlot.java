import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * This class is a part of the Decorator pattern. It is the Base class to which features
 * are added.
 */

public class BasePlot extends JPanel implements Drawable {
    JPanel panel;
    int points[];

    public BasePlot() {
    }

    @Override
    public JPanel plotPoints(JPanel finalPanel) {
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
            prevX = prevX + 20;
        }
    }

    private void drawPoints() {
        panel = new BasePlot();
        panel.setPreferredSize(new Dimension(500, 500));
        panel.setBackground(Color.RED);
    }
}
