package aabduljabbar1;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.xml.soap.Text;


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
    Label temF1;
    @FXML
    Label temC1;
    @FXML
    ListView listCities;
    @FXML
    Label windDir;
    @FXML
    Label humidity;
    @FXML
    Label line;

    int count = 0;

    CurrentWeather CW = new CurrentWeather();


    public void handleListView() {
        zipField.setText(listCities.getSelectionModel().getSelectedItem().toString());
        listCities.setVisible(false);
    }

    public void handlePaneClick(){
        listCities.setVisible(false);
    }

    public void handleInputField() {
        listCities.getItems().clear();
        Cities c = new Cities(zipField.getText().replace(" ", "%20"));
        c.getCities();
        c.collectCities(listCities);
        if (c.a.size()==0) listCities.setVisible(false);
        else listCities.setVisible(true);
    }

    public void initialize(){

        CW.fetchCurrent();
        try {
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
            temC.setVisible(true);
            temC1.setText(CW.getTemperatureC(CW.CurrentJson));
            temC1.setVisible(true);
            temF1.setText(CW.getTemperatureF(CW.CurrentJson));
            temF1.setVisible(false);
            windDir.setText(CW.getWindDir(CW.CurrentJson));
            windDir.setVisible(true);
            humidity.setText(CW.getHumidity(CW.CurrentJson));
            humidity.setVisible(true);
            line.setVisible(true);
        }
        catch (NullPointerException npe) {
            CopyRightBox.display("Error", "Didn't catch data during initialization. Try again!");
        }
    }

    public void handleWeatherButton(ActionEvent e)
    {
        Weather W = new Weather(zipField.getText());

        W.fetch();
        try {
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
            temC.setVisible(true);
            temC1.setText(W.getTemperatureC(W.DynamicJson));
            temC1.setVisible(true);
            temF1.setText(W.getTemperatureF(W.DynamicJson));
            temF1.setVisible(false);
            windDir.setText(W.getWindDir(W.DynamicJson));
            windDir.setVisible(true);
            humidity.setText(W.getHumidity((W.DynamicJson)));
            humidity.setVisible(true);
            line.setVisible(true);

        }
        catch (NullPointerException nue) {
            CopyRightBox.display("Error", "Something went wrong (NullPointerException). Try again!");
        }
    }

    public void handleClearButton(ActionEvent e)
    {
        zipField.setText("");
        try {
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
            temC.setVisible(true);
            temC1.setText(CW.getTemperatureC(CW.CurrentJson));
            temC1.setVisible(true);
            temF1.setText(CW.getTemperatureF(CW.CurrentJson));
            temF1.setVisible(false);
            windDir.setText(CW.getWindDir(CW.CurrentJson));
            windDir.setVisible(true);
            humidity.setText(CW.getHumidity(CW.CurrentJson));
            humidity.setVisible(true);
            line.setVisible(true);

        }
        catch (NullPointerException npe)
        {   imgView.setVisible(false);
            loc.setVisible(false);
            con.setVisible(false);
            temF.setVisible(false);
            line.setVisible(false);

        }
    }

    public void handleTempButton(ActionEvent e)
    {
        if(count == 0){
            temF1.setVisible(true);
            temC1.setVisible(false);
            count++;
        }
        else
        {
            temF1.setVisible(false);
            temC1.setVisible(true);
            count--;
        }
    }

    public void handleCopyRightButton(ActionEvent e)
    {
        CopyRightBox.display("Copyright", "© AVA Coders, LLC. All Rights Reserved.");
    }

    public void handleMenuButton(ActionEvent e)
    {
        CopyRightBox.display("Message", "Will be implemented after receiving the second payment!");
    }

}
