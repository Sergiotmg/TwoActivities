package com.example.sergio.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {

    public static final String EXTRA_REPLY ="com.example.android.twoactivities.extra.REPLY";

    private TextView textMessage;
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textMessage=findViewById(R.id.textMessage);
        //recoger la variable de la act 1 main
        Intent intent = getIntent();
        //pongo main Activity  yel punto y se autocompleta con la que tenga en el main Activity
        //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        textMessage.setText(getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE));
        mReply=findViewById(R.id.editText_main);
        // lo mostramos ahora en el textview


    }



    //metodo creado pulsando en el activity_main2 con create on clic eventhandler
    // al hacer alt+ enter en
    public void returnData(View view) {
        String reply= mReply.getText().toString();
        // no lo queremos para actividades nuevas y no le pasamos nada dentro del intent
        Intent replyIntent = new Intent();
        //ponerle de nombre a la variable y de valor lo del texto de respuesta
        replyIntent.putExtra(EXTRA_REPLY,reply);
        //volver a la actividad anterior
        setResult(RESULT_OK,replyIntent);
        //setResult(); solo usar cuando sea Cancel, al cancelar el login RESULT_CANCEL y no pasa dat
        //setResult(RESULT_FIRST_USER,); SI HACE algo por 1ª vez el user

        finish();

    }
}
