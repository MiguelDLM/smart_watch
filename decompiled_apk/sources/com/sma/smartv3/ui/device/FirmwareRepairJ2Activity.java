package com.sma.smartv3.ui.device;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.google.gson.Gson;
import com.jieli.jl_bt_ota.interfaces.BtEventCallback;
import com.jieli.jl_bt_ota.interfaces.IUpgradeCallback;
import com.jieli.jl_bt_ota.model.BluetoothOTAConfigure;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.watchtesttool.tool.bluetooth.BluetoothEventListener;
import com.jieli.watchtesttool.tool.bluetooth.BluetoothHelper;
import com.jieli.watchtesttool.tool.upgrade.OTAManager;
import com.sma.androidnetworklib.method.HttpProgressCallback;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.FirmwareVersion;
import com.sma.smartv3.model.UpgradeFailedDeviceData;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.ui.device.FirmwareRepairJ2Activity;
import com.sma.smartv3.util.UtilsKt;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleDeviceInfo;
import java.io.File;

@kotlin.jvm.internal.XX({"SMAP\nFirmwareRepairJ2Activity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwareRepairJ2Activity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairJ2Activity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,297:1\n18#2,2:298\n15#2:300\n15#2:301\n27#2,2:302\n*S KotlinDebug\n*F\n+ 1 FirmwareRepairJ2Activity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairJ2Activity\n*L\n45#1:298,2\n45#1:300\n49#1:301\n129#1:302,2\n*E\n"})
/* loaded from: classes12.dex */
public final class FirmwareRepairJ2Activity extends BaseFirmwareRepairActivity {
    private boolean isUseDfuAddress;
    private final BluetoothHelper mBluetoothHelper;

    @OXOo.OOXIXo
    private final II0xO0 mBtEventListener;

    @OXOo.OOXIXo
    private final BleDeviceInfo mDeviceInfo;

    @OXOo.OOXIXo
    private String mDfuAddress;
    private int mDownloaded;

    @OXOo.oOoXoXO
    private final FirmwareVersion mLatestFirmware;

    @OXOo.OOXIXo
    private final BtEventCallback mOTAEventCallback;

    @OXOo.oOoXoXO
    private OTAManager mOTAManager;

    @OXOo.OOXIXo
    private OTAStatus mOTAStatus = OTAStatus.NONE;
    private int mStepsIndex;

    /* loaded from: classes12.dex */
    public static final class I0Io extends BtEventCallback {
        public I0Io() {
        }

