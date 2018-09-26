package core.ExceptionsPack;

public class MyExceptions extends Exception{
    String myMessage;


    public MyExceptions(){
        super("My Exception Test: ");

    }

    public MyExceptions (String message){

        super("My Exception Test /w: " + message);
    }

}
