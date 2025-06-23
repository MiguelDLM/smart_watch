package com.sma.smartv3.ui.device;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bestmafen.baseble.data.ByteArrayExtKt;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.facebook.login.widget.ToolTipPopup;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.jieli.bluetooth_connect.bean.ErrorInfo;
import com.jieli.bluetooth_connect.bean.ble.BleScanMessage;
import com.jieli.jl_filebrowse.bean.SDCardBean;
import com.jieli.jl_rcsp.interfaces.watch.OnWatchCallback;
import com.jieli.jl_rcsp.task.TaskListener;
import com.jieli.jl_rcsp.task.TransferTask;
import com.jieli.jl_rcsp.task.UriTransferTask;
import com.jieli.watchtesttool.tool.bluetooth.BluetoothEventListener;
import com.jieli.watchtesttool.tool.bluetooth.BluetoothHelper;
import com.jieli.watchtesttool.tool.watch.WatchManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.ui.device.DeviceFileManager;
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
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

@kotlin.jvm.internal.XX({"SMAP\nDeviceFileManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceFileManager.kt\ncom/sma/smartv3/ui/device/DeviceFileManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,510:1\n1855#2,2:511\n*S KotlinDebug\n*F\n+ 1 DeviceFileManager.kt\ncom/sma/smartv3/ui/device/DeviceFileManager\n*L\n419#1:511,2\n*E\n"})
/* loaded from: classes12.dex */
public final class DeviceFileManager {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f21726I0Io = "music";

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f21727II0XooXoX = "AUDTON";

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static int f21729IIXOooo = 0;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static SDCardBean f21730IXxxXO = null;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static WatchManager f21733Oo = null;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f21735Oxx0IOOO = "QURAN";

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static int f21736Oxx0xo = 0;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static TransferTask f21737OxxIIOOXO = null;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f21739X0o0xo = "AUDIOBOOKS";

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f21740XO = "STUDY_CARDS";

