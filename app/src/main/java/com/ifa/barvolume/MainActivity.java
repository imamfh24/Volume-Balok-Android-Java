package com.ifa.barvolume;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtPanjang, edtLebar, edtTinggi;
    private Button btnCalculate;
    private TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPanjang = findViewById(R.id.et_tinggi);
        edtLebar = findViewById(R.id.et_lebar);
        edtTinggi = findViewById(R.id.et_tinggi);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_jumlah){ // Cek apakah ketika view on click ditekan dan yang ditekan adalah id btn_jumlah?
            // Simpan input kedalam string
            String inputPanjang = edtPanjang.getText().toString().trim();
            String inputLebar = edtLebar.getText().toString().trim();
            String inputTinggi = edtTinggi.getText().toString().trim();


        }
    }
}
