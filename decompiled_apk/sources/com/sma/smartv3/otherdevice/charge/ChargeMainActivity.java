package com.sma.smartv3.otherdevice.charge;

import Xx000oIo.oxoX;
import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.angcyo.dsladapter.LibExKt;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.github.appintro.indicator.DotIndicatorController;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.DeviceInfoChecker;
import com.sma.smartv3.biz.VoiceService;
import com.sma.smartv3.biz.voice.VoiceManager;
import com.sma.smartv3.ble.MyNotificationListenerService;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.BleInitializer;
import com.sma.smartv3.model.FirmwareVersion;
import com.sma.smartv3.model.ResourcesIdInfo;
import com.sma.smartv3.otherdevice.charge.ChargeMainActivity;
import com.sma.smartv3.pop.xx0X0;
import com.sma.smartv3.ui.device.EBookManagerActivity;
import com.sma.smartv3.ui.device.EarphoneKeySettingsActivity;
import com.sma.smartv3.ui.device.FirmwareRepairSearchActivity;
import com.sma.smartv3.ui.device.FirmwareUpgradeJSmaActivity;
import com.sma.smartv3.ui.device.MemoryManagerActivity;
import com.sma.smartv3.ui.device.MultiDeviceManagerActivity;
import com.sma.smartv3.ui.device.MusicManagerV2Activity;
import com.sma.smartv3.ui.device.NotificationSettingsActivity;
import com.sma.smartv3.ui.device.VoiceActivity;
import com.sma.smartv3.ui.device.VoiceSetActivity;
import com.sma.smartv3.ui.main.MainActivity;
import com.sma.smartv3.ui.me.PermissionSettingsActivity;
import com.sma.smartv3.ui.me.SettingsActivity;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.permission.PermissionHelper;
import com.sma.smartv3.view.ArcProgressBar;
import com.sma.smartv3.view.ImageViewRound;
import com.sma.smartv3.view.ScaleSeekBar;
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
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import okhttp3.internal.Util;

@kotlin.jvm.internal.XX({"SMAP\nChargeMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChargeMainActivity.kt\ncom/sma/smartv3/otherdevice/charge/ChargeMainActivity\n+ 2 BitmapDrawable.kt\nandroidx/core/graphics/drawable/BitmapDrawableKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,1134:1\n28#2:1135\n28#2:1136\n69#3,3:1137\n72#3,5:1141\n69#3,3:1146\n72#3,5:1150\n69#3,3:1155\n72#3,5:1159\n69#3,3:1164\n72#3,5:1168\n69#3,3:1173\n72#3,5:1177\n69#3,3:1182\n72#3,5:1186\n69#3,3:1191\n72#3,5:1195\n69#3,3:1202\n72#3,5:1206\n140#3,5:1211\n145#3,5:1217\n1#4:1140\n1#4:1149\n1#4:1158\n1#4:1167\n1#4:1176\n1#4:1185\n1#4:1194\n1#4:1205\n1#4:1216\n11#5,2:1200\n*S KotlinDebug\n*F\n+ 1 ChargeMainActivity.kt\ncom/sma/smartv3/otherdevice/charge/ChargeMainActivity\n*L\n485#1:1135\n498#1:1136\n875#1:1137,3\n875#1:1141,5\n920#1:1146,3\n920#1:1150,5\n960#1:1155,3\n960#1:1159,5\n1005#1:1164,3\n1005#1:1168,5\n1009#1:1173,3\n1009#1:1177,5\n1108#1:1182,3\n1108#1:1186,5\n1112#1:1191,3\n1112#1:1195,5\n1131#1:1202,3\n1131#1:1206,5\n379#1:1211,5\n379#1:1217,5\n875#1:1140\n920#1:1149\n960#1:1158\n1005#1:1167\n1009#1:1176\n1108#1:1185\n1112#1:1194\n1131#1:1205\n379#1:1216\n1130#1:1200,2\n*E\n"})
/* loaded from: classes12.dex */
public final class ChargeMainActivity extends BaseChargeActivity {

    @OXOo.oOoXoXO
    private TimerTask autoDataSync;
    private boolean isShow;
    private long lastClickTime;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mNotificationPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xOOOX mProgressPop;

    @OXOo.oOoXoXO
    private IO mScreensaver;

    @OXOo.oOoXoXO
    private xx0X0 mSelectAvatarPopup;

    @OXOo.oOoXoXO
    private Timer timer;

    @OXOo.OOXIXo
    private final String TAG = "ChargeMain";

