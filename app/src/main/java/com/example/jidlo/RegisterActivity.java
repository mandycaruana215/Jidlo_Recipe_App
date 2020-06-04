package com.example.jidlo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper db;
    ImageView Back;
    Button Login, Submit;
    TextInputEditText field1, field2, field3, field4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DatabaseHelper(this);
        field1 = (TextInputEditText)findViewById(R.id.enter_name);
        field2 = (TextInputEditText)findViewById(R.id.enter_email);
        field3 = (TextInputEditText)findViewById(R.id.enter_password);
        field4 = (TextInputEditText)findViewById(R.id.enter_cpassword);
        Submit = (Button)findViewById(R.id.register);

        Submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                String f1 = field1.getText().toString();
                String f2 = field2.getText().toString();
                String f3 = field3.getText().toString();
                String f4 = field4.getText().toString();
                if(f1.equals("")||f2.equals("")||f3.equals("")||f4.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }


                else if (f3.equals(f4)){
                    Boolean checkEmail = db.checkEmail(f2);

                    if (checkEmail == true){
                        Boolean insert = db.insert(f2,f1,f3);
                        Toast.makeText(getApplicationContext(),"Registration Successful",Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(RegisterActivity.this, StartUpScreen.class));

                    }

                    else{
                        Toast.makeText(getApplicationContext(),"Email has already been used",Toast.LENGTH_SHORT).show();

                    }
                }
                else if(f3 != f4){
                    Toast.makeText(getApplicationContext(),"Passwords do not match",Toast.LENGTH_SHORT).show();

                }

               /*
*/
            }


        });

        Back = (ImageView) findViewById(R.id.back_button);
        Back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(RegisterActivity.this, StartUpScreen.class));

            }
        });

        Login = (Button) findViewById(R.id.loginbtn);
        Login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

            }
        });
    }
}
