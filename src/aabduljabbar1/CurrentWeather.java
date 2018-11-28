package aabduljabbar1;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class CurrentWeather {

    public JsonElement CurrentJson; //json for current weather
    public JsonElement CurrentRSJson;

    public String getImageString(JsonElement j){
        return j.getAsJsonObject().get("current_observation").getAsJsonObject()
                .get("icon_url").getAsString();
    }

    public String getCityState(JsonElement j)
    {
        return j.getAsJsonObject().get("current_observation").getAsJsonObject()
                .get("display_location").getAsJsonObject()
                .get("full").getAsString();
    }

    public String getTemperatureF(JsonElement j)
    {
        return j.getAsJsonObject().get("current_observation").getAsJsonObject()
                .get("temp_f").getAsString() + "° F";
    }

    public String getTemperatureC(JsonElement j)
    {
        return j.getAsJsonObject().get("current_observation").getAsJsonObject()
                .get("temp_c").getAsString() + "° C";
    }

    public String getWeather(JsonElement j)
    {
        return j.getAsJsonObject().get("current_observation").getAsJsonObject()
                .get("weather").getAsString();
    }

    public String getWindDir(JsonElement j)
    {
        return "Wind " +  j.getAsJsonObject().get("current_observation").getAsJsonObject()
                .get("wind_dir").getAsString();
    }

    public String getHumidity(JsonElement j)
    {
        return "Humidity " + j.getAsJsonObject().get("current_observation").getAsJsonObject()
                .get("relative_humidity").getAsString();
    }

    public void getCurrentDay(JsonElement j, int dayN, Label dayDate, ImageView dayImgView, Label dayCond,
                       Label dayHTempF, Label dayLTempF, Label dayHTempC, Label dayLTempC){

        dayDate.setText(j.getAsJsonObject().get("forecast").getAsJsonObject().get("simpleforecast").getAsJsonObject()
                .get("forecastday").getAsJsonArray().get(dayN).getAsJsonObject().get("date").getAsJsonObject()
                .get("weekday").getAsString());

        Image dayImgCondition = new Image(j.getAsJsonObject().get("forecast").getAsJsonObject().get("simpleforecast").getAsJsonObject()
                .get("forecastday").getAsJsonArray().get(dayN).getAsJsonObject().get("icon_url").getAsString());

        dayImgView.setImage(dayImgCondition);

        dayCond.setText(j.getAsJsonObject().get("forecast").getAsJsonObject().get("simpleforecast").getAsJsonObject()
                .get("forecastday").getAsJsonArray().get(dayN).getAsJsonObject().get("conditions").getAsString());

        dayCond.setVisible(true);

        dayHTempF.setText(j.getAsJsonObject().get("forecast").getAsJsonObject().get("simpleforecast").getAsJsonObject()
                .get("forecastday").getAsJsonArray().get(dayN).getAsJsonObject().get("high").getAsJsonObject()
                .get("fahrenheit").getAsString());

        dayHTempF.setVisible(false);

        dayHTempC.setText(j.getAsJsonObject().get("forecast").getAsJsonObject().get("simpleforecast").getAsJsonObject()
                .get("forecastday").getAsJsonArray().get(dayN).getAsJsonObject().get("high").getAsJsonObject()
                .get("celsius").getAsString());

        dayHTempC.setVisible(true);

        dayLTempF.setText(j.getAsJsonObject().get("forecast").getAsJsonObject().get("simpleforecast").getAsJsonObject()
                .get("forecastday").getAsJsonArray().get(dayN).getAsJsonObject().get("low").getAsJsonObject()
                .get("fahrenheit").getAsString());

        dayLTempF.setVisible(false);

        dayLTempC.setText(j.getAsJsonObject().get("forecast").getAsJsonObject().get("simpleforecast").getAsJsonObject()
                .get("forecastday").getAsJsonArray().get(dayN).getAsJsonObject().get("low").getAsJsonObject()
                .get("celsius").getAsString());

        dayLTempC.setVisible(true);
    }

    public String getRadarImg(JsonElement j){
        return j.getAsJsonObject().get("radar").getAsJsonObject()
                .get("image_url").getAsString();
    }

    public String getSatImg(JsonElement j){
        return j.getAsJsonObject().get("satellite").getAsJsonObject()
                .get("image_url").getAsString();
    }

    //Method for getting weather for location based on the user`s IP
    public void fetchCurrent()
    {
        String wdRequest = "http://api.wunderground.com/api/1655f919bbcd29ed/conditions/forecast7day/q/autoip.json";

        try
        {
            URL wdURL = new URL(wdRequest);

            InputStream is = wdURL.openStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            JsonParser parser = new JsonParser();
            CurrentJson = parser.parse(br);
        }
        catch (java.net.MalformedURLException mue)
        {
            System.out.println("URL not valid");
            System.exit(1);
        }
        catch (java.io.IOException ioe)
        {
            System.out.println("IO Exception Caught");
            System.exit(1);
        }
    }

    public void fetchCurrentRS()
    {
        String wdRequest = "http://api.wunderground.com/api/1655f919bbcd29ed/radar/satellite/q/autoip.json";

        try
        {
            URL wdURL = new URL(wdRequest);

            InputStream is = wdURL.openStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            JsonParser parser = new JsonParser();
            CurrentRSJson = parser.parse(br);
        }
        catch (java.net.MalformedURLException mue)
        {
            System.out.println("URL not valid");
            System.exit(1);
        }
        catch (java.io.IOException ioe)
        {
            System.out.println("IO Exception Caught");
            System.exit(1);
        }
    }
}
