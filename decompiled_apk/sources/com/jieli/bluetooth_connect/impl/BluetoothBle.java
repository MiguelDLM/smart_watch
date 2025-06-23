package com.jieli.bluetooth_connect.impl;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.ExoPlayer;
import com.jieli.bluetooth_connect.bean.BluetoothOption;
import com.jieli.bluetooth_connect.bean.ErrorInfo;
import com.jieli.bluetooth_connect.constant.BluetoothConstant;
import com.jieli.bluetooth_connect.interfaces.IBluetoothBle;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtBleListener;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener;
import com.jieli.bluetooth_connect.interfaces.listener.OnThreadStateListener;
import com.jieli.bluetooth_connect.interfaces.listener.OnWriteDataCallback;
import com.jieli.bluetooth_connect.tool.BleEventCbManager;
import com.jieli.bluetooth_connect.tool.SendBleDataThread;
import com.jieli.bluetooth_connect.util.BluetoothUtil;
import com.jieli.bluetooth_connect.util.CHexConverter;
import com.jieli.bluetooth_connect.util.ConnectUtil;
import com.jieli.bluetooth_connect.util.JL_Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.eclipse.paho.android.service.MqttServiceConstants;

/* loaded from: classes10.dex */
public class BluetoothBle implements IBluetoothBle {
    private static final int CALLBACK_TIMEOUT = 3000;
    private static final int FAILURE_LIMIT = 2;
    private static final int MSG_BLE_DISCOVER_SERVICES_CALLBACK_TIMEOUT = 13641;
    private static final int MSG_CONNECT_BLE_TIMEOUT = 13639;
    private static final int MSG_DISCONNECT_BLE_CALLBACK_TIMEOUT = 13640;
    private static final int MSG_RECONNECT_BLE = 13642;
    private static final int RECONNECT_BLE_DELAY = 2000;
    private static final String TAG = "BluetoothBle";
    private long boundStartTime;
    private int failedCount;
    private final BleEventCbManager mBleEventCbManager;
    private int mBleNotificationCount;
    private BluetoothBleReceiver mBluetoothBleReceiver;
    private final BluetoothGattCallback mBluetoothGattCallback;
    private BluetoothOption mBluetoothOption;
    private final BluetoothPair mBluetoothPair;
    private volatile BluetoothDevice mBoundingBleDevice;
    private volatile BluetoothDevice mConnectedBleDevice;
    private volatile BluetoothDevice mConnectingBleDevice;
    private final Context mContext;
    private volatile BluetoothDevice mNeedReconnectBleDevice;
    private final OnBtDevicePairListener mOnBtDevicePairListener;
    private SendBleDataThread mSendBleDataThread;
    private int reconnectCount;
    private final List<BluetoothGatt> mBluetoothGatts = Collections.synchronizedList(new ArrayList());
    private final List<BluetoothDevice> mConnectedBleDevices = Collections.synchronizedList(new ArrayList());
    private final Map<String, Integer> mBleMtuMap = Collections.synchronizedMap(new HashMap());
    private final Map<String, Long> startTimeMap = new HashMap();
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.bluetooth_connect.impl.BluetoothBle.1
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00be, code lost:
        
