package com.solodroid.yourradioappsinglestation.activities;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.solodroid.yourradioappsinglestation.R;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ContactUsActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.contact_title)
    TextView contactTitle;
    @BindView(R.id.separator_2)
    View separator2;
    @BindView(R.id.phone_label)
    TextView phoneLabel;
    @BindView(R.id.whatsapp_label)
    TextView whatsappLabel;
    @BindView(R.id.mail_label)
    TextView mailLabel;
    @BindView(R.id.send_message_title)
    TextView sendMessageTitle;
    @BindView(R.id.name_label)
    TextView nameLabel;
    @BindView(R.id.name_input)
    TextInputEditText nameInput;
    @BindView(R.id.name_input_container)
    TextInputLayout nameInputContainer;
    @BindView(R.id.email_label)
    TextView emailLabel;
    @BindView(R.id.email_input)
    TextInputEditText emailInput;
    @BindView(R.id.email_input_container)
    TextInputLayout emailInputContainer;
    @BindView(R.id.message_label)
    TextView messageLabel;
    @BindView(R.id.message_input)
    TextInputEditText messageInput;
    @BindView(R.id.message_input_container)
    TextInputLayout messageInputContainer;
    @BindView(R.id.send_message_button)
    Button sendMessageButton;
    @BindView(R.id.contact_container)
    LinearLayout contactContainer;

    public String jobNo;
    public String teamNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        ButterKnife.bind(this);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(getString(R.string.drawer_more));
        }
        Intent intent = getIntent();
        jobNo = intent.getStringExtra("Job_No");
        teamNo = intent.getStringExtra("Team_No");

    }

    private boolean alreadyToSend() {
        if(!nameInput.getText().toString().isEmpty() && !emailInput.getText().toString().isEmpty() && !messageInput.getText().toString().isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }


    private void sendMail() {
        final String username = "aplicacion@shockmedia.com.ar";
        final String password = "WHRRi~C0t&G%";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.shockmedia.com.ar");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailInput.getText().toString()));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("lea.cuvelo@gmail.com"));
            message.setSubject("Testing Subject");
           // message.setText("sdsfs"); //TODO  CHANGE THIS

            Multipart multipart = new MimeMultipart();

            message.setContent(multipart);

            Transport.send(message);

            Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }



    /*

    private Session createSessionObject()
    {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        return Session.getInstance(properties, new javax.mail.Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    private Message createMessage(String email, String subject, String messageBody, Session session) throws

            MessagingException, UnsupportedEncodingException
    {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("xzy@outlook.com", "Naveed Qureshi"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email, email));
        message.setSubject(subject);
        message.setText(messageBody);
        return message;
    }

    public class SendMailTask extends AsyncTask<Message, Void, Void>
    {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(Email.this, "Please wait", "Sending mail", true, false);
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);
            progressDialog.dismiss();
        }

        protected Void doInBackground(javax.mail.Message... messages)
        {
            try
            {
                Transport.send(messages[0]);
            } catch (MessagingException e)
            {
                e.printStackTrace();
            }
            return null;
        }
    }

    */

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;

            default:
                return super.onOptionsItemSelected(menuItem);
        }
        return true;
    }

    @OnClick(R.id.send_message_button)
    public void handleSendMessage(){
        if(alreadyToSend()){
            sendMail();
        }
        else {
            Toast.makeText(this, "Complete todos los campos solicitados", Toast.LENGTH_SHORT).show();
        }
    }


}
