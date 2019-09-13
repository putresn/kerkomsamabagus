package com.example.kerkomsamabagus;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kerkomsamabagus.db.DatabaseHelper;
import com.example.kerkomsamabagus.db.MahasiswaBean;


public class UpdateDataActivity extends AppCompatActivity {
    EditText nomorInput;
    EditText namaInput;
    EditText tglLahirInput;
    EditText jenkelInput;
    EditText alamatInput;
    TextView textSave;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        nomorInput = findViewById(R.id.tfNomerInputDet);
        namaInput = findViewById(R.id.tfInputNamaDet);
        tglLahirInput = findViewById(R.id.tfInputTglLahirDet);
        jenkelInput = findViewById(R.id.tfInputJenkelDet);
        alamatInput = findViewById(R.id.tfInputAlamatDet);
        textSave = findViewById(R.id.textSave);
        context = this;

        MahasiswaBean bean = getIntent().getParcelableExtra("mahasiswa");
        nomorInput.setText(bean.getIdMahasiswa()+"");
        namaInput.setText(bean.getNama());
        tglLahirInput.setText(bean.getTglLahir());
        jenkelInput.setText(bean.getJenKel());
        alamatInput.setText(bean.getAlamat());

        textSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(context);
                db.update(new MahasiswaBean(
                        Integer.valueOf(nomorInput.getText().toString()),
                        namaInput.getText().toString(),
                        tglLahirInput.getText().toString(),
                        jenkelInput.getText().toString(),
                        alamatInput.getText().toString()
                ));
                Intent intent = new Intent(context, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}


