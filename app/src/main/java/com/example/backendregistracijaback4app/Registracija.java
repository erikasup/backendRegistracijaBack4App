package com.example.backendregistracijaback4app;

// Erika Supranavičiūtė

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class Registracija extends AppCompatActivity implements View.OnClickListener{

    private EditText edtRegEmail, edtRegName, edtRegPassword;
    private Button btnRegistruotis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registracija);

        setTitle("Registracija"); // Title

        edtRegEmail = findViewById(R.id.edtRegEmail);
        edtRegName = findViewById(R.id.edtRegName);
        edtRegPassword = findViewById(R.id.edtRegPassword);

        btnRegistruotis = findViewById(R.id.btnRegistruotis);

        btnRegistruotis.setOnClickListener(this);

//        if(ParseUser.getCurrentUser() != null) {
//
//        }
    }
    private  void transitionToPrisijungimo() {
        Intent intent = new Intent(Registracija.this, PrisijungtaPrieSistemos.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegistruotis:
                if(edtRegEmail.getText().toString().equals("") ||
                        edtRegName.getText().toString().equals("") ||
                        edtRegPassword.getText().toString().equals("")) {

                    FancyToast.makeText(Registracija.this,
                            "Reikalingas email, username ir pw",
                            Toast.LENGTH_SHORT,FancyToast.INFO, true).show();
                } else {
                    final ParseUser appUser = new ParseUser();
                    appUser.setEmail(edtRegEmail.getText().toString());
                    appUser.setUsername(edtRegName.getText().toString());
                    appUser.setPassword(edtRegPassword.getText().toString());

                    final ProgressDialog progressDialog = new ProgressDialog(this); // KAS CIA? :D
                    progressDialog.setMessage("Signing up " + edtRegName.getText().toString());
                    progressDialog.show();

                    appUser.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                FancyToast.makeText(Registracija.this,
                                        appUser.getUsername() + " yra  prisijunges :))" ,
                                        Toast.LENGTH_SHORT,FancyToast.SUCCESS,true).show();

                                transitionToPrisijungimo();
                                // **** PERKELTI I KITA ACTIVITY AFTER SIGNUP | MANO DUOMENYS NAUJAS ACTIVITY
                            } else {
                                FancyToast.makeText(Registracija.this,
                                        "There was an error " + e.getMessage(),
                                        Toast.LENGTH_SHORT, FancyToast.ERROR, true).show();

                            }
                            progressDialog.dismiss(); // praspiria progress dialog kai nebereikalingas
                            //nu wtf...

                        }
                    });
                }
                break;
        }



    }
}