package tcd.project.myapplication.fragment.delivery;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import baseproject.tran.canhdinh.base.BaseFragment;
import baseproject.tran.canhdinh.base.BaseParameters;
import tcd.project.myapplication.R;
import tcd.project.myapplication.activity.HomeActivity;
import tcd.project.myapplication.models.ItemModel;
import tcd.project.myapplication.views.fragment.delivery.FragmentDeliveryView;
import tcd.project.myapplication.views.fragment.delivery.FragmentDeliveryViewCallback;
import tcd.project.myapplication.views.fragment.delivery.FragmentDeliveryViewInterface;


public class FragmentDelivery extends BaseFragment<FragmentDeliveryViewInterface, BaseParameters> implements FragmentDeliveryViewCallback, LocationListener, OnMapReadyCallback {
    private HomeActivity homeActivity;
    private LocationManager locationManager;
    private String provider;
    private GoogleMap map;
    private ItemModel model;

    public static FragmentDelivery newInstance(ItemModel model) {

        Bundle args = new Bundle();
        args.putSerializable("model", model);
        FragmentDelivery fragment = new FragmentDelivery();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initialize() {
        homeActivity = (HomeActivity) getActivity();
        view.init(homeActivity, this);
        Bundle bundle = getArguments();
        if (bundle != null) {
            model = (ItemModel)bundle.getSerializable("model");
        }
        locationManager = (LocationManager) homeActivity.getSystemService(Context.LOCATION_SERVICE);

        provider = locationManager.getBestProvider(new Criteria(), false);

        if (ActivityCompat.checkSelfPermission(homeActivity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(homeActivity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            checkLocationPermission();
            return;
        }

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    protected FragmentDeliveryViewInterface getViewInstance() {
        return new FragmentDeliveryView();
    }

    @Override
    public void onBackHeader() {
        if (homeActivity != null) {
            homeActivity.checkBack();
        }
    }

    @Override
    public void onChangeFragmentEnd(String timeStart,String totalTimer) {
        if (homeActivity != null) {
            if (!TextUtils.isEmpty(timeStart)) {
                model.setTimeStart(timeStart);
            }
            if (!TextUtils.isEmpty(totalTimer)) {
                model.setTotalTime(totalTimer);
            }
            homeActivity.onChangeFragmentEnd(model);
        }
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(homeActivity,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(homeActivity,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new AlertDialog.Builder(homeActivity)
                        .setTitle("title_location_permission")
                        .setMessage("text_location_permission")
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(homeActivity,
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_LOCATION);
                            }
                        })
                        .create()
                        .show();


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(homeActivity,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(homeActivity,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        //Request location updates:
                        locationManager.requestLocationUpdates(provider, 400, 1, this);
                    }

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                }
                return;
            }

        }
    }

    double dLatitude = 0;
    double dLongitude = 0;

    @Override
    public void onLocationChanged(@NonNull @NotNull Location location) {
        //view.setDataLocation(location.getLatitude(), location.getLongitude());
        dLatitude = location.getLatitude();
        dLongitude = location.getLongitude();
    }


    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public void onResume() {
        super.onResume();
//        if (ContextCompat.checkSelfPermission(homeActivity,
//                Manifest.permission.ACCESS_FINE_LOCATION)
//                == PackageManager.PERMISSION_GRANTED) {
//
//            locationManager.requestLocationUpdates(provider, 400, 1, this);
//        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (ContextCompat.checkSelfPermission(homeActivity,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

            locationManager.removeUpdates(this);
        }
    }

    //private LatLng POINT_A = new LatLng(10.839062, 106.782454);

    // private LatLng POINT_B = new LatLng(10.839062, 106.782454);

    @Override
    public void onMapReady(@NonNull @NotNull GoogleMap googleMap) {
        map = googleMap;
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        if (ActivityCompat.checkSelfPermission(homeActivity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(homeActivity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            checkLocationPermission();
            return;
        }
        map.setMyLocationEnabled(true);
        map.getUiSettings().setMapToolbarEnabled(false);

        map.addMarker(new MarkerOptions().position(new LatLng(dLatitude, dLongitude))
                .title("My Location").icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(dLatitude, dLongitude), 10));

        Log.e("aaaaa", dLatitude + " - " + dLongitude);
//        LatLngBounds.Builder builder = new LatLngBounds.Builder();
//        builder.include(POINT_A);
//        builder.include(POINT_B);
//        LatLngBounds bounds = builder.build();
//        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, 200);
//
//        map.moveCamera(cu);
//        map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);

    }

}
