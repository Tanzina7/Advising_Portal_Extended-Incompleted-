import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Dash {
    public Dash()
    {
        JFrame f= new JFrame("Welcome");

        // Create a custom Font with a specific size
        Font customFont = new Font("Arial", Font.BOLD, 28);
        Font customFont2 = new Font("Times New Roman", Font.BOLD, 20);

        JLabel l1 = new JLabel("Welcome to DashBoard");
        l1.setForeground(Color.RED);
        l1.setFont(customFont);
        l1.setBounds(170, 50, 350, 200);
        f.add(l1);

        //JButton b=new JButton("Sign Up");
        RoundedCornerButton b = new RoundedCornerButton("Sign Up");
        b.setPreferredSize(new Dimension(150, 50));
        b.setBackground(new Color(129, 19, 49));
        b.setForeground(Color.white);
        b.setFont(customFont2);
        b.setBounds(180,240,120,50);
        f.add(b);

        //JLabel jb = new JLabel();
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //jb.setText("Hello World....");
                //jb.setBounds(65, 50, 100, 50);
                Signup s = new Signup();
                f. dispose();

            }
        });

        RoundedCornerButton b2 = new RoundedCornerButton("Login");
        //b.setPreferredSize(new Dimension(150, 50));
        b2.setBackground(new Color(129, 19, 49));
        b2.setForeground(Color.white);
        b2.setFont(customFont2);
        b2.setBounds(360,240,120,50);
        f.add(b2);

        //JLabel jb = new JLabel();
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //jb.setText("Hello World....");
                //jb.setBounds(65, 50, 100, 50);
                Login l = new Login();
                f. dispose();

            }
        });


        //f.add(jb);
        f.setSize(650,500);

        f.getContentPane().setBackground(new Color(204, 204, 255));
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
        Dash d = new Dash();
    }
}
