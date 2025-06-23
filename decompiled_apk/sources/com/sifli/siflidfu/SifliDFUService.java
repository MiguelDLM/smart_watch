package com.sifli.siflidfu;

import XXO0.oIX0oI;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.exoplayer2.ExoPlayer;
import com.sifli.siflidfu.constants.General;
import com.sifli.siflidfu.constants.SerialTrans;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;

/* loaded from: classes11.dex */
public class SifliDFUService extends Service implements ISifliDFUService {
    private static final String ACTION_NAND = "com.sifli.siflidfu.action.NAND";
    private static final String ACTION_NOR_V1 = "com.sifli.siflidfu.action.NOR_V1";
    private static final String ACTION_NOR_V2 = "com.sifli.siflidfu.action.NOR_V2";
    public static final String BROADCAST_DFU_LOG = "com.sifli.siflidfu.BROADCAST_DFU_LOG";
    public static final String BROADCAST_DFU_PROGRESS = "com.sifli.siflidfu.EXTRA_BROADCAST_PROGRESS";
    public static final String BROADCAST_DFU_STATE = "com.sifli.siflidfu.BROADCAST_DFU_STATE";
    private static final String EXTRA_ADDRESS = "com.sifli.siflidfu.extra.ADDRESS";
    private static final String EXTRA_BLE_DATA = "com.sifli.siflidfu.extra.BLE_DATA";
    public static final String EXTRA_DFU_PROGRESS = "com.sifli.siflidfu.EXTRA_DFU_PROGRESS";
    public static final String EXTRA_DFU_PROGRESS_TYPE = "com.sifli.siflidfu.EXTRA_DFU_PROGRESS_TYPE";
    public static final String EXTRA_DFU_STATE = "com.sifli.siflidfu.EXTRA_DFU_STATE";
    public static final String EXTRA_DFU_STATE_RESULT = "com.sifli.siflidfu.EXTRA_DFU_STATE_RESULT";
    private static final String EXTRA_IMAGES = "com.sifli.siflidfu.extra.IMAGES";
    public static final String EXTRA_LOG_LEVEL = "com.sifli.siflidfu.LOG_LEVEL";
    public static final String EXTRA_LOG_MESSAGE = "com.sifli.siflidfu.EXTRA_LOG_MESSAGE";
    private static final String EXTRA_NUM_OF_RSP = "com.sifli.siflidfu.extra.PARAM2";
    private static final String EXTRA_RESUME_MODE = "com.sifli.siflidfu.extra.PARAM1";
    private static final String TAG = "sifli-DFU";
    private static ISifliDFUService dfuService;
    private static final Boolean progressDebug = Boolean.FALSE;
    int countAll;
    int countCurrent;
    int countPrevious;
    private BroadcastReceiver mBleBroadcastReceiver;
    private Handler mBleHandler;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothDevice mBluetoothDevice;
    private BluetoothGatt mBluetoothGatt;
    private int mConnectionState;
    private int mConnectionStatus;
    private int mCurrentRetryCount;
    DFUState mDFUState;
    private int mError;
    private int mFsBlock;
    private BluetoothGattCallback mGattCallback;
    private int mImageSkipInfo;
    private boolean mIsDescriptorWrite;
    private boolean mIsRemoteBoot;
    private int mLastCateID;
    private long mLoseCheckTime;
    int mProgressType;
    private int mRemoteCurrentIndex;
    private int mRemoteImageID;
    private int mRemoteResume;
    private int mRemoteResumeCount;
    private int mRemoteResumeNumOfRsp;
    private int mRemoteResumeRestart;
    private int mRspFreq;
    private boolean mRspReceive;
    private boolean mSendAvailable;
    private boolean mSendComplete;
    private int mWaitEndMode;
    private BluetoothGattCharacteristic mWriteCharacteristic;
    private boolean misAlreadyConnect;
    byte[] receiveData;
    int receiveDataCurrentLen;
    int receiveDataLen;
    private String VersionStr = " 1.1.24";
    private int mMaxPacketLen = 20;
    private int mRemoteBoot = 0;
    private final int mLoadFileMode = 1;
    private final int MAX_RETRY_CONNECT_COUNT = 2;
    private final Object mLock = new Object();
    private Handler mTimerHandler = new Handler();
    private boolean isReleased = false;
    private int mRemoteVersion = 0;
    private int mWriteRetry = 0;
    private int mWriteRetryCount = 0;
    private boolean mIsLastPacket = false;
    private boolean mIsBusy = false;
    private SifliDFUBinder myBinder = new SifliDFUBinder();
    private final Runnable mConnectTimerRunnable = new Runnable() { // from class: com.sifli.siflidfu.SifliDFUService.5
        @Override // java.lang.Runnable
        public void run() {
            Log.e(SifliDFUService.TAG, "connect call timeout, system bt may error");
            SifliDFUService.this.mError = 62;
            synchronized (SifliDFUService.this.mLock) {
                SifliDFUService.this.mLock.notify();
            }
        }
    };
    private final Runnable mWriteDescriptorTimerRunnable = new Runnable() { // from class: com.sifli.siflidfu.SifliDFUService.6
        @Override // java.lang.Runnable
        public void run() {
            Log.e(SifliDFUService.TAG, "write descriptor timeout");
            SifliDFUService.this.mError = 68;
            synchronized (SifliDFUService.this.mLock) {
                SifliDFUService.this.mLock.notifyAll();
            }
        }
    };
    private final Runnable mDfuCommandTimerRunnable = new Runnable() { // from class: com.sifli.siflidfu.SifliDFUService.7
        @Override // java.lang.Runnable
        public void run() {
            Log.e(SifliDFUService.TAG, "ota command timeout");
            SifliDFUService.this.mError = 79;
            synchronized (SifliDFUService.this.mLock) {
                SifliDFUService.this.mLock.notifyAll();
            }
        }
    };
    private final Runnable mDiscoveryTimerRunnable = new Runnable() { // from class: com.sifli.siflidfu.SifliDFUService.8
        @Override // java.lang.Runnable
        public void run() {
            Log.e(SifliDFUService.TAG, "discovery timeout");
            SifliDFUService.this.sendLogBroadcast(5, "discovery timeout");
            SifliDFUService.this.mError = 67;
            synchronized (SifliDFUService.this.mLock) {
                SifliDFUService.this.mLock.notifyAll();
            }
        }
    };

    /* loaded from: classes11.dex */
    public class SifliDFUBinder extends Binder {
        public SifliDFUBinder() {
        }

        public ISifliDFUService getDfuService() {
            return SifliDFUService.this;
        }
    }

