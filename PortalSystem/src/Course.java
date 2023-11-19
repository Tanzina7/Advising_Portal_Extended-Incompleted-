public class Course {
    private String Name;
    private String Code, faculty;
    private int credit;
    private int Total_section, seat;
    Course(){}
    Course(String Code, String Name, int credit)
    {
        this.Code = Code;
        this.Name = Name;
        this.credit = credit;

    }
    Course(String Code, String Name, int credit, int Total_section)
    {
        this.Code = Code;
       this.Name = Name;
       this.credit = credit;
       this.Total_section = Total_section;

    }

    Course(String Code, String Name, int credit, int Total_section, String faculty, int seat)
    {
        this.Code = Code;
        this.Name = Name;
        this.credit = credit;
        this.Total_section = Total_section;
        this.faculty = faculty;
        this.seat= seat;
    }

    public String getCode() {
        return Code;
    }

    public String getName() {
        return Name;
    }
    public int getCredit() {
        return credit;
    }

    public void setTotal_section(int total_section) {
        Total_section = total_section;
    }

    public int getTotal_section() {
        return Total_section;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getSeat() {
        return seat;
    }

    @Override
    public String toString() {
        return Code + "\t" +Name  + "\t" + credit + "\t" + Total_section + "\t" + faculty+ "\t" + seat+ "\n" ;
    }
}
