package com.sma.smartv3.ui.sport;

import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.DistanceUtil;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.Utils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.sma.smartv3.biz.fitness_site.FunctionKt;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.LocationDao;
import com.sma.smartv3.db.dao.SportDataDao;
import com.sma.smartv3.db.dao.WorkoutDao;
import com.sma.smartv3.db.dao.WorkoutIndexDao;
import com.sma.smartv3.db.entity.Location;
import com.sma.smartv3.db.entity.SportData;
import com.sma.smartv3.db.entity.Workout;
import com.sma.smartv3.db.entity.WorkoutIndex;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.ui.sport.SportManager;
import com.sma.smartv3.ui.sport.SportManager$mBleHandleCallback$2;
import com.sma.smartv3.ui.sport.StepsManager;
import com.sma.smartv3.util.TextConvertKt;
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
import com.szabh.smable3.entity.BleAppSportData;
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
import com.szabh.smable3.entity.BleLocationReply;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Ref;
import kotlin.oXIO0o0XI;

@kotlin.jvm.internal.XX({"SMAP\nSportManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportManager.kt\ncom/sma/smartv3/ui/sport/SportManager\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,672:1\n19#2:673\n15#2:674\n19#2:681\n15#2:682\n1855#3,2:675\n1855#3,2:677\n1855#3,2:679\n*S KotlinDebug\n*F\n+ 1 SportManager.kt\ncom/sma/smartv3/ui/sport/SportManager\n*L\n312#1:673\n312#1:674\n94#1:681\n94#1:682\n412#1:675,2\n425#1:677,2\n656#1:679,2\n*E\n"})
/* loaded from: classes12.dex */
public final class SportManager {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static StepsManager f23823II0XooXoX = null;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f23824II0xO0 = 0;

    /* renamed from: IIX0o, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final I0Io f23825IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static List<BleHeartRate> f23826IIXOooo = null;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f23827IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static int f23828O0xOxO = 0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static long f23829OOXIXo = 0;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static AppUser f23830Oo = null;

    /* renamed from: OxI, reason: collision with root package name */
    public static int f23831OxI = 0;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f23833Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f23834OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static int f23835X0IIOO = 0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f23836X0o0xo = "SportManager";

    /* renamed from: XI0IXoo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static com.sma.smartv3.location.oxoX f23837XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static boolean f23838XIxXXX0x0;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static boolean f23840XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    @OXOo.OOXIXo
    public static List<SportData> f23841o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f23842oI0IIXIo;

    /* renamed from: oO, reason: collision with root package name */
    public static int f23844oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static int f23845oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static int f23846ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static int f23848x0XOIxOo;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f23850xXxxox0I;

    /* renamed from: xoIox, reason: collision with root package name */
    public static long f23851xoIox;

