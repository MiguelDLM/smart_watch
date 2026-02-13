package com.example.dialsender;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Dedicated activity for viewing BLE debug logs.
 * Logs are stored in a static StringBuilder shared with MainActivity.
 */
public class LogActivity extends AppCompatActivity {

    // Static shared log buffer accessible from MainActivity
    public static final StringBuilder sharedLog = new StringBuilder();

    private TextView txtLog;
    private ScrollView logScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SettingsActivity.applyGlobalTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        txtLog = findViewById(R.id.txtLog);
        logScroll = findViewById(R.id.logScroll);
        Button btnCopyLog = findViewById(R.id.btnCopyLog);
        Button btnClearLog = findViewById(R.id.btnClearLog);

        findViewById(R.id.btnBackLog).setOnClickListener(v -> finish());

        btnCopyLog.setOnClickListener(v -> {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("DialSender Logs", sharedLog.toString());
            clipboard.setPrimaryClip(clip);
            Toast.makeText(this, R.string.log_copied, Toast.LENGTH_SHORT).show();
        });

        btnClearLog.setOnClickListener(v -> {
            sharedLog.setLength(0);
            txtLog.setText("");
            Toast.makeText(this, R.string.log_cleared, Toast.LENGTH_SHORT).show();
        });

        // Display current log content
        txtLog.setText(sharedLog.toString());

        // Scroll to bottom
        logScroll.post(() -> logScroll.fullScroll(ScrollView.FOCUS_DOWN));
    }

    @Override
    protected void onResume() {
        super.onResume();
        txtLog.setText(sharedLog.toString());
        logScroll.post(() -> logScroll.fullScroll(ScrollView.FOCUS_DOWN));
    }

    /**
     * Utility method to append a log line from any context.
     */
    public static void appendLog(String msg) {
        sharedLog.append(msg).append("\n");
    }
}
