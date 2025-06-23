package com.sma.smartv3.initializer;

import android.annotation.SuppressLint;
import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.media.session.MediaSessionManager;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Vibrator;
import android.provider.ContactsContract;
import android.telecom.TelecomManager;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.bestmafen.androidbase.extension.PermissionStatus;
import com.bestmafen.baseble.data.ByteArrayExtKt;
import com.bestmafen.baseble.util.LogLevel;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.garmin.fit.xxXXXxIxo;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.material.timepicker.TimeModel;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.kuaishou.weapon.p0.bq;
import com.kuaishou.weapon.p0.g;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.AIWatchFaceManager;
import com.sma.smartv3.biz.DeviceInfoChecker;
import com.sma.smartv3.biz.dcs.DcsToken;
import com.sma.smartv3.biz.fitness_site.FunctionKt;
import com.sma.smartv3.ble.BleConnectStateManager;
import com.sma.smartv3.ble.MyNotificationListenerService;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.ActivityDao;
import com.sma.smartv3.db.dao.AlipayBindInfoDao;
import com.sma.smartv3.db.dao.BloodGlucoseDao;
import com.sma.smartv3.db.dao.BloodOxygenDao;
import com.sma.smartv3.db.dao.BloodPressureDao;
import com.sma.smartv3.db.dao.DailyPowerDao;
import com.sma.smartv3.db.dao.ElectrocardiogramDao;
import com.sma.smartv3.db.dao.HanBaoVibrationDao;
import com.sma.smartv3.db.dao.HeartRateDao;
import com.sma.smartv3.db.dao.HrvDao;
import com.sma.smartv3.db.dao.LocationDao;
import com.sma.smartv3.db.dao.MatchRecordDao;
import com.sma.smartv3.db.dao.PressureDao;
import com.sma.smartv3.db.dao.SleepDao;
import com.sma.smartv3.db.dao.TemperatureDao;
import com.sma.smartv3.db.dao.WorkoutDao;
import com.sma.smartv3.db.dao.WorkoutIndexDao;
import com.sma.smartv3.db.entity.Activity;
import com.sma.smartv3.db.entity.AlipayBindInfo;
import com.sma.smartv3.db.entity.BloodGlucose;
import com.sma.smartv3.db.entity.BloodOxygen;
import com.sma.smartv3.db.entity.BloodPressure;
import com.sma.smartv3.db.entity.DailyPower;
import com.sma.smartv3.db.entity.HanBaoVibration;
import com.sma.smartv3.db.entity.HeartRate;
import com.sma.smartv3.db.entity.Hrv;
import com.sma.smartv3.db.entity.Location;
import com.sma.smartv3.db.entity.MatchPeriod;
import com.sma.smartv3.db.entity.MatchRecord;
import com.sma.smartv3.db.entity.Pressure;
import com.sma.smartv3.db.entity.Sleep;
import com.sma.smartv3.db.entity.Temperature;
import com.sma.smartv3.db.entity.Workout;
import com.sma.smartv3.db.entity.WorkoutIndex;
import com.sma.smartv3.model.DeviceConfigInfo;
import com.sma.smartv3.model.PrayerTimeSettings;
import com.sma.smartv3.model.PrayerTimesKt;
import com.sma.smartv3.ui.device.X00xOoXI;
import com.sma.smartv3.util.DateTimeFormat;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.ooXIXxIX;
import com.sma.smartv3.util.permission.PermissionHelper;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.component.BleConstsKt;
import com.szabh.smable3.component.BleHandleCallback;
import com.szabh.smable3.entity.BleAICoachBeforePlan;
import com.szabh.smable3.entity.BleAICoachGeneratePlan;
import com.szabh.smable3.entity.BleActivity;
import com.szabh.smable3.entity.BleActivityDetail;
import com.szabh.smable3.entity.BleAgpsPrerequisite;
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
import com.szabh.smable3.entity.BleNotification;
import com.szabh.smable3.entity.BleNotification2;
import com.szabh.smable3.entity.BleNotificationSettings;
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
import com.szabh.smable3.entity.BleSMSQuickReplyContent;
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
import com.szabh.smable3.entity.BleTime;
import com.szabh.smable3.entity.BleTimeZone;
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
import com.szabh.smable3.entity.Languages;
import com.szabh.smable3.entity.MusicCommand;
import java.io.File;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.XIxXXX0x0;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.StringsKt__StringsKt;

@XX({"SMAP\nBleInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2140:1\n27#2,2:2141\n27#2,2:2143\n15#2:2149\n18#2,2:2150\n15#2:2152\n1549#3:2145\n1620#3,3:2146\n*S KotlinDebug\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer\n*L\n1356#1:2141,2\n1382#1:2143,2\n1998#1:2149\n2065#1:2150,2\n2065#1:2152\n1731#1:2145\n1731#1:2146,3\n*E\n"})
/* loaded from: classes12.dex */
public final class BleInitializer implements com.bestmafen.androidbase.base.II0xO0, BleHandleCallback {

    /* renamed from: I0X0x0oIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f20680I0X0x0oIo;

    /* renamed from: I0oOIX, reason: collision with root package name */
    public static long f20681I0oOIX = 0;

    /* renamed from: I0oOoX, reason: collision with root package name */
    public static int f20682I0oOoX = 0;

    /* renamed from: IO, reason: collision with root package name */
    public static boolean f20685IO = false;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f20686IXxxXO = 140;

    /* renamed from: Io, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static BleNotification f20687Io = null;

    /* renamed from: IoOoX, reason: collision with root package name */
    public static boolean f20688IoOoX = false;

    /* renamed from: O0Xx, reason: collision with root package name */
    public static long f20689O0Xx = 0;

    /* renamed from: OI0, reason: collision with root package name */
    public static boolean f20691OI0 = false;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20692Oo = "BleInitializer";

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public static long f20696X00IoxXI;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public static int f20701XOxIOxOx;

    /* renamed from: XX, reason: collision with root package name */
    public static int f20702XX;

    /* renamed from: XX0, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static MediaPlayer f20703XX0;

    /* renamed from: Xo0, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static com.sma.smartv3.location.oxoX f20704Xo0;

    /* renamed from: XoI0Ixx0, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static com.sma.smartv3.location.oxoX f20705XoI0Ixx0;

    /* renamed from: XoX, reason: collision with root package name */
    public static final Uri f20706XoX;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public static boolean f20707Xx000oIo;

    /* renamed from: o0, reason: collision with root package name */
    public static long f20709o0;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public static boolean f20712oOXoIIIo;

    /* renamed from: oX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f20713oX;

    /* renamed from: oo, reason: collision with root package name */
    public static boolean f20714oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Handler f20715oo0xXOI0I;

    /* renamed from: oxXx0IX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final II0xO0 f20717oxXx0IX;

    /* renamed from: oxxXoxO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f20718oxxXoxO;

    /* renamed from: x0o, reason: collision with root package name */
    public static boolean f20719x0o;

    /* renamed from: xII, reason: collision with root package name */
    public static boolean f20721xII;

    /* renamed from: xXOx, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f20722xXOx;

    /* renamed from: xo0x, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final long[] f20724xo0x;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final BleInitializer f20700XO = new BleInitializer();

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f20694Oxx0xo = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ActivityDao>() { // from class: com.sma.smartv3.initializer.BleInitializer$mActivityDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final ActivityDao invoke() {
            return MyDb.INSTANCE.getMDatabase().activityDao();
        }
    });

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f20711oI0IIXIo = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<HeartRateDao>() { // from class: com.sma.smartv3.initializer.BleInitializer$mHeartRateDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final HeartRateDao invoke() {
            return MyDb.INSTANCE.getMDatabase().heartRateDao();
        }
    });

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f20695OxxIIOOXO = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<BloodPressureDao>() { // from class: com.sma.smartv3.initializer.BleInitializer$mBloodPressureDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final BloodPressureDao invoke() {
            return MyDb.INSTANCE.getMDatabase().bloodPressureDao();
        }
    });

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f20684IIXOooo = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SleepDao>() { // from class: com.sma.smartv3.initializer.BleInitializer$mSleepDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final SleepDao invoke() {
            return MyDb.INSTANCE.getMDatabase().sleepDao();
        }
    });

    /* renamed from: xoXoI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f20725xoXoI = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WorkoutDao>() { // from class: com.sma.smartv3.initializer.BleInitializer$mWorkoutDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final WorkoutDao invoke() {
            return MyDb.INSTANCE.getMDatabase().workoutDao();
        }
    });

    /* renamed from: o00, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f20710o00 = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LocationDao>() { // from class: com.sma.smartv3.initializer.BleInitializer$mLocationDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final LocationDao invoke() {
            return MyDb.INSTANCE.getMDatabase().locationDao();
        }
    });

    /* renamed from: OxI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f20693OxI = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TemperatureDao>() { // from class: com.sma.smartv3.initializer.BleInitializer$mTemperatureDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final TemperatureDao invoke() {
            return MyDb.INSTANCE.getMDatabase().temperatureDao();
        }
    });

    /* renamed from: O0xOxO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f20690O0xOxO = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WorkoutIndexDao>() { // from class: com.sma.smartv3.initializer.BleInitializer$mWorkoutIndexDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final WorkoutIndexDao invoke() {
            return MyDb.INSTANCE.getMDatabase().workoutIndexDao();
        }
    });

    /* renamed from: X0IIOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f20697X0IIOO = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<BloodOxygenDao>() { // from class: com.sma.smartv3.initializer.BleInitializer$mBloodOxygenDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final BloodOxygenDao invoke() {
            return MyDb.INSTANCE.getMDatabase().bloodOxygenDao();
        }
    });

    /* renamed from: XI0IXoo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f20698XI0IXoo = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<HrvDao>() { // from class: com.sma.smartv3.initializer.BleInitializer$mHrvDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final HrvDao invoke() {
            return MyDb.INSTANCE.getMDatabase().hrvDao();
        }
    });

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f20699XIxXXX0x0 = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PressureDao>() { // from class: com.sma.smartv3.initializer.BleInitializer$mPressureDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final PressureDao invoke() {
            return MyDb.INSTANCE.getMDatabase().pressureDao();
        }
    });

    /* renamed from: xxX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f20726xxX = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<MatchRecordDao>() { // from class: com.sma.smartv3.initializer.BleInitializer$mMatchRecordDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final MatchRecordDao invoke() {
            return MyDb.INSTANCE.getMDatabase().matchRecordDao();
        }
    });

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f20708XxX0x0xxx = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<BloodGlucoseDao>() { // from class: com.sma.smartv3.initializer.BleInitializer$mBloodGlucoseDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final BloodGlucoseDao invoke() {
            return MyDb.INSTANCE.getMDatabase().bloodGlucoseDao();
        }
    });

    /* renamed from: xXxxox0I, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f20723xXxxox0I = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AlipayBindInfoDao>() { // from class: com.sma.smartv3.initializer.BleInitializer$mAlipayBindInfoDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final AlipayBindInfoDao invoke() {
            return MyDb.INSTANCE.getMDatabase().alipayBindInfoDao();
        }
    });

    /* renamed from: IIX0o, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f20683IIX0o = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ElectrocardiogramDao>() { // from class: com.sma.smartv3.initializer.BleInitializer$mElectrocardiogramDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final ElectrocardiogramDao invoke() {
            return MyDb.INSTANCE.getMDatabase().electrocardiogramDao();
        }
    });

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f20716ooXIXxIX = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<HanBaoVibrationDao>() { // from class: com.sma.smartv3.initializer.BleInitializer$mHanBaoVibrationDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final HanBaoVibrationDao invoke() {
            return MyDb.INSTANCE.getMDatabase().hanBaoVibrationDao();
        }
    });

    /* renamed from: xI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f20720xI = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DailyPowerDao>() { // from class: com.sma.smartv3.initializer.BleInitializer$mDailyPowerDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final DailyPowerDao invoke() {
            return MyDb.INSTANCE.getMDatabase().dailyPowerDao();
        }
    });

    /* loaded from: classes12.dex */
    public static final class I0Io implements com.sma.smartv3.location.II0xO0 {
        @Override // com.sma.smartv3.location.II0xO0
        public void oIX0oI(@OXOo.OOXIXo com.sma.smartv3.location.oIX0oI location) {
            IIX0o.x0xO0oo(location, "location");
            LogUtils.d("agpsLocationClient onLocationChange longitude: " + location.I0Io() + ", latitude: " + location.II0xO0() + ", altitude: " + location.oIX0oI());
            if (location.oIX0oI() == Double.MIN_VALUE) {
                return;
            }
            BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.AGPS_PREREQUISITE, BleKeyFlag.UPDATE, new BleAgpsPrerequisite((float) location.I0Io(), (float) location.II0xO0(), (int) location.oIX0oI()), false, false, 24, null);
            BleInitializer.f20700XO.xXoOI00O();
        }

