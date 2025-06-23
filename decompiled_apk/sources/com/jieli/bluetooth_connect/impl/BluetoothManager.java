package com.jieli.bluetooth_connect.impl;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelUuid;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.facebook.login.widget.ToolTipPopup;
import com.jieli.bluetooth_connect.bean.BluetoothOption;
import com.jieli.bluetooth_connect.bean.ErrorInfo;
import com.jieli.bluetooth_connect.bean.ble.BleScanMessage;
import com.jieli.bluetooth_connect.bean.history.HistoryRecord;
import com.jieli.bluetooth_connect.constant.BluetoothConstant;
import com.jieli.bluetooth_connect.data.HistoryRecordDbHelper;
import com.jieli.bluetooth_connect.data.HistoryRecordObserver;
import com.jieli.bluetooth_connect.interfaces.IBluetoothOperation;
import com.jieli.bluetooth_connect.interfaces.callback.BluetoothEventCallback;
import com.jieli.bluetooth_connect.interfaces.callback.OnHistoryRecordCallback;
import com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtBleListener;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtDiscoveryListener;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtSppListener;
import com.jieli.bluetooth_connect.interfaces.listener.OnWriteDataCallback;
import com.jieli.bluetooth_connect.tool.BluetoothEventCbManager;
import com.jieli.bluetooth_connect.tool.ReConnectHelper;
import com.jieli.bluetooth_connect.util.BluetoothUtil;
import com.jieli.bluetooth_connect.util.CHexConverter;
import com.jieli.bluetooth_connect.util.ConnectUtil;
import com.jieli.bluetooth_connect.util.JL_Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes10.dex */
public class BluetoothManager implements IBluetoothOperation {
    private static final int ADJUST_BLE_MTU_TIMEOUT = 6000;
    private static final int MSG_ADJUST_BLE_MTU_TIMEOUT = 4113;
    private static final int MSG_CONNECT_DEVICE_TIMEOUT = 4112;
    private static final int MSG_RECONNECT_DEVICE = 4114;
    private static final int REMOVE_HISTORY_RECORD_TIMEOUT = 10000;
    private static final String TAG = "BluetoothManager";
    private final BluetoothBle mBluetoothBle;
    private final BluetoothBrEdr mBluetoothBrEdr;
    private final BluetoothDiscovery mBluetoothDiscovery;
    private BluetoothOption mBluetoothOption;
    private final BluetoothPair mBluetoothPair;
    private final BluetoothSpp mBluetoothSpp;
    private volatile BluetoothDevice mConnectedDevice;
    private volatile BluetoothDevice mConnectingDevice;
    private final Context mContext;
    private final HistoryRecordDbHelper mHistoryRecordDbHelper;
    private final OnBrEdrListener mOnBrEdrListener;
    private final OnBtBleListener mOnBtBleListener;
    private final OnBtDevicePairListener mOnBtDevicePairListener;
    private final OnBtDiscoveryListener mOnBtDiscoveryListener;
    private final OnBtSppListener mOnBtSppListener;
    private final ReConnectHelper mReConnectHelper;
    private RemoveHistoryRecordTask mRemoveHistoryRecordTask;
    private final BluetoothEventCbManager mEventCbManager = new BluetoothEventCbManager();
    private final List<BluetoothDevice> mConnectedBtDevices = Collections.synchronizedList(new ArrayList());
    private final Set<String> mSkipRecordSet = new HashSet();
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.bluetooth_connect.impl.xxIXOIIO
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            boolean lambda$new$0;
            lambda$new$0 = BluetoothManager.this.lambda$new$0(message);
            return lambda$new$0;
        }
    });

    /* loaded from: classes10.dex */
    public class RemoveHistoryRecordTask implements Runnable {
        public static final int STATE_END = 2;
        public static final int STATE_REMOVE_DEVICE = 0;
        public static final int STATE_REMOVE_MAPPED = 1;
        public static final int WAY_DISCONNECT = 1;
        public static final int WAY_REMOVE = 0;
        public String disconnectAddress;
        private final HistoryRecord mHistoryRecord;
        private final OnHistoryRecordCallback mOnHistoryRecordCallback;
        public String removeAddress;
        private final String tag = RemoveHistoryRecordTask.class.getSimpleName();
        public int state = 0;

        public RemoveHistoryRecordTask(@NonNull HistoryRecord record, final OnHistoryRecordCallback callback) {
            this.mHistoryRecord = record;
            this.mOnHistoryRecordCallback = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            BluetoothDevice bluetoothDevice;
            int i = this.state;
            if (i == 0) {
                bluetoothDevice = BluetoothUtil.getRemoteDevice(BluetoothManager.this.mContext, this.mHistoryRecord.getAddress());
            } else {
                if (i == 1) {
                    if (!this.mHistoryRecord.getAddress().equals(this.mHistoryRecord.getMappedAddress())) {
                        bluetoothDevice = BluetoothUtil.getRemoteDevice(BluetoothManager.this.mContext, this.mHistoryRecord.getMappedAddress());
                    } else {
                        JL_Log.d(BluetoothManager.TAG, this.tag, "same address, skip");
                        this.state++;
                    }
                }
                bluetoothDevice = null;
            }
            JL_Log.d(BluetoothManager.TAG, this.tag, "start ---> state = " + this.state + ", device = " + BluetoothManager.this.printDeviceInfo(bluetoothDevice));
            if (bluetoothDevice != null) {
                this.removeAddress = bluetoothDevice.getAddress();
                if (BluetoothManager.this.isConnectedDevice(bluetoothDevice)) {
                    this.disconnectAddress = bluetoothDevice.getAddress();
                    BluetoothManager.this.mHandler.postDelayed(this, 10000L);
                    BluetoothManager.this.disconnectBtDevice(bluetoothDevice);
                    JL_Log.i(BluetoothManager.TAG, this.tag, "disconnectBtDevice >>> ");
                    return;
                }
                if (BluetoothManager.this.isConnectedByProfile(bluetoothDevice) == 2) {
                    this.disconnectAddress = bluetoothDevice.getAddress();
                    BluetoothManager.this.mHandler.postDelayed(this, 10000L);
                    if (BluetoothManager.this.disconnectByProfiles(bluetoothDevice)) {
                        JL_Log.i(BluetoothManager.TAG, this.tag, "disconnectByProfiles >>> ");
                        return;
                    }
                }
                this.disconnectAddress = null;
                if (BluetoothManager.this.isPaired(bluetoothDevice)) {
                    boolean tryToUnPair = BluetoothManager.this.tryToUnPair(bluetoothDevice);
                    JL_Log.i(BluetoothManager.TAG, this.tag, "tryToUnPair ---> " + tryToUnPair);
                    if (tryToUnPair) {
                        this.state++;
                        BluetoothManager.this.mHandler.postDelayed(this, 32000L);
                        return;
                    }
                }
            }
            JL_Log.i(BluetoothManager.TAG, this.tag, "end :: state = " + this.state);
            int i2 = this.state;
            if (i2 <= 1) {
                this.state = i2 + 1;
                this.removeAddress = null;
                BluetoothManager.this.mHandler.post(this);
            } else {
                BluetoothManager.this.mHistoryRecordDbHelper.deleteHistoryRecord(this.mHistoryRecord);
                OnHistoryRecordCallback onHistoryRecordCallback = this.mOnHistoryRecordCallback;
                if (onHistoryRecordCallback != null) {
                    onHistoryRecordCallback.onSuccess(this.mHistoryRecord);
                }
                BluetoothManager.this.mRemoveHistoryRecordTask = null;
            }
        }
    }

    public BluetoothManager(Context context, BluetoothOption option) {
        OnBtDiscoveryListener onBtDiscoveryListener = new OnBtDiscoveryListener() { // from class: com.jieli.bluetooth_connect.impl.BluetoothManager.2
            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDiscoveryListener
            public void onDiscoveryDevice(BluetoothDevice device, BleScanMessage bleScanMessage) {
                BluetoothManager.this.mEventCbManager.onDiscovery(device, bleScanMessage);
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDiscoveryListener
            public void onDiscoveryError(ErrorInfo error) {
                JL_Log.e(BluetoothManager.TAG, "onDiscoveryError", "" + error);
                BluetoothManager.this.mEventCbManager.onDiscoveryStatus(true, false);
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDiscoveryListener
            public void onDiscoveryStatusChange(boolean isBle, boolean bStart) {
                BluetoothManager.this.mEventCbManager.onDiscoveryStatus(isBle, bStart);
                if (bStart) {
                    BluetoothManager.this.syncSystemBtDeviceList(isBle);
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDiscoveryListener
            public void onShowProductDialog(BluetoothDevice device, BleScanMessage bleScanMessage) {
                BluetoothManager.this.mEventCbManager.onShowDialog(device, bleScanMessage);
            }
        };
        this.mOnBtDiscoveryListener = onBtDiscoveryListener;
        OnBtDevicePairListener onBtDevicePairListener = new OnBtDevicePairListener() { // from class: com.jieli.bluetooth_connect.impl.BluetoothManager.3
            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener
            public void onAdapterStatus(boolean bEnabled, boolean bHasBle) {
                BluetoothManager.this.mEventCbManager.onAdapterStatus(bEnabled, bHasBle);
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener
            public void onBtDeviceBond(BluetoothDevice device, int status) {
                HistoryRecord historyRecord;
                BluetoothManager.this.mEventCbManager.onBondStatus(device, status);
                if (device != null && status == 10 && !BluetoothManager.this.notifyRemoveHistoryRecordTask(device, 0) && (historyRecord = BluetoothManager.this.getHistoryRecord(device.getAddress())) != null) {
                    if (!BluetoothManager.this.mBluetoothOption.isNotAssociatedEDR()) {
                        BluetoothManager bluetoothManager = BluetoothManager.this;
                        bluetoothManager.disconnectBtDevice(BluetoothUtil.getRemoteDevice(bluetoothManager.mContext, historyRecord.getAddress()));
                        BluetoothManager.this.mHistoryRecordDbHelper.deleteHistoryRecord(historyRecord);
                        return;
                    }
                    JL_Log.w(BluetoothManager.TAG, "onBtDeviceBond", ConnectUtil.formatString("Device[%s] is un-bonded.Skipping the progress of delete history record.", device));
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener
            public void onPairError(BluetoothDevice device, ErrorInfo error) {
                if (error != null) {
                    error.setDevice(device);
                }
                BluetoothManager.this.mEventCbManager.onError(error);
                BluetoothManager.this.notifyRemoveHistoryRecordTask(device, 0);
            }
        };
        this.mOnBtDevicePairListener = onBtDevicePairListener;
        OnBrEdrListener onBrEdrListener = new OnBrEdrListener() { // from class: com.jieli.bluetooth_connect.impl.BluetoothManager.4
            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
            public void onA2dpStatus(BluetoothDevice device, int status) {
                BluetoothManager.this.mEventCbManager.onA2dpStatus(device, status);
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
            public void onBrEdrConnection(BluetoothDevice device, int status) {
                BluetoothManager.this.mEventCbManager.onBtDeviceConnectStatus(device, status);
                if (status == 2) {
                    HistoryRecord historyRecord = BluetoothManager.this.getHistoryRecord(device.getAddress());
                    if (historyRecord == null) {
                        return;
                    }
                    BluetoothDevice remoteDevice = BluetoothUtil.getRemoteDevice(BluetoothManager.this.mContext, historyRecord.getAddress());
                    boolean isConnectedDevice = BluetoothManager.this.isConnectedDevice(remoteDevice);
                    boolean z = !isConnectedDevice;
                    if (!isConnectedDevice && !BluetoothManager.this.mBluetoothOption.isUseMultiDevice() && BluetoothManager.this.getConnectedDevice() != null) {
                        BluetoothManager bluetoothManager = BluetoothManager.this;
                        if (!bluetoothManager.isMatchDevice(bluetoothManager.getConnectedDevice(), device)) {
                            z = false;
                        }
                    }
                    if (z && !BluetoothManager.this.mBluetoothOption.isReconnect()) {
                        z = false;
                    }
                    if (z) {
                        BluetoothManager.this.mHandler.removeMessages(4114);
                        BluetoothManager.this.mHandler.sendMessageDelayed(BluetoothManager.this.mHandler.obtainMessage(4114, historyRecord.getConnectType(), 0, remoteDevice), 800L);
                        return;
                    }
                    return;
                }
                if (status == 0) {
                    BluetoothManager.this.notifyRemoveHistoryRecordTask(device, 1);
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
            public void onDeviceUuids(BluetoothDevice device, ParcelUuid[] uuids) {
                BluetoothManager.this.mEventCbManager.onDeviceUuidsDiscovery(device, uuids);
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
            public void onEdrService(boolean isConnected, int profile, BluetoothProfile proxy) {
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
            public void onHfpStatus(BluetoothDevice device, int status) {
                BluetoothManager.this.mEventCbManager.onHfpStatus(device, status);
            }
        };
        this.mOnBrEdrListener = onBrEdrListener;
        OnBtSppListener onBtSppListener = new OnBtSppListener() { // from class: com.jieli.bluetooth_connect.impl.BluetoothManager.5
            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtSppListener
            public void onSppConnection(BluetoothDevice device, UUID uuid, int status) {
                BluetoothManager.this.mEventCbManager.onSppStatus(device, status);
                JL_Log.i(BluetoothManager.TAG, "onSppConnection", "device : " + BluetoothManager.this.printDeviceInfo(device) + ", uuid = " + uuid + ", state : " + BluetoothConstant.printBtConnection(status));
                if (status != 1) {
                    BluetoothManager.this.notifyConnectionStatus(device, status);
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtSppListener
            public void onSppDataNotify(BluetoothDevice device, UUID sppUUID, byte[] data) {
                BluetoothManager.this.mEventCbManager.onSppDataNotification(device, sppUUID, data);
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtSppListener
            public void onSwitchSppDevice(BluetoothDevice device) {
            }
        };
        this.mOnBtSppListener = onBtSppListener;
        OnBtBleListener onBtBleListener = new OnBtBleListener() { // from class: com.jieli.bluetooth_connect.impl.BluetoothManager.6
            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtBleListener
            public void onBleBond(BluetoothDevice device, int bondStatus) {
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtBleListener
            public void onBleConnection(BluetoothDevice device, int status) {
                BluetoothManager.this.mEventCbManager.onBleConnection(device, status);
                JL_Log.i(BluetoothManager.TAG, "onBleConnection", "device : " + BluetoothManager.this.printDeviceInfo(device) + ", status : " + BluetoothConstant.printBtConnection(status));
                if (status != 1) {
                    BluetoothManager.this.notifyConnectionStatus(device, status);
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtBleListener
            public void onBleDataNotify(BluetoothDevice device, UUID serviceUuid, UUID characteristicsUuid, byte[] data) {
                BluetoothManager.this.mEventCbManager.onBleDataNotification(device, serviceUuid, characteristicsUuid, data);
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtBleListener
            public void onBleMtuChanged(BluetoothDevice device, int block, int status) {
                BluetoothManager.this.mEventCbManager.onBleDataBlockChanged(device, block, status);
                if (BluetoothManager.this.mHandler.hasMessages(4113)) {
                    BluetoothManager.this.mHandler.removeMessages(4113);
                    BluetoothManager.this.mEventCbManager.onConnection(device, 2);
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtBleListener
            public void onBleNotificationStatus(BluetoothDevice device, UUID serviceUuid, UUID characteristicUuid, boolean bEnabled) {
                BluetoothManager.this.mEventCbManager.onBleNotificationStatus(device, serviceUuid, characteristicUuid, bEnabled);
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtBleListener
            public void onBleWriteStatus(BluetoothDevice device, UUID serviceUuid, UUID characteristicsUuid, byte[] data, int status) {
                BluetoothManager.this.mEventCbManager.onBleWriteStatus(device, serviceUuid, characteristicsUuid, data, status);
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtBleListener
            public void onConnectionUpdatedCallback(BluetoothGatt gatt, int interval, int latency, int timeout, int status) {
                BluetoothManager.this.mEventCbManager.onConnectionUpdated(gatt, interval, latency, timeout, status);
            }

            @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtBleListener
            public void onSwitchBleDevice(BluetoothDevice device) {
            }
        };
        this.mOnBtBleListener = onBtBleListener;
        Context context2 = (Context) ConnectUtil.checkNotNull(context);
        this.mContext = context2;
        ConnectUtil.setContext(context2);
        option = option == null ? BluetoothOption.createDefaultOption() : option;
        this.mBluetoothOption = option;
        JL_Log.i(TAG, "init", "Lib name = " + BluetoothConstant.getLibVersionName() + ", option = " + option + ",\n clazz : " + this);
        this.mBluetoothDiscovery = new BluetoothDiscovery(context, option, onBtDiscoveryListener);
        BluetoothPair bluetoothPair = new BluetoothPair(context, onBtDevicePairListener);
        this.mBluetoothPair = bluetoothPair;
        bluetoothPair.setBluetoothOption(option);
        BluetoothBrEdr bluetoothBrEdr = new BluetoothBrEdr(context, bluetoothPair, onBrEdrListener);
        this.mBluetoothBrEdr = bluetoothBrEdr;
        bluetoothBrEdr.setBluetoothOption(option);
        this.mBluetoothSpp = new BluetoothSpp(context, bluetoothBrEdr, option, onBtSppListener);
        this.mBluetoothBle = new BluetoothBle(context, bluetoothPair, option, onBtBleListener);
        this.mReConnectHelper = new ReConnectHelper(context, this);
        this.mHistoryRecordDbHelper = new HistoryRecordDbHelper(context, this.mBluetoothOption, new HistoryRecordObserver() { // from class: com.jieli.bluetooth_connect.impl.BluetoothManager.1
            @Override // com.jieli.bluetooth_connect.data.HistoryRecordObserver
            public void onDelete(HistoryRecord record) {
                BluetoothManager.this.mEventCbManager.onHistoryRecordChange(1, record);
            }

            @Override // com.jieli.bluetooth_connect.data.HistoryRecordObserver
            public void onInsert(HistoryRecord record) {
                BluetoothManager.this.mEventCbManager.onHistoryRecordChange(0, record);
            }

            @Override // com.jieli.bluetooth_connect.data.HistoryRecordObserver
            public void onModify(HistoryRecord record) {
                BluetoothManager.this.mEventCbManager.onHistoryRecordChange(2, record);
            }
        });
    }

    private void changeConnectedDevice(BluetoothDevice device) {
        if (!BluetoothUtil.deviceEquals(this.mConnectedDevice, device)) {
            BluetoothDevice bluetoothDevice = this.mConnectedDevice;
            this.mConnectedDevice = device;
            if (bluetoothDevice != null && isConnectedDevice(device)) {
                if (this.mBluetoothBle.isConnectedBleDevice(device)) {
                    this.mBluetoothBle.setConnectedBleDevice(device);
                } else if (this.mBluetoothSpp.isConnectedSppDevice(device)) {
                    this.mBluetoothSpp.setConnectedSppDevice(device);
                }
                HistoryRecord historyRecord = getHistoryRecord(device.getAddress());
                historyRecord.setOnlineTime(System.currentTimeMillis());
                this.mHistoryRecordDbHelper.updateHistoryRecord(historyRecord);
                this.mEventCbManager.onSwitchConnectedDevice(device);
            }
            JL_Log.d(TAG, "changeConnectedDevice", "device : " + printDeviceInfo(device));
        }
    }

    private boolean checkIsValidDevice(BluetoothDevice device) {
        if (device == null) {
            return false;
        }
        if (!BluetoothUtil.deviceEquals(device, getConnectingDevice()) && !BluetoothUtil.deviceEquals(device, getConnectingBrEdrDevice()) && !isConnectedDevice(device) && getHistoryRecord(device.getAddress()) == null && !this.mConnectedBtDevices.contains(device)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(Message message) {
        switch (message.what) {
            case 4112:
                BluetoothDevice bluetoothDevice = (BluetoothDevice) message.obj;
                if (bluetoothDevice != null) {
                    if (!isConnectedDevice(bluetoothDevice)) {
                        JL_Log.i(TAG, "MSG_CONNECT_DEVICE_TIMEOUT", "connect timeout, device : " + printDeviceInfo(bluetoothDevice));
                        notifyConnectionStatus(bluetoothDevice, 0);
                        if (isConnecting()) {
                            disconnectBtDevice(bluetoothDevice);
                        }
                    }
                    setConnectingDevice(null);
                    return true;
                }
                return true;
            case 4113:
                BluetoothDevice bluetoothDevice2 = (BluetoothDevice) message.obj;
                if (bluetoothDevice2 != null && isConnectedDevice(bluetoothDevice2)) {
                    this.mEventCbManager.onConnection(bluetoothDevice2, 2);
                    return true;
                }
                return true;
            case 4114:
                Object obj = message.obj;
                if (!(obj instanceof BluetoothDevice)) {
                    return false;
                }
                BluetoothDevice bluetoothDevice3 = (BluetoothDevice) obj;
                JL_Log.d(TAG, "MSG_RECONNECT_DEVICE", "device : " + bluetoothDevice3);
                connectBtDevice(bluetoothDevice3, message.arg1);
                return true;
            default:
                return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$writeDataToBLEDevice$1(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, boolean z, byte[] bArr) {
        JL_Log.d(TAG, "writeDataToBLEDevice", ConnectUtil.formatString("---> device : %s, serviceUUID:[%s], characteristicUUID:[%s], data:%s, result:%s", bluetoothDevice, uuid, uuid2, CHexConverter.byte2HexStr(bArr), Boolean.valueOf(z)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyConnectionStatus(BluetoothDevice bluetoothDevice, int i) {
        HistoryRecord historyRecord;
        boolean checkIsValidDevice = checkIsValidDevice(bluetoothDevice);
        String str = TAG;
        JL_Log.e(str, "notifyConnectionStatus", "device : " + printDeviceInfo(bluetoothDevice) + ", checkIsValidDevice : " + checkIsValidDevice + ", status : " + BluetoothConstant.printBtConnection(i));
        if (checkIsValidDevice) {
            if (i != 1) {
                if (BluetoothUtil.deviceEquals(bluetoothDevice, getConnectingDevice())) {
                    setConnectingDevice(null);
                    this.mHandler.removeMessages(4112);
                }
                if (i != 0) {
                    if (i == 2) {
                        if (!this.mConnectedBtDevices.contains(bluetoothDevice)) {
                            this.mConnectedBtDevices.add(bluetoothDevice);
                        }
                        if (this.mConnectedDevice == null) {
                            changeConnectedDevice(bluetoothDevice);
                        }
                        boolean isConnectedSppDevice = isConnectedSppDevice(bluetoothDevice);
                        if (!this.mSkipRecordSet.contains(bluetoothDevice.getAddress())) {
                            this.mHistoryRecordDbHelper.saveHistoryRecord(bluetoothDevice, isConnectedSppDevice ? 1 : 0);
                            if (this.mConnectedDevice != null && !BluetoothUtil.deviceEquals(this.mConnectedDevice, bluetoothDevice) && (historyRecord = getHistoryRecord(this.mConnectedDevice.getAddress())) != null) {
                                historyRecord.setOnlineTime(System.currentTimeMillis() + 200);
                                this.mHistoryRecordDbHelper.updateHistoryRecord(historyRecord);
                            }
                        } else {
                            this.mSkipRecordSet.remove(bluetoothDevice.getAddress());
                        }
                        JL_Log.i(str, "notifyConnectionStatus", "CONNECTION_OK, connected List : " + getConnectedDeviceList().size() + ", connectWay : " + (isConnectedSppDevice ? 1 : 0));
                        if (!isConnectedSppDevice && getBluetoothOption().isNeedChangeBleMtu() && getBluetoothOption().getMtu() > 20 && this.mBluetoothBle.requestBleMtu(bluetoothDevice, getBluetoothOption().getMtu())) {
                            this.mHandler.removeMessages(4113);
                            Handler handler = this.mHandler;
                            handler.sendMessageDelayed(handler.obtainMessage(4113, bluetoothDevice), ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
                            return;
                        }
                    }
                } else {
                    removeDevice(bluetoothDevice);
                    notifyRemoveHistoryRecordTask(bluetoothDevice, 1);
                }
            }
            JL_Log.d(str, "notifyConnectionStatus", "onConnection ---> device : " + printDeviceInfo(bluetoothDevice) + ", status : " + BluetoothConstant.printBtConnection(i));
            this.mEventCbManager.onConnection(bluetoothDevice, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifyRemoveHistoryRecordTask(BluetoothDevice device, int way) {
        boolean z = false;
        if (this.mRemoveHistoryRecordTask != null && device != null) {
            if ((way == 1 && device.getAddress().equals(this.mRemoveHistoryRecordTask.disconnectAddress)) || (way != 1 && device.getAddress().equals(this.mRemoveHistoryRecordTask.removeAddress))) {
                z = true;
            }
            if (z) {
                JL_Log.i(TAG, "notifyRemoveHistoryRecordTask", "device = " + device + ", way = " + way);
                this.mHandler.removeCallbacks(this.mRemoveHistoryRecordTask);
                this.mHandler.post(this.mRemoveHistoryRecordTask);
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String printDeviceInfo(BluetoothDevice device) {
        return BluetoothUtil.printBtDeviceInfo(this.mContext, device);
    }

    private void removeDevice(BluetoothDevice device) {
        if (device != null) {
            this.mConnectedBtDevices.remove(device);
            if (getConnectedDeviceList().isEmpty()) {
                changeConnectedDevice(null);
            } else if (BluetoothUtil.deviceEquals(this.mConnectedDevice, device)) {
                changeConnectedDevice(this.mConnectedBtDevices.get(r2.size() - 1));
            }
        }
    }

    private void setConnectingDevice(BluetoothDevice device) {
        this.mConnectingDevice = device;
    }

    private void startRemoveHistoryRecordTask(HistoryRecord historyRecord, OnHistoryRecordCallback callback) {
        if (this.mRemoveHistoryRecordTask != null) {
            if (callback != null) {
                callback.onFailed(7, ErrorInfo.getErrDesc(7));
            }
        } else {
            RemoveHistoryRecordTask removeHistoryRecordTask = new RemoveHistoryRecordTask(historyRecord, callback);
            this.mRemoveHistoryRecordTask = removeHistoryRecordTask;
            this.mHandler.post(removeHistoryRecordTask);
        }
    }

    private void stopRemoveHistoryRecordTask() {
        RemoveHistoryRecordTask removeHistoryRecordTask = this.mRemoveHistoryRecordTask;
        if (removeHistoryRecordTask != null) {
            this.mHandler.removeCallbacks(removeHistoryRecordTask);
            this.mRemoveHistoryRecordTask = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void syncSystemBtDeviceList(boolean isBleWay) {
        List<BluetoothDevice> systemConnectedBtDeviceList;
        if (!ConnectUtil.isHasConnectPermission(this.mContext) || (systemConnectedBtDeviceList = BluetoothUtil.getSystemConnectedBtDeviceList(this.mContext)) == null) {
            return;
        }
        String scanFilterData = this.mBluetoothOption.getScanFilterData();
        for (BluetoothDevice bluetoothDevice : systemConnectedBtDeviceList) {
            if (!isConnectedDevice(bluetoothDevice) && !getDiscoveredBluetoothDevices().contains(bluetoothDevice)) {
                int type = bluetoothDevice.getType();
                if ((isBleWay && (type == 2 || type == 3)) || (bluetoothDevice.getName() != null && scanFilterData != null && bluetoothDevice.getName().startsWith(scanFilterData))) {
                    BleScanMessage bleScanMessage = new BleScanMessage();
                    bleScanMessage.setEnableConnect(true);
                    this.mEventCbManager.onDiscovery(bluetoothDevice, bleScanMessage);
                }
            }
        }
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public void clearHistoryRecords() {
        this.mHistoryRecordDbHelper.clearAllHistoryRecord();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean connectBLEDevice(BluetoothDevice device) {
        return this.mBluetoothBle.connectBLEDevice(device);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    @SuppressLint({"MissingPermission"})
    public boolean connectBtDevice(BluetoothDevice device, int connectWay) {
        String str = TAG;
        JL_Log.i(str, "connectBtDevice", "device : " + printDeviceInfo(device) + ", connectWay = " + connectWay);
        if (device != null && ConnectUtil.isHasConnectPermission(this.mContext)) {
            if (!BluetoothUtil.isBluetoothEnable()) {
                JL_Log.i(str, "connectBtDevice", "isBluetoothEnabled : false.");
                return false;
            }
            if (isConnecting()) {
                JL_Log.i(str, "connectBtDevice", "device is connecting. device : " + printDeviceInfo(getConnectingDevice()));
                return false;
            }
            if (isConnectedDevice(device)) {
                JL_Log.i(str, "connectBtDevice", "Device is connected.");
                notifyConnectionStatus(device, 2);
                return true;
            }
            JL_Log.d(str, "connectBtDevice", "isUseMultiDevice : " + this.mBluetoothOption.isUseMultiDevice());
            if (!this.mBluetoothOption.isUseMultiDevice()) {
                BluetoothDevice connectedDevice = getConnectedDevice();
                JL_Log.d(str, "connectBtDevice", "connectedDevice : " + printDeviceInfo(connectedDevice));
                if (connectedDevice != null && !BluetoothUtil.deviceEquals(connectedDevice, device)) {
                    disconnectBtDevice(connectedDevice);
                    SystemClock.sleep(300L);
                }
            }
            setConnectingDevice(device);
            notifyConnectionStatus(device, 1);
            this.mHandler.removeMessages(4112);
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(4112, device), 40000L);
            int type = device.getType();
            if (type != 0) {
                if (type != 1) {
                    if (type != 2) {
                        if (type != 3) {
                            return true;
                        }
                    } else {
                        JL_Log.w(str, "connectBtDevice", "connectBLEDevice by device type");
                        return connectBLEDevice(device);
                    }
                } else {
                    JL_Log.w(str, "connectBtDevice", "connectSPPDevice by device type");
                    return connectSPPDevice(device);
                }
            }
            if (connectWay == 0) {
                JL_Log.w(str, "connectBtDevice", "connectBLEDevice by connectWay");
                return connectBLEDevice(device);
            }
            JL_Log.w(str, "connectBtDevice", "connectSPPDevice by connectWay");
            return connectSPPDevice(device);
        }
        JL_Log.i(str, "connectBtDevice", "device is null");
        return false;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean connectBtDeviceWithoutRecord(BluetoothDevice device, int connectWay) {
        if (device != null) {
            this.mSkipRecordSet.add(device.getAddress());
        }
        return connectBtDevice(device, connectWay);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean connectByProfiles(BluetoothDevice device) {
        return this.mBluetoothBrEdr.connectByProfiles(device);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public void connectHistoryRecord(HistoryRecord record, OnHistoryRecordCallback callback) {
        boolean z;
        String address;
        int connectType;
        if (record == null) {
            return;
        }
        int i = 0;
        if (record.getDevType() != 5 && record.getSdkFlag() != 8 && record.getSdkFlag() != 9) {
            z = false;
        } else {
            z = true;
        }
        if (record.getConnectType() == 1 && z) {
            address = record.getMappedAddress();
        } else {
            address = record.getAddress();
        }
        if (z) {
            connectType = 0;
        } else {
            connectType = record.getConnectType();
        }
        if (BluetoothAdapter.checkBluetoothAddress(record.getUpdateAddress()) && !record.getUpdateAddress().equals(address)) {
            address = record.getUpdateAddress();
        } else {
            i = connectType;
        }
        this.mReConnectHelper.reconnectDevice(address, i, callback);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean connectSPPDevice(BluetoothDevice device) {
        return this.mBluetoothSpp.connectSPPDevice(device);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation, com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void destroy() {
        JL_Log.w(TAG, "destroy", "");
        stopRemoveHistoryRecordTask();
        this.mBluetoothBle.removeListener(this.mOnBtBleListener);
        this.mBluetoothBle.destroy();
        this.mBluetoothSpp.removeListener(this.mOnBtSppListener);
        this.mBluetoothSpp.destroy();
        this.mBluetoothBrEdr.removeListener(this.mOnBrEdrListener);
        this.mBluetoothBrEdr.destroy();
        this.mBluetoothPair.removeListener(this.mOnBtDevicePairListener);
        this.mBluetoothPair.destroy();
        this.mBluetoothDiscovery.removeListener(this.mOnBtDiscoveryListener);
        this.mBluetoothDiscovery.destroy();
        this.mEventCbManager.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        this.mConnectedBtDevices.clear();
        this.mSkipRecordSet.clear();
        this.mReConnectHelper.destroy();
        this.mHistoryRecordDbHelper.destroy();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean disconnectBLEDevice(BluetoothDevice device) {
        return this.mBluetoothBle.disconnectBLEDevice(device);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public void disconnectBtDevice(BluetoothDevice device) {
        String str = TAG;
        JL_Log.d(str, "disconnectBtDevice", "device : " + printDeviceInfo(device));
        if (device == null) {
            JL_Log.i(str, "disconnectBtDevice", "device is null.");
            return;
        }
        if (isConnectedBLEDevice(device)) {
            disconnectBLEDevice(device);
        } else if (isConnectedSppDevice(device)) {
            disconnectSPPDevice(device);
        } else {
            notifyConnectionStatus(device, 0);
        }
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean disconnectByProfiles(BluetoothDevice device) {
        return this.mBluetoothBrEdr.disconnectByProfiles(device);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean disconnectSPPDevice(BluetoothDevice device) {
        return this.mBluetoothSpp.disconnectSPPDevice(device);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public void fastConnect() {
        List<HistoryRecord> historyRecordList = getHistoryRecordList();
        if (historyRecordList != null && !historyRecordList.isEmpty()) {
            Iterator<HistoryRecord> it = historyRecordList.iterator();
            while (it.hasNext()) {
                this.mReConnectHelper.reconnectHistory(it.next());
            }
        }
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public BluetoothDevice getActivityBluetoothDevice() {
        return this.mBluetoothBrEdr.getActivityBluetoothDevice();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public int getBleMtu(BluetoothDevice device) {
        return this.mBluetoothBle.getBleMtu(device);
    }

    public BluetoothBle getBluetoothBle() {
        return this.mBluetoothBle;
    }

    public BluetoothBrEdr getBluetoothBrEdr() {
        return this.mBluetoothBrEdr;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public BluetoothOption getBluetoothOption() {
        return this.mBluetoothOption;
    }

    public BluetoothPair getBluetoothPair() {
        return this.mBluetoothPair;
    }

    public BluetoothSpp getBluetoothSpp() {
        return this.mBluetoothSpp;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public BluetoothGatt getConnectedBluetoothGatt() {
        return this.mBluetoothBle.getConnectedBluetoothGatt();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public BluetoothDevice getConnectedDevice() {
        if (this.mConnectedDevice == null && !this.mConnectedBtDevices.isEmpty()) {
            this.mConnectedDevice = this.mConnectedBtDevices.get(0);
        }
        if (this.mConnectedDevice == null) {
            this.mConnectedDevice = this.mBluetoothBle.getConnectedBleDevice();
        }
        if (this.mConnectedDevice == null) {
            this.mConnectedDevice = this.mBluetoothSpp.getConnectedSPPDevice();
        }
        return this.mConnectedDevice;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public List<BluetoothDevice> getConnectedDeviceList() {
        return new ArrayList(this.mConnectedBtDevices);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public List<BluetoothDevice> getConnectedSppList() {
        return this.mBluetoothSpp.getConnectedSppDevices();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public BluetoothDevice getConnectingBrEdrDevice() {
        return this.mBluetoothBrEdr.getConnectingBrEdrDevice();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public BluetoothDevice getConnectingDevice() {
        if (this.mConnectingDevice == null) {
            this.mConnectingDevice = this.mBluetoothBle.getConnectingBleDevice();
        }
        if (this.mConnectingDevice == null) {
            this.mConnectingDevice = this.mBluetoothSpp.getSppConnectingDevice();
        }
        return this.mConnectingDevice;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public BluetoothGatt getDeviceGatt(BluetoothDevice device) {
        return this.mBluetoothBle.getDeviceGatt(device);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public ArrayList<BluetoothDevice> getDiscoveredBluetoothDevices() {
        return this.mBluetoothDiscovery.getDiscoveredBluetoothDevices();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public HistoryRecord getHistoryRecord(String devAddress) {
        return this.mHistoryRecordDbHelper.getHistoryRecordByMac(devAddress);
    }

    public HistoryRecordDbHelper getHistoryRecordHelper() {
        return this.mHistoryRecordDbHelper;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public List<HistoryRecord> getHistoryRecordList() {
        return this.mHistoryRecordDbHelper.getHistoryRecordList();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public String getMappedDeviceAddress(String deviceAddress) {
        return this.mHistoryRecordDbHelper.getMappedAddress(deviceAddress);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    public List<BluetoothDevice> getPairedDevices() {
        return this.mBluetoothPair.getPairedDevices();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public int getScanType() {
        return this.mBluetoothDiscovery.getScanType();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean isBrEdrConnecting() {
        return this.mBluetoothBrEdr.isBrEdrConnecting();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean isConnectedBLEDevice(BluetoothDevice device) {
        return this.mBluetoothBle.isConnectedBleDevice(device);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public int isConnectedByA2dp(BluetoothDevice device) {
        return this.mBluetoothBrEdr.isConnectedByA2dp(device);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public int isConnectedByHfp(BluetoothDevice device) {
        return this.mBluetoothBrEdr.isConnectedByHfp(device);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public int isConnectedByProfile(BluetoothDevice device) {
        return this.mBluetoothBrEdr.isConnectedByProfile(device);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean isConnectedDevice(BluetoothDevice device) {
        boolean isConnectedBleDevice = this.mBluetoothBle.isConnectedBleDevice(device);
        boolean isConnectedSppDevice = this.mBluetoothSpp.isConnectedSppDevice(device);
        JL_Log.d(TAG, "isConnectedDevice", "device : " + device + ", isBleConnected = " + isConnectedBleDevice + ", isSppConnected = " + isConnectedSppDevice);
        if (!isConnectedBleDevice && !isConnectedSppDevice) {
            return false;
        }
        return true;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean isConnectedSppDevice(BluetoothDevice device) {
        return this.mBluetoothSpp.isConnectedSppDevice(device);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean isConnecting() {
        if (this.mConnectingDevice == null && !this.mBluetoothBle.isBleConnecting() && !this.mBluetoothSpp.isSppConnecting()) {
            return false;
        }
        return true;
    }

    public boolean isMatchDevice(BluetoothDevice device1, BluetoothDevice device2) {
        if (device1 != null && device2 != null) {
            boolean deviceEquals = BluetoothUtil.deviceEquals(device1, device2);
            if (!deviceEquals) {
                return device2.getAddress().equals(getMappedDeviceAddress(device1.getAddress()));
            }
            return deviceEquals;
        }
        return false;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    public boolean isPaired(BluetoothDevice device) {
        return this.mBluetoothPair.isPaired(device);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    public boolean isPairing(BluetoothDevice device) {
        return this.mBluetoothPair.isPairing(device);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean isReconnectDevice() {
        return this.mReConnectHelper.isReconnecting();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean isScanning() {
        return this.mBluetoothDiscovery.isScanning();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    public boolean pair(BluetoothDevice device) {
        return this.mBluetoothPair.pair(device);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean registerBluetoothCallback(BluetoothEventCallback bluetoothCallback) {
        return this.mEventCbManager.addListener(bluetoothCallback);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public void removeHistoryRecord(String address, OnHistoryRecordCallback callback) {
        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            if (callback != null) {
                callback.onFailed(1, "address is error.");
                return;
            }
            return;
        }
        HistoryRecord historyRecord = getHistoryRecord(address);
        if (historyRecord == null) {
            if (callback != null) {
                callback.onSuccess(null);
                return;
            }
            return;
        }
        startRemoveHistoryRecordTask(historyRecord, callback);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean requestBleMtu(BluetoothDevice device, int mtu) {
        return this.mBluetoothBle.requestBleMtu(device, mtu);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean sendDataToDevice(BluetoothDevice device, byte[] data) {
        if (device == null || data == null || !isConnectedDevice(device)) {
            return false;
        }
        if (isConnectedBLEDevice(device)) {
            return writeDataToBLEDevice(device, getBluetoothOption().getBleServiceUUID(), getBluetoothOption().getBleWriteUUID(), data);
        }
        if (!isConnectedSppDevice(device)) {
            return false;
        }
        return writeDataToSppDevice(device, data);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean setActivityBluetoothDevice(BluetoothDevice device) {
        return this.mBluetoothBrEdr.setActivityBluetoothDevice(device);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation, com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void setBluetoothOption(BluetoothOption bluetoothOption) {
        if (bluetoothOption == null) {
            bluetoothOption = BluetoothOption.createDefaultOption();
        }
        this.mBluetoothOption = bluetoothOption;
        JL_Log.d(TAG, "setBluetoothOption", "" + bluetoothOption);
        this.mBluetoothBle.setBluetoothOption(bluetoothOption);
        this.mBluetoothSpp.setBluetoothOption(bluetoothOption);
        this.mBluetoothBrEdr.setBluetoothOption(bluetoothOption);
        this.mBluetoothPair.setBluetoothOption(bluetoothOption);
        this.mBluetoothDiscovery.setBluetoothOption(bluetoothOption);
        this.mHistoryRecordDbHelper.syncSystemDeviceList(bluetoothOption);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public void setConnectedDevice(BluetoothDevice device) {
        if (isConnectedDevice(device) && !BluetoothUtil.deviceEquals(this.mConnectedDevice, device)) {
            changeConnectedDevice(device);
        }
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean startBLEScan(long timeout) {
        return this.mBluetoothDiscovery.startBLEScan(timeout);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean startConnectByBreProfiles(BluetoothDevice breDevice) {
        return this.mBluetoothBrEdr.connectBrEdrDevice(breDevice);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean startDeviceScan(long timeout) {
        return this.mBluetoothDiscovery.startDeviceScan(timeout);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean stopBLEScan() {
        return this.mBluetoothDiscovery.stopBLEScan();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean stopDeviceScan() {
        return this.mBluetoothDiscovery.stopDeviceScan();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public void stopReconnect() {
        this.mReConnectHelper.stopReconnect();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    public boolean tryToPair(BluetoothDevice device) {
        return this.mBluetoothPair.tryToPair(device);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    public boolean tryToUnPair(BluetoothDevice device) {
        return this.mBluetoothPair.tryToUnPair(device);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    public boolean unPair(BluetoothDevice device) {
        return this.mBluetoothPair.unPair(device);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean unregisterBluetoothCallback(BluetoothEventCallback bluetoothCallback) {
        return this.mEventCbManager.removeListener(bluetoothCallback);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean writeDataToBLEDevice(BluetoothDevice device, UUID serviceUUID, UUID characteristicUUID, byte[] writeData) {
        boolean isConnectedBLEDevice = isConnectedBLEDevice(device);
        if (isConnectedBLEDevice) {
            this.mBluetoothBle.writeDataByBleAsync(device, serviceUUID, characteristicUUID, writeData, new OnWriteDataCallback() { // from class: com.jieli.bluetooth_connect.impl.II0XooXoX
                @Override // com.jieli.bluetooth_connect.interfaces.listener.OnWriteDataCallback
                public final void onBleResult(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, boolean z, byte[] bArr) {
                    BluetoothManager.lambda$writeDataToBLEDevice$1(bluetoothDevice, uuid, uuid2, z, bArr);
                }
            });
        } else {
            JL_Log.d(TAG, "writeDataToBLEDevice", "device(" + device + ") is disconnected.");
        }
        return isConnectedBLEDevice;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean writeDataToSppDevice(BluetoothDevice device, byte[] data) {
        return this.mBluetoothSpp.writeDataToSppDevice(device, data);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void addListener(OnBtDevicePairListener listener) {
        this.mBluetoothPair.addListener(listener);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    public boolean pair(BluetoothDevice device, int pairWay) {
        return this.mBluetoothPair.pair(device, pairWay);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void removeListener(OnBtDevicePairListener listener) {
        this.mBluetoothPair.removeListener(listener);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothOperation
    public boolean startDeviceScan(int type, long timeout) {
        return this.mBluetoothDiscovery.startDeviceScan(type, timeout);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    public boolean tryToPair(BluetoothDevice device, int pairWay) {
        return this.mBluetoothPair.tryToPair(device, pairWay);
    }
}
