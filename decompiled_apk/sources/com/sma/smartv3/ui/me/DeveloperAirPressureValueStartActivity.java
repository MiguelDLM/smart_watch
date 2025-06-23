package com.sma.smartv3.ui.me;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.bestmafen.androidbase.extension.PermissionStatus;
import com.bestmafen.baseble.connector.AbsBleConnector;
import com.bestmafen.baseble.scanner.BleDevice;
import com.bestmafen.baseble.scanner.ScanMode;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kuaishou.weapon.p0.g;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.BleOpRecord;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.SearchOpRecord;
import com.sma.smartv3.network.UploadOpRecord;
import com.sma.smartv3.ui.device.BaseListFunctionActivity;
import com.sma.smartv3.ui.me.DeveloperAirPressureValueStartActivity;
import com.sma.smartv3.util.UtilsKt;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.component.BleHandleCallback;
import com.szabh.smable3.entity.BleAICoachBeforePlan;
import com.szabh.smable3.entity.BleAICoachGeneratePlan;
import com.szabh.smable3.entity.BleActivity;
import com.szabh.smable3.entity.BleActivityDetail;
import com.szabh.smable3.entity.BleAirPressureCalibration;
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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.random.Random;

@kotlin.jvm.internal.XX({"SMAP\nDeveloperAirPressureValueStartActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperAirPressureValueStartActivity.kt\ncom/sma/smartv3/ui/me/DeveloperAirPressureValueStartActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 4 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,481:1\n19#2:482\n15#2:483\n27#2,2:524\n151#3,11:484\n171#3:503\n151#3,11:504\n171#3:523\n208#4,7:495\n226#4:502\n208#4,7:515\n226#4:522\n1#5:526\n*S KotlinDebug\n*F\n+ 1 DeveloperAirPressureValueStartActivity.kt\ncom/sma/smartv3/ui/me/DeveloperAirPressureValueStartActivity\n*L\n249#1:482\n249#1:483\n402#1:524,2\n338#1:484,11\n338#1:503\n376#1:504,11\n376#1:523\n338#1:495,7\n338#1:502\n376#1:515,7\n376#1:522\n*E\n"})
/* loaded from: classes11.dex */
public final class DeveloperAirPressureValueStartActivity extends BaseListFunctionActivity<BleDevice> {
    private boolean isAutoAirPressureValue;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.I0X0x0oIo mLoadingPopup;

    @OXOo.OOXIXo
    private final String TAG = "AirPressureValue";

