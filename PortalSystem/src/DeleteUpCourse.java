import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DeleteUpCourse extends viewCourse{
    public void DeleteCourse()
    {
        //super();

        //super.
                //b2.setBounds(00,500,100,30);
        //b2.setPreferredSize(new Dimension(90, 30));
        b2.setVisible(false);

        RoundedCornerButton b3 = new RoundedCornerButton("DELETE Course");
        b3.setPreferredSize(new Dimension(180, 30));
        // b2.setLocation(20, 500);
        b3.setLayout(new FlowLayout(FlowLayout.LEFT, 00, 35));
        //b3.setBackground(new Color(210, 4, 45));
        b3.setBackground(Color.red);
        b3.setForeground(Color.white);
        Font customFont1 = new Font("Times New Roman", Font.BOLD, 13);
        b3.setFont(customFont1);
        //scrollPane.add(b2);
        //b2.setBounds(30,400,100,30);
        f.add(b3);
        //f.setLayout(new FlowLayout(FlowLayout.LEFT, 00, 35));



        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int selectedRow = jt.getSelectedRow();
                if (selectedRow != -1) {
                    // Remove the selected row data from the DefaultTableModel
                    model.removeRow(selectedRow);
                }


                try {
                    File file = new File("CourseList.txt");
                    FileWriter writer = new FileWriter(file);

                    // Write the data rows
                    for (int row = 0; row < model.getRowCount(); row++)
                    {
                        for (int col = 1; col < model.getColumnCount(); col++)
                        {
                            writer.write(model.getValueAt(row, col).toString());
                            if (col < model.getColumnCount() - 1) {
                                writer.write("\t");
                            }
                        }
                        if((row+1) < model.getRowCount())
                             writer.write("\n");
                    }

                    // Close the writer
                    writer.close();

                    JOptionPane.showMessageDialog(f, "Course Successfully Deleted", "Delete Successful", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(f, "Error Deleting Course " + ex.getMessage(), "Error Deleting", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        //RoundedCornerButton b4 = new RoundedCornerButton("Go Back");
        //JButton b4 = new JButton("<html><span style='background-color: red;'>                                      </span><span style='background-color: green;'>Go Back</span></html");
        //JButton multiColorButton = new JButton("<html><span style='background-color: red;'>R</span><span style='background-color: green;'>G</span><span style='background-color: blue;'>B</span></html>");
        JButton b4 = new JButton(new ImageIcon("back2.png"));
       // b4.setBounds();
        //b4.setPreferredSize(new Dimension(70, 30));
        b4.setPreferredSize(new Dimension(236, 30));
        //b4.setLocation(-100, -100);
        b4.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        f.add(b4);

        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f. dispose();
                adminPanel a = new adminPanel();
            }
        });



        //f.setLayout(new FlowLayout(FlowLayout.CENTER, 130, 35));


    }
}
