import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Rough {
    public static void main(String[] args) throws IOException {

        /*
        Course[] arrO = new Course[12];
        arrO[0] = new Course("CSE115", "C_programming", 4, 12);
        arrO[1] = new Course("CSE215", "Java", 4, 9);
        arrO[2] = new Course("CSE225", "Data_Structure", 3, 7);
        arrO[3] = new Course("CSE231", "DLD", 3, 6);
        arrO[4] = new Course("CSE311", "DBMS", 3, 5);
        arrO[5] = new Course("CSE373", "Algorithm", 3, 5);
        arrO[6] = new Course("CSE331", "Microprocessor", 3, 6);
        arrO[7] = new Course("CSE332", "Compter_Architecure", 3, 5);
        arrO[8] = new Course("CSE440", "AI", 3, 2);
        arrO[9] = new Course("CSE445", "ML", 3, 3);
        arrO[10] = new Course("CSE465", "Neural Network", 3, 3);
        arrO[11] = new Course("EEE154", "AutoCaD", 1, 8);

        File f = new File("CourseList.txt");
        FileWriter fw = new FileWriter(f);

        for(int i = 0; i< arrO.length; i++)
        {
            fw.write(arrO[i].toString());
            System.out.println(arrO[i].toString());
        }

        fw.close();



         */

        /*
        FileWriter fw = new FileWriter("adminInfo.txt");
        fw.write("ID\tNAME\tPASSWORD\n" +
                "16201\tTanzina\t123\n" +
                "194142\tMahadi\t23456");
        fw.close();
    */
        File fl = new File("CourseList2.txt");

        Scanner sc = new Scanner(fl);
        int line = 0;
        while(sc.hasNextLine())
        {
            sc.nextLine();
            line++;
        }
        Course[] arr = new Course[line];
        sc = new Scanner(fl);
        int i = 0;
        while (sc.hasNextLine()) {
            String WHoleLine = sc.nextLine();
            String[] LineArray = WHoleLine.split("\t");

            String id1 = LineArray[0];
            String name1 = LineArray[1];
            int crd = Integer.valueOf(LineArray[2]);
            int sec = Integer.valueOf(LineArray[3]);
            arr[i] = new Course(id1, name1, crd, sec, "TBA", 40);
            i++;
        }
        FileWriter fw = new FileWriter("CourseList3.txt", true);

        fw.write("CODE\tNAME\tCREDIT\tSECTION\tFACULTY\tSEAT\n");
        for(int j= 0; j<line; j++)
        {
            //Course cr = new Course(t1.getText().toUpperCase(), t2.getText(), Integer.valueOf(t3.getText()), i+1);
            fw.write(arr[j].toString());
        }
        fw.close();




    }
}
