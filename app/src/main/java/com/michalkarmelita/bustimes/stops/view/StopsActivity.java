package com.michalkarmelita.bustimes.stops.view;

import android.Manifest;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.michalkarmelita.bustimes.R;
import com.michalkarmelita.bustimes.common.BaseActivity;
import com.michalkarmelita.bustimes.common.injection.AppComponent;
import com.michalkarmelita.bustimes.common.permissions.PermissionManager;
import com.michalkarmelita.bustimes.stops.injection.StopsModule;
import com.michalkarmelita.bustimes.stops.model.StopData;
import com.michalkarmelita.bustimes.stops.viewmodel.StopsViewModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StopsActivity extends BaseActivity implements StopsView, OnMapReadyCallback {

    private static final int PERMISSIONS_REQUEST = 100;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.mapView)
    MapView mapView;

    @Inject
    StopsViewModel.Factory viewModelFactory;
    @Inject
    PermissionManager permissionManager;

    private StopsViewModel viewModel;
    private GoogleMap googleMap;
    private Marker currentMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stops);
        ButterKnife.bind(this);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        if (!permissionManager.hasPermissions(BaseActivity.MANDATORY_PERMISSIONS)) {
            requestPermissions(MANDATORY_PERMISSIONS, PERMISSIONS_REQUEST);
        }
    }

    @Override
    protected void injectComponent(AppComponent appComponent) {
        appComponent
                .plus(new StopsModule(this))
                .inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(StopsViewModel.class);

        viewModel = ViewModelProviders.of(this).get(StopsViewModel.class);

        viewModel.getStops().observe(this, new Observer<List<StopData>>() {
            @Override
            public void onChanged(@Nullable List<StopData> stopData) {

            }
        });

        viewModel.getMapMarkers().observe(this, new Observer<List<MarkerOptions>>() {
            @Override
            public void onChanged(@Nullable List<MarkerOptions> markerOptions) {
                if (googleMap != null) {
                    for (MarkerOptions options : markerOptions) {
                        setSmallMarker(googleMap.addMarker(options));
                    }
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        mapView.onPause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        mapView.onLowMemory();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST:
                if (resultCode == RESULT_OK) {
                    viewModel.requestLocation();
                }
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        this.googleMap.setMyLocationEnabled(true);
        this.googleMap.setIndoorEnabled(false);
        this.googleMap.getUiSettings().setMapToolbarEnabled(false);
        this.googleMap.getUiSettings().setCompassEnabled(false);
//        this.googleMap.setOnMarkerClickListener(marker -> {
//            setSmallMarker(currentMarker);
//            currentMarker = marker;
//            setLargeMarker(marker);
//            StopData stopData = (StopData) marker.getTag();
////            bindStopData(stopData);
////            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
//            return false;
//        });
    }

    private void setSmallMarker(Marker marker) {
        if (marker != null) {
            Bitmap mDotMarkerBitmap = createBitmap(24);
            marker.setIcon(BitmapDescriptorFactory.fromBitmap(mDotMarkerBitmap));
        }
    }

    private void setLargeMarker(Marker marker) {
        if (marker != null) {
            Bitmap mDotMarkerBitmap = createBitmap(36);
            marker.setIcon(BitmapDescriptorFactory.fromBitmap(mDotMarkerBitmap));
        }
    }

    @NonNull
    private Bitmap createBitmap(int size) {
        Bitmap mDotMarkerBitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(mDotMarkerBitmap);
        Paint paint = new Paint();
        paint.setColor(ResourcesCompat.getColor(getResources(), android.R.color.holo_red_dark, null));
        canvas.drawText("70", 0, 0, paint);
        Drawable shape = ResourcesCompat.getDrawable(getResources(), R.drawable.bus_stop_marker, null);
        shape.setBounds(0, 0, mDotMarkerBitmap.getWidth(), mDotMarkerBitmap.getHeight());
        shape.draw(canvas);
        return mDotMarkerBitmap;
    }
}
