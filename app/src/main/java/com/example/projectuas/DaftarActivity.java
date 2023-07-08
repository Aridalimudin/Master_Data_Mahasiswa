package com.example.projectuas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class DaftarActivity extends AppCompatActivity {
    TextView btn_masuk;
    Button btn_daftar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        btn_masuk = (TextView) findViewById(R.id.btn_masuk);
        btn_daftar1 = (Button) findViewById(R.id.btn_daftar1);

        btn_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent DaftarActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(DaftarActivity);
            }
        });

        btn_daftar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent DaftarActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(DaftarActivity);
            }
        });
    }
}