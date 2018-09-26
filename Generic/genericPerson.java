package core.Generic;

import core.CoursesPack.Courses;
import core.CoursesPack.Duties;
import core.InterfacesPack.GenericFunctionsInterface;
import core.personPack.EmployeePack.Employee;
import core.personPack.EmployeePack.Faculty;
import core.personPack.EmployeePack.Staff;
import core.personPack.Person;
import core.personPack.StudentPack.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//Needs to be rewritten again.
public class genericPerson implements GenericFunctionsInterface{

    private List<Student> studentList = new ArrayList<>();

    //Rewrite as a single Person list later
    //Methods should be able to figure out which on is which.
    //private List<Employee> employeeList = new ArrayList<>();
    private List<Faculty> facultyList = new ArrayList<>();
    private List<Staff> staffList = new ArrayList<>();

    private final Scanner kb = new Scanner(System.in);
    private String userInputChoice_str="";

    public genericPerson() {
        //runObject();
    }

    public void runObject(){//Refactor later

        do{
            System.out.println("1) Create \t 2) Remove \t 3) Update \t 4) Display \t 5) Purge Everything \t 6) Type 'Done' to quit ");
            System.out.print("Input: ");
            try{
                getUserInput();
            }catch (Exception e){
                continue;
            }

            switch (userInputChoice_str){
                case "1"://Create
                    do{
                        System.out.println("Create: 1) Faculty \t 2) Staff \t 3) Student \t 4) Type 'back' to return to previous");
                        System.out.print("Input: ");
                        try{
                            getUserInput();
                        }catch (Exception e){
                            //continue;
                        }

                        String fname,lname,deptName,eID;
                        //Might need this
                        // fname=lname=deptName=eID="";

                        switch (userInputChoice_str){
                            case "1"://Faculty

                                System.out.print("Enter first name: "); getUserInput(); fname = userInputChoice_str;

                                System.out.print("Enter last name: "); getUserInput(); lname = userInputChoice_str;

                                System.out.print("Enter department name: "); getUserInput(); deptName = userInputChoice_str;

                                System.out.print("Enter ID: "); getUserInput(); eID = userInputChoice_str;

                                Faculty tempF = new Faculty(fname,lname,deptName,eID);
                                addEditCourse(tempF,true);

                                facultyList.add(tempF);
                                break;
                            case "2"://Staff

                                System.out.print("Enter first name: "); getUserInput(); fname = userInputChoice_str;

                                System.out.print("Enter last name: "); getUserInput(); lname = userInputChoice_str;

                                System.out.print("Enter department name: "); getUserInput(); deptName = userInputChoice_str;

                                System.out.print("Enter ID: "); getUserInput(); eID = userInputChoice_str;

                                Staff tempSF = new Staff(fname,lname,deptName,eID);

                                addEditDuties(tempSF,true);

                                staffList.add(tempSF);


                                break;
                            case "3"://Student

                                System.out.print("Enter first name: "); getUserInput(); fname = userInputChoice_str;

                                System.out.print("Enter last name: "); getUserInput(); lname = userInputChoice_str;

                                System.out.print("Enter ID: "); getUserInput(); eID = userInputChoice_str;

                                System.out.print("Enter matriculantStatus: "); char matriculantStatus = setmatriculantStatus_outside();

                                Student tempSTD = new Student(fname,lname,eID);
                                tempSTD.setMatriculantStatus(matriculantStatus);
                                addEditCourse(tempSTD,true);

                                studentList.add(tempSTD);
                                break;

                            case "4"://Back
                                userInputChoice_str = "back";
                                break;
                            case "back"://Redundant
                                userInputChoice_str = "back";
                                break;
                            default:
                                break;
                        }
                    }while(!userInputChoice_str.toLowerCase().equals("back"));

                    break;
                case "2"://Remove records
                    do{
                        System.out.println("Remove: 1) Faculty \t 2) Staff \t 3) Student \t 4) Type 'back' to return to previous");
                        System.out.print("Input: ");
                        try{
                            getUserInput();
                        }catch (Exception e){
                            //continue;
                        }
                        String fname;
                        switch (userInputChoice_str){
                            case "1"://Faculty

                                System.out.print("Search using first name: "); getUserInput(); fname = userInputChoice_str.toLowerCase();
                                int ctr = -1;
                                for(Faculty f:facultyList){

                                    if(f.getFirstName().toLowerCase().equals(fname)){
                                        ctr++;
                                        break;//found
                                    }
                                    ctr++;
                                }
                                if(ctr >= 0)
                                    facultyList.remove(ctr);
                                else
                                    System.out.print("Entry not found!");
                                break;

                            case "2"://Staff

                                System.out.print("Search using first name: "); getUserInput(); fname = userInputChoice_str.toLowerCase();
                                ctr = -1;

                                for(Staff s :staffList){

                                    if(s.getFirstName().toLowerCase().equals(fname)){
                                        ctr++;
                                        break;//found
                                    }
                                    ctr++;
                                }
                                if(ctr >= 0)
                                    staffList.remove(ctr);
                                else
                                    System.out.print("Entry not found!");
                                break;

                            case "3"://Student

                                System.out.print("Search using first name: "); getUserInput(); fname = userInputChoice_str.toLowerCase();
                                ctr = -1;

                                for(Student s :studentList){

                                    if(s.getFirstName().toLowerCase().equals(fname)){
                                        ctr++;
                                        break;//found
                                    }
                                    ctr++;
                                }
                                if(ctr >= 0)
                                    studentList.remove(ctr);
                                else
                                    System.out.print("Entry not found!");
                                break;

                            case "4"://Back
                                userInputChoice_str = "back";
                                break;
                            case "back"://Redundant
                                userInputChoice_str = "back";
                                break;
                            default:
                                break;
                        }

                    }while(!userInputChoice_str.toLowerCase().equals("back"));

                    break;

                case "3": //Update
                    do{

                        System.out.println("Update: 1) Faculty \t 2) Staff \t 3) Student \t 4) Type 'back' to return to previous");
                        System.out.print("Input: ");
                        try{
                            getUserInput();
                        }catch (Exception e){
                            //continue;
                        }

                        String fname,lname,eID;
                        switch (userInputChoice_str){

                            case "1"://faculty
                                System.out.println("Update Faculty --- 1) First name \t 2) Last name \t 3) eID \t 4) Edit courses  \t 5) Add courses \t 6) Type 'back' to return to previous");
                                System.out.print("Input: ");
                                getUserInput();

                                switch (userInputChoice_str){
                                    case "1"://First Name

                                        System.out.print("Search using first name: "); getUserInput(); fname = userInputChoice_str.toLowerCase();
                                        boolean isfound = false;

                                        for(Faculty f:facultyList){

                                            if(f.getFirstName().toLowerCase().equals(fname)){
                                                System.out.print("Set new first name: ");
                                                getUserInput(); fname = userInputChoice_str;
                                                f.setFirstName(fname);
                                                isfound = true;
                                                break;//found
                                            }

                                        }
                                        if(!isfound)
                                            System.out.print("Entry not found!");

                                        break;
                                    case "2"://LastName

                                        System.out.print("Search using last name: "); getUserInput(); lname = userInputChoice_str.toLowerCase();
                                        isfound = false;

                                        for(Faculty f:facultyList){

                                            if(f.getLastName().toLowerCase().equals(lname)){
                                                System.out.print("Set new last name: ");
                                                getUserInput(); lname = userInputChoice_str;
                                                f.setLastName(lname);
                                                isfound = true;
                                                break;//found
                                            }
                                        }
                                        if(!isfound)
                                            System.out.print("Entry not found!");
                                        break;

                                    case "3"://eID

                                        System.out.print("Search using eID: "); getUserInput(); eID = userInputChoice_str.toLowerCase();
                                        isfound = false;

                                        for(Faculty f:facultyList){

                                            if(f.getLastName().toLowerCase().equals(eID)){
                                                System.out.print("Set new eID: ");
                                                getUserInput(); eID = userInputChoice_str;
                                                f.seteID(eID);
                                                isfound = true;
                                                break;//found
                                            }
                                        }
                                        if(!isfound)
                                            System.out.print("Entry not found!");
                                        break;

                                    case "4"://Course Edit

                                        System.out.print("Search using first name: "); getUserInput(); fname = userInputChoice_str.toLowerCase();
                                        isfound = false;

                                        for(Faculty f:facultyList){

                                            if(f.getFirstName().toLowerCase().equals(fname)){
                                                addEditCourse(f,false);//False to edit
                                                isfound = true;
                                                break;//found
                                            }
                                        }
                                        if(!isfound)
                                            System.out.print("Entry not found!");
                                        break;

                                    case "5"://Course add

                                        System.out.print("Search using first name: "); getUserInput(); fname = userInputChoice_str.toLowerCase();
                                        isfound = false;

                                        for(Faculty f:facultyList){

                                            if(f.getFirstName().toLowerCase().equals(fname)){
                                                addEditCourse(f,true);//False to edit
                                                isfound = true;
                                                break;//found
                                            }
                                        }
                                        if(!isfound)
                                            System.out.print("Entry not found!");
                                        break;

                                    case "6"://Back
                                        userInputChoice_str = "back";
                                        break;
                                    case "back"://Redundant
                                        userInputChoice_str = "back";
                                        break;
                                    default:
                                        break;
                                }

                                break;
                            case "2"://Staff

                                System.out.println("Update Staff --- 1) First name \t 2) Last name \t 3) eID \t 4) Edit duties \t 5) Add Duties 6) Type 'back' to return to previous");
                                System.out.print("Input: ");
                                getUserInput();

                                switch (userInputChoice_str){
                                    case "1"://First Name

                                        System.out.print("Search using first name: "); getUserInput(); fname = userInputChoice_str.toLowerCase();
                                        boolean isfound = false;

                                        for(Staff f:staffList){

                                            if(f.getFirstName().toLowerCase().equals(fname)){
                                                System.out.print("Set new first name: ");
                                                getUserInput(); fname = userInputChoice_str;
                                                f.setFirstName(fname);
                                                isfound = true;
                                                break;//found
                                            }

                                        }
                                        if(!isfound)
                                            System.out.print("Entry not found!");

                                        break;
                                    case "2"://LastName

                                        System.out.print("Search using last name: "); getUserInput(); lname = userInputChoice_str.toLowerCase();
                                        isfound = false;

                                        for(Staff f:staffList){

                                            if(f.getLastName().toLowerCase().equals(lname)){
                                                System.out.print("Set new last name: ");
                                                getUserInput(); lname = userInputChoice_str;
                                                f.setLastName(lname);
                                                isfound = true;
                                                break;//found
                                            }
                                        }
                                        if(!isfound)
                                            System.out.print("Entry not found!");
                                        break;

                                    case "3"://eID

                                        System.out.print("Search using eID: "); getUserInput(); eID = userInputChoice_str.toLowerCase();
                                        isfound = false;

                                        for(Staff f:staffList){

                                            if(f.getLastName().toLowerCase().equals(eID)){
                                                System.out.print("Set new eID: ");
                                                getUserInput(); eID = userInputChoice_str;
                                                f.seteID(eID);
                                                isfound = true;
                                                break;//found
                                            }
                                        }
                                        if(!isfound)
                                            System.out.print("Entry not found!");
                                        break;

                                    case "4"://Duties Edit

                                        System.out.print("Search using first name: "); getUserInput(); fname = userInputChoice_str.toLowerCase();
                                        isfound = false;

                                        for(Staff f:staffList){

                                            if(f.getFirstName().toLowerCase().equals(fname)){
                                                addEditDuties(f,false);//False to edit
                                                isfound = true;
                                                break;//found
                                            }
                                        }
                                        if(!isfound)
                                            System.out.print("Entry not found!");
                                        break;

                                    case "5"://add duties

                                        System.out.print("Search using first name: "); getUserInput(); fname = userInputChoice_str.toLowerCase();
                                        isfound = false;

                                        for(Staff f:staffList){

                                            if(f.getFirstName().toLowerCase().equals(fname)){
                                                addEditDuties(f,true);//False to edit
                                                isfound = true;
                                                break;//found
                                            }
                                        }
                                        if(!isfound)
                                            System.out.print("Entry not found!");
                                        break;

                                    case "6"://Back
                                        userInputChoice_str = "back";
                                        break;
                                    case "back"://Redundant
                                        userInputChoice_str = "back";
                                        break;
                                    default:
                                        break;
                                }

                                break;
                            case "3"://Student
                                System.out.println("Update Student --- 1) First name \t 2) Last name \t 3) eID \t 4) change courses  \t 5) change courses \t 6) Type 'back' to return to previous");
                                System.out.print("Input: ");
                                getUserInput();

                                switch (userInputChoice_str){
                                    case "1"://First Name

                                        System.out.print("Search using first name: "); getUserInput(); fname = userInputChoice_str.toLowerCase();
                                        boolean isfound = false;

                                        for(Student f:studentList){

                                            if(f.getFirstName().toLowerCase().equals(fname)){
                                                System.out.print("Set new first name: ");
                                                getUserInput(); fname = userInputChoice_str;
                                                f.setFirstName(fname);
                                                isfound = true;
                                                break;//found
                                            }

                                        }
                                        if(!isfound)
                                            System.out.print("Entry not found!");

                                        break;
                                    case "2"://LastName

                                        System.out.print("Search using last name: "); getUserInput(); lname = userInputChoice_str.toLowerCase();
                                        isfound = false;

                                        for(Student f:studentList){

                                            if(f.getLastName().toLowerCase().equals(lname)){
                                                System.out.print("Set new last name: ");
                                                getUserInput(); lname = userInputChoice_str;
                                                f.setLastName(lname);
                                                isfound = true;
                                                break;//found
                                            }
                                        }
                                        if(!isfound)
                                            System.out.print("Entry not found!");
                                        break;

                                    case "3"://sID

                                        System.out.print("Search using eID: "); getUserInput(); eID = userInputChoice_str.toLowerCase();//sID just reusing the variable
                                        isfound = false;

                                        for(Student f:studentList){

                                            if(f.getLastName().toLowerCase().equals(eID)){
                                                System.out.print("Set new eID: ");
                                                getUserInput(); eID = userInputChoice_str;
                                                f.setsID(eID);
                                                isfound = true;
                                                break;//found
                                            }
                                        }
                                        if(!isfound)
                                            System.out.print("Entry not found!");
                                        break;

                                    case "4"://Course edit

                                        System.out.print("Search using first name: "); getUserInput(); fname = userInputChoice_str.toLowerCase();
                                        isfound = false;

                                        for(Student f:studentList){

                                            if(f.getFirstName().toLowerCase().equals(fname)){
                                                addEditCourse(f,false);//False to edit
                                                isfound = true;
                                                break;//found
                                            }
                                        }
                                        if(!isfound)
                                            System.out.print("Entry not found!");
                                        break;

                                    case "5"://add course

                                        System.out.print("Search using first name: "); getUserInput(); fname = userInputChoice_str.toLowerCase();
                                        isfound = false;

                                        for(Student f:studentList){

                                            if(f.getFirstName().toLowerCase().equals(fname)){
                                                addEditCourse(f,true);//False to edit
                                                isfound = true;
                                                break;//found
                                            }
                                        }
                                        if(!isfound)
                                            System.out.print("Entry not found!");
                                        break;

                                    case "6"://Back
                                        userInputChoice_str = "back";
                                        break;
                                    case "back"://Redundant
                                        userInputChoice_str = "back";
                                        break;
                                    default:
                                        break;
                                }
                                break;

                            case "5"://Back
                                userInputChoice_str = "back";
                                break;
                            case "back"://Redundant
                                userInputChoice_str = "back";
                                break;
                        }

                    }while(!userInputChoice_str.toLowerCase().equals("back"));

                    break;

                case "4"://Display
                    displayAll();
                    break;
                case "5":

                    try {
                        purgeEVERYTHING();
                    }catch (Exception e){
                        //keep it running
                        //
                    }

                    break;

                case "6"://Redundant
                    userInputChoice_str = "done";
                    break;
                case "done"://Redundant
                    break;

                default:
                    System.out.println("Invalid Input!");
                    break;

            }
        }while (!userInputChoice_str.toLowerCase().equals("done"));
        System.out.println("BYE!");

        displayAll();
    }

