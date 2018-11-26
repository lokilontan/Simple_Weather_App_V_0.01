package aabduljabbar1;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class CurrentWeather {

    public JsonElement CurrentJson; //json for current weather

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


    //Method for getting weather for location based on the user`s IP
    public void fetchCurrent()
    {
        String wdRequest = "http://api.wunderground.com/api/1655f919bbcd29ed/conditions/q/autoip.json";

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

}
