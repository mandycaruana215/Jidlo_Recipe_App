package com.example.jidlo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartUpScreen extends AppCompatActivity {

    Button Skip;
    Button Login;
    Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up_screen);

        Skip = (Button)findViewById(R.id.Skip);
        Skip.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(StartUpScreen.this, MainActivity.class));
            }
        });

        Login = (Button)findViewById(R.id.login);
        Login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(StartUpScreen.this, LoginActivity.class));

            }
        });

        Register = (Button)findViewById(R.id.register);
        Register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(StartUpScreen.this, RegisterActivity.class));

            }
        });
    }
}
