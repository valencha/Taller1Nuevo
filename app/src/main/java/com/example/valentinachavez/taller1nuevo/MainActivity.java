package com.example.valentinachavez.taller1nuevo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements Receptor.OnMessage {
    private ImageButton btn_arriba, btn_abajo, btn_derecha, btn_izquierda;
    Cliente c;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c = new Cliente(this);
        c.start();

        btn_arriba = findViewById(R.id.btn_arriba);
        btn_abajo = findViewById(R.id.btn_abajo);
        btn_derecha = findViewById(R.id.btn_derecha);
        btn_izquierda = findViewById(R.id.btn_izquierda);


        btn_arriba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.enviar("arriba");
            }
        });

        btn_abajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.enviar("abajo");
            }
        });
        btn_derecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.enviar("derecha");
            }
        });
        btn_izquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.enviar("izquierda");
            }
        });
    }

    @Override
    public void onReceived(String mensaje) {

    }
}
