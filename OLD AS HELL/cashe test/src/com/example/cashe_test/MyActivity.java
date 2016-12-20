package com.example.cashe_test;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private LruCache<String, Bitmap> mMemoryCache;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // Get max available VM memory, exceeding this amount will throw an
        // OutOfMemory exception. Stored in kilobytes as LruCache takes an
        // int in its constructor.
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

        // Use 1/8th of the available memory for this memory cache.
        final int cacheSize = maxMemory / 8;

        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                // The cache size will be measured in kilobytes rather than
                // number of items.
                return bitmap.getByteCount() / 1024;
            }
        };
        ImageDownloaderCont tom = new ImageDownloaderCont();
        tom.execute();
        Button button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  addBitmapToMemoryCache("key",);
            }
        });
    }
    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemCache(key) == null) {
            mMemoryCache.put(key, bitmap);
        }
    }
    public Bitmap getBitmapFromMemCache(String key) {
        return mMemoryCache.get(key);
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
               /* Document doc = Jsoup.connect("http://megatokyo.com/strip/"+ number).get();
                Elements spans = doc.select("span#strip-bl");
                Element mySpan = spans.first();
                Element image = mySpan.child(0);
                final String srcString = image.attr("src");*/
                URL url = new URL("http://megatokyo.com/1396.png");
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
               // new PhotoViewAttacher(iv);

            }
          //  closeDialog();
           // enablebuttons();
        }


        protected void onCancelled(){
          //  closeDialog();
          //  enablebuttons();
          //  oopsDialog();
        }
    }
}
