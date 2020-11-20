package apiquery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * <b>Description</b> :
 *
 * @author Vinod Akkepalli
 */
public class apiquery {

    public static void main(String[] args) throws IOException {

        String str = "i";
        URL url = new URL("https://jsonmock.hackerrank.com/api/countries/search?name=" + str);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if(conn.getResponseCode() != 200) {
            throw new RuntimeException("URL Query Failed! " + conn.getResponseMessage());
        } else {
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;

            while((line = br.readLine()) != null) {
                sb.append(line).append('\n');
            }
            br.close();

//            System.out.println(sb.toString());



            /*String jsonString = sb.toString() ; //assign your JSON String here
            JSONObject obj = new JSONObject(jsonString);
            String pageName = obj.getJSONObject("pageInfo").getString("pageName");

            JSONArray arr = obj.getJSONArray("posts");
            for (int i = 0; i < arr.length(); i++)
            {
                String post_id = arr.getJSONObject(i).getString("post_id");
    ......
            }*/



        }

    }
}