    /* loaded from: classes11.dex */
    public class bleHandlerCallback implements Handler.Callback {
        private bleHandlerCallback() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (SifliDFUService.this.mConnectionState != 0 && SifliDFUService.this.mError == 0) {
                int i = message.what;
                if (i != 0) {
                    if (i == 1) {
                        byte b = message.getData().getByteArray(SifliDFUService.EXTRA_BLE_DATA)[1];
                        if (b == 0 || b == 1) {
                            SifliDFUService sifliDFUService = SifliDFUService.this;
                            int i2 = sifliDFUService.countCurrent + 1;
                            sifliDFUService.countCurrent = i2;
                            int i3 = ((i2 + sifliDFUService.countPrevious) * 100) / sifliDFUService.countAll;
                            sifliDFUService.sendDFUProgressBroadcast(i3, sifliDFUService.mProgressType);
                            if (SifliDFUService.progressDebug.booleanValue()) {
                                Log.d(SifliDFUService.TAG, "progress " + i3 + ", countCurrent " + SifliDFUService.this.countCurrent + ", countPrevious " + SifliDFUService.this.countPrevious + ", countAll " + SifliDFUService.this.countAll);
                            }
                        }
                        if (b == 0 || b == 3) {
                            SifliDFUService.this.mIsLastPacket = true;
                        }
                    }
                    return false;
                }
                byte[] byteArray = message.getData().getByteArray(SifliDFUService.EXTRA_BLE_DATA);
                if (SifliDFUService.this.mWriteCharacteristic == null || SifliDFUService.this.mBluetoothGatt == null) {
                    return false;
                }
                SifliDFUService.this.mWriteCharacteristic.setValue(byteArray);
                SifliDFUService.this.mWriteCharacteristic.setWriteType(1);
                SifliDFUService.this.mSendAvailable = false;
                if (Build.VERSION.SDK_INT >= 31 && ContextCompat.checkSelfPermission(SifliDFUService.this, "android.permission.BLUETOOTH_CONNECT") != 0) {
                    Log.e(SifliDFUService.TAG, "no Permission");
                    SifliDFUService.this.mError = 61;
                    synchronized (SifliDFUService.this.mLock) {
                        SifliDFUService.this.mLock.notifyAll();
                    }
                    return false;
                }
                SifliDFUService.this.mBluetoothGatt.writeCharacteristic(SifliDFUService.this.mWriteCharacteristic);
                synchronized (SifliDFUService.this.mLock) {
                    while (!SifliDFUService.this.mSendAvailable && SifliDFUService.this.mError == 0) {
                        try {
                            SifliDFUService.this.mLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                while (SifliDFUService.this.mWriteRetry == 1 && SifliDFUService.this.mWriteRetryCount < 3 && message.what == 1) {
                    Log.i(SifliDFUService.TAG, "write retry");
                    SifliDFUService.this.mSendAvailable = false;
                    SifliDFUService.this.mBluetoothGatt.writeCharacteristic(SifliDFUService.this.mWriteCharacteristic);
                    SifliDFUService.access$2008(SifliDFUService.this);
                    synchronized (SifliDFUService.this.mLock) {
                        while (!SifliDFUService.this.mSendAvailable && SifliDFUService.this.mError == 0) {
                            try {
                                SifliDFUService.this.mLock.wait();
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
                SifliDFUService.this.mWriteRetry = 0;
                SifliDFUService.this.mWriteRetryCount = 0;
                return false;
            }
            Log.e(SifliDFUService.TAG, "handle exit " + SifliDFUService.this.mError);
            return false;
        }
    }

    public static /* synthetic */ int access$2008(SifliDFUService sifliDFUService) {
        int i = sifliDFUService.mWriteRetryCount;
        sifliDFUService.mWriteRetryCount = i + 1;
        return i;
    }

    public static String byte2hex(byte[] bArr) {
        if (bArr == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
            sb.append(" ");
        }
        return sb.toString();
    }

    private BluetoothGatt connect(BluetoothDevice bluetoothDevice, BluetoothGattCallback bluetoothGattCallback) {
        BluetoothGatt connectGatt;
        if (!this.mBluetoothAdapter.isEnabled()) {
            return null;
        }
        this.mConnectionState = 1;
        Log.i(TAG, "connecting to " + bluetoothDevice);
        int i = Build.VERSION.SDK_INT;
        if (i >= 31 && ContextCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") != 0) {
            Log.e(TAG, "no Permission");
            this.mError = 61;
            synchronized (this.mLock) {
                this.mLock.notifyAll();
            }
            return null;
        }
        if (i >= 26) {
            sendLogBroadcast(0, "gatt = device.connectGatt(autoConnect = false, TRANSPORT_LE, preferredPhy = LE_1M|LE_2M)");
            connectGatt = bluetoothDevice.connectGatt(this, false, bluetoothGattCallback, 2, 3);
        } else if (i >= 23) {
            sendLogBroadcast(0, "gatt = device.connectGatt(autoConnect = false, TRANSPORT_LE)");
            connectGatt = bluetoothDevice.connectGatt(this, false, bluetoothGattCallback, 2);
        } else {
            sendLogBroadcast(0, "gatt = device.connectGatt(autoConnect = false)");
            connectGatt = bluetoothDevice.connectGatt(this, false, bluetoothGattCallback);
        }
        this.mTimerHandler.postDelayed(this.mConnectTimerRunnable, 60000L);
        try {
            synchronized (this.mLock) {
                while (true) {
                    try {
                        int i2 = this.mConnectionState;
                        if ((i2 == 1 || i2 == 2) && this.mError == 0) {
                            this.mLock.wait();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (InterruptedException unused) {
            Log.e(TAG, "Sleeping interrupted");
        }
        this.mTimerHandler.removeCallbacks(this.mConnectTimerRunnable);
        if (this.mError == 62) {
            return null;
        }
        return connectGatt;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x009d, code lost:
    
        android.util.Log.d(com.sifli.siflidfu.SifliDFUService.TAG, "retry success");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean connectDevice(java.lang.String r17, android.bluetooth.BluetoothGattCallback r18) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sifli.siflidfu.SifliDFUService.connectDevice(java.lang.String, android.bluetooth.BluetoothGattCallback):boolean");
    }

    private int getAllFileLength(ArrayList<OTAFile> arrayList, int i) {
        int fileLength;
        Iterator<OTAFile> it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            OTAFile next = it.next();
            if (next.getImageID() != -1) {
                if (next.getFileLength() % i == 0) {
                    fileLength = next.getFileLength() / i;
                } else {
                    fileLength = (next.getFileLength() / i) + 1;
                }
                i2 += fileLength;
            }
        }
        Log.d(TAG, "all file len " + i2);
        return i2;
    }

    private BroadcastReceiver getBLEBroadcastReceiver() {
        return new BroadcastReceiver() { // from class: com.sifli.siflidfu.SifliDFUService.9
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) == 10) {
                    Log.e(SifliDFUService.TAG, "Bluetooth off");
                    SifliDFUService.this.mError = 74;
                    SifliDFUService.this.mBleHandler.removeMessages(1);
                    synchronized (SifliDFUService.this.mLock) {
                        SifliDFUService.this.mLock.notifyAll();
                    }
                }
            }
        };
    }

    private BluetoothGattCallback getEmptyGattCallback() {
        return new BluetoothGattCallback() { // from class: com.sifli.siflidfu.SifliDFUService.4
            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
                if (bluetoothGattCharacteristic.getUuid().toString().equals(SifliDFUService.this.mWriteCharacteristic.getUuid().toString())) {
                    SifliDFUService.this.processNotify(bluetoothGattCharacteristic.getValue());
                    synchronized (SifliDFUService.this.mLock) {
                        SifliDFUService.this.mLock.notifyAll();
                    }
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
                if (i != 0 && SifliDFUService.this.mError == 0) {
                    Log.d(SifliDFUService.TAG, "write failed with " + i);
                    SifliDFUService.this.mWriteRetry = 1;
                }
                if (SifliDFUService.this.mIsLastPacket) {
                    SifliDFUService.this.mIsLastPacket = false;
                    SifliDFUService.this.mSendComplete = true;
                }
                SifliDFUService.this.mSendAvailable = true;
                synchronized (SifliDFUService.this.mLock) {
                    SifliDFUService.this.mLock.notifyAll();
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
                super.onConnectionStateChange(bluetoothGatt, i, i2);
                Log.d(SifliDFUService.TAG, "onConnectionStateChange status " + i + ", new state " + i2);
                if (i2 == 2) {
                    if (!SifliDFUService.this.misAlreadyConnect) {
                        SifliDFUService.this.misAlreadyConnect = true;
                    } else {
                        Log.e(SifliDFUService.TAG, "return for repeat");
                        return;
                    }
                } else if (i2 == 0) {
                    SifliDFUService.this.misAlreadyConnect = false;
                }
                if (i2 == 2) {
                    if (SifliDFUService.this.mConnectionState == 3) {
                        Log.e(SifliDFUService.TAG, "state is ready!");
                        return;
                    }
                    if (SifliDFUService.this.mDFUState.getState() == 2 || SifliDFUService.this.mDFUState.getState() == 10) {
                        SifliDFUService.this.mDFUState.setState(3);
                    }
                    SifliDFUService.this.mConnectionState = 2;
                    SifliDFUService.this.waitFor(1000L);
                    SifliDFUService.this.updateMtu(bluetoothGatt, 247);
                    SifliDFUService.this.waitFor(1000L);
                    SifliDFUService.this.updateLink(bluetoothGatt);
                    SifliDFUService.this.refreshDeviceCache(bluetoothGatt);
                    SifliDFUService.this.waitFor(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                    if (SifliDFUService.this.mError != 0) {
                        Log.d(SifliDFUService.TAG, "abort connect due to error");
                        if (Build.VERSION.SDK_INT >= 31 && ContextCompat.checkSelfPermission(SifliDFUService.this, "android.permission.BLUETOOTH_CONNECT") != 0) {
                            Log.e(SifliDFUService.TAG, "no Permission");
                            SifliDFUService.this.mError = 61;
                            synchronized (SifliDFUService.this.mLock) {
                                SifliDFUService.this.mLock.notifyAll();
                            }
                            return;
                        }
                        bluetoothGatt.close();
                        synchronized (SifliDFUService.this.mLock) {
                            SifliDFUService.this.mLock.notifyAll();
                        }
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 31 && ContextCompat.checkSelfPermission(SifliDFUService.this, "android.permission.BLUETOOTH_CONNECT") != 0) {
                        Log.e(SifliDFUService.TAG, "no Permission");
                        SifliDFUService.this.mError = 61;
                        synchronized (SifliDFUService.this.mLock) {
                            SifliDFUService.this.mLock.notifyAll();
                        }
                        return;
                    }
                    boolean discoverServices = bluetoothGatt.discoverServices();
                    SifliDFUService.this.mTimerHandler.postDelayed(SifliDFUService.this.mDiscoveryTimerRunnable, 40000L);
                    Log.i(SifliDFUService.TAG, "Attempting to start service discovery:" + discoverServices);
                    if (!discoverServices) {
                        SifliDFUService.this.mError = 66;
                    } else {
                        return;
                    }
                } else if (i2 == 0) {
                    Log.i(SifliDFUService.TAG, "disconnect with " + i);
                    SifliDFUService.this.sendLogBroadcast(5, "disconnect with " + i);
                    SifliDFUService.this.mConnectionStatus = i;
                    Log.i(SifliDFUService.TAG, "clear state");
                    SifliDFUService.this.mConnectionState = 0;
                    bluetoothGatt.close();
                    if (SifliDFUService.this.mDFUState.getState() == 2) {
                        Log.d(SifliDFUService.TAG, "disconnect remote reboot");
                    } else if (SifliDFUService.this.mDFUState.getState() != 9 && SifliDFUService.this.mDFUState.getState() != 10) {
                        SifliDFUService.this.mError = 70;
                    } else if (i != 133 && i != 62) {
                        SifliDFUService.this.mError = 70;
                    } else {
                        Log.w(SifliDFUService.TAG, "retry due to reboot connect 133");
                        SifliDFUService.this.mDFUState.setState(10);
                    }
                }
                synchronized (SifliDFUService.this.mLock) {
                    SifliDFUService.this.mLock.notifyAll();
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
                super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
                Log.i(SifliDFUService.TAG, "onDescriptorWrite");
                SifliDFUService.this.mIsDescriptorWrite = true;
                synchronized (SifliDFUService.this.mLock) {
                    SifliDFUService.this.mLock.notifyAll();
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
                Log.d(SifliDFUService.TAG, "onMtuChanged " + i + ", status " + i2);
                if (i > 247) {
                    SifliDFUService.this.mMaxPacketLen = 244;
                } else if (i < 23) {
                    SifliDFUService.this.mMaxPacketLen = 20;
                } else {
                    SifliDFUService.this.mMaxPacketLen = i - 3;
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
                super.onServicesDiscovered(bluetoothGatt, i);
                SifliDFUService.this.mTimerHandler.removeCallbacks(SifliDFUService.this.mDiscoveryTimerRunnable);
                int i2 = 0;
                if (i == 0) {
                    Log.d(SifliDFUService.TAG, "onServicesDiscovered");
                    int i3 = 0;
                    while (i2 < bluetoothGatt.getServices().size()) {
                        Iterator<BluetoothGattCharacteristic> it = bluetoothGatt.getServices().get(i2).getCharacteristics().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                BluetoothGattCharacteristic next = it.next();
                                Log.e(SifliDFUService.TAG, "find uuid: " + next.getUuid().toString() + ", expect: " + SerialTrans.SERIAL_TRAM_DATA);
                                if (next.getUuid().toString().equals(SerialTrans.SERIAL_TRAM_DATA)) {
                                    Log.i(SifliDFUService.TAG, "find serial trans UUID");
                                    SifliDFUService.this.mWriteCharacteristic = next;
                                    SifliDFUService.this.mConnectionState = 3;
                                    i3 = 1;
                                    break;
                                }
                            }
                        }
                        i2++;
                    }
                    i2 = i3;
                } else {
                    Log.w(SifliDFUService.TAG, "onServicesDiscovered received: " + i);
                    SifliDFUService.this.mError = 101;
                    SifliDFUService.this.mConnectionStatus = i;
                    SifliDFUService.this.mConnectionState = 4;
                    SifliDFUService sifliDFUService = SifliDFUService.this;
                    sifliDFUService.sendDfuStateChangeBroadcast(sifliDFUService.mError, i);
                }
                if (i2 == 0) {
                    Log.e(SifliDFUService.TAG, "fail to find target uuid");
                    SifliDFUService.this.sendLogBroadcast(20, "fail to find target uuid");
                    SifliDFUService.this.mError = 102;
                    SifliDFUService.this.mConnectionState = 4;
                    SifliDFUService sifliDFUService2 = SifliDFUService.this;
                    sifliDFUService2.sendDfuStateChangeBroadcast(sifliDFUService2.mError, i);
                }
                synchronized (SifliDFUService.this.mLock) {
                    SifliDFUService.this.mLock.notifyAll();
                }
            }
        };
    }

    private OTAFile getImageByID(ArrayList<OTAFile> arrayList, int i) {
        Iterator<OTAFile> it = arrayList.iterator();
        while (it.hasNext()) {
            OTAFile next = it.next();
            if (next.getImageID() == i) {
                return next;
            }
        }
        return null;
    }

    private int getNandUnCompressImageLength(int i) {
        int i2;
        Log.d(TAG, "image total len " + i);
        if (i % General.SIFLI_DFU_PACKET_BODY_LEN_NAND == 0) {
            i2 = i / General.SIFLI_DFU_PACKET_BODY_LEN_NAND;
        } else {
            i2 = (i / General.SIFLI_DFU_PACKET_BODY_LEN_NAND) + 1;
        }
        int i3 = i - (i2 * 36);
        Log.d(TAG, "imageLen " + i3);
        return i3;
    }

    private int getSendFileLength(ArrayList<OTAFile> arrayList, int i, int i2) {
        int fileLength;
        Iterator<OTAFile> it = arrayList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            OTAFile next = it.next();
            if (next.getFileIndex() < i) {
                if (next.getFileLength() % i2 == 0) {
                    fileLength = next.getFileLength() / i2;
                } else {
                    fileLength = (next.getFileLength() / i2) + 1;
                }
                i3 += fileLength;
            }
        }
        return i3;
    }

    private int getSendImageLength(ArrayList<OTAFile> arrayList, int i, int i2) {
        int fileLength;
        Iterator<OTAFile> it = arrayList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            OTAFile next = it.next();
            if (next.getImageID() != -1) {
                if (next.getImageID() >= i) {
                    break;
                }
                if (next.getFileLength() % i2 == 0) {
                    fileLength = next.getFileLength() / i2;
                } else {
                    fileLength = (next.getFileLength() / i2) + 1;
                }
                i3 += fileLength;
            }
        }
        return i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int handleActionDFUNand(java.lang.String r16, java.util.ArrayList<com.sifli.siflidfu.DFUImagePath> r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 905
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sifli.siflidfu.SifliDFUService.handleActionDFUNand(java.lang.String, java.util.ArrayList, int, int):int");
    }

    private int handleActionDFUNorV1(String str, ArrayList<DFUImagePath> arrayList, int i, int i2) {
        int i3;
        Log.d(TAG, "handleActionDFUNorV1");
        int init = init();
        this.mRspFreq = i2;
        if (init != 0) {
            return init;
        }
        HandlerThread handlerThread = new HandlerThread("BleWrite");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), new bleHandlerCallback());
        this.mBleHandler = handler;
        handler.removeCallbacksAndMessages(null);
        ArrayList<OTAFile> imageFile = FileProcess.getImageFile(arrayList, this, 1);
        String str2 = FileProcess.getmLogString();
        if (str2 != null) {
            sendLogBroadcast(5, str2);
        }
        if (imageFile == null) {
            return 60;
        }
        Collections.sort(imageFile, new OTAImageComparator());
        connectDevice(str, this.mGattCallback);
        if (this.mConnectionState == 3 && this.mError == 0) {
            retryCCCD(writeCCCD(this.mBluetoothGatt, this.mWriteCharacteristic));
            synchronized (this.mLock) {
                while (!this.mIsDescriptorWrite && this.mError == 0) {
                    try {
                        this.mLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.mTimerHandler.removeCallbacks(this.mWriteDescriptorTimerRunnable);
            int i4 = this.mError;
            if (i4 != 0) {
                return i4;
            }
            OTAFile imageByID = getImageByID(imageFile, -1);
            Objects.requireNonNull(imageByID);
            sendDfuImageInit(imageByID.getFileData(), i);
            int i5 = this.mError;
            if (i5 != 0) {
                return i5;
            }
            if (this.mRemoteBoot == 1) {
                this.mDFUState.setState(2);
            }
            if (i == 2) {
                sendDfuImageResumeComplete();
            } else {
                sendDfuImageInitComplete();
            }
            if (this.mRemoteBoot == 1) {
                Log.d(TAG, "wait reboot, mConnectionState " + this.mConnectionState);
                if (this.mConnectionState != 0) {
                    synchronized (this.mLock) {
                        while (this.mConnectionState != 0) {
                            try {
                                this.mLock.wait();
                            } catch (InterruptedException e2) {
                                throw new RuntimeException(e2);
                            }
                        }
                    }
                }
                this.mDFUState.setState(9);
                connectDevice(str, this.mGattCallback);
                if (this.mConnectionState == 3 && this.mError == 0) {
                    retryCCCD(writeCCCD(this.mBluetoothGatt, this.mWriteCharacteristic));
                    synchronized (this.mLock) {
                        while (!this.mIsDescriptorWrite && this.mError == 0) {
                            try {
                                this.mLock.wait();
                            } catch (InterruptedException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    this.mTimerHandler.removeCallbacks(this.mWriteDescriptorTimerRunnable);
                    int i6 = this.mError;
                    if (i6 != 0) {
                        return i6;
                    }
                } else {
                    return this.mError;
                }
            }
            if (i == 2) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            this.mProgressType = 0;
            this.countAll = getAllFileLength(imageFile, General.SIFLI_DFU_PACKET_BODY_LEN_NOR);
            int handleDFUImageSend = handleDFUImageSend(i3, imageFile, General.SIFLI_DFU_PACKET_BODY_LEN_NOR);
            Log.i(TAG, "send image end with " + handleDFUImageSend);
            if (handleDFUImageSend != 0) {
                return handleDFUImageSend;
            }
            Log.i(TAG, "wait end mode " + this.mWaitEndMode);
            int i7 = this.mWaitEndMode;
            if (i7 == 1) {
                sendDfuImageTransmissionEndWait();
            } else if (i7 == 0) {
                sendDfuImageTransmissionEnd();
            } else if (i7 == 2) {
                sendDfuImageTransmissionEndWait();
                sendDfuEndCommand(this.mError);
            }
            int i8 = this.mError;
            if (i8 != 0) {
                return i8;
            }
            return handleDFUImageSend;
        }
        return this.mError;
    }

    private int handleActionDFUNorV2(String str, ArrayList<DFUImagePath> arrayList, int i, int i2) {
        int i3;
        Log.d(TAG, "handleActionDFUNorV2");
        sendLogBroadcast(5, "OTA START");
        int init = init();
        this.mRspFreq = i2;
        if (init != 0) {
            return init;
        }
        HandlerThread handlerThread = new HandlerThread("BleWrite");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), new bleHandlerCallback());
        this.mBleHandler = handler;
        handler.removeCallbacksAndMessages(null);
        ArrayList<OTAFile> imageFile = FileProcess.getImageFile(arrayList, this, 1);
        String str2 = FileProcess.getmLogString();
        if (str2 != null) {
            sendLogBroadcast(5, str2);
        }
        if (imageFile == null) {
            return 60;
        }
        Collections.sort(imageFile, new OTAImageComparator());
        connectDevice(str, this.mGattCallback);
        if (this.mConnectionState == 3 && this.mError == 0) {
            retryCCCD(writeCCCD(this.mBluetoothGatt, this.mWriteCharacteristic));
            synchronized (this.mLock) {
                while (!this.mIsDescriptorWrite && this.mError == 0) {
                    try {
                        this.mLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.mTimerHandler.removeCallbacks(this.mWriteDescriptorTimerRunnable);
            int i4 = this.mError;
            if (i4 != 0) {
                return i4;
            }
            OTAFile imageByID = getImageByID(imageFile, -1);
            Objects.requireNonNull(imageByID);
            sendDfuImageInitExt(imageByID.getFileData());
            int i5 = this.mError;
            if (i5 != 0) {
                return i5;
            }
            if (this.mRemoteBoot == 1) {
                this.mDFUState.setState(2);
            }
            Log.d(TAG, "sendDfuImageInitComplete resumeMode " + i + ", remote resume " + this.mRemoteResume);
            if (i == 1 && this.mRemoteResume != 0) {
                Log.i(TAG, "sendDfuImageInitComplete use resume");
                i3 = 1;
            } else {
                i3 = 0;
            }
            sendDfuImageInitCompleteExt(i3);
            if (i3 == 1) {
                i3 = this.mRemoteResume;
            }
            if (this.mRemoteBoot == 1) {
                Log.d(TAG, "wait reboot, mConnectionState " + this.mConnectionState);
                if (this.mConnectionState != 0) {
                    synchronized (this.mLock) {
                        while (this.mConnectionState != 0) {
                            try {
                                this.mLock.wait();
                            } catch (InterruptedException e2) {
                                throw new RuntimeException(e2);
                            }
                        }
                    }
                }
                this.mDFUState.setState(9);
                connectDevice(str, this.mGattCallback);
                if (this.mConnectionState == 3 && this.mError == 0) {
                    retryCCCD(writeCCCD(this.mBluetoothGatt, this.mWriteCharacteristic));
                    synchronized (this.mLock) {
                        while (!this.mIsDescriptorWrite && this.mError == 0) {
                            try {
                                this.mLock.wait();
                            } catch (InterruptedException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    this.mTimerHandler.removeCallbacks(this.mWriteDescriptorTimerRunnable);
                    int i6 = this.mError;
                    if (i6 != 0) {
                        return i6;
                    }
                } else {
                    return this.mError;
                }
            }
            this.mProgressType = 0;
            this.countAll = getAllFileLength(imageFile, General.SIFLI_DFU_PACKET_BODY_LEN_NOR);
            handleDFUImageSend(i3, imageFile, General.SIFLI_DFU_PACKET_BODY_LEN_NOR);
            int i7 = this.mError;
            if (i7 != 0) {
                return i7;
            }
            Log.i(TAG, "wait end mode " + this.mWaitEndMode);
            int i8 = this.mWaitEndMode;
            if (i8 == 1) {
                sendDfuImageTransmissionEndWait();
            } else if (i8 == 0) {
                sendDfuImageTransmissionEnd();
            } else if (i8 == 2) {
                sendDfuImageTransmissionEndWait();
                int i9 = this.mError;
                if (i9 == 0) {
                    sendDfuEndCommand(i9);
                    waitFor(5000L);
                }
            }
            int i10 = this.mError;
            if (i10 != 0) {
                return i10;
            }
            return init;
        }
        return this.mError;
    }

    private int handleDFUFileSend(int i, ArrayList<OTAFile> arrayList) {
        int i2;
        if (i == 1) {
            Log.d(TAG, "enable resume");
            i2 = this.mRemoteResumeCount;
        } else {
            i2 = 0;
        }
        loop0: while (i2 < arrayList.size()) {
            OTAFile oTAFile = arrayList.get(i2);
            CurrentSendFile currentSendFile = new CurrentSendFile(oTAFile.getFileData(), 10240, oTAFile.getFileName());
            sendDfuFileStart(oTAFile.getFilePath(), currentSendFile.getTotalSize(), currentSendFile.getTotalCount(), oTAFile.getFileIndex());
            this.countPrevious = getSendFileLength(arrayList, oTAFile.getFileIndex(), 10240);
            this.countCurrent = 0;
            int i3 = this.mError;
            if (i3 != 0) {
                return i3;
            }
            int i4 = 0;
            boolean z = false;
            while (i4 < currentSendFile.getTotalCount()) {
                int i5 = i4 + 1;
                sendDfuFilePacket(i5, currentSendFile.getData(i4));
                if (currentSendFile.getTotalCount() == i5) {
                    z = true;
                }
                int i6 = this.mRspFreq;
                if (i6 != 0 && i5 % i6 == 0) {
                    z = true;
                }
                if (z) {
                    this.mRspReceive = false;
                    try {
                        synchronized (this.mLock) {
                            while (!this.mRspReceive && this.mError == 0) {
                                try {
                                    this.mLock.wait();
                                } catch (Throwable th) {
                                    throw th;
                                    break loop0;
                                }
                            }
                        }
                    } catch (InterruptedException unused) {
                        Log.e(TAG, "Sleeping interrupted");
                    }
                    int i7 = this.mError;
                    if (i7 != 0) {
                        if (i7 == 13) {
                            int i8 = this.mRemoteCurrentIndex;
                            this.countCurrent = i8;
                            i4 = i8 - 1;
                        } else {
                            Log.d(TAG, "download exit with " + this.mError);
                            return this.mError;
                        }
                    }
                    z = false;
                }
                i4++;
            }
            int i9 = this.mError;
            if (i9 != 0) {
                return i9;
            }
            sendDfuFileEnd(oTAFile.getFileIndex());
            int i10 = this.mError;
            if (i10 != 0) {
                return i10;
            }
            i2++;
        }
        return 0;
    }

    private int handleDFUImageSend(int i, ArrayList<OTAFile> arrayList, int i2) {
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        boolean z2;
        int i7 = 1;
        if (i == 1) {
            Log.d(TAG, "enable resume");
            i3 = this.mRemoteImageID;
            if (this.mRemoteResumeRestart == 1) {
                this.mRemoteResumeCount = 0;
            }
            this.mRspFreq = this.mRemoteResumeNumOfRsp;
            z = true;
        } else {
            i3 = 0;
            z = false;
        }
        int i8 = 2;
        if (i == 2) {
            Log.d(TAG, "resume query");
            i3 = this.mRemoteImageID;
            this.mRspFreq = this.mRemoteResumeNumOfRsp;
        }
        int i9 = i3;
        int i10 = 0;
        loop0: while (i10 < arrayList.size()) {
            OTAFile oTAFile = arrayList.get(i10);
            this.countPrevious = getSendImageLength(arrayList, oTAFile.getImageID(), i2);
            this.countCurrent = 0;
            if (oTAFile.getImageID() != -1) {
                if (i == i8 && oTAFile.getImageID() == i9) {
                    Log.d(TAG, "resume psram image id " + i9 + ", " + this.mRemoteResumeCount);
                    z = true;
                }
                if (z) {
                    if (oTAFile.getImageID() == i9) {
                        i4 = this.mRemoteResumeCount;
                        this.countCurrent = i4;
                        z = false;
                    }
                } else {
                    i4 = 0;
                }
                CurrentSendFile currentSendFile = new CurrentSendFile(oTAFile.getFileLength(), i2, oTAFile.getFileName());
                sendDfuImageStart(oTAFile.getFileLength(), currentSendFile.getTotalCount(), oTAFile.getImageID());
                int i11 = this.mError;
                if (i11 != 0) {
                    return i11;
                }
                if (this.mImageSkipInfo == i7) {
                    Log.i(TAG, "skip " + oTAFile.getImageID());
                } else {
                    int i12 = i4;
                    while (i12 < currentSendFile.getTotalCount()) {
                        int i13 = i12 + 1;
                        if (i13 == currentSendFile.getTotalCount()) {
                            i6 = FileProcess.getFileSize(oTAFile.getFilePath()) - (i12 * i2);
                            Log.d(TAG, "last packet " + i6);
                        } else {
                            i6 = i2;
                        }
                        this.mSendComplete = false;
                        sendDfuImagePacket(oTAFile.getImageID(), i13, FileProcess.openFilePartly(this, oTAFile.getFilePath(), i12 * i2, i6));
                        if (currentSendFile.getTotalCount() == i13) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (this.mError != 0) {
                            z2 = true;
                        }
                        int i14 = this.mRspFreq;
                        if (i14 != 0 && i13 % i14 == 0) {
                            z2 = true;
                        }
                        if (z2) {
                            this.mSendComplete = true;
                        }
                        if (z2) {
                            this.mRspReceive = false;
                        }
                        if (z2) {
                            try {
                                synchronized (this.mLock) {
                                    while (!this.mRspReceive && this.mError == 0) {
                                        try {
                                            this.mLock.wait();
                                        } catch (Throwable th) {
                                            throw th;
                                            break loop0;
                                        }
                                    }
                                }
                            } catch (InterruptedException unused) {
                                Log.e(TAG, "Sleeping interrupted");
                            }
                        } else {
                            try {
                                synchronized (this.mLock) {
                                    while (!this.mSendComplete && this.mError == 0) {
                                        try {
                                            this.mLock.wait();
                                        } catch (Throwable th2) {
                                            throw th2;
                                            break loop0;
                                        }
                                    }
                                }
                            } catch (InterruptedException unused2) {
                                Log.e(TAG, "Sleeping interrupted");
                            }
                        }
                        int i15 = this.mError;
                        if (i15 != 0) {
                            if (i15 == 13) {
                                int i16 = this.mRemoteCurrentIndex;
                                i12 = i16 - 1;
                                this.countCurrent = i16;
                                Log.d(TAG, "continue with index " + i12);
                                sendDfuLinkLoseResponse(0);
                                this.mError = 0;
                            } else {
                                Log.d(TAG, "download exit with " + this.mError);
                                return this.mError;
                            }
                        }
                        i12++;
                    }
                    int i17 = this.mError;
                    if (i17 != 0) {
                        return i17;
                    }
                    if (i10 + 1 != arrayList.size()) {
                        i5 = 1;
                    } else {
                        i5 = 0;
                    }
                    sendDfuImageEnd(oTAFile.getImageID(), i5);
                    i10++;
                    i7 = 1;
                    i8 = 2;
                }
            }
            i10++;
            i7 = 1;
            i8 = 2;
        }
        Log.d(TAG, "final progress " + (((this.countCurrent + this.countPrevious) * 100) / this.countAll) + " , always send");
        sendDFUProgressBroadcast(100, this.mProgressType);
        return 0;
    }

    private int init() {
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
        if (bluetoothManager == null) {
            Log.e(TAG, "Unable to initialize BluetoothManager.");
            return 62;
        }
        this.isReleased = false;
        BluetoothAdapter adapter = bluetoothManager.getAdapter();
        this.mBluetoothAdapter = adapter;
        if (adapter == null) {
            Log.e(TAG, "Unable to obtain a BluetoothAdapter.");
            return 62;
        }
        this.mDFUState = new DFUState();
        this.mGattCallback = getEmptyGattCallback();
        this.misAlreadyConnect = false;
        this.mRemoteVersion = 0;
        this.mWriteRetry = 0;
        this.mWriteRetryCount = 0;
        this.mIsLastPacket = false;
        this.mIsRemoteBoot = false;
        this.mWaitEndMode = 0;
        registerBleBroadcast();
        return 0;
    }

    public static boolean isDfuBusy() {
        ISifliDFUService iSifliDFUService = dfuService;
        if (iSifliDFUService == null) {
            return false;
        }
        return iSifliDFUService.isBusy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processNotify(byte[] bArr) {
        byte[] serialReceive = serialReceive(bArr);
        if (serialReceive != null && this.mLastCateID == 1) {
            int unsignedShortFromByteArray = Utils.getUnsignedShortFromByteArray(serialReceive, 0);
            int unsignedShortFromByteArray2 = Utils.getUnsignedShortFromByteArray(serialReceive, 2);
            switch (unsignedShortFromByteArray) {
                case 1:
                    Log.d(TAG, "receive init response len " + serialReceive.length);
                    this.mRspReceive = true;
                    int unsignedShortFromByteArray3 = Utils.getUnsignedShortFromByteArray(serialReceive, 4);
                    sendLogBroadcast(5, "image init response " + unsignedShortFromByteArray3);
                    sendDfuStateChangeBroadcast(unsignedShortFromByteArray, unsignedShortFromByteArray3);
                    if (unsignedShortFromByteArray3 != 0) {
                        Log.d(TAG, "receive init response " + unsignedShortFromByteArray3);
                        this.mError = unsignedShortFromByteArray3;
                        return;
                    }
                    byte b = serialReceive[6];
                    Log.d(TAG, "receive init response, result: " + unsignedShortFromByteArray3 + ", boot: " + ((int) b));
                    this.mRemoteBoot = b;
                    return;
                case 4:
                    Log.d(TAG, "receive resume response");
                    this.mRspReceive = true;
                    int unsignedShortFromByteArray4 = Utils.getUnsignedShortFromByteArray(serialReceive, 4);
                    sendDfuStateChangeBroadcast(unsignedShortFromByteArray, unsignedShortFromByteArray4);
                    if (unsignedShortFromByteArray4 != 0) {
                        this.mError = unsignedShortFromByteArray4;
                        return;
                    }
                    byte b2 = serialReceive[6];
                    this.mRemoteBoot = b2;
                    this.mRemoteResumeRestart = serialReceive[7];
                    Log.i(TAG, "resume message len " + unsignedShortFromByteArray2);
                    if (unsignedShortFromByteArray2 == 8) {
                        this.mRemoteResumeCount = Utils.getUnsignedShortFromByteArray(serialReceive, 8);
                        this.mRemoteImageID = serialReceive[10];
                        Log.i(TAG, "resume rsp, img id " + this.mRemoteImageID + ", img num " + this.mRemoteResumeCount);
                    } else if (unsignedShortFromByteArray2 == 12) {
                        this.mRemoteResumeCount = Utils.getIntFromByteArray(serialReceive, 8);
                        this.mRemoteImageID = serialReceive[12];
                        this.mRemoteResumeNumOfRsp = serialReceive[13];
                        Log.i(TAG, "resume rsp, img id " + this.mRemoteImageID + ", img num " + this.mRemoteResumeNumOfRsp + ",reply freq " + this.mRemoteResumeNumOfRsp);
                    } else {
                        Log.i(TAG, "fail to resume due to get data error");
                        this.mError = 71;
                        return;
                    }
                    Log.i(TAG, "resume rsp: boot " + ((int) b2) + ", resume restart " + this.mRemoteResumeRestart);
                    return;
                case 7:
                    int unsignedShortFromByteArray5 = Utils.getUnsignedShortFromByteArray(serialReceive, 4);
                    sendDfuStateChangeBroadcast(unsignedShortFromByteArray, unsignedShortFromByteArray5);
                    Log.d(TAG, "SIFLI_DFU_IMAGE_SEND_START_RESPONSE " + unsignedShortFromByteArray5);
                    sendLogBroadcast(5, "image start rsp " + unsignedShortFromByteArray5);
                    this.mRspReceive = true;
                    if (unsignedShortFromByteArray5 != 0) {
                        this.mError = unsignedShortFromByteArray5;
                        return;
                    }
                    if (serialReceive.length == 8) {
                        this.mWaitEndMode = serialReceive[6];
                        Log.d(TAG, "wait end mode " + this.mWaitEndMode);
                        this.mImageSkipInfo = serialReceive[7];
                        Log.w(TAG, "image skip " + this.mImageSkipInfo);
                        return;
                    }
                    return;
                case 9:
                    byte b3 = serialReceive[4];
                    Log.d(TAG, "DFU_IMAGE_END_RESPONSE " + ((int) b3));
                    sendLogBroadcast(5, "image end rsp " + ((int) b3));
                    sendDfuStateChangeBroadcast(unsignedShortFromByteArray, b3);
                    this.mRspReceive = true;
                    if (b3 != 0) {
                        this.mError = b3;
                        return;
                    }
                    return;
                case 11:
                    int unsignedShortFromByteArray6 = Utils.getUnsignedShortFromByteArray(serialReceive, 4);
                    Log.d(TAG, "DFU_IMAGE_PACKET_DATA_RESPONSE " + unsignedShortFromByteArray6);
                    sendDfuStateChangeBroadcast(unsignedShortFromByteArray, unsignedShortFromByteArray6);
                    this.mRspReceive = true;
                    if (unsignedShortFromByteArray6 != 0) {
                        this.mError = unsignedShortFromByteArray6;
                        return;
                    }
                    return;
                case 13:
                    byte b4 = serialReceive[4];
                    Log.d(TAG, "DFU_END " + ((int) b4));
                    sendDfuStateChangeBroadcast(unsignedShortFromByteArray, b4);
                    this.mRspReceive = true;
                    if (b4 != 0) {
                        this.mError = b4;
                        return;
                    }
                    return;
                case 22:
                    this.mRspReceive = true;
                    int unsignedShortFromByteArray7 = Utils.getUnsignedShortFromByteArray(serialReceive, 4);
                    sendDfuStateChangeBroadcast(unsignedShortFromByteArray, unsignedShortFromByteArray7);
                    Log.d(TAG, "processNotify: result " + unsignedShortFromByteArray7 + ", data len " + serialReceive.length);
                    StringBuilder sb = new StringBuilder();
                    sb.append("dfu file init rsp result ");
                    sb.append(unsignedShortFromByteArray7);
                    sendLogBroadcast(5, sb.toString());
                    if (unsignedShortFromByteArray7 != 0) {
                        this.mError = unsignedShortFromByteArray7;
                        return;
                    }
                    this.mRemoteResume = Utils.getUnsignedShortFromByteArray(serialReceive, 6);
                    this.mRemoteResumeCount = Utils.getIntFromByteArray(serialReceive, 8);
                    Log.e(TAG, "processNotify: init response " + unsignedShortFromByteArray7 + ", mode " + this.mRemoteResume + ", " + this.mRemoteResumeCount);
                    if (serialReceive.length >= 16) {
                        this.mRemoteVersion = serialReceive[12];
                        this.mFsBlock = Utils.getUnsignedShortFromByteArray(serialReceive, 14);
                        Log.d(TAG, "ver " + this.mRemoteVersion + ", fs block " + this.mFsBlock);
                        return;
                    }
                    return;
                case 25:
                    int unsignedShortFromByteArray8 = Utils.getUnsignedShortFromByteArray(serialReceive, 4);
                    sendDfuStateChangeBroadcast(unsignedShortFromByteArray, unsignedShortFromByteArray8);
                    this.mRspReceive = true;
                    if (unsignedShortFromByteArray8 != 0) {
                        this.mError = unsignedShortFromByteArray8;
                        return;
                    }
                    return;
                case 27:
                    int unsignedShortFromByteArray9 = Utils.getUnsignedShortFromByteArray(serialReceive, 4);
                    sendDfuStateChangeBroadcast(unsignedShortFromByteArray, unsignedShortFromByteArray9);
                    this.mRspReceive = true;
                    if (unsignedShortFromByteArray9 != 0) {
                        Log.e(TAG, "file packet result " + unsignedShortFromByteArray9);
                        this.mError = unsignedShortFromByteArray9;
                    }
                    this.mRspFreq = Utils.getUnsignedShortFromByteArray(serialReceive, 6);
                    this.mRemoteCurrentIndex = Utils.getIntFromByteArray(serialReceive, 8);
                    return;
                case 29:
                    int unsignedShortFromByteArray10 = Utils.getUnsignedShortFromByteArray(serialReceive, 4);
                    sendDfuStateChangeBroadcast(unsignedShortFromByteArray, unsignedShortFromByteArray10);
                    Log.d(TAG, "file end " + unsignedShortFromByteArray10);
                    this.mError = unsignedShortFromByteArray10;
                    this.mRspReceive = true;
                    return;
                case 31:
                    int unsignedShortFromByteArray11 = Utils.getUnsignedShortFromByteArray(serialReceive, 4);
                    sendDfuStateChangeBroadcast(unsignedShortFromByteArray, unsignedShortFromByteArray11);
                    Log.d(TAG, "file total end " + unsignedShortFromByteArray11);
                    sendLogBroadcast(5, "file total end " + unsignedShortFromByteArray11);
                    this.mError = unsignedShortFromByteArray11;
                    this.mRspReceive = true;
                    return;
                case 33:
                    this.mRspReceive = true;
                    Log.d(TAG, "data length " + serialReceive.length);
                    int unsignedShortFromByteArray12 = Utils.getUnsignedShortFromByteArray(serialReceive, 4);
                    Log.i(TAG, "dfu init rsp ext result " + unsignedShortFromByteArray12);
                    sendDfuStateChangeBroadcast(unsignedShortFromByteArray, unsignedShortFromByteArray12);
                    if (unsignedShortFromByteArray12 != 0) {
                        this.mError = unsignedShortFromByteArray12;
                        return;
                    }
                    this.mRemoteResume = serialReceive[6];
                    this.mRemoteResumeRestart = serialReceive[7];
                    this.mRemoteResumeCount = Utils.getIntFromByteArray(serialReceive, 8);
                    this.mRemoteImageID = serialReceive[12];
                    this.mRemoteResumeNumOfRsp = serialReceive[13];
                    this.mRemoteBoot = serialReceive[14];
                    Log.w(TAG, "remote dfu version " + ((int) serialReceive[15]));
                    Log.i(TAG, "dfu init rsp ext resume " + this.mRemoteResume + ", restart " + this.mRemoteResumeRestart);
                    Log.i(TAG, "dfu init rsp ext count " + this.mRemoteResumeCount + ", id " + this.mRemoteImageID + ", rsp " + this.mRemoteResumeNumOfRsp + ", boot " + this.mRemoteBoot);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("init rsp ext ");
                    sb2.append(unsignedShortFromByteArray12);
                    sendLogBroadcast(5, sb2.toString());
                    sendLogBroadcast(0, "dfu init rsp ext resume " + this.mRemoteResume + ", restart " + this.mRemoteResumeRestart);
                    sendLogBroadcast(0, "dfu init rsp ext count " + this.mRemoteResumeCount + ", id " + this.mRemoteImageID + ", rsp " + this.mRemoteResumeNumOfRsp + ", boot " + this.mRemoteBoot);
                    return;
                case 35:
                    sendDfuStateChangeBroadcast(unsignedShortFromByteArray, serialReceive[4]);
                    this.mRspFreq = Utils.getUnsignedShortFromByteArray(serialReceive, 6);
                    if (this.mRemoteCurrentIndex == Utils.getIntFromByteArray(serialReceive, 8) && System.currentTimeMillis() - this.mLoseCheckTime < ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
                        Log.w(TAG, "repeat message, ignore");
                        return;
                    }
                    this.mRemoteCurrentIndex = Utils.getIntFromByteArray(serialReceive, 8);
                    this.mLoseCheckTime = System.currentTimeMillis();
                    Log.e(TAG, "lost check at index " + this.mRemoteCurrentIndex);
                    this.mError = 13;
                    return;
                case 37:
                    int unsignedShortFromByteArray13 = Utils.getUnsignedShortFromByteArray(serialReceive, 4);
                    sendDfuStateChangeBroadcast(unsignedShortFromByteArray, unsignedShortFromByteArray13);
                    Log.d(TAG, "dfu abort with " + unsignedShortFromByteArray13);
                    sendLogBroadcast(5, "dfu abort " + unsignedShortFromByteArray13);
                    this.mError = unsignedShortFromByteArray13;
                    this.mRspReceive = true;
                    return;
                default:
                    return;
            }
        }
    }

    private void registerBleBroadcast() {
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        BroadcastReceiver bLEBroadcastReceiver = getBLEBroadcastReceiver();
        this.mBleBroadcastReceiver = bLEBroadcastReceiver;
        registerReceiver(bLEBroadcastReceiver, intentFilter);
    }

    private void release() {
        if (this.isReleased) {
            Log.d(TAG, "already released");
            return;
        }
        Log.i(TAG, "release");
        this.isReleased = true;
        BroadcastReceiver broadcastReceiver = this.mBleBroadcastReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
        if (Build.VERSION.SDK_INT >= 31 && ContextCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") != 0) {
            Log.e(TAG, "no Permission");
            this.mError = 61;
            synchronized (this.mLock) {
                this.mLock.notifyAll();
            }
            return;
        }
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt != null && this.mConnectionState != 0) {
            bluetoothGatt.disconnect();
            this.mBluetoothGatt.close();
        }
    }

    private void retryCCCD(int i) {
        if (i != 0) {
            if (i == 1) {
                this.mError = 77;
                return;
            }
            if (i == 2) {
                int i2 = 0;
                do {
                    i2++;
                    Log.i(TAG, "retry write cccd " + i2);
                    waitFor(((long) i2) * 500);
                    if (writeCCCD(this.mBluetoothGatt, this.mWriteCharacteristic) != 2) {
                        return;
                    }
                } while (i2 < 3);
            }
        }
    }

    private void sendDfuEndCommand(int i) {
        Log.i(TAG, "sendDfuEndCommand " + i);
        byte[] bArr = new byte[5];
        Utils.addShortToByteArray(13, bArr, 0);
        Utils.addShortToByteArray(1, bArr, 2);
        bArr[4] = (byte) i;
        sendToSerial(bArr, 0);
    }

    private void sendDfuFileEnd(int i) {
        Log.d(TAG, "sendDfuFileEnd");
        byte[] bArr = new byte[6];
        Utils.addShortToByteArray(28, bArr, 0);
        Utils.addShortToByteArray(2, bArr, 2);
        Utils.addShortToByteArray(i, bArr, 4);
        sendToSerial(bArr, 0);
        this.mRspReceive = false;
        this.mTimerHandler.postDelayed(this.mDfuCommandTimerRunnable, 60000L);
        try {
            synchronized (this.mLock) {
                while (!this.mRspReceive && this.mError == 0) {
                    try {
                        this.mLock.wait();
                    } finally {
                    }
                }
            }
        } catch (InterruptedException unused) {
            Log.e(TAG, "Sleeping interrupted");
        }
        this.mTimerHandler.removeCallbacks(this.mDfuCommandTimerRunnable);
    }

    private void sendDfuFileInit(int i, int i2) {
        Log.d(TAG, "sendDfuFileInit " + i + ", count " + i2);
        byte[] bArr = new byte[20];
        Utils.addShortToByteArray(21, bArr, 0);
        Utils.addShortToByteArray(16, bArr, 2);
        Utils.addIntToByteArray(i2, bArr, 4);
        Utils.addIntToByteArray(i, bArr, 8);
        Utils.addShortToByteArray(2, bArr, 12);
        Utils.addShortToByteArray(4, bArr, 14);
        Utils.addIntToByteArray(100, bArr, 16);
        sendToSerial(bArr, 0);
        this.mRspReceive = false;
        this.mTimerHandler.postDelayed(this.mDfuCommandTimerRunnable, 60000L);
        try {
            synchronized (this.mLock) {
                while (!this.mRspReceive && this.mError == 0) {
                    try {
                        this.mLock.wait();
                    } finally {
                    }
                }
            }
        } catch (InterruptedException unused) {
            Log.e(TAG, "Sleeping interrupted");
        }
        this.mTimerHandler.removeCallbacks(this.mDfuCommandTimerRunnable);
    }

    private void sendDfuFileInitComplete(int i) {
        Log.d(TAG, "sendDfuFileInitComplete");
        byte[] bArr = new byte[5];
        Utils.addShortToByteArray(23, bArr, 0);
        int i2 = 1;
        Utils.addShortToByteArray(1, bArr, 2);
        if (i == 1 && this.mRemoteResume == 1) {
            Log.e(TAG, "sendDfuFileInitComplete resume");
        } else {
            i2 = 0;
        }
        bArr[4] = (byte) i2;
        sendToSerial(bArr, 0);
    }

    private void sendDfuFilePacket(int i, byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 8];
        Utils.addShortToByteArray(26, bArr2, 0);
        Utils.addShortToByteArray(bArr.length + 4, bArr2, 2);
        Utils.addShortToByteArray(i, bArr2, 4);
        Utils.addShortToByteArray(bArr.length, bArr2, 6);
        System.arraycopy(bArr, 0, bArr2, 8, bArr.length);
        sendToSerial(bArr2, 1);
    }

    private void sendDfuFileStart(String str, int i, int i2, int i3) {
        Log.d(TAG, "sendDfuFileStart " + str + ", len " + i + ", count " + i2 + ", index " + i3);
        StringBuilder sb = new StringBuilder();
        sb.append("sendDfuFileStart freq ");
        sb.append(this.mRspFreq);
        Log.d(TAG, sb.toString());
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        byte[] bArr = new byte[bytes.length + 16];
        Utils.addShortToByteArray(24, bArr, 0);
        Utils.addShortToByteArray(bytes.length + 12, bArr, 2);
        Utils.addShortToByteArray(i3, bArr, 4);
        Utils.addShortToByteArray(this.mRspFreq, bArr, 6);
        Utils.addIntToByteArray(i, bArr, 8);
        Utils.addShortToByteArray(i2, bArr, 12);
        Utils.addShortToByteArray(bytes.length, bArr, 14);
        System.arraycopy(bytes, 0, bArr, 16, bytes.length);
        sendToSerial(bArr, 0);
        this.mRspReceive = false;
        this.mTimerHandler.postDelayed(this.mDfuCommandTimerRunnable, 120000L);
        try {
            synchronized (this.mLock) {
                while (!this.mRspReceive && this.mError == 0) {
                    try {
                        this.mLock.wait();
                    } finally {
                    }
                }
            }
        } catch (InterruptedException unused) {
            Log.e(TAG, "Sleeping interrupted");
        }
        this.mTimerHandler.removeCallbacks(this.mDfuCommandTimerRunnable);
    }

    private void sendDfuFileTotalEnd(int i) {
        Log.d(TAG, "sendDfuFileTotalEnd " + i);
        byte[] bArr = new byte[6];
        Utils.addShortToByteArray(30, bArr, 0);
        Utils.addShortToByteArray(2, bArr, 2);
        Utils.addShortToByteArray(i, bArr, 4);
        sendToSerial(bArr, 0);
        this.mRspReceive = false;
        this.mTimerHandler.postDelayed(this.mDfuCommandTimerRunnable, 60000L);
        try {
            synchronized (this.mLock) {
                while (!this.mRspReceive && this.mError == 0) {
                    try {
                        this.mLock.wait();
                    } finally {
                    }
                }
            }
        } catch (InterruptedException unused) {
            Log.e(TAG, "Sleeping interrupted");
        }
        this.mTimerHandler.removeCallbacks(this.mDfuCommandTimerRunnable);
    }

    private void sendDfuImageEnd(int i, int i2) {
        Log.i(TAG, "sendDfuImageEnd");
        sendLogBroadcast(5, "send dfu image end");
        byte[] bArr = new byte[6];
        Utils.addShortToByteArray(8, bArr, 0);
        Utils.addShortToByteArray(2, bArr, 2);
        bArr[4] = (byte) i;
        bArr[5] = (byte) i2;
        Log.d(TAG, "sendDfuImageEnd, id " + i + ",more image: " + i2);
        sendToSerial(bArr, 0);
        this.mRspReceive = false;
        this.mTimerHandler.postDelayed(this.mDfuCommandTimerRunnable, 180000L);
        try {
            synchronized (this.mLock) {
                while (!this.mRspReceive && this.mError == 0) {
                    try {
                        this.mLock.wait();
                    } finally {
                    }
                }
            }
        } catch (InterruptedException unused) {
            Log.e(TAG, "Sleeping interrupted");
        }
        this.mTimerHandler.removeCallbacks(this.mDfuCommandTimerRunnable);
    }

    private void sendDfuImageInit(byte[] bArr, int i) {
        int i2;
        if (bArr == null) {
            this.mError = 76;
            return;
        }
        Log.d(TAG, "sendDfuInit " + bArr.length + ", mode " + i);
        byte[] bArr2 = new byte[bArr.length + 4];
        if (i == 1) {
            i2 = 0;
        } else {
            i2 = 3;
            if (i != 2) {
                if (i != 3) {
                    Log.e(TAG, "error mode " + i);
                }
                i2 = 14;
            }
        }
        Utils.addShortToByteArray(i2, bArr2, 0);
        Utils.addShortToByteArray(bArr.length, bArr2, 2);
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        sendToSerial(bArr2, 0);
        this.mRspReceive = false;
        this.mTimerHandler.postDelayed(this.mDfuCommandTimerRunnable, 60000L);
        try {
            synchronized (this.mLock) {
                while (!this.mRspReceive && this.mError == 0) {
                    try {
                        this.mLock.wait();
                    } finally {
                    }
                }
            }
        } catch (InterruptedException unused) {
            Log.e(TAG, "Sleeping interrupted");
        }
        this.mTimerHandler.removeCallbacks(this.mDfuCommandTimerRunnable);
    }

    private void sendDfuImageInitComplete() {
        Log.i(TAG, "sendDfuImageInitComplete");
        byte[] bArr = new byte[5];
        Utils.addShortToByteArray(2, bArr, 0);
        Utils.addShortToByteArray(1, bArr, 2);
        bArr[4] = (byte) 1;
        sendToSerial(bArr, 0);
    }

    private void sendDfuImageInitCompleteExt(int i) {
        Log.i(TAG, "sendDfuImageInitCompleteExt");
        byte[] bArr = new byte[5];
        Utils.addShortToByteArray(34, bArr, 0);
        Utils.addShortToByteArray(1, bArr, 2);
        bArr[4] = (byte) i;
        sendToSerial(bArr, 0);
    }

    private void sendDfuImageInitExt(byte[] bArr) {
        if (bArr == null) {
            this.mError = 76;
            return;
        }
        Log.d(TAG, "sendDfuInitExt " + bArr.length);
        byte[] bArr2 = new byte[bArr.length + 4];
        Utils.addShortToByteArray(32, bArr2, 0);
        Utils.addShortToByteArray(bArr.length, bArr2, 2);
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        sendToSerial(bArr2, 0);
        this.mRspReceive = false;
        this.mTimerHandler.postDelayed(this.mDfuCommandTimerRunnable, 60000L);
        try {
            synchronized (this.mLock) {
                while (!this.mRspReceive && this.mError == 0) {
                    try {
                        this.mLock.wait();
                    } finally {
                    }
                }
            }
        } catch (InterruptedException unused) {
            Log.e(TAG, "Sleeping interrupted");
        }
        this.mTimerHandler.removeCallbacks(this.mDfuCommandTimerRunnable);
    }

    private void sendDfuImagePacket(int i, int i2, byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 10];
        Utils.addShortToByteArray(10, bArr2, 0);
        Utils.addShortToByteArray(bArr.length + 6, bArr2, 2);
        Utils.addShortToByteArray(i, bArr2, 4);
        Utils.addShortToByteArray(i2, bArr2, 6);
        Utils.addShortToByteArray(bArr.length, bArr2, 8);
        System.arraycopy(bArr, 0, bArr2, 10, bArr.length);
        sendToSerial(bArr2, 1);
    }

    private void sendDfuImageResumeComplete() {
        Log.i(TAG, "sendDfuImageResumeComplete");
        byte[] bArr = new byte[5];
        Utils.addShortToByteArray(5, bArr, 0);
        Utils.addShortToByteArray(1, bArr, 2);
        bArr[4] = (byte) 1;
        sendToSerial(bArr, 0);
    }

    private void sendDfuImageStart(int i, int i2, int i3) {
        Log.i(TAG, "send dfu start id " + i3 + ", count " + i2 + ", len " + i);
        StringBuilder sb = new StringBuilder();
        sb.append("IMG ID: ");
        sb.append(i3);
        sendLogBroadcast(5, sb.toString());
        byte[] bArr = new byte[14];
        Utils.addShortToByteArray(6, bArr, 0);
        Utils.addShortToByteArray(10, bArr, 2);
        Utils.addIntToByteArray(i, bArr, 4);
        Utils.addIntToByteArray(i2, bArr, 8);
        bArr[12] = (byte) this.mRspFreq;
        bArr[13] = (byte) i3;
        sendToSerial(bArr, 0);
        this.mRspReceive = false;
        this.mTimerHandler.postDelayed(this.mDfuCommandTimerRunnable, 180000L);
        try {
            synchronized (this.mLock) {
                while (!this.mRspReceive && this.mError == 0) {
                    try {
                        this.mLock.wait();
                    } finally {
                    }
                }
            }
        } catch (InterruptedException unused) {
            Log.e(TAG, "Sleeping interrupted");
        }
        this.mTimerHandler.removeCallbacks(this.mDfuCommandTimerRunnable);
    }

    private void sendDfuImageTransmissionEnd() {
        Log.i(TAG, "sendDfuImageTransmissionEnd");
        byte[] bArr = new byte[5];
        Utils.addShortToByteArray(12, bArr, 0);
        Utils.addShortToByteArray(1, bArr, 2);
        bArr[4] = 0;
        sendToSerial(bArr, 0);
    }

    private void sendDfuImageTransmissionEndWait() {
        Log.i(TAG, "sendDfuImageTransmissionEndWait");
        byte[] bArr = new byte[5];
        Utils.addShortToByteArray(12, bArr, 0);
        Utils.addShortToByteArray(1, bArr, 2);
        bArr[4] = 0;
        sendToSerial(bArr, 0);
        this.mRspReceive = false;
        this.mTimerHandler.postDelayed(this.mDfuCommandTimerRunnable, 60000L);
        try {
            synchronized (this.mLock) {
                while (!this.mRspReceive && this.mError == 0) {
                    try {
                        this.mLock.wait();
                    } finally {
                    }
                }
            }
        } catch (InterruptedException unused) {
            Log.e(TAG, "Sleeping interrupted");
        }
        this.mTimerHandler.removeCallbacks(this.mDfuCommandTimerRunnable);
    }

    private void sendDfuLinkLoseResponse(int i) {
        Log.e(TAG, "sendDfuLinkLoseResponse");
        byte[] bArr = new byte[6];
        Utils.addShortToByteArray(36, bArr, 0);
        Utils.addShortToByteArray(2, bArr, 2);
        Utils.addShortToByteArray(i, bArr, 4);
        sendToSerialExt(bArr, 0, false);
    }

    private void sendToBleHandler(byte[] bArr, int i, boolean z) {
        Message message = new Message();
        message.what = i;
        Bundle bundle = new Bundle();
        bundle.putByteArray(EXTRA_BLE_DATA, bArr);
        message.setData(bundle);
        if (z) {
            this.mBleHandler.sendMessageAtFrontOfQueue(message);
        } else {
            this.mBleHandler.sendMessage(message);
        }
    }

    private void sendToSerial(byte[] bArr, int i) {
        sendToSerialExt(bArr, i, false);
    }

    private void sendToSerialExt(byte[] bArr, int i, boolean z) {
        int length = bArr.length;
        int i2 = length + 4;
        if (i2 > 65535) {
            Log.e(TAG, "serial length over");
            return;
        }
        int i3 = this.mMaxPacketLen;
        if (i2 <= i3) {
            byte[] bArr2 = new byte[i2];
            bArr2[0] = 1;
            bArr2[1] = 0;
            Utils.addShortToByteArray(length, bArr2, 2);
            System.arraycopy(bArr, 0, bArr2, 4, length);
            sendToBleHandler(bArr2, i, z);
            return;
        }
        byte[] bArr3 = new byte[i3];
        bArr3[0] = 1;
        bArr3[1] = 1;
        Utils.addShortToByteArray(length, bArr3, 2);
        System.arraycopy(bArr, 0, bArr3, 4, this.mMaxPacketLen - 4);
        int i4 = this.mMaxPacketLen - 4;
        sendToBleHandler(bArr3, i, z);
        while (i4 < length) {
            int i5 = length - i4;
            int i6 = this.mMaxPacketLen;
            if (i5 > i6 - 2) {
                byte[] bArr4 = new byte[i6];
                bArr4[0] = 1;
                bArr4[1] = 2;
                System.arraycopy(bArr, i4, bArr4, 2, i6 - 2);
                i4 += this.mMaxPacketLen - 2;
                sendToBleHandler(bArr4, i, z);
            } else {
                byte[] bArr5 = new byte[i5 + 2];
                bArr5[0] = 1;
                bArr5[1] = 3;
                System.arraycopy(bArr, i4, bArr5, 2, i5);
                sendToBleHandler(bArr5, i, z);
                i4 = length;
            }
        }
    }

    private byte[] serialReceive(byte[] bArr) {
        this.mLastCateID = bArr[0];
        byte b = bArr[1];
        if (b == 0) {
            int unsignedShortFromByteArray = Utils.getUnsignedShortFromByteArray(bArr, 2);
            this.receiveDataLen = unsignedShortFromByteArray;
            byte[] bArr2 = new byte[unsignedShortFromByteArray];
            this.receiveData = bArr2;
            System.arraycopy(bArr, 4, bArr2, 0, unsignedShortFromByteArray);
            return this.receiveData;
        }
        if (b == 1) {
            this.receiveDataCurrentLen = 0;
            int unsignedShortFromByteArray2 = Utils.getUnsignedShortFromByteArray(bArr, 2);
            this.receiveDataLen = unsignedShortFromByteArray2;
            this.receiveData = new byte[unsignedShortFromByteArray2];
            Log.d(TAG, "receiveDataLen " + this.receiveDataLen);
            System.arraycopy(bArr, 4, this.receiveData, 0, bArr.length - 4);
            this.receiveDataCurrentLen = this.receiveDataCurrentLen + (bArr.length - 4);
            return null;
        }
        if (b == 2) {
            System.arraycopy(bArr, 2, this.receiveData, this.receiveDataCurrentLen, bArr.length - 2);
            this.receiveDataCurrentLen += bArr.length - 2;
            return null;
        }
        if (b == 3) {
            System.arraycopy(bArr, 2, this.receiveData, this.receiveDataCurrentLen, bArr.length - 2);
            int length = this.receiveDataCurrentLen + (bArr.length - 2);
            this.receiveDataCurrentLen = length;
            if (length != this.receiveDataLen) {
                Log.e(TAG, "length error, final: " + this.receiveDataCurrentLen + ", expect: " + this.receiveDataLen);
                return null;
            }
            Log.d(TAG, "receive finish");
            return this.receiveData;
        }
        return null;
    }

    public static void stop(Context context) {
        Log.i(TAG, "stop");
        context.stopService(new Intent(context, (Class<?>) SifliDFUService.class));
        dfuService = null;
    }

    private void updateLink() {
        Log.i(TAG, "update link");
        int i = Build.VERSION.SDK_INT;
        if (i >= 31 && ContextCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") != 0) {
            Log.e(TAG, "no Permission");
            this.mError = 61;
            synchronized (this.mLock) {
                this.mLock.notifyAll();
            }
            return;
        }
        this.mBluetoothGatt.requestConnectionPriority(1);
        waitFor(1000L);
        if (i >= 26) {
            this.mBluetoothGatt.setPreferredPhy(2, 2, 0);
        }
        waitFor(1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMtu(BluetoothGatt bluetoothGatt, int i) {
        if (Build.VERSION.SDK_INT >= 31 && ContextCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") != 0) {
            Log.e(TAG, "no Permission update mtu");
            this.mError = 61;
            synchronized (this.mLock) {
                this.mLock.notifyAll();
            }
            return;
        }
        bluetoothGatt.requestMtu(i);
    }

    private int writeCCCD(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (Build.VERSION.SDK_INT >= 31 && ContextCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") != 0) {
            Log.e(TAG, "no Permission");
            this.mError = 61;
            synchronized (this.mLock) {
                this.mLock.notifyAll();
            }
            return 1;
        }
        bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, true);
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb"));
        if (descriptor == null) {
            this.mError = 68;
            Log.e(TAG, "desc null!!!");
            return 1;
        }
        this.mIsDescriptorWrite = false;
        descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        Log.d(TAG, "Write descriptor");
        this.mTimerHandler.postDelayed(this.mWriteDescriptorTimerRunnable, 30000L);
        boolean writeDescriptor = bluetoothGatt.writeDescriptor(descriptor);
        Log.i(TAG, "write cccd " + writeDescriptor);
        if (writeDescriptor) {
            return 0;
        }
        return 2;
    }

    public void close(BluetoothGatt bluetoothGatt) {
        Log.d(TAG, "Cleaning up...");
        if (Build.VERSION.SDK_INT >= 31 && ContextCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") != 0) {
            this.mError = 61;
            synchronized (this.mLock) {
                this.mLock.notifyAll();
            }
            return;
        }
        if (bluetoothGatt != null) {
            Log.d(TAG, "gatt.disconnect()");
            bluetoothGatt.disconnect();
            Log.d(TAG, "gatt.close()");
            bluetoothGatt.close();
        }
        this.mConnectionState = 5;
    }

    @Override // com.sifli.siflidfu.ISifliDFUService
    public boolean isBusy() {
        return this.mIsBusy;
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return this.myBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate()");
        dfuService = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        release();
        Log.i(TAG, "onDestroy");
        dfuService = null;
    }

    public void onHandleIntent(Intent intent) {
        Log.i(TAG, "start with " + this.VersionStr);
        if (Customize.isCustomizeVersion()) {
            Log.i(TAG, "customize ver");
        }
        this.mIsBusy = true;
        if (intent != null) {
            String action = intent.getAction();
            if (ACTION_NOR_V1.equals(action)) {
                int handleActionDFUNorV1 = handleActionDFUNorV1(intent.getStringExtra(EXTRA_ADDRESS), intent.getParcelableArrayListExtra(EXTRA_IMAGES), intent.getIntExtra(EXTRA_RESUME_MODE, 0), intent.getIntExtra(EXTRA_NUM_OF_RSP, 0));
                try {
                    Thread.sleep(5000L);
                    Log.w(TAG, "nor ota end with " + handleActionDFUNorV1);
                    sendLogBroadcast(5, "DFU end with " + handleActionDFUNorV1);
                    sendDfuStateChangeBroadcast(100, handleActionDFUNorV1);
                    release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else if (ACTION_NOR_V2.equals(action)) {
                int handleActionDFUNorV2 = handleActionDFUNorV2(intent.getStringExtra(EXTRA_ADDRESS), intent.getParcelableArrayListExtra(EXTRA_IMAGES), intent.getIntExtra(EXTRA_RESUME_MODE, 0), intent.getIntExtra(EXTRA_NUM_OF_RSP, 0));
                try {
                    Thread.sleep(5000L);
                    Log.w(TAG, "end with " + handleActionDFUNorV2);
                    sendLogBroadcast(5, "DFU end with " + handleActionDFUNorV2);
                    sendDfuStateChangeBroadcast(100, handleActionDFUNorV2);
                    release();
                } catch (InterruptedException e2) {
                    throw new RuntimeException(e2);
                }
            } else if (ACTION_NAND.equals(action)) {
                int handleActionDFUNand = handleActionDFUNand(intent.getStringExtra(EXTRA_ADDRESS), intent.getParcelableArrayListExtra(EXTRA_IMAGES), intent.getIntExtra(EXTRA_RESUME_MODE, 0), intent.getIntExtra(EXTRA_NUM_OF_RSP, 0));
                Log.w(TAG, "end with " + handleActionDFUNand);
                sendLogBroadcast(5, "DFU end with " + handleActionDFUNand);
                sendDfuStateChangeBroadcast(100, handleActionDFUNand);
                release();
            }
        }
        this.mIsBusy = false;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        Log.d(TAG, "onStart()");
    }

    public void refreshDeviceCache(BluetoothGatt bluetoothGatt) {
        try {
            Log.i(TAG, "Refreshing result: " + ((Boolean) bluetoothGatt.getClass().getMethod("refresh", null).invoke(bluetoothGatt, null)).booleanValue());
        } catch (Exception e) {
            Log.e(TAG, "An exception occurred while refreshing device", e);
            sendLogBroadcast(15, "Refreshing failed");
        }
    }

    public void sendDFUProgressBroadcast(int i, int i2) {
        Intent intent = new Intent(BROADCAST_DFU_PROGRESS);
        intent.putExtra(EXTRA_DFU_PROGRESS, i);
        intent.putExtra(EXTRA_DFU_PROGRESS_TYPE, i2);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    public void sendDfuStateChangeBroadcast(int i, int i2) {
        Intent intent = new Intent(BROADCAST_DFU_STATE);
        intent.putExtra(EXTRA_DFU_STATE, i);
        intent.putExtra(EXTRA_DFU_STATE_RESULT, i2);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    public void sendLogBroadcast(int i, String str) {
        Intent intent = new Intent(BROADCAST_DFU_LOG);
        intent.putExtra(EXTRA_LOG_MESSAGE, "[DFU] " + str);
        intent.putExtra(EXTRA_LOG_LEVEL, i);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    @Override // com.sifli.siflidfu.ISifliDFUService
    public void startActionDFUNand(Context context, String str, ArrayList<DFUImagePath> arrayList, int i, int i2) {
        Log.i(TAG, "startActionDFUNand");
        if (isDfuBusy()) {
            Log.e(TAG, "SifliDfuService is busy!");
            return;
        }
        final Intent intent = new Intent(context, (Class<?>) SifliDFUService.class);
        intent.setAction(ACTION_NAND);
        intent.putExtra(EXTRA_ADDRESS, str);
        intent.putExtra(EXTRA_IMAGES, arrayList);
        intent.putExtra(EXTRA_RESUME_MODE, i);
        intent.putExtra(EXTRA_NUM_OF_RSP, i2);
        HandlerThread handlerThread = new HandlerThread("MyHandlerThread");
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(new Runnable() { // from class: com.sifli.siflidfu.SifliDFUService.3
            @Override // java.lang.Runnable
            public void run() {
                SifliDFUService.this.onHandleIntent(intent);
            }
        });
    }

    @Override // com.sifli.siflidfu.ISifliDFUService
    public void startActionDFUNor(Context context, String str, ArrayList<DFUImagePath> arrayList, int i, int i2) {
        Log.i(TAG, "startActionDFUNor");
        if (isDfuBusy()) {
            Log.e(TAG, "SifliDfuService is busy!");
            return;
        }
        final Intent intent = new Intent(context, (Class<?>) SifliDFUService.class);
        intent.setAction(ACTION_NOR_V1);
        intent.putExtra(EXTRA_ADDRESS, str);
        intent.putExtra(EXTRA_IMAGES, arrayList);
        intent.putExtra(EXTRA_RESUME_MODE, i);
        intent.putExtra(EXTRA_NUM_OF_RSP, i2);
        HandlerThread handlerThread = new HandlerThread("MyHandlerThread");
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(new Runnable() { // from class: com.sifli.siflidfu.SifliDFUService.1
            @Override // java.lang.Runnable
            public void run() {
                SifliDFUService.this.onHandleIntent(intent);
            }
        });
    }

    @Override // com.sifli.siflidfu.ISifliDFUService
    public void startActionDFUNorExt(Context context, String str, ArrayList<DFUImagePath> arrayList, int i, int i2) {
        Log.i(TAG, "startActionDFUNorExt");
        if (isDfuBusy()) {
            Log.e(TAG, "SifliDfuService is busy!");
            return;
        }
        final Intent intent = new Intent(context, (Class<?>) SifliDFUService.class);
        intent.setAction(ACTION_NOR_V2);
        intent.putExtra(EXTRA_ADDRESS, str);
        intent.putExtra(EXTRA_IMAGES, arrayList);
        intent.putExtra(EXTRA_RESUME_MODE, i);
        intent.putExtra(EXTRA_NUM_OF_RSP, i2);
        HandlerThread handlerThread = new HandlerThread("MyHandlerThread");
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(new Runnable() { // from class: com.sifli.siflidfu.SifliDFUService.2
            @Override // java.lang.Runnable
            public void run() {
                SifliDFUService.this.onHandleIntent(intent);
            }
        });
    }

    public void waitFor(long j) {
        synchronized (this.mLock) {
            try {
                sendLogBroadcast(0, "wait(" + j + oIX0oI.I0Io.f4095I0Io);
                this.mLock.wait(j);
            } catch (InterruptedException unused) {
                Log.e(TAG, "Sleeping interrupted");
            }
        }
    }

    private void sendDfuFileInitComplete(int i, int i2) {
        Log.d(TAG, "sendDfuFileInitComplete with block len");
        byte[] bArr = new byte[9];
        Utils.addShortToByteArray(23, bArr, 0);
        Utils.addShortToByteArray(5, bArr, 2);
        int i3 = 1;
        if (i == 1 && this.mRemoteResume == 1) {
            Log.e(TAG, "sendDfuFileInitComplete resume");
        } else {
            i3 = 0;
        }
        bArr[4] = (byte) i3;
        Utils.addIntToByteArray(i2, bArr, 5);
        sendToSerial(bArr, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLink(BluetoothGatt bluetoothGatt) {
        Log.i(TAG, "update link");
        int i = Build.VERSION.SDK_INT;
        if (i >= 31 && ContextCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") != 0) {
            Log.e(TAG, "no Permission");
            this.mError = 61;
            synchronized (this.mLock) {
                this.mLock.notifyAll();
            }
            return;
        }
        Log.i(TAG, "update parameter");
        bluetoothGatt.requestConnectionPriority(1);
        waitFor(1000L);
        if (i >= 26) {
            bluetoothGatt.setPreferredPhy(2, 2, 0);
        }
        waitFor(1000L);
    }
}
