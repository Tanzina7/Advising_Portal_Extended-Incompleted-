import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Teacher extends  adminPanel{
    private String initial, password;
    private Person p;
    private String dept, designaton, phone, email;
    private ArrayList<Course> courseArrayList = new ArrayList<Course>();
    //private ArrayList<Str> courseNameList = new ArrayList<Course>();
    public Teacher()
    {



    }
    public Teacher(String name, String initial, String password,  String dept, String designaton, String phone, String  email)
    {
        p = new Person();
        p.setName(name);
        this.initial = initial;
        this.password = password;
        this.dept = dept;
        this.designaton = designaton;
        this.phone = phone;
        this.email = email;

    }

    public void setCourseArrayList(ArrayList<Course> courseArrayList) {
        this.courseArrayList = courseArrayList;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setDesignaton(String designaton) {
        this.designaton = designaton;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Course> getCourseArrayList() {
        return courseArrayList;
    }

    public Person getP() {
        return p;
    }

    public String getDept() {
        return dept;
    }

    public String getDesignaton() {
        return designaton;
    }

    public String getEmail() {
        return email;
    }

    public String getInitial() {
        return initial;
    }

    public String getPhone() {
        return phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return p.getName()+ "\t" + initial + "\t" + password + "\t" + dept + "\t" + designaton + "\t" +
                 phone + "\t" + email + "\n";
    }

    public void viewFacultyCourseList() throws IOException
    {
        File fl = new File("CourseList3.txt");
        Scanner sc = new Scanner(fl);

        while (sc.hasNextLine())
        {
            String WHoleLine = sc.nextLine();
            String[] LineArray = WHoleLine.split("\t");

            String id1 = LineArray[0];
            String name1 = LineArray[1];
            int crd = Integer.valueOf(LineArray[2]);
            int sec = Integer.valueOf(LineArray[3]);
            String fac = LineArray[4];
            int seat = Integer.valueOf(LineArray[5]);
            if(fac.equalsIgnoreCase(this.initial))
            {
                Course c = new Course(id1, name1, crd, sec, fac, seat);
                courseArrayList.add(c);
            }
        }

        System.out.println(courseArrayList);

    }
}
