package com.example.dialsender.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.dialsender.R;
import com.example.dialsender.ble.BleManager;
import com.example.dialsender.ble.SleepAnalyzer;
import com.example.dialsender.views.SleepTimelineView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MetricDetailBottomSheet extends BottomSheetDialogFragment {

    private static final String ARG_METRIC = "metric_key";
    private static final String PREF_NAME = "dial_sender_prefs";
    private static final String PREF_HEALTH_PREFIX = "health_";

    private static final int RANGE_DAY = 0, RANGE_WEEK = 1, RANGE_MONTH = 2, RANGE_ALL = 3;
    private int currentRange = RANGE_DAY;

    private String metricKey;
    private SharedPreferences prefs;
    private FrameLayout chartContainer;
    private TextView txtTitle, txtValue;

    public static MetricDetailBottomSheet newInstance(String metricKey) {
        MetricDetailBottomSheet sheet = new MetricDetailBottomSheet();
        Bundle args = new Bundle();
        args.putString(ARG_METRIC, metricKey);
        sheet.setArguments(args);
        return sheet;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_metric_detail, container, false);

        metricKey = getArguments() != null ? getArguments().getString(ARG_METRIC, "steps") : "steps";
        prefs = requireContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        txtTitle = view.findViewById(R.id.txtDetailTitle);
        txtValue = view.findViewById(R.id.txtDetailValue);
        chartContainer = view.findViewById(R.id.detailChartContainer);

        txtTitle.setText(metricKey.replace("_", " ").toUpperCase(Locale.US));

        MaterialButtonToggleGroup toggle = view.findViewById(R.id.toggleDetailRange);
        toggle.check(R.id.btnDetailDay);
        toggle.addOnButtonCheckedListener((group, checkedId, isChecked) -> {
            if (isChecked) {
                if (checkedId == R.id.btnDetailDay)
                    currentRange = RANGE_DAY;
                else if (checkedId == R.id.btnDetailWeek)
                    currentRange = RANGE_WEEK;
                else if (checkedId == R.id.btnDetailMonth)
                    currentRange = RANGE_MONTH;
                else if (checkedId == R.id.btnDetailAll)
                    currentRange = RANGE_ALL;
                renderChart();
            }
        });

        Button btnSync = view.findViewById(R.id.btnSyncDetail);
        btnSync.setOnClickListener(v -> {
            BleManager ble = BleManager.getInstance(requireContext());
            if (ble.isSessionReady()) {
                ble.syncHealth();
                Toast.makeText(requireContext(), "Sincronizando...", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(requireContext(), "No conectado", Toast.LENGTH_SHORT).show();
            }
        });

        View btnShare = view.findViewById(R.id.btnShareDetail);
        if (btnShare != null)
            btnShare.setOnClickListener(v -> shareMetric());

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        renderChart();
    }

    private void renderChart() {
        if (chartContainer == null || !isAdded())
            return;
        chartContainer.removeAllViews();
        String history = prefs.getString(PREF_HEALTH_PREFIX + metricKey, "");

        if ("sleep".equals(metricKey)) {
            SleepTimelineView stv = new SleepTimelineView(requireContext());
            stv.setSleepData(history);
            chartContainer.addView(stv, new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT));
            SleepAnalyzer.SleepResult sr = SleepAnalyzer.analyze(history);
            if (sr.totalMinutes > 0) {
                int h = sr.totalMinutes / 60, m = sr.totalMinutes % 60;
                txtValue.setText(h + "h " + m + "m");
            } else {
                txtValue.setText("—");
            }
            long now = System.currentTimeMillis() / 1000;
            long todayStart = getTodayStart();
            long rangeStart;
            int numBuckets, bucketSize;
            if (currentRange == RANGE_DAY) {
                rangeStart = todayStart;
                numBuckets = 24;
                bucketSize = 3600;
            } else if (currentRange == RANGE_WEEK) {
                rangeStart = todayStart - 6L * 86400;
                numBuckets = 7;
                bucketSize = 86400;
            } else if (currentRange == RANGE_MONTH) {
                rangeStart = todayStart - 29L * 86400;
                numBuckets = 30;
                bucketSize = 86400;
            } else {
                rangeStart = findEarliestTimestamp();
                numBuckets = (int) ((now - rangeStart) / 86400) + 1;
                if (numBuckets <= 0)
                    numBuckets = 1;
                bucketSize = 86400;
            }

            float[] buckets = new float[numBuckets];
            float[][] sleepStacks = null;
            if ("sleep".equals(metricKey) && currentRange != RANGE_DAY) {
                sleepStacks = new float[numBuckets][3];
            }

            int latestVal = 0;
            if (!history.isEmpty()) {
                long lastTs = -1;
                int lastMode = -1;
                for (String entry : history.split(",")) {
                    long ts = 0;
                    int val = 0;
                    if (entry.contains(":")) {
                        try {
                            ts = Long.parseLong(entry.split(":")[0]);
                            val = Integer.parseInt(entry.split(":")[1]);
                        } catch (Exception ignored) {
                        }
                    } else {
                        try {
                            val = Integer.parseInt(entry.trim());
                            ts = todayStart + 3600;
                        } catch (Exception ignored) {
                        }
                    }
                    if (ts >= rangeStart && ts <= now + 86400) {
                        int idx = (int) ((ts - rangeStart) / bucketSize);
                        if (idx >= 0 && idx < numBuckets) {
                            if ("sleep".equals(metricKey) && currentRange != RANGE_DAY) {
                                if (lastTs != -1 && ts > lastTs) {
                                    int lastBucketIdx = (int) ((lastTs - rangeStart) / bucketSize);
                                    if (lastBucketIdx >= 0 && lastBucketIdx < numBuckets) {
                                        float deltaHours = (ts - lastTs) / 3600f;
                                        if (lastMode == 1)
                                            sleepStacks[lastBucketIdx][0] += deltaHours; // Deep
                                        else if (lastMode == 2 || lastMode == 8)
                                            sleepStacks[lastBucketIdx][1] += deltaHours; // Light
                                        else if (lastMode == 9)
                                            sleepStacks[lastBucketIdx][2] += deltaHours; // REM
                                    }
                                }
                                lastTs = ts;
                                lastMode = val;
                            } else if ("sleep".equals(metricKey) && currentRange == RANGE_DAY) {
                                buckets[idx] = val;
                            } else if (val > buckets[idx]) {
                                buckets[idx] = val;
                            }
                        }
                    }
                    if (ts >= todayStart && ts <= now)
                        latestVal = val;
                }
            }

            String displayVal = (latestVal == 0 && "blood_oxygen".equals(metricKey)) ? "—"
                    : String.valueOf(latestVal);
            txtValue.setText(displayVal);

            List<BarEntry> entries = new ArrayList<>();
            for (int i = 0; i < numBuckets; i++) {
                if (sleepStacks != null) {
                    entries.add(new BarEntry(i, sleepStacks[i]));
                } else {
                    entries.add(new BarEntry(i, buckets[i]));
                }
            }

            BarDataSet ds = new BarDataSet(entries, "Data");
            if (sleepStacks != null) {
                ds.setColors(new int[] {
                        ContextCompat.getColor(requireContext(), R.color.accent_purple), // Deep
                        ContextCompat.getColor(requireContext(), R.color.accent_primary), // Light
                        ContextCompat.getColor(requireContext(), R.color.accent_pink) // REM
                });
                ds.setStackLabels(new String[] { "Profundo", "Ligero", "REM" });
            } else {
                ds.setColor(ContextCompat.getColor(requireContext(), R.color.accent_primary));
            }
            ds.setDrawValues(false);

            BarData data = new BarData(ds);
            data.setBarWidth(0.7f);

            BarChart chart = new BarChart(requireContext());
            chart.setData(data);
            chart.getDescription().setEnabled(false);
            chart.getLegend().setEnabled(false);
            chart.getXAxis().setDrawGridLines(false);
            chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
            chart.getXAxis().setTextColor(ContextCompat.getColor(requireContext(), R.color.text_secondary));
            chart.getAxisLeft().setTextColor(ContextCompat.getColor(requireContext(), R.color.text_secondary));
            chart.getAxisLeft().setAxisMinimum(0f);
            chart.getAxisRight().setEnabled(false);
            chart.setTouchEnabled(false);
            chart.animateY(600);

            chartContainer.addView(chart, new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT));
        }
    }

    private void shareMetric() {
        String label = metricKey.replace("_", " ");
        String range = currentRange == RANGE_DAY ? "hoy"
                : currentRange == RANGE_WEEK ? "esta semana" : "este mes";
        String val = txtValue.getText() != null ? txtValue.getText().toString() : "—";
        String text = "Mi " + label + " (" + range + "): " + val + "\nCompartido desde Fogg";
        android.content.Intent i = new android.content.Intent(android.content.Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(android.content.Intent.EXTRA_TEXT, text);
        startActivity(android.content.Intent.createChooser(i, "Compartir"));
    }

    private long getTodayStart() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis() / 1000;
    }

    private long findEarliestTimestamp() {
        long earliest = System.currentTimeMillis() / 1000;
        String history = prefs.getString(PREF_HEALTH_PREFIX + metricKey, "");
        if (!history.isEmpty()) {
            String firstEntry = history.split(",")[0];
            if (firstEntry.contains(":")) {
                try {
                    earliest = Long.parseLong(firstEntry.split(":")[0]);
                } catch (Exception ignored) {
                }
            }
        }
        return earliest;
    }
}
