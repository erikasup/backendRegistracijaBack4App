package com.example.backendregistracijaback4app;


// Erika Supranavičiūtė


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrisijungtaPrieSistemos extends AppCompatActivity {

    private Button btnAtgal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prisijungta_prie_sistemos);

        setTitle("Prisijungta");

        btnAtgal = findViewById(R.id.btnAtgal);

        btnAtgal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrisijungtaPrieSistemos.this, MainActivity.class));
            }
        });

    }
}