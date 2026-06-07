package com.example.dialsender.ble;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * BLE Manager — ported directly from the working omo-version MainActivity.
 * Uses raw processResponse() instead of BleParser to guarantee compatibility.
 * Includes comprehensive BLE protocol logging for debugging and refinement.
 */
public class BleManager {
    private static final String TAG = "BleManager";
    private static BleManager instance;
    private final Context context;

    private BluetoothAdapter bluetoothAdapter;
    private BluetoothGatt bluetoothGatt;
    private BluetoothGattCharacteristic writeChar;

    private static final UUID SERVICE_UUID = UUID.fromString("6e400001-b5a3-f393-e0a9-e50e24dcca9e");
    private static final UUID WRITE_CHAR_UUID = UUID.fromString("6e400002-b5a3-f393-e0a9-e50e24dcca9e");
    private static final UUID NOTIFY_CHAR_UUID = UUID.fromString("6e400003-b5a3-f393-e0a9-e50e24dcca9e");
    private static final UUID CCCD_UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");

    // Protocol State — exactly as in omo version
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
    private final SharedPreferences prefs;
    private static final String PREF_NAME = "dial_sender_prefs";

    private final Handler handler = new Handler(Looper.getMainLooper());

    private BleStateListener listener;
    private boolean isConnected = false;

    private final ConcurrentLinkedQueue<byte[]> commandQueue = new ConcurrentLinkedQueue<>();
    private boolean isSending = false;
    private int currentMtu = 23;
    private int ioBufferSize = 480;
    private int packetsSent = 0;
    private byte[] lastChunkSent = null;
    private int writeRetryCount = 0;
    private static final int MAX_WRITE_RETRIES = 3;
    private static final long WRITE_TIMEOUT_MS = 5000;
    private final Runnable writeWatchdogRunnable = this::handleWriteTimeout;

    // File transfer
    private byte[] fileBytesToSend;
    private long fileTotalSize;
    private boolean isFileTransferActive = false;
    private byte transferKey = 0x01; // default to watchface (0x01)

    // Pre-transfer / Setup
    private int preTransferIndex = 0;
    private int setupStep = 0;
    private Runnable transferTimeoutRunnable;
    private int transferRetryCount = 0;
    private static final int MAX_TRANSFER_RETRIES = 3;
    private static final long TRANSFER_TIMEOUT_MS = 3000;
    private long lastTransferOffset = -1;
    private Runnable preTransferTimeoutRunnable;
    private static final long PRE_TRANSFER_TIMEOUT_MS = 1500;
    private Runnable setupTimeoutRunnable;
    private static final long SETUP_TIMEOUT_MS = 2000;

    // Handshake Magic Bytes — exactly from omo version
    private static final byte[] HANDSHAKE_CMD = new byte[] {
            (byte) 0xAB, 0x01, 0x00, 0x07,
            (byte) 0xB1, (byte) 0xB2, 0x03, 0x02,
            0x20, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF
    };

    // CRC16-Modbus Table — exactly from omo version
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

    // ========== BLE LOG ==========
    private static final List<String> bleLog = new ArrayList<>();
    private static final int MAX_LOG_LINES = 2000;
    private static final SimpleDateFormat LOG_TIME_FMT = new SimpleDateFormat("HH:mm:ss.SSS", Locale.US);

    public interface BleStateListener {
        void onConnectionStateChange(boolean connected, boolean sessionReady);

        void onHealthDataReceived(String keyName, byte[] payload);

        void onHealthSyncComplete();

        void onTransferProgress(int percent, long bytesTransferred, long totalBytes);

        void onTransferComplete();

        void onLogUpdated();

        default void onFindPhoneRequest() {}

        default void onTransferFailed(String reason) {}
    }

    // Health data key codes from protocol doc 03-HEALTH-DATA.md
    public static final int HEALTH_KEY_ACTIVITY = 0x02; // 16 bytes/record
    public static final int HEALTH_KEY_HEART_RATE = 0x03; // 6 bytes/record
    public static final int HEALTH_KEY_BLOOD_PRESSURE = 0x04; // 6 bytes/record
    public static final int HEALTH_KEY_SLEEP = 0x05; // 7 bytes/record
    public static final int HEALTH_KEY_WORKOUT = 0x06; // 48 bytes/record
    public static final int HEALTH_KEY_WORKOUT2 = 0x0E; // 128 bytes/record
    public static final int HEALTH_KEY_TEMPERATURE = 0x08; // 6 bytes/record
    public static final int HEALTH_KEY_BLOOD_OXYGEN = 0x09; // 6 bytes/record
    public static final int HEALTH_KEY_HRV = 0x0A; // 6 bytes/record
    // Corrected against the decompiled BleKey enum (protocols/reference):
    public static final int HEALTH_KEY_PRESSURE = 0x0D; // stress (was wrongly 0x0E)
    public static final int HEALTH_KEY_ECG = 0x20; // ECG (was wrongly 0x0D)
    public static final int HEALTH_KEY_BLOOD_GLUCOSE = 0x10; // blood glucose

    // ========== Constructor ==========

    private BleManager(Context context) {
        this.context = context.getApplicationContext();
        BluetoothManager bm = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
        if (bm != null) {
            bluetoothAdapter = bm.getAdapter();
        }
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static BleManager getInstance(Context context) {
        if (instance == null) {
            instance = new BleManager(context);
        }
        return instance;
    }

    public void setListener(BleStateListener listener) {
        this.listener = listener;
        if (listener != null) {
            listener.onConnectionStateChange(isConnected, connectionState == ConnectionState.SESSION_READY);
        }
    }

    // ========== Logging ==========

    private void log(String msg) {
        String timestamp = LOG_TIME_FMT.format(new Date());
        String line = "[" + timestamp + "] " + msg;
        Log.d(TAG, msg);
        synchronized (bleLog) {
            bleLog.add(line);
            while (bleLog.size() > MAX_LOG_LINES) {
                bleLog.remove(0);
            }
        }
        if (listener != null) {
            handler.post(() -> listener.onLogUpdated());
        }
    }

    public static List<String> getLogLines() {
        synchronized (bleLog) {
            return new ArrayList<>(bleLog);
        }
    }

    public static String getLogText() {
        synchronized (bleLog) {
            StringBuilder sb = new StringBuilder();
            for (String line : bleLog) {
                sb.append(line).append("\n");
            }
            return sb.toString();
        }
    }

    public static void clearLog() {
        synchronized (bleLog) {
            bleLog.clear();
        }
    }

    // ========== Connection ==========

    @SuppressLint("MissingPermission")
    public void connect(BluetoothDevice device) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
            if (context.checkSelfPermission(
                    android.Manifest.permission.BLUETOOTH_CONNECT) != android.content.pm.PackageManager.PERMISSION_GRANTED) {
                log("ERROR: Missing BLUETOOTH_CONNECT permission!");
                return;
            }
        }

        if (bluetoothGatt != null) {
            log("Disconnecting previous GATT connection...");
            bluetoothGatt.disconnect();
            bluetoothGatt.close();
            bluetoothGatt = null;
        }
        isConnected = false;
        connectionState = ConnectionState.DISCONNECTED;
        commandQueue.clear();
        isSending = false;

