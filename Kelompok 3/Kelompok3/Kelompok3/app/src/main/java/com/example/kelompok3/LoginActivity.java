package com.example.kelompok3;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnlogin;
    EditText etUsername, etPassword;

    String username = "admin";
    String password = "admin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnlogin = findViewById(R.id.btnLogin);

        btnlogin.setOnClickListener(v -> {
            if(etUsername.getText().toString().equalsIgnoreCase(username) && etPassword.getText().toString().equalsIgnoreCase(password)){
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(LoginActivity.this, "Username/Password Salah", Toast.LENGTH_SHORT).show();
            }
        });
    }
}