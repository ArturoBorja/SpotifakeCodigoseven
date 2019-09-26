package com.example.tecsup.spotifakecodigoseven;

import android.app.DownloadManager;
import android.content.Intent;
import android.inputmethodservice.ExtractEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

public class Library extends AppCompatActivity {
    RequestQueue mRequestQueue;
    ListView lv_library;
    List<String> playlists;
    PlaylistAdapter library_adapter;

    Button button_library_artista;
    Button button_library_album;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        Builder();

        button_library_artista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inntent_artista=new Intent(Library.this,LibrArtist.class);
                startActivityForResult(inntent_artista,2);
             finish();

            }
        });
        button_library_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inntent_album=new Intent(Library.this,library_album.class);
                startActivityForResult(inntent_album,3);
              finishActivity(1);
            }
        });

    }
    public void Builder(){
        lv_library=findViewById(R.id.lv_library);
        playlists=new ArrayList<>();
        library_adapter=new PlaylistAdapter(this,R.layout.playlist_item,playlists);
        lv_library.setAdapter(library_adapter);
        //playlists.add("hola");
       // playlists.add("hola");
      //  playlists.add("hola");
        //library_adapter.notifyDataSetChanged();
        ExtraerJSON("a");

        button_library_artista = findViewById(R.id.button_library_album_artista);
        button_library_album = findViewById(R.id.button_library_album);
    }
    private void ExtraerJSON(String urlspoty) {
        Log.e("chau","z");
        Response.Listener<String> response_listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Log.e("hola","z");
                    JSONArray items = new JSONObject(response).getJSONArray("items");
                    System.out.println("*****JARRAY*****"+items.length());
                    for(int i=0;i<items.length();i++){
                        JSONObject json_data = items.getJSONObject(i);
                        playlists.add(json_data.getString("name"));
                    }
                    library_adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };


        Response.ErrorListener response_error_listener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    //TODO
                } else if (error instanceof AuthFailureError) {
                    //TODO
                } else if (error instanceof ServerError) {
                    //TODO
                } else if (error instanceof NetworkError) {
                    //TODO
                } else if (error instanceof ParseError) {
                    //TODO
                }
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                "https://api.spotify.com/v1/me/playlists",
                response_listener,response_error_listener)
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("Accept", "application/json");
                params.put("Content-Type", "application/json");
                params.put("Authorization", "Bearer BQCqzu3BoPBdAELYl1OVfTFnF8eQloPF0t_vZmGRZ6CeohfXFwlPKln6Ig-Ou_LG1JVyWqc_fTj5wQ05_-C1p37bLJWPVkgWdbwf_2LQua6yNTReafLLhoBS-23a0JxkB1qlPMR48Al5q-Jsl7SnsGXgcOimROEt4jtdOuW2xV_eB16FNhO71_A");

                return params;
            }
        };

        getRequestQueue().add(stringRequest);
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }


}
