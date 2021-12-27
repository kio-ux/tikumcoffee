package com.example.tikumcoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText et_username, et_email, et_password, et_repassword;
    private CheckBox cb_agree;
    private String username, email, password, rePassword;
    private Boolean agree;
    private Button btn_signup;
    private TextView loginHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initialize();
    }

    private void initialize() {
        et_username = findViewById(R.id.et_username);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        et_repassword = findViewById(R.id.et_repassword);
        btn_signup = findViewById(R.id.btn_signup);
        loginHere = findViewById(R.id.tv_login_here);
        cb_agree = findViewById(R.id.cb_agree);

        btn_signup.setOnClickListener(this::signUpClick);
        loginHere.setOnClickListener(this::loginHereClick);
    }

    public void signUpClick(View v){
        if (v == btn_signup){
            username = et_username.getText().toString();
            email = et_email.getText().toString();
            password = et_password.getText().toString();
            rePassword = et_repassword.getText().toString();
            agree = cb_agree.isChecked();

            if (username.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Username Must be Filled!", Toast.LENGTH_LONG).show();
            } else if (username.length() < 5 || username.length() > 20) {
                Toast.makeText(getApplicationContext(), "Username must contains 5-20 characters", Toast.LENGTH_LONG).show();
            } else if (email.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Email Must be Filled!", Toast.LENGTH_LONG).show();
            } else if (!email.contains("@") || !email.contains(".")) {
                Toast.makeText(getApplicationContext(), "Email must contain @ and .", Toast.LENGTH_LONG).show();
            } else if (password.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Password Must be Filled!", Toast.LENGTH_LONG).show();
            } else if (password.length() < 6) {
                Toast.makeText(getApplicationContext(), "Password must be at least 6 characters", Toast.LENGTH_LONG).show();
            } else if (!rePassword.equals(password)) {
                Toast.makeText(getApplicationContext(), "Confirm password should match with password", Toast.LENGTH_LONG).show();
            } else if (!agree) {
                Toast.makeText(getApplicationContext(), "Terms and Conditions Agreement Must be Clicked!", Toast.LENGTH_LONG).show();
            } else {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

            }
        }
    }

    public void loginHereClick(View login){
        if (login == loginHere){
            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}