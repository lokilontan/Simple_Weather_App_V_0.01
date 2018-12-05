package aabduljabbar1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("icon.png")));
        primaryStage.setTitle("Simple Weather App V.03");
        primaryStage.setScene(new Scene(root, 950, 520));
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) { launch(args);
    }
}
