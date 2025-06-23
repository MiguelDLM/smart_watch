package com.jieli.watchtesttool.tool.upgrade;

import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.Context;
import com.jieli.bluetooth_connect.bean.history.HistoryRecord;
import com.jieli.jl_bt_ota.impl.BluetoothOTAManager;
import com.jieli.jl_bt_ota.interfaces.IUpgradeCallback;
import com.jieli.jl_bt_ota.model.BluetoothOTAConfigure;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_bt_ota.model.response.TargetInfoResponse;
import com.jieli.jl_bt_ota.util.JL_Log;
import com.jieli.watchtesttool.tool.bluetooth.BluetoothEventListener;
import com.jieli.watchtesttool.tool.bluetooth.BluetoothHelper;
import com.jieli.watchtesttool.util.AppUtil;
import java.io.File;

/* loaded from: classes10.dex */
public class OTAManager extends BluetoothOTAManager {
    public static final String OTA_FILE_NAME = "update.ufw";
    public static final String OTA_FILE_SUFFIX = ".ufw";
    public static final String OTA_ZIP_SUFFIX = ".zip";
    private final BluetoothEventListener mBluetoothEventListener;
    private final BluetoothHelper mBluetoothHelper;
    private Context mContext;
    private String mNeedReconnectAddress;

    /* loaded from: classes10.dex */
    public final class CustomUpgradeCallback implements IUpgradeCallback {
        private final IUpgradeCallback mIUpgradeCallback;

