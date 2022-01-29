package com.example.infowindowadapterb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.squareup.picasso.Picasso;

import java.io.IOException;


public class Adapter implements GoogleMap.InfoWindowAdapter {
    private Context context;

    public Adapter(Context context) {
        this.context = context;
    }


    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker)  {

        View view = ((Activity)context).getLayoutInflater().inflate(R.layout.info, null);
        TextView titulo = view.findViewById(R.id.txtTitulo);
        TextView descripcion = view.findViewById(R.id.txtDescripcion);
        titulo.setText(marker.getTitle());
        descripcion.setText(marker.getSnippet());

        String principal = titulo.toString();
        ImageView imagen = (ImageView) view.findViewById(R.id.Img_cuadro);
/*        try {
            Bitmap bitmap = Picasso.get().load("http://i.imgur.com/DvpvklR.png").error(R.drawable.common_full_open_on_phone).get();
            imagen.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        Handler uiHandler = new Handler(Looper.getMainLooper());
        uiHandler.post(new Runnable(){
            @Override
            public void run() {
                Picasso.get()
                        .load("http://i.imgur.com/DvpvklR.png")
                        .into(imagen);
            }
        });


        imagen.refreshDrawableState();
        return view;
    }


}
