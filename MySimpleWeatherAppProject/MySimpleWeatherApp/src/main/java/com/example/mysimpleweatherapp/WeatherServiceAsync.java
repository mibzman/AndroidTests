import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.mysimpleweatherapp.R;

public class AsyncTaskTestActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Starting the task. Pass an url as the parameter.
        new PostTask().execute("http://feeds.pcworld.com/pcworld/latestnews");
    }

    // The definition of our task class
    private class PostTask extends AsyncTask<String, Integer, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            displayProgressBar("Downloading...");
        }

        @Override
        protected String doInBackground(String... params) {
            String url=params[0];

            // Dummy code
            for (int i = 0; i <= 100; i += 5) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
            }
            return "All Done!";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            updateProgressBar(values[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            dismissProgressBar();
        }
    }
