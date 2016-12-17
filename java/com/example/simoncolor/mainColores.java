package com.example.simoncolor;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.media.MediaPlayer;
import android.view.View;
import android.view.View.OnClickListener;
import android.support.v7.app.AppCompatActivity;

public class mainColores extends AppCompatActivity implements OnClickListener{
    Button inicio, azul, rojo, verde, amarillo;
    TextView explicacion;
    MediaPlayer mpred, mpblue, mpyellow, mpgreen;
    int vuelta = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_colores);
        explicacion = (TextView) findViewById(R.id.explicacion);

        inicio = (Button) findViewById(R.id.button);
        azul = (Button) findViewById(R.id.blue);        //1
        rojo = (Button) findViewById(R.id.red);         //2
        verde = (Button) findViewById(R.id.green);      //3
        amarillo = (Button) findViewById(R.id.yellow);  //4

        azul.setOnClickListener(this);
        rojo.setOnClickListener(this);
        verde.setOnClickListener(this);
        amarillo.setOnClickListener(this);
        inicio.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

    }


}
