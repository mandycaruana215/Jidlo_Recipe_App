package com.example.jidlo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    DatabaseHelper db;
    ImageView Back;
    Button Register, Submit;
    TextInputEditText eml, psw;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(getApplicationContext());

        db = new DatabaseHelper(this);
        eml = (TextInputEditText)findViewById(R.id.enter_email);
        psw = (TextInputEditText)findViewById(R.id.enter_password);
        Submit = (Button)findViewById(R.id.login);

        Toast.makeText(getApplicationContext(),"User Login Status: "+ sessionManager.isUserLoggedIn(),Toast.LENGTH_LONG).show();



        Submit.setOnClickListener(new View.OnClickListener()
        {
              public void onClick(View v)
              {
                  String email = eml.getText().toString();
                  String password = psw.getText().toString();
                    String user = "user";

                  if (email.equals("") || password.equals("")) {
                      Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                  }

                  Boolean checkEmailPassword = db.emailpasswordChecker(email,password);
                  if (checkEmailPassword == false) {
                      Toast.makeText(getApplicationContext(), "Successful Login", Toast.LENGTH_SHORT).show();


                   sessionManager.createUserLoginSession( user, email);

                   Intent i = new Intent(getApplicationContext(),MainActivity.class);
                   startActivity(i);


                  }
                  else
                      Toast.makeText(getApplicationContext(), "Wrong Email or Password", Toast.LENGTH_SHORT).show();


                  }
        });
                Back = (ImageView) findViewById(R.id.back_button);
        Back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(LoginActivity.this, StartUpScreen.class));

            }
        });

        Register = (Button) findViewById(R.id.sign_up_now);
        Register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

            }
        });

    }

  /*  public void login(View view){

        User user  =new User(eml.toString(),);

        //  sessionManager.saveSession(user);
    }*/

}
