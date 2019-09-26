package com.example.tecsup.spotifakecodigoseven;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class library_album extends AppCompatActivity {
    Button button_library_album;
    Button button_library_artista;
    Button button_library_playist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_album);


        Builder();
        button_library_playist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inntent =new Intent(library_album.this,Library.class);
                startActivityForResult(inntent,4);
                finish();
            }

        });

       button_library_artista.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent3 =new Intent(library_album.this,LibrArtist.class);
               startActivityForResult(intent3,3);
               finish();
           }
       });

    }

    private void Builder() {
        button_library_album =findViewById(R.id.button_library_album_album);
        button_library_artista =findViewById(R.id.button_library_album_artista);
        button_library_playist =findViewById(R.id.button_library_album_playlist);



    }
}
