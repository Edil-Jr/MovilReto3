package com.example.reto2.ui.servicios;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.reto2.BuildConfig;
import com.example.reto2.FormActivity;
import com.example.reto2.R;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

public class ServiciosFragment extends Fragment {
    private ServiciosViewModel serviciosViewModel;
    private MapView myOpenMapView;
    private MapController myMapController;
/*
    public ServiciosFragment(MapView myOpenMapView, MapController myMapController) {
        this.myOpenMapView = myOpenMapView;
        this.myMapController = myMapController;
    }
*/

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        serviciosViewModel =
                new ViewModelProvider(this).get(ServiciosViewModel.class);

        View root = inflater.inflate(R.layout.fragment_service, container, false);

        final TextView textView = root.findViewById(R.id.ServiciosMap);
        serviciosViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
                Toast.makeText(getContext(), "Proximamente nuestras ubicaciones", Toast.LENGTH_SHORT).show();
            }
        });
/*
        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);
        GeoPoint Bogota = new GeoPoint(4.6351,-74.0703);


        myOpenMapView = (MapView) root.findViewById(R.id.openmapview);
        myOpenMapView.setBuiltInZoomControls(true);
        myMapController = (MapController) myOpenMapView.getController();
        myMapController.setCenter(Bogota);
        myMapController.setZoom(6);
        myOpenMapView.setMultiTouchControls(true);


        /* -------------------------------------------------------------------------------------------------- */
   /*     final MyLocationNewOverlay myLocationoverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(getApplicationContext()), myOpenMapView);
        myOpenMapView.getOverlays().add(myLocationoverlay); //No añadir si no quieres una marca
        myLocationoverlay.enableMyLocation();

        myLocationoverlay.runOnFirstFix(new Runnable() {
            public void run() {
                myMapController.animateTo(myLocationoverlay.getMyLocation());
            }
        });
        /* -------------------------------------------------------------------------------------------------- */



        return root;
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.compras:
                Intent intent = new Intent(getContext(), FormActivity.class);
                intent.putExtra("name","servicios");
                getActivity().startActivity(intent);
                Toast.makeText(getContext(), "Hola estoy en Servicios", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }


    }



}
