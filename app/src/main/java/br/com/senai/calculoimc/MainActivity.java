package br.com.senai.calculoimc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etPeso;
    private EditText etAltura;
    private Button btCalcular;
    private IMC imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);
        btCalcular = findViewById(R.id.btCalcular);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etPeso == null) {
                    Toast.makeText(MainActivity.this, 
                            "Preencha seu peso", Toast.LENGTH_SHORT).show();
                } else if (etAltura == null) {
                    Toast.makeText(MainActivity.this,
                            "Preencha sua altura", Toast.LENGTH_SHORT).show();
                } else {
                    String inputPeso = etPeso.getText().toString();
                    float peso = Float.parseFloat(inputPeso);

                    String inputAltura = etAltura.getText().toString();
                    float altura = Float.parseFloat(inputAltura);

                    MainActivity.this.calcularIMC(peso, altura);
                }

                
            }
        });
    }

    private void calcularIMC(float peso, float altura) {
        this.imc = new IMC(peso, altura);
        this.imc.calcular();
        this.exibirResultado();
    }

    private void exibirResultado() {
        String msg = String.format("Seu IMC é %.2f", this.imc.getResultado());

        AlertDialog.Builder janela = new AlertDialog.Builder(this);
        janela.setTitle("Resultado do IMC");
        janela.setMessage(msg);

        janela.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                etPeso.setText("");
                etAltura.setText("");
            }
        });

        AlertDialog alertDialog = janela.create();
        alertDialog.show();
    }



}