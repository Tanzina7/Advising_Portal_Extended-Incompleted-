import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

class GradientPanel extends JPanel {

    Color startColor;
    Color endColor;
    GradientPanel(Color startColor, Color endColor)
    {
        this.startColor= startColor;
        this.endColor = endColor;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Define the gradient colors
        //Color startColor = Color.RED;
        //Color endColor = Color.BLUE;

        // Create a gradient paint object
        GradientPaint gradient = new GradientPaint(
                new Point2D.Double(0, 0), startColor,
                new Point2D.Double(0, getHeight()), endColor
        );

        // Create a graphics2D object
        Graphics2D g2d = (Graphics2D) g;

        // Set the gradient paint
        g2d.setPaint(gradient);

        // Fill a rectangle with the gradient paint
        g2d.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
    }
}

 class GradientPanelExample {
    public static void main(String[] args) {

                JFrame frame = new JFrame("Gradient JPanel Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            // Create a JPanel with a gradient background
            GradientPanel panel = new GradientPanel(Color.RED, Color.BLUE);
            frame.add(panel);

            frame.setVisible(true);

    }
}
