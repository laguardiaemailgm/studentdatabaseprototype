package core.InterfacesPack;


public interface GenericFunctionsInterface {

    boolean changefName(Object o);
    boolean changelName(Object o);

    boolean addEditCourse(Object o,boolean changeType);
    void removeCourse(Object o);

    boolean addEditDuties(Object o, boolean changeType);
    boolean removeDuties(Object o);

    void display();//Student or Employee
    void displayAll();//Display Everyone from Student or Employee

    boolean setID(Object o);
    char setmatriculantStatus_outside();//change


}
