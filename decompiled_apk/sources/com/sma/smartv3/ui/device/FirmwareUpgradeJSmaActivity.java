package com.sma.smartv3.ui.device;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.gson.Gson;
import com.jieli.jl_bt_ota.interfaces.BtEventCallback;
import com.jieli.jl_bt_ota.interfaces.IUpgradeCallback;
import com.jieli.jl_bt_ota.model.BluetoothOTAConfigure;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_rcsp.impl.NetworkOpImpl;
import com.jieli.jl_rcsp.interfaces.network.OnNetworkOTACallback;
import com.jieli.jl_rcsp.model.network.OTAParam;
import com.jieli.watchtesttool.tool.bluetooth.BluetoothEventListener;
import com.jieli.watchtesttool.tool.bluetooth.BluetoothHelper;
import com.jieli.watchtesttool.tool.upgrade.OTAManager;
import com.jieli.watchtesttool.tool.watch.WatchManager;
import com.sma.androidnetworklib.method.HttpProgressCallback;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.ExtraPackVersions;
import com.sma.smartv3.model.FirmwareVersion;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.ui.device.FirmwareUpgradeJSmaActivity;
import com.sma.smartv3.util.UtilsKt;
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
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

@kotlin.jvm.internal.XX({"SMAP\nFirmwareUpgradeJSmaActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwareUpgradeJSmaActivity.kt\ncom/sma/smartv3/ui/device/FirmwareUpgradeJSmaActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,787:1\n15#2:788\n15#2:789\n*S KotlinDebug\n*F\n+ 1 FirmwareUpgradeJSmaActivity.kt\ncom/sma/smartv3/ui/device/FirmwareUpgradeJSmaActivity\n*L\n206#1:788\n207#1:789\n*E\n"})
/* loaded from: classes12.dex */
public final class FirmwareUpgradeJSmaActivity extends BaseFirmwareUpgradeActivity {
    private boolean isUpgradeDoneOTAFile;
    private boolean isUseDfuAddress;

    @OXOo.oOoXoXO
    private BluetoothHelper mBluetoothHelper;

    @OXOo.OOXIXo
    private final String mCurrentFirmware;

    @OXOo.OOXIXo
    private final String mCurrentGps;

    @OXOo.OOXIXo
    private final String mCurrentLanguage;

    @OXOo.OOXIXo
    private final String mCurrentNetwork;

    @OXOo.OOXIXo
    private final String mCurrentUi;
    private int mDownloaded;

    @OXOo.oOoXoXO
    private final ExtraPackVersions mLatestExtraPacks;

    @OXOo.oOoXoXO
    private final FirmwareVersion mLatestFirmware;

    @OXOo.oOoXoXO
    private final FirmwareVersion mLatestFont;

    @OXOo.oOoXoXO
    private FirmwareVersion mLatestGpsFirmware;

    @OXOo.oOoXoXO
    private final FirmwareVersion mLatestLanguage;

    @OXOo.oOoXoXO
    private FirmwareVersion mLatestNetworkFirmware;

    @OXOo.oOoXoXO
    private final FirmwareVersion mLatestUi;

    @OXOo.oOoXoXO
    private NetworkOpImpl mNetworkOp;

    @OXOo.oOoXoXO
    private OTAManager mOTAManager;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mOtaFailedPopup;

    @OXOo.OOXIXo
    private final List<FileType> mSteps;
    private int mStepsIndex;

    @OXOo.oOoXoXO
    private WatchManager mWatchManager;

    @OXOo.OOXIXo
    private final String TAG = "UpgradeJ";

    @OXOo.OOXIXo
    private OTAStatus mOTAStatus = OTAStatus.NONE;

    @OXOo.OOXIXo
    private final I0Io mBtEventListener = new I0Io();

    @OXOo.OOXIXo
    private final BtEventCallback mOTAEventCallback = new oxoX();

    @OXOo.OOXIXo
    private II0xO0 mBleHandleCallback = new II0xO0();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes12.dex */
    public static final class FileType {
        private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
        private static final /* synthetic */ FileType[] $VALUES;
        public static final FileType FIRMWARE = new FileType("FIRMWARE", 0);
        public static final FileType UI_PACK = new FileType("UI_PACK", 1);
        public static final FileType LANGUAGE_PACK = new FileType("LANGUAGE_PACK", 2);
        public static final FileType FONT_PACK = new FileType("FONT_PACK", 3);
        public static final FileType OTA_PACK = new FileType("OTA_PACK", 4);
        public static final FileType GPS_FIRMWARE = new FileType("GPS_FIRMWARE", 5);
        public static final FileType NETWORK_FIRMWARE = new FileType("NETWORK_FIRMWARE", 6);

