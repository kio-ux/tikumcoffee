package com.example.tikumcoffee.views;

import androidx.annotation.NonNull;
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

import com.example.tikumcoffee.R;
import com.example.tikumcoffee.firebase.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    private EditText et_username, et_email, et_password, et_repassword;
    private CheckBox cb_agree;
    private String username, email, password, rePassword;
    private Boolean agree;
    private Button btn_signup;
    private TextView loginHere;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initialize();

        mAuth = FirebaseAuth.getInstance();
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
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    User user = new User(username, email, password);

                                    FirebaseDatabase.getInstance().getReference("Users")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()){
                                                Toast.makeText(SignUpActivity.this, "Registration completed!", Toast.LENGTH_LONG).show();
                                                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                                startActivity(intent);
                                            }
                                            else {
                                                Toast.makeText(SignUpActivity.this, "Registration failed, please try again!", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });
                                }
                                else {
                                    Toast.makeText(SignUpActivity.this, "Registration failed, please try again!", Toast.LENGTH_LONG).show();
                                }
                            }
                        });

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
