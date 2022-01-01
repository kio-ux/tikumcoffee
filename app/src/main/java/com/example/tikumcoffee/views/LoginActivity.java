package com.example.tikumcoffee.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;


import com.example.tikumcoffee.R;

public class LoginActivity extends AppCompatActivity {

    private EditText et_login_email, et_login_password;
    private TextView registerHere;
    private Button btn_login;
    private String email, password;
//    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialize();
//        mAuth = FirebaseAuth.getInstance();
    }

    private void initialize() {
        et_login_email = findViewById(R.id.et_login_email);
        et_login_password = findViewById(R.id.et_login_password);
        registerHere = findViewById(R.id.tv_register_here);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(this::loginClick);
        registerHere.setOnClickListener(this::registerHereClick);
    }

    public void loginClick(View v){
        if (v == btn_login) {
            userLogin();
        }
    }

    private void userLogin() {
        String email = et_login_email.getText().toString();
        String password = et_login_password.getText().toString();

        if (email.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Email Must be Filled!", Toast.LENGTH_LONG).show();
        }

        if (!email.contains("@") || !email.contains(".")) {
            Toast.makeText(getApplicationContext(), "Email must contain @ and .", Toast.LENGTH_LONG).show();
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(getApplicationContext(), "Please enter a valid email", Toast.LENGTH_LONG).show();
        }

        if (password.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Password Must be Filled!", Toast.LENGTH_LONG).show();
        }

        if (password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password must be at least 6 characters", Toast.LENGTH_LONG).show();
        }

//        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful()){
//                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
//                }
//                else {
//                    Toast.makeText(LoginActivity.this, "Login failed! Check your credentials.", Toast.LENGTH_LONG).show();
//                }
//            }
//        });

    }

    public void registerHereClick(View main) {
        if (main == registerHere) {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
        }
    }
}