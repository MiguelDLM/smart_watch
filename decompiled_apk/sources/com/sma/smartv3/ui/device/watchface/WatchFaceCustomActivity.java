package com.sma.smartv3.ui.device.watchface;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Xx000oIo.oxoX;
import android.app.Activity;
import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.LibExKt;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.base.BaseActivity;
import com.bestmafen.androidbase.viewpager.BaseFragmentPagerAdapter;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.IXxxXO;
import com.sma.smartv3.model.ResourcesIdInfo;
import com.sma.smartv3.model.ResourcesIdInfoKt;
import com.sma.smartv3.pop.xOOOX;
import com.sma.smartv3.pop.xx0X0;
import com.sma.smartv3.ui.device.watchface.fragment.ControlElementFragment;
import com.sma.smartv3.ui.device.watchface.fragment.II0XooXoX;
import com.sma.smartv3.ui.device.watchface.fragment.PointerElementFragment;
import com.sma.smartv3.ui.device.watchface.fragment.TimeElementFragment;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.oO;
import com.sma.smartv3.util.permission.PermissionHelper;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.util.xoIox;
import com.sma.smartv3.view.ImageViewRound;
import com.sma.smartv3.view.NoScollViewPager;
import com.sma.smartv3.view.dial.DialElementView;
import com.sma.smartv3.view.text.PFMedium;
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
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nWatchFaceCustomActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WatchFaceCustomActivity.kt\ncom/sma/smartv3/ui/device/watchface/WatchFaceCustomActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,642:1\n254#2:643\n*S KotlinDebug\n*F\n+ 1 WatchFaceCustomActivity.kt\ncom/sma/smartv3/ui/device/watchface/WatchFaceCustomActivity\n*L\n459#1:643\n*E\n"})
/* loaded from: classes12.dex */
public final class WatchFaceCustomActivity extends BaseActivity {
    private ControlElementFragment controlElementFragment;

    @OOXIXo
    private final String is2DAcceleration;

    @oOoXoXO
    private String mAiBgFile;

    @OOXIXo
    private final List<String> mBgFiles;

    @OOXIXo
    private final XO mBleHandleCallback;

    @OOXIXo
    private final X0IIOO mCrop$delegate;
    private byte[] mCurSendBytes;
    private int mCurSyncDevicePosition;
    private int mCurSyncDialId;
    private com.sma.smartv3.ui.device.watchface.oIX0oI mCustomWatchFace;

    @OOXIXo
    private final List<Integer> mDialIds;
    private BaseFragmentPagerAdapter mFragmentPagerAdapter;

    @oOoXoXO
    private xOOOX mProgressPop;

    @oOoXoXO
    private xx0X0 mSelectAvatarPopup;

    @OOXIXo
    private final String paramName;
    private PointerElementFragment pointerElementFragment;
    private CommonAdapter<String> rvBgAdapter;
    private TimeElementFragment timeElementFragment;

