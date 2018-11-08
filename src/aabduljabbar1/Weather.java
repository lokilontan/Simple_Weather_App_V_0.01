package aabduljabbar1;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Weather
{
    //private final String token = "b67d63a8e7ca97f75c63254fda3a94d60ae60c2e";
    private String zip;
    private JsonElement json;

    public Weather(String zipcode)
    {
        zip = zipcode;
    }

    public String getLocation()
    {
        return json.getAsJsonObject()
                .get("display_location").getAsJsonObject()
                .get("full").getAsString();
    }

    public String getTemp()
    {
        return json.getAsJsonObject()
                .get("temp_f").getAsString();
    }

    public String getCondution()
    {
        return json.getAsJsonObject()
                .get("weather").getAsString();
    }


    public void fetch()
    {
        String wdRequest = "http://api.Weather.com/api/1655f919bbcd29ed/conditions/q/" + zip +".json";

        try
        {
            URL wdURL = new URL(wdRequest);

            InputStream is = wdURL.openStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            JsonParser parser = new JsonParser();
            json = parser.parse(br);
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