    @OXOo.OOXIXo
    private final kotlin.X0IIOO refreshLayout$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SwipeRefreshLayout>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$refreshLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final SwipeRefreshLayout invoke() {
            return (SwipeRefreshLayout) ChargeMainActivity.this.findViewById(R.id.srf);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) ChargeMainActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO viewPager$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ViewPager>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$viewPager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ViewPager invoke() {
            return (ViewPager) ChargeMainActivity.this.findViewById(R.id.device_viewpager);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO viewPagerMain$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$viewPagerMain$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return LayoutInflater.from(ChargeMainActivity.this).inflate(R.layout.layout_charge_viewpager_main, (ViewGroup) null);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO viewPagerEarPhone$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$viewPagerEarPhone$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return LayoutInflater.from(ChargeMainActivity.this).inflate(R.layout.layout_charge_viewpager_earphone, (ViewGroup) null);
        }
    });

    @OXOo.OOXIXo
    private DeviceType mCurDeviceType = DeviceType.CHARGE;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO chargePanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$chargePanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ChargeMainActivity.this.findViewById(R.id.charge_panel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO earphonePanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$earphonePanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ChargeMainActivity.this.findViewById(R.id.earphone_panel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemChargeBind$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ViewGroup>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$itemChargeBind$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ViewGroup invoke() {
            View viewPagerMain;
            viewPagerMain = ChargeMainActivity.this.getViewPagerMain();
            return (ViewGroup) viewPagerMain.findViewById(R.id.item_charge_bind);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemEarphoneBind$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ViewGroup>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$itemEarphoneBind$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ViewGroup invoke() {
            View viewPagerEarPhone;
            viewPagerEarPhone = ChargeMainActivity.this.getViewPagerEarPhone();
            return (ViewGroup) viewPagerEarPhone.findViewById(R.id.item_earphone_bind);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO indicatorContainer$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ViewGroup>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$indicatorContainer$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ViewGroup invoke() {
            return (ViewGroup) ChargeMainActivity.this.findViewById(R.id.indicator_container);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO indicatorController$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DotIndicatorController>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$indicatorController$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final DotIndicatorController invoke() {
            return new DotIndicatorController(ChargeMainActivity.this);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO pbPower$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ArcProgressBar>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$pbPower$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ArcProgressBar invoke() {
            return (ArcProgressBar) ChargeMainActivity.this.findViewById(R.id.pb_power);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvPower$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$tvPower$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) ChargeMainActivity.this.findViewById(R.id.tv_power);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvState$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$tvState$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) ChargeMainActivity.this.findViewById(R.id.tv_state);
        }
    });

    @OXOo.OOXIXo
    private final Handler handler = new Handler();

    @OXOo.OOXIXo
    private final kotlin.X0IIOO switchStatusRunnable$delegate = kotlin.XIxXXX0x0.oIX0oI(new ChargeMainActivity$switchStatusRunnable$2(this));

    @OXOo.OOXIXo
    private final kotlin.X0IIOO pbRightPower$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ArcProgressBar>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$pbRightPower$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ArcProgressBar invoke() {
            return (ArcProgressBar) ChargeMainActivity.this.findViewById(R.id.pb_earphone_r);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvRightPower$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$tvRightPower$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) ChargeMainActivity.this.findViewById(R.id.tv_earphone_r);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO pbLeftPower$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ArcProgressBar>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$pbLeftPower$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ArcProgressBar invoke() {
            return (ArcProgressBar) ChargeMainActivity.this.findViewById(R.id.pb_earphone_l);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvLeftPower$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$tvLeftPower$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) ChargeMainActivity.this.findViewById(R.id.tv_earphone_l);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO seekbarLightness$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ScaleSeekBar>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$seekbarLightness$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ScaleSeekBar invoke() {
            return (ScaleSeekBar) ChargeMainActivity.this.findViewById(R.id.seekbar_lightness);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvLow$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$tvLow$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) ChargeMainActivity.this.findViewById(R.id.item_lightness_tv_low);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvMiddle$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$tvMiddle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) ChargeMainActivity.this.findViewById(R.id.item_lightness_tv_middle);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvHigh$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$tvHigh$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) ChargeMainActivity.this.findViewById(R.id.item_lightness_tv_high);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO llScreensaver$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$llScreensaver$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ChargeMainActivity.this.findViewById(R.id.ll_screensaver);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mScreensaverPics$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<List<? extends ResourcesIdInfo>>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$mScreensaverPics$2
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final List<? extends ResourcesIdInfo> invoke() {
            return Util.immutableListOf(new ResourcesIdInfo(R.drawable.pic_screensaver_1, 0, false, 6, null), new ResourcesIdInfo(R.drawable.pic_screensaver_2, 0, false, 6, null), new ResourcesIdInfo(R.drawable.pic_screensaver_3, 0, false, 6, null), new ResourcesIdInfo(R.drawable.pic_screensaver_4, 0, false, 6, null), new ResourcesIdInfo(R.drawable.pic_screensaver_5, 0, false, 6, null));
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvScreensaverValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$tvScreensaverValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) ChargeMainActivity.this.findViewById(R.id.tv_screensaver_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO seekbarScreensaver$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SeekBar>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$seekbarScreensaver$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final SeekBar invoke() {
            return (SeekBar) ChargeMainActivity.this.findViewById(R.id.seekbar_screensaver);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ivScreensaver$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageViewRound>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$ivScreensaver$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageViewRound invoke() {
            View viewPagerMain;
            viewPagerMain = ChargeMainActivity.this.getViewPagerMain();
            return (ImageViewRound) viewPagerMain.findViewById(R.id.iv_screensaver);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO addScreensaver$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$addScreensaver$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ChargeMainActivity.this.findViewById(R.id.add_screensaver);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rvScreensaver$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$rvScreensaver$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            return (RecyclerView) ChargeMainActivity.this.findViewById(R.id.rv_screensaver);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemMusicManager$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$itemMusicManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ChargeMainActivity.this.findViewById(R.id.item_music_manager);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemEBookManager$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$itemEBookManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ChargeMainActivity.this.findViewById(R.id.item_ebook_manager);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemVoiceAssistant$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$itemVoiceAssistant$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ChargeMainActivity.this.findViewById(R.id.item_voice_assistant);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemTranslationLayout$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$itemTranslationLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ChargeMainActivity.this.findViewById(R.id.ear_translation_layout);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemDialogueTranslationLayout$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$itemDialogueTranslationLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ChargeMainActivity.this.findViewById(R.id.ear_dialogue_translation_layout);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemSimultaneousTranslationLayout$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$itemSimultaneousTranslationLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ChargeMainActivity.this.findViewById(R.id.ear_simultaneous_translation_layout);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mCrop$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Xx000oIo.oxoX>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$mCrop$2

        /* loaded from: classes12.dex */
        public static final class oIX0oI implements oxoX.II0xO0 {

            /* renamed from: I0Io, reason: collision with root package name */
            public final /* synthetic */ ChargeMainActivity f20974I0Io;

            /* renamed from: II0xO0, reason: collision with root package name */
            @OXOo.OOXIXo
            public final Uri f20975II0xO0;

            /* renamed from: oIX0oI, reason: collision with root package name */
            @OXOo.OOXIXo
            public final Uri f20976oIX0oI;

            public oIX0oI(ChargeMainActivity chargeMainActivity) {
                this.f20974I0Io = chargeMainActivity;
                X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
                this.f20976oIX0oI = oix0oi.oxoX(com.sma.smartv3.initializer.IXxxXO.XIxXXX0x0(oix0oi));
                Uri fromFile = Uri.fromFile(com.sma.smartv3.initializer.IXxxXO.xoXoI(oix0oi));
                kotlin.jvm.internal.IIX0o.oO(fromFile, "fromFile(...)");
                this.f20975II0xO0 = fromFile;
            }

            @Override // Xx000oIo.oxoX.II0xO0
            public void II0xO0(@OXOo.OOXIXo Uri uri) {
                xx0X0 xx0x0;
                IO io2;
                kotlin.jvm.internal.IIX0o.x0xO0oo(uri, "uri");
                LogUtils.d("onCropped => " + uri);
                xx0x0 = this.f20974I0Io.mSelectAvatarPopup;
                if (xx0x0 != null) {
                    xx0x0.dismiss();
                }
                X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
                if (com.sma.smartv3.initializer.IXxxXO.xoXoI(oix0oi).exists()) {
                    Bitmap bitmap = ImageUtils.getBitmap(com.sma.smartv3.initializer.IXxxXO.xoXoI(oix0oi));
                    io2 = this.f20974I0Io.mScreensaver;
                    if (io2 != null) {
                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(bitmap);
                        io2.oOoXoXO(bitmap);
                    }
                    this.f20974I0Io.syncScreensaver();
                }
            }

            @Override // Xx000oIo.oxoX.II0xO0
            @OXOo.OOXIXo
            public Uri getResult() {
                return this.f20975II0xO0;
            }

            @Override // Xx000oIo.oxoX.II0xO0
            @OXOo.OOXIXo
            public Uri oIX0oI() {
                return this.f20976oIX0oI;
            }
        }

        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final Xx000oIo.oxoX invoke() {
            Activity mContext;
            mContext = ChargeMainActivity.this.getMContext();
            return new Xx000oIo.oxoX(mContext, new oIX0oI(ChargeMainActivity.this));
        }
    });

    @OXOo.OOXIXo
    private final oxoX mBleHandleCallback = new oxoX();

    @OXOo.OOXIXo
    private final kotlin.X0IIOO checkCall$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$checkCall$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            return (CheckBox) ChargeMainActivity.this.findViewById(R.id.check_call);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO llNoiseSettings$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$llNoiseSettings$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ChargeMainActivity.this.findViewById(R.id.ll_noise_settings);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ivDenoise$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$ivDenoise$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) ChargeMainActivity.this.findViewById(R.id.iv_denoise);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ivNoiseClose$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$ivNoiseClose$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) ChargeMainActivity.this.findViewById(R.id.iv_noise_close);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ivNoiseTrans$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$ivNoiseTrans$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) ChargeMainActivity.this.findViewById(R.id.iv_transparent);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvDenoise$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$tvDenoise$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) ChargeMainActivity.this.findViewById(R.id.tv_noise_mode_denoise);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvNoiseClose$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$tvNoiseClose$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) ChargeMainActivity.this.findViewById(R.id.tv_noise_mode_close);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvNoiseTrans$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$tvNoiseTrans$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) ChargeMainActivity.this.findViewById(R.id.tv_noise_mode_transparent);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO checkFindEarphoneLeft$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$checkFindEarphoneLeft$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            return (CheckBox) ChargeMainActivity.this.findViewById(R.id.check_find_earphone_left);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO checkFindEarphoneRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$checkFindEarphoneRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            return (CheckBox) ChargeMainActivity.this.findViewById(R.id.check_find_earphone_right);
        }
    });

    @OXOo.OOXIXo
    private BleEarphoneAncSettings mEarphoneAncSettings = (BleEarphoneAncSettings) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.EARPHONE_ANC_SET, BleEarphoneAncSettings.class, null, null, 12, null);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes12.dex */
    public static final class DeviceType {
        private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
        private static final /* synthetic */ DeviceType[] $VALUES;
        public static final DeviceType CHARGE = new DeviceType("CHARGE", 0);
        public static final DeviceType EARPHONE = new DeviceType("EARPHONE", 1);

        private static final /* synthetic */ DeviceType[] $values() {
            return new DeviceType[]{CHARGE, EARPHONE};
        }

        static {
            DeviceType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.I0Io.I0Io($values);
        }

        private DeviceType(String str, int i) {
        }

        @OXOo.OOXIXo
        public static kotlin.enums.oIX0oI<DeviceType> getEntries() {
            return $ENTRIES;
        }

        public static DeviceType valueOf(String str) {
            return (DeviceType) Enum.valueOf(DeviceType.class, str);
        }

        public static DeviceType[] values() {
            return (DeviceType[]) $VALUES.clone();
        }
    }

    /* loaded from: classes12.dex */
    public static final class I0Io implements SeekBar.OnSeekBarChangeListener {
        public I0Io() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@OXOo.oOoXoXO SeekBar seekBar, int i, boolean z) {
            ChargeMainActivity.this.getTvScreensaverValue().setText(ChargeMainActivity.this.getString(R.string.d_s, Integer.valueOf(i + 3)));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@OXOo.oOoXoXO SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@OXOo.oOoXoXO SeekBar seekBar) {
            BleConnector.sendInt8$default(BleConnector.INSTANCE, BleKey.BACK_LIGHT, BleKeyFlag.UPDATE, ChargeMainActivity.this.getSeekbarScreensaver().getProgress() + 3, false, false, 24, null);
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements SeekBar.OnSeekBarChangeListener {
        public II0xO0() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@OXOo.oOoXoXO SeekBar seekBar, int i, boolean z) {
            ChargeMainActivity.this.getTvLow().setEnabled(false);
            ChargeMainActivity.this.getTvMiddle().setEnabled(false);
            ChargeMainActivity.this.getTvHigh().setEnabled(false);
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            ChargeMainActivity.this.getTvHigh().setEnabled(true);
                            BleConnector.sendInt8$default(BleConnector.INSTANCE, BleKey.SCREEN_BRIGHTNESS_SET, BleKeyFlag.UPDATE, 4, false, false, 24, null);
                            return;
                        }
                        return;
                    }
                    ChargeMainActivity.this.getTvMiddle().setEnabled(true);
                    BleConnector.sendInt8$default(BleConnector.INSTANCE, BleKey.SCREEN_BRIGHTNESS_SET, BleKeyFlag.UPDATE, 2, false, false, 24, null);
                    return;
                }
                ChargeMainActivity.this.getTvLow().setEnabled(true);
                BleConnector.sendInt8$default(BleConnector.INSTANCE, BleKey.SCREEN_BRIGHTNESS_SET, BleKeyFlag.UPDATE, 0, false, false, 24, null);
                return;
            }
            ChargeMainActivity.this.getSeekbarLightness().setProgress(1);
            ChargeMainActivity.this.getTvLow().setEnabled(true);
            BleConnector.sendInt8$default(BleConnector.INSTANCE, BleKey.SCREEN_BRIGHTNESS_SET, BleKeyFlag.UPDATE, 0, false, false, 24, null);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@OXOo.oOoXoXO SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@OXOo.oOoXoXO SeekBar seekBar) {
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends TimerTask {
        public oIX0oI() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (!ChargeMainActivity.this.getRefreshLayout().isRefreshing() && BleConnector.INSTANCE.isAvailable()) {
                ChargeMainActivity.this.syncInfo();
            }
        }
    }

    /* loaded from: classes12.dex */
    public static final class oxoX implements BleHandleCallback {
        public oxoX() {
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
            if (bleKey == BleKey.WATCH_FACE) {
                ChargeMainActivity.this.syncFailed();
            } else if (bleKey == BleKey.POWER) {
                ChargeMainActivity.this.syncDone();
            }
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceConnected(@OXOo.OOXIXo BluetoothDevice bluetoothDevice) {
            BleHandleCallback.DefaultImpls.onDeviceConnected(this, bluetoothDevice);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceConnecting(boolean z) {
            if (z && ChargeMainActivity.this.mCurDeviceType == DeviceType.CHARGE) {
                ChargeMainActivity.this.getTvState().setText(R.string.device_connecting);
            }
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
        public void onEarphoneAncSettingsUpdate(@OXOo.OOXIXo BleEarphoneAncSettings earphoneAncSettings) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(earphoneAncSettings, "earphoneAncSettings");
            ChargeMainActivity.this.mEarphoneAncSettings = earphoneAncSettings;
            ChargeMainActivity chargeMainActivity = ChargeMainActivity.this;
            chargeMainActivity.showNoiseSetTab(chargeMainActivity.mEarphoneAncSettings.getMMode());
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onEarphoneCallUpdate(int i) {
            ChargeMainActivity.this.initCall();
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
        public void onEarphoneStateUpdate(@OXOo.OOXIXo BleEarphoneState earphoneState) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(earphoneState, "earphoneState");
            ChargeMainActivity.this.syncDone();
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
        public void onFindEarphoneUpdate(@OXOo.OOXIXo BleFindEarphone findEarphone) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(findEarphone, "findEarphone");
            ChargeMainActivity.this.initFindEarphone();
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
        public void onReadEarphoneAncSettings(@OXOo.OOXIXo BleEarphoneAncSettings earphoneAncSettings) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(earphoneAncSettings, "earphoneAncSettings");
            ChargeMainActivity.this.mEarphoneAncSettings = earphoneAncSettings;
            ChargeMainActivity chargeMainActivity = ChargeMainActivity.this;
            chargeMainActivity.showNoiseSetTab(chargeMainActivity.mEarphoneAncSettings.getMMode());
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneCall(int i) {
            ChargeMainActivity.this.initCall();
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneInfo(@OXOo.OOXIXo BleEarphoneInfo bleEarphoneInfo) {
            BleHandleCallback.DefaultImpls.onReadEarphoneInfo(this, bleEarphoneInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneKey(@OXOo.OOXIXo BleEarphoneKey earphoneKey) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(earphoneKey, "earphoneKey");
            ChargeMainActivity.this.initNoiseSet();
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphonePower(@OXOo.OOXIXo BleEarphonePower earphonePower) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(earphonePower, "earphonePower");
            ChargeMainActivity.this.syncDone();
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneSoundEffectsSettings(@OXOo.OOXIXo BleEarphoneSoundEffectsSettings bleEarphoneSoundEffectsSettings) {
            BleHandleCallback.DefaultImpls.onReadEarphoneSoundEffectsSettings(this, bleEarphoneSoundEffectsSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneState(@OXOo.OOXIXo BleEarphoneState earphoneState) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(earphoneState, "earphoneState");
            ChargeMainActivity.this.syncDone();
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
            ChargeMainActivity.this.syncDone();
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
        public void onReadSDCardInfo(@OXOo.OOXIXo BleSDCardInfo sdCardInfo) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(sdCardInfo, "sdCardInfo");
            ChargeMainActivity.this.syncDone();
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
            ChargeMainActivity.this.initLightness();
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
            ChargeMainActivity.this.initLightness();
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSessionStateChange(boolean z) {
            LogUtils.d("onSessionStateChange " + z);
            com.sma.smartv3.pop.xOOOX xooox = ChargeMainActivity.this.mProgressPop;
            if (xooox != null) {
                xooox.dismiss();
            }
            ChargeMainActivity.this.mProgressPop = null;
            if (z) {
                ChargeMainActivity.this.handler.removeCallbacks(ChargeMainActivity.this.getSwitchStatusRunnable());
                ChargeMainActivity.this.getTvState().setText(R.string.device_connectied);
                if (!ChargeMainActivity.this.getRefreshLayout().isRefreshing() && !BleInitializer.f20700XO.OOXIxO0()) {
                    ChargeMainActivity.this.autoSyncData(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                }
                BleConnector bleConnector = BleConnector.INSTANCE;
                BleKey bleKey = BleKey.EARPHONE_ANC_SET;
                BleKeyFlag bleKeyFlag = BleKeyFlag.READ;
                BleConnector.sendData$default(bleConnector, bleKey, bleKeyFlag, null, false, false, 28, null);
                BleConnector.sendData$default(bleConnector, BleKey.SCREEN_BRIGHTNESS_SET, bleKeyFlag, null, false, false, 28, null);
                return;
            }
            ChargeMainActivity.this.handler.postDelayed(ChargeMainActivity.this.getSwitchStatusRunnable(), 10000L);
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
                com.sma.smartv3.pop.xOOOX xooox = ChargeMainActivity.this.mProgressPop;
                if (xooox != null) {
                    xooox.XIxXXX0x0((int) ((i3 / i2) * 100));
                }
                if (i2 == i3) {
                    com.sma.smartv3.pop.xOOOX xooox2 = ChargeMainActivity.this.mProgressPop;
                    if (xooox2 != null) {
                        xooox2.dismiss();
                    }
                    ChargeMainActivity.this.mProgressPop = null;
                    ToastUtils.showLong(R.string.synced);
                    return;
                }
                return;
            }
            ChargeMainActivity.this.syncFailed();
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
    public final void autoSyncData(long j) {
        initInfo();
        timerCancel();
        this.timer = new Timer(true);
        oIX0oI oix0oi = new oIX0oI();
        this.autoDataSync = oix0oi;
        Timer timer = this.timer;
        if (timer != null) {
            timer.schedule(oix0oi, j);
        }
    }

    public static /* synthetic */ void autoSyncData$default(ChargeMainActivity chargeMainActivity, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 20000;
        }
        chargeMainActivity.autoSyncData(j);
    }

    private final boolean checkNotificationPermission() {
        boolean X0o0xo2 = MyNotificationListenerService.f20319OxI.X0o0xo(this);
        if (!X0o0xo2) {
            if (this.mNotificationPopup == null) {
                final com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
                String string = getString(R.string.allow_notification_access, getString(R.string.app_name));
                kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                xoI0Ixx0.Xx000oIo(string);
                com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, null, null, 2, null);
                xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$checkNotificationPermission$1$1$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        MyNotificationListenerService.f20319OxI.II0XooXoX(com.sma.smartv3.pop.XoI0Ixx0.this.Oxx0IOOO());
                        return Boolean.TRUE;
                    }
                });
                this.mNotificationPopup = xoI0Ixx0;
            }
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = this.mNotificationPopup;
            if (xoI0Ixx02 != null) {
                xoI0Ixx02.IIXOooo();
            }
        }
        return X0o0xo2;
    }

    private final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    private final View getAddScreensaver() {
        return (View) this.addScreensaver$delegate.getValue();
    }

    private final View getChargePanel() {
        return (View) this.chargePanel$delegate.getValue();
    }

    private final CheckBox getCheckCall() {
        return (CheckBox) this.checkCall$delegate.getValue();
    }

    private final CheckBox getCheckFindEarphoneLeft() {
        return (CheckBox) this.checkFindEarphoneLeft$delegate.getValue();
    }

    private final CheckBox getCheckFindEarphoneRight() {
        return (CheckBox) this.checkFindEarphoneRight$delegate.getValue();
    }

    private final View getEarphonePanel() {
        return (View) this.earphonePanel$delegate.getValue();
    }

    private final ViewGroup getIndicatorContainer() {
        return (ViewGroup) this.indicatorContainer$delegate.getValue();
    }

    private final DotIndicatorController getIndicatorController() {
        return (DotIndicatorController) this.indicatorController$delegate.getValue();
    }

    private final ViewGroup getItemChargeBind() {
        return (ViewGroup) this.itemChargeBind$delegate.getValue();
    }

    private final View getItemDialogueTranslationLayout() {
        return (View) this.itemDialogueTranslationLayout$delegate.getValue();
    }

    private final View getItemEBookManager() {
        return (View) this.itemEBookManager$delegate.getValue();
    }

    private final ViewGroup getItemEarphoneBind() {
        return (ViewGroup) this.itemEarphoneBind$delegate.getValue();
    }

    private final View getItemMusicManager() {
        return (View) this.itemMusicManager$delegate.getValue();
    }

    private final View getItemSimultaneousTranslationLayout() {
        return (View) this.itemSimultaneousTranslationLayout$delegate.getValue();
    }

    private final View getItemTranslationLayout() {
        return (View) this.itemTranslationLayout$delegate.getValue();
    }

    private final View getItemVoiceAssistant() {
        return (View) this.itemVoiceAssistant$delegate.getValue();
    }

    private final ImageView getIvDenoise() {
        return (ImageView) this.ivDenoise$delegate.getValue();
    }

    private final ImageView getIvNoiseClose() {
        return (ImageView) this.ivNoiseClose$delegate.getValue();
    }

    private final ImageView getIvNoiseTrans() {
        return (ImageView) this.ivNoiseTrans$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageViewRound getIvScreensaver() {
        return (ImageViewRound) this.ivScreensaver$delegate.getValue();
    }

    private final View getLlNoiseSettings() {
        return (View) this.llNoiseSettings$delegate.getValue();
    }

    private final View getLlScreensaver() {
        return (View) this.llScreensaver$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Xx000oIo.oxoX getMCrop() {
        return (Xx000oIo.oxoX) this.mCrop$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ResourcesIdInfo> getMScreensaverPics() {
        return (List) this.mScreensaverPics$delegate.getValue();
    }

    private final ArcProgressBar getPbLeftPower() {
        return (ArcProgressBar) this.pbLeftPower$delegate.getValue();
    }

    private final ArcProgressBar getPbPower() {
        return (ArcProgressBar) this.pbPower$delegate.getValue();
    }

    private final ArcProgressBar getPbRightPower() {
        return (ArcProgressBar) this.pbRightPower$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SwipeRefreshLayout getRefreshLayout() {
        return (SwipeRefreshLayout) this.refreshLayout$delegate.getValue();
    }

    private final RecyclerView getRvScreensaver() {
        return (RecyclerView) this.rvScreensaver$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScaleSeekBar getSeekbarLightness() {
        return (ScaleSeekBar) this.seekbarLightness$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SeekBar getSeekbarScreensaver() {
        return (SeekBar) this.seekbarScreensaver$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable getSwitchStatusRunnable() {
        return (Runnable) this.switchStatusRunnable$delegate.getValue();
    }

    private final TextView getTvDenoise() {
        return (TextView) this.tvDenoise$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvHigh() {
        return (TextView) this.tvHigh$delegate.getValue();
    }

    private final TextView getTvLeftPower() {
        return (TextView) this.tvLeftPower$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvLow() {
        return (TextView) this.tvLow$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvMiddle() {
        return (TextView) this.tvMiddle$delegate.getValue();
    }

    private final TextView getTvNoiseClose() {
        return (TextView) this.tvNoiseClose$delegate.getValue();
    }

    private final TextView getTvNoiseTrans() {
        return (TextView) this.tvNoiseTrans$delegate.getValue();
    }

    private final TextView getTvPower() {
        return (TextView) this.tvPower$delegate.getValue();
    }

    private final TextView getTvRightPower() {
        return (TextView) this.tvRightPower$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvScreensaverValue() {
        return (TextView) this.tvScreensaverValue$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvState() {
        return (TextView) this.tvState$delegate.getValue();
    }

    private final ViewPager getViewPager() {
        return (ViewPager) this.viewPager$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getViewPagerEarPhone() {
        return (View) this.viewPagerEarPhone$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getViewPagerMain() {
        return (View) this.viewPagerMain$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initCall() {
        getCheckCall().setChecked(oOXoIIIo.I0Io.II0xO0(BleCache.getInt$default(BleCache.INSTANCE, BleKey.EARPHONE_CALL, 0, null, 6, null)));
        getCheckCall().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sma.smartv3.otherdevice.charge.oo0xXOI0I
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ChargeMainActivity.initCall$lambda$3(compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initCall$lambda$3(CompoundButton compoundButton, boolean z) {
        BleConnector.sendInt8$default(BleConnector.INSTANCE, BleKey.EARPHONE_CALL, BleKeyFlag.UPDATE, oOXoIIIo.I0Io.I0Io(z), false, false, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initFindEarphone() {
        boolean z;
        BleFindEarphone bleFindEarphone = (BleFindEarphone) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.FIND_EARPHONE, BleFindEarphone.class, null, null, 12, null);
        CheckBox checkFindEarphoneLeft = getCheckFindEarphoneLeft();
        boolean z2 = false;
        if (bleFindEarphone.getMLeft() == 1) {
            z = true;
        } else {
            z = false;
        }
        checkFindEarphoneLeft.setChecked(z);
        ViewParent parent = getCheckFindEarphoneLeft().getParent();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.xxX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChargeMainActivity.initFindEarphone$lambda$11(ChargeMainActivity.this, view);
            }
        });
        CheckBox checkFindEarphoneRight = getCheckFindEarphoneRight();
        if (bleFindEarphone.getMRight() == 1) {
            z2 = true;
        }
        checkFindEarphoneRight.setChecked(z2);
        ViewParent parent2 = getCheckFindEarphoneRight().getParent();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent2).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.XxX0x0xxx
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChargeMainActivity.initFindEarphone$lambda$12(ChargeMainActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initFindEarphone$lambda$11(ChargeMainActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        BleEarphoneState bleEarphoneState = (BleEarphoneState) BleCache.getObject$default(BleCache.INSTANCE, BleKey.EARPHONE_STATE, BleEarphoneState.class, null, 4, null);
        if (bleEarphoneState != null && bleEarphoneState.getMLeftState() == 1) {
            this$0.getCheckFindEarphoneLeft().setChecked(true ^ this$0.getCheckFindEarphoneLeft().isChecked());
            BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.FIND_EARPHONE, BleKeyFlag.UPDATE, new BleFindEarphone(oOXoIIIo.I0Io.I0Io(this$0.getCheckFindEarphoneLeft().isChecked()), oOXoIIIo.I0Io.I0Io(this$0.getCheckFindEarphoneRight().isChecked())), false, false, 24, null);
            if (this$0.getCheckFindEarphoneLeft().isChecked()) {
                ToastUtils.showLong(this$0.getString(R.string.find_earphone_on), new Object[0]);
                return;
            }
            return;
        }
        ToastUtils.showShort(R.string.not_connected);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initFindEarphone$lambda$12(ChargeMainActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        BleEarphoneState bleEarphoneState = (BleEarphoneState) BleCache.getObject$default(BleCache.INSTANCE, BleKey.EARPHONE_STATE, BleEarphoneState.class, null, 4, null);
        if (bleEarphoneState != null && bleEarphoneState.getMRightState() == 1) {
            this$0.getCheckFindEarphoneRight().setChecked(true ^ this$0.getCheckFindEarphoneRight().isChecked());
            BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.FIND_EARPHONE, BleKeyFlag.UPDATE, new BleFindEarphone(oOXoIIIo.I0Io.I0Io(this$0.getCheckFindEarphoneLeft().isChecked()), oOXoIIIo.I0Io.I0Io(this$0.getCheckFindEarphoneRight().isChecked())), false, false, 24, null);
            if (this$0.getCheckFindEarphoneRight().isChecked()) {
                ToastUtils.showLong(this$0.getString(R.string.find_earphone_on), new Object[0]);
                return;
            }
            return;
        }
        ToastUtils.showShort(R.string.not_connected);
    }

    private final void initIndicator() {
        getIndicatorContainer().addView(getIndicatorController().newInstance(this));
        getIndicatorController().initialize(2);
        getIndicatorController().setUnselectedIndicatorColor(ContextCompat.getColor(this, R.color.charge_info_pb_bg_color));
        getIndicatorController().setSelectedIndicatorColor(ContextCompat.getColor(this, R.color.charge_info_pb_end_color));
    }

    private final void initInfo() {
        BleCache bleCache = BleCache.INSTANCE;
        int int$default = BleCache.getInt$default(bleCache, BleKey.POWER, 0, null, 4, null);
        getTvPower().setText(getString(R.string.d_percent, Integer.valueOf(int$default)));
        getPbPower().I0Io(int$default, 100);
        getPbLeftPower().setProgress(1.0f);
        getPbRightPower().setProgress(1.0f);
        BleEarphonePower bleEarphonePower = (BleEarphonePower) BleCache.getObject$default(bleCache, BleKey.EARPHONE_POWER, BleEarphonePower.class, null, 4, null);
        if (bleEarphonePower != null) {
            getTvLeftPower().setText(getString(R.string.d_percent, Integer.valueOf(bleEarphonePower.getMLeftPower())));
            getPbLeftPower().I0Io(bleEarphonePower.getMLeftPower(), 100);
            getTvRightPower().setText(getString(R.string.d_percent, Integer.valueOf(bleEarphonePower.getMRightPower())));
            getPbRightPower().I0Io(bleEarphonePower.getMRightPower(), 100);
        }
        showCurDeviceState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initLightness() {
        getSeekbarLightness().setOnSeekBarChangeListener(new II0xO0());
        getSeekbarLightness().setProgress(valueToProgress(BleCache.getInt$default(BleCache.INSTANCE, BleKey.SCREEN_BRIGHTNESS_SET, 0, null, 4, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initNoiseSet() {
        int i;
        BleEarphoneKey bleEarphoneKey = (BleEarphoneKey) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.EARPHONE_KEY, BleEarphoneKey.class, null, null, 12, null);
        View llNoiseSettings = getLlNoiseSettings();
        if (bleEarphoneKey.getMType() == 1) {
            i = 8;
        } else {
            i = 0;
        }
        llNoiseSettings.setVisibility(i);
    }

    private final void initScreensaver() {
        int i;
        View llScreensaver = getLlScreensaver();
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.IxIo()) {
            i = 0;
        } else {
            i = 8;
        }
        llScreensaver.setVisibility(i);
        getAddScreensaver().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.xXxxox0I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChargeMainActivity.initScreensaver$lambda$6(ChargeMainActivity.this, view);
            }
        });
        ImageViewRound ivScreensaver = getIvScreensaver();
        kotlin.jvm.internal.IIX0o.oO(ivScreensaver, "<get-ivScreensaver>(...)");
        IO io2 = new IO(this, ivScreensaver);
        this.mScreensaver = io2;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(io2);
        float XO2 = io2.XO();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(this.mScreensaver);
        ImageViewRound ivScreensaver2 = getIvScreensaver();
        kotlin.jvm.internal.IIX0o.oO(ivScreensaver2, "<get-ivScreensaver>(...)");
        LibExKt.IIX0(ivScreensaver2, SizeUtils.dp2px(110.0f), SizeUtils.dp2px((XO2 / r2.Oxx0IOOO()) * 110.0f));
        ImageViewRound ivScreensaver3 = getIvScreensaver();
        IO io3 = this.mScreensaver;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(io3);
        ivScreensaver3.setRadius(SizeUtils.dp2px(io3.II0XooXoX()));
        RecyclerView rvScreensaver = getRvScreensaver();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        rvScreensaver.setLayoutManager(linearLayoutManager);
        getRvScreensaver().setAdapter(new ChargeMainActivity$initScreensaver$3(this, getMScreensaverPics()));
        int int$default = BleCache.getInt$default(BleCache.INSTANCE, BleKey.BACK_LIGHT, productManager.OxxIIOOXO(), null, 4, null);
        getSeekbarScreensaver().setProgress(int$default - 3);
        getTvScreensaverValue().setText(getString(R.string.d_s, Integer.valueOf(int$default)));
        getSeekbarScreensaver().setOnSeekBarChangeListener(new I0Io());
        DeviceInfoChecker.f19983oIX0oI.oI0IIXIo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initScreensaver$lambda$6(ChargeMainActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.selectImagePopup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(ChargeMainActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.startActivityForResult(new Intent(this$0, (Class<?>) MultiDeviceManagerActivity.class), 7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(ChargeMainActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.onRefresh();
    }

    private final void initViewPager() {
        getViewPager().setAdapter(new PagerAdapter() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$initViewPager$1
            @Override // androidx.viewpager.widget.PagerAdapter
            public void destroyItem(@OXOo.OOXIXo ViewGroup container, int i, @OXOo.OOXIXo Object object) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(container, "container");
                kotlin.jvm.internal.IIX0o.x0xO0oo(object, "object");
                container.removeView((View) object);
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                return 2;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            @OXOo.OOXIXo
            public Object instantiateItem(@OXOo.OOXIXo ViewGroup container, int i) {
                View viewPagerEarPhone;
                View viewPagerEarPhone2;
                View viewPagerMain;
                kotlin.jvm.internal.IIX0o.x0xO0oo(container, "container");
                if (i == 0) {
                    viewPagerMain = ChargeMainActivity.this.getViewPagerMain();
                    container.addView(viewPagerMain, 0);
                    viewPagerEarPhone2 = ChargeMainActivity.this.getViewPagerMain();
                } else {
                    viewPagerEarPhone = ChargeMainActivity.this.getViewPagerEarPhone();
                    container.addView(viewPagerEarPhone, 0);
                    viewPagerEarPhone2 = ChargeMainActivity.this.getViewPagerEarPhone();
                }
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(viewPagerEarPhone2);
                return viewPagerEarPhone2;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public boolean isViewFromObject(@OXOo.OOXIXo View view, @OXOo.OOXIXo Object object) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
                kotlin.jvm.internal.IIX0o.x0xO0oo(object, "object");
                return kotlin.jvm.internal.IIX0o.Oxx0IOOO(view, object);
            }
        });
        getViewPager().addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$initViewPager$2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                ChargeMainActivity.DeviceType deviceType;
                ChargeMainActivity chargeMainActivity = ChargeMainActivity.this;
                if (i == 0) {
                    deviceType = ChargeMainActivity.DeviceType.CHARGE;
                } else {
                    deviceType = ChargeMainActivity.DeviceType.EARPHONE;
                }
                chargeMainActivity.mCurDeviceType = deviceType;
                ChargeMainActivity chargeMainActivity2 = ChargeMainActivity.this;
                chargeMainActivity2.showCurDeviceView(chargeMainActivity2.mCurDeviceType);
            }
        });
    }

    public static /* synthetic */ void onBindStateChange$default(ChargeMainActivity chargeMainActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        chargeMainActivity.onBindStateChange(z);
    }

    private final void onRefresh() {
        if (BleConnector.INSTANCE.isAvailable()) {
            if (!com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24435o00)) {
                syncInfo();
            }
        } else {
            ToastUtils.showShort(R.string.not_connected);
            new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.IIX0o
                @Override // java.lang.Runnable
                public final void run() {
                    ChargeMainActivity.onRefresh$lambda$4(ChargeMainActivity.this);
                }
            }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefresh$lambda$4(ChargeMainActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getRefreshLayout().setRefreshing(false);
        com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().put(com.sma.smartv3.util.XoI0Ixx0.f24435o00, this$0.getRefreshLayout().isRefreshing());
    }

    private final void selectImagePopup() {
        if (this.mSelectAvatarPopup == null) {
            xx0X0 xx0x0 = new xx0X0(this);
            xx0x0.xI(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$selectImagePopup$1$1
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
                    invoke2();
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Activity mContext;
                    PermissionHelper permissionHelper = PermissionHelper.f24522oIX0oI;
                    mContext = ChargeMainActivity.this.getMContext();
                    final ChargeMainActivity chargeMainActivity = ChargeMainActivity.this;
                    permissionHelper.X0o0xo(mContext, new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$selectImagePopup$1$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        public final void invoke(boolean z) {
                            Xx000oIo.oxoX mCrop;
                            if (z) {
                                mCrop = ChargeMainActivity.this.getMCrop();
                                mCrop.I0Io();
                            }
                        }
                    });
                }
            });
            xx0x0.ooXIXxIX(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$selectImagePopup$1$2
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
                    invoke2();
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Xx000oIo.oxoX mCrop;
                    mCrop = ChargeMainActivity.this.getMCrop();
                    mCrop.OOXIXo();
                }
            });
            this.mSelectAvatarPopup = xx0x0;
        }
        xx0X0 xx0x02 = this.mSelectAvatarPopup;
        if (xx0x02 != null) {
            xx0x02.IIXOooo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCurDeviceState() {
        if (this.mCurDeviceType == DeviceType.CHARGE) {
            if (BleConnector.INSTANCE.isAvailable()) {
                getTvState().setText(R.string.device_connectied);
                return;
            } else {
                getTvState().setText(R.string.device_disconnected);
                return;
            }
        }
        BleEarphoneState bleEarphoneState = (BleEarphoneState) BleCache.getObject$default(BleCache.INSTANCE, BleKey.EARPHONE_STATE, BleEarphoneState.class, null, 4, null);
        if (BleConnector.INSTANCE.isAvailable() && ((bleEarphoneState != null && bleEarphoneState.getMLeftState() == 1) || (bleEarphoneState != null && bleEarphoneState.getMRightState() == 1))) {
            getTvState().setText(R.string.device_connectied);
        } else {
            getTvState().setText(R.string.device_disconnected);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCurDeviceView(DeviceType deviceType) {
        String str;
        String str2;
        getViewPager().setCurrentItem(deviceType.ordinal());
        getIndicatorController().selectPosition(deviceType.ordinal());
        if (deviceType == DeviceType.CHARGE) {
            getChargePanel().setVisibility(0);
            getEarphonePanel().setVisibility(8);
            ((TextView) findViewById(R.id.abh_title_center)).setText(ProductManager.f20544oIX0oI.Oo());
        } else {
            getChargePanel().setVisibility(8);
            getEarphonePanel().setVisibility(0);
            BleEarphoneInfo bleEarphoneInfo = (BleEarphoneInfo) BleCache.getObject$default(BleCache.INSTANCE, BleKey.EARPHONE_INFO, BleEarphoneInfo.class, null, 4, null);
            TextView textView = (TextView) findViewById(R.id.abh_title_center);
            String str3 = null;
            if (bleEarphoneInfo != null) {
                str = bleEarphoneInfo.getMBleName();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                str2 = "TW03";
            } else {
                if (bleEarphoneInfo != null) {
                    str3 = bleEarphoneInfo.getMBleName();
                }
                str2 = str3;
            }
            textView.setText(str2);
        }
        showCurDeviceState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showNoiseSetTab(int i) {
        getIvDenoise().setBackgroundResource(R.color.transparent);
        getIvDenoise().setImageResource(R.drawable.ic_denoise_gray);
        getTvDenoise().setEnabled(false);
        getIvNoiseClose().setBackgroundResource(R.color.transparent);
        getIvNoiseClose().setImageResource(R.drawable.ic_noise_close_gray);
        getTvNoiseClose().setEnabled(false);
        getIvNoiseTrans().setBackgroundResource(R.color.transparent);
        getIvNoiseTrans().setImageResource(R.drawable.ic_transparent_gray);
        getTvNoiseTrans().setEnabled(false);
        if (i != 1) {
            if (i != 2) {
                getIvNoiseClose().setBackgroundResource(R.drawable.shape_charge_panel_set_fg);
                getIvNoiseClose().setImageResource(R.drawable.ic_noise_close_true);
                getTvNoiseClose().setEnabled(true);
                return;
            } else {
                getIvNoiseTrans().setBackgroundResource(R.drawable.shape_charge_panel_set_fg);
                getIvNoiseTrans().setImageResource(R.drawable.ic_transparent_true);
                getTvNoiseTrans().setEnabled(true);
                return;
            }
        }
        getIvDenoise().setBackgroundResource(R.drawable.shape_charge_panel_set_fg);
        getIvDenoise().setImageResource(R.drawable.ic_denoise_true);
        getTvDenoise().setEnabled(true);
    }

    private final void showShutdownPopup() {
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
        xoI0Ixx0.IoOoX(R.string.shutdown_tip);
        xoI0Ixx0.xI(Integer.valueOf(R.string.charge_shutdown_tip));
        com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
        xoI0Ixx0.x0o(R.string.shutdown, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$showShutdownPopup$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Boolean invoke() {
                BleConnector.sendInt8$default(BleConnector.INSTANCE, BleKey.SHUTDOWN, BleKeyFlag.UPDATE, 0, false, false, 24, null);
                return Boolean.TRUE;
            }
        });
        xoI0Ixx0.IIXOooo();
    }

    private final void showUnbindPopup() {
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
        xoI0Ixx0.IoOoX(R.string.unbind_tip);
        com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
        xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$showUnbindPopup$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Boolean invoke() {
                Boolean bool = Boolean.TRUE;
                com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24614XX, bool);
                return bool;
            }
        });
        xoI0Ixx0.IIXOooo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncDone() {
        getRefreshLayout().setRefreshing(false);
        com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().put(com.sma.smartv3.util.XoI0Ixx0.f24435o00, getRefreshLayout().isRefreshing());
        if (this.isShow) {
            autoSyncData$default(this, 0L, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncFailed() {
        com.sma.smartv3.pop.xOOOX xooox = this.mProgressPop;
        if (xooox != null) {
            xooox.dismiss();
        }
        this.mProgressPop = null;
        ToastUtils.showLong(R.string.sync_failed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncInfo() {
        com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().put(com.sma.smartv3.util.XoI0Ixx0.f24435o00, true);
        BleConnector bleConnector = BleConnector.INSTANCE;
        BleKey bleKey = BleKey.POWER;
        BleKeyFlag bleKeyFlag = BleKeyFlag.READ;
        BleConnector.sendData$default(bleConnector, bleKey, bleKeyFlag, null, false, false, 28, null);
        BleConnector.sendData$default(bleConnector, BleKey.EARPHONE_POWER, bleKeyFlag, null, false, false, 28, null);
        BleConnector.sendData$default(bleConnector, BleKey.EARPHONE_STATE, bleKeyFlag, null, false, false, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncScreensaver() {
        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$syncScreensaver$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                invoke2(bleConnector);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                IO io2;
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                io2 = ChargeMainActivity.this.mScreensaver;
                if (io2 != null) {
                    ChargeMainActivity chargeMainActivity = ChargeMainActivity.this;
                    if (chargeMainActivity.mProgressPop == null) {
                        com.sma.smartv3.pop.xOOOX xooox = new com.sma.smartv3.pop.xOOOX(chargeMainActivity, 0, 2, null);
                        xooox.xxX(R.string.syncing);
                        xooox.XIxXXX0x0(0);
                        chargeMainActivity.mProgressPop = xooox;
                        com.sma.smartv3.pop.xOOOX xooox2 = chargeMainActivity.mProgressPop;
                        if (xooox2 != null) {
                            xooox2.IIXOooo();
                        }
                        BleConnector.sendStream$default(BleConnector.INSTANCE, BleKey.WATCH_FACE, io2.oIX0oI(), 0, 4, (Object) null);
                    }
                }
            }
        }, 1, null);
    }

    private final void timerCancel() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
        TimerTask timerTask = this.autoDataSync;
        if (timerTask != null) {
            timerTask.cancel();
        }
    }

    private final int valueToProgress(int i) {
        if (i < 2) {
            return 1;
        }
        return i > 2 ? 3 : 2;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        BleConnector.INSTANCE.addHandleCallback(this.mBleHandleCallback);
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.sma.smartv3.otherdevice.charge.BaseChargeActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Xx000oIo.oxoX.oO(getMCrop(), this, null, 2, null);
        BarUtils.transparentStatusBar(this);
        BarUtils.addMarginTopEqualStatusBarHeight(findViewById(R.id.title_bar));
        setNavBarColor(this, oIxOXo.oxoX.I0Io(this, R.color.charge_bg_end_color));
        int i6 = 0;
        if (ProjectManager.f19822oIX0oI.oXX0IoI()) {
            getAbhTitleRight().setVisibility(0);
            getAbhTitleRight().setImageResource(R.drawable.icon_multi_device);
            getAbhTitleRight().setImageTintList(oIxOXo.oxoX.X0o0xo(this, R.color.light));
            getAbhTitleRight().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.ooXIXxIX
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChargeMainActivity.initView$lambda$1(ChargeMainActivity.this, view);
                }
            });
        }
        getRefreshLayout().setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.sma.smartv3.otherdevice.charge.xI
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                ChargeMainActivity.initView$lambda$2(ChargeMainActivity.this);
            }
        });
        initViewPager();
        initIndicator();
        initLightness();
        initScreensaver();
        initCall();
        View itemMusicManager = getItemMusicManager();
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.oOIx()) {
            i = 0;
        } else {
            i = 8;
        }
        itemMusicManager.setVisibility(i);
        View itemEBookManager = getItemEBookManager();
        if (productManager.oI0()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        itemEBookManager.setVisibility(i2);
        View itemVoiceAssistant = getItemVoiceAssistant();
        if (productManager.XXoO0oX()) {
            VoiceService.f20239Oo.I0Io();
            i3 = 0;
        } else {
            i3 = 8;
        }
        itemVoiceAssistant.setVisibility(i3);
        View itemTranslationLayout = getItemTranslationLayout();
        if (!productManager.oxIO0IIo() && !productManager.Ox00XOXoo()) {
            i4 = 8;
        } else {
            VoiceService.f20239Oo.I0Io();
            i4 = 0;
        }
        itemTranslationLayout.setVisibility(i4);
        View itemDialogueTranslationLayout = getItemDialogueTranslationLayout();
        if (productManager.oxIO0IIo()) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        itemDialogueTranslationLayout.setVisibility(i5);
        View itemSimultaneousTranslationLayout = getItemSimultaneousTranslationLayout();
        if (!productManager.Ox00XOXoo()) {
            i6 = 8;
        }
        itemSimultaneousTranslationLayout.setVisibility(i6);
        initNoiseSet();
        showNoiseSetTab(this.mEarphoneAncSettings.getMMode());
        showCurDeviceView(this.mCurDeviceType);
        initFindEarphone();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_charge_main;
    }

    public final void onAbout(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        ProjectManager.f19822oIX0oI.xo(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        Uri uri;
        super.onActivityResult(i, i2, intent);
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        sb.append(this.TAG);
        sb.append(" device -> onActivityResult: ");
        sb.append(i2);
        sb.append(", ");
        sb.append(i);
        sb.append(", ");
        if (intent != null) {
            uri = intent.getData();
        } else {
            uri = null;
        }
        sb.append(uri);
        oix0oi.oIX0oI(sb.toString());
        if (i == 7) {
            ProductManager productManager = ProductManager.f20544oIX0oI;
            if (!ProductManager.xOOxIO(productManager, null, 1, null)) {
                productManager.oIxOXo(this);
                return;
            }
            return;
        }
        int measuredWidth = getIvScreensaver().getMeasuredWidth();
        int measuredHeight = getIvScreensaver().getMeasuredHeight();
        LogUtils.d("onActivityResult outputX:" + measuredWidth + " outputY:" + measuredHeight);
        getMCrop().Oxx0IOOO(i, i2, intent, 1.0d, ((double) measuredWidth) / ((double) measuredHeight), measuredWidth, measuredHeight);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ActivityUtils.startHomeActivity();
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24572IO)
    public final void onBindStateChange(boolean z) {
        LogUtils.d("onBindStateChange " + z);
        if (!BleConnector.INSTANCE.isBound()) {
            startActivity(new Intent(this, (Class<?>) MainActivity.class));
            finish();
        }
    }

    public final void onCustomANC(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.ble.I0Io.I0Io(new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$onCustomANC$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                invoke2(bleConnector);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                ChargeMainActivity chargeMainActivity = ChargeMainActivity.this;
                chargeMainActivity.startActivity(new Intent(chargeMainActivity, (Class<?>) CustomAncActivity.class));
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BleConnector.INSTANCE.removeHandleCallback(this.mBleHandleCallback);
    }

    public final void onDialogueTranslation(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        startActivity(new Intent(this, (Class<?>) DialogueTranslationActivity.class));
    }

    public final void onEBookManager(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$onEBookManager$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                invoke2(bleConnector);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                ChargeMainActivity chargeMainActivity = ChargeMainActivity.this;
                chargeMainActivity.startActivity(new Intent(chargeMainActivity, (Class<?>) EBookManagerActivity.class));
            }
        }, 1, null);
    }

    public final void onEarphoneLeftKey(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$onEarphoneLeftKey$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                invoke2(bleConnector);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                ChargeMainActivity chargeMainActivity = ChargeMainActivity.this;
                Bundle bundle = new Bundle();
                bundle.putString("mArg0", null);
                bundle.putInt("mArg1", 0);
                bundle.putParcelable("mArg2", null);
                bundle.putSerializable("mArg3", null);
                Intent intent = new Intent(chargeMainActivity, (Class<?>) EarphoneKeySettingsActivity.class);
                intent.putExtras(bundle);
                chargeMainActivity.startActivity(intent);
            }
        }, 1, null);
    }

    public final void onEarphoneRightKey(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$onEarphoneRightKey$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                invoke2(bleConnector);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                ChargeMainActivity chargeMainActivity = ChargeMainActivity.this;
                Bundle bundle = new Bundle();
                bundle.putString("mArg0", null);
                bundle.putInt("mArg1", 1);
                bundle.putParcelable("mArg2", null);
                bundle.putSerializable("mArg3", null);
                Intent intent = new Intent(chargeMainActivity, (Class<?>) EarphoneKeySettingsActivity.class);
                intent.putExtras(bundle);
                chargeMainActivity.startActivity(intent);
            }
        }, 1, null);
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24620XoX)
    public final void onFirmwareRepair(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        LogUtils.d("onFirmwareRepair");
        BleCache bleCache = BleCache.INSTANCE;
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL)) {
            com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX().put(BleDeviceInfo.class.getName(), new Gson().toJson(bleCache.getMDeviceInfo()));
            startActivity(new Intent(this, (Class<?>) FirmwareRepairSearchActivity.class));
        }
    }

    public final void onFirmwareUpgrade(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$onFirmwareUpgrade$1

            @kotlin.jvm.internal.XX({"SMAP\nChargeMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChargeMainActivity.kt\ncom/sma/smartv3/otherdevice/charge/ChargeMainActivity$onFirmwareUpgrade$1$1\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1134:1\n69#2,3:1135\n72#2,5:1139\n1#3:1138\n*S KotlinDebug\n*F\n+ 1 ChargeMainActivity.kt\ncom/sma/smartv3/otherdevice/charge/ChargeMainActivity$onFirmwareUpgrade$1$1\n*L\n944#1:1135,3\n944#1:1139,5\n944#1:1138\n*E\n"})
            /* loaded from: classes12.dex */
            public static final class oIX0oI implements com.sma.smartv3.biz.II0XooXoX<FirmwareVersion> {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public final /* synthetic */ ChargeMainActivity f20978oIX0oI;

                public oIX0oI(ChargeMainActivity chargeMainActivity) {
                    this.f20978oIX0oI = chargeMainActivity;
                }

                @Override // com.sma.smartv3.biz.II0XooXoX
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void onSuccess(@OXOo.oOoXoXO FirmwareVersion firmwareVersion) {
                    if (ProductManager.f20544oIX0oI.xx0X0()) {
                        DeviceInfoChecker.f19983oIX0oI.oxoX(this.f20978oIX0oI);
                    } else {
                        ChargeMainActivity chargeMainActivity = this.f20978oIX0oI;
                        chargeMainActivity.startActivity(new Intent(chargeMainActivity, (Class<?>) FirmwareUpgradeJSmaActivity.class));
                    }
                }

                @Override // com.sma.smartv3.biz.II0XooXoX
                public void onFailure(@OXOo.OOXIXo String error) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                    ToastUtils.showLong(R.string.already_the_latest_version);
                }
            }

            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                invoke2(bleConnector);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                long j;
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                if (com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().getInt(com.sma.smartv3.util.XoI0Ixx0.f24396Oo, 0) >= 50) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j = ChargeMainActivity.this.lastClickTime;
                    if (currentTimeMillis - j >= 3000) {
                        ChargeMainActivity.this.lastClickTime = System.currentTimeMillis();
                        DeviceInfoChecker.XO(DeviceInfoChecker.f19983oIX0oI, new oIX0oI(ChargeMainActivity.this), null, 2, null);
                        return;
                    }
                    return;
                }
                ToastUtils.showLong(R.string.firmware_upgrade_tip_toast);
            }
        }, 1, null);
    }

    public final void onMemoryManager(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        startActivity(new Intent(this, (Class<?>) MemoryManagerActivity.class));
    }

    public final void onMusicManager(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$onMusicManager$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                invoke2(bleConnector);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                ChargeMainActivity chargeMainActivity = ChargeMainActivity.this;
                chargeMainActivity.startActivity(new Intent(chargeMainActivity, (Class<?>) MusicManagerV2Activity.class));
            }
        }, 1, null);
    }

    public final void onNoiseSetTab(@OXOo.OOXIXo final View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.ble.I0Io.I0Io(new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$onNoiseSetTab$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                invoke2(bleConnector);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                int id = view.getId();
                int i = id != R.id.iv_denoise ? id != R.id.iv_transparent ? 0 : 2 : 1;
                this.mEarphoneAncSettings.setMMode(i);
                BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.EARPHONE_ANC_SET, BleKeyFlag.UPDATE, this.mEarphoneAncSettings, false, false, 24, null);
                this.showNoiseSetTab(i);
            }
        });
    }

    public final void onNotification(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (checkNotificationPermission()) {
            startActivity(new Intent(this, (Class<?>) NotificationSettingsActivity.class));
        }
    }

    public final void onOnlineScreensavers(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$onOnlineScreensavers$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                invoke2(bleConnector);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                ProjectManager.f19822oIX0oI.OIxOX(ChargeMainActivity.this);
            }
        }, 1, null);
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24631oOXoIIIo)
    public final void onPairImageAttachmentChange(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        BleCache bleCache = BleCache.INSTANCE;
        File OO2 = com.sma.smartv3.initializer.IXxxXO.OO(oix0oi, new BleDeviceInfo(0, null, bleCache.getMBleName(), null, null, null, null, bleCache.getMFirmwareFlag(), 0, 0L, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -133, -1, -1, oI00o.XO.f31358oIX0oI, null));
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("onPairImageAttachmentChange " + FileUtils.isFileExists(OO2) + TokenParser.SP + OO2);
        if (FileUtils.isFileExists(OO2)) {
            ViewGroup itemEarphoneBind = getItemEarphoneBind();
            Bitmap bitmap = ImageUtils.getBitmap(OO2);
            kotlin.jvm.internal.IIX0o.oO(bitmap, "getBitmap(...)");
            Resources resources = getResources();
            kotlin.jvm.internal.IIX0o.oO(resources, "getResources(...)");
            itemEarphoneBind.setBackgroundDrawable(new BitmapDrawable(resources, bitmap));
            return;
        }
        getItemEarphoneBind().setBackgroundResource(((Number) ProductManager.XoIxOXIXo(ProductManager.f20544oIX0oI, null, 1, null).getSecond()).intValue());
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24577IoOoX)
    public final void onPairImageChange(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        BleCache bleCache = BleCache.INSTANCE;
        File O0Xx2 = com.sma.smartv3.initializer.IXxxXO.O0Xx(oix0oi, new BleDeviceInfo(0, null, bleCache.getMBleName(), null, null, null, null, bleCache.getMFirmwareFlag(), 0, 0L, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -133, -1, -1, oI00o.XO.f31358oIX0oI, null));
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("onPairImageChange " + FileUtils.isFileExists(O0Xx2) + TokenParser.SP + O0Xx2);
        if (FileUtils.isFileExists(O0Xx2)) {
            ViewGroup itemChargeBind = getItemChargeBind();
            Bitmap bitmap = ImageUtils.getBitmap(O0Xx2);
            kotlin.jvm.internal.IIX0o.oO(bitmap, "getBitmap(...)");
            Resources resources = getResources();
            kotlin.jvm.internal.IIX0o.oO(resources, "getResources(...)");
            itemChargeBind.setBackgroundDrawable(new BitmapDrawable(resources, bitmap));
            return;
        }
        getItemChargeBind().setBackgroundResource(((Number) ProductManager.XoIxOXIXo(ProductManager.f20544oIX0oI, null, 1, null).getFirst()).intValue());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.isShow = false;
        timerCancel();
    }

    public final void onPermission(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        startActivity(new Intent(this, (Class<?>) PermissionSettingsActivity.class));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onPairImageChange(new Object());
        onPairImageAttachmentChange(new Object());
        this.isShow = true;
        if (!getRefreshLayout().isRefreshing()) {
            autoSyncData(1000L);
        }
    }

    public final void onSettings(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        startActivity(new Intent(this, (Class<?>) SettingsActivity.class));
    }

    public final void onSimultaneousInterpretation(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        startActivity(new Intent(this, (Class<?>) SimultaneousInterpretationActivity.class));
    }

    public final void onSoundEffects(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.ble.I0Io.I0Io(new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$onSoundEffects$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                invoke2(bleConnector);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                ChargeMainActivity chargeMainActivity = ChargeMainActivity.this;
                chargeMainActivity.startActivity(new Intent(chargeMainActivity, (Class<?>) SoundEffectsSampleActivity.class));
            }
        });
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        onBackPressed();
    }

    public final void onTitleRightClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        showShutdownPopup();
    }

    public final void onUnbind(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        showUnbindPopup();
    }

    public final void onVoiceAssistant(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$onVoiceAssistant$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                invoke2(bleConnector);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                ProductManager productManager = ProductManager.f20544oIX0oI;
                if (!productManager.xIx0XO() && !productManager.oO0OX0() && TextUtils.isEmpty(productManager.I0Io()) && !productManager.XOx()) {
                    UtilsKt.XOxIOxOx(ChargeMainActivity.this);
                    return;
                }
                if (productManager.oo00()) {
                    VoiceManager voiceManager = VoiceManager.INSTANCE;
                    if (voiceManager.isExpired()) {
                        ChargeMainActivity chargeMainActivity = ChargeMainActivity.this;
                        SwipeRefreshLayout refreshLayout = chargeMainActivity.getRefreshLayout();
                        final ChargeMainActivity chargeMainActivity2 = ChargeMainActivity.this;
                        voiceManager.checkBaiduAuth(chargeMainActivity, refreshLayout, new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.otherdevice.charge.ChargeMainActivity$onVoiceAssistant$1.1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                            }

                            public final void invoke(boolean z) {
                                if (z) {
                                    ChargeMainActivity chargeMainActivity3 = ChargeMainActivity.this;
                                    chargeMainActivity3.startActivity(new Intent(chargeMainActivity3, (Class<?>) VoiceActivity.class));
                                } else {
                                    ChargeMainActivity chargeMainActivity4 = ChargeMainActivity.this;
                                    chargeMainActivity4.startActivity(new Intent(chargeMainActivity4, (Class<?>) VoiceSetActivity.class));
                                }
                            }
                        });
                        return;
                    }
                    ChargeMainActivity chargeMainActivity3 = ChargeMainActivity.this;
                    chargeMainActivity3.startActivity(new Intent(chargeMainActivity3, (Class<?>) VoiceActivity.class));
                    return;
                }
                ChargeMainActivity chargeMainActivity4 = ChargeMainActivity.this;
                chargeMainActivity4.startActivity(new Intent(chargeMainActivity4, (Class<?>) VoiceActivity.class));
            }
        }, 1, null);
    }
}
