package com.example.ecoapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;


public class Login extends AppCompatActivity {

    private static final String PREF_NAME = "UserData";

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
                        saveUserData(login);
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

    private void saveUserData(String login) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("login", login);
        editor.apply();
    }
}