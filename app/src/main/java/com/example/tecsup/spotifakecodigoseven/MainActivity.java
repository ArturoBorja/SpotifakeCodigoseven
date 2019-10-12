package com.example.tecsup.spotifakecodigoseven;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button txt_toplaylist;
    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        token="Bearer BQDfoCbuLOx0B3ii5qhIcyY8ABpHOSfiou6ODTTWiTNuUkh0hz6izKa8cIsY_0S199JmVXreQ2Br28KjeYqeLsuVnt1h05A5hpp3-J9ecxufO4wGuEVdUrYqdh093BJfs8DWe2A9t1_pd9tjZ0U7WKbaVb7iAyoWBsSfmzDUsV8IOxQSPaPHamiECkE";
        txt_toplaylist=findViewById(R.id.txt_toplaylist);
        txt_toplaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,Library.class);
                intent.putExtra("token",token);
                startActivity(intent);
            }
        });
    }
}
