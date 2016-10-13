package com.exemple.profedam.explicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent i = getIntent();
        String nombre = i.getStringExtra("nombre");

       // Seria millor String nombre = getIntent().getStringExtra("nombre");
        TextView tvTexto = (TextView) findViewById (R.id.displayintentextra);

        // tvTexto.setText ("Saludos " + nombre);

        StringBuilder cadena = new StringBuilder();
        cadena.append("Saludos ");
        cadena.append(nombre);
        String cadenaFinal = cadena.toString();
        tvTexto.setText(cadenaFinal);
        /* o millor
        tvTexto.setText(new StringBuilder().append("Saludos ").append(nombre).toString()); */

    }

    @Override
    public void finish() {

        Intent intent = new Intent();
        TextView tvTexto = (TextView) findViewById (R.id.displayintentextra);
        intent.putExtra ("saludo", tvTexto.getText().toString());
        setResult (this.RESULT_OK, intent);

        super.finish();
    }

}