    //Being lazy
    private void getUserInput(){
        try{
            userInputChoice_str = kb.next();//kb.nextLine();//Rewrite this
            userInputChoice_str = userInputChoice_str.toLowerCase();

        }catch (Exception e){
            //System.out.println(e);
            //System.out.println("Debug Input " + userInputChoice_str);
        }
    }

    @Override
    public boolean changefName(Object o) { //If you're a person then you can chage

        if(o instanceof Person){
            ((Person)o).setFirstName(kb.next());
            kb.nextLine();

            return true;//Success
        }

        return false;
    }

    @Override
    public boolean changelName(Object o) {

        if(o instanceof Person){
            ((Person)o).setLastName(kb.next());
            kb.nextLine();

            return true;//Success
        }

        return false;
    }


    @Override
    public boolean addEditCourse(Object o, boolean changeType) {
        //bool changeType
        //true, add
        //false,change

        Courses tempC;

        if(o instanceof Faculty && ((Faculty)o).getClass().equals(Faculty.class)){

            if(changeType) {//Add
                System.out.println("What course do you want to Add? ");
                tempC = new Courses();
            }
            else{//Edit
                System.out.println("What course do you want to change? ");
                System.out.print("Enter Course Name: ");
                String tempSTR = kb.next(); kb.nextLine(); // Find course by name

                tempC = ((Faculty)o).getFacultyCourses(tempSTR);
            }
            //Check for null; Course not found ; Edit mode
            //using kb.next() directly without input checking is unsafe
            //Edit later
            if(tempC != null) {
                System.out.print("Enter course Name: ");
                tempC.setCourseName(kb.next());
                kb.nextLine();

                System.out.print("Enter professor's name: ");
                tempC.setProffName(kb.next());
                kb.nextLine();

                System.out.print("Enter credit worth: ");

                int temp_creditWorth = inputCreditWorth();
                tempC.setCreditWorth(temp_creditWorth);

            }
            else
                return false;//Course not found on Edit mode

            //Add to list on Add-Mode
            if(changeType)
                ((Faculty)o).setFacultyCourses(tempC);

            return true;

        }else if(o instanceof Student && ((Student)o).getClass().equals(Student.class)){

            if(changeType) {
                System.out.println("What course do you want to Add? ");
                tempC = new Courses();
            }
            else{
                System.out.println("What course do you want to change? ");
                System.out.print("Enter Course Name: ");
                String tempSTR = kb.next(); kb.nextLine();

                tempC = ((Student)o).getStudentCourses(tempSTR);
            }

            if(tempC != null) {
                String courseStudentCheck;
                boolean isSuccess = false;

                do{
                    System.out.print("Enter course Name: ");
                    courseStudentCheck = kb.next(); kb.nextLine();

                    if(courseStudentCheck.charAt(0) == ((Student)o).getMatriculantStatus())
                        isSuccess = true;
                    else{
                        System.out.println("You're not allowed to register for this course:  " + courseStudentCheck);
                    }
                }while (!isSuccess);
                tempC.setCourseName(courseStudentCheck);

                System.out.print("Enter professor's name: ");
                tempC.setProffName(kb.next());
                kb.nextLine();

                System.out.print("Enter credit worth: ");

                int temp_creditWorth = inputCreditWorth();

                tempC.setCreditWorth(temp_creditWorth);

            }
            else
                return false;//Only null if it doesn't exist

            if(changeType)
                ((Student)o).setStudentCourses(tempC);

            return true;
        }
        return false;
    }

