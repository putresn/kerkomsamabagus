package com.example.kerkomsamabagus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kerkomsamabagus.db.DatabaseHelper;
import com.example.kerkomsamabagus.db.MahasiswaBean;

public class InputDataActivity extends AppCompatActivity {

    EditText nomorInput;
    EditText namaInput;
    EditText tglLahirInput;
    EditText jenkelInput;
    EditText alamatInput;
    TextView textSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        nomorInput = findViewById(R.id.tfNomerInputDet);
        namaInput = findViewById(R.id.tfInputNamaDet);
        tglLahirInput = findViewById(R.id.tfInputTglLahirDet);
        jenkelInput = findViewById(R.id.tfInputJenkelDet);
        alamatInput = findViewById(R.id.tfInputAlamatDet);
        textSave = findViewById(R.id.textUpdate);

        final DatabaseHelper db = new DatabaseHelper(this);

        textSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.insert(new MahasiswaBean(
                        Integer.valueOf(nomorInput.getText().toString()),
                        namaInput.getText().toString(),
                        tglLahirInput.getText().toString(),
                        jenkelInput.getText().toString(),
                        alamatInput.getText().toString()
                ));

            }
        });
    }
}