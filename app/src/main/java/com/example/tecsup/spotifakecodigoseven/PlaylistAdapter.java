package com.example.tecsup.spotifakecodigoseven;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class PlaylistAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<String> datos;

    public PlaylistAdapter(Context context, int layout, List<String> datos) {
        this.context = context;
        this.layout = layout;
        this.datos = datos;
    }

    @Override
    public int getCount() {        return datos.size();    }

    @Override
    public Object getItem(int i) {        return datos.get(i);    }

    @Override
    public long getItemId(int i) {        return i;    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View v=inflater.inflate(layout,null);
        TextView txt= v.findViewById(R.id.txt_playlist_item);
        txt.setText(datos.get(i));
        return v;
    }
}
