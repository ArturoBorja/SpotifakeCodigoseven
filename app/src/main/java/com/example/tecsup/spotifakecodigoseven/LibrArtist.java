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
    Button button_LibrArtist_playlist;
    ListView lv_librartist;
    PlaylistAdapter library_adapter;
    Intent intentb ;
    String token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libr_artist);
        intentb = getIntent();
        Builder();
        ApretarBotones();


    }
    public void Builder(){
        token=intentb.getStringExtra("token");
        lv_librartist=findViewById(R.id.lv_library_artist);
        playlists=new ArrayList<>();
        playlists.add(token);
        library_adapter=new PlaylistAdapter(this,R.layout.playlist_item,playlists);
        lv_librartist.setAdapter(library_adapter);
        button_LibrArtist_album =findViewById(R.id.button_library_artist_album);
        button_LibrArtist_playlist =findViewById(R.id.button_library_artist_playlist);


    }
    public void ApretarBotones(){
        button_LibrArtist_playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 =new Intent(LibrArtist.this,Library.class);
                intent3.putExtra("token",token);
                startActivityForResult(intent3,3);
                finish();
            }
        });
        button_LibrArtist_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 =new Intent(LibrArtist.this,library_album.class);
                startActivityForResult(intent4,4);

                intent4.putExtra("token",token);
                finish();
            }
        });


    }

}
