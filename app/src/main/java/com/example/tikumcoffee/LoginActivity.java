package com.example.tikumcoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText et_login_email, et_login_password;
    private TextView registerHere;
    private Button btn_login;
    private String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialize();
    }

    private void initialize() {
        et_login_email = findViewById(R.id.et_login_email);
        et_login_password = findViewById(R.id.et_login_password);
        registerHere = findViewById(R.id.tv_register_here);
        btn_login = findViewById(R.id.btn_login);
    }

    public void loginClick(View v){
        if (v == btn_login) {
            email = et_login_email.getText().toString();
            password = et_login_password.getText().toString();

            if (email.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Email Must be Filled!", Toast.LENGTH_LONG).show();
            } else if (!email.contains("@") || !email.contains(".")) {
                Toast.makeText(getApplicationContext(), "Email must contain @ and .", Toast.LENGTH_LONG).show();
            } else if (password.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Password Must be Filled!", Toast.LENGTH_LONG).show();
            } else if (password.length() < 6) {
                Toast.makeText(getApplicationContext(), "Password must be at least 6 characters", Toast.LENGTH_LONG).show();
            } else {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        }
    }

    public void registerHereClick(View main) {
        if (main == registerHere) {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
        }
    }
}