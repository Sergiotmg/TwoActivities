package com.example.sergio.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;//Place the cursor on the word "Log" and press Alt-Enter 
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG =MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Botón presionado");
        //con log que salgan por logcat
        //log.d d es de debug si es log.e será de error, mostradoen rojo
        //SIGUIENTE LINEA PARA ENVIAR ACTIVIDADES
        Intent intent = new Intent(this, Main2Activity.class);//THIS PORQUE SIEMPRE
        //PIDE CONTEXTO
        startActivity(intent);// SE USA EN CLASES QUE EXTIENDAN DE ACTIVITY
        //SI LA CASE NO EXTIENDE DE ACTIVITY NO SE PUEDE PONER lo anterior
        //startActivities() seria para mas de una a la vez

    }
}
