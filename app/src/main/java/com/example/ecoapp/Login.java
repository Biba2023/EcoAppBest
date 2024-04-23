package com.example.ecoapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ecoapp.databinding.ActivityMainBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextInputEditText editLogin = findViewById(R.id.loginEditText);

        TextInputEditText editPassword = findViewById(R.id.passwordEditText);

        Button buttonLogin = findViewById(R.id.buttonLogin);


        buttonLogin.setOnClickListener(v -> {
            String login = editLogin.getText().toString();
            String password = editPassword.getText().toString();

            if (!login.isEmpty() && !password.isEmpty()) {
                if (login.length() >= 2) {
                    if (password.length() >= 8) {
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                        showToast("Успешная авторизация");
                    } else {
                        showToast("Пароль не менее 8 символов");
                    }
                } else {
                    showToast("Имя не менее 2 букв");
                }
            } else {
                showToast("Заполните все поля");
            }
        });
    }



    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}