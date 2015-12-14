package com.example.srinivasjavvaji.loginapp;

/**
 * Created by Srinivas Javvaji on 12/14/2015.
 */

import java.lang.ref.WeakReference;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;

public class GPSTracker extends Service implements LocationListener {

    private final WeakReference<Activity> contextRef;

    // flag for GPS status
    private boolean isGPSEnabled = false;

    // flag for network status
    private boolean isNetworkEnabled = false;

    // flag for GPS status
    private boolean canGetLocation = false;

//    private GPSLocationStates gpsLocationStates = GPSLocationStates.ENABLE_SETTINGS;

    private Location location;
    private double latitude;
    private double longitude;

    // The minimum distance to change Updates in meters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters

    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute
//    private PermissionRequestManager permissionRequestManager ;
    // Declaring a Location Manager

//    public GPSLocationStates getGpsLocationStates() {
//        return gpsLocationStates;
//    }

    public GPSTracker(Activity activity) {
        contextRef = new WeakReference<Activity>(activity);
//        permissionRequestManager = new PermissionRequestManager();
        boolean canProceedWithLocationPermission = true;
//        gpsLocationStates = GPSLocationStates.ENABLE_SETTINGS; //default state
        if (canProceedWithLocationPermission) {
            location = getLocation();
        }else {
//            gpsLocationStates = GPSLocationStates.PERMISSION_NOT_AVAILABlE;
        }
    }

//    public boolean isLocationFoundState() {
//        return gpsLocationStates.equals(GPSLocationStates.LOCATION_FOUND);
//    }
//
//    public boolean isEnableSettingsState() {
//        return gpsLocationStates.equals(GPSLocationStates.ENABLE_SETTINGS);
//    }
//
//    public boolean isPermissionNotAvailableState() {
//        return gpsLocationStates.equals(GPSLocationStates.PERMISSION_NOT_AVAILABlE);
//    }

    public Location getLocation() {
        try {
            if (contextRef == null) {
                return null;
            }

            LocationManager locationManager = (LocationManager) contextRef.get()
                    .getSystemService(LOCATION_SERVICE);

            // getting GPS status
            isGPSEnabled = locationManager
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);

            // getting network status
            isNetworkEnabled = locationManager
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!isGPSEnabled && !isNetworkEnabled) {
                // no network provider is enabled

                System.out.println("both providers are not enabled");
                turnGPSOn();
                getLocation();
                turnGPSOff();
            } else {
//          this.canGetLocation = true;
//                gpsLocationStates = GPSLocationStates.LOCATION_FOUND;
                if (isNetworkEnabled) {
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,MIN_TIME_BW_UPDATES,MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    //Log.d("Network", "Network");
                    if (locationManager != null) {
                        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (location != null) {
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();
                        }
                    }
                }
                // if GPS Enabled get lat/long using GPS Services
                if (isGPSEnabled) {
                    if (location == null) {
                  /*if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                     // TODO: Consider calling
                     //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
                     // here to request the missing permissions, and then overriding
                     //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                     //                                          int[] grantResults)
                     // to handle the case where the user grants the permission. See the documentation
                     // for Activity#requestPermissions for more details.
                     return TODO;
                  }*/
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,MIN_TIME_BW_UPDATES,MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        //Log.d("GPS Enabled", "GPS Enabled");
                        if (locationManager != null) {
                            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (location != null) {
                                latitude = location.getLatitude();
                                longitude = location.getLongitude();
                            }
                        }
                    }
                }
            }
            if(locationManager != null){
                locationManager.removeUpdates(GPSTracker.this);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return location;
    }

    /*----Method to Check GPS is enable or disable ----- */
    private Boolean isGpsEnabled() {
        ContentResolver contentResolver = getBaseContext()
                .getContentResolver();
        boolean gpsStatus = Settings.Secure
                .isLocationProviderEnabled(contentResolver,
                        LocationManager.GPS_PROVIDER);
        if (gpsStatus) {
            return true;

        } else {
            return false;
        }
    }

    // automatic turn on the gps
    public void turnGPSOn()
    {
        Intent intent = new Intent("android.location.GPS_ENABLED_CHANGE");
        intent.putExtra("enabled", true);
        Context context = this.getBaseContext();
        this.getBaseContext().sendBroadcast(intent);

        String provider = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
        if(!provider.contains("gps")){ //if gps is disabled
            final Intent poke = new Intent();
            poke.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
            poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
            poke.setData(Uri.parse("3"));
            context.sendBroadcast(poke);


        }
    }
    // automatic turn off the gps
    public void turnGPSOff()
    {
        String provider = Settings.Secure.getString(this.getBaseContext().getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
        if(provider.contains("gps")){ //if gps is enabled
            final Intent poke = new Intent();
            poke.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
            poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
            poke.setData(Uri.parse("3"));
            this.getBaseContext().sendBroadcast(poke);
        }
    }



    public Double[] getLatLanDoubleArray() {
        Double locationCoords[] = new Double[2];
        locationCoords[0] = this.getLatitude();
        locationCoords[1] = this.getLongitude();
        return locationCoords;
    }

    public Location getUpdatedLocationAfterInstantiation() {
        return this.location;
    }
        /**
         * Stop using GPS listener
         * Calling this function will stop using GPS in your app
         * */
    public void stopUsingGPS(){
      /*if(locationManager != null){
         locationManager.removeUpdates(GPSTracker.this);
      }*/
    }

    /**
     * Function to get latitude
     * */
    public double getLatitude(){
        if(location != null){
            latitude = location.getLatitude();
        }

        // return latitude
        return latitude;
    }

    /**
     * Function to get longitude
     * */
    public double getLongitude(){
        if(location != null){
            longitude = location.getLongitude();
        }

        // return longitude
        return longitude;
    }

    /**
     * Function to check GPS/wifi enabled
     * @return boolean
     * */
    public boolean canGetLocation() {
        return this.canGetLocation;
    }

    /**
     * Function to show settings alert dialog
     * On pressing Settings button will lauch Settings Options
     * */
    public void showSettingsAlert(){
        if(contextRef == null) {
            return;
        }
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(contextRef.get());

        // Setting Dialog Title
        alertDialog.setTitle("GPS is settings");

        // Setting Dialog Message
        alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");

        // On pressing Settings button
        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                if(contextRef != null) {
                    contextRef.get().startActivity(intent);
                }
            }
        });

        // on pressing cancel button
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }

    @Override
    public void onLocationChanged(Location location) {
    }

    @Override
    public void onProviderDisabled(String provider) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }


}
