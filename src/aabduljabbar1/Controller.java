package aabduljabbar1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {

    @FXML
    TextField zipField;
    @FXML
    Label loc;
    @FXML
    Label con;
    @FXML
    ImageView imgView;
    @FXML
    Label temF;
    @FXML
    Label temC;
    @FXML
    Button copyRight;

    int count = 0;

    CurrentWeather CW = new CurrentWeather();

    public void initialize(){

        CW.fetchCurrent();
        Image imgCondition = new Image(CW.getImageString(CW.CurrentJson));
        imgView.setImage(imgCondition);
        imgView.setVisible(true);
        loc.setText(CW.getCityState(CW.CurrentJson));
        loc.setVisible(true);
        con.setText(CW.getWeather(CW.CurrentJson));
        con.setVisible(true);
        temF.setText(CW.getTemperatureF(CW.CurrentJson));
        temF.setVisible(true);
        temC.setText(CW.getTemperatureC(CW.CurrentJson));
        temC.setVisible(false);
    }



    public void handleWeatherButton(ActionEvent e)
    {   Weather W = new Weather(zipField.getText());
        W.fetch();
        Image imgCondition = new Image(W.getImageString(W.DynamicJson));
        imgView.setImage(imgCondition);
        imgView.setVisible(true);
        loc.setText(W.getCityState(W.DynamicJson));
        loc.setVisible(true);
        con.setText(W.getWeather(W.DynamicJson));
        con.setVisible(true);
        temF.setText(W.getTemperatureF(W.DynamicJson));
        temF.setVisible(true);
        temC.setText(W.getTemperatureC(W.DynamicJson));
        temC.setVisible(false);
    }

    public void handleClearButton(ActionEvent e)
    {
        zipField.setText("");
        Image imgCondition = new Image(CW.getImageString(CW.CurrentJson));
        imgView.setImage(imgCondition);
        imgView.setVisible(true);
        loc.setText(CW.getCityState(CW.CurrentJson));
        loc.setVisible(true);
        con.setText(CW.getWeather(CW.CurrentJson));
        con.setVisible(true);
        temF.setText(CW.getTemperatureF(CW.CurrentJson));
        temF.setVisible(true);
        temC.setText(CW.getTemperatureC(CW.CurrentJson));
        temC.setVisible(false);
    }

    public void handleTempButton(ActionEvent e)
    {
        if(count == 0){
            temF.setVisible(false);
            temC.setVisible(true);
            count++;
        }
        else
        {
            temF.setVisible(true);
            temC.setVisible(false);
            count--;
        }
    }

    public void handleCopyRightButton(ActionEvent e)
    {
        CopyRightBox.display("Copyright", "© AVA Coders, LLC. All Rights Reserved.");
    }
}
