package com.example.projectuas;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GmapsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmaps);

        EditText editTextSource = findViewById(R.id.lokasi);
        EditText editTextDestination = findViewById(R.id.tujuan);
        Button button = findViewById(R.id.maps);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lokasi = editTextSource.getText().toString();
                String tujuan = editTextDestination.getText().toString();
                if (lokasi.equals("") && tujuan.equals("")) {
                    Toast.makeText(GmapsActivity.this, "Input Lokasi dan Tujuan anda", Toast.LENGTH_SHORT).show();
                } else {
                    Uri uri = Uri.parse("https://www.google.com/maps/dir/" + lokasi + "/" + tujuan);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }

        });

    }
}