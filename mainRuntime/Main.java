package core.mainRuntime;

import core.Generic.genericPerson;

public class Main {

/*
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("myGUI_FX.fxml"));
        primaryStage.setTitle("Project1GUI");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
*/

    public static void main(String[] args) {

        System.out.println("Welcome Test");
        genericPerson testPerson = new genericPerson();

        testPerson.runObject();
    }

}
