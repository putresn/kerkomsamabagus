package com.example.kerkomsamabagus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.kerkomsamabagus.db.MahasiswaBean;

public class DetailDataActivity extends AppCompatActivity {

    EditText nomorInput;
    EditText namaInput;
    EditText tglLahirInput;
    EditText jenkelInput;
    EditText alamatInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);
        nomorInput = findViewById(R.id.tfNomorInputUp);
        namaInput = findViewById(R.id.tfInputNamaUp);
        tglLahirInput = findViewById(R.id.tfNomorInputUp);
        jenkelInput = findViewById(R.id.tfInputJenkelUp);
        alamatInput = findViewById(R.id.tfInputAlamatUp);

        MahasiswaBean bean = getIntent().getParcelableExtra("mahasiswa");

        nomorInput.setText(bean.getIdMahasiswa()+"");
        namaInput.setText(bean.getNama());
        tglLahirInput.setText(bean.getTglLahir());
        jenkelInput.setText(bean.getJenKel());
        alamatInput.setText(bean.getAlamat());
    }
}