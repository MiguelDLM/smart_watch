package com.example.dialsender.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dialsender.DialLibraryActivity;
import com.example.dialsender.R;
import com.example.dialsender.ble.BleManager;
import com.example.dialsender.ble.SleepAnalyzer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HomeFragment extends Fragment implements BleManager.BleStateListener {

    private static final String PREF_NAME = "dial_sender_prefs";
    private static final String PREF_HEALTH_PREFIX = "health_";

    private TextView txtGreeting, txtDate, txtSteps, txtStepsGoal;
    private TextView txtHeartRate, txtHeartRateSub, txtCalories, txtCaloriesSub;
    private TextView txtSleep, txtSleepSub, txtLastDial;
    private TextView homeStatusText;
    private View homeStatusDot;
    private ProgressBar progressSteps;
    private SharedPreferences prefs;
    private BleManager bleManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        txtGreeting = view.findViewById(R.id.txtGreeting);
        txtDate = view.findViewById(R.id.txtDate);
        txtSteps = view.findViewById(R.id.txtSteps);
        txtStepsGoal = view.findViewById(R.id.txtStepsGoal);
        txtHeartRate = view.findViewById(R.id.txtHeartRate);
        txtHeartRateSub = view.findViewById(R.id.txtHeartRateSub);
        txtCalories = view.findViewById(R.id.txtCalories);
        txtCaloriesSub = view.findViewById(R.id.txtCaloriesSub);
        txtSleep = view.findViewById(R.id.txtSleep);
        txtSleepSub = view.findViewById(R.id.txtSleepSub);
        txtLastDial = view.findViewById(R.id.txtLastDial);
        homeStatusText = view.findViewById(R.id.homeStatusText);
        homeStatusDot = view.findViewById(R.id.homeStatusDot);
        progressSteps = view.findViewById(R.id.progressSteps);

        prefs = requireContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        bleManager = BleManager.getInstance(requireContext());

        view.findViewById(R.id.cardSendDialHome).setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), DialLibraryActivity.class);
            startActivity(intent);
        });

        updateDate();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        bleManager.setListener(this);
        refreshMetrics();
        updateConnectionState(bleManager.isSessionReady());
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void updateDate() {
        if (txtDate == null) return;
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, d MMM", new Locale("es", "ES"));
        txtDate.setText(sdf.format(new Date()));
    }

    private void refreshMetrics() {
        if (!isAdded() || prefs == null) return;

        // Steps
        int steps = getLatestMetricValue("steps");
        txtSteps.setText(steps > 0 ? String.format(Locale.US, "%,d", steps) : "—");
        progressSteps.setProgress(Math.min(steps, 10000));

        // Heart rate
        int hr = getLatestMetricValue("heart_rate");
        txtHeartRate.setText(hr > 0 ? String.valueOf(hr) : "—");
        txtHeartRateSub.setText(hr > 0 ? "Normal" : "Sin datos");

        // Calories
        int cal = getLatestMetricValue("calories");
        txtCalories.setText(cal > 0 ? String.format(Locale.US, "%,d", cal) : "—");

        // Sleep (analyzed from raw mode records)
        String sleepData = prefs.getString(PREF_HEALTH_PREFIX + "sleep", "");
        SleepAnalyzer.SleepResult sleepRes = SleepAnalyzer.analyze(sleepData);
        int sleepMin = sleepRes.totalMinutes;
        if (sleepMin > 0) {
            int h = sleepMin / 60;
            int m = sleepMin % 60;
            txtSleep.setText(h > 0 ? h + "h " + m + "m" : m + "m");
            String phases = "";
            if (sleepRes.deepMin > 0) phases += "P: " + (sleepRes.deepMin/60) + "h" + (sleepRes.deepMin%60) + "m  ";
            if (sleepRes.lightMin > 0) phases += "L: " + (sleepRes.lightMin/60) + "h" + (sleepRes.lightMin%60) + "m  ";
            if (sleepRes.remMin > 0)   phases += "REM: " + sleepRes.remMin + "m";
            txtSleepSub.setText(phases.trim().isEmpty() ? "Sin desglose" : phases.trim());
        } else {
            txtSleep.setText("—");
            txtSleepSub.setText("Sin datos");
        }
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
    @Override public void onHealthSyncComplete() {
        if (!isAdded()) return;
        requireActivity().runOnUiThread(this::refreshMetrics);
    }
    @Override public void onTransferProgress(int percent, long bytesTransferred, long totalBytes) {}
    @Override public void onTransferComplete() {}
    @Override public void onLogUpdated() {}
}
