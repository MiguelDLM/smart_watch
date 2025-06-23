package com.sma.smartv3.ui.main;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity;
import com.bestmafen.androidbase.viewpager.BaseFragmentPagerAdapter;
import com.bestmafen.baseble.connector.AbsBleConnector;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.ClickUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kuaishou.weapon.p0.g;
import com.sma.androidnetworklib.method.HttpProgressCallback;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.DeviceInfoChecker;
import com.sma.smartv3.biz.OrderManager;
import com.sma.smartv3.biz.SmaNotification;
import com.sma.smartv3.biz.UploadInfoManager;
import com.sma.smartv3.biz.ad.ADPAdManager;
import com.sma.smartv3.ble.MyNotificationListenerService;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.AGPSInitializer;
import com.sma.smartv3.initializer.BleInitializer;
import com.sma.smartv3.initializer.IXxxXO;
import com.sma.smartv3.initializer.WeatherInitializer;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.AppVersion;
import com.sma.smartv3.model.EvaluationKt;
import com.sma.smartv3.model.ThirdPlatform;
import com.sma.smartv3.model.UserMember;
import com.sma.smartv3.model.WeatherRealtime;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.AppUserInfo;
import com.sma.smartv3.network.AppUserUpdate;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.NetWorkUtils$upload$$inlined$upload$1;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.pop.XoI0Ixx0;
import com.sma.smartv3.pop.oOXoIIIo;
import com.sma.smartv3.pop.xOOOX;
import com.sma.smartv3.ui.ai.fragment.AIFragment;
import com.sma.smartv3.ui.device.CameraActivity;
import com.sma.smartv3.ui.device.DeviceFragment;
import com.sma.smartv3.ui.device.FirmwareRepairGQActivity;
import com.sma.smartv3.ui.device.FirmwareRepairModeActivity;
import com.sma.smartv3.ui.device.FirmwareRepairNActivity;
import com.sma.smartv3.ui.device.FirmwareRepairSActivity;
import com.sma.smartv3.ui.device.FirmwareRepairSearchActivity;
import com.sma.smartv3.ui.main.BaseMainActivity;
import com.sma.smartv3.ui.me.GoogleWebViewActivity;
import com.sma.smartv3.ui.me.MainMeFragment;
import com.sma.smartv3.ui.me.PermissionSettingsActivity;
import com.sma.smartv3.ui.sport.SportDetailActivity;
import com.sma.smartv3.ui.sport.SportDetailV2Activity;
import com.sma.smartv3.ui.sport.SportFragment;
import com.sma.smartv3.ui.sport.SportManager;
import com.sma.smartv3.ui.sport.SportOnGoingGpsActivity;
import com.sma.smartv3.ui.status.MainStatusFragment;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.permission.PermissionHelper;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.work.Download;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nBaseMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseMainActivity.kt\ncom/sma/smartv3/ui/main/BaseMainActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 4 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n+ 5 Menu.kt\nandroidx/core/view/MenuKt\n+ 6 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 7 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1362:1\n93#2,2:1363\n90#2:1365\n11#2,2:1366\n11#2,2:1441\n11#2,2:1452\n11#2,2:1463\n11#2,2:1474\n19#2:1494\n15#2:1495\n90#2:1496\n19#2:1497\n15#2:1498\n83#3,7:1368\n98#3:1398\n151#3,11:1399\n171#3:1418\n106#4,23:1375\n208#4,7:1410\n226#4:1417\n63#5,4:1419\n63#5,4:1499\n69#6,3:1423\n72#6,5:1427\n69#6,3:1432\n72#6,5:1436\n69#6,3:1443\n72#6,5:1447\n69#6,3:1454\n72#6,5:1458\n69#6,3:1465\n72#6,5:1469\n69#6,3:1476\n72#6,5:1480\n69#6,3:1485\n72#6,5:1489\n1#7:1426\n1#7:1435\n1#7:1446\n1#7:1457\n1#7:1468\n1#7:1479\n1#7:1488\n*S KotlinDebug\n*F\n+ 1 BaseMainActivity.kt\ncom/sma/smartv3/ui/main/BaseMainActivity\n*L\n446#1:1363,2\n446#1:1365\n481#1:1366,2\n1043#1:1441,2\n1046#1:1452,2\n1049#1:1463,2\n1052#1:1474,2\n1114#1:1494\n1114#1:1495\n1316#1:1496\n294#1:1497\n294#1:1498\n577#1:1368,7\n577#1:1398\n593#1:1399,11\n593#1:1418\n577#1:1375,23\n593#1:1410,7\n593#1:1417\n1024#1:1419,4\n470#1:1499,4\n1039#1:1423,3\n1039#1:1427,5\n1041#1:1432,3\n1041#1:1436,5\n1044#1:1443,3\n1044#1:1447,5\n1047#1:1454,3\n1047#1:1458,5\n1050#1:1465,3\n1050#1:1469,5\n1053#1:1476,3\n1053#1:1480,5\n1056#1:1485,3\n1056#1:1489,5\n1039#1:1426\n1041#1:1435\n1044#1:1446\n1047#1:1457\n1050#1:1468\n1053#1:1479\n1056#1:1488\n*E\n"})
/* loaded from: classes12.dex */
public class BaseMainActivity extends BaseFragmentPagerActivity {
    private boolean isToPersonalInfo;
    private ImageView ivRemind;

    @OXOo.oOoXoXO
    private XoI0Ixx0 locationPopup;

    @OXOo.oOoXoXO
    private xOOOX mAGpsPopup;

    @OXOo.oOoXoXO
    private XoI0Ixx0 mAGpsPopupReminder;

    @OXOo.oOoXoXO
    private XoI0Ixx0 mClassicConnectPopup;

    @OXOo.oOoXoXO
    private XoI0Ixx0 mClassicNotePopup;

    @OXOo.oOoXoXO
    private oOXoIIIo mEvaluationPopup;

    @OXOo.oOoXoXO
    private XoI0Ixx0 mFindPhonePopup;

    @OXOo.oOoXoXO
    private XoI0Ixx0 mFontPackageStatusPopup;

    @OXOo.oOoXoXO
    private XoI0Ixx0 mGPSRepairPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.location.oxoX mLocationClient;

    @OXOo.oOoXoXO
    private XoI0Ixx0 mNotificationPopup;

    @OXOo.oOoXoXO
    private XoI0Ixx0 mPermissionCheckPopup;

    @OXOo.oOoXoXO
    private XoI0Ixx0 mRepairPopup;

    @OXOo.oOoXoXO
    private XoI0Ixx0 mStatusBarNotificationPopup;

    @OXOo.oOoXoXO
    private XoI0Ixx0 mUIPackageStatusPopup;
    public MainStatusFragment statusFragment;

