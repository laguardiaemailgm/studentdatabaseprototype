package core.personPack.EmployeePack;

import core.CoursesPack.Duties;

import java.util.ArrayList;
import java.util.List;


public class Staff extends Employee {

    private List<Duties> staffDuties = new ArrayList<Duties>();

    public Staff(){

    }
    public Staff(String fname, String lname) {
        super(fname, lname);
    }

    public Staff(String fname, String lname, String deptName, String eID) {
        super(fname, lname, deptName, eID);
    }

    public List<Duties> getStaffDuties() {
        return staffDuties;
    }

    public void setStaffDuties(List<Duties> staffDuties) {
        this.staffDuties.addAll(staffDuties);
    }

    public void setStaffDuties(Duties staffDuties) {
        this.staffDuties.add(staffDuties);
    }

    public void setStaffDuties(Duties staffDuties,int i) {
        this.staffDuties.set(i,staffDuties);
    }
    //Returns null if DutyName isn't part of the list

    public Duties getStaffDuties(String DutyName) {
        int index = findStaffDuties(DutyName);

        if(index >= 0){
            return staffDuties.get(index);
        }
        else
            return null;//The receiver will throw an exception

    }

    public boolean removeStaffDuties(String DutyName){

        int index = findStaffDuties(DutyName);

        if(index >= 0){
            staffDuties.remove(index);
            return true;
        }
        else
            return false;

    }

    //return int index
    private int findStaffDuties(String DutyName){
        int index = 0;
        for(Duties tempC:staffDuties){

            if(tempC.getDutyName().toLowerCase().equals(DutyName.toLowerCase()))
                return index;
        }
        return -1;//Return -1 if not found

    }
}
