package com.exemple.profedam.explicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  implements
        View.OnClickListener {


    public final int REQUEST_CODE = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnCallActivity = (Button) findViewById (R.id.startintent);
        btnCallActivity.setOnClickListener(this);


    }

    @Override
    public void onClick (View v)
    {

        Intent intent = new Intent (this, ResultActivity.class);

        EditText etInput = (EditText) findViewById(R.id.inputforintent);
        intent.putExtra ("nombre", etInput.getText().toString());
        //startActivity(intent);
       startActivityForResult(intent, REQUEST_CODE);
        // finish(); Esto finalizaría la activity1 y no quedaría por debajo
        // de la segunda Activity;

    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ((requestCode == this.REQUEST_CODE) && (resultCode == RESULT_OK))
        {
            Button btnCallActivity = (Button) findViewById (R.id.startintent);
            btnCallActivity.setText (data.getStringExtra("saludo"));
        }

        super.onActivityResult(requestCode, resultCode, data);

    }
    */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if ((requestCode == this.REQUEST_CODE) && (resultCode == RESULT_OK))
        {
            Button btnCallActivity = (Button) findViewById (R.id.startintent);
            btnCallActivity.setText (data.getStringExtra("saludo"));
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
