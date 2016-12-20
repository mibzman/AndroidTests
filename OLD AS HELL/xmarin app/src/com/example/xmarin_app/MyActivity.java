package com.example.xmarin_app;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.widget.TextView;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    int myId;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
     /*  StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .penaltyDialog()
                .build());

        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll()
                .penaltyLog()
                .build());
       */

        TextView wid = (TextView) findViewById(R.id.wid);
        TextView name = (TextView) findViewById(R.id.name);
        TextView url = (TextView) findViewById(R.id.url);


        JSONObject json = null;
        String str = "";
        HttpResponse response;
        HttpClient myClient = new DefaultHttpClient();
        HttpPost myConnection = new HttpPost("http://api.openweathermap.org/data/2.5/weather?q=London");

        try {
            response = myClient.execute(myConnection);
            str = EntityUtils.toString(response.getEntity(), "UTF-8");

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try{
            JSONObject jObject = new JSONObject(str);
            //JSONObject weatherObject = jObject.getJSONObject("weather");
            JSONArray weatherArray = jObject.getJSONArray("weather");
            JSONObject alsoWeatherObject = weatherArray.getJSONObject(0);



          String Idee = (alsoWeatherObject.getString("id"));
          int id = Integer.parseInt(Idee);
            myidSetter(id);

            //name.setText(weatherObject.getString("weather"));
            //url.setText(json.getString("url"));


        } catch ( JSONException e) {
            e.printStackTrace();
        }

    }
    public void myidSetter(int id){
        switch (id){
            case 200 :
               myId = 1;
                break;
            case 201 :
                myId = 2;
                break;
            case 202:
                myId = 3;
                break;
            case 210:
                myId = 4;
                break;
            case 211:
                myId = 5;
                break;
            case 212:
                myId = 6;
                break;
            case 221:
                myId = 5;
                break;
            case 230:
                myId = 7;
                break;
            case 231:
                myId = 8;
                break;
            case 232:
                myId = 9;
                break;
            case 300:
                myId = 10;
                break;
            case 301:
                myId = 11;
                break;
            case 302:
                myId = 12;
                break;
            case 310:
                myId = 10;
                break;
            case 311:
                myId = 11;
                break;
            case 312:
                myId = 12;
                break;
            case 313:
                myId = 11;
                break;
            case 314:
                myId = 12;
                break;
            case 321:
                myId = 10;
                break;
            case 500:
                myId = 13;
                break;
            case 501:
                myId = 14;
                break;
            case 502:
                myId = 15;
                break;
            case 503:
                myId = 16;
                break;
            case 504:
                myId = 17;
            case 511:
                myId = 18;
                break;
            case 520:
                myId = 13;
                break;
            case 521:
                myId = 14;
                break;
            case 522:
                myId = 15;
                break;
            case 531:
                myId = 13;
                break;
            case 600:
                myId = 19;
                break;
            case 601:
                myId = 20;
                break;
            case 602:
                myId = 21;
                break;
            case 611:
                myId = 22;
                break;
            case 612:
                myId = 22;
                break;
            case 615:
                myId = 22;
                break;
            case 616:
                myId = 22;
                break;
            case 620:
                myId = 19;
                break;
            case 621:
                myId = 20;
                break;
            case 622:
                myId = 21;
                break;
            case 701:
                myId = 23;
                break;
            case 711:
                myId = 23;
                break;
            case 721:
                myId = 23;
                break;
            case 731:
                myId = 23;
                break;
            case 741:
                myId = 23;
                break;
            case 751:
                myId = 23;
                break;
            case 761:
                myId = 23;
                break;
            case 762:
                myId = 23;
                break;
            case 771:
                myId = 24;
                break;
            case 781:
                myId = 25;
                break;
            case 800:
                myId = 26;
                break;
            case 801:
                myId = 27;
                break;
            case 802:
                myId = 27;
                break;
            case 803:
                myId = 27;
                break;
            case 804:
                myId = 27;
                break;
            case 900:
                myId = 25;
                break;
            case 901:
                myId = 28;
                break;
            case 902:
                myId = 29;
                break;
            case 903:
                myId = 30;
                break;
            case 904:
                myId = 31;
                break;
            case 905:
                myId = 32;
                break;
            case 906:
                myId = 33;
                break;

        }
    }

}