        public CustomUpgradeCallback(IUpgradeCallback iUpgradeCallback) {
            this.mIUpgradeCallback = iUpgradeCallback;
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onCancelOTA() {
            IUpgradeCallback iUpgradeCallback = this.mIUpgradeCallback;
            if (iUpgradeCallback != null) {
                iUpgradeCallback.onCancelOTA();
            }
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onError(BaseError baseError) {
            IUpgradeCallback iUpgradeCallback = this.mIUpgradeCallback;
            if (iUpgradeCallback != null) {
                iUpgradeCallback.onError(baseError);
            }
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onNeedReconnect(String str, boolean z) {
            HistoryRecord historyRecord = OTAManager.this.mBluetoothHelper.getBluetoothOp().getHistoryRecord(str);
            if (historyRecord != null && historyRecord.getConnectType() != 0) {
                String mappedAddress = historyRecord.getMappedAddress();
                String address = historyRecord.getAddress();
                historyRecord.setAddress(mappedAddress);
                historyRecord.setConnectType(0);
                historyRecord.setMappedAddress(address);
                try {
                    OTAManager.this.mBluetoothHelper.getBluetoothOp().getHistoryRecordHelper().updateHistoryRecord(historyRecord);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            IUpgradeCallback iUpgradeCallback = this.mIUpgradeCallback;
            if (iUpgradeCallback != null) {
                iUpgradeCallback.onNeedReconnect(str, z);
            }
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onProgress(int i, float f) {
            if (i == 0 && f > 50.0f && OTAManager.this.mNeedReconnectAddress == null && OTAManager.this.isSingleOTA()) {
                OTAManager oTAManager = OTAManager.this;
                oTAManager.mNeedReconnectAddress = oTAManager.getConnectedDevice().getAddress();
            }
            IUpgradeCallback iUpgradeCallback = this.mIUpgradeCallback;
            if (iUpgradeCallback != null) {
                iUpgradeCallback.onProgress(i, f);
            }
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onStartOTA() {
            IUpgradeCallback iUpgradeCallback = this.mIUpgradeCallback;
            if (iUpgradeCallback != null) {
                iUpgradeCallback.onStartOTA();
            }
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onStopOTA() {
            OTAManager.this.updateHistoryRecord(null);
            OTAManager.this.mNeedReconnectAddress = null;
            IUpgradeCallback iUpgradeCallback = this.mIUpgradeCallback;
            if (iUpgradeCallback != null) {
                iUpgradeCallback.onStopOTA();
            }
        }
    }

    public OTAManager(Context context) {
        super(context);
        BluetoothEventListener bluetoothEventListener = new BluetoothEventListener() { // from class: com.jieli.watchtesttool.tool.upgrade.OTAManager.1
            @Override // com.jieli.watchtesttool.tool.bluetooth.BluetoothEventListener
            public void onBleMtuChange(BluetoothGatt bluetoothGatt, int i, int i2) {
                OTAManager.this.onMtuChanged(bluetoothGatt, i, i2);
            }

            @Override // com.jieli.watchtesttool.tool.bluetooth.BluetoothEventListener
            public void onConnection(BluetoothDevice bluetoothDevice, int i) {
                OTAManager.this.onBtDeviceConnection(bluetoothDevice, AppUtil.convertOtaConnectStatus(i));
            }

            @Override // com.jieli.watchtesttool.tool.bluetooth.BluetoothEventListener
            public void onReceiveData(BluetoothDevice bluetoothDevice, byte[] bArr) {
                OTAManager.this.onReceiveDeviceData(bluetoothDevice, bArr);
            }
        };
        this.mBluetoothEventListener = bluetoothEventListener;
        this.mContext = context;
        BluetoothHelper bluetoothHelper = BluetoothHelper.getInstance((Application) context.getApplicationContext());
        this.mBluetoothHelper = bluetoothHelper;
        bluetoothHelper.addBluetoothEventListener(bluetoothEventListener);
        configureOTA();
    }

    private void checkDevice(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice != null && this.mBluetoothHelper.getBluetoothOp().isConnectedBLEDevice(bluetoothDevice)) {
            int bleMtu = this.mBluetoothHelper.getBluetoothOp().getBleMtu(bluetoothDevice);
            if (this.mBluetoothHelper.getBluetoothOp().getDeviceGatt(bluetoothDevice) != null) {
                onMtuChanged(this.mBluetoothHelper.getBluetoothOp().getDeviceGatt(bluetoothDevice), bleMtu + 3, 0);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void configureOTA() {
        BluetoothOTAConfigure createDefault = BluetoothOTAConfigure.createDefault();
        int i = this.mBluetoothHelper.getBluetoothOp().getBluetoothOption().getPriority();
        if (this.mBluetoothHelper.isConnectedDevice()) {
            i = this.mBluetoothHelper.getBluetoothOp().isConnectedSppDevice(this.mBluetoothHelper.getConnectedBtDevice());
        }
        this.mBluetoothHelper.getBluetoothOp().getBluetoothOption().setNotAssociatedEDR(true);
        createDefault.setPriority(i).setNeedChangeMtu(false).setMtu(20).setUseAuthDevice(false).setUseReconnect(false);
        String createFilePath = AppUtil.createFilePath(this.mContext, "upgrade");
        File file = new File(createFilePath);
        boolean exists = file.exists();
        if (!exists) {
            exists = file.mkdir();
        }
        if (exists) {
            String obtainUpdateFilePath = AppUtil.obtainUpdateFilePath(createFilePath, OTA_FILE_SUFFIX);
            if (obtainUpdateFilePath == null) {
                obtainUpdateFilePath = createFilePath + "/" + OTA_FILE_NAME;
            }
            createDefault.setFirmwareFilePath(obtainUpdateFilePath);
        }
        JL_Log.d(this.TAG, "configureOTA >> " + createDefault);
        configure(createDefault);
        if (this.mBluetoothHelper.isConnectedDevice()) {
            onBtDeviceConnection(getConnectedDevice(), 1);
            checkDevice(getConnectedDevice());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSingleOTA() {
        TargetInfoResponse deviceInfo = getDeviceInfo();
        if (deviceInfo != null && !deviceInfo.isSupportDoubleBackup()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHistoryRecord(String str) {
        HistoryRecord historyRecord = this.mBluetoothHelper.getBluetoothOp().getHistoryRecord(this.mNeedReconnectAddress);
        if (historyRecord != null) {
            if (historyRecord.getUpdateAddress() == null || !historyRecord.getUpdateAddress().equals(str)) {
                historyRecord.setUpdateAddress(str);
                this.mBluetoothHelper.getBluetoothOp().getHistoryRecordHelper().updateHistoryRecord(historyRecord);
            }
        }
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IBluetoothManager
    public void connectBluetoothDevice(BluetoothDevice bluetoothDevice) {
        updateHistoryRecord(bluetoothDevice.getAddress());
        this.mBluetoothHelper.connectDeviceWithoutRecord(bluetoothDevice);
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IBluetoothManager
    public void disconnectBluetoothDevice(BluetoothDevice bluetoothDevice) {
        this.mBluetoothHelper.disconnectDevice(bluetoothDevice);
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IBluetoothManager
    public BluetoothGatt getConnectedBluetoothGatt() {
        return this.mBluetoothHelper.getConnectedBluetoothGatt(getConnectedDevice());
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IBluetoothManager
    public BluetoothDevice getConnectedDevice() {
        return this.mBluetoothHelper.getConnectedBtDevice();
    }

    @Override // com.jieli.jl_bt_ota.impl.BluetoothOTAManager, com.jieli.jl_bt_ota.impl.BluetoothBreProfiles, com.jieli.jl_bt_ota.impl.BluetoothDiscovery, com.jieli.jl_bt_ota.impl.BluetoothBase, com.jieli.jl_bt_ota.interfaces.IUpgradeManager
    public void release() {
        super.release();
        this.mBluetoothHelper.removeBluetoothEventListener(this.mBluetoothEventListener);
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IBluetoothManager
    public boolean sendDataToDevice(BluetoothDevice bluetoothDevice, byte[] bArr) {
        return this.mBluetoothHelper.sendDataToDevice(bluetoothDevice, bArr);
    }

    @Override // com.jieli.jl_bt_ota.impl.BluetoothOTAManager, com.jieli.jl_bt_ota.interfaces.IUpgradeManager
    public void startOTA(IUpgradeCallback iUpgradeCallback) {
        checkDevice(getConnectedDevice());
        super.startOTA(new CustomUpgradeCallback(iUpgradeCallback));
    }
}
