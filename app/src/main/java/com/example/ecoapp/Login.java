package com.example.ecoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText editTextEmail = findViewById(R.id.editTextEmail);
        final EditText editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if (!login.isEmpty() && !password.isEmpty()) {
                    if (login.length() >= 2) {
                        if (password.length() >= 8) {
                            Intent intent = new Intent(Login.this, MainActivity.class);
                            startActivity(intent);
                            showToast("Успешная авторизация");
                        } else {
                            showToast("Пароль должен содержать не менее 8 символов");
                        }
                    } else {
                        showToast("Имя должно содержать не менее 2 букв");
                    }
                } else {
                    showToast("Заполните все поля");
                }
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}