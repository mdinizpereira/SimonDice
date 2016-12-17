package com.example.simoncolor;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.media.MediaPlayer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import java.util.ArrayList;
import android.support.v7.app.AppCompatActivity;

/**
 *
 */
public class mainColores extends AppCompatActivity implements OnClickListener{
    Button inicio, azul, rojo, verde, amarillo;
    TextView explicacion;
    MediaPlayer mpred, mpblue, mpyellow, mpgreen;
    int vuelta = 0;
    ArrayList <Integer> simondice = new ArrayList();
    ArrayList <Integer> contestacion = new ArrayList();

    /**
     * metodo que carga el layout correspondiente e inicizializa los botones
     * tambien le asigna la accion a los botones
     * @param savedInstanceState
     */
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

    /**
     * este metodo identifica que boton utiliza el metodo y le hace parpadear con un color
     * mas claro al suyo, aparte añade al arrayList contestacion un numero predefinido segun el color
     * en caso de ser el boton empezar: vacia el arrayList contestacion, lo deshabilita, llama
     * al metodo nuevocolor() y empieza el numero de vueltas en 0.
     * Cuando el tamaño de ambos arrayList es igual, es decir, el usuario haya pulsado tantas veces
     * como colores "haya dicho simon" comparará los arrayList.
     * @param v recoge el boton que llama al metodo onclick
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.blue:
                parpadear(azul);
                contestacion.add(1);
                break;
            case R.id.red:
                parpadear(rojo);
                contestacion.add(2);
                break;
            case R.id.green:
                parpadear(verde);
                contestacion.add(3);
                break;
            case R.id.yellow:
                parpadear(amarillo);
                contestacion.add(4);
                break;
            case R.id.button:
                if(!contestacion.isEmpty()){
                    contestacion.clear();
                }
                v.setEnabled(false);
                nuevocolor();
                explicacion.setText(String.valueOf(vuelta));
                explicacion.setTextSize(24);
                break;
        }
        if (simondice.size() == contestacion.size()) {
            // muestra un toast y limpia el array de contestacion sumando 1 al numero de vueltas y enseña un nuevo color
            if (simondice.equals(contestacion)) {
                Toast.makeText(getApplicationContext(), "Bien hecho!", Toast.LENGTH_SHORT).show();
                contestacion.clear();
                vuelta = vuelta + 1;
                explicacion.setText(String.valueOf(vuelta));

                v.postDelayed(new Runnable() {
                    public void run() {
                        nuevocolor();
                    }
                }, 1300);
            //muestra un toast, limpia los arrayList, vuelve a poner el boton empezar habilitado y vuelve a
                // poner el numero de vueltas a 0
            } else {
                Toast.makeText(getApplicationContext(), "Fallaste! vuelve a empezar", Toast.LENGTH_SHORT).show();
                contestacion.clear();
                simondice.clear();
                inicio.setEnabled(true);
                vuelta = 0;
                explicacion.setText(String.valueOf(vuelta));
            }
        }
    }

    /**
     * este metodo reproduce un sonido y cambia el color del boton que se pasa como parametro
     * al medio segundo vuelve a su color original
     * @param bflash esta variable recoge el boton que debe parpadar
     */
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
        //con el siguiente codigo vuelve a su color inicial pasados 500 ms
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

    /**
     * este metodo crea un numero aleatorio entre 1 y 4, lo añade al arrayList simondice y
     * directamente segun el numero creado hace parpadear el ultimo boton que se ha de pulsar
     */
    public void nuevocolor() {
        int valor = (int) Math.round(Math.random() * 3) + 1;
        simondice.add(valor);
        switch (valor) {
            case 1:
                parpadear(azul);
                break;
            case 2:
                parpadear(rojo);
                break;
            case 3:
                parpadear(verde);
                break;
            case 4:
                parpadear(amarillo);
                break;
        }
    }

}
