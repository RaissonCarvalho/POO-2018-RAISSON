package com.example.raissoncarvalho.atividadel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edValorDigitado;
    private TextView tvNumero;
    private Button btnIncrementar;
    private Button btnDecrementar;
    private Button btnToast;

    private int valorAtual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();

        btnIncrementar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    valorAtual += Integer.parseInt(edValorDigitado.getText().toString());
                    tvNumero.setText(String.valueOf(valorAtual));

                }catch (NumberFormatException e){

                    Toast.makeText(getApplicationContext(), "Digite um número", Toast.LENGTH_SHORT).show();

                }

            }
        });

        btnDecrementar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    valorAtual -= Integer.parseInt(edValorDigitado.getText().toString());
                    tvNumero.setText(String.valueOf(valorAtual));

                }catch (NumberFormatException e){

                    Toast.makeText(getApplicationContext(), "Digite um número", Toast.LENGTH_SHORT).show();

                }

            }
        });

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), String.valueOf(valorAtual), Toast.LENGTH_LONG).show();

            }
        });

    }

    private void setupViews(){

        edValorDigitado = findViewById(R.id.ed_valor);
        tvNumero = findViewById(R.id.tv_numero);
        btnIncrementar = findViewById(R.id.btn_incremento);
        btnDecrementar = findViewById(R.id.btn_decremento);
        btnToast = findViewById(R.id.btn_toast);

        tvNumero.setText(String.valueOf(valorAtual));

    }
}
