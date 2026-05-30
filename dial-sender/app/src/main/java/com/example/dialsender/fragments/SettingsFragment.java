package com.example.dialsender.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.dialsender.DeveloperToolsActivity;
import com.example.dialsender.NotificationSettingsActivity;
import com.example.dialsender.R;

public class SettingsFragment extends Fragment {

    public static final String ACTION_GAUGE_STYLE_CHANGED = "com.example.dialsender.GAUGE_STYLE_CHANGED";
    private static final String PREF_NAME = "dial_sender_prefs";

    private SharedPreferences prefs;
    private boolean initializing = false;

    private ImageView imgProfile;
    private TextView txtProfileName;

    // Image picker that returns a persistable URI for the profile photo.
    private final ActivityResultLauncher<String[]> pickPhoto =
            registerForActivityResult(new ActivityResultContracts.OpenDocument(), uri -> {
                if (uri == null)
                    return;
                try {
                    requireContext().getContentResolver().takePersistableUriPermission(
                            uri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
                } catch (Exception ignored) {
                }
                prefs.edit().putString("profile_photo_uri", uri.toString()).apply();
                loadProfilePhoto();
            });

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        prefs = requireContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        // Profile header — photo, editable name, bound device
        imgProfile = view.findViewById(R.id.imgProfile);
        txtProfileName = view.findViewById(R.id.txtProfileName);
        TextView profileDevice = view.findViewById(R.id.txtProfileDevice);
        if (profileDevice != null) {
            String addr = com.example.dialsender.ble.BleManager.getInstance(requireContext())
                    .getLastDeviceAddress();
            profileDevice.setText(addr != null ? "Reloj: " + addr : "Sin dispositivo vinculado");
        }
        if (txtProfileName != null)
            txtProfileName.setText(prefs.getString("profile_name", "Mi perfil"));
        loadProfilePhoto();

        View profileCard = view.findViewById(R.id.profileCard);
        if (profileCard != null)
            profileCard.setOnClickListener(v -> editProfile());

        // Version footer — 6 consecutive taps unlock developer tools (Android-style)
        TextView txtVersion = view.findViewById(R.id.txtVersion);
        if (txtVersion != null) {
            txtVersion.setText(getString(R.string.app_name) + " v0.2");
            txtVersion.setOnClickListener(new View.OnClickListener() {
                int taps = 0;
                long last = 0;
                @Override
                public void onClick(View v) {
                    long now = System.currentTimeMillis();
                    taps = (now - last < 2000) ? taps + 1 : 1;
                    last = now;
                    if (taps >= 6) {
                        taps = 0;
                        startActivity(new Intent(requireContext(), DeveloperToolsActivity.class));
                    } else if (taps >= 3) {
                        Toast.makeText(requireContext(),
                                "Faltan " + (6 - taps) + " toques para herramientas de desarrollo",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        // Notifications row
        view.findViewById(R.id.rowNotifications).setOnClickListener(v ->
                startActivity(new Intent(requireContext(), NotificationSettingsActivity.class)));

        // Gauge style radio group
        RadioGroup radioGauge = view.findViewById(R.id.radioGaugeStyle);
        String currentStyle = prefs.getString("gauge_style", "B");
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

    /** Load the saved profile photo into the avatar (or keep the default icon). */
    private void loadProfilePhoto() {
        if (imgProfile == null)
            return;
        String uriStr = prefs.getString("profile_photo_uri", null);
        if (uriStr == null) {
            imgProfile.setImageResource(R.drawable.ic_nav_me);
            imgProfile.setColorFilter(getResources().getColor(R.color.accent_primary));
            imgProfile.setPadding(dp(14), dp(14), dp(14), dp(14));
            return;
        }
        try {
            android.graphics.Bitmap bmp = android.graphics.BitmapFactory.decodeStream(
                    requireContext().getContentResolver().openInputStream(Uri.parse(uriStr)));
            if (bmp != null) {
                imgProfile.clearColorFilter();
                imgProfile.setPadding(0, 0, 0, 0);
                imgProfile.setImageBitmap(circularBitmap(bmp));
                return;
            }
        } catch (Exception ignored) {
        }
        imgProfile.setImageResource(R.drawable.ic_nav_me);
        imgProfile.setColorFilter(getResources().getColor(R.color.accent_primary));
    }

    /** Crop a bitmap into a circle so the avatar reads as a profile photo. */
    private android.graphics.Bitmap circularBitmap(android.graphics.Bitmap src) {
        int size = Math.min(src.getWidth(), src.getHeight());
        android.graphics.Bitmap sq = android.graphics.Bitmap.createBitmap(src,
                (src.getWidth() - size) / 2, (src.getHeight() - size) / 2, size, size);
        android.graphics.Bitmap out = android.graphics.Bitmap.createBitmap(size, size,
                android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas c = new android.graphics.Canvas(out);
        android.graphics.Paint p = new android.graphics.Paint(android.graphics.Paint.ANTI_ALIAS_FLAG);
        c.drawCircle(size / 2f, size / 2f, size / 2f, p);
        p.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        c.drawBitmap(sq, 0, 0, p);
        return out;
    }

    /** Dialog to change the profile name and pick a photo. */
    private void editProfile() {
        android.widget.LinearLayout box = new android.widget.LinearLayout(requireContext());
        box.setOrientation(android.widget.LinearLayout.VERTICAL);
        int pad = dp(20);
        box.setPadding(pad, pad, pad, 0);

        final EditText etName = new EditText(requireContext());
        etName.setHint("Tu nombre");
        etName.setText(prefs.getString("profile_name", ""));
        box.addView(etName);

        new androidx.appcompat.app.AlertDialog.Builder(requireContext())
                .setTitle("Mi perfil")
                .setView(box)
                .setNeutralButton("Cambiar foto", (d, w) ->
                        pickPhoto.launch(new String[] { "image/*" }))
                .setPositiveButton("Guardar", (d, w) -> {
                    String name = etName.getText().toString().trim();
                    prefs.edit().putString("profile_name", name.isEmpty() ? "Mi perfil" : name).apply();
                    if (txtProfileName != null)
                        txtProfileName.setText(name.isEmpty() ? "Mi perfil" : name);
                })
                .setNegativeButton("Cancelar", null)
                .show();
    }

    private int dp(int v) {
        return (int) android.util.TypedValue.applyDimension(
                android.util.TypedValue.COMPLEX_UNIT_DIP, v, getResources().getDisplayMetrics());
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
