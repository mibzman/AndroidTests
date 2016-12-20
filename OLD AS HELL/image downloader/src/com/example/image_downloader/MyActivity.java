package com.example.image_downloader;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView poop = (TextView) findViewById(R.id.textView);
                poop.setText("poop");
                ImageDownloader kyle = new ImageDownloader()       ;
                kyle.execute(4);
            }
        });
    }
    class ImageDownloader
            extends AsyncTask<Integer, Integer, String> {
        protected void onPreExecute(){
           // launchDialog();
        }

        @Override
        protected String doInBackground(Integer... params) {
            //TODO Auto-generated method stub
            try{
                int number = params[0];
                Document doc = Jsoup.connect("http://megatokyo.com/strip/" + number).get();
                Elements titleDivs = doc.select("div#comic");  //start of title getter
                Element myDivs = titleDivs.first();
                Element myDiv = myDivs.child(0);
                Element theDiv = myDiv.child(1);
                String title = theDiv.ownText();    //end title getter
                return title;
            }catch(Exception e){
                Log.e("Image", "Failed to load image", e);
                Toast.makeText(getApplicationContext(), "An Error Occured", Toast.LENGTH_LONG).show();
            }
            return null;
        }
        protected void onProgressUpdate(Integer... params){

        }
        protected void onPostExecute( final String title){
            TextView durrrr = (TextView) findViewById(R.id.textView);
            durrrr.setText(title);
            //totalTitle = title;
            //SharedPreferences.Editor editor = Megatokyo_data.edit();
           // editor.putString(Integer.toString(currentcomic), totalTitle);
            //editor.commit();
            ImageDownloaderCont tim = new ImageDownloaderCont();
            tim.execute(4);
        }


        protected void onCancelled(){
           /* closeDialog();
            enablebuttons();
            oopsDialog();           */
        }
    }
    class ImageDownloaderCont
            extends AsyncTask<Integer, Integer, Bitmap> {
        protected void onPreExecute(){
            //launchDialog();
        }

        @Override
        protected Bitmap doInBackground(Integer... params) {
            //TODO Auto-generated method stub
            try{
                int number = params[0];
                Document doc = Jsoup.connect("http://megatokyo.com/strip/"+ number).get();
                Elements spans = doc.select("span#strip-bl");
                Element mySpan = spans.first();
                Element image = mySpan.child(0);
                final String srcString = image.attr("src");
                URL url = new URL("http://megatokyo.com/"+ srcString);
                HttpURLConnection httpCon =
                        (HttpURLConnection)url.openConnection();
                if(httpCon.getResponseCode() != 200)
                    throw new Exception("Failed to connect");
                InputStream is = httpCon.getInputStream();
                return BitmapFactory.decodeStream(is);
            }catch(Exception e){
                Log.e("Image", "Failed to load image", e);
                Toast.makeText(getApplicationContext(), "off", Toast.LENGTH_SHORT).show();
            }
            return null;
        }
        protected void onProgressUpdate(Integer... params){

        }
        protected void onPostExecute(final Bitmap img){
            ImageView iv = (ImageView) findViewById(R.id.imageView);
            if(iv!=null && img!=null){
                iv.setImageBitmap(img);
                //new PhotoViewAttacher(iv);
                //addBitmapToMemoryCache(Integer.toString(currentcomic), img);

            }
            //closeDialog();
            //enablebuttons();
        }


        protected void onCancelled(){
          /*  closeDialog();
            enablebuttons();
            oopsDialog();     */
        }
    }
}
