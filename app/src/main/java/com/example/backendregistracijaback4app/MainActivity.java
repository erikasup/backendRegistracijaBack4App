package com.example.backendregistracijaback4app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.parse.ParseInstallation;
import com.parse.ParseObject;

// Erika Supranavičiūtė

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private Button btnSignUp, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseInstallation.getCurrentInstallation().saveInBackground();

        setTitle("Registracija"); // main'o title

        btnSignUp = findViewById(R.id.btnSignUp);
        btnLogin = findViewById(R.id.btnLogin);


        //**** CLICK *****

        btnSignUp.setOnClickListener(new View.OnClickListener() { // *** REGISTRACIJOS ACTIVITY ********
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Registracija.class));
            }

        });


        btnLogin.setOnClickListener(new View.OnClickListener() { // ************* LOGIN'as *********
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Prisijungimas.class));
            }
        });




    }

    private  void transitionToRegistracija() { // perkelia i kita activity
        Intent intent = new Intent(MainActivity.this, Registracija.class);
        startActivity(intent);
    }
    // test
    @Override

    public void onClick(View v) {





    }
}