    @OXOo.OOXIXo
    private final kotlin.X0IIOO etOldBleName$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.me.DeveloperAirPressureValueStartActivity$etOldBleName$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) DeveloperAirPressureValueStartActivity.this.findViewById(R.id.et_old_ble_name);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btStartAirPressureValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AppCompatButton>() { // from class: com.sma.smartv3.ui.me.DeveloperAirPressureValueStartActivity$btStartAirPressureValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AppCompatButton invoke() {
            return (AppCompatButton) DeveloperAirPressureValueStartActivity.this.findViewById(R.id.bt_start_airpressure_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btStopAirPressureValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AppCompatButton>() { // from class: com.sma.smartv3.ui.me.DeveloperAirPressureValueStartActivity$btStopAirPressureValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AppCompatButton invoke() {
            return (AppCompatButton) DeveloperAirPressureValueStartActivity.this.findViewById(R.id.bt_stop_airpressure_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO etSignal$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.me.DeveloperAirPressureValueStartActivity$etSignal$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) DeveloperAirPressureValueStartActivity.this.findViewById(R.id.et_signal);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvSearchNumber$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.DeveloperAirPressureValueStartActivity$tvSearchNumber$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) DeveloperAirPressureValueStartActivity.this.findViewById(R.id.tv_search_number);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAlreadyAirPressureValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.DeveloperAirPressureValueStartActivity$tvAlreadyAirPressureValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) DeveloperAirPressureValueStartActivity.this.findViewById(R.id.tv_already_airpressure_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO cbShutdown$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.ui.me.DeveloperAirPressureValueStartActivity$cbShutdown$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            return (CheckBox) DeveloperAirPressureValueStartActivity.this.findViewById(R.id.cb_shutdown);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO cbSkipServer$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.ui.me.DeveloperAirPressureValueStartActivity$cbSkipServer$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            return (CheckBox) DeveloperAirPressureValueStartActivity.this.findViewById(R.id.cb_skip_server);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO etAirPressureValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.me.DeveloperAirPressureValueStartActivity$etAirPressureValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) DeveloperAirPressureValueStartActivity.this.findViewById(R.id.et_airpressure_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO etAltitude$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.me.DeveloperAirPressureValueStartActivity$etAltitude$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) DeveloperAirPressureValueStartActivity.this.findViewById(R.id.et_altitude_value);
        }
    });

    @OXOo.OOXIXo
    private List<String> failedList = new ArrayList();

    @OXOo.OOXIXo
    private String deviceAddress = "";

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mScanner$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<XOxIOxOx.II0xO0>() { // from class: com.sma.smartv3.ui.me.DeveloperAirPressureValueStartActivity$mScanner$2

        @kotlin.jvm.internal.XX({"SMAP\nDeveloperAirPressureValueStartActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperAirPressureValueStartActivity.kt\ncom/sma/smartv3/ui/me/DeveloperAirPressureValueStartActivity$mScanner$2$2\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,481:1\n19#2:482\n15#2:483\n1002#3,2:484\n*S KotlinDebug\n*F\n+ 1 DeveloperAirPressureValueStartActivity.kt\ncom/sma/smartv3/ui/me/DeveloperAirPressureValueStartActivity$mScanner$2$2\n*L\n114#1:482\n114#1:483\n120#1:484,2\n*E\n"})
        /* loaded from: classes11.dex */
        public static final class II0xO0 implements XOxIOxOx.oxoX {

            /* renamed from: oIX0oI, reason: collision with root package name */
            public final /* synthetic */ DeveloperAirPressureValueStartActivity f23144oIX0oI;

            @kotlin.jvm.internal.XX({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 DeveloperAirPressureValueStartActivity.kt\ncom/sma/smartv3/ui/me/DeveloperAirPressureValueStartActivity$mScanner$2$2\n*L\n1#1,328:1\n120#2:329\n*E\n"})
            /* loaded from: classes11.dex */
            public static final class oIX0oI<T> implements Comparator {
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return xX0ox.Oxx0IOOO.oOoXoXO(Integer.valueOf(-((BleDevice) t).getMRssi()), Integer.valueOf(-((BleDevice) t2).getMRssi()));
                }
            }

            public II0xO0(DeveloperAirPressureValueStartActivity developerAirPressureValueStartActivity) {
                this.f23144oIX0oI = developerAirPressureValueStartActivity;
            }

            @Override // XOxIOxOx.oxoX
            public void I0Io() {
            }

            @Override // XOxIOxOx.oxoX
            public void II0xO0(@OXOo.OOXIXo BleDevice device) {
                List mList;
                List mList2;
                List mList3;
                TextView tvSearchNumber;
                List mList4;
                XIOOI.oIX0oI mListAdapter;
                kotlin.jvm.internal.IIX0o.x0xO0oo(device, "device");
                mList = this.f23144oIX0oI.getMList();
                if (mList.contains(device)) {
                    return;
                }
                SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
                Object oxox = new oxoX(null, 1, null);
                Object fromJson = new Gson().fromJson(XO2.getString(oxoX.class.getName()), (Class<Object>) oxoX.class);
                if (fromJson != null) {
                    oxox = fromJson;
                }
                if (!((oxoX) oxox).oxoX().contains(device.getMBluetoothDevice().getAddress())) {
                    mList2 = this.f23144oIX0oI.getMList();
                    mList2.add(device);
                    mList3 = this.f23144oIX0oI.getMList();
                    if (mList3.size() > 1) {
                        kotlin.collections.o00.OO0x0xX(mList3, new oIX0oI());
                    }
                    tvSearchNumber = this.f23144oIX0oI.getTvSearchNumber();
                    DeveloperAirPressureValueStartActivity developerAirPressureValueStartActivity = this.f23144oIX0oI;
                    mList4 = developerAirPressureValueStartActivity.getMList();
                    tvSearchNumber.setText(developerAirPressureValueStartActivity.getString(R.string.device_found, Integer.valueOf(mList4.size())));
                    mListAdapter = this.f23144oIX0oI.getMListAdapter();
                    mListAdapter.notifyDataSetChanged();
                }
            }

            @Override // XOxIOxOx.oxoX
            public void oIX0oI(boolean z) {
                boolean z2;
                AppCompatButton btStartAirPressureValue;
                AppCompatButton btStartAirPressureValue2;
                List mList;
                AppCompatButton btStartAirPressureValue3;
                if (z) {
                    btStartAirPressureValue3 = this.f23144oIX0oI.getBtStartAirPressureValue();
                    btStartAirPressureValue3.setVisibility(8);
                    return;
                }
                z2 = this.f23144oIX0oI.isAutoAirPressureValue;
                if (z2) {
                    btStartAirPressureValue2 = this.f23144oIX0oI.getBtStartAirPressureValue();
                    btStartAirPressureValue2.setVisibility(8);
                    mList = this.f23144oIX0oI.getMList();
                    if (mList.isEmpty()) {
                        this.f23144oIX0oI.autoStart();
                        return;
                    }
                    DeveloperAirPressureValueStartActivity developerAirPressureValueStartActivity = this.f23144oIX0oI;
                    EditText etOldBleName = developerAirPressureValueStartActivity.getEtOldBleName();
                    kotlin.jvm.internal.IIX0o.oO(etOldBleName, "access$getEtOldBleName(...)");
                    developerAirPressureValueStartActivity.startAirPressureValue(etOldBleName);
                    return;
                }
                btStartAirPressureValue = this.f23144oIX0oI.getBtStartAirPressureValue();
                btStartAirPressureValue.setVisibility(0);
            }
        }

        @kotlin.jvm.internal.XX({"SMAP\nDeveloperAirPressureValueStartActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperAirPressureValueStartActivity.kt\ncom/sma/smartv3/ui/me/DeveloperAirPressureValueStartActivity$mScanner$2$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,481:1\n1#2:482\n*E\n"})
        /* loaded from: classes11.dex */
        public static final class oIX0oI implements XOxIOxOx.X0o0xo {

            /* renamed from: oIX0oI, reason: collision with root package name */
            public final /* synthetic */ DeveloperAirPressureValueStartActivity f23145oIX0oI;

            public oIX0oI(DeveloperAirPressureValueStartActivity developerAirPressureValueStartActivity) {
                this.f23145oIX0oI = developerAirPressureValueStartActivity;
            }

            @Override // XOxIOxOx.X0o0xo
            public boolean oIX0oI(@OXOo.OOXIXo BleDevice device) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(device, "device");
                com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
                String string = xo0.XO().getString(com.sma.smartv3.util.XoI0Ixx0.f24429XoI0Ixx0, "");
                kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                if (string.length() == 0) {
                    if (device.getMRssi() > xo0.XO().getInt(com.sma.smartv3.util.XoI0Ixx0.f24428Xo0, -100)) {
                        return true;
                    }
                } else if (device.getMRssi() > xo0.XO().getInt(com.sma.smartv3.util.XoI0Ixx0.f24428Xo0, -100) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(ProductManager.f20544oIX0oI.x0xO0oo(device.getMName()), xo0.XO().getString(com.sma.smartv3.util.XoI0Ixx0.f24429XoI0Ixx0, ""))) {
                    Object obj = this.f23145oIX0oI.mConnectedFailMap.get(this.f23145oIX0oI.deviceAddress);
                    if (obj == null) {
                        obj = 0;
                    }
                    if (((Number) obj).intValue() < 8) {
                        return true;
                    }
                }
                return false;
            }
        }

        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final XOxIOxOx.II0xO0 invoke() {
            return XOxIOxOx.oO.II0xO0(XOxIOxOx.oO.f3971oIX0oI, null, ScanMode.LOW_LATENCY, 1, null).Oo(4).IXxxXO(new oIX0oI(DeveloperAirPressureValueStartActivity.this)).ooOOo0oXI(new II0xO0(DeveloperAirPressureValueStartActivity.this));
        }
    });

    @OXOo.OOXIXo
    private final HashMap<String, Integer> mConnectedFailMap = new HashMap<>();

    @OXOo.OOXIXo
    private final Handler mHandler = new Handler();

    @OXOo.OOXIXo
    private final Runnable mConnectedFailRunnable = new Runnable() { // from class: com.sma.smartv3.ui.me.X0IIOO
        @Override // java.lang.Runnable
        public final void run() {
            DeveloperAirPressureValueStartActivity.mConnectedFailRunnable$lambda$2(DeveloperAirPressureValueStartActivity.this);
        }
    };

    @OXOo.OOXIXo
    private final oIX0oI mBleHandleCallback = new oIX0oI();

    @kotlin.jvm.internal.XX({"SMAP\nDeveloperAirPressureValueStartActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperAirPressureValueStartActivity.kt\ncom/sma/smartv3/ui/me/DeveloperAirPressureValueStartActivity$mBleHandleCallback$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,481:1\n1#2:482\n19#3:483\n15#3:484\n19#3:485\n15#3:486\n11#3,2:487\n19#3:489\n15#3:490\n*S KotlinDebug\n*F\n+ 1 DeveloperAirPressureValueStartActivity.kt\ncom/sma/smartv3/ui/me/DeveloperAirPressureValueStartActivity$mBleHandleCallback$1\n*L\n182#1:483\n182#1:484\n216#1:485\n216#1:486\n219#1:487,2\n222#1:489\n222#1:490\n*E\n"})
    /* loaded from: classes11.dex */
    public static final class oIX0oI implements BleHandleCallback {
        public oIX0oI() {
        }

        public static final void II0XooXoX(DeveloperAirPressureValueStartActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            ToastUtils.showLong(R.string.auto_next_airpressure_value);
            EditText etOldBleName = this$0.getEtOldBleName();
            kotlin.jvm.internal.IIX0o.oO(etOldBleName, "access$getEtOldBleName(...)");
            this$0.startSearch(etOldBleName);
        }

        public static final void Oxx0IOOO(final DeveloperAirPressureValueStartActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
            Object oxox = new oxoX(null, 1, null);
            Object fromJson = new Gson().fromJson(XO2.getString(oxoX.class.getName()), (Class<Object>) oxoX.class);
            if (fromJson != null) {
                oxox = fromJson;
            }
            if (!((oxoX) oxox).oxoX().contains(this$0.deviceAddress)) {
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = this$0.mLoadingPopup;
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.TAG + " force closeConnection " + this$0.deviceAddress);
                BleConnector.INSTANCE.closeConnection(true);
                BleCache.remove$default(BleCache.INSTANCE, BleKey.AIR_PRESSURE_CALIBRATION, null, 2, null);
                this$0.failedList.add(this$0.deviceAddress);
                ThreadUtils.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.me.xXxxox0I
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeveloperAirPressureValueStartActivity.oIX0oI.II0XooXoX(DeveloperAirPressureValueStartActivity.this);
                    }
                });
            }
        }

        public static final void X0o0xo(DeveloperAirPressureValueStartActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            BleConnector.INSTANCE.closeConnection(true);
            BleCache.remove$default(BleCache.INSTANCE, BleKey.AIR_PRESSURE_CALIBRATION, null, 2, null);
            com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
            SPUtils XO2 = xo0.XO();
            Object oxox = new oxoX(null, 1, null);
            Object fromJson = new Gson().fromJson(XO2.getString(oxoX.class.getName()), (Class<Object>) oxoX.class);
            if (fromJson != null) {
                oxox = fromJson;
            }
            oxoX oxox2 = (oxoX) oxox;
            oxox2.oxoX().add(this$0.deviceAddress);
            xo0.XO().put(oxoX.class.getName(), new Gson().toJson(oxox2));
            TextView tvAlreadyAirPressureValue = this$0.getTvAlreadyAirPressureValue();
            SPUtils XO3 = xo0.XO();
            Object oxox3 = new oxoX(null, 1, null);
            Object fromJson2 = new Gson().fromJson(XO3.getString(oxoX.class.getName()), (Class<Object>) oxoX.class);
            if (fromJson2 != null) {
                oxox3 = fromJson2;
            }
            tvAlreadyAirPressureValue.setText(String.valueOf(((oxoX) oxox3).oxoX().size()));
            ToastUtils.showLong(R.string.auto_next_airpressure_value);
            com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = this$0.mLoadingPopup;
            if (i0X0x0oIo != null) {
                i0X0x0oIo.dismiss();
            }
            EditText etOldBleName = this$0.getEtOldBleName();
            kotlin.jvm.internal.IIX0o.oO(etOldBleName, "access$getEtOldBleName(...)");
            this$0.startSearch(etOldBleName);
            this$0.uploadOpRecord(this$0.getEtOldBleName().getText().toString(), this$0.deviceAddress);
        }

        public static final void XO(final DeveloperAirPressureValueStartActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            BleConnector bleConnector = BleConnector.INSTANCE;
            if (!bleConnector.isBound()) {
                BleConnector.sendInt32$default(bleConnector, BleKey.SESSION, BleKeyFlag.CREATE, Random.Default.nextInt(), null, false, false, 56, null);
            }
            BleConnector.sendObject$default(bleConnector, BleKey.AIR_PRESSURE_CALIBRATION, BleKeyFlag.UPDATE, new BleAirPressureCalibration(Integer.parseInt(this$0.getEtAirPressureValue().getText().toString()), Integer.parseInt(this$0.getEtAltitude().getText().toString())), false, false, 24, null);
            new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.xxX
                @Override // java.lang.Runnable
                public final void run() {
                    DeveloperAirPressureValueStartActivity.oIX0oI.Oxx0IOOO(DeveloperAirPressureValueStartActivity.this);
                }
            }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
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
            long j;
            kotlin.jvm.internal.IIX0o.x0xO0oo(bleKey, "bleKey");
            kotlin.jvm.internal.IIX0o.x0xO0oo(bleKeyFlag, "bleKeyFlag");
            if (bleKey == BleKey.AIR_PRESSURE_CALIBRATION) {
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = DeveloperAirPressureValueStartActivity.this.mLoadingPopup;
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
                OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                oix0oi.oIX0oI(DeveloperAirPressureValueStartActivity.this.TAG + " AirPressure Value success " + DeveloperAirPressureValueStartActivity.this.deviceAddress);
                if (DeveloperAirPressureValueStartActivity.this.getCbShutdown().isChecked()) {
                    oix0oi.oIX0oI(DeveloperAirPressureValueStartActivity.this.TAG + " need shutdown");
                    BleConnector.sendInt8$default(BleConnector.INSTANCE, BleKey.SHUTDOWN, BleKeyFlag.UPDATE, 0, false, false, 24, null);
                    j = 1000;
                } else {
                    j = 100;
                }
                Handler handler = new Handler();
                final DeveloperAirPressureValueStartActivity developerAirPressureValueStartActivity = DeveloperAirPressureValueStartActivity.this;
                handler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.XxX0x0xxx
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeveloperAirPressureValueStartActivity.oIX0oI.X0o0xo(DeveloperAirPressureValueStartActivity.this);
                    }
                }, j);
            }
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onCommandSendTimeout(@OXOo.OOXIXo BleKey bleKey, @OXOo.OOXIXo BleKeyFlag bleKeyFlag) {
            BleHandleCallback.DefaultImpls.onCommandSendTimeout(this, bleKey, bleKeyFlag);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceConnected(@OXOo.OOXIXo BluetoothDevice device) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(device, "device");
            DeveloperAirPressureValueStartActivity.this.getBtStopAirPressureValue().setVisibility(0);
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(DeveloperAirPressureValueStartActivity.this.TAG + " onDeviceConnected -> " + device);
            Handler handler = new Handler();
            final DeveloperAirPressureValueStartActivity developerAirPressureValueStartActivity = DeveloperAirPressureValueStartActivity.this;
            handler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.XIxXXX0x0
                @Override // java.lang.Runnable
                public final void run() {
                    DeveloperAirPressureValueStartActivity.oIX0oI.XO(DeveloperAirPressureValueStartActivity.this);
                }
            }, 3000L);
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
            if (!z) {
                try {
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI(DeveloperAirPressureValueStartActivity.this.TAG + " ConnectedFailTime " + DeveloperAirPressureValueStartActivity.this.deviceAddress + org.apache.commons.text.oIX0oI.f33048oxoX + DeveloperAirPressureValueStartActivity.this.mConnectedFailMap.get(DeveloperAirPressureValueStartActivity.this.deviceAddress));
                    HashMap hashMap = DeveloperAirPressureValueStartActivity.this.mConnectedFailMap;
                    String str = DeveloperAirPressureValueStartActivity.this.deviceAddress;
                    Object obj = DeveloperAirPressureValueStartActivity.this.mConnectedFailMap.get(DeveloperAirPressureValueStartActivity.this.deviceAddress);
                    if (obj == null) {
                        obj = 0;
                    }
                    hashMap.put(str, Integer.valueOf(((Number) obj).intValue() + 1));
                } catch (Exception e) {
                    e.printStackTrace();
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void autoStart() {
        new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.XI0IXoo
            @Override // java.lang.Runnable
            public final void run() {
                DeveloperAirPressureValueStartActivity.autoStart$lambda$0(DeveloperAirPressureValueStartActivity.this);
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void autoStart$lambda$0(DeveloperAirPressureValueStartActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.TAG + " list is empty! ConnectedFailMap clear");
        this$0.mConnectedFailMap.clear();
        EditText etOldBleName = this$0.getEtOldBleName();
        kotlin.jvm.internal.IIX0o.oO(etOldBleName, "<get-etOldBleName>(...)");
        this$0.startSearch(etOldBleName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppCompatButton getBtStartAirPressureValue() {
        return (AppCompatButton) this.btStartAirPressureValue$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppCompatButton getBtStopAirPressureValue() {
        return (AppCompatButton) this.btStopAirPressureValue$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CheckBox getCbShutdown() {
        return (CheckBox) this.cbShutdown$delegate.getValue();
    }

    private final CheckBox getCbSkipServer() {
        return (CheckBox) this.cbSkipServer$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText getEtAirPressureValue() {
        return (EditText) this.etAirPressureValue$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText getEtAltitude() {
        return (EditText) this.etAltitude$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText getEtOldBleName() {
        return (EditText) this.etOldBleName$delegate.getValue();
    }

    private final EditText getEtSignal() {
        return (EditText) this.etSignal$delegate.getValue();
    }

    private final XOxIOxOx.II0xO0 getMScanner() {
        return (XOxIOxOx.II0xO0) this.mScanner$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvAlreadyAirPressureValue() {
        return (TextView) this.tvAlreadyAirPressureValue$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvSearchNumber() {
        return (TextView) this.tvSearchNumber$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(DeveloperAirPressureValueStartActivity this$0, AdapterView adapterView, View view, int i, long j) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getEtOldBleName().setText(ProductManager.f20544oIX0oI.x0xO0oo(this$0.getMList().get(i).getMName()));
        EditText etOldBleName = this$0.getEtOldBleName();
        kotlin.jvm.internal.IIX0o.oO(etOldBleName, "<get-etOldBleName>(...)");
        this$0.startSearch(etOldBleName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mConnectedFailRunnable$lambda$2(DeveloperAirPressureValueStartActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI(this$0.TAG + " mConnectedFailRunnable " + this$0.deviceAddress);
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = this$0.mLoadingPopup;
        if (i0X0x0oIo != null && i0X0x0oIo.isShowing()) {
            HashMap<String, Integer> hashMap = this$0.mConnectedFailMap;
            String str = this$0.deviceAddress;
            Integer num = hashMap.get(str);
            if (num == null) {
                num = 0;
            }
            hashMap.put(str, Integer.valueOf(num.intValue() + 8));
            com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo2 = this$0.mLoadingPopup;
            if (i0X0x0oIo2 != null) {
                i0X0x0oIo2.dismiss();
            }
            oix0oi.oIX0oI(this$0.TAG + " ConnectedFailTime " + this$0.deviceAddress + TokenParser.SP + this$0.mConnectedFailMap.get(this$0.deviceAddress) + " -> skip");
            BleConnector.INSTANCE.closeConnection(true);
            EditText etOldBleName = this$0.getEtOldBleName();
            kotlin.jvm.internal.IIX0o.oO(etOldBleName, "<get-etOldBleName>(...)");
            this$0.startSearch(etOldBleName);
        }
    }

    @RequiresApi(29)
    private final void permissionBackgroundLocationRemind() {
        if (getMPermissionBackgroundPopup() == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.background_set_remind);
            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.settings, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.DeveloperAirPressureValueStartActivity$permissionBackgroundLocationRemind$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    Activity mContext;
                    mContext = DeveloperAirPressureValueStartActivity.this.getMContext();
                    mContext.requestPermissions(new String[]{g.g, "android.permission.ACCESS_BACKGROUND_LOCATION"}, 3);
                    return Boolean.TRUE;
                }
            });
            setMPermissionBackgroundPopup(xoI0Ixx0);
        }
        com.sma.smartv3.pop.XoI0Ixx0 mPermissionBackgroundPopup = getMPermissionBackgroundPopup();
        if (mPermissionBackgroundPopup != null) {
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            mPermissionBackgroundPopup.OxxIIOOXO(rootView);
        }
    }

    private final void requestEnableBluetooth() {
        oOXoIIIo.oIX0oI.IXxxXO(this, "android.bluetooth.adapter.action.REQUEST_ENABLE", 1, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestLocationPermission() {
        if (Build.VERSION.SDK_INT >= 29) {
            permissionBackgroundLocationRemind();
            return;
        }
        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.LOCATION);
        kotlin.jvm.internal.IIX0o.oO(permission, "permission(...)");
        oOXoIIIo.X0o0xo.I0Io(permission, null, null, new Oox.oOoXoXO<PermissionStatus, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.DeveloperAirPressureValueStartActivity$requestLocationPermission$1

            /* loaded from: classes11.dex */
            public /* synthetic */ class oIX0oI {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public static final /* synthetic */ int[] f23147oIX0oI;

                static {
                    int[] iArr = new int[PermissionStatus.values().length];
                    try {
                        iArr[PermissionStatus.GRANTED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PermissionStatus.DENIED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f23147oIX0oI = iArr;
                }
            }

            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                invoke2(permissionStatus);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo PermissionStatus it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                int i = oIX0oI.f23147oIX0oI[it.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        DeveloperAirPressureValueStartActivity.this.requestLocationPermission();
                        return;
                    } else {
                        DeveloperAirPressureValueStartActivity.this.permissionRemind();
                        return;
                    }
                }
                DeveloperAirPressureValueStartActivity developerAirPressureValueStartActivity = DeveloperAirPressureValueStartActivity.this;
                TextView tvAlreadyAirPressureValue = developerAirPressureValueStartActivity.getTvAlreadyAirPressureValue();
                kotlin.jvm.internal.IIX0o.oO(tvAlreadyAirPressureValue, "access$getTvAlreadyAirPressureValue(...)");
                developerAirPressureValueStartActivity.startSearch(tvAlreadyAirPressureValue);
            }
        }, 3, null);
    }

    private final void searchOpRecord(final BleDevice bleDevice) {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " searchOpRecord " + bleDevice);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap hashMap = new HashMap();
        hashMap.put("bleName", bleDevice.getMName());
        hashMap.put("mac", bleDevice.getMBluetoothDevice().getAddress());
        hashMap.put("type", "1");
        final xxxI.II0xO0<BleOpRecord[]> iI0xO0 = new xxxI.II0xO0<BleOpRecord[]>() { // from class: com.sma.smartv3.ui.me.DeveloperAirPressureValueStartActivity$searchOpRecord$2
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                AbsBleConnector.setBleDevice$default(BleConnector.INSTANCE, BleDevice.this, 0, 2, null).connect(true);
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " searchOpRecord -> error, connect new device -> " + BleDevice.this);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO BleOpRecord[] bleOpRecordArr) {
                if (bleOpRecordArr != null && bleOpRecordArr.length != 0) {
                    com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
                    SPUtils XO2 = xo0.XO();
                    Object oxox = new oxoX(null, 1, null);
                    Object fromJson = new Gson().fromJson(XO2.getString(oxoX.class.getName()), (Class<Object>) oxoX.class);
                    if (fromJson != null) {
                        oxox = fromJson;
                    }
                    oxoX oxox2 = (oxoX) oxox;
                    oxox2.oxoX().add(this.deviceAddress);
                    xo0.XO().put(oxoX.class.getName(), new Gson().toJson(oxox2));
                    TextView tvAlreadyAirPressureValue = this.getTvAlreadyAirPressureValue();
                    SPUtils XO3 = xo0.XO();
                    Object oxox3 = new oxoX(null, 1, null);
                    Object fromJson2 = new Gson().fromJson(XO3.getString(oxoX.class.getName()), (Class<Object>) oxoX.class);
                    if (fromJson2 != null) {
                        oxox3 = fromJson2;
                    }
                    tvAlreadyAirPressureValue.setText(String.valueOf(((oxoX) oxox3).oxoX().size()));
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " searchOpRecord -> skip device -> " + BleDevice.this);
                    com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = this.mLoadingPopup;
                    if (i0X0x0oIo != null) {
                        i0X0x0oIo.dismiss();
                    }
                    DeveloperAirPressureValueStartActivity developerAirPressureValueStartActivity = this;
                    EditText etOldBleName = developerAirPressureValueStartActivity.getEtOldBleName();
                    kotlin.jvm.internal.IIX0o.oO(etOldBleName, "access$getEtOldBleName(...)");
                    developerAirPressureValueStartActivity.startSearch(etOldBleName);
                    return;
                }
                AbsBleConnector.setBleDevice$default(BleConnector.INSTANCE, BleDevice.this, 0, 2, null).connect(true);
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " searchOpRecord -> connect new device -> " + BleDevice.this);
            }
        };
        final Activity activity = null;
        final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), SearchOpRecord.URL);
        netWorkUtils.printParam(convertBaseUrl + SearchOpRecord.URL, hashMap);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + SearchOpRecord.URL;
        final xxxI.II0xO0<Response<BleOpRecord[]>> iI0xO02 = new xxxI.II0xO0<Response<BleOpRecord[]>>() { // from class: com.sma.smartv3.ui.me.DeveloperAirPressureValueStartActivity$searchOpRecord$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<BleOpRecord[]> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) hashMap).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, BleOpRecord[].class), new ParsedRequestListener<Response<BleOpRecord[]>>() { // from class: com.sma.smartv3.ui.me.DeveloperAirPressureValueStartActivity$searchOpRecord$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<BleOpRecord[]> response) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void uploadOpRecord(String str, String str2) {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " uploadOpRecord " + str + TokenParser.SP + str2);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap hashMap = new HashMap();
        hashMap.put("bleName", str);
        hashMap.put("mac", str2);
        hashMap.put("type", "1");
        final xxxI.II0xO0<Object> iI0xO0 = new xxxI.II0xO0<Object>() { // from class: com.sma.smartv3.ui.me.DeveloperAirPressureValueStartActivity$uploadOpRecord$2
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
            }

            @Override // xxxI.II0xO0
            public void handleResponse(@OXOo.oOoXoXO Object obj) {
            }
        };
        final Activity activity = null;
        final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), UploadOpRecord.URL);
        netWorkUtils.printParam(convertBaseUrl + UploadOpRecord.URL, hashMap);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str3 = convertBaseUrl + UploadOpRecord.URL;
        final xxxI.II0xO0<Response<Object>> iI0xO02 = new xxxI.II0xO0<Response<Object>>() { // from class: com.sma.smartv3.ui.me.DeveloperAirPressureValueStartActivity$uploadOpRecord$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<Object> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str3).addBodyParameter((Map<String, String>) hashMap).setTag((Object) str3).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, Object.class), new ParsedRequestListener<Response<Object>>() { // from class: com.sma.smartv3.ui.me.DeveloperAirPressureValueStartActivity$uploadOpRecord$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<Object> response) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str4;
                String str5;
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
                    str4 = aNError.getErrorBody();
                } else {
                    str4 = null;
                }
                sb.append(str4);
                sb.append(", ");
                if (aNError != null) {
                    str5 = aNError.getErrorDetail();
                } else {
                    str5 = null;
                }
                sb.append(str5);
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

    public final void clearAirPressureValueHistory(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().remove(oxoX.class.getName());
        getTvAlreadyAirPressureValue().setText("0");
        EditText etOldBleName = getEtOldBleName();
        kotlin.jvm.internal.IIX0o.oO(etOldBleName, "<get-etOldBleName>(...)");
        startSearch(etOldBleName);
        this.failedList.clear();
        this.mConnectedFailMap.clear();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        BleConnector.INSTANCE.addHandleCallback(this.mBleHandleCallback);
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    @OXOo.OOXIXo
    public List<BleDevice> initList() {
        return new ArrayList();
    }

    @Override // com.bestmafen.androidbase.list.BaseListActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getBtStartAirPressureValue().setVisibility(8);
        getBtStopAirPressureValue().setVisibility(8);
        getMListView().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sma.smartv3.ui.me.O0xOxO
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                DeveloperAirPressureValueStartActivity.initView$lambda$3(DeveloperAirPressureValueStartActivity.this, adapterView, view, i, j);
            }
        });
        TextView tvAlreadyAirPressureValue = getTvAlreadyAirPressureValue();
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object oxox = new oxoX(null, 1, null);
        Object fromJson = new Gson().fromJson(XO2.getString(oxoX.class.getName()), (Class<Object>) oxoX.class);
        if (fromJson != null) {
            oxox = fromJson;
        }
        tvAlreadyAirPressureValue.setText(String.valueOf(((oxoX) oxox).oxoX().size()));
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    public int itemLayoutId() {
        return R.layout.item_device;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_developer_test_airpressure_value_start;
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        EditText etOldBleName = getEtOldBleName();
        kotlin.jvm.internal.IIX0o.oO(etOldBleName, "<get-etOldBleName>(...)");
        startSearch(etOldBleName);
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        BleConnector bleConnector = BleConnector.INSTANCE;
        bleConnector.setNeedBind(true);
        bleConnector.setOtaMode(false);
        bleConnector.removeHandleCallback(this.mBleHandleCallback);
        super.onDestroy();
        getMScanner().II0xO0();
    }

    public final void startAirPressureValue(@OXOo.OOXIXo View view) {
        BleDevice bleDevice;
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI(this.TAG + " startAirPressureValue failedList=" + this.failedList);
        oix0oi.oIX0oI(this.TAG + " startAirPressureValue mConnectedFailMap=" + this.mConnectedFailMap);
        if (getEtAirPressureValue().getText().toString().length() == 0) {
            return;
        }
        if (getMList().isEmpty()) {
            ToastUtils.showLong(R.string.no_device_not_airpressure_value);
            return;
        }
        this.isAutoAirPressureValue = true;
        Iterator<BleDevice> it = getMList().iterator();
        while (true) {
            if (it.hasNext()) {
                bleDevice = it.next();
                if (!this.failedList.contains(bleDevice.getMBluetoothDevice().getAddress())) {
                    break;
                }
            } else {
                bleDevice = null;
                break;
            }
        }
        if (bleDevice == null) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " no device");
            ToastUtils.showLong(R.string.no_device_to_airpressure_value);
            this.failedList.clear();
            autoStart();
            return;
        }
        if (this.mLoadingPopup == null) {
            this.mLoadingPopup = new com.sma.smartv3.pop.I0X0x0oIo(getMContext());
        }
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = this.mLoadingPopup;
        if (i0X0x0oIo != null) {
            i0X0x0oIo.IIXOooo();
        }
        this.mHandler.postDelayed(this.mConnectedFailRunnable, TimeUnit.SECONDS.toMillis(30L));
        getBtStopAirPressureValue().setVisibility(0);
        String address = bleDevice.getMBluetoothDevice().getAddress();
        kotlin.jvm.internal.IIX0o.oO(address, "getAddress(...)");
        this.deviceAddress = address;
        BleConnector bleConnector = BleConnector.INSTANCE;
        bleConnector.setNeedBind(false);
        bleConnector.setMConnectDirectly(true);
        if (getCbSkipServer().isChecked()) {
            AbsBleConnector.setBleDevice$default(bleConnector, bleDevice, 0, 2, null).connect(true);
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + TokenParser.SP + this.isAutoAirPressureValue + " connect new device -> " + bleDevice);
            return;
        }
        searchOpRecord(bleDevice);
    }

    public final void startSearch(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        this.mHandler.removeCallbacks(this.mConnectedFailRunnable);
        if (!PermissionUtils.isGranted(g.g)) {
            requestLocationPermission();
            return;
        }
        if (!BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            requestEnableBluetooth();
            return;
        }
        if (!UtilsKt.oo()) {
            locationServerRemind();
            return;
        }
        ToastUtils.showLong(R.string.search_device_remind);
        if (getEtSignal().getText().toString().length() == 0) {
            getEtSignal().setText("100");
        }
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24428Xo0, -Integer.parseInt(getEtSignal().getText().toString()));
        xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24429XoI0Ixx0, getEtOldBleName().getText().toString());
        getMList().clear();
        getMListAdapter().notifyDataSetChanged();
        getTvSearchNumber().setText(getString(R.string.device_found, Integer.valueOf(getMList().size())));
        getMScanner().oOoXoXO(true);
    }

    public final void stopAirPressureValue(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        ToastUtils.showLong(R.string.close_auto_airpressure_value_tip);
        this.isAutoAirPressureValue = false;
        getBtStopAirPressureValue().setVisibility(8);
    }

    @Override // com.bestmafen.androidbase.list.I0Io
    public void initItem(@OXOo.OOXIXo XIOOI.I0Io holder, @OXOo.OOXIXo BleDevice item, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        holder.o00(R.id.tv_name, item.getMName());
        holder.o00(R.id.tv_address, item.getMBluetoothDevice().getAddress());
        ((ImageView) holder.X0o0xo(R.id.iv_rssi)).setImageLevel(-item.getMRssi());
    }
}
