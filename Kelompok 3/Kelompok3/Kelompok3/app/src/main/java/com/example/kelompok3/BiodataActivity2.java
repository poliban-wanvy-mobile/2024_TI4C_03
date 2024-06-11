package com.example.kelompok3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BiodataActivity2 extends AppCompatActivity {

    Button btnNext2, btnBack2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_biodata2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnNext2 = findViewById(R.id.btnNext2);
        btnBack2 = findViewById(R.id.btnBack2);
        btnNext2.setOnClickListener(v -> {
            startActivity(new Intent(BiodataActivity2.this, BiodataActivity3.class));
        });
        btnBack2.setOnClickListener(v -> {
            startActivity(new Intent(BiodataActivity2.this, MainActivity.class));
        });
    }
}