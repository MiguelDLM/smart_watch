package com.example.dialsender;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dialsender.ble.BleManager;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Hidden developer tools, reached by tapping the version number 6 times in the
 * "Yo" tab. Hosts the BLE protocol log and the find-phone alert test — features
 * that don't belong in the everyday UI.
 */
public class DeveloperToolsActivity extends AppCompatActivity implements BleManager.BleStateListener {

    private TextView txtLog, txtLogCount, txtFindPhone;
    private ScrollView logScroll;
    private BleManager ble;

    protected void attachBaseContext(android.content.Context base) {
        super.attachBaseContext(LocaleHelper.wrap(base));
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ble = BleManager.getInstance(this);

        ScrollView outer = new ScrollView(this);
        outer.setBackgroundColor(0xFF0E1116);
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(dp(20), dp(20), dp(20), dp(24));

        // Header
        LinearLayout header = new LinearLayout(this);
        header.setOrientation(LinearLayout.HORIZONTAL);
        header.setGravity(Gravity.CENTER_VERTICAL);
        TextView back = new TextView(this);
        back.setText("‹");
        back.setTextColor(Color.WHITE);
        back.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
        back.setPadding(0, 0, dp(14), 0);
        back.setOnClickListener(v -> finish());
        header.addView(back);
        TextView title = new TextView(this);
        title.setText("Herramientas de desarrollo");
        title.setTextColor(Color.WHITE);
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        title.setTypeface(null, Typeface.BOLD);
        header.addView(title);
        root.addView(header);

        // --- Find phone test ---
        root.addView(sectionLabel("PRUEBA DE BUSCAR TELÉFONO"));
        TextView hint = new TextView(this);
        hint.setText("El reloj normalmente dispara esto y el teléfono suena hasta que lo detienes. "
                + "Aquí puedes probar la alerta manualmente.");
        hint.setTextColor(0xFF9AA4B2);
        hint.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        hint.setPadding(0, 0, 0, dp(10));
        root.addView(hint);

        txtFindPhone = new TextView(this);
        Button btnFindPhone = new Button(this);
        btnFindPhone.setText("Sonar / Detener");
        btnFindPhone.setOnClickListener(v -> {
            if (ble.isFindPhoneActive()) {
                ble.stopFindPhoneAlert();
                Toast.makeText(this, "Alerta detenida", Toast.LENGTH_SHORT).show();
            } else {
                ble.startFindPhoneAlert();
                Toast.makeText(this, "Sonando… toca de nuevo para detener", Toast.LENGTH_LONG).show();
            }
        });
        root.addView(btnFindPhone);

        // --- BLE log ---
        root.addView(sectionLabel("LOG BLE"));
        txtLogCount = new TextView(this);
        txtLogCount.setTextColor(0xFF6B7280);
        txtLogCount.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
        txtLogCount.setPadding(0, 0, 0, dp(6));
        root.addView(txtLogCount);

        logScroll = new ScrollView(this);
        logScroll.setBackgroundColor(0xFF161B22);
        logScroll.setPadding(dp(10), dp(10), dp(10), dp(10));
        LinearLayout.LayoutParams slp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, dp(280));
        logScroll.setLayoutParams(slp);
        txtLog = new TextView(this);
        txtLog.setTextColor(0xFF22D3EE);
        txtLog.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
        txtLog.setTypeface(Typeface.MONOSPACE);
        logScroll.addView(txtLog);
        root.addView(logScroll);

        LinearLayout logBtns = new LinearLayout(this);
        logBtns.setOrientation(LinearLayout.HORIZONTAL);
        logBtns.setPadding(0, dp(8), 0, 0);
        Button btnCopy = new Button(this);
        btnCopy.setText("Copiar");
        btnCopy.setOnClickListener(v -> copyLog());
        Button btnSave = new Button(this);
        btnSave.setText("Guardar");
        btnSave.setOnClickListener(v -> saveLog());
        Button btnClear = new Button(this);
        btnClear.setText("Limpiar");
        btnClear.setOnClickListener(v -> {
            BleManager.clearLog();
            refreshLog();
        });
        LinearLayout.LayoutParams bl = new LinearLayout.LayoutParams(0,
                ViewGroup.LayoutParams.WRAP_CONTENT, 1f);
        bl.setMargins(0, 0, dp(6), 0);
        btnCopy.setLayoutParams(bl);
        btnSave.setLayoutParams(bl);
        btnClear.setLayoutParams(new LinearLayout.LayoutParams(0,
                ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
        logBtns.addView(btnCopy);
        logBtns.addView(btnSave);
        logBtns.addView(btnClear);
        root.addView(logBtns);

        outer.addView(root);
        setContentView(outer);
    }

    private TextView sectionLabel(String s) {
        TextView t = new TextView(this);
        t.setText(s);
        t.setTextColor(0xFF22D3EE);
        t.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
        t.setTypeface(null, Typeface.BOLD);
        t.setPadding(0, dp(20), 0, dp(8));
        return t;
    }

    @Override
    protected void onResume() {
        super.onResume();
        ble.setListener(this);
        refreshLog();
    }

    private void refreshLog() {
        List<String> lines = BleManager.getLogLines();
        if (lines.isEmpty()) {
            txtLog.setText("Esperando eventos BLE…");
            txtLogCount.setText("0 líneas");
        } else {
            StringBuilder sb = new StringBuilder();
            for (String l : lines)
                sb.append(l).append("\n");
            txtLog.setText(sb.toString());
            txtLogCount.setText(lines.size() + " líneas");
        }
        logScroll.post(() -> logScroll.fullScroll(ScrollView.FOCUS_DOWN));
    }

    private void copyLog() {
        String t = BleManager.getLogText();
        if (t.isEmpty()) {
            Toast.makeText(this, "Sin log", Toast.LENGTH_SHORT).show();
            return;
        }
        ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        cm.setPrimaryClip(ClipData.newPlainText("BLE Log", t));
        Toast.makeText(this, "Log copiado", Toast.LENGTH_SHORT).show();
    }

    private void saveLog() {
        String t = BleManager.getLogText();
        if (t.isEmpty()) {
            Toast.makeText(this, "Sin log", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            String fn = "ble_log_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US)
                    .format(new Date()) + ".txt";
            File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            if (!dir.exists())
                dir.mkdirs();
            File f = new File(dir, fn);
            try (FileWriter w = new FileWriter(f)) {
                w.write(t);
            }
            Toast.makeText(this, "Guardado en Downloads/" + fn, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            try {
                File f = new File(getExternalFilesDir(null), "ble_log.txt");
                try (FileWriter w = new FileWriter(f)) {
                    w.write(t);
                }
                Toast.makeText(this, "Guardado en " + f.getAbsolutePath(), Toast.LENGTH_LONG).show();
            } catch (Exception e2) {
                Toast.makeText(this, "Error: " + e2.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    private int dp(int v) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, v, getResources().getDisplayMetrics());
    }

    // ===== BleStateListener =====
    @Override
    public void onConnectionStateChange(boolean connected, boolean sessionReady) {
    }

    @Override
    public void onHealthDataReceived(String k, byte[] p) {
    }

    @Override
    public void onHealthSyncComplete() {
    }

    @Override
    public void onTransferProgress(int pct, long done, long tot) {
    }

    @Override
    public void onTransferComplete() {
    }

    @Override
    public void onLogUpdated() {
        runOnUiThread(this::refreshLog);
    }

    @Override
    public void onFindPhoneRequest() {
    }
}
