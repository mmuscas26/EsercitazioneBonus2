package com.example.mirko.esercitazionebonus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class VediRisultati extends AppCompatActivity {

    Persona p1;
    Persona p2;
    TextView r;
    Button indietro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedi_risultati);

        r = (TextView) findViewById(R.id.result);
        indietro = (Button) findViewById(R.id.indietro);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(MainActivity.PERSONA_EXTRA);
        Bundle bundle = getIntent().getExtras();

        p1 = (Persona)obj;
        r = (TextView)findViewById(R.id.result);
        p2 = PersonaFactory.login(p1.getUsername(),p1.getPassword());
        if(p2 != null)
            r.setText("Benvenuto "+p2.getUsername());
        else
            r.setText("Accesso Negato!");

        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent undo = new Intent(VediRisultati.this, MainActivity.class);
                startActivity(undo);    //bottone per tornare alla prima activity
            }
        });
    }
}
