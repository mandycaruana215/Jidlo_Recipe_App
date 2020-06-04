package com.example.jidlo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class ProfileActivity extends AppCompatActivity {

    private TextView name, email;
    private Button logout;
    private ImageView Back;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        Back = (ImageView) findViewById(R.id.back_button);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            }
        });

        sessionManager = new SessionManager(getApplicationContext());
        //sessionManager.checkLogin();

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        logout = findViewById(R.id.logout);

        Toast.makeText(getApplicationContext(), "User Login Status: " + sessionManager.isUserLoggedIn(), Toast.LENGTH_LONG).show();


        if (sessionManager.checkLogin())
            finish();

        HashMap<String, String> user = sessionManager.getUserDetails();

        String smName = user.get(SessionManager.KEY_NAME);
        String smEmail = user.get(SessionManager.KEY_EMAIL);

        name.setText(Html.fromHtml("Name: <b>" + smName + "</b>"));

        email.setText(Html.fromHtml("Email: <b>" + smEmail + "</b>"));


        logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sessionManager.logoutUser();
                Intent i = new Intent(getApplicationContext(),StartUpScreen.class);
                startActivity(i);

            }
        });

    }

    }