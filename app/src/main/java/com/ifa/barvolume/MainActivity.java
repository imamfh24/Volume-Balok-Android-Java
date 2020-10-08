package com.ifa.barvolume;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtPanjang, edtLebar, edtTinggi;
    private Button btnCalculate;
    private TextView tvHasil;
    private static final String STATE_RESULT = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasikan view dan ambil Id dari view
        edtPanjang = findViewById(R.id.et_panjang);
        edtLebar = findViewById(R.id.et_lebar);
        edtTinggi = findViewById(R.id.et_tinggi);
        btnCalculate = findViewById(R.id.btn_jumlah);
        tvHasil = findViewById(R.id.tv_result);

        // Memberikan event pada button
        btnCalculate.setOnClickListener(this);

        if(savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            tvHasil.setText(result);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_jumlah){ // Cek apakah ketika view on click ditekan dan yang ditekan adalah id btn_jumlah?
            // Simpan input kedalam string
            String inputPanjang = edtPanjang.getText().toString().trim();
            String inputLebar = edtLebar.getText().toString().trim();
            String inputTinggi = edtTinggi.getText().toString().trim();

            boolean isEmptyFields = false; // Mengatur kondisi apakah inputan kosong atau tidak, jika kosong true dan jika tidak maka false
            boolean isInvalidDouble = false; // Menandakan apakah yang diinput berupa nomor

            if(TextUtils.isEmpty(inputPanjang)){ // Jika input field panjang kosong maka set error
                isEmptyFields = true;
                edtPanjang.setError("Field ini tidak boleh kosong");
            }

            if(TextUtils.isEmpty(inputLebar)){ // Jika input field lebar kosong maka set error
                isEmptyFields = true;
                edtLebar.setError("Field ini tidak boleh kosong");
            }

            if(TextUtils.isEmpty(inputTinggi)){ // Jika input field tinggi kosong maka set error
                isEmptyFields = true;
                edtTinggi.setError("Field ini tidak boleh kosong");
            }

            // Menyimpan data string inputan menjadi double
            Double length = toDouble(inputPanjang);
            Double width = toDouble(inputLebar);
            Double height = toDouble(inputTinggi);

            if(length == null){ // Jika panjang diinputkan null maka field error
                isInvalidDouble = true;
                edtPanjang.setError("Field ini harus berupa nomor yang valid");
            }

            if(width == null){ // Jika lebar diintputkan null maka field error
                isInvalidDouble = true;
                edtLebar.setError("Field ini harus berupa nomor yang valid");
            }

            if(height == null){ // Jika tinggi diinputkan null maka field error
                isInvalidDouble = true;
                edtTinggi.setError("Field ini harus berupa nomor yang valid");
            }

            if(!isEmptyFields && !isInvalidDouble){ // Jika isempty false dan isinvaliddouble false maka jalankan
                double volume = length * width * height;
                tvHasil.setText(String.valueOf(volume));
            }
        }
    }

    private Double toDouble(String str) { // Function untuk merubah double menjadi string
        try{
            return Double.valueOf(str);
        } catch (NumberFormatException e){
            return null;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) { // function untuk mempertahankan nilai
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvHasil.getText().toString());
    }
}