    private int inputCreditWorth() {
        int credits =-1;
        boolean iscorrectInput = false;
        do{

            try{
                credits = Integer.parseInt(kb.nextLine());
                if(credits <=4 && credits>=1)
                    iscorrectInput = true;

            }catch (Exception e){
                //Write
                //a better code than forcing it to continue running

            }
        }while(!iscorrectInput);

        return credits;
    }

    @Override
    public void removeCourse(Object o) {

        System.out.println("What course do you want to remove?");
        System.out.print("Enter Course Name: ");
        String tempSTR = kb.next(); kb.nextLine();

        if(o instanceof Faculty && ((Faculty)o).getClass().equals(Faculty.class)){


            if(((Faculty)o).removeFacultyCourses(tempSTR)){
                System.out.println("Faculty Course Removed!");
            }
            else {
                System.out.println("Invalid Input");
            }

        }
        else if (o instanceof Student && ((Student)o).getClass().equals(Student.class)){

            if(((Student)o).removeStudentCourses(tempSTR)){

                System.out.println("Student Course Removed!");

            }
            else {
                System.out.println("Invalid Input");
            }
        }

    }

    @Override
    public boolean addEditDuties(Object o, boolean changeType) {
        //bool changeType
        //true, add
        //false, change

        if(o instanceof Staff && ((Staff)o).getClass().equals(Staff.class)){

            Duties tempD;
            String tempSTR_DName;

            if(!changeType){
                System.out.println("What duty do you want to edit?");
            }else
                System.out.println("What duty do you want to Add?");

            System.out.print("Enter duty Name: ");
            tempSTR_DName = kb.next(); kb.nextLine();

            if(changeType){
                tempD = new Duties(tempSTR_DName);
                ((Staff)o).setStaffDuties(tempD);
                return true;

            }else {

                tempD = ((Staff)o).getStaffDuties(tempSTR_DName);
                if(tempD != null)
                    tempD.setDutyName(tempSTR_DName);
                return true;
            }
        }
        else {
            System.out.println("Invalid Input");
        }
        return false;
    }

