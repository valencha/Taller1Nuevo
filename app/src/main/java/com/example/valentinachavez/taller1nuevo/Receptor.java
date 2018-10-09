package com.example.valentinachavez.taller1nuevo;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Receptor extends Thread {
    Socket socket;

    //PASO 2
    OnMessage observer;

    public Receptor(Socket socket) {

        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            while (true) {
                String line = reader.readLine();
                System.out.println(line);
                Log.e("Recibido", line);
                //paso 4 SOLO FUNCIONA CUANDO OBSERVER NO ES NULO
                observer.onReceived(line);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }


    }


    //PASO 1

    public interface OnMessage {
        public void onReceived(String mensaje);
    }

    //PASO 3
    public void setObserver(OnMessage observer) {

        this.observer = observer;
    }

}



