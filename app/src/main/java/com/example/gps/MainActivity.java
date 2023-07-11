package com.example.gps;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;

public class MainActivity extends AppCompatActivity {
    //public Variables for refresh intervals of location.
    public static final int  DEFAULT_UPDATE_INTERVAL = 30;
    public static final int  FAST_UPDATE_INTERVAL = 5;


    //reference to the ui elements.
    TextView tv_lat, tv_lon, tv_altitude,tv_accuracy,tv_speed,tv_sensor,tv_updates,tv_address;
    Switch sw_locationUpdates, sw_gps;

    //variable to remember if we are tracking location or not
    boolean UpdateOn = false;

    //Location request config file
    LocationRequest locationRequest;


    //Googles API for location services. features depend on this class
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //give each ui variable a value.
        tv_lat = findViewById(R.id.tv_lat);
        tv_lon = findViewById(R.id.tv_lon);
        tv_altitude = findViewById(R.id.tv_altitude);
        tv_accuracy = findViewById(R.id.tv_accuracy);
        tv_speed = findViewById(R.id.tv_speed);
        tv_sensor = findViewById(R.id.tv_sensor);
        tv_updates = findViewById(R.id.tv_updates);
        tv_address = findViewById(R.id.tv_address);
        sw_locationUpdates = findViewById(R.id.sw_locationsupdates);
        sw_gps = findViewById(R.id.sw_gps);

//set all properties of locationRequest

        locationRequest = new LocationRequest();
//how often does the default location check occur
        locationRequest.setInterval(1000 * DEFAULT_UPDATE_INTERVAL);
        //how often do we want to update the location
        locationRequest.setFastestInterval(1000 * FAST_UPDATE_INTERVAL);
        locationRequest.setPriority(locationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        sw_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sw_gps.isChecked()){
                    //check to see if the slider is checked- most accurate
                    locationRequest.setPriority(locationRequest.PRIORITY_HIGH_ACCURACY);
                    tv_sensor.setText("Using GPS Sensor");
                }
                else
                {
                    locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
                    tv_sensor.setText("USING CELL TOWERS + WIFI");
                }
            }
        });
    }//end onCreate method
    private void updateGPS()
    {
        //get permissions from device to track location
        //get location from fused client
        //update the ui i.e. set all the properties in their text view items
    }
}