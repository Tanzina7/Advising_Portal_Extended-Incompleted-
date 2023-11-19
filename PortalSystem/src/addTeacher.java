import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.*;

public class addTeacher extends TeacherManage
{

    public addTeacher()
    {
       //JPanel jp = new JPanel();
        //GradientPanel jp = new GradientPanel(new Color(173, 216, 230),new Color(147, 112, 219));
       //jp.setBounds(280, 70, 390, 360);
       //jp.setBackground(new Color(216, 191, 216));

        JLabel l1 = new JLabel("Enter Teacher's Name :  ");
        l1.setBounds(280, 50, 150, 25);
        f.add(l1);

        JTextField t1 = new JTextField();
        t1.setBounds(440,50, 220,25);
        //t1.setBackground(new Color(240, 255, 255));
        //t1.setBorder(BorderFactory.createEmptyBorder());
        f.add(t1);

        JLabel l2 = new JLabel("Enter Teacher's Initial :  ");
        l2.setBounds(280, 85, 150, 25);
        f.add(l2);

        JTextField t2 = new JTextField();
        t2.setBounds(440,85, 220,25);
        f.add(t2);

        JLabel pl = new JLabel("Enter Password :  ");
        pl.setBounds(280, 120, 150, 25);
        f.add(pl);

        JPasswordField pt = new JPasswordField();
        pt.setBounds(440,120, 220,25);
        f.add(pt);

        JLabel l3 = new JLabel("Enter Department :  ");
        l3.setBounds(280, 155, 150, 25);
        f.add(l3);
        String[] deptA = {"Engineering", "Math & Physics", "Accounting & Finance", "Economics", "Architecture", "Law", "Literature"};
        JComboBox deptCombo = new JComboBox<>(deptA);
        deptCombo.setBounds(440,155, 220,25);
        deptCombo.setBackground(new Color(96, 130, 182));
        deptCombo.setForeground(Color.white);
        deptCombo.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        deptCombo.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                return new BasicComboPopup(comboBox) {

                    protected javax.swing.border.Border createPopupBorder() {
                        return BorderFactory.createEmptyBorder(); // Remove the popup border
                    }
                };
            }
        });

        f.add(deptCombo);

        //JTextField t3 = new JTextField();
        //t3.setBounds(440,135, 220,25);
        //f.add(t3);

        JLabel l4 = new JLabel("Enter Designation :  ");
        l4.setBounds(280, 190, 150, 25);
        f.add(l4);

        String[] desigA = {"Professor", "Associate Professor", "Assistant Professor", "Senior Lecturer", "Lecturer"};
        JComboBox desigCombo = new JComboBox<>(desigA);
        desigCombo.setBounds(440,190, 220,25);
        desigCombo.setBackground(new Color(8, 143, 143));
        desigCombo.setForeground(Color.white);
        desigCombo.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        desigCombo.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                return new BasicComboPopup(comboBox) {

                    protected javax.swing.border.Border createPopupBorder() {
                        return BorderFactory.createEmptyBorder(); // Remove the popup border
                    }
                };
            }
        });

        f.add(desigCombo);

        // JTextField t4 = new JTextField();
        // t4.setBounds(440,170, 220,25);
        //f.add(t4);
        JLabel l5 = new JLabel("Enter Phone no :  ");
        l5.setBounds(280, 260, 150, 25);
        f.add(l5);

        JTextField t5 = new JTextField("+0880");
        t5.setBounds(440,260, 220,25);
        f.add(t5);

        JLabel l6 = new JLabel("Enter email :  ");
        l6.setBounds(280, 225, 150, 25);
        f.add(l6);

        JTextField t6 = new JTextField(" @northsouth.edu");
        t6.setBounds(440,225, 220,25);
        f.add(t6);



        RoundedCornerButton bbb = new RoundedCornerButton("Submit");
        //b.setPreferredSize(new Dimension(150, 50));
        bbb.setBackground(new Color(129, 19, 49));
        bbb.setForeground(Color.white);
        Font customFont3 = new Font("Times New Roman", Font.BOLD, 14);
        bbb.setFont(customFont3);
        bbb.setBounds(450,330,80,40);
        f.add(bbb);

        bbb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                Boolean found = false;
                File fl = new File("TeacherInfo.txt");
                try{
                    if(fl.exists())
                    {
                        Scanner sc = new Scanner(fl);
                        while(sc.hasNextLine())
                        {
                            String line = sc.nextLine();
                            String[] lineArray = line.split("\t");
                            if(lineArray[1].equalsIgnoreCase(t2.getText()))
                            {
                                found = true;
                                JOptionPane.showMessageDialog(f, "This Initial already Exist", "Duplicate Teacher", JOptionPane.WARNING_MESSAGE);
                                break;
                            }
                        }
                    }

                    if(found==false)
                    {
                        FileWriter fw = new FileWriter(fl, true);
                        Teacher t = new Teacher(t1.getText(), t2.getText(), pt.getText(),
                                deptCombo.getItemAt(deptCombo.getSelectedIndex()).toString(),
                                desigCombo.getItemAt(desigCombo.getSelectedIndex()).toString(),
                                t5.getText(), t6.getText());
                        fw.write(t.toString());
                        fw.close();
                        JOptionPane.showMessageDialog(f, "Added Successfully", "Add Teacher", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch (IOException ee)
                {
                    ee.printStackTrace();
                }



                //f. dispose();

            }
        });






    }


    public static void main(String[] args)
    {
        addTeacher a  =  new addTeacher();

    }

}
