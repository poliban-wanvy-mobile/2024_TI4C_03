package com.example.kelompok3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BiodataActivity3 extends AppCompatActivity {

    Button btnNext3, btnBack3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_biodata3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnNext3 = findViewById(R.id.btnNext3);
        btnBack3 = findViewById(R.id.btnBack3);
        btnNext3.setOnClickListener(v -> {
            startActivity(new Intent(BiodataActivity3.this, BiodataActivity4.class));
        });
        btnBack3.setOnClickListener(v -> {
            startActivity(new Intent(BiodataActivity3.this, MainActivity.class));
        });
    }
}