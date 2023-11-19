import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

public class viewCourse
{
    JFrame f;
    //JLabel ll;
    //JTextField tt;
    RoundedCornerButton b2;
    JTable jt;
    DefaultTableModel model;

    public viewCourse() {
        //JFrame
                f = new JFrame("Admin Panel");

        //JPanel panel1=new JPanel();
        //panel1.setPreferredSize(new Dimension(500, 50));
        //panel1.setBackground(Color.pink);




        //JLabel ll = new JLabel("Search Course ");
         //ll.setSize(100, 50);
         //ll.setBounds(50, 50, 100, 50);
        //ll.setSize(new Dimension(100, 50));
         //panel1.add(ll);
        //f.add(ll);

        JTextField tt = new JTextField("Enter Course Code");
         tt.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 128), 1));
        //tt.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 0));
        // Set the preferred width of the JPanel containing the JTextField
        tt.setPreferredSize(new Dimension(250, 30));
         //tt.setSize(new Dimension(100, 50));
         //tt.setBounds(0, 10, 200, 10);
        //tt.setSize(100, 50);
         //panel1.add(tt);
        //f.setBounds(200, 200, 100, 50);
        f.add(tt);

        JButton jb = new JButton("Search");
        //RoundedCornerButton jb = new RoundedCornerButton("Search");
        jb.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 128), 4));
        jb.setPreferredSize(new Dimension(70, 30));
        jb.setBackground(new Color(0, 128, 128));
        jb.setForeground(Color.white);
        Font customFont2 = new Font("Times New Roman", Font.BOLD, 13);
        jb.setFont(customFont2);
        f.add(jb);

        //f.add(panel1);


        //ArrayList<String> cor = new ArrayList<String>();
        HashSet<String> cor = new HashSet<>();

        //DefaultTableModel
        model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("CourseCode");
        model.addColumn("CourseName");
        model.addColumn("Credit");
        model.addColumn("Section");
        model.addColumn("Faculty");
        model.addColumn("Seat");
        //Object[] colData = {"No","CourseCode", "CourseName", "Total Credit", "Total Sections"};
        //model.addRow(colData);
        //int count = 0;


        try {

            File fl = new File("CourseList3.txt");
            Scanner sc = new Scanner(fl);
            int line = 0;
            sc.nextLine();

            while (sc.hasNextLine()) {
                //count++;
                String WholeLine = sc.nextLine();
                String[] LineArray = WholeLine.split("\t");
                line++;

                cor.add(LineArray[0]);

                Object[] rowData = {Integer.toString(line), LineArray[0], LineArray[1], LineArray[2], LineArray[3], LineArray[4], LineArray[5]};

                // Add the new row data to the DefaultTableModel
                model.addRow(rowData);
            }
            sc.close();
        } catch (IOException ee) {
            ee.printStackTrace();
        }
        model.fireTableDataChanged();
        for (int row = 0; row < model.getRowCount(); row++) {
            model.setValueAt(row+1, row, 0);
        }


        //JTable
                jt = new JTable(model);

        // Adjust the dimensions as needed
        jt.setPreferredScrollableViewportSize(new Dimension(620, 250));
        //jt.setBounds(50, 200, 400, 400);
        //jt.setSize(500,500);

        //setting a color to the 1st row of the table
        // Add custom TableCellRenderer to color the first row
        jt.setDefaultRenderer(Object.class, new CustomRowColorRenderer());

        // Set the row height for the header (column names row)
        JTableHeader header = jt.getTableHeader();
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 25)); // Adjust the height as needed

        // Custom cell renderer for the header row
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(new Color(8, 143, 143)); // Set a background color for the header row
                c.setForeground(Color.white); // Set a text color for the header row
                return c;
            }
        });

        //setting custom width of every column
        TableColumnModel columnModel = jt.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(20); //no
        columnModel.getColumn(3).setPreferredWidth(40);//credit
        columnModel.getColumn(4).setPreferredWidth(50);//section
        columnModel.getColumn(1).setPreferredWidth(60);//code
        columnModel.getColumn(2).setPreferredWidth(100);//name
        columnModel.getColumn(5).setPreferredWidth(40);//faculty
        columnModel.getColumn(6).setPreferredWidth(40);//seat

        // Update the JTable's layout
        jt.revalidate();
        jt.repaint();



        //setting custom height of the 1st row
        //jt.setRowHeight(0, 30);
        //f.add(jt);
        JScrollPane scrollPane = new JScrollPane(jt);
        scrollPane.setSize(500, 250);
        f.add(scrollPane);
        f.setLayout(new FlowLayout(FlowLayout.CENTER, 00, 30));
        //f.setLayout(new FlowLayout());
        //f.setLayout( new GridLayout(2, 3, 50, 50));



        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                /*
                boolean fnd =  false;
                for (int i = 0; i < cor.size(); i++)
                {
                    if(tt.getText().equalsIgnoreCase(cor.get(i)))
                    {
                        JOptionPane.showMessageDialog(f, ""+tt.getText()+ " Course is FOUND", "found", JOptionPane.INFORMATION_MESSAGE );
                        fnd = true;
                        break;
                    }
                }
                if(fnd == false)
                {
                    JOptionPane.showMessageDialog(f, ""+tt.getText()+ " Course is NOT Found", " NOT found", JOptionPane.INFORMATION_MESSAGE );
                }

                 */

                String searchTerm = tt.getText().trim();
                for (int row = 0; row < model.getRowCount(); row++) {
                    for (int col = 0; col < model.getColumnCount(); col++) {
                        if (searchTerm.equalsIgnoreCase(model.getValueAt(row, col).toString())) {
                            // Highlight or select the cell where the element was found
                            jt.changeSelection(row, col, false, false);
                            return; // Stop searching after the first match
                        }
                    }
                }
                //JOptionPane.showMessageDialog(null, "Element not found");
                JOptionPane.showMessageDialog(f, searchTerm+ " Course is NOT Found", " NOT found", JOptionPane.INFORMATION_MESSAGE );


            }
        });

        RoundedCornerButton add = new RoundedCornerButton("ADD Course");
        add.setPreferredSize(new Dimension(125, 30));
        // b2.setLocation(20, 500);
        add.setLayout(new FlowLayout(FlowLayout.LEFT, 00, 35));
        add.setBackground(new Color(0, 128, 0));
        add.setForeground(Color.white);
        Font customFont1 = new Font("Times New Roman", Font.BOLD, 13);
        add.setFont(customFont1);
        //scrollPane.add(b2);
        //b2.setBounds(30,400,100,30);
        f.add(add);

        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f. dispose();
                AddCourse a = new AddCourse();
            }
        });

        RoundedCornerButton addSec = new RoundedCornerButton("ADD Section");
        addSec.setPreferredSize(new Dimension(125, 30));
        // b2.setLocation(20, 500);
        addSec.setLayout(new FlowLayout(FlowLayout.LEFT, 00, 35));
        addSec.setBackground(new Color(0, 128, 0));
        addSec.setForeground(Color.white);
        //Font customFont1 = new Font("Times New Roman", Font.BOLD, 13);
        addSec.setFont(customFont1);
        //scrollPane.add(b2);
        //b2.setBounds(30,400,100,30);
        f.add(addSec);

        addSec.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f. dispose();
                //AddCourse a = new AddCourse();
            }
        });


        RoundedCornerButton del = new RoundedCornerButton("DELETE");
        del.setPreferredSize(new Dimension(125, 30));
        // b2.setLocation(20, 500);
        del.setLayout(new FlowLayout(FlowLayout.LEFT, 00, 35));
        del.setBackground(new Color(0, 128, 0));
        del.setForeground(Color.white);
        //Font customFont1 = new Font("Times New Roman", Font.BOLD, 13);
        del.setFont(customFont1);
        //scrollPane.add(b2);
        //b2.setBounds(30,400,100,30);
        f.add(del);

        del.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int selectedRow = jt.getSelectedRow();
                if (selectedRow != -1) {
                    // Remove the selected row data from the DefaultTableModel
                    model.removeRow(selectedRow);
                }


                model.fireTableDataChanged();
                for (int row = 0; row < model.getRowCount(); row++) {
                    model.setValueAt(row+1, row, 0);
                }


                saveTableDataToFile(jt, model, "Delet");


            }
        });


        RoundedCornerButton ed = new RoundedCornerButton("UPDATE");
        ed.setPreferredSize(new Dimension(125, 30));
        // b2.setLocation(20, 500);
        ed.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 35));
        ed.setBackground(new Color(0, 128, 0));
        ed.setForeground(Color.white);
        //Font customFont1 = new Font("Times New Roman", Font.BOLD, 13);
        ed.setFont(customFont1);
        //scrollPane.add(b2);
        //b2.setBounds(30,400,100,30);
        f.add(ed);

        ed.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //f. dispose();
                //UpdateCourse a = new DeleteCourse();
                saveTableDataToFile(jt, model, "Updat");
            }
        });



        JButton b4 = new JButton(new ImageIcon("back2.png"));
        // b4.setBounds();
        //b4.setPreferredSize(new Dimension(70, 30));
        b4.setPreferredSize(new Dimension(236, 30));
        //b4.setLocation(-100, -100);
        b4.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        f.add(b4);



        /*
        //RoundedCornerButton
                b2 = new RoundedCornerButton("GO Back");
        b2.setPreferredSize(new Dimension(120, 30));
       // b2.setLocation(20, 500);
        //b2.setLayout(new FlowLayout(FlowLayout.LEFT, 00, 35));
        b2.setBackground(new Color(204, 119, 34));
        b2.setForeground(Color.white);
        //Font customFont1 = new Font("Times New Roman", Font.BOLD, 13);
        b2.setFont(customFont1);
        //scrollPane.add(b2);
        //b2.setBounds(30,400,100,30);
        f.add(b2);
        //f.setLayout(new FlowLayout(FlowLayout.LEFT, 00, 35));



         */
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f. dispose();
                adminPanel a = new adminPanel();
            }
        });



        f.setSize(720, 550);
        //f.isOpaque();
        f.getContentPane().setBackground(new Color(230, 230, 250));
        //f.setBackground(Color.red);
        f.setLocationRelativeTo(null);
        //f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }


    private static void saveTableDataToFile(JTable jt, DefaultTableModel model, String str)
    {
        try {
            File file = new File("CourseList3.txt");
            FileWriter writer = new FileWriter(file);
            writer.write("CODE\tNAME\tCREDIT\tSECTION\tFACULTY\tSEAT\n");

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

            JOptionPane.showMessageDialog(null, "Course Successfully "+str+"ed", "Successful", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error "+str+"ing Course " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }




        static class CustomRowColorRenderer extends DefaultTableCellRenderer
        {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
            {
                Component component;
                component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                //if (row == 0) {
                    //component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    //component.setBackground(new Color(170, 255, 0));
               // }else
                if (isSelected)
                {
                    // Highlight the selected cell
                    //component.setBackground(table.getSelectionBackground());
                    //component.setBackground((Color.red));
                    component.setBackground(new Color(255, 36, 0));
                }
                else
                {
                    if(row%2 == 0)
                    {
                        // component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                        component.setBackground(new Color(193, 225, 193));
                    }
                    else
                    {
                        //component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                        component.setBackground(Color.WHITE);
                    }
                }
                return component;
            }
        }


        public static void main(String[] args)
        {
            viewCourse v = new viewCourse();
        }

}