        @Override // com.jieli.jl_bt_ota.interfaces.BtEventCallback, com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
        public void onConnection(@OXOo.OOXIXo BluetoothDevice device, int i) {
            Boolean bool;
            kotlin.jvm.internal.IIX0o.x0xO0oo(device, "device");
            StringBuilder sb = new StringBuilder();
            sb.append("ota onConnection -> mOTAStatus = ");
            sb.append(FirmwareRepairJ2Activity.this.mOTAStatus);
            sb.append(", ");
            sb.append(device);
            sb.append(" ,status = ");
            sb.append(i);
            sb.append(" ,isOTA = ");
            OTAManager oTAManager = FirmwareRepairJ2Activity.this.mOTAManager;
            if (oTAManager != null) {
                bool = Boolean.valueOf(oTAManager.isOTA());
            } else {
                bool = null;
            }
            sb.append(bool);
            LogUtils.d(sb.toString());
            OTAManager oTAManager2 = FirmwareRepairJ2Activity.this.mOTAManager;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oTAManager2);
            if (!oTAManager2.isOTA()) {
                if (i != 0) {
                    if (i == 1) {
                        FirmwareRepairJ2Activity firmwareRepairJ2Activity = FirmwareRepairJ2Activity.this;
                        if (firmwareRepairJ2Activity.canOTA(firmwareRepairJ2Activity.mOTAStatus)) {
                            if (FirmwareRepairJ2Activity.this.mStepsIndex == 0) {
                                FirmwareRepairJ2Activity firmwareRepairJ2Activity2 = FirmwareRepairJ2Activity.this;
                                File oOoXoXO2 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
                                FirmwareVersion firmwareVersion = FirmwareRepairJ2Activity.this.mLatestFirmware;
                                kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion);
                                String absolutePath = new File(oOoXoXO2, firmwareVersion.getFileName()).getAbsolutePath();
                                kotlin.jvm.internal.IIX0o.oO(absolutePath, "getAbsolutePath(...)");
                                firmwareRepairJ2Activity2.startOTA(absolutePath);
                                return;
                            }
                            FirmwareRepairJ2Activity firmwareRepairJ2Activity3 = FirmwareRepairJ2Activity.this;
                            File oOoXoXO3 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
                            FirmwareVersion firmwareVersion2 = FirmwareRepairJ2Activity.this.mLatestFirmware;
                            kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion2);
                            String absolutePath2 = new File(oOoXoXO3, firmwareVersion2.getFileName2()).getAbsolutePath();
                            kotlin.jvm.internal.IIX0o.oO(absolutePath2, "getAbsolutePath(...)");
                            firmwareRepairJ2Activity3.startOTA(absolutePath2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                LogUtils.d("ota onConnection -> device disconnected");
                if (FirmwareRepairJ2Activity.this.mOTAStatus == OTAStatus.UPGRADE_PREPARE) {
                    FirmwareRepairJ2Activity.this.updateUpgradeStatus(OTAStatus.UPGRADE_PREPARE_FAILED);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 extends BluetoothEventListener {
        public II0xO0() {
        }

        @Override // com.jieli.watchtesttool.tool.bluetooth.BluetoothEventListener
        public void onAdapterStatus(boolean z) {
            LogUtils.d("bt onAdapterStatus " + z);
        }

        @Override // com.jieli.watchtesttool.tool.bluetooth.BluetoothEventListener
        public void onConnection(@OXOo.OOXIXo BluetoothDevice device, int i) {
            Boolean bool;
            kotlin.jvm.internal.IIX0o.x0xO0oo(device, "device");
            StringBuilder sb = new StringBuilder();
            sb.append("bt onConnection -> mOTAStatus = ");
            sb.append(FirmwareRepairJ2Activity.this.mOTAStatus);
            sb.append(", ");
            sb.append(device);
            sb.append(" ,status = ");
            sb.append(i);
            sb.append(" ,isOTA = ");
            OTAManager oTAManager = FirmwareRepairJ2Activity.this.mOTAManager;
            if (oTAManager != null) {
                bool = Boolean.valueOf(oTAManager.isOTA());
            } else {
                bool = null;
            }
            sb.append(bool);
            LogUtils.d(sb.toString());
            if (i == 0) {
                LogUtils.d("bt onConnection -> device disconnected");
                if (FirmwareRepairJ2Activity.this.mOTAStatus == OTAStatus.UPGRADE_PREPARE) {
                    if (FirmwareRepairJ2Activity.this.mStepsIndex != 0) {
                        FirmwareRepairJ2Activity.this.updateUpgradeStatus(OTAStatus.UPGRADE_PREPARE_FAILED);
                        return;
                    }
                    LogUtils.d("bt onConnection -> try ble Address");
                    FirmwareRepairJ2Activity firmwareRepairJ2Activity = FirmwareRepairJ2Activity.this;
                    firmwareRepairJ2Activity.connectDevice(firmwareRepairJ2Activity.mDeviceInfo.getMBleAddress());
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f21780oIX0oI;

        static {
            int[] iArr = new int[OTAStatus.values().length];
            try {
                iArr[OTAStatus.UPGRADE_SCANNING_TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OTAStatus.UPGRADE_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OTAStatus.UPGRADE_PREPARE_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f21780oIX0oI = iArr;
        }
    }

    /* loaded from: classes12.dex */
    public static final class oxoX implements IUpgradeCallback {
        public oxoX() {
        }

        public static final void II0xO0(FirmwareRepairJ2Activity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            this$0.upgrade();
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onCancelOTA() {
            LogUtils.d("onCancelOTA");
            FirmwareRepairJ2Activity.this.updateUpgradeStatus(OTAStatus.UPGRADE_FAILED);
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onError(@OXOo.oOoXoXO BaseError baseError) {
            String str;
            LogUtils.d("onError -> " + baseError);
            FirmwareRepairJ2Activity.this.updateUpgradeStatus(OTAStatus.UPGRADE_FAILED);
            if (baseError != null) {
                str = baseError.getMessage();
            } else {
                str = null;
            }
            ToastUtils.showLong(str, new Object[0]);
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onNeedReconnect(@OXOo.oOoXoXO String str, boolean z) {
            LogUtils.d("onNeedReconnect : " + str + ", " + z);
            FirmwareRepairJ2Activity.this.isUseDfuAddress = true;
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onProgress(int i, float f) {
            if (i == 0) {
                FirmwareRepairJ2Activity.this.mOTAStatus = OTAStatus.UPGRADE_CHECKING;
                FirmwareRepairJ2Activity.this.getTvTip().setText(FirmwareRepairJ2Activity.this.getString(R.string.check_file));
            } else {
                FirmwareRepairJ2Activity.this.mOTAStatus = OTAStatus.UPGRADEING;
                FirmwareRepairJ2Activity.this.getTvTip().setText(FirmwareRepairJ2Activity.this.getString(R.string.starting));
            }
            FirmwareRepairJ2Activity.this.getDfuProgress().setProgress(Math.round(f) / 100.0f);
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onStartOTA() {
            LogUtils.d("onStartOTA");
            com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24419XO, true);
            FirmwareRepairJ2Activity.this.updateUpgradeStatus(OTAStatus.UPGRADE_START);
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onStopOTA() {
            FirmwareRepairJ2Activity.this.isUseDfuAddress = false;
            LogUtils.d("onStopOTA() upgrade ok " + FirmwareRepairJ2Activity.this.mStepsIndex);
            FirmwareRepairJ2Activity.this.updateUpgradeStatus(OTAStatus.UPGRADE_STOP);
            if (FirmwareRepairJ2Activity.this.mStepsIndex == 0) {
                FirmwareRepairJ2Activity.this.getDfuProgress().setProgress(0.0f);
                FirmwareRepairJ2Activity.this.mStepsIndex++;
                TextView tvTip = FirmwareRepairJ2Activity.this.getTvTip();
                final FirmwareRepairJ2Activity firmwareRepairJ2Activity = FirmwareRepairJ2Activity.this;
                tvTip.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.xo0x
                    @Override // java.lang.Runnable
                    public final void run() {
                        FirmwareRepairJ2Activity.oxoX.II0xO0(FirmwareRepairJ2Activity.this);
                    }
                }, 5000L);
                return;
            }
            com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24419XO, false);
            ToastUtils.showLong(R.string.repair_successful);
            UpgradeFailedDeviceData.INSTANCE.delete(FirmwareRepairJ2Activity.this.mDeviceInfo);
            FirmwareRepairJ2Activity.this.finish();
        }
    }

    public FirmwareRepairJ2Activity() {
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        Object fromJson = new Gson().fromJson(xo0.oxoX().getString(BleDeviceInfo.class.getName()), (Class<Object>) BleDeviceInfo.class);
        BleDeviceInfo bleDeviceInfo = (BleDeviceInfo) (fromJson == null ? BleDeviceInfo.class.newInstance() : fromJson);
        this.mDeviceInfo = bleDeviceInfo;
        this.mDfuAddress = UtilsKt.XO(bleDeviceInfo.getMBleAddress());
        this.mLatestFirmware = (FirmwareVersion) new Gson().fromJson(xo0.II0xO0().getString(FirmwareVersion.class.getName()), FirmwareVersion.class);
        this.mBluetoothHelper = BluetoothHelper.getInstance(Utils.getApp());
        this.mBtEventListener = new II0xO0();
        this.mOTAEventCallback = new I0Io();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean canOTA(OTAStatus oTAStatus) {
        if (!isOTAError(oTAStatus) && oTAStatus != OTAStatus.UPGRADE_STOP) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkDownload() {
        if (this.mDownloaded == 2) {
            getTvTip().setText(R.string.preparing);
            upgrade();
        }
    }

    private final void destroyOTA() {
        OTAManager oTAManager = this.mOTAManager;
        if (oTAManager != null) {
            oTAManager.unregisterBluetoothCallback(this.mOTAEventCallback);
        }
        OTAManager oTAManager2 = this.mOTAManager;
        if (oTAManager2 != null) {
            oTAManager2.release();
        }
        this.mOTAManager = null;
    }

    private final void initOTA() {
        OTAManager oTAManager = new OTAManager(this);
        this.mOTAManager = oTAManager;
        oTAManager.registerBluetoothCallback(this.mOTAEventCallback);
    }

    private final boolean isOTAError(OTAStatus oTAStatus) {
        int i = oIX0oI.f21780oIX0oI[oTAStatus.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUpgradeStatus(OTAStatus oTAStatus) {
        LogUtils.d("updateUpgradeStatus status = " + oTAStatus);
        this.mOTAStatus = oTAStatus;
        if (isOTAError(oTAStatus)) {
            setMStarted(false);
            getTvTip().setText(getString(R.string.firmware_upgrading_failed));
        } else {
            setMStarted(true);
        }
    }

    public final void checkFirmware() {
        LogUtils.d("mDeviceInfo -> " + this.mDeviceInfo);
        getTvTip().setText(R.string.firmware_repair_download_tip);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        FirmwareVersion firmwareVersion = this.mLatestFirmware;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion);
        String fileUrl2 = firmwareVersion.getFileUrl2();
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        netWorkUtils.download(fileUrl2, com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(oix0oi), this.mLatestFirmware.getFileName2(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.device.FirmwareRepairJ2Activity$checkFirmware$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                FirmwareRepairJ2Activity.this.mDownloaded = 0;
                FirmwareRepairJ2Activity.this.setMStarted(false);
            }

            @Override // com.sma.androidnetworklib.method.HttpProgressCallback
            public void handleProgress(int i) {
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str) {
                int i;
                FirmwareRepairJ2Activity firmwareRepairJ2Activity = FirmwareRepairJ2Activity.this;
                i = firmwareRepairJ2Activity.mDownloaded;
                firmwareRepairJ2Activity.mDownloaded = i + 1;
                FirmwareRepairJ2Activity.this.checkDownload();
            }
        });
        netWorkUtils.download(this.mLatestFirmware.getFileUrl(), com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(oix0oi), this.mLatestFirmware.getFileName(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.device.FirmwareRepairJ2Activity$checkFirmware$2
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                FirmwareRepairJ2Activity.this.mDownloaded = 0;
                FirmwareRepairJ2Activity.this.setMStarted(false);
            }

            @Override // com.sma.androidnetworklib.method.HttpProgressCallback
            public void handleProgress(int i) {
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str) {
                int i;
                FirmwareRepairJ2Activity firmwareRepairJ2Activity = FirmwareRepairJ2Activity.this;
                i = firmwareRepairJ2Activity.mDownloaded;
                firmwareRepairJ2Activity.mDownloaded = i + 1;
                FirmwareRepairJ2Activity.this.checkDownload();
            }
        });
    }

    public final void connectDevice(@OXOo.OOXIXo String address) {
        BluetoothDevice bluetoothDevice;
        kotlin.jvm.internal.IIX0o.x0xO0oo(address, "address");
        LogUtils.d("connectDevice: " + address);
        BluetoothHelper bluetoothHelper = this.mBluetoothHelper;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            bluetoothDevice = defaultAdapter.getRemoteDevice(address);
        } else {
            bluetoothDevice = null;
        }
        bluetoothHelper.connectDevice(bluetoothDevice);
    }

    @Override // com.sma.smartv3.ui.device.BaseFirmwareRepairActivity, com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        BleConnector.INSTANCE.closeConnection(true);
        com.sma.smartv3.util.ooXIXxIX.II0xO0(this);
        this.mBluetoothHelper.addBluetoothEventListener(this.mBtEventListener);
    }

    @Override // com.sma.smartv3.ui.device.BaseFirmwareRepairActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        if (!TextUtils.isEmpty(getMArg0())) {
            String mArg0 = getMArg0();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(mArg0);
            this.mDfuAddress = mArg0;
        }
        checkFirmware();
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setMStarted(true);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getMStarted()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.sma.smartv3.ui.device.BaseFirmwareRepairActivity, com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX().remove(BleDeviceInfo.class.getName());
        this.mBluetoothHelper.removeBluetoothEventListener(this.mBtEventListener);
        this.mBluetoothHelper.destroy();
        destroyOTA();
        BleConnector.INSTANCE.launch();
        super.onDestroy();
    }

    public final void startOTA(@OXOo.OOXIXo String filePath) {
        BluetoothOTAConfigure bluetoothOTAConfigure;
        kotlin.jvm.internal.IIX0o.x0xO0oo(filePath, "filePath");
        LogUtils.d("startOTA :: " + filePath);
        OTAManager oTAManager = this.mOTAManager;
        if (oTAManager != null) {
            bluetoothOTAConfigure = oTAManager.getBluetoothOption();
        } else {
            bluetoothOTAConfigure = null;
        }
        if (bluetoothOTAConfigure != null) {
            bluetoothOTAConfigure.setFirmwareFilePath(filePath);
        }
        OTAManager oTAManager2 = this.mOTAManager;
        if (oTAManager2 != null) {
            oTAManager2.startOTA(new oxoX());
        }
    }

    public final void upgrade() {
        destroyOTA();
        initOTA();
        updateUpgradeStatus(OTAStatus.UPGRADE_PREPARE);
        if (this.mStepsIndex > 0) {
            if (this.isUseDfuAddress) {
                LogUtils.d("upgrade FIRMWARE2 -> use dfuAddress");
                connectDevice(this.mDfuAddress);
                return;
            } else {
                LogUtils.d("upgrade FIRMWARE2 -> use bleAddress");
                connectDevice(this.mDeviceInfo.getMBleAddress());
                return;
            }
        }
        connectDevice(this.mDfuAddress);
    }
}
