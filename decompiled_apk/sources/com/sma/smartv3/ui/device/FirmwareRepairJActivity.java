package com.sma.smartv3.ui.device;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.text.TextUtils;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jieli.jl_bt_ota.interfaces.BtEventCallback;
import com.jieli.jl_bt_ota.interfaces.IUpgradeCallback;
import com.jieli.jl_bt_ota.model.BluetoothOTAConfigure;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.watchtesttool.tool.bluetooth.BluetoothEventListener;
import com.jieli.watchtesttool.tool.bluetooth.BluetoothHelper;
import com.jieli.watchtesttool.tool.upgrade.OTAManager;
import com.sma.androidnetworklib.method.HttpProgressCallback;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.FirmwareVersion;
import com.sma.smartv3.model.UpgradeFailedDeviceData;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.FirmwareVersionLatest;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.util.UtilsKt;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleDeviceInfo;
import java.util.HashMap;
import java.util.Map;

@kotlin.jvm.internal.XX({"SMAP\nFirmwareRepairJActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwareRepairJActivity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairJActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 4 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,275:1\n18#2,2:276\n15#2:278\n27#2,2:279\n151#3,11:281\n171#3:300\n208#4,7:292\n226#4:299\n*S KotlinDebug\n*F\n+ 1 FirmwareRepairJActivity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairJActivity\n*L\n51#1:276,2\n51#1:278\n122#1:279,2\n193#1:281,11\n193#1:300\n193#1:292,7\n193#1:299\n*E\n"})
/* loaded from: classes12.dex */
public final class FirmwareRepairJActivity extends BaseFirmwareRepairActivity {

    @OXOo.OOXIXo
    private String mAddress;
    private final BluetoothHelper mBluetoothHelper;

    @OXOo.OOXIXo
    private final II0xO0 mBtEventListener;

    @OXOo.OOXIXo
    private final BleDeviceInfo mDeviceInfo;

    @OXOo.oOoXoXO
    private String mFilePath;

    @OXOo.OOXIXo
    private final BtEventCallback mOTAEventCallback;

    @OXOo.oOoXoXO
    private OTAManager mOTAManager;

    @OXOo.OOXIXo
    private final String TAG = "RepairJ";

    @OXOo.OOXIXo
    private OTAStatus mOTAStatus = OTAStatus.NONE;

