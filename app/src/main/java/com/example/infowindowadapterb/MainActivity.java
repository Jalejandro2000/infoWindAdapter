package com.example.infowindowadapterb;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener{

    GoogleMap mapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapa = googleMap;
        mapa.getUiSettings().setZoomControlsEnabled(true);

        mapa.setOnMapClickListener(this);


    }

    public void cambiarVista(View view){
        mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mapa.getUiSettings().setZoomControlsEnabled(true);

    }
    public  void moverCamara(View view){
        CameraUpdate camUpt1 = CameraUpdateFactory.newLatLngZoom(new LatLng(-1.01302697037121, -79.46931827031999), 20 );
        mapa.moveCamera(camUpt1);

      //  LatLng uteq = new LatLng(-1.0125584,-79.470437);
        mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012981379941741, -79.4706271882679)).title("Facultad de Ciencias de la Ingeniería")
                .snippet("Decano: Ing. Washington Alberto Chiriboga Casanova, M.Sc. \n " +
                        "Direccion: Av. Quito km. 1 1/2 vía a Santo Domingo de los Tsáchilas"));

        mapa.addMarker(new MarkerOptions().position(new LatLng(-1.0128982444612844, -79.46933168136457)).title("Facultad de Ciencias Agrarias")
                .snippet("Decano: Ing. Leonardo Gonzalo Matute, M.Sc. \n " +
                        "Direccion: Av. Quito km. 1 1/2 vía a Santo Domingo de los Tsáchilas"));

        mapa.addMarker(new MarkerOptions().position(new LatLng(-1.0127427006466205, -79.47001028021961)).title("Facultad de Ciencias Empresariales")
                .snippet("Decana: Ing. Mariela Susana Andrade Arias, PhD. \n " +
                        "Direccion: Av. Quito km. 1 1/2 vía a Santo Domingo de los Tsáchilas"));

        mapa.addMarker(new MarkerOptions().position(new LatLng(-1.0810087185116528, -79.50229117278236)).title("Facultad de Ciencias Pecuarias")
                .snippet("Decana: Ing. Jenny Guiselli Torres Navarrete \n " +
                        "Dirección: Campus “La María”, km 7 vía Quevedo-El Empalme"));

        mapa.setInfoWindowAdapter(new Adapter(MainActivity.this));

    }

    @Override
    public void onMapClick(LatLng latLng) {

        mapa.addMarker(new
                MarkerOptions().position(latLng)
                .title("Punto del mapa")
                .snippet("Nombre del Lugar"));

        Projection proj = mapa.getProjection();
        Point coord = proj.toScreenLocation(latLng);

        Toast.makeText(
                MainActivity.this,
                "Click\n" +
                        "Lat: " + latLng.latitude + "\n" +
                        "Lng: " + latLng.longitude + "\n" +
                        "X: " + coord.x + " - Y: " + coord.y,
                Toast.LENGTH_SHORT).show();
    }
}