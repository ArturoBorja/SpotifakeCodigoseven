package com.example.tecsup.spotifakecodigoseven;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import interfaceHomeEscuchadoRecientementeSpotifyApi.HomeEscuchadoRecientemente;
import modelHomeEscuchadoRecientemente.Items;
import modelHomeEscuchadoRecientemente.RecientementeEscuchado;
import modelHomeEscuchadoRecientemente.Track;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Home extends AppCompatActivity {

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.spotify.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HomeEscuchadoRecientemente id = retrofit.create(HomeEscuchadoRecientemente.class);

        Call <RecientementeEscuchado> call = id.getRecientementeEscuchadoId();
        call.enqueue(new Callback<RecientementeEscuchado>() {
            @Override
            public void onResponse(Call<RecientementeEscuchado> call, Response<RecientementeEscuchado> response) {
                if(response.isSuccessful()){
                    Toast.makeText(Home.this,response.code()+"",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(Home.this,response.code()+"",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<RecientementeEscuchado> call, Throwable t) {

            }
        });

    }
}
