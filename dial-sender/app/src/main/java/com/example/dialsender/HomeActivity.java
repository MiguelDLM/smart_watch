package com.example.dialsender;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SettingsActivity.applyGlobalTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViewById(R.id.cardCreateDial).setOnClickListener(v -> {
            startActivity(new Intent(this, DialEditorActivity.class));
        });

        findViewById(R.id.cardSendDial).setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });

        findViewById(R.id.cardDialLibrary).setOnClickListener(v -> {
            startActivity(new Intent(this, DialLibraryActivity.class));
        });

        findViewById(R.id.cardHealthData).setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });

        findViewById(R.id.btnSettings).setOnClickListener(v -> {
            startActivity(new Intent(this, SettingsActivity.class));
        });
    }
}
