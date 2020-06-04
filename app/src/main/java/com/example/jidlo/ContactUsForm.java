package com.example.jidlo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;

import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactUsForm extends AppCompatActivity {

    private Activity activity;
    ImageView Back;
    Button Submit;
    TextInputEditText name, subject, email, longmessage;
    String sEmail, sPassword;
    //char[] sPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us_form);

        name = (TextInputEditText)findViewById(R.id.enter_name);
        subject = (TextInputEditText)findViewById(R.id.enter_subject);
        email = (TextInputEditText)findViewById(R.id.enter_email);
        longmessage = (TextInputEditText)findViewById(R.id.enter_message);

        sEmail = "mandycaruana.215@gmail.com";
        sPassword = "MandyilGoalkeeper12";
       // sPassword = new char[] {'M','a','n','d','y','i','l','G','o','a','l','k','e','e','p','e','r','1','2'};


        Back = (ImageView) findViewById(R.id.back_button);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContactUsForm.this, MainActivity.class));
            }
        });

        Submit = (Button) findViewById(R.id.submit);
        Submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Properties properties = new Properties();
                properties.put("mail.smtp.auth","true");
                properties.put("mail.smtp.starttls.enable","true");
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.port","587");

                Session session = Session.getInstance(properties,new Authenticator(){
                    @Override
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
                        return new javax.mail.PasswordAuthentication(sEmail, sPassword);

                    }

                });


                try {
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(sEmail));

                    message.setRecipients(MimeMessage.RecipientType.TO,
                            InternetAddress.parse(sEmail.trim()));

                    message.setSubject(subject.getText().toString().trim());

                    message.setText(longmessage.getText().toString().trim());

                    new SendMail().execute(message);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }


             /*   String eml = email.getText().toString();
                String sbj = subject.getText().toString();
                String msg = message.getText().toString();

                Intent sendEmail = new Intent(Intent.ACTION_SEND);



                sendEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"mandycaruana.215@gmail.com"});

                sendEmail.putExtra(Intent.EXTRA_TEXT,


                        "name:"+nm+'\n'+"Email ID:"+eml+'\n'+"Message:"+'\n'+msg);
                sendEmail.setType("message/rfc822");

                startActivity(Intent.createChooser(sendEmail, "Send email via:"));

                Toast.makeText(getApplicationContext(),"Your message has been sent.",Toast.LENGTH_SHORT).show();
*/
               /* startActivity(new Intent(ContactUsForm.this, MainActivity.class));
*/
            }
        });
    }

    private class SendMail extends AsyncTask<MimeMessage,String,String>{

        private ProgressDialog progressDialog;





        protected void onPreExecute(){

            super.onPreExecute();

            progressDialog = ProgressDialog.show(ContactUsForm.this,"Please Wait", "Sending Mail...", true,false);
        }


        @Override
        protected String doInBackground(MimeMessage... messages)
        {
            try {
                Transport.send(messages[0]);
                return "Success";
            }
            catch (MessagingException e){
                e.printStackTrace();
                return "Error";
            }


        }

        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);

            progressDialog.dismiss();

            if(s.equals("Success")){

                AlertDialog.Builder build = new AlertDialog.Builder(ContactUsForm.this);
                build.setCancelable(false);
                build.setTitle(Html.fromHtml("<font color='#509324'>Success</font>"));
                build.setMessage("Mail Sent Successfully!");
                build.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        name.setText("");
                        email.setText("");
                        longmessage.setText("");
                        subject.setText("");

                        Intent i = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);

                    }
                });

            }

            else{
                //if there is an error

                Toast.makeText(getApplicationContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();

            }
        }
    }


    }