    @OXOo.OOXIXo
    private final X0IIOO rootView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) BaseMainActivity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO bottomNav$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<BottomNavigationView>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$bottomNav$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final BottomNavigationView invoke() {
            return (BottomNavigationView) BaseMainActivity.this.findViewById(R.id.bottomNav);
        }
    });
    private boolean isFocusChanged = true;
    private final int delayTimeTask = 254;

    @OXOo.OOXIXo
    private Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.sma.smartv3.ui.main.Oxx0IOOO
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            boolean mHandler$lambda$0;
            mHandler$lambda$0 = BaseMainActivity.mHandler$lambda$0(BaseMainActivity.this, message);
            return mHandler$lambda$0;
        }
    });

    @OXOo.OOXIXo
    private final II0xO0 mBleHandleCallback = new II0xO0();

    @OXOo.OOXIXo
    private final oIX0oI bleHandleCallback = new oIX0oI();

    /* loaded from: classes12.dex */
    public static final class I0Io implements com.sma.smartv3.location.II0xO0 {
        public I0Io() {
        }

        @Override // com.sma.smartv3.location.II0xO0
        public void oIX0oI(@OXOo.OOXIXo com.sma.smartv3.location.oIX0oI location) {
            IIX0o.x0xO0oo(location, "location");
            BaseMainActivity.this.requestWeatherLocation(location.I0Io(), location.II0xO0());
            BaseMainActivity.this.stopLocationClient();
        }

        @Override // com.sma.smartv3.location.II0xO0
        public void onError(@OXOo.OOXIXo String message) {
            IIX0o.x0xO0oo(message, "message");
            LogUtils.v("requestWeather -> CustomLocationCallback onError message=" + message);
        }
    }

    @XX({"SMAP\nBaseMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseMainActivity.kt\ncom/sma/smartv3/ui/main/BaseMainActivity$mBleHandleCallback$1\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1362:1\n69#2,3:1363\n72#2,5:1367\n87#2,7:1372\n94#2,3:1380\n70#2,7:1383\n97#2:1390\n1#3:1366\n1#3:1379\n*S KotlinDebug\n*F\n+ 1 BaseMainActivity.kt\ncom/sma/smartv3/ui/main/BaseMainActivity$mBleHandleCallback$1\n*L\n177#1:1363,3\n177#1:1367,5\n186#1:1372,7\n186#1:1380,3\n186#1:1383,7\n186#1:1390\n177#1:1366\n186#1:1379\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class II0xO0 implements BleHandleCallback {
        public II0xO0() {
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
            boolean isAppForeground = AppUtils.isAppForeground();
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            sb.append("main onCameraStateChange -> ");
            BleInitializer bleInitializer = BleInitializer.f20700XO;
            sb.append(bleInitializer.XI0oooXX());
            sb.append(", ");
            sb.append(i);
            sb.append(", ");
            sb.append(isAppForeground);
            oix0oi.oIX0oI(sb.toString());
            if (!isAppForeground) {
                return;
            }
            if (i == 1) {
                if (!bleInitializer.XI0oooXX()) {
                    bleInitializer.O0(true);
                    BaseMainActivity baseMainActivity = BaseMainActivity.this;
                    baseMainActivity.startActivity(new Intent(baseMainActivity, (Class<?>) CameraActivity.class));
                    return;
                }
                return;
            }
            bleInitializer.O0(false);
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
            IIX0o.x0xO0oo(deviceSportData, "deviceSportData");
            if (!SportManager.f23843oIX0oI.xI() && ProductManager.f20544oIX0oI.ox0I()) {
                BaseMainActivity baseMainActivity = BaseMainActivity.this;
                int mMode = deviceSportData.getMMode();
                Bundle bundle = new Bundle();
                bundle.putString("mArg0", null);
                bundle.putInt("mArg1", mMode);
                bundle.putParcelable("mArg2", null);
                bundle.putSerializable("mArg3", deviceSportData);
                Intent intent = new Intent(baseMainActivity, (Class<?>) SportOnGoingGpsActivity.class);
                intent.putExtras(bundle);
                baseMainActivity.startActivity(intent);
            }
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
            XoI0Ixx0 xoI0Ixx0;
            if (!z) {
                XoI0Ixx0 xoI0Ixx02 = BaseMainActivity.this.mAGpsPopupReminder;
                if (xoI0Ixx02 != null && xoI0Ixx02.isShowing() && (xoI0Ixx0 = BaseMainActivity.this.mAGpsPopupReminder) != null) {
                    xoI0Ixx0.dismiss();
                    return;
                }
                return;
            }
            BaseMainActivity.this.dismissRepairPopup();
            BaseMainActivity.this.checkGPSFirmwareUpgradeStatus(new Object());
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
    public static final class oIX0oI implements BleHandleCallback {
        public oIX0oI() {
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
            xOOOX mAGpsPopup;
            xOOOX mAGpsPopup2;
            IIX0o.x0xO0oo(bleKey, "bleKey");
            if (z && i2 > 0 && (mAGpsPopup2 = BaseMainActivity.this.getMAGpsPopup()) != null) {
                mAGpsPopup2.XIxXXX0x0((i3 * 100) / i2);
            }
            if ((!z || i2 == i3) && (mAGpsPopup = BaseMainActivity.this.getMAGpsPopup()) != null && mAGpsPopup.isShowing()) {
                mAGpsPopup.dismiss();
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

    private final void appUserUpdate(AppUser appUser) {
        appUser.setThirdPlatform(null);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        File II0XooXoX2 = IXxxXO.II0XooXoX(X00IoxXI.oIX0oI.f3233oIX0oI);
        final xxxI.II0xO0<AppUser> iI0xO0 = new xxxI.II0xO0<AppUser>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$appUserUpdate$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("appUserUpdate handleError----------------------------");
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO AppUser appUser2) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("appUserUpdate handleResponse----------------------------");
                Xo0 xo0 = Xo0.f24349oIX0oI;
                xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24478xII, false);
                xo0.XO().put(AppUser.class.getName(), new Gson().toJson(appUser2));
            }
        };
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(this, getRootView());
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = Api.INSTANCE.getBASE_URL() + AppUserUpdate.URL;
        final xxxI.II0xO0<Response<AppUser>> iI0xO02 = new xxxI.II0xO0<Response<AppUser>>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$appUserUpdate$$inlined$upload$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<AppUser> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity = this;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
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
        ANRequest.MultiPartBuilder upload = AndroidNetworking.upload(str);
        if (II0XooXoX2.exists()) {
            upload.addMultipartFile("avatar", II0XooXoX2);
        }
        upload.addMultipartParameter(appUser).setTag((Object) str).setPriority(Priority.HIGH).build().setUploadProgressListener(NetWorkUtils$upload$$inlined$upload$1.INSTANCE).getAsParsed(TypeToken.getParameterized(Response.class, AppUser.class), new ParsedRequestListener<Response<AppUser>>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$appUserUpdate$$inlined$upload$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<AppUser> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                xxxI.II0xO0.this.handleError(String.valueOf(aNError));
            }
        });
    }

    private final void checkAppVersion() {
        Xo0.f24349oIX0oI.oIX0oI().put(AppVersion.class.getName(), new Gson().toJson(new AppVersion(0, null, null, null, null, null, 0, 127, null)));
        DeviceInfoChecker.f19983oIX0oI.II0xO0(new BaseMainActivity$checkAppVersion$1(this));
    }

    private final void checkBluetoothPermission() {
        if (Build.VERSION.SDK_INT >= 31) {
            PermissionHelper permissionHelper = PermissionHelper.f24522oIX0oI;
            if (!permissionHelper.OxxIIOOXO(this) && BleConnector.INSTANCE.isBound()) {
                permissionHelper.oxoX(this, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$checkBluetoothPermission$1
                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    public final void invoke(boolean z) {
                        if (z) {
                            BleConnector.INSTANCE.launch();
                        }
                    }
                });
            }
        }
    }

    private final void checkClassicConnect(boolean z) {
        if (Build.VERSION.SDK_INT >= 31 && !PermissionHelper.f24522oIX0oI.OxxIIOOXO(this)) {
            LogUtils.d("checkClassicConnect -> Need BLUETOOTH permission!!!!");
            return;
        }
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.OOOI()) {
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            BleConnector bleConnector = BleConnector.INSTANCE;
            boolean isBoundClassic = bleConnector.isBoundClassic();
            booleanRef.element = isBoundClassic;
            if (!isBoundClassic) {
                if (z) {
                    if (bleConnector.isAvailable() && productManager.o00xOoIO()) {
                        BleConnector.sendInt8$default(bleConnector, BleKey.CLASSIC_BLUETOOTH_STATE, BleKeyFlag.UPDATE, 1, false, false, 24, null);
                    } else {
                        bleConnector.connectClassic();
                    }
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.main.II0XooXoX
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseMainActivity.checkClassicConnect$lambda$19(BaseMainActivity.this, booleanRef);
                    }
                }, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
                return;
            }
            classicNotePopup();
            return;
        }
        if (!z) {
            permissionCheckPopup();
        }
    }

    public static /* synthetic */ void checkClassicConnect$default(BaseMainActivity baseMainActivity, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            baseMainActivity.checkClassicConnect(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkClassicConnect");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkClassicConnect$lambda$19(final BaseMainActivity this$0, Ref.BooleanRef isSystemBind) {
        XoI0Ixx0 xoI0Ixx0;
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(isSystemBind, "$isSystemBind");
        if (this$0.isFocusChanged) {
            BleConnector bleConnector = BleConnector.INSTANCE;
            boolean isBoundClassic = bleConnector.isBoundClassic();
            isSystemBind.element = isBoundClassic;
            if (!isBoundClassic) {
                if (this$0.mClassicConnectPopup == null) {
                    XoI0Ixx0 xoI0Ixx02 = new XoI0Ixx0(this$0, 0, 2, null);
                    String string = this$0.getString(R.string.classic_connect_pop);
                    IIX0o.oO(string, "getString(...)");
                    xoI0Ixx02.Xx000oIo(string);
                    XoI0Ixx0.IO(xoI0Ixx02, Integer.valueOf(R.string.cancel), null, 2, null);
                    xoI0Ixx02.x0o(R.string.settings, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$checkClassicConnect$1$1$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // Oox.oIX0oI
                        @OXOo.OOXIXo
                        public final Boolean invoke() {
                            try {
                                BaseMainActivity.this.startActivity(new Intent("android.settings.BLUETOOTH_SETTINGS"));
                            } catch (Exception unused) {
                                BaseMainActivity.this.startActivity(new Intent("android.settings.SETTINGS"));
                            }
                            return Boolean.TRUE;
                        }
                    });
                    xoI0Ixx02.Oo(new BaseMainActivity$checkClassicConnect$1$1$2(this$0));
                    this$0.mClassicConnectPopup = xoI0Ixx02;
                }
                if (bleConnector.isBound() && (xoI0Ixx0 = this$0.mClassicConnectPopup) != null) {
                    RelativeLayout rootView = this$0.getRootView();
                    IIX0o.oO(rootView, "<get-rootView>(...)");
                    xoI0Ixx0.OxxIIOOXO(rootView);
                    return;
                }
                return;
            }
            this$0.classicNotePopup();
        }
    }

    private final void checkDeviceSecurity() {
    }

    private final boolean checkNotificationPermission() {
        boolean X0o0xo2 = MyNotificationListenerService.f20319OxI.X0o0xo(getMContext());
        if (!X0o0xo2) {
            if (this.mNotificationPopup == null) {
                XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this, 0, 2, null);
                String string = getString(R.string.allow_notification_access, getString(R.string.app_name));
                IIX0o.oO(string, "getString(...)");
                xoI0Ixx0.Xx000oIo(string);
                XoI0Ixx0.IO(xoI0Ixx0, null, null, 2, null);
                xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$checkNotificationPermission$1$1$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        Activity mContext;
                        MyNotificationListenerService.oIX0oI oix0oi = MyNotificationListenerService.f20319OxI;
                        mContext = BaseMainActivity.this.getMContext();
                        oix0oi.II0XooXoX(mContext);
                        BaseMainActivity.this.checkStatusBarNotificationPermission();
                        return Boolean.TRUE;
                    }
                });
                this.mNotificationPopup = xoI0Ixx0;
            }
            XoI0Ixx0 xoI0Ixx02 = this.mNotificationPopup;
            if (xoI0Ixx02 != null) {
                RelativeLayout rootView = getRootView();
                IIX0o.oO(rootView, "<get-rootView>(...)");
                xoI0Ixx02.OxxIIOOXO(rootView);
            }
        }
        return X0o0xo2;
    }

    private final void checkPermission() {
        if (checkNotificationPermission()) {
            checkStatusBarNotificationPermission();
        }
        checkBluetoothPermission();
        checkPostNotificationsPermission();
    }

    private final void checkPostNotificationsPermission() {
        PermissionHelper permissionHelper = PermissionHelper.f24522oIX0oI;
        if (!permissionHelper.X0IIOO(this) && Xo0.f24349oIX0oI.XO().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24371IoOoo, true)) {
            permissionHelper.x0XOIxOo(this, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$checkPostNotificationsPermission$1
                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return oXIO0o0XI.f29392oIX0oI;
                }

                public final void invoke(boolean z) {
                    if (z) {
                        return;
                    }
                    Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24371IoOoo, false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkStatusBarNotificationPermission() {
        boolean areNotificationsEnabled = NotificationManagerCompat.from(getMContext()).areNotificationsEnabled();
        if (!areNotificationsEnabled && Build.VERSION.SDK_INT >= 26) {
            if (this.mStatusBarNotificationPopup == null) {
                XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this, 0, 2, null);
                String string = getString(R.string.allow_status_bar_notification_access);
                IIX0o.oO(string, "getString(...)");
                xoI0Ixx0.Xx000oIo(string);
                XoI0Ixx0.IO(xoI0Ixx0, null, null, 2, null);
                xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$checkStatusBarNotificationPermission$1$1$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        Intent intent = new Intent();
                        try {
                            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                            intent.putExtra("android.provider.extra.APP_PACKAGE", BaseMainActivity.this.getPackageName());
                            intent.putExtra("android.provider.extra.CHANNEL_ID", BaseMainActivity.this.getApplicationInfo().uid);
                            intent.putExtra("app_package", BaseMainActivity.this.getPackageName());
                            intent.putExtra("app_uid", BaseMainActivity.this.getApplicationInfo().uid);
                            BaseMainActivity.this.startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                            intent.putExtra("package", BaseMainActivity.this.getPackageName());
                            BaseMainActivity.this.startActivity(intent);
                        }
                        BaseMainActivity.checkClassicConnect$default(BaseMainActivity.this, false, 1, null);
                        return Boolean.TRUE;
                    }
                });
                this.mStatusBarNotificationPopup = xoI0Ixx0;
            }
            XoI0Ixx0 xoI0Ixx02 = this.mStatusBarNotificationPopup;
            if (xoI0Ixx02 != null) {
                RelativeLayout rootView = getRootView();
                IIX0o.oO(rootView, "<get-rootView>(...)");
                xoI0Ixx02.OxxIIOOXO(rootView);
            }
        }
        return areNotificationsEnabled;
    }

    private final void classicNotePopup() {
        if (ProjectManager.f19822oIX0oI.xXOx()) {
            Xo0 xo0 = Xo0.f24349oIX0oI;
            if (xo0.II0xO0().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24368Io, true)) {
                XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this, 0, 2, null);
                xoI0Ixx0.x0xO0oo(false);
                xoI0Ixx0.IoOoX(R.string.classic_note_title);
                xoI0Ixx0.xI(Integer.valueOf(ProductManager.f20544oIX0oI.o00()));
                XoI0Ixx0.IO(xoI0Ixx0, null, null, 2, null);
                xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$classicNotePopup$1$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        BaseMainActivity.this.permissionCheckPopup();
                        return Boolean.TRUE;
                    }
                });
                this.mClassicNotePopup = xoI0Ixx0;
                RelativeLayout rootView = getRootView();
                IIX0o.oO(rootView, "<get-rootView>(...)");
                xoI0Ixx0.OxxIIOOXO(rootView);
                xo0.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24368Io, false);
                return;
            }
        }
        permissionCheckPopup();
    }

    private final void dataOperating() {
        new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.main.xxIXOIIO
            @Override // java.lang.Runnable
            public final void run() {
                BaseMainActivity.dataOperating$lambda$9(BaseMainActivity.this);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dataOperating$lambda$9(final BaseMainActivity this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.isFocusChanged) {
            Xo0 xo0 = Xo0.f24349oIX0oI;
            SPUtils XO2 = xo0.XO();
            Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
            Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
            if (fromJson != null) {
                appUser = fromJson;
            }
            AppUser appUser2 = (AppUser) appUser;
            if (xo0.XO().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24363IO, true)) {
                this$0.updateUserInfo(appUser2, true);
                if (appUser2.getIdentity().length() > 0) {
                    if (!xo0.XO().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24478xII, false)) {
                        updateUserInfo$default(this$0, appUser2, false, 2, null);
                    } else {
                        this$0.appUserUpdate(appUser2);
                    }
                    this$0.downloadData(appUser2);
                    new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.main.oIX0oI
                        @Override // java.lang.Runnable
                        public final void run() {
                            BaseMainActivity.dataOperating$lambda$9$lambda$3(BaseMainActivity.this);
                        }
                    }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                }
            } else if (appUser2.getHeight() == 0.0f || appUser2.getWeight() == 0.0f) {
                this$0.toPersonalInformationActivity();
            }
            this$0.checkPermission();
            this$0.checkAppVersion();
            DeviceInfoChecker.f19983oIX0oI.xxIXOIIO();
            x0xO0oo.oIX0oI(x0xO0oo.f24650x0xO, Boolean.FALSE);
            this$0.checkFirmwareUpgradeStatus(new Object());
            this$0.initializationRecordTime();
            ProjectManager projectManager = ProjectManager.f19822oIX0oI;
            if (projectManager.XO00XOO()) {
                this$0.uploadToZewaFitPop();
            }
            this$0.showClientAppUpgradePopup();
            if (projectManager.OOxOI()) {
                new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.main.II0xO0
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseMainActivity.dataOperating$lambda$9$lambda$4(BaseMainActivity.this);
                    }
                }, 3000L);
            }
            new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.main.I0Io
                @Override // java.lang.Runnable
                public final void run() {
                    BaseMainActivity.dataOperating$lambda$9$lambda$5(BaseMainActivity.this);
                }
            }, 5000L);
            new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.main.oxoX
                @Override // java.lang.Runnable
                public final void run() {
                    BaseMainActivity.dataOperating$lambda$9$lambda$6(BaseMainActivity.this);
                }
            }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            if (projectManager.xOOOX()) {
                this$0.mHandler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.main.X0o0xo
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseMainActivity.dataOperating$lambda$9$lambda$7(BaseMainActivity.this);
                    }
                }, 3000L);
            }
            this$0.mHandler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.main.XO
                @Override // java.lang.Runnable
                public final void run() {
                    BaseMainActivity.dataOperating$lambda$9$lambda$8(BaseMainActivity.this);
                }
            }, 3000L);
            this$0.mHandler.sendEmptyMessageDelayed(this$0.delayTimeTask, AbsBleConnector.TIMEOUT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dataOperating$lambda$9$lambda$3(BaseMainActivity this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.userMigrate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dataOperating$lambda$9$lambda$4(BaseMainActivity this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.uploadPhoneInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dataOperating$lambda$9$lambda$5(BaseMainActivity this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.requestWeather();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dataOperating$lambda$9$lambda$6(BaseMainActivity this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        checkClassicConnect$default(this$0, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dataOperating$lambda$9$lambda$7(BaseMainActivity this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        ADPAdManager.INSTANCE.getAdMobConsent(this$0, new Oox.x0xO0oo<Boolean, Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$dataOperating$1$5$1
            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool, Boolean bool2) {
                invoke(bool.booleanValue(), bool2.booleanValue());
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(boolean z, boolean z2) {
                Xo0.f24349oIX0oI.oIX0oI().put(com.sma.smartv3.util.XoI0Ixx0.f24369IoIOOxIIo, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dataOperating$lambda$9$lambda$8(BaseMainActivity this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.checkDeviceSecurity();
    }

    private final void downloadData(AppUser appUser) {
        if (!Xo0.f24349oIX0oI.XO().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24496xxIXOIIO, false) && appUser.getDbUrl().length() > 0) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("downloadData");
            final xOOOX xooox = new xOOOX(this, 0, 2, null);
            xooox.xxX(R.string.syncing);
            xooox.XIxXXX0x0(0);
            RelativeLayout rootView = getRootView();
            IIX0o.oO(rootView, "<get-rootView>(...)");
            xooox.OxxIIOOXO(rootView);
            X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
            if (IXxxXO.Oo(oix0oi).exists()) {
                parseData(xooox);
            } else {
                NetWorkUtils.INSTANCE.download(appUser.getDbUrl(), IXxxXO.ooOOo0oXI(oix0oi), "data", new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$downloadData$1
                    @Override // xxxI.II0xO0
                    public void handleError(@OXOo.OOXIXo String error) {
                        IIX0o.x0xO0oo(error, "error");
                        xOOOX.this.dismiss();
                    }

                    @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                    public void handleProgress(int i) {
                        xOOOX.this.XIxXXX0x0(i);
                    }

                    @Override // xxxI.II0xO0
                    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                    public void handleResponse(@OXOo.oOoXoXO String str) {
                        this.parseData(xOOOX.this);
                    }
                });
            }
        }
    }

    private final void initializationRecordTime() {
        EvaluationKt.specialProcessingTime(com.sma.smartv3.util.XoI0Ixx0.f24380O0IxXx);
        EvaluationKt.specialProcessingTime(com.sma.smartv3.util.XoI0Ixx0.f24372IoXIXo);
        EvaluationKt.specialProcessingTime(com.sma.smartv3.util.XoI0Ixx0.f24497xxOXOOoIX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mHandler$lambda$0(BaseMainActivity this$0, Message it) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(it, "it");
        if (it.what == this$0.delayTimeTask) {
            this$0.onShowEvaluationStatus();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void parseData(xOOOX xooox) {
        LogUtils.d("parseData data");
        xooox.xxX(R.string.Parsing);
        xooox.XIxXXX0x0(0);
        if (Download.f25779oIX0oI.II0xO0(xooox) && getStatusFragment().isVisible()) {
            getStatusFragment().onRefresh();
        }
        xooox.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void permissionCheckPopup() {
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.o0oIxOo() || !projectManager.XIo0oOXIx()) {
            return;
        }
        Xo0 xo0 = Xo0.f24349oIX0oI;
        if (xo0.II0xO0().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24434o0, true) && !PermissionHelper.f24522oIX0oI.IXxxXO(this)) {
            XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this, R.layout.pop_message2);
            xoI0Ixx0.x0xO0oo(false);
            xoI0Ixx0.xI(Integer.valueOf(R.string.permission_check_text));
            XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.settings, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$permissionCheckPopup$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    BaseMainActivity baseMainActivity = BaseMainActivity.this;
                    baseMainActivity.startActivity(new Intent(baseMainActivity, (Class<?>) PermissionSettingsActivity.class));
                    return Boolean.TRUE;
                }
            });
            this.mPermissionCheckPopup = xoI0Ixx0;
            RelativeLayout rootView = getRootView();
            IIX0o.oO(rootView, "<get-rootView>(...)");
            xoI0Ixx0.OxxIIOOXO(rootView);
            xo0.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24434o0, false);
        }
    }

    private final void requestWeather() {
        if (PermissionUtils.isGranted(PermissionConstants.LOCATION)) {
            if (!WeatherInitializer.f20909XO.Oxx0IOOO()) {
                LogUtils.v("requestWeather -> the last Request not done");
                return;
            }
            if (!ProductManager.f20544oIX0oI.oI()) {
                LogUtils.v("requestWeather -> Device does not support weather");
                return;
            }
            if (!BleConnector.INSTANCE.isAvailable()) {
                LogUtils.v("requestWeather -> BleConnector is not available");
                return;
            }
            if (this.mLocationClient == null) {
                this.mLocationClient = com.sma.smartv3.location.X0o0xo.II0xO0(new I0Io(), false, 2, null);
            }
            com.sma.smartv3.location.oxoX oxox = this.mLocationClient;
            if (oxox != null) {
                oxox.XO(R.string.show_map_and_phone_get_location_desc, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestWeatherLocation(double d, double d2) {
        SPUtils oIX0oI2 = Xo0.f24349oIX0oI.oIX0oI();
        if (((WeatherRealtime) new Gson().fromJson(oIX0oI2.getString(com.sma.smartv3.util.XoI0Ixx0.f24491xoO0xx0 + '_' + WeatherRealtime.class.getName()), WeatherRealtime.class)) != null && calculateDistance(d2, d, r0.getLat(), r0.getLon())) {
            WeatherInitializer.f20909XO.oOoXoXO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setBottomNavItem$lambda$12(BaseMainActivity this$0, MenuItem it) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(it, "it");
        this$0.clearSubContent();
        Menu menu = this$0.getBottomNav().getMenu();
        IIX0o.oO(menu, "getMenu(...)");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            if (it.getItemId() == menu.getItem(i).getItemId()) {
                this$0.getMViewPager().setCurrentItem(i);
            }
        }
        return false;
    }

    private final xOOOX setProgressBackCallBack(xOOOX xooox) {
        if (xooox == null) {
            xOOOX xooox2 = new xOOOX(this, 0, 2, null);
            xooox2.IXxxXO(new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$setProgressBackCallBack$1$1
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                    invoke2();
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    BaseMainActivity.oIX0oI oix0oi;
                    BleConnector bleConnector = BleConnector.INSTANCE;
                    oix0oi = BaseMainActivity.this.bleHandleCallback;
                    bleConnector.addHandleCallback(oix0oi);
                }
            });
            xooox2.Oo(new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$setProgressBackCallBack$1$2
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                    invoke2();
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    BaseMainActivity.oIX0oI oix0oi;
                    BleConnector bleConnector = BleConnector.INSTANCE;
                    oix0oi = BaseMainActivity.this.bleHandleCallback;
                    bleConnector.removeHandleCallback(oix0oi);
                }
            });
            return xooox2;
        }
        return xooox;
    }

    private final void setupBottomNavigationBar() {
        setNavBarColor(this, oIxOXo.oxoX.I0Io(getMContext(), R.color.bottom_navigation_bg_color));
        getBottomNav().setItemIconTintList(null);
        setBottomNavItem();
        View inflate = LayoutInflater.from(this).inflate(R.layout.red_badge, (ViewGroup) getRootView(), false);
        IIX0o.oO(inflate, "inflate(...)");
        View findViewById = inflate.findViewById(R.id.ivRemind);
        IIX0o.oO(findViewById, "findViewById(...)");
        this.ivRemind = (ImageView) findViewById;
        ((BottomNavigationItemView) getBottomNav().findViewById(R.id.item_bottom_me)).addView(inflate);
        bottomRemoveItem();
        getMViewPager().addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$setupBottomNavigationBar$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                BaseMainActivity.this.getBottomNav().getMenu().getItem(i).setChecked(true);
                BaseMainActivity.this.clearSubContent();
                BaseMainActivity.this.viewPagerSelected(i);
            }
        });
    }

    private final void showClientAppUpgradePopup() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopLocationClient() {
        com.sma.smartv3.location.oxoX oxox = this.mLocationClient;
        if (oxox != null) {
            oxox.II0XooXoX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toPersonalInformationActivity() {
        this.isToPersonalInfo = true;
        ProjectManager.f19822oIX0oI.O0OOX0IIx(this);
    }

    private final void updateUserInfo(final AppUser appUser, final boolean z) {
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> userIdentityBody = RequestBodyKt.getUserIdentityBody(appUser);
        final xxxI.II0xO0<AppUser> iI0xO0 = new xxxI.II0xO0<AppUser>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$updateUserInfo$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO AppUser appUser2) {
                ThirdPlatform thirdPlatform;
                String str;
                int i;
                Xo0 xo0 = Xo0.f24349oIX0oI;
                SPUtils oxoX2 = xo0.oxoX();
                Object appUser3 = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
                Object fromJson = new Gson().fromJson(oxoX2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
                if (fromJson != null) {
                    appUser3 = fromJson;
                }
                AppUser appUser4 = (AppUser) appUser3;
                if (z) {
                    if (appUser2 != null && (thirdPlatform = appUser2.getThirdPlatform()) != null && thirdPlatform.getProjectId() == 2) {
                        SPUtils oIX0oI2 = xo0.oIX0oI();
                        ThirdPlatform thirdPlatform2 = appUser2.getThirdPlatform();
                        if (thirdPlatform2 != null) {
                            str = thirdPlatform2.getOpenId();
                        } else {
                            str = null;
                        }
                        oIX0oI2.put(com.sma.smartv3.util.XoI0Ixx0.f24438o0oxo0oI, str);
                        SPUtils oIX0oI3 = xo0.oIX0oI();
                        ThirdPlatform thirdPlatform3 = appUser2.getThirdPlatform();
                        if (thirdPlatform3 != null) {
                            i = thirdPlatform3.getReplaced();
                        } else {
                            i = 0;
                        }
                        oIX0oI3.put(com.sma.smartv3.util.XoI0Ixx0.f24408X0O0I0, i);
                        return;
                    }
                    return;
                }
                if (appUser4.getHeight() == 0.0f || appUser4.getWeight() == 0.0f) {
                    if (appUser2 != null) {
                        appUser2.setUnit(appUser.getUnit());
                    }
                    xo0.XO().put(AppUser.class.getName(), new Gson().toJson(appUser2));
                    this.parseUserInfo(appUser2);
                    return;
                }
                ToastUtils.showLong(R.string.check_personal_data);
                if (appUser2 != null) {
                    if (appUser2.getNickname().length() == 0 && appUser4.getNickname().length() > 0) {
                        appUser2.setNickname(appUser4.getNickname());
                    }
                    if (appUser2.getBirthday().length() == 0 && appUser4.getBirthday().length() > 0) {
                        appUser2.setBirthday(appUser4.getBirthday());
                    }
                    if (appUser2.getHeight() == 0.0f && appUser4.getHeight() != 0.0f) {
                        appUser2.setHeight(appUser4.getHeight());
                    }
                    if (appUser2.getWeight() == 0.0f && appUser4.getWeight() != 0.0f) {
                        appUser2.setWeight(appUser4.getWeight());
                    }
                }
                if (appUser2 != null) {
                    appUser2.setUnit(appUser.getUnit());
                }
                xo0.XO().put(AppUser.class.getName(), new Gson().toJson(appUser2));
                this.toPersonalInformationActivity();
            }
        };
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), AppUserInfo.URL);
        netWorkUtils.printParam(convertBaseUrl + AppUserInfo.URL, userIdentityBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + AppUserInfo.URL;
        final xxxI.II0xO0<Response<AppUser>> iI0xO02 = new xxxI.II0xO0<Response<AppUser>>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$updateUserInfo$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<AppUser> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
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
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) userIdentityBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, AppUser.class), new ParsedRequestListener<Response<AppUser>>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$updateUserInfo$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<AppUser> response) {
                IIX0o.x0xO0oo(response, "response");
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

    public static /* synthetic */ void updateUserInfo$default(BaseMainActivity baseMainActivity, AppUser appUser, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            baseMainActivity.updateUserInfo(appUser, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateUserInfo");
    }

    private final void uploadPhoneInfo() {
        if (this.isToPersonalInfo) {
            return;
        }
        try {
            UploadInfoManager.f20222oIX0oI.oOoXoXO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void uploadToZewaFitPop() {
        Xo0 xo0 = Xo0.f24349oIX0oI;
        if (!xo0.XO().contains(com.sma.smartv3.util.XoI0Ixx0.f24474x0xO)) {
            SPUtils XO2 = xo0.XO();
            Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
            Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
            if (fromJson != null) {
                appUser = fromJson;
            }
            if (((AppUser) appUser).getIdentity().length() > 0) {
                XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this, 0, 2, null);
                xoI0Ixx0.x0xO0oo(false);
                xoI0Ixx0.Xx000oIo("Is it allowed to sync data to Zewa server?");
                xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$uploadToZewaFitPop$1$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24474x0xO, false);
                        return Boolean.TRUE;
                    }
                });
                xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$uploadToZewaFitPop$1$2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24474x0xO, true);
                        return Boolean.TRUE;
                    }
                });
                RelativeLayout rootView = getRootView();
                IIX0o.oO(rootView, "<get-rootView>(...)");
                xoI0Ixx0.OxxIIOOXO(rootView);
            }
        }
    }

    private final void userMigrate() {
    }

    public void bottomRemoveItem() {
        if (!ProjectManager.f19822oIX0oI.xOoOIoI()) {
            getBottomNav().getMenu().removeItem(R.id.item_bottom_ai);
        }
    }

    public final boolean calculateDistance(double d, double d2, double d3, double d4) {
        boolean z;
        double radians = Math.toRadians(d3 - d);
        double radians2 = Math.toRadians(d4 - d2);
        double d5 = 2;
        double d6 = radians / d5;
        double d7 = radians2 / d5;
        double sin = (Math.sin(d6) * Math.sin(d6)) + (Math.cos(d) * Math.cos(d3) * Math.sin(d7) * Math.sin(d7));
        double d8 = 1000;
        double atan2 = 6371 * d5 * Math.atan2(Math.sqrt(sin), Math.sqrt(1 - sin)) * d8;
        if (atan2 > d8) {
            z = true;
        } else {
            z = false;
        }
        LogUtils.d("requestWeather  distance = " + atan2 + " result = " + z);
        return z;
    }

    @XO0.XO(tag = com.sma.smartv3.util.XoI0Ixx0.f24419XO)
    public final void checkFirmwareUpgradeStatus(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.d("checkFirmwareUpgradeStatus");
        if (ProductManager.f20544oIX0oI.I0oOIX() && Xo0.f24349oIX0oI.II0xO0().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24419XO, false)) {
            if (this.mRepairPopup == null) {
                XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this, 0, 2, null);
                xoI0Ixx0.x0xO0oo(false);
                xoI0Ixx0.IoOoX(R.string.check_firmware_upgrade_failed_tip);
                XoI0Ixx0.IO(xoI0Ixx0, null, null, 2, null);
                xoI0Ixx0.x0o(R.string.firmware_repair, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$checkFirmwareUpgradeStatus$1$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        x0xO0oo.II0xO0(x0xO0oo.f24620XoX, null, 2, null);
                        return Boolean.TRUE;
                    }
                });
                this.mRepairPopup = xoI0Ixx0;
            }
            XoI0Ixx0 xoI0Ixx02 = this.mRepairPopup;
            if (xoI0Ixx02 != null) {
                RelativeLayout rootView = getRootView();
                IIX0o.oO(rootView, "<get-rootView>(...)");
                xoI0Ixx02.OxxIIOOXO(rootView);
            }
        }
    }

    @XO0.XO(tag = com.sma.smartv3.util.XoI0Ixx0.f24409X0o0xo)
    public final void checkGPSFirmwareUpgradeStatus(@OXOo.OOXIXo Object data) {
        XoI0Ixx0 xoI0Ixx0;
        IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("checkGPSFirmwareUpgradeStatus");
        if (ProductManager.f20544oIX0oI.Xxx0oXX() && Xo0.f24349oIX0oI.II0xO0().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24409X0o0xo, false)) {
            if (this.mGPSRepairPopup == null) {
                XoI0Ixx0 xoI0Ixx02 = new XoI0Ixx0(this, 0, 2, null);
                xoI0Ixx02.x0xO0oo(true);
                xoI0Ixx02.IoOoX(R.string.check_gps_firmware_upgrade_failed_tip);
                XoI0Ixx0.IO(xoI0Ixx02, null, null, 2, null);
                xoI0Ixx02.x0o(R.string.firmware_repair, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$checkGPSFirmwareUpgradeStatus$1$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        final BaseMainActivity baseMainActivity = BaseMainActivity.this;
                        return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$checkGPSFirmwareUpgradeStatus$1$1.1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(BleConnector bleConnector) {
                                invoke2(bleConnector);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                                IIX0o.x0xO0oo(it, "it");
                                DeviceInfoChecker.f19983oIX0oI.O0xOxO(BaseMainActivity.this, "A");
                            }
                        }, 1, null));
                    }
                });
                this.mGPSRepairPopup = xoI0Ixx02;
            }
            XoI0Ixx0 xoI0Ixx03 = this.mGPSRepairPopup;
            if ((xoI0Ixx03 == null || !xoI0Ixx03.isShowing()) && (xoI0Ixx0 = this.mGPSRepairPopup) != null) {
                RelativeLayout rootView = getRootView();
                IIX0o.oO(rootView, "<get-rootView>(...)");
                xoI0Ixx0.OxxIIOOXO(rootView);
            }
        }
    }

    public final void clearSubContent() {
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        if (backStackEntryCount >= 0) {
            int i = 0;
            while (true) {
                getSupportFragmentManager().popBackStack();
                if (i != backStackEntryCount) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void dismissRepairPopup() {
        XoI0Ixx0 xoI0Ixx0;
        XoI0Ixx0 xoI0Ixx02 = this.mRepairPopup;
        if (xoI0Ixx02 != null && xoI0Ixx02.isShowing() && (xoI0Ixx0 = this.mRepairPopup) != null) {
            xoI0Ixx0.dismiss();
        }
        Xo0.f24349oIX0oI.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24419XO, false);
    }

    public final BottomNavigationView getBottomNav() {
        return (BottomNavigationView) this.bottomNav$delegate.getValue();
    }

    @OXOo.oOoXoXO
    public final xOOOX getMAGpsPopup() {
        return this.mAGpsPopup;
    }

    public final RelativeLayout getRootView() {
        return (RelativeLayout) this.rootView$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final MainStatusFragment getStatusFragment() {
        MainStatusFragment mainStatusFragment = this.statusFragment;
        if (mainStatusFragment != null) {
            return mainStatusFragment;
        }
        IIX0o.XOxIOxOx("statusFragment");
        return null;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("locale -> " + getResources().getConfiguration().locale);
        BleConnector bleConnector = BleConnector.INSTANCE;
        bleConnector.addHandleCallback(this.mBleHandleCallback);
        if (ProductManager.f20544oIX0oI.xx00oOoI() && ContextCompat.checkSelfPermission(this, g.g) == 0) {
            SmaNotification.oIX0oI oix0oi = SmaNotification.f20192Oxx0IOOO;
            oix0oi.oIX0oI().II0XooXoX();
            oix0oi.oIX0oI().oOoXoXO(0, 0);
        }
        if (bleConnector.isBound()) {
            DeviceInfoChecker.OOXIXo(DeviceInfoChecker.f19983oIX0oI, null, null, 3, null);
        }
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.viewpager.oIX0oI
    @OXOo.OOXIXo
    public List<Fragment> initFragments() {
        setStatusFragment(new MainStatusFragment());
        ArrayList arrayList = new ArrayList();
        arrayList.add(getStatusFragment());
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.OOOI()) {
            arrayList.add(new SportFragment());
            MenuItem findItem = getBottomNav().getMenu().findItem(R.id.item_bottom_sport);
            if (findItem != null) {
                findItem.setVisible(true);
            }
        } else {
            getBottomNav().getMenu().removeItem(R.id.item_bottom_sport);
        }
        if (projectManager.xOoOIoI()) {
            arrayList.add(new AIFragment());
            MenuItem findItem2 = getBottomNav().getMenu().findItem(R.id.item_bottom_ai);
            if (findItem2 != null) {
                findItem2.setVisible(true);
            }
        } else {
            getBottomNav().getMenu().removeItem(R.id.item_bottom_ai);
        }
        arrayList.add(new DeviceFragment());
        arrayList.add(new MainMeFragment());
        return arrayList;
    }

    @Override // com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        if (ProjectManager.f19822oIX0oI.I0oOoX()) {
            ProductManager.f20544oIX0oI.oIxOXo(this);
            return;
        }
        setupBottomNavigationBar();
        dataOperating();
        setupSubContentContainer();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_main;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            ClickUtils.back2HomeFriendly(getString(R.string.back2home));
        } else {
            super.onBackPressed();
        }
    }

    @XO0.XO(tag = x0xO0oo.f24591OO)
    public final void onClassicConnect(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.d("onClassicConnect");
        checkClassicConnect(false);
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        BleConnector.INSTANCE.removeHandleCallback(this.mBleHandleCallback);
        super.onDestroy();
    }

    @XO0.XO(tag = x0xO0oo.f24661xo0x)
    public final void onFindPhone(@OXOo.OOXIXo Object data) {
        XoI0Ixx0 xoI0Ixx0;
        IIX0o.x0xO0oo(data, "data");
        if (this.mFindPhonePopup == null) {
            XoI0Ixx0 xoI0Ixx02 = new XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx02.x0xO0oo(false);
            xoI0Ixx02.oo0xXOI0I(1);
            xoI0Ixx02.xI(Integer.valueOf(R.string.find_watch_success));
            XoI0Ixx0.IO(xoI0Ixx02, null, null, 2, null);
            xoI0Ixx02.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$onFindPhone$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    BleConnector.sendInt8$default(BleConnector.INSTANCE, BleKey.FIND_PHONE, BleKeyFlag.UPDATE, 1, false, false, 24, null);
                    BleInitializer.f20700XO.onFindPhone(false);
                    return Boolean.TRUE;
                }
            });
            this.mFindPhonePopup = xoI0Ixx02;
        }
        XoI0Ixx0 xoI0Ixx03 = this.mFindPhonePopup;
        if ((xoI0Ixx03 == null || !xoI0Ixx03.isShowing()) && (xoI0Ixx0 = this.mFindPhonePopup) != null) {
            RelativeLayout rootView = getRootView();
            IIX0o.oO(rootView, "<get-rootView>(...)");
            xoI0Ixx0.OxxIIOOXO(rootView);
        }
    }

    @XO0.XO(tag = x0xO0oo.f24620XoX)
    public final void onFirmwareRepair(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.d("onFirmwareRepair");
        if (ProductManager.f20544oIX0oI.oxxXoxO().isEmpty()) {
            BleCache bleCache = BleCache.INSTANCE;
            if (IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_NORDIC)) {
                startActivity(new Intent(this, (Class<?>) FirmwareRepairNActivity.class));
                return;
            }
            if (IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_R3Q)) {
                startActivity(new Intent(this, (Class<?>) FirmwareRepairGQActivity.class));
                return;
            }
            if (IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL)) {
                Xo0.f24349oIX0oI.oxoX().put(BleDeviceInfo.class.getName(), new Gson().toJson(bleCache.getMDeviceInfo()));
                startActivity(new Intent(this, (Class<?>) FirmwareRepairSearchActivity.class));
                return;
            }
            if (IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_SIFLI)) {
                Xo0.f24349oIX0oI.oxoX().put(BleDeviceInfo.class.getName(), new Gson().toJson(bleCache.getMDeviceInfo()));
                startActivity(new Intent(this, (Class<?>) FirmwareRepairSActivity.class));
                return;
            } else if (IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL707)) {
                Xo0.f24349oIX0oI.oxoX().put(BleDeviceInfo.class.getName(), new Gson().toJson(bleCache.getMDeviceInfo()));
                startActivity(new Intent(this, (Class<?>) FirmwareRepairSearchActivity.class));
                return;
            } else {
                if (IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL707LITE)) {
                    Xo0.f24349oIX0oI.oxoX().put(BleDeviceInfo.class.getName(), new Gson().toJson(bleCache.getMDeviceInfo()));
                    startActivity(new Intent(this, (Class<?>) FirmwareRepairSearchActivity.class));
                    return;
                }
                return;
            }
        }
        startActivity(new Intent(this, (Class<?>) FirmwareRepairModeActivity.class));
    }

    @XO0.XO(tag = x0xO0oo.f24563I0X0x0oIo)
    public final void onLoginDone(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        dataOperating();
    }

    @XO0.XO(tag = x0xO0oo.f24644oxXx0IX)
    public final void onPackageStatus(@OXOo.OOXIXo Object data) {
        XoI0Ixx0 xoI0Ixx0;
        XoI0Ixx0 xoI0Ixx02;
        IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("onPackageStatus data = " + data);
        BlePackageStatus blePackageStatus = (BlePackageStatus) data;
        int mUIPackageStatus = blePackageStatus.getMUIPackageStatus();
        Integer valueOf = Integer.valueOf(R.string.cancel);
        if (mUIPackageStatus == 1) {
            if (this.mUIPackageStatusPopup == null) {
                XoI0Ixx0 xoI0Ixx03 = new XoI0Ixx0(this, 0, 2, null);
                xoI0Ixx03.x0xO0oo(false);
                xoI0Ixx03.IoOoX(R.string.check_device_repair_title);
                xoI0Ixx03.xI(Integer.valueOf(R.string.check_device_repair_tip));
                XoI0Ixx0.IO(xoI0Ixx03, valueOf, null, 2, null);
                xoI0Ixx03.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$onPackageStatus$1$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        DeviceInfoChecker.f19983oIX0oI.XI0IXoo(BaseMainActivity.this, "A");
                        return Boolean.TRUE;
                    }
                });
                this.mUIPackageStatusPopup = xoI0Ixx03;
            }
            XoI0Ixx0 xoI0Ixx04 = this.mUIPackageStatusPopup;
            if ((xoI0Ixx04 == null || !xoI0Ixx04.isShowing()) && (xoI0Ixx02 = this.mUIPackageStatusPopup) != null) {
                RelativeLayout rootView = getRootView();
                IIX0o.oO(rootView, "<get-rootView>(...)");
                xoI0Ixx02.OxxIIOOXO(rootView);
                return;
            }
            return;
        }
        if (blePackageStatus.getMFontPackageStatus() == 1) {
            if (this.mFontPackageStatusPopup == null) {
                XoI0Ixx0 xoI0Ixx05 = new XoI0Ixx0(this, 0, 2, null);
                xoI0Ixx05.x0xO0oo(false);
                xoI0Ixx05.IoOoX(R.string.check_device_repair_title);
                xoI0Ixx05.xI(Integer.valueOf(R.string.check_font_package_status_tip));
                XoI0Ixx0.IO(xoI0Ixx05, valueOf, null, 2, null);
                xoI0Ixx05.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$onPackageStatus$2$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        DeviceInfoChecker.f19983oIX0oI.o00(BaseMainActivity.this, "A");
                        return Boolean.TRUE;
                    }
                });
                this.mFontPackageStatusPopup = xoI0Ixx05;
            }
            XoI0Ixx0 xoI0Ixx06 = this.mFontPackageStatusPopup;
            if ((xoI0Ixx06 == null || !xoI0Ixx06.isShowing()) && (xoI0Ixx0 = this.mFontPackageStatusPopup) != null) {
                RelativeLayout rootView2 = getRootView();
                IIX0o.oO(rootView2, "<get-rootView>(...)");
                xoI0Ixx0.OxxIIOOXO(rootView2);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mHandler.removeMessages(this.delayTimeTask);
    }

    @XO0.XO(tag = x0xO0oo.f24571IIxOXoOo0)
    public void onRefreshMain(@OXOo.OOXIXo Object data) {
        boolean z;
        IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI("onRefreshMain");
        boolean z2 = true;
        if (getBottomNav().getMenu().findItem(R.id.item_bottom_sport) != null) {
            z = true;
        } else {
            z = false;
        }
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        boolean OOOI2 = projectManager.OOOI();
        if (getBottomNav().getMenu().findItem(R.id.item_bottom_ai) == null) {
            z2 = false;
        }
        boolean xOoOIoI2 = projectManager.xOoOIoI();
        oix0oi.oIX0oI("onRefreshMain -> " + z + TokenParser.SP + OOOI2 + ", " + z2 + TokenParser.SP + xOoOIoI2);
        if (z == OOOI2 && z2 == xOoOIoI2 && !projectManager.XoX()) {
            oix0oi.oIX0oI("onRefreshMain -> not refresh");
            return;
        }
        oix0oi.oIX0oI("onRefreshMain -> need refresh");
        int selectedItemId = getBottomNav().getSelectedItemId();
        int count = getMFragmentPagerAdapter().getCount();
        for (int i = 0; i < count; i++) {
            getSupportFragmentManager().beginTransaction().remove(getMFragmentPagerAdapter().getItem(i)).commitNowAllowingStateLoss();
        }
        getBottomNav().getMenu().clear();
        getBottomNav().inflateMenu(R.menu.bottom_nav);
        BaseFragmentPagerAdapter baseFragmentPagerAdapter = new BaseFragmentPagerAdapter(this);
        getMViewPager().setAdapter(baseFragmentPagerAdapter);
        getMViewPager().setOffscreenPageLimit(baseFragmentPagerAdapter.getCount());
        setMFragmentPagerAdapter(baseFragmentPagerAdapter);
        Menu menu = getBottomNav().getMenu();
        IIX0o.oO(menu, "getMenu(...)");
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (selectedItemId == menu.getItem(i2).getItemId()) {
                getMViewPager().setCurrentItem(i2);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public final void onShowEvaluationStatus() {
        oOXoIIIo ooxoiiio;
        this.mHandler.removeMessages(this.delayTimeTask);
        if (EvaluationKt.isShowEvaluationDialog()) {
            if (this.mEvaluationPopup == null) {
                this.mEvaluationPopup = new oOXoIIIo(this, 0, 2, null);
            }
            oOXoIIIo ooxoiiio2 = this.mEvaluationPopup;
            if ((ooxoiiio2 == null || !ooxoiiio2.isShowing()) && (ooxoiiio = this.mEvaluationPopup) != null) {
                RelativeLayout rootView = getRootView();
                IIX0o.oO(rootView, "<get-rootView>(...)");
                ooxoiiio.xoXoI(rootView);
            }
        }
    }

    @XO0.XO(tag = x0xO0oo.f24592OO0x0xX)
    public final void onShowLocationPopup(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.d("onShowLocationPopup");
        if (Xo0.f24349oIX0oI.II0xO0().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24353I0X0x0oIo, true) && PermissionHelper.f24522oIX0oI.oI0IIXIo(this)) {
            XoI0Ixx0 xoI0Ixx0 = this.locationPopup;
            if (xoI0Ixx0 == null || !xoI0Ixx0.isShowing()) {
                if (this.locationPopup == null) {
                    XoI0Ixx0 xoI0Ixx02 = new XoI0Ixx0(this, 0, 2, null);
                    String string = getString(R.string.background_location_permission_popup_tip, AppUtils.getAppName());
                    IIX0o.oO(string, "getString(...)");
                    xoI0Ixx02.Xx000oIo(string);
                    XoI0Ixx0.IO(xoI0Ixx02, null, null, 2, null);
                    xoI0Ixx02.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$onShowLocationPopup$1$1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // Oox.oIX0oI
                        @OXOo.OOXIXo
                        public final Boolean invoke() {
                            Xo0.f24349oIX0oI.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24353I0X0x0oIo, false);
                            return Boolean.TRUE;
                        }
                    });
                    this.locationPopup = xoI0Ixx02;
                }
                XoI0Ixx0 xoI0Ixx03 = this.locationPopup;
                if (xoI0Ixx03 != null) {
                    xoI0Ixx03.oI0IIXIo(R.id.root_view);
                }
            }
        }
    }

    @XO0.XO(tag = x0xO0oo.f24580Ioxxx)
    public final void onShowSportDetail(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.d("onShowSportDetail " + data);
        if (data instanceof Integer) {
            if (ProjectManager.f19822oIX0oI.OO0()) {
                getMContext().startActivity(new Intent(getMContext(), (Class<?>) SportDetailV2Activity.class).putExtra("mArg1", ((Number) data).intValue()));
            } else {
                getMContext().startActivity(new Intent(getMContext(), (Class<?>) SportDetailActivity.class).putExtra("mArg1", ((Number) data).intValue()));
            }
        }
    }

    @XO0.XO(tag = x0xO0oo.f24668xxIO)
    public final void onShowSyncAgpsPopup(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("onShowSyncAgpsPopup");
        if (this.mAGpsPopupReminder == null) {
            XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this, R.layout.pop_message);
            xoI0Ixx0.IoOoX(R.string.agps_upgrade_title);
            xoI0Ixx0.xI(Integer.valueOf(R.string.agps_upgrade_describe));
            xoI0Ixx0.oo0xXOI0I(1);
            xoI0Ixx0.x0xO0oo(false);
            xoI0Ixx0.X00IoxXI(null, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$onShowSyncAgpsPopup$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    return Boolean.TRUE;
                }
            });
            xoI0Ixx0.x0o(R.string.sync, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$onShowSyncAgpsPopup$1$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    BaseMainActivity.this.onSyncAgps(new Object());
                    return Boolean.TRUE;
                }
            });
            this.mAGpsPopupReminder = xoI0Ixx0;
        }
        XoI0Ixx0 xoI0Ixx02 = this.mAGpsPopupReminder;
        IIX0o.ooOOo0oXI(xoI0Ixx02);
        if (!xoI0Ixx02.isShowing()) {
            XoI0Ixx0 xoI0Ixx03 = this.mAGpsPopupReminder;
            IIX0o.ooOOo0oXI(xoI0Ixx03);
            RelativeLayout rootView = getRootView();
            IIX0o.oO(rootView, "<get-rootView>(...)");
            xoI0Ixx03.OxxIIOOXO(rootView);
        }
    }

    @XO0.XO(tag = x0xO0oo.f24626o0xxxXXxX)
    public final void onSyncAgps(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.d("onSyncAgps");
        showSyncAGPS();
    }

    @XO0.XO(tag = x0xO0oo.f24635oX)
    public final void onThemeChange(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.d(x0xO0oo.f24635oX);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.isFocusChanged = z;
    }

    public void parseUserInfo(@OXOo.oOoXoXO AppUser appUser) {
        Float f;
        Float f2;
        String str = null;
        if (appUser != null) {
            f = Float.valueOf(appUser.getHeight());
        } else {
            f = null;
        }
        if (!IIX0o.X0o0xo(f, 0.0f)) {
            if (appUser != null) {
                f2 = Float.valueOf(appUser.getWeight());
            } else {
                f2 = null;
            }
            if (!IIX0o.X0o0xo(f2, 0.0f)) {
                if (appUser != null) {
                    str = appUser.getEmail();
                }
                if (str == null || appUser.getEmail().length() == 0) {
                    ProjectManager.f19822oIX0oI.IOOoXo0Ix(this);
                    return;
                }
                return;
            }
        }
        toPersonalInformationActivity();
    }

    public void setBottomNavItem() {
        getBottomNav().setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() { // from class: com.sma.smartv3.ui.main.xoIox
            @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                boolean bottomNavItem$lambda$12;
                bottomNavItem$lambda$12 = BaseMainActivity.setBottomNavItem$lambda$12(BaseMainActivity.this, menuItem);
                return bottomNavItem$lambda$12;
            }
        });
    }

    public final void setMAGpsPopup(@OXOo.oOoXoXO xOOOX xooox) {
        this.mAGpsPopup = xooox;
    }

    public final void setStatusFragment(@OXOo.OOXIXo MainStatusFragment mainStatusFragment) {
        IIX0o.x0xO0oo(mainStatusFragment, "<set-?>");
        this.statusFragment = mainStatusFragment;
    }

    public final void setupSubContentContainer() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(2, R.id.bottomNav);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(R.id.sub_content);
        getRootView().addView(frameLayout, layoutParams);
    }

    public final void showAILackingTip(int i) {
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.XooIO0oo0() && projectManager.oIIxXoo() && projectManager.OOOI() && projectManager.xOoOIoI() && i == 2) {
            Xo0 xo0 = Xo0.f24349oIX0oI;
            long j = xo0.XO().getLong(com.sma.smartv3.util.XoI0Ixx0.f24447oOoIIO0, 0L);
            SPUtils XO2 = xo0.XO();
            Object fromJson = new Gson().fromJson(XO2.getString(x0xO0oo.f24656xOoOIoI + '_' + UserMember.class.getName()), (Class<Object>) UserMember.class);
            if (fromJson == null) {
                fromJson = UserMember.class.newInstance();
            }
            UserMember userMember = (UserMember) fromJson;
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("main showAILackingTip  mIsShowTime = " + j + " mUserMember = " + userMember);
            if (userMember.getLatestDateTime() > 0) {
                OrderManager orderManager = OrderManager.f20130oIX0oI;
                if (OrderManager.X0o0xo(orderManager, userMember.getLatestDateTime(), 0, 2, null) && orderManager.XO(j, 1)) {
                    xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24447oOoIIO0, System.currentTimeMillis());
                    XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this, 0, 2, null);
                    xoI0Ixx0.IoOoX(R.string.tip);
                    xoI0Ixx0.xI(Integer.valueOf(R.string.ai_benefits_about_expire));
                    xoI0Ixx0.oo0xXOI0I(1);
                    XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
                    xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.main.BaseMainActivity$showAILackingTip$1$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // Oox.oIX0oI
                        @OXOo.OOXIXo
                        public final Boolean invoke() {
                            BaseMainActivity baseMainActivity = BaseMainActivity.this;
                            String IIX0o2 = OrderManager.IIX0o(OrderManager.f20130oIX0oI, null, null, 3, null);
                            Bundle bundle = new Bundle();
                            bundle.putString("mArg0", IIX0o2);
                            bundle.putInt("mArg1", 2);
                            bundle.putParcelable("mArg2", null);
                            bundle.putSerializable("mArg3", null);
                            Intent intent = new Intent(baseMainActivity, (Class<?>) GoogleWebViewActivity.class);
                            intent.putExtras(bundle);
                            baseMainActivity.startActivity(intent);
                            return Boolean.TRUE;
                        }
                    });
                    xoI0Ixx0.IIXOooo();
                }
            }
        }
    }

    public void showSyncAGPS() {
        xOOOX progressBackCallBack = setProgressBackCallBack(this.mAGpsPopup);
        this.mAGpsPopup = progressBackCallBack;
        if (progressBackCallBack != null) {
            progressBackCallBack.xxX(R.string.downloading);
            progressBackCallBack.XIxXXX0x0(0);
            RelativeLayout rootView = getRootView();
            IIX0o.oO(rootView, "<get-rootView>(...)");
            progressBackCallBack.OxxIIOOXO(rootView);
        }
        AGPSInitializer.f20674XO.OxxIIOOXO(false, this.mAGpsPopup);
    }

    public void viewPagerSelected(int i) {
        showAILackingTip(i);
    }
}
