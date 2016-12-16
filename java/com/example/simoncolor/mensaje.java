package com.example.simoncolor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Miguel on 16/12/2016.
 */

public class mensaje extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mensaje);

        String respuesta = getIntent().getStringExtra("contestacion");
        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText(respuesta);

    }
}
