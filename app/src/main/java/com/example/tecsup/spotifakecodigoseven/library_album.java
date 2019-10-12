package com.example.tecsup.spotifakecodigoseven;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class library_album extends AppCompatActivity {
    Button button_library_artista;
    Button button_library_playist;
    ListView lv_library;
    List<String> playlists;
    PlaylistAdapter library_adapter;
    Intent intenta;
    String token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_album);
        intenta =getIntent();

        Builder();
        ApretarBotones();


    }

    private void Builder() {
        token = intenta.getStringExtra("token");
        lv_library=findViewById(R.id.lv_library_album);
        playlists=new ArrayList<>();
        playlists.add(token);
        library_adapter=new PlaylistAdapter(this,R.layout.playlist_item,playlists);
        if(library_adapter == null) {
            Log.e("error","lslslsd");
        }else {
            lv_library.setAdapter(library_adapter);
        }
        button_library_artista =findViewById(R.id.button_library_album_artista);
        button_library_playist =findViewById(R.id.button_library_album_playlist);



    }
    public  void ApretarBotones(){
        button_library_playist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 =new Intent(library_album.this,Library.class);
                intent5.putExtra("token",token);
                startActivityForResult(intent5,5);
                finish();
            }

        });

        button_library_artista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 =new Intent(library_album.this,LibrArtist.class);
                intent6.putExtra("token",token);
                startActivityForResult(intent6,6);
                finish();
            }
        });
    }
}
