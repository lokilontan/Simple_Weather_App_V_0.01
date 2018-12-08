package aabduljabbar1;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sierra.AsyncTask;




public class Controller {

    @FXML
    ImageView loadImgView;
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
    @FXML
    Label day0;
    @FXML
    Label day1;
    @FXML
    Label day2;
    @FXML
    Label day3;
    @FXML
    Label day4;
    @FXML
    Label day5;
    @FXML
    Label day6;
    @FXML
    ImageView imgViewDay0;
    @FXML
    ImageView imgViewDay1;
    @FXML
    ImageView imgViewDay2;
    @FXML
    ImageView imgViewDay3;
    @FXML
    ImageView imgViewDay4;
    @FXML
    ImageView imgViewDay5;
    @FXML
    ImageView imgViewDay6;
    @FXML
    Label conDay0;
    @FXML
    Label conDay1;
    @FXML
    Label conDay2;
    @FXML
    Label conDay3;
    @FXML
    Label conDay4;
    @FXML
    Label conDay5;
    @FXML
    Label conDay6;
    @FXML
    Label highTempFDay0;
    @FXML
    Label lowTempFDay0;
    @FXML
    Label highTempCDay0;
    @FXML
    Label lowTempCDay0;
    @FXML
    Label highTempFDay1;
    @FXML
    Label lowTempFDay1;
    @FXML
    Label highTempCDay1;
    @FXML
    Label lowTempCDay1;
    @FXML
    Label highTempFDay2;
    @FXML
    Label lowTempFDay2;
    @FXML
    Label highTempCDay2;
    @FXML
    Label lowTempCDay2;
    @FXML
    Label highTempFDay3;
    @FXML
    Label lowTempFDay3;
    @FXML
    Label highTempCDay3;
    @FXML
    Label lowTempCDay3;
    @FXML
    Label highTempFDay4;
    @FXML
    Label lowTempFDay4;
    @FXML
    Label highTempCDay4;
    @FXML
    Label lowTempCDay4;
    @FXML
    Label highTempFDay5;
    @FXML
    Label lowTempFDay5;
    @FXML
    Label highTempCDay5;
    @FXML
    Label lowTempCDay5;
    @FXML
    Label highTempFDay6;
    @FXML
    Label lowTempFDay6;
    @FXML
    Label highTempCDay6;
    @FXML
    Label lowTempCDay6;
    @FXML
    ImageView animatedRadarImg;
    @FXML
    ImageView animatedSatImg;
    @FXML
    ImageView radarImg;
    @FXML
    ImageView humidityIcon;
    @FXML
    ImageView windIcon;

    CurrentWeather CW = new CurrentWeather();


    int count = 0;
    String newRadar = CW.getRadarImg();
    String dynamicRadar;







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

            Image animatedImgRadar = new Image(CW.getRadarAImg());
            animatedRadarImg.setImage(animatedImgRadar);
            animatedRadarImg.setVisible(true);

            Image animatedImgSat = new Image(CW.getSatAImg());
            animatedSatImg.setImage(animatedImgSat);
            animatedSatImg.setVisible(false);

            Image imgRadar = new Image(CW.getRadarImg());
            radarImg.setImage(imgRadar);
            radarImg.setVisible(true);

            Image imgHumidity = new Image(Main.class.getResourceAsStream("Humidity.jpg"));
            humidityIcon.setImage(imgHumidity);
            humidityIcon.setVisible(true);

            Image imgWind = new Image(Main.class.getResourceAsStream("wind.png"));
            windIcon.setImage(imgWind);
            windIcon.setVisible(true);



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

            //FORECAST - here must be a for loop, which loops 7 times and i don`t write this method here 7 times!
            //SORRY it`s 01:00 AM

            //DAY 1
            CW.getCurrentDay(CW.CurrentJson, 0, day0, imgViewDay0, conDay0, highTempFDay0,
                    lowTempFDay0, highTempCDay0, lowTempCDay0);

            //DAY 2
            CW.getCurrentDay(CW.CurrentJson, 1, day1, imgViewDay1, conDay1, highTempFDay1,
                    lowTempFDay1, highTempCDay1, lowTempCDay1);

