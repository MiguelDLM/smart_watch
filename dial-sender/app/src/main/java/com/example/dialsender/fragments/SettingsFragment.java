package com.example.dialsender.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.dialsender.NotificationSettingsActivity;
import com.example.dialsender.R;

public class SettingsFragment extends Fragment {

    public static final String ACTION_GAUGE_STYLE_CHANGED = "com.example.dialsender.GAUGE_STYLE_CHANGED";
    private static final String PREF_NAME = "dial_sender_prefs";

    private SharedPreferences prefs;
    private boolean initializing = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        prefs = requireContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        // Profile header — show the bound device address (if any)
        android.widget.TextView profileDevice = view.findViewById(R.id.txtProfileDevice);
        if (profileDevice != null) {
            String addr = com.example.dialsender.ble.BleManager.getInstance(requireContext())
                    .getLastDeviceAddress();
            profileDevice.setText(addr != null ? "Reloj: " + addr : "Sin dispositivo vinculado");
        }

        // Notifications row
        view.findViewById(R.id.rowNotifications).setOnClickListener(v ->
                startActivity(new Intent(requireContext(), NotificationSettingsActivity.class)));

        // Gauge style radio group
        RadioGroup radioGauge = view.findViewById(R.id.radioGaugeStyle);
        String currentStyle = prefs.getString("gauge_style", "A");
        initializing = true;
        if ("B".equals(currentStyle))      radioGauge.check(R.id.radioGaugeB);
        else if ("C".equals(currentStyle)) radioGauge.check(R.id.radioGaugeC);
        else                               radioGauge.check(R.id.radioGaugeA);
        initializing = false;

        radioGauge.setOnCheckedChangeListener((group, checkedId) -> {
            if (initializing) return;
            String style;
            if (checkedId == R.id.radioGaugeB)      style = "B";
            else if (checkedId == R.id.radioGaugeC) style = "C";
            else                                     style = "A";
            prefs.edit().putString("gauge_style", style).apply();
            LocalBroadcastManager.getInstance(requireContext())
                    .sendBroadcast(new Intent(ACTION_GAUGE_STYLE_CHANGED));
        });

        // Distance unit spinner
        Spinner spinnerDist = view.findViewById(R.id.spinnerDistance);
        ArrayAdapter<String> distAdapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_spinner_dropdown_item, new String[]{"km", "millas"});
        spinnerDist.setAdapter(distAdapter);
        spinnerDist.setSelection("mi".equals(prefs.getString("unit_distance", "km")) ? 1 : 0);
        spinnerDist.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            boolean first = true;
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                if (first) { first = false; return; }
                String unit = position == 1 ? "mi" : "km";
                prefs.edit().putString("unit_distance", unit).apply();
                TextView lbl = getView() != null ? getView().findViewById(R.id.lblDistanceUnit) : null;
                if (lbl != null) lbl.setText("  " + unit);
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Weight unit spinner
        Spinner spinnerWeight = view.findViewById(R.id.spinnerWeight);
        ArrayAdapter<String> weightAdapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_spinner_dropdown_item, new String[]{"kg", "libras"});
        spinnerWeight.setAdapter(weightAdapter);
        spinnerWeight.setSelection("lb".equals(prefs.getString("unit_weight", "kg")) ? 1 : 0);
        spinnerWeight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            boolean first = true;
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                if (first) { first = false; return; }
                prefs.edit().putString("unit_weight", position == 1 ? "lb" : "kg").apply();
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Goal fields (save on focus lost)
        setupGoalField(view, R.id.etGoalSteps,    "goal_steps",     10000);
        setupGoalField(view, R.id.etGoalSleep,    "goal_sleep_min", 480);
        setupGoalField(view, R.id.etGoalCalories, "goal_calories",  500);
        setupGoalField(view, R.id.etGoalDistance, "goal_distance",  5);

        // Distance unit label initial state
        TextView lblDist = view.findViewById(R.id.lblDistanceUnit);
        lblDist.setText("  " + prefs.getString("unit_distance", "km"));

        return view;
    }

    private void setupGoalField(View root, int editTextId, String prefKey, int defaultVal) {
        EditText et = root.findViewById(editTextId);
        et.setText(String.valueOf(prefs.getInt(prefKey, defaultVal)));
        et.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                try {
                    int val = Integer.parseInt(et.getText().toString().trim());
                    prefs.edit().putInt(prefKey, val).apply();
                } catch (NumberFormatException ignored) {
                    et.setText(String.valueOf(prefs.getInt(prefKey, defaultVal)));
                }
            }
        });
    }
}
