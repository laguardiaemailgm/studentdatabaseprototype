package core.CoursesPack;

public class Courses {

    private String courseName;
    private String proffName;
    private int creditWorth;

    public Courses() {

        //courseName ="Math";
        //proffName = "Bears";
        //creditWorth = 4;
        //Debug

    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getProffName() {
        return proffName;
    }

    public void setProffName(String proffName) {
        this.proffName = proffName;
    }

    public int getCreditWorth() {
        return this.creditWorth;
    }

    public void setCreditWorth(int creditWorth) {
        this.creditWorth = creditWorth;
    }
}
