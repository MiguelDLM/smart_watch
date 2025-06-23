package com.sma.smartv3.ui.device;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bluetrum.abota.bluetooth.BleManager;
import com.bluetrum.abota.bluetooth.BluetoothEventListener;
import com.bluetrum.abota.data.MyDataReader;
import com.bluetrum.fota.abota.ABOta;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.sma.androidnetworklib.method.HttpProgressCallback;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.FirmwareVersion;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.ui.device.FirmwareUpgradeZActivity;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.view.ProgressButton;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.collections.CollectionsKt__CollectionsKt;

@kotlin.jvm.internal.XX({"SMAP\nFirmwareUpgradeZActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwareUpgradeZActivity.kt\ncom/sma/smartv3/ui/device/FirmwareUpgradeZActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,355:1\n15#2:356\n*S KotlinDebug\n*F\n+ 1 FirmwareUpgradeZActivity.kt\ncom/sma/smartv3/ui/device/FirmwareUpgradeZActivity\n*L\n110#1:356\n*E\n"})
/* loaded from: classes12.dex */
public final class FirmwareUpgradeZActivity extends BaseFirmwareUpgradeActivity {

    @OXOo.oOoXoXO
    private ABOta mAbOta;

    @OXOo.oOoXoXO
    private BleManager mBluetoothManager;
    private int mDownloaded;
    private int mStepsIndex;

    @OXOo.OOXIXo
    private final String TAG = "UpgradeZ";

    @OXOo.OOXIXo
    private final II0xO0 mBluetoothEventListener = new II0xO0();

    @OXOo.OOXIXo
    private final I0Io mOTAEventListener = new I0Io();

    @OXOo.oOoXoXO
    private final FirmwareVersion mLatestFirmware = (FirmwareVersion) new Gson().fromJson(com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().getString(FirmwareVersion.class.getName()), FirmwareVersion.class);

    @OXOo.OOXIXo
    private final String mCurrentFirmware = BleCache.getString$default(BleCache.INSTANCE, BleKey.FIRMWARE_VERSION, null, null, 6, null);

    @OXOo.OOXIXo
    private final List<FileType> mSteps = new ArrayList();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes12.dex */
    public static final class FileType {
        private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
        private static final /* synthetic */ FileType[] $VALUES;
        public static final FileType FIRMWARE = new FileType("FIRMWARE", 0);

        private static final /* synthetic */ FileType[] $values() {
            return new FileType[]{FIRMWARE};
        }

        static {
            FileType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.I0Io.I0Io($values);
        }

        private FileType(String str, int i) {
        }

        @OXOo.OOXIXo
        public static kotlin.enums.oIX0oI<FileType> getEntries() {
            return $ENTRIES;
        }

        public static FileType valueOf(String str) {
            return (FileType) Enum.valueOf(FileType.class, str);
        }

        public static FileType[] values() {
            return (FileType[]) $VALUES.clone();
        }
    }

    /* loaded from: classes12.dex */
    public static final class I0Io implements ABOta.EventListener {
        public I0Io() {
        }

        @Override // com.bluetrum.fota.abota.ABOta.EventListener
        public void onReceiveChannel(boolean z) {
        }

        @Override // com.bluetrum.fota.abota.ABOta.EventListener
        public void onReceiveTwsInfo(boolean z, boolean z2) {
        }

        @Override // com.bluetrum.fota.abota.ABOta.EventListener
        public void onReceiveVersion(int i) {
            kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
            String format = String.format(Locale.getDefault(), "V%d.%d.%d.%d", Arrays.copyOf(new Object[]{Integer.valueOf((i >> 12) & 15), Integer.valueOf((i >> 8) & 15), Integer.valueOf((i >> 4) & 15), Integer.valueOf(i & 15)}, 4));
            kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeZActivity.this.TAG + " onReceiveVersion -> " + format);
        }

