package com.example.tecsup.spotifakecodigoseven;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayList extends AppCompatActivity {
    RequestQueue mRequestQueue;
    ImageView img_playlistmain;
    TextView txt_playlistname;
    TextView txt_playlistautor;
    ListView lv_playlist;
    List<String> canciones;
    PlaylistAdapter playlist_adapter;
    String imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);
        builder();
        ExtraerJSON("a");



    }
    public void builder(){
        img_playlistmain=findViewById(R.id.img_playlistmain);
        txt_playlistautor=findViewById(R.id.txt_playlistautor);
        txt_playlistname=findViewById(R.id.txt_playlistname);
        lv_playlist=findViewById(R.id.lv_playlist);
        canciones=new ArrayList<>();
        playlist_adapter =new PlaylistAdapter(this,R.layout.playlist_item,canciones);
        lv_playlist.setAdapter(playlist_adapter);

    }
    private void ExtraerJSON(String urlspoty) {
        Response.Listener<String> response_listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray items = new JSONObject(response).getJSONObject("tracks").getJSONArray("items");
                    String name = new JSONObject(response).getString("name");
                    txt_playlistname.setText(name);
                    String autor = new JSONObject(response).getJSONObject("owner").getString("display_name");
                    txt_playlistautor.setText(autor);
                    imagen = new JSONObject(response).getJSONArray("images").getJSONObject(1).getString("url");
                    SetImage (imagen);
                    System.out.println("*****JARRAY*****"+items.length());
                    for(int i=0;i<items.length();i++){
                        JSONObject json_data = items.getJSONObject(i).getJSONObject("track");
                        canciones.add(json_data.getString("name"));
                    }
                    playlist_adapter.notifyDataSetChanged();
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
                params.put("Authorization", "Bearer BQBwe9UK3HuadpKVp_9zyKGSsKxw_4xLpghtLLzzz87ieUvuZP_VZ7MTY4xRUQGgSAqXaRO3C-GTs-bdAhDTv2nalHEvIHlsD7jxaOnQSPnWEavoJGrovEApahO3K19KwnasKTfkLvbk7_p-AwKs5skOWGzBwoi4pQCcyLhHH6zgpu3kKtesA1AAQQ4");

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
    public  void SetImage (String url){
        Glide.with(PlayList.this).load(url).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                Drawable originalDrawable = resource;
                Bitmap originalBitmap = ((BitmapDrawable) originalDrawable).getBitmap();
                RoundedBitmapDrawable roundedDrawable = RoundedBitmapDrawableFactory.create(getResources(), originalBitmap);
                roundedDrawable.setCornerRadius(originalBitmap.getHeight());
                img_playlistmain.setImageDrawable(roundedDrawable);
                return true;
            }
        }).into(img_playlistmain);
    }
}
