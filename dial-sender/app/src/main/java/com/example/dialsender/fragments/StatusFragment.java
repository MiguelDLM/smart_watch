package com.example.dialsender.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.dialsender.R;
import com.example.dialsender.ble.BleManager;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StatusFragment extends Fragment {
    private static final String PREF_NAME = "dial_sender_prefs";
    private static final String PREF_HEALTH_PREFIX = "health_";
    private static final String[] METRICS = {
            "steps", "calories", "sleep", "distance", "heart_rate", "blood_oxygen"
    };

    private static final int RANGE_DAY = 0;
    private static final int RANGE_WEEK = 1;
    private static final int RANGE_MONTH = 2;

    private LinearLayout healthContainer;
    private SharedPreferences prefs;
    private int currentRange = RANGE_DAY;
    private MaterialButtonToggleGroup toggleTimeRange;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_status, container, false);

        prefs = requireContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        healthContainer = view.findViewById(R.id.healthContainer);
        toggleTimeRange = view.findViewById(R.id.toggleTimeRange);

        // Hide back button since it's a tab now
        View btnBack = view.findViewById(R.id.btnBackHealth);
        if (btnBack != null) {
            btnBack.setVisibility(View.GONE);
        }

        view.findViewById(R.id.btnSyncHealthFromScreen).setOnClickListener(v -> {
            // Send trigger to watch
            byte[] command = new byte[] { 0x05, 0x01 }; // Sample trigger
            // TODO real trigger mechanism with BleManager
        });

        toggleTimeRange.addOnButtonCheckedListener((group, checkedId, isChecked) -> {
            if (isChecked) {
                if (checkedId == R.id.btnRangeDay) {
                    currentRange = RANGE_DAY;
                } else if (checkedId == R.id.btnRangeWeek) {
                    currentRange = RANGE_WEEK;
                } else if (checkedId == R.id.btnRangeMonth) {
                    currentRange = RANGE_MONTH;
                }
                renderMetrics();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        renderMetrics();
    }

    private void renderMetrics() {
        if (healthContainer == null || !isAdded())
            return;
        healthContainer.removeAllViews();
        long now = System.currentTimeMillis() / 1000;
        long todayStart = getTodayStartTimestamp();

        long rangeStart;
        int numBuckets;
        int bucketSize;
        if (currentRange == RANGE_DAY) {
            rangeStart = todayStart;
            numBuckets = 24;
            bucketSize = 3600;
        } else if (currentRange == RANGE_WEEK) {
            rangeStart = todayStart - 6 * 86400; // 7 days total including today
            numBuckets = 7;
            bucketSize = 86400;
        } else {
            rangeStart = todayStart - 29 * 86400; // 30 days
            numBuckets = 30;
            bucketSize = 86400;
        }

        for (String metric : METRICS) {
            String history = prefs.getString(PREF_HEALTH_PREFIX + metric, "");
            int latestToday = 0;
            float[] buckets = new float[numBuckets];

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
                        ts = todayStart + 3600; // Fake recent time for backwards compatibility
                    }

                    if (ts >= rangeStart && ts <= now + 86400) {
                        int bucketIdx = (int) ((ts - rangeStart) / bucketSize);
                        if (bucketIdx >= 0 && bucketIdx < numBuckets) {
                            if (val > buckets[bucketIdx]) {
                                buckets[bucketIdx] = val;
                            }
                        }
                    }

                    if (ts >= todayStart || !entry.contains(":")) {
                        latestToday = val;
                    }
                }
            }

            androidx.cardview.widget.CardView card = new androidx.cardview.widget.CardView(requireContext());
            LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            cardParams.setMargins(0, 0, 0, dpToPx(24));
            card.setLayoutParams(cardParams);
            card.setRadius(dpToPx(24));
            card.setCardElevation(dpToPx(8));
            card.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.card_library_start));

            LinearLayout cardContent = new LinearLayout(requireContext());
            cardContent.setOrientation(LinearLayout.VERTICAL);
            cardContent.setPadding(dpToPx(24), dpToPx(24), dpToPx(24), dpToPx(24));

            TextView title = new TextView(requireContext());
            title.setText(metric.replace("_", " ").toUpperCase(Locale.US));
            title.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_primary));
            title.setTextSize(16f);
            title.setTypeface(null, android.graphics.Typeface.BOLD);
            cardContent.addView(title);

            TextView valueText = new TextView(requireContext());
            valueText.setText(String.valueOf(latestToday));
            valueText.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_primary));
            valueText.setTextSize(36f);
            valueText.setTypeface(null, android.graphics.Typeface.BOLD);
            valueText.setPadding(0, dpToPx(8), 0, dpToPx(16));
            cardContent.addView(valueText);

            List<BarEntry> chartEntries = new ArrayList<>();
            boolean hasData = false;
            for (int i = 0; i < numBuckets; i++) {
                chartEntries.add(new BarEntry(i, buckets[i]));
                if (buckets[i] > 0)
                    hasData = true;
            }

            if (hasData || history.isEmpty()) {
                BarDataSet dataSet = new BarDataSet(chartEntries, "Data");
                dataSet.setColor(ContextCompat.getColor(requireContext(), R.color.accent_primary));
                dataSet.setDrawValues(false);

                BarData barData = new BarData(dataSet);
                barData.setBarWidth(0.7f);

                BarChart chart = new BarChart(requireContext());
                chart.setData(barData);
                chart.getDescription().setEnabled(false);
                chart.getLegend().setEnabled(false);

                chart.getXAxis().setDrawGridLines(false);
                chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
                chart.getXAxis().setTextColor(ContextCompat.getColor(requireContext(), R.color.text_secondary));
                chart.getXAxis().setAxisMinimum(-0.5f);
                chart.getXAxis().setAxisMaximum(numBuckets - 0.5f);

                chart.getAxisLeft().setTextColor(ContextCompat.getColor(requireContext(), R.color.text_secondary));
                chart.getAxisLeft().setAxisMinimum(0f);
                chart.getAxisRight().setEnabled(false);

                chart.setTouchEnabled(false);
                chart.animateY(800);

                cardContent.addView(chart, new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, dpToPx(180)));
            } else {
                TextView noData = new TextView(requireContext());
                noData.setText(getString(R.string.no_health_data));
                noData.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_secondary));
                cardContent.addView(noData);
            }

            card.addView(cardContent);
            healthContainer.addView(card);
        }
    }

    private int dpToPx(int dp) {
        if (!isAdded())
            return 0;
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
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
