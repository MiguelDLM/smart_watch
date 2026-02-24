package com.example.dialsender;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private static final int CREATE_DIAL_REQUEST = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SettingsActivity.applyGlobalTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViewById(R.id.cardCreateDial).setOnClickListener(v -> {
            startActivityForResult(new Intent(this, DialEditorActivity.class), CREATE_DIAL_REQUEST);
        });

        findViewById(R.id.cardSendDial).setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });

        findViewById(R.id.cardDialLibrary).setOnClickListener(v -> {
            startActivity(new Intent(this, DialLibraryActivity.class));
        });

        findViewById(R.id.cardHealthData).setOnClickListener(v -> {
            startActivity(new Intent(this, HealthDataActivity.class));
        });

        findViewById(R.id.btnSettings).setOnClickListener(v -> {
            startActivity(new Intent(this, SettingsActivity.class));
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CREATE_DIAL_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Intent transferIntent = new Intent(this, MainActivity.class);
            transferIntent.putExtra("dial_file_path", data.getData().getPath());
            startActivity(transferIntent);
        }
    }
}
