package com.example.turco;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int pontosUm;
    int pontosDois;

    TextView textoUm;
    TextView textoDois;

    TextView editPontos;

    TextView editEquipeUm;
    TextView editEquipeDois;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textoUm = findViewById(R.id.pontosEquipeUm);
        textoDois = findViewById(R.id.pontosEquipeDois);

        editPontos = findViewById(R.id.editPontos);
        editEquipeDois = findViewById(R.id.editEquipe2);
        editEquipeUm = findViewById(R.id.editUm);


        pontosUm = 0;
        pontosDois = 0;
    }

    public void adicionarNumeroUm(View view){

        if (verificacao()){
            int proximoNumero = pontosUm + 1;


                pontosUm = proximoNumero;


            textoUm.setText(String.valueOf(proximoNumero));

            encontraVencedor();

        }

    }

    public void adicionarNumeroDois(View view){

        if (verificacao()){
            int proximoNumero = pontosDois + 1;


                pontosDois = proximoNumero;

            textoDois.setText(String.valueOf(proximoNumero));

            encontraVencedor();
        }
    }

    public void diminuirNumeroUm(View view){

        if (verificacao()){
            int proximoNumero = pontosUm - 1;

            if (proximoNumero > 0){
                pontosUm = proximoNumero;
                textoUm.setText(String.valueOf(proximoNumero));
            }


        }

    }

    public void diminuirNumeroDois(View view){

        if (verificacao()){
            int proximoNumero = pontosDois - 1;

            if (proximoNumero >= 0){
                pontosDois = proximoNumero;
                textoDois.setText(String.valueOf(proximoNumero));
            }


        }


    }

    public boolean verificacao(){
        if (editEquipeUm.getText().toString().isEmpty() || editEquipeDois.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Adicione os nomes primeiro", Toast.LENGTH_SHORT).show();
            return false;
        }else if (editPontos.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Sem pontuação máxima", Toast.LENGTH_SHORT).show();
            return false;
        }

        try {
            int num = Integer.parseInt(editPontos.getText().toString());
        }catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(), "Pontuação máxima invalida", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public void encontraVencedor (){

        int pontosMaximo = Integer.parseInt(editPontos.getText().toString());

        Intent intent = new Intent(this, MainActivity2.class);

        if (pontosUm>=pontosMaximo){
            intent.putExtra("Vencedor", editEquipeUm.getText().toString());
            startActivity(intent);

        }else if (pontosDois >= pontosMaximo){
            intent.putExtra("Vencedor", editEquipeDois.getText().toString());
            startActivity(intent);

        }

    }

    public void reiniciar(View view){

        pontosUm = 0;
        pontosDois = 0;

        textoUm.setText("0");
        textoDois.setText("0");

        editPontos.setText("");
        editEquipeDois.setText("");
        editEquipeUm.setText("");

    }


}