package com.sma.smartv3.ui.me;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
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
import com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity;
import com.sma.smartv3.ui.me.DeveloperUpgradeRActivity;
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

@kotlin.jvm.internal.XX({"SMAP\nDeveloperUpgradeRActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperUpgradeRActivity.kt\ncom/sma/smartv3/ui/me/DeveloperUpgradeRActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,286:1\n19#2:287\n15#2:288\n15#2:289\n15#2:290\n*S KotlinDebug\n*F\n+ 1 DeveloperUpgradeRActivity.kt\ncom/sma/smartv3/ui/me/DeveloperUpgradeRActivity\n*L\n41#1:287\n41#1:288\n113#1:289\n114#1:290\n*E\n"})
/* loaded from: classes11.dex */
public final class DeveloperUpgradeRActivity extends BaseFirmwareUpgradeActivity {

    @OXOo.OOXIXo
    private final ooOOo0oXI alreadyUpdateDeviceList;

    @OXOo.OOXIXo
    private final String mCurrentFirmware;

    @OXOo.OOXIXo
    private final String mCurrentLanguage;

    @OXOo.OOXIXo
    private final String mCurrentUi;

    @OXOo.OOXIXo
    private final II0xO0 mDfuCallback;

    @OXOo.OOXIXo
    private final DfuConfig mDfuConfig;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mDfuHelper$delegate;
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes11.dex */
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

    @kotlin.jvm.internal.XX({"SMAP\nDeveloperUpgradeRActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperUpgradeRActivity.kt\ncom/sma/smartv3/ui/me/DeveloperUpgradeRActivity$mDfuCallback$1\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,286:1\n11#2,2:287\n*S KotlinDebug\n*F\n+ 1 DeveloperUpgradeRActivity.kt\ncom/sma/smartv3/ui/me/DeveloperUpgradeRActivity$mDfuCallback$1\n*L\n93#1:287,2\n*E\n"})
    /* loaded from: classes11.dex */
    public static final class II0xO0 extends DfuAdapter.DfuHelperCallback {
        public II0xO0() {
        }

        public static final void II0XooXoX(DeveloperUpgradeRActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            this$0.upgrade();
        }

        public static final void Oxx0IOOO(int i, final DeveloperUpgradeRActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            if (i == 258) {
                if (this$0.mStepsIndex < CollectionsKt__CollectionsKt.oo0xXOI0I(this$0.mSteps)) {
                    this$0.getProgressButton().setProgress(0.0f);
                    this$0.mStepsIndex++;
                    this$0.getTvStep().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.oX0I0O
                        @Override // java.lang.Runnable
                        public final void run() {
                            DeveloperUpgradeRActivity.II0xO0.II0XooXoX(DeveloperUpgradeRActivity.this);
                        }
                    }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                    return;
                }
                ArrayList<String> oxoX2 = this$0.alreadyUpdateDeviceList.oxoX();
                com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
                oxoX2.add(xo0.II0xO0().getString(com.sma.smartv3.util.XoI0Ixx0.f24456oo));
                xo0.II0xO0().put(ooOOo0oXI.class.getName(), new Gson().toJson(this$0.alreadyUpdateDeviceList));
                this$0.finish();
            }
        }

        public static final void XO(DeveloperUpgradeRActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            ProgressButton.XO(this$0.getProgressButton(), com.sma.smartv3.util.oO.f24511oIX0oI.X0o0xo(), false, 2, null);
            this$0.onBottomClick(this$0.getTvStep());
        }

        public static final void xoIox(int i, DeveloperUpgradeRActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            if (i == 258) {
                this$0.upgrade();
            } else if (i == 4097) {
                this$0.setMStarted(false);
                ProgressButton.XO(this$0.getProgressButton(), com.sma.smartv3.util.oO.f24511oIX0oI.X0o0xo(), false, 2, null);
                this$0.onBottomClick(this$0.getTvStep());
            }
        }