        @Override // com.bluetrum.fota.abota.ABOta.EventListener
        public void onStatusChanged(int i, int i2) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeZActivity.this.TAG + " onStatusChanged -> " + i + ", " + i2);
            switch (i) {
                case 0:
                    FirmwareUpgradeZActivity.this.otaReady();
                    return;
                case 1:
                    FirmwareUpgradeZActivity.this.otaStart();
                    return;
                case 2:
                    FirmwareUpgradeZActivity.this.otaUpdating(i2);
                    return;
                case 3:
                    FirmwareUpgradeZActivity.this.otaPause();
                    return;
                case 4:
                    FirmwareUpgradeZActivity.this.otaContinue();
                    return;
                case 5:
                    FirmwareUpgradeZActivity.this.otaFinish();
                    return;
                case 6:
                    FirmwareUpgradeZActivity.this.otaWaitFinish();
                    return;
                case 7:
                    FirmwareUpgradeZActivity.this.otaStatusFail(i2);
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements BluetoothEventListener {

        @kotlin.jvm.internal.XX({"SMAP\nTimer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Timer.kt\nkotlin/concurrent/TimersKt$timerTask$1\n+ 2 FirmwareUpgradeZActivity.kt\ncom/sma/smartv3/ui/device/FirmwareUpgradeZActivity$mBluetoothEventListener$1\n*L\n1#1,148:1\n53#2,4:149\n*E\n"})
        /* loaded from: classes12.dex */
        public static final class oIX0oI extends TimerTask {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ FirmwareUpgradeZActivity f21882XO;

            public oIX0oI(FirmwareUpgradeZActivity firmwareUpgradeZActivity) {
                this.f21882XO = firmwareUpgradeZActivity;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                BleManager bleManager = this.f21882XO.mBluetoothManager;
                if (bleManager != null && bleManager.isReady()) {
                    ABOta aBOta = this.f21882XO.mAbOta;
                    if (aBOta == null || !aBOta.isUpdating()) {
                        FirmwareUpgradeZActivity firmwareUpgradeZActivity = this.f21882XO;
                        StringBuilder sb = new StringBuilder();
                        sb.append(com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(X00IoxXI.oIX0oI.f3233oIX0oI));
                        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
                        FirmwareVersion firmwareVersion = this.f21882XO.mLatestFirmware;
                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion);
                        sb.append(firmwareVersion.getFileName());
                        firmwareUpgradeZActivity.startOTA(sb.toString());
                    }
                }
            }
        }

        public II0xO0() {
        }

        public static final void II0xO0(FirmwareUpgradeZActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            this$0.updateUpgradeStatus(true, "disconnected");
        }

        @Override // com.bluetrum.abota.bluetooth.BluetoothEventListener
        public void onBluetoothReady() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeZActivity.this.TAG + " onBluetoothReady");
            ABOta aBOta = FirmwareUpgradeZActivity.this.mAbOta;
            if (aBOta != null) {
                aBOta.prepareToUpdate();
            }
            new Timer().schedule(new oIX0oI(FirmwareUpgradeZActivity.this), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }

        @Override // com.bluetrum.abota.bluetooth.BluetoothEventListener
        public void onConnectionStateChange(@OXOo.oOoXoXO BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i2 == 0) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeZActivity.this.TAG + " onConnectionStateChange -> disconnected");
                final FirmwareUpgradeZActivity firmwareUpgradeZActivity = FirmwareUpgradeZActivity.this;
                firmwareUpgradeZActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.device.IoXIXo
                    @Override // java.lang.Runnable
                    public final void run() {
                        FirmwareUpgradeZActivity.II0xO0.II0xO0(FirmwareUpgradeZActivity.this);
                    }
                });
            }
        }

        @Override // com.bluetrum.abota.bluetooth.BluetoothEventListener
        public void onReceive(@OXOo.oOoXoXO byte[] bArr) {
            ABOta aBOta = FirmwareUpgradeZActivity.this.mAbOta;
            if (aBOta != null) {
                aBOta.handleData(bArr);
            }
        }

        @Override // com.bluetrum.abota.bluetooth.BluetoothEventListener
        public void onSend(@OXOo.oOoXoXO byte[] bArr) {
            ABOta aBOta = FirmwareUpgradeZActivity.this.mAbOta;
            if (aBOta != null) {
                aBOta.nextRun();
            }
        }
    }

    /* loaded from: classes12.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f21883oIX0oI;

        static {
            int[] iArr = new int[FileType.values().length];
            try {
                iArr[FileType.FIRMWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f21883oIX0oI = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkDownload() {
        if (this.mDownloaded == this.mSteps.size()) {
            ProgressButton.X0o0xo(getProgressButton(), R.string.preparing, false, 2, null);
            LogUtils.d("checkDownload done start upgrade");
            upgrade();
        }
    }

    private final void destroyOTA() {
        BleManager bleManager = this.mBluetoothManager;
        if (bleManager != null) {
            bleManager.close();
        }
        this.mAbOta = null;
        this.mBluetoothManager = null;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " destroyOTA");
    }

    private final void initOTA() {
        BleManager bleManager = new BleManager(this, BluetoothAdapter.getDefaultAdapter().getRemoteDevice(BleCache.INSTANCE.getMBleAddress()));
        this.mBluetoothManager = bleManager;
        ABOta aBOta = new ABOta();
        this.mAbOta = aBOta;
        aBOta.setEventListener(this.mOTAEventListener);
        ABOta aBOta2 = this.mAbOta;
        if (aBOta2 != null) {
            aBOta2.setSendCallback(bleManager);
        }
        BleManager bleManager2 = this.mBluetoothManager;
        if (bleManager2 != null) {
            bleManager2.setEventListener(this.mBluetoothEventListener);
        }
        BleManager bleManager3 = this.mBluetoothManager;
        if (bleManager3 != null) {
            bleManager3.open();
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " initOTA");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void otaContinue() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " otaContinue -> Upgrading firmware...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void otaFinish() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " otaFinish -> The upgrade is complete");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void otaPause() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " otaPause -> The upgrade has been paused");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void otaReady() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " otaReady -> Ready");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void otaStart() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " otaStart -> Upgrading firmware...");
        updateUpgradeStatus$default(this, false, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void otaStatusFail(int i) {
        String str;
        if (i != 1) {
            if (i != 2) {
                if (i != 11) {
                    if (i != 4097) {
                        switch (i) {
                            case 4099:
                                str = "Receive timeout";
                                break;
                            case 4100:
                                str = "TWS is disconnected and the upgrade is stopped";
                                break;
                            case 4101:
                                str = "DataReader error";
                                break;
                            default:
                                str = "Unknown error";
                                break;
                        }
                    } else {
                        str = "The device refuses to be upgraded";
                    }
                } else {
                    str = "CRC error";
                }
            } else {
                str = "The key does not correspond";
            }
        } else {
            str = "The firmware is the same";
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " otaStatusFail -> " + str);
        updateUpgradeStatus(true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void otaUpdating(final int i) {
        runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.device.O0IxXx
            @Override // java.lang.Runnable
            public final void run() {
                FirmwareUpgradeZActivity.otaUpdating$lambda$1(FirmwareUpgradeZActivity.this, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void otaUpdating$lambda$1(FirmwareUpgradeZActivity this$0, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getProgressButton().setProgress(i / 100.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void otaWaitFinish() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " otaWaitFinish -> The data transfer is complete, please wait for the upgrade to complete, and the device will restart automatically");
        upgradeDone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUpgradeStatus(boolean z, String str) {
        if (z) {
            setMStarted(false);
            ProgressButton.XO(getProgressButton(), com.sma.smartv3.util.oO.f24511oIX0oI.X0o0xo(), false, 2, null);
            ToastUtils.showLong(str, new Object[0]);
            return;
        }
        setMStarted(true);
    }

    public static /* synthetic */ void updateUpgradeStatus$default(FirmwareUpgradeZActivity firmwareUpgradeZActivity, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        firmwareUpgradeZActivity.updateUpgradeStatus(z, str);
    }

    private final void upgrade() {
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI(this.TAG + " upgrade " + this.mSteps.get(this.mStepsIndex));
        getTvStep().setVisibility(0);
        ProgressButton.X0o0xo(getProgressButton(), R.string.starting, false, 2, null);
        getTvStep().setText(getString(R.string.upgrade_steps_d_d, Integer.valueOf(this.mStepsIndex + 1), Integer.valueOf(this.mSteps.size())));
        if (oIX0oI.f21883oIX0oI[this.mSteps.get(this.mStepsIndex).ordinal()] == 1) {
            oix0oi.oIX0oI(this.TAG + " firmware");
            destroyOTA();
            initOTA();
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        String str;
        super.initView();
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI(this.TAG + " Server -> " + UtilsKt.IXxxXO());
        oix0oi.oIX0oI(this.TAG + " Firmware -> " + this.mLatestFirmware);
        FirmwareVersion firmwareVersion = this.mLatestFirmware;
        if (firmwareVersion == null) {
            getTvLatest().setText(getString(R.string.v_s, String.valueOf(this.mCurrentFirmware)));
            ViewParent parent = getTvCurrent().getParent();
            kotlin.jvm.internal.IIX0o.x0XOIxOo(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).setVisibility(8);
            getProgressButton().setVisibility(8);
            return;
        }
        if (firmwareVersion == null || (str = firmwareVersion.getVersion()) == null) {
            str = this.mCurrentFirmware;
        }
        getTvLatest().setText(getString(R.string.v_s, String.valueOf(str)));
        oix0oi.oIX0oI(this.TAG + " latest -> " + ((Object) getTvLatest().getText()));
        getTvCurrent().setText(getString(R.string.v_s, String.valueOf(this.mCurrentFirmware)));
        oix0oi.oIX0oI(this.TAG + " current -> " + ((Object) getTvCurrent().getText()));
        this.mSteps.add(FileType.FIRMWARE);
        getTvStep().setVisibility(0);
    }

    @Override // com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getMStarted()) {
            return;
        }
        super.onBackPressed();
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (!BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            ToastUtils.showLong("Bluetooth is off!", new Object[0]);
            return;
        }
        if (!ProductManager.f20544oIX0oI.o0xIoII()) {
            BleConnector.INSTANCE.closeConnection(true);
        }
        this.mDownloaded = 0;
        setMStarted(true);
        ProgressButton.X0o0xo(getProgressButton(), R.string.downloading, false, 2, null);
        if (this.mStepsIndex == 0) {
            if (this.mLatestFirmware != null) {
                File file = new File(com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(X00IoxXI.oIX0oI.f3233oIX0oI), this.mLatestFirmware.getFileName());
                if (FileUtils.isFileExists(file)) {
                    this.mDownloaded++;
                    checkDownload();
                    return;
                }
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " download firmware");
                NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
                String fileUrl = this.mLatestFirmware.getFileUrl();
                String parent = file.getParent();
                kotlin.jvm.internal.IIX0o.oO(parent, "getParent(...)");
                String name = file.getName();
                kotlin.jvm.internal.IIX0o.oO(name, "getName(...)");
                netWorkUtils.download(fileUrl, parent, name, new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.device.FirmwareUpgradeZActivity$onBottomClick$1
                    @Override // xxxI.II0xO0
                    public void handleError(@OXOo.OOXIXo String error) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeZActivity.this.TAG + " download firmware error -> " + error);
                        FirmwareUpgradeZActivity.this.mDownloaded = 0;
                        FirmwareUpgradeZActivity.this.setMStarted(false);
                    }

                    @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                    public void handleProgress(int i) {
                    }

                    @Override // xxxI.II0xO0
                    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                    public void handleResponse(@OXOo.oOoXoXO String str) {
                        int i;
                        FirmwareUpgradeZActivity firmwareUpgradeZActivity = FirmwareUpgradeZActivity.this;
                        i = firmwareUpgradeZActivity.mDownloaded;
                        firmwareUpgradeZActivity.mDownloaded = i + 1;
                        FirmwareUpgradeZActivity.this.checkDownload();
                        FirmwareUpgradeZActivity firmwareUpgradeZActivity2 = FirmwareUpgradeZActivity.this;
                        BaseFirmwareUpgradeActivity.uploadDownloadInfo$default(firmwareUpgradeZActivity2, firmwareUpgradeZActivity2.mLatestFirmware.getFileUrl(), FirmwareUpgradeZActivity.this.mLatestFirmware.getFileName(), 0, 4, null);
                    }
                });
                return;
            }
            return;
        }
        upgrade();
    }

    @Override // com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity, com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (!this.mSteps.isEmpty() && this.mStepsIndex == CollectionsKt__CollectionsKt.oo0xXOI0I(this.mSteps)) {
            BleCache.remove$default(BleCache.INSTANCE, BleKey.UI_FILE, null, 2, null);
            BleConnector.INSTANCE.closeConnection(true);
        }
        destroyOTA();
        super.onDestroy();
    }

    public final void startOTA(@OXOo.OOXIXo String filePath) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(filePath, "filePath");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " startOTA -> " + filePath);
        MyDataReader myDataReader = new MyDataReader(filePath);
        ABOta aBOta = this.mAbOta;
        if (aBOta != null) {
            aBOta.setDataReader(myDataReader);
        }
        ABOta aBOta2 = this.mAbOta;
        if (aBOta2 != null) {
            aBOta2.startOTA();
        }
    }

    public final void upgradeDone() {
        ToastUtils.showLong(R.string.support_dual_backup_upgrade_successful);
        FirmwareVersion firmwareVersion = this.mLatestFirmware;
        if (firmwareVersion != null) {
            updateDeviceInfo(firmwareVersion.getVersion());
        }
        finish();
        FirmwareVersion firmwareVersion2 = this.mLatestFirmware;
        if (firmwareVersion2 != null && firmwareVersion2.getFlag() == 2) {
            com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24614XX, Boolean.TRUE);
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24561I0, null, 2, null);
        }
        com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24640ooOx, "done");
    }
}
