package com.example.gps_do;

import android.app.Activity;
import android.content.Context;
import android.location.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity
{
    double Lat1 = 41.4906377;
    double oldLon = -81.056922;
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
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lat1 = location.getLatitude();
                oldLon = location.getLongitude();
            }
        });
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

    private void updateWithNewLocation(Location location)
    {
        String latLong;
        TextView myLocation;
        myLocation = (TextView) findViewById(R.id.textView);
        if (location != null)
        {
            //this is all from http://www.movable-type.co.uk/scripts/latlong.html
            double lat2 = location.getLatitude();
            double lon = location.getLongitude();
            latLong = "Lat:" + lat2 + "\nLong:" + lon;
            double R = 6371000;
            double sigma1 = Math.toRadians(Lat1);
            double sigma2 = Math.toRadians(lat2);
            //double deltaSigma = Math.toRadians()

            double radOldlat = Math.toRadians(Lat1);
            double radOldlon = Math.toRadians(oldLon);

            double radLat = Math.toRadians(location.getLatitude());
            double radLon = Math.toRadians(location.getLongitude());


            double deltaSigma = Math.toRadians((radOldlat - radLat));
            double deltaLambda = Math.toRadians((radOldlon - radLon));

            double a = (Math.sin(deltaSigma/2)*Math.sin(deltaSigma)) +
                    Math.cos(sigma1)*Math.cos(sigma2)*
                            (Math.sin(deltaLambda/2)*Math.sin(deltaLambda/2));

            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

            double d = R * c * 3280.8399;
            final String DeeString = Double.toString(d);
            setTheText(DeeString);
            //oldLat = lat;
            //oldLon = lon;
        } else{
            latLong = " NO Location Found ";
        }
        //  TextView theTextView = (TextView) findViewById(R.id.butt);
        //theTextView.setText(DeeString);
        myLocation.setText("your Current Position is :\n" + latLong);
    }
    public void setTheText (String input){
        TextView bwaa = (TextView) findViewById(R.id.butt);
        bwaa.setText(input);
    }
}


