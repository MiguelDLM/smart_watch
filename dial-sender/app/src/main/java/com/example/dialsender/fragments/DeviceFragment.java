package com.example.dialsender.fragments;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.dialsender.R;
import com.example.dialsender.ble.BleManager;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DeviceFragment extends Fragment implements BleManager.BleStateListener {

    private View statusIndicator;
    private TextView txtStatus;
    private Button btnConnect;

    // BLE Log UI
    private TextView txtBleLog;
    private TextView txtLogCount;
    private ScrollView logScrollView;

    private BleManager bleManager;
    private BluetoothManager bluetoothManager;
    private BluetoothAdapter bluetoothAdapter;
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_device, container, false);

        // Connection UI
        statusIndicator = view.findViewById(R.id.statusIndicator);
        txtStatus = view.findViewById(R.id.txtStatus);
        btnConnect = view.findViewById(R.id.btnConnect);

        // BLE Log UI
        txtBleLog = view.findViewById(R.id.txtBleLog);
        txtLogCount = view.findViewById(R.id.txtLogCount);
        logScrollView = view.findViewById(R.id.logScrollView);
        Button btnCopyLog = view.findViewById(R.id.btnCopyLog);
        Button btnSaveLog = view.findViewById(R.id.btnSaveLog);
        Button btnClearLog = view.findViewById(R.id.btnClearLog);

        Button btnToggleLog = view.findViewById(R.id.btnToggleLog);
        View logButtonsRow = view.findViewById(R.id.logButtonsRow);
        btnToggleLog.setOnClickListener(v -> {
            boolean visible = logScrollView.getVisibility() == View.VISIBLE;
            logScrollView.setVisibility(visible ? View.GONE : View.VISIBLE);
            if (logButtonsRow != null) {
                logButtonsRow.setVisibility(visible ? View.GONE : View.VISIBLE);
            }
            ((Button) v).setText(visible ? "Mostrar log" : "Ocultar log");
        });

        bluetoothManager = (BluetoothManager) requireContext()
                .getSystemService(Context.BLUETOOTH_SERVICE);
        if (bluetoothManager != null) {
            bluetoothAdapter = bluetoothManager.getAdapter();
        }

        bleManager = BleManager.getInstance(requireContext());
        bleManager.setListener(this);

        btnConnect.setOnClickListener(v -> handleConnect());

        // Device function entries
        View btnWatchFaces = view.findViewById(R.id.btnWatchFaces);
        if (btnWatchFaces != null) {
            btnWatchFaces.setOnClickListener(v -> {
                if (getActivity() instanceof com.example.dialsender.MainActivity) {
                    ((com.example.dialsender.MainActivity) getActivity())
                            .showFragment(new DialsFragment());
                }
            });
        }
        View btnCamera = view.findViewById(R.id.btnCamera);
        if (btnCamera != null) {
            btnCamera.setOnClickListener(v ->
                    startActivity(new Intent(requireContext(), com.example.dialsender.CameraActivity.class)));
        }
        // "Buscar teléfono" is normally triggered FROM the watch (the phone rings).
        // This entry lets the user preview/stop that alert.
        View btnFindWatch = view.findViewById(R.id.btnFindWatch);
        if (btnFindWatch != null) {
            btnFindWatch.setOnClickListener(v -> {
                if (bleManager.isFindPhoneActive()) {
                    bleManager.stopFindPhoneAlert();
                } else {
                    bleManager.startFindPhoneAlert();
                    Toast.makeText(requireContext(),
                            "Sonando… (el reloj activa esto). Toca de nuevo o «Detener» para parar.",
                            Toast.LENGTH_LONG).show();
                }
            });
        }

        // Notificaciones de apps
        View btnNotifs = view.findViewById(R.id.btnNotifs);
        if (btnNotifs != null) {
            btnNotifs.setOnClickListener(v -> startActivity(
                    new Intent(requireContext(), com.example.dialsender.NotificationSettingsActivity.class)));
        }

        // Anti-pérdida toggle (verified: SET ANTI_LOST 0x0215, int8 0/1)
        TextView txtAntiLost = view.findViewById(R.id.txtAntiLost);
        View rowAntiLost = view.findViewById(R.id.rowAntiLost);
        if (txtAntiLost != null && rowAntiLost != null) {
            android.content.SharedPreferences sp = requireContext()
                    .getSharedPreferences("dial_sender_prefs", Context.MODE_PRIVATE);
            boolean[] state = { sp.getBoolean("set_antilost", false) };
            txtAntiLost.setText(state[0] ? R.string.state_on : R.string.state_off);
            rowAntiLost.setOnClickListener(v -> {
                state[0] = !state[0];
                txtAntiLost.setText(state[0] ? R.string.state_on : R.string.state_off);
                sp.edit().putBoolean("set_antilost", state[0]).apply();
                if (bleManager.isSessionReady()) {
                    bleManager.sendSetting(0x15, new byte[] { (byte) (state[0] ? 1 : 0) });
                } else {
                    Toast.makeText(requireContext(), "No conectado al reloj", Toast.LENGTH_SHORT).show();
                }
            });
        }

        android.content.SharedPreferences sp2 = requireContext()
                .getSharedPreferences("dial_sender_prefs", Context.MODE_PRIVATE);

        // No molestar (verified: NO_DISTURB_RANGE 0x020A = enabled + 3x BleTimeRange[en,sh,sm,eh,em])
        TextView txtDnd = view.findViewById(R.id.txtDnd);
        View rowDnd = view.findViewById(R.id.rowDnd);
        if (txtDnd != null && rowDnd != null) {
            boolean[] on = { sp2.getBoolean("set_dnd", false) };
            txtDnd.setText(on[0] ? R.string.state_on : R.string.state_off);
            rowDnd.setOnClickListener(v -> {
                on[0] = !on[0];
                txtDnd.setText(on[0] ? R.string.state_on : R.string.state_off);
                sp2.edit().putBoolean("set_dnd", on[0]).apply();
                if (bleManager.isSessionReady()) {
                    byte en = (byte) (on[0] ? 1 : 0);
                    byte[] p = new byte[16];
                    p[0] = en;                 // global enabled
                    p[1] = en; p[2] = 22; p[3] = 0; p[4] = 8; p[5] = 0; // range1 22:00–08:00
                    bleManager.sendSetting(0x0A, p);
                } else {
                    Toast.makeText(requireContext(), "No conectado al reloj", Toast.LENGTH_SHORT).show();
                }
            });
        }

        // Recordatorio sedentario (SEDENTARINESS 0x0209, 6B: bitfield[en|repeat], sh,sm,eh,em,interval)
        TextView txtSed = view.findViewById(R.id.txtSedentary);
        View rowSed = view.findViewById(R.id.rowSedentary);
        if (txtSed != null && rowSed != null) {
            boolean[] on = { sp2.getBoolean("set_sedentary", false) };
            txtSed.setText(on[0] ? R.string.state_on : R.string.state_off);
            rowSed.setOnClickListener(v -> {
                on[0] = !on[0];
                txtSed.setText(on[0] ? R.string.state_on : R.string.state_off);
                sp2.edit().putBoolean("set_sedentary", on[0]).apply();
                if (bleManager.isSessionReady()) {
                    byte b0 = (byte) ((on[0] ? 0x80 : 0x00) | 0x7F); // enabled bit + all weekdays
                    byte[] p = new byte[] { b0, 8, 0, 22, 0, 60 };   // 08:00–22:00, cada 60 min
                    bleManager.sendSetting(0x09, p);
                } else {
                    Toast.makeText(requireContext(), "No conectado al reloj", Toast.LENGTH_SHORT).show();
                }
            });
        }

        // Desconectar
        View btnDisconnect = view.findViewById(R.id.btnDisconnect);
        if (btnDisconnect != null) {
            btnDisconnect.setOnClickListener(v -> {
                bleManager.disconnect();
                Toast.makeText(requireContext(), "Desconectando…", Toast.LENGTH_SHORT).show();
            });
        }

        btnCopyLog.setOnClickListener(v -> copyLogToClipboard());
        btnSaveLog.setOnClickListener(v -> saveLogToFile());
        btnClearLog.setOnClickListener(v -> {
            BleManager.clearLog();
            txtBleLog.setText("Log cleared.");
            txtLogCount.setText("0 lines");
        });

        // Load existing log
        refreshLogView();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        bleManager.setListener(this);
        refreshLogView();
    }

    @Override
    public void onPause() {
        super.onPause();
        // Don't null out listener completely so connection callbacks still work
    }

    // ========== BleStateListener callbacks ==========

    @Override
    public void onConnectionStateChange(boolean connected, boolean sessionReady) {
        if (!isAdded())
            return;
        requireActivity().runOnUiThread(() -> {
            if (sessionReady) {
                statusIndicator.setBackgroundResource(R.drawable.indicator_connected);
                txtStatus.setText(R.string.connected);
                txtStatus.setTextColor(getResources().getColor(R.color.status_connected));
                btnConnect.setText(R.string.reconnect);
            } else if (connected) {
                txtStatus.setText(R.string.connecting);
                txtStatus.setTextColor(getResources().getColor(R.color.status_scanning));
            } else {
                statusIndicator.setBackgroundResource(R.drawable.indicator_disconnected);
                txtStatus.setText(R.string.disconnected);
                txtStatus.setTextColor(getResources().getColor(R.color.status_disconnected));
                btnConnect.setText(R.string.scan_connect);
            }
        });
    }

    @Override
    public void onHealthDataReceived(String keyName, byte[] payload) {
        // Health data will be handled elsewhere or logged
    }

    @Override
    public void onHealthSyncComplete() {
        // Health sync completion handled in StatusFragment
    }

    @Override
    public void onTransferProgress(int percent, long bytesTransferred, long totalBytes) {
        // Transfer progress handled in sending activity
    }

    @Override
    public void onTransferComplete() {
        // Transfer completion handled in sending activity
    }

    @Override
    public void onLogUpdated() {
        if (!isAdded())
            return;
        refreshLogView();
    }

    // ========== Log Viewer ==========

    private void refreshLogView() {
        if (txtBleLog == null || txtLogCount == null)
            return;

        List<String> lines = BleManager.getLogLines();
        if (lines.isEmpty()) {
            txtBleLog.setText("Waiting for BLE events...");
            txtLogCount.setText("0 lines");
        } else {
            StringBuilder sb = new StringBuilder();
            for (String line : lines) {
                sb.append(line).append("\n");
            }
            txtBleLog.setText(sb.toString());
            txtLogCount.setText(lines.size() + " lines");
        }

        // Auto-scroll to bottom
        logScrollView.post(() -> logScrollView.fullScroll(ScrollView.FOCUS_DOWN));
    }

    private void copyLogToClipboard() {
        String logText = BleManager.getLogText();
        if (logText.isEmpty()) {
            Toast.makeText(requireContext(), "No logs to copy", Toast.LENGTH_SHORT).show();
            return;
        }
        ClipboardManager clipboard = (ClipboardManager) requireContext()
                .getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("BLE Protocol Log", logText);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(requireContext(), "Log copied to clipboard (" + BleManager.getLogLines().size() + " lines)",
                Toast.LENGTH_SHORT).show();
    }

    private void saveLogToFile() {
        String logText = BleManager.getLogText();
        if (logText.isEmpty()) {
            Toast.makeText(requireContext(), "No logs to save", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US);
            String filename = "ble_log_" + sdf.format(new Date()) + ".txt";

            File downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            if (!downloadsDir.exists()) {
                downloadsDir.mkdirs();
            }
            File logFile = new File(downloadsDir, filename);

            FileWriter writer = new FileWriter(logFile);
            writer.write("=== BLE Protocol Log ===\n");
            writer.write("Exported: " + new Date().toString() + "\n");
            writer.write("========================\n\n");
            writer.write(logText);
            writer.close();

            Toast.makeText(requireContext(), "Saved to Downloads/" + filename, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            // Fallback: save to app-specific directory
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US);
                String filename = "ble_log_" + sdf.format(new Date()) + ".txt";

                File appDir = requireContext().getExternalFilesDir(null);
                File logFile = new File(appDir, filename);
                FileWriter writer = new FileWriter(logFile);
                writer.write("=== BLE Protocol Log ===\n");
                writer.write("Exported: " + new Date().toString() + "\n");
                writer.write("========================\n\n");
                writer.write(logText);
                writer.close();

                Toast.makeText(requireContext(), "Saved to " + logFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
            } catch (Exception e2) {
                Toast.makeText(requireContext(), "Failed to save: " + e2.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    // ========== Connection ==========

    private void handleConnect() {
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            Toast.makeText(requireContext(), R.string.enable_bt, Toast.LENGTH_SHORT).show();
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (ContextCompat.checkSelfPermission(requireContext(),
                    Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(
                        new String[] { Manifest.permission.BLUETOOTH_SCAN, Manifest.permission.BLUETOOTH_CONNECT }, 1);
                return;
            }
        } else {
            if (ContextCompat.checkSelfPermission(requireContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[] { Manifest.permission.ACCESS_FINE_LOCATION }, 1);
                return;
            }
        }

        // Check already connected GATT devices — offer chooser if multiple
        if (bluetoothManager != null) {
            if (ContextCompat.checkSelfPermission(requireContext(),
                    Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED
                    || Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
                List<BluetoothDevice> connectedDevices = bluetoothManager.getConnectedDevices(BluetoothProfile.GATT);
                List<BluetoothDevice> namedDevices = new ArrayList<>();
                for (BluetoothDevice device : connectedDevices) {
                    namedDevices.add(device);
                }

                if (namedDevices.size() == 1) {
                    txtStatus.setText(R.string.connecting);
                    bleManager.connect(namedDevices.get(0));
                    return;
                } else if (namedDevices.size() > 1) {
                    String[] names = new String[namedDevices.size()];
                    for (int i = 0; i < namedDevices.size(); i++) {
                        BluetoothDevice d = namedDevices.get(i);
                        String name = d.getName();
                        names[i] = (name != null && !name.isEmpty() ? name : "Unknown") + " (" + d.getAddress() + ")";
                    }
                    new AlertDialog.Builder(requireContext())
                            .setTitle(R.string.select_watch)
                            .setItems(names, (dialog, which) -> {
                                txtStatus.setText(R.string.connecting);
                                bleManager.connect(namedDevices.get(which));
                            })
                            .show();
                    return;
                }
            }
        }

        btnConnect.setText(R.string.scanning);
        btnConnect.setEnabled(false);

        List<BluetoothDevice> foundDevices = new ArrayList<>();
        bluetoothAdapter.startLeScan(new BluetoothAdapter.LeScanCallback() {
            @Override
            public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
                boolean exists = false;
                for (BluetoothDevice d : foundDevices) {
                    if (d.getAddress().equals(device.getAddress())) {
                        exists = true;
                        break;
                    }
                }
                if (!exists)
                    foundDevices.add(device);
            }
        });

        handler.postDelayed(() -> {
            bluetoothAdapter.stopLeScan(null);
            if (!isAdded())
                return;
            btnConnect.setText(R.string.scan_connect);
            btnConnect.setEnabled(true);

            if (foundDevices.isEmpty()) {
                Toast.makeText(requireContext(), R.string.no_ble_found, Toast.LENGTH_SHORT).show();
            } else if (foundDevices.size() == 1) {
                txtStatus.setText(R.string.connecting);
                bleManager.connect(foundDevices.get(0));
            } else {
                String[] names = new String[foundDevices.size()];
                for (int i = 0; i < foundDevices.size(); i++) {
                    BluetoothDevice d = foundDevices.get(i);
                    if (ContextCompat.checkSelfPermission(requireContext(),
                            Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED
                            || Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
                        String name = d.getName();
                        names[i] = (name != null && !name.isEmpty() ? name : "Unknown") + " (" + d.getAddress() + ")";
                    } else {
                        names[i] = "Unknown (" + d.getAddress() + ")";
                    }
                }
                new AlertDialog.Builder(requireContext())
                        .setTitle(R.string.select_watch)
                        .setItems(names, (dialog, which) -> {
                            txtStatus.setText(R.string.connecting);
                            bleManager.connect(foundDevices.get(which));
                        })
                        .show();
            }
        }, 10000);
    }
}
