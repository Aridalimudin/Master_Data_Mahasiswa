package com.example.projectuas;

import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UbahActivity extends AppCompatActivity {

    protected Cursor cursor;
    Database database;
    Button btn_ubah;
    EditText nama, jurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah);

        database = new Database(this);
        nama = findViewById(R.id.nama);
        jurusan = findViewById(R.id.jurusan);
        btn_ubah = findViewById(R.id.btn_ubah);
        SQLiteDatabase db = database.getReadableDatabase();

        cursor = db.rawQuery("SELECT * FROM mahasiswa WHERE nama = '"+
                getIntent().getStringExtra( "nama")+"'", null);
        cursor.moveToFirst();
        if(cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            nama.setText(cursor.getString(0).toString());
            jurusan.setText(cursor.getString(1).toString());;
        }

        btn_ubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("update mahasiswa set nama='" +
                        nama.getText().toString() +"', jurusan= '" +
                        jurusan.getText().toString() +"'where nama ='"+
                        getIntent().getStringExtra("nama")+ "'");
                Toast.makeText(UbahActivity.this, "Data berhasil diubah", Toast.LENGTH_SHORT).show();
                MahasiswaActivity.mahasiswaActivity.RefreshList();
                finish();
            }
        });
    }
}