        private static final /* synthetic */ FileType[] $values() {
            return new FileType[]{FIRMWARE, UI_PACK, LANGUAGE_PACK, FONT_PACK, OTA_PACK, GPS_FIRMWARE, NETWORK_FIRMWARE};
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
    public static final class I0Io extends BluetoothEventListener {
        public I0Io() {
        }

        public static final void II0xO0(FirmwareUpgradeJSmaActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            File oOoXoXO2 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
            FirmwareVersion firmwareVersion = this$0.mLatestNetworkFirmware;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion);
            String absolutePath = new File(oOoXoXO2, firmwareVersion.getFileName()).getAbsolutePath();
            kotlin.jvm.internal.IIX0o.oO(absolutePath, "getAbsolutePath(...)");
            this$0.startNetworkOTA(absolutePath);
        }

        @Override // com.jieli.watchtesttool.tool.bluetooth.BluetoothEventListener
        public void onAdapterStatus(boolean z) {
            LogUtils.d(FirmwareUpgradeJSmaActivity.this.TAG + " bt onAdapterStatus -> " + z);
        }

        @Override // com.jieli.watchtesttool.tool.bluetooth.BluetoothEventListener
        public void onConnection(@OXOo.OOXIXo BluetoothDevice device, int i) {
            Boolean bool;
            kotlin.jvm.internal.IIX0o.x0xO0oo(device, "device");
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            sb.append(FirmwareUpgradeJSmaActivity.this.TAG);
            sb.append(" bt onConnection -> mOTAStatus = ");
            sb.append(FirmwareUpgradeJSmaActivity.this.mOTAStatus);
            sb.append(", ");
            sb.append(device);
            sb.append(", status = ");
            sb.append(i);
            sb.append(", isOTA = ");
            OTAManager oTAManager = FirmwareUpgradeJSmaActivity.this.mOTAManager;
            Boolean bool2 = null;
            if (oTAManager != null) {
                bool = Boolean.valueOf(oTAManager.isOTA());
            } else {
                bool = null;
            }
            sb.append(bool);
            sb.append(",  isNetworkOTA = ");
            NetworkOpImpl networkOpImpl = FirmwareUpgradeJSmaActivity.this.mNetworkOp;
            if (networkOpImpl != null) {
                bool2 = Boolean.valueOf(networkOpImpl.isNetworkOTA());
            }
            sb.append(bool2);
            oix0oi.oIX0oI(sb.toString());
            if (FirmwareUpgradeJSmaActivity.this.mSteps.get(FirmwareUpgradeJSmaActivity.this.mStepsIndex) == FileType.NETWORK_FIRMWARE) {
                if (i != 0) {
                    if (i == 2) {
                        oix0oi.oIX0oI(FirmwareUpgradeJSmaActivity.this.TAG + " bt onConnection -> network device connected");
                        NetworkOpImpl networkOpImpl2 = FirmwareUpgradeJSmaActivity.this.mNetworkOp;
                        if (networkOpImpl2 != null && !networkOpImpl2.isNetworkOTA()) {
                            Handler handler = new Handler();
                            final FirmwareUpgradeJSmaActivity firmwareUpgradeJSmaActivity = FirmwareUpgradeJSmaActivity.this;
                            handler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.OX00O0xII
                                @Override // java.lang.Runnable
                                public final void run() {
                                    FirmwareUpgradeJSmaActivity.I0Io.II0xO0(FirmwareUpgradeJSmaActivity.this);
                                }
                            }, 1000L);
                            return;
                        }
                        return;
                    }
                    return;
                }
                oix0oi.oIX0oI(FirmwareUpgradeJSmaActivity.this.TAG + " bt onConnection -> network device disconnected");
                if (FirmwareUpgradeJSmaActivity.this.mOTAStatus == OTAStatus.UPGRADE_PREPARE) {
                    FirmwareUpgradeJSmaActivity.this.updateUpgradeStatus(OTAStatus.UPGRADE_PREPARE_FAILED, "network device disconnected");
                    return;
                }
                return;
            }
            if (i == 0) {
                oix0oi.oIX0oI(FirmwareUpgradeJSmaActivity.this.TAG + " bt onConnection -> ota device disconnected");
                if (FirmwareUpgradeJSmaActivity.this.mOTAStatus == OTAStatus.UPGRADE_PREPARE) {
                    FirmwareUpgradeJSmaActivity.this.updateUpgradeStatus(OTAStatus.UPGRADE_PREPARE_FAILED, "ota device disconnected");
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements BleHandleCallback {

        /* loaded from: classes12.dex */
        public /* synthetic */ class oIX0oI {

            /* renamed from: oIX0oI, reason: collision with root package name */
            public static final /* synthetic */ int[] f21841oIX0oI;

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
                try {
                    iArr[FileType.OTA_PACK.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[FileType.GPS_FIRMWARE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[FileType.NETWORK_FIRMWARE.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                f21841oIX0oI = iArr;
            }
        }

        public II0xO0() {
        }

        public static final void I0Io(FirmwareUpgradeJSmaActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            BleConnector bleConnector = BleConnector.INSTANCE;
            BleKey bleKey = BleKey.UI_FILE;
            File oOoXoXO2 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
            FirmwareVersion firmwareVersion = this$0.mLatestUi;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion);
            BleConnector.sendStream$default(bleConnector, bleKey, new File(oOoXoXO2, firmwareVersion.getFileName()), 0, 4, (Object) null);
        }

        public static final void oxoX(FirmwareUpgradeJSmaActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            this$0.upgrade();
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
            BleHandleCallback.DefaultImpls.onCommandReply(this, bleKey, bleKeyFlag, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onCommandSendTimeout(@OXOo.OOXIXo BleKey bleKey, @OXOo.OOXIXo BleKeyFlag bleKeyFlag) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(bleKey, "bleKey");
            kotlin.jvm.internal.IIX0o.x0xO0oo(bleKeyFlag, "bleKeyFlag");
            if (bleKey == BleKey.UI_FILE || bleKey == BleKey.LANGUAGE_FILE || bleKey == BleKey.OTA_FILE || bleKey == BleKey.GPS_FIRMWARE_VERSION) {
                FirmwareUpgradeJSmaActivity.this.setMStarted(false);
                ProgressButton.XO(FirmwareUpgradeJSmaActivity.this.getProgressButton(), com.sma.smartv3.util.oO.f24511oIX0oI.X0o0xo(), false, 2, null);
            }
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceConnected(@OXOo.OOXIXo BluetoothDevice bluetoothDevice) {
            BleHandleCallback.DefaultImpls.onDeviceConnected(this, bluetoothDevice);
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
            if (z) {
                switch (oIX0oI.f21841oIX0oI[((FileType) FirmwareUpgradeJSmaActivity.this.mSteps.get(FirmwareUpgradeJSmaActivity.this.mStepsIndex)).ordinal()]) {
                    case 1:
                        ProgressButton.X0o0xo(FirmwareUpgradeJSmaActivity.this.getProgressButton(), R.string.Parsing, false, 2, null);
                        Handler handler = new Handler();
                        final FirmwareUpgradeJSmaActivity firmwareUpgradeJSmaActivity = FirmwareUpgradeJSmaActivity.this;
                        handler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.xoO0xx0
                            @Override // java.lang.Runnable
                            public final void run() {
                                FirmwareUpgradeJSmaActivity.II0xO0.I0Io(FirmwareUpgradeJSmaActivity.this);
                            }
                        }, 12000L);
                        return;
                    case 2:
                        ProgressButton.X0o0xo(FirmwareUpgradeJSmaActivity.this.getProgressButton(), R.string.Parsing, false, 2, null);
                        BleConnector bleConnector = BleConnector.INSTANCE;
                        BleKey bleKey = BleKey.LANGUAGE_FILE;
                        File oOoXoXO2 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
                        FirmwareVersion firmwareVersion = FirmwareUpgradeJSmaActivity.this.mLatestLanguage;
                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion);
                        BleConnector.sendStream$default(bleConnector, bleKey, new File(oOoXoXO2, firmwareVersion.getFileName()), 0, 4, (Object) null);
                        return;
                    case 3:
                        ProgressButton.X0o0xo(FirmwareUpgradeJSmaActivity.this.getProgressButton(), R.string.Parsing, false, 2, null);
                        BleConnector bleConnector2 = BleConnector.INSTANCE;
                        BleKey bleKey2 = BleKey.FONT_FILE;
                        File oOoXoXO3 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
                        FirmwareVersion firmwareVersion2 = FirmwareUpgradeJSmaActivity.this.mLatestFont;
                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion2);
                        BleConnector.sendStream$default(bleConnector2, bleKey2, new File(oOoXoXO3, firmwareVersion2.getFileName()), 0, 4, (Object) null);
                        return;
                    case 4:
                        ProgressButton.X0o0xo(FirmwareUpgradeJSmaActivity.this.getProgressButton(), R.string.Parsing, false, 2, null);
                        BleConnector bleConnector3 = BleConnector.INSTANCE;
                        BleKey bleKey3 = BleKey.OTA_FILE;
                        File oOoXoXO4 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
                        FirmwareVersion firmwareVersion3 = FirmwareUpgradeJSmaActivity.this.mLatestFirmware;
                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion3);
                        BleConnector.sendStream$default(bleConnector3, bleKey3, new File(oOoXoXO4, firmwareVersion3.getFileName()), 0, 4, (Object) null);
                        return;
                    case 5:
                        ProgressButton.X0o0xo(FirmwareUpgradeJSmaActivity.this.getProgressButton(), R.string.Parsing, false, 2, null);
                        BleConnector bleConnector4 = BleConnector.INSTANCE;
                        BleKey bleKey4 = BleKey.GPS_FIRMWARE_FILE;
                        File oOoXoXO5 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
                        FirmwareVersion firmwareVersion4 = FirmwareUpgradeJSmaActivity.this.mLatestGpsFirmware;
                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion4);
                        BleConnector.sendStream$default(bleConnector4, bleKey4, new File(oOoXoXO5, firmwareVersion4.getFileName()), 0, 4, (Object) null);
                        return;
                    case 6:
                        ProgressButton.X0o0xo(FirmwareUpgradeJSmaActivity.this.getProgressButton(), R.string.Parsing, false, 2, null);
                        FirmwareUpgradeJSmaActivity.this.connectDevice(BleCache.INSTANCE.getMBleAddress());
                        return;
                    default:
                        return;
                }
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
            if (z) {
                FirmwareUpgradeJSmaActivity.this.getProgressButton().setProgressDecimalPlaces(i3 / i2);
                if (i2 == i3) {
                    if (FirmwareUpgradeJSmaActivity.this.mStepsIndex < CollectionsKt__CollectionsKt.oo0xXOI0I(FirmwareUpgradeJSmaActivity.this.mSteps)) {
                        FirmwareUpgradeJSmaActivity.this.getProgressButton().setProgress(0.0f);
                        FirmwareUpgradeJSmaActivity.this.mStepsIndex++;
                        TextView tvStep = FirmwareUpgradeJSmaActivity.this.getTvStep();
                        final FirmwareUpgradeJSmaActivity firmwareUpgradeJSmaActivity = FirmwareUpgradeJSmaActivity.this;
                        tvStep.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.ooOx
                            @Override // java.lang.Runnable
                            public final void run() {
                                FirmwareUpgradeJSmaActivity.II0xO0.oxoX(FirmwareUpgradeJSmaActivity.this);
                            }
                        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                        return;
                    }
                    FirmwareUpgradeJSmaActivity.this.upgradeDone();
                    return;
                }
                return;
            }
            FirmwareUpgradeJSmaActivity.this.setMStarted(false);
            if (!FirmwareUpgradeJSmaActivity.this.isUpgradeDoneOTAFile()) {
                ProgressButton.XO(FirmwareUpgradeJSmaActivity.this.getProgressButton(), com.sma.smartv3.util.oO.f24511oIX0oI.X0o0xo(), false, 2, null);
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

    /* loaded from: classes12.dex */
    public static final class X0o0xo implements OnNetworkOTACallback {
        public X0o0xo() {
        }

        public static final void II0xO0(FirmwareUpgradeJSmaActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            this$0.upgrade();
        }

        @Override // com.jieli.jl_rcsp.interfaces.network.OnNetworkOTACallback
        public void onCancel() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeJSmaActivity.this.TAG + " NetworkOTA onCancel");
            FirmwareUpgradeJSmaActivity.this.updateUpgradeStatus(OTAStatus.UPGRADE_FAILED, "NetworkOTA onCancel");
        }

        @Override // com.jieli.jl_rcsp.interfaces.network.OnNetworkOTACallback
        public void onError(int i, @OXOo.oOoXoXO String str) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeJSmaActivity.this.TAG + " NetworkOTA onError -> error = " + i + ", " + str);
            ToastUtils.showLong(str, new Object[0]);
            FirmwareUpgradeJSmaActivity.this.updateUpgradeStatus(OTAStatus.UPGRADE_FAILED, "error = " + i + ", " + str);
        }

        @Override // com.jieli.jl_rcsp.interfaces.network.OnNetworkOTACallback
        public void onProgress(int i) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeJSmaActivity.this.TAG + " NetworkOTA p -> " + i);
            FirmwareUpgradeJSmaActivity.this.mOTAStatus = OTAStatus.UPGRADEING;
            FirmwareUpgradeJSmaActivity.this.getProgressButton().setProgress(((float) i) / 100.0f);
        }

