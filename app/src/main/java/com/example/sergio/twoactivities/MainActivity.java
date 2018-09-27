package com.example.sergio.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;//Place the cursor on the word "Log" and press Alt-Enter 
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG =MainActivity.class.getSimpleName();// con eso no s da el nombre de la actividad
    //PONER LOG_TAG EN MAYUS. es privada porque solo queremos utilizar en esta clase Main
    public static final String EXTRA_MESSAGE = "message";

    // se le puede llamar desde cualquier otra clase, static quire decir que esa variable siempre valdrá
    //lo mismo. EJ: static int x=2, da igual todos los objetos distintos de esa clase(persona:p1p2p3) esa variable valdrá
    // 2 en todas de ellas, si en una de ellas cambio de x=2 a x=4 ahora cambia en todas las personas x de 2 a 4
    //el FINAL ES para declarar constantes, no se puede cambiar los valores una vez asignados , no puedo hacer
    //EXTRA_MESSAGE ES OTRA COSA
    //SIMPLEMENTE PONIENDO MainAc...EXTRA_MESSAGE  lo recojemos

    private EditText mEditText; // se le pone m es por los programadores de android, quiere decir que esa variable es de esa instancia
    // m que se ade tu clase entera
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hacer esto siempre oOJO!!!!!
        mEditText=findViewById(R.id.editText_main);//enlazo mi variable editrtet con la parte grafica
    }


    public void launchSecondActivity(View view) {
        Log.e(LOG_TAG, "Botón presionado");
        //Log.e("MAINACTIVITY", "ieeeeeeeeeeeeeeeeeeeeeeeeee");
        //con log que salgan por logcat
        //log.d d es de debug si es log.e será de error, mostradoen rojo
        //PONER ESA LINEA!!! SIEMPRE
        String message = mEditText.getText().toString();
        //pasar esos valores de atras al intent:
        Intent intent = new Intent(this, Main2Activity.class);


        //SIGUIENTE LINEA PARA ENVIAR ACTIVIDADES


        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        // SE USA EN CLASES QUE EXTIENDAN DE ACTIVITY
        //SI LA CASE NO EXTIENDE DE ACTIVITY NO SE PUEDE PONER lo anterior
        //startActivities() seria para mas de una a la vez


    }
    //para mostrar el mensaje del main2activity en el main activity 1
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
