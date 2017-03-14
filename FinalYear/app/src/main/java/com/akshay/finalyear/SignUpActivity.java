package com.akshay.finalyear;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText reg_fname, reg_lname, reg_email, reg_pass, reg_conpass, reg_mobile, reg_budget;
    Button btn_signUp, btn_cancel;
    TextView link_login;

    DBAdapater loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        // get Instance  of Database Adapter
        loginDataBaseAdapter = new DBAdapater(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        // Get Refferences of Views
        reg_fname = (EditText) findViewById(R.id.input_first);
        reg_lname = (EditText) findViewById(R.id.input_last);
        reg_email = (EditText) findViewById(R.id.input_email);
        reg_pass = (EditText) findViewById(R.id.input_password);
        reg_conpass = (EditText) findViewById(R.id.input_conPass);
        reg_budget = (EditText) findViewById(R.id.input_budget);
        reg_mobile = (EditText) findViewById(R.id.input_mobile);

        btn_signUp = (Button) findViewById(R.id.btn_signup);
        btn_signUp.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {

                                              String FirstName = reg_fname.getText().toString();
                                              String Lastname = reg_lname.getText().toString();
                                              String Email_id = reg_email.getText().toString();
                                              String Password = reg_pass.getText().toString();
                                              String ConfirmPassword = reg_conpass.getText().toString();
                                              String Budget = reg_budget.getText().toString();
                                              String Mobile = reg_mobile.getText().toString();

                                              if (FirstName.isEmpty()) {
                                                  reg_fname.setError("Enter Firstname");
                                              } else {
                                                  reg_fname.setError(null);
                                              }

                                              if (Lastname.isEmpty()) {
                                                  reg_lname.setError("Enter Lastname");
                                              } else {
                                                  reg_lname.setError(null);
                                              }

                                              if (Email_id.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(Email_id).matches()) {
                                                  reg_email.setError("Enter  valid email address");
                                              } else {
                                                  reg_email.setError(null);
                                              }

                                              // check if both password matches
                                              if (Password.isEmpty() || Password.length() < 4 || Password.length() > 12) {
                                                  reg_pass.setError("Set Password of length 4 to 12 @/num char.");
                                              } else if (!(ConfirmPassword.equals(Password))) {
                                                  reg_conpass.setError("Confirm password not matched.");
                                              } else {
                                                  reg_pass.setError(null);
                                              }

                                              if (Mobile.isEmpty() || Mobile.length() != 10) {
                                                  reg_mobile.setError("Enter Valid Mobile Number");
                                              } else {
                                                  reg_mobile.setError(null);
                                              }

                                              if (Budget.isEmpty() || Budget.length() > 5) {
                                                  reg_budget.setError("Please enter valid amount.");
                                              } else {
                                                  // Save the Data in Database
                                                  loginDataBaseAdapter.insertEntry(Email_id, Password);
                                                  final ProgressDialog progressDialog = new ProgressDialog(SignUpActivity.this,
                                                          R.style.AppTheme_Dark_Dialog);
                                                  progressDialog.setIndeterminate(true);
                                                  progressDialog.setMessage("Creating Account Please wait...");
                                                  progressDialog.show();
                                                  Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                                                  new android.os.Handler().postDelayed(
                                                          new Runnable() {
                                                              public void run() {
                                                                  // On complete call either onLoginSuccess or onLoginFailed
                                                                  // onLoginFailed();
                                                                  Intent in = new Intent(SignUpActivity.this, SignInActivity.class);
                                                                  startActivity(in);

                                                                  progressDialog.dismiss();
                                                              }
                                                          }, 3000);
                                              }
                                          }
                                      }

        );

        link_login=(TextView) findViewById(R.id.link_login);
        link_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                SignUpActivity.this.startActivity(intent);
                SignUpActivity.this.finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
        startActivity(intent);
    }
}

