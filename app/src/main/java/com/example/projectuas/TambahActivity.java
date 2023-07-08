package com.example.projectuas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TambahActivity extends AppCompatActivity {

    protected Cursor cursor;
    Database database;
    Button btn_tambah;
    EditText nama, jurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        database = new Database(this);
        nama = findViewById(R.id.nama);
        jurusan = findViewById(R.id.jurusan);
        btn_tambah = findViewById(R.id.btn_tambah);

        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("insert into mahasiswa (nama, jurusan) values ('" +
                        nama.getText().toString() + "','" +
                        jurusan.getText().toString() + "')");
                Toast.makeText(TambahActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                MahasiswaActivity.mahasiswaActivity.RefreshList();
                finish();
            }
        });
    }
}