    /* renamed from: xoXoI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static List<Location> f23852xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public static boolean f23854xxX;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final SportManager f23843oIX0oI = new SportManager();

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f23822I0Io = 1;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f23847oxoX = 2;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f23839XO = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CopyOnWriteArrayList<oIX0oI>>() { // from class: com.sma.smartv3.ui.sport.SportManager$mSportCallbacks$2
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final CopyOnWriteArrayList<SportManager.oIX0oI> invoke() {
            return new CopyOnWriteArrayList<>();
        }
    });

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Handler f23832Oxx0IOOO = new Handler(Looper.getMainLooper());

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static int f23853xxIXOIIO = 4;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static SportData f23849x0xO0oo = new SportData(0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32767, null);

    /* loaded from: classes12.dex */
    public static final class I0Io implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            SportManager.f23832Oxx0IOOO.postDelayed(this, 1000L);
            SportManager.f23843oIX0oI.O0Xx();
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements StepsManager.oIX0oI {
        @Override // com.sma.smartv3.ui.sport.StepsManager.oIX0oI
        public void oIX0oI(int i) {
            SportManager sportManager = SportManager.f23843oIX0oI;
            sportManager.O0xOxO().setMStep(i);
            if (sportManager.O0xOxO().getMMode() != 10) {
                sportManager.O0xOxO().setMCalorie(XIo0oOXIx.f23889oIX0oI.XO(SportManager.f23830Oo.getGender(), SportManager.f23830Oo.getWeight(), sportManager.O0xOxO().getMStep()));
            }
            if (sportManager.o00().isEmpty() || sportManager.o00().size() < 2) {
                sportManager.O0xOxO().setMDistance(XIo0oOXIx.f23889oIX0oI.Oxx0IOOO(SportManager.f23830Oo.getHeight(), sportManager.O0xOxO().getMStep()));
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface oIX0oI {

        /* renamed from: com.sma.smartv3.ui.sport.SportManager$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public static final class C0990oIX0oI {
            public static void I0Io(@OXOo.OOXIXo oIX0oI oix0oi, @OXOo.OOXIXo Location location) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(location, "location");
            }

            public static void II0xO0(@OXOo.OOXIXo oIX0oI oix0oi, int i) {
            }

            public static void X0o0xo(@OXOo.OOXIXo oIX0oI oix0oi, @OXOo.OOXIXo BleAppSportState sportState) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(sportState, "sportState");
            }

            public static void oIX0oI(@OXOo.OOXIXo oIX0oI oix0oi, boolean z) {
            }

            public static void oxoX(@OXOo.OOXIXo oIX0oI oix0oi, @OXOo.OOXIXo SportData sportData) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(sportData, "sportData");
            }
        }

        void I0Io(boolean z);

        void II0xO0(@OXOo.OOXIXo BleAppSportState bleAppSportState);

        void X0o0xo(@OXOo.OOXIXo SportData sportData);

        void oIX0oI(int i);

        void oxoX(@OXOo.OOXIXo Location location);
    }

    /* loaded from: classes12.dex */
    public static final class oxoX implements com.sma.smartv3.location.II0xO0 {
        @Override // com.sma.smartv3.location.II0xO0
        public void oIX0oI(@OXOo.OOXIXo com.sma.smartv3.location.oIX0oI loc) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(loc, "loc");
            Date date = new Date();
            long time = date.getTime();
            String format = com.sma.smartv3.util.xoIox.I0Io().format(date);
            kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
            SportManager sportManager = SportManager.f23843oIX0oI;
            Location location = new Location(0, time, format, sportManager.O0xOxO().getMMode(), oOIx.oxoX.IIX0(loc.oIX0oI()), (float) loc.I0Io(), (float) loc.II0xO0(), loc.oxoX(), 0, 0, 768, null);
            if (sportManager.o00().isEmpty()) {
                location.setMActivityMode(0);
                sportManager.OOXIXo(location);
            } else {
                Location location2 = (Location) CollectionsKt___CollectionsKt.O0O0Io00X(sportManager.o00());
                double distance = DistanceUtil.getDistance(new LatLng(location2.getMLatitude(), location2.getMLongitude()), new LatLng(loc.II0xO0(), loc.I0Io()));
                if (distance >= 1.0d) {
                    SportManager.f23848x0XOIxOo += (int) distance;
                    int XIxXXX0x02 = sportManager.XIxXXX0x0();
                    if (XIxXXX0x02 != 1) {
                        if (XIxXXX0x02 != 2) {
                            if (XIxXXX0x02 == 3) {
                                location.setMActivityMode(2);
                                sportManager.OOXIXo(location);
                            }
                        } else {
                            if (((Location) CollectionsKt___CollectionsKt.O0O0Io00X(sportManager.o00())).getMActivityMode() != 3) {
                                location.setMActivityMode(3);
                            }
                            sportManager.OOXIXo(location);
                        }
                    } else {
                        sportManager.OOXIXo(location);
                    }
                } else {
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI("SportManager onLocationChange -> too short tmpDistance=" + distance);
                    return;
                }
            }
            if (sportManager.oo0xXOI0I()) {
                MyDb.INSTANCE.getMDatabase().locationDao().insert(CollectionsKt__CollectionsKt.Oxx0xo(location));
                sportManager.o0(loc);
            }
        }

        @Override // com.sma.smartv3.location.II0xO0
        public void onError(@OXOo.OOXIXo String message) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(message, "message");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("SportManager gps error: " + message);
        }
    }

    static {
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        f23830Oo = (AppUser) appUser;
        f23827IXxxXO = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WorkoutDao>() { // from class: com.sma.smartv3.ui.sport.SportManager$mWorkoutDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final WorkoutDao invoke() {
                return MyDb.INSTANCE.getMDatabase().workoutDao();
            }
        });
        f23833Oxx0xo = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LocationDao>() { // from class: com.sma.smartv3.ui.sport.SportManager$mLocationDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final LocationDao invoke() {
                return MyDb.INSTANCE.getMDatabase().locationDao();
            }
        });
        f23842oI0IIXIo = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WorkoutIndexDao>() { // from class: com.sma.smartv3.ui.sport.SportManager$mWorkoutIndexDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final WorkoutIndexDao invoke() {
                return MyDb.INSTANCE.getMDatabase().workoutIndexDao();
            }
        });
        f23834OxxIIOOXO = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SportDataDao>() { // from class: com.sma.smartv3.ui.sport.SportManager$mSportDataDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final SportDataDao invoke() {
                return MyDb.INSTANCE.getMDatabase().sportDataDao();
            }
        });
        f23826IIXOooo = new ArrayList();
        f23852xoXoI = new ArrayList();
        f23841o00 = new ArrayList();
        f23854xxX = true;
        f23850xXxxox0I = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SportManager$mBleHandleCallback$2.AnonymousClass1>() { // from class: com.sma.smartv3.ui.sport.SportManager$mBleHandleCallback$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.sma.smartv3.ui.sport.SportManager$mBleHandleCallback$2$1] */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final AnonymousClass1 invoke() {
                return new BleHandleCallback() { // from class: com.sma.smartv3.ui.sport.SportManager$mBleHandleCallback$2.1
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
                    public void onDeviceSportDataUpdate(@OXOo.OOXIXo BleDeviceSportData deviceSportData) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(deviceSportData, "deviceSportData");
                        SportManager sportManager = SportManager.f23843oIX0oI;
                        sportManager.O0xOxO().setMTime(System.currentTimeMillis());
                        SportData O0xOxO2 = sportManager.O0xOxO();
                        String millis2String = TimeUtils.millis2String(sportManager.O0xOxO().getMTime(), com.sma.smartv3.util.xoIox.I0Io());
                        kotlin.jvm.internal.IIX0o.oO(millis2String, "millis2String(...)");
                        O0xOxO2.setMLocalTime(millis2String);
                        sportManager.O0xOxO().setMDuration(deviceSportData.getMDuration());
                        sportManager.O0xOxO().setMSpm(deviceSportData.getMSpm());
                        sportManager.O0xOxO().setMPace(deviceSportData.getMPace());
                        sportManager.O0xOxO().setMSpeed(deviceSportData.getMSpeed());
                        sportManager.O0xOxO().setMCalorie(deviceSportData.getMCalorie() / 1000);
                        sportManager.O0xOxO().setMStep(deviceSportData.getMStep());
                        sportManager.O0xOxO().setMDistance(deviceSportData.getMDistance());
                        sportManager.oxxXoxO(deviceSportData.getMBpm());
                        sportManager.oOXoIIIo(new Oox.oOoXoXO<SportManager.oIX0oI, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportManager$mBleHandleCallback$2$1$onDeviceSportDataUpdate$1
                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(SportManager.oIX0oI oix0oi) {
                                invoke2(oix0oi);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OXOo.OOXIXo SportManager.oIX0oI it) {
                                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                                it.X0o0xo(SportManager.f23843oIX0oI.O0xOxO());
                            }
                        });
                        sportManager.xXxxox0I();
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
                    public void onSessionStateChange(final boolean z) {
                        SportManager.f23843oIX0oI.oOXoIIIo(new Oox.oOoXoXO<SportManager.oIX0oI, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportManager$mBleHandleCallback$2$1$onSessionStateChange$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(SportManager.oIX0oI oix0oi) {
                                invoke2(oix0oi);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OXOo.OOXIXo SportManager.oIX0oI it) {
                                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                                it.I0Io(z);
                            }
                        });
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
                    public void onUpdateAppSportState(@OXOo.OOXIXo final BleAppSportState appSportState) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(appSportState, "appSportState");
                        SportManager sportManager = SportManager.f23843oIX0oI;
                        sportManager.xXOx(appSportState.getMState());
                        int mState = appSportState.getMState();
                        if (mState != 1) {
                            if (mState != 2) {
                                if (mState != 3) {
                                    if (mState == 4) {
                                        sportManager.oO(false);
                                    }
                                } else {
                                    sportManager.IO(false);
                                }
                            } else {
                                sportManager.XOxIOxOx(false);
                            }
                        } else {
                            SportManager.Xo0(sportManager, appSportState.getMMode(), false, 0, 0, 0, 28, null);
                        }
                        sportManager.oOXoIIIo(new Oox.oOoXoXO<SportManager.oIX0oI, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportManager$mBleHandleCallback$2$1$onUpdateAppSportState$1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(SportManager.oIX0oI oix0oi) {
                                invoke2(oix0oi);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OXOo.OOXIXo SportManager.oIX0oI it) {
                                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                                it.II0xO0(BleAppSportState.this);
                            }
                        });
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
                    public void onUpdateHeartRate(@OXOo.OOXIXo BleHeartRate heartRate) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(heartRate, "heartRate");
                        if (heartRate.getMType() == 1) {
                            return;
                        }
                        SportManager sportManager = SportManager.f23843oIX0oI;
                        sportManager.oxxXoxO(heartRate.getMBpm());
                        sportManager.OxxIIOOXO().add(heartRate);
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
                };
            }
        });
        f23825IIX0o = new I0Io();
    }

    public static /* synthetic */ void OI0(SportManager sportManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        sportManager.XOxIOxOx(z);
    }

    public static /* synthetic */ void Xo0(SportManager sportManager, int i, boolean z, int i2, int i3, int i4, int i5, Object obj) {
        boolean z2;
        int i6;
        int i7;
        int i8;
        if ((i5 & 2) != 0) {
            z2 = true;
        } else {
            z2 = z;
        }
        if ((i5 & 4) != 0) {
            i6 = 0;
        } else {
            i6 = i2;
        }
        if ((i5 & 8) != 0) {
            i7 = 0;
        } else {
            i7 = i3;
        }
        if ((i5 & 16) != 0) {
            i8 = 0;
        } else {
            i8 = i4;
        }
        sportManager.oX(i, z2, i6, i7, i8);
    }

    public static final void Xx000oIo(Oox.oOoXoXO action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "$action");
        for (oIX0oI oix0oi : f23843oIX0oI.OxI()) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oix0oi);
            action.invoke(oix0oi);
        }
    }

    public static /* synthetic */ void x0xO0oo(SportManager sportManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        sportManager.oO(z);
    }

    public static /* synthetic */ void xII(SportManager sportManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        sportManager.IO(z);
    }

    public final void I0X0x0oIo(boolean z) {
        f23854xxX = z;
    }

    public final void I0oOoX(@OXOo.OOXIXo List<BleHeartRate> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<set-?>");
        f23826IIXOooo = list;
    }

    public final void IIX0o(@OXOo.OOXIXo Application app) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(app, "app");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("SportManager init");
        f23823II0XooXoX = new StepsManager(app, new II0xO0());
        try {
            BleConnector.INSTANCE.removeHandleCallback(oI0IIXIo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        BleConnector.INSTANCE.addHandleCallback(oI0IIXIo());
        X00IoxXI(new Object());
    }

    public final int IIXOooo() {
        return f23844oO;
    }

    public final void IO(boolean z) {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("SportManager pause " + z + TokenParser.SP);
        f23853xxIXOIIO = 3;
        StepsManager stepsManager = f23823II0XooXoX;
        if (stepsManager == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mStepsManager");
            stepsManager = null;
        }
        stepsManager.Oo();
        XoI0Ixx0(z);
    }

    public final int IXxxXO() {
        return f23824II0xO0;
    }

    public final void Io() {
        SportData copy;
        if (!ProductManager.f20544oIX0oI.ox0I()) {
            if (f23849x0xO0oo.getMDuration() % 60 != 0) {
                List<SportData> list = f23841o00;
                copy = r3.copy((r33 & 1) != 0 ? r3.mId : 0, (r33 & 2) != 0 ? r3.mTime : 0L, (r33 & 4) != 0 ? r3.mLocalTime : null, (r33 & 8) != 0 ? r3.mStep : 0, (r33 & 16) != 0 ? r3.mDistance : 0, (r33 & 32) != 0 ? r3.mCalorie : 0, (r33 & 64) != 0 ? r3.mDuration : 0, (r33 & 128) != 0 ? r3.mSpm : 0, (r33 & 256) != 0 ? r3.mAltitude : 0, (r33 & 512) != 0 ? r3.mAirPressure : 0, (r33 & 1024) != 0 ? r3.mPace : 0, (r33 & 2048) != 0 ? r3.mSpeed : 0, (r33 & 4096) != 0 ? r3.mMode : 0, (r33 & 8192) != 0 ? r3.mIsSync : 0, (r33 & 16384) != 0 ? f23849x0xO0oo.mIsDelete : 0);
                list.add(copy);
            }
            WorkoutDao xxX2 = xxX();
            Workout workout = new Workout(0, 0L, 0L, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0.0f, 0.0f, 0, 0.0f, 0, 0, 0, null, null, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, null, 0, 0, null, 0, 0, null, 0, 0, null, 0, 0, null, -1, -1, 511, null);
            workout.setMSource(1);
            workout.setMStart(f23851xoIox);
            workout.setMEnd(f23829OOXIXo);
            String millis2String = TimeUtils.millis2String(workout.getMStart(), com.sma.smartv3.util.xoIox.I0Io());
            kotlin.jvm.internal.IIX0o.oO(millis2String, "millis2String(...)");
            workout.setMLocalTime(millis2String);
            workout.setMDuration(f23849x0xO0oo.getMDuration());
            workout.setMAltitude(f23849x0xO0oo.getMAltitude());
            workout.setMAirPressure(f23849x0xO0oo.getMAirPressure());
            workout.setMSpm(f23849x0xO0oo.getMSpm());
            workout.setMMode(f23849x0xO0oo.getMMode());
            workout.setMStep(f23849x0xO0oo.getMStep());
            workout.setMDistance(f23849x0xO0oo.getMDistance());
            workout.setMCalorie(f23849x0xO0oo.getMCalorie() * 1000);
            workout.setMSpeed(f23849x0xO0oo.getMSpeed() * 1000);
            workout.setMPace(f23849x0xO0oo.getMPace());
            for (BleHeartRate bleHeartRate : f23826IIXOooo) {
                workout.setMAvgBpm(workout.getMAvgBpm() + bleHeartRate.getMBpm());
                if (bleHeartRate.getMBpm() > workout.getMMaxBpm()) {
                    workout.setMMaxBpm(bleHeartRate.getMBpm());
                }
                if (bleHeartRate.getMBpm() < workout.getMMinBpm()) {
                    workout.setMMinBpm(bleHeartRate.getMBpm());
                }
            }
            if (!f23826IIXOooo.isEmpty()) {
                workout.setMAvgBpm(workout.getMAvgBpm() / f23826IIXOooo.size());
            }
            for (SportData sportData : f23841o00) {
                if (sportData.getMSpm() > workout.getMMaxSpm()) {
                    workout.setMMaxSpm(sportData.getMSpm());
                }
                if (sportData.getMSpm() < workout.getMMinSpm()) {
                    workout.setMMinSpm(sportData.getMSpm());
                }
                if (sportData.getMPace() > workout.getMMaxPace()) {
                    workout.setMMaxPace(sportData.getMPace());
                }
                if (sportData.getMPace() < workout.getMMinPace()) {
                    workout.setMMinPace(sportData.getMPace());
                }
            }
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            final WorkoutIndex workoutIndex = new WorkoutIndex(0, 2, workout.getMEnd(), workout.getMMode(), 0, 17, null);
            Application app = Utils.getApp();
            kotlin.jvm.internal.IIX0o.oO(app, "getApp(...)");
            FunctionKt.Oxx0IOOO(app, workoutIndex, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportManager$save$workoutId$2$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return oXIO0o0XI.f29392oIX0oI;
                }

                public final void invoke(boolean z) {
                    WorkoutIndexDao XxX0x0xxx2;
                    if (z) {
                        return;
                    }
                    XxX0x0xxx2 = SportManager.f23843oIX0oI.XxX0x0xxx();
                    XxX0x0xxx2.insert(WorkoutIndex.this);
                }
            });
            long j = xxX2.insert(CollectionsKt__CollectionsKt.XOxIOxOx(workout))[0];
            xoXoI().insert(f23852xoXoI);
            X0IIOO().insert(f23841o00);
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24605X0o0xo, null, 2, null);
            com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24580Ioxxx, Integer.valueOf((int) j));
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("SportManager save " + j);
        }
    }

    public final boolean IoOoX() {
        return f23854xxX;
    }

    public final void O0Xx() {
        SportData copy;
        f23845oOoXoXO++;
        if (f23853xxIXOIIO == 3) {
            f23846ooOOo0oXI++;
        }
        if (oo()) {
            f23849x0xO0oo.setMTime(System.currentTimeMillis());
            SportData sportData = f23849x0xO0oo;
            String millis2String = TimeUtils.millis2String(sportData.getMTime(), com.sma.smartv3.util.xoIox.I0Io());
            kotlin.jvm.internal.IIX0o.oO(millis2String, "millis2String(...)");
            sportData.setMLocalTime(millis2String);
            f23849x0xO0oo.setMDuration(f23845oOoXoXO - f23846ooOOo0oXI);
            SportData sportData2 = f23849x0xO0oo;
            XIo0oOXIx xIo0oOXIx = XIo0oOXIx.f23889oIX0oI;
            sportData2.setMSpm(xIo0oOXIx.II0XooXoX(f23849x0xO0oo.getMStep(), f23849x0xO0oo.getMDuration()));
            SportData sportData3 = f23849x0xO0oo;
            sportData3.setMPace(xIo0oOXIx.II0xO0(sportData3.getMDuration(), f23849x0xO0oo.getMDistance()));
            SportData sportData4 = f23849x0xO0oo;
            sportData4.setMSpeed(xIo0oOXIx.I0Io(sportData4.getMDistance(), f23849x0xO0oo.getMDuration()));
            if (f23849x0xO0oo.getMMode() == 10) {
                f23849x0xO0oo.setMCalorie(xIo0oOXIx.oIX0oI(f23830Oo.getWeight(), f23849x0xO0oo.getMDistance()));
            }
            oOXoIIIo(new Oox.oOoXoXO<oIX0oI, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportManager$updateCountTime$1
                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(SportManager.oIX0oI oix0oi) {
                    invoke2(oix0oi);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo SportManager.oIX0oI it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    it.X0o0xo(SportManager.f23843oIX0oI.O0xOxO());
                }
            });
            if (f23849x0xO0oo.getMDuration() % 60 == 0) {
                List<SportData> list = f23841o00;
                copy = r4.copy((r33 & 1) != 0 ? r4.mId : 0, (r33 & 2) != 0 ? r4.mTime : 0L, (r33 & 4) != 0 ? r4.mLocalTime : null, (r33 & 8) != 0 ? r4.mStep : 0, (r33 & 16) != 0 ? r4.mDistance : 0, (r33 & 32) != 0 ? r4.mCalorie : 0, (r33 & 64) != 0 ? r4.mDuration : 0, (r33 & 128) != 0 ? r4.mSpm : 0, (r33 & 256) != 0 ? r4.mAltitude : 0, (r33 & 512) != 0 ? r4.mAirPressure : 0, (r33 & 1024) != 0 ? r4.mPace : 0, (r33 & 2048) != 0 ? r4.mSpeed : 0, (r33 & 4096) != 0 ? r4.mMode : 0, (r33 & 8192) != 0 ? r4.mIsSync : 0, (r33 & 16384) != 0 ? f23849x0xO0oo.mIsDelete : 0);
                list.add(copy);
            }
            BleConnector bleConnector = BleConnector.INSTANCE;
            if (bleConnector.isAvailable() && ProductManager.f20544oIX0oI.o0Oo()) {
                BleConnector.sendObject$default(bleConnector, BleKey.APP_SPORT_DATA, BleKeyFlag.UPDATE, new BleAppSportData(f23849x0xO0oo.getMStep(), f23849x0xO0oo.getMDistance(), f23849x0xO0oo.getMCalorie(), f23849x0xO0oo.getMDuration(), f23849x0xO0oo.getMSpm(), f23849x0xO0oo.getMAltitude(), f23849x0xO0oo.getMAirPressure(), f23849x0xO0oo.getMPace(), xIo0oOXIx.oxoX(f23849x0xO0oo.getMDistance(), f23849x0xO0oo.getMDuration()), f23849x0xO0oo.getMMode(), 0, 1024, null), false, false, 24, null);
            }
            xXxxox0I();
        }
        LogUtils.d("SportManager sportData -> isSupportAppSport = " + ProductManager.f20544oIX0oI.o0Oo() + "  BleConnector.isAvailable() = " + BleConnector.INSTANCE.isAvailable() + " state:" + f23853xxIXOIIO + ", t:" + ((System.currentTimeMillis() - f23851xoIox) / 1000) + ", mTotalTime:" + f23845oOoXoXO + ", mPauseTime:" + f23846ooOOo0oXI + ", " + f23849x0xO0oo + TokenParser.SP);
    }

    @OXOo.OOXIXo
    public final SportData O0xOxO() {
        return f23849x0xO0oo;
    }

    public final void OOXIXo(@OXOo.OOXIXo final Location location) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(location, "location");
        if (!ProductManager.f20544oIX0oI.ox0I()) {
            if (!f23852xoXoI.isEmpty()) {
                if (location.getMActivityMode() == 2) {
                    if (location.getMActivityMode() != ((Location) CollectionsKt___CollectionsKt.O0O0Io00X(f23852xoXoI)).getMActivityMode()) {
                        SportData sportData = f23849x0xO0oo;
                        sportData.setMDistance(sportData.getMDistance() + XIo0oOXIx.f23889oIX0oI.X0o0xo((Location) CollectionsKt___CollectionsKt.O0O0Io00X(f23852xoXoI), location));
                    }
                } else {
                    SportData sportData2 = f23849x0xO0oo;
                    sportData2.setMDistance(sportData2.getMDistance() + XIo0oOXIx.f23889oIX0oI.X0o0xo((Location) CollectionsKt___CollectionsKt.O0O0Io00X(f23852xoXoI), location));
                }
            } else {
                f23849x0xO0oo.setMDistance(0);
            }
            f23849x0xO0oo.setMAltitude(location.getMAltitude());
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("SportManager addLocation -> " + location);
        f23852xoXoI.add(location);
        oOXoIIIo(new Oox.oOoXoXO<oIX0oI, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportManager$addLocation$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(SportManager.oIX0oI oix0oi) {
                invoke2(oix0oi);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo SportManager.oIX0oI it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                it.oxoX(Location.this);
            }
        });
    }

    public final int Oo() {
        return f23847oxoX;
    }

    public final CopyOnWriteArrayList<oIX0oI> OxI() {
        return (CopyOnWriteArrayList) f23839XO.getValue();
    }

    public final int Oxx0xo() {
        return f23822I0Io;
    }

    @OXOo.OOXIXo
    public final List<BleHeartRate> OxxIIOOXO() {
        return f23826IIXOooo;
    }

    @XO0.XO(tag = com.sma.smartv3.util.XoI0Ixx0.f24367IXxxXO)
    public final void X00IoxXI(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("onLocationWhere");
        f23837XI0IXoo = com.sma.smartv3.location.X0o0xo.II0xO0(new oxoX(), false, 2, null);
    }

    public final SportDataDao X0IIOO() {
        return (SportDataDao) f23834OxxIIOOXO.getValue();
    }

    @OXOo.OOXIXo
    public final List<SportData> XI0IXoo() {
        return f23841o00;
    }

    public final int XIxXXX0x0() {
        return f23853xxIXOIIO;
    }

    public final void XOxIOxOx(boolean z) {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("SportManager resume " + z + TokenParser.SP);
        f23853xxIXOIIO = 2;
        StepsManager stepsManager = f23823II0XooXoX;
        if (stepsManager == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mStepsManager");
            stepsManager = null;
        }
        stepsManager.IXxxXO();
        XoI0Ixx0(z);
    }

    public final void XX(boolean z) {
        f23838XIxXXX0x0 = z;
    }

    public final void XX0(boolean z) {
        f23840XxX0x0xxx = z;
    }

    public final void XoI0Ixx0(boolean z) {
        if (z) {
            BleConnector bleConnector = BleConnector.INSTANCE;
            if (bleConnector.isAvailable() && ProductManager.f20544oIX0oI.o0Oo()) {
                BleConnector.sendObject$default(bleConnector, BleKey.APP_SPORT_STATE, BleKeyFlag.UPDATE, new BleAppSportState(f23849x0xO0oo.getMMode(), f23853xxIXOIIO), false, false, 24, null);
            }
        }
    }

    public final void XoX(@OXOo.OOXIXo List<Location> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<set-?>");
        f23852xoXoI = list;
    }

    public final WorkoutIndexDao XxX0x0xxx() {
        return (WorkoutIndexDao) f23842oI0IIXIo.getValue();
    }

    public final void o0(@OXOo.OOXIXo com.sma.smartv3.location.oIX0oI location) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(location, "location");
        if (BleCache.INSTANCE.getMAGpsType() == 0 && f23849x0xO0oo.getMDuration() % 20 == 0) {
            int IIX02 = oOIx.oxoX.IIX0(location.oIX0oI());
            BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.REQUEST_LOCATION, BleKeyFlag.CREATE, new BleLocationReply(location.X0o0xo(), Float.parseFloat(TextConvertKt.oOXoIIIo(f23848x0XOIxOo / 1000.0f, false, 2, null)), IIX02), false, false, 24, null);
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("SportManager sendLocation -> mSpeed=" + location.X0o0xo() + ", mTotalDistance=" + f23848x0XOIxOo + ", altitude=" + IIX02);
        }
    }

    @OXOo.OOXIXo
    public final List<Location> o00() {
        return f23852xoXoI;
    }

    public final SportManager$mBleHandleCallback$2.AnonymousClass1 oI0IIXIo() {
        return (SportManager$mBleHandleCallback$2.AnonymousClass1) f23850xXxxox0I.getValue();
    }

    public final void oO(boolean z) {
        com.sma.smartv3.location.oxoX oxox;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("SportManager end " + z + TokenParser.SP);
        f23853xxIXOIIO = 4;
        StepsManager stepsManager = f23823II0XooXoX;
        if (stepsManager == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mStepsManager");
            stepsManager = null;
        }
        stepsManager.x0xO0oo();
        f23829OOXIXo = System.currentTimeMillis();
        f23832Oxx0IOOO.removeCallbacks(f23825IIX0o);
        XoI0Ixx0(z);
        if (ProductManager.f20544oIX0oI.IXxOIOO(f23849x0xO0oo.getMMode()) && (oxox = f23837XI0IXoo) != null) {
            oxox.II0XooXoX();
        }
        if (!f23852xoXoI.isEmpty() && f23852xoXoI.size() > 1) {
            ((Location) CollectionsKt___CollectionsKt.O0O0Io00X(f23852xoXoI)).setMActivityMode(4);
        }
    }

    public final void oOXoIIIo(final Oox.oOoXoXO<? super oIX0oI, oXIO0o0XI> oooxoxo) {
        f23832Oxx0IOOO.post(new Runnable() { // from class: com.sma.smartv3.ui.sport.I0oOIX
            @Override // java.lang.Runnable
            public final void run() {
                SportManager.Xx000oIo(Oox.oOoXoXO.this);
            }
        });
    }

    public final void oOoXoXO(@OXOo.OOXIXo oIX0oI onSportListener) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(onSportListener, "onSportListener");
        OxI().add(onSportListener);
    }

    public final void oX(int i, boolean z, int i2, int i3, int i4) {
        com.sma.smartv3.location.oxoX oxox;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("SportManager start " + i + TokenParser.SP + z + TokenParser.SP + i2 + TokenParser.SP + i3 + TokenParser.SP + i4 + TokenParser.SP + f23854xxX);
        if (oo()) {
            return;
        }
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        f23830Oo = (AppUser) appUser;
        f23852xoXoI.clear();
        f23826IIXOooo.clear();
        f23841o00.clear();
        f23845oOoXoXO = 0;
        f23846ooOOo0oXI = 0;
        f23831OxI = i2;
        f23828O0xOxO = i3;
        f23835X0IIOO = i4;
        f23849x0xO0oo = new SportData(0, 0L, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, 0, 0, 28671, null);
        f23853xxIXOIIO = 1;
        f23851xoIox = System.currentTimeMillis();
        f23829OOXIXo = System.currentTimeMillis();
        f23838XIxXXX0x0 = false;
        f23848x0XOIxOo = 0;
        f23844oO = 0;
        XoI0Ixx0(z);
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.IXxOIOO(f23849x0xO0oo.getMMode()) && (oxox = f23837XI0IXoo) != null) {
            oxox.XO(R.string.get_your_location, false);
        }
        if (!productManager.ox0I()) {
            f23832Oxx0IOOO.postDelayed(f23825IIX0o, 1000L);
            StepsManager stepsManager = f23823II0XooXoX;
            if (stepsManager == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mStepsManager");
                stepsManager = null;
            }
            stepsManager.Oxx0xo();
        }
    }

    public final boolean oo() {
        int i = f23853xxIXOIIO;
        if (i == 1 || i == 2) {
            return true;
        }
        return false;
    }

    public final boolean oo0xXOI0I() {
        if (BleCache.INSTANCE.getMAGpsType() == 0 && ProductManager.f20544oIX0oI.ox0I()) {
            return true;
        }
        return false;
    }

    public final boolean ooOOo0oXI() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("canSave " + f23849x0xO0oo.getMDuration() + "  " + f23849x0xO0oo.getMStep() + "  " + f23849x0xO0oo.getMCalorie());
        if (f23849x0xO0oo.getMDuration() < 120) {
            return false;
        }
        if (ProductManager.f20544oIX0oI.IOooo0o(f23849x0xO0oo.getMMode())) {
            if (f23849x0xO0oo.getMStep() < 100) {
                return false;
            }
            return true;
        }
        if (f23849x0xO0oo.getMCalorie() < 4) {
            return false;
        }
        return true;
    }

    public final boolean ooXIXxIX() {
        return f23838XIxXXX0x0;
    }

    public final void oxXx0IX(@OXOo.OOXIXo SportData sportData) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sportData, "<set-?>");
        f23849x0xO0oo = sportData;
    }

    public final void oxxXoxO(int i) {
        f23844oO = i;
    }

    public final void x0XOIxOo() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("SportManager destroy");
        StepsManager stepsManager = null;
        if (oo()) {
            xII(this, false, 1, null);
        }
        if (f23853xxIXOIIO != 4) {
            x0xO0oo(this, false, 1, null);
        }
        StepsManager stepsManager2 = f23823II0XooXoX;
        if (stepsManager2 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mStepsManager");
        } else {
            stepsManager = stepsManager2;
        }
        stepsManager.oO();
        BleConnector.INSTANCE.removeHandleCallback(oI0IIXIo());
    }

    public final void x0o(@OXOo.OOXIXo oIX0oI onSportListener) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(onSportListener, "onSportListener");
        OxI().remove(onSportListener);
    }

    public final boolean xI() {
        return f23840XxX0x0xxx;
    }

    public final void xXOx(int i) {
        f23853xxIXOIIO = i;
    }

    public final void xXxxox0I() {
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        if (f23831OxI != 0 && f23849x0xO0oo.getMDistance() >= f23831OxI) {
            intRef.element = f23824II0xO0;
        }
        if (f23828O0xOxO != 0 && f23849x0xO0oo.getMDuration() >= f23828O0xOxO) {
            intRef.element = f23822I0Io;
        }
        if (f23835X0IIOO != 0 && f23849x0xO0oo.getMCalorie() >= f23835X0IIOO) {
            intRef.element = f23847oxoX;
        }
        if (intRef.element != -1 && !f23838XIxXXX0x0) {
            f23838XIxXXX0x0 = true;
            oOXoIIIo(new Oox.oOoXoXO<oIX0oI, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportManager$handleGoalDone$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(SportManager.oIX0oI oix0oi) {
                    invoke2(oix0oi);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo SportManager.oIX0oI it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    it.oIX0oI(Ref.IntRef.this.element);
                }
            });
        }
    }

    public final void xo0x(@OXOo.OOXIXo List<SportData> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<set-?>");
        f23841o00 = list;
    }

    public final LocationDao xoXoI() {
        return (LocationDao) f23833Oxx0xo.getValue();
    }

    public final WorkoutDao xxX() {
        return (WorkoutDao) f23827IXxxXO.getValue();
    }
}