            //DAY 3
            CW.getCurrentDay(CW.CurrentJson, 2, day2, imgViewDay2, conDay2, highTempFDay2,
                    lowTempFDay2, highTempCDay2, lowTempCDay2);

            //DAY 4
            CW.getCurrentDay(CW.CurrentJson, 3, day3, imgViewDay3, conDay3, highTempFDay3,
                    lowTempFDay3, highTempCDay3, lowTempCDay3);

            //DAY 5
            CW.getCurrentDay(CW.CurrentJson, 4, day4, imgViewDay4, conDay4, highTempFDay4,
                    lowTempFDay4, highTempCDay4, lowTempCDay4);

            //DAY 6
            CW.getCurrentDay(CW.CurrentJson, 5, day5, imgViewDay5, conDay5, highTempFDay5,
                    lowTempFDay5, highTempCDay5, lowTempCDay5);

            //DAY 7
            CW.getCurrentDay(CW.CurrentJson, 6, day6, imgViewDay6, conDay6, highTempFDay6,
                    lowTempFDay6, highTempCDay6, lowTempCDay6);

        }
        catch (NullPointerException npe) {
            CopyRightBox.display("Error", "Didn't catch data during initialization. Try again!");
        }
    }

    public void handleWeatherButton(ActionEvent e) {

        Image loading = new Image(Main.class.getResourceAsStream("loading.gif"));


        loadImgView.setImage(loading);
        loadImgView.setFitWidth(100);
        loadImgView.setPreserveRatio(true);
        loadImgView.setSmooth(true);
        loadImgView.setCache(true);
        loadImgView.relocate(-7, 0);
        loadImgView.setVisible(true);


         AsyncTask t = new GetDataInBackground();
         t.execute(zipField.getText());

    }

    public void handleClearButton(ActionEvent e)
    {
        zipField.setText("");
        listCities.setVisible(false);
        loadImgView.setVisible(false);
        try {

            //reset the url for the radar
            newRadar = CW.getRadarImg();

            Image animatedImgRadar = new Image(CW.getRadarAImg());
            animatedRadarImg.setImage(animatedImgRadar);
            animatedRadarImg.setVisible(true);

            Image animatedImgSat = new Image(CW.getSatAImg());
            animatedSatImg.setImage(animatedImgSat);
            animatedSatImg.setVisible(false);

            Image imgRadar = new Image(CW.getRadarImg());
            radarImg.setImage(imgRadar);
            radarImg.setVisible(true);

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

            //RETURN OLD FORECAST FOR IP LOCATION
            //DAY 1
            CW.getCurrentDay(CW.CurrentJson, 0, day0, imgViewDay0, conDay0, highTempFDay0,
                    lowTempFDay0, highTempCDay0, lowTempCDay0);

            //DAY 2
            CW.getCurrentDay(CW.CurrentJson, 1, day1, imgViewDay1, conDay1, highTempFDay1,
                    lowTempFDay1, highTempCDay1, lowTempCDay1);

            //DAY 3
            CW.getCurrentDay(CW.CurrentJson, 2, day2, imgViewDay2, conDay2, highTempFDay2,
                    lowTempFDay2, highTempCDay2, lowTempCDay2);

            //DAY 4
            CW.getCurrentDay(CW.CurrentJson, 3, day3, imgViewDay3, conDay3, highTempFDay3,
                    lowTempFDay3, highTempCDay3, lowTempCDay3);

            //DAY 5
            CW.getCurrentDay(CW.CurrentJson, 4, day4, imgViewDay4, conDay4, highTempFDay4,
                    lowTempFDay4, highTempCDay4, lowTempCDay4);

            //DAY 6
            CW.getCurrentDay(CW.CurrentJson, 5, day5, imgViewDay5, conDay5, highTempFDay5,
                    lowTempFDay5, highTempCDay5, lowTempCDay5);

            //DAY 7
            CW.getCurrentDay(CW.CurrentJson, 6, day6, imgViewDay6, conDay6, highTempFDay6,
                    lowTempFDay6, highTempCDay6, lowTempCDay6);

        }
        catch (NullPointerException npe)
        {
            imgView.setVisible(false);
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

            highTempFDay0.setVisible(true);
            highTempCDay0.setVisible(false);
            lowTempFDay0.setVisible(true);
            lowTempCDay0.setVisible(false);

            highTempFDay1.setVisible(true);
            highTempCDay1.setVisible(false);
            lowTempFDay1.setVisible(true);
            lowTempCDay1.setVisible(false);

            highTempFDay2.setVisible(true);
            highTempCDay2.setVisible(false);
            lowTempFDay2.setVisible(true);
            lowTempCDay2.setVisible(false);

            highTempFDay3.setVisible(true);
            highTempCDay3.setVisible(false);
            lowTempFDay3.setVisible(true);
            lowTempCDay3.setVisible(false);

            highTempFDay4.setVisible(true);
            highTempCDay4.setVisible(false);
            lowTempFDay4.setVisible(true);
            lowTempCDay4.setVisible(false);

            highTempFDay5.setVisible(true);
            highTempCDay5.setVisible(false);
            lowTempFDay5.setVisible(true);
            lowTempCDay5.setVisible(false);

            highTempFDay6.setVisible(true);
            highTempCDay6.setVisible(false);
            lowTempFDay6.setVisible(true);
            lowTempCDay6.setVisible(false);

            count++;
        }
        else
        {
            temF1.setVisible(false);
            temC1.setVisible(true);

            highTempFDay0.setVisible(false);
            highTempCDay0.setVisible(true);
            lowTempFDay0.setVisible(false);
            lowTempCDay0.setVisible(true);

            highTempFDay1.setVisible(false);
            highTempCDay1.setVisible(true);
            lowTempFDay1.setVisible(false);
            lowTempCDay1.setVisible(true);

            highTempFDay2.setVisible(false);
            highTempCDay2.setVisible(true);
            lowTempFDay2.setVisible(false);
            lowTempCDay2.setVisible(true);

            highTempFDay3.setVisible(false);
            highTempCDay3.setVisible(true);
            lowTempFDay3.setVisible(false);
            lowTempCDay3.setVisible(true);

            highTempFDay4.setVisible(false);
            highTempCDay4.setVisible(true);
            lowTempFDay4.setVisible(false);
            lowTempCDay4.setVisible(true);

            highTempFDay5.setVisible(false);
            highTempCDay5.setVisible(true);
            lowTempFDay5.setVisible(false);
            lowTempCDay5.setVisible(true);

            highTempFDay6.setVisible(false);
            highTempCDay6.setVisible(true);
            lowTempFDay6.setVisible(false);
            lowTempCDay6.setVisible(true);

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

    public void handleRadarButton(ActionEvent e)
    {
        animatedRadarImg.setVisible(true);
        animatedSatImg.setVisible(false);
    }

    public void handleSatelliteButton(ActionEvent e)
    {
        animatedRadarImg.setVisible(false);
        animatedSatImg.setVisible(true);
    }

   public String whichRadar(){

        if (loc.getText().equals(CW.getCityState(CW.CurrentJson))) return CW.getRadarImg();
        else return dynamicRadar;
    }

    public void handleZoomOut(ActionEvent e)
    {
        //newRadar = whichRadar();

        if (newRadar.length() == 107)
        {
            int result = Integer.parseInt(newRadar.substring(85, 86));
            System.out.println(newRadar);

            System.out.println(newRadar.substring(85, 88));
            result = result + 10;
            String[] parts = newRadar.split("radius=");
            String part1 = parts[0]; // 004
            String part2 = parts[1].substring(1);
            newRadar = part1 + "radius=" + result + part2;
            Image imgRadar = new Image(newRadar);
            radarImg.setImage(imgRadar);
        }
        else if(newRadar.length() >= 109) {
            int result = Integer.parseInt(newRadar.substring(85, 88));
            System.out.println(newRadar);

            System.out.println(newRadar.substring(85, 88));
            result = result + 10;
            String[] parts = newRadar.split("radius=");
            String part1 = parts[0]; // 004
            String part2 = parts[1].substring(3);
            newRadar = part1 + "radius=" + result + part2;
            Image imgRadar = new Image(newRadar);
            radarImg.setImage(imgRadar);
        }
        else
        {
            int result = Integer.parseInt(newRadar.substring(85, 87));
            System.out.println(newRadar);

            System.out.println(newRadar.substring(85, 88));
            result = result + 10;
            String[] parts = newRadar.split("radius=");
            String part1 = parts[0]; // 004
            String part2 = parts[1].substring(2);
            newRadar = part1 + "radius=" + result + part2;
            Image imgRadar = new Image(newRadar);
            radarImg.setImage(imgRadar);

            System.out.println(newRadar);
            System.out.println("-------------------------------------");

        }


    }

    public void handleZoomIn(ActionEvent e)
    {
        //newRadar = whichRadar();
        if (newRadar.length() == 107)
        {
            CopyRightBox.display("Warning", "Too close to zoom in anymore!" );
        }
        else if(newRadar.length() >= 109) {
            int result = Integer.parseInt(newRadar.substring(85, 88));
            System.out.println(newRadar);

            System.out.println(newRadar.substring(85, 88));
            result = result - 10;
            String[] parts = newRadar.split("radius=");
            String part1 = parts[0]; // 004
            String part2 = parts[1].substring(3);
            newRadar = part1 + "radius=" + result + part2;
            Image imgRadar = new Image(newRadar);
            radarImg.setImage(imgRadar);
        }
        else
        {
            int result = Integer.parseInt(newRadar.substring(85, 87));
            System.out.println(newRadar);

            System.out.println(newRadar.substring(85, 88));
            result = result - 10;
            String[] parts = newRadar.split("radius=");
            String part1 = parts[0]; // 004
            String part2 = parts[1].substring(2);
            newRadar = part1 + "radius=" + result + part2;
            Image imgRadar = new Image(newRadar);
            radarImg.setImage(imgRadar);

            System.out.println(newRadar);
            System.out.println("-------------------------------------");

        }

    }



   private class GetDataInBackground extends AsyncTask<String, Weather>

        {

            public Weather doInBackground(String location)
            {

                Weather W = new Weather(zipField.getText());

                W.fetch();

                return W;
            }



            public void onPostExecute(Weather W)
            {
                try {
                    dynamicRadar = W.getRadarImg();

                    imgView.setImage(W.imgCondition);
                    imgView.setFitWidth(100);
                    imgView.setVisible(true);


                    animatedRadarImg.setImage(W.animatedImgRadar);
                    animatedRadarImg.setVisible(true);


                    animatedSatImg.setImage(W.animatedImgSat);
                    animatedSatImg.setVisible(false);

                    radarImg.setImage(W.imgRadar);
                    radarImg.setVisible(true);

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

                    //FORECAST

                    //DAY 1
                    W.getLocationDay(W.DynamicJson, 0, day0, imgViewDay0, conDay0, highTempFDay0,
                            lowTempFDay0, highTempCDay0, lowTempCDay0);

                    //DAY 2
                    W.getLocationDay(W.DynamicJson, 1, day1, imgViewDay1, conDay1, highTempFDay1,
                            lowTempFDay1, highTempCDay1, lowTempCDay1);

                    //DAY 3
                    W.getLocationDay(W.DynamicJson, 2, day2, imgViewDay2, conDay2, highTempFDay2,
                            lowTempFDay2, highTempCDay2, lowTempCDay2);

                    //DAY 4
                    W.getLocationDay(W.DynamicJson, 3, day3, imgViewDay3, conDay3, highTempFDay3,
                            lowTempFDay3, highTempCDay3, lowTempCDay3);

                    //DAY 5
                    W.getLocationDay(W.DynamicJson, 4, day4, imgViewDay4, conDay4, highTempFDay4,
                            lowTempFDay4, highTempCDay4, lowTempCDay4);

                    //DAY 6
                    W.getLocationDay(W.DynamicJson, 5, day5, imgViewDay5, conDay5, highTempFDay5,
                            lowTempFDay5, highTempCDay5, lowTempCDay5);

                    //DAY 7
                    W.getLocationDay(W.DynamicJson, 6, day6, imgViewDay6, conDay6, highTempFDay6,
                            lowTempFDay6, highTempCDay6, lowTempCDay6);

                    loadImgView.setVisible(false);

                } catch (NullPointerException nue) {
                    loadImgView.setVisible(false);
                    CopyRightBox.display("Error", "Something went wrong (NullPointerException). Try again!");
                }



            }
        }


}
