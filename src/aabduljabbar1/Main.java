package aabduljabbar1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Simple Weather App V.03");
        primaryStage.setScene(new Scene(root, 765, 520));
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) { launch(args);
    }
}
