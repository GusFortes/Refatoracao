package uinterface;

import business.Bar;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("inicio.fxml"));
        primaryStage.setTitle("Menu Bar");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static Bar bar = new Bar();

    public static void main(String[] args) {
        launch(args);


    }

    public Bar getBar(){
        return bar;
    }
}
