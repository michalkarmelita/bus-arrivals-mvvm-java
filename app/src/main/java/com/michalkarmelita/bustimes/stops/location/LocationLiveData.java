package com.michalkarmelita.bustimes.stops.location;

import android.Manifest;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.michalkarmelita.bustimes.common.injection.qualifiers.ForActivity;

import javax.inject.Inject;

public class LocationLiveData extends LiveData<Location> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {
    private final Context context;
    private final GoogleApiClient googleApiClient;

    @Inject
    public LocationLiveData(@ForActivity Context context) {
        this.context = context;
        googleApiClient =
                new GoogleApiClient.Builder(context, this, this)
                        .addApi(LocationServices.API)
                        .build();
    }

    @Override
    protected void onActive() {
        // Wait for the GoogleApiClient to be connected
        googleApiClient.connect();
    }

    public void reconnect() {
        googleApiClient.reconnect();
    }

    @Override
    protected void onInactive() {
        if (googleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(
                    googleApiClient, this);
        }
        googleApiClient.disconnect();
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        // Try to immediately find a location
        Location lastLocation = LocationServices.FusedLocationApi
                .getLastLocation(googleApiClient);
        if (lastLocation != null) {
            setValue(lastLocation);
        }
        // Request updates if there’s someone observing
        if (hasActiveObservers()) {
            LocationServices.FusedLocationApi.requestLocationUpdates(
                    googleApiClient, new LocationRequest(), this);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        // Deliver the location changes
        setValue(location);
    }

    @Override
    public void onConnectionSuspended(int cause) {
        // Cry softly, hope it comes back on its own
    }

    @Override
    public void onConnectionFailed(
            @NonNull ConnectionResult connectionResult) {
        // Consider exposing this state as described here:
        // https://d.android.com/topic/libraries/architecture/guide.html#addendum
    }
}
