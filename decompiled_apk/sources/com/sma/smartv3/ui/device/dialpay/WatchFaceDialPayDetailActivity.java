package com.sma.smartv3.ui.device.dialpay;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0.XO;
import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.sma.androidnetworklib.method.HttpProgressCallback;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.OrderManager;
import com.sma.smartv3.biz.StatManager;
import com.sma.smartv3.biz.WatchFaceManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.BleInitializer;
import com.sma.smartv3.initializer.IXxxXO;
import com.sma.smartv3.model.AccountCreateOrder;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.EvaluationKt;
import com.sma.smartv3.model.SyncStatus;
import com.sma.smartv3.model.WatchFaceCategoryV2;
import com.sma.smartv3.model.WatchFaceDetail;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.pop.XoI0Ixx0;
import com.sma.smartv3.pop.oOXoIIIo;
import com.sma.smartv3.ui.device.dial.DialPickerPopup;
import com.sma.smartv3.ui.device.dial.xIXX;
import com.sma.smartv3.ui.login.ServerSelectActivity;
import com.sma.smartv3.ui.me.GoogleWebViewActivity;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.oO;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.ProgressButtonV2;
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
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nWatchFaceDialPayDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WatchFaceDialPayDetailActivity.kt\ncom/sma/smartv3/ui/device/dialpay/WatchFaceDialPayDetailActivity\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,792:1\n87#2,7:793\n94#2,3:801\n70#2,7:804\n97#2:811\n87#2,7:812\n94#2,3:820\n70#2,7:823\n97#2:830\n1#3:800\n1#3:819\n*S KotlinDebug\n*F\n+ 1 WatchFaceDialPayDetailActivity.kt\ncom/sma/smartv3/ui/device/dialpay/WatchFaceDialPayDetailActivity\n*L\n265#1:793,7\n265#1:801,3\n265#1:804,7\n265#1:811\n439#1:812,7\n439#1:820,3\n439#1:823,7\n439#1:830\n265#1:800\n439#1:819\n*E\n"})
/* loaded from: classes12.dex */
public final class WatchFaceDialPayDetailActivity extends BaseActivity {

    @oOoXoXO
    private DialPickerPopup dialPickerPopup;
    private boolean isNeedPayDialog;
    private boolean isPaySuccess;
    private float mAmount;
    private float mAmountMember;
    private float mAmountOriginal;

    @oOoXoXO
    private XoI0Ixx0 mConfirmPopup;
    private int mCurSyncCompleted;
    private int mCurSyncDevicePosition;
    private int mCurSyncDialId;
    private int mCurSyncPosition;
    private int mCurSyncTotal;
    private boolean mDialDiscount;
    private boolean mDialIsLimitFreeFlag;
    private boolean mDialIsVipFreeFlag;
    private int mDialType;

    @oOoXoXO
    private oOXoIIIo mEvaluationPopup;

    @oOoXoXO
    private XoI0Ixx0 mLoginHintPopup;

    @oOoXoXO
    private XoI0Ixx0 mPayconfirmPopup;

