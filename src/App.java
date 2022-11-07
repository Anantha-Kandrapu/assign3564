import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.*;

/**
 * @author Anantha Kandrapu
 * @author Mohammad Danish Khan
 * @author Paromita Roy
 * 
 * This is the driver code that calls all the functions necessary to plot random points in three
 * different formats. These formats are- a line plot, point plot, and a bar plot.
 * 
 */
public class App extends JFrame implements ActionListener {
    static PlotPanel plotPanel = PlotPanel.getPlotPanel();
    static DataSource dataSource = DataSource.getDataSource();
    static JFrame frame;

    public void frameGenerator() {
        frame = new JFrame();
        JButton runButton = new JButton("Run");
        frame.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        frame.add(plotPanel.drawPanels());
        runButton.addActionListener(this);
        frame.add(runButton);
        frame.setTitle("Assignment 03- Design Patterns");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public App() {
        JButton runButton = new JButton("First Run");
        runButton.addActionListener(this);
        frame = new JFrame();
        frame.add(runButton);
        frame.setSize(500, 500);
        frame.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        frame.setTitle("Assignment 3");
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        dataSource.setObs1(plotPanel);
        dataSource.setData();
        new App();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dataSource.setData();
        frame.dispose();
        frameGenerator();
    }

}
