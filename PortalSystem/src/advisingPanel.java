import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.table.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.*;

public class advisingPanel
            //extends Signup
{

        JFrame f;
        JLabel fees;
        final int[] count = {0};
        final int[] totalFee = {0};
        public advisingPanel()
        {
            //JFrame f;

            Login su = new  Login();
            su.f.dispose();

            JLabel l1 = new JLabel();
            l1.setBounds(50, -20, 100, 100);
            // l1.setText(st.getId());
            l1.setText("ID: " + su.idd);

            JLabel l2 = new JLabel();
            l2.setBounds(250, -20, 100, 100);
            // l2.setText(st.getName());
            l2.setText("Name: " +su.nmm);

            JLabel l3 = new JLabel();
            l3.setBounds(450, -20, 100, 100);
            //l3.setText(String.valueOf(st.getCg()));
            l3.setText("CGPA: " +su.cgg);


            int nline = 0;
            HashSet<String> corseSet = new HashSet<String>();
            //reading all the courses from the CouseList File and loading it on to an array
            try{
                File file1 = new File("CourseList3.txt");
                Scanner sc7 = new Scanner( file1);
                sc7.nextLine();

                while(sc7.hasNextLine())
                {
                    String WholeLIne = sc7.nextLine();
                    String[] Linearray = WholeLIne.split("\t");
                    corseSet.add(Linearray[0]);
                    nline++;
                }
                sc7.close();

            }
            catch(IOException e5)
            {
                e5.printStackTrace();
            }
            Course[] arrO = new Course[nline];

            try{
                File file2 = new File("CourseList3.txt");
                Scanner sc8 = new Scanner( file2);
                sc8.nextLine();
                for(int i = 0; i< nline; i++)
                {
                    String oneLine = sc8.nextLine();
                    String[] lineArr = oneLine.split("\t");
                    arrO[i]= new Course(lineArr[0], lineArr[1], Integer.valueOf(lineArr[2]), Integer.valueOf(lineArr[3]),lineArr[4], Integer.valueOf(lineArr[5]));
                }

                sc8.close();


            }
            catch(IOException e5)
            {
                e5.printStackTrace();
            }

            //now making the JComboBox from info of the array that was made from file
            JFrame f = new JFrame("Courses");

            String[] c = new String[corseSet.size()];
            int index = 0;
            //for (int i = 0; i < c.length; i++) {
            for (String i : corseSet) {
                c[index] = i;
                index++;
            }

            Arrays.sort(c);

            JComboBox<String> cb = new JComboBox<>(c);

            cb.setBounds(50, 60, 150, 25);
            cb.setBackground(new Color(255, 117, 24));
            //cb.setBackground(Color.black);
            cb.setForeground(Color.black);
            //cb.is
            cb.setFont(new Font("Arial", Font.BOLD, 14));
            // Set the custom border to the JComboBox
            cb.setBorder(BorderFactory.createLineBorder(Color.red, 3));
            cb.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                return new BasicComboPopup(comboBox) {

                    protected javax.swing.border.Border createPopupBorder() {
                        return BorderFactory.createEmptyBorder(); // Remove the popup border
                    }
                };
            }
        });
            f.add(cb);

            //optionTable
            DefaultTableModel model0 = new DefaultTableModel();
            //model0.addColumn("No");
            model0.addColumn("CourseCode");
            model0.addColumn("CourseName");
            model0.addColumn("Section");
            model0.addColumn("Faculty");
            model0.addColumn("Seat");
            //model0.addColumn("Credit");
            //model0.addColumn("Fee");
            //Object[] colData0 = {"No","CourseCode", "CourseName", "Section", "Credit", "Fee"};
            Object[] colData0 = {"CourseCode", "CourseName", "Section", "Faculty", "Seat"};
            model0.addRow(colData0);

            cb.addActionListener(new ActionListener()
            {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> source = (JComboBox<String>) e.getSource();
                String selectedValue = (String) source.getSelectedItem();
                //System.out.println("Selected Value: " + selectedValue);
                clearTable(model0);
                model0.addRow(colData0);
                int SecSerial = 0;
                for(int i = 0; i<arrO.length; i++)
                {
                    if(arrO[i].getCode().equalsIgnoreCase(selectedValue))
                    {
                        SecSerial++;
                        Object[] rowData0 = {arrO[i].getCode(), arrO[i].getName(), SecSerial, arrO[i].getFaculty(), arrO[i].getSeat()};

                        // Add the new row data to the DefaultTableModel
                        model0.addRow(rowData0);
                    }
                }


               }
            });

            JTable jt0 = new JTable(model0);
            jt0.setBounds(250, 60, 480, 180);
            //jt0.setBackground(new Color(250, 249, 246));
            jt0.setDefaultRenderer(Object.class, new CustomRowColorRenderer0());
            jt0.setRowHeight(0, 20);
            f.add(jt0);

            // Get the TableColumnModel and the TableColumn for the first column
            TableColumnModel columnModel0 = jt0.getColumnModel();
            // Set the preferred width for the first column
            columnModel0.getColumn(0).setPreferredWidth(60);
            columnModel0.getColumn(1).setPreferredWidth(130);
            columnModel0.getColumn(2).setPreferredWidth(30);
            columnModel0.getColumn(3).setPreferredWidth(80);

            //-----------------------------------------------------------------------

            //Lets add a icon
            ImageIcon malle = new ImageIcon("Pics\\malle2.png");
            ImageIcon femalle = new ImageIcon("Pics\\femalle2.png");
            JLabel imageLabelM = new JLabel(malle);
            JLabel imageLabelF = new JLabel(femalle);
            JLabel genderImage;
            if(su.gen.equalsIgnoreCase("female"))
                genderImage = imageLabelF;
            else if(su.gen.equalsIgnoreCase("male"))
                genderImage = imageLabelM;
            else if(su.gen.equalsIgnoreCase(null))
                genderImage = imageLabelF;
            else
                genderImage = imageLabelM;

            genderImage.setBounds(50, 100, 150, 150);
            f.add(genderImage);

            /*

            // Create a custom panel for the table
            JPanel tablePanel = new JPanel(new BorderLayout());
            tablePanel.add(jt0.getTableHeader(), BorderLayout.NORTH);
            tablePanel.add(jt0, BorderLayout.CENTER);

            // Create a custom scroll bar
            JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL);
            scrollBar.addAdjustmentListener(e -> {
                int value = e.getValue();
                tablePanel.scrollRectToVisible(new Rectangle(0, value, 1, tablePanel.getHeight()));
            });

            // Add the custom scroll bar to the frame
            f.getContentPane().add(BorderLayout.EAST, scrollBar);
            f.getContentPane().add(BorderLayout.CENTER, tablePanel);

             */


            //.........................................................................................



            //List to add all the sections of each course in a jcombobox
            /*
            List<TableCellEditor> editors = new ArrayList<TableCellEditor>(corseSet.size());
            String[] currArray0 = {"Section"};
            JComboBox jbx0 = new JComboBox(currArray0);
            DefaultCellEditor dce0 = new DefaultCellEditor(jbx0);
            editors.add(dce0);

             */


            //creating the table
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("CourseCode");
            model.addColumn("CourseName");
            model.addColumn("Credit");
            model.addColumn("Section");
            model.addColumn("Faculty");
            model.addColumn("Fee");
            Object[] colData = {"No","CourseCode", "CourseName", "Credit", "Section", "Faculty", "Fee"};
            model.addRow(colData);
            JTable jt = new JTable(model);
            //final int[] count = {0};

            try
            {
                File pf = new File("AdvisingSlip\\"+su.idd +".txt");
                if(pf.exists())
                {
                    int line = 0;
                    Scanner scc = new Scanner(pf);
                    while(scc.hasNextLine())
                    {
                        scc.nextLine();
                        line++;
                    }
                    scc = new Scanner(pf);
                    for(int i = 0; i<line; i++)
                    {
                        String CurrentLine =  scc.nextLine();
                        if(i>=3 && i<line-2)
                        {
                            String[] SlipLine = CurrentLine.split("\t");
                            count[0] =  count[0] + 1;
                            totalFee[0] = totalFee[0] + Integer.valueOf(SlipLine[6]);
                   
                            model.addRow(SlipLine);


                        }
                        else
                            continue;
                    }
                    scc.close();
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

            //JLabel
                    fees = new JLabel();
            fees.setText("Total Tuition Fee = "  +  totalFee[0]);
            fees.setHorizontalAlignment(JLabel.CENTER);
            fees.setBounds(500,500,200,25);
            fees.setForeground(new Color(8, 24, 168));
            fees.setFont(new Font("Times New Roman", 1, 16));
            f.add(fees);


            JButton addButton = new JButton("ADD");
            addButton.setBounds(50, 280, 75, 22);
            addButton.setBackground(new Color(220, 20, 60));
            addButton.setForeground(Color.white);
            addButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
            f.add(addButton);

            addButton.addActionListener(e -> {

                int selectedRow = jt0.getSelectedRow();
                if (selectedRow >0)
                {
                    // Get data from the selected row in the source table
                    Object[] rowData = new Object[5];
                    rowData[0] = model0.getValueAt(selectedRow, 0);//course Code
                    rowData[1] = model0.getValueAt(selectedRow, 1);//name
                    rowData[2] = model0.getValueAt(selectedRow, 2);//section
                    rowData[3] = model0.getValueAt(selectedRow, 3);//faculty
                    rowData[4] = model0.getValueAt(selectedRow, 4);//seat

                    //first check if the course already exist on the table
                    Boolean CourseCheck = false;
                    Boolean SectionCheck = false;

                    for (int row = 1; row < model.getRowCount(); row++)
                    {
                        if (String.valueOf(model.getValueAt(row, 1)).equalsIgnoreCase(String.valueOf(rowData[0])))
                        {
                            CourseCheck = true;
                            if(String.valueOf(model.getValueAt(row, 4)).equalsIgnoreCase(String.valueOf(rowData[2])))
                            {
                                SectionCheck = true;
                                break;
                            }
                            else
                                SectionCheck = false;

                        }
                    }

                     //now the NEW COURSE ADDDing
                    if(CourseCheck== false && SectionCheck == false)
                    {
                        //Now, we will add the NEW section of the course
                        AddNewCourseWithNewSetion(model, rowData);
                    }
                    //code for section Change
                    else if(CourseCheck== true && SectionCheck == false)
                    {
                        //first, we will have to delete the existing section of the course
                        int DeleteFee = 0;

                        for (int row = 1; row < model.getRowCount(); row++)
                        {
                                String existCorseCode = String.valueOf(model.getValueAt(row, 1));
                                if(existCorseCode.equalsIgnoreCase( String.valueOf(rowData[0]) ))
                                {
                                    //deletedRowIndex = row;
                                    DeleteFee = Integer.valueOf(String.valueOf(model.getValueAt(row, 6)));
                                    model.removeRow(row);
                                    totalFee[0] = totalFee[0] - DeleteFee;
                                    break;
                                }
                        }

                        // Notify the table to update itself
                        model.fireTableDataChanged();

                        //Now, we will add the NEW section of the course
                        AddNewCourseWithNewSetion(model, rowData);

                        // Notify the table to update itself
                        model.fireTableDataChanged();

                    }
                    else if (CourseCheck== true && SectionCheck == true)
                    {
                        JOptionPane.showMessageDialog(f, "Course already added", "Duplicate Course", JOptionPane.WARNING_MESSAGE);
                    }
                }

            });


            jt.setRowHeight(0, 25);
            //setting custom width of 2 columns
            // Get the TableColumnModel and the TableColumn for the first column
            TableColumnModel columnModel = jt.getColumnModel();
            // Set the preferred width for the first column
            columnModel.getColumn(0).setPreferredWidth(40);
            columnModel.getColumn(2).setPreferredWidth(150);

            // Update the JTable's layout
            jt.revalidate();
            jt.repaint();


            //setting a color to the 1st row of the table
            // Add custom TableCellRenderer to color the first row
            jt.setDefaultRenderer(Object.class, new CustomRowColorRenderer());

            jt.setBounds(50, 320, 680, 150);
            f.add(jt);

            //JScrollPane scrollPane = new JScrollPane(jt);
            // f.getContentPane().add(scrollPane);


            // f.add(new JScrollPane(jt));

            // Create a JScrollPane to hold the JTable
            //JScrollPane scrollPane = new JScrollPane(jt);
            // Add the JScrollPane to the JFrame
            //f.add(scrollPane);




            /*
            JLabel fees = new JLabel();
            fees.setText("Total Tuition Fee = "  +  totalFee[0]);
            fees.setHorizontalAlignment(JLabel.CENTER);
            fees.setBounds(320,500,200,25);
            fees.setForeground(new Color(8, 24, 168));
            f.add(fees);

             */

            /*
            JButton sh =new JButton("Show");
            sh.setBounds(580,500,70,25);
            sh.setBackground(new Color(180, 0, 57));
            sh.setForeground(Color.white);
            sh.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
            f.add(sh);

            sh.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    //fees.setText("Total Tuition Fee = " +  totalFee[0]);
                }
            }
            );

             */


            JButton deleteButton = new JButton("DELETE");
            deleteButton.setBounds(175, 280, 90, 22);
            deleteButton.setBackground(new Color(220, 20, 60));
            deleteButton.setForeground(Color.white);
            deleteButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
            f.add(deleteButton);
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = jt.getSelectedRow();
                    int feeP = Integer.valueOf(String.valueOf(model.getValueAt(selectedRow, 6)));
                    if (selectedRow != -1) {
                        // Remove the selected row data from the DefaultTableModel
                        model.removeRow(selectedRow);
                        totalFee[0] = totalFee[0] - feeP;
                    }
                    model.fireTableDataChanged();
                    UpdateNOColumn(model);
                    model.fireTableDataChanged();
                    fees.setText("Total Tuition Fee = "  +  totalFee[0]);
                    model.fireTableDataChanged();
                }
            });


            // Create a button to save the data
            JButton saveButton = new JButton("SAVE");
            saveButton.setBounds(315, 280, 80, 22);
            saveButton.setBackground(new Color(220, 20, 60));
            saveButton.setForeground(Color.white);
            saveButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
            f.add(saveButton);
            saveButton.addActionListener(e -> {

                try {
                    File file = new File("AdvisingSlip\\"+su.idd+".txt");
                    FileWriter writer = new FileWriter(file);

                    writer.write(l1.getText() + "\t\t"+l2.getText()+ "\t\t"+l3.getText()+"\n\n");


                    // Write the data rows
                    for (int row = 0; row < model.getRowCount(); row++) {
                        for (int col = 0; col < model.getColumnCount(); col++) {
                            writer.write(model.getValueAt(row, col).toString());
                            if (col < model.getColumnCount() - 1) {
                                writer.write("\t");
                            }
                        }
                        writer.write("\n");
                    }

                    writer.write("_________________________________________________________________");
                    writer.write("\n\t\t\t\t Total Payable amount = " +totalFee[0]);

                    // Close the writer
                    writer.close();

                    JOptionPane.showMessageDialog(null, "Data saved to " + file.getAbsolutePath(), "Save Successful", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving data: " + ex.getMessage(), "Save Error", JOptionPane.ERROR_MESSAGE);
                }

            });

            RoundedCornerButton b1 = new RoundedCornerButton("logout");
            //b.setPreferredSize(new Dimension(150, 50));
            b1.setBackground(new Color(200, 0, 0));
            b1.setForeground(Color.white);
            Font customFont2 = new Font("Times New Roman", Font.BOLD, 16);
            b1.setFont(customFont2);
            b1.setBounds(50,540,80,30);
            f.add(b1);

            b1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    f. dispose();
                }
            });


            f.add(l1);
            f.add(l2);
            f.add(l3);

            f.setLayout(null);
            f.setSize(800, 650);
            f.getContentPane().setBackground(new Color(204, 204, 255));
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }

        void AddNewCourseWithNewSetion( DefaultTableModel model, Object[] rowData)
        {
            String selectedCode = "";
            String SelectedName = "";
            String SelectedCredit = "";
            String SelectedSec = "";
            String SelectedFac = "";

            try{
                File file3 = new File("CourseList3.txt");
                Scanner sc9 = new Scanner( file3);
                sc9.nextLine();
                while(sc9.hasNextLine())
                {
                    String WholeLINE = sc9.nextLine();
                    String[] LINEArray = WholeLINE.split("\t");

                    if (String.valueOf(rowData[0]).equalsIgnoreCase(LINEArray[0])  &&
                            String.valueOf(rowData[2]).equalsIgnoreCase(LINEArray[3]) )
                    {
                        selectedCode =LINEArray[0];
                        SelectedName = LINEArray[1];
                        SelectedCredit = LINEArray[2];
                        SelectedSec = LINEArray[3];
                        SelectedFac = LINEArray[4];
                        break;
                    }

                }
                sc9.close();


            }
            catch(IOException e5)
            {
                e5.printStackTrace();
            }

            int bill = Integer.valueOf(SelectedCredit) * 6500; //6500 is the fee per credit
            totalFee[0] = totalFee[0] + bill;
            count[0] = count[0] + 1;

            Object[] rowData1 = {String.valueOf(count[0]), selectedCode, SelectedName,SelectedCredit, SelectedSec,SelectedFac, String.valueOf(bill)};


            // Add the new row data to the DefaultTableModel
            model.addRow(rowData1);

            model.fireTableDataChanged();

            UpdateNOColumn(model);
            model.fireTableDataChanged();
            fees.setText("Total Tuition Fee = "  +  totalFee[0]);
            model.fireTableDataChanged();

        }

        //updating the "NO" column
        void UpdateNOColumn(DefaultTableModel model)
        {
            for (int row = 1; row < model.getRowCount(); row++) {
                model.setValueAt(row, row, 0);
            }
        }



        // Custom TableCellRenderer to color the first row
        static class CustomRowColorRenderer extends DefaultTableCellRenderer {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component component;
                component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (isSelected && row != 0) {
                    component.setBackground(new Color(255, 36, 0));
                }
                else
                {
                    if (row == 0) {
                        component.setBackground(new Color(173, 255, 47));
                    }
                    else if (row % 2 == 0) {
                        component.setBackground(new Color(193, 225, 193));
                    } else {
                        component.setBackground(Color.WHITE);
                    }
                }

                return component;
            }
        }

    static class CustomRowColorRenderer0 extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component;
            component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (isSelected && row != 0) {
                component.setBackground(new Color(255, 36, 0));
            } else {
                if (row == 0) {
                    component.setBackground(new Color(255, 170, 51));
                } else if (row % 2 == 0) {
                    component.setBackground(new Color(230, 230, 250));
                } else {
                    component.setBackground(Color.WHITE);
                }
            }
            return component;
        }
    }

    private static void clearTable(DefaultTableModel model) {
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }


        public static void main(String[] args) {
            advisingPanel m = new advisingPanel();

        }

    }
