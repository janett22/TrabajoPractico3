package com.example.trabajopractico3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private MainActivityViewModel vm;
private EditText etDolar,etEuros;
private Button btConvertir;
private RadioButton rbDolar,rbEuros;
private TextView tvResultado;
private RadioGroup rbOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDolar = findViewById(R.id.etDolar);
        etEuros = findViewById(R.id.etEuros);
        tvResultado = findViewById(R.id.tvResultado);
        btConvertir = findViewById(R.id.btConvertir);
        rbDolar = findViewById(R.id.rbDolar);
        rbEuros = findViewById(R.id.rbEuros);
        rbOpciones = findViewById(R.id.rbOpciones);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        vm.getEstadoETD().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                etDolar.setEnabled(aBoolean);
                etDolar.setText("");
                etEuros.setText("");
            }
        });

        vm.getEstadoETE().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                etEuros.setEnabled(aBoolean);
                etDolar.setText("");
                etEuros.setText("");
            }
        });

        vm.getConvertidor().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvResultado.setText(s);
            }
        });

    }

      public void convertir(View v){
              vm.convertidor(rbDolar.isChecked(),etDolar.getText().toString(),etEuros.getText().toString());
          }


      public void cambiarEstadoET(View v){
          vm.cambiarEstadoET(v.getId(),rbDolar.getId(),rbEuros.getId());
        }

    }
