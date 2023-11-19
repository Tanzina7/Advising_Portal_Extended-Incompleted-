import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.SwingConstants.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.*;
import javax.swing.text.TableView;

public class adminPanel
{
    public adminPanel()
    {
        JFrame f = new JFrame("Admin Panel");

        // Create a custom Font with a specific size
        Font customFont = new Font("Arial", Font.BOLD, 22);
        Font customFont2 = new Font("Times New Roman", Font.BOLD, 13);

        JLabel l1 = new JLabel("Welcome ADMIN");
        l1.setForeground(new Color(220, 20, 60 ));
        l1.setFont(customFont);
        //l1.setHorizontalAlignment(Label.CENTER);
        l1.setBounds(220, 50, 350, 200);
        f.add(l1);

        //JButton b=new JButton("Sign Up");
        RoundedCornerButton b1 = new RoundedCornerButton("Manage Students");
        //b1.setPreferredSize(new Dimension(200, 30));
        b1.setBackground(new Color(220, 20, 60));
        b1.setForeground(Color.white);
        b1.setFont(customFont2);
        b1.setBounds(70,250,140,40);
        f.add(b1);

        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                //AddCourse s = new AddCourse();
                //f. dispose();

            }
        });

        //JButton b=new JButton("Sign Up");
        RoundedCornerButton b2 = new RoundedCornerButton("Manage Teachers");
        //b2.setPreferredSize(new Dimension(200, 30));
        b2.setBackground(new Color(220, 20, 60));
        b2.setForeground(Color.white);
        b2.setFont(customFont2);
        b2.setBounds(250,250,140,40);
        f.add(b2);


        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                TeacherManage s = new TeacherManage();
                f. dispose();

            }
        });


        //JButton b=new JButton("Sign Up");
        RoundedCornerButton b3 = new RoundedCornerButton("Manage Courses");
        //b3.setPreferredSize(new Dimension(200, 30));
        b3.setBackground(new Color(220, 20, 60));
        b3.setForeground(Color.white);
        b3.setFont(customFont2);
        b3.setBounds(430,250,140,40);
        f.add(b3);


        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                viewCourse s = new viewCourse();
                f. dispose();

            }
        });


        //JButton b=new JButton("Sign Up");
        RoundedCornerButton b4 = new RoundedCornerButton("ADD New ADMIN");
        b4.setPreferredSize(new Dimension(150, 30));
        b4.setBackground(new Color(255, 165, 0));
        b4.setForeground(Color.white);
        b4.setFont(customFont2);
        b4.setBounds(250,370,160,40);
        f.add(b4);


        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                addAdmin s = new addAdmin();
                f. dispose();

            }
        });


        f.setSize(660,500);
        //f.isOpaque();
        f.getContentPane().setBackground(new Color(230, 230, 250));
        //f.setBackground(Color.red);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        adminPanel ap = new adminPanel();
    }
}

