package aabduljabbar1;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import javafx.scene.control.ListView;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Cities {

    private String character;
    public JsonElement json;
    public JsonArray a;


    public Cities (String c) {
        character = c;
    }



    public void getCities()
    {
        String wdRequest = "http://autocomplete.wunderground.com/aq?query=" + character;
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

    public void collectCities(ListView lv) {
       a = json.getAsJsonObject().get("RESULTS").getAsJsonArray();
       for (int i = 0; i< a.size()-1; i++) {
           if (a.size() == 0) lv.setVisible(false); else
               if (a.size() >= 10) lv.setMaxHeight(20*13);
                       else lv.setMaxHeight(a.size()*13);
           lv.getItems().add(a.get(i).getAsJsonObject().get("name").getAsString());

       }
    }

}
