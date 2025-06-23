package com.jieli.watchtesttool.tool.bluetooth;

import OI0.oxoX;
import android.annotation.SuppressLint;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.jieli.bluetooth_connect.bean.BluetoothOption;
import com.jieli.bluetooth_connect.bean.ErrorInfo;
import com.jieli.bluetooth_connect.bean.ble.BleScanMessage;
import com.jieli.bluetooth_connect.bean.history.HistoryRecord;
import com.jieli.bluetooth_connect.impl.BluetoothManager;
import com.jieli.bluetooth_connect.interfaces.IBluetoothOperation;
import com.jieli.bluetooth_connect.interfaces.callback.BluetoothEventCallback;
import com.jieli.bluetooth_connect.interfaces.callback.OnHistoryRecordCallback;
import com.jieli.bluetooth_connect.util.BluetoothUtil;
import com.jieli.bluetooth_connect.util.CHexConverter;
import com.jieli.jl_rcsp.impl.RcspAuth;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.watchtesttool.tool.config.ConfigHelper;
import com.jieli.watchtesttool.util.AppUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes10.dex */
public class BluetoothHelper {
    private static final long DELAY_WAITING_TIME = 5000;
    private static final boolean IS_CHANGE_BLE_MTU = true;
    private static final String TAG = "BluetoothHelper";
    private static volatile BluetoothHelper instance;
    private final ConfigHelper configHelper;
    private final IBluetoothOperation mBluetoothOp;
    private final BluetoothEventCallback mBtEventCallback;
    private final BtEventCbManager mBtEventCbManager;
    private ChangeBleMtuTimeoutTask mChangeBleMtuTimeoutTask;
    private final RcspAuth mRcspAuth;
    private final RcspAuth.OnRcspAuthListener mRcspAuthListener;
    private final Map<String, Boolean> mAuthDeviceMap = new HashMap();
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.watchtesttool.tool.bluetooth.oIX0oI
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            boolean lambda$new$0;
            lambda$new$0 = BluetoothHelper.lambda$new$0(message);
            return lambda$new$0;
        }
    });

    /* loaded from: classes10.dex */
    public class ChangeBleMtuTimeoutTask implements Runnable {
        private final BluetoothDevice mDevice;

        public ChangeBleMtuTimeoutTask(BluetoothDevice bluetoothDevice) {
            this.mDevice = bluetoothDevice;
        }

        public BluetoothDevice getDevice() {
            return this.mDevice;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BluetoothHelper.this.mBluetoothOp.isConnectedDevice(this.mDevice)) {
                BluetoothHelper.this.callbackDeviceConnected(this.mDevice);
            } else {
                BluetoothHelper.this.publishDeviceConnectionStatus(this.mDevice, 0);
            }
        }
    }

    private BluetoothHelper(Application application) {
        BluetoothEventCallback bluetoothEventCallback = new BluetoothEventCallback() { // from class: com.jieli.watchtesttool.tool.bluetooth.BluetoothHelper.1
            @Override // com.jieli.bluetooth_connect.interfaces.callback.BluetoothEventCallback, com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
            public void onAdapterStatus(boolean z, boolean z2) {
                BluetoothHelper.this.mBtEventCbManager.onAdapterStatus(z);
            }

            @Override // com.jieli.bluetooth_connect.interfaces.callback.BluetoothEventCallback, com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
            public void onBleDataBlockChanged(BluetoothDevice bluetoothDevice, int i, int i2) {
                BluetoothHelper.this.mBtEventCbManager.onBleMtuChange(BluetoothHelper.this.getConnectedBluetoothGatt(bluetoothDevice), i, i2);
                if (i2 == 0 && BluetoothHelper.this.mChangeBleMtuTimeoutTask != null && BluetoothUtil.deviceEquals(bluetoothDevice, BluetoothHelper.this.mChangeBleMtuTimeoutTask.getDevice())) {
                    BluetoothHelper.this.stopChangeBleMtu();
                    BluetoothHelper.this.callbackDeviceConnected(bluetoothDevice);
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.callback.BluetoothEventCallback, com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
            public void onBleDataNotification(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, byte[] bArr) {
                if (uuid.equals(BluetoothHelper.this.mBluetoothOp.getBluetoothOption().getBleServiceUUID()) && uuid2.equals(BluetoothHelper.this.mBluetoothOp.getBluetoothOption().getBleNotificationUUID())) {
                    BluetoothHelper.this.handleReceiveRawData(bluetoothDevice, bArr);
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.callback.BluetoothEventCallback, com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
            public void onConnection(BluetoothDevice bluetoothDevice, int i) {
                JL_Log.w(BluetoothHelper.TAG, "onConnection >>> status = " + i);
                if (i == 2) {
                    BluetoothHelper.this.handleDeviceConnectedEvent(bluetoothDevice);
                } else {
                    BluetoothHelper.this.publishDeviceConnectionStatus(bluetoothDevice, i);
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.callback.BluetoothEventCallback, com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
            public void onDiscovery(BluetoothDevice bluetoothDevice, BleScanMessage bleScanMessage) {
                BluetoothHelper.this.mBtEventCbManager.onBtDiscovery(bluetoothDevice, bleScanMessage);
            }

            @Override // com.jieli.bluetooth_connect.interfaces.callback.BluetoothEventCallback, com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
            public void onDiscoveryStatus(boolean z, boolean z2) {
                BluetoothHelper.this.mBtEventCbManager.onBtDiscoveryStatus(z, z2);
            }

            @Override // com.jieli.bluetooth_connect.interfaces.callback.BluetoothEventCallback, com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
            public void onError(ErrorInfo errorInfo) {
                BluetoothHelper.this.mBtEventCbManager.onError(errorInfo);
            }

            @Override // com.jieli.bluetooth_connect.interfaces.callback.BluetoothEventCallback, com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
            public void onShowDialog(BluetoothDevice bluetoothDevice, BleScanMessage bleScanMessage) {
                BluetoothHelper.this.mBtEventCbManager.onShowDialog(bluetoothDevice, bleScanMessage);
            }

            @Override // com.jieli.bluetooth_connect.interfaces.callback.BluetoothEventCallback, com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
            public void onSppDataNotification(BluetoothDevice bluetoothDevice, UUID uuid, byte[] bArr) {
                if (uuid.equals(BluetoothHelper.this.mBluetoothOp.getBluetoothOption().getSppUUID())) {
                    BluetoothHelper.this.handleReceiveRawData(bluetoothDevice, bArr);
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.callback.BluetoothEventCallback, com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
            public void onSwitchConnectedDevice(BluetoothDevice bluetoothDevice) {
                BluetoothHelper.this.mBtEventCbManager.onSwitchConnectedDevice(bluetoothDevice);
            }
        };
        this.mBtEventCallback = bluetoothEventCallback;
        RcspAuth.OnRcspAuthListener onRcspAuthListener = new RcspAuth.OnRcspAuthListener() { // from class: com.jieli.watchtesttool.tool.bluetooth.BluetoothHelper.2
            @Override // com.jieli.jl_rcsp.impl.RcspAuth.OnRcspAuthListener
            public void onAuthFailed(BluetoothDevice bluetoothDevice, int i, String str) {
                JL_Log.e(BluetoothHelper.TAG, "-onAuthFailed- device : " + AppUtil.printBtDeviceInfo(bluetoothDevice) + ", code = " + i + ", message = " + str);
                BluetoothHelper.this.setDevAuth(bluetoothDevice, false);
                BluetoothHelper.this.disconnectDevice(bluetoothDevice);
            }

            @Override // com.jieli.jl_rcsp.impl.RcspAuth.OnRcspAuthListener
            public void onAuthSuccess(BluetoothDevice bluetoothDevice) {
                JL_Log.w(BluetoothHelper.TAG, "-onAuthSuccess- device : " + AppUtil.printBtDeviceInfo(bluetoothDevice));
                BluetoothHelper.this.setDevAuth(bluetoothDevice, true);
                BluetoothHelper.this.handleDeviceConnectedEvent(bluetoothDevice);
            }

            @Override // com.jieli.jl_rcsp.impl.RcspAuth.OnRcspAuthListener
            public void onInitResult(boolean z) {
            }
        };
        this.mRcspAuthListener = onRcspAuthListener;
        ConfigHelper configHelper = ConfigHelper.getInstance(application);
        this.configHelper = configHelper;
        BluetoothOption createDefaultOption = BluetoothOption.createDefaultOption();
        createDefaultOption.setPriority(configHelper.isSPPConnectWay() ? 1 : 0);
        createDefaultOption.setScanFilterData("");
        createDefaultOption.setMtu(getDefaultMtu(configHelper));
        createDefaultOption.setNeedChangeBleMtu(false);
        createDefaultOption.setBleScanStrategy(configHelper.isFilterDevice() ? 1 : 0);
        createDefaultOption.setUseMultiDevice(false);
        createDefaultOption.setUseDeviceAuth(configHelper.isUseDeviceAuth());
        BluetoothManager bluetoothManager = new BluetoothManager(application, createDefaultOption);
        this.mBluetoothOp = bluetoothManager;
        bluetoothManager.registerBluetoothCallback(bluetoothEventCallback);
        this.mRcspAuth = new RcspAuth(new RcspAuth.IRcspAuthOp() { // from class: com.jieli.watchtesttool.tool.bluetooth.II0xO0
            @Override // com.jieli.jl_rcsp.impl.RcspAuth.IRcspAuthOp
            public final boolean sendAuthDataToDevice(BluetoothDevice bluetoothDevice, byte[] bArr) {
                return BluetoothHelper.this.sendDataToDevice(bluetoothDevice, bArr);
            }
        }, onRcspAuthListener);
        this.mBtEventCbManager = new BtEventCbManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackDeviceConnected(BluetoothDevice bluetoothDevice) {
        publishDeviceConnectionStatus(bluetoothDevice, 2);
    }

    public static int getDefaultMtu(ConfigHelper configHelper) {
        if (!oxoX.OOXIXo() && !oxoX.oOoXoXO()) {
            return configHelper.getBleMtu();
        }
        return 247;
    }

    public static BluetoothHelper getInstance(Application application) {
        if (instance == null) {
            synchronized (BluetoothHelper.class) {
                try {
                    if (instance == null) {
                        instance = new BluetoothHelper(application);
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDeviceConnectedEvent(BluetoothDevice bluetoothDevice) {
        int bleMtu;
        int mtu;
        boolean isConnectedSppDevice = this.mBluetoothOp.isConnectedSppDevice(bluetoothDevice);
        String str = TAG;
        JL_Log.i(str, "-handleDeviceConnectedEvent- device = " + AppUtil.printBtDeviceInfo(bluetoothDevice) + ", connectWay = " + (isConnectedSppDevice ? 1 : 0));
        if (!isAuthDevice(bluetoothDevice)) {
            this.mRcspAuth.stopAuth(bluetoothDevice, false);
            boolean startAuth = this.mRcspAuth.startAuth(bluetoothDevice);
            JL_Log.w(str, "-handleDeviceConnectedEvent- startAuth = " + startAuth);
            if (!startAuth) {
                disconnectDevice(bluetoothDevice);
                return;
            }
            return;
        }
        if (!isConnectedSppDevice && (bleMtu = this.mBluetoothOp.getBleMtu(bluetoothDevice)) != (mtu = this.mBluetoothOp.getBluetoothOption().getMtu())) {
            boolean startChangeMtu = startChangeMtu(bluetoothDevice, mtu);
            JL_Log.w(str, "-handleDeviceConnectedEvent- startChangeMtu = " + startChangeMtu + ", mtu = " + bleMtu + ", change mtu = " + mtu);
            if (startChangeMtu) {
                return;
            }
        }
        callbackDeviceConnected(bluetoothDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleReceiveRawData(BluetoothDevice bluetoothDevice, byte[] bArr) {
        JL_Log.w(TAG, "-handleReceiveRawData- device = " + AppUtil.printBtDeviceInfo(bluetoothDevice) + ", rawData = " + CHexConverter.byte2HexStr(bArr));
        if (!isAuthDevice(bluetoothDevice)) {
            this.mRcspAuth.handleAuthData(bluetoothDevice, bArr);
        } else {
            this.mBtEventCbManager.onReceiveData(bluetoothDevice, bArr);
        }
    }

    private boolean isDevAuth(String str) {
        if (!this.mBluetoothOp.getBluetoothOption().isUseDeviceAuth()) {
            return true;
        }
        Boolean bool = this.mAuthDeviceMap.get(str);
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$0(Message message) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void publishDeviceConnectionStatus(BluetoothDevice bluetoothDevice, int i) {
        this.mBtEventCbManager.onConnection(bluetoothDevice, i);
        if (2 == i || i == 0) {
            ChangeBleMtuTimeoutTask changeBleMtuTimeoutTask = this.mChangeBleMtuTimeoutTask;
            if (changeBleMtuTimeoutTask != null && BluetoothUtil.deviceEquals(bluetoothDevice, changeBleMtuTimeoutTask.getDevice())) {
                stopChangeBleMtu();
            }
            if (i == 0 && bluetoothDevice != null) {
                removeDevAuth(bluetoothDevice.getAddress());
            }
        }
    }

    private void removeDevAuth(String str) {
        this.mAuthDeviceMap.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDevAuth(BluetoothDevice bluetoothDevice, boolean z) {
        if (bluetoothDevice == null) {
            return;
        }
        this.mAuthDeviceMap.put(bluetoothDevice.getAddress(), Boolean.valueOf(z));
    }

    private boolean startChangeMtu(BluetoothDevice bluetoothDevice, int i) {
        if (this.mChangeBleMtuTimeoutTask != null) {
            JL_Log.w(TAG, "-startChangeMtu- Adjusting the MTU for BLE");
            return true;
        }
        boolean requestBleMtu = this.mBluetoothOp.requestBleMtu(bluetoothDevice, i);
        JL_Log.i(TAG, "-startChangeMtu- requestBleMtu = " + requestBleMtu + ", change mtu = " + i);
        if (requestBleMtu) {
            ChangeBleMtuTimeoutTask changeBleMtuTimeoutTask = new ChangeBleMtuTimeoutTask(bluetoothDevice);
            this.mChangeBleMtuTimeoutTask = changeBleMtuTimeoutTask;
            this.mHandler.postDelayed(changeBleMtuTimeoutTask, 5000L);
        }
        return requestBleMtu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopChangeBleMtu() {
        JL_Log.i(TAG, "-stopChangeBleMtu- >>>>");
        ChangeBleMtuTimeoutTask changeBleMtuTimeoutTask = this.mChangeBleMtuTimeoutTask;
        if (changeBleMtuTimeoutTask != null) {
            this.mHandler.removeCallbacks(changeBleMtuTimeoutTask);
            this.mChangeBleMtuTimeoutTask = null;
        }
    }

    public void addBluetoothEventListener(BluetoothEventListener bluetoothEventListener) {
        this.mBtEventCbManager.addBluetoothEventListener(bluetoothEventListener);
    }

    @SuppressLint({"MissingPermission"})
    public void connectDevice(BluetoothDevice bluetoothDevice) {
        BluetoothDevice remoteDevice;
        if (bluetoothDevice == null) {
            return;
        }
        int type = bluetoothDevice.getType();
        int i = 0;
        if (type == 0 || type == 3) {
            int cacheConnectWay = getCacheConnectWay(bluetoothDevice);
            if (this.configHelper.isSPPConnectWay()) {
                if (cacheConnectWay == 1) {
                    String mappedDeviceAddress = this.mBluetoothOp.getMappedDeviceAddress(bluetoothDevice.getAddress());
                    if (BluetoothAdapter.checkBluetoothAddress(mappedDeviceAddress) && (remoteDevice = AppUtil.getRemoteDevice(mappedDeviceAddress)) != null && remoteDevice.getType() != 2 && remoteDevice.getType() != 3) {
                        bluetoothDevice = remoteDevice;
                    }
                }
                i = cacheConnectWay;
            }
        }
        this.mBluetoothOp.connectBtDevice(bluetoothDevice, i);
    }

    public boolean connectDeviceWithoutRecord(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return false;
        }
        return this.mBluetoothOp.connectBtDeviceWithoutRecord(bluetoothDevice, 0);
    }

    public void connectHistoryRecord(HistoryRecord historyRecord) {
        if (historyRecord == null) {
            return;
        }
        this.mBluetoothOp.connectHistoryRecord(historyRecord, null);
    }

    public void destroy() {
        this.mBluetoothOp.unregisterBluetoothCallback(this.mBtEventCallback);
        this.mBluetoothOp.destroy();
        this.mRcspAuth.removeListener(this.mRcspAuthListener);
        this.mRcspAuth.destroy();
        this.mAuthDeviceMap.clear();
        this.mHandler.removeCallbacksAndMessages(null);
        this.mBtEventCbManager.destroy();
        instance = null;
    }

    public void disconnectDevice(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return;
        }
        if (isConnectedBtDevice(bluetoothDevice)) {
            this.mBluetoothOp.disconnectBtDevice(bluetoothDevice);
        } else {
            publishDeviceConnectionStatus(bluetoothDevice, 0);
        }
    }

    public BluetoothManager getBluetoothOp() {
        return (BluetoothManager) this.mBluetoothOp;
    }

    public int getCacheConnectWay(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return 0;
        }
        if (this.mBluetoothOp.isConnectedDevice(bluetoothDevice)) {
            if (!this.mBluetoothOp.isConnectedSppDevice(bluetoothDevice)) {
                return 0;
            }
            return 1;
        }
        HistoryRecord historyRecord = this.mBluetoothOp.getHistoryRecord(bluetoothDevice.getAddress());
        if (historyRecord == null) {
            return 0;
        }
        return historyRecord.getConnectType();
    }

    public BluetoothGatt getConnectedBluetoothGatt(BluetoothDevice bluetoothDevice) {
        return this.mBluetoothOp.getDeviceGatt(bluetoothDevice);
    }

    public BluetoothDevice getConnectedBtDevice() {
        return this.mBluetoothOp.getConnectedDevice();
    }

    public int getConnectionStatus(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return 0;
        }
        if (isConnectedBtDevice(bluetoothDevice)) {
            return 1;
        }
        if (!BluetoothUtil.deviceEquals(bluetoothDevice, getBluetoothOp().getConnectingDevice())) {
            return 0;
        }
        return 3;
    }

    public boolean isAuthDevice(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice != null && isDevAuth(bluetoothDevice.getAddress())) {
            return true;
        }
        return false;
    }

    public boolean isConnectedBtDevice(BluetoothDevice bluetoothDevice) {
        return this.mBluetoothOp.isConnectedDevice(bluetoothDevice);
    }

    public boolean isConnectedDevice() {
        if (getConnectedBtDevice() != null && isDevAuth(getConnectedBtDevice().getAddress())) {
            return true;
        }
        return false;
    }

    public boolean isConnectedSppDevice(BluetoothDevice bluetoothDevice) {
        return this.mBluetoothOp.isConnectedSppDevice(bluetoothDevice);
    }

    public boolean isHistoryRecord(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice != null && this.mBluetoothOp.getHistoryRecord(bluetoothDevice.getAddress()) != null) {
            return true;
        }
        return false;
    }

    public boolean isUsedBtDevice(BluetoothDevice bluetoothDevice) {
        if (this.mBluetoothOp.isConnectedDevice(bluetoothDevice) && BluetoothUtil.deviceEquals(getConnectedBtDevice(), bluetoothDevice)) {
            return true;
        }
        return false;
    }

    public void removeBluetoothEventListener(BluetoothEventListener bluetoothEventListener) {
        this.mBtEventCbManager.removeBluetoothEventListener(bluetoothEventListener);
    }

    public void removeHistoryRecord(String str, OnHistoryRecordCallback onHistoryRecordCallback) {
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            return;
        }
        this.mBluetoothOp.removeHistoryRecord(str, onHistoryRecordCallback);
    }

    public boolean sendDataToDevice(BluetoothDevice bluetoothDevice, byte[] bArr) {
        return this.mBluetoothOp.sendDataToDevice(bluetoothDevice, bArr);
    }

    public void connectDevice(BluetoothDevice bluetoothDevice, int i) {
        this.mBluetoothOp.connectBtDevice(bluetoothDevice, i);
    }

    public void connectDevice(BluetoothDevice bluetoothDevice, BleScanMessage bleScanMessage) {
        int i;
        BluetoothDevice remoteDevice;
        if (bluetoothDevice == null) {
            return;
        }
        if (bleScanMessage != null) {
            if (!this.configHelper.isSPPConnectWay() || (remoteDevice = AppUtil.getRemoteDevice(bleScanMessage.getEdrAddr())) == null) {
                i = 0;
            } else {
                bluetoothDevice = remoteDevice;
                i = 1;
            }
            this.mBluetoothOp.connectBtDevice(bluetoothDevice, i);
            return;
        }
        connectDevice(bluetoothDevice);
    }
}
