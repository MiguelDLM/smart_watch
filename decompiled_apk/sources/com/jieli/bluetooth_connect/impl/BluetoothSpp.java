package com.jieli.bluetooth_connect.impl;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.jieli.bluetooth_connect.bean.BluetoothOption;
import com.jieli.bluetooth_connect.bean.ErrorInfo;
import com.jieli.bluetooth_connect.constant.BluetoothConstant;
import com.jieli.bluetooth_connect.interfaces.IBluetoothSpp;
import com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtSppListener;
import com.jieli.bluetooth_connect.tool.ReceiveSppDataThread;
import com.jieli.bluetooth_connect.tool.SppEventCbManager;
import com.jieli.bluetooth_connect.util.BluetoothUtil;
import com.jieli.bluetooth_connect.util.CHexConverter;
import com.jieli.bluetooth_connect.util.ConnectUtil;
import com.jieli.bluetooth_connect.util.JL_Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes10.dex */
public class BluetoothSpp implements IBluetoothSpp {
    private static final int DELAY_TIME = 1000;
    private static final int MSG_CONNECT_SPP = 41014;
    private static final int MSG_CONNECT_SPP_TIMEOUT = 41013;
    private static final int MSG_WAIT_SYSTEM_CONNECT_EDR_TIMEOUT = 41015;
    private static final String TAG = "BluetoothSpp";
    private static final int WAIT_TIMEOUT = 3000;
    private final BluetoothBrEdr mBluetoothBrEdr;
    private BluetoothOption mBluetoothOption;
    private final BluetoothPair mBluetoothPair;
    private volatile BluetoothDevice mConnectedSppDevice;
    private volatile BluetoothDevice mConnectingSppDevice;
    private ConnectionSppThread mConnectionSppThread;
    private final Context mContext;
    private final OnBrEdrListener mOnBrEdrListener;
    private final OnBtDevicePairListener mOnBtDevicePairListener;
    private final ReceiveSppDataThread.OnRecvSppDataListener mOnRecvSppDataListener;
    private final SppEventCbManager mSppEventCbManager;
    private BluetoothSppReceiver mSppReceiver;
    private final List<BluetoothDevice> mConnectedSppDevices = Collections.synchronizedList(new ArrayList());
    private final Map<String, BluetoothSocket> mSppSocketMap = Collections.synchronizedMap(new HashMap());
    private final Map<String, ReceiveSppDataThread> mSppRecvThreadMap = Collections.synchronizedMap(new HashMap());
    private final ExecutorService mThreadPool = Executors.newFixedThreadPool(8);
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.bluetooth_connect.impl.BluetoothSpp.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case BluetoothSpp.MSG_CONNECT_SPP_TIMEOUT /* 41013 */:
                    BluetoothDevice bluetoothDevice = BluetoothSpp.this.mConnectingSppDevice;
                    JL_Log.d(BluetoothSpp.TAG, "MSG_CONNECT_SPP_TIMEOUT", "device : " + BluetoothSpp.this.printfDeviceInfo(bluetoothDevice));
                    if (bluetoothDevice != null && !BluetoothSpp.this.isConnectedSppDevice(bluetoothDevice)) {
                        BluetoothSpp.this.notifySppState(bluetoothDevice, 0);
                        return true;
                    }
                    return true;
                case BluetoothSpp.MSG_CONNECT_SPP /* 41014 */:
                    BluetoothDevice bluetoothDevice2 = BluetoothSpp.this.mConnectingSppDevice;
                    JL_Log.d(BluetoothSpp.TAG, "MSG_CONNECT_SPP", "device : " + BluetoothSpp.this.printfDeviceInfo(bluetoothDevice2));
                    if (bluetoothDevice2 != null) {
                        BluetoothSpp.this.startConnectSpp(bluetoothDevice2);
                        return true;
                    }
                    return true;
                case BluetoothSpp.MSG_WAIT_SYSTEM_CONNECT_EDR_TIMEOUT /* 41015 */:
                    BluetoothDevice bluetoothDevice3 = BluetoothSpp.this.mConnectingSppDevice;
                    JL_Log.d(BluetoothSpp.TAG, "MSG_WAIT_SYSTEM_CONNECT_EDR_TIMEOUT", "device : " + BluetoothSpp.this.printfDeviceInfo(bluetoothDevice3));
                    if (bluetoothDevice3 != null) {
                        BluetoothSpp.this.mHandler.sendEmptyMessage(BluetoothSpp.MSG_CONNECT_SPP);
                        return true;
                    }
                    return true;
                default:
                    return true;
            }
        }
    });

    /* loaded from: classes10.dex */
    public class BluetoothSppReceiver extends BroadcastReceiver {
        private BluetoothSppReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BluetoothDevice bluetoothDevice;
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action) && "android.bluetooth.device.action.UUID".equals(action) && (bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")) != null && ConnectUtil.isHasConnectPermission(context)) {
                Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("android.bluetooth.device.extra.UUID");
                if (parcelableArrayExtra == null) {
                    BluetoothSpp.this.handleDeviceUuids(bluetoothDevice, null);
                    JL_Log.i(BluetoothSpp.TAG, "ACTION_UUID", "no uuids");
                    return;
                }
                ParcelUuid[] parcelUuidArr = new ParcelUuid[parcelableArrayExtra.length];
                for (int i = 0; i < parcelableArrayExtra.length; i++) {
                    parcelUuidArr[i] = ParcelUuid.fromString(parcelableArrayExtra[i].toString());
                    JL_Log.i(BluetoothSpp.TAG, "ACTION_UUID", "uuid : " + parcelUuidArr[i].toString());
                }
                BluetoothSpp.this.handleDeviceUuids(bluetoothDevice, parcelUuidArr);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class ConnectionSppThread extends Thread {
        private static final String tag = "ConnectionThread";
        private final BluetoothDevice mDevice;

        /* JADX WARN: Removed duplicated region for block: B:18:0x00c4 A[Catch: all -> 0x0083, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x003a, B:7:0x0046, B:9:0x005e, B:12:0x0087, B:15:0x0097, B:18:0x00c4, B:22:0x00f4, B:24:0x011e, B:25:0x0125, B:27:0x0133, B:28:0x0154, B:31:0x00a0, B:34:0x015b), top: B:2:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00f4 A[Catch: all -> 0x0083, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x003a, B:7:0x0046, B:9:0x005e, B:12:0x0087, B:15:0x0097, B:18:0x00c4, B:22:0x00f4, B:24:0x011e, B:25:0x0125, B:27:0x0133, B:28:0x0154, B:31:0x00a0, B:34:0x015b), top: B:2:0x0001 }] */
        @Override // java.lang.Thread, java.lang.Runnable
        @android.annotation.SuppressLint({"MissingPermission"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public synchronized void run() {
            /*
                Method dump skipped, instructions count: 367
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jieli.bluetooth_connect.impl.BluetoothSpp.ConnectionSppThread.run():void");
        }

        private ConnectionSppThread(BluetoothDevice device) {
            super(tag);
            this.mDevice = device;
        }
    }

    public BluetoothSpp(Context context, BluetoothBrEdr bluetoothBrEdr, BluetoothOption option, OnBtSppListener listener) {
        OnBtDevicePairListener onBtDevicePairListener = new OnBtDevicePairListener() { // from class: com.jieli.bluetooth_connect.impl.BluetoothSpp.2
            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener
            public void onAdapterStatus(boolean bEnabled, boolean bHasBle) {
                if (!bEnabled) {
                    BluetoothSpp.this.clearDevices();
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener
            public void onBtDeviceBond(BluetoothDevice device, int status) {
                if (BluetoothUtil.deviceEquals(device, BluetoothSpp.this.mConnectingSppDevice)) {
                    JL_Log.w(BluetoothSpp.TAG, "onBtDeviceBond", "device : " + BluetoothSpp.this.printfDeviceInfo(device) + ", status : " + status);
                    if (status == 12) {
                        BluetoothSpp.this.mHandler.removeMessages(BluetoothSpp.MSG_CONNECT_SPP_TIMEOUT);
                        BluetoothSpp.this.mHandler.sendEmptyMessageDelayed(BluetoothSpp.MSG_CONNECT_SPP_TIMEOUT, 30000L);
                        if (!BluetoothUtil.deviceHasA2dp(BluetoothSpp.this.mContext, device) && !BluetoothUtil.deviceHasHfp(BluetoothSpp.this.mContext, device)) {
                            JL_Log.i(BluetoothSpp.TAG, "onBtDeviceBond", "device has not a2dp and hfp.");
                            BluetoothSpp.this.mHandler.sendEmptyMessage(BluetoothSpp.MSG_CONNECT_SPP);
                            return;
                        } else {
                            JL_Log.d(BluetoothSpp.TAG, "onBtDeviceBond", "Waiting for a2dp or hfp connect.");
                            BluetoothSpp.this.mHandler.removeMessages(BluetoothSpp.MSG_WAIT_SYSTEM_CONNECT_EDR_TIMEOUT);
                            BluetoothSpp.this.mHandler.sendEmptyMessageDelayed(BluetoothSpp.MSG_WAIT_SYSTEM_CONNECT_EDR_TIMEOUT, 3000L);
                            return;
                        }
                    }
                    if (status == 10) {
                        BluetoothSpp.this.notifySppState(device, 0);
                    }
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener
            public void onPairError(BluetoothDevice device, ErrorInfo error) {
                if (BluetoothUtil.deviceEquals(device, BluetoothSpp.this.mConnectingSppDevice)) {
                    BluetoothSpp.this.notifySppState(device, 0);
                }
            }
        };
        this.mOnBtDevicePairListener = onBtDevicePairListener;
        OnBrEdrListener onBrEdrListener = new OnBrEdrListener() { // from class: com.jieli.bluetooth_connect.impl.BluetoothSpp.3
            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
            public void onA2dpStatus(BluetoothDevice device, int status) {
                BluetoothSpp.this.checkNeedConnect(device, status);
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
            public void onBrEdrConnection(BluetoothDevice device, int status) {
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
            public void onDeviceUuids(BluetoothDevice device, ParcelUuid[] uuids) {
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
            public void onEdrService(boolean isConnected, int profile, BluetoothProfile proxy) {
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
            public void onHfpStatus(BluetoothDevice device, int status) {
                BluetoothSpp.this.checkNeedConnect(device, status);
            }
        };
        this.mOnBrEdrListener = onBrEdrListener;
        this.mOnRecvSppDataListener = new ReceiveSppDataThread.OnRecvSppDataListener() { // from class: com.jieli.bluetooth_connect.impl.BluetoothSpp.4
            @Override // com.jieli.bluetooth_connect.tool.ReceiveSppDataThread.OnRecvSppDataListener
            public void onRecvSppData(long threadID, BluetoothDevice device, byte[] data) {
                JL_Log.d(BluetoothSpp.TAG, ConnectUtil.formatString("[onRecvSppData] <<< device : %s, data [ %s ].", device, CHexConverter.byte2HexStr(data)));
                BluetoothSpp.this.mSppEventCbManager.onSppDataNotify(device, BluetoothSpp.this.mBluetoothOption.getSppUUID(), data);
            }

            @Override // com.jieli.bluetooth_connect.tool.ReceiveSppDataThread.OnRecvSppDataListener
            public void onThreadStart(long threadID) {
            }

            @Override // com.jieli.bluetooth_connect.tool.ReceiveSppDataThread.OnRecvSppDataListener
            public void onThreadStop(long threadID, int reason, BluetoothDevice device) {
                JL_Log.w(BluetoothSpp.TAG, "onThreadStop", "reason : " + reason);
                BluetoothSpp.this.disconnectSPPDevice(device);
            }
        };
        this.mContext = (Context) ConnectUtil.checkNotNull(context);
        BluetoothBrEdr bluetoothBrEdr2 = (BluetoothBrEdr) ConnectUtil.checkNotNull(bluetoothBrEdr);
        this.mBluetoothBrEdr = bluetoothBrEdr2;
        BluetoothPair bluetoothPair = bluetoothBrEdr.getBluetoothPair();
        this.mBluetoothPair = bluetoothPair;
        bluetoothBrEdr2.addListener(onBrEdrListener);
        bluetoothPair.addListener(onBtDevicePairListener);
        this.mSppEventCbManager = new SppEventCbManager();
        this.mBluetoothOption = option == null ? BluetoothOption.createDefaultOption() : option;
        addListener(listener);
        registerSppReceiver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNeedConnect(BluetoothDevice device, int status) {
        if (BluetoothUtil.deviceEquals(device, this.mConnectingSppDevice)) {
            if (status != 1) {
                JL_Log.d(TAG, "checkNeedConnect", "a2dp or hfp connect finish.");
                this.mHandler.removeMessages(MSG_CONNECT_SPP);
                this.mHandler.sendEmptyMessageDelayed(MSG_CONNECT_SPP, 1000L);
                return;
            }
            this.mHandler.removeMessages(MSG_WAIT_SYSTEM_CONNECT_EDR_TIMEOUT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDevices() {
        JL_Log.d(TAG, "clearDevices", "");
        Iterator it = new ArrayList(this.mConnectedSppDevices).iterator();
        while (it.hasNext()) {
            disconnectSpp((BluetoothDevice) it.next());
        }
        if (!this.mSppSocketMap.isEmpty()) {
            Iterator<String> it2 = this.mSppSocketMap.keySet().iterator();
            while (it2.hasNext()) {
                BluetoothSocket bluetoothSocket = this.mSppSocketMap.get(it2.next());
                if (bluetoothSocket != null && bluetoothSocket.isConnected()) {
                    try {
                        bluetoothSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        this.mSppSocketMap.clear();
        this.mSppRecvThreadMap.clear();
        this.mConnectedSppDevices.clear();
        setConnectingSppDevice(null);
        setConnectedSppDevice(null);
    }

    private boolean disconnectSpp(BluetoothDevice device) {
        String str = TAG;
        JL_Log.i(str, "disconnectSpp", "device : " + printfDeviceInfo(device));
        if (device != null && ConnectUtil.isHasConnectPermission(this.mContext)) {
            if (!this.mConnectedSppDevices.contains(device)) {
                JL_Log.i(str, "disconnectSpp", "device is not connected device.");
                return true;
            }
            BluetoothSocket remove = this.mSppSocketMap.remove(device.getAddress());
            if (remove != null && remove.isConnected()) {
                try {
                    remove.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            ReceiveSppDataThread remove2 = this.mSppRecvThreadMap.remove(device.getAddress());
            if (remove2 != null) {
                remove2.stopThread();
            }
            this.mConnectedSppDevices.remove(device);
            JL_Log.i(TAG, "disconnectSpp", "remove connected device ok.");
            return true;
        }
        JL_Log.w(str, "disconnectSpp", "param is error.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDeviceUuids(BluetoothDevice device, ParcelUuid[] uuids) {
        if (BluetoothUtil.deviceEquals(device, this.mConnectingSppDevice)) {
            JL_Log.d(TAG, "handleDeviceUuids", "get uuid success.");
            this.mHandler.sendEmptyMessage(MSG_CONNECT_SPP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySppState(BluetoothDevice device, int status) {
        notifySppState(device, this.mBluetoothOption.getSppUUID(), status);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String printfDeviceInfo(BluetoothDevice device) {
        return BluetoothUtil.printBtDeviceInfo(this.mContext, device);
    }

    private void registerSppReceiver() {
        if (this.mSppReceiver == null) {
            this.mSppReceiver = new BluetoothSppReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.device.action.UUID");
            this.mContext.registerReceiver(this.mSppReceiver, intentFilter);
        }
    }

    private void removeDevice(BluetoothDevice device) {
        if (this.mConnectedSppDevices.isEmpty()) {
            setConnectedSppDevice(null);
        } else if (BluetoothUtil.deviceEquals(device, this.mConnectedSppDevice)) {
            setConnectedSppDevice(this.mConnectedSppDevices.get(r2.size() - 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startConnectSpp(BluetoothDevice device) {
        JL_Log.i(TAG, "startConnectSpp", "device : " + printfDeviceInfo(device) + ", Connect thread : " + this.mConnectionSppThread);
        if (device != null && this.mConnectionSppThread == null) {
            ConnectionSppThread connectionSppThread = new ConnectionSppThread(device);
            this.mConnectionSppThread = connectionSppThread;
            connectionSppThread.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startReceiveDataThread(BluetoothDevice device, BluetoothSocket socket) {
        JL_Log.e(TAG, "startReceiveDataThread", "socket : " + socket);
        ReceiveSppDataThread receiveSppDataThread = new ReceiveSppDataThread(device, socket, this.mOnRecvSppDataListener);
        if (!this.mThreadPool.isShutdown()) {
            this.mThreadPool.submit(receiveSppDataThread);
            this.mSppRecvThreadMap.put(device.getAddress(), receiveSppDataThread);
        }
    }

    private void stopConnectSpp() {
        ConnectionSppThread connectionSppThread = this.mConnectionSppThread;
        if (connectionSppThread != null) {
            try {
                if (connectionSppThread.isAlive()) {
                    this.mConnectionSppThread.interrupt();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mConnectionSppThread = null;
        }
    }

    private void unregisterSppReceiver() {
        BluetoothSppReceiver bluetoothSppReceiver = this.mSppReceiver;
        if (bluetoothSppReceiver != null) {
            this.mContext.unregisterReceiver(bluetoothSppReceiver);
            this.mSppReceiver = null;
        }
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothSpp
    @SuppressLint({"MissingPermission"})
    public boolean connectSPPDevice(BluetoothDevice device) {
        if (device != null && ConnectUtil.isHasConnectPermission(this.mContext)) {
            String str = TAG;
            JL_Log.i(str, "connectSPPDevice", "device : " + printfDeviceInfo(device));
            if (this.mConnectingSppDevice != null) {
                JL_Log.i(str, "connectSPPDevice", "ConnectingSppDevice is connecting. ConnectingSppDevice : " + printfDeviceInfo(this.mConnectedSppDevice));
                return false;
            }
            if (isConnectedSppDevice(device)) {
                notifySppState(device, 2);
                return true;
            }
            if (!this.mBluetoothOption.isUseMultiDevice() && this.mConnectedSppDevice != null && !BluetoothUtil.deviceEquals(this.mConnectedSppDevice, device)) {
                disconnectSPPDevice(this.mConnectedSppDevice);
                SystemClock.sleep(300L);
            }
            setConnectingSppDevice(device);
            boolean isPaired = this.mBluetoothPair.isPaired(device);
            JL_Log.i(str, "connectSPPDevice", "isPaired : " + isPaired);
            if (!isPaired) {
                boolean tryToPair = this.mBluetoothPair.tryToPair(device);
                JL_Log.i(str, "connectSPPDevice", "tryToPair : " + tryToPair);
                if (!tryToPair) {
                    notifySppState(device, 0);
                    JL_Log.w(str, "connectSPPDevice", "tryToPair is failed.");
                    return false;
                }
            } else if (device.getUuids() != null && BluetoothUtil.deviceHasProfile(this.mContext, device, this.mBluetoothOption.getSppUUID())) {
                JL_Log.i(str, "connectSPPDevice", "start connect spp.");
                this.mHandler.sendEmptyMessage(MSG_CONNECT_SPP);
            } else if (!device.fetchUuidsWithSdp()) {
                notifySppState(device, 0);
                JL_Log.w(str, "connectSPPDevice", "fetchUuidsWithSdp is failed.");
                return false;
            }
            notifySppState(device, 1);
            this.mHandler.removeMessages(MSG_CONNECT_SPP_TIMEOUT);
            this.mHandler.sendEmptyMessageDelayed(MSG_CONNECT_SPP_TIMEOUT, 40000L);
            return true;
        }
        JL_Log.i(TAG, "connectSPPDevice", "device is bad object. ");
        return false;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void destroy() {
        JL_Log.d(TAG, "destroy", "");
        this.mSppEventCbManager.destroy();
        this.mBluetoothPair.removeListener(this.mOnBtDevicePairListener);
        this.mBluetoothBrEdr.removeListener(this.mOnBrEdrListener);
        stopConnectSpp();
        clearDevices();
        if (!this.mThreadPool.isShutdown()) {
            this.mThreadPool.shutdownNow();
        }
        unregisterSppReceiver();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothSpp
    public boolean disconnectSPPDevice(BluetoothDevice device) {
        JL_Log.i(TAG, "disconnectSPPDevice", "device : " + printfDeviceInfo(device));
        boolean disconnectSpp = disconnectSpp(device);
        if (disconnectSpp) {
            notifySppState(device, 0);
        }
        return disconnectSpp;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothSpp
    public BluetoothDevice getConnectedSPPDevice() {
        return this.mConnectedSppDevice;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothSpp
    public List<BluetoothDevice> getConnectedSppDevices() {
        return new ArrayList(this.mConnectedSppDevices);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothSpp
    public BluetoothDevice getSppConnectingDevice() {
        return this.mConnectingSppDevice;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothSpp
    public boolean isConnectedSppDevice(BluetoothDevice device) {
        BluetoothSocket bluetoothSocket;
        if (device == null || (bluetoothSocket = this.mSppSocketMap.get(device.getAddress())) == null) {
            return false;
        }
        return bluetoothSocket.isConnected();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothSpp
    public boolean isSppConnecting() {
        if (this.mConnectingSppDevice != null) {
            return true;
        }
        return false;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void setBluetoothOption(BluetoothOption option) {
        if (option != null) {
            this.mBluetoothOption = option;
        }
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothSpp
    public void setConnectedSppDevice(BluetoothDevice device) {
        if (!BluetoothUtil.deviceEquals(this.mConnectedSppDevice, device)) {
            this.mConnectedSppDevice = device;
            if (device != null) {
                this.mSppEventCbManager.onSwitchSppDevice(device);
            }
        }
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothSpp
    public void setConnectingSppDevice(BluetoothDevice connectingSppDevice) {
        this.mConnectingSppDevice = connectingSppDevice;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothSpp
    public synchronized boolean writeDataToSppDevice(BluetoothDevice device, byte[] data) {
        if (data != null && device != null) {
            if (!isConnectedSppDevice(device)) {
                JL_Log.w(TAG, "writeDataToSppDevice", "device is disconnected.");
                return false;
            }
            BluetoothSocket bluetoothSocket = this.mSppSocketMap.get(device.getAddress());
            if (bluetoothSocket != null && bluetoothSocket.isConnected()) {
                try {
                    bluetoothSocket.getOutputStream().write(data);
                    JL_Log.i(TAG, ConnectUtil.formatString("[writeDataToSppDevice] >>> send data successful. device : %s, data [ %s ].", device, CHexConverter.byte2HexStr(data)));
                    return true;
                } catch (Exception e) {
                    JL_Log.w(TAG, "writeDataToSppDevice", "have an exception : " + e);
                    e.printStackTrace();
                    return false;
                }
            }
            JL_Log.w(TAG, "writeDataToSppDevice", "spp socket is close.");
            return false;
        }
        JL_Log.w(TAG, "writeDataToSppDevice", "param is error.");
        return false;
    }

    private void notifySppState(BluetoothDevice device, UUID sppUUID, int status) {
        JL_Log.i(TAG, "notifySppState", "device : " + printfDeviceInfo(device) + ", status : " + BluetoothConstant.printBtConnection(status));
        if (status != 1) {
            if (BluetoothUtil.deviceEquals(this.mConnectingSppDevice, device)) {
                setConnectingSppDevice(null);
                this.mHandler.removeMessages(MSG_CONNECT_SPP_TIMEOUT);
            }
            if (status == 0) {
                removeDevice(device);
            }
        }
        this.mSppEventCbManager.onSppConnection(device, sppUUID, status);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void addListener(OnBtSppListener listener) {
        this.mSppEventCbManager.addListener(listener);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void removeListener(OnBtSppListener listener) {
        this.mSppEventCbManager.removeListener(listener);
    }
}
