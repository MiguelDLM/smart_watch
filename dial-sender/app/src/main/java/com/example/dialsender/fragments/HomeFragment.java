package com.example.dialsender.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.dialsender.R;
import com.example.dialsender.ble.BleManager;
import com.example.dialsender.ble.SleepAnalyzer;
import com.example.dialsender.views.GaugeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HomeFragment extends Fragment implements BleManager.BleStateListener {

    private static final String PREF_NAME = "dial_sender_prefs";
    private static final String PREF_HEALTH_PREFIX = "health_";

    private TextView txtGreeting, txtDate, homeStatusText;
    private View homeStatusDot;
    private GaugeView gaugeSteps, gaugeHeart, gaugeCalories, gaugeSpo2, gaugeSleep;
    private TextView txtSleepPhases;
    private BroadcastReceiver gaugeStyleReceiver;

    private SharedPreferences prefs;
    private BleManager bleManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        txtGreeting = view.findViewById(R.id.txtGreeting);
        txtDate = view.findViewById(R.id.txtDate);
        homeStatusText = view.findViewById(R.id.homeStatusText);
        homeStatusDot = view.findViewById(R.id.homeStatusDot);

        gaugeSteps = view.findViewById(R.id.gaugeSteps);
        gaugeHeart = view.findViewById(R.id.gaugeHeart);
        gaugeCalories = view.findViewById(R.id.gaugeCalories);
        gaugeSpo2 = view.findViewById(R.id.gaugeSpo2);
        gaugeSleep = view.findViewById(R.id.gaugeSleep);
        txtSleepPhases = view.findViewById(R.id.txtSleepPhases);

        prefs = requireContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        bleManager = BleManager.getInstance(requireContext());

        view.findViewById(R.id.gaugeCardSteps).setOnClickListener(v ->
                MetricDetailBottomSheet.newInstance("steps")
                        .show(getChildFragmentManager(), "detail"));

        view.findViewById(R.id.gaugeCardHeart).setOnClickListener(v ->
                MetricDetailBottomSheet.newInstance("heart_rate")
                        .show(getChildFragmentManager(), "detail"));

        view.findViewById(R.id.gaugeCardCalories).setOnClickListener(v ->
                MetricDetailBottomSheet.newInstance("calories")
                        .show(getChildFragmentManager(), "detail"));

        view.findViewById(R.id.gaugeCardSpo2).setOnClickListener(v ->
                MetricDetailBottomSheet.newInstance("blood_oxygen")
                        .show(getChildFragmentManager(), "detail"));

        view.findViewById(R.id.gaugeCardSleep).setOnClickListener(v ->
                MetricDetailBottomSheet.newInstance("sleep")
                        .show(getChildFragmentManager(), "detail"));

        updateDate();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        bleManager.setListener(this);
        refreshMetrics();
        updateConnectionState(bleManager.isSessionReady());

        gaugeStyleReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                applyGaugeStyle();
            }
        };
        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(
                gaugeStyleReceiver,
                new IntentFilter(SettingsFragment.ACTION_GAUGE_STYLE_CHANGED));
        applyGaugeStyle();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (gaugeStyleReceiver != null) {
            LocalBroadcastManager.getInstance(requireContext())
                    .unregisterReceiver(gaugeStyleReceiver);
            gaugeStyleReceiver = null;
        }
    }

    private void applyGaugeStyle() {
        if (!isAdded() || prefs == null) return;
        String style = prefs.getString("gauge_style", GaugeView.STYLE_A);
        GaugeView[] gauges = {gaugeSteps, gaugeHeart, gaugeCalories, gaugeSpo2, gaugeSleep};
        for (GaugeView g : gauges) {
            if (g != null) g.setGaugeStyle(style);
        }
    }

    private void updateDate() {
        if (txtDate == null) return;
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, d MMM", new Locale("es", "ES"));
        txtDate.setText(sdf.format(new Date()));
    }

    private void refreshMetrics() {
        if (!isAdded() || prefs == null) return;

        int goalSteps = prefs.getInt("goal_steps", 10000);
        int goalCal   = prefs.getInt("goal_calories", 500);
        int goalSleep = prefs.getInt("goal_sleep_min", 480);

        // Steps
        int steps = getLatestMetricValue("steps");
        gaugeSteps.setValue(steps > 0 ? (float) steps / goalSteps : 0f);
        gaugeSteps.setValueText(steps > 0 ? formatSteps(steps) : "—");
        gaugeSteps.setSubText("meta " + formatSteps(goalSteps));

        // Heart rate
        int hr = getLatestMetricValue("heart_rate");
        gaugeHeart.setValue(hr > 0 ? (float) hr / 200f : 0f);
        gaugeHeart.setValueText(hr > 0 ? String.valueOf(hr) : "—");
        gaugeHeart.setSubText(hr > 0 ? "Normal" : "Sin datos");

        // Calories
        int cal = getLatestMetricValue("calories");
        gaugeCalories.setValue(cal > 0 ? (float) cal / goalCal : 0f);
        gaugeCalories.setValueText(cal > 0 ? String.valueOf(cal) : "—");
        gaugeCalories.setSubText("meta " + goalCal);

        // SpO2
        int spo2 = getLatestMetricValue("blood_oxygen");
        gaugeSpo2.setValue(spo2 > 0 ? (float) spo2 / 100f : 0f);
        gaugeSpo2.setValueText(spo2 > 0 ? spo2 + "%" : "—");
        gaugeSpo2.setSubText(spo2 > 0 ? "Normal" : "Sin datos");

        // Sleep
        String sleepData = prefs.getString(PREF_HEALTH_PREFIX + "sleep", "");
        SleepAnalyzer.SleepResult sr = SleepAnalyzer.analyze(sleepData);
        int sleepMin = sr.totalMinutes;
        gaugeSleep.setValue(sleepMin > 0 ? (float) sleepMin / goalSleep : 0f);
        if (sleepMin > 0) {
            int h = sleepMin / 60, m = sleepMin % 60;
            gaugeSleep.setValueText(h > 0 ? h + "h" + m + "m" : m + "m");
            StringBuilder phases = new StringBuilder();
            if (sr.deepMin > 0) phases.append("Prof: ").append(formatMins(sr.deepMin)).append("  ");
            if (sr.lightMin > 0) phases.append("Lig: ").append(formatMins(sr.lightMin)).append("  ");
            if (sr.remMin > 0)   phases.append("REM: ").append(formatMins(sr.remMin));
            String phasesStr = phases.toString().trim();
            txtSleepPhases.setText(phasesStr.isEmpty() ? "Sin desglose" : phasesStr);
        } else {
            gaugeSleep.setValueText("—");
            txtSleepPhases.setText("Sin datos");
        }
    }

    private String formatSteps(int steps) {
        if (steps >= 1000) {
            return (steps / 1000) + "." + ((steps % 1000) / 100) + "K";
        }
        return String.valueOf(steps);
    }

    private String formatMins(int mins) {
        int h = mins / 60, m = mins % 60;
        return h > 0 ? h + "h" + m + "m" : m + "m";
    }

    private int getLatestMetricValue(String metric) {
        String history = prefs.getString(PREF_HEALTH_PREFIX + metric, "");
        if (history.isEmpty()) return 0;
        String[] entries = history.split(",");
        String last = entries[entries.length - 1].trim();
        try {
            if (last.contains(":")) {
                return Integer.parseInt(last.split(":")[1]);
            }
            return Integer.parseInt(last);
        } catch (Exception e) {
            return 0;
        }
    }

    private void updateConnectionState(boolean connected) {
        if (!isAdded()) return;
        if (connected) {
            homeStatusDot.setBackgroundResource(R.drawable.indicator_connected);
            homeStatusText.setText("Conectado");
            homeStatusText.setTextColor(requireContext().getColor(R.color.status_connected));
        } else {
            homeStatusDot.setBackgroundResource(R.drawable.indicator_disconnected);
            homeStatusText.setText("Desconectado");
            homeStatusText.setTextColor(requireContext().getColor(R.color.status_disconnected));
        }
    }

    // BleStateListener
    @Override
    public void onConnectionStateChange(boolean connected, boolean sessionReady) {
        if (!isAdded()) return;
        requireActivity().runOnUiThread(() -> updateConnectionState(sessionReady));
    }

    @Override public void onHealthDataReceived(String keyName, byte[] payload) {}

    @Override
    public void onHealthSyncComplete() {
        if (!isAdded()) return;
        requireActivity().runOnUiThread(this::refreshMetrics);
    }

    @Override public void onTransferProgress(int percent, long bytesTransferred, long totalBytes) {}
    @Override public void onTransferComplete() {}
    @Override public void onLogUpdated() {}
}
