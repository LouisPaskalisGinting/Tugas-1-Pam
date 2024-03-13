package com.example.tugas1pam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etEmail, etPass;
    private Button button_login;
    public static final String Email = "ngerikali@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.email);
        etPass = findViewById(R.id.pass);
        button_login = findViewById(R.id.btn_login);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String pass = etPass.getText().toString();

                // Kondisi kalo email kosong
                if (email.isEmpty()) {
                    etEmail.setError("Masukkan email anda!");
                    return;
                }
                if (pass.isEmpty()) {
                    etPass.setError("Masukkan password anda!");
                    return;
                }
                login(email);
            }
        });

    }
    private void login (String email) {
        // intent
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra(Email, email);
        startActivity(intent);
    }
}