    /* renamed from: oO, reason: collision with root package name */
    public static boolean f21744oO = false;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static boolean f21746ooOOo0oXI = false;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f21747oxoX = "EBOOK";

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static boolean f21748x0XOIxOo = false;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static BluetoothHelper f21749x0xO0oo = null;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f21752xxIXOIIO = "EN";

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final DeviceFileManager f21743oIX0oI = new DeviceFileManager();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f21728II0xO0 = "DeviceFileManager";

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f21750xoIox = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CopyOnWriteArrayList<oIX0oI>>() { // from class: com.sma.smartv3.ui.device.DeviceFileManager$mDeviceFileCallbacks$2
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final CopyOnWriteArrayList<DeviceFileManager.oIX0oI> invoke() {
            return new CopyOnWriteArrayList<>();
        }
    });

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Handler f21732OOXIXo = new Handler(Looper.getMainLooper());

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static int f21745oOoXoXO = 1;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static List<ox0I> f21742oI0IIXIo = new ArrayList();

    /* renamed from: xoXoI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final DeviceFileManager$mBtEventListener$1 f21751xoXoI = new BluetoothEventListener() { // from class: com.sma.smartv3.ui.device.DeviceFileManager$mBtEventListener$1
        @Override // com.jieli.watchtesttool.tool.bluetooth.BluetoothEventListener
        public void onAdapterStatus(boolean z) {
            String str;
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            str = DeviceFileManager.f21728II0xO0;
            sb.append(str);
            sb.append(" -> bt onAdapterStatus ");
            sb.append(z);
            oix0oi.oIX0oI(sb.toString());
            DeviceFileManager deviceFileManager = DeviceFileManager.f21743oIX0oI;
            DeviceFileManager.f21744oO = false;
        }

        @Override // com.jieli.watchtesttool.tool.bluetooth.BluetoothEventListener
        public void onBtDiscovery(@OXOo.oOoXoXO BluetoothDevice bluetoothDevice, @OXOo.oOoXoXO BleScanMessage bleScanMessage) {
            String str;
            super.onBtDiscovery(bluetoothDevice, bleScanMessage);
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            str = DeviceFileManager.f21728II0xO0;
            sb.append(str);
            sb.append(" -> bt onBtDiscovery ");
            sb.append(bluetoothDevice);
            oix0oi.oIX0oI(sb.toString());
        }

        @Override // com.jieli.watchtesttool.tool.bluetooth.BluetoothEventListener
        public void onBtDiscoveryStatus(boolean z, boolean z2) {
            String str;
            super.onBtDiscoveryStatus(z, z2);
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            str = DeviceFileManager.f21728II0xO0;
            sb.append(str);
            sb.append(" -> bt onBtDiscoveryStatus ");
            sb.append(z);
            sb.append(TokenParser.SP);
            sb.append(z2);
            oix0oi.oIX0oI(sb.toString());
        }

        @Override // com.jieli.watchtesttool.tool.bluetooth.BluetoothEventListener
        public void onConnection(@OXOo.OOXIXo BluetoothDevice device, final int i) {
            boolean z;
            String str;
            boolean z2;
            kotlin.jvm.internal.IIX0o.x0xO0oo(device, "device");
            DeviceFileManager deviceFileManager = DeviceFileManager.f21743oIX0oI;
            if (i == 2) {
                z = true;
            } else {
                z = false;
            }
            DeviceFileManager.f21744oO = z;
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            str = DeviceFileManager.f21728II0xO0;
            sb.append(str);
            sb.append(" -> bt onConnection ");
            sb.append(device);
            sb.append(TokenParser.SP);
            sb.append(i);
            sb.append(TokenParser.SP);
            z2 = DeviceFileManager.f21744oO;
            sb.append(z2);
            oix0oi.oIX0oI(sb.toString());
            deviceFileManager.XIxXXX0x0(new Oox.oOoXoXO<DeviceFileManager.oIX0oI, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFileManager$mBtEventListener$1$onConnection$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DeviceFileManager.oIX0oI oix0oi2) {
                    invoke2(oix0oi2);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo DeviceFileManager.oIX0oI it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    it.oIX0oI(i);
                }
            });
        }

        @Override // com.jieli.watchtesttool.tool.bluetooth.BluetoothEventListener
        public void onError(@OXOo.oOoXoXO ErrorInfo errorInfo) {
            String str;
            super.onError(errorInfo);
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            str = DeviceFileManager.f21728II0xO0;
            sb.append(str);
            sb.append(" -> bt onError ");
            sb.append(errorInfo);
            oix0oi.oIX0oI(sb.toString());
        }
    };

    /* renamed from: o00, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final DeviceFileManager$mFileTransferTaskCallback$1 f21741o00 = new TaskListener() { // from class: com.sma.smartv3.ui.device.DeviceFileManager$mFileTransferTaskCallback$1

        /* renamed from: II0xO0, reason: collision with root package name */
        @OXOo.OOXIXo
        public String f21753II0xO0 = "";

        /* renamed from: oIX0oI, reason: collision with root package name */
        public long f21754oIX0oI;

        public final void I0Io(long j) {
            this.f21754oIX0oI = j;
        }

        @OXOo.OOXIXo
        public final String II0xO0() {
            return this.f21753II0xO0;
        }

        public final long oIX0oI() {
            return this.f21754oIX0oI;
        }

        @Override // com.jieli.jl_rcsp.task.TaskListener
        public void onBegin() {
            TransferTask transferTask;
            String str;
            String str2;
            TransferTask transferTask2;
            DeviceFileManager deviceFileManager = DeviceFileManager.f21743oIX0oI;
            DeviceFileManager.f21748x0XOIxOo = true;
            transferTask = DeviceFileManager.f21737OxxIIOOXO;
            String str3 = null;
            if (transferTask != null) {
                str = transferTask.getPath();
            } else {
                str = null;
            }
            float length = (((float) new File(str).length()) / 1024.0f) / 1024.0f;
            this.f21754oIX0oI = System.currentTimeMillis();
            kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
            String format = String.format(Locale.getDefault(), "%.2fM", Arrays.copyOf(new Object[]{Float.valueOf(length)}, 1));
            kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
            this.f21753II0xO0 = format;
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            str2 = DeviceFileManager.f21728II0xO0;
            sb.append(str2);
            sb.append(" -> onBegin ");
            sb.append(deviceFileManager.oI0IIXIo());
            sb.append(", name = ");
            transferTask2 = DeviceFileManager.f21737OxxIIOOXO;
            if (transferTask2 != null) {
                str3 = transferTask2.getPath();
            }
            sb.append(new File(str3).getName());
            oix0oi.oIX0oI(sb.toString());
            deviceFileManager.XIxXXX0x0(new Oox.oOoXoXO<DeviceFileManager.oIX0oI, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFileManager$mFileTransferTaskCallback$1$onBegin$1
                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DeviceFileManager.oIX0oI oix0oi2) {
                    invoke2(oix0oi2);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo DeviceFileManager.oIX0oI it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    it.I0Io(DeviceFileManager.f21743oIX0oI.oI0IIXIo());
                }
            });
        }

        @Override // com.jieli.jl_rcsp.task.TaskListener
        public void onCancel(int i) {
            String str;
            TransferTask transferTask;
            String str2;
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            str = DeviceFileManager.f21728II0xO0;
            sb.append(str);
            sb.append(" -> onCancel ");
            DeviceFileManager deviceFileManager = DeviceFileManager.f21743oIX0oI;
            sb.append(deviceFileManager.oI0IIXIo());
            sb.append(", ");
            sb.append(i);
            sb.append(", name = ");
            transferTask = DeviceFileManager.f21737OxxIIOOXO;
            if (transferTask != null) {
                str2 = transferTask.getPath();
            } else {
                str2 = null;
            }
            sb.append(new File(str2).getName());
            oix0oi.oIX0oI(sb.toString());
            DeviceFileManager.f21748x0XOIxOo = false;
            deviceFileManager.XIxXXX0x0(new Oox.oOoXoXO<DeviceFileManager.oIX0oI, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFileManager$mFileTransferTaskCallback$1$onCancel$1
                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DeviceFileManager.oIX0oI oix0oi2) {
                    invoke2(oix0oi2);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo DeviceFileManager.oIX0oI it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    it.XO(DeviceFileManager.f21743oIX0oI.oI0IIXIo());
                }
            });
        }

        @Override // com.jieli.jl_rcsp.task.TaskListener
        public void onError(final int i, @OXOo.OOXIXo final String s) {
            String str;
            int i2;
            boolean z;
            TransferTask transferTask;
            String str2;
            int i3;
            boolean z2;
            String str3;
            int i4;
            Handler handler;
            Runnable runnable;
            kotlin.jvm.internal.IIX0o.x0xO0oo(s, "s");
            kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
            String format = String.format(Locale.getDefault(), "i=%d, s=%s", Arrays.copyOf(new Object[]{Integer.valueOf(i), s}, 2));
            kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            str = DeviceFileManager.f21728II0xO0;
            sb.append(str);
            sb.append(" -> onError autoRetryCount=");
            i2 = DeviceFileManager.f21729IIXOooo;
            sb.append(i2);
            sb.append(", isTransfer=");
            z = DeviceFileManager.f21748x0XOIxOo;
            sb.append(z);
            sb.append(", ");
            DeviceFileManager deviceFileManager = DeviceFileManager.f21743oIX0oI;
            sb.append(deviceFileManager.oI0IIXIo());
            sb.append(", ");
            sb.append(format);
            sb.append(", name = ");
            transferTask = DeviceFileManager.f21737OxxIIOOXO;
            if (transferTask != null) {
                str2 = transferTask.getPath();
            } else {
                str2 = null;
            }
            sb.append(new File(str2).getName());
            oix0oi.oIX0oI(sb.toString());
            i3 = DeviceFileManager.f21729IIXOooo;
            if (i3 < 10) {
                z2 = DeviceFileManager.f21748x0XOIxOo;
                if (z2) {
                    StringBuilder sb2 = new StringBuilder();
                    str3 = DeviceFileManager.f21728II0xO0;
                    sb2.append(str3);
                    sb2.append(" retry watting -> autoRetryCount = ");
                    i4 = DeviceFileManager.f21729IIXOooo;
                    sb2.append(i4);
                    oix0oi.oIX0oI(sb2.toString());
                    handler = DeviceFileManager.f21732OOXIXo;
                    runnable = DeviceFileManager.f21734OxI;
                    handler.postDelayed(runnable, ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
                    return;
                }
            }
            DeviceFileManager.f21748x0XOIxOo = false;
            deviceFileManager.XIxXXX0x0(new Oox.oOoXoXO<DeviceFileManager.oIX0oI, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFileManager$mFileTransferTaskCallback$1$onError$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DeviceFileManager.oIX0oI oix0oi2) {
                    invoke2(oix0oi2);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo DeviceFileManager.oIX0oI it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    it.II0xO0(DeviceFileManager.f21743oIX0oI.oI0IIXIo(), i, s);
                }
            });
        }

        @Override // com.jieli.jl_rcsp.task.TaskListener
        public void onFinish() {
            String str;
            TransferTask transferTask;
            String str2;
            String str3;
            int currentTimeMillis = ((int) (System.currentTimeMillis() - this.f21754oIX0oI)) / 1000;
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            str = DeviceFileManager.f21728II0xO0;
            sb.append(str);
            sb.append(" -> onFinish ");
            DeviceFileManager deviceFileManager = DeviceFileManager.f21743oIX0oI;
            sb.append(deviceFileManager.oI0IIXIo());
            sb.append(", size = ");
            sb.append(this.f21753II0xO0);
            sb.append(", time = ");
            sb.append(currentTimeMillis);
            sb.append(" s, name = ");
            transferTask = DeviceFileManager.f21737OxxIIOOXO;
            if (transferTask != null) {
                str2 = transferTask.getPath();
            } else {
                str2 = null;
            }
            sb.append(new File(str2).getName());
            oix0oi.oIX0oI(sb.toString());
            if (deviceFileManager.oI0IIXIo() < deviceFileManager.xoXoI().size() - 1) {
                deviceFileManager.XIxXXX0x0(new Oox.oOoXoXO<DeviceFileManager.oIX0oI, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFileManager$mFileTransferTaskCallback$1$onFinish$1
                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DeviceFileManager.oIX0oI oix0oi2) {
                        invoke2(oix0oi2);
                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OXOo.OOXIXo DeviceFileManager.oIX0oI it) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                        it.X0o0xo(DeviceFileManager.f21743oIX0oI.oI0IIXIo(), false);
                    }
                });
                deviceFileManager.xI(deviceFileManager.oI0IIXIo() + 1);
                deviceFileManager.X00IoxXI(deviceFileManager.IIXOooo());
                return;
            }
            DeviceFileManager.f21748x0XOIxOo = false;
            StringBuilder sb2 = new StringBuilder();
            str3 = DeviceFileManager.f21728II0xO0;
            sb2.append(str3);
            sb2.append(" -> onFileTransferFinish");
            oix0oi.oIX0oI(sb2.toString());
            deviceFileManager.XIxXXX0x0(new Oox.oOoXoXO<DeviceFileManager.oIX0oI, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFileManager$mFileTransferTaskCallback$1$onFinish$2
                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DeviceFileManager.oIX0oI oix0oi2) {
                    invoke2(oix0oi2);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo DeviceFileManager.oIX0oI it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    it.X0o0xo(DeviceFileManager.f21743oIX0oI.oI0IIXIo(), true);
                }
            });
        }

        @Override // com.jieli.jl_rcsp.task.TaskListener
        public void onProgress(final int i) {
            String str;
            TransferTask transferTask;
            String str2;
            DeviceFileManager deviceFileManager = DeviceFileManager.f21743oIX0oI;
            DeviceFileManager.f21729IIXOooo = 0;
            int currentTimeMillis = ((int) (System.currentTimeMillis() - this.f21754oIX0oI)) / 1000;
            StringBuilder sb = new StringBuilder();
            str = DeviceFileManager.f21728II0xO0;
            sb.append(str);
            sb.append(" -> onProgress ");
            sb.append(deviceFileManager.oI0IIXIo());
            sb.append(TokenParser.SP);
            sb.append(i);
            sb.append(", size = ");
            sb.append(this.f21753II0xO0);
            sb.append(", time = ");
            sb.append(currentTimeMillis);
            sb.append(" s, name = ");
            transferTask = DeviceFileManager.f21737OxxIIOOXO;
            if (transferTask != null) {
                str2 = transferTask.getPath();
            } else {
                str2 = null;
            }
            sb.append(new File(str2).getName());
            LogUtils.d(sb.toString());
            deviceFileManager.XIxXXX0x0(new Oox.oOoXoXO<DeviceFileManager.oIX0oI, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFileManager$mFileTransferTaskCallback$1$onProgress$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DeviceFileManager.oIX0oI oix0oi) {
                    invoke2(oix0oi);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo DeviceFileManager.oIX0oI it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    it.oxoX(DeviceFileManager.f21743oIX0oI.oI0IIXIo(), i);
                }
            });
        }

        public final void oxoX(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
            this.f21753II0xO0 = str;
        }
    };

    /* renamed from: OxI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Runnable f21734OxI = new Runnable() { // from class: com.sma.smartv3.ui.device.ooXIXxIX
        @Override // java.lang.Runnable
        public final void run() {
            DeviceFileManager.XI0IXoo();
        }
    };

    /* renamed from: O0xOxO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final I0Io f21731O0xOxO = new I0Io();

    /* renamed from: X0IIOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final II0xO0 f21738X0IIOO = new II0xO0();

    /* loaded from: classes12.dex */
    public static final class I0Io extends OnWatchCallback {
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements BleHandleCallback {
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
            if (!ProductManager.f20544oIX0oI.OOOI() && i == 2) {
                BleConnector.INSTANCE.unbindClassic(BleCache.INSTANCE.getMClassicAddress());
            }
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onCommandReply(@OXOo.OOXIXo BleKey bleKey, @OXOo.OOXIXo BleKeyFlag bleKeyFlag, boolean z) {
            BleHandleCallback.DefaultImpls.onCommandReply(this, bleKey, bleKeyFlag, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onCommandSendTimeout(@OXOo.OOXIXo BleKey bleKey, @OXOo.OOXIXo BleKeyFlag bleKeyFlag) {
            BleHandleCallback.DefaultImpls.onCommandSendTimeout(this, bleKey, bleKeyFlag);
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
            BleHandleCallback.DefaultImpls.onSessionStateChange(this, z);
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
            BleHandleCallback.DefaultImpls.onStreamProgress(this, z, i, i2, i3, bleKey);
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
    public interface oIX0oI {

        /* renamed from: com.sma.smartv3.ui.device.DeviceFileManager$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public static final class C0943oIX0oI {
            public static void I0Io(@OXOo.OOXIXo oIX0oI oix0oi, int i, int i2, @OXOo.OOXIXo String msg) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(msg, "msg");
            }

            public static void II0xO0(@OXOo.OOXIXo oIX0oI oix0oi, int i) {
            }

            public static void X0o0xo(@OXOo.OOXIXo oIX0oI oix0oi, int i, int i2) {
            }

            public static void XO(@OXOo.OOXIXo oIX0oI oix0oi, int i) {
            }

            public static void oIX0oI(@OXOo.OOXIXo oIX0oI oix0oi, int i) {
            }

            public static void oxoX(@OXOo.OOXIXo oIX0oI oix0oi, int i, boolean z) {
            }
        }

        void I0Io(int i);

        void II0xO0(int i, int i2, @OXOo.OOXIXo String str);

        void X0o0xo(int i, boolean z);

        void XO(int i);

        void oIX0oI(int i);

        void oxoX(int i, int i2);
    }

    public static final void XI0IXoo() {
        f21729IIXOooo++;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(f21728II0xO0 + " retry -> autoRetryCount = " + f21729IIXOooo);
        f21743oIX0oI.xXxxox0I();
    }

    public static final void xxX(Oox.oOoXoXO action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "$action");
        for (oIX0oI oix0oi : f21743oIX0oI.OxxIIOOXO()) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oix0oi);
            action.invoke(oix0oi);
        }
    }

    public final void IIX0o(boolean z) {
        f21746ooOOo0oXI = z;
    }

    @OXOo.oOoXoXO
    public final SDCardBean IIXOooo() {
        return f21730IXxxXO;
    }

    public final void IO() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(f21728II0xO0 + " -> stopTransfer " + f21736Oxx0xo);
        TransferTask transferTask = f21737OxxIIOOXO;
        if (transferTask != null) {
            transferTask.cancel((byte) 0);
        }
        f21748x0XOIxOo = false;
        f21732OOXIXo.removeCallbacks(f21734OxI);
    }

    public final void IXxxXO() {
        f21746ooOOo0oXI = false;
        WatchManager watchManager = f21733Oo;
        if (watchManager != null) {
            watchManager.unregisterOnWatchCallback(f21731O0xOxO);
        }
        WatchManager watchManager2 = f21733Oo;
        if (watchManager2 != null) {
            watchManager2.release();
        }
        f21733Oo = null;
        BluetoothHelper bluetoothHelper = f21749x0xO0oo;
        if (bluetoothHelper != null) {
            bluetoothHelper.removeBluetoothEventListener(f21751xoXoI);
        }
        BluetoothHelper bluetoothHelper2 = f21749x0xO0oo;
        if (bluetoothHelper2 != null) {
            bluetoothHelper2.destroy();
        }
        f21749x0xO0oo = null;
        f21748x0XOIxOo = false;
        f21744oO = false;
        if (!ProductManager.f20544oIX0oI.OOOI()) {
            BleConnector bleConnector = BleConnector.INSTANCE;
            if (bleConnector.isAvailable()) {
                BleConnector.sendInt8$default(bleConnector, BleKey.CLASSIC_BLUETOOTH_STATE, BleKeyFlag.UPDATE, 0, false, false, 24, null);
            } else {
                bleConnector.unbindClassic(BleCache.INSTANCE.getMClassicAddress());
            }
        }
    }

    public final void IoOoX(@OXOo.OOXIXo ox0I list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(f21728II0xO0 + " -> setTransferFiles " + list);
        f21736Oxx0xo = 0;
        if (f21742oI0IIXIo == null) {
            f21742oI0IIXIo = new ArrayList();
        }
        f21742oI0IIXIo.clear();
        f21742oI0IIXIo.add(list);
    }

    public final boolean O0xOxO() {
        return f21746ooOOo0oXI;
    }

    public final TransferTask Oo(WatchManager watchManager, SDCardBean sDCardBean, String str, String str2, String str3) {
        boolean z;
        TransferTask.Param param = new TransferTask.Param();
        param.encodeType = StandardCharsets.UTF_16LE.displayName();
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        sb.append(f21728II0xO0);
        sb.append(" -> createTask title: ");
        sb.append(str3);
        sb.append(", ");
        byte[] bytes = str3.getBytes(kotlin.text.oxoX.f29583X0o0xo);
        kotlin.jvm.internal.IIX0o.oO(bytes, "getBytes(...)");
        sb.append(ByteArrayExtKt.getMHexString(bytes));
        oix0oi.oIX0oI(sb.toString());
        param.devHandler = sDCardBean.getDevHandler();
        if (sDCardBean.getType() != 4 && sDCardBean.getType() != 2) {
            z = false;
        } else {
            z = true;
        }
        param.useFlash = z;
        param.isOtherEncode = true;
        if (Build.VERSION.SDK_INT > 28) {
            return new UriTransferTask(Utils.getApp(), watchManager, str2, str3, param);
        }
        return new TransferTask(watchManager, str, param);
    }

    public final boolean OxI() {
        return f21744oO;
    }

    public final int Oxx0xo() {
        return f21745oOoXoXO;
    }

    public final CopyOnWriteArrayList<oIX0oI> OxxIIOOXO() {
        return (CopyOnWriteArrayList) f21750xoIox.getValue();
    }

    public final void X00IoxXI(@OXOo.oOoXoXO SDCardBean sDCardBean) {
        try {
            f21730IXxxXO = sDCardBean;
            if (sDCardBean != null) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(f21728II0xO0 + " -> startTransfer " + f21736Oxx0xo);
                String II0XooXoX2 = f21742oI0IIXIo.get(f21736Oxx0xo).II0XooXoX();
                String Oxx0IOOO2 = f21742oI0IIXIo.get(f21736Oxx0xo).Oxx0IOOO();
                String XO2 = f21742oI0IIXIo.get(f21736Oxx0xo).XO();
                TransferTask transferTask = f21737OxxIIOOXO;
                if (transferTask != null) {
                    if (transferTask != null) {
                        transferTask.release();
                    }
                    f21737OxxIIOOXO = null;
                }
                WatchManager watchManager = f21733Oo;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(watchManager);
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(sDCardBean);
                TransferTask Oo2 = Oo(watchManager, sDCardBean, II0XooXoX2, Oxx0IOOO2, XO2);
                f21737OxxIIOOXO = Oo2;
                if (Oo2 != null) {
                    Oo2.setListener(f21741o00);
                }
                TransferTask transferTask2 = f21737OxxIIOOXO;
                if (transferTask2 != null) {
                    transferTask2.start();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final boolean X0IIOO() {
        return f21748x0XOIxOo;
    }

    public final void XIxXXX0x0(final Oox.oOoXoXO<? super oIX0oI, kotlin.oXIO0o0XI> oooxoxo) {
        f21732OOXIXo.post(new Runnable() { // from class: com.sma.smartv3.ui.device.IIX0o
            @Override // java.lang.Runnable
            public final void run() {
                DeviceFileManager.xxX(Oox.oOoXoXO.this);
            }
        });
    }

    public final void Xx000oIo(@OXOo.oOoXoXO SDCardBean sDCardBean) {
        f21730IXxxXO = sDCardBean;
        if (sDCardBean != null) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(f21728II0xO0 + " -> startTransfer " + f21736Oxx0xo);
            String II0XooXoX2 = f21742oI0IIXIo.get(f21736Oxx0xo).II0XooXoX();
            String Oxx0IOOO2 = f21742oI0IIXIo.get(f21736Oxx0xo).Oxx0IOOO();
            String XO2 = f21742oI0IIXIo.get(f21736Oxx0xo).XO();
            TransferTask transferTask = f21737OxxIIOOXO;
            if (transferTask != null) {
                if (transferTask != null) {
                    transferTask.release();
                }
                f21737OxxIIOOXO = null;
            }
            WatchManager watchManager = f21733Oo;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(watchManager);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(sDCardBean);
            TransferTask x0xO0oo2 = x0xO0oo(watchManager, sDCardBean, II0XooXoX2, Oxx0IOOO2, XO2);
            f21737OxxIIOOXO = x0xO0oo2;
            if (x0xO0oo2 != null) {
                x0xO0oo2.setListener(f21741o00);
            }
            TransferTask transferTask2 = f21737OxxIIOOXO;
            if (transferTask2 != null) {
                transferTask2.start();
            }
        }
    }

    public final void XxX0x0xxx(@OXOo.OOXIXo oIX0oI onDeviceFileListner) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(onDeviceFileListner, "onDeviceFileListner");
        OxxIIOOXO().remove(onDeviceFileListner);
    }

    public final void o00(@OXOo.OOXIXo Application app) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(app, "app");
        if (f21746ooOOo0oXI) {
            return;
        }
        BluetoothHelper bluetoothHelper = BluetoothHelper.getInstance(app);
        f21749x0xO0oo = bluetoothHelper;
        if (bluetoothHelper != null) {
            bluetoothHelper.addBluetoothEventListener(f21751xoXoI);
        }
        WatchManager watchManager = WatchManager.getInstance(app);
        f21733Oo = watchManager;
        if (watchManager != null) {
            watchManager.registerOnWatchCallback(f21731O0xOxO);
        }
        f21746ooOOo0oXI = true;
        BleConnector bleConnector = BleConnector.INSTANCE;
        II0xO0 iI0xO0 = f21738X0IIOO;
        if (!bleConnector.isHandlerCallbackExist(iI0xO0)) {
            bleConnector.addHandleCallback(iI0xO0);
        }
    }

    public final int oI0IIXIo() {
        return f21736Oxx0xo;
    }

    public final void oO() {
        String mClassicAddress;
        BluetoothDevice bluetoothDevice;
        if (!ProductManager.f20544oIX0oI.OOOI()) {
            BleConnector.sendInt8$default(BleConnector.INSTANCE, BleKey.CLASSIC_BLUETOOTH_STATE, BleKeyFlag.UPDATE, 1, false, false, 24, null);
        }
        BleCache bleCache = BleCache.INSTANCE;
        if (TextUtils.isEmpty(bleCache.getMClassicAddress())) {
            f21745oOoXoXO = 0;
            mClassicAddress = bleCache.getMBleAddress();
        } else {
            f21745oOoXoXO = 1;
            mClassicAddress = bleCache.getMClassicAddress();
        }
        if (TextUtils.isEmpty(mClassicAddress)) {
            return;
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(f21728II0xO0 + " -> connectDevice " + mClassicAddress + ", " + f21745oOoXoXO);
        BluetoothHelper bluetoothHelper = f21749x0xO0oo;
        if (bluetoothHelper != null) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                bluetoothDevice = defaultAdapter.getRemoteDevice(mClassicAddress);
            } else {
                bluetoothDevice = null;
            }
            bluetoothHelper.connectDevice(bluetoothDevice, f21745oOoXoXO);
        }
    }

    public final void oOXoIIIo(@OXOo.OOXIXo List<ox0I> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(f21728II0xO0 + " -> setTransferFiles " + list);
        f21736Oxx0xo = 0;
        if (f21742oI0IIXIo == null) {
            f21742oI0IIXIo = new ArrayList();
        }
        f21742oI0IIXIo.clear();
        f21742oI0IIXIo.addAll(list);
    }

    public final void oo(@OXOo.OOXIXo List<ox0I> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<set-?>");
        f21742oI0IIXIo = list;
    }

    public final void oo0xXOI0I(@OXOo.oOoXoXO SDCardBean sDCardBean) {
        f21730IXxxXO = sDCardBean;
    }

    public final void ooXIXxIX(int i) {
        f21745oOoXoXO = i;
    }

    public final void x0XOIxOo(@OXOo.OOXIXo oIX0oI onDeviceFileListner) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(onDeviceFileListner, "onDeviceFileListner");
        OxxIIOOXO().add(onDeviceFileListner);
    }

    public final TransferTask x0xO0oo(WatchManager watchManager, SDCardBean sDCardBean, String str, String str2, String str3) {
        boolean z;
        TransferTask.Param param = new TransferTask.Param();
        param.encodeType = StandardCharsets.UTF_8.displayName();
        param.devHandler = sDCardBean.getDevHandler();
        if (sDCardBean.getType() != 4 && sDCardBean.getType() != 2) {
            z = false;
        } else {
            z = true;
        }
        param.useFlash = z;
        if (Build.VERSION.SDK_INT > 28) {
            return new UriTransferTask(Utils.getApp(), watchManager, str2, str3, param);
        }
        return new TransferTask(watchManager, str, param);
    }

    public final void xI(int i) {
        f21736Oxx0xo = i;
    }

    public final void xXxxox0I() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(f21728II0xO0 + " -> resumeTransfer " + f21736Oxx0xo + TokenParser.SP + X0IIOO());
        X00IoxXI(f21730IXxxXO);
    }

    @OXOo.OOXIXo
    public final List<ox0I> xoXoI() {
        return f21742oI0IIXIo;
    }
}
