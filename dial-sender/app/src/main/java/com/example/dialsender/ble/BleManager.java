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
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
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
    private static final String PREF_BIND_ID = "bind_id";

    private final Handler handler = new Handler(Looper.getMainLooper());

    private BleStateListener listener;
    private boolean isConnected = false;

    private final ConcurrentLinkedQueue<byte[]> commandQueue = new ConcurrentLinkedQueue<>();
    private boolean isSending = false;
    private int currentMtu = 23;
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

        void onTransferProgress(int percent, long bytesTransferred, long totalBytes);

        void onTransferComplete();

        void onLogUpdated();
    }

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

    // ========== GATT Callback — ported from omo version ==========

    private final BluetoothGattCallback gattCallback = new BluetoothGattCallback() {
        @SuppressLint("MissingPermission")
        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            if (newState == BluetoothProfile.STATE_CONNECTED) {
                isConnected = true;
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
                log("MTU changed to " + mtu + " (payload=" + currentMtu + ")");
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

    private void sendBind() {
        log("Sending Bind...");
        int bindId = new Random().nextInt();
        prefs.edit().putInt(PREF_BIND_ID, bindId).apply();
        ByteBuffer payload = ByteBuffer.allocate(4);
        payload.order(ByteOrder.LITTLE_ENDIAN);
        payload.putInt(bindId);

        byte[] message = createMessage((byte) 0x03, (byte) 0x01, (byte) 0x20, payload.array());
        connectionState = ConnectionState.BIND_SENT;
        log("Tx Bind: " + bytesToHex(message));
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
        log("Tx Login: " + bytesToHex(message));
        enqueueLogicalFrame(message);
        isSending = true;
        sendNextChunk();
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

        // Handle Identity Info Request from watch -> implies Session Ready
        if ((header & 0x10) == 0 && header == 0x01 && cmd == 0x03 && key == 0x01) {
            log("Received Identity Request - Sending ACK");
            sendAck(cmd, key, flag);
            if (connectionState == ConnectionState.LOGIN_SENT) {
                connectionState = ConnectionState.SESSION_READY;
                log("=== SESSION READY ===");
                if (listener != null) {
                    handler.post(() -> listener.onConnectionStateChange(true, true));
                }
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
                handler.postDelayed(this::sendLogin, 100);
            } else {
                handler.postDelayed(this::sendBind, 100);
            }
            return;
        }

        // Bind ACK
        if (isReply && cmd == 0x03 && key == 0x01 && connectionState == ConnectionState.BIND_SENT) {
            log("Bind OK");
            connectionState = ConnectionState.BIND_OK;
            handler.postDelayed(this::sendLogin, 100);
            return;
        }

        // Login ACK
        if (isReply && cmd == 0x03 && key == 0x02 && connectionState == ConnectionState.LOGIN_SENT) {
            log("Login OK");
            connectionState = ConnectionState.SESSION_READY;
            log("=== SESSION READY ===");
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
        if (cmd == 0x07 && key == 0x01 && data.length >= 18) {
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
                    sendStreamChunk(completed);
                } else if (isFileTransferActive && completed >= total) {
                    log("=== Transfer Complete! ===");
                    isFileTransferActive = false;
                    connectionState = ConnectionState.SESSION_READY;
                    commandQueue.clear();
                    isSending = false;
                    packetsSent = 0;
                    if (listener != null) {
                        handler.post(() -> listener.onTransferComplete());
                    }
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
            if (listener != null) {
                handler.post(() -> listener.onHealthDataReceived(keyName, healthPayload));
            }
            return;
        }

        // Unknown response
        log("Unhandled response: Cmd=0x" + String.format("%02X", cmd) + " Key=0x" + String.format("%02X", key));
    }

    // ========== File Transfer — ported from omo version ==========

    public void startFileTransfer(byte[] fileData) {
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
        commandQueue.clear();
        isSending = false;
        packetsSent = 0;
        preTransferIndex = 0;
        setupStep = 0;
        isFileTransferActive = true;

        log("Starting file transfer (" + fileTotalSize + " bytes)");
        startPreTransferSequence();
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

        byte[] message = createMessage((byte) 0x07, (byte) 0x01, (byte) 0x00, bb.array());
        enqueueLogicalFrame(message);
        isSending = true;
        sendNextChunk();
        scheduleTransferTimeout(offset);
    }

    // ========== Health Sync ==========

    public void syncHealth() {
        log("=== Syncing Health Data ===");
        int[] keys = { 0x03, 0x04, 0x0D, 0x07, 0x05, 0x0E, 0x09, 0x0B };
        for (int key : keys) {
            byte[] msg = createMessage((byte) 0x05, (byte) key, (byte) 0x10, null);
            enqueueLogicalFrame(msg);
        }
        isSending = true;
        sendNextChunk();
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

    // ========== Utility ==========

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes)
            sb.append(String.format("%02X ", b));
        return sb.toString().trim();
    }
}
