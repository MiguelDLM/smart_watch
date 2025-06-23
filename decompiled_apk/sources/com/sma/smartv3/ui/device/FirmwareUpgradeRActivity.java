package com.sma.smartv3.ui.device;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.gson.Gson;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.DfuProgressInfo;
import com.realsil.sdk.dfu.model.Throughput;
import com.realsil.sdk.dfu.utils.DfuAdapter;
import com.realsil.sdk.dfu.utils.GattDfuAdapter;
import com.sma.androidnetworklib.method.HttpProgressCallback;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.ExtraPackVersions;
import com.sma.smartv3.model.FirmwareVersion;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.ui.device.FirmwareUpgradeRActivity;
import com.sma.smartv3.view.ProgressButton;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleLanguagePackVersion;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

@kotlin.jvm.internal.XX({"SMAP\nFirmwareUpgradeRActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwareUpgradeRActivity.kt\ncom/sma/smartv3/ui/device/FirmwareUpgradeRActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,270:1\n15#2:271\n15#2:272\n*S KotlinDebug\n*F\n+ 1 FirmwareUpgradeRActivity.kt\ncom/sma/smartv3/ui/device/FirmwareUpgradeRActivity\n*L\n94#1:271\n95#1:272\n*E\n"})
/* loaded from: classes12.dex */
public final class FirmwareUpgradeRActivity extends BaseFirmwareUpgradeActivity {

    @OXOo.OOXIXo
    private final String mCurrentFirmware;

    @OXOo.OOXIXo
    private final String mCurrentLanguage;

    @OXOo.OOXIXo
    private final String mCurrentUi;

    @OXOo.OOXIXo
    private final DfuConfig mDfuConfig;
    private int mDownloaded;

    @OXOo.oOoXoXO
    private final ExtraPackVersions mLatestExtraPacks;

    @OXOo.oOoXoXO
    private final FirmwareVersion mLatestFirmware;

    @OXOo.oOoXoXO
    private final FirmwareVersion mLatestLanguage;

    @OXOo.oOoXoXO
    private final FirmwareVersion mLatestUi;

