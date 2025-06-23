package com.jieli.bluetooth_connect.impl;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.jieli.bluetooth_connect.bean.BluetoothOption;
import com.jieli.bluetooth_connect.bean.ErrorInfo;
import com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr;
import com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener;
import com.jieli.bluetooth_connect.tool.BrEdrEventCbManager;
import com.jieli.bluetooth_connect.util.BluetoothUtil;
import com.jieli.bluetooth_connect.util.ConnectUtil;
import com.jieli.bluetooth_connect.util.JL_Log;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class BluetoothBrEdr implements IBluetoothBrEdr {
    private static final int MSG_CONNECT_EDR_TIMEOUT = 26145;
    private static final String TAG = "BluetoothBrEdr";
    private volatile boolean isInitA2dp;
    private volatile boolean isInitHfp;
    private BluetoothA2dp mBluetoothA2dp;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothHandFreeReceiver mBluetoothHandFreeReceiver;
    private BluetoothHeadset mBluetoothHfp;
    private BluetoothOption mBluetoothOption;
    private final BluetoothPair mBluetoothPair;
    private final BrEdrEventCbManager mBrEdrEventCbManager;
    private volatile BluetoothDevice mConnectingEdr;
    private final Context mContext;
    private final OnBtDevicePairListener mOnBtDevicePairListener;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.bluetooth_connect.impl.I0Io
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            boolean lambda$new$0;
            lambda$new$0 = BluetoothBrEdr.this.lambda$new$0(message);
            return lambda$new$0;
        }
    });
    private final BluetoothProfile.ServiceListener mBTServiceListener = new BluetoothProfile.ServiceListener() { // from class: com.jieli.bluetooth_connect.impl.BluetoothBrEdr.1
        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int profile, BluetoothProfile proxy) {
            JL_Log.i(BluetoothBrEdr.TAG, "onServiceConnected", "profile = " + profile);
            if (2 == profile) {
                BluetoothBrEdr.this.mBluetoothA2dp = (BluetoothA2dp) proxy;
                BluetoothBrEdr.this.isInitA2dp = false;
            } else if (1 == profile) {
                BluetoothBrEdr.this.mBluetoothHfp = (BluetoothHeadset) proxy;
                BluetoothBrEdr.this.isInitHfp = false;
            }
            BluetoothBrEdr.this.mBrEdrEventCbManager.onEdrService(true, profile, proxy);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int profile) {
            JL_Log.i(BluetoothBrEdr.TAG, "onServiceDisconnected", "profile = " + profile);
            if (2 == profile) {
                BluetoothBrEdr.this.mBluetoothA2dp = null;
                BluetoothBrEdr.this.isInitA2dp = false;
            } else if (1 == profile) {
                BluetoothBrEdr.this.mBluetoothHfp = null;
                BluetoothBrEdr.this.isInitHfp = false;
            }
            BluetoothBrEdr.this.mBrEdrEventCbManager.onEdrService(false, profile, null);
        }
    };

    /* loaded from: classes10.dex */
    public class BluetoothHandFreeReceiver extends BroadcastReceiver {
        private BluetoothHandFreeReceiver() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action;
            BluetoothDevice bluetoothDevice;
            char c;
            if (intent == null || (action = intent.getAction()) == null || action.isEmpty() || (bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")) == null) {
                return;
            }
            switch (action.hashCode()) {
                case -855499628:
                    if (action.equals("android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -377527494:
                    if (action.equals("android.bluetooth.device.action.UUID")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 545516589:
                    if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1244161670:
                    if (action.equals("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 11);
                    JL_Log.i(BluetoothBrEdr.TAG, "A2DP#ACTION_PLAYING_STATE_CHANGED", "state : " + intExtra);
                    return;
                case 1:
                    Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("android.bluetooth.device.extra.UUID");
                    if (parcelableArrayExtra == null) {
                        BluetoothBrEdr.this.onDeviceUuids(bluetoothDevice, null);
                        JL_Log.i(BluetoothBrEdr.TAG, "ACTION_UUID", "no uuids");
                        return;
                    }
                    ParcelUuid[] parcelUuidArr = new ParcelUuid[parcelableArrayExtra.length];
                    for (int i = 0; i < parcelableArrayExtra.length; i++) {
                        ParcelUuid fromString = ParcelUuid.fromString(parcelableArrayExtra[i].toString());
                        parcelUuidArr[i] = fromString;
                        JL_Log.i(BluetoothBrEdr.TAG, "ACTION_UUID", fromString.toString());
                    }
                    BluetoothBrEdr.this.onDeviceUuids(bluetoothDevice, parcelUuidArr);
                    return;
                case 2:
                    try {
                        int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                        JL_Log.i(BluetoothBrEdr.TAG, "HFP#ACTION_CONNECTION_STATE_CHANGED", "device : " + BluetoothBrEdr.this.printDeviceInfo(bluetoothDevice) + ", state : " + intExtra2);
                        if (intExtra2 != -1) {
                            BluetoothBrEdr.this.onHfpStatus(bluetoothDevice, intExtra2);
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                case 3:
                    try {
                        int intExtra3 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                        JL_Log.i(BluetoothBrEdr.TAG, "A2DP#ACTION_CONNECTION_STATE_CHANGED", "device : " + BluetoothBrEdr.this.printDeviceInfo(bluetoothDevice) + ", state : " + intExtra3);
                        if (intExtra3 != -1) {
                            BluetoothBrEdr.this.onA2dpStatus(bluetoothDevice, intExtra3);
                            return;
                        }
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public BluetoothBrEdr(Context context, BluetoothPair bluetoothPair, OnBrEdrListener listener) {
        OnBtDevicePairListener onBtDevicePairListener = new OnBtDevicePairListener() { // from class: com.jieli.bluetooth_connect.impl.BluetoothBrEdr.2
            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener
            public void onAdapterStatus(boolean bEnabled, boolean bHasBle) {
                BluetoothDevice connectingBrEdrDevice;
                if (!bEnabled && (connectingBrEdrDevice = BluetoothBrEdr.this.getConnectingBrEdrDevice()) != null) {
                    BluetoothBrEdr.this.startConnectionTimeout(connectingBrEdrDevice, 0L);
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener
            @SuppressLint({"MissingPermission"})
            public void onBtDeviceBond(BluetoothDevice device, int status) {
                if (!BluetoothUtil.deviceEquals(device, BluetoothBrEdr.this.getConnectingBrEdrDevice())) {
                    return;
                }
                JL_Log.i(BluetoothBrEdr.TAG, "onBtDeviceBond", ConnectUtil.formatString("device : [%s], status : %d", BluetoothBrEdr.this.printDeviceInfo(device), Integer.valueOf(status)));
                if (status == 10) {
                    BluetoothBrEdr.this.onBrEdrConnection(device, 0);
                } else if (status == 12) {
                    if (ConnectUtil.isHasConnectPermission(BluetoothBrEdr.this.mContext) && device.getType() != 1) {
                        BluetoothBrEdr.this.tryToConnectBrEdr(device);
                    }
                    BluetoothBrEdr.this.startConnectionTimeout(device, 30000L);
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener
            public void onPairError(BluetoothDevice device, ErrorInfo error) {
                if (!BluetoothUtil.deviceEquals(device, BluetoothBrEdr.this.getConnectingBrEdrDevice())) {
                    return;
                }
                JL_Log.w(BluetoothBrEdr.TAG, "onPairError", ConnectUtil.formatString("device : [%s], error : %s", BluetoothBrEdr.this.printDeviceInfo(device), error));
                BluetoothBrEdr.this.onBrEdrConnection(device, 0);
            }
        };
        this.mOnBtDevicePairListener = onBtDevicePairListener;
        this.mContext = (Context) ConnectUtil.checkNotNull(context);
        BluetoothPair bluetoothPair2 = (BluetoothPair) ConnectUtil.checkNotNull(bluetoothPair);
        this.mBluetoothPair = bluetoothPair2;
        bluetoothPair2.addListener(onBtDevicePairListener);
        this.mBrEdrEventCbManager = new BrEdrEventCbManager();
        addListener(listener);
        initBrEdrService(context);
        registerReceiver();
    }

    private boolean checkA2dpBadEnv(String method, BluetoothDevice device) {
        if (device != null && ConnectUtil.isHasConnectPermission(this.mContext)) {
            if (this.mBluetoothA2dp == null) {
                JL_Log.w(TAG, method, "BluetoothA2dp is null");
                return true;
            }
            return false;
        }
        JL_Log.w(TAG, method, "device is null");
        return true;
    }

    private boolean checkHfpBadEnv(String method, BluetoothDevice device) {
        if (device != null && ConnectUtil.isHasConnectPermission(this.mContext)) {
            if (this.mBluetoothHfp == null) {
                JL_Log.w(TAG, method, "BluetoothHfp is null");
                return true;
            }
            return false;
        }
        JL_Log.w(TAG, method, "device is null");
        return true;
    }

    private void initBrEdrService(Context context) {
        if (context == null) {
            return;
        }
        android.bluetooth.BluetoothManager bluetoothManager = (android.bluetooth.BluetoothManager) context.getSystemService("bluetooth");
        if (bluetoothManager != null) {
            this.mBluetoothAdapter = bluetoothManager.getAdapter();
        }
        if (this.mBluetoothAdapter == null) {
            this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        if (this.mBluetoothAdapter == null) {
            JL_Log.w(TAG, "initBrEdrService", "The device does not support Bluetooth.");
            return;
        }
        if (this.mBluetoothA2dp == null && !this.isInitA2dp) {
            try {
                this.isInitA2dp = this.mBluetoothAdapter.getProfileProxy(context, this.mBTServiceListener, 2);
                if (!this.isInitA2dp) {
                    JL_Log.w(TAG, "initBrEdrService", "getProfileProxy: a2dp error.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.mBluetoothHfp == null && !this.isInitHfp) {
            try {
                this.isInitHfp = this.mBluetoothAdapter.getProfileProxy(context, this.mBTServiceListener, 1);
                if (!this.isInitHfp) {
                    JL_Log.w(TAG, "initBrEdrService", "getProfileProxy: hfp error");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(Message message) {
        if (message.what == MSG_CONNECT_EDR_TIMEOUT) {
            Object obj = message.obj;
            if (!(obj instanceof BluetoothDevice)) {
                return false;
            }
            BluetoothDevice bluetoothDevice = (BluetoothDevice) obj;
            JL_Log.i(TAG, "MSG_CONNECT_EDR_TIMEOUT", "connectingDev : " + printDeviceInfo(bluetoothDevice));
            if (isConnectedByProfile(bluetoothDevice) != 2) {
                onBrEdrConnection(bluetoothDevice, 0);
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onA2dpStatus(BluetoothDevice device, int status) {
        String str = TAG;
        JL_Log.d(str, "onA2dpStatus", ConnectUtil.formatString("device : [%s], status : %s", printDeviceInfo(device), BluetoothUtil.connectionString(status)));
        this.mBrEdrEventCbManager.onA2dpStatus(device, status);
        if (status == 0) {
            onBrEdrConnection(device, 0);
            return;
        }
        if (status == 2) {
            onBrEdrConnection(device, 2);
            int isConnectedByHfp = isConnectedByHfp(device);
            JL_Log.i(str, "onA2dpStatus", "a2dp is connected, hfp status = " + BluetoothUtil.connectionString(isConnectedByHfp));
            if (isConnectedByHfp != 2) {
                connectByProfiles(device);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBrEdrConnection(BluetoothDevice device, int status) {
        JL_Log.d(TAG, "onBrEdrConnection", ConnectUtil.formatString("device : [%s], status : %s", printDeviceInfo(device), BluetoothUtil.connectionString(status)));
        if (status != 1 && BluetoothUtil.deviceEquals(device, getConnectingBrEdrDevice())) {
            setConnectingEdr(null);
            this.mHandler.removeMessages(MSG_CONNECT_EDR_TIMEOUT);
        }
        this.mBrEdrEventCbManager.onBrEdrConnection(device, status);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDeviceUuids(BluetoothDevice device, ParcelUuid[] uuids) {
        this.mBrEdrEventCbManager.onDeviceUuids(device, uuids);
        if (BluetoothUtil.deviceEquals(device, getConnectingBrEdrDevice()) && !connectByProfiles(device)) {
            onBrEdrConnection(device, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHfpStatus(BluetoothDevice device, int status) {
        String str = TAG;
        JL_Log.d(str, "onHfpStatus", ConnectUtil.formatString("device : [%s], status : %s", printDeviceInfo(device), BluetoothUtil.connectionString(status)));
        this.mBrEdrEventCbManager.onHfpStatus(device, status);
        if (status == 0) {
            onBrEdrConnection(device, 0);
            return;
        }
        if (status == 2) {
            int isConnectedByA2dp = isConnectedByA2dp(device);
            JL_Log.i(str, "onHfpStatus", "hfp is connected, a2dp status = " + BluetoothUtil.connectionString(isConnectedByA2dp));
            if (isConnectedByA2dp != 2) {
                connectByProfiles(device);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String printDeviceInfo(BluetoothDevice device) {
        return BluetoothUtil.printBtDeviceInfo(this.mContext, device);
    }

    private void registerReceiver() {
        if (this.mBluetoothHandFreeReceiver == null) {
            this.mBluetoothHandFreeReceiver = new BluetoothHandFreeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.device.action.UUID");
            intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
            this.mContext.registerReceiver(this.mBluetoothHandFreeReceiver, intentFilter);
        }
    }

    private void setConnectingEdr(BluetoothDevice device) {
        this.mConnectingEdr = device;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startConnectionTimeout(BluetoothDevice device, long delay) {
        this.mHandler.removeMessages(MSG_CONNECT_EDR_TIMEOUT);
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(MSG_CONNECT_EDR_TIMEOUT, device), delay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public boolean tryToConnectBrEdr(BluetoothDevice device) {
        boolean fetchUuidsWithSdp;
        String str;
        if (device == null) {
            return false;
        }
        if (device.getUuids() != null && device.getUuids().length != 0 && (BluetoothUtil.deviceHasA2dp(this.mContext, device) || BluetoothUtil.deviceHasHfp(this.mContext, device))) {
            fetchUuidsWithSdp = connectByProfiles(device);
            str = "connectByProfiles";
        } else {
            fetchUuidsWithSdp = device.fetchUuidsWithSdp();
            str = "fetchUuidsWithSdp";
        }
        if (!fetchUuidsWithSdp) {
            onBrEdrConnection(device, 0);
            JL_Log.w(TAG, "tryToConnectBrEdr", str + " failed.");
        } else {
            JL_Log.i(TAG, "tryToConnectBrEdr", str + " success.");
        }
        return fetchUuidsWithSdp;
    }

    private void unregisterReceiver() {
        BluetoothHandFreeReceiver bluetoothHandFreeReceiver = this.mBluetoothHandFreeReceiver;
        if (bluetoothHandFreeReceiver != null) {
            this.mContext.unregisterReceiver(bluetoothHandFreeReceiver);
            this.mBluetoothHandFreeReceiver = null;
        }
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    @SuppressLint({"MissingPermission"})
    public boolean connectBrEdrDevice(BluetoothDevice device) {
        if (device != null && ConnectUtil.isHasConnectPermission(this.mContext)) {
            BluetoothDevice connectingBrEdrDevice = getConnectingBrEdrDevice();
            if (connectingBrEdrDevice != null) {
                JL_Log.w(TAG, "connectBrEdrDevice", "Classic device is connecting. connecting device : " + printDeviceInfo(connectingBrEdrDevice));
                return false;
            }
            setConnectingEdr(device);
            boolean isPaired = this.mBluetoothPair.isPaired(device);
            String str = TAG;
            JL_Log.d(str, "connectBrEdrDevice", "isPaired : " + isPaired);
            if (!isPaired) {
                boolean tryToPair = this.mBluetoothPair.tryToPair(device);
                JL_Log.d(str, "connectBrEdrDevice", "tryToPair : " + tryToPair);
                if (!tryToPair) {
                    onBrEdrConnection(device, 0);
                    return false;
                }
            } else if (!tryToConnectBrEdr(device)) {
                return false;
            }
            onBrEdrConnection(device, 1);
            startConnectionTimeout(device, 40000L);
            JL_Log.d(str, "connectBrEdrDevice", "Start connecting classic Bluetooth.");
            return true;
        }
        JL_Log.w(TAG, "connectBrEdrDevice", "device is null.");
        return false;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    public boolean connectByA2dp(BluetoothDevice device) {
        if (checkA2dpBadEnv("connectByA2dp", device)) {
            return false;
        }
        int isConnectedByA2dp = isConnectedByA2dp(device);
        String str = TAG;
        JL_Log.i(str, "connectByA2dp", "deviceA2dpStatus : " + BluetoothUtil.connectionString(isConnectedByA2dp));
        if (isConnectedByA2dp == 1) {
            JL_Log.d(str, "connectByA2dp", "A2DP is connecting.");
            return true;
        }
        if (isConnectedByA2dp != 2) {
            boolean connectDeviceA2dp = BluetoothUtil.connectDeviceA2dp(this.mContext, this.mBluetoothA2dp, device);
            JL_Log.i(str, "connectByA2dp", "ret : " + connectDeviceA2dp);
            return connectDeviceA2dp;
        }
        onA2dpStatus(device, isConnectedByA2dp);
        return true;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    public boolean connectByHfp(BluetoothDevice device) {
        if (checkHfpBadEnv("connectByHfp", device)) {
            return false;
        }
        if (!BluetoothUtil.deviceHasHfp(this.mContext, device)) {
            JL_Log.w(TAG, "connectByHfp", "no found hfp service");
            return false;
        }
        int isConnectedByHfp = isConnectedByHfp(device);
        String str = TAG;
        JL_Log.d(str, "connectByHfp", "deviceHfpStatus : " + BluetoothUtil.connectionString(isConnectedByHfp));
        if (isConnectedByHfp != 1) {
            if (isConnectedByHfp != 2) {
                boolean connectDeviceHfp = BluetoothUtil.connectDeviceHfp(this.mContext, this.mBluetoothHfp, device);
                JL_Log.d(str, "connectByHfp", "ret : " + connectDeviceHfp);
                return connectDeviceHfp;
            }
            onHfpStatus(device, isConnectedByHfp);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0084, code lost:
    
        if (r3 != 3) goto L32;
     */
    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean connectByProfiles(android.bluetooth.BluetoothDevice r9) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jieli.bluetooth_connect.impl.BluetoothBrEdr.connectByProfiles(android.bluetooth.BluetoothDevice):boolean");
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void destroy() {
        setConnectingEdr(null);
        this.mHandler.removeCallbacksAndMessages(null);
        this.mBluetoothPair.removeListener(this.mOnBtDevicePairListener);
        this.mBrEdrEventCbManager.destroy();
        unregisterReceiver();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    @SuppressLint({"MissingPermission"})
    public boolean disconnectByProfiles(BluetoothDevice device) {
        boolean z;
        if (device != null && ConnectUtil.isHasConnectPermission(this.mContext)) {
            String str = TAG;
            JL_Log.d(str, "disconnectByProfiles", "device : " + printDeviceInfo(device));
            int isConnectedByA2dp = isConnectedByA2dp(device);
            if (isConnectedByA2dp == 2) {
                z = disconnectFromA2dp(device);
            } else {
                z = false;
            }
            int isConnectedByHfp = isConnectedByHfp(device);
            if (isConnectedByHfp == 2) {
                z = disconnectFromHfp(device);
            }
            if (isConnectedByA2dp == 0 && isConnectedByHfp == 0) {
                onBrEdrConnection(device, 0);
                z = true;
            }
            JL_Log.d(str, "disconnectByProfiles", "ret :  " + z);
            return z;
        }
        JL_Log.w(TAG, "disconnectByProfiles", "device is null");
        return false;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    public boolean disconnectFromA2dp(BluetoothDevice device) {
        if (checkA2dpBadEnv("disconnectFromA2dp", device)) {
            return false;
        }
        int isConnectedByA2dp = isConnectedByA2dp(device);
        String str = TAG;
        JL_Log.d(str, "disconnectFromA2dp", "deviceA2dpStatus : " + BluetoothUtil.connectionString(isConnectedByA2dp));
        if (isConnectedByA2dp == 1) {
            JL_Log.d(str, "disconnectFromA2dp", "A2DP is connecting.");
            return false;
        }
        if (isConnectedByA2dp != 2) {
            onA2dpStatus(device, 0);
            return true;
        }
        boolean disconnectDeviceA2dp = BluetoothUtil.disconnectDeviceA2dp(this.mContext, this.mBluetoothA2dp, device);
        JL_Log.d(str, "disconnectFromA2dp", "ret : " + disconnectDeviceA2dp);
        return disconnectDeviceA2dp;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    public boolean disconnectFromHfp(BluetoothDevice device) {
        if (checkHfpBadEnv("disconnectFromHfp", device)) {
            return false;
        }
        int isConnectedByHfp = isConnectedByHfp(device);
        String str = TAG;
        JL_Log.d(str, "disconnectFromHfp", "deviceHfpStatus : " + BluetoothUtil.connectionString(isConnectedByHfp));
        if (isConnectedByHfp == 1) {
            JL_Log.d(str, "disconnectFromHfp", "HFP is connecting.");
            return false;
        }
        if (isConnectedByHfp != 2) {
            onHfpStatus(device, 0);
            return true;
        }
        boolean disconnectDeviceHfp = BluetoothUtil.disconnectDeviceHfp(this.mContext, this.mBluetoothHfp, device);
        JL_Log.d(str, "disconnectFromHfp", "ret : " + disconnectDeviceHfp);
        return disconnectDeviceHfp;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    public BluetoothDevice getActivityBluetoothDevice() {
        return BluetoothUtil.getActivityDevice(this.mContext, this.mBluetoothA2dp);
    }

    public BluetoothA2dp getBluetoothA2dp() {
        return this.mBluetoothA2dp;
    }

    public BluetoothHeadset getBluetoothHfp() {
        return this.mBluetoothHfp;
    }

    public BluetoothPair getBluetoothPair() {
        return this.mBluetoothPair;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    public BluetoothDevice getConnectingBrEdrDevice() {
        return this.mConnectingEdr;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    public boolean isBrEdrConnecting() {
        if (getConnectingBrEdrDevice() != null) {
            return true;
        }
        return false;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    @SuppressLint({"MissingPermission"})
    public int isConnectedByA2dp(BluetoothDevice device) {
        if (checkA2dpBadEnv("isConnectedByA2dp", device)) {
            return 0;
        }
        List<BluetoothDevice> connectedDevices = this.mBluetoothA2dp.getConnectedDevices();
        if (connectedDevices != null) {
            Iterator<BluetoothDevice> it = connectedDevices.iterator();
            while (it.hasNext()) {
                if (it.next().getAddress().equals(device.getAddress())) {
                    return 2;
                }
            }
        }
        return this.mBluetoothA2dp.getConnectionState(device);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    @SuppressLint({"MissingPermission"})
    public int isConnectedByHfp(BluetoothDevice device) {
        if (checkHfpBadEnv("isConnectedByHfp", device)) {
            return 0;
        }
        List<BluetoothDevice> connectedDevices = this.mBluetoothHfp.getConnectedDevices();
        if (connectedDevices != null) {
            Iterator<BluetoothDevice> it = connectedDevices.iterator();
            while (it.hasNext()) {
                if (it.next().getAddress().equals(device.getAddress())) {
                    return 2;
                }
            }
        }
        return this.mBluetoothHfp.getConnectionState(device);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    @SuppressLint({"MissingPermission"})
    public int isConnectedByProfile(BluetoothDevice device) {
        int isConnectedByA2dp;
        int i;
        BluetoothOption bluetoothOption = this.mBluetoothOption;
        if ((bluetoothOption == null || bluetoothOption.isSupportA2DP()) && BluetoothUtil.deviceHasA2dp(this.mContext, device)) {
            isConnectedByA2dp = isConnectedByA2dp(device);
        } else {
            isConnectedByA2dp = 0;
        }
        if (isConnectedByA2dp == 2) {
            return isConnectedByA2dp;
        }
        if (BluetoothUtil.deviceHasHfp(this.mContext, device)) {
            i = isConnectedByHfp(device);
        } else {
            i = 0;
        }
        if (i != 2) {
            return 0;
        }
        return i;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBrEdr
    @SuppressLint({"MissingPermission"})
    public boolean setActivityBluetoothDevice(BluetoothDevice device) {
        List<BluetoothDevice> connectedDevices;
        if (((device != null && this.mBluetoothA2dp != null) || !ConnectUtil.isHasConnectPermission(this.mContext)) && (connectedDevices = this.mBluetoothA2dp.getConnectedDevices()) != null && connectedDevices.contains(device)) {
            return BluetoothUtil.setActivityDevice(this.mContext, this.mBluetoothA2dp, device);
        }
        return false;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void setBluetoothOption(BluetoothOption option) {
        this.mBluetoothOption = option;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void addListener(OnBrEdrListener listener) {
        this.mBrEdrEventCbManager.addListener(listener);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void removeListener(OnBrEdrListener listener) {
        this.mBrEdrEventCbManager.removeListener(listener);
    }

    public boolean connectByA2dp(String address) {
        return connectByA2dp(BluetoothUtil.getRemoteDevice(this.mContext, address));
    }

    public boolean disconnectFromA2dp(String address) {
        return disconnectFromA2dp(BluetoothUtil.getRemoteDevice(this.mContext, address));
    }

    public boolean disconnectFromHfp(String address) {
        return disconnectFromHfp(BluetoothUtil.getRemoteDevice(this.mContext, address));
    }

    public boolean connectByHfp(String address) {
        return connectByHfp(BluetoothUtil.getRemoteDevice(this.mContext, address));
    }
}
