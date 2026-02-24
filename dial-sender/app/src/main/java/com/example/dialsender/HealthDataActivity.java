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
        long todayStart = getTodayStartTimestamp();

        for (String metric : METRICS) {
            String history = prefs.getString(PREF_HEALTH_PREFIX + metric, "");
            int latestToday = 0;
            int maxAllTime = 10; // Avoid 0 division

            if (!history.isEmpty()) {
                String[] entries = history.split(",");
                for (String entry : entries) {
                    long ts = 0;
                    int val = 0;
                    if (entry.contains(":")) {
                        String[] parts = entry.split(":");
                        try {
                            ts = Long.parseLong(parts[0]);
                            val = Integer.parseInt(parts[1]);
                        } catch (Exception ignored) {
                        }
                    } else {
                        val = parseIntSafe(entry);
                    }

                    maxAllTime = Math.max(maxAllTime, Math.abs(val));

                    // If timestamp is valid and from today, or it's old imported data without
                    // timestamp (assume today)
                    if (ts >= todayStart || !entry.contains(":")) {
                        latestToday = val; // Latest value from today
                    }
                }
            }

            // Create CardView
            androidx.cardview.widget.CardView card = new androidx.cardview.widget.CardView(this);
            LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            cardParams.setMargins(0, 0, 0, 24);
            card.setLayoutParams(cardParams);
            card.setRadius(24f);
            card.setCardElevation(8f);
            card.setCardBackgroundColor(ContextCompat.getColor(this, R.color.card_library_start)); // From themes

            LinearLayout cardContent = new LinearLayout(this);
            cardContent.setOrientation(LinearLayout.VERTICAL);
            cardContent.setPadding(32, 32, 32, 32);

            // Title
            TextView title = new TextView(this);
            title.setText(metric.replace("_", " ").toUpperCase(Locale.US));
            title.setTextColor(ContextCompat.getColor(this, R.color.text_primary));
            title.setTextSize(16f);
            title.setTypeface(null, android.graphics.Typeface.BOLD);
            cardContent.addView(title);

            // Value
            TextView valueText = new TextView(this);
            valueText.setText(String.valueOf(latestToday));
            valueText.setTextColor(ContextCompat.getColor(this, R.color.text_primary));
            valueText.setTextSize(36f);
            valueText.setTypeface(null, android.graphics.Typeface.BOLD);
            valueText.setPadding(0, 8, 0, 16);
            cardContent.addView(valueText);

            // Progress Bar
            ProgressBar bar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
            bar.setMax(maxAllTime);
            bar.setProgress(latestToday < 0 ? 0 : Math.min(latestToday, maxAllTime));
            // Style the progress bar
            bar.setProgressTintList(
                    android.content.res.ColorStateList.valueOf(ContextCompat.getColor(this, R.color.card_border_send)));
            cardContent.addView(bar, new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, 24));

            // Details/History
            TextView details = new TextView(this);
            details.setText(history.isEmpty() ? getString(R.string.no_health_data) : "Max: " + maxAllTime);
            details.setTextColor(ContextCompat.getColor(this, R.color.text_secondary));
            details.setTextSize(12f);
            details.setPadding(0, 16, 0, 0);
            cardContent.addView(details);

            card.addView(cardContent);
            healthContainer.addView(card);
        }
    }

    private long getTodayStartTimestamp() {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(java.util.Calendar.HOUR_OF_DAY, 0);
        cal.set(java.util.Calendar.MINUTE, 0);
        cal.set(java.util.Calendar.SECOND, 0);
        cal.set(java.util.Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis() / 1000;
    }

    private int parseIntSafe(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (Exception ignored) {
            return 0;
        }
    }
}
