package com.example.tecsup.spotifakecodigoseven;

import android.app.DownloadManager;
import android.inputmethodservice.ExtractEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Library extends AppCompatActivity {
    TextView txt_library;
    Button btn_buscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        txt_library=findViewById(R.id.txt_library);
        btn_buscar=findViewById(R.id.btn_buscar);
        txt_library.setMovementMethod(new ScrollingMovementMethod());
       btn_buscar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               ExtrarJSON("a");

           }
       });
       
    }
    RequestQueue mRequestQueue;
    private void ExtrarJSON(String urlspoty){
        Response.Listener<String> response_listener =new   Response.Listener<String>(){

        }
    }

}