            return false;
         */
        @Override // android.os.Handler.Callback
        @android.annotation.SuppressLint({"MissingPermission"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean handleMessage(@androidx.annotation.NonNull android.os.Message r5) {
            /*
                r4 = this;
                int r0 = r5.what
                r1 = 0
                r2 = 0
                switch(r0) {
                    case 13639: goto L99;
                    case 13640: goto L66;
                    case 13641: goto L25;
                    case 13642: goto L9;
                    default: goto L7;
                }
            L7:
                goto Lbe
            L9:
                java.lang.Object r5 = r5.obj
                boolean r0 = r5 instanceof android.bluetooth.BluetoothDevice
                if (r0 == 0) goto Lbe
                android.bluetooth.BluetoothDevice r5 = (android.bluetooth.BluetoothDevice) r5
                com.jieli.bluetooth_connect.impl.BluetoothBle r0 = com.jieli.bluetooth_connect.impl.BluetoothBle.this
                com.jieli.bluetooth_connect.impl.BluetoothBle.access$200(r0, r1)
                com.jieli.bluetooth_connect.impl.BluetoothBle r0 = com.jieli.bluetooth_connect.impl.BluetoothBle.this
                boolean r0 = r0.connectBLEDevice(r5)
                if (r0 != 0) goto Lbe
                com.jieli.bluetooth_connect.impl.BluetoothBle r0 = com.jieli.bluetooth_connect.impl.BluetoothBle.this
                com.jieli.bluetooth_connect.impl.BluetoothBle.access$100(r0, r5, r2)
                goto Lbe
            L25:
                java.lang.Object r5 = r5.obj
                boolean r0 = r5 instanceof android.bluetooth.BluetoothDevice
                if (r0 == 0) goto Lbe
                android.bluetooth.BluetoothDevice r5 = (android.bluetooth.BluetoothDevice) r5
                com.jieli.bluetooth_connect.impl.BluetoothBle r0 = com.jieli.bluetooth_connect.impl.BluetoothBle.this
                android.bluetooth.BluetoothGatt r0 = r0.getDeviceGatt(r5)
                if (r0 == 0) goto L48
                java.util.List r1 = r0.getServices()
                if (r1 == 0) goto L48
                boolean r1 = r1.isEmpty()
                if (r1 != 0) goto L48
                com.jieli.bluetooth_connect.impl.BluetoothBle r5 = com.jieli.bluetooth_connect.impl.BluetoothBle.this
                com.jieli.bluetooth_connect.impl.BluetoothBle.access$500(r5, r0, r2)
                goto Lbe
            L48:
                java.lang.String r0 = com.jieli.bluetooth_connect.impl.BluetoothBle.access$600()
                java.lang.String r1 = "MSG_BLE_DISCOVER_SERVICES_CALLBACK_TIMEOUT"
                java.lang.String r3 = "discover services timeout."
                com.jieli.bluetooth_connect.util.JL_Log.d(r0, r1, r3)
                com.jieli.bluetooth_connect.impl.BluetoothBle r0 = com.jieli.bluetooth_connect.impl.BluetoothBle.this
                com.jieli.bluetooth_connect.impl.BluetoothBle.access$700(r0, r5)
                com.jieli.bluetooth_connect.impl.BluetoothBle r0 = com.jieli.bluetooth_connect.impl.BluetoothBle.this
                boolean r0 = r0.disconnectBLEDevice(r5)
                if (r0 != 0) goto Lbe
                com.jieli.bluetooth_connect.impl.BluetoothBle r0 = com.jieli.bluetooth_connect.impl.BluetoothBle.this
                com.jieli.bluetooth_connect.impl.BluetoothBle.access$100(r0, r5, r2)
                goto Lbe
            L66:
                java.lang.Object r5 = r5.obj
                boolean r0 = r5 instanceof android.bluetooth.BluetoothDevice
                if (r0 == 0) goto Lbe
                android.bluetooth.BluetoothDevice r5 = (android.bluetooth.BluetoothDevice) r5
                com.jieli.bluetooth_connect.impl.BluetoothBle r0 = com.jieli.bluetooth_connect.impl.BluetoothBle.this
                android.bluetooth.BluetoothGatt r0 = r0.getDeviceGatt(r5)
                if (r0 == 0) goto Lbe
                com.jieli.bluetooth_connect.impl.BluetoothBle r1 = com.jieli.bluetooth_connect.impl.BluetoothBle.this
                android.content.Context r1 = com.jieli.bluetooth_connect.impl.BluetoothBle.access$300(r1)
                boolean r1 = com.jieli.bluetooth_connect.util.ConnectUtil.isHasConnectPermission(r1)
                if (r1 == 0) goto Lbe
                com.jieli.bluetooth_connect.impl.BluetoothBle r1 = com.jieli.bluetooth_connect.impl.BluetoothBle.this
                android.content.Context r1 = com.jieli.bluetooth_connect.impl.BluetoothBle.access$300(r1)
                com.jieli.bluetooth_connect.util.BluetoothUtil.refreshBleDeviceCache(r1, r0)
                r0.close()
                com.jieli.bluetooth_connect.impl.BluetoothBle r1 = com.jieli.bluetooth_connect.impl.BluetoothBle.this
                com.jieli.bluetooth_connect.impl.BluetoothBle.access$100(r1, r5, r2)
                com.jieli.bluetooth_connect.impl.BluetoothBle r1 = com.jieli.bluetooth_connect.impl.BluetoothBle.this
                com.jieli.bluetooth_connect.impl.BluetoothBle.access$400(r1, r5, r0)
                goto Lbe
            L99:
                com.jieli.bluetooth_connect.impl.BluetoothBle r0 = com.jieli.bluetooth_connect.impl.BluetoothBle.this
                android.bluetooth.BluetoothDevice r0 = com.jieli.bluetooth_connect.impl.BluetoothBle.access$000(r0)
                if (r0 != 0) goto Laa
                java.lang.Object r5 = r5.obj
                boolean r3 = r5 instanceof android.bluetooth.BluetoothDevice
                if (r3 == 0) goto Laa
                r0 = r5
                android.bluetooth.BluetoothDevice r0 = (android.bluetooth.BluetoothDevice) r0
            Laa:
                if (r0 == 0) goto Lbe
                com.jieli.bluetooth_connect.impl.BluetoothBle r5 = com.jieli.bluetooth_connect.impl.BluetoothBle.this
                boolean r5 = r5.isBleConnected(r0)
                if (r5 != 0) goto Lb9
                com.jieli.bluetooth_connect.impl.BluetoothBle r5 = com.jieli.bluetooth_connect.impl.BluetoothBle.this
                com.jieli.bluetooth_connect.impl.BluetoothBle.access$100(r5, r0, r2)
            Lb9:
                com.jieli.bluetooth_connect.impl.BluetoothBle r5 = com.jieli.bluetooth_connect.impl.BluetoothBle.this
                com.jieli.bluetooth_connect.impl.BluetoothBle.access$200(r5, r1)
            Lbe:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jieli.bluetooth_connect.impl.BluetoothBle.AnonymousClass1.handleMessage(android.os.Message):boolean");
        }
    });

    /* loaded from: classes10.dex */
    public class BluetoothBleReceiver extends BroadcastReceiver {
        private BluetoothBleReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
                return;
            }
            action.hashCode();
            if (!action.equals("android.bluetooth.device.action.ACL_CONNECTED")) {
                if (action.equals("android.bluetooth.device.action.ACL_DISCONNECTED")) {
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    JL_Log.i(BluetoothBle.TAG, "ACTION_ACL_DISCONNECTED", "device : " + BluetoothBle.this.printDeviceInfo(bluetoothDevice));
                    return;
                }
                return;
            }
            BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            JL_Log.i(BluetoothBle.TAG, "ACTION_ACL_CONNECTED", "device : " + BluetoothBle.this.printDeviceInfo(bluetoothDevice2));
        }
    }

    public BluetoothBle(Context context, BluetoothPair bluetoothPair, BluetoothOption option, OnBtBleListener listener) {
        OnBtDevicePairListener onBtDevicePairListener = new OnBtDevicePairListener() { // from class: com.jieli.bluetooth_connect.impl.BluetoothBle.3
            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener
            public void onAdapterStatus(boolean bEnabled, boolean bHasBle) {
                if (!bEnabled) {
                    BluetoothBle.this.clearDevices();
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener
            public void onBtDeviceBond(BluetoothDevice device, int status) {
                if (BluetoothUtil.deviceEquals(BluetoothBle.this.mBoundingBleDevice, device)) {
                    JL_Log.i(BluetoothBle.TAG, "onBondStatus", "device : " + device + ", status : " + status);
                    if (status == 12) {
                        BluetoothBle.this.onBleBond(device, 12);
                        return;
                    }
                    if (status != 10) {
                        BluetoothBle.this.onBleBond(device, status);
                        return;
                    }
                    long abs = Math.abs(ConnectUtil.getCurrentTime() - BluetoothBle.this.boundStartTime);
                    BluetoothBle.access$1408(BluetoothBle.this);
                    if (abs < 5000 && BluetoothBle.this.failedCount <= 2) {
                        SystemClock.sleep(300L);
                        if (BluetoothBle.this.startBleBond(device)) {
                            JL_Log.i(BluetoothBle.TAG, "onBondStatus", "restart bond ble device : " + device + ", failedCount ： " + BluetoothBle.this.failedCount);
                            return;
                        }
                    }
                    BluetoothBle.this.onBleBond(device, 10);
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener
            public void onPairError(BluetoothDevice device, ErrorInfo error) {
                if (BluetoothUtil.deviceEquals(BluetoothBle.this.mBoundingBleDevice, device)) {
                    BluetoothBle.this.onBleBond(device, 10);
                }
            }
        };
        this.mOnBtDevicePairListener = onBtDevicePairListener;
        this.mBluetoothGattCallback = new BluetoothGattCallback() { // from class: com.jieli.bluetooth_connect.impl.BluetoothBle.4
            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
                super.onCharacteristicChanged(gatt, characteristic);
                BluetoothBle.this.mBleEventCbManager.onCharacteristicChanged(gatt, characteristic);
                if (gatt != null && characteristic != null && characteristic.getService() != null) {
                    BluetoothDevice device = gatt.getDevice();
                    UUID uuid = characteristic.getService().getUuid();
                    UUID uuid2 = characteristic.getUuid();
                    byte[] value = characteristic.getValue();
                    JL_Log.d(BluetoothBle.TAG, ConnectUtil.formatString("[onCharacteristicChanged] <<< device : %s, characteristic = %s, data = %s ", BluetoothBle.this.printDeviceInfo(device, false), characteristic, CHexConverter.byte2HexStr(value)));
                    BluetoothBle.this.mBleEventCbManager.onBleDataNotify(device, uuid, uuid2, value);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
                super.onCharacteristicRead(gatt, characteristic, status);
                JL_Log.d(BluetoothBle.TAG, ConnectUtil.formatString("[onCharacteristicRead] <<< device : %s, characteristic = %s, data = %s ", BluetoothBle.this.printDeviceInfo(gatt.getDevice(), false), characteristic, CHexConverter.byte2HexStr(characteristic.getValue())));
                BluetoothBle.this.mBleEventCbManager.onCharacteristicRead(gatt, characteristic, status);
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
                BluetoothDevice device;
                super.onCharacteristicWrite(gatt, characteristic, status);
                if (gatt != null && (device = gatt.getDevice()) != null && characteristic != null && characteristic.getService() != null) {
                    BluetoothBle.this.mBleEventCbManager.onCharacteristicWrite(gatt, characteristic, status);
                    JL_Log.i(BluetoothBle.TAG, ConnectUtil.formatString("[onCharacteristicWrite] >>> device : %s, characteristic = %s, status = %d ", BluetoothBle.this.printDeviceInfo(gatt.getDevice(), false), characteristic.getUuid(), Integer.valueOf(status)));
                    UUID uuid = characteristic.getService().getUuid();
                    UUID uuid2 = characteristic.getUuid();
                    byte[] value = characteristic.getValue();
                    BluetoothBle.this.wakeUpSendDataThread(device, uuid, uuid2, status, value);
                    BluetoothBle.this.mBleEventCbManager.onBleWriteStatus(gatt.getDevice(), uuid, uuid2, value, status);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
                if (gatt == null) {
                    JL_Log.w(BluetoothBle.TAG, "onConnectionStateChange", "No Gatt.");
                    return;
                }
                BluetoothDevice device = gatt.getDevice();
                if (device == null) {
                    JL_Log.w(BluetoothBle.TAG, "onConnectionStateChange", "No Device.");
                    return;
                }
                BluetoothBle.this.mBleEventCbManager.onConnectionStateChange(gatt, status, newState);
                JL_Log.e(BluetoothBle.TAG, "onConnectionStateChange", "ble ConnectionStateChange device : " + BluetoothBle.this.printDeviceInfo(device) + ", status : " + BluetoothConstant.printBtConnection(status) + " newState : " + newState);
                BluetoothBle.this.handleBleConnection(gatt, device, status, newState);
            }

            public void onConnectionUpdated(final BluetoothGatt gatt, int interval, int latency, int timeout, int status) {
                if (gatt == null) {
                    return;
                }
                BluetoothDevice device = gatt.getDevice();
                JL_Log.e(BluetoothBle.TAG, "onConnectionUpdated", "device :" + BluetoothBle.this.printDeviceInfo(device) + " , interval : " + interval + ", latency : " + latency + ", timeout : " + timeout + ", status : " + BluetoothConstant.printBtConnection(status));
                BluetoothBle.this.mBleEventCbManager.onConnectionUpdatedCallback(gatt, interval, latency, timeout, status);
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onDescriptorRead(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
                BluetoothBle.this.mBleEventCbManager.onDescriptorRead(gatt, descriptor, status);
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
                UUID uuid;
                UUID uuid2;
                String str;
                boolean z;
                super.onDescriptorWrite(gatt, descriptor, status);
                BluetoothBle.this.mBleEventCbManager.onDescriptorWrite(gatt, descriptor, status);
                BluetoothGattCharacteristic characteristic = descriptor.getCharacteristic();
                if (characteristic != null) {
                    uuid = characteristic.getUuid();
                    uuid2 = characteristic.getService().getUuid();
                } else {
                    uuid = null;
                    uuid2 = null;
                }
                String str2 = BluetoothBle.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("UUID = ");
                if (uuid != null) {
                    str = uuid.toString();
                } else {
                    str = "";
                }
                sb.append(str);
                sb.append(", status = ");
                sb.append(status);
                JL_Log.i(str2, "onDescriptorWrite", sb.toString());
                BluetoothBle bluetoothBle = BluetoothBle.this;
                BluetoothDevice device = gatt.getDevice();
                if (status == 0) {
                    z = true;
                } else {
                    z = false;
                }
                bluetoothBle.onBleNotificationStatus(device, uuid2, uuid, z);
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onMtuChanged(BluetoothGatt gatt, int mtu, int status) {
                BluetoothDevice device;
                super.onMtuChanged(gatt, mtu, status);
                if (gatt == null || (device = gatt.getDevice()) == null) {
                    return;
                }
                BluetoothBle.this.mBleEventCbManager.onMtuChanged(gatt, mtu, status);
                if (status == 0) {
                    int i = mtu - 3;
                    BluetoothBle.this.addBleMtu(device, i);
                    JL_Log.e(BluetoothBle.TAG, "onMtuChanged", "realMtu : " + i);
                }
                BluetoothBle.this.mBleEventCbManager.onBleMtuChanged(device, BluetoothBle.this.getBleMtu(device), status);
            }

            @Override // android.bluetooth.BluetoothGattCallback
            @RequiresApi(api = 26)
            public void onPhyRead(BluetoothGatt gatt, int txPhy, int rxPhy, int status) {
                JL_Log.d(BluetoothBle.TAG, "onPhyRead", ConnectUtil.formatString("txPhy = %d, rxPhy = %d, status = %d", Integer.valueOf(txPhy), Integer.valueOf(rxPhy), Integer.valueOf(status)));
                BluetoothBle.this.mBleEventCbManager.onPhyRead(gatt, txPhy, rxPhy, status);
            }

            @Override // android.bluetooth.BluetoothGattCallback
            @RequiresApi(api = 26)
            public void onPhyUpdate(BluetoothGatt gatt, int txPhy, int rxPhy, int status) {
                JL_Log.d(BluetoothBle.TAG, "onPhyUpdate", ConnectUtil.formatString("txPhy = %d, rxPhy = %d, status = %d", Integer.valueOf(txPhy), Integer.valueOf(rxPhy), Integer.valueOf(status)));
                BluetoothBle.this.mBleEventCbManager.onPhyUpdate(gatt, txPhy, rxPhy, status);
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onReadRemoteRssi(BluetoothGatt gatt, int rssi, int status) {
                BluetoothBle.this.mBleEventCbManager.onReadRemoteRssi(gatt, rssi, status);
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onReliableWriteCompleted(BluetoothGatt gatt, int status) {
                super.onReliableWriteCompleted(gatt, status);
                if (gatt != null) {
                    JL_Log.i(BluetoothBle.TAG, "onReliableWriteCompleted", "device : " + BluetoothBle.this.printDeviceInfo(gatt.getDevice(), false));
                    BluetoothBle.this.mBleEventCbManager.onReliableWriteCompleted(gatt, status);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            @RequiresApi(api = 31)
            public void onServiceChanged(@NonNull BluetoothGatt gatt) {
                BluetoothBle.this.mBleEventCbManager.onServiceChanged(gatt);
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onServicesDiscovered(BluetoothGatt gatt, int status) {
                super.onServicesDiscovered(gatt, status);
                BluetoothBle.this.mHandler.removeMessages(BluetoothBle.MSG_BLE_DISCOVER_SERVICES_CALLBACK_TIMEOUT);
                BluetoothUtil.printBleGattServices(BluetoothBle.this.mContext, gatt.getDevice(), gatt, status);
                BluetoothBle.this.onBleServiceDiscovery(gatt, status);
            }
        };
        this.mContext = (Context) ConnectUtil.checkNotNull(context);
        BluetoothPair bluetoothPair2 = (BluetoothPair) ConnectUtil.checkNotNull(bluetoothPair);
        this.mBluetoothPair = bluetoothPair2;
        bluetoothPair2.addListener(onBtDevicePairListener);
        this.mBleEventCbManager = new BleEventCbManager();
        this.mBluetoothOption = option == null ? BluetoothOption.createDefaultOption() : option;
        addListener(listener);
        registerReceiver();
    }

    public static /* synthetic */ int access$1408(BluetoothBle bluetoothBle) {
        int i = bluetoothBle.failedCount;
        bluetoothBle.failedCount = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBleMtu(BluetoothDevice device, int mtu) {
        int formatBleMtu = BluetoothUtil.formatBleMtu(mtu);
        if (device != null && isConnectedBleDevice(device)) {
            this.mBleMtuMap.put(device.getAddress(), Integer.valueOf(formatBleMtu));
        }
    }

    private void addSendTask(BluetoothDevice device, UUID serviceUUID, UUID characteristicUUID, byte[] data, OnWriteDataCallback callback) {
        boolean z;
        SendBleDataThread sendBleDataThread = this.mSendBleDataThread;
        if (sendBleDataThread != null) {
            z = sendBleDataThread.addSendTask(device, serviceUUID, characteristicUUID, data, callback);
        } else {
            z = false;
        }
        if (!z && callback != null) {
            callback.onBleResult(device, serviceUUID, characteristicUUID, false, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void clearDevices() {
        Iterator it = new ArrayList(this.mConnectedBleDevices).iterator();
        while (it.hasNext()) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) it.next();
            BluetoothGatt deviceGatt = getDeviceGatt(bluetoothDevice);
            if (deviceGatt != null) {
                if (ConnectUtil.isHasConnectPermission(this.mContext) && BluetoothUtil.isBluetoothEnable()) {
                    deviceGatt.disconnect();
                    deviceGatt.close();
                }
                this.mBleEventCbManager.onBleConnection(bluetoothDevice, 0);
            }
        }
        this.mConnectedBleDevices.clear();
        this.mBluetoothGatts.clear();
        this.mBleMtuMap.clear();
        setConnectedBleDevice(null);
        setConnectingBleDevice(null);
        stopSendDataThread();
    }

    @SuppressLint({"MissingPermission"})
    private boolean connectBluetoothGatt(BluetoothDevice device) {
        BluetoothGatt connectGatt;
        long longValue;
        String str = TAG;
        JL_Log.i(str, "connectBluetoothGatt", "");
        if (device != null && ConnectUtil.isHasConnectPermission(this.mContext)) {
            if (Build.VERSION.SDK_INT >= 23) {
                connectGatt = device.connectGatt(this.mContext, this.mBluetoothOption.isAutoConnectBle(), this.mBluetoothGattCallback, 2);
            } else {
                connectGatt = device.connectGatt(this.mContext, this.mBluetoothOption.isAutoConnectBle(), this.mBluetoothGattCallback);
            }
            if (connectGatt == null) {
                JL_Log.i(str, "connectBluetoothGatt", "bluetoothGatt is null.");
                notifyBleConnectStatus(device, 0);
                return false;
            }
            if (this.mBluetoothOption.isAutoConnectBle() && !connectGatt.connect()) {
                JL_Log.i(str, "connectBluetoothGatt", "Failed to auto connect.");
                return false;
            }
            Long l = this.startTimeMap.get(device.getAddress());
            if (l == null) {
                longValue = ConnectUtil.getCurrentTime();
                this.startTimeMap.put(device.getAddress(), Long.valueOf(longValue));
            } else {
                longValue = l.longValue();
            }
            if (!this.mBluetoothGatts.contains(connectGatt)) {
                this.mBluetoothGatts.add(connectGatt);
            }
            JL_Log.i(str, "connectBluetoothGatt", "start ble connect. startTime : " + longValue);
            return true;
        }
        JL_Log.w(str, "connectBluetoothGatt", "device is null");
        return false;
    }

    private void dealWithBleConnected(BluetoothDevice device) {
        if (this.mBluetoothOption.isUseBleBondWay()) {
            startBleBond(device);
        }
        notifyBleConnectStatus(device, 2);
    }

    @SuppressLint({"MissingPermission"})
    private boolean discoverBLEDeviceServices(BluetoothDevice device) {
        String str = TAG;
        JL_Log.i(str, "discoverBLEDeviceServices", "device : " + device);
        if (!ConnectUtil.isHasConnectPermission(this.mContext)) {
            return false;
        }
        BluetoothGatt deviceGatt = getDeviceGatt(device);
        if (deviceGatt == null) {
            JL_Log.i(str, "discoverBLEDeviceServices", "no bluetoothGatt");
            return false;
        }
        boolean discoverServices = deviceGatt.discoverServices();
        JL_Log.i(str, "discoverBLEDeviceServices", "discoverServices ---> " + discoverServices);
        return discoverServices;
    }

    @SuppressLint({"MissingPermission"})
    private boolean enableBLEDeviceNotification(BluetoothDevice device, UUID serviceUUID, UUID characteristicUUID) {
        boolean z;
        boolean z2 = false;
        if (!ConnectUtil.isHasConnectPermission(this.mContext)) {
            JL_Log.w(TAG, "enableBLEDeviceNotification", "no connect permission.");
            return false;
        }
        BluetoothGatt deviceGatt = getDeviceGatt(device);
        if (deviceGatt == null) {
            JL_Log.w(TAG, "enableBLEDeviceNotification", "No Gatt.");
            return false;
        }
        BluetoothGattService service = deviceGatt.getService(serviceUUID);
        if (service == null) {
            JL_Log.w(TAG, "enableBLEDeviceNotification", "No Gatt Service.");
            return false;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(characteristicUUID);
        if (characteristic == null) {
            JL_Log.w(TAG, "enableBLEDeviceNotification", "No Gatt Characteristic.");
            return false;
        }
        try {
            z = deviceGatt.setCharacteristicNotification(characteristic, true);
        } catch (Exception e) {
            e = e;
        }
        try {
            if (z) {
                BluetoothGattDescriptor descriptor = characteristic.getDescriptor(BluetoothConstant.UUID_CLIENT_CHARACTERISTIC_CONFIG);
                if (descriptor != null) {
                    z = tryToWriteDescriptor(deviceGatt, descriptor, 0, false);
                }
            } else {
                JL_Log.w(TAG, "enableBLEDeviceNotification", "setCharacteristicNotification failed.");
            }
        } catch (Exception e2) {
            e = e2;
            z2 = z;
            JL_Log.e(TAG, "enableBLEDeviceNotification", "exception : " + e.getMessage());
            e.printStackTrace();
            z = z2;
            JL_Log.w(TAG, "enableBLEDeviceNotification", "" + z);
            return z;
        }
        JL_Log.w(TAG, "enableBLEDeviceNotification", "" + z);
        return z;
    }

    private void handleACLConnection(BluetoothDevice device, int status) {
        if (BluetoothUtil.deviceEquals(this.mConnectingBleDevice, device) && status == 2 && !isConnectedBleDevice(device)) {
            connectBluetoothGatt(device);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void handleBleConnection(BluetoothGatt gatt, BluetoothDevice device, int status, int newState) {
        long longValue;
        boolean z = true;
        if (status == 0 && newState != 0) {
            if (newState == 2) {
                if (!this.mBluetoothGatts.contains(gatt)) {
                    this.mBluetoothGatts.add(gatt);
                }
                if (!this.mConnectedBleDevices.contains(device)) {
                    this.mConnectedBleDevices.add(device);
                    addBleMtu(device, 20);
                }
                if (!discoverBLEDeviceServices(device)) {
                    disconnectBLEDevice(device);
                    return;
                }
                this.mHandler.removeMessages(MSG_BLE_DISCOVER_SERVICES_CALLBACK_TIMEOUT);
                Handler handler = this.mHandler;
                handler.sendMessageDelayed(handler.obtainMessage(MSG_BLE_DISCOVER_SERVICES_CALLBACK_TIMEOUT, device), 3000L);
                return;
            }
            if (newState == 1) {
                notifyBleConnectStatus(device, 1);
                return;
            }
            return;
        }
        this.mHandler.removeMessages(MSG_DISCONNECT_BLE_CALLBACK_TIMEOUT);
        this.mHandler.removeMessages(MSG_BLE_DISCOVER_SERVICES_CALLBACK_TIMEOUT);
        removeDeviceFromRecord(device, gatt);
        BluetoothUtil.refreshBleDeviceCache(this.mContext, gatt);
        if (ConnectUtil.isHasConnectPermission(this.mContext)) {
            gatt.close();
        }
        long currentTime = ConnectUtil.getCurrentTime();
        Long l = this.startTimeMap.get(device.getAddress());
        if (l == null) {
            longValue = 0;
        } else {
            longValue = l.longValue();
        }
        long j = currentTime - longValue;
        long j2 = 30000 - j;
        this.reconnectCount++;
        if (!this.mBluetoothOption.isReconnect() || j >= 30000 || j > j2 || this.reconnectCount >= 2) {
            z = false;
        }
        String str = TAG;
        JL_Log.i(str, "handleBleConnection", "usedTime : " + j + ", leftConnectTime : " + j2 + ", isAllowReconnect : " + z + ", reconnectCount = " + this.reconnectCount);
        if (z && (status == 133 || BluetoothUtil.deviceEquals(device, this.mNeedReconnectBleDevice))) {
            JL_Log.i(str, "handleBleConnection", "found connect device. retry...");
            reconnectBleDevice(device);
        } else {
            JL_Log.w(str, "handleBleConnection", "callback device is disconnected.");
            notifyBleConnectStatus(device, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBleNotificationStatus$1(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2) {
        int i = this.mBleNotificationCount + 1;
        this.mBleNotificationCount = i;
        if (i < 5) {
            if (!enableBLEDeviceNotification(bluetoothDevice, uuid, uuid2)) {
                disconnectBLEDevice(bluetoothDevice);
            }
        } else {
            this.mBleNotificationCount = 0;
            disconnectBLEDevice(bluetoothDevice);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBleServiceDiscovery$0(BluetoothDevice bluetoothDevice) {
        this.mBleNotificationCount = 0;
        if (!enableBLEDeviceNotification(bluetoothDevice, this.mBluetoothOption.getBleServiceUUID(), this.mBluetoothOption.getBleNotificationUUID())) {
            disconnectBLEDevice(bluetoothDevice);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyBleConnectStatus(BluetoothDevice device, int status) {
        BluetoothGatt deviceGatt;
        if (status != 1) {
            if (BluetoothUtil.deviceEquals(device, this.mConnectingBleDevice)) {
                setConnectingBleDevice(null);
                this.mHandler.removeMessages(MSG_CONNECT_BLE_TIMEOUT);
            }
            if (device != null) {
                this.startTimeMap.remove(device.getAddress());
            }
            if (BluetoothUtil.deviceEquals(device, this.mNeedReconnectBleDevice)) {
                setNeedReconnectBleDevice(null);
                this.mHandler.removeMessages(MSG_RECONNECT_BLE);
            }
            this.mBleNotificationCount = 0;
            this.reconnectCount = 0;
            if (status == 2) {
                if (this.mConnectedBleDevice == null) {
                    setConnectedBleDevice(device);
                }
                startSendDataThread();
            } else if (status == 0) {
                if (this.mConnectedBleDevices.remove(device) && (deviceGatt = getDeviceGatt(device)) != null) {
                    this.mBluetoothGatts.remove(deviceGatt);
                }
                if (this.mConnectedBleDevices.isEmpty()) {
                    setConnectedBleDevice(null);
                    stopSendDataThread();
                } else if (BluetoothUtil.deviceEquals(this.mConnectedBleDevice, device)) {
                    List<BluetoothDevice> list = this.mConnectedBleDevices;
                    setConnectedBleDevice(list.get(list.size() - 1));
                }
            }
        }
        JL_Log.i(TAG, "notifyBleConnectStatus", "status : " + status);
        this.mBleEventCbManager.onBleConnection(device, status);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBleBond(final BluetoothDevice device, final int status) {
        if (status != 11 && BluetoothUtil.deviceEquals(device, this.mBoundingBleDevice)) {
            this.failedCount = 0;
            this.boundStartTime = 0L;
            this.mBoundingBleDevice = null;
        }
        this.mBleEventCbManager.onBleBond(device, status);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBleNotificationStatus(final BluetoothDevice device, final UUID serviceUuid, final UUID characteristicUuid, boolean bEnabled) {
        this.mBleEventCbManager.onBleNotificationStatus(device, serviceUuid, characteristicUuid, bEnabled);
        if (serviceUuid != null && serviceUuid.equals(this.mBluetoothOption.getBleServiceUUID()) && characteristicUuid != null && characteristicUuid.equals(this.mBluetoothOption.getBleNotificationUUID())) {
            if (!bEnabled) {
                JL_Log.w(TAG, "onBleNotificationStatus", ConnectUtil.formatString("device : %s, serviceUuid : %s, characteristicUuid : %s, mBleNotificationCount : %d", device, serviceUuid, characteristicUuid, Integer.valueOf(this.mBleNotificationCount)));
                this.mHandler.post(new Runnable() { // from class: com.jieli.bluetooth_connect.impl.oIX0oI
                    @Override // java.lang.Runnable
                    public final void run() {
                        BluetoothBle.this.lambda$onBleNotificationStatus$1(device, serviceUuid, characteristicUuid);
                    }
                });
            } else {
                dealWithBleConnected(device);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBleServiceDiscovery(BluetoothGatt gatt, int status) {
        boolean z;
        this.mBleEventCbManager.onServicesDiscovered(gatt, status);
        if (gatt != null && gatt.getServices() != null && gatt.getDevice() != null) {
            final BluetoothDevice device = gatt.getDevice();
            if (this.mBluetoothOption.isOnlyConnect()) {
                JL_Log.w(TAG, "onBleServiceDiscovery", "isOnlyConnect : true, notify ble connected ok.");
                dealWithBleConnected(device);
                return;
            }
            List<BluetoothGattService> services = gatt.getServices();
            Iterator<BluetoothGattService> it = services.iterator();
            while (true) {
                if (it.hasNext()) {
                    BluetoothGattService next = it.next();
                    if (next.getUuid().equals(this.mBluetoothOption.getBleServiceUUID()) && next.getCharacteristic(this.mBluetoothOption.getBleWriteUUID()) != null && next.getCharacteristic(this.mBluetoothOption.getBleNotificationUUID()) != null) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            JL_Log.w(TAG, "onBleServiceDiscovery", "bServiceFound : " + z);
            if (!z) {
                if (services.isEmpty()) {
                    setNeedReconnectBleDevice(device);
                }
                disconnectBLEDevice(device);
                return;
            }
            this.mHandler.post(new Runnable() { // from class: com.jieli.bluetooth_connect.impl.II0xO0
                @Override // java.lang.Runnable
                public final void run() {
                    BluetoothBle.this.lambda$onBleServiceDiscovery$0(device);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String printDeviceInfo(BluetoothDevice device, boolean isDetail) {
        return BluetoothUtil.printBtDeviceInfo(this.mContext, device, isDetail);
    }

    private void reconnectBleDevice(BluetoothDevice device) {
        this.mHandler.removeMessages(MSG_RECONNECT_BLE);
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(MSG_RECONNECT_BLE, device), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        if (BluetoothUtil.deviceEquals(device, this.mNeedReconnectBleDevice)) {
            setNeedReconnectBleDevice(null);
        }
    }

    private void registerReceiver() {
        if (this.mBluetoothBleReceiver == null) {
            this.mBluetoothBleReceiver = new BluetoothBleReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            this.mContext.registerReceiver(this.mBluetoothBleReceiver, intentFilter);
        }
    }

    private void removeBleMtu(BluetoothDevice device) {
        if (device != null) {
            this.mBleMtuMap.remove(device.getAddress());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeDeviceFromRecord(BluetoothDevice device, BluetoothGatt gatt) {
        BluetoothDevice bluetoothDevice;
        boolean z = false;
        if (device == null) {
            return false;
        }
        Iterator it = new ArrayList(this.mConnectedBleDevices).iterator();
        while (true) {
            if (it.hasNext()) {
                bluetoothDevice = (BluetoothDevice) it.next();
                if (bluetoothDevice != null && bluetoothDevice.getAddress().equals(device.getAddress())) {
                    z = true;
                    break;
                }
            } else {
                bluetoothDevice = null;
                break;
            }
        }
        if (bluetoothDevice != null) {
            removeBleMtu(bluetoothDevice);
            this.mConnectedBleDevices.remove(bluetoothDevice);
        }
        if (gatt != null && this.mBluetoothGatts.contains(gatt)) {
            JL_Log.e(TAG, "removeDeviceFromRecord", "remove gatt : " + gatt.getDevice());
            this.mBluetoothGatts.remove(gatt);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectingBleDevice(BluetoothDevice connectingBleDevice) {
        this.mConnectingBleDevice = connectingBleDevice;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNeedReconnectBleDevice(BluetoothDevice device) {
        this.mNeedReconnectBleDevice = device;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean startBleBond(BluetoothDevice device) {
        if (device == null) {
            return false;
        }
        boolean isPaired = this.mBluetoothPair.isPaired(device);
        String str = TAG;
        JL_Log.i(str, "startBleBond", "isPaired : " + isPaired);
        if (!isPaired) {
            boolean tryToPair = this.mBluetoothPair.tryToPair(device);
            JL_Log.i(str, "startBleBond", "isStartBond : " + tryToPair);
            if (tryToPair) {
                this.failedCount = 0;
                this.boundStartTime = ConnectUtil.getCurrentTime();
                this.mBoundingBleDevice = device;
                return true;
            }
            onBleBond(device, 10);
            return false;
        }
        onBleBond(device, 12);
        return true;
    }

    private void startSendDataThread() {
        if (this.mSendBleDataThread == null) {
            SendBleDataThread sendBleDataThread = new SendBleDataThread(this, new OnThreadStateListener() { // from class: com.jieli.bluetooth_connect.impl.BluetoothBle.2
                @Override // com.jieli.bluetooth_connect.interfaces.listener.OnThreadStateListener
                public void onEnd(long id, String name) {
                    BluetoothBle.this.mSendBleDataThread = null;
                }

                @Override // com.jieli.bluetooth_connect.interfaces.listener.OnThreadStateListener
                public void onStart(long id, String name) {
                }
            });
            this.mSendBleDataThread = sendBleDataThread;
            sendBleDataThread.start();
        }
    }

    private void stopSendDataThread() {
        SendBleDataThread sendBleDataThread = this.mSendBleDataThread;
        if (sendBleDataThread != null) {
            sendBleDataThread.stopThread();
        }
    }

    @SuppressLint({"MissingPermission"})
    private boolean tryToWriteDescriptor(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor descriptor, int retryCount, boolean isSkipSetValue) {
        if (!ConnectUtil.isHasConnectPermission(this.mContext)) {
            return false;
        }
        if (!isSkipSetValue) {
            isSkipSetValue = descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
            String str = TAG;
            JL_Log.i(str, "tryToWriteDescriptor", "setValue ---> " + isSkipSetValue);
            if (!isSkipSetValue) {
                retryCount++;
                if (retryCount >= 3) {
                    return false;
                }
                JL_Log.i(str, "tryToWriteDescriptor", "setValue failed. retryCount : " + retryCount + ", isSkipSetValue :  false");
                SystemClock.sleep(50L);
                tryToWriteDescriptor(bluetoothGatt, descriptor, retryCount, false);
            } else {
                retryCount = 0;
            }
        }
        if (isSkipSetValue) {
            isSkipSetValue = bluetoothGatt.writeDescriptor(descriptor);
            String str2 = TAG;
            JL_Log.i(str2, "tryToWriteDescriptor", "writeDescriptor ---> " + isSkipSetValue);
            if (!isSkipSetValue) {
                int i = retryCount + 1;
                if (i >= 3) {
                    return false;
                }
                JL_Log.i(str2, "tryToWriteDescriptor", "writeDescriptor failed. retryCount : " + i + ", isSkipSetValue :  true");
                SystemClock.sleep(50L);
                tryToWriteDescriptor(bluetoothGatt, descriptor, i, true);
            }
        }
        return isSkipSetValue;
    }

    private void unregisterReceiver() {
        BluetoothBleReceiver bluetoothBleReceiver = this.mBluetoothBleReceiver;
        if (bluetoothBleReceiver != null) {
            this.mContext.unregisterReceiver(bluetoothBleReceiver);
            this.mBluetoothBleReceiver = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wakeUpSendDataThread(BluetoothDevice device, UUID serviceUUID, UUID characteristicUUID, int status, byte[] data) {
        if (this.mSendBleDataThread != null) {
            SendBleDataThread.BleSendTask bleSendTask = new SendBleDataThread.BleSendTask(device, serviceUUID, characteristicUUID, data, null);
            bleSendTask.setStatus(status);
            this.mSendBleDataThread.wakeupSendThread(bleSendTask);
        }
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBle
    @SuppressLint({"MissingPermission"})
    public boolean connectBLEDevice(BluetoothDevice device) {
        if (device != null && ConnectUtil.isHasConnectPermission(this.mContext)) {
            String str = TAG;
            JL_Log.d(str, "connectBLEDevice", "device : " + printDeviceInfo(device));
            BluetoothDevice connectingBleDevice = getConnectingBleDevice();
            if (connectingBleDevice != null) {
                JL_Log.w(str, "connectBLEDevice", "Device is connecting. connectingDev : " + printDeviceInfo(connectingBleDevice));
                return false;
            }
            if (isConnectedBleDevice(device)) {
                JL_Log.w(str, "connectBLEDevice", "BLE is connected.");
                notifyBleConnectStatus(device, 2);
                return true;
            }
            JL_Log.d(str, "connectBLEDevice", "isUseMultiDevice : " + this.mBluetoothOption.isUseMultiDevice());
            if (!this.mBluetoothOption.isUseMultiDevice()) {
                BluetoothDevice connectedBleDevice = getConnectedBleDevice();
                JL_Log.d(str, "connectBLEDevice", "connectedDevice : " + printDeviceInfo(connectedBleDevice));
                if (connectedBleDevice != null && !BluetoothUtil.deviceEquals(connectedBleDevice, device)) {
                    disconnectBLEDevice(connectedBleDevice);
                    SystemClock.sleep(300L);
                }
            }
            setConnectingBleDevice(device);
            this.mHandler.removeMessages(MSG_CONNECT_BLE_TIMEOUT);
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(MSG_CONNECT_BLE_TIMEOUT, device), 30000L);
            boolean connectBluetoothGatt = connectBluetoothGatt(device);
            if (!connectBluetoothGatt) {
                notifyBleConnectStatus(device, 0);
            }
            return connectBluetoothGatt;
        }
        JL_Log.w(TAG, "connectBLEDevice", "connect to ble device is null");
        return false;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void destroy() {
        JL_Log.d(TAG, "destroy", "");
        clearDevices();
        this.mBleEventCbManager.destroy();
        this.startTimeMap.clear();
        unregisterReceiver();
        this.mBluetoothPair.removeListener(this.mOnBtDevicePairListener);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBle
    @SuppressLint({"MissingPermission"})
    public boolean disconnectBLEDevice(BluetoothDevice device) {
        if (!ConnectUtil.isHasConnectPermission(this.mContext)) {
            return false;
        }
        String str = TAG;
        JL_Log.d(str, "disconnectBLEDevice", "device : " + printDeviceInfo(device));
        try {
            if (!BluetoothUtil.isBluetoothEnable()) {
                JL_Log.w(str, "disconnectBLEDevice", "bluetooth is close.");
                return false;
            }
            BluetoothGatt deviceGatt = getDeviceGatt(device);
            if (deviceGatt == null) {
                JL_Log.w(str, "disconnectBLEDevice", "no bluetoothGatt");
                return false;
            }
            JL_Log.e(str, "disconnectBLEDevice", MqttServiceConstants.DISCONNECT_ACTION);
            deviceGatt.disconnect();
            this.mHandler.removeMessages(MSG_DISCONNECT_BLE_CALLBACK_TIMEOUT);
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(MSG_DISCONNECT_BLE_CALLBACK_TIMEOUT, device), 3000L);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBle
    public int getBleMtu(BluetoothDevice device) {
        Integer num;
        if (device == null || (num = this.mBleMtuMap.get(device.getAddress())) == null) {
            return 0;
        }
        if (num.intValue() >= 128) {
            num = Integer.valueOf(num.intValue() - 6);
        }
        return num.intValue();
    }

    public BluetoothPair getBluetoothPair() {
        return this.mBluetoothPair;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBle
    public BluetoothDevice getConnectedBleDevice() {
        return this.mConnectedBleDevice;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBle
    public List<BluetoothDevice> getConnectedBleDevices() {
        return new ArrayList(this.mConnectedBleDevices);
    }

    public BluetoothGatt getConnectedBluetoothGatt() {
        return getDeviceGatt(getConnectedBleDevice());
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBle
    public BluetoothDevice getConnectingBleDevice() {
        return this.mConnectingBleDevice;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBle
    public BluetoothGatt getDeviceGatt(BluetoothDevice device) {
        if (device == null) {
            return null;
        }
        Iterator it = new ArrayList(this.mBluetoothGatts).iterator();
        while (it.hasNext()) {
            BluetoothGatt bluetoothGatt = (BluetoothGatt) it.next();
            if (device.getAddress().equals(bluetoothGatt.getDevice().getAddress())) {
                return bluetoothGatt;
            }
        }
        return null;
    }

    public boolean isBleConnected(BluetoothDevice device) {
        if (device != null && ConnectUtil.isHasConnectPermission(this.mContext)) {
            Iterator<BluetoothDevice> it = this.mConnectedBleDevices.iterator();
            while (it.hasNext()) {
                if (BluetoothUtil.deviceEquals(it.next(), device)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBle
    public boolean isBleConnecting() {
        if (this.mConnectingBleDevice != null) {
            return true;
        }
        return false;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBle
    public boolean isConnectedBleDevice(BluetoothDevice device) {
        if (device == null || getDeviceGatt(device) == null || !isBleConnected(device)) {
            return false;
        }
        return true;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBle
    @SuppressLint({"MissingPermission"})
    public boolean requestBleMtu(final BluetoothDevice device, final int mtu) {
        if (!ConnectUtil.isHasConnectPermission(this.mContext)) {
            return false;
        }
        BluetoothGatt deviceGatt = getDeviceGatt(device);
        if (deviceGatt == null) {
            JL_Log.e(TAG, "requestBleMtu", "Failed to get gatt.");
            return false;
        }
        String str = TAG;
        JL_Log.i(str, "requestBleMtu", "requestMtu is started.");
        if (!deviceGatt.requestMtu(mtu + 3)) {
            JL_Log.e(str, "requestBleMtu", "requestMtu failed. callback old mtu.");
            addBleMtu(device, 20);
            this.mBleEventCbManager.onBleMtuChanged(device, 20, 257);
            return false;
        }
        return true;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void setBluetoothOption(BluetoothOption option) {
        if (option != null) {
            this.mBluetoothOption = option;
        }
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBle
    public void setConnectedBleDevice(BluetoothDevice device) {
        if (!BluetoothUtil.deviceEquals(this.mConnectedBleDevice, device)) {
            this.mConnectedBleDevice = device;
            if (device != null) {
                this.mBleEventCbManager.onSwitchBleDevice(device);
            }
        }
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBle
    public void writeDataByBleAsync(BluetoothDevice device, UUID serviceUUID, UUID characteristicUUID, byte[] data, OnWriteDataCallback callback) {
        addSendTask(device, serviceUUID, characteristicUUID, data, callback);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBle
    @SuppressLint({"MissingPermission"})
    public synchronized boolean writeDataByBleSync(BluetoothDevice device, UUID serviceUUID, UUID characteristicUUID, byte[] data) {
        boolean z = false;
        if (device != null) {
            if (ConnectUtil.isHasConnectPermission(this.mContext) && serviceUUID != null && characteristicUUID != null) {
                if (data != null && data.length != 0) {
                    BluetoothGatt deviceGatt = getDeviceGatt(device);
                    if (deviceGatt == null) {
                        JL_Log.i(TAG, "writeDataByBleSync", "No Gatt.");
                        return false;
                    }
                    BluetoothGattService service = deviceGatt.getService(serviceUUID);
                    if (service == null) {
                        JL_Log.i(TAG, "writeDataByBleSync", "No Gatt Service.");
                        return false;
                    }
                    BluetoothGattCharacteristic characteristic = service.getCharacteristic(characteristicUUID);
                    if (characteristic == null) {
                        JL_Log.i(TAG, "writeDataByBleSync", "No Gatt Characteristic.");
                        return false;
                    }
                    try {
                        characteristic.setValue(data);
                        z = deviceGatt.writeCharacteristic(characteristic);
                    } catch (Exception e) {
                        e.printStackTrace();
                        JL_Log.e(TAG, "writeDataByBleSync", "exception : " + e);
                    }
                    JL_Log.d(TAG, "writeDataByBleSync", "send data : " + z);
                    return z;
                }
                JL_Log.i(TAG, "writeDataByBleSync", "data is empty.");
                return false;
            }
        }
        JL_Log.i(TAG, "writeDataByBleSync", "param is error.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String printDeviceInfo(BluetoothDevice device) {
        return printDeviceInfo(device, true);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void addListener(OnBtBleListener listener) {
        this.mBleEventCbManager.addListener(listener);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void removeListener(OnBtBleListener listener) {
        this.mBleEventCbManager.removeListener(listener);
    }
}