    @Override
    public boolean removeDuties(Object o){
        System.out.println("What duty do you want to remove?");
        System.out.print("Enter duty name: ");
        String tempSTR = kb.next(); kb.nextLine();

        if(o instanceof Staff && ((Staff)o).getClass().equals(Staff.class)){

            if(((Staff)o).removeStaffDuties(tempSTR)){

                System.out.print("Staff duties removed!");
                return true;
            }
            else {
                System.out.print("Invalid Input");
            }
            return false;
        }
        return false;
    }

    @Override
    public void display() {

    }

    @Override
    public void displayAll() {
        List<Person> tempPersonHolder = new ArrayList<>();
        tempPersonHolder.addAll(facultyList);
        tempPersonHolder.addAll(staffList);
        tempPersonHolder.addAll(studentList);

        for (Person o : tempPersonHolder) {
            System.out.println();

            if (o instanceof Faculty && ((Faculty) o).getClass().equals(Faculty.class)) {
                System.out.print("First name: " + o.getFirstName() + "\tLast name: " + o.getLastName());
                System.out.print("\t ID: " + ((Faculty)o).geteID());

                System.out.println();
                System.out.println("List courses: ");
                for(Courses c: ((Faculty)o).getFacultyCourses()){
                    System.out.print(c.getCourseName()+ " , ");
                }
                System.out.println();
            } else if (o instanceof Staff && ((Staff) o).getClass().equals(Staff.class)) {

                System.out.print("First name: " + o.getFirstName() + "\tLast name: " + o.getLastName());
                System.out.print("\t ID: " + ((Staff)o).geteID());

                System.out.println();
                System.out.println("List courses: ");
                for(Duties d: ((Staff)o).getStaffDuties()){
                    System.out.print(d.getDutyName()+ " , ");
                }
                System.out.println();

            } else if (o instanceof Student && ((Student) o).getClass().equals(Student.class)) {

                System.out.print("First name: " + o.getFirstName() + "\tLast name: " + o.getLastName() + "\nStatus: " + ((Student) o).getMatriculantStatus() + "\t ID: " + ((Student)o).getsID());

                System.out.println();
                System.out.println("List courses: ");
                for(Courses s: ((Student)o).getStudentCourses()){
                    System.out.print(s.getCourseName()+ " , ");
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    @Override
    public boolean setID(Object o) {

        if(o instanceof Employee){
            ((Employee)o).seteID(kb.next());
            kb.nextLine();
            return true;//Success
        }
        else{
            ((Student)o).setsID(kb.next());
            return true;
        }
    }

    @Override
    public char setmatriculantStatus_outside() {

        System.out.println("Set student status");
        System.out.println("Enter 'U' for undergraduate and 'G' for graduate'");
        char tempChr;
        boolean isInputCorrect = false;

        do{
            System.out.print("Input: ");
            tempChr = kb.next().charAt(0);
            tempChr = Character.toLowerCase(tempChr);
            if ((tempChr != 'u') &&  (tempChr != 'g'))
                System.out.println("Invalid input! ");
            else
                isInputCorrect = true;

        }while (!isInputCorrect);

        //System.out.println("Debug:     "+ tempChr);
        return tempChr;
    }


    private void purgeEVERYTHING(){
        studentList.clear();
        facultyList.clear();
        //employeeList.clear();
        staffList.clear();
    }

}