    @OOXIXo
    private final X0IIOO rootView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return WatchFaceDialPayDetailActivity.this.findViewById(R.id.rootView);
        }
    });

    @OOXIXo
    private final X0IIOO dialIv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$dialIv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) WatchFaceDialPayDetailActivity.this.findViewById(R.id.iv);
        }
    });

    @OOXIXo
    private final X0IIOO abhTitleCenter$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) WatchFaceDialPayDetailActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OOXIXo
    private final X0IIOO btnView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$btnView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return WatchFaceDialPayDetailActivity.this.findViewById(R.id.dial_pay_detail_btn);
        }
    });

    @OOXIXo
    private final X0IIOO progressButton$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ProgressButtonV2>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$progressButton$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ProgressButtonV2 invoke() {
            return (ProgressButtonV2) WatchFaceDialPayDetailActivity.this.findViewById(R.id.btn_bottom);
        }
    });

    @OOXIXo
    private final X0IIOO dialNew$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$dialNew$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return WatchFaceDialPayDetailActivity.this.findViewById(R.id.item_dial_pay_detail_new);
        }
    });

    @OOXIXo
    private final X0IIOO tvAmount$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$tvAmount$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WatchFaceDialPayDetailActivity.this.findViewById(R.id.item_dial_pay_detail_title_amount);
        }
    });

    @OOXIXo
    private final X0IIOO tvMemory$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$tvMemory$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WatchFaceDialPayDetailActivity.this.findViewById(R.id.item_dial_pay_detail_memory);
        }
    });

    @OOXIXo
    private final X0IIOO tvLimitedFree$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$tvLimitedFree$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WatchFaceDialPayDetailActivity.this.findViewById(R.id.item_dial_pay_detail_limited_time_free);
        }
    });

    @OOXIXo
    private final X0IIOO tvAlsoLike$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$tvAlsoLike$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WatchFaceDialPayDetailActivity.this.findViewById(R.id.item_dial_pay_detail_also_like);
        }
    });

    @OOXIXo
    private final X0IIOO mRecyclerView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$mRecyclerView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            return (RecyclerView) WatchFaceDialPayDetailActivity.this.findViewById(R.id.recycler_view);
        }
    });

    @OOXIXo
    private final X0IIOO mNestedScrollView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<NestedScrollView>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$mNestedScrollView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final NestedScrollView invoke() {
            return (NestedScrollView) WatchFaceDialPayDetailActivity.this.findViewById(R.id.dial_watchface_detail_scrollview);
        }
    });

    @OOXIXo
    private final X0IIOO mPrecautionsTitle$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$mPrecautionsTitle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WatchFaceDialPayDetailActivity.this.findViewById(R.id.dial_qrcode_sycn_title3_tv);
        }
    });

    @OOXIXo
    private final X0IIOO mOpenMembership$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ProgressButtonV2>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$mOpenMembership$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ProgressButtonV2 invoke() {
            return (ProgressButtonV2) WatchFaceDialPayDetailActivity.this.findViewById(R.id.open_membership);
        }
    });

    @OOXIXo
    private final X0IIOO mOpenMembershipLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$mOpenMembershipLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return WatchFaceDialPayDetailActivity.this.findViewById(R.id.open_membership_layout);
        }
    });

    @OOXIXo
    private String mDialMemberAttr = "";

    @OOXIXo
    private final String TAG = "WatchFaceDialPayDetailActivity";

    @OOXIXo
    private String mPayStatus = "";

    @OOXIXo
    private String previewUrl = "";

    @OOXIXo
    private String binUrl = "";
    private int mItemPosition = -1;

    @OOXIXo
    private final List<Integer> mDialIds = CollectionsKt__CollectionsKt.XOxIOxOx(0);

    @OOXIXo
    private String mBinFileName = "";

    @OOXIXo
    private String orderNum = "";

    @OOXIXo
    private SyncStatus mCurSyncStatus = SyncStatus.NO_SYNC;

    @OOXIXo
    private final II0xO0 mBleHandleCallback = new II0xO0();

    @XX({"SMAP\nWatchFaceDialPayDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WatchFaceDialPayDetailActivity.kt\ncom/sma/smartv3/ui/device/dialpay/WatchFaceDialPayDetailActivity$mBleHandleCallback$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,792:1\n1855#2,2:793\n*S KotlinDebug\n*F\n+ 1 WatchFaceDialPayDetailActivity.kt\ncom/sma/smartv3/ui/device/dialpay/WatchFaceDialPayDetailActivity$mBleHandleCallback$1\n*L\n149#1:793,2\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class II0xO0 implements BleHandleCallback {
        public II0xO0() {
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
                WatchFaceDialPayDetailActivity.this.mCurSyncStatus = SyncStatus.FAILED;
                ToastUtils.showLong(oO.f24511oIX0oI.oIX0oI(0), new Object[0]);
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
            WatchFaceDialPayDetailActivity.this.mDialIds.clear();
            List<Integer> mIdList = watchFaceId.getMIdList();
            WatchFaceDialPayDetailActivity watchFaceDialPayDetailActivity = WatchFaceDialPayDetailActivity.this;
            Iterator<T> it = mIdList.iterator();
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                if (intValue <= 0) {
                    watchFaceDialPayDetailActivity.mDialIds.add(0);
                } else {
                    watchFaceDialPayDetailActivity.mDialIds.add(Integer.valueOf(intValue));
                }
            }
            LogUtils.d("mDialIds -> " + WatchFaceDialPayDetailActivity.this.mDialIds);
            WatchFaceDialPayDetailActivity.this.initSynced();
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
            if (WatchFaceDialPayDetailActivity.this.mCurSyncDialId != 0 && WatchFaceDialPayDetailActivity.this.mCurSyncStatus == SyncStatus.SYNCING) {
                WatchFaceDialPayDetailActivity.this.mCurSyncStatus = SyncStatus.FAILED;
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
            if (bleKey != BleKey.WATCH_FACE) {
                return;
            }
            if (z) {
                WatchFaceDialPayDetailActivity.this.mCurSyncStatus = SyncStatus.SYNCING;
                BleInitializer bleInitializer = BleInitializer.f20700XO;
                bleInitializer.IXO(true);
                if (i2 == i3) {
                    WatchFaceDialPayDetailActivity.this.mCurSyncStatus = SyncStatus.SYNCED;
                    WatchFaceDialPayDetailActivity.this.mDialIds.set(WatchFaceDialPayDetailActivity.this.mCurSyncDevicePosition, Integer.valueOf(WatchFaceDialPayDetailActivity.this.mCurSyncDialId));
                    if (!ProductManager.f20544oIX0oI.OOoOoO0o()) {
                        Xo0.f24349oIX0oI.II0xO0().put("syncId", WatchFaceDialPayDetailActivity.this.mCurSyncDialId);
                    }
                    x0xO0oo.II0xO0(x0xO0oo.f24584O00XxXI, null, 2, null);
                    WatchFaceDialPayDetailActivity.this.onShowEvaluationStatus();
                    bleInitializer.IXO(false);
                }
            } else {
                WatchFaceDialPayDetailActivity.this.mCurSyncStatus = SyncStatus.FAILED;
                ToastUtils.showLong(oO.f24511oIX0oI.I0Io(i), new Object[0]);
                BleInitializer.f20700XO.IXO(false);
                WatchFaceDialPayDetailActivity.this.mDialIds.set(WatchFaceDialPayDetailActivity.this.mCurSyncDevicePosition, 0);
                if (!ProductManager.f20544oIX0oI.OOoOoO0o()) {
                    Xo0.f24349oIX0oI.II0xO0().put("syncId", 0);
                }
            }
            WatchFaceDialPayDetailActivity.this.mCurSyncTotal = i2;
            WatchFaceDialPayDetailActivity.this.mCurSyncCompleted = i3;
            WatchFaceDialPayDetailActivity watchFaceDialPayDetailActivity = WatchFaceDialPayDetailActivity.this;
            ProgressButtonV2 progressButton = watchFaceDialPayDetailActivity.getProgressButton();
            IIX0o.oO(progressButton, "access$getProgressButton(...)");
            watchFaceDialPayDetailActivity.syncStatusChange(progressButton, WatchFaceDialPayDetailActivity.this.mCurSyncStatus);
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
            BleHandleCallback.DefaultImpls.onWatchFaceIdUpdate(this, z);
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
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f22599oIX0oI;

        static {
            int[] iArr = new int[SyncStatus.values().length];
            try {
                iArr[SyncStatus.FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SyncStatus.NO_SYNC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SyncStatus.SYNCING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SyncStatus.SYNCED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f22599oIX0oI = iArr;
        }
    }

    private final PFMedium getAbhTitleCenter() {
        return (PFMedium) this.abhTitleCenter$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getBtnView() {
        return (View) this.btnView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView getDialIv() {
        return (ImageView) this.dialIv$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getDialNew() {
        return (View) this.dialNew$delegate.getValue();
    }

    private final NestedScrollView getMNestedScrollView() {
        return (NestedScrollView) this.mNestedScrollView$delegate.getValue();
    }

    private final ProgressButtonV2 getMOpenMembership() {
        return (ProgressButtonV2) this.mOpenMembership$delegate.getValue();
    }

    private final View getMOpenMembershipLayout() {
        return (View) this.mOpenMembershipLayout$delegate.getValue();
    }

    private final TextView getMPrecautionsTitle() {
        return (TextView) this.mPrecautionsTitle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView getMRecyclerView() {
        return (RecyclerView) this.mRecyclerView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProgressButtonV2 getProgressButton() {
        return (ProgressButtonV2) this.progressButton$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvAlsoLike() {
        return (TextView) this.tvAlsoLike$delegate.getValue();
    }

    private final TextView getTvAmount() {
        return (TextView) this.tvAmount$delegate.getValue();
    }

    private final TextView getTvLimitedFree() {
        return (TextView) this.tvLimitedFree$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvMemory() {
        return (TextView) this.tvMemory$delegate.getValue();
    }

    private final void goCreateOrder() {
        OrderManager.f20130oIX0oI.oIX0oI("WatchFace", String.valueOf(getMArg1()), this, new Oox.oOoXoXO<AccountCreateOrder, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$goCreateOrder$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(AccountCreateOrder accountCreateOrder) {
                invoke2(accountCreateOrder);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@oOoXoXO AccountCreateOrder accountCreateOrder) {
                if (accountCreateOrder != null) {
                    WatchFaceDialPayDetailActivity.this.setOrderNum(accountCreateOrder.getOrderNum());
                    WatchFaceDialPayDetailActivity.this.setNeedPayDialog(true);
                    WatchFaceDialPayDetailActivity watchFaceDialPayDetailActivity = WatchFaceDialPayDetailActivity.this;
                    String Oo2 = OrderManager.Oo(OrderManager.f20130oIX0oI, watchFaceDialPayDetailActivity.getOrderNum(), "WatchFace", null, 4, null);
                    Bundle bundle = new Bundle();
                    bundle.putString("mArg0", Oo2);
                    bundle.putInt("mArg1", 2);
                    bundle.putParcelable("mArg2", null);
                    bundle.putSerializable("mArg3", null);
                    Intent intent = new Intent(watchFaceDialPayDetailActivity, (Class<?>) GoogleWebViewActivity.class);
                    intent.putExtras(bundle);
                    watchFaceDialPayDetailActivity.startActivity(intent);
                    return;
                }
                ToastUtils.showLong(WatchFaceDialPayDetailActivity.this.getString(R.string.fail_order), new Object[0]);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initData() {
        float amount;
        float amountDis;
        float f;
        int i;
        this.isPaySuccess = false;
        String mArg0 = getMArg0();
        if (mArg0 != null && mArg0.length() > 0) {
            Glide.with((FragmentActivity) this).load(getMArg0()).into(getDialIv());
        }
        if (getMArg3() != null) {
            Serializable mArg3 = getMArg3();
            IIX0o.x0XOIxOo(mArg3, "null cannot be cast to non-null type com.sma.smartv3.model.WatchFaceCategoryV2");
            WatchFaceCategoryV2 watchFaceCategoryV2 = (WatchFaceCategoryV2) mArg3;
            String payStatus = watchFaceCategoryV2.getPayStatus();
            if (payStatus == null) {
                payStatus = "";
            }
            this.mPayStatus = payStatus;
            ProjectManager projectManager = ProjectManager.f19822oIX0oI;
            if (projectManager.Oxx0xo()) {
                amount = watchFaceCategoryV2.getDollar();
            } else {
                amount = watchFaceCategoryV2.getAmount();
            }
            this.mAmountOriginal = amount;
            if (projectManager.Oxx0xo()) {
                amountDis = watchFaceCategoryV2.getDollarDis();
            } else {
                amountDis = watchFaceCategoryV2.getAmountDis();
            }
            this.mAmountMember = amountDis;
            if (IIX0o.Oxx0IOOO(watchFaceCategoryV2.getMemberAttr(), "2") && projectManager.IxIo()) {
                f = this.mAmountMember;
            } else {
                f = this.mAmountOriginal;
            }
            this.mAmount = f;
            this.previewUrl = watchFaceCategoryV2.getPreviewUrl();
            this.binUrl = watchFaceCategoryV2.getBinUrl();
            String dialType = watchFaceCategoryV2.getDialType();
            if (dialType != null) {
                i = Integer.parseInt(dialType);
            } else {
                i = 0;
            }
            this.mDialType = i;
            getBtnView().setVisibility(0);
            getTvMemory().setText("");
            setViewText(watchFaceCategoryV2.getLimitFreeFlag(), watchFaceCategoryV2.getMemberAttr());
        } else {
            getBtnView().setVisibility(4);
        }
        getWatchFaceDetail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(WatchFaceDialPayDetailActivity this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        OrderManager orderManager = OrderManager.f20130oIX0oI;
        String IIX0o2 = OrderManager.IIX0o(orderManager, null, orderManager.XIxXXX0x0(), 1, null);
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", IIX0o2);
        bundle.putInt("mArg1", 2);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this$0, (Class<?>) GoogleWebViewActivity.class);
        intent.putExtras(bundle);
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendDial(File file) {
        this.mCurSyncStatus = SyncStatus.SYNCING;
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.OOoOoO0o()) {
            BleConnector.sendInt32$default(BleConnector.INSTANCE, BleKey.WATCHFACE_ID, BleKeyFlag.UPDATE, this.mCurSyncDialId, null, false, false, 56, null);
        } else {
            BleConnector.INSTANCE.sendStream(BleKey.WATCH_FACE, file, this.mCurSyncDevicePosition);
            productManager.xOIO();
        }
    }

    public static /* synthetic */ void sendDial$default(WatchFaceDialPayDetailActivity watchFaceDialPayDetailActivity, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            file = IXxxXO.X0o0xo(X00IoxXI.oIX0oI.f3233oIX0oI, watchFaceDialPayDetailActivity.mBinFileName);
        }
        watchFaceDialPayDetailActivity.sendDial(file);
    }

    public static /* synthetic */ void setViewText$default(WatchFaceDialPayDetailActivity watchFaceDialPayDetailActivity, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            str = "";
        }
        watchFaceDialPayDetailActivity.setViewText(z, str);
    }

    private final void showConfirm() {
        if (this.mConfirmPopup == null) {
            XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.x0xO0oo(false);
            xoI0Ixx0.IoOoX(R.string.login_required_tip);
            XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.successful_confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$showConfirm$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OOXIXo
                public final Boolean invoke() {
                    Xo0 xo0 = Xo0.f24349oIX0oI;
                    SPUtils XO2 = xo0.XO();
                    Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
                    Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
                    if (fromJson != null) {
                        appUser = fromJson;
                    }
                    xo0.oxoX().put(AppUser.class.getName(), new Gson().toJson((AppUser) appUser));
                    WatchFaceDialPayDetailActivity watchFaceDialPayDetailActivity = WatchFaceDialPayDetailActivity.this;
                    watchFaceDialPayDetailActivity.startActivity(new Intent(watchFaceDialPayDetailActivity, (Class<?>) ServerSelectActivity.class));
                    return Boolean.TRUE;
                }
            });
            this.mConfirmPopup = xoI0Ixx0;
        }
        XoI0Ixx0 xoI0Ixx02 = this.mConfirmPopup;
        if (xoI0Ixx02 != null) {
            xoI0Ixx02.IIXOooo();
        }
    }

    private final void showLoginHint() {
        if (this.mLoginHintPopup == null) {
            XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.login_reminder);
            xoI0Ixx0.oo0xXOI0I(1);
            xoI0Ixx0.xI(Integer.valueOf(R.string.login_reminder_tip));
            XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$showLoginHint$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OOXIXo
                public final Boolean invoke() {
                    Activity mContext;
                    Xo0 xo0 = Xo0.f24349oIX0oI;
                    SPUtils XO2 = xo0.XO();
                    Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
                    Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
                    if (fromJson != null) {
                        appUser = fromJson;
                    }
                    xo0.oxoX().put(AppUser.class.getName(), new Gson().toJson((AppUser) appUser));
                    ProjectManager projectManager = ProjectManager.f19822oIX0oI;
                    mContext = WatchFaceDialPayDetailActivity.this.getMContext();
                    projectManager.OooO0XOx(mContext);
                    return Boolean.TRUE;
                }
            });
            this.mLoginHintPopup = xoI0Ixx0;
        }
        XoI0Ixx0 xoI0Ixx02 = this.mLoginHintPopup;
        if (xoI0Ixx02 != null) {
            View rootView = getRootView();
            IIX0o.oO(rootView, "<get-rootView>(...)");
            xoI0Ixx02.OxxIIOOXO(rootView);
        }
    }

    private final void showPayConfirm() {
        if (this.mPayconfirmPopup == null) {
            XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.x0xO0oo(false);
            xoI0Ixx0.IoOoX(R.string.payment_completed_tip);
            xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$showPayConfirm$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OOXIXo
                public final Boolean invoke() {
                    WatchFaceDialPayDetailActivity.this.getWatchFaceDetail();
                    return Boolean.TRUE;
                }
            });
            xoI0Ixx0.x0o(R.string.yes_payment, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$showPayConfirm$1$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OOXIXo
                public final Boolean invoke() {
                    WatchFaceDialPayDetailActivity.this.getOrderStatus();
                    return Boolean.TRUE;
                }
            });
            this.mPayconfirmPopup = xoI0Ixx0;
        }
        XoI0Ixx0 xoI0Ixx02 = this.mPayconfirmPopup;
        if (xoI0Ixx02 != null) {
            View rootView = getRootView();
            IIX0o.oO(rootView, "<get-rootView>(...)");
            xoI0Ixx02.OxxIIOOXO(rootView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncDial(final int i, int i2, int i3, final ProgressButtonV2 progressButtonV2, final String str, final String str2, final int i4) {
        File file;
        File file2;
        String str3;
        WatchFaceManager.f20245oIX0oI.oIX0oI(String.valueOf(i));
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI("syncDial -> position:" + i2 + ", mCurSyncPosition:" + i3 + ", mCurSyncDialId:" + i + "  category = " + i4);
        this.mCurSyncDialId = i;
        this.mCurSyncPosition = i2;
        this.mCurSyncStatus = SyncStatus.DOWNLOAD;
        this.mCurSyncDevicePosition = i3;
        StringBuilder sb = new StringBuilder();
        sb.append(this.mAmount);
        sb.append('_');
        BleCache bleCache = BleCache.INSTANCE;
        sb.append(bleCache.getMPrototype());
        sb.append('_');
        sb.append(bleCache.getMBleName());
        sb.append('_');
        sb.append(i);
        sb.append(".bin");
        this.mBinFileName = sb.toString();
        if (this.mAmount == 0.0f) {
            X00IoxXI.oIX0oI oix0oi2 = X00IoxXI.oIX0oI.f3233oIX0oI;
            String absolutePath = IXxxXO.XI0IXoo(oix0oi2).getAbsolutePath();
            IIX0o.oO(absolutePath, "getAbsolutePath(...)");
            file = new File(IXxxXO.XI0IXoo(oix0oi2), this.mBinFileName);
            file2 = new File(IXxxXO.XI0IXoo(oix0oi2), this.mAmount + '_' + bleCache.getMPrototype() + '_' + bleCache.getMBleName() + '_' + i);
            str3 = absolutePath;
        } else {
            StringBuilder sb2 = new StringBuilder();
            X00IoxXI.oIX0oI oix0oi3 = X00IoxXI.oIX0oI.f3233oIX0oI;
            sb2.append(IXxxXO.oOXoIIIo(oix0oi3));
            sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb2.append(bleCache.getMPrototype());
            sb2.append("/PAY");
            String sb3 = sb2.toString();
            file = new File(IXxxXO.oOXoIIIo(oix0oi3), bleCache.getMPrototype() + "/PAY/" + this.mBinFileName);
            file2 = new File(IXxxXO.oOXoIIIo(oix0oi3), bleCache.getMPrototype() + "/PAY/" + this.mAmount + '_' + bleCache.getMPrototype() + '_' + bleCache.getMBleName() + '_' + i);
            str3 = sb3;
        }
        if (file.exists()) {
            oix0oi.oIX0oI("syncDial -> dial try get from dialFile file = " + this.mBinFileName + " size:" + FileUtils.getSize(file));
            ProgressButtonV2.XO(progressButtonV2, R.string.syncing, false, 0, false, 0, null, 62, null);
            sendDial(file);
            return;
        }
        ProgressButtonV2.XO(progressButtonV2, R.string.downloading, false, 0, false, 0, null, 62, null);
        final File file3 = file;
        final File file4 = file2;
        NetWorkUtils.INSTANCE.download(str, str3, this.mBinFileName, new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$syncDial$1
            @Override // xxxI.II0xO0
            public void handleError(@OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                FileUtils.delete(file3);
                FileUtils.delete(file4);
                this.mCurSyncStatus = SyncStatus.FAILED;
                ProgressButtonV2.XO(progressButtonV2, R.string.sync_failed, false, 0, false, 0, null, 62, null);
                ToastUtils.showLong(oO.f24511oIX0oI.oIX0oI(1), new Object[0]);
            }

            @Override // com.sma.androidnetworklib.method.HttpProgressCallback
            public void handleProgress(int i5) {
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@oOoXoXO String str4) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("syncDial -> dial try get from net");
                StatManager.f20200oIX0oI.I0Io(str, FileUtils.getLength(file3), i4, i);
                if (!FileUtils.isFileExists(file4)) {
                    FileUtils.createOrExistsFile(file4);
                    FileIOUtils.writeFileFromString(file4, str2, false);
                }
                ProgressButtonV2.XO(progressButtonV2, R.string.syncing, false, 0, false, 0, null, 62, null);
                this.sendDial(file3);
            }
        });
    }

    public static /* synthetic */ void syncDial$default(WatchFaceDialPayDetailActivity watchFaceDialPayDetailActivity, int i, int i2, int i3, ProgressButtonV2 progressButtonV2, String str, String str2, int i4, int i5, Object obj) {
        int i6;
        if ((i5 & 64) != 0) {
            i6 = 0;
        } else {
            i6 = i4;
        }
        watchFaceDialPayDetailActivity.syncDial(i, i2, i3, progressButtonV2, str, str2, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncStatusChange(ProgressButtonV2 progressButtonV2, SyncStatus syncStatus) {
        int i = oIX0oI.f22599oIX0oI[syncStatus.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        ProgressButtonV2.XO(progressButtonV2, R.string.synced, true, 0, false, 0, null, 60, null);
                        return;
                    }
                    return;
                }
                progressButtonV2.setProgressDecimalPlaces(this.mCurSyncCompleted / this.mCurSyncTotal);
                return;
            }
            ProgressButtonV2.XO(progressButtonV2, R.string.sync, false, 0, false, 0, null, 62, null);
            return;
        }
        ProgressButtonV2.XO(progressButtonV2, R.string.sync_failed, false, 0, false, 0, null, 62, null);
    }

    public final void detailSyncDial() {
        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$detailSyncDial$1

            /* loaded from: classes12.dex */
            public static final class oIX0oI implements xIXX {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public final /* synthetic */ WatchFaceDialPayDetailActivity f22598oIX0oI;

                public oIX0oI(WatchFaceDialPayDetailActivity watchFaceDialPayDetailActivity) {
                    this.f22598oIX0oI = watchFaceDialPayDetailActivity;
                }

                @Override // com.sma.smartv3.ui.device.dial.xIXX
                public void oIX0oI(int i) {
                    WatchFaceDialPayDetailActivity watchFaceDialPayDetailActivity = this.f22598oIX0oI;
                    int mArg1 = watchFaceDialPayDetailActivity.getMArg1();
                    int mItemPosition = this.f22598oIX0oI.getMItemPosition();
                    ProgressButtonV2 progressButton = this.f22598oIX0oI.getProgressButton();
                    IIX0o.oO(progressButton, "access$getProgressButton(...)");
                    watchFaceDialPayDetailActivity.syncDial(mArg1, mItemPosition, i, progressButton, this.f22598oIX0oI.getBinUrl(), this.f22598oIX0oI.getPreviewUrl(), this.f22598oIX0oI.getMDialType());
                }
            }

            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(BleConnector bleConnector) {
                invoke2(bleConnector);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo BleConnector it) {
                DialPickerPopup dialPickerPopup;
                DialPickerPopup dialPickerPopup2;
                View rootView;
                IIX0o.x0xO0oo(it, "it");
                WatchFaceDialPayDetailActivity watchFaceDialPayDetailActivity = WatchFaceDialPayDetailActivity.this;
                IIX0o.x0XOIxOo(watchFaceDialPayDetailActivity, "null cannot be cast to non-null type com.bestmafen.androidbase.base.BaseActivity");
                watchFaceDialPayDetailActivity.disableOrientation();
                if (ProductManager.f20544oIX0oI.OOoOoO0o()) {
                    dialPickerPopup = WatchFaceDialPayDetailActivity.this.dialPickerPopup;
                    if (dialPickerPopup == null || !dialPickerPopup.isShowing()) {
                        WatchFaceDialPayDetailActivity watchFaceDialPayDetailActivity2 = WatchFaceDialPayDetailActivity.this;
                        WatchFaceDialPayDetailActivity watchFaceDialPayDetailActivity3 = WatchFaceDialPayDetailActivity.this;
                        watchFaceDialPayDetailActivity2.dialPickerPopup = new DialPickerPopup(watchFaceDialPayDetailActivity3, watchFaceDialPayDetailActivity3.mDialIds, WatchFaceDialPayDetailActivity.this.getMDialType(), new oIX0oI(WatchFaceDialPayDetailActivity.this));
                        dialPickerPopup2 = WatchFaceDialPayDetailActivity.this.dialPickerPopup;
                        if (dialPickerPopup2 != null) {
                            rootView = WatchFaceDialPayDetailActivity.this.getRootView();
                            IIX0o.oO(rootView, "access$getRootView(...)");
                            dialPickerPopup2.OxxIIOOXO(rootView);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WatchFaceDialPayDetailActivity watchFaceDialPayDetailActivity4 = WatchFaceDialPayDetailActivity.this;
                int mArg1 = watchFaceDialPayDetailActivity4.getMArg1();
                ProgressButtonV2 progressButton = WatchFaceDialPayDetailActivity.this.getProgressButton();
                IIX0o.oO(progressButton, "access$getProgressButton(...)");
                watchFaceDialPayDetailActivity4.syncDial(mArg1, -1, 0, progressButton, WatchFaceDialPayDetailActivity.this.getBinUrl(), WatchFaceDialPayDetailActivity.this.getPreviewUrl(), WatchFaceDialPayDetailActivity.this.getMDialType());
            }
        }, 1, null);
    }

    @OOXIXo
    public final String getBinUrl() {
        return this.binUrl;
    }

    public final float getMAmount() {
        return this.mAmount;
    }

    public final float getMAmountMember() {
        return this.mAmountMember;
    }

    public final float getMAmountOriginal() {
        return this.mAmountOriginal;
    }

    public final int getMDialType() {
        return this.mDialType;
    }

    public final int getMItemPosition() {
        return this.mItemPosition;
    }

    @OOXIXo
    public final String getMPayStatus() {
        return this.mPayStatus;
    }

    @OOXIXo
    public final String getOrderNum() {
        return this.orderNum;
    }

    public final void getOrderStatus() {
        OrderManager.f20130oIX0oI.IXxxXO(this.orderNum, "WatchFace", new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$getOrderStatus$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(boolean z) {
                if (z) {
                    WatchFaceDialPayDetailActivity.this.isPaySuccess = true;
                    ToastUtils.showLong(R.string.pay_success_dial_itp);
                    WatchFaceDialPayDetailActivity.this.detailSyncDial();
                    return;
                }
                ToastUtils.showLong(R.string.pay_confirm_error);
            }
        });
    }

    @OOXIXo
    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    @OOXIXo
    public final String getTAG() {
        return this.TAG;
    }

    public final void getWatchFaceDetail() {
        WatchFaceManager.f20245oIX0oI.II0XooXoX(String.valueOf(getMArg1()), new Oox.oOoXoXO<WatchFaceDetail, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$getWatchFaceDetail$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(WatchFaceDetail watchFaceDetail) {
                invoke2(watchFaceDetail);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@oOoXoXO WatchFaceDetail watchFaceDetail) {
                TextView tvMemory;
                float mAmountOriginal;
                View btnView;
                View dialNew;
                ImageView dialIv;
                if (watchFaceDetail != null) {
                    tvMemory = WatchFaceDialPayDetailActivity.this.getTvMemory();
                    tvMemory.setText(watchFaceDetail.getFileSize() + "MB");
                    WatchFaceDialPayDetailActivity watchFaceDialPayDetailActivity = WatchFaceDialPayDetailActivity.this;
                    ProjectManager projectManager = ProjectManager.f19822oIX0oI;
                    watchFaceDialPayDetailActivity.setMAmountOriginal(projectManager.Oxx0xo() ? watchFaceDetail.getDollar() : watchFaceDetail.getAmount());
                    WatchFaceDialPayDetailActivity.this.setMAmountMember(projectManager.Oxx0xo() ? watchFaceDetail.getDollarDis() : watchFaceDetail.getAmountDis());
                    WatchFaceDialPayDetailActivity watchFaceDialPayDetailActivity2 = WatchFaceDialPayDetailActivity.this;
                    if (IIX0o.Oxx0IOOO(watchFaceDetail.getMemberAttr(), "2") && projectManager.IxIo()) {
                        mAmountOriginal = WatchFaceDialPayDetailActivity.this.getMAmountMember();
                    } else {
                        mAmountOriginal = WatchFaceDialPayDetailActivity.this.getMAmountOriginal();
                    }
                    watchFaceDialPayDetailActivity2.setMAmount(mAmountOriginal);
                    WatchFaceDialPayDetailActivity watchFaceDialPayDetailActivity3 = WatchFaceDialPayDetailActivity.this;
                    String payStatus = watchFaceDetail.getPayStatus();
                    if (payStatus == null) {
                        payStatus = "";
                    }
                    watchFaceDialPayDetailActivity3.setMPayStatus(payStatus);
                    WatchFaceDialPayDetailActivity.this.setPreviewUrl(watchFaceDetail.getPreviewUrl());
                    WatchFaceDialPayDetailActivity.this.setBinUrl(watchFaceDetail.getBinUrl());
                    WatchFaceDialPayDetailActivity.this.setMDialType(watchFaceDetail.getDialType());
                    btnView = WatchFaceDialPayDetailActivity.this.getBtnView();
                    btnView.setVisibility(0);
                    if (!IIX0o.Oxx0IOOO(watchFaceDetail.getPreviewUrl(), WatchFaceDialPayDetailActivity.this.getMArg0())) {
                        RequestBuilder<Drawable> load = Glide.with((FragmentActivity) WatchFaceDialPayDetailActivity.this).load(watchFaceDetail.getPreviewUrl());
                        dialIv = WatchFaceDialPayDetailActivity.this.getDialIv();
                        load.into(dialIv);
                    }
                    dialNew = WatchFaceDialPayDetailActivity.this.getDialNew();
                    dialNew.setVisibility((watchFaceDetail.getNewFlag() && projectManager.IxIX0I()) ? 0 : 8);
                    WatchFaceDialPayDetailActivity.this.setViewText(watchFaceDetail.getLimitFreeFlag(), watchFaceDetail.getMemberAttr());
                }
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
        BleConnector.INSTANCE.addHandleCallback(this.mBleHandleCallback);
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    public final void initSynced() {
        if (this.mDialIds.contains(Integer.valueOf(getMArg1()))) {
            ProgressButtonV2 progressButton = getProgressButton();
            IIX0o.oO(progressButton, "<get-progressButton>(...)");
            ProgressButtonV2.XO(progressButton, R.string.synced, true, 0, false, 0, null, 60, null);
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        BleInitializer.f20700XO.xx0X0(true);
        getAbhTitleCenter().setText(getString(R.string.dail_detail_title));
        getMNestedScrollView().setBackground(oIxOXo.oxoX.Oxx0IOOO(this, R.drawable.dial_watchface_detail_re_bg));
        CharSequence text = getMPrecautionsTitle().getText();
        if (text.length() > 2) {
            TextView mPrecautionsTitle = getMPrecautionsTitle();
            IIX0o.ooOOo0oXI(text);
            mPrecautionsTitle.setText(text.subSequence(0, text.length() - 1).toString());
        }
        ProgressButtonV2 mOpenMembership = getMOpenMembership();
        IIX0o.oO(mOpenMembership, "<get-mOpenMembership>(...)");
        String string = getString(R.string.dial_member_buy);
        IIX0o.oO(string, "getString(...)");
        ProgressButtonV2.Oxx0IOOO(mOpenMembership, string, true, 0, false, 0, null, 60, null);
        getMOpenMembership().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dialpay.I0Io
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WatchFaceDialPayDetailActivity.initView$lambda$2(WatchFaceDialPayDetailActivity.this, view);
            }
        });
        initData();
        WatchFaceManager.f20245oIX0oI.xoIox(String.valueOf(getMArg1()), new Oox.oOoXoXO<WatchFaceCategoryV2[], oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity$initView$2
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(WatchFaceCategoryV2[] watchFaceCategoryV2Arr) {
                invoke2(watchFaceCategoryV2Arr);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@oOoXoXO WatchFaceCategoryV2[] watchFaceCategoryV2Arr) {
                TextView tvAlsoLike;
                RecyclerView mRecyclerView;
                Activity mContext;
                Activity mContext2;
                RecyclerView mRecyclerView2;
                if (watchFaceCategoryV2Arr == null) {
                    return;
                }
                tvAlsoLike = WatchFaceDialPayDetailActivity.this.getTvAlsoLike();
                tvAlsoLike.setVisibility(watchFaceCategoryV2Arr.length == 0 ? 8 : 0);
                mRecyclerView = WatchFaceDialPayDetailActivity.this.getMRecyclerView();
                mContext = WatchFaceDialPayDetailActivity.this.getMContext();
                mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
                mContext2 = WatchFaceDialPayDetailActivity.this.getMContext();
                WatchFaceDialPayDetailActivity$initView$2$mAdapter$1 watchFaceDialPayDetailActivity$initView$2$mAdapter$1 = new WatchFaceDialPayDetailActivity$initView$2$mAdapter$1(WatchFaceDialPayDetailActivity.this, mContext2, ArraysKt___ArraysKt.X0XOOO(watchFaceCategoryV2Arr));
                mRecyclerView2 = WatchFaceDialPayDetailActivity.this.getMRecyclerView();
                mRecyclerView2.setAdapter(watchFaceDialPayDetailActivity$initView$2$mAdapter$1);
            }
        });
    }

    public final boolean isNeedPayDialog() {
        return this.isNeedPayDialog;
    }

    public final boolean isSync() {
        SyncStatus syncStatus = this.mCurSyncStatus;
        if (syncStatus != SyncStatus.SYNCING && syncStatus != SyncStatus.DOWNLOAD) {
            return false;
        }
        return true;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_dial_pay_watchface_detail;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (isSync()) {
            ToastUtils.showLong(R.string.syncing);
        } else {
            super.onBackPressed();
        }
    }

    public final void onBottomClick(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        this.mItemPosition = -1;
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (!projectManager.xIOXX() && this.mAmount != 0.0f && !com.sma.smartv3.ui.device.dialpay.oIX0oI.oxoX(this.mPayStatus) && projectManager.oXO0oOx0()) {
            showConfirm();
            return;
        }
        if (isSync()) {
            ToastUtils.showLong(R.string.syncing_remind);
            return;
        }
        if (this.mDialIds.contains(Integer.valueOf(getMArg1()))) {
            ToastUtils.showLong(R.string.dial_sync_done);
            return;
        }
        if (this.mAmount != 0.0f && !com.sma.smartv3.ui.device.dialpay.oIX0oI.oxoX(this.mPayStatus)) {
            if (projectManager.xIOXX()) {
                if (this.mDialIsLimitFreeFlag) {
                    detailSyncDial();
                    return;
                }
                if (this.mDialIsVipFreeFlag) {
                    if (projectManager.IxIo()) {
                        detailSyncDial();
                        return;
                    } else {
                        goCreateOrder();
                        return;
                    }
                }
                if (IIX0o.Oxx0IOOO(this.mDialMemberAttr, "1") && !projectManager.IxIo()) {
                    OrderManager orderManager = OrderManager.f20130oIX0oI;
                    String IIX0o2 = OrderManager.IIX0o(orderManager, null, orderManager.XIxXXX0x0(), 1, null);
                    Bundle bundle = new Bundle();
                    bundle.putString("mArg0", IIX0o2);
                    bundle.putInt("mArg1", 2);
                    bundle.putParcelable("mArg2", null);
                    bundle.putSerializable("mArg3", null);
                    Intent intent = new Intent(this, (Class<?>) GoogleWebViewActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    return;
                }
                if (this.isPaySuccess) {
                    detailSyncDial();
                    return;
                } else {
                    goCreateOrder();
                    return;
                }
            }
            showLoginHint();
            return;
        }
        detailSyncDial();
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        BleConnector.INSTANCE.removeHandleCallback(this.mBleHandleCallback);
        BleInitializer bleInitializer = BleInitializer.f20700XO;
        bleInitializer.xx0X0(false);
        bleInitializer.IXO(false);
        super.onDestroy();
    }

    @XO(tag = x0xO0oo.f24583O0)
    public final void onOrderPayStatusChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " onOrderPayStatusChange");
        this.isNeedPayDialog = false;
        XoI0Ixx0 xoI0Ixx0 = this.mPayconfirmPopup;
        if (xoI0Ixx0 != null && xoI0Ixx0 != null) {
            xoI0Ixx0.dismiss();
        }
        getOrderStatus();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isNeedPayDialog) {
            this.isNeedPayDialog = false;
            showPayConfirm();
        }
        if (ProductManager.f20544oIX0oI.OOoOoO0o()) {
            BleConnector.sendData$default(BleConnector.INSTANCE, BleKey.WATCHFACE_ID, BleKeyFlag.READ, null, false, false, 28, null);
            return;
        }
        this.mDialIds.set(0, Integer.valueOf(Xo0.f24349oIX0oI.II0xO0().getInt("syncId", 0)));
        LogUtils.d("mDialIds -> " + this.mDialIds);
        initSynced();
    }

    public final void onShowEvaluationStatus() {
        oOXoIIIo ooxoiiio;
        if (EvaluationKt.isShowEvaluationDialog()) {
            if (this.mEvaluationPopup == null) {
                this.mEvaluationPopup = new oOXoIIIo(this, 0, 2, null);
            }
            oOXoIIIo ooxoiiio2 = this.mEvaluationPopup;
            if ((ooxoiiio2 == null || !ooxoiiio2.isShowing()) && (ooxoiiio = this.mEvaluationPopup) != null) {
                View rootView = getRootView();
                IIX0o.oO(rootView, "<get-rootView>(...)");
                ooxoiiio.xoXoI(rootView);
            }
        }
    }

    public final void onTitleLeftClick(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        if (isSync()) {
            ToastUtils.showLong(R.string.syncing);
        } else {
            finish();
        }
    }

    public final void setBinUrl(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.binUrl = str;
    }

    public final void setMAmount(float f) {
        this.mAmount = f;
    }

    public final void setMAmountMember(float f) {
        this.mAmountMember = f;
    }

    public final void setMAmountOriginal(float f) {
        this.mAmountOriginal = f;
    }

    public final void setMDialType(int i) {
        this.mDialType = i;
    }

    public final void setMItemPosition(int i) {
        this.mItemPosition = i;
    }

    public final void setMPayStatus(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mPayStatus = str;
    }

    public final void setNeedPayDialog(boolean z) {
        this.isNeedPayDialog = z;
    }

    public final void setOrderNum(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.orderNum = str;
    }

    public final void setPreviewUrl(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.previewUrl = str;
    }

    public final void setViewText(boolean z, @OOXIXo String memberAttr) {
        IIX0o.x0xO0oo(memberAttr, "memberAttr");
        LogUtils.d(this.TAG + " setViewText  mAmount = " + this.mAmount + "  mPayStatus = " + this.mPayStatus + TokenParser.SP);
        if (this.mAmount == 0.0f) {
            getTvAmount().setText(String.valueOf(getString(R.string.free_order_amount)));
        } else {
            getTvAmount().setText(getString(R.string.order_pay_amount_name) + ": " + com.sma.smartv3.ui.device.dialpay.oIX0oI.I0Io(this.mAmount, null, 2, null));
        }
        this.mDialMemberAttr = memberAttr;
        this.mDialIsVipFreeFlag = IIX0o.Oxx0IOOO(memberAttr, "1");
        this.mDialDiscount = IIX0o.Oxx0IOOO(memberAttr, "2");
        this.mDialIsLimitFreeFlag = z;
        getMOpenMembershipLayout().setVisibility(8);
        if (this.mDialIsLimitFreeFlag) {
            getTvLimitedFree().setVisibility(8);
            getTvAmount().setText(getString(R.string.limited_time_free));
        } else if (this.mDialIsVipFreeFlag) {
            if (ProjectManager.f19822oIX0oI.IxIo()) {
                getTvLimitedFree().getPaint().setFlags(16);
                getTvLimitedFree().setVisibility(0);
                getTvLimitedFree().setText(getString(R.string.order_pay_amount_name2) + ": " + com.sma.smartv3.ui.device.dialpay.oIX0oI.I0Io(this.mAmountOriginal, null, 2, null));
                getTvLimitedFree().setTextColor(getResources().getColor(R.color.line_color));
                getTvAmount().setTextColor(oIxOXo.oxoX.X0o0xo(this, R.color.order_text_orange));
                getTvAmount().setText(getString(R.string.member_exclusive2));
            } else {
                getTvLimitedFree().setVisibility(0);
                getTvLimitedFree().setText(getString(R.string.member_exclusive2));
                getTvLimitedFree().setTextColor(getResources().getColor(R.color.order_text_orange));
                getTvAmount().setTextColor(oIxOXo.oxoX.X0o0xo(this, R.color.text_color));
                getTvAmount().setText(getString(R.string.order_pay_amount_name) + ": " + com.sma.smartv3.ui.device.dialpay.oIX0oI.I0Io(this.mAmount, null, 2, null));
                getMOpenMembershipLayout().setVisibility(0);
            }
        } else if (this.mDialDiscount) {
            if (ProjectManager.f19822oIX0oI.IxIo()) {
                getTvAmount().setText(getString(R.string.dial_member_price) + ": " + com.sma.smartv3.ui.device.dialpay.oIX0oI.I0Io(this.mAmount, null, 2, null));
                getTvLimitedFree().setVisibility(0);
                getTvLimitedFree().getPaint().setFlags(16);
                getTvLimitedFree().setText(getString(R.string.order_pay_amount_name2) + ": " + com.sma.smartv3.ui.device.dialpay.oIX0oI.I0Io(this.mAmountOriginal, null, 2, null));
                getTvLimitedFree().setTextColor(getResources().getColor(R.color.line_color));
            } else {
                getTvAmount().setText(getString(R.string.order_pay_amount_name) + ": " + com.sma.smartv3.ui.device.dialpay.oIX0oI.I0Io(this.mAmount, null, 2, null));
                getMOpenMembershipLayout().setVisibility(0);
                getTvAmount().setTextColor(getResources().getColor(R.color.line_color));
                getTvLimitedFree().setTextColor(getResources().getColor(R.color.order_text_orange));
                getTvLimitedFree().setVisibility(0);
                getTvLimitedFree().setText(getString(R.string.dial_member_price) + ": " + com.sma.smartv3.ui.device.dialpay.oIX0oI.I0Io(this.mAmountMember, null, 2, null));
            }
        } else {
            getTvAmount().getPaint().setFlags(0);
            getTvLimitedFree().setVisibility(8);
            getTvAmount().setTextColor(getResources().getColor(R.color.order_text_orange));
        }
        if (z) {
            ProgressButtonV2 progressButton = getProgressButton();
            IIX0o.oO(progressButton, "<get-progressButton>(...)");
            ProgressButtonV2.XO(progressButton, R.string.sync, true, 0, false, 0, null, 60, null);
        } else if (IIX0o.Oxx0IOOO(memberAttr, "1")) {
            ProgressButtonV2 progressButton2 = getProgressButton();
            IIX0o.oO(progressButton2, "<get-progressButton>(...)");
            ProgressButtonV2.XO(progressButton2, R.string.pay_dail_detail_btn_no_pay, true, 0, false, 0, null, 60, null);
        } else if (!com.sma.smartv3.ui.device.dialpay.oIX0oI.oxoX(this.mPayStatus) && this.mAmount != 0.0f) {
            ProgressButtonV2 progressButton3 = getProgressButton();
            IIX0o.oO(progressButton3, "<get-progressButton>(...)");
            ProgressButtonV2.XO(progressButton3, R.string.pay_dail_detail_btn_no_pay, true, 0, false, 0, null, 60, null);
        } else {
            ProgressButtonV2 progressButton4 = getProgressButton();
            IIX0o.oO(progressButton4, "<get-progressButton>(...)");
            ProgressButtonV2.XO(progressButton4, R.string.sync, true, 0, false, 0, null, 60, null);
        }
        initSynced();
    }
}