    @OOXIXo
    private final X0IIOO abhTitleCenter$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) WatchFaceCustomActivity.this.findViewById(R.id.abh_title_center);
        }
    });
    private final float WATCHFACEVIEW_HEIGHT = 260.0f;

    @OOXIXo
    private final X0IIOO watchfaceView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CardView>() { // from class: com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity$watchfaceView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CardView invoke() {
            return (CardView) WatchFaceCustomActivity.this.findViewById(R.id.watchface_view);
        }
    });

    @OOXIXo
    private final X0IIOO customizeDialBg$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageViewRound>() { // from class: com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity$customizeDialBg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageViewRound invoke() {
            return (ImageViewRound) WatchFaceCustomActivity.this.findViewById(R.id.customizeDialBg);
        }
    });

    @OOXIXo
    private final X0IIOO controlViewStep$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DialElementView>() { // from class: com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity$controlViewStep$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DialElementView invoke() {
            return (DialElementView) WatchFaceCustomActivity.this.findViewById(R.id.controlViewStep);
        }
    });

    @OOXIXo
    private final X0IIOO controlViewHr$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DialElementView>() { // from class: com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity$controlViewHr$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DialElementView invoke() {
            return (DialElementView) WatchFaceCustomActivity.this.findViewById(R.id.controlViewHr);
        }
    });

    @OOXIXo
    private final X0IIOO controlViewCa$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DialElementView>() { // from class: com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity$controlViewCa$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DialElementView invoke() {
            return (DialElementView) WatchFaceCustomActivity.this.findViewById(R.id.controlViewCa);
        }
    });

    @OOXIXo
    private final X0IIOO controlViewDis$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DialElementView>() { // from class: com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity$controlViewDis$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DialElementView invoke() {
            return (DialElementView) WatchFaceCustomActivity.this.findViewById(R.id.controlViewDis);
        }
    });

    @OOXIXo
    private final X0IIOO timeDigitalView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DialElementView>() { // from class: com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity$timeDigitalView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DialElementView invoke() {
            return (DialElementView) WatchFaceCustomActivity.this.findViewById(R.id.timeDigitalView);
        }
    });

    @OOXIXo
    private final X0IIOO timePointView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity$timePointView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) WatchFaceCustomActivity.this.findViewById(R.id.timePointView);
        }
    });

    @OOXIXo
    private final X0IIOO timeScaleView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity$timeScaleView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) WatchFaceCustomActivity.this.findViewById(R.id.timeScaleView);
        }
    });

    @OOXIXo
    private final X0IIOO tvBgTitle$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity$tvBgTitle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WatchFaceCustomActivity.this.findViewById(R.id.tv_bg_title);
        }
    });

    @OOXIXo
    private final X0IIOO addBg$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ViewGroup>() { // from class: com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity$addBg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ViewGroup invoke() {
            return (ViewGroup) WatchFaceCustomActivity.this.findViewById(R.id.add_bg);
        }
    });

    @OOXIXo
    private final X0IIOO rvBg$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity$rvBg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            return (RecyclerView) WatchFaceCustomActivity.this.findViewById(R.id.rv_bg);
        }
    });

    @OOXIXo
    private final X0IIOO table$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TabLayout>() { // from class: com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity$table$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TabLayout invoke() {
            return (TabLayout) WatchFaceCustomActivity.this.findViewById(R.id.table);
        }
    });

    @OOXIXo
    private final X0IIOO mViewPager$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<NoScollViewPager>() { // from class: com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity$mViewPager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final NoScollViewPager invoke() {
            return (NoScollViewPager) WatchFaceCustomActivity.this.findViewById(R.id.view_pager);
        }
    });

    /* loaded from: classes12.dex */
    public static final class I0Io implements com.sma.smartv3.ui.device.watchface.fragment.XO<Integer> {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ List<ResourcesIdInfo> f22777II0xO0;

        public I0Io(List<ResourcesIdInfo> list) {
            this.f22777II0xO0 = list;
        }

        public void II0xO0(int i, boolean z) {
            WatchFaceCustomActivity.this.getControlViewStep().setTextColor(this.f22777II0xO0.get(i).getSecondaryId());
            WatchFaceCustomActivity.this.getControlViewHr().setTextColor(this.f22777II0xO0.get(i).getSecondaryId());
            WatchFaceCustomActivity.this.getControlViewCa().setTextColor(this.f22777II0xO0.get(i).getSecondaryId());
            WatchFaceCustomActivity.this.getControlViewDis().setTextColor(this.f22777II0xO0.get(i).getSecondaryId());
            com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi = WatchFaceCustomActivity.this.mCustomWatchFace;
            if (oix0oi == null) {
                IIX0o.XOxIOxOx("mCustomWatchFace");
                oix0oi = null;
            }
            oix0oi.xX(i);
        }

        @Override // com.sma.smartv3.ui.device.watchface.fragment.XO
        public /* bridge */ /* synthetic */ void oIX0oI(Integer num, boolean z) {
            II0xO0(num.intValue(), z);
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements com.sma.smartv3.ui.device.watchface.fragment.XO<Integer> {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ List<ResourcesIdInfo> f22779II0xO0;

        public II0xO0(List<ResourcesIdInfo> list) {
            this.f22779II0xO0 = list;
        }

        public void II0xO0(int i, boolean z) {
            int i2;
            DialElementView timeDigitalView = WatchFaceCustomActivity.this.getTimeDigitalView();
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            timeDigitalView.setVisibility(i2);
            WatchFaceCustomActivity.this.getTimePointView().setVisibility(8);
            WatchFaceCustomActivity.this.getTimeScaleView().setVisibility(8);
            WatchFaceCustomActivity.this.getTimeDigitalView().setImageRes(this.f22779II0xO0.get(i).getResId());
            com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi = WatchFaceCustomActivity.this.mCustomWatchFace;
            if (oix0oi == null) {
                IIX0o.XOxIOxOx("mCustomWatchFace");
                oix0oi = null;
            }
            oix0oi.IO0XoXxO(i);
        }

        @Override // com.sma.smartv3.ui.device.watchface.fragment.XO
        public /* bridge */ /* synthetic */ void oIX0oI(Integer num, boolean z) {
            II0xO0(num.intValue(), z);
        }
    }

    /* loaded from: classes12.dex */
    public static final class X0o0xo extends com.sma.smartv3.ui.device.watchface.oIX0oI {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public X0o0xo(Application application) {
            super(application);
            IIX0o.ooOOo0oXI(application);
        }

        @Override // com.sma.smartv3.ui.device.watchface.oIX0oI
        public void oXIO0o0XI() {
            View findViewById = WatchFaceCustomActivity.this.findViewById(R.id.root_view);
            IIX0o.oO(findViewById, "findViewById(...)");
            oXIoO(findViewById);
            View findViewById2 = XoX().findViewById(R.id.customizeDialBg);
            IIX0o.oO(findViewById2, "findViewById(...)");
            XXoOx0((ImageView) findViewById2);
            View findViewById3 = XoX().findViewById(R.id.controlViewStep);
            IIX0o.oO(findViewById3, "findViewById(...)");
            x0OIX00oO((ViewGroup) findViewById3);
            View findViewById4 = XoX().findViewById(R.id.controlViewHr);
            IIX0o.oO(findViewById4, "findViewById(...)");
            OIOoIIOIx((ViewGroup) findViewById4);
            View findViewById5 = XoX().findViewById(R.id.controlViewCa);
            IIX0o.oO(findViewById5, "findViewById(...)");
            XIXIxO((ViewGroup) findViewById5);
            View findViewById6 = XoX().findViewById(R.id.controlViewDis);
            IIX0o.oO(findViewById6, "findViewById(...)");
            OoO((ViewGroup) findViewById6);
            View findViewById7 = XoX().findViewById(R.id.timeDigitalView);
            IIX0o.oO(findViewById7, "findViewById(...)");
            IxX00((ViewGroup) findViewById7);
            View findViewById8 = XoX().findViewById(R.id.timePointView);
            IIX0o.oO(findViewById8, "findViewById(...)");
            XO0o((ImageView) findViewById8);
            View findViewById9 = XoX().findViewById(R.id.timeScaleView);
            IIX0o.oO(findViewById9, "findViewById(...)");
            oX0I0O((ImageView) findViewById9);
        }
    }

    @XX({"SMAP\nWatchFaceCustomActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WatchFaceCustomActivity.kt\ncom/sma/smartv3/ui/device/watchface/WatchFaceCustomActivity$mBleHandleCallback$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,642:1\n1855#2,2:643\n*S KotlinDebug\n*F\n+ 1 WatchFaceCustomActivity.kt\ncom/sma/smartv3/ui/device/watchface/WatchFaceCustomActivity$mBleHandleCallback$1\n*L\n226#1:643,2\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class XO implements BleHandleCallback {
        public XO() {
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAICoachGeneratePlanUpdate(int i) {
            BleHandleCallback.DefaultImpls.onAICoachGeneratePlanUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAlarmAdd(@OOXIXo BleAlarm bleAlarm) {
            BleHandleCallback.DefaultImpls.onAlarmAdd(this, bleAlarm);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAlarmDelete(int i) {
            BleHandleCallback.DefaultImpls.onAlarmDelete(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAlarmUpdate(@OOXIXo BleAlarm bleAlarm) {
            BleHandleCallback.DefaultImpls.onAlarmUpdate(this, bleAlarm);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAppOpUpdate(@OOXIXo BleAppOp bleAppOp) {
            BleHandleCallback.DefaultImpls.onAppOpUpdate(this, bleAppOp);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAppSportDataResponse(boolean z) {
            BleHandleCallback.DefaultImpls.onAppSportDataResponse(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onBWNaviInfoUpdate(@OOXIXo BleBWNaviInfo bleBWNaviInfo) {
            BleHandleCallback.DefaultImpls.onBWNaviInfoUpdate(this, bleBWNaviInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onBacklightUpdate(int i) {
            BleHandleCallback.DefaultImpls.onBacklightUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onBleThirdPartyDataUpdate(@OOXIXo BleThirdPartyData bleThirdPartyData) {
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
        public void onCheckInEveryDayUpdate(@OOXIXo BleCheckInEveryDay bleCheckInEveryDay) {
            BleHandleCallback.DefaultImpls.onCheckInEveryDayUpdate(this, bleCheckInEveryDay);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onClassicBluetoothStateChange(int i) {
            BleHandleCallback.DefaultImpls.onClassicBluetoothStateChange(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onCommandReply(@OOXIXo BleKey bleKey, @OOXIXo BleKeyFlag bleKeyFlag, boolean z) {
            BleHandleCallback.DefaultImpls.onCommandReply(this, bleKey, bleKeyFlag, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onCommandSendTimeout(@OOXIXo BleKey bleKey, @OOXIXo BleKeyFlag bleKeyFlag) {
            IIX0o.x0xO0oo(bleKey, "bleKey");
            IIX0o.x0xO0oo(bleKeyFlag, "bleKeyFlag");
            if (bleKey == BleKey.WATCH_FACE) {
                WatchFaceCustomActivity.syncFailed$default(WatchFaceCustomActivity.this, 0, 1, null);
            }
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceConnected(@OOXIXo BluetoothDevice bluetoothDevice) {
            BleHandleCallback.DefaultImpls.onDeviceConnected(this, bluetoothDevice);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceConnecting(boolean z) {
            BleHandleCallback.DefaultImpls.onDeviceConnecting(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceFileUpdate(@OOXIXo BleDeviceFile bleDeviceFile) {
            BleHandleCallback.DefaultImpls.onDeviceFileUpdate(this, bleDeviceFile);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceRequestAGpsFile(@OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onDeviceRequestAGpsFile(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceSMSQuickReply(@OOXIXo BleSMSQuickReply bleSMSQuickReply) {
            BleHandleCallback.DefaultImpls.onDeviceSMSQuickReply(this, bleSMSQuickReply);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceSportDataUpdate(@OOXIXo BleDeviceSportData bleDeviceSportData) {
            BleHandleCallback.DefaultImpls.onDeviceSportDataUpdate(this, bleDeviceSportData);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDistanceGoalUpdate(int i) {
            BleHandleCallback.DefaultImpls.onDistanceGoalUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDoubleScreenSettingsUpdate(@OOXIXo BleDoubleScreenSettings bleDoubleScreenSettings) {
            BleHandleCallback.DefaultImpls.onDoubleScreenSettingsUpdate(this, bleDoubleScreenSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onEarphoneAncSettingsUpdate(@OOXIXo BleEarphoneAncSettings bleEarphoneAncSettings) {
            BleHandleCallback.DefaultImpls.onEarphoneAncSettingsUpdate(this, bleEarphoneAncSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onEarphoneCallUpdate(int i) {
            BleHandleCallback.DefaultImpls.onEarphoneCallUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onEarphoneKeyUpdate(@OOXIXo BleEarphoneKey bleEarphoneKey) {
            BleHandleCallback.DefaultImpls.onEarphoneKeyUpdate(this, bleEarphoneKey);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onEarphoneSoundEffectsSettingsUpdate(@OOXIXo BleEarphoneSoundEffectsSettings bleEarphoneSoundEffectsSettings) {
            BleHandleCallback.DefaultImpls.onEarphoneSoundEffectsSettingsUpdate(this, bleEarphoneSoundEffectsSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onEarphoneStateUpdate(@OOXIXo BleEarphoneState bleEarphoneState) {
            BleHandleCallback.DefaultImpls.onEarphoneStateUpdate(this, bleEarphoneState);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onFactoryTestUpdate(@OOXIXo BleFactoryTest bleFactoryTest) {
            BleHandleCallback.DefaultImpls.onFactoryTestUpdate(this, bleFactoryTest);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onFallSetUpdate(int i) {
            BleHandleCallback.DefaultImpls.onFallSetUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onFindEarphoneUpdate(@OOXIXo BleFindEarphone bleFindEarphone) {
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
        public void onGameControlUpdate(@OOXIXo BleGameControl bleGameControl) {
            BleHandleCallback.DefaultImpls.onGameControlUpdate(this, bleGameControl);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onGestureWake2Update(@OOXIXo BleGestureWake2 bleGestureWake2) {
            BleHandleCallback.DefaultImpls.onGestureWake2Update(this, bleGestureWake2);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onGestureWakeUpdate(@OOXIXo BleGestureWake bleGestureWake) {
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
        public void onIPCStoresInfoUpdate(@OOXIXo BleIPCStoresInfo bleIPCStoresInfo) {
            BleHandleCallback.DefaultImpls.onIPCStoresInfoUpdate(this, bleIPCStoresInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onIPCWifiInfoUpdate(@OOXIXo BleIPCWifiInfo bleIPCWifiInfo) {
            BleHandleCallback.DefaultImpls.onIPCWifiInfoUpdate(this, bleIPCWifiInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onIPCWifiStateUpdate(int i) {
            BleHandleCallback.DefaultImpls.onIPCWifiStateUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onIdentityCreate(boolean z, @oOoXoXO BleDeviceInfo bleDeviceInfo) {
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
        public void onLoveTapUpdate(@OOXIXo BleLoveTap bleLoveTap) {
            BleHandleCallback.DefaultImpls.onLoveTapUpdate(this, bleLoveTap);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onLoveTapUserDelete(int i) {
            BleHandleCallback.DefaultImpls.onLoveTapUserDelete(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onLoveTapUserUpdate(@OOXIXo BleLoveTapUser bleLoveTapUser) {
            BleHandleCallback.DefaultImpls.onLoveTapUserUpdate(this, bleLoveTapUser);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMeasurementUpdate(@OOXIXo BleMeasurement bleMeasurement) {
            BleHandleCallback.DefaultImpls.onMeasurementUpdate(this, bleMeasurement);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMedicationAlarmAdd(@OOXIXo BleMedicationAlarm bleMedicationAlarm) {
            BleHandleCallback.DefaultImpls.onMedicationAlarmAdd(this, bleMedicationAlarm);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMedicationAlarmDelete(int i) {
            BleHandleCallback.DefaultImpls.onMedicationAlarmDelete(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMedicationAlarmUpdate(@OOXIXo BleMedicationAlarm bleMedicationAlarm) {
            BleHandleCallback.DefaultImpls.onMedicationAlarmUpdate(this, bleMedicationAlarm);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMedicationReminderDelete(int i) {
            BleHandleCallback.DefaultImpls.onMedicationReminderDelete(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMedicationReminderUpdate(@OOXIXo BleMedicationReminder bleMedicationReminder) {
            BleHandleCallback.DefaultImpls.onMedicationReminderUpdate(this, bleMedicationReminder);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onNaviInfoUpdate(@OOXIXo BleNaviInfo bleNaviInfo) {
            BleHandleCallback.DefaultImpls.onNaviInfoUpdate(this, bleNaviInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onNoDisturbUpdate(@OOXIXo BleNoDisturbSettings bleNoDisturbSettings) {
            BleHandleCallback.DefaultImpls.onNoDisturbUpdate(this, bleNoDisturbSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onNotificationLightScreenSetUpdate(int i) {
            BleHandleCallback.DefaultImpls.onNotificationLightScreenSetUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onNotificationSettings2Update(@OOXIXo BleNotificationSettings2 bleNotificationSettings2) {
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
        public void onReadAICoachGenerateBeforeInfo(@OOXIXo BleAICoachBeforePlan bleAICoachBeforePlan) {
            BleHandleCallback.DefaultImpls.onReadAICoachGenerateBeforeInfo(this, bleAICoachBeforePlan);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAICoachPlan(@OOXIXo BleAICoachGeneratePlan bleAICoachGeneratePlan) {
            BleHandleCallback.DefaultImpls.onReadAICoachPlan(this, bleAICoachGeneratePlan);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadActivity(@OOXIXo List<BleActivity> list) {
            BleHandleCallback.DefaultImpls.onReadActivity(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadActivityDetail(@OOXIXo BleActivityDetail bleActivityDetail) {
            BleHandleCallback.DefaultImpls.onReadActivityDetail(this, bleActivityDetail);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAlarm(@OOXIXo List<BleAlarm> list) {
            BleHandleCallback.DefaultImpls.onReadAlarm(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAlipayBindInfo(@OOXIXo List<BleAlipayBindInfo> list) {
            BleHandleCallback.DefaultImpls.onReadAlipayBindInfo(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAlipaySettings(@OOXIXo BleAlipaySettings bleAlipaySettings) {
            BleHandleCallback.DefaultImpls.onReadAlipaySettings(this, bleAlipaySettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAppApiVersion(@OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadAppApiVersion(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAppInfoList(@OOXIXo BleAppInfoList bleAppInfoList) {
            BleHandleCallback.DefaultImpls.onReadAppInfoList(this, bleAppInfoList);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAvgHeartRate(@OOXIXo List<BleAvgHeartRate> list) {
            BleHandleCallback.DefaultImpls.onReadAvgHeartRate(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBAC(@OOXIXo List<BleBAC> list) {
            BleHandleCallback.DefaultImpls.onReadBAC(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBacCalibration(@OOXIXo BleBacCalibration bleBacCalibration, @OOXIXo BleKeyFlag bleKeyFlag) {
            BleHandleCallback.DefaultImpls.onReadBacCalibration(this, bleBacCalibration, bleKeyFlag);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBacklight(int i) {
            BleHandleCallback.DefaultImpls.onReadBacklight(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBatteryUsage(@OOXIXo BleBatteryUsage bleBatteryUsage) {
            BleHandleCallback.DefaultImpls.onReadBatteryUsage(this, bleBatteryUsage);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBleAddress(@OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadBleAddress(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBleHrv(@OOXIXo List<BleHrv> list) {
            BleHandleCallback.DefaultImpls.onReadBleHrv(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBleHrv2(@OOXIXo List<BleHrv2> list) {
            BleHandleCallback.DefaultImpls.onReadBleHrv2(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBleLogText(@OOXIXo List<BleLogText> list) {
            BleHandleCallback.DefaultImpls.onReadBleLogText(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBloodGlucose(@OOXIXo List<BleBloodGlucose> list) {
            BleHandleCallback.DefaultImpls.onReadBloodGlucose(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBloodOxyGenSettings(@OOXIXo BleBloodOxyGenSettings bleBloodOxyGenSettings) {
            BleHandleCallback.DefaultImpls.onReadBloodOxyGenSettings(this, bleBloodOxyGenSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBloodOxygen(@OOXIXo List<BleBloodOxygen> list) {
            BleHandleCallback.DefaultImpls.onReadBloodOxygen(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBloodPressure(@OOXIXo List<BleBloodPressure> list) {
            BleHandleCallback.DefaultImpls.onReadBloodPressure(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBloodPressureCalibration(@OOXIXo BleBloodPressureCalibration bleBloodPressureCalibration) {
            BleHandleCallback.DefaultImpls.onReadBloodPressureCalibration(this, bleBloodPressureCalibration);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBodyStatus(@OOXIXo List<BleBodyStatus> list) {
            BleHandleCallback.DefaultImpls.onReadBodyStatus(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCPUserInfo(@OOXIXo BleCPUserInfo bleCPUserInfo) {
            BleHandleCallback.DefaultImpls.onReadCPUserInfo(this, bleCPUserInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCalibrationData(@OOXIXo BleCalibrationData bleCalibrationData) {
            BleHandleCallback.DefaultImpls.onReadCalibrationData(this, bleCalibrationData);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCalorieIntake(@OOXIXo List<BleCalorieIntake> list) {
            BleHandleCallback.DefaultImpls.onReadCalorieIntake(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCaloriesGoal(int i) {
            BleHandleCallback.DefaultImpls.onReadCaloriesGoal(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCheckInEveryDay(@OOXIXo BleCheckInEveryDay bleCheckInEveryDay) {
            BleHandleCallback.DefaultImpls.onReadCheckInEveryDay(this, bleCheckInEveryDay);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadClassicBluetoothState(int i) {
            BleHandleCallback.DefaultImpls.onReadClassicBluetoothState(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCoachingIds(@OOXIXo BleCoachingIds bleCoachingIds) {
            BleHandleCallback.DefaultImpls.onReadCoachingIds(this, bleCoachingIds);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDailyPower(@OOXIXo List<BlePhysicalPower> list) {
            BleHandleCallback.DefaultImpls.onReadDailyPower(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDateFormat(int i) {
            BleHandleCallback.DefaultImpls.onReadDateFormat(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDeviceFile(@OOXIXo BleDeviceFile bleDeviceFile) {
            BleHandleCallback.DefaultImpls.onReadDeviceFile(this, bleDeviceFile);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDeviceInfo(@OOXIXo BleDeviceInfo bleDeviceInfo) {
            BleHandleCallback.DefaultImpls.onReadDeviceInfo(this, bleDeviceInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDeviceInfo2(@OOXIXo BleDeviceInfo2 bleDeviceInfo2) {
            BleHandleCallback.DefaultImpls.onReadDeviceInfo2(this, bleDeviceInfo2);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDeviceLanguages(@OOXIXo BleDeviceLanguages bleDeviceLanguages) {
            BleHandleCallback.DefaultImpls.onReadDeviceLanguages(this, bleDeviceLanguages);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDeviceUniqueDataSettings(@OOXIXo BleDeviceUniqueDataSettings bleDeviceUniqueDataSettings) {
            BleHandleCallback.DefaultImpls.onReadDeviceUniqueDataSettings(this, bleDeviceUniqueDataSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDistanceGoal(int i) {
            BleHandleCallback.DefaultImpls.onReadDistanceGoal(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDoubleScreenSettings(@OOXIXo BleDoubleScreenSettings bleDoubleScreenSettings) {
            BleHandleCallback.DefaultImpls.onReadDoubleScreenSettings(this, bleDoubleScreenSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDrinkWater(@OOXIXo BleDrinkWaterSettings bleDrinkWaterSettings) {
            BleHandleCallback.DefaultImpls.onReadDrinkWater(this, bleDrinkWaterSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneAncSettings(@OOXIXo BleEarphoneAncSettings bleEarphoneAncSettings) {
            BleHandleCallback.DefaultImpls.onReadEarphoneAncSettings(this, bleEarphoneAncSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneCall(int i) {
            BleHandleCallback.DefaultImpls.onReadEarphoneCall(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneInfo(@OOXIXo BleEarphoneInfo bleEarphoneInfo) {
            BleHandleCallback.DefaultImpls.onReadEarphoneInfo(this, bleEarphoneInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneKey(@OOXIXo BleEarphoneKey bleEarphoneKey) {
            BleHandleCallback.DefaultImpls.onReadEarphoneKey(this, bleEarphoneKey);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphonePower(@OOXIXo BleEarphonePower bleEarphonePower) {
            BleHandleCallback.DefaultImpls.onReadEarphonePower(this, bleEarphonePower);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneSoundEffectsSettings(@OOXIXo BleEarphoneSoundEffectsSettings bleEarphoneSoundEffectsSettings) {
            BleHandleCallback.DefaultImpls.onReadEarphoneSoundEffectsSettings(this, bleEarphoneSoundEffectsSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneState(@OOXIXo BleEarphoneState bleEarphoneState) {
            BleHandleCallback.DefaultImpls.onReadEarphoneState(this, bleEarphoneState);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEcg(@OOXIXo List<BleEcg> list) {
            BleHandleCallback.DefaultImpls.onReadEcg(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEcgSettings(@OOXIXo BleEcgSettings bleEcgSettings) {
            BleHandleCallback.DefaultImpls.onReadEcgSettings(this, bleEcgSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadFallSet(int i) {
            BleHandleCallback.DefaultImpls.onReadFallSet(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadFilePath(@OOXIXo BleAppAudioBookList bleAppAudioBookList) {
            BleHandleCallback.DefaultImpls.onReadFilePath(this, bleAppAudioBookList);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadFirmwareVersion(@OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadFirmwareVersion(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadFoodBalance(@OOXIXo List<BleFoodBalance> list) {
            BleHandleCallback.DefaultImpls.onReadFoodBalance(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGestureWake(@OOXIXo BleGestureWake bleGestureWake) {
            BleHandleCallback.DefaultImpls.onReadGestureWake(this, bleGestureWake);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGestureWake2(@OOXIXo BleGestureWake2 bleGestureWake2) {
            BleHandleCallback.DefaultImpls.onReadGestureWake2(this, bleGestureWake2);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGirlCareMonthly(@OOXIXo BleGirlCareMonthly bleGirlCareMonthly) {
            BleHandleCallback.DefaultImpls.onReadGirlCareMonthly(this, bleGirlCareMonthly);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGirlCareSettings(@OOXIXo BleGirlCareSettings bleGirlCareSettings) {
            BleHandleCallback.DefaultImpls.onReadGirlCareSettings(this, bleGirlCareSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGoMoreSettings(@OOXIXo BleGoMoreSettings bleGoMoreSettings) {
            BleHandleCallback.DefaultImpls.onReadGoMoreSettings(this, bleGoMoreSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGpsFirmwareVersion(@OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadGpsFirmwareVersion(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadHanBaoSettings(@OOXIXo BleHanBaoSettings bleHanBaoSettings) {
            BleHandleCallback.DefaultImpls.onReadHanBaoSettings(this, bleHanBaoSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadHanBaoVibration(@OOXIXo List<BleHanBaoVibration> list) {
            BleHandleCallback.DefaultImpls.onReadHanBaoVibration(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadHeartRate(@OOXIXo List<BleHeartRate> list) {
            BleHandleCallback.DefaultImpls.onReadHeartRate(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadHourSystem(int i) {
            BleHandleCallback.DefaultImpls.onReadHourSystem(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadHrMonitoringSettings(@OOXIXo BleHrMonitoringSettings bleHrMonitoringSettings) {
            BleHandleCallback.DefaultImpls.onReadHrMonitoringSettings(this, bleHrMonitoringSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadIPCStoresInfo(@OOXIXo BleIPCStoresInfo bleIPCStoresInfo) {
            BleHandleCallback.DefaultImpls.onReadIPCStoresInfo(this, bleIPCStoresInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadIPCVersion(@OOXIXo String str) {
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
        public void onReadLactateThreshold(@OOXIXo List<BleLactateThreshold> list) {
            BleHandleCallback.DefaultImpls.onReadLactateThreshold(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadLanguage(int i) {
            BleHandleCallback.DefaultImpls.onReadLanguage(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadLanguagePackVersion(@OOXIXo BleLanguagePackVersion bleLanguagePackVersion) {
            BleHandleCallback.DefaultImpls.onReadLanguagePackVersion(this, bleLanguagePackVersion);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadLocation(@OOXIXo List<BleLocation> list) {
            BleHandleCallback.DefaultImpls.onReadLocation(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadLoveTapUser(@OOXIXo List<BleLoveTapUser> list) {
            BleHandleCallback.DefaultImpls.onReadLoveTapUser(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMatchRecord(@OOXIXo List<BleMatchRecord> list) {
            BleHandleCallback.DefaultImpls.onReadMatchRecord(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMatchRecord2(@OOXIXo List<BleMatchRecord2> list) {
            BleHandleCallback.DefaultImpls.onReadMatchRecord2(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMedicationAlarm(@OOXIXo List<BleMedicationAlarm> list) {
            BleHandleCallback.DefaultImpls.onReadMedicationAlarm(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMedicationReminder(@OOXIXo List<BleMedicationReminder> list) {
            BleHandleCallback.DefaultImpls.onReadMedicationReminder(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMindStatus(@OOXIXo List<BleMindStatus> list) {
            BleHandleCallback.DefaultImpls.onReadMindStatus(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMtkOtaMeta() {
            BleHandleCallback.DefaultImpls.onReadMtkOtaMeta(this);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadNetworkFirmwareVersion(@OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadNetworkFirmwareVersion(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadNoDisturb(@OOXIXo BleNoDisturbSettings bleNoDisturbSettings) {
            BleHandleCallback.DefaultImpls.onReadNoDisturb(this, bleNoDisturbSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadNotificationLightScreenSet(int i) {
            BleHandleCallback.DefaultImpls.onReadNotificationLightScreenSet(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadNotificationSettings2(@OOXIXo BleNotificationSettings2 bleNotificationSettings2) {
            BleHandleCallback.DefaultImpls.onReadNotificationSettings2(this, bleNotificationSettings2);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadPackageStatus(@OOXIXo BlePackageStatus blePackageStatus) {
            BleHandleCallback.DefaultImpls.onReadPackageStatus(this, blePackageStatus);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadPower(int i) {
            BleHandleCallback.DefaultImpls.onReadPower(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadPower2(@OOXIXo BlePower2 blePower2) {
            BleHandleCallback.DefaultImpls.onReadPower2(this, blePower2);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadPressure(@OOXIXo List<BlePressure> list) {
            BleHandleCallback.DefaultImpls.onReadPressure(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadPressureTimingMeasurement(@OOXIXo BlePressureTimingMeasurement blePressureTimingMeasurement) {
            BleHandleCallback.DefaultImpls.onReadPressureTimingMeasurement(this, blePressureTimingMeasurement);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadQiblaSettings(@OOXIXo BleQiblaSettings bleQiblaSettings) {
            BleHandleCallback.DefaultImpls.onReadQiblaSettings(this, bleQiblaSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadRelaxReminder(@OOXIXo BleRelaxReminder bleRelaxReminder) {
            BleHandleCallback.DefaultImpls.onReadRelaxReminder(this, bleRelaxReminder);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadRespiratoryRate(@OOXIXo List<BleRespiratoryRate> list) {
            BleHandleCallback.DefaultImpls.onReadRespiratoryRate(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadRingVibrationSet(@OOXIXo BleRingVibrationSettings bleRingVibrationSettings) {
            BleHandleCallback.DefaultImpls.onReadRingVibrationSet(this, bleRingVibrationSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadRri(@OOXIXo List<BleRri> list) {
            BleHandleCallback.DefaultImpls.onReadRri(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSDCardInfo(@OOXIXo BleSDCardInfo bleSDCardInfo) {
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
        public void onReadSOSSettings(@OOXIXo BleSOSSettings bleSOSSettings) {
            BleHandleCallback.DefaultImpls.onReadSOSSettings(this, bleSOSSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadScreenBrightnessSet(int i) {
            BleHandleCallback.DefaultImpls.onReadScreenBrightnessSet(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSedentariness(@OOXIXo BleSedentarinessSettings bleSedentarinessSettings) {
            BleHandleCallback.DefaultImpls.onReadSedentariness(this, bleSedentarinessSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSleep(@OOXIXo List<BleSleep> list) {
            BleHandleCallback.DefaultImpls.onReadSleep(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSleepGoal(int i) {
            BleHandleCallback.DefaultImpls.onReadSleepGoal(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSleepQuality(@OOXIXo BleSleepQuality bleSleepQuality) {
            BleHandleCallback.DefaultImpls.onReadSleepQuality(this, bleSleepQuality);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSleepQualityScore(int i) {
            BleHandleCallback.DefaultImpls.onReadSleepQualityScore(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSleepRaw(@OOXIXo byte[] bArr) {
            BleHandleCallback.DefaultImpls.onReadSleepRaw(this, bArr);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSosCallLog(@OOXIXo List<BleSosCallLog> list) {
            BleHandleCallback.DefaultImpls.onReadSosCallLog(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSosContact(@OOXIXo BleSosContact bleSosContact) {
            BleHandleCallback.DefaultImpls.onReadSosContact(this, bleSosContact);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSportDurationGoal(int i) {
            BleHandleCallback.DefaultImpls.onReadSportDurationGoal(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadStandbyWatchFaceSet(@OOXIXo BleStandbyWatchFaceSet bleStandbyWatchFaceSet) {
            BleHandleCallback.DefaultImpls.onReadStandbyWatchFaceSet(this, bleStandbyWatchFaceSet);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadStepGoal(int i) {
            BleHandleCallback.DefaultImpls.onReadStepGoal(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadStock(@OOXIXo List<BleStock> list) {
            BleHandleCallback.DefaultImpls.onReadStock(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadTemperature(@OOXIXo List<BleTemperature> list) {
            BleHandleCallback.DefaultImpls.onReadTemperature(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadTemperatureUnit(int i) {
            BleHandleCallback.DefaultImpls.onReadTemperatureUnit(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadTrainingStatus(@OOXIXo List<BleTrainingStatus> list) {
            BleHandleCallback.DefaultImpls.onReadTrainingStatus(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadTuyaKey(@OOXIXo BleTuyaKey bleTuyaKey) {
            BleHandleCallback.DefaultImpls.onReadTuyaKey(this, bleTuyaKey);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadUiPackVersion(@OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadUiPackVersion(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadUnit(int i) {
            BleHandleCallback.DefaultImpls.onReadUnit(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadUserProfile(@OOXIXo BleUserProfile bleUserProfile) {
            BleHandleCallback.DefaultImpls.onReadUserProfile(this, bleUserProfile);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadVitalityValue(@OOXIXo List<BleVitality> list) {
            BleHandleCallback.DefaultImpls.onReadVitalityValue(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWatchFaceId(@OOXIXo BleWatchFaceId watchFaceId) {
            IIX0o.x0xO0oo(watchFaceId, "watchFaceId");
            WatchFaceCustomActivity.this.mDialIds.clear();
            List<Integer> mIdList = watchFaceId.getMIdList();
            WatchFaceCustomActivity watchFaceCustomActivity = WatchFaceCustomActivity.this;
            Iterator<T> it = mIdList.iterator();
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                if (intValue <= 0) {
                    watchFaceCustomActivity.mDialIds.add(0);
                } else {
                    watchFaceCustomActivity.mDialIds.add(Integer.valueOf(intValue));
                }
            }
            LogUtils.d("mDialIds -> " + WatchFaceCustomActivity.this.mDialIds);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWatchFaceIndex(@OOXIXo BleWatchFaceIndex bleWatchFaceIndex) {
            BleHandleCallback.DefaultImpls.onReadWatchFaceIndex(this, bleWatchFaceIndex);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWatchFaceSwitch(int i) {
            BleHandleCallback.DefaultImpls.onReadWatchFaceSwitch(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWatchPassword(@OOXIXo BleSettingWatchPassword bleSettingWatchPassword) {
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
        public void onReadWorkout(@OOXIXo List<BleWorkout> list) {
            BleHandleCallback.DefaultImpls.onReadWorkout(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWorkout2(@OOXIXo List<BleWorkout2> list) {
            BleHandleCallback.DefaultImpls.onReadWorkout2(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWorkout3(@OOXIXo List<BleWorkout3> list) {
            BleHandleCallback.DefaultImpls.onReadWorkout3(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWorldClock(@OOXIXo List<BleWorldClock> list) {
            BleHandleCallback.DefaultImpls.onReadWorldClock(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onRealTimeMeasurement(@OOXIXo BleRealTimeMeasurement bleRealTimeMeasurement) {
            BleHandleCallback.DefaultImpls.onRealTimeMeasurement(this, bleRealTimeMeasurement);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveFilePacket(@OOXIXo BleReceiveFilePacket bleReceiveFilePacket) {
            BleHandleCallback.DefaultImpls.onReceiveFilePacket(this, bleReceiveFilePacket);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveGSensorMotion(@OOXIXo List<BleGSensorMotion> list) {
            BleHandleCallback.DefaultImpls.onReceiveGSensorMotion(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveGSensorRaw(@OOXIXo List<BleGSensorRaw> list) {
            BleHandleCallback.DefaultImpls.onReceiveGSensorRaw(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveGSensorSHSY(@OOXIXo List<BleGSensorSHSY> list) {
            BleHandleCallback.DefaultImpls.onReceiveGSensorSHSY(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveHRRaw(@OOXIXo List<BleHRRaw> list) {
            BleHandleCallback.DefaultImpls.onReceiveHRRaw(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveLocationGga(@OOXIXo BleLocationGga bleLocationGga) {
            BleHandleCallback.DefaultImpls.onReceiveLocationGga(this, bleLocationGga);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveLocationGsv(@OOXIXo List<BleLocationGsv> list) {
            BleHandleCallback.DefaultImpls.onReceiveLocationGsv(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveMusicCommand(@OOXIXo MusicCommand musicCommand) {
            BleHandleCallback.DefaultImpls.onReceiveMusicCommand(this, musicCommand);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceivePpgSHSY(@OOXIXo List<BlePpgSHSY> list) {
            BleHandleCallback.DefaultImpls.onReceivePpgSHSY(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveRealtimeLog(@OOXIXo BleRealtimeLog bleRealtimeLog) {
            BleHandleCallback.DefaultImpls.onReceiveRealtimeLog(this, bleRealtimeLog);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveRecordPacket(@OOXIXo BleRecordPacket bleRecordPacket) {
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
        public void onRingVibrationSetUpdate(@OOXIXo BleRingVibrationSettings bleRingVibrationSettings) {
            BleHandleCallback.DefaultImpls.onRingVibrationSetUpdate(this, bleRingVibrationSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSDCardInfoUpdate(@OOXIXo BleSDCardInfo bleSDCardInfo) {
            BleHandleCallback.DefaultImpls.onSDCardInfoUpdate(this, bleSDCardInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSGTestUpdate(@OOXIXo BleSGTest bleSGTest) {
            BleHandleCallback.DefaultImpls.onSGTestUpdate(this, bleSGTest);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSOSSettingsUpdate(@OOXIXo BleSOSSettings bleSOSSettings) {
            BleHandleCallback.DefaultImpls.onSOSSettingsUpdate(this, bleSOSSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onScreenBrightnessSetUpdate(int i) {
            BleHandleCallback.DefaultImpls.onScreenBrightnessSetUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSessionStateChange(boolean z) {
            if (!z && WatchFaceCustomActivity.this.mProgressPop != null) {
                WatchFaceCustomActivity.syncFailed$default(WatchFaceCustomActivity.this, 0, 1, null);
            }
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSosContactUpdate(@OOXIXo BleSosContact bleSosContact) {
            BleHandleCallback.DefaultImpls.onSosContactUpdate(this, bleSosContact);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSportEndNotifyUpdate(int i) {
            BleHandleCallback.DefaultImpls.onSportEndNotifyUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onStandbyWatchFaceSetUpdate(@OOXIXo BleStandbyWatchFaceSet bleStandbyWatchFaceSet) {
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
        public void onStreamProgress(boolean z, int i, int i2, int i3, @OOXIXo BleKey bleKey) {
            IIX0o.x0xO0oo(bleKey, "bleKey");
            if (z) {
                xOOOX xooox = WatchFaceCustomActivity.this.mProgressPop;
                if (xooox != null) {
                    xooox.XIxXXX0x0((int) ((i3 / i2) * 100));
                }
                if (i2 == i3) {
                    xOOOX xooox2 = WatchFaceCustomActivity.this.mProgressPop;
                    if (xooox2 != null) {
                        xooox2.dismiss();
                    }
                    WatchFaceCustomActivity.this.mProgressPop = null;
                    ToastUtils.showLong(R.string.dial_sync_done);
                    WatchFaceCustomActivity.this.mDialIds.set(WatchFaceCustomActivity.this.mCurSyncDevicePosition, Integer.valueOf(WatchFaceCustomActivity.this.mCurSyncDialId));
                    Xo0.f24349oIX0oI.II0xO0().put("syncId", 0);
                    WatchFaceCustomActivity.this.saveRecord();
                    return;
                }
                return;
            }
            WatchFaceCustomActivity.this.syncFailed(i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSyncData(int i, @OOXIXo BleKey bleKey) {
            BleHandleCallback.DefaultImpls.onSyncData(this, i, bleKey);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onTimeUpdate() {
            BleHandleCallback.DefaultImpls.onTimeUpdate(this);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateAppSportState(@OOXIXo BleAppSportState bleAppSportState) {
            BleHandleCallback.DefaultImpls.onUpdateAppSportState(this, bleAppSportState);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateBAC(@OOXIXo BleBAC bleBAC) {
            BleHandleCallback.DefaultImpls.onUpdateBAC(this, bleBAC);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateBloodPressure(@OOXIXo BleBloodPressure bleBloodPressure) {
            BleHandleCallback.DefaultImpls.onUpdateBloodPressure(this, bleBloodPressure);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateHeartRate(@OOXIXo BleHeartRate bleHeartRate) {
            BleHandleCallback.DefaultImpls.onUpdateHeartRate(this, bleHeartRate);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateTemperature(@OOXIXo BleTemperature bleTemperature) {
            BleHandleCallback.DefaultImpls.onUpdateTemperature(this, bleTemperature);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateWatchFaceSwitch(boolean z) {
            BleHandleCallback.DefaultImpls.onUpdateWatchFaceSwitch(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUserProfileUpdate(@OOXIXo BleUserProfile bleUserProfile) {
            BleHandleCallback.DefaultImpls.onUserProfileUpdate(this, bleUserProfile);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onVibrationUpdate(int i) {
            BleHandleCallback.DefaultImpls.onVibrationUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onWatchFaceIdUpdate(boolean z) {
            WatchFaceCustomActivity.this.syncWatchFace();
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onWatchFaceIndexCreate(boolean z) {
            BleHandleCallback.DefaultImpls.onWatchFaceIndexCreate(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onWatchFaceIndexUpdate(@OOXIXo BleWatchFaceIndex bleWatchFaceIndex) {
            BleHandleCallback.DefaultImpls.onWatchFaceIndexUpdate(this, bleWatchFaceIndex);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onWatchPasswordUpdate(@OOXIXo BleSettingWatchPassword bleSettingWatchPassword) {
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
    public static final class oIX0oI implements II0XooXoX<Integer> {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ List<ResourcesIdInfo> f22786I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ List<ResourcesIdInfo> f22787II0xO0;

        public oIX0oI(List<ResourcesIdInfo> list, List<ResourcesIdInfo> list2) {
            this.f22787II0xO0 = list;
            this.f22786I0Io = list2;
        }

        public void I0Io(int i, boolean z) {
            int i2 = 8;
            WatchFaceCustomActivity.this.getTimeDigitalView().setVisibility(8);
            WatchFaceCustomActivity.this.getTimePointView().setImageResource(this.f22787II0xO0.get(i).getResId());
            com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi = WatchFaceCustomActivity.this.mCustomWatchFace;
            TimeElementFragment timeElementFragment = null;
            if (oix0oi == null) {
                IIX0o.XOxIOxOx("mCustomWatchFace");
                oix0oi = null;
            }
            oix0oi.o0IXXIx(i);
            ImageView timePointView = WatchFaceCustomActivity.this.getTimePointView();
            if (z) {
                i2 = 0;
            }
            timePointView.setVisibility(i2);
            TimeElementFragment timeElementFragment2 = WatchFaceCustomActivity.this.timeElementFragment;
            if (timeElementFragment2 == null) {
                IIX0o.XOxIOxOx("timeElementFragment");
            } else {
                timeElementFragment = timeElementFragment2;
            }
            timeElementFragment.reset();
        }

        @Override // com.sma.smartv3.ui.device.watchface.fragment.II0XooXoX
        public /* bridge */ /* synthetic */ void II0xO0(Integer num, boolean z) {
            oxoX(num.intValue(), z);
        }

        @Override // com.sma.smartv3.ui.device.watchface.fragment.II0XooXoX
        public /* bridge */ /* synthetic */ void oIX0oI(Integer num, boolean z) {
            I0Io(num.intValue(), z);
        }

        public void oxoX(int i, boolean z) {
            int i2 = 8;
            WatchFaceCustomActivity.this.getTimeDigitalView().setVisibility(8);
            WatchFaceCustomActivity.this.getTimeScaleView().setImageResource(this.f22786I0Io.get(i).getResId());
            com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi = WatchFaceCustomActivity.this.mCustomWatchFace;
            TimeElementFragment timeElementFragment = null;
            if (oix0oi == null) {
                IIX0o.XOxIOxOx("mCustomWatchFace");
                oix0oi = null;
            }
            oix0oi.OooI(i);
            ImageView timeScaleView = WatchFaceCustomActivity.this.getTimeScaleView();
            if (z) {
                i2 = 0;
            }
            timeScaleView.setVisibility(i2);
            TimeElementFragment timeElementFragment2 = WatchFaceCustomActivity.this.timeElementFragment;
            if (timeElementFragment2 == null) {
                IIX0o.XOxIOxOx("timeElementFragment");
            } else {
                timeElementFragment = timeElementFragment2;
            }
            timeElementFragment.reset();
        }
    }

    /* loaded from: classes12.dex */
    public static final class oxoX implements com.bestmafen.androidbase.viewpager.oIX0oI {
        public oxoX() {
        }

        @Override // com.bestmafen.androidbase.viewpager.oIX0oI
        @OOXIXo
        public List<Fragment> initFragments() {
            PointerElementFragment pointerElementFragment = WatchFaceCustomActivity.this.pointerElementFragment;
            ControlElementFragment controlElementFragment = null;
            if (pointerElementFragment == null) {
                IIX0o.XOxIOxOx("pointerElementFragment");
                pointerElementFragment = null;
            }
            TimeElementFragment timeElementFragment = WatchFaceCustomActivity.this.timeElementFragment;
            if (timeElementFragment == null) {
                IIX0o.XOxIOxOx("timeElementFragment");
                timeElementFragment = null;
            }
            ControlElementFragment controlElementFragment2 = WatchFaceCustomActivity.this.controlElementFragment;
            if (controlElementFragment2 == null) {
                IIX0o.XOxIOxOx("controlElementFragment");
            } else {
                controlElementFragment = controlElementFragment2;
            }
            return CollectionsKt__CollectionsKt.X00IoxXI(pointerElementFragment, timeElementFragment, controlElementFragment);
        }

        @Override // com.bestmafen.androidbase.viewpager.oIX0oI
        @OOXIXo
        public FragmentManager provideFragmentManager() {
            FragmentManager supportFragmentManager = WatchFaceCustomActivity.this.getSupportFragmentManager();
            IIX0o.oO(supportFragmentManager, "getSupportFragmentManager(...)");
            return supportFragmentManager;
        }
    }

    public WatchFaceCustomActivity() {
        String str;
        if (ProductManager.f20544oIX0oI.XxIo()) {
            str = "/2d/";
        } else {
            str = "/default/";
        }
        this.is2DAcceleration = str;
        this.paramName = BleCache.INSTANCE.getMPrototype() + IOUtils.DIR_SEPARATOR_UNIX;
        this.mDialIds = CollectionsKt__CollectionsKt.XOxIOxOx(0);
        this.mBgFiles = new ArrayList();
        this.mCrop$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Xx000oIo.oxoX>() { // from class: com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity$mCrop$2

            /* loaded from: classes12.dex */
            public static final class oIX0oI implements oxoX.II0xO0 {

                /* renamed from: I0Io, reason: collision with root package name */
                public final /* synthetic */ WatchFaceCustomActivity f22783I0Io;

                /* renamed from: II0xO0, reason: collision with root package name */
                @OOXIXo
                public final Uri f22784II0xO0;

                /* renamed from: oIX0oI, reason: collision with root package name */
                @OOXIXo
                public final Uri f22785oIX0oI;

                public oIX0oI(WatchFaceCustomActivity watchFaceCustomActivity) {
                    this.f22783I0Io = watchFaceCustomActivity;
                    X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
                    this.f22785oIX0oI = oix0oi.oxoX(IXxxXO.XIxXXX0x0(oix0oi));
                    Uri fromFile = Uri.fromFile(IXxxXO.xoXoI(oix0oi));
                    IIX0o.oO(fromFile, "fromFile(...)");
                    this.f22784II0xO0 = fromFile;
                }

                @Override // Xx000oIo.oxoX.II0xO0
                public void II0xO0(@OOXIXo Uri uri) {
                    xx0X0 xx0x0;
                    Bitmap round;
                    List list;
                    IIX0o.x0xO0oo(uri, "uri");
                    LogUtils.d("onCropped => " + uri);
                    xx0x0 = this.f22783I0Io.mSelectAvatarPopup;
                    if (xx0x0 != null) {
                        xx0x0.dismiss();
                    }
                    X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
                    if (IXxxXO.xoXoI(oix0oi).exists()) {
                        File file = new File(IXxxXO.I0X0x0oIo(oix0oi), xoIox.x0o().format(new Date()) + ".png");
                        Bitmap bitmap = ImageUtils.getBitmap(IXxxXO.xoXoI(oix0oi));
                        WatchFaceCustomActivity watchFaceCustomActivity = this.f22783I0Io;
                        IIX0o.ooOOo0oXI(bitmap);
                        round = watchFaceCustomActivity.toRound(bitmap);
                        ImageUtils.save(round, file, Bitmap.CompressFormat.PNG);
                        list = this.f22783I0Io.mBgFiles;
                        String path = file.getPath();
                        IIX0o.oO(path, "getPath(...)");
                        list.add(path);
                        this.f22783I0Io.showRvBg();
                    }
                }

                @Override // Xx000oIo.oxoX.II0xO0
                @OOXIXo
                public Uri getResult() {
                    return this.f22784II0xO0;
                }

                @Override // Xx000oIo.oxoX.II0xO0
                @OOXIXo
                public Uri oIX0oI() {
                    return this.f22785oIX0oI;
                }
            }

            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OOXIXo
            public final Xx000oIo.oxoX invoke() {
                Activity mContext;
                mContext = WatchFaceCustomActivity.this.getMContext();
                return new Xx000oIo.oxoX(mContext, new oIX0oI(WatchFaceCustomActivity.this));
            }
        });
        this.mBleHandleCallback = new XO();
    }

    private final void adjustWatchfaceViewWidth() {
        float OX00O0xII2;
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi = this.mCustomWatchFace;
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi2 = null;
        if (oix0oi == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
            oix0oi = null;
        }
        float XIo0oOXIx2 = oix0oi.XIo0oOXIx();
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi3 = this.mCustomWatchFace;
        if (oix0oi3 == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
            oix0oi3 = null;
        }
        float IoOoo2 = this.WATCHFACEVIEW_HEIGHT * (XIo0oOXIx2 / oix0oi3.IoOoo());
        CardView watchfaceView = getWatchfaceView();
        IIX0o.oO(watchfaceView, "<get-watchfaceView>(...)");
        LibExKt.IIX0(watchfaceView, SizeUtils.dp2px(IoOoo2), SizeUtils.dp2px(this.WATCHFACEVIEW_HEIGHT));
        ImageViewRound customizeDialBg = getCustomizeDialBg();
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi4 = this.mCustomWatchFace;
        if (oix0oi4 == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
            oix0oi4 = null;
        }
        customizeDialBg.setRadius(SizeUtils.dp2px(oix0oi4.OX00O0xII()));
        ImageViewRound customizeDialBg2 = getCustomizeDialBg();
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi5 = this.mCustomWatchFace;
        if (oix0oi5 == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
            oix0oi5 = null;
        }
        customizeDialBg2.setType(!oix0oi5.oOo() ? 1 : 0);
        CardView watchfaceView2 = getWatchfaceView();
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi6 = this.mCustomWatchFace;
        if (oix0oi6 == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
            oix0oi6 = null;
        }
        if (oix0oi6.oOo()) {
            OX00O0xII2 = 200.0f;
        } else {
            com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi7 = this.mCustomWatchFace;
            if (oix0oi7 == null) {
                IIX0o.XOxIOxOx("mCustomWatchFace");
            } else {
                oix0oi2 = oix0oi7;
            }
            OX00O0xII2 = oix0oi2.OX00O0xII();
        }
        watchfaceView2.setRadius(SizeUtils.dp2px(OX00O0xII2));
    }

    private final void controlChangeStatus(View view, ImageView imageView) {
        if (view.getVisibility() == 0) {
            view.setVisibility(8);
            imageView.setImageResource(R.drawable.ic_watchface_element_add);
        } else {
            view.setVisibility(0);
            imageView.setImageResource(R.drawable.ic_watchface_element_del);
        }
    }

    private final PFMedium getAbhTitleCenter() {
        return (PFMedium) this.abhTitleCenter$delegate.getValue();
    }

    private final ViewGroup getAddBg() {
        return (ViewGroup) this.addBg$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialElementView getControlViewCa() {
        return (DialElementView) this.controlViewCa$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialElementView getControlViewDis() {
        return (DialElementView) this.controlViewDis$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialElementView getControlViewHr() {
        return (DialElementView) this.controlViewHr$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialElementView getControlViewStep() {
        return (DialElementView) this.controlViewStep$delegate.getValue();
    }

    private final ImageViewRound getCustomizeDialBg() {
        return (ImageViewRound) this.customizeDialBg$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Xx000oIo.oxoX getMCrop() {
        return (Xx000oIo.oxoX) this.mCrop$delegate.getValue();
    }

    private final NoScollViewPager getMViewPager() {
        return (NoScollViewPager) this.mViewPager$delegate.getValue();
    }

    private final RecyclerView getRvBg() {
        return (RecyclerView) this.rvBg$delegate.getValue();
    }

    private final TabLayout getTable() {
        return (TabLayout) this.table$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialElementView getTimeDigitalView() {
        return (DialElementView) this.timeDigitalView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView getTimePointView() {
        return (ImageView) this.timePointView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView getTimeScaleView() {
        return (ImageView) this.timeScaleView$delegate.getValue();
    }

    private final TextView getTvBgTitle() {
        return (TextView) this.tvBgTitle$delegate.getValue();
    }

    private final CardView getWatchfaceView() {
        return (CardView) this.watchfaceView$delegate.getValue();
    }

    private final void initBgView() {
        int i;
        RecyclerView rvBg = getRvBg();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        rvBg.setLayoutManager(linearLayoutManager);
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi = this.mCustomWatchFace;
        CommonAdapter<String> commonAdapter = null;
        if (oix0oi == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
            oix0oi = null;
        }
        if (oix0oi.oOo()) {
            i = R.layout.item_watchface_bg;
        } else {
            i = R.layout.item_watchface_bg_r;
        }
        this.rvBgAdapter = new WatchFaceCustomActivity$initBgView$2(this, i, this.mBgFiles);
        RecyclerView rvBg2 = getRvBg();
        CommonAdapter<String> commonAdapter2 = this.rvBgAdapter;
        if (commonAdapter2 == null) {
            IIX0o.XOxIOxOx("rvBgAdapter");
        } else {
            commonAdapter = commonAdapter2;
        }
        rvBg2.setAdapter(commonAdapter);
    }

    private final void initElementView() {
        BleCache bleCache = BleCache.INSTANCE;
        BleDeviceInfo mDeviceInfo = bleCache.getMDeviceInfo();
        IIX0o.ooOOo0oXI(mDeviceInfo);
        List<ResourcesIdInfo> watchFaceElementPointers = ResourcesIdInfoKt.getWatchFaceElementPointers(mDeviceInfo);
        BleDeviceInfo mDeviceInfo2 = bleCache.getMDeviceInfo();
        IIX0o.ooOOo0oXI(mDeviceInfo2);
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi = this.mCustomWatchFace;
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi2 = null;
        if (oix0oi == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
            oix0oi = null;
        }
        List<ResourcesIdInfo> watchFaceElementScales = ResourcesIdInfoKt.getWatchFaceElementScales(mDeviceInfo2, oix0oi.oOo());
        List<ResourcesIdInfo> watchFaceElementColors = ResourcesIdInfoKt.getWatchFaceElementColors(this);
        List<ResourcesIdInfo> watchFaceElementDigitalTimes = ResourcesIdInfoKt.getWatchFaceElementDigitalTimes();
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi3 = this.mCustomWatchFace;
        if (oix0oi3 == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
            oix0oi3 = null;
        }
        this.pointerElementFragment = new PointerElementFragment(watchFaceElementPointers, watchFaceElementScales, oix0oi3.oOo(), new oIX0oI(watchFaceElementPointers, watchFaceElementScales));
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi4 = this.mCustomWatchFace;
        if (oix0oi4 == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
            oix0oi4 = null;
        }
        final TimeElementFragment timeElementFragment = new TimeElementFragment(watchFaceElementColors, oix0oi4.oOo(), new II0xO0(watchFaceElementDigitalTimes));
        timeElementFragment.setOnViewClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.watchface.II0xO0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WatchFaceCustomActivity.initElementView$lambda$3$lambda$2(TimeElementFragment.this, this, view);
            }
        });
        this.timeElementFragment = timeElementFragment;
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi5 = this.mCustomWatchFace;
        if (oix0oi5 == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
        } else {
            oix0oi2 = oix0oi5;
        }
        final ControlElementFragment controlElementFragment = new ControlElementFragment(watchFaceElementColors, oix0oi2.oOo(), new I0Io(watchFaceElementColors));
        controlElementFragment.setOnViewClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.watchface.I0Io
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WatchFaceCustomActivity.initElementView$lambda$5$lambda$4(WatchFaceCustomActivity.this, controlElementFragment, view);
            }
        });
        this.controlElementFragment = controlElementFragment;
        BaseFragmentPagerAdapter baseFragmentPagerAdapter = new BaseFragmentPagerAdapter(new oxoX());
        String str = getString(R.string.pointer) + kotlin.text.XIxXXX0x0.f29558oxoX + getString(R.string.scale);
        String string = getString(R.string.time);
        IIX0o.oO(string, "getString(...)");
        String string2 = getString(R.string.control);
        IIX0o.oO(string2, "getString(...)");
        baseFragmentPagerAdapter.setTitles(new String[]{str, string, string2});
        getMViewPager().setAdapter(baseFragmentPagerAdapter);
        getMViewPager().setOffscreenPageLimit(baseFragmentPagerAdapter.getCount());
        this.mFragmentPagerAdapter = baseFragmentPagerAdapter;
        getTable().setupWithViewPager(getMViewPager());
        getMViewPager().setCanScoll(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initElementView$lambda$3$lambda$2(TimeElementFragment this_apply, WatchFaceCustomActivity this$0, View view) {
        int i;
        IIX0o.x0xO0oo(this_apply, "$this_apply");
        IIX0o.x0xO0oo(this$0, "this$0");
        if (view.getId() == R.id.dialSelect0) {
            ImageView dialSelectStatus0 = this_apply.getDialSelectStatus0();
            if (dialSelectStatus0.getVisibility() == 8) {
                i = 0;
            } else {
                i = 8;
            }
            dialSelectStatus0.setVisibility(i);
            this$0.getTimeDigitalView().setVisibility(this_apply.getDialSelectStatus0().getVisibility());
            this$0.getTimePointView().setVisibility(8);
            this$0.getTimeScaleView().setVisibility(8);
            PointerElementFragment pointerElementFragment = this$0.pointerElementFragment;
            if (pointerElementFragment == null) {
                IIX0o.XOxIOxOx("pointerElementFragment");
                pointerElementFragment = null;
            }
            pointerElementFragment.reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initElementView$lambda$5$lambda$4(WatchFaceCustomActivity this$0, ControlElementFragment this_apply, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(this_apply, "$this_apply");
        switch (view.getId()) {
            case R.id.dialSelect0 /* 2131364003 */:
                DialElementView controlViewStep = this$0.getControlViewStep();
                IIX0o.oO(controlViewStep, "<get-controlViewStep>(...)");
                ImageView dialSelectStatus0 = this_apply.getDialSelectStatus0();
                IIX0o.oO(dialSelectStatus0, "<get-dialSelectStatus0>(...)");
                this$0.controlChangeStatus(controlViewStep, dialSelectStatus0);
                return;
            case R.id.dialSelect1 /* 2131364004 */:
                DialElementView controlViewHr = this$0.getControlViewHr();
                IIX0o.oO(controlViewHr, "<get-controlViewHr>(...)");
                ImageView dialSelectStatus1 = this_apply.getDialSelectStatus1();
                IIX0o.oO(dialSelectStatus1, "<get-dialSelectStatus1>(...)");
                this$0.controlChangeStatus(controlViewHr, dialSelectStatus1);
                return;
            case R.id.dialSelect2 /* 2131364005 */:
                DialElementView controlViewCa = this$0.getControlViewCa();
                IIX0o.oO(controlViewCa, "<get-controlViewCa>(...)");
                ImageView dialSelectStatus2 = this_apply.getDialSelectStatus2();
                IIX0o.oO(dialSelectStatus2, "<get-dialSelectStatus2>(...)");
                this$0.controlChangeStatus(controlViewCa, dialSelectStatus2);
                return;
            case R.id.dialSelect3 /* 2131364006 */:
                DialElementView controlViewDis = this$0.getControlViewDis();
                IIX0o.oO(controlViewDis, "<get-controlViewDis>(...)");
                ImageView dialSelectStatus3 = this_apply.getDialSelectStatus3();
                IIX0o.oO(dialSelectStatus3, "<get-dialSelectStatus3>(...)");
                this$0.controlChangeStatus(controlViewDis, dialSelectStatus3);
                return;
            default:
                return;
        }
    }

    private final void initWatchfaceView() {
        this.mCustomWatchFace = new X0o0xo(Utils.getApp());
        DialElementView controlViewStep = getControlViewStep();
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi = this.mCustomWatchFace;
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi2 = null;
        if (oix0oi == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
            oix0oi = null;
        }
        controlViewStep.setIsRangeCircle(oix0oi.oOo());
        DialElementView controlViewHr = getControlViewHr();
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi3 = this.mCustomWatchFace;
        if (oix0oi3 == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
            oix0oi3 = null;
        }
        controlViewHr.setIsRangeCircle(oix0oi3.oOo());
        DialElementView controlViewCa = getControlViewCa();
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi4 = this.mCustomWatchFace;
        if (oix0oi4 == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
            oix0oi4 = null;
        }
        controlViewCa.setIsRangeCircle(oix0oi4.oOo());
        DialElementView controlViewDis = getControlViewDis();
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi5 = this.mCustomWatchFace;
        if (oix0oi5 == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
            oix0oi5 = null;
        }
        controlViewDis.setIsRangeCircle(oix0oi5.oOo());
        DialElementView timeDigitalView = getTimeDigitalView();
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi6 = this.mCustomWatchFace;
        if (oix0oi6 == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
        } else {
            oix0oi2 = oix0oi6;
        }
        timeDigitalView.setIsRangeCircle(oix0oi2.oOo());
        adjustWatchfaceViewWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveRecord() {
        String str;
        String str2 = BleCache.INSTANCE.getMBleName() + '_' + this.mCurSyncDialId + '_' + System.currentTimeMillis();
        if (TextUtils.isEmpty(this.mAiBgFile)) {
            str = this.paramName + this.is2DAcceleration + str2;
        } else {
            str = this.paramName + "/AI/" + str2;
        }
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        File file = new File(IXxxXO.oOXoIIIo(oix0oi), str + ".png");
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi2 = this.mCustomWatchFace;
        if (oix0oi2 == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
            oix0oi2 = null;
        }
        FileIOUtils.writeFileFromBytesByStream(file, oix0oi2.ooOx());
        File file2 = new File(IXxxXO.oOXoIIIo(oix0oi), str);
        byte[] bArr = this.mCurSendBytes;
        if (bArr == null) {
            IIX0o.XOxIOxOx("mCurSendBytes");
            bArr = null;
        }
        FileIOUtils.writeFileFromBytesByStream(file2, bArr);
        x0xO0oo.II0xO0(x0xO0oo.f24584O00XxXI, null, 2, null);
    }

    private final void selectImagePopup() {
        if (this.mSelectAvatarPopup == null) {
            final xx0X0 xx0x0 = new xx0X0(this);
            xx0x0.xI(new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity$selectImagePopup$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    PermissionHelper permissionHelper = PermissionHelper.f24522oIX0oI;
                    Activity Oxx0IOOO2 = xx0X0.this.Oxx0IOOO();
                    final WatchFaceCustomActivity watchFaceCustomActivity = this;
                    permissionHelper.X0o0xo(Oxx0IOOO2, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity$selectImagePopup$1$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        public final void invoke(boolean z) {
                            Xx000oIo.oxoX mCrop;
                            if (z) {
                                mCrop = WatchFaceCustomActivity.this.getMCrop();
                                mCrop.I0Io();
                            }
                        }
                    });
                }
            });
            xx0x0.ooXIXxIX(new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity$selectImagePopup$1$2
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
                    Xx000oIo.oxoX mCrop;
                    mCrop = WatchFaceCustomActivity.this.getMCrop();
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
    public final void showRvBg() {
        Bitmap bitmap;
        boolean z;
        int i;
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi = this.mCustomWatchFace;
        CommonAdapter<String> commonAdapter = null;
        if (oix0oi == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
            oix0oi = null;
        }
        if (!this.mBgFiles.isEmpty()) {
            bitmap = ImageUtils.getBitmap((String) CollectionsKt___CollectionsKt.O0OOX0IIx(this.mBgFiles));
        } else {
            bitmap = ImageUtils.getBitmap(R.drawable.pic_custom_bg_def);
        }
        IIX0o.ooOOo0oXI(bitmap);
        oix0oi.oX0ooo0I0(bitmap);
        TextView tvBgTitle = getTvBgTitle();
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.image));
        sb.append(HexStringBuilder.COMMENT_BEGIN_CHAR);
        sb.append(this.mBgFiles.size());
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        ProductManager productManager = ProductManager.f20544oIX0oI;
        sb.append(productManager.o0());
        sb.append(HexStringBuilder.COMMENT_END_CHAR);
        tvBgTitle.setText(sb.toString());
        ViewGroup addBg = getAddBg();
        if (this.mBgFiles.size() < productManager.o0()) {
            z = true;
        } else {
            z = false;
        }
        addBg.setEnabled(z);
        ViewGroup addBg2 = getAddBg();
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi2 = this.mCustomWatchFace;
        if (oix0oi2 == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
            oix0oi2 = null;
        }
        if (oix0oi2.oOo()) {
            i = R.drawable.shape_custom_dial_add_bg;
        } else {
            i = R.drawable.shape_custom_dial_add_bg_r;
        }
        addBg2.setBackgroundResource(i);
        CommonAdapter<String> commonAdapter2 = this.rvBgAdapter;
        if (commonAdapter2 == null) {
            IIX0o.XOxIOxOx("rvBgAdapter");
        } else {
            commonAdapter = commonAdapter2;
        }
        commonAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncFailed(int i) {
        xOOOX xooox = this.mProgressPop;
        if (xooox != null) {
            xooox.dismiss();
        }
        this.mProgressPop = null;
        ToastUtils.showLong(oO.f24511oIX0oI.I0Io(i), new Object[0]);
    }

    public static /* synthetic */ void syncFailed$default(WatchFaceCustomActivity watchFaceCustomActivity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        watchFaceCustomActivity.syncFailed(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncWatchFace() {
        if (this.mProgressPop == null) {
            xOOOX xooox = new xOOOX(this, 0, 2, null);
            xooox.xxX(R.string.dial_generated_start);
            xooox.XIxXXX0x0(0);
            this.mProgressPop = xooox;
            xooox.IIXOooo();
            xOOOX xooox2 = this.mProgressPop;
            if (xooox2 != null) {
                xooox2.xxX(R.string.dial_generated_sync);
            }
            new Thread(new Runnable() { // from class: com.sma.smartv3.ui.device.watchface.oxoX
                @Override // java.lang.Runnable
                public final void run() {
                    WatchFaceCustomActivity.syncWatchFace$lambda$8(WatchFaceCustomActivity.this);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void syncWatchFace$lambda$8(WatchFaceCustomActivity this$0) {
        List<String> ooXIXxIX2;
        IIX0o.x0xO0oo(this$0, "this$0");
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi = this$0.mCustomWatchFace;
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi2 = null;
        if (oix0oi == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
            oix0oi = null;
        }
        if (this$0.mBgFiles.size() > 1) {
            ooXIXxIX2 = this$0.mBgFiles;
        } else {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        oix0oi.OX(ooXIXxIX2);
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi3 = this$0.mCustomWatchFace;
        if (oix0oi3 == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
        } else {
            oix0oi2 = oix0oi3;
        }
        byte[] XO2 = oix0oi2.XO();
        this$0.mCurSendBytes = XO2;
        X00IoxXI.oIX0oI oix0oi4 = X00IoxXI.oIX0oI.f3233oIX0oI;
        File xxX2 = IXxxXO.xxX(oix0oi4);
        File IoOoX2 = IXxxXO.IoOoX(oix0oi4);
        StringBuilder sb = new StringBuilder();
        BleCache bleCache = BleCache.INSTANCE;
        sb.append(bleCache.getMPrototype());
        sb.append('_');
        sb.append(bleCache.getMBleName());
        sb.append('_');
        sb.append(this$0.mCurSyncDialId);
        sb.append(".png");
        FileUtils.copy(xxX2, new File(IoOoX2, sb.toString()));
        LogUtils.d(this$0.mCurSyncDevicePosition + " Custom WatchFace bytes size  " + XO2.length);
        BleConnector.INSTANCE.sendStream(BleKey.WATCH_FACE, XO2, this$0.mCurSyncDevicePosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toCropPic(Uri uri) {
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi = this.mCustomWatchFace;
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi2 = null;
        if (oix0oi == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
            oix0oi = null;
        }
        int XIo0oOXIx2 = oix0oi.XIo0oOXIx();
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi3 = this.mCustomWatchFace;
        if (oix0oi3 == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
        } else {
            oix0oi2 = oix0oi3;
        }
        int IoOoo2 = oix0oi2.IoOoo();
        if (XIo0oOXIx2 < 320) {
            XIo0oOXIx2 *= 2;
            IoOoo2 *= 2;
        }
        int i = XIo0oOXIx2;
        int i2 = IoOoo2;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("toCropPic outputX:" + i + " outputY:" + i2 + TokenParser.SP + uri);
        getMCrop().X0o0xo(uri, 1.0d, ((double) i) / ((double) i2), i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap toRound(Bitmap bitmap) {
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi = this.mCustomWatchFace;
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi2 = null;
        if (oix0oi == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
            oix0oi = null;
        }
        if (oix0oi.oOo()) {
            Bitmap round = ImageUtils.toRound(bitmap);
            IIX0o.ooOOo0oXI(round);
            return round;
        }
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi3 = this.mCustomWatchFace;
        if (oix0oi3 == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
        } else {
            oix0oi2 = oix0oi3;
        }
        Bitmap roundCorner = ImageUtils.toRoundCorner(bitmap, oix0oi2.xoxXI());
        IIX0o.ooOOo0oXI(roundCorner);
        return roundCorner;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
        BleConnector.INSTANCE.addHandleCallback(this.mBleHandleCallback);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        getAbhTitleCenter().setText(R.string.dial_customize);
        getMCrop().ooOOo0oXI(this, new Oox.oOoXoXO<Uri, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity$initView$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Uri uri) {
                invoke2(uri);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo Uri it) {
                IIX0o.x0xO0oo(it, "it");
                WatchFaceCustomActivity.this.toCropPic(it);
            }
        });
        initWatchfaceView();
        initBgView();
        showRvBg();
        initElementView();
        String stringExtra = getIntent().getStringExtra("bgFile");
        this.mAiBgFile = stringExtra;
        if (stringExtra != null) {
            Uri fromFile = Uri.fromFile(new File(this.mAiBgFile));
            IIX0o.oO(fromFile, "fromFile(...)");
            toCropPic(fromFile);
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_watchface_custom;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @oOoXoXO Intent intent) {
        Uri uri;
        super.onActivityResult(i, i2, intent);
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityResult ");
        sb.append(i);
        sb.append(TokenParser.SP);
        sb.append(i2);
        sb.append(TokenParser.SP);
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi = null;
        if (intent != null) {
            uri = intent.getData();
        } else {
            uri = null;
        }
        sb.append(uri);
        LogUtils.d(sb.toString());
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi2 = this.mCustomWatchFace;
        if (oix0oi2 == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
            oix0oi2 = null;
        }
        int XIo0oOXIx2 = oix0oi2.XIo0oOXIx();
        com.sma.smartv3.ui.device.watchface.oIX0oI oix0oi3 = this.mCustomWatchFace;
        if (oix0oi3 == null) {
            IIX0o.XOxIOxOx("mCustomWatchFace");
        } else {
            oix0oi = oix0oi3;
        }
        int IoOoo2 = oix0oi.IoOoo();
        if (XIo0oOXIx2 < 320) {
            XIo0oOXIx2 *= 2;
            IoOoo2 *= 2;
        }
        int i3 = XIo0oOXIx2;
        int i4 = IoOoo2;
        LogUtils.d("onActivityResult outputX:" + i3 + " outputY:" + i4);
        getMCrop().Oxx0IOOO(i, i2, intent, 1.0d, ((double) i3) / ((double) i4), i3, i4);
    }

    public final void onAddBg(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        selectImagePopup();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mProgressPop != null) {
            ToastUtils.showLong(R.string.syncing);
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        BleConnector.INSTANCE.removeHandleCallback(this.mBleHandleCallback);
        super.onDestroy();
        FileUtils.delete(IXxxXO.I0X0x0oIo(X00IoxXI.oIX0oI.f3233oIX0oI));
    }

    public final void onReset(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        getControlViewStep().setVisibility(8);
        getControlViewHr().setVisibility(8);
        getControlViewCa().setVisibility(8);
        getControlViewDis().setVisibility(8);
        getTimeDigitalView().setVisibility(8);
        getTimePointView().setVisibility(8);
        getTimeScaleView().setVisibility(8);
        ControlElementFragment controlElementFragment = this.controlElementFragment;
        ControlElementFragment controlElementFragment2 = null;
        if (controlElementFragment == null) {
            IIX0o.XOxIOxOx("controlElementFragment");
            controlElementFragment = null;
        }
        controlElementFragment.getDialSelectStatus0().setImageResource(R.drawable.ic_watchface_element_add);
        ControlElementFragment controlElementFragment3 = this.controlElementFragment;
        if (controlElementFragment3 == null) {
            IIX0o.XOxIOxOx("controlElementFragment");
            controlElementFragment3 = null;
        }
        controlElementFragment3.getDialSelectStatus1().setImageResource(R.drawable.ic_watchface_element_add);
        ControlElementFragment controlElementFragment4 = this.controlElementFragment;
        if (controlElementFragment4 == null) {
            IIX0o.XOxIOxOx("controlElementFragment");
            controlElementFragment4 = null;
        }
        controlElementFragment4.getDialSelectStatus2().setImageResource(R.drawable.ic_watchface_element_add);
        ControlElementFragment controlElementFragment5 = this.controlElementFragment;
        if (controlElementFragment5 == null) {
            IIX0o.XOxIOxOx("controlElementFragment");
            controlElementFragment5 = null;
        }
        controlElementFragment5.getDialSelectStatus3().setImageResource(R.drawable.ic_watchface_element_add);
        this.mBgFiles.clear();
        showRvBg();
        PointerElementFragment pointerElementFragment = this.pointerElementFragment;
        if (pointerElementFragment == null) {
            IIX0o.XOxIOxOx("pointerElementFragment");
            pointerElementFragment = null;
        }
        pointerElementFragment.reset();
        TimeElementFragment timeElementFragment = this.timeElementFragment;
        if (timeElementFragment == null) {
            IIX0o.XOxIOxOx("timeElementFragment");
            timeElementFragment = null;
        }
        timeElementFragment.reset();
        ControlElementFragment controlElementFragment6 = this.controlElementFragment;
        if (controlElementFragment6 == null) {
            IIX0o.XOxIOxOx("controlElementFragment");
        } else {
            controlElementFragment2 = controlElementFragment6;
        }
        controlElementFragment2.reset();
    }

    public final void onSycn(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        this.mCurSyncDevicePosition = 0;
        this.mCurSyncDialId = 10000000;
        syncWatchFace();
    }

    public final void onTitleLeftClick(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        if (this.mProgressPop != null) {
            ToastUtils.showLong(R.string.syncing);
        } else {
            finish();
        }
    }
}
