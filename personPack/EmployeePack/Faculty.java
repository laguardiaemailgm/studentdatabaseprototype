package core.personPack.EmployeePack;

import core.CoursesPack.Courses;

import java.util.ArrayList;
import java.util.List;


public class Faculty extends Employee{

    //
    private static final byte MAX_NUMBER_OF_COURSES = 6;

    private List<Courses> facultyCourses = new ArrayList<>();

    public Faculty(){

    }
    public Faculty(String fname, String lname, String deptName, String eID) {
        super(fname, lname, deptName, eID);

    }

    public Faculty(String fname, String lname, String deptName, String eID, List<Courses> facultyCourses) {

        super(fname, lname, deptName, eID);
        this.facultyCourses.addAll(facultyCourses);

    }

    public List<Courses> getFacultyCourses() {
        return facultyCourses;
    }

    //Returns null if course isn't part of the list
    public Courses getFacultyCourses(String CourseName) {


        // Debug begin
        // this.facultyCourses.add(new Courses());
        // Debug end

        int index = findFacultyCourses(CourseName);

        if(index >= 0){
            return facultyCourses.get(index);
        }
        else
            return null; //The receiver will throw an exception

    }

    //return int index
    private int findFacultyCourses(String CourseName){ //Needs to be rewritten to be more efficient
        int index = 0;
            for(Courses tempC:facultyCourses){

                if(tempC.getCourseName().toLowerCase().equals(CourseName.toLowerCase()))
                    return index;
            }
        return -1;//Return -1 if not found

    }

    public boolean removeFacultyCourses(String CourseName){

        int index = findFacultyCourses(CourseName);

        if(index >= 0){
            facultyCourses.remove(index);
            return true;
        }
        else
            return false;

    }

    public void setFacultyCourses(List<Courses> facultyCourses) {
        this.facultyCourses.addAll(facultyCourses);
    }

    //Set Single course
    public void setFacultyCourses(Courses facultyCourses) {
        this.facultyCourses.add(facultyCourses);
    }

}
