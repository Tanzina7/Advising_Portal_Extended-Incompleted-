import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class addAdmin {
    addAdmin()
    {
        JFrame f = new JFrame("Admin Panel");
        //found = false;

        JLabel l1 = new JLabel("Enter Admin ID :  ");
        l1.setBounds(80, 50, 150, 30);
        f.add(l1);

        JTextField t1 = new JTextField();
        t1.setBounds(300,50, 200,30);
        f.add(t1);

        JLabel l2 = new JLabel("Enter Name: ");
        l2.setBounds(80, 100, 150, 30);
        f.add(l2);

        JTextField t2 = new JTextField();
        t2.setBounds(300,100, 200,30);
        f.add(t2);

        JLabel l3 = new JLabel("Enter Password :  ");
        l3.setBounds(80, 150, 150, 30);
        f.add(l3);

        JPasswordField t3 = new JPasswordField();
        t3.setBounds(300,150, 200,30);
        f.add(t3);



        RoundedCornerButton b = new RoundedCornerButton("ENTRY");
        //b.setPreferredSize(new Dimension(150, 30));
        b.setBackground(new Color(220, 20, 60));
        b.setForeground(Color.white);
        Font customFont2 = new Font("Times New Roman", Font.BOLD, 13);
        b.setFont(customFont2);
        b.setBounds(250,250,150,40);
        f.add(b);

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                try
                {
                    File fl = new File("adminInfo.txt");
                    Scanner sc = new Scanner(fl);
                    Boolean found = false;

                    while(sc.hasNextLine())
                    {
                        String WHoleLine = sc.nextLine();
                        String[] LineArray = WHoleLine.split("\t");

                        String id1 = LineArray[0];
                        String nm = LineArray[1];
                        String pw1 = LineArray[2];
                        //int crd = Integer.valueOf(LineArray[2]);
                        //int sec =  Integer.valueOf(LineArray[3]);

                        if(t1.getText().equalsIgnoreCase(id1))
                        {
                            found = true;
                            break;
                            //JOptionPane.showMessageDialog(null, "ID Already Exists.\n LOGIN","Duplicate ID", JOptionPane.ERROR_MESSAGE);
                            //f.dispose();
                            //Dash d = new Dash();
                        }
                    }
                    sc.close();

                    if(found == false)
                    {
                        FileWriter fw = new FileWriter(fl, true);

                        //Course cr = new Course(t1.getText().toUpperCase(), t2.getText(), Integer.valueOf(t3.getText()), Integer.valueOf(t4.getText()));
                        fw.write("\n"+t1.getText()+"\t"+t2.getText()+"\t"+t3.getText());
                        fw.close();
                        //System.out.println(cr.toString());

                        JOptionPane.showMessageDialog(f, "Admin added Successfully " + fl.getAbsolutePath(),"Add Succseed", JOptionPane.INFORMATION_MESSAGE);







                        //Advising s = new Advising();
                        // Login l = new Login();
                        //f.dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(f, "Admin Already Exists","Duplicate ID", JOptionPane.WARNING_MESSAGE);
                        //f.dispose();
                        //Dash d = new Dash();
                    }



                }
                catch (IOException e11 )
                {
                    e11.printStackTrace();
                }

                //Add s = new Add();
                //f. dispose();

            }
        });


        RoundedCornerButton b2 = new RoundedCornerButton("GO Back");
        //b2.setPreferredSize(new Dimension(150, 30));
        b2.setBackground(new Color(204, 119, 34));
        b2.setForeground(Color.white);
        b2.setFont(customFont2);
        b2.setBounds(30,350,100,30);
        f.add(b2);



        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //jb.setText("Hello World....");
                //jb.setBounds(65, 50, 100, 50);
                f. dispose();
                //viewCourse a = new viewCourse();
                adminPanel s = new adminPanel();
                //s.found = false;


            }
        });






        f.setSize(600,500);
        //f.isOpaque();
        f.getContentPane().setBackground(new Color(230, 230, 250));
        //f.setBackground(Color.red);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
