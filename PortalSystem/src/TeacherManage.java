import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherManage {
    JFrame f;
    GradientButton addTeacher, assign, delTeacher, back;
    public TeacherManage()
    {
         f =  new JFrame("Teacher Manage");

        Font customFont2 = new Font("Times New Roman", Font.BOLD, 13);

        //GradientButton
                addTeacher = new GradientButton("ADD New Teacher", new Color(64, 171, 183), new Color(150, 0, 180));
        addTeacher.setBounds(40, 150, 185, 35);
        addTeacher.setForeground(Color.white);
        //addTeacher.setForeground(new Color(255, 0, 0));
        //addTeacher.setBackground(new Color(0, 120, 120));
        addTeacher.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        addTeacher.setFont(customFont2);
        f.add(addTeacher);

        addTeacher.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                addTeacher s = new addTeacher();
                f. dispose();

            }
        });

        //GradientButton
                assign = new GradientButton("Assign Course to Teacher", new Color(64, 171, 183), new Color(150, 0, 180));
        assign.setBounds(40, 200, 185, 35);
        assign.setForeground(Color.white);
        assign.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        assign.setFont(customFont2);
        f.add(assign);

        assign.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                AssignTeacher s = new AssignTeacher();
                f. dispose();

            }
        });

        //GradientButton
                delTeacher = new  GradientButton("Remove a Teacher", new Color(64, 171, 183), new Color(150, 0, 180));
        delTeacher.setBounds(40, 250, 185, 35);
        delTeacher.setForeground(Color.white);
        delTeacher.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        delTeacher.setFont(customFont2);
        f.add(delTeacher);

        delTeacher.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                //AddCourse s = new AddCourse();
                //f. dispose();

            }
        });

        //GradientButton
                back = new  GradientButton("Go Back", new Color(64, 171, 183), new Color(150, 0, 180));
        back.setBounds(40, 300, 185, 30);
        back.setForeground(Color.white);
        back.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        back.setFont(customFont2);
        f.add(back);

        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                //AddCourse s = new AddCourse();
                //f. dispose();

            }
        });




        f.setSize(750,550);
        //f.isOpaque();
        f.getContentPane().setBackground(new Color(230, 230, 250));
        //f.setBackground(Color.red);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        TeacherManage tm = new TeacherManage();

    }
}
