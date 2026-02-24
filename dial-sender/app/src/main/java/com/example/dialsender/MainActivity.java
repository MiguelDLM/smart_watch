package com.example.dialsender;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DialSender";
    private static final int PERMISSION_REQUEST_CODE = 1;
    private static final int FILE_SELECT_CODE = 2;

    // UUIDs from STF Emulator
    private static final UUID SERVICE_UUID = UUID.fromString("6e400001-b5a3-f393-e0a9-e50e24dcca9e");
    private static final UUID WRITE_CHAR_UUID = UUID.fromString("6e400002-b5a3-f393-e0a9-e50e24dcca9e");
    private static final UUID NOTIFY_CHAR_UUID = UUID.fromString("6e400003-b5a3-f393-e0a9-e50e24dcca9e");
    private static final UUID CCCD_UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");

    // UI
    private TextView txtStatus;
    private TextView txtDeviceName;
    private TextView txtFileInfo;
    private TextView txtProgress;
    private TextView txtTransferStatus;
    private View statusIndicator;
    private Button btnScan;
    private Button btnSelectFile;
    private Button btnSendDial;
    private View btnViewLogs; // Added
    private Button btnCancel; // Added
    private ProgressBar progressBar;
    private LinearLayout transferCard;

    // Bluetooth
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothGatt bluetoothGatt;
    private BluetoothGattCharacteristic writeChar;
    private boolean isConnected = false;
    private Handler mainHandler = new Handler(Looper.getMainLooper());
    private String connectedDeviceName = "";

    // Protocol State
    private enum ConnectionState {
        DISCONNECTED,
        CONNECTED,
        HANDSHAKE_SENT,
        HANDSHAKE_OK,
        BIND_SENT,
        BIND_OK,
        LOGIN_SENT,
        SESSION_READY,
        WATCHFACE_ID_SENT,
        PRE_TRANSFER,
        SETUP1_SENT,
        SETUP2_SENT,
        TRANSFERRING
    }

    private ConnectionState connectionState = ConnectionState.DISCONNECTED;

    // File Transfer State
    private byte[] fileBytesToSend;
    private long fileTotalSize;
    private boolean isFileTransferActive = false;
    private int currentMtu = 23;
    private ConcurrentLinkedQueue<byte[]> commandQueue = new ConcurrentLinkedQueue<>();
    private boolean isSending = false;
    private int packetsSent = 0;
    private byte[] lastChunkSent = null;
    private int writeRetryCount = 0;
    private static final int MAX_WRITE_RETRIES = 3;
    private static final long WRITE_TIMEOUT_MS = 5000;
    private final Runnable writeWatchdogRunnable = this::handleWriteTimeout;
    // Session Persistence
    private SharedPreferences prefs;
    private static final String PREF_NAME = "dial_sender_prefs";
    private static final String PREF_BIND_ID = "bind_id";
    private static final String PREF_DEVICE_ADDRESS = "device_address";
    private static final String PREF_HEALTH_PREFIX = "health_";
    private static final int HEALTH_HISTORY_SIZE = 20;
    private Runnable transferTimeoutRunnable;
    private int transferRetryCount = 0;
    private static final int MAX_TRANSFER_RETRIES = 3;
    private static final long TRANSFER_TIMEOUT_MS = 3000;
    private long lastTransferOffset = -1;
    private Runnable preTransferTimeoutRunnable;
    private static final long PRE_TRANSFER_TIMEOUT_MS = 1500;
    private Runnable setupTimeoutRunnable;
    private static final long SETUP_TIMEOUT_MS = 2000;

    // Handshake Magic Bytes
    private static final byte[] HANDSHAKE_CMD = new byte[] {
            (byte) 0xAB, 0x01, 0x00, 0x07,
            (byte) 0xB1, (byte) 0xB2, 0x03, 0x02,
            0x20, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF
    };

    // CRC Table
    private static final int[] CRC16_TABLE = {
            0, 49345, 49537, 320, 49921, 960, 640, 49729, 50689, 1728, 1920, 51009, 1280, 50625, 50305, 1088, 52225,
            3264, 3456, 52545, 3840, 53185, 52865, 3648, 2560, 51905, 52097, 2880, 51457, 2496, 2176, 51265, 55297,
            6336, 6528, 55617, 6912, 56257, 55937, 6720, 7680, 57025, 57217, 8000, 56577, 7616, 7296, 56385, 5120,
            54465, 54657, 5440, 55041, 6080, 5760, 54849, 53761, 4800, 4992, 54081, 4352, 53697, 53377, 4160, 61441,
            12480, 12672, 61761, 13056, 62401, 62081, 12864, 13824, 63169, 63361, 14144, 62721, 13760, 13440, 62529,
            15360, 64705, 64897, 15680, 65281, 16320, 16000, 65089, 64001, 15040, 15232, 64321, 14592, 63937, 63617,
            14400, 10240, 59585, 59777, 10560, 60161, 11200, 10880, 59969, 60929, 11968, 12160, 61249, 11520, 60865,
            60545, 11328, 58369, 9408, 9600, 58689, 9984, 59329, 59009, 9792, 8704, 58049, 58241, 9024, 57601, 8640,
            8320, 57409, 40961, 24768, 24960, 41281, 25344, 41921, 41601, 25152, 26112, 42689, 42881, 26432, 42241,
            26048, 25728, 42049, 27648, 44225, 44417, 27968, 44801, 28608, 28288, 44609, 43521, 27328, 27520, 43841,
            26880, 43457, 43137, 26688, 30720, 47297, 47489, 31040, 47873, 31680, 31360, 47681, 48641, 32448, 32640,
            48961, 32000, 48577, 48257, 31808, 46081, 29888, 30080, 46401, 30464, 47041, 46721, 30272, 29184, 45761,
            45953, 29504, 45313, 29120, 28800, 45121, 20480, 37057, 37249, 20800, 37633, 21440, 21120, 37441, 38401,
            22208, 22400, 38721, 21760, 38337, 38017, 21568, 39937, 23744, 23936, 40257, 24320, 40897, 40577, 24128,
            23040, 39617, 39809, 23360, 39169, 22976, 22656, 38977, 34817, 18624, 18816, 35137, 19200, 35777, 35457,
            19008, 19968, 36545, 36737, 20288, 36097, 19904, 19584, 35905, 17408, 33985, 34177, 17728, 34561, 18368,
            18048, 34369, 33281, 17088, 17280, 33601, 16640, 33217, 32897, 16448
    };

    // Protocol Sequencing
    private int preTransferIndex = 0;
    private int setupStep = 0;

    // Setup method selection (mirrors stfemulator implementation)
    private enum SetupMethod {
        CAPTURED,
        DERIVED
    }

    private SetupMethod setupMethod = SetupMethod.CAPTURED;
    private boolean setupAttemptedCaptured = false;
    private boolean setupAttemptedDerived = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SettingsActivity.applyGlobalTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Bind UI
        prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        txtStatus = findViewById(R.id.txtStatus);
        txtDeviceName = findViewById(R.id.txtDeviceName);
        txtFileInfo = findViewById(R.id.txtFileInfo);
        txtProgress = findViewById(R.id.txtProgress);
        txtTransferStatus = findViewById(R.id.txtTransferStatus);
        statusIndicator = findViewById(R.id.statusIndicator);
        btnScan = findViewById(R.id.btnScan);
        btnSelectFile = findViewById(R.id.btnSelectFile);
        btnSendDial = findViewById(R.id.btnSendDial);
        progressBar = findViewById(R.id.progressBar);
        btnViewLogs = findViewById(R.id.btnViewLogs);
        btnCancel = findViewById(R.id.btnCancel);
        transferCard = findViewById(R.id.transferCard);
        btnScan.setOnClickListener(v -> startScan());
        btnSelectFile.setOnClickListener(v -> openFilePicker());
        btnSelectFile.setEnabled(false);

        // Send button — only sends when file is loaded AND connected
        btnSendDial.setEnabled(false);
        btnSendDial.setOnClickListener(v -> sendFile());

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
        btnViewLogs.setOnClickListener(v -> {
            startActivity(new Intent(this, LogActivity.class));
        });
        btnCancel.setOnClickListener(v -> cancelTransfer());

        checkPermissions();

        // Check if we have an existing connection from a previous session
        if (bluetoothGatt != null && isConnected && connectionState == ConnectionState.SESSION_READY) {
            updateConnectionUI(true);
        }
        // Check if launched from library with a pre-selected file
        handleIncomingFile();
        tryAutoReconnect();
        if (getIntent().getBooleanExtra("trigger_health_sync", false)) {
            mainHandler.postDelayed(() -> {
                if (connectionState == ConnectionState.SESSION_READY) {
                    syncHealth();
                    Toast.makeText(this, R.string.health_sync_started, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, R.string.session_not_ready, Toast.LENGTH_SHORT).show();
                }
            }, 500);
        }
    }

    private void handleIncomingFile() {
        String filePath = getIntent().getStringExtra("dial_file_path");
        if (filePath != null) {
            try {
                java.io.File f = new java.io.File(filePath);
                java.io.FileInputStream fis = new java.io.FileInputStream(f);
                ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int len;
                while ((len = fis.read(buffer)) != -1)
                    byteBuffer.write(buffer, 0, len);
                fis.close();
                fileBytesToSend = byteBuffer.toByteArray();
                fileTotalSize = fileBytesToSend.length;
                String sizeStr = fileTotalSize > 1024
                        ? String.format("%.1f KB", fileTotalSize / 1024.0)
                        : fileTotalSize + " bytes";
                log("File loaded from library: " + f.getName() + " (" + sizeStr + ")");
                txtFileInfo.setText(f.getName() + " \u2014 " + sizeStr);
                txtFileInfo.setTextColor(getResources().getColor(R.color.accent_secondary));
                updateSendButtonState();
            } catch (Exception e) {
                log("Error loading file from library: " + e.getMessage());
            }
        }
    }

    /**
     * Enable the Send button only when BOTH conditions are met:
     * 1. A file is loaded
     * 2. The BLE session is ready
     */
    private void updateSendButtonState() {
        runOnUiThread(() -> {
            boolean fileReady = fileBytesToSend != null && fileBytesToSend.length > 0;
            boolean sessionReady = isConnected && connectionState == ConnectionState.SESSION_READY;
            btnSendDial.setEnabled(fileReady && sessionReady && !isFileTransferActive);
        });
    }

    private void log(String msg) {
        Log.d(TAG, msg);
        LogActivity.appendLog(msg);
    }

    private void updateConnectionUI(boolean connected) {
        runOnUiThread(() -> {
            if (connected) {
                statusIndicator.setBackgroundResource(R.drawable.indicator_connected);
                txtStatus.setText(R.string.connected);
                txtStatus.setTextColor(getResources().getColor(R.color.status_connected));
                txtDeviceName.setText(connectedDeviceName);
                btnSelectFile.setEnabled(true);
                btnScan.setText(R.string.reconnect);
            } else {
                statusIndicator.setBackgroundResource(R.drawable.indicator_disconnected);
                txtStatus.setText(R.string.disconnected);
                txtStatus.setTextColor(getResources().getColor(R.color.status_disconnected));
                txtDeviceName.setText("");
                btnSelectFile.setEnabled(false);
                btnScan.setText(R.string.scan_connect);
            }
            updateSendButtonState();
        });
    }

    private void checkPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(this,
                            Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[] {
                        Manifest.permission.BLUETOOTH_SCAN,
                        Manifest.permission.BLUETOOTH_CONNECT,
                        Manifest.permission.ACCESS_FINE_LOCATION
                }, PERMISSION_REQUEST_CODE);
            }
        } else {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.ACCESS_FINE_LOCATION },
                        PERMISSION_REQUEST_CODE);
            }
        }
    }

    private void startScan() {
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        bluetoothAdapter = bluetoothManager.getAdapter();

        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            log("Bluetooth not enabled");
            Toast.makeText(this, R.string.enable_bt, Toast.LENGTH_SHORT).show();
            return;
        }

        // If already connected and session ready, re-enable file sending
        if (isConnected && connectionState == ConnectionState.SESSION_READY) {
            log("Already connected and session ready. Ready to send.");
            updateConnectionUI(true);
            return;
        }

        // Check already connected GATT devices — offer chooser if multiple
        List<BluetoothDevice> connectedDevices = bluetoothManager.getConnectedDevices(BluetoothProfile.GATT);
        List<BluetoothDevice> namedDevices = new ArrayList<>();
        for (BluetoothDevice device : connectedDevices) {
            String name = device.getName();
            if (name != null) {
                namedDevices.add(device);
                log("Found connected device: " + name + " (" + device.getAddress() + ")");
            }
        }
        if (namedDevices.size() == 1) {
            connectToDevice(namedDevices.get(0));
            return;
        } else if (namedDevices.size() > 1) {
            // Multiple GATT devices — let user pick
            String[] names = new String[namedDevices.size()];
            for (int i = 0; i < namedDevices.size(); i++) {
                BluetoothDevice d = namedDevices.get(i);
                names[i] = d.getName() + " (" + d.getAddress() + ")";
            }
            runOnUiThread(() -> new AlertDialog.Builder(this)
                    .setTitle(R.string.select_watch)
                    .setItems(names, (dialog, which) -> connectToDevice(namedDevices.get(which)))
                    .setCancelable(true)
                    .show());
            return;
        }

        log("Scanning for BLE devices...");
        btnScan.setText(R.string.scanning);
        btnScan.setEnabled(false);

        // Collect ALL found devices with names for selection dialog
        List<BluetoothDevice> foundDevices = new ArrayList<>();

        bluetoothAdapter.startLeScan(new BluetoothAdapter.LeScanCallback() {
            @Override
            public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
                String name = device.getName();
                if (name != null && !name.isEmpty()) {
                    for (BluetoothDevice d : foundDevices) {
                        if (d.getAddress().equals(device.getAddress()))
                            return;
                    }
                    foundDevices.add(device);
                    log("Found: " + name + " (" + device.getAddress() + ") RSSI=" + rssi);
                }
            }
        });

        mainHandler.postDelayed(() -> {
            if (bluetoothAdapter != null) {
                bluetoothAdapter.stopLeScan(null);
            }
            runOnUiThread(() -> {
                btnScan.setText(R.string.scan_connect);
                btnScan.setEnabled(true);
            });

            if (foundDevices.isEmpty()) {
                log("No BLE devices found");
                runOnUiThread(() -> Toast.makeText(this, R.string.no_ble_found, Toast.LENGTH_LONG).show());
            } else if (foundDevices.size() == 1) {
                connectToDevice(foundDevices.get(0));
            } else {
                String[] names = new String[foundDevices.size()];
                for (int i = 0; i < foundDevices.size(); i++) {
                    BluetoothDevice d = foundDevices.get(i);
                    names[i] = d.getName() + " (" + d.getAddress() + ")";
                }
                runOnUiThread(() -> new AlertDialog.Builder(this)
                        .setTitle(R.string.select_watch)
                        .setItems(names, (dialog, which) -> connectToDevice(foundDevices.get(which)))
                        .setCancelable(true)
                        .show());
            }
        }, 10000);
    }

    private void connectToDevice(BluetoothDevice device) {
        connectedDeviceName = device.getName() != null ? device.getName() : device.getAddress();
        log("Connecting to " + connectedDeviceName + " (" + device.getAddress() + ")");
        prefs.edit().putString(PREF_DEVICE_ADDRESS, device.getAddress()).apply();
        runOnUiThread(() -> {
            txtStatus.setText(R.string.connecting);
            txtStatus.setTextColor(getResources().getColor(R.color.status_scanning));
        });
        bluetoothGatt = device.connectGatt(this, false, gattCallback);
    }

    private final BluetoothGattCallback gattCallback = new BluetoothGattCallback() {
        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            if (newState == BluetoothProfile.STATE_CONNECTED) {
                isConnected = true;
                log("Connected. Discovering services...");
                updateConnectionUI(true);
                gatt.discoverServices();
            } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                isConnected = false;
                connectionState = ConnectionState.DISCONNECTED;
                log("Disconnected - Resetting state");
                updateConnectionUI(false);
                commandQueue.clear();
                isSending = false;
                isFileTransferActive = false;
                runOnUiThread(() -> {
                    transferCard.setVisibility(View.GONE);
                    btnSelectFile.setEnabled(false);
                    btnSendDial.setEnabled(false);
                });

                // Auto-reconnect via prefs after 5 seconds
                String lastAddr = prefs.getString(PREF_DEVICE_ADDRESS, null);
                if (lastAddr != null) {
                    log("Will auto-reconnect in 5s...");
                    mainHandler.postDelayed(() -> tryAutoReconnect(), 5000);
                }
            }
        }

        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                BluetoothGattService service = gatt.getService(SERVICE_UUID);
                if (service != null) {
                    writeChar = service.getCharacteristic(WRITE_CHAR_UUID);
                    BluetoothGattCharacteristic notifyChar = service.getCharacteristic(NOTIFY_CHAR_UUID);

                    if (writeChar != null && notifyChar != null) {
                        log("STF Services Found!");
                        gatt.setCharacteristicNotification(notifyChar, true);
                        BluetoothGattDescriptor descriptor = notifyChar.getDescriptor(CCCD_UUID);
                        if (descriptor != null) {
                            descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                            gatt.writeDescriptor(descriptor);
                            log("Enabling notifications...");
                        }
                    } else {
                        log("Required characteristics not found");
                    }
                } else {
                    log("STF Service UUID not found - device may not be compatible");
                }
            }
        }

        @Override
        public void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                log("Notifications enabled. Requesting MTU...");
                gatt.requestMtu(512);
            }
        }

        @Override
        public void onMtuChanged(BluetoothGatt gatt, int mtu, int status) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                currentMtu = mtu - 3;
                log("MTU changed to " + mtu + " (payload=" + currentMtu + ")");
                sendHandshake();
            }
        }

        @Override
        public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
            byte[] data = characteristic.getValue();
            if (data != null)
                processResponse(data);
        }

        @Override
        public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            // Cancel watchdog on any callback
            mainHandler.removeCallbacks(writeWatchdogRunnable);
            writeRetryCount = 0;
            if (status == BluetoothGatt.GATT_SUCCESS) {
                sendNextChunk();
            } else {
                log("Write failed: " + status);
            }
        }
    };

    // --- Protocol Implementation ---

    private void sendHandshake() {
        log("Sending Handshake...");
        connectionState = ConnectionState.HANDSHAKE_SENT;
        if (!isFileTransferActive) {
            commandQueue.clear();
        }
        packetsSent = 0;
        enqueueLogicalFrame(HANDSHAKE_CMD);
        isSending = true;
        sendNextChunk();
    }

    private void sendBind() {
        log("Sending Bind...");
        int bindId = new Random().nextInt();
        prefs.edit().putInt(PREF_BIND_ID, bindId).apply();
        ByteBuffer payload = ByteBuffer.allocate(4);
        payload.order(ByteOrder.LITTLE_ENDIAN);
        payload.putInt(bindId);

        byte[] message = createMessage((byte) 0x03, (byte) 0x01, (byte) 0x20, payload.array());
        connectionState = ConnectionState.BIND_SENT;
        enqueueLogicalFrame(message);
        isSending = true;
        sendNextChunk();
    }

    private void sendLogin() {
        log("Sending Login...");
        int sessionId = new Random().nextInt();
        ByteBuffer payload = ByteBuffer.allocate(4);
        payload.order(ByteOrder.LITTLE_ENDIAN);
        payload.putInt(sessionId);

        byte[] message = createMessage((byte) 0x03, (byte) 0x02, (byte) 0x20, payload.array());
        connectionState = ConnectionState.LOGIN_SENT;
        enqueueLogicalFrame(message);
        isSending = true;
        sendNextChunk();
    }

    private void processResponse(byte[] data) {
        if (data.length == 0 || data[0] != (byte) 0xAB)
            return;

        int header = data[1] & 0xFF;
        boolean isReply = (header & 0x10) != 0;

        if (data.length < 9)
            return;
        byte cmd = data[6];
        byte key = data[7];
        byte flag = data[8];

        log("Rx: Cmd=" + String.format("%02X", cmd) + " Key=" + String.format("%02X", key) + " State="
                + connectionState);

        // Handle Identity Info Request from watch -> implies Session Ready
        if ((header & 0x10) == 0 && header == 0x01 && cmd == 0x03 && key == 0x01) {
            log("Received Identity Request - Sending ACK");
            sendAck(cmd, key, flag);
            if (connectionState == ConnectionState.LOGIN_SENT) {
                connectionState = ConnectionState.SESSION_READY;
                log("=== SESSION READY ===");
                updateConnectionUI(true);
                runOnUiThread(() -> btnSelectFile.setEnabled(true));
            }
            return;
        }

        // Handshake ACK
        if (isReply && connectionState == ConnectionState.HANDSHAKE_SENT) {
            log("Handshake OK");
            connectionState = ConnectionState.HANDSHAKE_OK;
            int storedBindId = prefs.getInt(PREF_BIND_ID, 0);
            if (storedBindId != 0) {
                log("Using stored bind ID, skipping bind");
                mainHandler.postDelayed(this::sendLogin, 100);
            } else {
                mainHandler.postDelayed(this::sendBind, 100);
            }
            return;
        }

        // Bind ACK
        if (isReply && cmd == 0x03 && key == 0x01 && connectionState == ConnectionState.BIND_SENT) {
            log("Bind OK");
            connectionState = ConnectionState.BIND_OK;
            mainHandler.postDelayed(this::sendLogin, 100);
            return;
        }

        // Login ACK
        if (isReply && cmd == 0x03 && key == 0x02 && connectionState == ConnectionState.LOGIN_SENT) {
            log("Login OK");
            connectionState = ConnectionState.SESSION_READY;
            log("=== SESSION READY ===");
            updateConnectionUI(true);
            runOnUiThread(() -> btnSelectFile.setEnabled(true));
            return;
        }

        // Watchface ID ACK
        if (isReply && cmd == 0x02 && key == 0x27 && connectionState == ConnectionState.WATCHFACE_ID_SENT) {
            log("Watchface ID ACK");
            mainHandler.postDelayed(this::startPreTransferSequence, 50);
            return;
        }

        // Pre-Transfer ACK

        if (isReply && connectionState == ConnectionState.PRE_TRANSFER) {
            if (preTransferTimeoutRunnable != null)
                mainHandler.removeCallbacks(preTransferTimeoutRunnable);
            log("Pre-Transfer ACK");
            preTransferIndex++;
            mainHandler.postDelayed(this::sendNextPreTransferCommand, 50);
            return;
        }

        // Setup1 ACK
        if (isReply && cmd == 0x02 && key == 0x20 && connectionState == ConnectionState.SETUP1_SENT) {
            if (setupTimeoutRunnable != null)
                mainHandler.removeCallbacks(setupTimeoutRunnable);
            log("Setup1 ACK");
            setupStep = 2;
            mainHandler.postDelayed(this::sendSetupStep2, 50);
            return;
        }

        // Setup2 ACK
        if (isReply && cmd == 0x04 && key == 0x0C && connectionState == ConnectionState.SETUP2_SENT) {
            if (setupTimeoutRunnable != null)
                mainHandler.removeCallbacks(setupTimeoutRunnable);
            log("Setup2 ACK");
            mainHandler.postDelayed(this::startStreamTransfer, 50);
            return;
        }

        // Progress / Completion
        if (cmd == 0x07 && key == 0x01 && data.length >= 18) {
            // Clear transfer timeout on progress
            if (transferTimeoutRunnable != null)
                mainHandler.removeCallbacks(transferTimeoutRunnable);
            transferRetryCount = 0;
            // Parse progress
            byte[] payload = Arrays.copyOfRange(data, 9, data.length);
            int statusByte = payload[0] & 0xFF;
            int transferStatus = (statusByte >> 4) & 0x0F;
            int error = statusByte & 0x0F;

            ByteBuffer bb = ByteBuffer.wrap(payload);
            bb.order(ByteOrder.BIG_ENDIAN);
            bb.position(1);
            long total = bb.getInt() & 0xFFFFFFFFL;
            long completed = bb.getInt() & 0xFFFFFFFFL;
            int percent = (total > 0) ? (int) ((completed * 100) / total) : 0;
            log("Progress: " + completed + "/" + total + " (" + percent + "%) Err=" + error);
            runOnUiThread(() -> {
                progressBar.setProgress(percent);
                txtProgress.setText(percent + "%");
                txtTransferStatus.setText(completed + " / " + total + " bytes");
            });
            if (transferStatus == 0) {
                if (isFileTransferActive && completed < total) {
                    sendStreamChunk(completed);
                } else if (isFileTransferActive && completed >= total) {
                    log("=== Transfer Complete! ===");
                    isFileTransferActive = false;
                    // PERSISTENT: Stay in SESSION_READY — ready for next transfer
                    connectionState = ConnectionState.SESSION_READY;
                    // CRITICAL FIX: Reset queue state so next transfer works cleanly
                    commandQueue.clear();
                    isSending = false;
                    packetsSent = 0;

                    runOnUiThread(() -> {
                        txtProgress.setText("100%");
                        txtTransferStatus.setText(R.string.transfer_complete);
                        progressBar.setProgress(100);
                        btnSelectFile.setEnabled(true);
                        updateSendButtonState();
                        Toast.makeText(this, R.string.dial_sent_ok, Toast.LENGTH_LONG).show();
                    });
                }
            }
            return;
        }

        // Health data responses (Cmd=0x05)
        if (isReply && cmd == 0x05) {
            String keyName;
            switch (key) {
                case 0x03:
                    keyName = "Steps";
                    break;
                case 0x04:
                    keyName = "Calories";
                    break;
                case 0x05:
                    keyName = "Sleep";
                    break;
                case 0x07:
                    keyName = "Distance";
                    break;
                case 0x09:
                    keyName = "Heart Rate";
                    break;
                case 0x0B:
                    keyName = "Blood Oxygen";
                    break;
                case 0x0D:
                    keyName = "Unknown_0D";
                    break;
                case 0x0E:
                    keyName = "Unknown_0E";
                    break;
                default:
                    keyName = "Unknown_" + String.format("%02X", key);
                    break;
            }
            byte[] healthPayload = (data.length > 9) ? Arrays.copyOfRange(data, 9, data.length) : new byte[0];
            log("Health [" + keyName + "]: " + bytesToHex(healthPayload));
            storeHealthValue(keyName, healthPayload);
            return;
        }
    }

    // --- File Transfer ---

    private void openFilePicker() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, FILE_SELECT_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FILE_SELECT_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            try {
                InputStream is = getContentResolver().openInputStream(data.getData());
                ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer)) != -1) {
                    byteBuffer.write(buffer, 0, len);
                }
                fileBytesToSend = byteBuffer.toByteArray();
                fileTotalSize = fileBytesToSend.length;

                String sizeStr = fileTotalSize > 1024
                        ? String.format("%.1f KB", fileTotalSize / 1024.0)
                        : fileTotalSize + " bytes";
                log("File Loaded: " + sizeStr);

                runOnUiThread(() -> {
                    txtFileInfo.setText(getString(R.string.dial_file) + ": " + sizeStr);
                    txtFileInfo.setTextColor(getResources().getColor(R.color.accent_secondary));
                    updateSendButtonState();
                });

                // DON'T auto-send — user must press the "Send" button
            } catch (Exception e) {
                log("Error reading file: " + e.getMessage());
                runOnUiThread(() -> Toast.makeText(this, R.string.error_read_file, Toast.LENGTH_SHORT).show());
            }
        }
    }

    private void sendFile() {
        if (connectionState != ConnectionState.SESSION_READY) {
            log("Session not ready! Current state: " + connectionState);
            Toast.makeText(this, R.string.session_not_ready, Toast.LENGTH_SHORT).show();
            return;
        }

        if (fileBytesToSend == null || fileBytesToSend.length == 0) {
            Toast.makeText(this, R.string.select_file_first, Toast.LENGTH_SHORT).show();
            return;
        }

        // ====== CRITICAL FIX: Full state reset before starting new transfer ======
        commandQueue.clear();
        isSending = false;
        packetsSent = 0;
        preTransferIndex = 0;
        setupStep = 0;
        isFileTransferActive = true;

        // Show transfer card
        runOnUiThread(() -> {
            transferCard.setVisibility(View.VISIBLE);
            txtProgress.setText("0%");
            txtTransferStatus.setText(R.string.preparing);
            progressBar.setProgress(0);
            btnSelectFile.setEnabled(false);
            btnSendDial.setEnabled(false);
        });

        startPreTransferSequence();
    }

    private void cancelTransfer() {
        log("Transfer cancelled by user");
        isFileTransferActive = false;
        commandQueue.clear();
        isSending = false;
        connectionState = ConnectionState.SESSION_READY;

        runOnUiThread(() -> {
            transferCard.setVisibility(View.GONE);
            btnSelectFile.setEnabled(true);
            updateSendButtonState();
            Toast.makeText(this, R.string.cancelled, Toast.LENGTH_SHORT).show();
        });
    }

    private static class PreTransferCommand {
        byte cmd, key, flag, header;
        byte[] payload;

        PreTransferCommand(int cmd, int key, int flag, byte[] payload) {
            this.cmd = (byte) cmd;
            this.key = (byte) key;
            this.flag = (byte) flag;
            this.header = 0x01;
            this.payload = payload;
        }

        PreTransferCommand(int cmd, int key, int flag, byte[] payload, int header) {
            this.cmd = (byte) cmd;
            this.key = (byte) key;
            this.flag = (byte) flag;
            this.header = (byte) header;
            this.payload = payload;
        }
    }

    private List<PreTransferCommand> getPreTransferCommands() {
        List<PreTransferCommand> cmds = new ArrayList<>();
        cmds.add(new PreTransferCommand(0x02, 0x1a, 0x00,
                new byte[] { 0x00, 0x0a, 0x00, 0x02, 0x03, 0x30, 0x00, 0x00, 0x05, 0x1c }, 0x01));
        cmds.add(new PreTransferCommand(0x02, 0x1a, 0x00,
                new byte[] { 0x00, 0x0a, 0x00, 0x02, 0x03, 0x30, 0x00, 0x00, 0x05, 0x1c }, 0x00));
        cmds.add(new PreTransferCommand(0x02, 0x1a, 0x00,
                new byte[] { 0x00, 0x0a, 0x00, 0x02, 0x03, 0x30, 0x00, 0x00, 0x05, 0x1c }, 0x03));
        cmds.add(new PreTransferCommand(0x02, 0x03, 0x10, null));
        cmds.add(new PreTransferCommand(0x02, 0x02, 0x00, new byte[] { 0x04 }));
        cmds.add(new PreTransferCommand(0x02, 0x15, 0x00, new byte[] { 0x00 }));
        cmds.add(new PreTransferCommand(0x05, 0x02, 0x10, null));
        cmds.add(new PreTransferCommand(0x02, 0x03, 0x10, null));
        return cmds;
    }

    private void startPreTransferSequence() {
        log("Starting Pre-Transfer...");
        connectionState = ConnectionState.PRE_TRANSFER;
        preTransferIndex = 0;
        sendNextPreTransferCommand();
    }

    private void sendNextPreTransferCommand() {
        List<PreTransferCommand> cmds = getPreTransferCommands();
        if (preTransferIndex >= cmds.size()) {
            log("Pre-Transfer Done");
            startSetupSequence();
            return;
        }
        PreTransferCommand c = cmds.get(preTransferIndex);
        byte[] msg = createMessageWithHeader(c.header, c.cmd, c.key, c.flag, c.payload);
        connectionState = ConnectionState.PRE_TRANSFER;
        enqueueLogicalFrame(msg);
        isSending = true;
        sendNextChunk();
        schedulePreTransferTimeout();
    }

    private void startSetupSequence() {
        log("Starting Setup...");
        sendSetupStep1();
    }

    private void sendSetupStep1() {
        byte[] payload = new byte[] {
                (byte) 0xC3, 0x25, (byte) 0xB3, (byte) 0xC2, (byte) 0x9F, (byte) 0xA2, (byte) 0xA7, 0x41,
                0x02, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        };

        log("Setup1: Sending Session/Auth Token");
        byte[] msg = createMessage((byte) 0x02, (byte) 0x20, (byte) 0x00, payload);
        connectionState = ConnectionState.SETUP1_SENT;
        enqueueLogicalFrame(msg);
        isSending = true;
        sendNextChunk();
        scheduleSetupTimeout("SETUP1");
    }

    private void sendSetupStep2() {
        String name = "Custom Dial";
        byte[] nameBytes = name.getBytes();

        byte[] payload = new byte[101];
        Arrays.fill(payload, (byte) 0);

        payload[0] = 0x00;
        payload[1] = 0x1A;
        payload[2] = 0x02;
        payload[3] = 0x05;
        payload[4] = 0x08;
        payload[5] = 0x31;
        payload[6] = (byte) nameBytes.length;

        System.arraycopy(nameBytes, 0, payload, 7, Math.min(nameBytes.length, 60));

        byte[] tail = new byte[] {
                0x10, 0x00, 0x00, 0x01, 0x00, 0x03, 0x51, 0x0A,
                0x00, 0x00, 0x00, 0x0D, 0x21, 0x2D, 0x00, 0x33,
                0x04, 0x02, 0x00, 0x00
        };

        int tailPos = payload.length - tail.length;
        System.arraycopy(tail, 0, payload, tailPos, tail.length);

        log("Setup2: Sending dial metadata");

        byte[] msg = createMessage((byte) 0x04, (byte) 0x0C, (byte) 0x00, payload);
        connectionState = ConnectionState.SETUP2_SENT;
        enqueueLogicalFrame(msg);
        isSending = true;
        sendNextChunk();
        scheduleSetupTimeout("SETUP2");
    }

    private void startStreamTransfer() {
        log("Starting Stream Transfer...");
        connectionState = ConnectionState.TRANSFERRING;
        runOnUiThread(() -> txtTransferStatus.setText(R.string.transferring));
        sendStreamChunk(0);
    }

    private void sendStreamChunk(long offset) {
        if (!isFileTransferActive)
            return;

        long remaining = fileTotalSize - offset;
        if (remaining <= 0)
            return;

        int chunkSize = (int) Math.min(remaining, 1018);
        byte[] chunk = new byte[chunkSize];
        System.arraycopy(fileBytesToSend, (int) offset, chunk, 0, chunkSize);

        byte[] id = new byte[4];
        id[0] = (byte) ((fileTotalSize >> 24) & 0xFF);
        id[1] = (byte) ((fileTotalSize >> 16) & 0xFF);
        id[2] = (byte) ((fileTotalSize >> 8) & 0xFF);
        id[3] = (byte) (fileTotalSize & 0xFF);

        ByteBuffer bb = ByteBuffer.allocate(9 + chunkSize);
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.put((byte) 0);
        bb.put(id);
        bb.putInt((int) offset);
        bb.put(chunk);

        byte[] message = createMessage((byte) 0x07, (byte) 0x01, (byte) 0x00, bb.array());
        enqueueLogicalFrame(message);
        isSending = true;
        sendNextChunk();
        scheduleTransferTimeout(offset);
    }

    // --- Helpers ---

    private byte[] createMessage(byte cmd, byte key, byte flag, byte[] payload) {
        return createMessageWithHeader((byte) 0x01, cmd, key, flag, payload);
    }

    private byte[] createMessageWithHeader(byte header, byte cmd, byte key, byte flag, byte[] payload) {
        int payloadLen = (payload != null) ? payload.length : 0;
        ByteBuffer buffer = ByteBuffer.allocate(payloadLen + 9);
        buffer.put((byte) 0xAB);
        buffer.put(header);
        buffer.putShort((short) (payloadLen + 3));
        buffer.putShort((short) 0);
        buffer.put(cmd);
        buffer.put(key);
        buffer.put(flag);
        if (payload != null)
            buffer.put(payload);

        byte[] arr = buffer.array();
        int crc = calculateCrc16(arr, 6);
        arr[4] = (byte) ((crc >> 8) & 0xFF);
        arr[5] = (byte) (crc & 0xFF);
        return arr;
    }

    private void sendAck(byte cmd, byte key, byte flag) {
        byte[] msg = createMessageWithHeader((byte) 0x11, cmd, key, flag, new byte[] { 0x00 });
        enqueueLogicalFrame(msg);
        isSending = true;
        sendNextChunk();
    }

    private int calculateCrc16(byte[] data, int offset) {
        int crc = 0;
        for (int i = offset; i < data.length; i++) {
            crc = (CRC16_TABLE[(crc ^ (data[i] & 0xFF)) & 0xFF] ^ (crc >>> 8)) & 0xFFFF;
        }
        return crc;
    }

    private void enqueueLogicalFrame(byte[] frame) {
        int offset = 0;
        while (offset < frame.length) {
            int remaining = frame.length - offset;
            int size = Math.min(remaining, currentMtu);
            byte[] chunk = new byte[size];
            System.arraycopy(frame, offset, chunk, 0, size);
            commandQueue.add(chunk);
            offset += size;
        }
    }

    private void sendNextChunk() {
        if (commandQueue.isEmpty()) {
            isSending = false;
            return;
        }
        byte[] chunk = commandQueue.poll();
        if (chunk != null && writeChar != null && bluetoothGatt != null) {
            lastChunkSent = chunk;
            writeChar.setValue(chunk);
            writeChar.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
            bluetoothGatt.writeCharacteristic(writeChar);
            // Start watchdog — if no callback within 5s, retry or abort
            mainHandler.removeCallbacks(writeWatchdogRunnable);
            mainHandler.postDelayed(writeWatchdogRunnable, WRITE_TIMEOUT_MS);
        }
    }

    private void handleWriteTimeout() {
        if (!isSending && commandQueue.isEmpty())
            return;
        writeRetryCount++;
        if (writeRetryCount > MAX_WRITE_RETRIES) {
            log("Write watchdog: max retries exceeded, aborting transfer");
            isFileTransferActive = false;
            commandQueue.clear();
            isSending = false;
            connectionState = ConnectionState.SESSION_READY;
            runOnUiThread(() -> {
                transferCard.setVisibility(View.GONE);
                btnSelectFile.setEnabled(true);
                updateSendButtonState();
                Toast.makeText(this, "Transfer stalled — please retry", Toast.LENGTH_LONG).show();
            });
            return;
        }
        log("Write watchdog: retrying chunk (attempt " + writeRetryCount + ")");
        // Re-send last chunk
        if (lastChunkSent != null && writeChar != null && bluetoothGatt != null) {
            writeChar.setValue(lastChunkSent);
            writeChar.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
            bluetoothGatt.writeCharacteristic(writeChar);
            mainHandler.postDelayed(writeWatchdogRunnable, WRITE_TIMEOUT_MS);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Don't close GATT here to keep connection persistent
    }

    // --- Timeout & Retry Methods ---

    private void tryAutoReconnect() {
        String lastAddr = prefs.getString(PREF_DEVICE_ADDRESS, null);
        if (lastAddr == null)
            return;
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        bluetoothAdapter = bluetoothManager.getAdapter();
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled())
            return;
        BluetoothDevice device = bluetoothAdapter.getRemoteDevice(lastAddr);
        if (device != null) {
            log("Auto-reconnecting to " + lastAddr);
            connectToDevice(device);
        }
    }

    private void scheduleTransferTimeout(long offset) {
        if (transferTimeoutRunnable != null)
            mainHandler.removeCallbacks(transferTimeoutRunnable);
        lastTransferOffset = offset;
        transferTimeoutRunnable = () -> {
            if (isFileTransferActive && lastTransferOffset == offset) {
                transferRetryCount++;
                if (transferRetryCount <= MAX_TRANSFER_RETRIES) {
                    log("Transfer stalled at offset " + offset + ", retry " + transferRetryCount);
                    sendStreamChunk(offset);
                } else {
                    log("Transfer failed after " + MAX_TRANSFER_RETRIES + " retries");
                    isFileTransferActive = false;
                    runOnUiThread(() -> txtStatus.setText("Transfer Failed"));
                }
            }
        };
        mainHandler.postDelayed(transferTimeoutRunnable, TRANSFER_TIMEOUT_MS);
    }

    private void schedulePreTransferTimeout() {
        if (preTransferTimeoutRunnable != null)
            mainHandler.removeCallbacks(preTransferTimeoutRunnable);
        preTransferTimeoutRunnable = () -> {
            List<PreTransferCommand> commands = getPreTransferCommands();
            log("Pre-Transfer timeout at step " + (preTransferIndex + 1));
            if (preTransferIndex < commands.size() - 1) {
                preTransferIndex++;
                log("Skipping to next step " + (preTransferIndex + 1));
                sendNextPreTransferCommand();
            } else {
                log("Pre-Transfer exhausted, continuing to setup");
                startSetupSequence();
            }
        };
        mainHandler.postDelayed(preTransferTimeoutRunnable, PRE_TRANSFER_TIMEOUT_MS);
    }

    private void scheduleSetupTimeout(String stage) {
        if (setupTimeoutRunnable != null)
            mainHandler.removeCallbacks(setupTimeoutRunnable);
        setupTimeoutRunnable = () -> {
            log("Setup timeout on " + stage + " using " + setupMethod);
            handleSetupTimeout();
        };
        mainHandler.postDelayed(setupTimeoutRunnable, SETUP_TIMEOUT_MS);
    }

    private void handleSetupTimeout() {
        if (setupMethod == SetupMethod.CAPTURED && !setupAttemptedDerived) {
            setupAttemptedCaptured = true;
            setupMethod = SetupMethod.DERIVED;
            log("Switching to DERIVED setup method");
            startSetupSequence();
        } else if (setupMethod == SetupMethod.DERIVED && !setupAttemptedCaptured) {
            setupAttemptedDerived = true;
            setupMethod = SetupMethod.CAPTURED;
            log("Switching to CAPTURED setup method");
            startSetupSequence();
        } else {
            log("Both setup methods failed, attempting direct stream transfer");
            startStreamTransfer();
        }
    }

    // --- Health Data ---

    private void syncHealth() {
        log("=== Syncing Health Data ===");
        int[] keys = { 0x03, 0x04, 0x0D, 0x07, 0x05, 0x0E, 0x09, 0x0B };
        for (int key : keys) {
            byte[] msg = createMessage((byte) 0x05, (byte) key, (byte) 0x10, null);
            enqueueLogicalFrame(msg);
        }
        isSending = true;
        sendNextChunk();
    }

    private void storeHealthValue(String keyName, byte[] payload) {
        if (payload.length < 4)
            return;
        int value = 0;
        long timestamp = System.currentTimeMillis() / 1000;

        // If payload is 8 bytes, usually it's [4-byte timestamp][4-byte value]
        if (payload.length >= 8) {
            timestamp = ByteBuffer.wrap(Arrays.copyOfRange(payload, 0, 4))
                    .order(ByteOrder.LITTLE_ENDIAN)
                    .getInt() & 0xFFFFFFFFL;
            value = ByteBuffer.wrap(Arrays.copyOfRange(payload, 4, 8))
                    .order(ByteOrder.LITTLE_ENDIAN)
                    .getInt();
        } else {
            // fallback: read first 4 bytes as value
            value = ByteBuffer.wrap(Arrays.copyOf(payload, 4))
                    .order(ByteOrder.LITTLE_ENDIAN)
                    .getInt();
        }

        String prefKey = PREF_HEALTH_PREFIX + keyName.replace(" ", "_").toLowerCase(Locale.US);
        String current = prefs.getString(prefKey, "");
        String newValue = timestamp + ":" + value;
        String next = current.isEmpty() ? newValue : current + "," + newValue;
        String[] parts = next.split(",");
        if (parts.length > HEALTH_HISTORY_SIZE) {
            next = String.join(",", Arrays.copyOfRange(parts, parts.length - HEALTH_HISTORY_SIZE, parts.length));
        }
        prefs.edit().putString(prefKey, next).apply();
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes)
            sb.append(String.format("%02X ", b));
        return sb.toString().trim();
    }
}