        @Override // com.jieli.jl_rcsp.interfaces.network.OnNetworkOTACallback
        public void onStart() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeJSmaActivity.this.TAG + " NetworkOTA start");
            FirmwareUpgradeJSmaActivity.updateUpgradeStatus$default(FirmwareUpgradeJSmaActivity.this, OTAStatus.UPGRADE_START, null, 2, null);
        }

        @Override // com.jieli.jl_rcsp.interfaces.network.OnNetworkOTACallback
        public void onStop() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeJSmaActivity.this.TAG + " NetworkOTA onStop upgrade ok");
            FirmwareUpgradeJSmaActivity.updateUpgradeStatus$default(FirmwareUpgradeJSmaActivity.this, OTAStatus.UPGRADE_STOP, null, 2, null);
            FirmwareUpgradeJSmaActivity.this.setMStarted(true);
            FirmwareUpgradeJSmaActivity.this.getProgressButton().setProgress(1.0f);
            if (FirmwareUpgradeJSmaActivity.this.mStepsIndex < CollectionsKt__CollectionsKt.oo0xXOI0I(FirmwareUpgradeJSmaActivity.this.mSteps)) {
                FirmwareUpgradeJSmaActivity.this.getProgressButton().setProgress(0.0f);
                FirmwareUpgradeJSmaActivity.this.mStepsIndex++;
                TextView tvStep = FirmwareUpgradeJSmaActivity.this.getTvStep();
                final FirmwareUpgradeJSmaActivity firmwareUpgradeJSmaActivity = FirmwareUpgradeJSmaActivity.this;
                tvStep.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.xX0IIXIx0
                    @Override // java.lang.Runnable
                    public final void run() {
                        FirmwareUpgradeJSmaActivity.X0o0xo.II0xO0(FirmwareUpgradeJSmaActivity.this);
                    }
                }, 3000L);
                return;
            }
            FirmwareUpgradeJSmaActivity.this.upgradeDone();
        }
    }

    /* loaded from: classes12.dex */
    public static final class XO implements IUpgradeCallback {
        public XO() {
        }

        public static final void II0xO0(FirmwareUpgradeJSmaActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            this$0.upgrade();
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onCancelOTA() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeJSmaActivity.this.TAG + " ota cancel");
            FirmwareUpgradeJSmaActivity.this.updateUpgradeStatus(OTAStatus.UPGRADE_FAILED, "ota cancel");
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onError(@OXOo.OOXIXo BaseError p0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(p0, "p0");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeJSmaActivity.this.TAG + " ota onError -> status = " + FirmwareUpgradeJSmaActivity.this.mOTAStatus + ", error = " + p0);
            ToastUtils.showLong(p0.getMessage(), new Object[0]);
            FirmwareUpgradeJSmaActivity.this.updateUpgradeStatus(OTAStatus.UPGRADE_FAILED, "status = " + FirmwareUpgradeJSmaActivity.this.mOTAStatus + ", error = " + p0);
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onNeedReconnect(@OXOo.OOXIXo String addr, boolean z) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(addr, "addr");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeJSmaActivity.this.TAG + " ota onNeedReconnect -> " + addr + ", " + z);
            FirmwareUpgradeJSmaActivity.this.isUseDfuAddress = true;
            com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24419XO, true);
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onProgress(int i, float f) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeJSmaActivity.this.TAG + " ota p -> " + i + ", " + f);
            if (i == 0) {
                FirmwareUpgradeJSmaActivity.this.mOTAStatus = OTAStatus.UPGRADE_CHECKING;
                ProgressButton progressButton = FirmwareUpgradeJSmaActivity.this.getProgressButton();
                String string = FirmwareUpgradeJSmaActivity.this.getString(R.string.check_file);
                kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                progressButton.II0xO0(string, Math.round(f) / 100.0f);
                return;
            }
            FirmwareUpgradeJSmaActivity.this.mOTAStatus = OTAStatus.UPGRADEING;
            FirmwareUpgradeJSmaActivity.this.getProgressButton().setProgress(Math.round(f) / 100.0f);
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onStartOTA() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeJSmaActivity.this.TAG + " ota start");
            FirmwareUpgradeJSmaActivity.this.setUpgradeDoneOTAFile(false);
            FirmwareUpgradeJSmaActivity.updateUpgradeStatus$default(FirmwareUpgradeJSmaActivity.this, OTAStatus.UPGRADE_START, null, 2, null);
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onStopOTA() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeJSmaActivity.this.TAG + " ota stop! upgrade is ok");
            FirmwareUpgradeJSmaActivity.updateUpgradeStatus$default(FirmwareUpgradeJSmaActivity.this, OTAStatus.UPGRADE_STOP, null, 2, null);
            com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24419XO, false);
            FirmwareUpgradeJSmaActivity.this.getProgressButton().setProgress(1.0f);
            if (FirmwareUpgradeJSmaActivity.this.mStepsIndex < CollectionsKt__CollectionsKt.oo0xXOI0I(FirmwareUpgradeJSmaActivity.this.mSteps)) {
                FirmwareUpgradeJSmaActivity.this.getProgressButton().setProgress(0.0f);
                FirmwareUpgradeJSmaActivity.this.mStepsIndex++;
                TextView tvStep = FirmwareUpgradeJSmaActivity.this.getTvStep();
                final FirmwareUpgradeJSmaActivity firmwareUpgradeJSmaActivity = FirmwareUpgradeJSmaActivity.this;
                tvStep.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.xOOOX
                    @Override // java.lang.Runnable
                    public final void run() {
                        FirmwareUpgradeJSmaActivity.XO.II0xO0(FirmwareUpgradeJSmaActivity.this);
                    }
                }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                return;
            }
            FirmwareUpgradeJSmaActivity.this.upgradeDone();
        }
    }

    /* loaded from: classes12.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public static final /* synthetic */ int[] f21844II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f21845oIX0oI;

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
            try {
                iArr[FileType.OTA_PACK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FileType.GPS_FIRMWARE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[FileType.NETWORK_FIRMWARE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f21845oIX0oI = iArr;
            int[] iArr2 = new int[OTAStatus.values().length];
            try {
                iArr2[OTAStatus.UPGRADE_SCANNING_TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[OTAStatus.UPGRADE_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[OTAStatus.UPGRADE_PREPARE_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            f21844II0xO0 = iArr2;
        }
    }

    /* loaded from: classes12.dex */
    public static final class oxoX extends BtEventCallback {
        public oxoX() {
        }

        @Override // com.jieli.jl_bt_ota.interfaces.BtEventCallback, com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
        public void onConnection(@OXOo.OOXIXo BluetoothDevice device, int i) {
            Boolean bool;
            kotlin.jvm.internal.IIX0o.x0xO0oo(device, "device");
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            sb.append(FirmwareUpgradeJSmaActivity.this.TAG);
            sb.append(" ota onConnection -> mOTAStatus = ");
            sb.append(FirmwareUpgradeJSmaActivity.this.mOTAStatus);
            sb.append(", ");
            sb.append(device);
            sb.append(" ,status = ");
            sb.append(i);
            sb.append(" ,isOTA = ");
            OTAManager oTAManager = FirmwareUpgradeJSmaActivity.this.mOTAManager;
            if (oTAManager != null) {
                bool = Boolean.valueOf(oTAManager.isOTA());
            } else {
                bool = null;
            }
            sb.append(bool);
            oix0oi.oIX0oI(sb.toString());
            if (FirmwareUpgradeJSmaActivity.this.mSteps.get(FirmwareUpgradeJSmaActivity.this.mStepsIndex) == FileType.FIRMWARE) {
                OTAManager oTAManager2 = FirmwareUpgradeJSmaActivity.this.mOTAManager;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(oTAManager2);
                if (!oTAManager2.isOTA()) {
                    if (i != 0) {
                        if (i == 1) {
                            FirmwareUpgradeJSmaActivity firmwareUpgradeJSmaActivity = FirmwareUpgradeJSmaActivity.this;
                            if (firmwareUpgradeJSmaActivity.canOTA(firmwareUpgradeJSmaActivity.mOTAStatus)) {
                                FirmwareUpgradeJSmaActivity firmwareUpgradeJSmaActivity2 = FirmwareUpgradeJSmaActivity.this;
                                File oOoXoXO2 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
                                FirmwareVersion firmwareVersion = FirmwareUpgradeJSmaActivity.this.mLatestFirmware;
                                kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion);
                                String absolutePath = new File(oOoXoXO2, firmwareVersion.getFileName()).getAbsolutePath();
                                kotlin.jvm.internal.IIX0o.oO(absolutePath, "getAbsolutePath(...)");
                                firmwareUpgradeJSmaActivity2.startOTA(absolutePath);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    oix0oi.oIX0oI(FirmwareUpgradeJSmaActivity.this.TAG + " ota onConnection -> device disconnected");
                    if (FirmwareUpgradeJSmaActivity.this.mOTAStatus == OTAStatus.UPGRADE_PREPARE) {
                        FirmwareUpgradeJSmaActivity.this.updateUpgradeStatus(OTAStatus.UPGRADE_PREPARE_FAILED, "device disconnected");
                    }
                }
            }
        }
    }

    public FirmwareUpgradeJSmaActivity() {
        FirmwareVersion firmwareVersion;
        FirmwareVersion firmwareVersion2;
        FirmwareVersion firmwareVersion3;
        FirmwareVersion firmwareVersion4;
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
        if (extraPackVersions != null) {
            firmwareVersion2 = extraPackVersions.getLanguagePackVersion();
        } else {
            firmwareVersion2 = null;
        }
        this.mLatestLanguage = firmwareVersion2;
        if (extraPackVersions != null) {
            firmwareVersion3 = extraPackVersions.getFontPackVersion();
        } else {
            firmwareVersion3 = null;
        }
        this.mLatestFont = firmwareVersion3;
        if (extraPackVersions != null) {
            firmwareVersion4 = extraPackVersions.getGpsFirmwareVersion();
        } else {
            firmwareVersion4 = null;
        }
        this.mLatestGpsFirmware = firmwareVersion4;
        this.mLatestNetworkFirmware = extraPackVersions != null ? extraPackVersions.getNetworkFirmwareVersion() : null;
        BleCache bleCache = BleCache.INSTANCE;
        this.mCurrentFirmware = BleCache.getString$default(bleCache, BleKey.FIRMWARE_VERSION, null, null, 6, null);
        this.mCurrentUi = BleCache.getString$default(bleCache, BleKey.UI_PACK_VERSION, null, null, 6, null);
        this.mCurrentLanguage = ((BleLanguagePackVersion) BleCache.getObjectNotNull$default(bleCache, BleKey.LANGUAGE_PACK_VERSION, BleLanguagePackVersion.class, null, null, 12, null)).getMVersion();
        this.mCurrentGps = BleCache.getString$default(bleCache, BleKey.GPS_FIRMWARE_VERSION, null, null, 6, null);
        this.mCurrentNetwork = BleCache.getString$default(bleCache, BleKey.NETWORK_FIRMWARE_VERSION, null, null, 6, null);
        this.mSteps = new ArrayList();
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
        if (this.mDownloaded == this.mSteps.size()) {
            ProgressButton.X0o0xo(getProgressButton(), R.string.preparing, false, 2, null);
            LogUtils.d("checkDownload done start upgrade");
            upgrade();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void connectDevice(String str) {
        BluetoothDevice bluetoothDevice;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " connectDevice -> " + str);
        BluetoothHelper bluetoothHelper = this.mBluetoothHelper;
        if (bluetoothHelper != null) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                bluetoothDevice = defaultAdapter.getRemoteDevice(str);
            } else {
                bluetoothDevice = null;
            }
            bluetoothHelper.connectDevice(bluetoothDevice);
        }
    }

    private final void destroyOTA() {
        WatchManager watchManager = this.mWatchManager;
        if (watchManager != null) {
            watchManager.release();
        }
        this.mWatchManager = null;
        OTAManager oTAManager = this.mOTAManager;
        if (oTAManager != null) {
            oTAManager.unregisterBluetoothCallback(this.mOTAEventCallback);
        }
        OTAManager oTAManager2 = this.mOTAManager;
        if (oTAManager2 != null) {
            oTAManager2.release();
        }
        this.mOTAManager = null;
        NetworkOpImpl networkOpImpl = this.mNetworkOp;
        if (networkOpImpl != null) {
            networkOpImpl.destroy();
        }
        this.mNetworkOp = null;
        BluetoothHelper bluetoothHelper = this.mBluetoothHelper;
        if (bluetoothHelper != null) {
            bluetoothHelper.removeBluetoothEventListener(this.mBtEventListener);
        }
        BluetoothHelper bluetoothHelper2 = this.mBluetoothHelper;
        if (bluetoothHelper2 != null) {
            bluetoothHelper2.destroy();
        }
        this.mBluetoothHelper = null;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " destroyOTA");
    }

    private final void initOTA() {
        BluetoothHelper bluetoothHelper = BluetoothHelper.getInstance(Utils.getApp());
        this.mBluetoothHelper = bluetoothHelper;
        if (bluetoothHelper != null) {
            bluetoothHelper.addBluetoothEventListener(this.mBtEventListener);
        }
        OTAManager oTAManager = new OTAManager(this);
        this.mOTAManager = oTAManager;
        oTAManager.registerBluetoothCallback(this.mOTAEventCallback);
        WatchManager watchManager = WatchManager.getInstance(Utils.getApp());
        this.mWatchManager = watchManager;
        this.mNetworkOp = NetworkOpImpl.instance(watchManager);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " initOTA");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(FirmwareUpgradeJSmaActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.onBottomClick(this$0.getTvTip());
    }

    private final boolean isOTAError(OTAStatus oTAStatus) {
        int i = oIX0oI.f21844II0xO0[oTAStatus.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return true;
        }
        return false;
    }

    private final void showOtaFailedPopup() {
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0;
        if (this.mOtaFailedPopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx02.x0xO0oo(false);
            xoI0Ixx02.IoOoX(R.string.firmware_upgrading_failed_and_retry);
            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx02, null, null, 2, null);
            xoI0Ixx02.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.FirmwareUpgradeJSmaActivity$showOtaFailedPopup$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    FirmwareUpgradeJSmaActivity firmwareUpgradeJSmaActivity = FirmwareUpgradeJSmaActivity.this;
                    firmwareUpgradeJSmaActivity.onBottomClick(firmwareUpgradeJSmaActivity.getTvTip());
                    return Boolean.TRUE;
                }
            });
            this.mOtaFailedPopup = xoI0Ixx02;
        }
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx03 = this.mOtaFailedPopup;
        if ((xoI0Ixx03 == null || !xoI0Ixx03.isShowing()) && (xoI0Ixx0 = this.mOtaFailedPopup) != null) {
            xoI0Ixx0.IIXOooo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUpgradeStatus(OTAStatus oTAStatus, String str) {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " updateUpgradeStatus status -> " + oTAStatus);
        this.mOTAStatus = oTAStatus;
        if (isOTAError(oTAStatus)) {
            setMStarted(false);
            ProgressButton.XO(getProgressButton(), com.sma.smartv3.util.oO.f24511oIX0oI.X0o0xo(), false, 2, null);
            if (isAutoUpdate()) {
                upgradeFailed(str);
            } else {
                showOtaFailedPopup();
            }
            BaseFirmwareUpgradeActivity.uploadOtaRecord$default(this, "-1", str, null, null, null, 28, null);
            return;
        }
        setMStarted(true);
    }

    public static /* synthetic */ void updateUpgradeStatus$default(FirmwareUpgradeJSmaActivity firmwareUpgradeJSmaActivity, OTAStatus oTAStatus, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        firmwareUpgradeJSmaActivity.updateUpgradeStatus(oTAStatus, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void upgrade() {
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI(this.TAG + " upgrade " + this.mSteps.get(this.mStepsIndex));
        getTvStep().setVisibility(0);
        ProgressButton.X0o0xo(getProgressButton(), R.string.starting, false, 2, null);
        getTvStep().setText(getString(R.string.upgrade_steps_d_d, Integer.valueOf(this.mStepsIndex + 1), Integer.valueOf(this.mSteps.size())));
        switch (oIX0oI.f21845oIX0oI[this.mSteps.get(this.mStepsIndex).ordinal()]) {
            case 1:
                oix0oi.oIX0oI(this.TAG + " firmware");
                destroyOTA();
                initOTA();
                if (this.isUseDfuAddress) {
                    oix0oi.oIX0oI(this.TAG + " upgrade -> use dfuAddress");
                    connectDevice(BleCache.INSTANCE.getMDfuAddress());
                } else {
                    oix0oi.oIX0oI(this.TAG + " upgrade -> use bleAddress");
                    connectDevice(BleCache.INSTANCE.getMBleAddress());
                }
                updateUpgradeStatus$default(this, OTAStatus.UPGRADE_PREPARE, null, 2, null);
                return;
            case 2:
                jlDestory();
                oix0oi.oIX0oI(this.TAG + " ui_file");
                BleConnector bleConnector = BleConnector.INSTANCE;
                if (bleConnector.isAvailable()) {
                    BleKey bleKey = BleKey.UI_FILE;
                    File oOoXoXO2 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
                    FirmwareVersion firmwareVersion = this.mLatestUi;
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion);
                    BleConnector.sendStream$default(bleConnector, bleKey, new File(oOoXoXO2, firmwareVersion.getFileName()), 0, 4, (Object) null);
                    return;
                }
                new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.O00XxXI
                    @Override // java.lang.Runnable
                    public final void run() {
                        FirmwareUpgradeJSmaActivity.upgrade$lambda$2();
                    }
                }, 4000L);
                return;
            case 3:
                jlDestory();
                oix0oi.oIX0oI(this.TAG + " language_file");
                BleConnector bleConnector2 = BleConnector.INSTANCE;
                if (bleConnector2.isAvailable()) {
                    BleKey bleKey2 = BleKey.LANGUAGE_FILE;
                    File oOoXoXO3 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
                    FirmwareVersion firmwareVersion2 = this.mLatestLanguage;
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion2);
                    BleConnector.sendStream$default(bleConnector2, bleKey2, new File(oOoXoXO3, firmwareVersion2.getFileName()), 0, 4, (Object) null);
                    return;
                }
                new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.XI0oooXX
                    @Override // java.lang.Runnable
                    public final void run() {
                        FirmwareUpgradeJSmaActivity.upgrade$lambda$3();
                    }
                }, 4000L);
                return;
            case 4:
                jlDestory();
                oix0oi.oIX0oI(this.TAG + " font_pack");
                BleConnector bleConnector3 = BleConnector.INSTANCE;
                if (bleConnector3.isAvailable()) {
                    BleKey bleKey3 = BleKey.FONT_FILE;
                    File oOoXoXO4 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
                    FirmwareVersion firmwareVersion3 = this.mLatestFont;
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion3);
                    BleConnector.sendStream$default(bleConnector3, bleKey3, new File(oOoXoXO4, firmwareVersion3.getFileName()), 0, 4, (Object) null);
                    return;
                }
                new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.OOXIxO0
                    @Override // java.lang.Runnable
                    public final void run() {
                        FirmwareUpgradeJSmaActivity.upgrade$lambda$4();
                    }
                }, 4000L);
                return;
            case 5:
                jlDestory();
                oix0oi.oIX0oI(this.TAG + " ota_pack");
                BleConnector bleConnector4 = BleConnector.INSTANCE;
                if (bleConnector4.isAvailable()) {
                    BleKey bleKey4 = BleKey.OTA_FILE;
                    File oOoXoXO5 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
                    FirmwareVersion firmwareVersion4 = this.mLatestFirmware;
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion4);
                    BleConnector.sendStream$default(bleConnector4, bleKey4, new File(oOoXoXO5, firmwareVersion4.getFileName()), 0, 4, (Object) null);
                    return;
                }
                new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.IIxOXoOo0
                    @Override // java.lang.Runnable
                    public final void run() {
                        FirmwareUpgradeJSmaActivity.upgrade$lambda$5();
                    }
                }, 4000L);
                return;
            case 6:
                jlDestory();
                oix0oi.oIX0oI(this.TAG + " gps_firmware");
                BleConnector bleConnector5 = BleConnector.INSTANCE;
                if (bleConnector5.isAvailable()) {
                    BleKey bleKey5 = BleKey.GPS_FIRMWARE_FILE;
                    File oOoXoXO6 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
                    FirmwareVersion firmwareVersion5 = this.mLatestGpsFirmware;
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion5);
                    BleConnector.sendStream$default(bleConnector5, bleKey5, new File(oOoXoXO6, firmwareVersion5.getFileName()), 0, 4, (Object) null);
                    return;
                }
                new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.I0
                    @Override // java.lang.Runnable
                    public final void run() {
                        FirmwareUpgradeJSmaActivity.upgrade$lambda$6();
                    }
                }, 4000L);
                return;
            case 7:
                if (this.mNetworkOp == null) {
                    initOTA();
                }
                oix0oi.oIX0oI(this.TAG + " network_firmware");
                updateUpgradeStatus$default(this, OTAStatus.UPGRADE_PREPARE, null, 2, null);
                connectDevice(BleCache.INSTANCE.getMBleAddress());
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void upgrade$lambda$2() {
        BleConnector.INSTANCE.launch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void upgrade$lambda$3() {
        BleConnector.INSTANCE.launch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void upgrade$lambda$4() {
        BleConnector.INSTANCE.launch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void upgrade$lambda$5() {
        BleConnector.INSTANCE.launch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void upgrade$lambda$6() {
        BleConnector.INSTANCE.launch();
    }

    private final void upgradeFailed(String str) {
        finish();
        com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24640ooOx, str);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24419XO, false);
        BleConnector.INSTANCE.addHandleCallback(this.mBleHandleCallback);
        com.sma.smartv3.util.ooXIXxIX.II0xO0(this);
    }

    @Override // com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        super.initView();
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI(this.TAG + " Server -> " + UtilsKt.IXxxXO());
        oix0oi.oIX0oI(this.TAG + " Firmware -> " + this.mLatestFirmware);
        oix0oi.oIX0oI(this.TAG + " ExtraPacks -> " + this.mLatestExtraPacks);
        FirmwareVersion firmwareVersion = this.mLatestFirmware;
        if (firmwareVersion == null && this.mLatestUi == null && this.mLatestLanguage == null && this.mLatestFont == null && this.mLatestGpsFirmware == null && this.mLatestNetworkFirmware == null) {
            String str6 = this.mCurrentFirmware;
            String IIOIX2 = kotlin.text.OxI.IIOIX(this.mCurrentUi, FileUtils.FILE_EXTENSION_SEPARATOR, "", false, 4, null);
            String IIOIX3 = kotlin.text.OxI.IIOIX(this.mCurrentLanguage, FileUtils.FILE_EXTENSION_SEPARATOR, "", false, 4, null);
            String IIOIX4 = kotlin.text.OxI.IIOIX(this.mCurrentGps, FileUtils.FILE_EXTENSION_SEPARATOR, "", false, 4, null);
            getTvLatest().setText(getString(R.string.v_s, str6 + '.' + IIOIX2 + IIOIX3 + IIOIX4));
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
        String IIOIX5 = kotlin.text.OxI.IIOIX(str2, FileUtils.FILE_EXTENSION_SEPARATOR, "", false, 4, null);
        FirmwareVersion firmwareVersion3 = this.mLatestLanguage;
        if (firmwareVersion3 == null || (str3 = firmwareVersion3.getVersion()) == null) {
            str3 = this.mCurrentLanguage;
        }
        String IIOIX6 = kotlin.text.OxI.IIOIX(str3, FileUtils.FILE_EXTENSION_SEPARATOR, "", false, 4, null);
        FirmwareVersion firmwareVersion4 = this.mLatestGpsFirmware;
        if (firmwareVersion4 == null || (str4 = firmwareVersion4.getVersion()) == null) {
            str4 = this.mCurrentGps;
        }
        String IIOIX7 = kotlin.text.OxI.IIOIX(str4, FileUtils.FILE_EXTENSION_SEPARATOR, "", false, 4, null);
        FirmwareVersion firmwareVersion5 = this.mLatestNetworkFirmware;
        if (firmwareVersion5 == null || (str5 = firmwareVersion5.getVersion()) == null) {
            str5 = this.mCurrentNetwork;
        }
        String IIOIX8 = kotlin.text.OxI.IIOIX(str5, FileUtils.FILE_EXTENSION_SEPARATOR, "", false, 4, null);
        getTvLatest().setText(getString(R.string.v_s, str + '.' + IIOIX5 + IIOIX6 + IIOIX7 + IIOIX8));
        StringBuilder sb = new StringBuilder();
        sb.append(this.TAG);
        sb.append(" latest -> ");
        sb.append((Object) getTvLatest().getText());
        oix0oi.oIX0oI(sb.toString());
        String IIOIX9 = kotlin.text.OxI.IIOIX(this.mCurrentUi, FileUtils.FILE_EXTENSION_SEPARATOR, "", false, 4, null);
        String IIOIX10 = kotlin.text.OxI.IIOIX(this.mCurrentLanguage, FileUtils.FILE_EXTENSION_SEPARATOR, "", false, 4, null);
        String IIOIX11 = kotlin.text.OxI.IIOIX(this.mCurrentGps, FileUtils.FILE_EXTENSION_SEPARATOR, "", false, 4, null);
        String IIOIX12 = kotlin.text.OxI.IIOIX(this.mCurrentNetwork, FileUtils.FILE_EXTENSION_SEPARATOR, "", false, 4, null);
        getTvCurrent().setText(getString(R.string.v_s, this.mCurrentFirmware + '.' + IIOIX9 + IIOIX10 + IIOIX11 + IIOIX12));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.TAG);
        sb2.append(" current -> ");
        sb2.append((Object) getTvCurrent().getText());
        oix0oi.oIX0oI(sb2.toString());
        setMCurrentVersion(this.mCurrentFirmware);
        setMTargetVersion(str);
        if (this.mLatestFirmware != null) {
            if (ProductManager.f20544oIX0oI.o0xIoII()) {
                this.mSteps.add(FileType.OTA_PACK);
            } else {
                this.mSteps.add(FileType.FIRMWARE);
            }
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
        if (this.mLatestGpsFirmware != null) {
            this.mSteps.add(FileType.GPS_FIRMWARE);
        }
        if (this.mLatestNetworkFirmware != null) {
            this.mSteps.add(FileType.NETWORK_FIRMWARE);
        }
        getTvStep().setVisibility(0);
        getTvTip().setText(R.string.jl_firmware_upgrade_tip);
        if (isAutoUpdate()) {
            new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.o0xxxXXxX
                @Override // java.lang.Runnable
                public final void run() {
                    FirmwareUpgradeJSmaActivity.initView$lambda$0(FirmwareUpgradeJSmaActivity.this);
                }
            }, 500L);
        }
    }

    public final boolean isUpgradeDoneOTAFile() {
        return this.isUpgradeDoneOTAFile;
    }

    public final void jlDestory() {
        destroyOTA();
    }

    @Override // com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = this.mOtaFailedPopup;
        if (xoI0Ixx0 != null && xoI0Ixx0.isShowing()) {
            return;
        }
        if (!getMStarted() && com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24419XO)) {
            showOtaFailedPopup();
        } else {
            super.onBackPressed();
        }
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
                if (com.blankj.utilcode.util.FileUtils.isFileExists(file)) {
                    this.mDownloaded++;
                    checkDownload();
                } else {
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " download firmware");
                    NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
                    String fileUrl = this.mLatestFirmware.getFileUrl();
                    String parent = file.getParent();
                    kotlin.jvm.internal.IIX0o.oO(parent, "getParent(...)");
                    String name = file.getName();
                    kotlin.jvm.internal.IIX0o.oO(name, "getName(...)");
                    netWorkUtils.download(fileUrl, parent, name, new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.device.FirmwareUpgradeJSmaActivity$onBottomClick$1
                        @Override // xxxI.II0xO0
                        public void handleError(@OXOo.OOXIXo String error) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                            OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeJSmaActivity.this.TAG + " download firmware error -> " + error);
                            FirmwareUpgradeJSmaActivity.this.mDownloaded = 0;
                            FirmwareUpgradeJSmaActivity.this.setMStarted(false);
                        }

                        @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                        public void handleProgress(int i) {
                        }

                        @Override // xxxI.II0xO0
                        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                        public void handleResponse(@OXOo.oOoXoXO String str) {
                            int i;
                            FirmwareUpgradeJSmaActivity firmwareUpgradeJSmaActivity = FirmwareUpgradeJSmaActivity.this;
                            i = firmwareUpgradeJSmaActivity.mDownloaded;
                            firmwareUpgradeJSmaActivity.mDownloaded = i + 1;
                            FirmwareUpgradeJSmaActivity.this.checkDownload();
                            FirmwareUpgradeJSmaActivity firmwareUpgradeJSmaActivity2 = FirmwareUpgradeJSmaActivity.this;
                            BaseFirmwareUpgradeActivity.uploadDownloadInfo$default(firmwareUpgradeJSmaActivity2, firmwareUpgradeJSmaActivity2.mLatestFirmware.getFileUrl(), FirmwareUpgradeJSmaActivity.this.mLatestFirmware.getFileName(), 0, 4, null);
                        }
                    });
                }
            }
            FirmwareVersion firmwareVersion = this.mLatestUi;
            if (firmwareVersion != null) {
                NetWorkUtils.INSTANCE.download(firmwareVersion.getFileUrl(), com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(X00IoxXI.oIX0oI.f3233oIX0oI), this.mLatestUi.getFileName(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.device.FirmwareUpgradeJSmaActivity$onBottomClick$2
                    @Override // xxxI.II0xO0
                    public void handleError(@OXOo.OOXIXo String error) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeJSmaActivity.this.TAG + " download ui error -> " + error);
                        FirmwareUpgradeJSmaActivity.this.mDownloaded = 0;
                        FirmwareUpgradeJSmaActivity.this.setMStarted(false);
                    }

                    @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                    public void handleProgress(int i) {
                    }

                    @Override // xxxI.II0xO0
                    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                    public void handleResponse(@OXOo.oOoXoXO String str) {
                        int i;
                        FirmwareUpgradeJSmaActivity firmwareUpgradeJSmaActivity = FirmwareUpgradeJSmaActivity.this;
                        i = firmwareUpgradeJSmaActivity.mDownloaded;
                        firmwareUpgradeJSmaActivity.mDownloaded = i + 1;
                        FirmwareUpgradeJSmaActivity.this.checkDownload();
                        FirmwareUpgradeJSmaActivity firmwareUpgradeJSmaActivity2 = FirmwareUpgradeJSmaActivity.this;
                        BaseFirmwareUpgradeActivity.uploadDownloadInfo$default(firmwareUpgradeJSmaActivity2, firmwareUpgradeJSmaActivity2.mLatestUi.getFileUrl(), FirmwareUpgradeJSmaActivity.this.mLatestUi.getFileName(), 0, 4, null);
                    }
                });
            }
            FirmwareVersion firmwareVersion2 = this.mLatestLanguage;
            if (firmwareVersion2 != null) {
                NetWorkUtils.INSTANCE.download(firmwareVersion2.getFileUrl(), com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(X00IoxXI.oIX0oI.f3233oIX0oI), this.mLatestLanguage.getFileName(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.device.FirmwareUpgradeJSmaActivity$onBottomClick$3
                    @Override // xxxI.II0xO0
                    public void handleError(@OXOo.OOXIXo String error) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeJSmaActivity.this.TAG + " download language error -> " + error);
                        FirmwareUpgradeJSmaActivity.this.mDownloaded = 0;
                        FirmwareUpgradeJSmaActivity.this.setMStarted(false);
                    }

                    @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                    public void handleProgress(int i) {
                    }

                    @Override // xxxI.II0xO0
                    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                    public void handleResponse(@OXOo.oOoXoXO String str) {
                        int i;
                        FirmwareUpgradeJSmaActivity firmwareUpgradeJSmaActivity = FirmwareUpgradeJSmaActivity.this;
                        i = firmwareUpgradeJSmaActivity.mDownloaded;
                        firmwareUpgradeJSmaActivity.mDownloaded = i + 1;
                        FirmwareUpgradeJSmaActivity.this.checkDownload();
                        FirmwareUpgradeJSmaActivity firmwareUpgradeJSmaActivity2 = FirmwareUpgradeJSmaActivity.this;
                        BaseFirmwareUpgradeActivity.uploadDownloadInfo$default(firmwareUpgradeJSmaActivity2, firmwareUpgradeJSmaActivity2.mLatestLanguage.getFileUrl(), FirmwareUpgradeJSmaActivity.this.mLatestLanguage.getFileName(), 0, 4, null);
                    }
                });
            }
            FirmwareVersion firmwareVersion3 = this.mLatestFont;
            if (firmwareVersion3 != null) {
                NetWorkUtils.INSTANCE.download(firmwareVersion3.getFileUrl(), com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(X00IoxXI.oIX0oI.f3233oIX0oI), this.mLatestFont.getFileName(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.device.FirmwareUpgradeJSmaActivity$onBottomClick$4
                    @Override // xxxI.II0xO0
                    public void handleError(@OXOo.OOXIXo String error) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeJSmaActivity.this.TAG + " download font error -> " + error);
                        FirmwareUpgradeJSmaActivity.this.mDownloaded = 0;
                        FirmwareUpgradeJSmaActivity.this.setMStarted(false);
                    }

                    @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                    public void handleProgress(int i) {
                    }

                    @Override // xxxI.II0xO0
                    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                    public void handleResponse(@OXOo.oOoXoXO String str) {
                        int i;
                        FirmwareUpgradeJSmaActivity firmwareUpgradeJSmaActivity = FirmwareUpgradeJSmaActivity.this;
                        i = firmwareUpgradeJSmaActivity.mDownloaded;
                        firmwareUpgradeJSmaActivity.mDownloaded = i + 1;
                        FirmwareUpgradeJSmaActivity.this.checkDownload();
                    }
                });
            }
            FirmwareVersion firmwareVersion4 = this.mLatestGpsFirmware;
            if (firmwareVersion4 != null) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion4);
                String fileUrl2 = firmwareVersion4.getFileUrl();
                String ooOOo0oXI2 = com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(X00IoxXI.oIX0oI.f3233oIX0oI);
                FirmwareVersion firmwareVersion5 = this.mLatestGpsFirmware;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion5);
                netWorkUtils2.download(fileUrl2, ooOOo0oXI2, firmwareVersion5.getFileName(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.device.FirmwareUpgradeJSmaActivity$onBottomClick$5
                    @Override // xxxI.II0xO0
                    public void handleError(@OXOo.OOXIXo String error) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeJSmaActivity.this.TAG + " download gpsfw error -> " + error);
                        FirmwareUpgradeJSmaActivity.this.mDownloaded = 0;
                        FirmwareUpgradeJSmaActivity.this.setMStarted(false);
                    }

                    @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                    public void handleProgress(int i) {
                    }

                    @Override // xxxI.II0xO0
                    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                    public void handleResponse(@OXOo.oOoXoXO String str) {
                        int i;
                        FirmwareUpgradeJSmaActivity firmwareUpgradeJSmaActivity = FirmwareUpgradeJSmaActivity.this;
                        i = firmwareUpgradeJSmaActivity.mDownloaded;
                        firmwareUpgradeJSmaActivity.mDownloaded = i + 1;
                        FirmwareUpgradeJSmaActivity.this.checkDownload();
                    }
                });
            }
            FirmwareVersion firmwareVersion6 = this.mLatestNetworkFirmware;
            if (firmwareVersion6 != null) {
                NetWorkUtils netWorkUtils3 = NetWorkUtils.INSTANCE;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion6);
                String fileUrl3 = firmwareVersion6.getFileUrl();
                String ooOOo0oXI3 = com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(X00IoxXI.oIX0oI.f3233oIX0oI);
                FirmwareVersion firmwareVersion7 = this.mLatestNetworkFirmware;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion7);
                netWorkUtils3.download(fileUrl3, ooOOo0oXI3, firmwareVersion7.getFileName(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.device.FirmwareUpgradeJSmaActivity$onBottomClick$6
                    @Override // xxxI.II0xO0
                    public void handleError(@OXOo.OOXIXo String error) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI(FirmwareUpgradeJSmaActivity.this.TAG + " download networkfw error -> " + error);
                        FirmwareUpgradeJSmaActivity.this.mDownloaded = 0;
                        FirmwareUpgradeJSmaActivity.this.setMStarted(false);
                    }

                    @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                    public void handleProgress(int i) {
                    }

                    @Override // xxxI.II0xO0
                    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                    public void handleResponse(@OXOo.oOoXoXO String str) {
                        int i;
                        FirmwareUpgradeJSmaActivity firmwareUpgradeJSmaActivity = FirmwareUpgradeJSmaActivity.this;
                        i = firmwareUpgradeJSmaActivity.mDownloaded;
                        firmwareUpgradeJSmaActivity.mDownloaded = i + 1;
                        FirmwareUpgradeJSmaActivity.this.checkDownload();
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
        BleConnector bleConnector = BleConnector.INSTANCE;
        bleConnector.removeHandleCallback(this.mBleHandleCallback);
        if (!this.mSteps.isEmpty() && this.mStepsIndex == CollectionsKt__CollectionsKt.oo0xXOI0I(this.mSteps)) {
            BleCache.remove$default(BleCache.INSTANCE, BleKey.UI_FILE, null, 2, null);
            bleConnector.closeConnection(true);
        }
        jlDestory();
        if (com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24419XO, false)) {
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.XoI0Ixx0.f24419XO, null, 2, null);
        }
        super.onDestroy();
    }

    public final void setUpgradeDoneOTAFile(boolean z) {
        this.isUpgradeDoneOTAFile = z;
    }

    public final void startNetworkOTA(@OXOo.OOXIXo String filePath) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(filePath, "filePath");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " startNetworkOTA -> " + filePath);
        NetworkOpImpl networkOpImpl = this.mNetworkOp;
        if (networkOpImpl != null) {
            WatchManager watchManager = this.mWatchManager;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(watchManager);
            networkOpImpl.startNetworkOTA(watchManager.getConnectedDevice(), new OTAParam(filePath), new X0o0xo());
        }
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
            oTAManager2.startOTA(new XO());
        }
    }

    public final void upgradeDone() {
        if (ProductManager.f20544oIX0oI.o0xIoII()) {
            this.isUpgradeDoneOTAFile = true;
            ToastUtils.showLong(R.string.support_dual_backup_upgrade_successful);
        } else {
            ToastUtils.showLong(R.string.upgrade_successful);
        }
        FirmwareVersion firmwareVersion = this.mLatestFirmware;
        if (firmwareVersion != null) {
            updateDeviceInfo(firmwareVersion.getVersion());
        }
        BaseFirmwareUpgradeActivity.uploadOtaRecord$default(this, "0", null, null, null, null, 30, null);
        finish();
        FirmwareVersion firmwareVersion2 = this.mLatestFirmware;
        if (firmwareVersion2 != null && firmwareVersion2.getFlag() == 2) {
            com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24614XX, Boolean.TRUE);
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24561I0, null, 2, null);
        }
        com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24640ooOx, "done");
    }
}
