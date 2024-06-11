package com.example.kelompok3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BiodataActivity4 extends AppCompatActivity {

    Button btnNext4, btnBack4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_biodata4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnNext4 = findViewById(R.id.btnNext4);
        btnBack4 = findViewById(R.id.btnBack4);
        btnNext4.setOnClickListener(v -> {
            startActivity(new Intent(BiodataActivity4.this, BiodataActivity5.class));
        });
        btnBack4.setOnClickListener(v -> {
            startActivity(new Intent(BiodataActivity4.this, MainActivity.class));
        });
    }
}