package com.sma.smartv3.ui.me;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.bestmafen.baseble.connector.AbsBleConnector;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.gson.Gson;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.DfuProgressInfo;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import com.realsil.sdk.dfu.model.Throughput;
import com.realsil.sdk.dfu.utils.ConnectParams;
import com.realsil.sdk.dfu.utils.DfuAdapter;
import com.realsil.sdk.dfu.utils.GattDfuAdapter;
import com.sma.androidnetworklib.method.HttpProgressCallback;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.ExtraPackVersions;
import com.sma.smartv3.model.FirmwareVersion;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity;
import com.sma.smartv3.ui.me.DeveloperUpgradeRSmaActivity;
import com.sma.smartv3.view.ProgressButton;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.component.BleHandleCallback;
import com.szabh.smable3.entity.BleAICoachBeforePlan;
import com.szabh.smable3.entity.BleAICoachGeneratePlan;
import com.szabh.smable3.entity.BleActivity;
import com.szabh.smable3.entity.BleActivityDetail;
import com.szabh.smable3.entity.BleAlarm;
import com.szabh.smable3.entity.BleAlipayBindInfo;
import com.szabh.smable3.entity.BleAlipaySettings;
import com.szabh.smable3.entity.BleAppAudioBookList;
import com.szabh.smable3.entity.BleAppInfoList;
import com.szabh.smable3.entity.BleAppOp;
import com.szabh.smable3.entity.BleAppSportState;
import com.szabh.smable3.entity.BleAvgHeartRate;
import com.szabh.smable3.entity.BleBAC;
import com.szabh.smable3.entity.BleBWNaviInfo;
import com.szabh.smable3.entity.BleBacCalibration;
import com.szabh.smable3.entity.BleBatteryUsage;
import com.szabh.smable3.entity.BleBloodGlucose;
import com.szabh.smable3.entity.BleBloodOxyGenSettings;
import com.szabh.smable3.entity.BleBloodOxygen;
import com.szabh.smable3.entity.BleBloodPressure;
import com.szabh.smable3.entity.BleBloodPressureCalibration;
import com.szabh.smable3.entity.BleBodyStatus;
import com.szabh.smable3.entity.BleCPUserInfo;
import com.szabh.smable3.entity.BleCalibrationData;
import com.szabh.smable3.entity.BleCalorieIntake;
import com.szabh.smable3.entity.BleCheckInEveryDay;
import com.szabh.smable3.entity.BleCoachingIds;
import com.szabh.smable3.entity.BleDeviceFile;
import com.szabh.smable3.entity.BleDeviceInfo;
import com.szabh.smable3.entity.BleDeviceInfo2;
import com.szabh.smable3.entity.BleDeviceLanguages;
import com.szabh.smable3.entity.BleDeviceSportData;
import com.szabh.smable3.entity.BleDeviceUniqueDataSettings;
import com.szabh.smable3.entity.BleDoubleScreenSettings;
import com.szabh.smable3.entity.BleDrinkWaterSettings;
import com.szabh.smable3.entity.BleEarphoneAncSettings;
import com.szabh.smable3.entity.BleEarphoneInfo;
import com.szabh.smable3.entity.BleEarphoneKey;
import com.szabh.smable3.entity.BleEarphonePower;
import com.szabh.smable3.entity.BleEarphoneSoundEffectsSettings;
import com.szabh.smable3.entity.BleEarphoneState;
import com.szabh.smable3.entity.BleEcg;
import com.szabh.smable3.entity.BleEcgSettings;
import com.szabh.smable3.entity.BleFactoryTest;
import com.szabh.smable3.entity.BleFindEarphone;
import com.szabh.smable3.entity.BleFoodBalance;
import com.szabh.smable3.entity.BleGSensorMotion;
import com.szabh.smable3.entity.BleGSensorRaw;
import com.szabh.smable3.entity.BleGSensorSHSY;
import com.szabh.smable3.entity.BleGameControl;
import com.szabh.smable3.entity.BleGestureWake;
import com.szabh.smable3.entity.BleGestureWake2;
import com.szabh.smable3.entity.BleGirlCareMonthly;
import com.szabh.smable3.entity.BleGirlCareSettings;
import com.szabh.smable3.entity.BleGoMoreSettings;
import com.szabh.smable3.entity.BleHRRaw;
import com.szabh.smable3.entity.BleHanBaoSettings;
import com.szabh.smable3.entity.BleHanBaoVibration;
import com.szabh.smable3.entity.BleHeartRate;
import com.szabh.smable3.entity.BleHrMonitoringSettings;
import com.szabh.smable3.entity.BleHrv;
import com.szabh.smable3.entity.BleHrv2;
import com.szabh.smable3.entity.BleIPCStoresInfo;
import com.szabh.smable3.entity.BleIPCWifiInfo;
import com.szabh.smable3.entity.BleLactateThreshold;
import com.szabh.smable3.entity.BleLanguagePackVersion;
import com.szabh.smable3.entity.BleLocation;
import com.szabh.smable3.entity.BleLocationGga;
import com.szabh.smable3.entity.BleLocationGsv;
import com.szabh.smable3.entity.BleLogText;
import com.szabh.smable3.entity.BleLoveTap;
import com.szabh.smable3.entity.BleLoveTapUser;
import com.szabh.smable3.entity.BleMatchRecord;
import com.szabh.smable3.entity.BleMatchRecord2;
import com.szabh.smable3.entity.BleMeasurement;
import com.szabh.smable3.entity.BleMedicationAlarm;
import com.szabh.smable3.entity.BleMedicationReminder;
import com.szabh.smable3.entity.BleMindStatus;
import com.szabh.smable3.entity.BleNaviInfo;
import com.szabh.smable3.entity.BleNoDisturbSettings;
import com.szabh.smable3.entity.BleNotificationSettings2;
import com.szabh.smable3.entity.BlePackageStatus;
import com.szabh.smable3.entity.BlePhysicalPower;
import com.szabh.smable3.entity.BlePower2;
import com.szabh.smable3.entity.BlePpgSHSY;
import com.szabh.smable3.entity.BlePressure;
import com.szabh.smable3.entity.BlePressureTimingMeasurement;
import com.szabh.smable3.entity.BleQiblaSettings;
import com.szabh.smable3.entity.BleRealTimeMeasurement;
import com.szabh.smable3.entity.BleRealtimeLog;
import com.szabh.smable3.entity.BleReceiveFilePacket;
import com.szabh.smable3.entity.BleRecordPacket;
import com.szabh.smable3.entity.BleRelaxReminder;
import com.szabh.smable3.entity.BleRespiratoryRate;
import com.szabh.smable3.entity.BleRingVibrationSettings;
import com.szabh.smable3.entity.BleRri;
import com.szabh.smable3.entity.BleSDCardInfo;
import com.szabh.smable3.entity.BleSGTest;
import com.szabh.smable3.entity.BleSMSQuickReply;
import com.szabh.smable3.entity.BleSOSSettings;
import com.szabh.smable3.entity.BleSedentarinessSettings;
import com.szabh.smable3.entity.BleSettingWatchPassword;
import com.szabh.smable3.entity.BleSleep;
import com.szabh.smable3.entity.BleSleepQuality;
import com.szabh.smable3.entity.BleSosCallLog;
import com.szabh.smable3.entity.BleSosContact;
import com.szabh.smable3.entity.BleStandbyWatchFaceSet;
import com.szabh.smable3.entity.BleStock;
import com.szabh.smable3.entity.BleTemperature;
import com.szabh.smable3.entity.BleThirdPartyData;
import com.szabh.smable3.entity.BleTrainingStatus;
import com.szabh.smable3.entity.BleTuyaKey;
import com.szabh.smable3.entity.BleUserProfile;
import com.szabh.smable3.entity.BleVitality;
import com.szabh.smable3.entity.BleWatchFaceId;
import com.szabh.smable3.entity.BleWatchFaceIndex;
import com.szabh.smable3.entity.BleWorkout;
import com.szabh.smable3.entity.BleWorkout2;
import com.szabh.smable3.entity.BleWorkout3;
import com.szabh.smable3.entity.BleWorldClock;
import com.szabh.smable3.entity.MusicCommand;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.random.Random;

@kotlin.jvm.internal.XX({"SMAP\nDeveloperUpgradeRSmaActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperUpgradeRSmaActivity.kt\ncom/sma/smartv3/ui/me/DeveloperUpgradeRSmaActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,609:1\n19#2:610\n15#2:611\n15#2:612\n15#2:613\n19#2:614\n15#2:615\n11#2,2:616\n*S KotlinDebug\n*F\n+ 1 DeveloperUpgradeRSmaActivity.kt\ncom/sma/smartv3/ui/me/DeveloperUpgradeRSmaActivity\n*L\n53#1:610\n53#1:611\n241#1:612\n242#1:613\n296#1:614\n296#1:615\n602#1:616,2\n*E\n"})
/* loaded from: classes11.dex */
public final class DeveloperUpgradeRSmaActivity extends BaseFirmwareUpgradeActivity {

    @OXOo.OOXIXo
    private final ooOOo0oXI alreadyUpdateDeviceList;
    private final String deviceAddress;
    private boolean isAutoShutdown;
    private boolean isStartShutdown;
    private int lastPackageSize;

    @OXOo.OOXIXo
    private II0xO0 mBleHandleCallback;

    @OXOo.OOXIXo
    private final String mCurrentFirmware;

    @OXOo.OOXIXo
    private final String mCurrentLanguage;

    @OXOo.OOXIXo
    private final String mCurrentUi;

    @OXOo.OOXIXo
    private final I0Io mDfuCallback;

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
    private final FirmwareVersion mLatestFont;

    @OXOo.oOoXoXO
    private final FirmwareVersion mLatestLanguage;

    @OXOo.oOoXoXO
    private final FirmwareVersion mLatestUi;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.I0X0x0oIo mLoadingPopup;

    @OXOo.oOoXoXO
    private OtaDeviceInfo mOtaDeviceInfo;

    @OXOo.OOXIXo
    private final List<FileType> mSteps;
    private int mStepsIndex;
    private long time1;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes11.dex */
    public static final class FileType {
        private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
        private static final /* synthetic */ FileType[] $VALUES;
        public static final FileType FIRMWARE = new FileType("FIRMWARE", 0);
        public static final FileType UI_PACK = new FileType("UI_PACK", 1);
        public static final FileType LANGUAGE_PACK = new FileType("LANGUAGE_PACK", 2);
        public static final FileType FONT_PACK = new FileType("FONT_PACK", 3);

        private static final /* synthetic */ FileType[] $values() {
            return new FileType[]{FIRMWARE, UI_PACK, LANGUAGE_PACK, FONT_PACK};
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

    /* loaded from: classes11.dex */
    public static final class I0Io extends DfuAdapter.DfuHelperCallback {
        public I0Io() {
        }

        public static final void II0XooXoX(DeveloperUpgradeRSmaActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            this$0.upgrade();
        }

        public static final void Oxx0IOOO(int i, final DeveloperUpgradeRSmaActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            if (i == 258) {
                if (this$0.mStepsIndex >= CollectionsKt__CollectionsKt.oo0xXOI0I(this$0.mSteps)) {
                    this$0.upgradeDone();
                    return;
                }
                this$0.getProgressButton().setProgress(0.0f);
                this$0.mStepsIndex++;
                this$0.getTvStep().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.xOOxI
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeveloperUpgradeRSmaActivity.I0Io.II0XooXoX(DeveloperUpgradeRSmaActivity.this);
                    }
                }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            }
        }

        public static final void XO(DeveloperUpgradeRSmaActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            ProgressButton.XO(this$0.getProgressButton(), com.sma.smartv3.util.oO.f24511oIX0oI.X0o0xo(), false, 2, null);
            this$0.onBottomClick(this$0.getTvStep());
        }

        public static final void xoIox(int i, DeveloperUpgradeRSmaActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            if (i == 258) {
                this$0.upgrade();
                return;
            }
            if (i != 527) {
                if (i == 4097) {
                    this$0.setMStarted(false);
                    ProgressButton.XO(this$0.getProgressButton(), com.sma.smartv3.util.oO.f24511oIX0oI.X0o0xo(), false, 2, null);
                    this$0.onBottomClick(this$0.getTvStep());
                    return;
                }
                return;
            }
            ProgressButton.X0o0xo(this$0.getProgressButton(), R.string.preparing, false, 2, null);
            this$0.setMOtaDeviceInfo(this$0.getMDfuHelper().getOtaDeviceInfo());
            LogUtils.d("onStateChanged -> mOtaDeviceInfo = " + this$0.getMOtaDeviceInfo());
            this$0.startOtaProcess();
        }

        public static final void xxIXOIIO(DeveloperUpgradeRSmaActivity this$0, DfuProgressInfo progressInfo) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            kotlin.jvm.internal.IIX0o.x0xO0oo(progressInfo, "$progressInfo");
            this$0.getProgressButton().setProgress(progressInfo.getProgress() / 100.0f);
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onError(int i, int i2) {
            LogUtils.e("FirmwareUpgradeRSmaActivity onError: type=" + i + ", code" + i2);
            DeveloperUpgradeRSmaActivity.this.setMStarted(false);
            ToastUtils.showLong(R.string.firmware_upgrading_failed_and_retry);
            final DeveloperUpgradeRSmaActivity developerUpgradeRSmaActivity = DeveloperUpgradeRSmaActivity.this;
            developerUpgradeRSmaActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.me.xIx0XO
                @Override // java.lang.Runnable
                public final void run() {
                    DeveloperUpgradeRSmaActivity.I0Io.XO(DeveloperUpgradeRSmaActivity.this);
                }
            });
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onProcessStateChanged(final int i, @OXOo.oOoXoXO Throughput throughput) {
            final DeveloperUpgradeRSmaActivity developerUpgradeRSmaActivity = DeveloperUpgradeRSmaActivity.this;
            developerUpgradeRSmaActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.me.oXxx000
                @Override // java.lang.Runnable
                public final void run() {
                    DeveloperUpgradeRSmaActivity.I0Io.Oxx0IOOO(i, developerUpgradeRSmaActivity);
                }
            });
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onProgressChanged(@OXOo.OOXIXo final DfuProgressInfo progressInfo) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(progressInfo, "progressInfo");
            final DeveloperUpgradeRSmaActivity developerUpgradeRSmaActivity = DeveloperUpgradeRSmaActivity.this;
            developerUpgradeRSmaActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.me.XooIO0oo0
                @Override // java.lang.Runnable
                public final void run() {
                    DeveloperUpgradeRSmaActivity.I0Io.xxIXOIIO(DeveloperUpgradeRSmaActivity.this, progressInfo);
                }
            });
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onStateChanged(final int i) {
            LogUtils.d("onStateChanged -> state = " + i);
            final DeveloperUpgradeRSmaActivity developerUpgradeRSmaActivity = DeveloperUpgradeRSmaActivity.this;
            developerUpgradeRSmaActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.me.OOIXx0x
                @Override // java.lang.Runnable
                public final void run() {
                    DeveloperUpgradeRSmaActivity.I0Io.xoIox(i, developerUpgradeRSmaActivity);
                }
            });
        }
    }

    /* loaded from: classes11.dex */
    public static final class II0xO0 implements BleHandleCallback {

        /* loaded from: classes11.dex */
        public /* synthetic */ class oIX0oI {

            /* renamed from: oIX0oI, reason: collision with root package name */
            public static final /* synthetic */ int[] f23288oIX0oI;

            static {
                int[] iArr = new int[FileType.values().length];
                try {
                    iArr[FileType.UI_PACK.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FileType.LANGUAGE_PACK.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[FileType.FONT_PACK.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f23288oIX0oI = iArr;
            }
        }

        public II0xO0() {
        }

        public static final void II0XooXoX(final DeveloperUpgradeRSmaActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            BleConnector bleConnector = BleConnector.INSTANCE;
            BleConnector.sendInt32$default(bleConnector, BleKey.SESSION, BleKeyFlag.CREATE, Random.Default.nextInt(), null, false, false, 56, null);
            BleConnector.sendInt8$default(bleConnector, BleKey.SHUTDOWN, BleKeyFlag.UPDATE, 0, false, false, 24, null);
            new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.OOxOI
                @Override // java.lang.Runnable
                public final void run() {
                    DeveloperUpgradeRSmaActivity.II0xO0.xxIXOIIO(DeveloperUpgradeRSmaActivity.this);
                }
            }, 5000L);
        }

        public static final void OOXIXo(DeveloperUpgradeRSmaActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            this$0.upgrade();
        }

        public static final void Oxx0IOOO(DeveloperUpgradeRSmaActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            this$0.upgrade();
        }

        public static final void oOoXoXO(DeveloperUpgradeRSmaActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            this$0.upgrade();
        }

        public static final void xoIox(DeveloperUpgradeRSmaActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            BleConnector bleConnector = BleConnector.INSTANCE;
            BleConnector.sendInt32$default(bleConnector, BleKey.SESSION, BleKeyFlag.CREATE, Random.Default.nextInt(), null, false, false, 56, null);
            int i = oIX0oI.f23288oIX0oI[((FileType) this$0.mSteps.get(this$0.mStepsIndex)).ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        ProgressButton.X0o0xo(this$0.getProgressButton(), R.string.Parsing, false, 2, null);
                        BleKey bleKey = BleKey.FONT_FILE;
                        File oOoXoXO2 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
                        FirmwareVersion firmwareVersion = this$0.mLatestFont;
                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion);
                        BleConnector.sendStream$default(bleConnector, bleKey, new File(oOoXoXO2, firmwareVersion.getFileName()), 0, 4, (Object) null);
                        return;
                    }
                    return;
                }
                ProgressButton.X0o0xo(this$0.getProgressButton(), R.string.Parsing, false, 2, null);
                BleKey bleKey2 = BleKey.LANGUAGE_FILE;
                File oOoXoXO3 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
                FirmwareVersion firmwareVersion2 = this$0.mLatestLanguage;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion2);
                BleConnector.sendStream$default(bleConnector, bleKey2, new File(oOoXoXO3, firmwareVersion2.getFileName()), 0, 4, (Object) null);
                return;
            }
            ProgressButton.X0o0xo(this$0.getProgressButton(), R.string.Parsing, false, 2, null);
            BleKey bleKey3 = BleKey.UI_FILE;
            File oOoXoXO4 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
            FirmwareVersion firmwareVersion3 = this$0.mLatestUi;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion3);
            BleConnector.sendStream$default(bleConnector, bleKey3, new File(oOoXoXO4, firmwareVersion3.getFileName()), 0, 4, (Object) null);
        }

        public static final void xxIXOIIO(DeveloperUpgradeRSmaActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = this$0.mLoadingPopup;
            if (i0X0x0oIo != null) {
                i0X0x0oIo.dismiss();
            }
            LogUtils.d("force exit");
            this$0.upgradeExit();
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAICoachGeneratePlanUpdate(int i) {
            BleHandleCallback.DefaultImpls.onAICoachGeneratePlanUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAlarmAdd(@OXOo.OOXIXo BleAlarm bleAlarm) {
            BleHandleCallback.DefaultImpls.onAlarmAdd(this, bleAlarm);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAlarmDelete(int i) {
            BleHandleCallback.DefaultImpls.onAlarmDelete(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAlarmUpdate(@OXOo.OOXIXo BleAlarm bleAlarm) {
            BleHandleCallback.DefaultImpls.onAlarmUpdate(this, bleAlarm);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAppOpUpdate(@OXOo.OOXIXo BleAppOp bleAppOp) {
            BleHandleCallback.DefaultImpls.onAppOpUpdate(this, bleAppOp);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAppSportDataResponse(boolean z) {
            BleHandleCallback.DefaultImpls.onAppSportDataResponse(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onBWNaviInfoUpdate(@OXOo.OOXIXo BleBWNaviInfo bleBWNaviInfo) {
            BleHandleCallback.DefaultImpls.onBWNaviInfoUpdate(this, bleBWNaviInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onBacklightUpdate(int i) {
            BleHandleCallback.DefaultImpls.onBacklightUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onBleThirdPartyDataUpdate(@OXOo.OOXIXo BleThirdPartyData bleThirdPartyData) {
            BleHandleCallback.DefaultImpls.onBleThirdPartyDataUpdate(this, bleThirdPartyData);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onCaloriesGoalUpdate(int i) {
            BleHandleCallback.DefaultImpls.onCaloriesGoalUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onCameraResponse(boolean z, int i) {
            BleHandleCallback.DefaultImpls.onCameraResponse(this, z, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onCameraStateChange(int i) {
            BleHandleCallback.DefaultImpls.onCameraStateChange(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onCheckInEveryDayUpdate(@OXOo.OOXIXo BleCheckInEveryDay bleCheckInEveryDay) {
            BleHandleCallback.DefaultImpls.onCheckInEveryDayUpdate(this, bleCheckInEveryDay);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onClassicBluetoothStateChange(int i) {
            BleHandleCallback.DefaultImpls.onClassicBluetoothStateChange(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onCommandReply(@OXOo.OOXIXo BleKey bleKey, @OXOo.OOXIXo BleKeyFlag bleKeyFlag, boolean z) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(bleKey, "bleKey");
            kotlin.jvm.internal.IIX0o.x0xO0oo(bleKeyFlag, "bleKeyFlag");
            if (bleKey == BleKey.SHUTDOWN) {
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = DeveloperUpgradeRSmaActivity.this.mLoadingPopup;
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
                LogUtils.d("shutdown success");
                DeveloperUpgradeRSmaActivity.this.upgradeExit();
            }
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onCommandSendTimeout(@OXOo.OOXIXo BleKey bleKey, @OXOo.OOXIXo BleKeyFlag bleKeyFlag) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(bleKey, "bleKey");
            kotlin.jvm.internal.IIX0o.x0xO0oo(bleKeyFlag, "bleKeyFlag");
            if (bleKey == BleKey.UI_FILE || bleKey == BleKey.LANGUAGE_FILE) {
                DeveloperUpgradeRSmaActivity.this.setMStarted(false);
                ProgressButton.X0o0xo(DeveloperUpgradeRSmaActivity.this.getProgressButton(), R.string.starting, false, 2, null);
                TextView tvStep = DeveloperUpgradeRSmaActivity.this.getTvStep();
                final DeveloperUpgradeRSmaActivity developerUpgradeRSmaActivity = DeveloperUpgradeRSmaActivity.this;
                tvStep.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.X00xOoXI
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeveloperUpgradeRSmaActivity.II0xO0.Oxx0IOOO(DeveloperUpgradeRSmaActivity.this);
                    }
                }, AbsBleConnector.TIMEOUT);
            }
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceConnected(@OXOo.OOXIXo BluetoothDevice device) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(device, "device");
            LogUtils.d("onDeviceConnected " + DeveloperUpgradeRSmaActivity.this.isStartShutdown);
            if (DeveloperUpgradeRSmaActivity.this.isStartShutdown) {
                Handler handler = new Handler();
                final DeveloperUpgradeRSmaActivity developerUpgradeRSmaActivity = DeveloperUpgradeRSmaActivity.this;
                handler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.xxx00
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeveloperUpgradeRSmaActivity.II0xO0.II0XooXoX(DeveloperUpgradeRSmaActivity.this);
                    }
                }, 3000L);
            } else {
                Handler handler2 = new Handler();
                final DeveloperUpgradeRSmaActivity developerUpgradeRSmaActivity2 = DeveloperUpgradeRSmaActivity.this;
                handler2.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.o0Xo
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeveloperUpgradeRSmaActivity.II0xO0.xoIox(DeveloperUpgradeRSmaActivity.this);
                    }
                }, 10000L);
            }
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceConnecting(boolean z) {
            BleHandleCallback.DefaultImpls.onDeviceConnecting(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceFileUpdate(@OXOo.OOXIXo BleDeviceFile bleDeviceFile) {
            BleHandleCallback.DefaultImpls.onDeviceFileUpdate(this, bleDeviceFile);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceRequestAGpsFile(@OXOo.OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onDeviceRequestAGpsFile(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceSMSQuickReply(@OXOo.OOXIXo BleSMSQuickReply bleSMSQuickReply) {
            BleHandleCallback.DefaultImpls.onDeviceSMSQuickReply(this, bleSMSQuickReply);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceSportDataUpdate(@OXOo.OOXIXo BleDeviceSportData bleDeviceSportData) {
            BleHandleCallback.DefaultImpls.onDeviceSportDataUpdate(this, bleDeviceSportData);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDistanceGoalUpdate(int i) {
            BleHandleCallback.DefaultImpls.onDistanceGoalUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDoubleScreenSettingsUpdate(@OXOo.OOXIXo BleDoubleScreenSettings bleDoubleScreenSettings) {
            BleHandleCallback.DefaultImpls.onDoubleScreenSettingsUpdate(this, bleDoubleScreenSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onEarphoneAncSettingsUpdate(@OXOo.OOXIXo BleEarphoneAncSettings bleEarphoneAncSettings) {
            BleHandleCallback.DefaultImpls.onEarphoneAncSettingsUpdate(this, bleEarphoneAncSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onEarphoneCallUpdate(int i) {
            BleHandleCallback.DefaultImpls.onEarphoneCallUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onEarphoneKeyUpdate(@OXOo.OOXIXo BleEarphoneKey bleEarphoneKey) {
            BleHandleCallback.DefaultImpls.onEarphoneKeyUpdate(this, bleEarphoneKey);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onEarphoneSoundEffectsSettingsUpdate(@OXOo.OOXIXo BleEarphoneSoundEffectsSettings bleEarphoneSoundEffectsSettings) {
            BleHandleCallback.DefaultImpls.onEarphoneSoundEffectsSettingsUpdate(this, bleEarphoneSoundEffectsSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onEarphoneStateUpdate(@OXOo.OOXIXo BleEarphoneState bleEarphoneState) {
            BleHandleCallback.DefaultImpls.onEarphoneStateUpdate(this, bleEarphoneState);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onFactoryTestUpdate(@OXOo.OOXIXo BleFactoryTest bleFactoryTest) {
            BleHandleCallback.DefaultImpls.onFactoryTestUpdate(this, bleFactoryTest);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onFallSetUpdate(int i) {
            BleHandleCallback.DefaultImpls.onFallSetUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onFindEarphoneUpdate(@OXOo.OOXIXo BleFindEarphone bleFindEarphone) {
            BleHandleCallback.DefaultImpls.onFindEarphoneUpdate(this, bleFindEarphone);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onFindPhone(boolean z) {
            BleHandleCallback.DefaultImpls.onFindPhone(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onFindWatchUpdate(int i) {
            BleHandleCallback.DefaultImpls.onFindWatchUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onFollowSystemLanguage(boolean z) {
            BleHandleCallback.DefaultImpls.onFollowSystemLanguage(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onGameControlUpdate(@OXOo.OOXIXo BleGameControl bleGameControl) {
            BleHandleCallback.DefaultImpls.onGameControlUpdate(this, bleGameControl);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onGestureWake2Update(@OXOo.OOXIXo BleGestureWake2 bleGestureWake2) {
            BleHandleCallback.DefaultImpls.onGestureWake2Update(this, bleGestureWake2);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onGestureWakeUpdate(@OXOo.OOXIXo BleGestureWake bleGestureWake) {
            BleHandleCallback.DefaultImpls.onGestureWakeUpdate(this, bleGestureWake);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onHIDState(int i) {
            BleHandleCallback.DefaultImpls.onHIDState(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onHIDValueChange(int i) {
            BleHandleCallback.DefaultImpls.onHIDValueChange(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onHanBaoVibrationStateChange(int i) {
            BleHandleCallback.DefaultImpls.onHanBaoVibrationStateChange(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onHourSystemUpdate(int i) {
            BleHandleCallback.DefaultImpls.onHourSystemUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onIPCStoresInfoUpdate(@OXOo.OOXIXo BleIPCStoresInfo bleIPCStoresInfo) {
            BleHandleCallback.DefaultImpls.onIPCStoresInfoUpdate(this, bleIPCStoresInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onIPCWifiInfoUpdate(@OXOo.OOXIXo BleIPCWifiInfo bleIPCWifiInfo) {
            BleHandleCallback.DefaultImpls.onIPCWifiInfoUpdate(this, bleIPCWifiInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onIPCWifiStateUpdate(int i) {
            BleHandleCallback.DefaultImpls.onIPCWifiStateUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onIdentityCreate(boolean z, @OXOo.oOoXoXO BleDeviceInfo bleDeviceInfo) {
            BleHandleCallback.DefaultImpls.onIdentityCreate(this, z, bleDeviceInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onIdentityDelete(boolean z) {
            BleHandleCallback.DefaultImpls.onIdentityDelete(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onIdentityDeleteByDevice(boolean z) {
            BleHandleCallback.DefaultImpls.onIdentityDeleteByDevice(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onIncomingCallRingUpdate(int i) {
            BleHandleCallback.DefaultImpls.onIncomingCallRingUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onIncomingCallStatus(int i) {
            BleHandleCallback.DefaultImpls.onIncomingCallStatus(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onLoveTapUpdate(@OXOo.OOXIXo BleLoveTap bleLoveTap) {
            BleHandleCallback.DefaultImpls.onLoveTapUpdate(this, bleLoveTap);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onLoveTapUserDelete(int i) {
            BleHandleCallback.DefaultImpls.onLoveTapUserDelete(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onLoveTapUserUpdate(@OXOo.OOXIXo BleLoveTapUser bleLoveTapUser) {
            BleHandleCallback.DefaultImpls.onLoveTapUserUpdate(this, bleLoveTapUser);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMeasurementUpdate(@OXOo.OOXIXo BleMeasurement bleMeasurement) {
            BleHandleCallback.DefaultImpls.onMeasurementUpdate(this, bleMeasurement);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMedicationAlarmAdd(@OXOo.OOXIXo BleMedicationAlarm bleMedicationAlarm) {
            BleHandleCallback.DefaultImpls.onMedicationAlarmAdd(this, bleMedicationAlarm);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMedicationAlarmDelete(int i) {
            BleHandleCallback.DefaultImpls.onMedicationAlarmDelete(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMedicationAlarmUpdate(@OXOo.OOXIXo BleMedicationAlarm bleMedicationAlarm) {
            BleHandleCallback.DefaultImpls.onMedicationAlarmUpdate(this, bleMedicationAlarm);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMedicationReminderDelete(int i) {
            BleHandleCallback.DefaultImpls.onMedicationReminderDelete(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMedicationReminderUpdate(@OXOo.OOXIXo BleMedicationReminder bleMedicationReminder) {
            BleHandleCallback.DefaultImpls.onMedicationReminderUpdate(this, bleMedicationReminder);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onNaviInfoUpdate(@OXOo.OOXIXo BleNaviInfo bleNaviInfo) {
            BleHandleCallback.DefaultImpls.onNaviInfoUpdate(this, bleNaviInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onNoDisturbUpdate(@OXOo.OOXIXo BleNoDisturbSettings bleNoDisturbSettings) {
            BleHandleCallback.DefaultImpls.onNoDisturbUpdate(this, bleNoDisturbSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onNotificationLightScreenSetUpdate(int i) {
            BleHandleCallback.DefaultImpls.onNotificationLightScreenSetUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onNotificationSettings2Update(@OXOo.OOXIXo BleNotificationSettings2 bleNotificationSettings2) {
            BleHandleCallback.DefaultImpls.onNotificationSettings2Update(this, bleNotificationSettings2);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onOTA(boolean z) {
            BleHandleCallback.DefaultImpls.onOTA(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onPowerSaveModeState(int i) {
            BleHandleCallback.DefaultImpls.onPowerSaveModeState(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onPowerSaveModeStateChange(int i) {
            BleHandleCallback.DefaultImpls.onPowerSaveModeStateChange(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onQiblaSettingsUpdate() {
            BleHandleCallback.DefaultImpls.onQiblaSettingsUpdate(this);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAICoachGenerateBeforeInfo(@OXOo.OOXIXo BleAICoachBeforePlan bleAICoachBeforePlan) {
            BleHandleCallback.DefaultImpls.onReadAICoachGenerateBeforeInfo(this, bleAICoachBeforePlan);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAICoachPlan(@OXOo.OOXIXo BleAICoachGeneratePlan bleAICoachGeneratePlan) {
            BleHandleCallback.DefaultImpls.onReadAICoachPlan(this, bleAICoachGeneratePlan);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadActivity(@OXOo.OOXIXo List<BleActivity> list) {
            BleHandleCallback.DefaultImpls.onReadActivity(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadActivityDetail(@OXOo.OOXIXo BleActivityDetail bleActivityDetail) {
            BleHandleCallback.DefaultImpls.onReadActivityDetail(this, bleActivityDetail);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAlarm(@OXOo.OOXIXo List<BleAlarm> list) {
            BleHandleCallback.DefaultImpls.onReadAlarm(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAlipayBindInfo(@OXOo.OOXIXo List<BleAlipayBindInfo> list) {
            BleHandleCallback.DefaultImpls.onReadAlipayBindInfo(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAlipaySettings(@OXOo.OOXIXo BleAlipaySettings bleAlipaySettings) {
            BleHandleCallback.DefaultImpls.onReadAlipaySettings(this, bleAlipaySettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAppApiVersion(@OXOo.OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadAppApiVersion(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAppInfoList(@OXOo.OOXIXo BleAppInfoList bleAppInfoList) {
            BleHandleCallback.DefaultImpls.onReadAppInfoList(this, bleAppInfoList);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAvgHeartRate(@OXOo.OOXIXo List<BleAvgHeartRate> list) {
            BleHandleCallback.DefaultImpls.onReadAvgHeartRate(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBAC(@OXOo.OOXIXo List<BleBAC> list) {
            BleHandleCallback.DefaultImpls.onReadBAC(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBacCalibration(@OXOo.OOXIXo BleBacCalibration bleBacCalibration, @OXOo.OOXIXo BleKeyFlag bleKeyFlag) {
            BleHandleCallback.DefaultImpls.onReadBacCalibration(this, bleBacCalibration, bleKeyFlag);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBacklight(int i) {
            BleHandleCallback.DefaultImpls.onReadBacklight(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBatteryUsage(@OXOo.OOXIXo BleBatteryUsage bleBatteryUsage) {
            BleHandleCallback.DefaultImpls.onReadBatteryUsage(this, bleBatteryUsage);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBleAddress(@OXOo.OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadBleAddress(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBleHrv(@OXOo.OOXIXo List<BleHrv> list) {
            BleHandleCallback.DefaultImpls.onReadBleHrv(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBleHrv2(@OXOo.OOXIXo List<BleHrv2> list) {
            BleHandleCallback.DefaultImpls.onReadBleHrv2(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBleLogText(@OXOo.OOXIXo List<BleLogText> list) {
            BleHandleCallback.DefaultImpls.onReadBleLogText(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBloodGlucose(@OXOo.OOXIXo List<BleBloodGlucose> list) {
            BleHandleCallback.DefaultImpls.onReadBloodGlucose(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBloodOxyGenSettings(@OXOo.OOXIXo BleBloodOxyGenSettings bleBloodOxyGenSettings) {
            BleHandleCallback.DefaultImpls.onReadBloodOxyGenSettings(this, bleBloodOxyGenSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBloodOxygen(@OXOo.OOXIXo List<BleBloodOxygen> list) {
            BleHandleCallback.DefaultImpls.onReadBloodOxygen(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBloodPressure(@OXOo.OOXIXo List<BleBloodPressure> list) {
            BleHandleCallback.DefaultImpls.onReadBloodPressure(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBloodPressureCalibration(@OXOo.OOXIXo BleBloodPressureCalibration bleBloodPressureCalibration) {
            BleHandleCallback.DefaultImpls.onReadBloodPressureCalibration(this, bleBloodPressureCalibration);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBodyStatus(@OXOo.OOXIXo List<BleBodyStatus> list) {
            BleHandleCallback.DefaultImpls.onReadBodyStatus(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCPUserInfo(@OXOo.OOXIXo BleCPUserInfo bleCPUserInfo) {
            BleHandleCallback.DefaultImpls.onReadCPUserInfo(this, bleCPUserInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCalibrationData(@OXOo.OOXIXo BleCalibrationData bleCalibrationData) {
            BleHandleCallback.DefaultImpls.onReadCalibrationData(this, bleCalibrationData);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCalorieIntake(@OXOo.OOXIXo List<BleCalorieIntake> list) {
            BleHandleCallback.DefaultImpls.onReadCalorieIntake(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCaloriesGoal(int i) {
            BleHandleCallback.DefaultImpls.onReadCaloriesGoal(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCheckInEveryDay(@OXOo.OOXIXo BleCheckInEveryDay bleCheckInEveryDay) {
            BleHandleCallback.DefaultImpls.onReadCheckInEveryDay(this, bleCheckInEveryDay);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadClassicBluetoothState(int i) {
            BleHandleCallback.DefaultImpls.onReadClassicBluetoothState(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCoachingIds(@OXOo.OOXIXo BleCoachingIds bleCoachingIds) {
            BleHandleCallback.DefaultImpls.onReadCoachingIds(this, bleCoachingIds);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDailyPower(@OXOo.OOXIXo List<BlePhysicalPower> list) {
            BleHandleCallback.DefaultImpls.onReadDailyPower(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDateFormat(int i) {
            BleHandleCallback.DefaultImpls.onReadDateFormat(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDeviceFile(@OXOo.OOXIXo BleDeviceFile bleDeviceFile) {
            BleHandleCallback.DefaultImpls.onReadDeviceFile(this, bleDeviceFile);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDeviceInfo(@OXOo.OOXIXo BleDeviceInfo bleDeviceInfo) {
            BleHandleCallback.DefaultImpls.onReadDeviceInfo(this, bleDeviceInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDeviceInfo2(@OXOo.OOXIXo BleDeviceInfo2 bleDeviceInfo2) {
            BleHandleCallback.DefaultImpls.onReadDeviceInfo2(this, bleDeviceInfo2);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDeviceLanguages(@OXOo.OOXIXo BleDeviceLanguages bleDeviceLanguages) {
            BleHandleCallback.DefaultImpls.onReadDeviceLanguages(this, bleDeviceLanguages);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDeviceUniqueDataSettings(@OXOo.OOXIXo BleDeviceUniqueDataSettings bleDeviceUniqueDataSettings) {
            BleHandleCallback.DefaultImpls.onReadDeviceUniqueDataSettings(this, bleDeviceUniqueDataSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDistanceGoal(int i) {
            BleHandleCallback.DefaultImpls.onReadDistanceGoal(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDoubleScreenSettings(@OXOo.OOXIXo BleDoubleScreenSettings bleDoubleScreenSettings) {
            BleHandleCallback.DefaultImpls.onReadDoubleScreenSettings(this, bleDoubleScreenSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDrinkWater(@OXOo.OOXIXo BleDrinkWaterSettings bleDrinkWaterSettings) {
            BleHandleCallback.DefaultImpls.onReadDrinkWater(this, bleDrinkWaterSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneAncSettings(@OXOo.OOXIXo BleEarphoneAncSettings bleEarphoneAncSettings) {
            BleHandleCallback.DefaultImpls.onReadEarphoneAncSettings(this, bleEarphoneAncSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneCall(int i) {
            BleHandleCallback.DefaultImpls.onReadEarphoneCall(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneInfo(@OXOo.OOXIXo BleEarphoneInfo bleEarphoneInfo) {
            BleHandleCallback.DefaultImpls.onReadEarphoneInfo(this, bleEarphoneInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneKey(@OXOo.OOXIXo BleEarphoneKey bleEarphoneKey) {
            BleHandleCallback.DefaultImpls.onReadEarphoneKey(this, bleEarphoneKey);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphonePower(@OXOo.OOXIXo BleEarphonePower bleEarphonePower) {
            BleHandleCallback.DefaultImpls.onReadEarphonePower(this, bleEarphonePower);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneSoundEffectsSettings(@OXOo.OOXIXo BleEarphoneSoundEffectsSettings bleEarphoneSoundEffectsSettings) {
            BleHandleCallback.DefaultImpls.onReadEarphoneSoundEffectsSettings(this, bleEarphoneSoundEffectsSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneState(@OXOo.OOXIXo BleEarphoneState bleEarphoneState) {
            BleHandleCallback.DefaultImpls.onReadEarphoneState(this, bleEarphoneState);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEcg(@OXOo.OOXIXo List<BleEcg> list) {
            BleHandleCallback.DefaultImpls.onReadEcg(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEcgSettings(@OXOo.OOXIXo BleEcgSettings bleEcgSettings) {
            BleHandleCallback.DefaultImpls.onReadEcgSettings(this, bleEcgSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadFallSet(int i) {
            BleHandleCallback.DefaultImpls.onReadFallSet(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadFilePath(@OXOo.OOXIXo BleAppAudioBookList bleAppAudioBookList) {
            BleHandleCallback.DefaultImpls.onReadFilePath(this, bleAppAudioBookList);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadFirmwareVersion(@OXOo.OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadFirmwareVersion(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadFoodBalance(@OXOo.OOXIXo List<BleFoodBalance> list) {
            BleHandleCallback.DefaultImpls.onReadFoodBalance(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGestureWake(@OXOo.OOXIXo BleGestureWake bleGestureWake) {
            BleHandleCallback.DefaultImpls.onReadGestureWake(this, bleGestureWake);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGestureWake2(@OXOo.OOXIXo BleGestureWake2 bleGestureWake2) {
            BleHandleCallback.DefaultImpls.onReadGestureWake2(this, bleGestureWake2);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGirlCareMonthly(@OXOo.OOXIXo BleGirlCareMonthly bleGirlCareMonthly) {
            BleHandleCallback.DefaultImpls.onReadGirlCareMonthly(this, bleGirlCareMonthly);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGirlCareSettings(@OXOo.OOXIXo BleGirlCareSettings bleGirlCareSettings) {
            BleHandleCallback.DefaultImpls.onReadGirlCareSettings(this, bleGirlCareSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGoMoreSettings(@OXOo.OOXIXo BleGoMoreSettings bleGoMoreSettings) {
            BleHandleCallback.DefaultImpls.onReadGoMoreSettings(this, bleGoMoreSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGpsFirmwareVersion(@OXOo.OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadGpsFirmwareVersion(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadHanBaoSettings(@OXOo.OOXIXo BleHanBaoSettings bleHanBaoSettings) {
            BleHandleCallback.DefaultImpls.onReadHanBaoSettings(this, bleHanBaoSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadHanBaoVibration(@OXOo.OOXIXo List<BleHanBaoVibration> list) {
            BleHandleCallback.DefaultImpls.onReadHanBaoVibration(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadHeartRate(@OXOo.OOXIXo List<BleHeartRate> list) {
            BleHandleCallback.DefaultImpls.onReadHeartRate(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadHourSystem(int i) {
            BleHandleCallback.DefaultImpls.onReadHourSystem(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadHrMonitoringSettings(@OXOo.OOXIXo BleHrMonitoringSettings bleHrMonitoringSettings) {
            BleHandleCallback.DefaultImpls.onReadHrMonitoringSettings(this, bleHrMonitoringSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadIPCStoresInfo(@OXOo.OOXIXo BleIPCStoresInfo bleIPCStoresInfo) {
            BleHandleCallback.DefaultImpls.onReadIPCStoresInfo(this, bleIPCStoresInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadIPCVersion(@OXOo.OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadIPCVersion(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadIPCWifiState(int i) {
            BleHandleCallback.DefaultImpls.onReadIPCWifiState(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadIncomingCallRing(int i) {
            BleHandleCallback.DefaultImpls.onReadIncomingCallRing(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadLactateThreshold(@OXOo.OOXIXo List<BleLactateThreshold> list) {
            BleHandleCallback.DefaultImpls.onReadLactateThreshold(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadLanguage(int i) {
            BleHandleCallback.DefaultImpls.onReadLanguage(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadLanguagePackVersion(@OXOo.OOXIXo BleLanguagePackVersion bleLanguagePackVersion) {
            BleHandleCallback.DefaultImpls.onReadLanguagePackVersion(this, bleLanguagePackVersion);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadLocation(@OXOo.OOXIXo List<BleLocation> list) {
            BleHandleCallback.DefaultImpls.onReadLocation(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadLoveTapUser(@OXOo.OOXIXo List<BleLoveTapUser> list) {
            BleHandleCallback.DefaultImpls.onReadLoveTapUser(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMatchRecord(@OXOo.OOXIXo List<BleMatchRecord> list) {
            BleHandleCallback.DefaultImpls.onReadMatchRecord(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMatchRecord2(@OXOo.OOXIXo List<BleMatchRecord2> list) {
            BleHandleCallback.DefaultImpls.onReadMatchRecord2(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMedicationAlarm(@OXOo.OOXIXo List<BleMedicationAlarm> list) {
            BleHandleCallback.DefaultImpls.onReadMedicationAlarm(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMedicationReminder(@OXOo.OOXIXo List<BleMedicationReminder> list) {
            BleHandleCallback.DefaultImpls.onReadMedicationReminder(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMindStatus(@OXOo.OOXIXo List<BleMindStatus> list) {
            BleHandleCallback.DefaultImpls.onReadMindStatus(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMtkOtaMeta() {
            BleHandleCallback.DefaultImpls.onReadMtkOtaMeta(this);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadNetworkFirmwareVersion(@OXOo.OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadNetworkFirmwareVersion(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadNoDisturb(@OXOo.OOXIXo BleNoDisturbSettings bleNoDisturbSettings) {
            BleHandleCallback.DefaultImpls.onReadNoDisturb(this, bleNoDisturbSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadNotificationLightScreenSet(int i) {
            BleHandleCallback.DefaultImpls.onReadNotificationLightScreenSet(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadNotificationSettings2(@OXOo.OOXIXo BleNotificationSettings2 bleNotificationSettings2) {
            BleHandleCallback.DefaultImpls.onReadNotificationSettings2(this, bleNotificationSettings2);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadPackageStatus(@OXOo.OOXIXo BlePackageStatus blePackageStatus) {
            BleHandleCallback.DefaultImpls.onReadPackageStatus(this, blePackageStatus);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadPower(int i) {
            BleHandleCallback.DefaultImpls.onReadPower(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadPower2(@OXOo.OOXIXo BlePower2 blePower2) {
            BleHandleCallback.DefaultImpls.onReadPower2(this, blePower2);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadPressure(@OXOo.OOXIXo List<BlePressure> list) {
            BleHandleCallback.DefaultImpls.onReadPressure(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadPressureTimingMeasurement(@OXOo.OOXIXo BlePressureTimingMeasurement blePressureTimingMeasurement) {
            BleHandleCallback.DefaultImpls.onReadPressureTimingMeasurement(this, blePressureTimingMeasurement);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadQiblaSettings(@OXOo.OOXIXo BleQiblaSettings bleQiblaSettings) {
            BleHandleCallback.DefaultImpls.onReadQiblaSettings(this, bleQiblaSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadRelaxReminder(@OXOo.OOXIXo BleRelaxReminder bleRelaxReminder) {
            BleHandleCallback.DefaultImpls.onReadRelaxReminder(this, bleRelaxReminder);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadRespiratoryRate(@OXOo.OOXIXo List<BleRespiratoryRate> list) {
            BleHandleCallback.DefaultImpls.onReadRespiratoryRate(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadRingVibrationSet(@OXOo.OOXIXo BleRingVibrationSettings bleRingVibrationSettings) {
            BleHandleCallback.DefaultImpls.onReadRingVibrationSet(this, bleRingVibrationSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadRri(@OXOo.OOXIXo List<BleRri> list) {
            BleHandleCallback.DefaultImpls.onReadRri(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSDCardInfo(@OXOo.OOXIXo BleSDCardInfo bleSDCardInfo) {
            BleHandleCallback.DefaultImpls.onReadSDCardInfo(this, bleSDCardInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSGKeywordAwake(int i) {
            BleHandleCallback.DefaultImpls.onReadSGKeywordAwake(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSGSleepSet(int i) {
            BleHandleCallback.DefaultImpls.onReadSGSleepSet(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSOSSettings(@OXOo.OOXIXo BleSOSSettings bleSOSSettings) {
            BleHandleCallback.DefaultImpls.onReadSOSSettings(this, bleSOSSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadScreenBrightnessSet(int i) {
            BleHandleCallback.DefaultImpls.onReadScreenBrightnessSet(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSedentariness(@OXOo.OOXIXo BleSedentarinessSettings bleSedentarinessSettings) {
            BleHandleCallback.DefaultImpls.onReadSedentariness(this, bleSedentarinessSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSleep(@OXOo.OOXIXo List<BleSleep> list) {
            BleHandleCallback.DefaultImpls.onReadSleep(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSleepGoal(int i) {
            BleHandleCallback.DefaultImpls.onReadSleepGoal(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSleepQuality(@OXOo.OOXIXo BleSleepQuality bleSleepQuality) {
            BleHandleCallback.DefaultImpls.onReadSleepQuality(this, bleSleepQuality);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSleepQualityScore(int i) {
            BleHandleCallback.DefaultImpls.onReadSleepQualityScore(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSleepRaw(@OXOo.OOXIXo byte[] bArr) {
            BleHandleCallback.DefaultImpls.onReadSleepRaw(this, bArr);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSosCallLog(@OXOo.OOXIXo List<BleSosCallLog> list) {
            BleHandleCallback.DefaultImpls.onReadSosCallLog(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSosContact(@OXOo.OOXIXo BleSosContact bleSosContact) {
            BleHandleCallback.DefaultImpls.onReadSosContact(this, bleSosContact);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSportDurationGoal(int i) {
            BleHandleCallback.DefaultImpls.onReadSportDurationGoal(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadStandbyWatchFaceSet(@OXOo.OOXIXo BleStandbyWatchFaceSet bleStandbyWatchFaceSet) {
            BleHandleCallback.DefaultImpls.onReadStandbyWatchFaceSet(this, bleStandbyWatchFaceSet);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadStepGoal(int i) {
            BleHandleCallback.DefaultImpls.onReadStepGoal(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadStock(@OXOo.OOXIXo List<BleStock> list) {
            BleHandleCallback.DefaultImpls.onReadStock(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadTemperature(@OXOo.OOXIXo List<BleTemperature> list) {
            BleHandleCallback.DefaultImpls.onReadTemperature(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadTemperatureUnit(int i) {
            BleHandleCallback.DefaultImpls.onReadTemperatureUnit(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadTrainingStatus(@OXOo.OOXIXo List<BleTrainingStatus> list) {
            BleHandleCallback.DefaultImpls.onReadTrainingStatus(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadTuyaKey(@OXOo.OOXIXo BleTuyaKey bleTuyaKey) {
            BleHandleCallback.DefaultImpls.onReadTuyaKey(this, bleTuyaKey);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadUiPackVersion(@OXOo.OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadUiPackVersion(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadUnit(int i) {
            BleHandleCallback.DefaultImpls.onReadUnit(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadUserProfile(@OXOo.OOXIXo BleUserProfile bleUserProfile) {
            BleHandleCallback.DefaultImpls.onReadUserProfile(this, bleUserProfile);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadVitalityValue(@OXOo.OOXIXo List<BleVitality> list) {
            BleHandleCallback.DefaultImpls.onReadVitalityValue(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWatchFaceId(@OXOo.OOXIXo BleWatchFaceId bleWatchFaceId) {
            BleHandleCallback.DefaultImpls.onReadWatchFaceId(this, bleWatchFaceId);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWatchFaceIndex(@OXOo.OOXIXo BleWatchFaceIndex bleWatchFaceIndex) {
            BleHandleCallback.DefaultImpls.onReadWatchFaceIndex(this, bleWatchFaceIndex);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWatchFaceSwitch(int i) {
            BleHandleCallback.DefaultImpls.onReadWatchFaceSwitch(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWatchPassword(@OXOo.OOXIXo BleSettingWatchPassword bleSettingWatchPassword) {
            BleHandleCallback.DefaultImpls.onReadWatchPassword(this, bleSettingWatchPassword);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWearWayState(int i) {
            BleHandleCallback.DefaultImpls.onReadWearWayState(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWeatherRealTime(boolean z) {
            BleHandleCallback.DefaultImpls.onReadWeatherRealTime(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWorkout(@OXOo.OOXIXo List<BleWorkout> list) {
            BleHandleCallback.DefaultImpls.onReadWorkout(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWorkout2(@OXOo.OOXIXo List<BleWorkout2> list) {
            BleHandleCallback.DefaultImpls.onReadWorkout2(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWorkout3(@OXOo.OOXIXo List<BleWorkout3> list) {
            BleHandleCallback.DefaultImpls.onReadWorkout3(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWorldClock(@OXOo.OOXIXo List<BleWorldClock> list) {
            BleHandleCallback.DefaultImpls.onReadWorldClock(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onRealTimeMeasurement(@OXOo.OOXIXo BleRealTimeMeasurement bleRealTimeMeasurement) {
            BleHandleCallback.DefaultImpls.onRealTimeMeasurement(this, bleRealTimeMeasurement);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveFilePacket(@OXOo.OOXIXo BleReceiveFilePacket bleReceiveFilePacket) {
            BleHandleCallback.DefaultImpls.onReceiveFilePacket(this, bleReceiveFilePacket);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveGSensorMotion(@OXOo.OOXIXo List<BleGSensorMotion> list) {
            BleHandleCallback.DefaultImpls.onReceiveGSensorMotion(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveGSensorRaw(@OXOo.OOXIXo List<BleGSensorRaw> list) {
            BleHandleCallback.DefaultImpls.onReceiveGSensorRaw(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveGSensorSHSY(@OXOo.OOXIXo List<BleGSensorSHSY> list) {
            BleHandleCallback.DefaultImpls.onReceiveGSensorSHSY(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveHRRaw(@OXOo.OOXIXo List<BleHRRaw> list) {
            BleHandleCallback.DefaultImpls.onReceiveHRRaw(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveLocationGga(@OXOo.OOXIXo BleLocationGga bleLocationGga) {
            BleHandleCallback.DefaultImpls.onReceiveLocationGga(this, bleLocationGga);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveLocationGsv(@OXOo.OOXIXo List<BleLocationGsv> list) {
            BleHandleCallback.DefaultImpls.onReceiveLocationGsv(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveMusicCommand(@OXOo.OOXIXo MusicCommand musicCommand) {
            BleHandleCallback.DefaultImpls.onReceiveMusicCommand(this, musicCommand);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceivePpgSHSY(@OXOo.OOXIXo List<BlePpgSHSY> list) {
            BleHandleCallback.DefaultImpls.onReceivePpgSHSY(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveRealtimeLog(@OXOo.OOXIXo BleRealtimeLog bleRealtimeLog) {
            BleHandleCallback.DefaultImpls.onReceiveRealtimeLog(this, bleRealtimeLog);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveRecordPacket(@OXOo.OOXIXo BleRecordPacket bleRecordPacket) {
            BleHandleCallback.DefaultImpls.onReceiveRecordPacket(this, bleRecordPacket);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onRequestAgpsPrerequisite() {
            BleHandleCallback.DefaultImpls.onRequestAgpsPrerequisite(this);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onRequestLocation(int i) {
            BleHandleCallback.DefaultImpls.onRequestLocation(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onRingVibrationSetUpdate(@OXOo.OOXIXo BleRingVibrationSettings bleRingVibrationSettings) {
            BleHandleCallback.DefaultImpls.onRingVibrationSetUpdate(this, bleRingVibrationSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSDCardInfoUpdate(@OXOo.OOXIXo BleSDCardInfo bleSDCardInfo) {
            BleHandleCallback.DefaultImpls.onSDCardInfoUpdate(this, bleSDCardInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSGTestUpdate(@OXOo.OOXIXo BleSGTest bleSGTest) {
            BleHandleCallback.DefaultImpls.onSGTestUpdate(this, bleSGTest);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSOSSettingsUpdate(@OXOo.OOXIXo BleSOSSettings bleSOSSettings) {
            BleHandleCallback.DefaultImpls.onSOSSettingsUpdate(this, bleSOSSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onScreenBrightnessSetUpdate(int i) {
            BleHandleCallback.DefaultImpls.onScreenBrightnessSetUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSessionStateChange(boolean z) {
            LogUtils.d("onSessionStateChange");
            if (!z) {
                DeveloperUpgradeRSmaActivity.this.setMStarted(false);
            }
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSosContactUpdate(@OXOo.OOXIXo BleSosContact bleSosContact) {
            BleHandleCallback.DefaultImpls.onSosContactUpdate(this, bleSosContact);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSportEndNotifyUpdate(int i) {
            BleHandleCallback.DefaultImpls.onSportEndNotifyUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onStandbyWatchFaceSetUpdate(@OXOo.OOXIXo BleStandbyWatchFaceSet bleStandbyWatchFaceSet) {
            BleHandleCallback.DefaultImpls.onStandbyWatchFaceSetUpdate(this, bleStandbyWatchFaceSet);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onStepGoalUpdate(int i) {
            BleHandleCallback.DefaultImpls.onStepGoalUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onStockDelete(int i) {
            BleHandleCallback.DefaultImpls.onStockDelete(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onStreamProgress(boolean z, int i, int i2, int i3, @OXOo.OOXIXo BleKey bleKey) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(bleKey, "bleKey");
            if (!z) {
                DeveloperUpgradeRSmaActivity.this.setMStarted(false);
                ProgressButton.X0o0xo(DeveloperUpgradeRSmaActivity.this.getProgressButton(), R.string.starting, false, 2, null);
                TextView tvStep = DeveloperUpgradeRSmaActivity.this.getTvStep();
                final DeveloperUpgradeRSmaActivity developerUpgradeRSmaActivity = DeveloperUpgradeRSmaActivity.this;
                tvStep.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.OXXoIoXI
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeveloperUpgradeRSmaActivity.II0xO0.oOoXoXO(DeveloperUpgradeRSmaActivity.this);
                    }
                }, AbsBleConnector.TIMEOUT);
                return;
            }
            if (System.currentTimeMillis() - DeveloperUpgradeRSmaActivity.this.time1 > 1000) {
                DeveloperUpgradeRSmaActivity.this.time1 = System.currentTimeMillis();
                DeveloperUpgradeRSmaActivity.this.getTvSpeed().setText(new DecimalFormat("#.##", DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format((i3 - DeveloperUpgradeRSmaActivity.this.lastPackageSize) / 1024.0d) + " KB/s");
                DeveloperUpgradeRSmaActivity.this.lastPackageSize = i3;
            }
            DeveloperUpgradeRSmaActivity.this.getProgressButton().setProgressDecimalPlaces(i3 / i2);
            if (i2 == i3) {
                if (DeveloperUpgradeRSmaActivity.this.mStepsIndex >= CollectionsKt__CollectionsKt.oo0xXOI0I(DeveloperUpgradeRSmaActivity.this.mSteps)) {
                    DeveloperUpgradeRSmaActivity.this.upgradeDone();
                    return;
                }
                DeveloperUpgradeRSmaActivity.this.getProgressButton().setProgress(0.0f);
                DeveloperUpgradeRSmaActivity.this.mStepsIndex++;
                TextView tvStep2 = DeveloperUpgradeRSmaActivity.this.getTvStep();
                final DeveloperUpgradeRSmaActivity developerUpgradeRSmaActivity2 = DeveloperUpgradeRSmaActivity.this;
                tvStep2.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.XO00XOO
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeveloperUpgradeRSmaActivity.II0xO0.OOXIXo(DeveloperUpgradeRSmaActivity.this);
                    }
                }, 4000L);
            }
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSyncData(int i, @OXOo.OOXIXo BleKey bleKey) {
            BleHandleCallback.DefaultImpls.onSyncData(this, i, bleKey);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onTimeUpdate() {
            BleHandleCallback.DefaultImpls.onTimeUpdate(this);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateAppSportState(@OXOo.OOXIXo BleAppSportState bleAppSportState) {
            BleHandleCallback.DefaultImpls.onUpdateAppSportState(this, bleAppSportState);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateBAC(@OXOo.OOXIXo BleBAC bleBAC) {
            BleHandleCallback.DefaultImpls.onUpdateBAC(this, bleBAC);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateBloodPressure(@OXOo.OOXIXo BleBloodPressure bleBloodPressure) {
            BleHandleCallback.DefaultImpls.onUpdateBloodPressure(this, bleBloodPressure);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateHeartRate(@OXOo.OOXIXo BleHeartRate bleHeartRate) {
            BleHandleCallback.DefaultImpls.onUpdateHeartRate(this, bleHeartRate);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateTemperature(@OXOo.OOXIXo BleTemperature bleTemperature) {
            BleHandleCallback.DefaultImpls.onUpdateTemperature(this, bleTemperature);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateWatchFaceSwitch(boolean z) {
            BleHandleCallback.DefaultImpls.onUpdateWatchFaceSwitch(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUserProfileUpdate(@OXOo.OOXIXo BleUserProfile bleUserProfile) {
            BleHandleCallback.DefaultImpls.onUserProfileUpdate(this, bleUserProfile);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onVibrationUpdate(int i) {
            BleHandleCallback.DefaultImpls.onVibrationUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onWatchFaceIdUpdate(boolean z) {
            BleHandleCallback.DefaultImpls.onWatchFaceIdUpdate(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onWatchFaceIndexCreate(boolean z) {
            BleHandleCallback.DefaultImpls.onWatchFaceIndexCreate(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onWatchFaceIndexUpdate(@OXOo.OOXIXo BleWatchFaceIndex bleWatchFaceIndex) {
            BleHandleCallback.DefaultImpls.onWatchFaceIndexUpdate(this, bleWatchFaceIndex);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onWatchPasswordUpdate(@OXOo.OOXIXo BleSettingWatchPassword bleSettingWatchPassword) {
            BleHandleCallback.DefaultImpls.onWatchPasswordUpdate(this, bleSettingWatchPassword);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onWearWayUpdate(int i) {
            BleHandleCallback.DefaultImpls.onWearWayUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onWorldClockDelete(int i) {
            BleHandleCallback.DefaultImpls.onWorldClockDelete(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onXModem(byte b) {
            BleHandleCallback.DefaultImpls.onXModem(this, b);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadStock(boolean z) {
            BleHandleCallback.DefaultImpls.onReadStock(this, z);
        }
    }

    /* loaded from: classes11.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f23289oIX0oI;

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
            try {
                iArr[FileType.FONT_PACK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f23289oIX0oI = iArr;
        }
    }

    public DeveloperUpgradeRSmaActivity() {
        FirmwareVersion firmwareVersion;
        FirmwareVersion firmwareVersion2;
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        SPUtils II0xO02 = xo0.II0xO0();
        Object ooooo0oxi = new ooOOo0oXI(null, 1, null);
        Object fromJson = new Gson().fromJson(II0xO02.getString(ooOOo0oXI.class.getName()), (Class<Object>) ooOOo0oXI.class);
        this.alreadyUpdateDeviceList = (ooOOo0oXI) (fromJson != null ? fromJson : ooooo0oxi);
        String string = xo0.II0xO0().getString(com.sma.smartv3.util.XoI0Ixx0.f24456oo);
        this.deviceAddress = string;
        this.isAutoShutdown = xo0.II0xO0().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24382O0Xx, false);
        this.mDfuHelper$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<GattDfuAdapter>() { // from class: com.sma.smartv3.ui.me.DeveloperUpgradeRSmaActivity$mDfuHelper$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final GattDfuAdapter invoke() {
                Activity mContext;
                mContext = DeveloperUpgradeRSmaActivity.this.getMContext();
                return GattDfuAdapter.getInstance(mContext);
            }
        });
        this.mDfuCallback = new I0Io();
        DfuConfig dfuConfig = new DfuConfig();
        dfuConfig.setAddress(string);
        dfuConfig.setAutomaticActiveEnabled(true);
        dfuConfig.setFileLocation(0);
        dfuConfig.setVersionCheckEnabled(false);
        this.mDfuConfig = dfuConfig;
        this.mBleHandleCallback = new II0xO0();
        this.mLatestFirmware = (FirmwareVersion) new Gson().fromJson(xo0.II0xO0().getString(FirmwareVersion.class.getName()), FirmwareVersion.class);
        ExtraPackVersions extraPackVersions = (ExtraPackVersions) new Gson().fromJson(xo0.II0xO0().getString(ExtraPackVersions.class.getName()), ExtraPackVersions.class);
        this.mLatestExtraPacks = extraPackVersions;
        if (extraPackVersions != null) {
            firmwareVersion = extraPackVersions.getUiPackVersion();
        } else {
            firmwareVersion = null;
        }
        this.mLatestUi = firmwareVersion;
        if (extraPackVersions != null) {
            firmwareVersion2 = extraPackVersions.getLanguagePackVersion();
        } else {
            firmwareVersion2 = null;
        }
        this.mLatestLanguage = firmwareVersion2;
        this.mLatestFont = extraPackVersions != null ? extraPackVersions.getFontPackVersion() : null;
        BleCache bleCache = BleCache.INSTANCE;
        this.mCurrentFirmware = BleCache.getString$default(bleCache, BleKey.FIRMWARE_VERSION, null, null, 6, null);
        this.mCurrentUi = BleCache.getString$default(bleCache, BleKey.UI_PACK_VERSION, null, null, 6, null);
        this.mCurrentLanguage = ((BleLanguagePackVersion) BleCache.getObjectNotNull$default(bleCache, BleKey.LANGUAGE_PACK_VERSION, BleLanguagePackVersion.class, null, null, 12, null)).getMVersion();
        this.mSteps = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkDownload() {
        if (this.mDownloaded == this.mSteps.size()) {
            LogUtils.d("checkDownload");
            ProgressButton.X0o0xo(getProgressButton(), R.string.preparing, false, 2, null);
            int i = oIX0oI.f23289oIX0oI[this.mSteps.get(this.mStepsIndex).ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            BleConnector bleConnector = BleConnector.INSTANCE;
                            if (bleConnector.isAvailable()) {
                                BleKey bleKey = BleKey.FONT_FILE;
                                File oOoXoXO2 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
                                FirmwareVersion firmwareVersion = this.mLatestFont;
                                kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion);
                                BleConnector.sendStream$default(bleConnector, bleKey, new File(oOoXoXO2, firmwareVersion.getFileName()), 0, 4, (Object) null);
                                return;
                            }
                            GattDfuAdapter mDfuHelper = getMDfuHelper();
                            if (mDfuHelper != null) {
                                mDfuHelper.abort();
                                mDfuHelper.close();
                            }
                            new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.OxXXx0X
                                @Override // java.lang.Runnable
                                public final void run() {
                                    DeveloperUpgradeRSmaActivity.checkDownload$lambda$7(DeveloperUpgradeRSmaActivity.this);
                                }
                            }, 4000L);
                            return;
                        }
                        return;
                    }
                    BleConnector bleConnector2 = BleConnector.INSTANCE;
                    if (bleConnector2.isAvailable()) {
                        BleKey bleKey2 = BleKey.LANGUAGE_FILE;
                        File oOoXoXO3 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
                        FirmwareVersion firmwareVersion2 = this.mLatestLanguage;
                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion2);
                        BleConnector.sendStream$default(bleConnector2, bleKey2, new File(oOoXoXO3, firmwareVersion2.getFileName()), 0, 4, (Object) null);
                        return;
                    }
                    GattDfuAdapter mDfuHelper2 = getMDfuHelper();
                    if (mDfuHelper2 != null) {
                        mDfuHelper2.abort();
                        mDfuHelper2.close();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.oo00
                        @Override // java.lang.Runnable
                        public final void run() {
                            DeveloperUpgradeRSmaActivity.checkDownload$lambda$5(DeveloperUpgradeRSmaActivity.this);
                        }
                    }, 4000L);
                    return;
                }
                BleConnector bleConnector3 = BleConnector.INSTANCE;
                if (bleConnector3.isAvailable()) {
                    BleKey bleKey3 = BleKey.UI_FILE;
                    File oOoXoXO4 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
                    FirmwareVersion firmwareVersion3 = this.mLatestUi;
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion3);
                    BleConnector.sendStream$default(bleConnector3, bleKey3, new File(oOoXoXO4, firmwareVersion3.getFileName()), 0, 4, (Object) null);
                    return;
                }
                GattDfuAdapter mDfuHelper3 = getMDfuHelper();
                if (mDfuHelper3 != null) {
                    mDfuHelper3.abort();
                    mDfuHelper3.close();
                }
                new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.oX0ooo0I0
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeveloperUpgradeRSmaActivity.checkDownload$lambda$3(DeveloperUpgradeRSmaActivity.this);
                    }
                }, 4000L);
                return;
            }
            getMDfuHelper().initialize(this.mDfuCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkDownload$lambda$3(DeveloperUpgradeRSmaActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        BleConnector bleConnector = BleConnector.INSTANCE;
        String deviceAddress = this$0.deviceAddress;
        kotlin.jvm.internal.IIX0o.oO(deviceAddress, "deviceAddress");
        bleConnector.setAddress(deviceAddress).connect(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkDownload$lambda$5(DeveloperUpgradeRSmaActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        BleConnector bleConnector = BleConnector.INSTANCE;
        String deviceAddress = this$0.deviceAddress;
        kotlin.jvm.internal.IIX0o.oO(deviceAddress, "deviceAddress");
        bleConnector.setAddress(deviceAddress).connect(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkDownload$lambda$7(DeveloperUpgradeRSmaActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        BleConnector bleConnector = BleConnector.INSTANCE;
        String deviceAddress = this$0.deviceAddress;
        kotlin.jvm.internal.IIX0o.oO(deviceAddress, "deviceAddress");
        bleConnector.setAddress(deviceAddress).connect(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GattDfuAdapter getMDfuHelper() {
        return (GattDfuAdapter) this.mDfuHelper$delegate.getValue();
    }

    private final void otaConnect(String str) {
        getMDfuHelper().connectDevice(new ConnectParams.Builder().address(str).reconnectTimes(3).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startOtaProcess() {
        DfuConfig dfuConfig = this.mDfuConfig;
        dfuConfig.setOtaWorkMode(0);
        File oOoXoXO2 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
        FirmwareVersion firmwareVersion = this.mLatestFirmware;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion);
        dfuConfig.setFilePath(new File(oOoXoXO2, firmwareVersion.getFileName()).getAbsolutePath());
        GattDfuAdapter mDfuHelper = getMDfuHelper();
        if (mDfuHelper != null) {
            mDfuHelper.startOtaProcedure(dfuConfig, this.mOtaDeviceInfo, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void upgrade() {
        LogUtils.d("upgrade");
        getTvStep().setVisibility(0);
        ProgressButton.X0o0xo(getProgressButton(), R.string.starting, false, 2, null);
        getTvStep().setText(getString(R.string.upgrade_steps_d_d, Integer.valueOf(this.mStepsIndex + 1), Integer.valueOf(this.mSteps.size())));
        int i = oIX0oI.f23289oIX0oI[this.mSteps.get(this.mStepsIndex).ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        BleConnector bleConnector = BleConnector.INSTANCE;
                        if (bleConnector.isAvailable()) {
                            BleKey bleKey = BleKey.FONT_FILE;
                            File oOoXoXO2 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
                            FirmwareVersion firmwareVersion = this.mLatestFont;
                            kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion);
                            BleConnector.sendStream$default(bleConnector, bleKey, new File(oOoXoXO2, firmwareVersion.getFileName()), 0, 4, (Object) null);
                            return;
                        }
                        GattDfuAdapter mDfuHelper = getMDfuHelper();
                        if (mDfuHelper != null) {
                            mDfuHelper.abort();
                            mDfuHelper.close();
                        }
                        new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.OxO
                            @Override // java.lang.Runnable
                            public final void run() {
                                DeveloperUpgradeRSmaActivity.upgrade$lambda$14(DeveloperUpgradeRSmaActivity.this);
                            }
                        }, 4000L);
                        return;
                    }
                    return;
                }
                BleConnector bleConnector2 = BleConnector.INSTANCE;
                if (bleConnector2.isAvailable()) {
                    BleKey bleKey2 = BleKey.LANGUAGE_FILE;
                    File oOoXoXO3 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
                    FirmwareVersion firmwareVersion2 = this.mLatestLanguage;
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion2);
                    BleConnector.sendStream$default(bleConnector2, bleKey2, new File(oOoXoXO3, firmwareVersion2.getFileName()), 0, 4, (Object) null);
                    return;
                }
                GattDfuAdapter mDfuHelper2 = getMDfuHelper();
                if (mDfuHelper2 != null) {
                    mDfuHelper2.abort();
                    mDfuHelper2.close();
                }
                new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.X0O0I0
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeveloperUpgradeRSmaActivity.upgrade$lambda$12(DeveloperUpgradeRSmaActivity.this);
                    }
                }, 4000L);
                return;
            }
            BleConnector bleConnector3 = BleConnector.INSTANCE;
            if (bleConnector3.isAvailable()) {
                BleKey bleKey3 = BleKey.UI_FILE;
                File oOoXoXO4 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
                FirmwareVersion firmwareVersion3 = this.mLatestUi;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion3);
                BleConnector.sendStream$default(bleConnector3, bleKey3, new File(oOoXoXO4, firmwareVersion3.getFileName()), 0, 4, (Object) null);
                return;
            }
            GattDfuAdapter mDfuHelper3 = getMDfuHelper();
            if (mDfuHelper3 != null) {
                mDfuHelper3.abort();
                mDfuHelper3.close();
            }
            new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.o0oxo0oI
                @Override // java.lang.Runnable
                public final void run() {
                    DeveloperUpgradeRSmaActivity.upgrade$lambda$10(DeveloperUpgradeRSmaActivity.this);
                }
            }, 4000L);
            return;
        }
        String deviceAddress = this.deviceAddress;
        kotlin.jvm.internal.IIX0o.oO(deviceAddress, "deviceAddress");
        otaConnect(deviceAddress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void upgrade$lambda$10(DeveloperUpgradeRSmaActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        BleConnector bleConnector = BleConnector.INSTANCE;
        String deviceAddress = this$0.deviceAddress;
        kotlin.jvm.internal.IIX0o.oO(deviceAddress, "deviceAddress");
        bleConnector.setAddress(deviceAddress).connect(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void upgrade$lambda$12(DeveloperUpgradeRSmaActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        BleConnector bleConnector = BleConnector.INSTANCE;
        String deviceAddress = this$0.deviceAddress;
        kotlin.jvm.internal.IIX0o.oO(deviceAddress, "deviceAddress");
        bleConnector.setAddress(deviceAddress).connect(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void upgrade$lambda$14(DeveloperUpgradeRSmaActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        BleConnector bleConnector = BleConnector.INSTANCE;
        String deviceAddress = this$0.deviceAddress;
        kotlin.jvm.internal.IIX0o.oO(deviceAddress, "deviceAddress");
        bleConnector.setAddress(deviceAddress).connect(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void upgradeDone() {
        if (this.isAutoShutdown) {
            LogUtils.d("start shutdown");
            if (this.mLoadingPopup == null) {
                this.mLoadingPopup = new com.sma.smartv3.pop.I0X0x0oIo(getMContext());
            }
            com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = this.mLoadingPopup;
            if (i0X0x0oIo != null) {
                i0X0x0oIo.IIXOooo();
            }
            this.isStartShutdown = true;
            BleConnector bleConnector = BleConnector.INSTANCE;
            if (bleConnector.isAvailable()) {
                BleConnector.sendInt8$default(bleConnector, BleKey.SHUTDOWN, BleKeyFlag.UPDATE, 0, false, false, 24, null);
                return;
            }
            GattDfuAdapter mDfuHelper = getMDfuHelper();
            if (mDfuHelper != null) {
                mDfuHelper.abort();
                mDfuHelper.close();
            }
            new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.x00IOx
                @Override // java.lang.Runnable
                public final void run() {
                    DeveloperUpgradeRSmaActivity.upgradeDone$lambda$16(DeveloperUpgradeRSmaActivity.this);
                }
            }, 10000L);
            return;
        }
        upgradeExit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void upgradeDone$lambda$16(DeveloperUpgradeRSmaActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        BleConnector bleConnector = BleConnector.INSTANCE;
        String deviceAddress = this$0.deviceAddress;
        kotlin.jvm.internal.IIX0o.oO(deviceAddress, "deviceAddress");
        bleConnector.setAddress(deviceAddress).connect(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void upgradeExit() {
        this.alreadyUpdateDeviceList.oxoX().add(this.deviceAddress);
        com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(ooOOo0oXI.class.getName(), new Gson().toJson(this.alreadyUpdateDeviceList));
        finish();
    }

    @OXOo.oOoXoXO
    public final OtaDeviceInfo getMOtaDeviceInfo() {
        return this.mOtaDeviceInfo;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        BleConnector bleConnector = BleConnector.INSTANCE;
        bleConnector.addHandleCallback(this.mBleHandleCallback);
        bleConnector.setNeedBind(false);
    }

    @Override // com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        String str;
        String str2;
        String str3;
        String str4;
        String version;
        super.initView();
        FirmwareVersion firmwareVersion = this.mLatestFirmware;
        if (firmwareVersion == null && this.mLatestUi == null && this.mLatestLanguage == null && this.mLatestFont == null) {
            String str5 = this.mCurrentFirmware;
            String IIOIX2 = kotlin.text.OxI.IIOIX(this.mCurrentUi, FileUtils.FILE_EXTENSION_SEPARATOR, "", false, 4, null);
            String IIOIX3 = kotlin.text.OxI.IIOIX(this.mCurrentLanguage, FileUtils.FILE_EXTENSION_SEPARATOR, "", false, 4, null);
            getTvLatest().setText(getString(R.string.v_s, str5 + '.' + IIOIX2 + IIOIX3 + "000"));
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
            FirmwareVersion firmwareVersion4 = this.mLatestFont;
            if (firmwareVersion4 == null || (version = firmwareVersion4.getVersion()) == null) {
                str4 = "000";
            } else {
                str4 = version;
            }
            String IIOIX6 = kotlin.text.OxI.IIOIX(str4, FileUtils.FILE_EXTENSION_SEPARATOR, "", false, 4, null);
            getTvLatest().setText(getString(R.string.v_s, str + '.' + IIOIX4 + IIOIX5 + IIOIX6));
            String IIOIX7 = kotlin.text.OxI.IIOIX(this.mCurrentUi, FileUtils.FILE_EXTENSION_SEPARATOR, "", false, 4, null);
            String IIOIX8 = kotlin.text.OxI.IIOIX(this.mCurrentLanguage, FileUtils.FILE_EXTENSION_SEPARATOR, "", false, 4, null);
            getTvCurrent().setText(getString(R.string.v_s, this.mCurrentFirmware + '.' + IIOIX7 + IIOIX8));
            if (this.mLatestFirmware != null) {
                this.mSteps.add(FileType.FIRMWARE);
            }
            if (this.mLatestLanguage != null) {
                this.mSteps.add(FileType.LANGUAGE_PACK);
            }
            if (this.mLatestUi != null) {
                this.mSteps.add(FileType.UI_PACK);
            }
            if (this.mLatestFont != null) {
                this.mSteps.add(FileType.FONT_PACK);
            }
            getTvStep().setVisibility(0);
        }
        getDevInfo().setVisibility(0);
        TextView tvAlreadyOta = getTvAlreadyOta();
        SPUtils II0xO02 = com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0();
        Object ooooo0oxi = new ooOOo0oXI(null, 1, null);
        Object fromJson = new Gson().fromJson(II0xO02.getString(ooOOo0oXI.class.getName()), (Class<Object>) ooOOo0oXI.class);
        if (fromJson != null) {
            ooooo0oxi = fromJson;
        }
        tvAlreadyOta.setText(String.valueOf(((ooOOo0oXI) ooooo0oxi).oxoX().size()));
        getTvInfo().setText("R sma");
        onBottomClick(getTvStep());
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        BleConnector.INSTANCE.closeConnection(true);
        this.mDownloaded = 0;
        setMStarted(true);
        ProgressButton.X0o0xo(getProgressButton(), R.string.downloading, false, 2, null);
        if (this.mStepsIndex == 0) {
            if (this.mLatestFirmware != null) {
                X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
                if (new File(com.sma.smartv3.initializer.IXxxXO.oOoXoXO(oix0oi), this.mLatestFirmware.getFileName()).exists()) {
                    this.mDownloaded++;
                    checkDownload();
                } else {
                    NetWorkUtils.INSTANCE.download(this.mLatestFirmware.getFileUrl(), com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(oix0oi), this.mLatestFirmware.getFileName(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.me.DeveloperUpgradeRSmaActivity$onBottomClick$1
                        @Override // xxxI.II0xO0
                        public void handleError(@OXOo.OOXIXo String error) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                            DeveloperUpgradeRSmaActivity.this.mDownloaded = 0;
                            DeveloperUpgradeRSmaActivity.this.setMStarted(false);
                        }

                        @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                        public void handleProgress(int i) {
                        }

                        @Override // xxxI.II0xO0
                        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                        public void handleResponse(@OXOo.oOoXoXO String str) {
                            int i;
                            DeveloperUpgradeRSmaActivity developerUpgradeRSmaActivity = DeveloperUpgradeRSmaActivity.this;
                            i = developerUpgradeRSmaActivity.mDownloaded;
                            developerUpgradeRSmaActivity.mDownloaded = i + 1;
                            DeveloperUpgradeRSmaActivity.this.checkDownload();
                        }
                    });
                }
            }
            if (this.mLatestUi != null) {
                X00IoxXI.oIX0oI oix0oi2 = X00IoxXI.oIX0oI.f3233oIX0oI;
                if (new File(com.sma.smartv3.initializer.IXxxXO.oOoXoXO(oix0oi2), this.mLatestUi.getFileName()).exists()) {
                    this.mDownloaded++;
                    checkDownload();
                } else {
                    NetWorkUtils.INSTANCE.download(this.mLatestUi.getFileUrl(), com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(oix0oi2), this.mLatestUi.getFileName(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.me.DeveloperUpgradeRSmaActivity$onBottomClick$2
                        @Override // xxxI.II0xO0
                        public void handleError(@OXOo.OOXIXo String error) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                            DeveloperUpgradeRSmaActivity.this.mDownloaded = 0;
                            DeveloperUpgradeRSmaActivity.this.setMStarted(false);
                        }

                        @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                        public void handleProgress(int i) {
                        }

                        @Override // xxxI.II0xO0
                        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                        public void handleResponse(@OXOo.oOoXoXO String str) {
                            int i;
                            DeveloperUpgradeRSmaActivity developerUpgradeRSmaActivity = DeveloperUpgradeRSmaActivity.this;
                            i = developerUpgradeRSmaActivity.mDownloaded;
                            developerUpgradeRSmaActivity.mDownloaded = i + 1;
                            DeveloperUpgradeRSmaActivity.this.checkDownload();
                        }
                    });
                }
            }
            if (this.mLatestLanguage != null) {
                X00IoxXI.oIX0oI oix0oi3 = X00IoxXI.oIX0oI.f3233oIX0oI;
                if (new File(com.sma.smartv3.initializer.IXxxXO.oOoXoXO(oix0oi3), this.mLatestLanguage.getFileName()).exists()) {
                    this.mDownloaded++;
                    checkDownload();
                } else {
                    NetWorkUtils.INSTANCE.download(this.mLatestLanguage.getFileUrl(), com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(oix0oi3), this.mLatestLanguage.getFileName(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.me.DeveloperUpgradeRSmaActivity$onBottomClick$3
                        @Override // xxxI.II0xO0
                        public void handleError(@OXOo.OOXIXo String error) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                            DeveloperUpgradeRSmaActivity.this.mDownloaded = 0;
                            DeveloperUpgradeRSmaActivity.this.setMStarted(false);
                        }

                        @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                        public void handleProgress(int i) {
                        }

                        @Override // xxxI.II0xO0
                        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                        public void handleResponse(@OXOo.oOoXoXO String str) {
                            int i;
                            DeveloperUpgradeRSmaActivity developerUpgradeRSmaActivity = DeveloperUpgradeRSmaActivity.this;
                            i = developerUpgradeRSmaActivity.mDownloaded;
                            developerUpgradeRSmaActivity.mDownloaded = i + 1;
                            DeveloperUpgradeRSmaActivity.this.checkDownload();
                        }
                    });
                }
            }
            if (this.mLatestFont != null) {
                X00IoxXI.oIX0oI oix0oi4 = X00IoxXI.oIX0oI.f3233oIX0oI;
                if (new File(com.sma.smartv3.initializer.IXxxXO.oOoXoXO(oix0oi4), this.mLatestFont.getFileName()).exists()) {
                    this.mDownloaded++;
                    checkDownload();
                    return;
                } else {
                    NetWorkUtils.INSTANCE.download(this.mLatestFont.getFileUrl(), com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(oix0oi4), this.mLatestFont.getFileName(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.me.DeveloperUpgradeRSmaActivity$onBottomClick$4
                        @Override // xxxI.II0xO0
                        public void handleError(@OXOo.OOXIXo String error) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                            DeveloperUpgradeRSmaActivity.this.mDownloaded = 0;
                            DeveloperUpgradeRSmaActivity.this.setMStarted(false);
                        }

                        @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                        public void handleProgress(int i) {
                        }

                        @Override // xxxI.II0xO0
                        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                        public void handleResponse(@OXOo.oOoXoXO String str) {
                            int i;
                            DeveloperUpgradeRSmaActivity developerUpgradeRSmaActivity = DeveloperUpgradeRSmaActivity.this;
                            i = developerUpgradeRSmaActivity.mDownloaded;
                            developerUpgradeRSmaActivity.mDownloaded = i + 1;
                            DeveloperUpgradeRSmaActivity.this.checkDownload();
                        }
                    });
                    return;
                }
            }
            return;
        }
        upgrade();
    }

    @Override // com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity, com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        BleConnector bleConnector = BleConnector.INSTANCE;
        bleConnector.removeHandleCallback(this.mBleHandleCallback);
        if (!this.mSteps.isEmpty() && this.mStepsIndex == CollectionsKt__CollectionsKt.oo0xXOI0I(this.mSteps)) {
            BleCache bleCache = BleCache.INSTANCE;
            BleCache.remove$default(bleCache, BleKey.UI_FILE, null, 2, null);
            BleCache.remove$default(bleCache, BleKey.LANGUAGE_FILE, null, 2, null);
            BleCache.remove$default(bleCache, BleKey.FONT_FILE, null, 2, null);
            bleConnector.closeConnection(true);
        }
        bleConnector.setNeedBind(true);
        GattDfuAdapter mDfuHelper = getMDfuHelper();
        if (mDfuHelper != null) {
            mDfuHelper.abort();
            mDfuHelper.close();
        }
        super.onDestroy();
    }

    public final void setMOtaDeviceInfo(@OXOo.oOoXoXO OtaDeviceInfo otaDeviceInfo) {
        this.mOtaDeviceInfo = otaDeviceInfo;
    }
}
