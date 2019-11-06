package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mengenali tombol
        final Button buttonLakukan = (Button) findViewById(R.id.buttonLakukan);
        final RadioGroup radioGroupOperasi = (RadioGroup) findViewById(R.id.radioGroupOperasi);
        final EditText editTextBilangan1 = (EditText) findViewById(R.id.editBilangan1);
        final EditText editTextBilangan2 = (EditText) findViewById(R.id.editBilangan2);

        //membuat action button
        buttonLakukan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                if (editTextBilangan1.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(), "Masukkan bilangan 1", Toast.LENGTH_LONG).show();
                }
                else if (editTextBilangan2.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(), "Masukkan bilangan 2", Toast.LENGTH_LONG).show();
                }
                else if (radioGroupOperasi.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(), "Pilih operasi terlebih dahulu", Toast.LENGTH_LONG).show();
                }
                else{
                    RadioButton selectedButton = (RadioButton) findViewById(radioGroupOperasi.getCheckedRadioButtonId());
                    Integer bilangan1 = Integer.parseInt((editTextBilangan1.getText().toString()));
                    Integer bilangan2 = Integer.parseInt((editTextBilangan2.getText().toString()));
                    String operasi = selectedButton.getText().toString();
                    Integer hasil = 0;

                    switch(operasi){
                        case "Penjumlahan" : hasil = bilangan1 + bilangan2; break;
                        case "Pengurangan" : hasil = bilangan1 - bilangan2; break;
                        case "Perkalian" : hasil = bilangan1 * bilangan2; break;
                        case "Pembagian" : hasil = bilangan1 / bilangan2; break;
                    }

                    String ditampilkan = "Hasil "+operasi+" adalah : "+hasil;

                    Toast toast = Toast.makeText(getApplicationContext(), ditampilkan, Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}
