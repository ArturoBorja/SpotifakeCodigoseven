package com.example.tecsup.spotifakecodigoseven;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.IntStream.builder;

public class LibrArtist extends AppCompatActivity {
    List<String> playlists;
    Button button_LibrArtist_album;
    Button button_LibrArtist_artista;
    Button button_LibrArtist_playlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libr_artist);
        Builder();
        ApretarBotones();


    }
    public void Builder(){
        playlists=new ArrayList<>();
        button_LibrArtist_album =findViewById(R.id.button_library_album_album);
        button_LibrArtist_artista =findViewById(R.id.button_library_album_artista);
        button_LibrArtist_playlist =findViewById(R.id.button_library_album_playlist);


    }
    public void ApretarBotones(){
        button_LibrArtist_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inntent4 =new Intent(LibrArtist.this,library_album.class);
                startActivityForResult(inntent4,5);
                finish();
            }
        });

        button_LibrArtist_playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 =new Intent(LibrArtist.this,Library.class);
                startActivityForResult(intent5,6);
                finish();


            }
        });
    }

}
