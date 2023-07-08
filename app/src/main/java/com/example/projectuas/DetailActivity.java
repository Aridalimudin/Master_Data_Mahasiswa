package com.example.projectuas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite. SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    protected Cursor cursor;
    Database database;
    Button btn_detail;
    TextView nama, jurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        database = new Database(this);
        nama = findViewById(R.id.nama);
        jurusan = findViewById(R.id.jurusan);
        btn_detail = findViewById(R.id.btn_detail);
        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM mahasiswa WHERE nama='" +
                getIntent().getStringExtra( "nama")+"'", null);
        cursor.moveToPosition (0);
        nama.setText(cursor.getString(0).toString());
        jurusan.setText(cursor.getString(1).toString());
    }
}

