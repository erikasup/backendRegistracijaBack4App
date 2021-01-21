package com.example.backendregistracijaback4app;

// Erika Supranavičiūtė

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class Prisijungimas extends AppCompatActivity  implements View.OnClickListener {

    EditText edtLoginEmail, edtLoginPassword;
    Button btnPrisijungti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prisijungimas);

        setTitle("Prisijungimas"); // ****

        edtLoginEmail = findViewById(R.id.edtLoginEmail);
        edtLoginPassword = findViewById(R.id.edtLoginPassword);

        btnPrisijungti = findViewById(R.id.btnPrisijungti);
        btnPrisijungti.setOnClickListener(this);

        if (ParseUser.getCurrentUser() != null) {
            ParseUser.getCurrentUser().logOut();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) { // ******** NEBAIGTA SWITCH CASE:::::: ***
            case R.id.btnPrisijungti:

                ParseUser.logInInBackground(edtLoginEmail.getText().toString(),
                        edtLoginPassword.getText().toString(),
                        new LogInCallback() {
                            @Override
                            public void done(ParseUser user, ParseException e) {
                                if (user != null && e == null) {
                                    FancyToast.makeText(Prisijungimas.this,
                                            user.getUsername() + " is logged in",
                                            Toast.LENGTH_SHORT, FancyToast.SUCCESS, true).show();

                                    transitionToPrisijungimo();
                                }
                            }
                        });

                break;
        }
    }


    private void transitionToPrisijungimo () {
        Intent intent = new Intent(Prisijungimas.this, PrisijungtaPrieSistemos.class);
        startActivity(intent);
    }


}
