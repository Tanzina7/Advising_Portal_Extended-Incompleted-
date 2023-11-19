import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddCourse
{
    JFrame f;
    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3, t4;
    //Boolean found ;


    public AddCourse()
    {
        //JFrame
                f = new JFrame("Admin Panel");
                //found = false;

        //JLabel
                l1 = new JLabel("Enter Course Code :  ");
        l1.setBounds(80, 50, 200, 30);
        f.add(l1);

        //JTextField
                t1 = new JTextField();
        t1.setBounds(300,50, 250,30);
        f.add(t1);

        //JLabel
                l2 = new JLabel("Enter Course Name :  ");
        l2.setBounds(80, 100, 200, 30);
        f.add(l2);

        //JTextField
                t2 = new JTextField();
        t2.setBounds(300,100, 250,30);
        f.add(t2);

        //JLabel
                l3 = new JLabel("Enter Course Credit no :  ");
        l3.setBounds(80, 150, 200, 30);
        f.add(l3);

        //JTextField
                t3 = new JTextField();
        t3.setBounds(300,150, 250,30);
        f.add(t3);

        //JLabel
                l4 = new JLabel("Enter allocated Sections no :  ");
        l4.setBounds(80, 200, 200, 30);
        f.add(l4);

        //JTextField
                t4 = new JTextField();
        t4.setBounds(300,200, 250,30);
        f.add(t4);


        RoundedCornerButton b = new RoundedCornerButton("ADD Course");
        b.setPreferredSize(new Dimension(150, 30));
        b.setBackground(new Color(220, 20, 60));
        b.setForeground(Color.white);
        Font customFont2 = new Font("Times New Roman", Font.BOLD, 13);
        b.setFont(customFont2);
        b.setBounds(250,300,150,40);
        f.add(b);

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                try
                {
                    File fl = new File("CourseList3.txt");
                    Boolean found = false;
                    if(fl.exists()) {
                        Scanner sc = new Scanner(fl);


                        while (sc.hasNextLine()) {
                            String WHoleLine = sc.nextLine();
                            String[] LineArray = WHoleLine.split("\t");

                            String id1 = LineArray[0];
                            String name1 = LineArray[1];
                            //int crd = Integer.valueOf(LineArray[2]);
                            //int sec = Integer.valueOf(LineArray[3]);
                            //String fac

                            if (t1.getText().equalsIgnoreCase(id1)) {
                                found = true;
                                break;
                                //JOptionPane.showMessageDialog(null, "ID Already Exists.\n LOGIN","Duplicate ID", JOptionPane.ERROR_MESSAGE);
                                //f.dispose();
                                //Dash d = new Dash();
                            }
                        }
                        sc.close();
                    }

                    if(found == false)
                    {
                        FileWriter fw = new FileWriter(fl, true);

                        for(int i= 0; i<Integer.valueOf(t4.getText()); i++)
                        {
                            Course cr = new Course(t1.getText().toUpperCase(), t2.getText(), Integer.valueOf(t3.getText()), i+1, "TBA", 40);
                            fw.write(cr.toString());
                        }


                        fw.close();
                        //System.out.println(cr.toString());

                        JOptionPane.showMessageDialog(f, "Course Successfully Added to" + fl.getAbsolutePath(),"Add Succseed", JOptionPane.INFORMATION_MESSAGE);







                        //Advising s = new Advising();
                        // Login l = new Login();
                        //f.dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(f, "Course Already Exists","Duplicate Course", JOptionPane.ERROR_MESSAGE);
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
        b2.setPreferredSize(new Dimension(150, 30));
        b2.setBackground(new Color(204, 119, 34));
        b2.setForeground(Color.white);
        b2.setFont(customFont2);
        b2.setBounds(30,400,100,30);
        f.add(b2);



        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //jb.setText("Hello World....");
                //jb.setBounds(65, 50, 100, 50);
                f. dispose();
                viewCourse a = new viewCourse();
                //AddCourse s = new AddCourse();
                //s.found = false;


            }
        });

        RoundedCornerButton b3 = new RoundedCornerButton("Add Another");
        b3.setPreferredSize(new Dimension(150, 30));
        b3.setBackground(new Color(204, 119, 34));
        b3.setForeground(Color.white);
        b3.setFont(customFont2);
        b3.setBounds(500,400,120,30);
        f.add(b3);

        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //jb.setText("Hello World....");
                //jb.setBounds(65, 50, 100, 50);
                f. dispose();
                AddCourse s = new AddCourse();


            }
        });


        //f.revalidate(); // Refresh the frame to show the child button




        f.setSize(660,500);
        //f.isOpaque();
        f.getContentPane().setBackground(new Color(230, 230, 250));
        //f.setBackground(Color.red);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
