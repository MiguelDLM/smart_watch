package com.example.dialsender;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.OpenableColumns;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.UUID;

import java.util.concurrent.TimeUnit;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DialSender";
    private static final int PERMISSION_REQUEST_CODE = 1;
    private static final int FILE_SELECT_CODE = 2;

    // Jieli UUIDs
    private static final UUID SERVICE_UUID = UUID.fromString("0000ae00-0000-1000-8000-00805f9b34fb");
    private static final UUID WRITE_CHAR_UUID = UUID.fromString("0000ae01-0000-1000-8000-00805f9b34fb");
    private static final UUID NOTIFY_CHAR_UUID = UUID.fromString("0000ae02-0000-1000-8000-00805f9b34fb");

    // Protocol Constants
    private static final int OP_CODE_EXTRA_FLASH = 0x1A;
    private static final int OP_CODE_GET_TARGET_INFO = 0x0C;
    private static final int OPT_WRITE = 0;
    private static final int OPT_INSERT = 2;
    private static final int OPT_DIAL = 3;
    private static final int OPT_UPDATE_RESOURCE = 7; // New OpCode
    private static final int OPT_TRAN_REPLY = 8;
    
    private static final int STATE_STOP = 0;
    private static final int STATE_START = 1;

    // UI
    private TextView txtStatus;
    private TextView txtLog;
    private TextView txtVersion;
    private Button btnScan;
    private Button btnSelectFile;
    private ProgressBar progressBar;

    // Bluetooth
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothGatt bluetoothGatt;
    private BluetoothGattCharacteristic writeChar;
    private boolean isConnected = false;
    // Whether we've successfully enabled remote notifications (CCCD written)
    private volatile boolean notificationsEnabled = false;
    private Handler mainHandler = new Handler(Looper.getMainLooper());

    private final java.util.concurrent.BlockingQueue<byte[]> responseQueue = new java.util.concurrent.LinkedBlockingQueue<>();
    private int sequenceNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtStatus = findViewById(R.id.txtStatus);
        txtLog = findViewById(R.id.txtLog);
        txtVersion = findViewById(R.id.txtVersion);
        btnScan = findViewById(R.id.btnScan);
        btnSelectFile = findViewById(R.id.btnSelectFile);

        txtVersion.setText("v1.5 - RCSP v1 Tag (AB BC CD)");
        
        // Auto-scroll logic
        txtLog.setMovementMethod(new android.text.method.ScrollingMovementMethod());

        btnScan.setOnClickListener(v -> startScan());
        btnSelectFile.setOnClickListener(v -> openFilePicker());

        checkPermissions();
    }

    private void checkPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{
                        Manifest.permission.BLUETOOTH_SCAN,
                        Manifest.permission.BLUETOOTH_CONNECT,
                        Manifest.permission.ACCESS_FINE_LOCATION
                }, PERMISSION_REQUEST_CODE);
            }
        } else {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
            }
        }
    }

    private void startScan() {
        Toast.makeText(this, "Ensure 'co-fit' app is Force Stopped!", Toast.LENGTH_LONG).show();
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        bluetoothAdapter = bluetoothManager.getAdapter();

        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            log("Bluetooth not enabled");
            return;
        }

        // 1. Check for already connected devices (bonded/connected at system level)
        // This handles cases where the device is paired but not "seen" by a fresh scan immediately
        List<BluetoothDevice> connectedDevices = bluetoothManager.getConnectedDevices(BluetoothProfile.GATT);
        for (BluetoothDevice device : connectedDevices) {
            log("Found connected device: " + (device.getName() != null ? device.getName() : "Unknown") + " (" + device.getAddress() + ")");
            // Check if it might be our target? Since the user said "already connected", let's try it.
            // Ideally we check if it has the UUID, but we can't do that without connecting GATT.
            // So we just connect.
            connectToDevice(device);
            return; 
        }

        log("Scanning for devices (UUID: " + SERVICE_UUID.toString().substring(4, 8) + ")...");
        
        // Scan with Service UUID filter to find re-named devices
        UUID[] serviceUuids = new UUID[]{SERVICE_UUID};
        
        bluetoothAdapter.startLeScan(serviceUuids, (device, rssi, scanRecord) -> {
            log("Found device: " + (device.getName() != null ? device.getName() : "Unknown") + " [" + device.getAddress() + "]");
            bluetoothAdapter.stopLeScan(null);
            connectToDevice(device);
        });
        
        // Also scan broadly just in case the UUID advertisement is tricky
        // But do NOT filter by name.
        bluetoothAdapter.startLeScan((device, rssi, scanRecord) -> {
            // Log candidates but be careful about auto-connecting to everything
            // If the filtered scan works, this might be redundant.
            // But if the UUID is missing from advertisement packet (common in some firmwares), 
            // we might need to rely on the user seeing the log or manual selection.
            // For now, let's trust the UUID filter first.
            if (device.getName() != null && (device.getName().toUpperCase().contains("WATCH") || device.getName().toUpperCase().contains("JIELI"))) {
                 // Fallback name check if UUID filter fails (legacy)
                 // But we don't stop strictly.
            }
        });

        // Timeout scan after 10s
        mainHandler.postDelayed(() -> bluetoothAdapter.stopLeScan(null), 10000);
    }

    private void connectToDevice(BluetoothDevice device) {
        log("Connecting to " + device.getAddress());
        bluetoothGatt = device.connectGatt(this, false, gattCallback);
    }

    private final BluetoothGattCallback gattCallback = new BluetoothGattCallback() {
        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            if (newState == BluetoothProfile.STATE_CONNECTED) {
                isConnected = true;
                runOnUiThread(() -> {
                    txtStatus.setText("Connected: " + gatt.getDevice().getName());
                    btnSelectFile.setEnabled(true);
                });
                log("Connected. Discovering services...");
                // Request higher MTU for better speed, though some devices ignore it
                gatt.requestMtu(512); 
                // Discovery will be triggered after MTU change or if we skip it
                // But for safety, let's just do discoverServices() directly as some devices don't like MTU req before discovery
                gatt.discoverServices();
            } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                isConnected = false;
                runOnUiThread(() -> {
                    txtStatus.setText("Disconnected");
                    btnSelectFile.setEnabled(false);
                });
                log("Disconnected");
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
                        log("Jieli Services Found!");
                        
                        // Read Firmware Revision to verify link quality
                        BluetoothGattService deviceService = gatt.getService(UUID.fromString("0000180a-0000-1000-8000-00805f9b34fb"));
                        if (deviceService != null) {
                            BluetoothGattCharacteristic fwChar = deviceService.getCharacteristic(UUID.fromString("00002a26-0000-1000-8000-00805f9b34fb"));
                            if (fwChar != null) {
                                log("Reading Firmware Revision...");
                                gatt.readCharacteristic(fwChar);
                            }
                        }
                        
                        // Enable local notifications
                        if ((notifyChar.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) > 0) {
                            gatt.setCharacteristicNotification(notifyChar, true);
                            
                            // Write to CCCD descriptor to enable remote notifications (CRITICAL FIX)
                            BluetoothGattDescriptor descriptor = notifyChar.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb"));
                            if (descriptor != null) {
                                descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                                if (gatt.writeDescriptor(descriptor)) {
                                    log("Enabling notifications on device...");
                                } else {
                                    log("Failed to write CCCD descriptor");
                                }
                            } else {
                                log("Error: CCCD Descriptor not found");
                            }
                        } else if ((notifyChar.getProperties() & BluetoothGattCharacteristic.PROPERTY_INDICATE) > 0) {
                             log("Characteristic supports INDICATE, not NOTIFY. Switching...");
                             gatt.setCharacteristicNotification(notifyChar, true);
                             BluetoothGattDescriptor descriptor = notifyChar.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb"));
                             if (descriptor != null) {
                                descriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
                                if (gatt.writeDescriptor(descriptor)) {
                                    log("Enabling indications on device...");
                                } else {
                                    log("Failed to write CCCD (Indicate)");
                                }
                             }
                        } else {
                            log("Error: Characteristic does not support Notify or Indicate");
                        }

                    } else {
                        log("Required characteristics not found");
                    }
                } else {
                    log("Jieli Service UUID not found");
                }
            }
        }
        
        @Override
        public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
             byte[] data = characteristic.getValue();
             if (data != null) {
                 // log("Rx: " + bytesToHex(data)); // Optional: Verbose logging
                 responseQueue.offer(data);
             }
        }

        @Override
        public void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
            if (descriptor != null && descriptor.getUuid() != null && descriptor.getUuid().toString().equals("00002902-0000-1000-8000-00805f9b34fb")) {
                if (status == BluetoothGatt.GATT_SUCCESS) {
                    notificationsEnabled = true;
                    log("Remote notifications enabled");
                } else {
                    notificationsEnabled = false;
                    log("Failed to enable remote notifications, status: " + status);
                }
            }
        }
            @Override
        public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                if (characteristic.getUuid().toString().contains("2a26")) {
                    String fw = new String(characteristic.getValue());
                    log("Firmware Rev: " + fw);
                }
            } else {
                log("Failed to read characteristic: " + status);
            }
        }
    };

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }

    private void openFilePicker() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, FILE_SELECT_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FILE_SELECT_CODE && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            startTransfer(uri);
        }
    }

    private void startTransfer(Uri uri) {
        try {
            InputStream is = getContentResolver().openInputStream(uri);
            byte[] fileBytes = getBytes(is);
            String fileName = getFileName(uri);
            
            log("Selected file: " + fileName + " (" + fileBytes.length + " bytes)");
            new TransferTask(fileBytes, fileName).execute();
            
        } catch (Exception e) {
            log("Error reading file: " + e.getMessage());
        }
    }

    private class TransferTask extends AsyncTask<Void, Integer, Boolean> {
        private byte[] fileData;
        private String fileName;
        private int currentCrc = 0;

        public TransferTask(byte[] data, String name) {
            this.fileData = data;
            // Sanitize filename
            String cleanName = name.replaceAll("[^a-zA-Z0-9._-]", "");
            this.fileName = "dial/" + cleanName;
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            try {
                // 0. Connectivity Check
                log("Checking connectivity (Get Target Info)...");
                ByteBuffer infoPayload = ByteBuffer.allocate(4);
                infoPayload.order(ByteOrder.BIG_ENDIAN);
                infoPayload.putInt(0xFFFFFFFF); // Request all info
                
                // We use a short timeout/don't fail strictly if this specific command isn't supported, 
                // but it's a good test.
                // However, for now let's enforce it to verify Rx path works.
                if (!sendPacket(OP_CODE_GET_TARGET_INFO, infoPayload.array(), true)) {
                    log("Connectivity check failed. Device might require Auth or is unresponsive.");
                    // We continue anyway? No, if Rx is broken, Transfer will fail.
                    // But maybe the device doesn't support 0x0C.
                    // Let's just log warning.
                    log("Warning: Get Target Info timed out. Proceeding with transfer...");
                } else {
                    log("Connectivity verified.");
                }

                // 1. Insert Start
                log("Sending Insert Start...");
                byte[] nameBytes = fileName.getBytes();
                // Payload: Op(1) + Flag(1) + Size(4) + Path(N) + Null(1)
                ByteBuffer payload = ByteBuffer.allocate(6 + nameBytes.length + 1);
                payload.order(ByteOrder.BIG_ENDIAN); // JL Payload requires Big Endian (Size/Offset/CRC)
                payload.put((byte) OPT_INSERT);
                payload.put((byte) STATE_START);
                payload.putInt(fileData.length); // 4 bytes size
                payload.put(nameBytes);
                payload.put((byte) 0); // Null Terminator
                
                if (!sendPacket(OP_CODE_EXTRA_FLASH, payload.array(), true)) {
                    log("Insert Start failed. Check filename/path or storage.");
                    return false;
                }
                
                // 2. Data Chunks
                int offset = 0;
                int chunkSize = 256; // Standard BLE chunk
                
                while (offset < fileData.length) {
                    int remaining = fileData.length - offset;
                    int size = Math.min(chunkSize, remaining);
                    byte[] chunk = new byte[size];
                    System.arraycopy(fileData, offset, chunk, 0, size);
                    
                    // CRC Update
                    currentCrc = crc16_ccitt(chunk, currentCrc);
                    
                    // Payload: [Opt=0] [State=1 if more, 0 if last] [Offset(4B BE)] [Data...]
                    ByteBuffer chunkPayload = ByteBuffer.allocate(6 + size);
                    chunkPayload.order(ByteOrder.BIG_ENDIAN);
                    chunkPayload.put((byte) OPT_WRITE);
                    
                    // Flag: 1 for intermediate chunks, 0 for the very last chunk
                    boolean isLastChunk = (offset + size) >= fileData.length;
                    chunkPayload.put((byte) (isLastChunk ? STATE_STOP : STATE_START)); 
                    
                    chunkPayload.putInt(offset); // Offset Big Endian (confirmed from APK analysis)
                    chunkPayload.put(chunk);
                    
                    // Optimization: Only request response for the last chunk to ensure flush
                    // Or if we want to be safe, request every N chunks.
                    boolean confirmChunk = isLastChunk; 
                    
                    if (!sendPacket(OP_CODE_EXTRA_FLASH, chunkPayload.array(), confirmChunk)) {
                        log("Write chunk failed at offset " + offset);
                        return false;
                    }
                    
                    offset += size;
                    publishProgress((int)((offset / (float)fileData.length) * 100));
                    
                    // Slight delay is still good for flow control
                    Thread.sleep(10); 
                }
                
                // 3. CRC Check (Query Write Result)
                // Payload: [Opt=8] [State=0] [CRC16(2B LE)]
                ByteBuffer crcPayload = ByteBuffer.allocate(4);
                crcPayload.order(ByteOrder.BIG_ENDIAN);
                crcPayload.put((byte) OPT_TRAN_REPLY);
                crcPayload.put((byte) 0);
                crcPayload.putShort((short) currentCrc); 
                
                log("Verifying CRC (0x" + Integer.toHexString(currentCrc & 0xFFFF) + ")...");
                if (!sendPacket(OP_CODE_EXTRA_FLASH, crcPayload.array(), true)) {
                    log("CRC Verification failed. Data corruption?");
                    return false;
                }

                // 4. Insert Stop (File Close)
                ByteBuffer stopPayload = ByteBuffer.allocate(2);
                stopPayload.put((byte) OPT_INSERT);
                stopPayload.put((byte) STATE_STOP);
                
                log("Finalizing File...");
                if (!sendPacket(OP_CODE_EXTRA_FLASH, stopPayload.array(), true)) {
                    log("File Close failed.");
                    return false;
                }

                // 5. Update Resource (Apply Dial)
                // Op 3 (DIAL): [Op=3] [flag=1] [path(N)] [null]
                byte[] dialPathBytes = fileName.getBytes();
                ByteBuffer dialPayload = ByteBuffer.allocate(2 + dialPathBytes.length + 1);
                dialPayload.put((byte) OPT_DIAL);
                dialPayload.put((byte) STATE_START); // flag=1 to activate
                dialPayload.put(dialPathBytes);
                dialPayload.put((byte) 0); // Null terminator
                
                log("Installing Dial (OPT_DIAL) with path: " + fileName + "...");
                if (!sendPacket(OP_CODE_EXTRA_FLASH, dialPayload.array(), true)) {
                    log("Dial installation command rejected.");
                    return false;
                }

                return true;

            } catch (Exception e) {
                log("Transfer Error: " + e.getMessage());
                e.printStackTrace();
                return false;
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Boolean success) {
            if (success) log("Transfer Complete!");
            else log("Transfer Failed.");
        }
    }

    private boolean sendPacket(int opCode, byte[] payload, boolean responseNeeded) throws InterruptedException {
        if (writeChar == null || bluetoothGatt == null) return false;

        // Try RCSP v1 Header (AB BC CD) instead of v2 (FE DC BA)
        // Many older/cloned Jieli devices use v1
        byte[] tag = new byte[]{(byte)0xAB, (byte)0xBC, (byte)0xCD};
        
        // Control: OpCode | (Seq << 8)
        // v1 usually uses LE Control
        int control = opCode | ((sequenceNumber++ & 0xFF) << 8);
        
        // Length of payload
        int len = payload.length;

        ByteBuffer buffer = ByteBuffer.allocate(tag.length + 2 + 2 + len + 1);
        buffer.order(ByteOrder.LITTLE_ENDIAN); // Control is Little Endian
        buffer.put(tag);
        buffer.putShort((short) control);
        
        buffer.order(ByteOrder.BIG_ENDIAN); // Length: v1 is usually Big Endian
        buffer.putShort((short) len);
        
        buffer.put(payload);
        buffer.put((byte) 0xEF); // End Tag is same? Usually. Or just End.

        // Log Tx for debugging
        log("Tx: " + bytesToHex(buffer.array()));

        if (responseNeeded) {
            responseQueue.clear();
            // Ensure remote notifications are enabled before sending commands that expect a reply
            int waited = 0;
            while (!notificationsEnabled && waited < 5000) {
                Thread.sleep(100);
                waited += 100;
            }
            if (!notificationsEnabled) {
                log("Warning: remote notifications not enabled; response may never arrive");
            }
            // Many JL chips prefer WriteNoResponse + Notification even for commands
            writeChar.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        } else {
            writeChar.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        }
        
        writeChar.setValue(buffer.array());
        if (!bluetoothGatt.writeCharacteristic(writeChar)) {
            log("Failed to write characteristic");
            return false;
        }

        if (responseNeeded) {
            // Wait for a notification response (first attempt)
            byte[] response = responseQueue.poll(8000, TimeUnit.MILLISECONDS);
            if (response == null) {
                log("Timeout (8s) waiting for response to OpCode: " + opCode + " (first attempt)");
                // Fallback: try using WRITE_TYPE_DEFAULT (with response) once
                log("Retrying with WRITE_TYPE_DEFAULT as fallback...");
                writeChar.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
                // resend the same payload
                writeChar.setValue(buffer.array());
                if (!bluetoothGatt.writeCharacteristic(writeChar)) {
                    log("Retry write failed");
                    return false;
                }

                response = responseQueue.poll(8000, TimeUnit.MILLISECONDS);
                if (response == null) {
                    log("Timeout (8s) waiting for response to OpCode: " + opCode + " (second attempt)");
                    return false;
                }
            }
            
            // Log response for debugging
            log("Rx: " + bytesToHex(response));

            // Response Validation (check for both v1 0xAB and v2 0xFE headers)
            // Response format: [TAG: 3B] [Control: 2B] [Length: 2B] [Status: 1B] [Payload] [End: 0xEF]
            if (response.length >= 8) {
                // Check if response uses v1 (0xAB 0xBC 0xCD) or v2 (0xFE 0xDC 0xBA) header
                boolean isValidTag = (response[0] == (byte)0xFE && response[1] == (byte)0xDC && response[2] == (byte)0xBA) ||
                                     (response[0] == (byte)0xAB && response[1] == (byte)0xBC && response[2] == (byte)0xCD);
                
                if (isValidTag) {
                    // Status byte is typically at index 7 or after control+length
                    // v1: [AB BC CD] [Control:2B] [Length:2B] [Status:1B] ...
                    if (response.length > 7) {
                        byte status = response[7];
                        if (status != 0) {
                            log("Error! Device responded with Status: " + status + " for OpCode: " + opCode);
                            return false;
                        }
                    }
                    return true;
                } else {
                    log("Invalid response tag (expected 0xAB/0xFE). Got: " + bytesToHex(response).substring(0, 8));
                    return false;
                }
            } else {
                log("Response too short: " + response.length + " bytes");
                return false; 
            }
        }
        
        // Flow control for non-response packets
        Thread.sleep(20); 
        return true;
    }

    // Helpers
    private int crc16_ccitt(byte[] data, int crc) {
        for (byte b : data) {
            crc ^= ((b & 0xFF) << 8);
            for (int i = 0; i < 8; i++) {
                if ((crc & 0x8000) != 0) {
                    crc = (crc << 1) ^ 0x1021;
                } else {
                    crc = crc << 1;
                }
            }
        }
        return crc & 0xFFFF;
    }

    private byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }
        return byteBuffer.toByteArray();
    }

    private String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    int index = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                     if(index >= 0) result = cursor.getString(index);
                }
            } finally {
                cursor.close();
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }

    private void log(String msg) {
        Log.d(TAG, msg);
        runOnUiThread(() -> txtLog.append(msg + "\n"));
    }
}