    @kotlin.jvm.internal.XX({"SMAP\nFirmwareRepairJActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwareRepairJActivity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairJActivity$mOTAEventCallback$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,275:1\n1#2:276\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class I0Io extends BtEventCallback {
        public I0Io() {
        }

        @Override // com.jieli.jl_bt_ota.interfaces.BtEventCallback, com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
        public void onConnection(@OXOo.OOXIXo BluetoothDevice device, int i) {
            Boolean bool;
            String str;
            kotlin.jvm.internal.IIX0o.x0xO0oo(device, "device");
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            sb.append(FirmwareRepairJActivity.this.TAG);
            sb.append(" ota onConnection -> mOTAStatus = ");
            sb.append(FirmwareRepairJActivity.this.mOTAStatus);
            sb.append(", ");
            sb.append(device);
            sb.append(" ,status = ");
            sb.append(i);
            sb.append(" ,isOTA = ");
            OTAManager oTAManager = FirmwareRepairJActivity.this.mOTAManager;
            if (oTAManager != null) {
                bool = Boolean.valueOf(oTAManager.isOTA());
            } else {
                bool = null;
            }
            sb.append(bool);
            oix0oi.oIX0oI(sb.toString());
            OTAManager oTAManager2 = FirmwareRepairJActivity.this.mOTAManager;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oTAManager2);
            if (!oTAManager2.isOTA()) {
                if (i != 0) {
                    if (i == 1) {
                        FirmwareRepairJActivity firmwareRepairJActivity = FirmwareRepairJActivity.this;
                        if (firmwareRepairJActivity.canOTA(firmwareRepairJActivity.mOTAStatus) && (str = FirmwareRepairJActivity.this.mFilePath) != null) {
                            FirmwareRepairJActivity.this.startOTA(str);
                            return;
                        }
                        return;
                    }
                    return;
                }
                oix0oi.oIX0oI(FirmwareRepairJActivity.this.TAG + " ota onConnection -> device disconnected");
                if (FirmwareRepairJActivity.this.mOTAStatus == OTAStatus.UPGRADE_PREPARE) {
                    FirmwareRepairJActivity.this.updateUpgradeStatus(OTAStatus.UPGRADE_PREPARE_FAILED);
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
            LogUtils.d(FirmwareRepairJActivity.this.TAG + " bt onAdapterStatus -> " + z);
        }

        @Override // com.jieli.watchtesttool.tool.bluetooth.BluetoothEventListener
        public void onConnection(@OXOo.OOXIXo BluetoothDevice device, int i) {
            Boolean bool;
            kotlin.jvm.internal.IIX0o.x0xO0oo(device, "device");
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            sb.append(FirmwareRepairJActivity.this.TAG);
            sb.append(" bt onConnection -> mOTAStatus = ");
            sb.append(FirmwareRepairJActivity.this.mOTAStatus);
            sb.append(", ");
            sb.append(device);
            sb.append(", status = ");
            sb.append(i);
            sb.append(" ,isOTA = ");
            OTAManager oTAManager = FirmwareRepairJActivity.this.mOTAManager;
            if (oTAManager != null) {
                bool = Boolean.valueOf(oTAManager.isOTA());
            } else {
                bool = null;
            }
            sb.append(bool);
            oix0oi.oIX0oI(sb.toString());
            if (i == 0) {
                oix0oi.oIX0oI(FirmwareRepairJActivity.this.TAG + " bt onConnection -> device disconnected");
                if (FirmwareRepairJActivity.this.mOTAStatus == OTAStatus.UPGRADE_PREPARE) {
                    FirmwareRepairJActivity.this.updateUpgradeStatus(OTAStatus.UPGRADE_PREPARE_FAILED);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f21790oIX0oI;

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
            f21790oIX0oI = iArr;
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nFirmwareRepairJActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwareRepairJActivity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairJActivity$startOTA$1\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,275:1\n27#2,2:276\n*S KotlinDebug\n*F\n+ 1 FirmwareRepairJActivity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairJActivity$startOTA$1\n*L\n158#1:276,2\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class oxoX implements IUpgradeCallback {
        public oxoX() {
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onCancelOTA() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareRepairJActivity.this.TAG + " ota cancel");
            FirmwareRepairJActivity.this.updateUpgradeStatus(OTAStatus.UPGRADE_FAILED);
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onError(@OXOo.oOoXoXO BaseError baseError) {
            String str;
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareRepairJActivity.this.TAG + " onError -> status = " + FirmwareRepairJActivity.this.mOTAStatus + ", error = " + baseError);
            FirmwareRepairJActivity.this.updateUpgradeStatus(OTAStatus.UPGRADE_FAILED);
            if (baseError != null) {
                str = baseError.getMessage();
            } else {
                str = null;
            }
            ToastUtils.showLong(str, new Object[0]);
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onNeedReconnect(@OXOo.OOXIXo String addr, boolean z) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(addr, "addr");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareRepairJActivity.this.TAG + " onNeedReconnect -> " + addr + ", " + z);
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onProgress(int i, float f) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareRepairJActivity.this.TAG + " ota p -> " + i + ", " + f);
            if (i == 0) {
                FirmwareRepairJActivity.this.mOTAStatus = OTAStatus.UPGRADE_CHECKING;
                FirmwareRepairJActivity.this.getTvTip().setText(FirmwareRepairJActivity.this.getString(R.string.check_file));
            } else {
                FirmwareRepairJActivity.this.mOTAStatus = OTAStatus.UPGRADEING;
                FirmwareRepairJActivity.this.getTvTip().setText(FirmwareRepairJActivity.this.getString(R.string.starting));
            }
            FirmwareRepairJActivity.this.getDfuProgress().setProgress(Math.round(f) / 100.0f);
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onStartOTA() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareRepairJActivity.this.TAG + " ota start");
            com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24419XO, true);
            FirmwareRepairJActivity.this.updateUpgradeStatus(OTAStatus.UPGRADE_START);
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onStopOTA() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareRepairJActivity.this.TAG + " ota stop! upgrade is ok");
            FirmwareRepairJActivity.this.updateUpgradeStatus(OTAStatus.UPGRADE_STOP);
            com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
            xo0.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24419XO, false);
            ToastUtils.showLong(R.string.repair_successful);
            UpgradeFailedDeviceData.INSTANCE.delete(FirmwareRepairJActivity.this.mDeviceInfo);
            xo0.II0xO0().remove(FirmwareVersion.class.getName());
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24613XOxIOxOx, null, 2, null);
            FirmwareRepairJActivity.this.finish();
        }
    }

    public FirmwareRepairJActivity() {
        Object fromJson = new Gson().fromJson(com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX().getString(BleDeviceInfo.class.getName()), (Class<Object>) BleDeviceInfo.class);
        BleDeviceInfo bleDeviceInfo = (BleDeviceInfo) (fromJson == null ? BleDeviceInfo.class.newInstance() : fromJson);
        this.mDeviceInfo = bleDeviceInfo;
        this.mAddress = UtilsKt.XO(bleDeviceInfo.getMBleAddress());
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
        int i = oIX0oI.f21790oIX0oI[oTAStatus.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUpgradeStatus(OTAStatus oTAStatus) {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " updateUpgradeStatus status -> " + oTAStatus);
        this.mOTAStatus = oTAStatus;
        if (isOTAError(oTAStatus)) {
            setMStarted(false);
            getTvTip().setText(getString(R.string.firmware_upgrading_failed));
        } else {
            setMStarted(true);
        }
    }

    public final void checkFirmware() {
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI(this.TAG + " Server -> " + UtilsKt.IXxxXO());
        oix0oi.oIX0oI(this.TAG + " checkFirmware deviceInfo -> " + this.mDeviceInfo);
        getTvTip().setText(R.string.firmware_repair_download_tip);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> checkFirmwareVersionBody = RequestBodyKt.getCheckFirmwareVersionBody("0", "N", this.mDeviceInfo.getMBleName(), this.mDeviceInfo.getMFirmwareFlag());
        final xxxI.II0xO0<FirmwareVersion> iI0xO0 = new xxxI.II0xO0<FirmwareVersion>() { // from class: com.sma.smartv3.ui.device.FirmwareRepairJActivity$checkFirmware$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                FirmwareRepairJActivity.this.setMStarted(false);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO FirmwareVersion firmwareVersion) {
                if (firmwareVersion != null) {
                    FirmwareRepairJActivity firmwareRepairJActivity = FirmwareRepairJActivity.this;
                    firmwareRepairJActivity.getTvName().setText(firmwareVersion.getFileName());
                    firmwareRepairJActivity.getTvSize().setText(ConvertUtils.byte2FitMemorySize(firmwareVersion.getFileSize()));
                    firmwareRepairJActivity.download(firmwareVersion);
                }
            }
        };
        final Activity mContext = getMContext();
        final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(mContext, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), FirmwareVersionLatest.URL);
        netWorkUtils.printParam(convertBaseUrl + FirmwareVersionLatest.URL, checkFirmwareVersionBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + FirmwareVersionLatest.URL;
        final xxxI.II0xO0<Response<FirmwareVersion>> iI0xO02 = new xxxI.II0xO0<Response<FirmwareVersion>>() { // from class: com.sma.smartv3.ui.device.FirmwareRepairJActivity$checkFirmware$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<FirmwareVersion> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity = mContext;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) checkFirmwareVersionBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, FirmwareVersion.class), new ParsedRequestListener<Response<FirmwareVersion>>() { // from class: com.sma.smartv3.ui.device.FirmwareRepairJActivity$checkFirmware$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<FirmwareVersion> response) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", ");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final void connectDevice(@OXOo.OOXIXo String address) {
        BluetoothDevice bluetoothDevice;
        kotlin.jvm.internal.IIX0o.x0xO0oo(address, "address");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " connectDevice -> " + address);
        BluetoothHelper bluetoothHelper = this.mBluetoothHelper;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            bluetoothDevice = defaultAdapter.getRemoteDevice(address);
        } else {
            bluetoothDevice = null;
        }
        bluetoothHelper.connectDevice(bluetoothDevice);
    }

    public final void download(@OXOo.OOXIXo FirmwareVersion firmwareVersion) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(firmwareVersion, "firmwareVersion");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " download " + firmwareVersion);
        StringBuilder sb = new StringBuilder();
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        sb.append(com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(oix0oi));
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb.append(firmwareVersion.getFileName());
        this.mFilePath = sb.toString();
        NetWorkUtils.INSTANCE.download(firmwareVersion.getFileUrl(), com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(oix0oi), firmwareVersion.getFileName(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.device.FirmwareRepairJActivity$download$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareRepairJActivity.this.TAG + " download firmware error -> " + error);
                FirmwareRepairJActivity.this.setMStarted(false);
            }

            @Override // com.sma.androidnetworklib.method.HttpProgressCallback
            public void handleProgress(int i) {
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str) {
                FirmwareRepairJActivity.this.upgrade();
            }
        });
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
            this.mAddress = mArg0;
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " mAddress -> " + this.mAddress);
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
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " startOTA -> " + filePath);
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
        connectDevice(this.mAddress);
    }
}
