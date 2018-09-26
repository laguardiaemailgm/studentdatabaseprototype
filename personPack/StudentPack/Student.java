package core.personPack.StudentPack;

import core.CoursesPack.Courses;
import core.personPack.Person;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    private String sID;
    private char matriculantStatus;
    private static final byte MAX_NUMBER_OF_COURSES = 6;

    private List<Courses> studentCourses = new ArrayList<>();

    public Student() {

    }

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Student(String firstName, String lastName, String sID) {
        super(firstName, lastName);
        this.sID = sID;
    }

    public Student(String fname, String lname, String sID, List<Courses> studentCourses) {
        super(fname, lname);
        this.sID = sID;
        this.studentCourses.addAll(studentCourses);
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public char getMatriculantStatus() {
        return matriculantStatus;
    }

    public void setMatriculantStatus(char matriculantStatus) {
        this.matriculantStatus = matriculantStatus;
    }

    public List<Courses> getStudentCourses() {
        return studentCourses;
    }

    //Returns null if course isn't part of the list
    public Courses getStudentCourses(String CourseName) {

        // Debug begin
        // this.facultyCourses.add(new Courses());
        // Debug end
        int index = findStudentCourses(CourseName);

        if(index >= 0){
            return studentCourses.get(index);
        }
        else
            return null;//The receiver will throw an exception

    }

    //return int index
    private int findStudentCourses(String CourseName){
        int index = 0;
        for(Courses tempC:studentCourses){

            if(tempC.getCourseName().toLowerCase().equals(CourseName.toLowerCase()))
                return index;
        }
        return -1;//Return -1 if not found

    }

    public boolean removeStudentCourses(String CourseName){

        int index = findStudentCourses(CourseName);

        if(index >= 0){
            studentCourses.remove(index);
            return true;
        }
        else
            return false;

    }
    public void setStudentCourses(List<Courses> studentCourses) {
        this.studentCourses.addAll(studentCourses);
    }
    public void setStudentCourses(Courses studentCourses) {
        this.studentCourses.add(studentCourses);
    }


    public static byte getMaxNumberOfCourses() {
        return MAX_NUMBER_OF_COURSES;
    }

}
