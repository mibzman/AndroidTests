package com.example.lovenstein_test;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import uk.co.senab.photoview.PhotoViewAttacher;

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
        ImageDownloaderCont loadAncomic = new ImageDownloaderCont();
        loadAncomic.execute(500);

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
                    Document doc = Jsoup.connect("http://www.mrlovenstein.com/comic/" + number + "#comic").get();
                    Elements imgs = doc.select("img#comic_main_image");
                    Element image = imgs.first();
                    final String srcString = image.attr("src");
                    URL url = new URL("http://www.mrlovenstein.com"+ srcString);
                   // URL url = new URL("http://www.mrlovenstein.com/images/comics/591_ghost_story.png");
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
                new PhotoViewAttacher(iv);
               // addBitmapToMemoryCache(Integer.toString(currentcomic), img);

            }

        }


        protected void onCancelled(){

        }
    }
}