        public static final void xxIXOIIO(DeveloperUpgradeRActivity this$0, DfuProgressInfo progressInfo) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            kotlin.jvm.internal.IIX0o.x0xO0oo(progressInfo, "$progressInfo");
            this$0.getProgressButton().setProgress(progressInfo.getProgress() / 100.0f);
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onError(int i, int i2) {
            LogUtils.e("FirmwareUpgradeRActivity onError: type=" + i + ", code" + i2);
            DeveloperUpgradeRActivity.this.setMStarted(false);
            ToastUtils.showLong(R.string.firmware_upgrading_failed_and_retry);
            final DeveloperUpgradeRActivity developerUpgradeRActivity = DeveloperUpgradeRActivity.this;
            developerUpgradeRActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.me.XO0o
                @Override // java.lang.Runnable
                public final void run() {
                    DeveloperUpgradeRActivity.II0xO0.XO(DeveloperUpgradeRActivity.this);
                }
            });
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onProcessStateChanged(final int i, @OXOo.oOoXoXO Throughput throughput) {
            final DeveloperUpgradeRActivity developerUpgradeRActivity = DeveloperUpgradeRActivity.this;
            developerUpgradeRActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.me.IxX00
                @Override // java.lang.Runnable
                public final void run() {
                    DeveloperUpgradeRActivity.II0xO0.Oxx0IOOO(i, developerUpgradeRActivity);
                }
            });
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onProgressChanged(@OXOo.OOXIXo final DfuProgressInfo progressInfo) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(progressInfo, "progressInfo");
            final DeveloperUpgradeRActivity developerUpgradeRActivity = DeveloperUpgradeRActivity.this;
            developerUpgradeRActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.me.O0xxXxI
                @Override // java.lang.Runnable
                public final void run() {
                    DeveloperUpgradeRActivity.II0xO0.xxIXOIIO(DeveloperUpgradeRActivity.this, progressInfo);
                }
            });
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onStateChanged(final int i) {
            final DeveloperUpgradeRActivity developerUpgradeRActivity = DeveloperUpgradeRActivity.this;
            developerUpgradeRActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.me.oxOXxoXII
                @Override // java.lang.Runnable
                public final void run() {
                    DeveloperUpgradeRActivity.II0xO0.xoIox(i, developerUpgradeRActivity);
                }
            });
        }
    }

    /* loaded from: classes11.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f23282oIX0oI;

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
            f23282oIX0oI = iArr;
        }
    }

    public DeveloperUpgradeRActivity() {
        FirmwareVersion firmwareVersion;
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        SPUtils II0xO02 = xo0.II0xO0();
        Object ooooo0oxi = new ooOOo0oXI(null, 1, null);
        Object fromJson = new Gson().fromJson(II0xO02.getString(ooOOo0oXI.class.getName()), (Class<Object>) ooOOo0oXI.class);
        this.alreadyUpdateDeviceList = (ooOOo0oXI) (fromJson != null ? fromJson : ooooo0oxi);
        this.mDfuHelper$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<GattDfuAdapter>() { // from class: com.sma.smartv3.ui.me.DeveloperUpgradeRActivity$mDfuHelper$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final GattDfuAdapter invoke() {
                Activity mContext;
                mContext = DeveloperUpgradeRActivity.this.getMContext();
                return GattDfuAdapter.getInstance(mContext);
            }
        });
        this.mDfuCallback = new II0xO0();
        DfuConfig dfuConfig = new DfuConfig();
        dfuConfig.setAddress(xo0.II0xO0().getString(com.sma.smartv3.util.XoI0Ixx0.f24456oo));
        dfuConfig.setAutomaticActiveEnabled(true);
        dfuConfig.setFileLocation(0);
        dfuConfig.setVersionCheckEnabled(false);
        this.mDfuConfig = dfuConfig;
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
        BleCache bleCache = BleCache.INSTANCE;
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
        int i = oIX0oI.f23282oIX0oI[this.mSteps.get(this.mStepsIndex).ordinal()];
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
        } else {
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
        onBottomClick(getTvStep());
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        this.mDownloaded = 0;
        setMStarted(true);
        ProgressButton.X0o0xo(getProgressButton(), R.string.downloading, false, 2, null);
        if (this.mStepsIndex == 0) {
            FirmwareVersion firmwareVersion = this.mLatestFirmware;
            if (firmwareVersion != null) {
                NetWorkUtils.INSTANCE.download(firmwareVersion.getFileUrl(), com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(X00IoxXI.oIX0oI.f3233oIX0oI), this.mLatestFirmware.getFileName(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.me.DeveloperUpgradeRActivity$onBottomClick$1
                    @Override // xxxI.II0xO0
                    public void handleError(@OXOo.OOXIXo String error) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                        DeveloperUpgradeRActivity.this.mDownloaded = 0;
                        DeveloperUpgradeRActivity.this.setMStarted(false);
                    }

                    @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                    public void handleProgress(int i) {
                    }

                    @Override // xxxI.II0xO0
                    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                    public void handleResponse(@OXOo.oOoXoXO String str) {
                        int i;
                        DeveloperUpgradeRActivity developerUpgradeRActivity = DeveloperUpgradeRActivity.this;
                        i = developerUpgradeRActivity.mDownloaded;
                        developerUpgradeRActivity.mDownloaded = i + 1;
                        DeveloperUpgradeRActivity.this.checkDownload();
                    }
                });
            }
            FirmwareVersion firmwareVersion2 = this.mLatestUi;
            if (firmwareVersion2 != null) {
                NetWorkUtils.INSTANCE.download(firmwareVersion2.getFileUrl(), com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(X00IoxXI.oIX0oI.f3233oIX0oI), this.mLatestUi.getFileName(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.me.DeveloperUpgradeRActivity$onBottomClick$2
                    @Override // xxxI.II0xO0
                    public void handleError(@OXOo.OOXIXo String error) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                        DeveloperUpgradeRActivity.this.mDownloaded = 0;
                        DeveloperUpgradeRActivity.this.setMStarted(false);
                    }

                    @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                    public void handleProgress(int i) {
                    }

                    @Override // xxxI.II0xO0
                    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                    public void handleResponse(@OXOo.oOoXoXO String str) {
                        int i;
                        DeveloperUpgradeRActivity developerUpgradeRActivity = DeveloperUpgradeRActivity.this;
                        i = developerUpgradeRActivity.mDownloaded;
                        developerUpgradeRActivity.mDownloaded = i + 1;
                        DeveloperUpgradeRActivity.this.checkDownload();
                    }
                });
            }
            FirmwareVersion firmwareVersion3 = this.mLatestLanguage;
            if (firmwareVersion3 != null) {
                NetWorkUtils.INSTANCE.download(firmwareVersion3.getFileUrl(), com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(X00IoxXI.oIX0oI.f3233oIX0oI), this.mLatestLanguage.getFileName(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.me.DeveloperUpgradeRActivity$onBottomClick$3
                    @Override // xxxI.II0xO0
                    public void handleError(@OXOo.OOXIXo String error) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                        DeveloperUpgradeRActivity.this.mDownloaded = 0;
                        DeveloperUpgradeRActivity.this.setMStarted(false);
                    }

                    @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                    public void handleProgress(int i) {
                    }

                    @Override // xxxI.II0xO0
                    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                    public void handleResponse(@OXOo.oOoXoXO String str) {
                        int i;
                        DeveloperUpgradeRActivity developerUpgradeRActivity = DeveloperUpgradeRActivity.this;
                        i = developerUpgradeRActivity.mDownloaded;
                        developerUpgradeRActivity.mDownloaded = i + 1;
                        DeveloperUpgradeRActivity.this.checkDownload();
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
