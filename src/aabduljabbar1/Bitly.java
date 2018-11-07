package aabduljabbar1;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Bitly
{
    private String longURL;

    /**
     * Create a Bitly object with the given long URL
     * @param url
     */
    public Bitly(String url)
    {
        longURL = url;
    }

    /**
     * Return the short Bitly URL that corresponds to the longURL.
     * @return
     */
    public String getShortURL()
    {
        String bitlyRequest = "";

        try
        {
            // Create URL object.
            URL bitlyURL = new URL(bitlyRequest);

            // Open the data stream from the Bitly server.
            InputStream is = bitlyURL.openStream();
            InputStreamReader isr = new InputStreamReader(is);

            // Parse the returned JSON document.
            JsonParser parser = new JsonParser();
            JsonElement json = parser.parse(isr);

            // Fetch the short URL from the JSON data.
            String shortURL = json.getAsJsonObject()
                    .get("data").getAsJsonObject()
                    .get("url").getAsString();
            return shortURL;

        }
        catch (java.net.MalformedURLException mue)
        {
            System.out.println("URL is not valid.");
            System.exit(1);
        }
        catch (java.io.IOException ioe)
        {
            System.out.println("Caught IO Exception");
            System.exit(1);
        }

        return "Nothing";
    }
}
