package com.ness.petagram.pojo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ness.petagram.MainActivity;
import com.ness.petagram.R;

public class ContactoActivity extends AppCompatActivity {

    private EditText tedtNombre;
    private EditText tedtMensaje;
    private EditText tedtEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        Bundle parametros = getIntent().getExtras();

        /*
        if (parametros != null){
            String nombre   = parametros.getString(getResources().getString(R.string.parametro_nombre));
            String mensaje  = parametros.getString(getResources().getString(R.string.parametro_mensaje));
            String email    = parametros.getString(getResources().getString(R.string.parametro_pemail));

            tedtNombre  = findViewById(R.id.tedtNombre);
            tedtNombre.setText(nombre);

            tedtMensaje = findViewById(R.id.tedtMensaje);
            tedtMensaje.setText(mensaje);

            tedtEmail   = findViewById(R.id.tedtEmail);
            tedtEmail.setText(email);
        }
         */

        Button btnEnviar = findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarEmail();
            }
        });

    }


    public void enviarEmail(){
        tedtNombre  = findViewById(R.id.tedtNombre);
        tedtMensaje = findViewById(R.id.tedtMensaje);
        tedtEmail   = findViewById(R.id.tedtEmail);

        String nombre   = tedtNombre.getText().toString();
        String mensaje  = tedtMensaje.getText().toString();
        String email    = tedtEmail.getText().toString();

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailito (:"));
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ email});
        emailIntent.putExtra(Intent.EXTRA_TEXT, mensaje);


        startActivity(Intent.createChooser(emailIntent, "Email"));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(ContactoActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);

    }

}