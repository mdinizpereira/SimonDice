package com.example.simoncolor;

import android.graphics.Color;
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
    public void parpadear(final Button bflash) {
        if (bflash == azul) {
            mpblue = MediaPlayer.create(this,R.raw.azul);
            mpblue.start();
            bflash.setBackgroundColor(Color.parseColor("#A9D0F5"));
        } else if (bflash == rojo) {
            mpred = MediaPlayer.create(this, R.raw.rojo);
            mpred.start();
            bflash.setBackgroundColor(Color.parseColor("#F5A9A9"));
        } else if (bflash == verde) {
            mpgreen = MediaPlayer.create(this, R.raw.verde);
            mpgreen.start();
            bflash.setBackgroundColor(Color.parseColor("#A9F5A9"));
        } else if (bflash == amarillo) {
            mpyellow = MediaPlayer.create(this, R.raw.amarillo);
            mpyellow.start();
            bflash.setBackgroundColor(Color.parseColor("#F2F5A9"));
        }

        bflash.postDelayed(new Runnable() {
            public void run() {
                if (bflash == azul)
                    bflash.setBackgroundColor(Color.parseColor("#01A9DB"));
                else if (bflash == rojo)
                    bflash.setBackgroundColor(Color.parseColor("#DF0101"));
                else if (bflash == verde)
                    bflash.setBackgroundColor(Color.parseColor("#01DF01"));
                else if (bflash == amarillo)
                    bflash.setBackgroundColor(Color.parseColor("#D7DF01"));
            }
        }, 500);
    }

}
