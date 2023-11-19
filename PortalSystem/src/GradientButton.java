import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradientButton extends JButton
{

    Color endColor;  //= new Color(0, 128, 255); // Start color (e.g., blue)
    Color startColor;// = new Color(0, 255, 128);   // End color (e.g., green)
    public GradientButton(String text, Color startColor, Color endColor) {
        super(text);
        this.startColor = startColor;
        this.endColor = endColor;
        setContentAreaFilled(false); // Make the button transparent
        setFocusPainted(false); // Remove the default focus border

        // Add an ActionListener for the button
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click
            }
        });
    }

    public GradientButton(String text) {
        super(text);
        setContentAreaFilled(false); // Make the button transparent
        setFocusPainted(false); // Remove the default focus border

        // Add an ActionListener for the button
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        // Define the gradient colors
        //Color endColor  = new Color(0, 128, 255); // Start color (e.g., blue)
        //Color startColor = new Color(0, 255, 128);   // End color (e.g., green)

        // Create a gradient paint
        GradientPaint gradient = new GradientPaint(0, 0, startColor, 0, height, endColor);

        // Set the paint for the button
        g2d.setPaint(gradient);

        // Fill the button background with the gradient
        g2d.fillRect(0, 0, width, height);

        // Call the parent's paintComponent method to draw the button's text and other content
        super.paintComponent(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gradient Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);

       // GradientButton button = new GradientButton("Gradient Button");
       // frame.add(button);

        frame.setVisible(true);
    }
}