    @OXOo.OOXIXo
    private final List<FileType> mSteps;
    private int mStepsIndex;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mDfuHelper$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<GattDfuAdapter>() { // from class: com.sma.smartv3.ui.device.FirmwareUpgradeRActivity$mDfuHelper$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final GattDfuAdapter invoke() {
            Activity mContext;
            mContext = FirmwareUpgradeRActivity.this.getMContext();
            return GattDfuAdapter.getInstance(mContext);
        }
    });

    @OXOo.OOXIXo
    private final II0xO0 mDfuCallback = new II0xO0();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes12.dex */
    public static final class FileType {
        private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
        private static final /* synthetic */ FileType[] $VALUES;
        public static final FileType FIRMWARE = new FileType("FIRMWARE", 0);
        public static final FileType UI_PACK = new FileType("UI_PACK", 1);
        public static final FileType LANGUAGE_PACK = new FileType("LANGUAGE_PACK", 2);

        private static final /* synthetic */ FileType[] $values() {
            return new FileType[]{FIRMWARE, UI_PACK, LANGUAGE_PACK};
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
    public static final class II0xO0 extends DfuAdapter.DfuHelperCallback {
        public II0xO0() {
        }

        public static final void II0XooXoX(FirmwareUpgradeRActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            this$0.upgrade();
        }

        public static final void Oxx0IOOO(int i, final FirmwareUpgradeRActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            if (i == 258) {
                if (this$0.mStepsIndex < CollectionsKt__CollectionsKt.oo0xXOI0I(this$0.mSteps)) {
                    this$0.getProgressButton().setProgress(0.0f);
                    this$0.mStepsIndex++;
                    this$0.getTvStep().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.xx0X0
                        @Override // java.lang.Runnable
                        public final void run() {
                            FirmwareUpgradeRActivity.II0xO0.II0XooXoX(FirmwareUpgradeRActivity.this);
                        }
                    }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                    return;
                }
                this$0.finish();
            }
        }

        public static final void XO(FirmwareUpgradeRActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            ProgressButton.XO(this$0.getProgressButton(), com.sma.smartv3.util.oO.f24511oIX0oI.X0o0xo(), false, 2, null);
        }

        public static final void xoIox(int i, FirmwareUpgradeRActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            if (i == 258) {
                this$0.upgrade();
            } else if (i == 4097) {
                this$0.setMStarted(false);
                ProgressButton.XO(this$0.getProgressButton(), com.sma.smartv3.util.oO.f24511oIX0oI.X0o0xo(), false, 2, null);
            }
        }

        public static final void xxIXOIIO(FirmwareUpgradeRActivity this$0, DfuProgressInfo progressInfo) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            kotlin.jvm.internal.IIX0o.x0xO0oo(progressInfo, "$progressInfo");
            this$0.getProgressButton().setProgress(progressInfo.getProgress() / 100.0f);
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onError(int i, int i2) {
            LogUtils.e("FirmwareUpgradeRActivity onError: type=" + i + ", code" + i2);
            FirmwareUpgradeRActivity.this.setMStarted(false);
            ToastUtils.showLong(R.string.firmware_upgrading_failed_and_retry);
            final FirmwareUpgradeRActivity firmwareUpgradeRActivity = FirmwareUpgradeRActivity.this;
            firmwareUpgradeRActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.device.xOoOIoI
                @Override // java.lang.Runnable
                public final void run() {
                    FirmwareUpgradeRActivity.II0xO0.XO(FirmwareUpgradeRActivity.this);
                }
            });
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onProcessStateChanged(final int i, @OXOo.oOoXoXO Throughput throughput) {
            final FirmwareUpgradeRActivity firmwareUpgradeRActivity = FirmwareUpgradeRActivity.this;
            firmwareUpgradeRActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.device.IoIOOxIIo
                @Override // java.lang.Runnable
                public final void run() {
                    FirmwareUpgradeRActivity.II0xO0.Oxx0IOOO(i, firmwareUpgradeRActivity);
                }
            });
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onProgressChanged(@OXOo.OOXIXo final DfuProgressInfo progressInfo) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(progressInfo, "progressInfo");
            final FirmwareUpgradeRActivity firmwareUpgradeRActivity = FirmwareUpgradeRActivity.this;
            firmwareUpgradeRActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.device.Ox0O
                @Override // java.lang.Runnable
                public final void run() {
                    FirmwareUpgradeRActivity.II0xO0.xxIXOIIO(FirmwareUpgradeRActivity.this, progressInfo);
                }
            });
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onStateChanged(final int i) {
            final FirmwareUpgradeRActivity firmwareUpgradeRActivity = FirmwareUpgradeRActivity.this;
            firmwareUpgradeRActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.device.xI0oxI00
                @Override // java.lang.Runnable
                public final void run() {
                    FirmwareUpgradeRActivity.II0xO0.xoIox(i, firmwareUpgradeRActivity);
                }
            });
        }
    }

    /* loaded from: classes12.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f21866oIX0oI;

        static {
            int[] iArr = new int[FileType.values().length];
            try {
                iArr[FileType.FIRMWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FileType.UI_PACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FileType.LANGUAGE_PACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f21866oIX0oI = iArr;
        }
    }

    public FirmwareUpgradeRActivity() {
        FirmwareVersion firmwareVersion;
        DfuConfig dfuConfig = new DfuConfig();
        BleCache bleCache = BleCache.INSTANCE;
        dfuConfig.setAddress(bleCache.getMDfuAddress());
        dfuConfig.setAutomaticActiveEnabled(true);
        dfuConfig.setFileLocation(0);
        dfuConfig.setVersionCheckEnabled(false);
        this.mDfuConfig = dfuConfig;
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        this.mLatestFirmware = (FirmwareVersion) new Gson().fromJson(xo0.II0xO0().getString(FirmwareVersion.class.getName()), FirmwareVersion.class);
        ExtraPackVersions extraPackVersions = (ExtraPackVersions) new Gson().fromJson(xo0.II0xO0().getString(ExtraPackVersions.class.getName()), ExtraPackVersions.class);
        this.mLatestExtraPacks = extraPackVersions;
        if (extraPackVersions != null) {
            firmwareVersion = extraPackVersions.getUiPackVersion();
        } else {
            firmwareVersion = null;
        }
        this.mLatestUi = firmwareVersion;
        this.mLatestLanguage = extraPackVersions != null ? extraPackVersions.getLanguagePackVersion() : null;
        this.mCurrentFirmware = BleCache.getString$default(bleCache, BleKey.FIRMWARE_VERSION, null, null, 6, null);
        this.mCurrentUi = BleCache.getString$default(bleCache, BleKey.UI_PACK_VERSION, null, null, 6, null);
        this.mCurrentLanguage = ((BleLanguagePackVersion) BleCache.getObjectNotNull$default(bleCache, BleKey.LANGUAGE_PACK_VERSION, BleLanguagePackVersion.class, null, null, 12, null)).getMVersion();
        this.mSteps = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkDownload() {
        if (this.mDownloaded == this.mSteps.size()) {
            ProgressButton.X0o0xo(getProgressButton(), R.string.preparing, false, 2, null);
            getMDfuHelper().initialize(this.mDfuCallback);
        }
    }

    private final GattDfuAdapter getMDfuHelper() {
        return (GattDfuAdapter) this.mDfuHelper$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void upgrade() {
        getTvStep().setVisibility(0);
        ProgressButton.X0o0xo(getProgressButton(), R.string.starting, false, 2, null);
        getTvStep().setText(getString(R.string.upgrade_steps_d_d, Integer.valueOf(this.mStepsIndex + 1), Integer.valueOf(this.mSteps.size())));
        int i = oIX0oI.f21866oIX0oI[this.mSteps.get(this.mStepsIndex).ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    DfuConfig dfuConfig = this.mDfuConfig;
                    dfuConfig.setOtaWorkMode(16);
                    File oOoXoXO2 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
                    FirmwareVersion firmwareVersion = this.mLatestLanguage;
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion);
                    dfuConfig.setFilePath(new File(oOoXoXO2, firmwareVersion.getFileName()).getAbsolutePath());
                    GattDfuAdapter mDfuHelper = getMDfuHelper();
                    if (mDfuHelper != null) {
                        mDfuHelper.startOtaProcess(dfuConfig);
                        return;
                    }
                    return;
                }
                return;
            }
            DfuConfig dfuConfig2 = this.mDfuConfig;
            dfuConfig2.setOtaWorkMode(16);
            File oOoXoXO3 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
            FirmwareVersion firmwareVersion2 = this.mLatestUi;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion2);
            dfuConfig2.setFilePath(new File(oOoXoXO3, firmwareVersion2.getFileName()).getAbsolutePath());
            GattDfuAdapter mDfuHelper2 = getMDfuHelper();
            if (mDfuHelper2 != null) {
                mDfuHelper2.startOtaProcess(dfuConfig2);
                return;
            }
            return;
        }
        DfuConfig dfuConfig3 = this.mDfuConfig;
        dfuConfig3.setOtaWorkMode(0);
        File oOoXoXO4 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
        FirmwareVersion firmwareVersion3 = this.mLatestFirmware;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion3);
        dfuConfig3.setFilePath(new File(oOoXoXO4, firmwareVersion3.getFileName()).getAbsolutePath());
        GattDfuAdapter mDfuHelper3 = getMDfuHelper();
        if (mDfuHelper3 != null) {
            mDfuHelper3.startOtaProcess(dfuConfig3);
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        BleConnector.INSTANCE.closeConnection(true);
    }

    @Override // com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        String str;
        String str2;
        String str3;
        super.initView();
        FirmwareVersion firmwareVersion = this.mLatestFirmware;
        if (firmwareVersion == null && this.mLatestUi == null && this.mLatestLanguage == null) {
            String str4 = this.mCurrentFirmware;
            String IIOIX2 = kotlin.text.OxI.IIOIX(this.mCurrentUi, FileUtils.FILE_EXTENSION_SEPARATOR, "", false, 4, null);
            String IIOIX3 = kotlin.text.OxI.IIOIX(this.mCurrentLanguage, FileUtils.FILE_EXTENSION_SEPARATOR, "", false, 4, null);
            getTvLatest().setText(getString(R.string.v_s, str4 + '.' + IIOIX2 + IIOIX3));
            ViewParent parent = getTvCurrent().getParent();
            kotlin.jvm.internal.IIX0o.x0XOIxOo(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).setVisibility(8);
            getProgressButton().setVisibility(8);
            return;
        }
        if (firmwareVersion == null || (str = firmwareVersion.getVersion()) == null) {
            str = this.mCurrentFirmware;
        }
        FirmwareVersion firmwareVersion2 = this.mLatestUi;
        if (firmwareVersion2 == null || (str2 = firmwareVersion2.getVersion()) == null) {
            str2 = this.mCurrentUi;
        }
        String IIOIX4 = kotlin.text.OxI.IIOIX(str2, FileUtils.FILE_EXTENSION_SEPARATOR, "", false, 4, null);
        FirmwareVersion firmwareVersion3 = this.mLatestLanguage;
        if (firmwareVersion3 == null || (str3 = firmwareVersion3.getVersion()) == null) {
            str3 = this.mCurrentLanguage;
        }
        String IIOIX5 = kotlin.text.OxI.IIOIX(str3, FileUtils.FILE_EXTENSION_SEPARATOR, "", false, 4, null);
        getTvLatest().setText(getString(R.string.v_s, str + '.' + IIOIX4 + IIOIX5));
        String IIOIX6 = kotlin.text.OxI.IIOIX(this.mCurrentUi, FileUtils.FILE_EXTENSION_SEPARATOR, "", false, 4, null);
        String IIOIX7 = kotlin.text.OxI.IIOIX(this.mCurrentLanguage, FileUtils.FILE_EXTENSION_SEPARATOR, "", false, 4, null);
        getTvCurrent().setText(getString(R.string.v_s, this.mCurrentFirmware + '.' + IIOIX6 + IIOIX7));
        if (this.mLatestFirmware != null) {
            this.mSteps.add(FileType.FIRMWARE);
        }
        if (this.mLatestLanguage != null) {
            this.mSteps.add(FileType.LANGUAGE_PACK);
        }
        if (this.mLatestUi != null) {
            this.mSteps.add(FileType.UI_PACK);
        }
        getTvStep().setVisibility(0);
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        this.mDownloaded = 0;
        setMStarted(true);
        ProgressButton.X0o0xo(getProgressButton(), R.string.downloading, false, 2, null);
        if (this.mStepsIndex == 0) {
            FirmwareVersion firmwareVersion = this.mLatestFirmware;
            if (firmwareVersion != null) {
                NetWorkUtils.INSTANCE.download(firmwareVersion.getFileUrl(), com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(X00IoxXI.oIX0oI.f3233oIX0oI), this.mLatestFirmware.getFileName(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.device.FirmwareUpgradeRActivity$onBottomClick$1
                    @Override // xxxI.II0xO0
                    public void handleError(@OXOo.OOXIXo String error) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                        FirmwareUpgradeRActivity.this.mDownloaded = 0;
                        FirmwareUpgradeRActivity.this.setMStarted(false);
                    }

                    @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                    public void handleProgress(int i) {
                    }

                    @Override // xxxI.II0xO0
                    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                    public void handleResponse(@OXOo.oOoXoXO String str) {
                        int i;
                        FirmwareVersion firmwareVersion2;
                        FirmwareVersion firmwareVersion3;
                        FirmwareUpgradeRActivity firmwareUpgradeRActivity = FirmwareUpgradeRActivity.this;
                        i = firmwareUpgradeRActivity.mDownloaded;
                        firmwareUpgradeRActivity.mDownloaded = i + 1;
                        FirmwareUpgradeRActivity.this.checkDownload();
                        FirmwareUpgradeRActivity firmwareUpgradeRActivity2 = FirmwareUpgradeRActivity.this;
                        firmwareVersion2 = firmwareUpgradeRActivity2.mLatestFirmware;
                        String fileUrl = firmwareVersion2.getFileUrl();
                        firmwareVersion3 = FirmwareUpgradeRActivity.this.mLatestFirmware;
                        BaseFirmwareUpgradeActivity.uploadDownloadInfo$default(firmwareUpgradeRActivity2, fileUrl, firmwareVersion3.getFileName(), 0, 4, null);
                    }
                });
            }
            FirmwareVersion firmwareVersion2 = this.mLatestUi;
            if (firmwareVersion2 != null) {
                NetWorkUtils.INSTANCE.download(firmwareVersion2.getFileUrl(), com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(X00IoxXI.oIX0oI.f3233oIX0oI), this.mLatestUi.getFileName(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.device.FirmwareUpgradeRActivity$onBottomClick$2
                    @Override // xxxI.II0xO0
                    public void handleError(@OXOo.OOXIXo String error) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                        FirmwareUpgradeRActivity.this.mDownloaded = 0;
                        FirmwareUpgradeRActivity.this.setMStarted(false);
                    }

                    @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                    public void handleProgress(int i) {
                    }

                    @Override // xxxI.II0xO0
                    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                    public void handleResponse(@OXOo.oOoXoXO String str) {
                        int i;
                        FirmwareVersion firmwareVersion3;
                        FirmwareVersion firmwareVersion4;
                        FirmwareUpgradeRActivity firmwareUpgradeRActivity = FirmwareUpgradeRActivity.this;
                        i = firmwareUpgradeRActivity.mDownloaded;
                        firmwareUpgradeRActivity.mDownloaded = i + 1;
                        FirmwareUpgradeRActivity.this.checkDownload();
                        FirmwareUpgradeRActivity firmwareUpgradeRActivity2 = FirmwareUpgradeRActivity.this;
                        firmwareVersion3 = firmwareUpgradeRActivity2.mLatestUi;
                        String fileUrl = firmwareVersion3.getFileUrl();
                        firmwareVersion4 = FirmwareUpgradeRActivity.this.mLatestUi;
                        BaseFirmwareUpgradeActivity.uploadDownloadInfo$default(firmwareUpgradeRActivity2, fileUrl, firmwareVersion4.getFileName(), 0, 4, null);
                    }
                });
            }
            FirmwareVersion firmwareVersion3 = this.mLatestLanguage;
            if (firmwareVersion3 != null) {
                NetWorkUtils.INSTANCE.download(firmwareVersion3.getFileUrl(), com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(X00IoxXI.oIX0oI.f3233oIX0oI), this.mLatestLanguage.getFileName(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.device.FirmwareUpgradeRActivity$onBottomClick$3
                    @Override // xxxI.II0xO0
                    public void handleError(@OXOo.OOXIXo String error) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                        FirmwareUpgradeRActivity.this.mDownloaded = 0;
                        FirmwareUpgradeRActivity.this.setMStarted(false);
                    }

                    @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                    public void handleProgress(int i) {
                    }

                    @Override // xxxI.II0xO0
                    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                    public void handleResponse(@OXOo.oOoXoXO String str) {
                        int i;
                        FirmwareVersion firmwareVersion4;
                        FirmwareVersion firmwareVersion5;
                        FirmwareUpgradeRActivity firmwareUpgradeRActivity = FirmwareUpgradeRActivity.this;
                        i = firmwareUpgradeRActivity.mDownloaded;
                        firmwareUpgradeRActivity.mDownloaded = i + 1;
                        FirmwareUpgradeRActivity.this.checkDownload();
                        FirmwareUpgradeRActivity firmwareUpgradeRActivity2 = FirmwareUpgradeRActivity.this;
                        firmwareVersion4 = firmwareUpgradeRActivity2.mLatestLanguage;
                        String fileUrl = firmwareVersion4.getFileUrl();
                        firmwareVersion5 = FirmwareUpgradeRActivity.this.mLatestLanguage;
                        BaseFirmwareUpgradeActivity.uploadDownloadInfo$default(firmwareUpgradeRActivity2, fileUrl, firmwareVersion5.getFileName(), 0, 4, null);
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
        GattDfuAdapter mDfuHelper = getMDfuHelper();
        if (mDfuHelper != null) {
            mDfuHelper.abort();
            mDfuHelper.close();
        }
        super.onDestroy();
    }
}