        @Override // com.sma.smartv3.location.II0xO0
        public void onError(@OXOo.OOXIXo String message) {
            IIX0o.x0xO0oo(message, "message");
            LogUtils.d("agpsLocationClient onError ");
            BleInitializer.f20700XO.xXoOI00O();
        }
    }

    @XX({"SMAP\nBleInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadBloodPressure$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2140:1\n1549#2:2141\n1620#2,3:2142\n*S KotlinDebug\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadBloodPressure$1\n*L\n583#1:2141\n583#1:2142,3\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class II0XooXoX extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ Date f20727IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ long f20728Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20729Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ List<BleBloodPressure> f20730XO;

        public II0XooXoX(List<BleBloodPressure> list, long j, Date date, SimpleDateFormat simpleDateFormat) {
            this.f20730XO = list;
            this.f20728Oo = j;
            this.f20727IXxxXO = date;
            this.f20729Oxx0xo = simpleDateFormat;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@OXOo.oOoXoXO Void r1) {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @OXOo.oOoXoXO
        public Void doInBackground() {
            BloodPressureDao XX2 = BleInitializer.f20700XO.XX();
            List<BleBloodPressure> list = this.f20730XO;
            long j = this.f20728Oo;
            Date date = this.f20727IXxxXO;
            SimpleDateFormat simpleDateFormat = this.f20729Oxx0xo;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                BloodPressure bloodPressure = new BloodPressure((BleBloodPressure) it.next(), j);
                date.setTime(bloodPressure.getMTime());
                String format = simpleDateFormat.format(date);
                IIX0o.oO(format, "format(...)");
                bloodPressure.setMLocalTime(format);
                arrayList.add(bloodPressure);
            }
            XX2.insert(arrayList);
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24562I0Io, null, 2, null);
            return null;
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 extends ContentObserver {
        public II0xO0(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            LogUtils.v("BleInitializer SmsObserver onChange -> selfChange=" + z);
            super.onChange(z);
            Xo0 xo0 = Xo0.f24349oIX0oI;
            if (!xo0.I0Io().getBoolean(XoI0Ixx0.f24352I0Io)) {
                return;
            }
            BleConnector bleConnector = BleConnector.INSTANCE;
            if (!bleConnector.isAvailable()) {
                return;
            }
            String[] II0xO02 = X00xOoXI.II0xO0();
            if (!PermissionUtils.isGranted((String[]) Arrays.copyOf(II0xO02, II0xO02.length))) {
                return;
            }
            long j = xo0.I0Io().getLong(XoI0Ixx0.f24392OOXIXo, -1L);
            Cursor query = Utils.getApp().getContentResolver().query(BleInitializer.f20706XoX, null, "read = 0 and type = 1 and _id > " + j, null, "_id desc");
            if (query != null) {
                Cursor cursor = query;
                try {
                    Cursor cursor2 = cursor;
                    if (cursor2.moveToNext()) {
                        xo0.I0Io().put(XoI0Ixx0.f24392OOXIXo, cursor2.getLong(cursor2.getColumnIndex("_id")));
                        BleInitializer bleInitializer = BleInitializer.f20700XO;
                        bleInitializer.x0OIX00oO(true);
                        bleInitializer.XXoOx0(System.currentTimeMillis());
                        String string = cursor2.getString(cursor2.getColumnIndex("address"));
                        String string2 = cursor2.getString(cursor2.getColumnIndex("body"));
                        if (ProductManager.f20544oIX0oI.X0OXX() && !TextUtils.isEmpty(string)) {
                            long time = new Date().getTime();
                            IIX0o.ooOOo0oXI(string);
                            String X00IoxXI2 = bleInitializer.X00IoxXI(string);
                            IIX0o.ooOOo0oXI(string2);
                            BleNotification2 bleNotification2 = new BleNotification2(127, time, "com.android.mms", X00IoxXI2, string, string2);
                            OI0.oIX0oI.f1507oIX0oI.XO("BleInitializer SmsObserver onChange -> notification2=" + bleNotification2);
                            BleConnector.sendObject$default(bleConnector, BleKey.NOTIFICATION2, BleKeyFlag.UPDATE, bleNotification2, false, false, 24, null);
                        } else {
                            long time2 = new Date().getTime();
                            IIX0o.ooOOo0oXI(string);
                            String X00IoxXI3 = bleInitializer.X00IoxXI(string);
                            IIX0o.ooOOo0oXI(string2);
                            BleNotification bleNotification = new BleNotification(127, time2, "com.android.mms", X00IoxXI3, string2);
                            OI0.oIX0oI.f1507oIX0oI.XO("BleInitializer SmsObserver onChange -> notification=" + bleNotification);
                            BleConnector.sendObject$default(bleConnector, BleKey.NOTIFICATION, BleKeyFlag.UPDATE, bleNotification, false, false, 24, null);
                        }
                    }
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    kotlin.io.II0xO0.oIX0oI(cursor, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        kotlin.io.II0xO0.oIX0oI(cursor, th);
                        throw th2;
                    }
                }
            }
        }
    }

    @XX({"SMAP\nBleInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReceiveGSensorSHSY$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2140:1\n1864#2,3:2141\n*S KotlinDebug\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReceiveGSensorSHSY$1\n*L\n1903#1:2141,3\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class IIXOooo extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20731IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Calendar f20732Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20733Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ List<BleGSensorSHSY> f20734XO;

        public IIXOooo(List<BleGSensorSHSY> list, Calendar calendar, SimpleDateFormat simpleDateFormat, SimpleDateFormat simpleDateFormat2) {
            this.f20734XO = list;
            this.f20732Oo = calendar;
            this.f20731IXxxXO = simpleDateFormat;
            this.f20733Oxx0xo = simpleDateFormat2;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@OXOo.oOoXoXO Void r1) {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @OXOo.oOoXoXO
        public Void doInBackground() {
            try {
                List<BleGSensorSHSY> list = this.f20734XO;
                Calendar calendar = this.f20732Oo;
                SimpleDateFormat simpleDateFormat = this.f20731IXxxXO;
                SimpleDateFormat simpleDateFormat2 = this.f20733Oxx0xo;
                int i = 0;
                for (Object obj : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt__CollectionsKt.XoX();
                    }
                    BleGSensorSHSY bleGSensorSHSY = (BleGSensorSHSY) obj;
                    long timeInMillis = calendar.getTimeInMillis() + bleGSensorSHSY.getMTime();
                    if (i == 0) {
                        BleInitializer bleInitializer = BleInitializer.f20700XO;
                        if (bleInitializer.xII() == 0) {
                            bleInitializer.IoIOOxIIo(timeInMillis);
                        }
                    }
                    File file = new File(com.sma.smartv3.initializer.IXxxXO.X00IoxXI(X00IoxXI.oIX0oI.f3233oIX0oI), "gSensorSHSYs_" + simpleDateFormat.format(Long.valueOf(BleInitializer.f20700XO.xII())) + '_' + BleCache.INSTANCE.getMBleAddress() + ".csv");
                    if (!FileUtils.isFileExists(file)) {
                        FileUtils.createOrExistsFile(file);
                        FileIOUtils.writeFileFromString(file, "Timestamp,X,Y,Z,label,sleepParticularCase,steps\n", false);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(simpleDateFormat2.format(new Date(timeInMillis)));
                    sb.append(',');
                    String format = String.format("%+.8f", Arrays.copyOf(new Object[]{Float.valueOf(bleGSensorSHSY.getMX() / 1024.0f)}, 1));
                    IIX0o.oO(format, "format(...)");
                    sb.append(format);
                    sb.append(',');
                    String format2 = String.format("%+.8f", Arrays.copyOf(new Object[]{Float.valueOf(bleGSensorSHSY.getMY() / 1024.0f)}, 1));
                    IIX0o.oO(format2, "format(...)");
                    sb.append(format2);
                    sb.append(',');
                    String format3 = String.format("%+.8f", Arrays.copyOf(new Object[]{Float.valueOf(bleGSensorSHSY.getMZ() / 1024.0f)}, 1));
                    IIX0o.oO(format3, "format(...)");
                    sb.append(format3);
                    sb.append(',');
                    sb.append(ProductManager.f20544oIX0oI.xIXX(bleGSensorSHSY.getMActivityMode()));
                    sb.append(',');
                    String format4 = String.format(TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(bleGSensorSHSY.getMSleepParticularCase())}, 1));
                    IIX0o.oO(format4, "format(...)");
                    sb.append(format4);
                    sb.append(',');
                    String format5 = String.format(TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(bleGSensorSHSY.getMStep())}, 1));
                    IIX0o.oO(format5, "format(...)");
                    sb.append(format5);
                    sb.append('\n');
                    FileIOUtils.writeFileFromString(file, sb.toString(), true);
                    i = i2;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @XX({"SMAP\nBleInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadRri$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2140:1\n1855#2,2:2141\n*S KotlinDebug\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadRri$1\n*L\n1807#1:2141,2\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class IXxxXO extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ long f20735IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Date f20736Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20737Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ List<BleRri> f20738XO;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20739oI0IIXIo;

        public IXxxXO(List<BleRri> list, Date date, long j, SimpleDateFormat simpleDateFormat, SimpleDateFormat simpleDateFormat2) {
            this.f20738XO = list;
            this.f20736Oo = date;
            this.f20735IXxxXO = j;
            this.f20737Oxx0xo = simpleDateFormat;
            this.f20739oI0IIXIo = simpleDateFormat2;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@OXOo.oOoXoXO Void r1) {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @OXOo.oOoXoXO
        public Void doInBackground() {
            try {
                List<BleRri> list = this.f20738XO;
                Date date = this.f20736Oo;
                long j = this.f20735IXxxXO;
                SimpleDateFormat simpleDateFormat = this.f20737Oxx0xo;
                SimpleDateFormat simpleDateFormat2 = this.f20739oI0IIXIo;
                for (BleRri bleRri : list) {
                    date.setTime(((bleRri.getMTime() * 1000) - j) + com.sma.smartv3.util.xoIox.f24684IO);
                    File file = new File(com.sma.smartv3.initializer.IXxxXO.I0oOoX(X00IoxXI.oIX0oI.f3233oIX0oI), "rri_" + simpleDateFormat.format(date) + ".csv");
                    if (!FileUtils.isFileExists(file)) {
                        FileUtils.createOrExistsFile(file);
                        FileIOUtils.writeFileFromString(file, "timestamp,date,rri0,rri1\n", false);
                    }
                    date.setTime((bleRri.getMTime() * 1000) - j);
                    FileIOUtils.writeFileFromString(file, bleRri.getMTime() + ',' + simpleDateFormat2.format(date) + ',' + bleRri.getMRRI() + ',' + bleRri.getMRRI2() + '\n', true);
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @XX({"SMAP\nBleInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onUpdateTemperature$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2140:1\n1549#2:2141\n1620#2,3:2142\n*S KotlinDebug\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onUpdateTemperature$1\n*L\n1599#1:2141\n1599#1:2142,3\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class O0xOxO extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ Date f20740IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ long f20741Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20742Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ BleTemperature f20743XO;

        public O0xOxO(BleTemperature bleTemperature, long j, Date date, SimpleDateFormat simpleDateFormat) {
            this.f20743XO = bleTemperature;
            this.f20741Oo = j;
            this.f20740IXxxXO = date;
            this.f20742Oxx0xo = simpleDateFormat;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@OXOo.oOoXoXO Void r1) {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @OXOo.oOoXoXO
        public Void doInBackground() {
            TemperatureDao O0Xx2 = BleInitializer.f20700XO.O0Xx();
            List XOxIOxOx2 = CollectionsKt__CollectionsKt.XOxIOxOx(this.f20743XO);
            long j = this.f20741Oo;
            Date date = this.f20740IXxxXO;
            SimpleDateFormat simpleDateFormat = this.f20742Oxx0xo;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(XOxIOxOx2, 10));
            Iterator it = XOxIOxOx2.iterator();
            while (it.hasNext()) {
                Temperature temperature = new Temperature((BleTemperature) it.next(), j);
                date.setTime(temperature.getMTime());
                String format = simpleDateFormat.format(date);
                IIX0o.oO(format, "format(...)");
                temperature.setMLocalTime(format);
                arrayList.add(temperature);
            }
            O0Xx2.insert(arrayList);
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24600Oxx0IOOO, null, 2, null);
            return null;
        }
    }

    @XX({"SMAP\nBleInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadHanBaoVibration$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2140:1\n1549#2:2141\n1620#2,3:2142\n*S KotlinDebug\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadHanBaoVibration$1\n*L\n2100#1:2141\n2100#1:2142,3\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class OOXIXo extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ Date f20744IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ long f20745Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20746Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ List<BleHanBaoVibration> f20747XO;

        public OOXIXo(List<BleHanBaoVibration> list, long j, Date date, SimpleDateFormat simpleDateFormat) {
            this.f20747XO = list;
            this.f20745Oo = j;
            this.f20744IXxxXO = date;
            this.f20746Oxx0xo = simpleDateFormat;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@OXOo.oOoXoXO Void r1) {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @OXOo.oOoXoXO
        public Void doInBackground() {
            HanBaoVibrationDao oxXx0IX2 = BleInitializer.f20700XO.oxXx0IX();
            List<BleHanBaoVibration> list = this.f20747XO;
            long j = this.f20745Oo;
            Date date = this.f20744IXxxXO;
            SimpleDateFormat simpleDateFormat = this.f20746Oxx0xo;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                HanBaoVibration hanBaoVibration = new HanBaoVibration((BleHanBaoVibration) it.next(), j);
                date.setTime(hanBaoVibration.getMTime());
                String format = simpleDateFormat.format(date);
                IIX0o.oO(format, "format(...)");
                hanBaoVibration.setMLocalTime(format);
                arrayList.add(hanBaoVibration);
            }
            oxXx0IX2.insert(arrayList);
            return null;
        }
    }

    @XX({"SMAP\nBleInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onUpdateHeartRate$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2140:1\n1549#2:2141\n1620#2,3:2142\n*S KotlinDebug\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onUpdateHeartRate$1\n*L\n1577#1:2141\n1577#1:2142,3\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class OxI extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ Date f20748IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ long f20749Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20750Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ BleHeartRate f20751XO;

        public OxI(BleHeartRate bleHeartRate, long j, Date date, SimpleDateFormat simpleDateFormat) {
            this.f20751XO = bleHeartRate;
            this.f20749Oo = j;
            this.f20748IXxxXO = date;
            this.f20750Oxx0xo = simpleDateFormat;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@OXOo.oOoXoXO Void r1) {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @OXOo.oOoXoXO
        public Void doInBackground() {
            HeartRateDao xo0x2 = BleInitializer.f20700XO.xo0x();
            List XOxIOxOx2 = CollectionsKt__CollectionsKt.XOxIOxOx(this.f20751XO);
            long j = this.f20749Oo;
            Date date = this.f20748IXxxXO;
            SimpleDateFormat simpleDateFormat = this.f20750Oxx0xo;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(XOxIOxOx2, 10));
            Iterator it = XOxIOxOx2.iterator();
            while (it.hasNext()) {
                HeartRate heartRate = new HeartRate((BleHeartRate) it.next(), j);
                date.setTime(heartRate.getMTime());
                String format = simpleDateFormat.format(date);
                IIX0o.oO(format, "format(...)");
                heartRate.setMLocalTime(format);
                arrayList.add(heartRate);
            }
            xo0x2.insert(arrayList);
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24567II0xO0, null, 2, null);
            return null;
        }
    }

    @XX({"SMAP\nBleInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadBloodOxygen$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2140:1\n1549#2:2141\n1620#2,3:2142\n*S KotlinDebug\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadBloodOxygen$1\n*L\n766#1:2141\n766#1:2142,3\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class Oxx0IOOO extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ Date f20752IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ long f20753Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20754Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ List<BleBloodOxygen> f20755XO;

        public Oxx0IOOO(List<BleBloodOxygen> list, long j, Date date, SimpleDateFormat simpleDateFormat) {
            this.f20755XO = list;
            this.f20753Oo = j;
            this.f20752IXxxXO = date;
            this.f20754Oxx0xo = simpleDateFormat;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@OXOo.oOoXoXO Void r1) {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @OXOo.oOoXoXO
        public Void doInBackground() {
            BloodOxygenDao o02 = BleInitializer.f20700XO.o0();
            List<BleBloodOxygen> list = this.f20755XO;
            long j = this.f20753Oo;
            Date date = this.f20752IXxxXO;
            SimpleDateFormat simpleDateFormat = this.f20754Oxx0xo;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                BloodOxygen bloodOxygen = new BloodOxygen((BleBloodOxygen) it.next(), j);
                date.setTime(bloodOxygen.getMTime());
                String format = simpleDateFormat.format(date);
                IIX0o.oO(format, "format(...)");
                bloodOxygen.setMLocalTime(format);
                arrayList.add(bloodOxygen);
            }
            o02.insert(arrayList);
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24566II0XooXoX, null, 2, null);
            return null;
        }
    }

    @XX({"SMAP\nBleInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadSleep$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2140:1\n1855#2,2:2141\n1855#2:2143\n1549#2:2144\n1620#2,3:2145\n1856#2:2148\n1549#2:2149\n1620#2,3:2150\n*S KotlinDebug\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadSleep$1\n*L\n606#1:2141,2\n619#1:2143\n628#1:2144\n628#1:2145,3\n619#1:2148\n637#1:2149\n637#1:2150,3\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class Oxx0xo extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ Date f20756IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ long f20757Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20758Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ List<BleSleep> f20759XO;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public final /* synthetic */ int f20760oI0IIXIo;

        public Oxx0xo(List<BleSleep> list, long j, Date date, SimpleDateFormat simpleDateFormat, int i) {
            this.f20759XO = list;
            this.f20757Oo = j;
            this.f20756IXxxXO = date;
            this.f20758Oxx0xo = simpleDateFormat;
            this.f20760oI0IIXIo = i;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@OXOo.oOoXoXO Void r1) {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @OXOo.oOoXoXO
        public Void doInBackground() {
            String str;
            for (BleSleep bleSleep : this.f20759XO) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("onReadSleep -> " + bleSleep);
            }
            ProductManager productManager = ProductManager.f20544oIX0oI;
            String str2 = "format(...)";
            if (!productManager.oIXoXx0() && !productManager.Xx()) {
                SleepDao XoI0Ixx02 = BleInitializer.f20700XO.XoI0Ixx0();
                List<BleSleep> list = this.f20759XO;
                long j = this.f20757Oo;
                Date date = this.f20756IXxxXO;
                SimpleDateFormat simpleDateFormat = this.f20758Oxx0xo;
                int i = this.f20760oI0IIXIo;
                ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    Sleep sleep = new Sleep((BleSleep) it.next(), j);
                    date.setTime(sleep.getMTime());
                    String format = simpleDateFormat.format(date);
                    IIX0o.oO(format, "format(...)");
                    sleep.setMLocalTime(format);
                    sleep.setMAlgorithmType(i);
                    arrayList.add(sleep);
                }
                XoI0Ixx02.insert(arrayList);
            } else {
                try {
                    String str3 = com.sma.smartv3.util.xoIox.xoIox().format(new Date()) + ".json";
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI(str3);
                    File oxoX2 = com.sma.smartv3.initializer.IXxxXO.oxoX(X00IoxXI.oIX0oI.f3233oIX0oI, str3);
                    String json = new Gson().toJson(this.f20759XO);
                    IIX0o.oO(json, "toJson(...)");
                    FilesKt__FileReadWriteKt.xxIXOIIO(oxoX2, json, null, 2, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                List<List<BleSleep>> sleepAllDaySegments = BleSleep.Companion.getSleepAllDaySegments(this.f20759XO);
                long j2 = this.f20757Oo;
                Date date2 = this.f20756IXxxXO;
                SimpleDateFormat simpleDateFormat2 = this.f20758Oxx0xo;
                int i2 = this.f20760oI0IIXIo;
                Iterator<T> it2 = sleepAllDaySegments.iterator();
                while (it2.hasNext()) {
                    List list2 = (List) it2.next();
                    if (list2.size() > 1) {
                        str = str2;
                        BleInitializer.f20700XO.XoI0Ixx0().deleteSleeps(((BleSleep) CollectionsKt___CollectionsKt.O0OOX0IIx(list2)).getMLocalTime(), ((BleSleep) CollectionsKt___CollectionsKt.O0O0Io00X(list2)).getMLocalTime());
                    } else {
                        str = str2;
                    }
                    SleepDao XoI0Ixx03 = BleInitializer.f20700XO.XoI0Ixx0();
                    List list3 = list2;
                    ArrayList arrayList2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list3, 10));
                    Iterator it3 = list3.iterator();
                    while (it3.hasNext()) {
                        Sleep sleep2 = new Sleep((BleSleep) it3.next(), j2);
                        date2.setTime(sleep2.getMTime());
                        String format2 = simpleDateFormat2.format(date2);
                        IIX0o.oO(format2, str);
                        sleep2.setMLocalTime(format2);
                        sleep2.setMAlgorithmType(i2);
                        arrayList2.add(sleep2);
                    }
                    XoI0Ixx03.insert(arrayList2);
                    str2 = str;
                }
            }
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24645oxoX, null, 2, null);
            return null;
        }
    }

    @XX({"SMAP\nBleInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReceiveGSensorMotion$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2140:1\n1855#2,2:2141\n*S KotlinDebug\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReceiveGSensorMotion$1\n*L\n1859#1:2141,2\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class OxxIIOOXO extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20761IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Date f20762Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20763Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ List<BleGSensorMotion> f20764XO;

        public OxxIIOOXO(List<BleGSensorMotion> list, Date date, SimpleDateFormat simpleDateFormat, SimpleDateFormat simpleDateFormat2) {
            this.f20764XO = list;
            this.f20762Oo = date;
            this.f20761IXxxXO = simpleDateFormat;
            this.f20763Oxx0xo = simpleDateFormat2;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@OXOo.oOoXoXO Void r1) {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @OXOo.oOoXoXO
        public Void doInBackground() {
            try {
                List<BleGSensorMotion> list = this.f20764XO;
                Date date = this.f20762Oo;
                SimpleDateFormat simpleDateFormat = this.f20761IXxxXO;
                SimpleDateFormat simpleDateFormat2 = this.f20763Oxx0xo;
                for (BleGSensorMotion bleGSensorMotion : list) {
                    date.setTime(System.currentTimeMillis());
                    File file = new File(com.sma.smartv3.initializer.IXxxXO.X00IoxXI(X00IoxXI.oIX0oI.f3233oIX0oI), "gSensorMotions_" + simpleDateFormat.format(date) + ".csv");
                    if (!FileUtils.isFileExists(file)) {
                        FileUtils.createOrExistsFile(file);
                        FileIOUtils.writeFileFromString(file, "date,value\n", false);
                    }
                    if (bleGSensorMotion.getMMotion() > 42) {
                        FileIOUtils.writeFileFromString(file, simpleDateFormat2.format(date) + ',' + ((int) bleGSensorMotion.getMMotion()) + '\n', true);
                    }
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @XX({"SMAP\nBleInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadBleHrv$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2140:1\n1549#2:2141\n1620#2,3:2142\n*S KotlinDebug\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadBleHrv$1\n*L\n789#1:2141\n789#1:2142,3\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class X0o0xo extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ Date f20765IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ long f20766Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20767Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ List<BleHrv> f20768XO;

        public X0o0xo(List<BleHrv> list, long j, Date date, SimpleDateFormat simpleDateFormat) {
            this.f20768XO = list;
            this.f20766Oo = j;
            this.f20765IXxxXO = date;
            this.f20767Oxx0xo = simpleDateFormat;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@OXOo.oOoXoXO Void r1) {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @OXOo.oOoXoXO
        public Void doInBackground() {
            HrvDao xXOx2 = BleInitializer.f20700XO.xXOx();
            List<BleHrv> list = this.f20768XO;
            long j = this.f20766Oo;
            Date date = this.f20765IXxxXO;
            SimpleDateFormat simpleDateFormat = this.f20767Oxx0xo;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                Hrv hrv = new Hrv((BleHrv) it.next(), j);
                date.setTime(hrv.getMTime());
                String format = simpleDateFormat.format(date);
                IIX0o.oO(format, "format(...)");
                hrv.setMLocalTime(format);
                arrayList.add(hrv);
            }
            xXOx2.insert(arrayList);
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24669xxIXOIIO, null, 2, null);
            return null;
        }
    }

    @XX({"SMAP\nBleInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadBloodGlucose$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2140:1\n1549#2:2141\n1620#2,3:2142\n*S KotlinDebug\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadBloodGlucose$1\n*L\n1649#1:2141\n1649#1:2142,3\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class XO extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ Date f20769IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ long f20770Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20771Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ List<BleBloodGlucose> f20772XO;

        public XO(List<BleBloodGlucose> list, long j, Date date, SimpleDateFormat simpleDateFormat) {
            this.f20772XO = list;
            this.f20770Oo = j;
            this.f20769IXxxXO = date;
            this.f20771Oxx0xo = simpleDateFormat;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@OXOo.oOoXoXO Void r1) {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @OXOo.oOoXoXO
        public Void doInBackground() {
            BloodGlucoseDao Io2 = BleInitializer.f20700XO.Io();
            List<BleBloodGlucose> list = this.f20772XO;
            long j = this.f20770Oo;
            Date date = this.f20769IXxxXO;
            SimpleDateFormat simpleDateFormat = this.f20771Oxx0xo;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                BloodGlucose bloodGlucose = new BloodGlucose((BleBloodGlucose) it.next(), j);
                date.setTime(bloodGlucose.getMTime());
                String format = simpleDateFormat.format(date);
                IIX0o.oO(format, "format(...)");
                bloodGlucose.setMLocalTime(format);
                arrayList.add(bloodGlucose);
            }
            Io2.insert(arrayList);
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24648x0XOIxOo, null, 2, null);
            return null;
        }
    }

    @XX({"SMAP\nBleInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onUpdateBloodPressure$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2140:1\n1549#2:2141\n1620#2,3:2142\n*S KotlinDebug\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onUpdateBloodPressure$1\n*L\n1621#1:2141\n1621#1:2142,3\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class o00 extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ Date f20775IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ long f20776Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20777Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ BleBloodPressure f20778XO;

        public o00(BleBloodPressure bleBloodPressure, long j, Date date, SimpleDateFormat simpleDateFormat) {
            this.f20778XO = bleBloodPressure;
            this.f20776Oo = j;
            this.f20775IXxxXO = date;
            this.f20777Oxx0xo = simpleDateFormat;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@OXOo.oOoXoXO Void r1) {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @OXOo.oOoXoXO
        public Void doInBackground() {
            BloodPressureDao XX2 = BleInitializer.f20700XO.XX();
            List XOxIOxOx2 = CollectionsKt__CollectionsKt.XOxIOxOx(this.f20778XO);
            long j = this.f20776Oo;
            Date date = this.f20775IXxxXO;
            SimpleDateFormat simpleDateFormat = this.f20777Oxx0xo;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(XOxIOxOx2, 10));
            Iterator it = XOxIOxOx2.iterator();
            while (it.hasNext()) {
                BloodPressure bloodPressure = new BloodPressure((BleBloodPressure) it.next(), j);
                date.setTime(bloodPressure.getMTime());
                String format = simpleDateFormat.format(date);
                IIX0o.oO(format, "format(...)");
                bloodPressure.setMLocalTime(format);
                arrayList.add(bloodPressure);
            }
            XX2.insert(arrayList);
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24562I0Io, null, 2, null);
            return null;
        }
    }

    @XX({"SMAP\nBleInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadTemperature$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2140:1\n1549#2:2141\n1620#2,3:2142\n*S KotlinDebug\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadTemperature$1\n*L\n743#1:2141\n743#1:2142,3\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class oI0IIXIo extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ Date f20779IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ long f20780Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20781Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ List<BleTemperature> f20782XO;

        public oI0IIXIo(List<BleTemperature> list, long j, Date date, SimpleDateFormat simpleDateFormat) {
            this.f20782XO = list;
            this.f20780Oo = j;
            this.f20779IXxxXO = date;
            this.f20781Oxx0xo = simpleDateFormat;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@OXOo.oOoXoXO Void r1) {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @OXOo.oOoXoXO
        public Void doInBackground() {
            TemperatureDao O0Xx2 = BleInitializer.f20700XO.O0Xx();
            List<BleTemperature> list = this.f20782XO;
            long j = this.f20780Oo;
            Date date = this.f20779IXxxXO;
            SimpleDateFormat simpleDateFormat = this.f20781Oxx0xo;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                Temperature temperature = new Temperature((BleTemperature) it.next(), j);
                date.setTime(temperature.getMTime());
                String format = simpleDateFormat.format(date);
                IIX0o.oO(format, "format(...)");
                temperature.setMLocalTime(format);
                arrayList.add(temperature);
            }
            O0Xx2.insert(arrayList);
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24600Oxx0IOOO, null, 2, null);
            return null;
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends PhoneStateListener {
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, @OXOo.oOoXoXO String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("BleInitializer PhoneStateListener onCallStateChanged -> isAppForeground:");
            sb.append(AppUtils.isAppForeground());
            sb.append(" isScreenLock:");
            sb.append(ScreenUtils.isScreenLock());
            sb.append(" state=");
            BleInitializer bleInitializer = BleInitializer.f20700XO;
            sb.append(bleInitializer.oOXoIIIo(i));
            sb.append(", phoneNumber=");
            sb.append(str);
            sb.append(", ");
            sb.append(BleInitializer.f20701XOxIOxOx);
            LogUtils.v(sb.toString());
            if (i == 0) {
                bleInitializer.Ioxxx(1);
                Xo0.f24349oIX0oI.I0Io().put(XoI0Ixx0.f24461ooXIXxIX, false);
                if (BleInitializer.f20701XOxIOxOx == 1) {
                    if (ProductManager.f20544oIX0oI.X0OXX() && !TextUtils.isEmpty(str)) {
                        if (str == null) {
                            str = "";
                        }
                        bleInitializer.O00XxXI(str);
                    } else {
                        if (str == null) {
                            str = "";
                        }
                        bleInitializer.o0xxxXXxX(str);
                    }
                } else if (BleInitializer.f20701XOxIOxOx == 2) {
                    bleInitializer.XIo0oOXIx();
                }
                bleInitializer.o0oIxOo(null);
            } else if (i != 1) {
                if (i == 2) {
                    bleInitializer.Ioxxx(0);
                    Xo0.f24349oIX0oI.I0Io().put(XoI0Ixx0.f24461ooXIXxIX, false);
                    if (BleInitializer.f20701XOxIOxOx == 1) {
                        bleInitializer.XIo0oOXIx();
                    }
                    bleInitializer.o0oIxOo(null);
                }
            } else {
                Xo0.f24349oIX0oI.I0Io().put(XoI0Ixx0.f24461ooXIXxIX, true);
                if (ProductManager.f20544oIX0oI.X0OXX() && !TextUtils.isEmpty(str)) {
                    if (str == null) {
                        str = "";
                    }
                    bleInitializer.XX0xXo(str);
                } else {
                    if (str == null) {
                        str = "";
                    }
                    bleInitializer.xxIO(str);
                }
            }
            BleInitializer.f20701XOxIOxOx = i;
        }
    }

    @XX({"SMAP\nBleInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadMatchRecord2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2140:1\n1549#2:2141\n1620#2,3:2142\n*S KotlinDebug\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadMatchRecord2$1\n*L\n1542#1:2141\n1542#1:2142,3\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class oO extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ Date f20783IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ long f20784Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20785Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ List<BleMatchRecord2> f20786XO;

        public oO(List<BleMatchRecord2> list, long j, Date date, SimpleDateFormat simpleDateFormat) {
            this.f20786XO = list;
            this.f20784Oo = j;
            this.f20783IXxxXO = date;
            this.f20785Oxx0xo = simpleDateFormat;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@OXOo.oOoXoXO Void r1) {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @OXOo.oOoXoXO
        public Void doInBackground() {
            MatchRecordDao I0X0x0oIo2 = BleInitializer.f20700XO.I0X0x0oIo();
            List<BleMatchRecord2> list = this.f20786XO;
            long j = this.f20784Oo;
            Date date = this.f20783IXxxXO;
            SimpleDateFormat simpleDateFormat = this.f20785Oxx0xo;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                MatchRecord matchRecord = new MatchRecord((BleMatchRecord2) it.next(), j);
                date.setTime(matchRecord.getMStart());
                String format = simpleDateFormat.format(date);
                IIX0o.oO(format, "format(...)");
                matchRecord.setMLocalTime(format);
                arrayList.add(matchRecord);
            }
            I0X0x0oIo2.insert(arrayList);
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24610XIo0oOXIx, null, 2, null);
            return null;
        }
    }

    @XX({"SMAP\nBleInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadHeartRate$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2140:1\n1549#2:2141\n1620#2,3:2142\n*S KotlinDebug\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadHeartRate$1\n*L\n561#1:2141\n561#1:2142,3\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class oOoXoXO extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ Date f20787IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ long f20788Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20789Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ List<BleHeartRate> f20790XO;

        public oOoXoXO(List<BleHeartRate> list, long j, Date date, SimpleDateFormat simpleDateFormat) {
            this.f20790XO = list;
            this.f20788Oo = j;
            this.f20787IXxxXO = date;
            this.f20789Oxx0xo = simpleDateFormat;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@OXOo.oOoXoXO Void r1) {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @OXOo.oOoXoXO
        public Void doInBackground() {
            HeartRateDao xo0x2 = BleInitializer.f20700XO.xo0x();
            List<BleHeartRate> list = this.f20790XO;
            long j = this.f20788Oo;
            Date date = this.f20787IXxxXO;
            SimpleDateFormat simpleDateFormat = this.f20789Oxx0xo;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                HeartRate heartRate = new HeartRate((BleHeartRate) it.next(), j);
                date.setTime(heartRate.getMTime());
                String format = simpleDateFormat.format(date);
                IIX0o.oO(format, "format(...)");
                heartRate.setMLocalTime(format);
                arrayList.add(heartRate);
            }
            xo0x2.insert(arrayList);
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24567II0xO0, null, 2, null);
            return null;
        }
    }

    @XX({"SMAP\nBleInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadLocation$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2140:1\n1549#2:2141\n1620#2,3:2142\n*S KotlinDebug\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadLocation$1\n*L\n720#1:2141\n720#1:2142,3\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class ooOOo0oXI extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ Date f20807IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ long f20808Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20809Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ List<BleLocation> f20810XO;

        public ooOOo0oXI(List<BleLocation> list, long j, Date date, SimpleDateFormat simpleDateFormat) {
            this.f20810XO = list;
            this.f20808Oo = j;
            this.f20807IXxxXO = date;
            this.f20809Oxx0xo = simpleDateFormat;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@OXOo.oOoXoXO Void r1) {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @OXOo.oOoXoXO
        public Void doInBackground() {
            LocationDao XX02 = BleInitializer.f20700XO.XX0();
            List<BleLocation> list = this.f20810XO;
            long j = this.f20808Oo;
            Date date = this.f20807IXxxXO;
            SimpleDateFormat simpleDateFormat = this.f20809Oxx0xo;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                Location location = new Location((BleLocation) it.next(), j);
                date.setTime(location.getMTime());
                String format = simpleDateFormat.format(date);
                IIX0o.oO(format, "format(...)");
                location.setMLocalTime(format);
                arrayList.add(location);
            }
            XX02.insert(arrayList);
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24593OOXIXo, null, 2, null);
            return null;
        }
    }

    @XX({"SMAP\nBleInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadAlipayBindInfo$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2140:1\n1549#2:2141\n1620#2,3:2142\n*S KotlinDebug\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadAlipayBindInfo$1\n*L\n1769#1:2141\n1769#1:2142,3\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class oxoX extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ Date f20811IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ long f20812Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20813Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ List<BleAlipayBindInfo> f20814XO;

        public oxoX(List<BleAlipayBindInfo> list, long j, Date date, SimpleDateFormat simpleDateFormat) {
            this.f20814XO = list;
            this.f20812Oo = j;
            this.f20811IXxxXO = date;
            this.f20813Oxx0xo = simpleDateFormat;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@OXOo.oOoXoXO Void r1) {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @OXOo.oOoXoXO
        public Void doInBackground() {
            AlipayBindInfoDao XOxIOxOx2 = BleInitializer.f20700XO.XOxIOxOx();
            List<BleAlipayBindInfo> list = this.f20814XO;
            long j = this.f20812Oo;
            Date date = this.f20811IXxxXO;
            SimpleDateFormat simpleDateFormat = this.f20813Oxx0xo;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                AlipayBindInfo alipayBindInfo = new AlipayBindInfo((BleAlipayBindInfo) it.next(), j);
                date.setTime(alipayBindInfo.getMTime());
                String format = simpleDateFormat.format(date);
                IIX0o.oO(format, "format(...)");
                alipayBindInfo.setMLocalTime(format);
                BleCache bleCache = BleCache.INSTANCE;
                alipayBindInfo.setMBleName(bleCache.getMBleName());
                alipayBindInfo.setMFirmwareFlag(bleCache.getMFirmwareFlag());
                alipayBindInfo.setMFirmwareVersion(BleCache.getString$default(bleCache, BleKey.FIRMWARE_VERSION, bq.e, null, 4, null));
                alipayBindInfo.setMMacAddress(kotlin.text.OxI.IIOIX(bleCache.getMBleAddress(), ":", "", false, 4, null));
                String appVersionName = AppUtils.getAppVersionName();
                IIX0o.oO(appVersionName, "getAppVersionName(...)");
                alipayBindInfo.setMAppVersion(appVersionName);
                arrayList.add(alipayBindInfo);
            }
            XOxIOxOx2.insert(arrayList);
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24630oO, null, 2, null);
            return null;
        }
    }

    @XX({"SMAP\nBleInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadMatchRecord$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2140:1\n1549#2:2141\n1620#2,3:2142\n*S KotlinDebug\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadMatchRecord$1\n*L\n1520#1:2141\n1520#1:2142,3\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class x0XOIxOo extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ Date f20816IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ long f20817Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20818Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ List<BleMatchRecord> f20819XO;

        public x0XOIxOo(List<BleMatchRecord> list, long j, Date date, SimpleDateFormat simpleDateFormat) {
            this.f20819XO = list;
            this.f20817Oo = j;
            this.f20816IXxxXO = date;
            this.f20818Oxx0xo = simpleDateFormat;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@OXOo.oOoXoXO Void r1) {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @OXOo.oOoXoXO
        public Void doInBackground() {
            MatchRecordDao I0X0x0oIo2 = BleInitializer.f20700XO.I0X0x0oIo();
            List<BleMatchRecord> list = this.f20819XO;
            long j = this.f20817Oo;
            Date date = this.f20816IXxxXO;
            SimpleDateFormat simpleDateFormat = this.f20818Oxx0xo;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                MatchRecord matchRecord = new MatchRecord((BleMatchRecord) it.next(), j);
                date.setTime(matchRecord.getMStart());
                String format = simpleDateFormat.format(date);
                IIX0o.oO(format, "format(...)");
                matchRecord.setMLocalTime(format);
                arrayList.add(matchRecord);
            }
            I0X0x0oIo2.insert(arrayList);
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24610XIo0oOXIx, null, 2, null);
            return null;
        }
    }

    @XX({"SMAP\nBleInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadPressure$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2140:1\n1549#2:2141\n1620#2,3:2142\n*S KotlinDebug\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadPressure$1\n*L\n978#1:2141\n978#1:2142,3\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class x0xO0oo extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ Date f20820IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ long f20821Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20822Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ List<BlePressure> f20823XO;

        public x0xO0oo(List<BlePressure> list, long j, Date date, SimpleDateFormat simpleDateFormat) {
            this.f20823XO = list;
            this.f20821Oo = j;
            this.f20820IXxxXO = date;
            this.f20822Oxx0xo = simpleDateFormat;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@OXOo.oOoXoXO Void r1) {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @OXOo.oOoXoXO
        public Void doInBackground() {
            PressureDao oX2 = BleInitializer.f20700XO.oX();
            List<BlePressure> list = this.f20823XO;
            long j = this.f20821Oo;
            Date date = this.f20820IXxxXO;
            SimpleDateFormat simpleDateFormat = this.f20822Oxx0xo;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                Pressure pressure = new Pressure((BlePressure) it.next(), j);
                date.setTime(pressure.getMTime());
                String format = simpleDateFormat.format(date);
                IIX0o.oO(format, "format(...)");
                pressure.setMLocalTime(format);
                arrayList.add(pressure);
            }
            oX2.insert(arrayList);
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24639ooOOo0oXI, null, 2, null);
            return null;
        }
    }

    /* loaded from: classes12.dex */
    public static final class xoIox extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ List<BleEcg> f20824XO;

        public xoIox(List<BleEcg> list) {
            this.f20824XO = list;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@OXOo.oOoXoXO Void r1) {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @OXOo.oOoXoXO
        public Void doInBackground() {
            BleInitializer bleInitializer = BleInitializer.f20700XO;
            bleInitializer.XoX().insert(com.sma.smartv3.util.ooOOo0oXI.I0Io(this.f20824XO, bleInitializer.XoX().getLastElectrocardiogram()));
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24567II0xO0, null, 2, null);
            return null;
        }
    }

    @XX({"SMAP\nBleInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReceivePpgSHSY$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2140:1\n1864#2,3:2141\n*S KotlinDebug\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReceivePpgSHSY$1\n*L\n1957#1:2141,3\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class xoXoI extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20825IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Calendar f20826Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20827Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ List<BlePpgSHSY> f20828XO;

        public xoXoI(List<BlePpgSHSY> list, Calendar calendar, SimpleDateFormat simpleDateFormat, SimpleDateFormat simpleDateFormat2) {
            this.f20828XO = list;
            this.f20826Oo = calendar;
            this.f20825IXxxXO = simpleDateFormat;
            this.f20827Oxx0xo = simpleDateFormat2;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@OXOo.oOoXoXO Void r1) {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @OXOo.oOoXoXO
        public Void doInBackground() {
            try {
                List<BlePpgSHSY> list = this.f20828XO;
                Calendar calendar = this.f20826Oo;
                SimpleDateFormat simpleDateFormat = this.f20825IXxxXO;
                SimpleDateFormat simpleDateFormat2 = this.f20827Oxx0xo;
                int i = 0;
                for (Object obj : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt__CollectionsKt.XoX();
                    }
                    BlePpgSHSY blePpgSHSY = (BlePpgSHSY) obj;
                    long timeInMillis = calendar.getTimeInMillis() + blePpgSHSY.getMTime();
                    if (i == 0) {
                        BleInitializer bleInitializer = BleInitializer.f20700XO;
                        if (bleInitializer.IO() == 0) {
                            bleInitializer.xI0oxI00(timeInMillis);
                        }
                    }
                    File file = new File(com.sma.smartv3.initializer.IXxxXO.X00IoxXI(X00IoxXI.oIX0oI.f3233oIX0oI), "ppgSHSYs_" + simpleDateFormat.format(Long.valueOf(BleInitializer.f20700XO.IO())) + '_' + BleCache.INSTANCE.getMBleAddress() + ".csv");
                    if (!FileUtils.isFileExists(file)) {
                        FileUtils.createOrExistsFile(file);
                        FileIOUtils.writeFileFromString(file, "Timestamp,PPGRaw,PPG\n", false);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(simpleDateFormat2.format(new Date(timeInMillis)));
                    sb.append(',');
                    String format = String.format(TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(blePpgSHSY.getMPGGRaw())}, 1));
                    IIX0o.oO(format, "format(...)");
                    sb.append(format);
                    sb.append(',');
                    String format2 = String.format(TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(blePpgSHSY.getMPGG())}, 1));
                    IIX0o.oO(format2, "format(...)");
                    sb.append(format2);
                    sb.append('\n');
                    FileIOUtils.writeFileFromString(file, sb.toString(), true);
                    i = i2;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @XX({"SMAP\nBleInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadDailyPower$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2140:1\n1549#2:2141\n1620#2,3:2142\n*S KotlinDebug\n*F\n+ 1 BleInitializer.kt\ncom/sma/smartv3/initializer/BleInitializer$onReadDailyPower$1\n*L\n2125#1:2141\n2125#1:2142,3\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class xxIXOIIO extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ Date f20829IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ long f20830Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f20831Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ List<BlePhysicalPower> f20832XO;

        public xxIXOIIO(List<BlePhysicalPower> list, long j, Date date, SimpleDateFormat simpleDateFormat) {
            this.f20832XO = list;
            this.f20830Oo = j;
            this.f20829IXxxXO = date;
            this.f20831Oxx0xo = simpleDateFormat;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@OXOo.oOoXoXO Void r1) {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @OXOo.oOoXoXO
        public Void doInBackground() {
            DailyPowerDao I0oOoX2 = BleInitializer.f20700XO.I0oOoX();
            List<BlePhysicalPower> list = this.f20832XO;
            long j = this.f20830Oo;
            Date date = this.f20829IXxxXO;
            SimpleDateFormat simpleDateFormat = this.f20831Oxx0xo;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                DailyPower dailyPower = new DailyPower((BlePhysicalPower) it.next(), j);
                date.setTime(dailyPower.getMTime());
                String format = simpleDateFormat.format(date);
                IIX0o.oO(format, "format(...)");
                dailyPower.setMLocalTime(format);
                arrayList.add(dailyPower);
            }
            I0oOoX2.insert(arrayList);
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24633oOoIIO0, null, 2, null);
            return null;
        }
    }

    static {
        Handler handler = new Handler();
        f20715oo0xXOI0I = handler;
        f20701XOxIOxOx = -1;
        f20718oxxXoxO = new oIX0oI();
        f20706XoX = Uri.parse("content://sms/");
        f20717oxXx0IX = new II0xO0(handler);
        f20724xo0x = new long[]{500, 500};
        f20722xXOx = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AudioManager>() { // from class: com.sma.smartv3.initializer.BleInitializer$mAudioManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final AudioManager invoke() {
                Object systemService = Utils.getApp().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
                IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.media.AudioManager");
                return (AudioManager) systemService;
            }
        });
        f20680I0X0x0oIo = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AssetFileDescriptor>() { // from class: com.sma.smartv3.initializer.BleInitializer$mDescriptor4FindDevice$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final AssetFileDescriptor invoke() {
                return Utils.getApp().getAssets().openFd("find_phone.ogg");
            }
        });
        f20713oX = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Vibrator>() { // from class: com.sma.smartv3.initializer.BleInitializer$mVibrator$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Vibrator invoke() {
                Object systemService = Utils.getApp().getSystemService("vibrator");
                IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.os.Vibrator");
                return (Vibrator) systemService;
            }
        });
    }

    public static final void IIX0(boolean z) {
        if (z) {
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24571IIxOXoOo0, null, 2, null);
        }
        BleConnector.INSTANCE.unbind();
        f20700XO.IoOoX();
    }

    public static final boolean IoXIXo(MediaPlayer mediaPlayer, int i, int i2) {
        f20700XO.x0OxxIOxX();
        return false;
    }

    public static /* synthetic */ void O0X(BleInitializer bleInitializer, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        bleInitializer.oOo(z);
    }

    public static final void XIXIX() {
        BleConnector.INSTANCE.connectClassic();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LocationDao XX0() {
        return (LocationDao) f20710o00.getValue();
    }

    public final boolean I0() {
        return f20691OI0;
    }

    public final MatchRecordDao I0X0x0oIo() {
        return (MatchRecordDao) f20726xxX.getValue();
    }

    public final Vibrator I0oOIX() {
        return (Vibrator) f20713oX.getValue();
    }

    public final DailyPowerDao I0oOoX() {
        return (DailyPowerDao) f20720xI.getValue();
    }

    public final boolean IIxOXoOo0() {
        return f20685IO;
    }

    public final long IO() {
        return f20681I0oOIX;
    }

    public final void IXO(boolean z) {
        f20712oOXoIIIo = z;
    }

    public final BloodGlucoseDao Io() {
        return (BloodGlucoseDao) f20708XxX0x0xxx.getValue();
    }

    public final void IoIOOxIIo(long j) {
        f20689O0Xx = j;
    }

    public final void IoOoX() {
        Xo0 xo0 = Xo0.f24349oIX0oI;
        xo0.II0xO0().remove(DeviceConfigInfo.class.getName());
        if (ProjectManager.f19822oIX0oI.xx0X0()) {
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24576IoIOOxIIo, null, 2, null);
        }
        xo0.II0xO0().clear();
        BleCache bleCache = BleCache.INSTANCE;
        BleCache.remove$default(bleCache, BleKey.WEATHER_REALTIME, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.WEATHER_FORECAST, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.WEATHER_REALTIME2, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.WEATHER_FORECAST2, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.WEATHER_REALTIME3, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.WEATHER_FORECAST3, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.IDENTITY, null, 2, null);
        bleCache.remove(BleKey.COACHING, BleKeyFlag.READ);
        BleCache.remove$default(bleCache, BleKey.GAME_SET, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.POWER_SAVE_MODE, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.GAME_TIME_REMINDER, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.FIRMWARE_VERSION, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.UI_PACK_VERSION, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.CALORIES_GOAL, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.DISTANCE_GOAL, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.TOUCH_SET, null, 2, null);
        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24662xoIox, null, 2, null);
        com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24572IO, Boolean.FALSE);
        FileUtils.delete(com.sma.smartv3.initializer.IXxxXO.XO(X00IoxXI.oIX0oI.f3233oIX0oI));
        xo0.XO().remove(DcsToken.class.getName());
        oo();
    }

    @OXOo.oOoXoXO
    public final BleNotification IoOoo() {
        return f20687Io;
    }

    public final void Ioxxx(int i) {
        if (ProductManager.f20544oIX0oI.IoXIXo()) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("handleInComingCall value=" + i);
            BleConnector.sendInt8$default(BleConnector.INSTANCE, BleKey.INCOMING_CALL, BleKeyFlag.UPDATE, i, false, false, 24, null);
        }
    }

    public final void Ix00oIoI(int i) {
        f20702XX = i;
    }

    public final void IxIX0I(boolean z) {
        f20719x0o = z;
    }

    public final void O0(boolean z) {
        f20688IoOoX = z;
    }

    public final void O00XxXI(String str) {
        LogUtils.d("handleMissedCall2 -> " + str);
        if (!Xo0.f24349oIX0oI.I0Io().getBoolean(XoI0Ixx0.f24358II0xO0)) {
            return;
        }
        f20685IO = true;
        String X00IoxXI2 = X00IoxXI(str);
        if (TextUtils.isEmpty(X00IoxXI2) && (X00IoxXI2 = x0()) == null) {
            X00IoxXI2 = "";
        }
        long time = new Date().getTime();
        String string = Utils.getApp().getString(R.string.missed_call);
        IIX0o.oO(string, "getString(...)");
        BleNotification2 bleNotification2 = new BleNotification2(127, time, BleNotification.PACKAGE_MISSED_CALL, X00IoxXI2, str, string);
        OI0.oIX0oI.f1507oIX0oI.XO("BleInitializer handleMissedCall2 -> Send Notification2 = " + bleNotification2);
        BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.NOTIFICATION2, BleKeyFlag.UPDATE, bleNotification2, false, false, 24, null);
    }

    public final void O0IxXx() {
        x0OxxIOxX();
        try {
            AudioManager OI02 = OI0();
            OI02.setStreamVolume(4, OI02.getStreamMaxVolume(4), 0);
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setLooping(true);
            BleInitializer bleInitializer = f20700XO;
            mediaPlayer.setDataSource(bleInitializer.oxxXoxO().getFileDescriptor(), bleInitializer.oxxXoxO().getStartOffset(), bleInitializer.oxxXoxO().getLength());
            mediaPlayer.setAudioStreamType(4);
            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.sma.smartv3.initializer.xoIox
                @Override // android.media.MediaPlayer.OnErrorListener
                public final boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                    boolean IoXIXo2;
                    IoXIXo2 = BleInitializer.IoXIXo(mediaPlayer2, i, i2);
                    return IoXIXo2;
                }
            });
            mediaPlayer.prepare();
            mediaPlayer.start();
            f20703XX0 = mediaPlayer;
            I0oOIX().vibrate(f20724xo0x, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final TemperatureDao O0Xx() {
        return (TemperatureDao) f20693OxI.getValue();
    }

    public final AudioManager OI0() {
        return (AudioManager) f20722xXOx.getValue();
    }

    public final void OIOoIIOIx(boolean z) {
        f20691OI0 = z;
    }

    public final WorkoutIndexDao OO() {
        return (WorkoutIndexDao) f20690O0xOxO.getValue();
    }

    public final int OO0x0xX() {
        return f20702XX;
    }

    public final boolean OOXIxO0() {
        return f20714oo;
    }

    public final boolean OX00O0xII() {
        return f20721xII;
    }

    public final void OoO(boolean z) {
        f20685IO = z;
    }

    public final void Ox0O() {
        BleConnector bleConnector = BleConnector.INSTANCE;
        if (bleConnector.isAvailable()) {
            BleCache bleCache = BleCache.INSTANCE;
            if (IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL) || IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL707) || IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL707LITE)) {
                BleNotificationSettings bleNotificationSettings = new BleNotificationSettings();
                if (Xo0.f24349oIX0oI.I0Io().getBoolean(XoI0Ixx0.f24358II0xO0, false)) {
                    bleNotificationSettings.enable("tel");
                } else {
                    bleNotificationSettings.disable("tel");
                }
                BleConnector.sendObject$default(bleConnector, BleKey.NOTIFICATION_REMINDER, BleKeyFlag.UPDATE, bleNotificationSettings, false, false, 24, null);
            }
        }
    }

    public final String X00IoxXI(String str) {
        if (!PermissionUtils.isGranted("android.permission.READ_CONTACTS")) {
            return TextConvertKt.XX(str);
        }
        try {
            Cursor query = Utils.getApp().getContentResolver().query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)), null, null, null, null);
            if (query != null) {
                Cursor cursor = query;
                try {
                    Cursor cursor2 = cursor;
                    if (cursor2.moveToNext()) {
                        String string = cursor2.getString(cursor2.getColumnIndex("display_name"));
                        IIX0o.oO(string, "getString(...)");
                        String o02 = TextConvertKt.o0(string);
                        kotlin.io.II0xO0.oIX0oI(cursor, null);
                        return o02;
                    }
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    kotlin.io.II0xO0.oIX0oI(cursor, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        kotlin.io.II0xO0.oIX0oI(cursor, th);
                        throw th2;
                    }
                }
            }
            return Xx000oIo(str);
        } catch (Exception e) {
            e.printStackTrace();
            return TextConvertKt.XX(str);
        }
    }

    public final boolean XI0oooXX() {
        return f20688IoOoX;
    }

    public final void XIXIxO(@OXOo.OOXIXo Context context) {
        TelephonyManager telephonyManager;
        IIX0o.x0xO0oo(context, "context");
        Object systemService = context.getSystemService("phone");
        if (systemService instanceof TelephonyManager) {
            telephonyManager = (TelephonyManager) systemService;
        } else {
            telephonyManager = null;
        }
        if (telephonyManager != null && !f20691OI0 && PermissionUtils.isGranted("android.permission.READ_CALL_LOG", g.c)) {
            telephonyManager.listen(f20718oxxXoxO, 32);
            f20691OI0 = true;
        }
        OI0.oIX0oI.f1507oIX0oI.XO("setPhoneListener -> " + f20691OI0);
    }

    public final void XIo0oOXIx() {
        LogUtils.d("handleEnd");
        if (!Xo0.f24349oIX0oI.I0Io().getBoolean(XoI0Ixx0.f24358II0xO0)) {
            return;
        }
        BleNotification bleNotification = new BleNotification(1, 0L, null, null, null, 30, null);
        OI0.oIX0oI.f1507oIX0oI.XO("BleInitializer handleEnd -> Send Notification = " + bleNotification);
        BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.NOTIFICATION, BleKeyFlag.DELETE, bleNotification, false, false, 24, null);
    }

    public final AlipayBindInfoDao XOxIOxOx() {
        return (AlipayBindInfoDao) f20723xXxxox0I.getValue();
    }

    public final BloodPressureDao XX() {
        return (BloodPressureDao) f20695OxxIIOOXO.getValue();
    }

    public final void XX0xXo(String str) {
        LogUtils.d("handleIncomingCall2 -> " + str);
        if (!Xo0.f24349oIX0oI.I0Io().getBoolean(XoI0Ixx0.f24358II0xO0)) {
            return;
        }
        BleConnector bleConnector = BleConnector.INSTANCE;
        if (!bleConnector.isAvailable()) {
            return;
        }
        String[] oIX0oI2 = X00xOoXI.oIX0oI();
        if (!PermissionUtils.isGranted((String[]) Arrays.copyOf(oIX0oI2, oIX0oI2.length))) {
            return;
        }
        String X00IoxXI2 = X00IoxXI(str);
        if (TextUtils.isEmpty(X00IoxXI2) && (X00IoxXI2 = x0()) == null) {
            X00IoxXI2 = "";
        }
        long time = new Date().getTime();
        String string = Utils.getApp().getString(R.string.incoming_call);
        IIX0o.oO(string, "getString(...)");
        BleNotification2 bleNotification2 = new BleNotification2(1, time, null, X00IoxXI2, str, string, 4, null);
        OI0.oIX0oI.f1507oIX0oI.XO("BleInitializer handleIncomingCall2 -> Send Notification2 = " + bleNotification2);
        BleConnector.sendObject$default(bleConnector, BleKey.NOTIFICATION2, BleKeyFlag.UPDATE, bleNotification2, false, false, 24, null);
    }

    public final void XXoOx0(long j) {
        f20696X00IoxXI = j;
    }

    public final int Xo0() {
        return f20682I0oOoX;
    }

    public final SleepDao XoI0Ixx0() {
        return (SleepDao) f20684IIXOooo.getValue();
    }

    public final ElectrocardiogramDao XoX() {
        return (ElectrocardiogramDao) f20683IIX0o.getValue();
    }

    public final String Xx000oIo(String str) {
        String str2;
        if (!PermissionUtils.isGranted("android.permission.READ_CONTACTS")) {
            return TextConvertKt.XX(str);
        }
        try {
            Application app = Utils.getApp();
            IIX0o.oO(app, "getApp(...)");
            if (UtilsKt.IO(app) && str.length() == 5) {
                str2 = " = '" + str + '\'';
            } else {
                str2 = " like '%" + str + '\'';
            }
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("getPN1 -> " + str2);
            Cursor query = Utils.getApp().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"display_name", "data4"}, "data4" + str2, null, null);
            if (query != null) {
                Cursor cursor = query;
                try {
                    Cursor cursor2 = cursor;
                    if (cursor2.moveToNext()) {
                        String string = cursor2.getString(cursor2.getColumnIndex("display_name"));
                        IIX0o.oO(string, "getString(...)");
                        String o02 = TextConvertKt.o0(string);
                        kotlin.io.II0xO0.oIX0oI(cursor, null);
                        return o02;
                    }
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    kotlin.io.II0xO0.oIX0oI(cursor, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        kotlin.io.II0xO0.oIX0oI(cursor, th);
                        throw th2;
                    }
                }
            }
            return TextConvertKt.XX(str);
        } catch (Exception e) {
            e.printStackTrace();
            return TextConvertKt.XX(str);
        }
    }

    public final BloodOxygenDao o0() {
        return (BloodOxygenDao) f20697X0IIOO.getValue();
    }

    public final void o0oIxOo(@OXOo.oOoXoXO BleNotification bleNotification) {
        f20687Io = bleNotification;
    }

    public final void o0xxxXXxX(String str) {
        LogUtils.d("handleMissedCall -> " + str);
        if (!Xo0.f24349oIX0oI.I0Io().getBoolean(XoI0Ixx0.f24358II0xO0)) {
            return;
        }
        f20685IO = true;
        String X00IoxXI2 = X00IoxXI(str);
        if (TextUtils.isEmpty(X00IoxXI2) && (X00IoxXI2 = x0()) == null) {
            X00IoxXI2 = "";
        }
        long time = new Date().getTime();
        String string = Utils.getApp().getString(R.string.missed_call);
        IIX0o.oO(string, "getString(...)");
        BleNotification bleNotification = new BleNotification(127, time, BleNotification.PACKAGE_MISSED_CALL, X00IoxXI2, string);
        OI0.oIX0oI.f1507oIX0oI.XO("BleInitializer handleMissedCall -> Send Notification = " + bleNotification);
        BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.NOTIFICATION, BleKeyFlag.UPDATE, bleNotification, false, false, 24, null);
    }

    public final void oI(long j) {
        f20709o0 = j;
    }

    @Override // com.bestmafen.androidbase.base.II0xO0
    public void oIX0oI(@OXOo.OOXIXo Application app) {
        IIX0o.x0xO0oo(app, "app");
        XO0.II0xO0.oxoX().x0XOIxOo(this);
        OI0.oIX0oI.f1507oIX0oI.X0o0xo(new Oox.IXxxXO<LogLevel, String, String, Boolean>() { // from class: com.sma.smartv3.initializer.BleInitializer$init$1

            /* loaded from: classes12.dex */
            public static final class oIX0oI extends ThreadUtils.SimpleTask<Void> {

                /* renamed from: Oo, reason: collision with root package name */
                public final /* synthetic */ LogLevel f20773Oo;

                /* renamed from: XO, reason: collision with root package name */
                public final /* synthetic */ String f20774XO;

                public oIX0oI(String str, LogLevel logLevel) {
                    this.f20774XO = str;
                    this.f20773Oo = logLevel;
                }

                @Override // com.blankj.utilcode.util.ThreadUtils.Task
                public void onSuccess(@OXOo.oOoXoXO Void r1) {
                }

                @Override // com.blankj.utilcode.util.ThreadUtils.Task
                @OXOo.oOoXoXO
                public Void doInBackground() {
                    String substring;
                    if (!Xo0.f24349oIX0oI.oIX0oI().getBoolean(XoI0Ixx0.f24489xoIox, false)) {
                        return null;
                    }
                    Date date = new Date();
                    String str = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(date) + ".txt";
                    String format = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault()).format(date);
                    int ceil = (int) Math.ceil(this.f20774XO.length() / 140);
                    String str2 = this.f20774XO;
                    LogLevel logLevel = this.f20773Oo;
                    for (int i = 0; i < ceil; i++) {
                        if (i == ceil - 1) {
                            substring = str2.substring(i * 140, str2.length());
                            IIX0o.oO(substring, "substring(...)");
                        } else {
                            substring = str2.substring(i * 140, (i + 1) * 140);
                            IIX0o.oO(substring, "substring(...)");
                        }
                        FilesKt__FileReadWriteKt.xxIXOIIO(IXxxXO.oIX0oI(X00IoxXI.oIX0oI.f3233oIX0oI, str), format + TokenParser.SP + logLevel + TokenParser.SP + substring + '\n', null, 2, null);
                    }
                    return null;
                }
            }

            @Override // Oox.IXxxXO
            @OXOo.OOXIXo
            public final Boolean invoke(@OXOo.OOXIXo LogLevel level, @OXOo.OOXIXo String str, @OXOo.OOXIXo String msg) {
                IIX0o.x0xO0oo(level, "level");
                IIX0o.x0xO0oo(str, "<anonymous parameter 1>");
                IIX0o.x0xO0oo(msg, "msg");
                ThreadUtils.executeBySingle(new oIX0oI(msg, level));
                return Boolean.FALSE;
            }
        });
        new BleConnector.Builder(app).supportNordicOta(true).supportRealtekDfu(true).supportMtkOta(true).build().addHandleCallback(this);
        xOoOIoI(app);
        XIXIxO(app);
        xOOOX();
        BleCache bleCache = BleCache.INSTANCE;
        if (IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL) || IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL707) || IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL707LITE)) {
            ooXIXxIX.II0xO0(app);
        }
        BleConnectStateManager.f20314oIX0oI.XO(app);
        AIWatchFaceManager.f19897oIX0oI.x0XOIxOo(app);
    }

    public final String oOXoIIIo(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return "UNKNOWN";
                }
                return "OFFHOOK";
            }
            return "RINGING";
        }
        return "IDLE";
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24614XX)
    public final void oOo(boolean z) {
        final boolean z2;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("onUnbind");
        if (z) {
            BleConnector.sendData$default(BleConnector.INSTANCE, BleKey.IDENTITY, BleKeyFlag.DELETE, null, false, false, 28, null);
        } else {
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24561I0, null, 2, null);
        }
        BleDeviceInfo mDeviceInfo = BleCache.INSTANCE.getMDeviceInfo();
        if (mDeviceInfo != null) {
            com.sma.smartv3.biz.oOoXoXO.f20294oIX0oI.oxoX(mDeviceInfo);
        }
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (!productManager.o0Oo() && !productManager.XXoO0oX()) {
            z2 = false;
        } else {
            z2 = true;
        }
        new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.initializer.xxIXOIIO
            @Override // java.lang.Runnable
            public final void run() {
                BleInitializer.IIX0(z2);
            }
        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    public final void oOoIIO0(boolean z) {
        f20721xII = z;
    }

    public final PressureDao oX() {
        return (PressureDao) f20699XIxXXX0x0.getValue();
    }

    @XO0.XO(tag = XoI0Ixx0.f24367IXxxXO)
    public final void oXIO0o0XI(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("BleInitializer onLocationWhere");
        f20704Xo0 = com.sma.smartv3.location.X0o0xo.oxoX();
        f20705XoI0Ixx0 = com.sma.smartv3.location.X0o0xo.II0xO0(new I0Io(), false, 2, null);
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
        if (i == 3) {
            f20715oo0xXOI0I.postDelayed(new Runnable() { // from class: com.sma.smartv3.initializer.II0XooXoX
                @Override // java.lang.Runnable
                public final void run() {
                    BleInitializer.XIXIX();
                }
            }, 3000L);
        }
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onCommandReply(@OXOo.OOXIXo BleKey bleKey, @OXOo.OOXIXo BleKeyFlag bleKeyFlag, boolean z) {
        BleHandleCallback.DefaultImpls.onCommandReply(this, bleKey, bleKeyFlag, z);
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onCommandSendTimeout(@OXOo.OOXIXo BleKey bleKey, @OXOo.OOXIXo BleKeyFlag bleKeyFlag) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        IIX0o.x0xO0oo(bleKeyFlag, "bleKeyFlag");
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
    public void onDeviceFileUpdate(@OXOo.OOXIXo BleDeviceFile deviceFile) {
        IIX0o.x0xO0oo(deviceFile, "deviceFile");
        Date date = new Date();
        date.setTime(((deviceFile.getMTime() + BleConstsKt.DATA_EPOCH) * 1000) - TimeZone.getDefault().getOffset(System.currentTimeMillis()));
        File file = new File(com.sma.smartv3.initializer.IXxxXO.Oxx0xo(X00IoxXI.oIX0oI.f3233oIX0oI), com.sma.smartv3.util.xoIox.OO0x0xX().format(date) + '.' + deviceFile.getMFileFormat());
        if (deviceFile.getMFileSize() != 0) {
            FileIOUtils.writeFileFromBytesByStream(file, deviceFile.getMFileContent(), true);
        }
        if (deviceFile.getMFileSize() == deviceFile.getMOffsetValue() + deviceFile.getMFileContent().length && deviceFile.getMFileFormat() == 3) {
            byte[] readFile2BytesByChannel = FileIOUtils.readFile2BytesByChannel(file);
            if (readFile2BytesByChannel.length > 4) {
                IIX0o.ooOOo0oXI(readFile2BytesByChannel);
                ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
                IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
                int i = ByteArrayExtKt.getInt(readFile2BytesByChannel, 0, 2, LITTLE_ENDIAN);
                IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
                int i2 = ByteArrayExtKt.getInt(readFile2BytesByChannel, 2, 2, LITTLE_ENDIAN);
                LogUtils.d("onDeviceFileUpdate -> " + i + ", " + i2);
                byte[] xxOXOOoIX2 = kotlin.collections.ooOOo0oXI.xxOXOOoIX(readFile2BytesByChannel, 4, readFile2BytesByChannel.length);
                ArraysKt___ArraysKt.ooIxXoX(xxOXOOoIX2);
                Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565);
                IIX0o.oO(createBitmap, "createBitmap(...)");
                createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(xxOXOOoIX2));
                ImageUtils.save(ImageUtils.rotate(createBitmap, 180, createBitmap.getWidth() / 2.0f, createBitmap.getHeight() / 2.0f), file.getPath() + ".png", Bitmap.CompressFormat.PNG);
                ToastUtils.showLong("图片保存成功!", new Object[0]);
            }
        }
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onDeviceRequestAGpsFile(@OXOo.OOXIXo String url) {
        IIX0o.x0xO0oo(url, "url");
        AGPSInitializer.IIXOooo(AGPSInitializer.f20674XO, false, null, 2, null);
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onDeviceSMSQuickReply(@OXOo.OOXIXo BleSMSQuickReply smsQuickReply) {
        String str;
        Object obj;
        SmsManager smsManager;
        int defaultSmsSubscriptionId;
        IIX0o.x0xO0oo(smsQuickReply, "smsQuickReply");
        String mPhone = smsQuickReply.getMPhone();
        Iterator it = BleCache.getList$default(BleCache.INSTANCE, BleKey.SMS_QUICK_REPLY_CONTENT, BleSMSQuickReplyContent.class, null, 4, null).iterator();
        while (true) {
            str = null;
            if (it.hasNext()) {
                obj = it.next();
                if (((BleSMSQuickReplyContent) obj).getMId() == smsQuickReply.getMId()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        BleSMSQuickReplyContent bleSMSQuickReplyContent = (BleSMSQuickReplyContent) obj;
        if (bleSMSQuickReplyContent != null) {
            str = bleSMSQuickReplyContent.getMContent();
        }
        if (!TextUtils.isEmpty(mPhone) && !TextUtils.isEmpty(str)) {
            LogUtils.d("sms -> p:" + mPhone + " , c:" + str);
            if (Build.VERSION.SDK_INT >= 22) {
                defaultSmsSubscriptionId = SmsManager.getDefaultSmsSubscriptionId();
                LogUtils.d("Default subId " + defaultSmsSubscriptionId);
                smsManager = SmsManager.getSmsManagerForSubscriptionId(defaultSmsSubscriptionId);
            } else {
                smsManager = SmsManager.getDefault();
            }
            ArrayList<String> divideMessage = smsManager.divideMessage(str);
            IIX0o.oO(divideMessage, "divideMessage(...)");
            Iterator<String> it2 = divideMessage.iterator();
            while (it2.hasNext()) {
                smsManager.sendTextMessage(mPhone, null, it2.next(), null, null);
            }
        }
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
        if (z) {
            if (ProductManager.f20544oIX0oI.OoIXo()) {
                com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24661xo0x, null, 2, null);
            }
            O0IxXx();
            return;
        }
        x0OxxIOxX();
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onFindWatchUpdate(int i) {
        BleHandleCallback.DefaultImpls.onFindWatchUpdate(this, i);
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onFollowSystemLanguage(boolean z) {
        Xo0 xo0 = Xo0.f24349oIX0oI;
        SPUtils II0xO02 = xo0.II0xO0();
        Languages languages = Languages.INSTANCE;
        II0xO02.put(XoI0Ixx0.f24413XI0IXoo, Languages.languageToCode$default(languages, null, 0, 3, null));
        BleConnector.sendInt8$default(BleConnector.INSTANCE, BleKey.LANGUAGE, BleKeyFlag.UPDATE, xo0.II0xO0().getInt(XoI0Ixx0.f24413XI0IXoo, Languages.languageToCode$default(languages, null, 0, 3, null)), false, false, 24, null);
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
        MyNotificationListenerService.oIX0oI oix0oi = MyNotificationListenerService.f20319OxI;
        Application app = Utils.getApp();
        IIX0o.oO(app, "getApp(...)");
        oix0oi.oIX0oI(app);
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
        if (z) {
            com.sma.smartv3.app.II0xO0.f19811OxxIIOOXO.II0xO0();
            DeviceInfoChecker.OOXIXo(DeviceInfoChecker.f19983oIX0oI, null, null, 3, null);
            com.sma.smartv3.biz.oOoXoXO.f20294oIX0oI.oIX0oI(bleDeviceInfo);
            Xo0.f24349oIX0oI.XO().put(XoI0Ixx0.f24399Ox0O, ProductManager.f20544oIX0oI.xx0());
        }
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onIdentityDelete(boolean z) {
        BleHandleCallback.DefaultImpls.onIdentityDelete(this, z);
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onIdentityDeleteByDevice(boolean z) {
        if (!f20714oo) {
            BleConnector bleConnector = BleConnector.INSTANCE;
            if (bleConnector.isBound()) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("onIdentityDeleteByDevice onUnbind");
                bleConnector.closeConnection(true);
                oOo(false);
            }
        }
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onIncomingCallRingUpdate(int i) {
        BleHandleCallback.DefaultImpls.onIncomingCallRingUpdate(this, i);
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    @SuppressLint({"MissingPermission"})
    public void onIncomingCallStatus(int i) {
        if (i == 0) {
            try {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 26) {
                    PermissionUtils permission = PermissionUtils.permission(PermissionConstants.PHONE);
                    IIX0o.oO(permission, "permission(...)");
                    oOXoIIIo.X0o0xo.I0Io(permission, null, null, new Oox.oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.BleInitializer$onIncomingCallStatus$1
                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                            invoke2(permissionStatus);
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo PermissionStatus it) {
                            IIX0o.x0xO0oo(it, "it");
                            if (it == PermissionStatus.GRANTED) {
                                LogUtils.d("hang up OK");
                                TelecomManager telecomManager = (TelecomManager) Utils.getApp().getSystemService("telecom");
                                if (telecomManager != null) {
                                    telecomManager.acceptRingingCall();
                                }
                            }
                        }
                    }, 3, null);
                    return;
                }
                if (i2 >= 23 && i2 < 26) {
                    Object systemService = Utils.getApp().getSystemService("media_session");
                    IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.media.session.MediaSessionManager");
                    List<MediaController> activeSessions = ((MediaSessionManager) systemService).getActiveSessions(new ComponentName(Utils.getApp(), (Class<?>) MyNotificationListenerService.class));
                    IIX0o.oO(activeSessions, "getActiveSessions(...)");
                    for (MediaController mediaController : activeSessions) {
                        if (IIX0o.Oxx0IOOO(BleNotification.ANDROID_TELECOM, mediaController.getPackageName())) {
                            mediaController.dispatchMediaButtonEvent(new KeyEvent(0, 79));
                            mediaController.dispatchMediaButtonEvent(new KeyEvent(1, 79));
                            return;
                        }
                    }
                    return;
                }
                AudioManager audioManager = (AudioManager) Utils.getApp().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
                KeyEvent keyEvent = new KeyEvent(0, 79);
                KeyEvent keyEvent2 = new KeyEvent(1, 79);
                if (audioManager != null) {
                    audioManager.dispatchMediaKeyEvent(keyEvent);
                }
                if (audioManager != null) {
                    audioManager.dispatchMediaKeyEvent(keyEvent2);
                }
                Runtime.getRuntime().exec("input keyevent " + Integer.toString(79));
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (Build.VERSION.SDK_INT < 28) {
            try {
                Class<?> cls = Class.forName("com.android.internal.telephony.ITelephony");
                Class<?> cls2 = cls.getClasses()[0];
                Class<?> cls3 = Class.forName("android.os.ServiceManager");
                Class<?> cls4 = Class.forName("android.os.ServiceManagerNative");
                Method method = cls3.getMethod("getService", String.class);
                Method method2 = cls4.getMethod("asInterface", IBinder.class);
                Binder binder = new Binder();
                binder.attachInterface(null, "fake");
                Object invoke = method.invoke(method2.invoke(null, binder), "phone");
                IIX0o.x0XOIxOo(invoke, "null cannot be cast to non-null type android.os.IBinder");
                cls.getMethod("endCall", null).invoke(cls2.getMethod("asInterface", IBinder.class).invoke(null, (IBinder) invoke), null);
                return;
            } catch (Exception e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("hang up error ");
                e2.printStackTrace();
                sb.append(oXIO0o0XI.f29392oIX0oI);
                LogUtils.d(sb.toString());
                return;
            }
        }
        PermissionUtils permission2 = PermissionUtils.permission(PermissionConstants.PHONE);
        IIX0o.oO(permission2, "permission(...)");
        oOXoIIIo.X0o0xo.I0Io(permission2, null, null, new Oox.oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.BleInitializer$onIncomingCallStatus$2
            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                invoke2(permissionStatus);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo PermissionStatus it) {
                IIX0o.x0xO0oo(it, "it");
                if (it == PermissionStatus.GRANTED) {
                    LogUtils.d("hang up OK");
                    Object systemService2 = Utils.getApp().getSystemService("telecom");
                    IIX0o.x0XOIxOo(systemService2, "null cannot be cast to non-null type android.telecom.TelecomManager");
                    ((TelecomManager) systemService2).endCall();
                }
            }
        }, 3, null);
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
        BleCache bleCache = BleCache.INSTANCE;
        BleKey bleKey = BleKey.QIBLA_SET;
        BleQiblaSettings bleQiblaSettings = (BleQiblaSettings) BleCache.getObjectNotNull$default(bleCache, bleKey, BleQiblaSettings.class, null, null, 12, null);
        com.sma.smartv3.location.oIX0oI ooOOo0oXI2 = UtilsKt.ooOOo0oXI();
        Calendar calendar = Calendar.getInstance();
        IIX0o.oO(calendar, "getInstance(...)");
        long OxxIIOOXO2 = com.sma.smartv3.util.xoIox.OxxIIOOXO(calendar);
        bleQiblaSettings.setMStartTime((int) (System.currentTimeMillis() / 1000));
        Object fromJson = new Gson().fromJson(Xo0.f24349oIX0oI.oIX0oI().getString(PrayerTimeSettings.class.getName()), (Class<Object>) PrayerTimeSettings.class);
        if (fromJson == null) {
            fromJson = PrayerTimeSettings.class.newInstance();
        }
        bleQiblaSettings.setMPrayerTimes(PrayerTimesKt.toBlePrayerTimes(PrayerTimesKt.getPrayerTimeMap$default((PrayerTimeSettings) fromJson, ooOOo0oXI2.II0xO0(), ooOOo0oXI2.I0Io(), OxxIIOOXO2, 0, 16, null)));
        com.sma.smartv3.util.IIX0o x0XOIxOo2 = com.sma.smartv3.util.xoIox.x0XOIxOo(OxxIIOOXO2, 0, 2, null);
        bleQiblaSettings.setMHijriYear(x0XOIxOo2.II0XooXoX());
        bleQiblaSettings.setMHijriMonth(x0XOIxOo2.Oxx0IOOO());
        bleQiblaSettings.setMHijriDay(x0XOIxOo2.XO());
        BleConnector.sendObject$default(BleConnector.INSTANCE, bleKey, BleKeyFlag.UPDATE, bleQiblaSettings, false, false, 24, null);
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
    public void onReadActivity(@OXOo.OOXIXo final List<BleActivity> activities) {
        IIX0o.x0xO0oo(activities, "activities");
        final SimpleDateFormat I0Io2 = com.sma.smartv3.util.xoIox.I0Io();
        final Date date = new Date();
        final long offset = TimeZone.getDefault().getOffset(System.currentTimeMillis());
        ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<Void>() { // from class: com.sma.smartv3.initializer.BleInitializer$onReadActivity$1
            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public void onSuccess(@OXOo.oOoXoXO Void r1) {
            }

            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            @OXOo.oOoXoXO
            public Void doInBackground() {
                ActivityDao x0o2;
                x0o2 = BleInitializer.f20700XO.x0o();
                List<BleActivity> list = activities;
                long j = offset;
                Date date2 = date;
                SimpleDateFormat simpleDateFormat = I0Io2;
                ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    Activity activity = new Activity((BleActivity) it.next(), j);
                    date2.setTime(activity.getMTime());
                    String format = simpleDateFormat.format(date2);
                    IIX0o.oO(format, "format(...)");
                    activity.setMLocalTime(format);
                    if (!ProductManager.f20544oIX0oI.oxO() && activity.getMState() == 4) {
                        final WorkoutIndex workoutIndex = new WorkoutIndex(0, 1, activity.getMTime(), activity.getMMode(), 0, 17, null);
                        Application app = Utils.getApp();
                        IIX0o.oO(app, "getApp(...)");
                        FunctionKt.Oxx0IOOO(app, workoutIndex, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.BleInitializer$onReadActivity$1$doInBackground$1$2$1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            public final void invoke(boolean z) {
                                WorkoutIndexDao OO2;
                                if (z) {
                                    return;
                                }
                                OO2 = BleInitializer.f20700XO.OO();
                                OO2.insert(WorkoutIndex.this);
                            }
                        });
                    }
                    arrayList.add(activity);
                }
                x0o2.insert(arrayList);
                com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24629oIX0oI, null, 2, null);
                return null;
            }
        });
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
    public void onReadAlipayBindInfo(@OXOo.OOXIXo List<BleAlipayBindInfo> alipayBindInfos) {
        IIX0o.x0xO0oo(alipayBindInfos, "alipayBindInfos");
        LogUtils.d(alipayBindInfos);
        ThreadUtils.executeByIo(new oxoX(alipayBindInfos, TimeZone.getDefault().getOffset(System.currentTimeMillis()), new Date(), com.sma.smartv3.util.xoIox.I0Io()));
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
    public void onReadBleHrv(@OXOo.OOXIXo List<BleHrv> hrv) {
        IIX0o.x0xO0oo(hrv, "hrv");
        LogUtils.d(hrv);
        ThreadUtils.executeByIo(new X0o0xo(hrv, TimeZone.getDefault().getOffset(System.currentTimeMillis()), new Date(), com.sma.smartv3.util.xoIox.I0Io()));
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReadBleHrv2(@OXOo.OOXIXo List<BleHrv2> list) {
        BleHandleCallback.DefaultImpls.onReadBleHrv2(this, list);
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReadBleLogText(@OXOo.OOXIXo List<BleLogText> logs) {
        IIX0o.x0xO0oo(logs, "logs");
        try {
            FilesKt__FileReadWriteKt.xxIXOIIO(com.sma.smartv3.initializer.IXxxXO.I0Io(X00IoxXI.oIX0oI.f3233oIX0oI, com.sma.smartv3.util.xoIox.oxoX().format(new Date()) + ".txt"), CollectionsKt___CollectionsKt.OoIXo(logs, "\n", null, null, 0, null, new Oox.oOoXoXO<BleLogText, CharSequence>() { // from class: com.sma.smartv3.initializer.BleInitializer$onReadBleLogText$1
                @Override // Oox.oOoXoXO
                @OXOo.OOXIXo
                public final CharSequence invoke(@OXOo.OOXIXo BleLogText it) {
                    IIX0o.x0xO0oo(it, "it");
                    return it.getMContent();
                }
            }, 30, null), null, 2, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReadBloodGlucose(@OXOo.OOXIXo List<BleBloodGlucose> bloodGlucoses) {
        IIX0o.x0xO0oo(bloodGlucoses, "bloodGlucoses");
        LogUtils.d(bloodGlucoses);
        ThreadUtils.executeByIo(new XO(bloodGlucoses, TimeZone.getDefault().getOffset(System.currentTimeMillis()), new Date(), com.sma.smartv3.util.xoIox.I0Io()));
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReadBloodOxyGenSettings(@OXOo.OOXIXo BleBloodOxyGenSettings bleBloodOxyGenSettings) {
        BleHandleCallback.DefaultImpls.onReadBloodOxyGenSettings(this, bleBloodOxyGenSettings);
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReadBloodOxygen(@OXOo.OOXIXo List<BleBloodOxygen> bloodOxygen) {
        IIX0o.x0xO0oo(bloodOxygen, "bloodOxygen");
        LogUtils.d(bloodOxygen);
        ThreadUtils.executeByIo(new Oxx0IOOO(bloodOxygen, TimeZone.getDefault().getOffset(System.currentTimeMillis()), new Date(), com.sma.smartv3.util.xoIox.I0Io()));
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReadBloodPressure(@OXOo.OOXIXo List<BleBloodPressure> bloodPressures) {
        IIX0o.x0xO0oo(bloodPressures, "bloodPressures");
        ThreadUtils.executeByIo(new II0XooXoX(bloodPressures, TimeZone.getDefault().getOffset(System.currentTimeMillis()), new Date(), com.sma.smartv3.util.xoIox.I0Io()));
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
    public void onReadDailyPower(@OXOo.OOXIXo List<BlePhysicalPower> powers) {
        IIX0o.x0xO0oo(powers, "powers");
        ThreadUtils.executeByIo(new xxIXOIIO(powers, TimeZone.getDefault().getOffset(System.currentTimeMillis()), new Date(), com.sma.smartv3.util.xoIox.I0Io()));
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
    public void onReadEarphoneState(@OXOo.OOXIXo BleEarphoneState earphoneState) {
        IIX0o.x0xO0oo(earphoneState, "earphoneState");
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReadEcg(@OXOo.OOXIXo List<BleEcg> ecgs) {
        IIX0o.x0xO0oo(ecgs, "ecgs");
        ThreadUtils.executeByIo(new xoIox(ecgs));
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
    public void onReadFirmwareVersion(@OXOo.OOXIXo String version) {
        IIX0o.x0xO0oo(version, "version");
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        sb.append("info:\n");
        sb.append(UtilsKt.X0o0xo());
        sb.append('\n');
        PermissionHelper permissionHelper = PermissionHelper.f24522oIX0oI;
        Application app = Utils.getApp();
        IIX0o.oO(app, "getApp(...)");
        sb.append(permissionHelper.x0xO0oo(app));
        oix0oi.oIX0oI(sb.toString());
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
    public void onReadGoMoreSettings(@OXOo.OOXIXo BleGoMoreSettings goMoreSettings) {
        String str;
        IIX0o.x0xO0oo(goMoreSettings, "goMoreSettings");
        if (!BleConnector.INSTANCE.isNeedBind()) {
            return;
        }
        goMoreSettings.setMType(ProductManager.f20544oIX0oI.II0xO0(goMoreSettings.getMType()));
        BleGoMoreSettings bleGoMoreSettings = (BleGoMoreSettings) new Gson().fromJson(Xo0.f24349oIX0oI.I0Io().getString(BleGoMoreSettings.class.getName()), BleGoMoreSettings.class);
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI("cache -> " + bleGoMoreSettings);
        if (!TextUtils.isEmpty(goMoreSettings.getMKey())) {
            String mKey = goMoreSettings.getMKey();
            if (bleGoMoreSettings != null) {
                str = bleGoMoreSettings.getMKey();
            } else {
                str = null;
            }
            if (IIX0o.Oxx0IOOO(mKey, str)) {
                oix0oi.oIX0oI("getGoMoreAuthKey -> " + goMoreSettings.getMType() + " - GoMore activated!");
                return;
            }
        }
        DeviceInfoChecker.f19983oIX0oI.oO(goMoreSettings.getMUuid(), goMoreSettings.getMType());
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
    public void onReadHanBaoVibration(@OXOo.OOXIXo List<BleHanBaoVibration> hanBaoVibrations) {
        IIX0o.x0xO0oo(hanBaoVibrations, "hanBaoVibrations");
        ThreadUtils.executeByIo(new OOXIXo(hanBaoVibrations, TimeZone.getDefault().getOffset(System.currentTimeMillis()), new Date(), com.sma.smartv3.util.xoIox.I0Io()));
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReadHeartRate(@OXOo.OOXIXo List<BleHeartRate> heartRates) {
        IIX0o.x0xO0oo(heartRates, "heartRates");
        ThreadUtils.executeByIo(new oOoXoXO(heartRates, TimeZone.getDefault().getOffset(System.currentTimeMillis()), new Date(), com.sma.smartv3.util.xoIox.I0Io()));
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
    public void onReadLocation(@OXOo.OOXIXo List<BleLocation> locations) {
        IIX0o.x0xO0oo(locations, "locations");
        ThreadUtils.executeByIo(new ooOOo0oXI(locations, TimeZone.getDefault().getOffset(System.currentTimeMillis()), new Date(), com.sma.smartv3.util.xoIox.I0Io()));
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReadLoveTapUser(@OXOo.OOXIXo List<BleLoveTapUser> list) {
        BleHandleCallback.DefaultImpls.onReadLoveTapUser(this, list);
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReadMatchRecord(@OXOo.OOXIXo List<BleMatchRecord> matchRecords) {
        IIX0o.x0xO0oo(matchRecords, "matchRecords");
        ThreadUtils.executeByIo(new x0XOIxOo(matchRecords, TimeZone.getDefault().getOffset(System.currentTimeMillis()), new Date(), com.sma.smartv3.util.xoIox.I0Io()));
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReadMatchRecord2(@OXOo.OOXIXo List<BleMatchRecord2> matchRecords) {
        IIX0o.x0xO0oo(matchRecords, "matchRecords");
        ThreadUtils.executeByIo(new oO(matchRecords, TimeZone.getDefault().getOffset(System.currentTimeMillis()), new Date(), com.sma.smartv3.util.xoIox.I0Io()));
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
    public void onReadPackageStatus(@OXOo.OOXIXo BlePackageStatus packageStatus) {
        IIX0o.x0xO0oo(packageStatus, "packageStatus");
        com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24644oxXx0IX, packageStatus);
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
    public void onReadPressure(@OXOo.OOXIXo List<BlePressure> pressures) {
        IIX0o.x0xO0oo(pressures, "pressures");
        ThreadUtils.executeByIo(new x0xO0oo(pressures, TimeZone.getDefault().getOffset(System.currentTimeMillis()), new Date(), com.sma.smartv3.util.xoIox.I0Io()));
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
    public void onReadRri(@OXOo.OOXIXo List<BleRri> rris) {
        IIX0o.x0xO0oo(rris, "rris");
        ThreadUtils.executeByIo(new IXxxXO(rris, new Date(), TimeZone.getDefault().getOffset(System.currentTimeMillis()), com.sma.smartv3.util.xoIox.oxoX(), com.sma.smartv3.util.xoIox.I0Io()));
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
    public void onReadSleep(@OXOo.OOXIXo List<BleSleep> sleeps) {
        IIX0o.x0xO0oo(sleeps, "sleeps");
        ThreadUtils.executeByIo(new Oxx0xo(sleeps, TimeZone.getDefault().getOffset(System.currentTimeMillis()), new Date(), com.sma.smartv3.util.xoIox.I0Io(), BleCache.INSTANCE.getMSleepAlgorithmType()));
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
        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24582IxIX0I, null, 2, null);
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReadSleepRaw(@OXOo.OOXIXo byte[] sleepRawData) {
        IIX0o.x0xO0oo(sleepRawData, "sleepRawData");
        try {
            FilesKt__FileReadWriteKt.xxIXOIIO(com.sma.smartv3.initializer.IXxxXO.oxoX(X00IoxXI.oIX0oI.f3233oIX0oI, com.sma.smartv3.util.xoIox.xoIox().format(new Date()) + ".txt"), ByteArrayExtKt.getMHexString(sleepRawData), null, 2, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public void onReadTemperature(@OXOo.OOXIXo List<BleTemperature> temperatures) {
        IIX0o.x0xO0oo(temperatures, "temperatures");
        LogUtils.d(temperatures);
        ThreadUtils.executeByIo(new oI0IIXIo(temperatures, TimeZone.getDefault().getOffset(System.currentTimeMillis()), new Date(), com.sma.smartv3.util.xoIox.I0Io()));
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
        BleCache bleCache = BleCache.INSTANCE;
        BleCache.remove$default(bleCache, BleKey.WEATHER_REALTIME, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.WEATHER_FORECAST, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.WEATHER_REALTIME2, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.WEATHER_FORECAST2, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.WEATHER_REALTIME3, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.WEATHER_FORECAST3, null, 2, null);
        WeatherInitializer.f20909XO.IXxxXO();
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReadWorkout(@OXOo.OOXIXo final List<BleWorkout> workouts) {
        IIX0o.x0xO0oo(workouts, "workouts");
        LogUtils.i("onReadWorkout " + BleCache.INSTANCE + ".mPlatform");
        final SimpleDateFormat I0Io2 = com.sma.smartv3.util.xoIox.I0Io();
        final Date date = new Date();
        final long offset = (long) TimeZone.getDefault().getOffset(System.currentTimeMillis());
        ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<Void>() { // from class: com.sma.smartv3.initializer.BleInitializer$onReadWorkout$1
            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public void onSuccess(@OXOo.oOoXoXO Void r1) {
            }

            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            @OXOo.oOoXoXO
            public Void doInBackground() {
                WorkoutDao xoxXI2;
                xoxXI2 = BleInitializer.f20700XO.xoxXI();
                List<BleWorkout> list = workouts;
                long j = offset;
                Date date2 = date;
                SimpleDateFormat simpleDateFormat = I0Io2;
                ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    Workout workout = new Workout((BleWorkout) it.next(), j);
                    date2.setTime(workout.getMStart());
                    String format = simpleDateFormat.format(date2);
                    IIX0o.oO(format, "format(...)");
                    workout.setMLocalTime(format);
                    BleCache bleCache = BleCache.INSTANCE;
                    if (bleCache.getMBleName().length() > 0) {
                        workout.setMFirmwareFlag(bleCache.getMFirmwareFlag());
                        workout.setMPrototype(bleCache.getMPrototype());
                        workout.setMBleName(bleCache.getMBleName());
                        workout.setMPlatform(bleCache.getMPlatform());
                        workout.setMAGpsType(bleCache.getMAGpsType());
                    }
                    final WorkoutIndex workoutIndex = new WorkoutIndex(0, 2, workout.getMEnd(), workout.getMMode(), 0, 17, null);
                    Application app = Utils.getApp();
                    IIX0o.oO(app, "getApp(...)");
                    FunctionKt.Oxx0IOOO(app, workoutIndex, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.BleInitializer$onReadWorkout$1$doInBackground$1$2$1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        public final void invoke(boolean z) {
                            WorkoutIndexDao OO2;
                            if (z) {
                                return;
                            }
                            OO2 = BleInitializer.f20700XO.OO();
                            OO2.insert(WorkoutIndex.this);
                        }
                    });
                    arrayList.add(workout);
                }
                xoxXI2.insert(arrayList);
                com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24605X0o0xo, null, 2, null);
                return null;
            }
        });
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReadWorkout2(@OXOo.OOXIXo final List<BleWorkout2> workouts) {
        IIX0o.x0xO0oo(workouts, "workouts");
        final SimpleDateFormat I0Io2 = com.sma.smartv3.util.xoIox.I0Io();
        final Date date = new Date();
        final long offset = TimeZone.getDefault().getOffset(System.currentTimeMillis());
        ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<Void>() { // from class: com.sma.smartv3.initializer.BleInitializer$onReadWorkout2$1
            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public void onSuccess(@OXOo.oOoXoXO Void r1) {
            }

            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            @OXOo.oOoXoXO
            public Void doInBackground() {
                WorkoutDao xoxXI2;
                xoxXI2 = BleInitializer.f20700XO.xoxXI();
                List<BleWorkout2> list = workouts;
                long j = offset;
                Date date2 = date;
                SimpleDateFormat simpleDateFormat = I0Io2;
                ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    Workout workout = new Workout((BleWorkout2) it.next(), j);
                    date2.setTime(workout.getMStart());
                    String format = simpleDateFormat.format(date2);
                    IIX0o.oO(format, "format(...)");
                    workout.setMLocalTime(format);
                    BleCache bleCache = BleCache.INSTANCE;
                    if (bleCache.getMBleName().length() > 0) {
                        workout.setMFirmwareFlag(bleCache.getMFirmwareFlag());
                        workout.setMPrototype(bleCache.getMPrototype());
                        workout.setMBleName(bleCache.getMBleName());
                        workout.setMPlatform(bleCache.getMPlatform());
                        workout.setMAGpsType(bleCache.getMAGpsType());
                    }
                    final WorkoutIndex workoutIndex = new WorkoutIndex(0, 2, workout.getMEnd(), workout.getMMode(), 0, 17, null);
                    Application app = Utils.getApp();
                    IIX0o.oO(app, "getApp(...)");
                    FunctionKt.Oxx0IOOO(app, workoutIndex, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.BleInitializer$onReadWorkout2$1$doInBackground$1$2$1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        public final void invoke(boolean z) {
                            WorkoutIndexDao OO2;
                            if (z) {
                                return;
                            }
                            OO2 = BleInitializer.f20700XO.OO();
                            OO2.insert(WorkoutIndex.this);
                        }
                    });
                    arrayList.add(workout);
                }
                xoxXI2.insert(arrayList);
                com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24605X0o0xo, null, 2, null);
                return null;
            }
        });
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReadWorkout3(@OXOo.OOXIXo final List<BleWorkout3> workouts) {
        IIX0o.x0xO0oo(workouts, "workouts");
        LogUtils.i("onReadWorkout3 " + BleCache.INSTANCE + ".mPlatform");
        final SimpleDateFormat I0Io2 = com.sma.smartv3.util.xoIox.I0Io();
        final Date date = new Date();
        final long offset = (long) TimeZone.getDefault().getOffset(System.currentTimeMillis());
        ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<Void>() { // from class: com.sma.smartv3.initializer.BleInitializer$onReadWorkout3$1
            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public void onSuccess(@OXOo.oOoXoXO Void r1) {
            }

            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            @OXOo.oOoXoXO
            public Void doInBackground() {
                WorkoutDao xoxXI2;
                xoxXI2 = BleInitializer.f20700XO.xoxXI();
                List<BleWorkout3> list = workouts;
                long j = offset;
                Date date2 = date;
                SimpleDateFormat simpleDateFormat = I0Io2;
                ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    Workout workout = new Workout((BleWorkout3) it.next(), j);
                    date2.setTime(workout.getMStart());
                    String format = simpleDateFormat.format(date2);
                    IIX0o.oO(format, "format(...)");
                    workout.setMLocalTime(format);
                    BleCache bleCache = BleCache.INSTANCE;
                    if (bleCache.getMBleName().length() > 0) {
                        workout.setMFirmwareFlag(bleCache.getMFirmwareFlag());
                        workout.setMPrototype(bleCache.getMPrototype());
                        workout.setMBleName(bleCache.getMBleName());
                        workout.setMPlatform(bleCache.getMPlatform());
                        workout.setMAGpsType(bleCache.getMAGpsType());
                    }
                    final WorkoutIndex workoutIndex = new WorkoutIndex(0, 2, workout.getMEnd(), workout.getMMode(), 0, 17, null);
                    Application app = Utils.getApp();
                    IIX0o.oO(app, "getApp(...)");
                    FunctionKt.Oxx0IOOO(app, workoutIndex, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.BleInitializer$onReadWorkout3$1$doInBackground$1$2$1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        public final void invoke(boolean z) {
                            WorkoutIndexDao OO2;
                            if (z) {
                                return;
                            }
                            OO2 = BleInitializer.f20700XO.OO();
                            OO2.insert(WorkoutIndex.this);
                        }
                    });
                    arrayList.add(workout);
                }
                xoxXI2.insert(arrayList);
                com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24605X0o0xo, null, 2, null);
                return null;
            }
        });
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
    public void onReceiveGSensorMotion(@OXOo.OOXIXo List<BleGSensorMotion> gSensorMotions) {
        IIX0o.x0xO0oo(gSensorMotions, "gSensorMotions");
        ThreadUtils.executeByIo(new OxxIIOOXO(gSensorMotions, new Date(), com.sma.smartv3.util.xoIox.oxoX(), com.sma.smartv3.util.xoIox.I0Io()));
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReceiveGSensorRaw(@OXOo.OOXIXo List<BleGSensorRaw> list) {
        BleHandleCallback.DefaultImpls.onReceiveGSensorRaw(this, list);
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReceiveGSensorSHSY(@OXOo.OOXIXo List<BleGSensorSHSY> gSensorSHSYs) {
        IIX0o.x0xO0oo(gSensorSHSYs, "gSensorSHSYs");
        SimpleDateFormat OO0x0xX2 = com.sma.smartv3.util.xoIox.OO0x0xX();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        IIX0o.ooOOo0oXI(calendar);
        oOXoIIIo.II0xO0.oI0IIXIo(calendar, 0);
        oOXoIIIo.II0xO0.IIXOooo(calendar, 0);
        oOXoIIIo.II0xO0.O0xOxO(calendar, 0);
        oOXoIIIo.II0xO0.OxxIIOOXO(calendar, 0);
        ThreadUtils.executeByIo(new IIXOooo(gSensorSHSYs, calendar, OO0x0xX2, simpleDateFormat));
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
        IIX0o.x0xO0oo(musicCommand, "musicCommand");
        MyNotificationListenerService.oIX0oI oix0oi = MyNotificationListenerService.f20319OxI;
        Application app = Utils.getApp();
        IIX0o.oO(app, "getApp(...)");
        oix0oi.oIX0oI(app);
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReceivePpgSHSY(@OXOo.OOXIXo List<BlePpgSHSY> ppgSHSYs) {
        IIX0o.x0xO0oo(ppgSHSYs, "ppgSHSYs");
        SimpleDateFormat OO0x0xX2 = com.sma.smartv3.util.xoIox.OO0x0xX();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        IIX0o.ooOOo0oXI(calendar);
        oOXoIIIo.II0xO0.oI0IIXIo(calendar, 0);
        oOXoIIIo.II0xO0.IIXOooo(calendar, 0);
        oOXoIIIo.II0xO0.O0xOxO(calendar, 0);
        oOXoIIIo.II0xO0.OxxIIOOXO(calendar, 0);
        ThreadUtils.executeByIo(new xoXoI(ppgSHSYs, calendar, OO0x0xX2, simpleDateFormat));
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReceiveRealtimeLog(@OXOo.OOXIXo BleRealtimeLog realtimeLog) {
        IIX0o.x0xO0oo(realtimeLog, "realtimeLog");
        try {
            if (StringsKt__StringsKt.o00xOoIO(realtimeLog.getMContent(), "csv-1", false, 2, null)) {
                FilesKt__FileReadWriteKt.xxIXOIIO(com.sma.smartv3.initializer.IXxxXO.I0Io(X00IoxXI.oIX0oI.f3233oIX0oI, com.sma.smartv3.util.xoIox.Oxx0IOOO().format(new Date()) + "-1.csv"), kotlin.text.OxI.IIOIX(realtimeLog.getMContent(), "    csv-1", "", false, 4, null), null, 2, null);
            } else if (StringsKt__StringsKt.o00xOoIO(realtimeLog.getMContent(), "csv-2", false, 2, null)) {
                FilesKt__FileReadWriteKt.xxIXOIIO(com.sma.smartv3.initializer.IXxxXO.I0Io(X00IoxXI.oIX0oI.f3233oIX0oI, com.sma.smartv3.util.xoIox.Oxx0IOOO().format(new Date()) + "-2.csv"), kotlin.text.OxI.IIOIX(realtimeLog.getMContent(), "    csv-2", "", false, 4, null), null, 2, null);
            } else {
                FilesKt__FileReadWriteKt.xxIXOIIO(com.sma.smartv3.initializer.IXxxXO.I0Io(X00IoxXI.oIX0oI.f3233oIX0oI, com.sma.smartv3.util.xoIox.Oxx0IOOO().format(new Date()) + ".txt"), realtimeLog.getMContent(), null, 2, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReceiveRecordPacket(@OXOo.OOXIXo BleRecordPacket bleRecordPacket) {
        BleHandleCallback.DefaultImpls.onReceiveRecordPacket(this, bleRecordPacket);
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onRequestAgpsPrerequisite() {
        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.LOCATION);
        IIX0o.oO(permission, "permission(...)");
        oOXoIIIo.X0o0xo.I0Io(permission, null, null, new Oox.oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.BleInitializer$onRequestAgpsPrerequisite$1
            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                invoke2(permissionStatus);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo PermissionStatus status) {
                com.sma.smartv3.location.oxoX oxox;
                IIX0o.x0xO0oo(status, "status");
                if (status == PermissionStatus.GRANTED) {
                    oxox = BleInitializer.f20705XoI0Ixx0;
                    if (oxox != null) {
                        oxox.XO(R.string.get_your_location, false);
                        return;
                    }
                    return;
                }
                LogUtils.v("onRequestAgpsPrerequisite -> Location permission is not granted");
            }
        }, 3, null);
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onRequestLocation(final int i) {
        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.LOCATION);
        IIX0o.oO(permission, "permission(...)");
        oOXoIIIo.X0o0xo.I0Io(permission, null, null, new Oox.oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.BleInitializer$onRequestLocation$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                invoke2(permissionStatus);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo PermissionStatus status) {
                IIX0o.x0xO0oo(status, "status");
                if (status == PermissionStatus.GRANTED) {
                    int i2 = i;
                    if (i2 == 1) {
                        BleInitializer bleInitializer = BleInitializer.f20700XO;
                        bleInitializer.oI(System.currentTimeMillis());
                        bleInitializer.Ix00oIoI(0);
                        Xo0 xo0 = Xo0.f24349oIX0oI;
                        xo0.oIX0oI().put(XoI0Ixx0.f24404Oxx0xo, "");
                        xo0.oIX0oI().put(XoI0Ixx0.f24361IIXOooo, true, true);
                        bleInitializer.xxOXOOoIX();
                        return;
                    }
                    if (i2 == 2) {
                        Xo0 xo02 = Xo0.f24349oIX0oI;
                        if (!xo02.oIX0oI().getBoolean(XoI0Ixx0.f24441oI0IIXIo, false)) {
                            BleInitializer.f20700XO.xxOXOOoIX();
                        } else {
                            xo02.oIX0oI().put(XoI0Ixx0.f24405OxxIIOOXO, false, true);
                        }
                        xo02.oIX0oI().put(XoI0Ixx0.f24361IIXOooo, true, true);
                        return;
                    }
                    if (i2 == 3) {
                        Xo0.f24349oIX0oI.oIX0oI().put(XoI0Ixx0.f24405OxxIIOOXO, true, true);
                        return;
                    }
                    if (i2 != 4) {
                        LogUtils.v("Unknown workoutState");
                        return;
                    }
                    Xo0 xo03 = Xo0.f24349oIX0oI;
                    xo03.oIX0oI().put(XoI0Ixx0.f24404Oxx0xo, "");
                    xo03.oIX0oI().put(XoI0Ixx0.f24405OxxIIOOXO, true, true);
                    BleInitializer.f20700XO.IxIX0I(false);
                    return;
                }
                LogUtils.v("onRequestLocation workout -> Location permission is not granted");
            }
        }, 3, null);
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
        if (z && !f20714oo) {
            f20682I0oOoX = 0;
            com.sma.smartv3.ble.II0xO0.f20317oIX0oI.xxX();
        } else {
            x0OxxIOxX();
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
        BleHandleCallback.DefaultImpls.onStreamProgress(this, z, i, i2, i3, bleKey);
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onSyncData(int i, @OXOo.OOXIXo BleKey bleKey) {
        BleHandleCallback.DefaultImpls.onSyncData(this, i, bleKey);
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onTimeUpdate() {
        BleConnector bleConnector = BleConnector.INSTANCE;
        BleKey bleKey = BleKey.TIME_ZONE;
        BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
        BleConnector.sendObject$default(bleConnector, bleKey, bleKeyFlag, new BleTimeZone(), false, false, 24, null);
        BleConnector.sendObject$default(bleConnector, BleKey.TIME, bleKeyFlag, BleTime.Companion.local(), false, false, 24, null);
        BleKey bleKey2 = BleKey.HOUR_SYSTEM;
        BleConnector.sendInt8$default(bleConnector, bleKey2, bleKeyFlag, BleCache.getInt$default(BleCache.INSTANCE, bleKey2, !com.sma.smartv3.util.xoIox.ooXIXxIX() ? 1 : 0, null, 4, null), false, false, 24, null);
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
    public void onUpdateBloodPressure(@OXOo.OOXIXo BleBloodPressure bloodPressure) {
        IIX0o.x0xO0oo(bloodPressure, "bloodPressure");
        ThreadUtils.executeByIo(new o00(bloodPressure, TimeZone.getDefault().getOffset(System.currentTimeMillis()), new Date(), com.sma.smartv3.util.xoIox.I0Io()));
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onUpdateHeartRate(@OXOo.OOXIXo BleHeartRate heartRate) {
        IIX0o.x0xO0oo(heartRate, "heartRate");
        if (heartRate.getMType() == 1) {
            return;
        }
        ThreadUtils.executeByIo(new OxI(heartRate, TimeZone.getDefault().getOffset(System.currentTimeMillis()), new Date(), com.sma.smartv3.util.xoIox.I0Io()));
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onUpdateTemperature(@OXOo.OOXIXo BleTemperature temperature) {
        IIX0o.x0xO0oo(temperature, "temperature");
        ThreadUtils.executeByIo(new O0xOxO(temperature, TimeZone.getDefault().getOffset(System.currentTimeMillis()), new Date(), com.sma.smartv3.util.xoIox.I0Io()));
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

    public final void oo() {
        DateTimeFormat IXxxXO2;
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        BleCache bleCache = BleCache.INSTANCE;
        if (IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), ProductManager.OOX0x)) {
            IXxxXO2 = DateTimeFormat.ddMMyyyy;
        } else {
            IXxxXO2 = projectManager.IXxxXO();
        }
        projectManager.XOxoX(IXxxXO2);
        LogUtils.d("changeDateFormat => " + projectManager.x0XOIxOo());
        BleCache.putInt$default(bleCache, BleKey.DATE_FORMAT, projectManager.x0XOIxOo().getType(), null, 4, null);
        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24594OOXIxO0, null, 2, null);
    }

    public final boolean ooOx() {
        return f20707Xx000oIo;
    }

    public final void ox(@OXOo.OOXIXo List<Workout> workouts) {
        IIX0o.x0xO0oo(workouts, "workouts");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("insert2MatchRecord -> " + workouts.size());
        MatchRecordDao I0X0x0oIo2 = I0X0x0oIo();
        List<Workout> list = workouts;
        ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
        for (Workout workout : list) {
            MatchRecord matchRecord = new MatchRecord(0, 0L, null, 0, 0, 0, null, 0, 0, null, null, 0, 0, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, kotlinx.coroutines.internal.O0xOxO.f30252xoIox, null);
            matchRecord.setMSource(1);
            matchRecord.setMMode(workout.getMMode());
            matchRecord.setMStart(workout.getMStart());
            matchRecord.setMLocalTime(workout.getMLocalTime());
            MatchPeriod matchPeriod = new MatchPeriod(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, xxXXXxIxo.f15726I0Io, null);
            matchPeriod.setMDuration(workout.getMDuration());
            matchPeriod.setMDistance(workout.getMDistance() / 10);
            matchPeriod.setMStep(workout.getMStep());
            matchPeriod.setMCalorie(workout.getMCalorie() / 1000);
            matchPeriod.setMSpeed(workout.getMSpeed() / 100);
            matchPeriod.setMAvgBpm(workout.getMAvgBpm());
            matchPeriod.setMMaxBpm(workout.getMMaxBpm());
            matchRecord.setMPeriod(matchPeriod);
            matchRecord.setMMinBpm(workout.getMMinBpm());
            matchRecord.setMAirPressure(workout.getMAirPressure());
            matchRecord.setMPace(workout.getMPace());
            matchRecord.setMMaxPace(workout.getMMaxPace());
            matchRecord.setMMinPace(workout.getMMinPace());
            matchRecord.setMSpm(workout.getMSpm());
            matchRecord.setMMaxSpm(workout.getMMaxSpm());
            matchRecord.setMMinSpm(workout.getMMinSpm());
            matchRecord.setMAltitude(workout.getMAltitude());
            matchRecord.setMMaxAltitude(workout.getMMaxAltitude());
            matchRecord.setMMinAltitude(workout.getMMinAltitude());
            arrayList.add(matchRecord);
        }
        I0X0x0oIo2.insert(arrayList);
    }

    public final void oxIIX0o(int i) {
        f20682I0oOoX = i;
    }

    public final HanBaoVibrationDao oxXx0IX() {
        return (HanBaoVibrationDao) f20716ooXIXxIX.getValue();
    }

    public final AssetFileDescriptor oxxXoxO() {
        return (AssetFileDescriptor) f20680I0X0x0oIo.getValue();
    }

    @OXOo.oOoXoXO
    public final String x0() {
        String str;
        BleNotification bleNotification = f20687Io;
        String str2 = null;
        if (bleNotification != null) {
            str = bleNotification.getMPackage();
        } else {
            str = null;
        }
        if (IIX0o.Oxx0IOOO(str, BleNotification.GOOGLE_DUO)) {
            BleNotification bleNotification2 = f20687Io;
            if (bleNotification2 != null) {
                str2 = bleNotification2.getMTitle();
            }
            str2 = String.valueOf(str2);
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("tryGetNameByNotification name -> " + str2);
        return str2;
    }

    public final void x0OIX00oO(boolean z) {
        f20707Xx000oIo = z;
    }

    public final void x0OxxIOxX() {
        MediaPlayer mediaPlayer = f20703XX0;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            f20703XX0 = null;
        }
        I0oOIX().cancel();
    }

    public final ActivityDao x0o() {
        return (ActivityDao) f20694Oxx0xo.getValue();
    }

    public final long x0xO() {
        return f20709o0;
    }

    public final void xI0oxI00(long j) {
        f20681I0oOIX = j;
    }

    public final long xII() {
        return f20689O0Xx;
    }

    public final void xOOOX() {
        ContentResolver contentResolver = Utils.getApp().getContentResolver();
        II0xO0 iI0xO0 = f20717oxXx0IX;
        contentResolver.unregisterContentObserver(iI0xO0);
        String[] II0xO02 = X00xOoXI.II0xO0();
        if (PermissionUtils.isGranted((String[]) Arrays.copyOf(II0xO02, II0xO02.length))) {
            Utils.getApp().getContentResolver().registerContentObserver(f20706XoX, true, iI0xO0);
        }
    }

    @SuppressLint({"WrongConstant"})
    public final void xOoOIoI(final Application application) {
        com.sma.smartv3.util.oIX0oI oix0oi = com.sma.smartv3.util.oIX0oI.f24510oIX0oI;
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.sma.smartv3.initializer.BleInitializer$registerMyReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Intent intent) {
                IIX0o.x0xO0oo(context, "context");
                IIX0o.x0xO0oo(intent, "intent");
                String action = intent.getAction();
                if (action != null) {
                    switch (action.hashCode()) {
                        case -1513032534:
                            if (!action.equals("android.intent.action.TIME_TICK") || !Xo0.f24349oIX0oI.oIX0oI().getBoolean(XoI0Ixx0.f24489xoIox, false)) {
                                return;
                            }
                            MyNotificationListenerService.f20319OxI.oIX0oI(application);
                            return;
                        case -19011148:
                            if (action.equals("android.intent.action.LOCALE_CHANGED")) {
                                BleConnector.sendInt8$default(BleConnector.INSTANCE, BleKey.LANGUAGE, BleKeyFlag.UPDATE, Languages.languageToCode$default(Languages.INSTANCE, null, 0, 3, null), false, false, 24, null);
                                com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24629oIX0oI, null, 2, null);
                                return;
                            }
                            return;
                        case 502473491:
                            if (!action.equals("android.intent.action.TIMEZONE_CHANGED")) {
                                return;
                            }
                            break;
                        case 505380757:
                            if (!action.equals("android.intent.action.TIME_SET")) {
                                return;
                            }
                            break;
                        default:
                            return;
                    }
                    BleConnector bleConnector = BleConnector.INSTANCE;
                    BleKey bleKey = BleKey.TIME_ZONE;
                    BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                    BleConnector.sendObject$default(bleConnector, bleKey, bleKeyFlag, new BleTimeZone(), false, false, 24, null);
                    BleConnector.sendObject$default(bleConnector, BleKey.TIME, bleKeyFlag, BleTime.Companion.local(), false, false, 24, null);
                    BleConnector.sendInt8$default(bleConnector, BleKey.HOUR_SYSTEM, bleKeyFlag, !com.sma.smartv3.util.xoIox.ooXIXxIX() ? 1 : 0, false, false, 24, null);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_TICK");
        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        oix0oi.oIX0oI(application, broadcastReceiver, intentFilter, 2);
    }

    public final boolean xX0IIXIx0() {
        return f20712oOXoIIIo;
    }

    public final HrvDao xXOx() {
        return (HrvDao) f20698XI0IXoo.getValue();
    }

    public final void xXoOI00O() {
        com.sma.smartv3.location.oxoX oxox = f20705XoI0Ixx0;
        if (oxox != null) {
            oxox.II0XooXoX();
        }
    }

    public final HeartRateDao xo0x() {
        return (HeartRateDao) f20711oI0IIXIo.getValue();
    }

    public final long xoIxX() {
        return f20696X00IoxXI;
    }

    public final boolean xoO0xx0() {
        return f20719x0o;
    }

    public final WorkoutDao xoxXI() {
        return (WorkoutDao) f20725xoXoI.getValue();
    }

    public final void xx0X0(boolean z) {
        f20714oo = z;
    }

    public final void xxIO(String str) {
        String str2;
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI("handleIncomingCall -> " + str);
        if (!Xo0.f24349oIX0oI.I0Io().getBoolean(XoI0Ixx0.f24358II0xO0)) {
            return;
        }
        BleConnector bleConnector = BleConnector.INSTANCE;
        if (!bleConnector.isAvailable()) {
            return;
        }
        String[] oIX0oI2 = X00xOoXI.oIX0oI();
        if (!PermissionUtils.isGranted((String[]) Arrays.copyOf(oIX0oI2, oIX0oI2.length))) {
            return;
        }
        String X00IoxXI2 = X00IoxXI(str);
        oix0oi.oIX0oI("BleInitializer handleIncomingCall -> Send title = " + X00IoxXI2 + "  phoneNumber" + str);
        if (TextUtils.isEmpty(X00IoxXI2) && (X00IoxXI2 = x0()) == null) {
            X00IoxXI2 = "";
        }
        if (TextUtils.isEmpty(X00IoxXI2) && !TextUtils.isEmpty(str)) {
            str2 = str;
        } else {
            str2 = X00IoxXI2;
        }
        long time = new Date().getTime();
        String string = Utils.getApp().getString(R.string.incoming_call);
        IIX0o.oO(string, "getString(...)");
        BleNotification bleNotification = new BleNotification(1, time, null, str2, string, 4, null);
        oix0oi.oIX0oI("BleInitializer handleIncomingCall -> Send Notification = " + bleNotification);
        BleConnector.sendObject$default(bleConnector, BleKey.NOTIFICATION, BleKeyFlag.UPDATE, bleNotification, false, false, 24, null);
    }

    public final void xxOXOOoIX() {
        if (!f20721xII) {
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24592OO0x0xX, null, 2, null);
        }
        f20721xII = true;
        f20719x0o = true;
        Xo0.f24349oIX0oI.oIX0oI().put(XoI0Ixx0.f24441oI0IIXIo, true);
        com.sma.smartv3.location.oxoX oxox = f20704Xo0;
        if (oxox != null) {
            com.sma.smartv3.location.oxoX.Oxx0IOOO(oxox, R.string.device_no_support_and_phone_get_location_desc, false, 2, null);
        }
        xoIXOxX.II0xO0.I0Io(false, false, null, null, 0, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.BleInitializer$startLocationThread$1
            @Override // Oox.oIX0oI
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                invoke2();
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.sma.smartv3.location.oxoX oxox2;
                while (true) {
                    Xo0 xo0 = Xo0.f24349oIX0oI;
                    if (!xo0.oIX0oI().getBoolean(XoI0Ixx0.f24441oI0IIXIo, true)) {
                        return;
                    }
                    xo0.oIX0oI().put(XoI0Ixx0.f24405OxxIIOOXO, true, true);
                    Thread.sleep(60000L);
                    if (xo0.oIX0oI().getBoolean(XoI0Ixx0.f24405OxxIIOOXO, true)) {
                        xo0.oIX0oI().put(XoI0Ixx0.f24441oI0IIXIo, false, true);
                        oxox2 = BleInitializer.f20704Xo0;
                        if (oxox2 != null) {
                            oxox2.II0XooXoX();
                        }
                        BleInitializer bleInitializer = BleInitializer.f20700XO;
                        bleInitializer.oOoIIO0(false);
                        bleInitializer.IxIX0I(false);
                    }
                }
            }
        }, 31, null);
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReadStock(boolean z) {
        Xo0.f24349oIX0oI.II0xO0().remove(XoI0Ixx0.f24385OI0);
        StockInitializer.f20895XO.Oxx0IOOO();
    }
}
