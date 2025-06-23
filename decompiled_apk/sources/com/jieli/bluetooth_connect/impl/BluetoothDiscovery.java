package com.jieli.bluetooth_connect.impl;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.bestmafen.baseble.connector.AbsBleConnector;
import com.jieli.bluetooth_connect.bean.BluetoothOption;
import com.jieli.bluetooth_connect.bean.ErrorInfo;
import com.jieli.bluetooth_connect.bean.ble.BleScanMessage;
import com.jieli.bluetooth_connect.interfaces.IBluetoothDiscovery;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtDiscoveryListener;
import com.jieli.bluetooth_connect.tool.BtDiscoveryCbManager;
import com.jieli.bluetooth_connect.util.BluetoothUtil;
import com.jieli.bluetooth_connect.util.ConnectUtil;
import com.jieli.bluetooth_connect.util.JL_Log;
import com.jieli.bluetooth_connect.util.ParseDataUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes10.dex */
public class BluetoothDiscovery implements IBluetoothDiscovery {
    private static final int MSG_DISCOVERY_BLE_TIMEOUT = 1011;
    private static final int MSG_DISCOVERY_EDR_TIMEOUT = 1022;
    public static int SCAN_MIN_TIMEOUT = 2000;
    private static final String TAG = "BluetoothDiscovery";
    private boolean isBleScanning;
    private boolean isEdrScanning;
    private final BluetoothAdapter mBluetoothAdapter;
    private BluetoothDiscoveryReceiver mBluetoothDiscoveryReceiver;
    private BluetoothLeScanner mBluetoothLeScanner;
    private BluetoothOption mBluetoothOption;
    private BluetoothReceiver mBluetoothReceiver;
    private final BtDiscoveryCbManager mBtDiscoveryCbManager;
    private final Context mContext;
    private int mScanType;
    private long scanTotalTime;
    private long startBleScanTime;
    private long startEdrScanTime;
    private final List<BluetoothDevice> mDiscoveredDevices = new ArrayList();
    private final List<BluetoothDevice> mDiscoveredEdrDevices = new ArrayList();
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.bluetooth_connect.impl.X0o0xo
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            boolean lambda$new$0;
            lambda$new$0 = BluetoothDiscovery.this.lambda$new$0(message);
            return lambda$new$0;
        }
    });
    private final BluetoothAdapter.LeScanCallback leScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: com.jieli.bluetooth_connect.impl.XO
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            BluetoothDiscovery.this.lambda$new$1(bluetoothDevice, i, bArr);
        }
    };

    @RequiresApi(21)
    private final ScanCallback mScanCallback = new ScanCallback() { // from class: com.jieli.bluetooth_connect.impl.BluetoothDiscovery.1
        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> results) {
            super.onBatchScanResults(results);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int errorCode) {
            super.onScanFailed(errorCode);
            JL_Log.e(BluetoothDiscovery.TAG, "onScanFailed", "errorCode : " + errorCode);
            BluetoothDiscovery.this.mBtDiscoveryCbManager.onDiscoveryError(ErrorInfo.buildError(8, errorCode, null));
            BluetoothDiscovery.this.notifyDiscoveryStatus(true, false);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int callbackType, ScanResult result) {
            boolean z;
            super.onScanResult(callbackType, result);
            if (result != null && result.getScanRecord() != null) {
                BluetoothDevice device = result.getDevice();
                if (Build.VERSION.SDK_INT >= 26) {
                    z = result.isConnectable();
                } else {
                    z = true;
                }
                BluetoothDiscovery.this.filterDevice(device, result.getRssi(), result.getScanRecord().getBytes(), z);
            }
        }
    };

    /* loaded from: classes10.dex */
    public class BluetoothDiscoveryReceiver extends BroadcastReceiver {
        private BluetoothDiscoveryReceiver() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.content.BroadcastReceiver
        @SuppressLint({"MissingPermission"})
        public void onReceive(Context context, Intent intent) {
            char c;
            if (intent != null && context != null) {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                Objects.requireNonNull(action);
                switch (action.hashCode()) {
                    case -1780914469:
                        if (action.equals("android.bluetooth.adapter.action.DISCOVERY_FINISHED")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 6759640:
                        if (action.equals("android.bluetooth.adapter.action.DISCOVERY_STARTED")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1167529923:
                        if (action.equals("android.bluetooth.device.action.FOUND")) {
                            c = 2;
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
                        JL_Log.i(BluetoothDiscovery.TAG, "ACTION_DISCOVERY_FINISHED", "isDeviceScanning : " + BluetoothDiscovery.this.isDeviceScanning());
                        BluetoothDiscovery.this.notifyDiscoveryStatus(false, false);
                        return;
                    case 1:
                        JL_Log.i(BluetoothDiscovery.TAG, "ACTION_DISCOVERY_STARTED", "isDeviceScanning : " + BluetoothDiscovery.this.isDeviceScanning());
                        BluetoothDiscovery.this.notifyDiscoveryStatus(false, true);
                        return;
                    case 2:
                        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                        short shortExtra = intent.getShortExtra("android.bluetooth.device.extra.RSSI", (short) -1);
                        if (bluetoothDevice != null && BluetoothUtil.isBluetoothEnable() && ConnectUtil.isHasConnectPermission(context) && BluetoothDiscovery.this.isDeviceScanning()) {
                            int type = bluetoothDevice.getType();
                            int i = BluetoothDiscovery.this.mScanType;
                            if (i != 0) {
                                if (i != 1) {
                                    if (i != 2) {
                                        return;
                                    }
                                } else if (1 != type) {
                                    return;
                                }
                            } else if (2 != type && 3 != type) {
                                return;
                            }
                            if (!BluetoothDiscovery.this.mDiscoveredEdrDevices.contains(bluetoothDevice)) {
                                BluetoothDiscovery.this.mDiscoveredEdrDevices.add(bluetoothDevice);
                                BluetoothDiscovery.this.mBtDiscoveryCbManager.onDiscoveryDevice(bluetoothDevice, new BleScanMessage().setEnableConnect(true).setRssi(shortExtra));
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class BluetoothReceiver extends BroadcastReceiver {
        private BluetoothReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z;
            if (intent != null && "android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction()) && intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0) == 10) {
                BluetoothDiscovery.this.mDiscoveredDevices.clear();
                BluetoothDiscovery.this.mDiscoveredEdrDevices.clear();
                if (BluetoothDiscovery.this.isScanning()) {
                    BluetoothDiscovery bluetoothDiscovery = BluetoothDiscovery.this;
                    if (bluetoothDiscovery.mScanType == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bluetoothDiscovery.notifyDiscoveryStatus(z, false);
                }
            }
        }
    }

    public BluetoothDiscovery(Context context, BluetoothOption option, OnBtDiscoveryListener listener) {
        this.mContext = (Context) ConnectUtil.checkNotNull(context);
        setBluetoothOption(option);
        this.mBtDiscoveryCbManager = new BtDiscoveryCbManager();
        addListener(listener);
        this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        getBluetoothLeScanner();
        registerBtReceiver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void filterDevice(BluetoothDevice device, int rssi, byte[] scanRecord, boolean isBleEnableConnect) {
        boolean z;
        if (device != null && ConnectUtil.isHasConnectPermission(this.mContext) && BluetoothUtil.isBluetoothEnable()) {
            if (this.mBluetoothOption.isSkipNoneNameDevice() && TextUtils.isEmpty(device.getName())) {
                z = false;
            } else {
                z = true;
            }
            if (this.mBluetoothOption.getBleScanStrategy() == 0) {
                if (z && !this.mDiscoveredDevices.contains(device)) {
                    BleScanMessage parseOTAFlagFilterWithBroad = ParseDataUtil.parseOTAFlagFilterWithBroad(scanRecord, this.mBluetoothOption.getOtaScanFilterData());
                    if (parseOTAFlagFilterWithBroad == null) {
                        parseOTAFlagFilterWithBroad = new BleScanMessage();
                    }
                    this.mDiscoveredDevices.add(device);
                    this.mBtDiscoveryCbManager.onDiscoveryDevice(device, parseOTAFlagFilterWithBroad.setRawData(scanRecord).setRssi(rssi).setEnableConnect(isBleEnableConnect));
                    return;
                }
                return;
            }
            BleScanMessage isFilterBleDevice = ParseDataUtil.isFilterBleDevice(this.mBluetoothOption, scanRecord);
            if (isFilterBleDevice != null && z) {
                if (isFilterBleDevice.isEnableConnect() && !isBleEnableConnect) {
                    isFilterBleDevice.setEnableConnect(false);
                }
                isFilterBleDevice.setRawData(scanRecord).setRssi(rssi);
                if (isFilterBleDevice.isShowDialog()) {
                    this.mBtDiscoveryCbManager.onShowProductDialog(device, isFilterBleDevice);
                }
                if (!this.mDiscoveredDevices.contains(device)) {
                    this.mDiscoveredDevices.add(device);
                    this.mBtDiscoveryCbManager.onDiscoveryDevice(device, isFilterBleDevice);
                }
            }
        }
    }

    private BluetoothLeScanner getBluetoothLeScanner() {
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter != null && this.mBluetoothLeScanner == null) {
            this.mBluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner();
        }
        return this.mBluetoothLeScanner;
    }

    private long getCurrentTime() {
        return System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(Message message) {
        int i = message.what;
        if (i != 1011) {
            if (i == 1022) {
                boolean isDeviceScanning = isDeviceScanning();
                JL_Log.w(TAG, "MSG_DISCOVERY_EDR_TIMEOUT", "deviceScanning = " + isDeviceScanning);
                if (isDeviceScanning) {
                    stopDeviceScan(true);
                    notifyDiscoveryStatus(false, false);
                }
            }
        } else {
            boolean isBleScanning = isBleScanning();
            JL_Log.w(TAG, "MSG_DISCOVERY_BLE_TIMEOUT", "bleScanning = " + isBleScanning);
            if (isBleScanning) {
                stopBleScan(true);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        filterDevice(bluetoothDevice, i, bArr, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDiscoveryStatus(boolean bBle, boolean bStart) {
        JL_Log.i(TAG, "notifyDiscoveryStatus", "bBle : " + bBle + ", bStart : " + bStart + ", mScanType : " + this.mScanType);
        int i = this.mScanType;
        if (!bStart) {
            if (bBle) {
                this.startBleScanTime = 0L;
                setBleScanning(false);
                this.mHandler.removeMessages(1011);
            } else {
                this.startEdrScanTime = 0L;
                setDeviceScanning(false);
                unregisterReceiver();
                this.mHandler.removeMessages(1022);
            }
            this.mScanType = 0;
        }
        if (i == 0 && bBle) {
            this.mBtDiscoveryCbManager.onDiscoveryStatusChange(true, bStart);
        } else if (i == 1 && !bBle) {
            this.mBtDiscoveryCbManager.onDiscoveryStatusChange(false, bStart);
        }
    }

    private void registerBtReceiver() {
        if (this.mBluetoothReceiver == null) {
            this.mBluetoothReceiver = new BluetoothReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            this.mContext.registerReceiver(this.mBluetoothReceiver, intentFilter);
        }
    }

    private void registerReceiver() {
        if (this.mBluetoothDiscoveryReceiver == null) {
            this.mBluetoothDiscoveryReceiver = new BluetoothDiscoveryReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
            intentFilter.addAction("android.bluetooth.device.action.FOUND");
            this.mContext.registerReceiver(this.mBluetoothDiscoveryReceiver, intentFilter);
        }
    }

    private void setBleScanning(boolean bleScanning) {
        this.isBleScanning = bleScanning;
    }

    private void setDeviceScanning(boolean edrScanning) {
        this.isEdrScanning = edrScanning;
    }

    @SuppressLint({"MissingPermission"})
    private boolean stopBleScan(boolean isMandatory) {
        if (this.mBluetoothAdapter != null && ConnectUtil.isHasScanPermission(this.mContext)) {
            if (!BluetoothUtil.isBluetoothEnable()) {
                return false;
            }
            if (!isBleScanning()) {
                return true;
            }
            long currentTime = getCurrentTime() - this.startBleScanTime;
            if (!isMandatory && currentTime < SCAN_MIN_TIMEOUT) {
                JL_Log.i(TAG, "stopBleScan", "Turn on time is too short. usedTime = " + currentTime + ", SCAN_MIN_TIMEOUT = " + SCAN_MIN_TIMEOUT);
                this.mHandler.removeMessages(1011);
                this.mHandler.sendEmptyMessageDelayed(1011, ((long) SCAN_MIN_TIMEOUT) - currentTime);
                return true;
            }
            if (getBluetoothLeScanner() != null) {
                try {
                    JL_Log.d(TAG, "stopBleScan", "stopScan");
                    this.mBluetoothLeScanner.stopScan(this.mScanCallback);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    JL_Log.d(TAG, "stopBleScan", "stopLeScan");
                    this.mBluetoothAdapter.stopLeScan(this.leScanCallback);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            notifyDiscoveryStatus(true, false);
            return true;
        }
        JL_Log.e(TAG, "stopBleScan", "this device is not supported bluetooth.");
        return false;
    }

    private void unregisterBtReceiver() {
        BluetoothReceiver bluetoothReceiver = this.mBluetoothReceiver;
        if (bluetoothReceiver != null) {
            this.mContext.unregisterReceiver(bluetoothReceiver);
            this.mBluetoothReceiver = null;
        }
    }

    private void unregisterReceiver() {
        BluetoothDiscoveryReceiver bluetoothDiscoveryReceiver = this.mBluetoothDiscoveryReceiver;
        if (bluetoothDiscoveryReceiver != null) {
            this.mContext.unregisterReceiver(bluetoothDiscoveryReceiver);
            this.mBluetoothDiscoveryReceiver = null;
        }
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void destroy() {
        this.mBtDiscoveryCbManager.destroy();
        stopDeviceScan(true);
        stopBleScan(true);
        unregisterReceiver();
        unregisterBtReceiver();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothDiscovery
    public ArrayList<BluetoothDevice> getDiscoveredBluetoothDevices() {
        if (this.mScanType == 0) {
            return new ArrayList<>(this.mDiscoveredDevices);
        }
        return new ArrayList<>(this.mDiscoveredEdrDevices);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothDiscovery
    public int getScanType() {
        return this.mScanType;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothDiscovery
    public boolean isBleScanning() {
        return this.isBleScanning;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothDiscovery
    public boolean isDeviceScanning() {
        return this.isEdrScanning;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothDiscovery
    public boolean isScanning() {
        if (!isDeviceScanning() && !isBleScanning()) {
            return false;
        }
        return true;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void setBluetoothOption(BluetoothOption option) {
        if (option == null) {
            option = BluetoothOption.createDefaultOption();
        }
        this.mBluetoothOption = option;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothDiscovery
    @SuppressLint({"MissingPermission"})
    public boolean startBLEScan(long timeout) {
        boolean startLeScan;
        ScanSettings build;
        ScanSettings.Builder matchMode;
        if (!ConnectUtil.isHasScanPermission(this.mContext)) {
            JL_Log.e(TAG, "startBLEScan", "No Bluetooth scanning permission.");
            return false;
        }
        if (!ConnectUtil.isHasLocationPermission(this.mContext)) {
            JL_Log.e(TAG, "startBLEScan", "No location permission.");
            return false;
        }
        if (this.mBluetoothAdapter == null) {
            JL_Log.e(TAG, "startBLEScan", "this device is not supported bluetooth.");
            return false;
        }
        if (!BluetoothUtil.isBluetoothEnable()) {
            JL_Log.w(TAG, "startBLEScan", "Bluetooth adapter is close.");
            return false;
        }
        if (isDeviceScanning()) {
            stopDeviceScan(true);
        }
        if (isBleScanning()) {
            long currentTime = this.scanTotalTime - (getCurrentTime() - this.startBleScanTime);
            JL_Log.i(TAG, "startBLEScan", "scanning ble ..... left timeout : " + currentTime);
            return true;
        }
        int i = Build.VERSION.SDK_INT;
        if (getBluetoothLeScanner() != null) {
            if (i >= 23) {
                matchMode = new ScanSettings.Builder().setScanMode(this.mBluetoothOption.getBleScanMode()).setMatchMode(1);
                build = matchMode.build();
            } else {
                build = new ScanSettings.Builder().setScanMode(this.mBluetoothOption.getBleScanMode()).build();
            }
            this.mBluetoothLeScanner.startScan(new ArrayList(), build, this.mScanCallback);
            JL_Log.d(TAG, "startBLEScan", "startScan : true ");
            startLeScan = true;
        } else {
            startLeScan = this.mBluetoothAdapter.startLeScan(this.leScanCallback);
            JL_Log.d(TAG, "startBLEScan", "startLeScan : " + startLeScan);
        }
        if (startLeScan) {
            this.mScanType = 0;
            this.mDiscoveredDevices.clear();
            setBleScanning(true);
            if (timeout < SCAN_MIN_TIMEOUT) {
                timeout = AbsBleConnector.TIMEOUT;
            }
            this.startBleScanTime = getCurrentTime();
            this.scanTotalTime = timeout;
            JL_Log.d(TAG, "startBLEScan", "scanTotalTime : " + this.scanTotalTime);
            this.mHandler.removeMessages(1011);
            this.mHandler.sendEmptyMessageDelayed(1011, timeout);
            notifyDiscoveryStatus(true, true);
        }
        return startLeScan;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothDiscovery
    public boolean startDeviceScan(long timeout) {
        return startDeviceScan(1, timeout);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothDiscovery
    public boolean stopBLEScan() {
        return stopBleScan(false);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothDiscovery
    public boolean stopDeviceScan() {
        return stopDeviceScan(false);
    }

    @SuppressLint({"MissingPermission"})
    private boolean stopDeviceScan(boolean isMandatory) {
        if (this.mBluetoothAdapter != null && ConnectUtil.isHasScanPermission(this.mContext)) {
            if (!BluetoothUtil.isBluetoothEnable()) {
                return false;
            }
            if (!isDeviceScanning()) {
                return true;
            }
            long currentTime = getCurrentTime() - this.startEdrScanTime;
            if (!isMandatory && currentTime < SCAN_MIN_TIMEOUT) {
                JL_Log.i(TAG, "stopDeviceScan", "Turn on time is too short. usedTime = " + currentTime + ", SCAN_MIN_TIMEOUT = " + SCAN_MIN_TIMEOUT);
                this.mHandler.removeMessages(1022);
                this.mHandler.sendEmptyMessageDelayed(1022, ((long) SCAN_MIN_TIMEOUT) - currentTime);
                return true;
            }
            boolean cancelDiscovery = this.mBluetoothAdapter.cancelDiscovery();
            JL_Log.d(TAG, "stopDeviceScan", "cancelDiscovery : " + cancelDiscovery);
            return cancelDiscovery;
        }
        JL_Log.e(TAG, "stopDeviceScan", " this device is not supported bluetooth.");
        return false;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void addListener(OnBtDiscoveryListener listener) {
        this.mBtDiscoveryCbManager.addListener(listener);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void removeListener(OnBtDiscoveryListener listener) {
        this.mBtDiscoveryCbManager.removeListener(listener);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothDiscovery
    @SuppressLint({"MissingPermission"})
    public boolean startDeviceScan(int type, long timeout) {
        if (!ConnectUtil.isHasScanPermission(this.mContext)) {
            JL_Log.e(TAG, "startDeviceScan", "No Bluetooth scanning permission.");
            return false;
        }
        if (!ConnectUtil.isHasLocationPermission(this.mContext)) {
            JL_Log.e(TAG, "startDeviceScan", "No location permission.");
            return false;
        }
        if (this.mBluetoothAdapter == null) {
            JL_Log.e(TAG, "startDeviceScan", "this device is not supported bluetooth.");
            return false;
        }
        if (!BluetoothUtil.isBluetoothEnable()) {
            JL_Log.e(TAG, "startDeviceScan", "Bluetooth is not turned on.");
            return false;
        }
        if (type == 0) {
            return startBLEScan(timeout);
        }
        if (isBleScanning()) {
            JL_Log.w(TAG, "startDeviceScan", "stopBLEScan");
            stopBleScan(true);
        }
        if (isDeviceScanning()) {
            long currentTime = this.scanTotalTime - (getCurrentTime() - this.startEdrScanTime);
            JL_Log.i(TAG, "startDeviceScan", "scanning edr ..... ScanType : " + this.mScanType + ", leftTime : " + currentTime);
            return true;
        }
        registerReceiver();
        boolean startDiscovery = this.mBluetoothAdapter.startDiscovery();
        JL_Log.i(TAG, "startDeviceScan", "startDiscovery : " + startDiscovery);
        if (!startDiscovery) {
            unregisterReceiver();
        } else {
            this.mScanType = type;
            this.mDiscoveredEdrDevices.clear();
            setDeviceScanning(true);
            if (timeout < SCAN_MIN_TIMEOUT) {
                timeout = AbsBleConnector.TIMEOUT;
            }
            this.startEdrScanTime = getCurrentTime();
            this.scanTotalTime = timeout;
            this.mHandler.removeMessages(1022);
            this.mHandler.sendEmptyMessageDelayed(1022, timeout);
        }
        return startDiscovery;
    }
}
