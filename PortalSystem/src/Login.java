import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class Login {

    static String nmm, idd, cgg, gen = "";
    JFrame f;

    public Login()
    {
        //JFrame
                f = new JFrame("Login");



        JLabel l1 = new JLabel("Enter ID :  ");
        l1.setBounds(80, 50, 200, 30);
        f.add(l1);

        JTextField t1 = new JTextField();
        t1.setBounds(300,50, 250,30);
        f.add(t1);

        JLabel l2 = new JLabel("Enter Password :  ");
        l2.setBounds(80, 100, 200, 30);
        f.add(l2);

        JPasswordField t2 = new JPasswordField();
        t2.setBounds(300,100, 250,30);
        f.add(t2);


        RoundedCornerButton bb = new RoundedCornerButton("login");
        //b.setPreferredSize(new Dimension(150, 50));
        bb.setBackground(new Color(129, 19, 49));
        bb.setForeground(Color.white);
        Font customFont2 = new Font("Times New Roman", Font.BOLD, 20);
        bb.setFont(customFont2);
        bb.setBounds(260,200,100,50);
        f.add(bb);

        bb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String id = t1.getText();
                String pw = t2.getText();


                try
                {
                    ///checking Student Login
                    File fl = new File("StudentRecords2.txt");
                    Scanner sc = new Scanner(fl);
                    Boolean flag = false;
                    while(sc.hasNext())
                    {
                        String ID = sc.next();
                        String NAME = sc.next();
                        String Password = sc.next();
                        String CGPA = sc.next();
                        String GENDER = sc.next();

                        if(ID.equalsIgnoreCase(id) && Password.equalsIgnoreCase(pw))
                        {
                            nmm = NAME;
                            idd = ID;
                            cgg = CGPA;
                            gen = GENDER;

                            advisingPanel ad = new advisingPanel();
                            flag = true;
                            f.dispose();


                        }

                    }
                    sc.close();

                    //checkin admin Login
                    File fl2 = new File("adminInfo.txt");
                    Scanner sc2 = new Scanner(fl2);
                    //Boolean flag2 = false;
                    while(sc2.hasNext())
                    {
                        //String WholeLine = s
                        String ID = sc2.next();
                        String NAME = sc2.next();
                        String Password = sc2.next();

                        if(ID.equalsIgnoreCase(id) && Password.equalsIgnoreCase(pw))
                        {
                            nmm = NAME;
                            idd = ID;

                            adminPanel ad = new adminPanel();
                            flag = true;
                            f.dispose();


                        }

                    }
                    sc2.close();

                    if(flag == false)
                        JOptionPane.showMessageDialog(f, "Wrong ID or Password","ERROR", JOptionPane.ERROR_MESSAGE);
                }
                catch(IOException ee)
                {
                    ee.printStackTrace();
                }

                //Advising s = new Advising();
                //Login l = new Login();
                //f. dispose();

            }
        });


        f.setSize(650,500);
        f.getContentPane().setBackground(new Color(204, 204, 255));
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
