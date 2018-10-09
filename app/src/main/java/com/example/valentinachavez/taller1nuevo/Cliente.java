package com.example.valentinachavez.taller1nuevo;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.jar.Attributes;

public class Cliente extends Thread {
    Socket s;
    Receptor r;
    MainActivity activity;
    public Cliente(MainActivity activity){
        this.activity= activity;
    }

    @Override
    public void run() {

        try {
            s = new Socket("10.0.2.2", 5000);
            r= new Receptor(s);
            r.setObserver(activity);
            r.start();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
        public void enviar (final String instruccion) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //ESTE CODIGO SE VA A EJECUTAR EN PARALELO.LAMBDA

                try {

                  OutputStream  os = s.getOutputStream();

                    PrintWriter out = new PrintWriter(new OutputStreamWriter(os));
                    out.println(instruccion);
                    out.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();






        }
    }




