package aabduljabbar1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    TextField zipField;
    @FXML
    Label loc;
    @FXML
    Label con;
    @FXML
    Label temF;
    @FXML
    Label temC;

    public void handleWeatherButton(ActionEvent e)
    {
        Weather W = new Weather(zipField.getText());
        W.fetch();
        loc.setText(W.getCityState());
        loc.setVisible(true);
        con.setText(W.getWeather());
        con.setVisible(true);
        temF.setText(W.getTemperatureF());
        temF.setVisible(true);
        temC.setVisible(false);
    }

    public void handleClearButton(ActionEvent e)
    {
        zipField.setText("");
        loc.setText("");
        con.setText("");
        temF.setText("");
    }

    public handleTempButton(ActionEvent e)
    {
        int count = 0;
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
}