import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import javax.swing.*;

/**
 * The PlotPanel class acts as the observer and observes DataSource.
 */

public class PlotPanel extends JPanel implements Observer {
    protected int points[];
    JButton runButton = new JButton();
    static protected PlotPanel p;
    JPanel jPanel;

    private PlotPanel() {
    }

    public static PlotPanel getPlotPanel() {
        if (p == null) {
            p = new PlotPanel();
        }
        return p;
    }

    @Override
    public void update(int points[]) {
        this.points = points;
        drawPanels();
    }

    public JPanel drawPanels() {
        jPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 10, 10));
        jPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Plot Panel"));
        Drawable plot = new PointPlot(new BarPlot(new BasePlot()));
        jPanel = plot.plotPoints(jPanel);
        return jPanel;
    }
}
