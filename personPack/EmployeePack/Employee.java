package core.personPack.EmployeePack;

import core.personPack.Person;


public class Employee extends Person{
    private String deptName;
    private String eID;

    public Employee(String fname, String lname) {

        super(fname,lname);
    }

    public Employee(){

    }

    public Employee(String fname, String lname, String deptName, String eID) {

        super(fname,lname);

        this.deptName = deptName;
        this.eID = eID;
    }


    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String geteID() {
        return eID;
    }

    public void seteID(String eID) {
        this.eID = eID;
    }

}
