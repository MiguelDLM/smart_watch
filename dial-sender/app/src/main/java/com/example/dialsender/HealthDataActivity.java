package com.example.dialsender;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Locale;

public class HealthDataActivity extends AppCompatActivity {
    private static final String PREF_NAME = "dial_sender_prefs";
    private static final String PREF_HEALTH_PREFIX = "health_";
    private static final String[] METRICS = {
            "steps", "calories", "sleep", "distance", "heart_rate", "blood_oxygen"
    };

    private LinearLayout healthContainer;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SettingsActivity.applyGlobalTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_data);
        prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        healthContainer = findViewById(R.id.healthContainer);
        findViewById(R.id.btnBackHealth).setOnClickListener(v -> finish());
        findViewById(R.id.btnSyncHealthFromScreen).setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("trigger_health_sync", true);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        renderMetrics();
    }

    private void renderMetrics() {
        healthContainer.removeAllViews();
        for (String metric : METRICS) {
            String history = prefs.getString(PREF_HEALTH_PREFIX + metric, "");
            int latest = 0;
            int max = 100;
            if (!history.isEmpty()) {
                String[] values = history.split(",");
                latest = parseIntSafe(values[values.length - 1]);
                for (String value : values) {
                    max = Math.max(max, Math.abs(parseIntSafe(value)));
                }
            }

            TextView title = new TextView(this);
            title.setText(metric.replace("_", " ").toUpperCase(Locale.US));
            title.setTextColor(ContextCompat.getColor(this, R.color.text_primary));
            title.setTextSize(14f);
            title.setPadding(0, 12, 0, 4);
            healthContainer.addView(title);

            ProgressBar bar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
            bar.setMax(max);
            bar.setProgress(latest < 0 ? 0 : Math.min(latest, max));
            healthContainer.addView(bar, new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));

            TextView details = new TextView(this);
            details.setText(history.isEmpty() ? getString(R.string.no_health_data) : history);
            details.setTextColor(ContextCompat.getColor(this, R.color.text_secondary));
            details.setTextSize(11f);
            details.setPadding(0, 4, 0, 0);
            healthContainer.addView(details);
        }
    }

    private int parseIntSafe(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (Exception ignored) {
            return 0;
        }
    }
}
