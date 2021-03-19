/* Bruno Ricardo Corrêa RA:19118
*  Esse é o original!
*/


package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class imcCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnCalcularOnClick(View v){
        TextView imcResult = findViewById(R.id.imcResult);
        EditText pesoInput = findViewById(R.id.pesoInput);
        EditText alturaInput = findViewById(R.id.alturaInput);
        int peso;
        float altura,resultado = 0;

        try{
            peso = Integer.parseInt(pesoInput.getText().toString());
            altura = Float.parseFloat(alturaInput.getText().toString());
            resultado = peso / (altura * altura);
            imcResult.setText(String.valueOf(resultado));
        }
        catch(NumberFormatException nfe){
            imcResult.setText(R.string.validar_valores);
        }

        if(!Float.isNaN(resultado)){
            if (resultado < 18.5) {
                imcResult.setTextColor(Color.rgb(180,20,20));
                imcResult.setText(R.string.abaixo_do_peso);
            }
            else if ((resultado >= 18.5) && (resultado < 25)){
                imcResult.setTextColor(Color.rgb(55,221,47));
                imcResult.setText(R.string.peso_correto);
            }
            else if ((resultado >= 25) && (resultado < 30)){
                imcResult.setTextColor(Color.rgb(241,199,27));
                imcResult.setText(R.string.acima);
            }
            else if ((resultado >= 30) && (resultado < 35)){
                imcResult.setTextColor(Color.rgb(243,139,24));
                imcResult.setText(R.string.obesidade1);
            }
            else if ((resultado >= 35) && (resultado < 40)){
                imcResult.setTextColor(Color.rgb(203,96,65));
                imcResult.setText(R.string.obesidade2);
            }
            else {
                imcResult.setTextColor(Color.rgb(200,10,10));
                imcResult.setText(R.string.obesidade_morbida);
            }
        }
        else {
            imcResult.setText(R.string.validar_valores);
        }

        //fonte: https://www.montarumblog.com/wp-content/uploads/2012/05/tabela-imc1.jpg
    }
}