        String deviceName = device.getName() != null ? device.getName() : device.getAddress();
        log("Connecting to " + deviceName + " (" + device.getAddress() + ")");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            log("Using TRANSPORT_LE");
            bluetoothGatt = device.connectGatt(context, false, gattCallback, BluetoothDevice.TRANSPORT_LE);
        } else {
            bluetoothGatt = device.connectGatt(context, false, gattCallback);
        }
    }

    @SuppressLint("MissingPermission")
    public void disconnect() {
        if (bluetoothGatt != null) {
            log("Disconnecting...");
            bluetoothGatt.disconnect();
        }
    }

    public boolean isSessionReady() {
        return isConnected && connectionState == ConnectionState.SESSION_READY;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public String getLastDeviceAddress() {
        return prefs.getString("last_device_address", null);
    }

    public String getLastDeviceName() {
        return prefs.getString("last_device_name", null);
    }

    @SuppressLint("MissingPermission")
    public void reconnect(String address) {
        if (isConnected || bluetoothGatt != null || address == null || bluetoothAdapter == null)
            return;
        BluetoothDevice device = bluetoothAdapter.getRemoteDevice(address);
        connect(device);
    }

    // ========== GATT Callback — ported from omo version ==========

    private final BluetoothGattCallback gattCallback = new BluetoothGattCallback() {
        @SuppressLint("MissingPermission")
        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            if (newState == BluetoothProfile.STATE_CONNECTED) {
                isConnected = true;
                String connName = gatt.getDevice().getName();
                prefs.edit()
                        .putString("last_device_address", gatt.getDevice().getAddress())
                        .putString("last_device_name",
                                connName != null ? connName : "")
                        .apply();
                log("Connected (status=" + status + "). Discovering services...");
                if (listener != null) {
                    handler.post(() -> listener.onConnectionStateChange(true, false));
                }
                gatt.discoverServices();
            } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                isConnected = false;
                connectionState = ConnectionState.DISCONNECTED;
                log("Disconnected (status=" + status + ") - Resetting state");
                commandQueue.clear();
                isSending = false;
                isFileTransferActive = false;
                if (listener != null) {
                    handler.post(() -> listener.onConnectionStateChange(false, false));
                }
            }
        }

        @SuppressLint("MissingPermission")
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
                        } else {
                            log("ERROR: CCCD descriptor not found!");
                        }
                    } else {
                        log("ERROR: Required characteristics not found");
                        gatt.disconnect();
                    }
                } else {
                    log("ERROR: STF Service UUID not found - device may not be compatible");
                    gatt.disconnect();
                }
            } else {
                log("ERROR: Service discovery failed, status=" + status);
            }
        }

        @SuppressLint("MissingPermission")
        @Override
        public void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                log("Notifications enabled. Requesting MTU...");
                gatt.requestMtu(512);
            } else {
                log("ERROR: Descriptor write failed, status=" + status);
            }
        }

        @Override
        public void onMtuChanged(BluetoothGatt gatt, int mtu, int status) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                currentMtu = mtu - 3;
                ioBufferSize = 2 * currentMtu;
                log("MTU changed to " + mtu + " (payload=" + currentMtu + ", chunkSize=" + ioBufferSize + ")");
                sendHandshake();
            } else {
                log("ERROR: MTU change failed, status=" + status);
            }
        }

        @Override
        public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
            byte[] data = characteristic.getValue();
            if (data != null) {
                log("Rx [" + data.length + "]: " + bytesToHex(data));
                processResponse(data);
            }
        }

        @Override
        public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            handler.removeCallbacks(writeWatchdogRunnable);
            writeRetryCount = 0;
            if (status == BluetoothGatt.GATT_SUCCESS) {
                sendNextChunk();
            } else {
                log("Write failed: status=" + status);
            }
        }
    };

    // ========== Protocol — ported EXACTLY from omo version ==========

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

    /**
     * Called when the watch acknowledges the SESSION CREATE handshake.
     * Marks the session ready and replicates the CO-FIT app's post-connect
     * routine: synchronise the clock and basic device settings, then notify the
     * UI. This mirrors the verified capture, where the phone pushes TIME_ZONE +
     * TIME + HOUR_SYSTEM immediately after the handshake reply.
     */
    private void onSessionReady() {
        connectionState = ConnectionState.SESSION_READY;
        log("=== SESSION READY ===");
        if (listener != null) {
            handler.post(() -> listener.onConnectionStateChange(true, true));
        }
        handler.postDelayed(this::readDeviceInfo, 200);
        handler.postDelayed(this::readFirmwareVersion, 350);
        handler.postDelayed(this::readBattery, 500);
        // Push time + settings shortly after the session is up.
        handler.postDelayed(this::syncTimeAndSettings, 800);
        // Then push weather (network fetch, off the main thread) once things settle.
        handler.postDelayed(() -> WeatherSync.syncIfPossible(context, this), 2500);
    }

    /**
     * Process raw response — ported EXACTLY from omo version's processResponse().
     * NO BleParser intermediary — direct byte inspection.
     */
    private void processResponse(byte[] data) {
        if (data.length == 0 || data[0] != (byte) 0xAB)
            return;

        int header = data[1] & 0xFF;
        boolean isReply = (header & 0x10) != 0;

        if (data.length < 9) {
            log("Short frame (" + data.length + " bytes), ignoring");
            return;
        }
        byte cmd = data[6];
        byte key = data[7];
        byte flag = data[8];

        log("Parse: Hdr=0x" + String.format("%02X", header) + " Cmd=0x" + String.format("%02X", cmd)
                + " Key=0x" + String.format("%02X", key) + " Flag=0x" + String.format("%02X", flag)
                + " Reply=" + isReply + " State=" + connectionState);

        // Handle Identity Info Request from watch -> implies Session Ready.
        // Kept as a fallback for firmware variants that solicit identity before
        // we observe the SESSION CREATE reply.
        if ((header & 0x10) == 0 && header == 0x01 && cmd == 0x03 && key == 0x01) {
            log("Received Identity Request - Sending ACK");
            sendAck(cmd, key, flag);
            if (connectionState != ConnectionState.SESSION_READY) {
                onSessionReady();
            }
            return;
        }

        // Handshake / SESSION CREATE ACK.
        // The real CO-FIT app (verified against full_capture.log) does NOT send a
        // separate bind/login with random ints — it sends the fixed SESSION CREATE
        // (cmd=0x03 key=0x02 flag=0x20, data=FFFFFFFF) and proceeds straight into
        // its config sequence as soon as the watch replies. So the reply to the
        // handshake *is* the session being established.
        if (isReply && connectionState == ConnectionState.HANDSHAKE_SENT
                && cmd == 0x03 && key == 0x02) {
            log("SESSION CREATE OK");
            onSessionReady();
            return;
        }

        // Watch requests time sync
        if (cmd == 0x02 && key == 0x01 && connectionState == ConnectionState.SESSION_READY
                && !isFileTransferActive) {
            log("Watch requested time sync — sending time");
            syncTime();
            return;
        }

        // Device Info response (Cmd=0x02, Key=0x3E)
        if (isReply && cmd == 0x02 && (key & 0xFF) == 0x3E) {
            log("Device Info received (ioBufferSize via MTU=" + ioBufferSize + ")");
            return;
        }

        // Battery response (Cmd=0x02, Key=0x03)
        if (isReply && cmd == 0x02 && key == 0x03) {
            int battery = (data.length > 9) ? (data[9] & 0xFF) : 0;
            log("Battery Level: " + battery + "%");
            prefs.edit().putInt("battery_level", battery).apply();
            return;
        }

        // Firmware Version response (Cmd=0x02, Key=0x04)
        if (isReply && cmd == 0x02 && key == 0x04) {
            String version = (data.length > 9) ? new String(Arrays.copyOfRange(data, 9, data.length)).trim() : "";
            log("Firmware Version: " + version);
            prefs.edit().putString("firmware_version", "v" + version).apply();
            if (listener != null) {
                handler.post(() -> listener.onConnectionStateChange(true, true));
            }
            return;
        }

        // Watchface ID ACK
        if (isReply && cmd == 0x02 && key == 0x27 && connectionState == ConnectionState.WATCHFACE_ID_SENT) {
            log("Watchface ID ACK");
            handler.postDelayed(this::startPreTransferSequence, 50);
            return;
        }

        // Pre-Transfer ACK
        if (isReply && connectionState == ConnectionState.PRE_TRANSFER) {
            if (preTransferTimeoutRunnable != null)
                handler.removeCallbacks(preTransferTimeoutRunnable);
            log("Pre-Transfer ACK");
            preTransferIndex++;
            handler.postDelayed(this::sendNextPreTransferCommand, 50);
            return;
        }

        // Setup1 ACK
        if (isReply && cmd == 0x02 && key == 0x20 && connectionState == ConnectionState.SETUP1_SENT) {
            if (setupTimeoutRunnable != null)
                handler.removeCallbacks(setupTimeoutRunnable);
            log("Setup1 ACK");
            setupStep = 2;
            handler.postDelayed(this::sendSetupStep2, 50);
            return;
        }

        // Setup2 ACK
        if (isReply && cmd == 0x04 && key == 0x0C && connectionState == ConnectionState.SETUP2_SENT) {
            if (setupTimeoutRunnable != null)
                handler.removeCallbacks(setupTimeoutRunnable);
            log("Setup2 ACK");
            handler.postDelayed(this::startStreamTransfer, 50);
            return;
        }

        // Progress / Completion
        if (cmd == 0x07 && (key == 0x01 || key == 0x02) && data.length >= 18) {
            if (transferTimeoutRunnable != null)
                handler.removeCallbacks(transferTimeoutRunnable);
            transferRetryCount = 0;
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

            if (listener != null) {
                handler.post(() -> listener.onTransferProgress(percent, completed, total));
            }

            if (transferStatus == 0) {
                if (isFileTransferActive && completed < total) {
                    // Guard: only send next chunk if the offset actually advanced.
                    // This prevents an infinite loop when the watch echoes back
                    // completed=0 (or a stale offset) before the transfer truly begins.
                    if (completed > lastTransferOffset || lastTransferOffset < 0) {
                        lastTransferOffset = completed;
                        sendStreamChunk(completed);
                    } else {
                        log("Progress stalled at " + completed + " (lastOffset=" + lastTransferOffset
                                + ") — waiting for watch to advance");
                    }
                } else if (isFileTransferActive && completed >= total) {
                    log("=== Transfer Complete! ===");
                    isFileTransferActive = false;
                    connectionState = ConnectionState.SESSION_READY;
                    commandQueue.clear();
                    isSending = false;
                    packetsSent = 0;
                    lastTransferOffset = -1;
                    if (listener != null) {
                        handler.post(() -> listener.onTransferComplete());
                    }
                }
            }
            return;
        }

        // Health data responses (Cmd=0x05) — parse per protocol doc 03-HEALTH-DATA.md
        if (cmd == 0x05) {
            byte[] healthPayload = (data.length > 9) ? Arrays.copyOfRange(data, 9, data.length) : new byte[0];
            String keyName = getHealthKeyName(key & 0xFF);
            log("Health [" + keyName + "] payload=" + healthPayload.length + "B: " + bytesToHex(healthPayload));

            // Parse health records and store to SharedPreferences
            parseAndStoreHealthData(key & 0xFF, healthPayload);

            if (listener != null) {
                handler.post(() -> listener.onHealthDataReceived(keyName, healthPayload));
            }

            // ACK unsolicited pushes (watch -> phone) before driving the sync state
            // machine, otherwise advance the sequential paging.
            if (!isReply) {
                sendAck(cmd, key, flag);
            } else {
                onHealthPage(key & 0xFF, healthPayload.length);
            }
            return;
        }

        // Find phone (SET FIND_PHONE 0x0213, watch -> phone): the watch asks the
        // phone to ring. The phone keeps ringing until the user stops it (or the
        // watch sends a stop, payload[0]==0). Verified against the original app's
        // BleHandleCallback.onFindPhone(boolean).
        if (cmd == 0x02 && key == 0x13 && !isReply) {
            boolean start = (data.length <= 9) || (data[9] != 0);
            log("Find phone: start=" + start);
            sendAck(cmd, key, flag);
            if (start)
                startFindPhoneAlert();
            else
                stopFindPhoneAlert();
            return;
        }

        // Camera shutter pushed from the watch (CONTROL 0x0601, watch -> phone)
        if (cmd == 0x06 && key == 0x01 && !isReply) {
            log("Camera shutter from watch");
            sendAck(cmd, key, flag);
            if (cameraListener != null) {
                handler.post(() -> cameraListener.onShutter());
            }
            return;
        }

        // Unknown response
        log("Unhandled response: Cmd=0x" + String.format("%02X", cmd) + " Key=0x" + String.format("%02X", key));
    }

    // ========== File Transfer — ported from omo version ==========

    public void startFileTransfer(byte[] fileData) {
        startFileTransfer(fileData, (byte) 0x01);
    }

    public void startFileTransfer(byte[] fileData, byte key) {
        if (connectionState != ConnectionState.SESSION_READY) {
            log("Session not ready! Current state: " + connectionState);
            return;
        }
        if (fileData == null || fileData.length == 0) {
            log("No file data to send");
            return;
        }

        this.fileBytesToSend = fileData;
        this.fileTotalSize = fileData.length;
        this.transferKey = key;
        commandQueue.clear();
        isSending = false;
        packetsSent = 0;
        preTransferIndex = 0;
        setupStep = 0;
        isFileTransferActive = true;
        lastTransferOffset = -1;

        log("Starting file transfer (" + fileTotalSize + " bytes) for key 0x" + String.format("%02X", key));
        if (key == 0x02) {
            // AGPS: start streaming directly!
            startStreamTransfer();
        } else {
            // Watchface: do the full setup sequence
            startPreTransferSequence();
        }
    }

    public void cancelTransfer() {
        log("Transfer cancelled");
        isFileTransferActive = false;
        commandQueue.clear();
        isSending = false;
        connectionState = ConnectionState.SESSION_READY;
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
        log("Pre-Transfer step " + (preTransferIndex + 1) + "/" + cmds.size() + ": " + bytesToHex(msg));
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

        byte[] message = createMessage((byte) 0x07, transferKey, (byte) 0x00, bb.array());
        enqueueLogicalFrame(message);
        isSending = true;
        sendNextChunk();
        scheduleTransferTimeout(offset);
    }

    // ========== Health Sync ==========

    public static final int HEALTH_KEY_LOCATION = 0x07; // GPS location coordinate records

    /**
     * Request all health data from the watch.
     * Sends READ (0x10) requests for each health data BleKey in the 0x05xx range.
     * Per protocol doc 03-HEALTH-DATA.md, the watch responds with packed binary
     * records.
     */
    // Keys queried during a full health sync, in order.
    private static final int[] HEALTH_SYNC_KEYS = {
            HEALTH_KEY_ACTIVITY, // 0x02 - Steps/Calories/Distance
            HEALTH_KEY_HEART_RATE, // 0x03 - Heart rate BPM
            HEALTH_KEY_BLOOD_PRESSURE, // 0x04 - Systolic/Diastolic
            HEALTH_KEY_SLEEP, // 0x05 - Sleep stages
            HEALTH_KEY_WORKOUT, // 0x06 - Workout session data
            HEALTH_KEY_WORKOUT2, // 0x0E - Rich workout session data
            HEALTH_KEY_LOCATION, // 0x07 - GPS coordinate records
            HEALTH_KEY_TEMPERATURE, // 0x08 - Body temperature
            HEALTH_KEY_BLOOD_OXYGEN, // 0x09 - SpO2
            HEALTH_KEY_HRV, // 0x0A - Heart rate variability
            HEALTH_KEY_PRESSURE, // 0x0D - Stress level
    };
    private int healthKeyIndex = -1;
    private int healthPageCount = 0;
    private static final int MAX_HEALTH_PAGES = 64; // safety cap against infinite paging

    /**
     * Request all health data from the watch, one key at a time.
     * For each key we send a READ; the watch replies with a page of packed
     * records. While the page is non-empty we keep paging with READ_CONTINUE;
     * an empty page means that key is exhausted and we advance to the next.
     */
    public void syncHealth() {
        if (connectionState != ConnectionState.SESSION_READY) {
            log("Cannot sync health: session not ready (state=" + connectionState + ")");
            return;
        }
        log("=== Syncing Health Data ===");
        healthKeyIndex = 0;
        healthPageCount = 0;
        requestHealthKey(HEALTH_SYNC_KEYS[0], BleKeyFlag.READ.getValue());
    }

    private void requestHealthKey(int key, int flag) {
        // Verified against the live CO-FIT capture: data reads carry NO payload
        // (the request is just CMD=05, KEY, FLAG=READ with an empty body). An
        // empty reply from the watch means "no more records" for that key.
        byte[] msg = createMessage((byte) 0x05, (byte) key, (byte) flag, null);
        log("Health READ key=0x" + String.format("%02X", key) + " flag=0x" + String.format("%02X", flag));
        enqueueLogicalFrame(msg);
        isSending = true;
        sendNextChunk();
    }

    /** Advance the sequential health sync after a key's page was processed. */
    private void onHealthPage(int key, int payloadLen) {
        if (healthKeyIndex < 0)
            return; // not in a sync session (e.g. unsolicited push)
        boolean more = payloadLen > 0 && healthPageCount < MAX_HEALTH_PAGES;
        if (more) {
            healthPageCount++;
            requestHealthKey(key, BleKeyFlag.READ_CONTINUE.getValue());
            return;
        }
        // This key is done — move to the next one.
        healthKeyIndex++;
        healthPageCount = 0;
        if (healthKeyIndex < HEALTH_SYNC_KEYS.length) {
            requestHealthKey(HEALTH_SYNC_KEYS[healthKeyIndex], BleKeyFlag.READ.getValue());
        } else {
            healthKeyIndex = -1;
            log("=== Health Sync Complete ===");
            prefs.edit().putLong("last_sync_time", System.currentTimeMillis() / 1000L).apply();
            if (listener != null) {
                handler.post(() -> listener.onHealthSyncComplete());
            }
        }
    }

    private String getHealthKeyName(int key) {
        switch (key) {
            case HEALTH_KEY_ACTIVITY:
                return "activity";
            case HEALTH_KEY_HEART_RATE:
                return "heart_rate";
            case HEALTH_KEY_BLOOD_PRESSURE:
                return "blood_pressure";
            case HEALTH_KEY_SLEEP:
                return "sleep";
            case HEALTH_KEY_WORKOUT:
                return "workout";
            case HEALTH_KEY_WORKOUT2:
                return "workout2";
            case HEALTH_KEY_LOCATION:
                return "location";
            case HEALTH_KEY_TEMPERATURE:
                return "temperature";
            case HEALTH_KEY_BLOOD_OXYGEN:
                return "blood_oxygen";
            case HEALTH_KEY_HRV:
                return "hrv";
            case HEALTH_KEY_ECG:
                return "ecg";
            case HEALTH_KEY_PRESSURE:
                return "stress";
            case HEALTH_KEY_BLOOD_GLUCOSE:
                return "blood_glucose";
            default:
                return "unknown_" + String.format("%02X", key);
        }
    }

    /**
     * Parse binary health records per protocol doc 03-HEALTH-DATA.md and store to
     * SharedPreferences.
     * Each entity type has a fixed ITEM_LENGTH. Records are big-endian packed.
     */
    private void parseAndStoreHealthData(int key, byte[] payload) {
        if (payload == null || payload.length == 0) {
            log("Health [" + getHealthKeyName(key) + "]: empty payload");
            return;
        }

        SharedPreferences.Editor editor = prefs.edit();
        String prefix = "health_";

        try {
            ByteBuffer bb = ByteBuffer.wrap(payload);
            bb.order(ByteOrder.BIG_ENDIAN);

            switch (key) {
                case HEALTH_KEY_ACTIVITY: {
                    // ITEM_LENGTH=16: time(4) packed(1) step(3) calorie(4) distance(4)
                    int itemLen = 16;
                    StringBuilder steps = new StringBuilder(prefs.getString(prefix + "steps", ""));
                    StringBuilder calories = new StringBuilder(prefs.getString(prefix + "calories", ""));
                    StringBuilder distance = new StringBuilder(prefs.getString(prefix + "distance", ""));
                    while (bb.remaining() >= itemLen) {
                        int time = bb.getInt() + 946684800; // Watch uses 2000-01-01 epoch
                        int packed = bb.get() & 0xFF;
                        int b0 = bb.get() & 0xFF;
                        int b1 = bb.get() & 0xFF;
                        int b2 = bb.get() & 0xFF;
                        int step = (b0 << 16) | (b1 << 8) | b2;
                        int calorie = bb.getInt() / 10000;
                        int dist = bb.getInt() / 10000;
                        if (steps.length() > 0)
                            steps.append(",");
                        steps.append(time).append(":").append(step);
                        if (calories.length() > 0)
                            calories.append(",");
                        calories.append(time).append(":").append(calorie);
                        if (distance.length() > 0)
                            distance.append(",");
                        distance.append(time).append(":").append(dist);
                        log("  Activity: t=" + time + " steps=" + step + " cal=" + calorie + " dist=" + dist);
                    }
                    editor.putString(prefix + "steps", steps.toString());
                    editor.putString(prefix + "calories", calories.toString());
                    editor.putString(prefix + "distance", distance.toString());
                    break;
                }
                case HEALTH_KEY_HEART_RATE: {
                    // ITEM_LENGTH=6: time(4) bpm(1) type(1)
                    int itemLen = 6;
                    StringBuilder sb = new StringBuilder(prefs.getString(prefix + "heart_rate", ""));
                    while (bb.remaining() >= itemLen) {
                        int time = bb.getInt() + 946684800; // Watch uses 2000-01-01 epoch
                        int bpm = bb.get() & 0xFF;
                        int type = bb.get() & 0xFF;
                        if (sb.length() > 0)
                            sb.append(",");
                        sb.append(time).append(":").append(bpm);
                        log("  HeartRate: t=" + time + " bpm=" + bpm + " type=" + type);
                    }
                    editor.putString(prefix + "heart_rate", sb.toString());
                    break;
                }
                case HEALTH_KEY_BLOOD_PRESSURE: {
                    // ITEM_LENGTH=6: time(4) systolic(1) diastolic(1)
                    int itemLen = 6;
                    StringBuilder sb = new StringBuilder();
                    while (bb.remaining() >= itemLen) {
                        int time = bb.getInt() + 946684800; // Watch uses 2000-01-01 epoch
                        int sys = bb.get() & 0xFF;
                        int dia = bb.get() & 0xFF;
                        if (sb.length() > 0)
                            sb.append(",");
                        sb.append(time).append(":").append(sys).append("/").append(dia);
                        log("  BP: t=" + time + " sys=" + sys + " dia=" + dia);
                    }
                    editor.putString(prefix + "blood_pressure", sb.toString());
                    break;
                }
                case HEALTH_KEY_SLEEP: {
                    // ITEM_LENGTH=7: time(4) mode(1) soft(1) strong(1)
                    int itemLen = 7;
                    StringBuilder sb = new StringBuilder(prefs.getString(prefix + "sleep", ""));
                    while (bb.remaining() >= itemLen) {
                        int time = bb.getInt() + 946684800; // Watch uses 2000-01-01 epoch
                        int mode = bb.get() & 0xFF;
                        int soft = bb.get() & 0xFF;
                        int strong = bb.get() & 0xFF;
                        if (sb.length() > 0)
                            sb.append(",");
                        sb.append(time).append(":").append(mode).append(":").append(soft).append(":").append(strong);
                        log("  Sleep: t=" + time + " mode=" + mode + " light=" + soft + " deep=" + strong);
                    }
                    editor.putString(prefix + "sleep", sb.toString());
                    break;
                }
                case HEALTH_KEY_TEMPERATURE: {
                    // ITEM_LENGTH=6: time(4) temperature(2) — value *10
                    int itemLen = 6;
                    StringBuilder sb = new StringBuilder();
                    while (bb.remaining() >= itemLen) {
                        int time = bb.getInt() + 946684800; // Watch uses 2000-01-01 epoch
                        int temp = bb.getShort();
                        if (sb.length() > 0)
                            sb.append(",");
                        sb.append(time).append(":").append(temp);
                        log("  Temp: t=" + time + " temp=" + (temp / 10.0) + "°C");
                    }
                    editor.putString(prefix + "temperature", sb.toString());
                    break;
                }
                case HEALTH_KEY_BLOOD_OXYGEN: {
                    // ITEM_LENGTH=6: time(4) value(1) padding(1)
                    int itemLen = 6;
                    StringBuilder sb = new StringBuilder(prefs.getString(prefix + "blood_oxygen", ""));
                    while (bb.remaining() >= itemLen) {
                        int time = bb.getInt() + 946684800; // Watch uses 2000-01-01 epoch
                        int spo2 = bb.get() & 0xFF;
                        bb.get(); // padding
                        if (sb.length() > 0)
                            sb.append(",");
                        sb.append(time).append(":").append(spo2);
                        log("  SpO2: t=" + time + " value=" + spo2 + "%");
                    }
                    editor.putString(prefix + "blood_oxygen", sb.toString());
                    break;
                }
                case HEALTH_KEY_HRV: {
                    // ITEM_LENGTH=6: time(4) value(1) avg(1)
                    int itemLen = 6;
                    StringBuilder sb = new StringBuilder(prefs.getString(prefix + "hrv", ""));
                    while (bb.remaining() >= itemLen) {
                        int time = bb.getInt() + 946684800;
                        int val = bb.get(); // signed
                        bb.get(); // avg
                        if (sb.length() > 0)
                            sb.append(",");
                        sb.append(time).append(":").append(val);
                    }
                    editor.putString(prefix + "hrv", sb.toString());
                    break;
                }
                case HEALTH_KEY_PRESSURE: {
                    // ITEM_LENGTH=6: time(4) value(1) padding(1) — stress 0..100
                    int itemLen = 6;
                    StringBuilder sb = new StringBuilder(prefs.getString(prefix + "stress", ""));
                    while (bb.remaining() >= itemLen) {
                        int time = bb.getInt() + 946684800;
                        int val = bb.get() & 0xFF;
                        bb.get(); // padding
                        if (sb.length() > 0)
                            sb.append(",");
                        sb.append(time).append(":").append(val);
                    }
                    editor.putString(prefix + "stress", sb.toString());
                    break;
                }
                case HEALTH_KEY_WORKOUT: {
                    // ITEM_LENGTH=48: start(4) end(4) duration(2) altitude(2) airPressure(2) spm(1) mode(1) step(4) distance(4) calorie(4) speed(4) pace(4) avgBpm(1) maxBpm(1) padding(10)
                    int itemLen = 48;
                    StringBuilder sb = new StringBuilder(prefs.getString(prefix + "workout", ""));
                    while (bb.remaining() >= itemLen) {
                        int start = bb.getInt() + 946684800;
                        int end = bb.getInt() + 946684800;
                        int duration = bb.getShort() & 0xFFFF;
                        int altitude = bb.getShort();
                        int airPressure = bb.getShort() & 0xFFFF;
                        int spm = bb.get() & 0xFF;
                        int mode = bb.get() & 0xFF;
                        int step = bb.getInt();
                        int distance = bb.getInt();
                        int calorie = bb.getInt();
                        int speed = bb.getInt();
                        int pace = bb.getInt();
                        int avgBpm = bb.get() & 0xFF;
                        int maxBpm = bb.get() & 0xFF;
                        // Skip remaining 10 bytes padding
                        for (int i = 0; i < 10; i++) {
                            bb.get();
                        }
                        if (sb.length() > 0)
                            sb.append(",");
                        sb.append(start).append(":")
                          .append(end).append(":")
                          .append(duration).append(":")
                          .append(altitude).append(":")
                          .append(airPressure).append(":")
                          .append(spm).append(":")
                          .append(mode).append(":")
                          .append(step).append(":")
                          .append(distance).append(":")
                          .append(calorie).append(":")
                          .append(speed).append(":")
                          .append(pace).append(":")
                          .append(avgBpm).append(":")
                          .append(maxBpm);
                        log("  Workout: start=" + start + " end=" + end + " mode=" + mode + " steps=" + step + " dist=" + distance + " kcal=" + calorie);

                        // Merge into standard "sport_sessions" for history compatibility
                        String allSessions = prefs.getString("sport_sessions", "");
                        boolean exists = false;
                        if (!allSessions.isEmpty()) {
                            for (String s : allSessions.split(",")) {
                                if (s.startsWith(start + "|")) {
                                    exists = true;
                                    break;
                                }
                            }
                        }
                        if (!exists) {
                            String rec = start + "|" + getSportName(mode) + "|" + duration + "|" + calorie;
                            editor.putString("sport_sessions", allSessions.isEmpty() ? rec : rec + "," + allSessions);
                        }
                    }
                    editor.putString(prefix + "workout", sb.toString());
                    break;
                }
                case HEALTH_KEY_WORKOUT2: {
                    // ITEM_LENGTH=128: start(4) end(4) duration(2) altitude(2) airPressure(2) spm(1) mode(1) step(4) distance(4) calorie(4) speed(4) pace(4) avgBpm(1) maxBpm(1) minBpm(1) undefined(1) maxSpm(2) minSpm(2) maxPace(4) minPace(4) maxAltitude(2) minAltitude(2) minStress(1) maxStress(1) avgStress(1) maxSpeed(4) minSpeed(4) restDuration(4) padding(59)
                    int itemLen = 128;
                    StringBuilder sb = new StringBuilder(prefs.getString(prefix + "workout", ""));
                    while (bb.remaining() >= itemLen) {
                        int start = bb.getInt() + 946684800;
                        int end = bb.getInt() + 946684800;
                        int duration = bb.getShort() & 0xFFFF;
                        int altitude = bb.getShort();
                        int airPressure = bb.getShort() & 0xFFFF;
                        int spm = bb.get() & 0xFF;
                        int mode = bb.get() & 0xFF;
                        int step = bb.getInt();
                        int distance = bb.getInt();
                        int calorie = bb.getInt();
                        int speed = bb.getInt();
                        int pace = bb.getInt();
                        int avgBpm = bb.get() & 0xFF;
                        int maxBpm = bb.get() & 0xFF;
                        // Skip remaining 90 bytes of the 128-byte item
                        for (int i = 0; i < 90; i++) {
                            bb.get();
                        }
                        if (sb.length() > 0)
                            sb.append(",");
                        sb.append(start).append(":")
                          .append(end).append(":")
                          .append(duration).append(":")
                          .append(altitude).append(":")
                          .append(airPressure).append(":")
                          .append(spm).append(":")
                          .append(mode).append(":")
                          .append(step).append(":")
                          .append(distance).append(":")
                          .append(calorie).append(":")
                          .append(speed).append(":")
                          .append(pace).append(":")
                          .append(avgBpm).append(":")
                          .append(maxBpm);
                        log("  Workout2: start=" + start + " end=" + end + " mode=" + mode + " steps=" + step + " dist=" + distance + " kcal=" + calorie);

                        // Merge into standard "sport_sessions" for history compatibility
                        String allSessions = prefs.getString("sport_sessions", "");
                        boolean exists = false;
                        if (!allSessions.isEmpty()) {
                            for (String s : allSessions.split(",")) {
                                if (s.startsWith(start + "|")) {
                                    exists = true;
                                    break;
                                }
                            }
                        }
                        if (!exists) {
                            String rec = start + "|" + getSportName(mode) + "|" + duration + "|" + calorie;
                            editor.putString("sport_sessions", allSessions.isEmpty() ? rec : rec + "," + allSessions);
                        }
                    }
                    editor.putString(prefix + "workout", sb.toString());
                    break;
                }
                case HEALTH_KEY_LOCATION: {
                    // ITEM_LENGTH=16: time(4) mode(1) padding(1) altitude(2) longitude(4) latitude(4)
                    int itemLen = 16;
                    StringBuilder sb = new StringBuilder(prefs.getString(prefix + "location", ""));
                    while (bb.remaining() >= itemLen) {
                        int time = bb.getInt() + 946684800; // Watch uses 2000-01-01 epoch
                        int mode = bb.get() & 0xFF;
                        bb.get(); // padding (1 byte)
                        int altitude = bb.getShort();
                        float longitude = bb.getFloat();
                        float latitude = bb.getFloat();
                        if (sb.length() > 0)
                            sb.append(",");
                        sb.append(time).append(":").append(mode).append(":").append(altitude).append(":").append(longitude).append(":").append(latitude);
                        log("  Location: t=" + time + " mode=" + mode + " alt=" + altitude + " lon=" + longitude + " lat=" + latitude);
                    }
                    editor.putString(prefix + "location", sb.toString());
                    break;
                }
                default:
                    log("  Unhandled health key 0x" + String.format("%02X", key) + " (" + payload.length + " bytes)");
                    break;
            }
            editor.apply();
        } catch (Exception e) {
            log("Health parse error: " + e.getMessage());
        }
    }

    private String getSportName(int mode) {
        String[] sports = {
            "Caminar", "Correr", "Ciclismo", "Senderismo", "Cinta", "Yoga",
            "Saltar la cuerda", "Baloncesto", "Fútbol", "Natación", "Remo", "Escalada"
        };
        if (mode >= 1 && mode <= sports.length) {
            return sports[mode - 1];
        }
        return "Deporte " + mode;
    }

    // ========== Helpers — ported from omo version ==========

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
        log("Tx ACK: " + bytesToHex(msg));
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

    @SuppressLint("MissingPermission")
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
            // Start watchdog
            handler.removeCallbacks(writeWatchdogRunnable);
            handler.postDelayed(writeWatchdogRunnable, WRITE_TIMEOUT_MS);
        }
    }

    @SuppressLint("MissingPermission")
    private void handleWriteTimeout() {
        if (!isSending && commandQueue.isEmpty())
            return;
        writeRetryCount++;
        if (writeRetryCount > MAX_WRITE_RETRIES) {
            log("Write watchdog: max retries exceeded, aborting");
            isFileTransferActive = false;
            commandQueue.clear();
            isSending = false;
            connectionState = ConnectionState.SESSION_READY;
            return;
        }
        log("Write watchdog: retrying chunk (attempt " + writeRetryCount + ")");
        if (lastChunkSent != null && writeChar != null && bluetoothGatt != null) {
            writeChar.setValue(lastChunkSent);
            writeChar.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
            bluetoothGatt.writeCharacteristic(writeChar);
            handler.postDelayed(writeWatchdogRunnable, WRITE_TIMEOUT_MS);
        }
    }

    // ========== Timeout / Retry — ported from omo version ==========

    private void scheduleTransferTimeout(long offset) {
        if (transferTimeoutRunnable != null)
            handler.removeCallbacks(transferTimeoutRunnable);
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
                    if (listener != null)
                        handler.post(() -> listener.onTransferFailed("Transfer stalled after " + MAX_TRANSFER_RETRIES + " retries"));
                }
            }
        };
        handler.postDelayed(transferTimeoutRunnable, TRANSFER_TIMEOUT_MS);
    }

    private void schedulePreTransferTimeout() {
        if (preTransferTimeoutRunnable != null)
            handler.removeCallbacks(preTransferTimeoutRunnable);
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
        handler.postDelayed(preTransferTimeoutRunnable, PRE_TRANSFER_TIMEOUT_MS);
    }

    private void scheduleSetupTimeout(String stage) {
        if (setupTimeoutRunnable != null)
            handler.removeCallbacks(setupTimeoutRunnable);
        setupTimeoutRunnable = () -> {
            log("Setup timeout on " + stage);
            handleSetupTimeout();
        };
        handler.postDelayed(setupTimeoutRunnable, SETUP_TIMEOUT_MS);
    }

    private void handleSetupTimeout() {
        log("Setup failed, attempting direct stream transfer");
        startStreamTransfer();
    }

    // ========== Time / Date / Settings Sync ==========

    public void syncTime() {
        if (!isSessionReady()) return;
        java.util.Calendar cal = java.util.Calendar.getInstance();
        byte[] timePayload = new byte[] {
            (byte) (cal.get(java.util.Calendar.YEAR) - 2000),
            (byte) (cal.get(java.util.Calendar.MONTH) + 1),
            (byte)  cal.get(java.util.Calendar.DAY_OF_MONTH),
            (byte)  cal.get(java.util.Calendar.HOUR_OF_DAY),
            (byte)  cal.get(java.util.Calendar.MINUTE),
            (byte)  cal.get(java.util.Calendar.SECOND)
        };
        log("Syncing time: " + cal.getTime());
        byte[] timeMsg = createMessage((byte) 0x02, (byte) 0x01, (byte) 0x00, timePayload);
        enqueueLogicalFrame(timeMsg);
        isSending = true;
        sendNextChunk();
    }

    public void readBattery() {
        if (!isSessionReady()) return;
        log("Reading battery level...");
        byte[] msg = createMessage((byte) 0x02, (byte) 0x03, (byte) 0x10, null);
        enqueueLogicalFrame(msg);
        isSending = true;
        sendNextChunk();
    }

    public void readDeviceInfo() {
        if (!isSessionReady()) return;
        log("Reading device info (0x023E)...");
        byte[] msg = createMessage((byte) 0x02, (byte) 0x3E, (byte) 0x10, null);
        enqueueLogicalFrame(msg);
        isSending = true;
        sendNextChunk();
    }

    public void readFirmwareVersion() {
        if (!isSessionReady()) return;
        log("Reading firmware version (0x0204)...");
        byte[] msg = createMessage((byte) 0x02, (byte) 0x04, (byte) 0x10, null);
        enqueueLogicalFrame(msg);
        isSending = true;
        sendNextChunk();
    }

    /**
     * Push current time + basic clock settings to the watch.
     * Order mirrors the verified CO-FIT capture: TIME_ZONE, TIME, HOUR_SYSTEM.
     */
    public void syncTimeAndSettings() {
        if (!isSessionReady()) {
            log("syncTimeAndSettings: session not ready");
            return;
        }
        log("=== Syncing time & settings ===");
        sendTimeZone();
        sendTime();
        sendHourSystem();
        isSending = true;
        sendNextChunk();
    }

    /**
     * SET TIME (BleKey 0x0201, UPDATE).
     *
     * IMPORTANT: the device clock is NOT a 4-byte Unix timestamp (as previously
     * documented). The verified capture shows a 6-byte calendar structure:
     *     [year-2000, month(1-12), day, hour(0-23), minute, second]
     * e.g. 1A 02 05 08 31 0B == 2026-02-05 08:49:11.
     */
    public void sendTime() {
        Calendar c = Calendar.getInstance();
        byte[] payload = new byte[] {
                (byte) (c.get(Calendar.YEAR) - 2000),
                (byte) (c.get(Calendar.MONTH) + 1), // Calendar.MONTH is 0-based
                (byte) c.get(Calendar.DAY_OF_MONTH),
                (byte) c.get(Calendar.HOUR_OF_DAY),
                (byte) c.get(Calendar.MINUTE),
                (byte) c.get(Calendar.SECOND)
        };
        byte[] msg = createMessage((byte) 0x02, (byte) 0x01, (byte) 0x00, payload);
        log("Tx TIME: " + bytesToHex(payload));
        enqueueLogicalFrame(msg);
    }

    /**
     * SET TIME_ZONE (BleKey 0x0202, UPDATE) — single signed byte.
     * Verified against the original app's BleTimeZone entity: the value is the
     * UTC offset expressed in 15-minute units, i.e. offsetMillis/1000/60/15.
     * (e.g. UTC+2 -> 8, UTC-6 -> -24.)
     */
    public void sendTimeZone() {
        int offsetMs = TimeZone.getDefault().getOffset(System.currentTimeMillis());
        int quarters = offsetMs / 1000 / 60 / 15;
        byte[] payload = new byte[] { (byte) quarters };
        byte[] msg = createMessage((byte) 0x02, (byte) 0x02, (byte) 0x00, payload);
        log("Tx TIME_ZONE: " + bytesToHex(payload) + " (" + quarters + " x15min)");
        enqueueLogicalFrame(msg);
    }

    /**
     * SET HOUR_SYSTEM (BleKey 0x020E, UPDATE) — 0x00 = 12h, 0x01 = 24h.
     * Defaults to the phone's locale setting.
     */
    public void sendHourSystem() {
        boolean is24 = android.text.format.DateFormat.is24HourFormat(context);
        byte[] payload = new byte[] { (byte) (is24 ? 0x01 : 0x00) };
        byte[] msg = createMessage((byte) 0x02, (byte) 0x0E, (byte) 0x00, payload);
        log("Tx HOUR_SYSTEM: " + bytesToHex(payload));
        enqueueLogicalFrame(msg);
    }

    // ========== Weather Push ==========
    //
    // Byte layout verified against the original app's decompiled entities
    // (com.szabh.smable3.entity.BleWeather / BleWeatherRealtime / BleWeatherForecast):
    //
    //   BleWeather (10 bytes): currentTemp(i8) maxTemp(i8) minTemp(i8) code(i8)
    //                          windSpeed(i8) humidity(i8) visibility(i8)
    //                          uvIndex(i8) precipitation(i16 LITTLE-ENDIAN)
    //   WEATHER_REALTIME (0x0404, UPDATE): BleTime(6) + BleWeather          = 16 B
    //   WEATHER_FORECAST (0x0405, UPDATE): BleTime(6) + 3 x BleWeather      = 36 B
    //
    // Weather codes: 0=other 1=sunny 2=cloudy 3=overcast 4=rainy 5=thunder
    //   6=thundershower 7=high-wind 8=snowy 9=foggy 10=sandstorm 11=haze.

    public static final int WEATHER_OTHER = 0, WEATHER_SUNNY = 1, WEATHER_CLOUDY = 2,
            WEATHER_OVERCAST = 3, WEATHER_RAINY = 4, WEATHER_THUNDER = 5,
            WEATHER_THUNDERSHOWER = 6, WEATHER_HIGH_WIND = 7, WEATHER_SNOWY = 8,
            WEATHER_FOGGY = 9, WEATHER_SANDSTORM = 10, WEATHER_HAZE = 11;

    /** One BleWeather record (10 bytes once encoded). All temps in °C. */
    public static class WeatherDay {
        public int conditionCode; // 0..11 (see WEATHER_* constants)
        public int tempCurrent;
        public int tempLow;
        public int tempHigh;
        public int windSpeed;     // km/h
        public int humidity;      // %
        public int visibility;    // km
        public int uvIndex;
        public int precipitation; // % (0..100), encoded as int16 LE

        public WeatherDay(int conditionCode, int tempCurrent, int tempLow, int tempHigh) {
            this(conditionCode, tempCurrent, tempLow, tempHigh, 0, 0, 0, 0, 0);
        }

        public WeatherDay(int conditionCode, int tempCurrent, int tempLow, int tempHigh,
                int windSpeed, int humidity, int visibility, int uvIndex, int precipitation) {
            this.conditionCode = conditionCode;
            this.tempCurrent = tempCurrent;
            this.tempLow = tempLow;
            this.tempHigh = tempHigh;
            this.windSpeed = windSpeed;
            this.humidity = humidity;
            this.visibility = visibility;
            this.uvIndex = uvIndex;
            this.precipitation = precipitation;
        }
    }

    /** Appends a 10-byte BleWeather record. precipitation is int16 little-endian. */
    private void putBleWeather(ByteBuffer buf, WeatherDay d) {
        buf.put((byte) d.tempCurrent);
        buf.put((byte) d.tempHigh);
        buf.put((byte) d.tempLow);
        buf.put((byte) d.conditionCode);
        buf.put((byte) d.windSpeed);
        buf.put((byte) d.humidity);
        buf.put((byte) d.visibility);
        buf.put((byte) d.uvIndex);
        buf.put((byte) (d.precipitation & 0xFF));        // LE low byte
        buf.put((byte) ((d.precipitation >> 8) & 0xFF)); // LE high byte
    }

    /**
     * Push current weather (today) + a 3-day forecast to the watch.
     *
     * @param days today first, then the next days (forecast uses up to 3)
     * @param city ignored by this protocol variant (kept for the public API)
     */
    public void sendWeather(List<WeatherDay> days, String city) {
        if (!isSessionReady() || days == null || days.isEmpty()) {
            log("sendWeather: not ready or no data");
            return;
        }
        Calendar now = Calendar.getInstance();

        // --- WEATHER_REALTIME (0x0404): BleTime + BleWeather (16 bytes) ---
        ByteBuffer rt = ByteBuffer.allocate(16);
        rt.order(ByteOrder.BIG_ENDIAN);
        putBleTime(rt, now);
        putBleWeather(rt, days.get(0));
        enqueueLogicalFrame(createMessage((byte) 0x04, (byte) 0x04, (byte) 0x00, rt.array()));
        log("Tx WEATHER_REALTIME: " + bytesToHex(rt.array()));

        // --- WEATHER_FORECAST (0x0405): BleTime + 3 x BleWeather (36 bytes) ---
        ByteBuffer fc = ByteBuffer.allocate(36);
        fc.order(ByteOrder.BIG_ENDIAN);
        putBleTime(fc, now);
        for (int i = 0; i < 3; i++) {
            // Repeat the last available day if fewer than 3 were supplied.
            WeatherDay d = days.get(Math.min(i, days.size() - 1));
            putBleWeather(fc, d);
        }
        enqueueLogicalFrame(createMessage((byte) 0x04, (byte) 0x05, (byte) 0x00, fc.array()));
        log("Tx WEATHER_FORECAST: " + bytesToHex(fc.array()));

        isSending = true;
        sendNextChunk();
    }

    /** Convenience hook for the UI: fetch current weather and push it to the watch. */
    public void syncWeather() {
        WeatherSync.syncIfPossible(context, this);
    }

    /**
     * Writes a 6-byte BleTime [year-2000, month, day, hour, min, sec].
     * Verified against the original app's decompiled BleTime entity
     * (ITEM_LENGTH = 6, no weekday byte).
     */
    private void putBleTime(ByteBuffer buf, Calendar c) {
        buf.put((byte) (c.get(Calendar.YEAR) - 2000));
        buf.put((byte) (c.get(Calendar.MONTH) + 1));
        buf.put((byte) c.get(Calendar.DAY_OF_MONTH));
        buf.put((byte) c.get(Calendar.HOUR_OF_DAY));
        buf.put((byte) c.get(Calendar.MINUTE));
        buf.put((byte) c.get(Calendar.SECOND));
    }

    // ========== Device Control & Settings ==========

    /** Optional callback for remote-camera events from the watch. */
    public interface CameraListener {
        void onShutter();
    }

    private CameraListener cameraListener;

    public void setCameraListener(CameraListener l) {
        this.cameraListener = l;
    }

    // CAMERA (0x0601) control states observed from the original app.
    public static final int CAMERA_ENTER = 0x01; // phone entered camera screen
    public static final int CAMERA_EXIT = 0x00; // phone left camera screen

    /**
     * Tell the watch the phone's camera screen is open/closed (CAMERA 0x0601).
     * While open, pressing the watch's shutter makes the watch send a 0x0601
     * push which we surface via {@link CameraListener#onShutter()}.
     */
    public void sendCamera(int state) {
        if (!isSessionReady())
            return;
        byte[] msg = createMessage((byte) 0x06, (byte) 0x01, (byte) 0x00, new byte[] { (byte) state });
        log("Tx CAMERA state=" + state);
        enqueueLogicalFrame(msg);
        isSending = true;
        sendNextChunk();
    }

    // ===== Find phone (watch rings the phone) =====
    private MediaPlayer findPhonePlayer;
    private static final String FIND_PHONE_CHANNEL = "find_phone";
    private static final int FIND_PHONE_NOTIF_ID = 4101;
    public static final String ACTION_FIND_PHONE_STOP = "com.example.dialsender.FIND_PHONE_STOP";

    /** Start ringing + vibrating the phone, with a notification + screen to stop. */
    public void startFindPhoneAlert() {
        handler.post(() -> {
            try {
                if (findPhonePlayer == null) {
                    Uri uri = RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.TYPE_RINGTONE);
                    if (uri == null)
                        uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                    findPhonePlayer = new MediaPlayer();
                    findPhonePlayer.setAudioAttributes(new AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_ALARM)
                            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build());
                    findPhonePlayer.setDataSource(context, uri);
                    findPhonePlayer.setLooping(true);
                    findPhonePlayer.prepare();
                    findPhonePlayer.start();
                }
                try {
                    Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                    if (v != null && v.hasVibrator()) {
                        v.vibrate(VibrationEffect.createWaveform(new long[] { 0, 600, 400 }, 0));
                    }
                } catch (Exception ve) {
                    log("Find phone vibrate skipped: " + ve.getMessage());
                }
                postFindPhoneNotification();
                log("Find phone: ringing");
                if (listener != null) listener.onFindPhoneRequest();
            } catch (Exception e) {
                log("Find phone ring error: " + e.getMessage());
            }
        });
    }

    /** Stop the find-phone alert. */
    public void stopFindPhoneAlert() {
        handler.post(() -> {
            if (findPhonePlayer != null) {
                try {
                    findPhonePlayer.stop();
                    findPhonePlayer.release();
                } catch (Exception ignored) {
                }
                findPhonePlayer = null;
            }
            Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
            if (v != null)
                v.cancel();
            NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            if (nm != null)
                nm.cancel(FIND_PHONE_NOTIF_ID);
            log("Find phone: stopped");
        });
    }

    public boolean isFindPhoneActive() {
        return findPhonePlayer != null;
    }

    @SuppressLint("MissingPermission")
    private void postFindPhoneNotification() {
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (nm == null)
            return;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel ch = new NotificationChannel(FIND_PHONE_CHANNEL,
                    "Buscar teléfono", NotificationManager.IMPORTANCE_HIGH);
            ch.setSound(null, null); // we ring via MediaPlayer
            nm.createNotificationChannel(ch);
        }
        Intent stopIntent = new Intent(ACTION_FIND_PHONE_STOP).setPackage(context.getPackageName());
        PendingIntent stopPi = PendingIntent.getBroadcast(context, 0, stopIntent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        Intent full = new Intent(context, com.example.dialsender.FindPhoneActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent fullPi = PendingIntent.getActivity(context, 1, full,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        NotificationCompat.Builder b = new NotificationCompat.Builder(context, FIND_PHONE_CHANNEL)
                .setSmallIcon(android.R.drawable.ic_lock_idle_alarm)
                .setContentTitle("Tu reloj está buscando el teléfono")
                .setContentText("Toca «Detener» para silenciar")
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setCategory(NotificationCompat.CATEGORY_ALARM)
                .setOngoing(true)
                .setFullScreenIntent(fullPi, true)
                .addAction(0, "Detener", stopPi);
        try {
            nm.notify(FIND_PHONE_NOTIF_ID, b.build());
        } catch (Exception ignored) {
        }
    }

    /**
     * Generic settings writer for SET (0x02) keys. Use the authoritative key
     * values in protocols/reference/blekey_map_authoritative.txt.
     */
    public void sendSetting(int key, byte[] data) {
        if (!isSessionReady())
            return;
        byte[] msg = createMessage((byte) 0x02, (byte) key, (byte) 0x00, data);
        log("Tx SET key=0x" + String.format("%02X", key) + " " + bytesToHex(data));
        enqueueLogicalFrame(msg);
        isSending = true;
        sendNextChunk();
    }

    // ========== Notification Forwarding ==========

    public void sendNotification(int category, String title, String content, String packageName) {
        handler.post(() -> {
            if (!isSessionReady())
                return;

            // BleNotification (0x0401, UPDATE) — layout verified against the
            // original app's decompiled BleNotification entity:
            //   [0]       mCategory (int8)
            //   [1..6]    mTime (BleTime, 6 bytes: yy,MM,dd,hh,mm,ss)
            //   [7..38]   mPackage (32 bytes fixed, UTF-8, null-padded)
            //   [39..70]  mTitle   (32 bytes fixed, UTF-8, null-padded)
            //   [71..]    mContent (actual UTF-8 bytes, truncated to 250, NOT padded)
            // Total = 71 + contentBytes (variable length).
            byte[] contentBytes = truncatedUtf8(content != null ? content : "", 250);
            ByteBuffer buf = ByteBuffer.allocate(71 + contentBytes.length);
            buf.order(ByteOrder.BIG_ENDIAN);
            buf.put((byte) category);
            putBleTime(buf, Calendar.getInstance());
            buf.put(fixedBytes(packageName != null ? packageName : "", 32));
            buf.put(fixedBytes(title != null ? title : "", 32));
            buf.put(contentBytes);

            byte[] frame = createMessage((byte) 0x04, (byte) 0x01, (byte) 0x00, buf.array());
            log("Tx NOTIFICATION cat=" + category + " pkg=" + packageName + " title=" + title);
            enqueueLogicalFrame(frame);
            if (!isSending) {
                isSending = true;
                sendNextChunk();
            }
        });
    }

    /**
     * Returns a null-padded byte array of exactly {@code len} bytes from {@code s}
     * (UTF-8).
     */
    private byte[] fixedBytes(String s, int len) {
        byte[] src = s.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        byte[] dst = new byte[len];
        System.arraycopy(src, 0, dst, 0, Math.min(src.length, len));
        return dst;
    }

    /** UTF-8 bytes of {@code s}, truncated to at most {@code maxLen} bytes. */
    private byte[] truncatedUtf8(String s, int maxLen) {
        byte[] src = s.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        if (src.length <= maxLen)
            return src;
        return Arrays.copyOf(src, maxLen);
    }

    // ========== Utility ==========

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes)
            sb.append(String.format("%02X ", b));
        return sb.toString().trim();
    }
}
