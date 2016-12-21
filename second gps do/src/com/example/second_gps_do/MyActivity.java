package com.example.second_gps_do;

import android.app.Activity;
import android.content.Context;
import android.location.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import junit.framework.Test;
import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;

public class MyActivity extends Activity
{
double lat2;
    double lon2;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        LocationManager locationManager;
        String context = Context.LOCATION_SERVICE;
        locationManager = (LocationManager) getSystemService(context);

        Criteria crta = new Criteria();
        crta.setAccuracy(Criteria.ACCURACY_FINE);
        crta.setAltitudeRequired(false);
        crta.setBearingRequired(false);
        crta.setCostAllowed(true);
        crta.setPowerRequirement(Criteria.POWER_LOW);
        String provider = locationManager.getBestProvider(crta, true);

        // String provider = LocationManager.GPS_PROVIDER;
        final Location location = locationManager.getLastKnownLocation(provider);
        updateWithNewLocation(location);

        locationManager.requestLocationUpdates(provider, 1000, 0,
                locationListener);

    }

    private final LocationListener locationListener = new LocationListener()
    {

        @Override
        public void onLocationChanged(Location location)
        {
            updateWithNewLocation(location);
        }

        @Override
        public void onProviderDisabled(String provider)
        {
            updateWithNewLocation(null);
        }

        @Override
        public void onProviderEnabled(String provider)
        {
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras)
        {
        }

    };
    private void updateWithNewLocation(final Location location)
    {
        String latLong;
        TextView myLocation;
        myLocation = (TextView) findViewById(R.id.textView);
        if (location != null)
        {
            //this is all from http://www.movable-type.co.uk/scripts/latlong.html
            final double lat1 = location.getLatitude();
            double lon1 = location.getLongitude();
            //final double lat2;
            //final double lon2;
            Button button = (Button) findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setLatLong(location.getLatitude(), location.getLongitude());
                }
            });
            double R = 6371000.0;
            double sigma1 = Math.toRadians(lat1);
            double sigma2 = Math.toRadians(lat2);
            double lambda1 = Math.toRadians(lon1);
            double lambda2 = Math.toRadians(lon2);
            double deltaSigma = Math.toRadians(lat2 - lat1);
            double deltaLambda = Math.toRadians(lon2 - lon1);

            //begin distance
            double a = Math.sin(deltaSigma/2)*Math.sin(deltaSigma/2) +
                        Math.cos(sigma1) * Math.cos(sigma2) *
                        Math.sin(deltaLambda/2)*Math.sin(deltaLambda/2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
            double d = R * c * 3.28084;
            //end distance approx

            //begin bering
            /*
            double y = Math.sin(lambda2 - lambda1) * Math.cos(sigma2);
            double x = Math.cos(sigma1)*Math.sin(sigma2) -
                        Math.sin(sigma1)*Math.cos(sigma2)*Math.cos(lambda2-lambda1);
            double brng = Math.toDegrees(Math.atan2(y,x));
            */
            //eng bering

            setTheText(d);
        } else{
            latLong = " NO Location Found ";
        }
        //  TextView theTextView = (TextView) findViewById(R.id.butt);
        //theTextView.setText(DeeString);
        myLocation.setText("Your Current Position is: \n " + location.getLatitude() + "\n" + location.getLongitude() + " ");
    }
    public void setTheText (double dist){
        String dee = Double.toString(dist);
       // String bee = Double.toString(brng);
        TextView bwaa = (TextView) findViewById(R.id.dist);
        bwaa.setText("Dist:" + dee);
        //TextView Tbrng = (TextView) findViewById(R.id.brng);
        //Tbrng.setText("Brng:" + bee);
    }
    public void setLatLong(double inlat2, double inlon2){
        lat2 = inlat2;
        lon2 = inlon2;
        TextView textView = (TextView) findViewById(R.id.saveLOC);
        textView.setText(" " + lat2 + "\n" + lon2 + " ");
    }
}



