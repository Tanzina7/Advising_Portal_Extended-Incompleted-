import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AssignTeacher extends TeacherManage{
    public AssignTeacher()
    {
        JLabel l1 = new JLabel("Enter Course Code :  ");
        l1.setBounds(280, 155, 150, 25);
        f.add(l1);

        JTextField t1 = new JTextField();
        t1.setBounds(440,155, 220,25);
        //t1.setBackground(new Color(240, 255, 255));
        //t1.setBorder(BorderFactory.createEmptyBorder());
        f.add(t1);

        JLabel l2 = new JLabel("Enter Section no :  ");
        l2.setBounds(280, 190, 150, 25);
        f.add(l2);

        JTextField t2 = new JTextField();
        t2.setBounds(440,190, 220,25);
        f.add(t2);

        JLabel l3 = new JLabel("Enter Teacher's Initial :  ");
        l3.setBounds(280, 225, 150, 25);
        f.add(l3);

        JTextField t3 = new JTextField();
        t3.setBounds(440,225, 220,25);
        f.add(t3);

        RoundedCornerButton bbb = new RoundedCornerButton("Submit");
        //b.setPreferredSize(new Dimension(150, 50));
        bbb.setBackground(new Color(129, 19, 49));
        bbb.setForeground(Color.white);
        Font customFont3 = new Font("Times New Roman", Font.BOLD, 14);
        bbb.setFont(customFont3);
        bbb.setBounds(450,290,80,40);
        f.add(bbb);

        bbb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                Boolean change = false;
                ArrayList<Course> allCourses = new ArrayList<Course>();
                File fl = new File("CourseList3.txt");
                try{
                    if(fl.exists())
                    {
                        Scanner sc = new Scanner(fl);
                        //String ll =
                        sc.nextLine();
                        while(sc.hasNextLine())
                        {
                            String line = sc.nextLine();
                            String[] lineArray = line.split("\t");

                            if(lineArray[0].equalsIgnoreCase(t1.getText()) && lineArray[3].equalsIgnoreCase(t2.getText()) )
                            {
                                lineArray[4].replace("TBA", t3.getText());
                                change = true;
                                //JOptionPane.showMessageDialog(f, "This Initial already Exist", "Duplicate Teacher", JOptionPane.WARNING_MESSAGE);
                                //break;
                            }
                            Course c = new Course(lineArray[0], lineArray[1], Integer.valueOf(lineArray[2]), Integer.valueOf(lineArray[3]), lineArray[4], Integer.valueOf(lineArray[5]));
                            allCourses.add(c);
                        }
                    }

                    if(change==true)
                    {
                        File fl2 = new File("NewCourseList.txt");
                        FileWriter fw = new FileWriter(fl2);
                        for(int i = 0; i<allCourses.size(); i++)
                        {
                            fw.write(allCourses.get(i).toString());
                        }
                        fw.close();
                        //String dest = fl.getAbsolutePath();
                       //fl.delete();
                       fl2.renameTo(fl);
                        //JOptionPane.showMessageDialog(f, "Added Successfully", "Add Teacher", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch (IOException ee)
                {
                    ee.printStackTrace();
                }



                //f. dispose();

            }
        });



    }
}
