package com.sma.smartv3.ui.device;

import android.app.Activity;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.bestmafen.androidbase.extension.PermissionStatus;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.gson.Gson;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.DeviceInfoChecker;
import com.sma.smartv3.biz.voice.VoiceManager;
import com.sma.smartv3.ble.MyNotificationListenerService;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.AGPSInitializer;
import com.sma.smartv3.initializer.BleInitializer;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.ExtraPackageData;
import com.sma.smartv3.model.FirmwareVersion;
import com.sma.smartv3.model.QrcodeTypeInfo;
import com.sma.smartv3.network.RequestCommonMethod;
import com.sma.smartv3.otherdevice.charge.DialogueTranslationActivity;
import com.sma.smartv3.otherdevice.charge.SimultaneousInterpretationActivity;
import com.sma.smartv3.otherdevice.charge.SoundEffectsSampleActivity;
import com.sma.smartv3.pop.IntValuePickerPopup;
import com.sma.smartv3.ui.device.DeviceFragment;
import com.sma.smartv3.ui.device.guide.AppGuideActivity;
import com.sma.smartv3.ui.device.item.AGPSUpgradeItem;
import com.sma.smartv3.ui.device.item.AlarmClockItem;
import com.sma.smartv3.ui.device.item.AlipaySetItem;
import com.sma.smartv3.ui.device.item.AntiLostItem;
import com.sma.smartv3.ui.device.item.AppStoreItem;
import com.sma.smartv3.ui.device.item.AudioBookLearnItem;
import com.sma.smartv3.ui.device.item.BacklightItem;
import com.sma.smartv3.ui.device.item.BaseDeviceItem;
import com.sma.smartv3.ui.device.item.BloodOxyGenItem;
import com.sma.smartv3.ui.device.item.ClassicPairItem;
import com.sma.smartv3.ui.device.item.CustomLogoItem;
import com.sma.smartv3.ui.device.item.DateFormatItem;
import com.sma.smartv3.ui.device.item.DialItem;
import com.sma.smartv3.ui.device.item.DoubleClickScreenItem;
import com.sma.smartv3.ui.device.item.DrinkWaterItem;
import com.sma.smartv3.ui.device.item.EBookManagerItem;
import com.sma.smartv3.ui.device.item.EarphoneItem;
import com.sma.smartv3.ui.device.item.EcgMonitoringItem;
import com.sma.smartv3.ui.device.item.FallManagerItem;
import com.sma.smartv3.ui.device.item.FindWatchItem;
import com.sma.smartv3.ui.device.item.FirmwareItem;
import com.sma.smartv3.ui.device.item.GameSettingsItem;
import com.sma.smartv3.ui.device.item.GameStoreItem;
import com.sma.smartv3.ui.device.item.GameTimeSetItem;
import com.sma.smartv3.ui.device.item.GestureWake2Item;
import com.sma.smartv3.ui.device.item.GestureWakeItem;
import com.sma.smartv3.ui.device.item.HardWareAlipayItem;
import com.sma.smartv3.ui.device.item.HealthCareItem;
import com.sma.smartv3.ui.device.item.HrMonitoringItem;
import com.sma.smartv3.ui.device.item.IncomingCallItem;
import com.sma.smartv3.ui.device.item.IncomingCallRingItem;
import com.sma.smartv3.ui.device.item.IncomingCallRingVibrationItem;
import com.sma.smartv3.ui.device.item.InfoItem;
import com.sma.smartv3.ui.device.item.LanguageItem;
import com.sma.smartv3.ui.device.item.LearnCardItem;
import com.sma.smartv3.ui.device.item.MacQrcodeItem;
import com.sma.smartv3.ui.device.item.MeasureUnitItem;
import com.sma.smartv3.ui.device.item.MedicationAlarmItem;
import com.sma.smartv3.ui.device.item.MemoryManagerItem;
import com.sma.smartv3.ui.device.item.MessagePushItem;
import com.sma.smartv3.ui.device.item.MusicControlItem;
import com.sma.smartv3.ui.device.item.MusicManagerItem;
import com.sma.smartv3.ui.device.item.MyCardCode2Item;
import com.sma.smartv3.ui.device.item.MyCardCodeItem;
import com.sma.smartv3.ui.device.item.NFCGuideItem;
import com.sma.smartv3.ui.device.item.NavigationItem;
import com.sma.smartv3.ui.device.item.NoDisturb2Item;
import com.sma.smartv3.ui.device.item.NoDisturbItem;
import com.sma.smartv3.ui.device.item.NotificationLightScreenItem;
import com.sma.smartv3.ui.device.item.NucleicAcidCodeItem;
import com.sma.smartv3.ui.device.item.PowerSaveModeItem;
import com.sma.smartv3.ui.device.item.PressureItem;
import com.sma.smartv3.ui.device.item.QiblaItem;
import com.sma.smartv3.ui.device.item.ReceiptCode2Item;
import com.sma.smartv3.ui.device.item.ReceiptCodeItem;
import com.sma.smartv3.ui.device.item.RecordingItem;
import com.sma.smartv3.ui.device.item.RelaxReminderItem;
import com.sma.smartv3.ui.device.item.RemoteCameraItem;
import com.sma.smartv3.ui.device.item.ResetItem;
import com.sma.smartv3.ui.device.item.SMSQuickReplyItem;
import com.sma.smartv3.ui.device.item.SOSManagerItem;
import com.sma.smartv3.ui.device.item.ScheduleItem;
import com.sma.smartv3.ui.device.item.SedentarinessItem;
import com.sma.smartv3.ui.device.item.ShockItem;
import com.sma.smartv3.ui.device.item.ShockSettingsItem;
import com.sma.smartv3.ui.device.item.ShutdownItem;
import com.sma.smartv3.ui.device.item.SplitLine4DPItem;
import com.sma.smartv3.ui.device.item.StandbySetItem;
import com.sma.smartv3.ui.device.item.StandbyWatchFaceItem;
import com.sma.smartv3.ui.device.item.StockMarketItem;
import com.sma.smartv3.ui.device.item.SyncContactItem;
import com.sma.smartv3.ui.device.item.TempMonitoringItem;
import com.sma.smartv3.ui.device.item.TimeFormatItem;
import com.sma.smartv3.ui.device.item.TouchSetItem;
import com.sma.smartv3.ui.device.item.TranslationDialogueItem;
import com.sma.smartv3.ui.device.item.TranslationSimultaneousItem;
import com.sma.smartv3.ui.device.item.UnpairItem;
import com.sma.smartv3.ui.device.item.VoiceItem;
import com.sma.smartv3.ui.device.item.WashItem;
import com.sma.smartv3.ui.device.item.WatchPasswordItem;
import com.sma.smartv3.ui.device.item.WearWayItem;
import com.sma.smartv3.ui.device.item.WorldClockItem;
import com.sma.smartv3.ui.login.LoginReminderActivity;
import com.sma.smartv3.ui.me.LanguageListActivity;
import com.sma.smartv3.util.DateTimeFormat;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.permission.PermissionHelper;
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
import com.szabh.smable3.entity.BleGameTimeReminder;
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
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.collections.CollectionsKt__CollectionsKt;

@kotlin.jvm.internal.XX({"SMAP\nDeviceFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceFragment.kt\ncom/sma/smartv3/ui/device/DeviceFragment\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2652:1\n151#2,5:2653\n156#2,5:2659\n78#2,3:2664\n81#2,5:2668\n78#2,3:2673\n81#2,5:2677\n78#2,3:2682\n81#2,5:2686\n78#2,3:2691\n81#2,5:2695\n78#2,3:2700\n81#2,5:2704\n151#2,5:2709\n156#2,5:2715\n99#2,7:2720\n106#2,3:2728\n79#2,7:2731\n109#2:2738\n1#3:2658\n1#3:2667\n1#3:2676\n1#3:2685\n1#3:2694\n1#3:2703\n1#3:2714\n1#3:2727\n*S KotlinDebug\n*F\n+ 1 DeviceFragment.kt\ncom/sma/smartv3/ui/device/DeviceFragment\n*L\n2119#1:2653,5\n2119#1:2659,5\n2365#1:2664,3\n2365#1:2668,5\n2369#1:2673,3\n2369#1:2677,5\n2371#1:2682,3\n2371#1:2686,5\n2373#1:2691,3\n2373#1:2695,5\n2380#1:2700,3\n2380#1:2704,5\n2587#1:2709,5\n2587#1:2715,5\n2598#1:2720,7\n2598#1:2728,3\n2598#1:2731,7\n2598#1:2738\n2119#1:2658\n2365#1:2667\n2369#1:2676\n2371#1:2685\n2373#1:2694\n2380#1:2703\n2587#1:2714\n2598#1:2727\n*E\n"})
/* loaded from: classes12.dex */
public class DeviceFragment extends BaseDSLRecyclerFragment {
    public static final int CODE_ENABLE_BLUETOOTH = 5;
    public static final int CODE_GUIDE = 2;
    public static final int CODE_LOCATION_SERVER = 6;
    public static final int CODE_MULTI_DEVICE = 7;
    public static final int CODE_PAIR = 1;
    public static final int CODE_SELECT_IMAGE = 4;
    public static final int CODE_USE_GUIDE = 3;

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    private boolean isBindDevice;
    private boolean isScanQrcode;
    private long lastClickTime;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xOOOX mAGpsPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mAntiLostSetPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mBacklightPopup;

    @OXOo.oOoXoXO
    private IntValuePickerPopup mBacklightPopup2;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mBindDeviceRemindPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.x0xO mConfirmPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mDateFormatPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mGameTimeSetPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mHIDPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mIncomingCallPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mIncomingCallRingtPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mMacQrcodePopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xoxXI mMultiRingVibrationPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mNoDisturbPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mNotificationLightScreenItem;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mNotificationPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mPermissionPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mPowerSaveModeSetPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mRingVibrationPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XIXIxO mSelectPairPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mShockPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mStandbySetPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mTimeFormatPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mUnbindPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mWearWayPopup;
    private List<DslAdapterItem> showList;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = DeviceFragment.this.getMView();
            return mView.findViewById(R.id.root_view);
        }
    });
    private boolean isTipAppGuideActivity = true;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO infoItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<InfoItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$infoItem$2

        @kotlin.jvm.internal.XX({"SMAP\nDeviceFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceFragment.kt\ncom/sma/smartv3/ui/device/DeviceFragment$infoItem$2$1$2\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2652:1\n151#2,5:2653\n156#2,5:2659\n1#3:2658\n*S KotlinDebug\n*F\n+ 1 DeviceFragment.kt\ncom/sma/smartv3/ui/device/DeviceFragment$infoItem$2$1$2\n*L\n107#1:2653,5\n107#1:2659,5\n107#1:2658\n*E\n"})
        /* loaded from: classes12.dex */
        public static final class oIX0oI implements InfoItem.oIX0oI {

            /* renamed from: oIX0oI, reason: collision with root package name */
            public final /* synthetic */ DeviceFragment f21758oIX0oI;

            public oIX0oI(DeviceFragment deviceFragment) {
                this.f21758oIX0oI = deviceFragment;
            }

            @Override // com.sma.smartv3.ui.device.item.InfoItem.oIX0oI
            public void onClick(@OXOo.OOXIXo View v) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(v, "v");
                if (v.getId() == R.id.btn_multi_device) {
                    DeviceFragment deviceFragment = this.f21758oIX0oI;
                    FragmentActivity activity = deviceFragment.getActivity();
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(activity);
                    deviceFragment.startActivityForResult(new Intent(activity, (Class<?>) MultiDeviceManagerActivity.class), 7);
                }
            }
        }

        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final InfoItem invoke() {
            InfoItem infoItem = new InfoItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            infoItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$infoItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    if (BleConnector.INSTANCE.isBound()) {
                        return;
                    }
                    if (ProjectManager.f19822oIX0oI.XXXI()) {
                        DeviceFragment.this.showPairTypePop();
                    } else {
                        DeviceFragment.toAddDevice$default(DeviceFragment.this, null, null, 3, null);
                    }
                }
            });
            infoItem.setOnClickListener(new oIX0oI(deviceFragment));
            return infoItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO gameStoreItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<GameStoreItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$gameStoreItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final GameStoreItem invoke() {
            GameStoreItem gameStoreItem = new GameStoreItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            gameStoreItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$gameStoreItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    com.sma.smartv3.biz.OOXIXo oOXIXo = com.sma.smartv3.biz.OOXIXo.f20119oIX0oI;
                    Application application = DeviceFragment.this.getMActivity().getApplication();
                    kotlin.jvm.internal.IIX0o.oO(application, "getApplication(...)");
                    oOXIXo.OxxIIOOXO(application);
                    oOXIXo.XIxXXX0x0(DeviceFragment.this.getMActivity());
                }
            });
            return gameStoreItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO classicPairItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ClassicPairItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$classicPairItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final ClassicPairItem invoke() {
            ClassicPairItem classicPairItem = new ClassicPairItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            classicPairItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$classicPairItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) ClassicPairActivity.class));
                }
            });
            return classicPairItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO dialItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DialItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$dialItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final DialItem invoke() {
            DialItem dialItem = new DialItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            dialItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$dialItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    final DeviceFragment deviceFragment2 = DeviceFragment.this;
                    com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$dialItem$2$1$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                            invoke2(bleConnector);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                            ProjectManager.f19822oIX0oI.OIxOX(DeviceFragment.this.getMActivity());
                        }
                    }, 1, null);
                }
            });
            return dialItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO messagePushItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<MessagePushItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$messagePushItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final MessagePushItem invoke() {
            MessagePushItem messagePushItem = new MessagePushItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            messagePushItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$messagePushItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    if (DeviceFragment.this.checkNotificationPermission()) {
                        DeviceFragment deviceFragment2 = DeviceFragment.this;
                        deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) NotificationSettingsActivity.class));
                    }
                }
            });
            return messagePushItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO antiLostItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AntiLostItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$antiLostItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final AntiLostItem invoke() {
            AntiLostItem antiLostItem = new AntiLostItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            antiLostItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$antiLostItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix;
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    xxoxoooix = DeviceFragment.this.mAntiLostSetPopup;
                    if (xxoxoooix == null) {
                        DeviceFragment deviceFragment2 = DeviceFragment.this;
                        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix3 = new com.sma.smartv3.pop.xxOXOOoIX(DeviceFragment.this.getMActivity(), R.array.enable, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
                        final DeviceFragment deviceFragment3 = DeviceFragment.this;
                        xxoxoooix3.xI(R.string.anti_lost);
                        xxoxoooix3.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$antiLostItem$2$1$1$1$1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                                return invoke(num.intValue());
                            }

                            @OXOo.OOXIXo
                            public final Boolean invoke(final int i) {
                                final DeviceFragment deviceFragment4 = DeviceFragment.this;
                                return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$antiLostItem$2$1$1$1$1.1
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
                                    public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                                        BleConnector.sendInt8$default(it2, BleKey.ANTI_LOST, BleKeyFlag.UPDATE, i, false, false, 24, null);
                                        deviceFragment4.getAntiLostItem().initView();
                                    }
                                }, 1, null));
                            }
                        });
                        deviceFragment2.mAntiLostSetPopup = xxoxoooix3;
                    }
                    xxoxoooix2 = DeviceFragment.this.mAntiLostSetPopup;
                    if (xxoxoooix2 != null) {
                        DeviceFragment deviceFragment4 = DeviceFragment.this;
                        xxoxoooix2.IIX0o(BleCache.getInt$default(BleCache.INSTANCE, BleKey.ANTI_LOST, 0, null, 6, null));
                        View rootView = deviceFragment4.getRootView();
                        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                        xxoxoooix2.OxxIIOOXO(rootView);
                    }
                }
            });
            return antiLostItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO incomingCallItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<IncomingCallItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$incomingCallItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final IncomingCallItem invoke() {
            IncomingCallItem incomingCallItem = new IncomingCallItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            incomingCallItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$incomingCallItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix;
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    if (DeviceFragment.this.checkNotificationPermission()) {
                        xxoxoooix = DeviceFragment.this.mIncomingCallPopup;
                        if (xxoxoooix == null) {
                            DeviceFragment deviceFragment2 = DeviceFragment.this;
                            final com.sma.smartv3.pop.xxOXOOoIX xxoxoooix3 = new com.sma.smartv3.pop.xxOXOOoIX(DeviceFragment.this.getMActivity(), R.array.enable, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
                            final DeviceFragment deviceFragment3 = DeviceFragment.this;
                            xxoxoooix3.xI(R.string.incoming_call);
                            xxoxoooix3.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$incomingCallItem$2$1$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // Oox.oOoXoXO
                                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                                    return invoke(num.intValue());
                                }

                                @OXOo.OOXIXo
                                public final Boolean invoke(int i) {
                                    if (i == 1) {
                                        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.PHONE, PermissionConstants.CONTACTS);
                                        kotlin.jvm.internal.IIX0o.oO(permission, "permission(...)");
                                        final com.sma.smartv3.pop.xxOXOOoIX xxoxoooix4 = xxoxoooix3;
                                        final DeviceFragment deviceFragment4 = DeviceFragment.this;
                                        oOXoIIIo.X0o0xo.I0Io(permission, null, null, new Oox.oOoXoXO<PermissionStatus, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$incomingCallItem$2$1$1$1$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // Oox.oOoXoXO
                                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                                                invoke2(permissionStatus);
                                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(@OXOo.OOXIXo PermissionStatus it2) {
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                                                if (it2 != PermissionStatus.GRANTED) {
                                                    deviceFragment4.noPermissionRemind();
                                                    return;
                                                }
                                                com.sma.smartv3.util.Xo0.f24349oIX0oI.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24358II0xO0, true);
                                                BleInitializer bleInitializer = BleInitializer.f20700XO;
                                                bleInitializer.Ox0O();
                                                bleInitializer.XIXIxO(com.sma.smartv3.pop.xxOXOOoIX.this.Oxx0IOOO());
                                                deviceFragment4.getIncomingCallItem().initView();
                                            }
                                        }, 3, null);
                                    } else {
                                        com.sma.smartv3.util.Xo0.f24349oIX0oI.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24358II0xO0, false);
                                        BleInitializer.f20700XO.Ox0O();
                                    }
                                    DeviceFragment.this.getIncomingCallItem().initView();
                                    return Boolean.TRUE;
                                }
                            });
                            deviceFragment2.mIncomingCallPopup = xxoxoooix3;
                        }
                        xxoxoooix2 = DeviceFragment.this.mIncomingCallPopup;
                        if (xxoxoooix2 != null) {
                            DeviceFragment deviceFragment4 = DeviceFragment.this;
                            int i = 0;
                            if (com.sma.smartv3.util.Xo0.f24349oIX0oI.I0Io().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24358II0xO0, false)) {
                                String[] oIX0oI2 = X00xOoXI.oIX0oI();
                                if (PermissionUtils.isGranted((String[]) Arrays.copyOf(oIX0oI2, oIX0oI2.length))) {
                                    i = 1;
                                }
                            }
                            xxoxoooix2.IIX0o(i);
                            View rootView = deviceFragment4.getRootView();
                            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                            xxoxoooix2.OxxIIOOXO(rootView);
                        }
                    }
                }
            });
            return incomingCallItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO notificationLightScreenItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<NotificationLightScreenItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$notificationLightScreenItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final NotificationLightScreenItem invoke() {
            NotificationLightScreenItem notificationLightScreenItem = new NotificationLightScreenItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            notificationLightScreenItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$notificationLightScreenItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix;
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    xxoxoooix = DeviceFragment.this.mNotificationLightScreenItem;
                    if (xxoxoooix == null) {
                        DeviceFragment deviceFragment2 = DeviceFragment.this;
                        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix3 = new com.sma.smartv3.pop.xxOXOOoIX(DeviceFragment.this.getMActivity(), R.array.enable, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
                        final DeviceFragment deviceFragment3 = DeviceFragment.this;
                        xxoxoooix3.xI(R.string.notification_light_screen);
                        xxoxoooix3.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$notificationLightScreenItem$2$1$1$1$1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                                return invoke(num.intValue());
                            }

                            @OXOo.OOXIXo
                            public final Boolean invoke(final int i) {
                                final DeviceFragment deviceFragment4 = DeviceFragment.this;
                                return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$notificationLightScreenItem$2$1$1$1$1.1
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
                                    public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                                        BleConnector.sendInt8$default(it2, BleKey.NOTIFICATION_LIGHT_SCREEN_SET, BleKeyFlag.UPDATE, i, false, false, 24, null);
                                        deviceFragment4.getNotificationLightScreenItem().initView();
                                    }
                                }, 1, null));
                            }
                        });
                        deviceFragment2.mNotificationLightScreenItem = xxoxoooix3;
                    }
                    xxoxoooix2 = DeviceFragment.this.mNotificationLightScreenItem;
                    if (xxoxoooix2 != null) {
                        DeviceFragment deviceFragment4 = DeviceFragment.this;
                        xxoxoooix2.IIX0o(BleCache.getInt$default(BleCache.INSTANCE, BleKey.NOTIFICATION_LIGHT_SCREEN_SET, 0, null, 6, null));
                        View rootView = deviceFragment4.getRootView();
                        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                        xxoxoooix2.OxxIIOOXO(rootView);
                    }
                }
            });
            return notificationLightScreenItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO timeFormatItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TimeFormatItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$timeFormatItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final TimeFormatItem invoke() {
            TimeFormatItem timeFormatItem = new TimeFormatItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            timeFormatItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$timeFormatItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix;
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    xxoxoooix = DeviceFragment.this.mTimeFormatPopup;
                    if (xxoxoooix == null) {
                        DeviceFragment deviceFragment2 = DeviceFragment.this;
                        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix3 = new com.sma.smartv3.pop.xxOXOOoIX(DeviceFragment.this.getMActivity(), R.array.time_format, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
                        final DeviceFragment deviceFragment3 = DeviceFragment.this;
                        xxoxoooix3.xI(R.string.time_format);
                        xxoxoooix3.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$timeFormatItem$2$1$1$1$1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                                return invoke(num.intValue());
                            }

                            @OXOo.OOXIXo
                            public final Boolean invoke(final int i) {
                                final DeviceFragment deviceFragment4 = DeviceFragment.this;
                                return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$timeFormatItem$2$1$1$1$1.1
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
                                    public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                                        BleConnector.sendInt8$default(it2, BleKey.HOUR_SYSTEM, BleKeyFlag.UPDATE, i, false, false, 24, null);
                                        deviceFragment4.getTimeFormatItem().initView();
                                    }
                                }, 1, null));
                            }
                        });
                        deviceFragment2.mTimeFormatPopup = xxoxoooix3;
                    }
                    xxoxoooix2 = DeviceFragment.this.mTimeFormatPopup;
                    if (xxoxoooix2 != null) {
                        DeviceFragment deviceFragment4 = DeviceFragment.this;
                        xxoxoooix2.IIX0o(BleCache.getInt$default(BleCache.INSTANCE, BleKey.HOUR_SYSTEM, 0, null, 6, null));
                        View rootView = deviceFragment4.getRootView();
                        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                        xxoxoooix2.OxxIIOOXO(rootView);
                    }
                }
            });
            return timeFormatItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO dateFormatItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DateFormatItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$dateFormatItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final DateFormatItem invoke() {
            DateFormatItem dateFormatItem = new DateFormatItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            dateFormatItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$dateFormatItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix;
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    xxoxoooix = DeviceFragment.this.mDateFormatPopup;
                    if (xxoxoooix == null) {
                        DeviceFragment deviceFragment2 = DeviceFragment.this;
                        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix3 = new com.sma.smartv3.pop.xxOXOOoIX(DeviceFragment.this.getMActivity(), R.array.date_format, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
                        final DeviceFragment deviceFragment3 = DeviceFragment.this;
                        xxoxoooix3.xI(R.string.date_format);
                        xxoxoooix3.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$dateFormatItem$2$1$1$1$1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                                return invoke(num.intValue());
                            }

                            @OXOo.OOXIXo
                            public final Boolean invoke(final int i) {
                                final DeviceFragment deviceFragment4 = DeviceFragment.this;
                                return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$dateFormatItem$2$1$1$1$1.1
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
                                    public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                                        BleConnector.sendInt8$default(it2, BleKey.DATE_FORMAT, BleKeyFlag.UPDATE, i, false, false, 24, null);
                                        ProjectManager.f19822oIX0oI.XOxoX(DateTimeFormat.Companion.oIX0oI(i));
                                        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24594OOXIxO0, null, 2, null);
                                        deviceFragment4.getDateFormatItem().initView();
                                    }
                                }, 1, null));
                            }
                        });
                        deviceFragment2.mDateFormatPopup = xxoxoooix3;
                    }
                    xxoxoooix2 = DeviceFragment.this.mDateFormatPopup;
                    if (xxoxoooix2 != null) {
                        DeviceFragment deviceFragment4 = DeviceFragment.this;
                        xxoxoooix2.IIX0o(BleCache.getInt$default(BleCache.INSTANCE, BleKey.DATE_FORMAT, ProjectManager.f19822oIX0oI.x0XOIxOo().getType(), null, 4, null));
                        View rootView = deviceFragment4.getRootView();
                        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                        xxoxoooix2.OxxIIOOXO(rootView);
                    }
                }
            });
            return dateFormatItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO wearWayItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WearWayItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$wearWayItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final WearWayItem invoke() {
            WearWayItem wearWayItem = new WearWayItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            wearWayItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$wearWayItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix;
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    xxoxoooix = DeviceFragment.this.mWearWayPopup;
                    if (xxoxoooix == null) {
                        DeviceFragment deviceFragment2 = DeviceFragment.this;
                        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix3 = new com.sma.smartv3.pop.xxOXOOoIX(DeviceFragment.this.getMActivity(), R.array.wear_way, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
                        final DeviceFragment deviceFragment3 = DeviceFragment.this;
                        xxoxoooix3.xI(R.string.wear_way);
                        xxoxoooix3.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$wearWayItem$2$1$1$1$1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                                return invoke(num.intValue());
                            }

                            @OXOo.OOXIXo
                            public final Boolean invoke(final int i) {
                                final DeviceFragment deviceFragment4 = DeviceFragment.this;
                                return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$wearWayItem$2$1$1$1$1.1
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
                                    public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                                        BleConnector.sendInt8$default(it2, BleKey.WEAR_WAY, BleKeyFlag.UPDATE, i, false, false, 24, null);
                                        deviceFragment4.getWearWayItem().initView();
                                    }
                                }, 1, null));
                            }
                        });
                        deviceFragment2.mWearWayPopup = xxoxoooix3;
                    }
                    xxoxoooix2 = DeviceFragment.this.mWearWayPopup;
                    if (xxoxoooix2 != null) {
                        DeviceFragment deviceFragment4 = DeviceFragment.this;
                        xxoxoooix2.IIX0o(BleCache.getInt$default(BleCache.INSTANCE, BleKey.WEAR_WAY, 0, null, 6, null));
                        View rootView = deviceFragment4.getRootView();
                        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                        xxoxoooix2.OxxIIOOXO(rootView);
                    }
                }
            });
            return wearWayItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO incomingCallRingVibrationItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<IncomingCallRingVibrationItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$incomingCallRingVibrationItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final IncomingCallRingVibrationItem invoke() {
            IncomingCallRingVibrationItem incomingCallRingVibrationItem = new IncomingCallRingVibrationItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            incomingCallRingVibrationItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$incomingCallRingVibrationItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    if (ProjectManager.f19822oIX0oI.Oxx()) {
                        DeviceFragment.this.singleChoiceIncomingCallRing();
                    } else {
                        DeviceFragment.this.multiChoiceIncomingCallRing();
                    }
                }
            });
            return incomingCallRingVibrationItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO noDisturbItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<NoDisturbItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$noDisturbItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final NoDisturbItem invoke() {
            NoDisturbItem noDisturbItem = new NoDisturbItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            noDisturbItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$noDisturbItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix;
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    if (!ProductManager.f20544oIX0oI.XoOOx0IX()) {
                        xxoxoooix = DeviceFragment.this.mNoDisturbPopup;
                        if (xxoxoooix == null) {
                            DeviceFragment deviceFragment2 = DeviceFragment.this;
                            com.sma.smartv3.pop.xxOXOOoIX xxoxoooix3 = new com.sma.smartv3.pop.xxOXOOoIX(DeviceFragment.this.getMActivity(), R.array.enable, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
                            final DeviceFragment deviceFragment3 = DeviceFragment.this;
                            xxoxoooix3.xI(R.string.do_not_disturb);
                            xxoxoooix3.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$noDisturbItem$2$1$1$1$1
                                {
                                    super(1);
                                }

                                @Override // Oox.oOoXoXO
                                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                                    return invoke(num.intValue());
                                }

                                @OXOo.OOXIXo
                                public final Boolean invoke(final int i) {
                                    final DeviceFragment deviceFragment4 = DeviceFragment.this;
                                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$noDisturbItem$2$1$1$1$1.1
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
                                        public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                                            BleCache bleCache = BleCache.INSTANCE;
                                            BleKey bleKey = BleKey.NO_DISTURB_RANGE;
                                            BleNoDisturbSettings bleNoDisturbSettings = (BleNoDisturbSettings) BleCache.getObjectNotNull$default(bleCache, bleKey, BleNoDisturbSettings.class, null, null, 12, null);
                                            bleNoDisturbSettings.getMBleTimeRange1().setMEnabled(i);
                                            BleConnector.sendObject$default(it2, bleKey, BleKeyFlag.UPDATE, bleNoDisturbSettings, false, false, 24, null);
                                            deviceFragment4.getNoDisturbItem().initView();
                                        }
                                    }, 1, null));
                                }
                            });
                            deviceFragment2.mNoDisturbPopup = xxoxoooix3;
                        }
                        xxoxoooix2 = DeviceFragment.this.mNoDisturbPopup;
                        if (xxoxoooix2 != null) {
                            DeviceFragment deviceFragment4 = DeviceFragment.this;
                            xxoxoooix2.IIX0o(((BleNoDisturbSettings) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.NO_DISTURB_RANGE, BleNoDisturbSettings.class, null, null, 12, null)).getMBleTimeRange1().getMEnabled());
                            View rootView = deviceFragment4.getRootView();
                            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                            xxoxoooix2.OxxIIOOXO(rootView);
                            return;
                        }
                        return;
                    }
                    DeviceFragment deviceFragment5 = DeviceFragment.this;
                    deviceFragment5.startActivity(new Intent(deviceFragment5.getActivity(), (Class<?>) NoDisturbSettingsActivity.class));
                }
            });
            return noDisturbItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO noDisturb2Item$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<NoDisturb2Item>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$noDisturb2Item$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final NoDisturb2Item invoke() {
            NoDisturb2Item noDisturb2Item = new NoDisturb2Item();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            noDisturb2Item.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$noDisturb2Item$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) NoDisturbSettings2Activity.class));
                }
            });
            return noDisturb2Item;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO doubleClickScreenItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DoubleClickScreenItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$doubleClickScreenItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final DoubleClickScreenItem invoke() {
            DoubleClickScreenItem doubleClickScreenItem = new DoubleClickScreenItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            doubleClickScreenItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$doubleClickScreenItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) DoubleClickSettingsActivity.class));
                }
            });
            return doubleClickScreenItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO incomingCallRingItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<IncomingCallRingItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$incomingCallRingItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final IncomingCallRingItem invoke() {
            IncomingCallRingItem incomingCallRingItem = new IncomingCallRingItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            incomingCallRingItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$incomingCallRingItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix;
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    xxoxoooix = DeviceFragment.this.mIncomingCallRingtPopup;
                    if (xxoxoooix == null) {
                        DeviceFragment deviceFragment2 = DeviceFragment.this;
                        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix3 = new com.sma.smartv3.pop.xxOXOOoIX(DeviceFragment.this.getMActivity(), R.array.enable, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
                        final DeviceFragment deviceFragment3 = DeviceFragment.this;
                        xxoxoooix3.xI(R.string.incoming_call_ring);
                        xxoxoooix3.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$incomingCallRingItem$2$1$1$1$1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                                return invoke(num.intValue());
                            }

                            @OXOo.OOXIXo
                            public final Boolean invoke(final int i) {
                                final DeviceFragment deviceFragment4 = DeviceFragment.this;
                                return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$incomingCallRingItem$2$1$1$1$1.1
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
                                    public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                                        BleConnector.sendInt8$default(it2, BleKey.INCOMING_CALL_RING, BleKeyFlag.UPDATE, i, false, false, 24, null);
                                        deviceFragment4.getIncomingCallRingItem().initView();
                                    }
                                }, 1, null));
                            }
                        });
                        deviceFragment2.mIncomingCallRingtPopup = xxoxoooix3;
                    }
                    xxoxoooix2 = DeviceFragment.this.mIncomingCallRingtPopup;
                    if (xxoxoooix2 != null) {
                        DeviceFragment deviceFragment4 = DeviceFragment.this;
                        xxoxoooix2.IIX0o(BleCache.getInt$default(BleCache.INSTANCE, BleKey.INCOMING_CALL_RING, 0, null, 6, null));
                        View rootView = deviceFragment4.getRootView();
                        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                        xxoxoooix2.OxxIIOOXO(rootView);
                    }
                }
            });
            return incomingCallRingItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO alarmClockItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AlarmClockItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$alarmClockItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final AlarmClockItem invoke() {
            AlarmClockItem alarmClockItem = new AlarmClockItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            alarmClockItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$alarmClockItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) AlarmsActivity.class));
                }
            });
            return alarmClockItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO nfcGuideItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<NFCGuideItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$nfcGuideItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final NFCGuideItem invoke() {
            NFCGuideItem nFCGuideItem = new NFCGuideItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            nFCGuideItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$nfcGuideItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) GuideNfcActivity.class));
                }
            });
            return nFCGuideItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO gameTimeSetItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<GameTimeSetItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$gameTimeSetItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final GameTimeSetItem invoke() {
            GameTimeSetItem gameTimeSetItem = new GameTimeSetItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            gameTimeSetItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$gameTimeSetItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix;
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2;
                    String string;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    xxoxoooix = DeviceFragment.this.mGameTimeSetPopup;
                    int i = 7;
                    if (xxoxoooix == null) {
                        DeviceFragment deviceFragment2 = DeviceFragment.this;
                        Activity mActivity = deviceFragment2.getMActivity();
                        DeviceFragment deviceFragment3 = DeviceFragment.this;
                        ArrayList arrayList = new ArrayList(8);
                        for (int i2 = 0; i2 < 8; i2++) {
                            if (i2 == 0) {
                                string = deviceFragment3.getMActivity().getString(R.string.off);
                            } else if (i2 != 7) {
                                string = deviceFragment3.getMActivity().getString(R.string.d_minutes, Integer.valueOf(i2 * 10));
                            } else {
                                string = deviceFragment3.getMActivity().getString(R.string.d_minutes, 120);
                            }
                            kotlin.jvm.internal.IIX0o.ooOOo0oXI(string);
                            arrayList.add(string);
                        }
                        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix3 = new com.sma.smartv3.pop.xxOXOOoIX(mActivity, arrayList, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
                        final DeviceFragment deviceFragment4 = DeviceFragment.this;
                        xxoxoooix3.xI(R.string.game_time_set);
                        xxoxoooix3.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$gameTimeSetItem$2$1$1$2$1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                                return invoke(num.intValue());
                            }

                            @OXOo.OOXIXo
                            public final Boolean invoke(final int i3) {
                                final DeviceFragment deviceFragment5 = DeviceFragment.this;
                                return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$gameTimeSetItem$2$1$1$2$1.1
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
                                    public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                                        BleCache bleCache = BleCache.INSTANCE;
                                        BleKey bleKey = BleKey.GAME_TIME_REMINDER;
                                        BleGameTimeReminder bleGameTimeReminder = (BleGameTimeReminder) BleCache.getObjectNotNull$default(bleCache, bleKey, BleGameTimeReminder.class, null, null, 12, null);
                                        int i4 = i3;
                                        if (i4 == 0) {
                                            bleGameTimeReminder.setMEnabled(0);
                                        } else if (i4 != 7) {
                                            bleGameTimeReminder.setMEnabled(1);
                                            bleGameTimeReminder.setMMinute(i3 * 10);
                                        } else {
                                            bleGameTimeReminder.setMEnabled(1);
                                            bleGameTimeReminder.setMMinute(120);
                                        }
                                        BleConnector.sendObject$default(it2, bleKey, BleKeyFlag.UPDATE, bleGameTimeReminder, false, false, 24, null);
                                        deviceFragment5.getGameTimeSetItem().initView();
                                    }
                                }, 1, null));
                            }
                        });
                        deviceFragment2.mGameTimeSetPopup = xxoxoooix3;
                    }
                    xxoxoooix2 = DeviceFragment.this.mGameTimeSetPopup;
                    if (xxoxoooix2 != null) {
                        DeviceFragment deviceFragment5 = DeviceFragment.this;
                        BleGameTimeReminder bleGameTimeReminder = (BleGameTimeReminder) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.GAME_TIME_REMINDER, BleGameTimeReminder.class, null, null, 12, null);
                        if (bleGameTimeReminder.getMEnabled() == 0) {
                            i = 0;
                        } else if (bleGameTimeReminder.getMMinute() != 120) {
                            i = bleGameTimeReminder.getMMinute() / 10;
                        }
                        xxoxoooix2.IIX0o(i);
                        View rootView = deviceFragment5.getRootView();
                        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                        xxoxoooix2.OxxIIOOXO(rootView);
                    }
                }
            });
            return gameTimeSetItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO medicationAlarmItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<MedicationAlarmItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$medicationAlarmItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final MedicationAlarmItem invoke() {
            MedicationAlarmItem medicationAlarmItem = new MedicationAlarmItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            medicationAlarmItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$medicationAlarmItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) MedicationAlarmsActivity.class));
                }
            });
            return medicationAlarmItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO sedentarinessItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SedentarinessItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$sedentarinessItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final SedentarinessItem invoke() {
            SedentarinessItem sedentarinessItem = new SedentarinessItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            sedentarinessItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$sedentarinessItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) SedentarinessSettingsActivity.class));
                }
            });
            return sedentarinessItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO findWatchItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<FindWatchItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$findWatchItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final FindWatchItem invoke() {
            FindWatchItem findWatchItem = new FindWatchItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            findWatchItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$findWatchItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    final DeviceFragment deviceFragment2 = DeviceFragment.this;
                    com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$findWatchItem$2$1$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                            invoke2(bleConnector);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                            BleConnector.sendInt8$default(BleConnector.INSTANCE, BleKey.FIND_WATCH, BleKeyFlag.UPDATE, 1, false, false, 24, null);
                            ToastUtils.showLong(DeviceFragment.this.getString(R.string.find_watch_on), new Object[0]);
                        }
                    }, 1, null);
                }
            });
            return findWatchItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO drinkWaterItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DrinkWaterItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$drinkWaterItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final DrinkWaterItem invoke() {
            DrinkWaterItem drinkWaterItem = new DrinkWaterItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            drinkWaterItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$drinkWaterItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) DrinkWaterSettingsActivity.class));
                }
            });
            return drinkWaterItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO bloodOxyGenItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<BloodOxyGenItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$bloodOxyGenItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final BloodOxyGenItem invoke() {
            BloodOxyGenItem bloodOxyGenItem = new BloodOxyGenItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            bloodOxyGenItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$bloodOxyGenItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) BloodOxyGenSettingsActivity.class));
                }
            });
            return bloodOxyGenItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO relaxReminderItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelaxReminderItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$relaxReminderItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final RelaxReminderItem invoke() {
            RelaxReminderItem relaxReminderItem = new RelaxReminderItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            relaxReminderItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$relaxReminderItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) RelaxReminderSettingsActivity.class));
                }
            });
            return relaxReminderItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO resetItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ResetItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$resetItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final ResetItem invoke() {
            ResetItem resetItem = new ResetItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            resetItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$resetItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    final DeviceFragment deviceFragment2 = DeviceFragment.this;
                    com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$resetItem$2$1$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                            invoke2(bleConnector);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(DeviceFragment.this.getMActivity(), 0, 2, null);
                            xoI0Ixx0.x0xO0oo(false);
                            xoI0Ixx0.IoOoX(R.string.device_reset_title);
                            xoI0Ixx0.xI(Integer.valueOf(R.string.device_reset_tip));
                            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
                            xoI0Ixx0.x0o(R.string.confirm, DeviceFragment$resetItem$2$1$1$1$1$1.INSTANCE);
                            xoI0Ixx0.IIXOooo();
                        }
                    }, 1, null);
                }
            });
            return resetItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO shutdownItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ShutdownItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$shutdownItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final ShutdownItem invoke() {
            ShutdownItem shutdownItem = new ShutdownItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            shutdownItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$shutdownItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    final DeviceFragment deviceFragment2 = DeviceFragment.this;
                    com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$shutdownItem$2$1$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                            invoke2(bleConnector);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(DeviceFragment.this.getMActivity(), 0, 2, null);
                            xoI0Ixx0.x0xO0oo(false);
                            xoI0Ixx0.IoOoX(R.string.device_shutdown_title);
                            xoI0Ixx0.xI(Integer.valueOf(R.string.device_shutdown_tip));
                            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
                            xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$shutdownItem$2$1$1$1$1$1
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
                    }, 1, null);
                }
            });
            return shutdownItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO pressureItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PressureItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$pressureItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final PressureItem invoke() {
            PressureItem pressureItem = new PressureItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            pressureItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$pressureItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) PressureSettingsActivity.class));
                }
            });
            return pressureItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO standbyWatchFaceItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<StandbyWatchFaceItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$standbyWatchFaceItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final StandbyWatchFaceItem invoke() {
            StandbyWatchFaceItem standbyWatchFaceItem = new StandbyWatchFaceItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            standbyWatchFaceItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$standbyWatchFaceItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) StandbyWatchFaceSettingsActivity.class));
                }
            });
            return standbyWatchFaceItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO washItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WashItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$washItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final WashItem invoke() {
            WashItem washItem = new WashItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            washItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$washItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) WashSettingsActivity.class));
                }
            });
            return washItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO gameSettingsItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<GameSettingsItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$gameSettingsItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final GameSettingsItem invoke() {
            GameSettingsItem gameSettingsItem = new GameSettingsItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            gameSettingsItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$gameSettingsItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) GameSettingsActivity.class));
                }
            });
            return gameSettingsItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO measureUnitItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<MeasureUnitItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$measureUnitItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final MeasureUnitItem invoke() {
            MeasureUnitItem measureUnitItem = new MeasureUnitItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            measureUnitItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$measureUnitItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) MeasureUnitSettingsActivity.class));
                }
            });
            return measureUnitItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO shockItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ShockItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$shockItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final ShockItem invoke() {
            ShockItem shockItem = new ShockItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            shockItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$shockItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix;
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    xxoxoooix = DeviceFragment.this.mShockPopup;
                    if (xxoxoooix == null) {
                        DeviceFragment deviceFragment2 = DeviceFragment.this;
                        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix3 = new com.sma.smartv3.pop.xxOXOOoIX(DeviceFragment.this.getMActivity(), R.array.vibration_times, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
                        final DeviceFragment deviceFragment3 = DeviceFragment.this;
                        xxoxoooix3.xI(ProductManager.f20544oIX0oI.OooI());
                        xxoxoooix3.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$shockItem$2$1$1$1$1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                                return invoke(num.intValue());
                            }

                            @OXOo.OOXIXo
                            public final Boolean invoke(final int i) {
                                final DeviceFragment deviceFragment4 = DeviceFragment.this;
                                return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$shockItem$2$1$1$1$1.1
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
                                    public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                                        BleConnector.sendInt8$default(it2, BleKey.VIBRATION, BleKeyFlag.UPDATE, i, false, false, 24, null);
                                        deviceFragment4.getShockItem().initView();
                                    }
                                }, 1, null));
                            }
                        });
                        deviceFragment2.mShockPopup = xxoxoooix3;
                    }
                    xxoxoooix2 = DeviceFragment.this.mShockPopup;
                    if (xxoxoooix2 != null) {
                        DeviceFragment deviceFragment4 = DeviceFragment.this;
                        int int$default = BleCache.getInt$default(BleCache.INSTANCE, BleKey.VIBRATION, 0, null, 6, null);
                        if (int$default > 3) {
                            int$default = 3;
                        }
                        xxoxoooix2.IIX0o(int$default);
                        View rootView = deviceFragment4.getRootView();
                        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                        xxoxoooix2.OxxIIOOXO(rootView);
                    }
                }
            });
            return shockItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO shockSettingsItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ShockSettingsItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$shockSettingsItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final ShockSettingsItem invoke() {
            ShockSettingsItem shockSettingsItem = new ShockSettingsItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            shockSettingsItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$shockSettingsItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) ShockSettingsActivity.class));
                }
            });
            return shockSettingsItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO backLightItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<BacklightItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$backLightItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final BacklightItem invoke() {
            BacklightItem backlightItem = new BacklightItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            backlightItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$backLightItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* JADX WARN: Code restructure failed: missing block: B:50:0x0102, code lost:
                
                    if (r6 != 15) goto L70;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:53:0x0109, code lost:
                
                    if (r6 != 10) goto L70;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:55:0x010e, code lost:
                
                    if (r6 != 15) goto L43;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:58:0x0115, code lost:
                
                    if (r6 != 10) goto L70;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:63:0x0122, code lost:
                
                    if (r6 != 10) goto L35;
                 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void invoke2(@OXOo.OOXIXo android.view.View r15) {
                    /*
                        Method dump skipped, instructions count: 312
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.DeviceFragment$backLightItem$2$1$1.invoke2(android.view.View):void");
                }
            });
            return backlightItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO gestureWakeItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<GestureWakeItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$gestureWakeItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final GestureWakeItem invoke() {
            GestureWakeItem gestureWakeItem = new GestureWakeItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            gestureWakeItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$gestureWakeItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) GestureWakeSettingsActivity.class));
                }
            });
            return gestureWakeItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO gestureWake2Item$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<GestureWake2Item>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$gestureWake2Item$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final GestureWake2Item invoke() {
            GestureWake2Item gestureWake2Item = new GestureWake2Item();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            gestureWake2Item.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$gestureWake2Item$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) GestureWake2SettingsActivity.class));
                }
            });
            return gestureWake2Item;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO hrMonitoringItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<HrMonitoringItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$hrMonitoringItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final HrMonitoringItem invoke() {
            HrMonitoringItem hrMonitoringItem = new HrMonitoringItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            hrMonitoringItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$hrMonitoringItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) HrMonitoringSettingsActivity.class));
                }
            });
            return hrMonitoringItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ecgMonitoringItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EcgMonitoringItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$ecgMonitoringItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final EcgMonitoringItem invoke() {
            EcgMonitoringItem ecgMonitoringItem = new EcgMonitoringItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            ecgMonitoringItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$ecgMonitoringItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) EcgMonitoringSettingsActivity.class));
                }
            });
            return ecgMonitoringItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tempMonitoringItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TempMonitoringItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$tempMonitoringItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final TempMonitoringItem invoke() {
            TempMonitoringItem tempMonitoringItem = new TempMonitoringItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            tempMonitoringItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$tempMonitoringItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) TempMonitoringSettingsActivity.class));
                }
            });
            return tempMonitoringItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO girlCareItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<HealthCareItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$girlCareItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final HealthCareItem invoke() {
            HealthCareItem healthCareItem = new HealthCareItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            healthCareItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$girlCareItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) HealthCareSettingsActivity.class));
                }
            });
            return healthCareItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO remoteCameraItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RemoteCameraItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$remoteCameraItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final RemoteCameraItem invoke() {
            RemoteCameraItem remoteCameraItem = new RemoteCameraItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            remoteCameraItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$remoteCameraItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    final DeviceFragment deviceFragment2 = DeviceFragment.this;
                    com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$remoteCameraItem$2$1$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                            invoke2(bleConnector);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                            DeviceFragment deviceFragment3 = DeviceFragment.this;
                            Bundle bundle = new Bundle();
                            bundle.putString("mArg0", null);
                            bundle.putInt("mArg1", 1);
                            bundle.putParcelable("mArg2", null);
                            bundle.putSerializable("mArg3", null);
                            Intent intent = new Intent(deviceFragment3.getActivity(), (Class<?>) CameraActivity.class);
                            intent.putExtras(bundle);
                            deviceFragment3.startActivity(intent);
                        }
                    }, 1, null);
                }
            });
            return remoteCameraItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO languageItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LanguageItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$languageItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final LanguageItem invoke() {
            LanguageItem languageItem = new LanguageItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            languageItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$languageItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    final DeviceFragment deviceFragment2 = DeviceFragment.this;
                    com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$languageItem$2$1$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                            invoke2(bleConnector);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                            DeviceFragment deviceFragment3 = DeviceFragment.this;
                            Bundle bundle = new Bundle();
                            bundle.putString("mArg0", null);
                            bundle.putInt("mArg1", R.string.watch_language_set);
                            bundle.putParcelable("mArg2", null);
                            bundle.putSerializable("mArg3", null);
                            Intent intent = new Intent(deviceFragment3.getActivity(), (Class<?>) LanguageListActivity.class);
                            intent.putExtras(bundle);
                            deviceFragment3.startActivity(intent);
                        }
                    }, 1, null);
                }
            });
            return languageItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO touchSetItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TouchSetItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$touchSetItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final TouchSetItem invoke() {
            TouchSetItem touchSetItem = new TouchSetItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            touchSetItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$touchSetItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) TouchSettingsActivity.class));
                }
            });
            return touchSetItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO firmwareItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<FirmwareItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$firmwareItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final FirmwareItem invoke() {
            FirmwareItem firmwareItem = new FirmwareItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            firmwareItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$firmwareItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    final DeviceFragment deviceFragment2 = DeviceFragment.this;
                    com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$firmwareItem$2$1$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                            invoke2(bleConnector);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                            long j;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                            if (com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().getInt(com.sma.smartv3.util.XoI0Ixx0.f24396Oo, 0) >= 50) {
                                long currentTimeMillis = System.currentTimeMillis();
                                j = DeviceFragment.this.lastClickTime;
                                if (currentTimeMillis - j >= 3000) {
                                    DeviceFragment.this.checkVersionByClickFirmware();
                                    DeviceFragment.this.lastClickTime = System.currentTimeMillis();
                                    return;
                                }
                                return;
                            }
                            ToastUtils.showLong(R.string.firmware_upgrade_tip_toast);
                        }
                    }, 1, null);
                }
            });
            return firmwareItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO aGPSUpgradeItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AGPSUpgradeItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$aGPSUpgradeItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final AGPSUpgradeItem invoke() {
            AGPSUpgradeItem aGPSUpgradeItem = new AGPSUpgradeItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            aGPSUpgradeItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$aGPSUpgradeItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    final DeviceFragment deviceFragment2 = DeviceFragment.this;
                    com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$aGPSUpgradeItem$2$1$1.1

                        @kotlin.jvm.internal.XX({"SMAP\nDeviceFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceFragment.kt\ncom/sma/smartv3/ui/device/DeviceFragment$aGPSUpgradeItem$2$1$1$1$1\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2652:1\n78#2,3:2653\n81#2,5:2657\n1#3:2656\n*S KotlinDebug\n*F\n+ 1 DeviceFragment.kt\ncom/sma/smartv3/ui/device/DeviceFragment$aGPSUpgradeItem$2$1$1$1$1\n*L\n1217#1:2653,3\n1217#1:2657,5\n1217#1:2656\n*E\n"})
                        /* renamed from: com.sma.smartv3.ui.device.DeviceFragment$aGPSUpgradeItem$2$1$1$1$oIX0oI */
                        /* loaded from: classes12.dex */
                        public static final class oIX0oI implements com.sma.smartv3.biz.II0XooXoX<ExtraPackageData> {

                            /* renamed from: oIX0oI, reason: collision with root package name */
                            public final /* synthetic */ DeviceFragment f21757oIX0oI;

                            public oIX0oI(DeviceFragment deviceFragment) {
                                this.f21757oIX0oI = deviceFragment;
                            }

                            @Override // com.sma.smartv3.biz.II0XooXoX
                            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                            public void onSuccess(@OXOo.oOoXoXO ExtraPackageData extraPackageData) {
                                DeviceFragment deviceFragment = this.f21757oIX0oI;
                                deviceFragment.startActivity(new Intent(deviceFragment.getActivity(), (Class<?>) FirmwareUpgradeGPSActivity.class));
                            }

                            @Override // com.sma.smartv3.biz.II0XooXoX
                            public void onFailure(@OXOo.OOXIXo String error) {
                                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                                this.f21757oIX0oI.toSyncAGPS();
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
                        public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                            if (!ProductManager.f20544oIX0oI.Xxx0oXX()) {
                                DeviceFragment.this.toSyncAGPS();
                            } else {
                                DeviceInfoChecker.f19983oIX0oI.Oxx0IOOO(new oIX0oI(DeviceFragment.this), DeviceFragment.this.getMActivity(), DeviceFragment.this.getRootView(), "A");
                            }
                        }
                    }, 1, null);
                }
            });
            return aGPSUpgradeItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO syncContactItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SyncContactItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$syncContactItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final SyncContactItem invoke() {
            SyncContactItem syncContactItem = new SyncContactItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            syncContactItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$syncContactItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    PermissionUtils permission = PermissionUtils.permission(PermissionConstants.CONTACTS);
                    kotlin.jvm.internal.IIX0o.oO(permission, "permission(...)");
                    final DeviceFragment deviceFragment2 = DeviceFragment.this;
                    oOXoIIIo.X0o0xo.I0Io(permission, null, null, new Oox.oOoXoXO<PermissionStatus, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$syncContactItem$2$1$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                            invoke2(permissionStatus);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo PermissionStatus it2) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                            if (it2 != PermissionStatus.GRANTED) {
                                DeviceFragment.this.noPermissionRemind();
                            } else if (ProductManager.f20544oIX0oI.oXoXxOo()) {
                                DeviceFragment deviceFragment3 = DeviceFragment.this;
                                deviceFragment3.startActivity(new Intent(deviceFragment3.getActivity(), (Class<?>) ContactListV2Activity.class));
                            } else {
                                DeviceFragment deviceFragment4 = DeviceFragment.this;
                                deviceFragment4.startActivity(new Intent(deviceFragment4.getActivity(), (Class<?>) ContactListActivity.class));
                            }
                        }
                    }, 3, null);
                }
            });
            return syncContactItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO macQrcodeItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<MacQrcodeItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$macQrcodeItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final MacQrcodeItem invoke() {
            MacQrcodeItem macQrcodeItem = new MacQrcodeItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            macQrcodeItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$macQrcodeItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix;
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    xxoxoooix = DeviceFragment.this.mMacQrcodePopup;
                    if (xxoxoooix == null) {
                        DeviceFragment deviceFragment2 = DeviceFragment.this;
                        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix3 = new com.sma.smartv3.pop.xxOXOOoIX(DeviceFragment.this.getMActivity(), R.array.mac_qrcodes, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
                        final DeviceFragment deviceFragment3 = DeviceFragment.this;
                        xxoxoooix3.xI(R.string.mac_qrcode);
                        xxoxoooix3.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$macQrcodeItem$2$1$1$1$1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                                return invoke(num.intValue());
                            }

                            @OXOo.OOXIXo
                            public final Boolean invoke(int i) {
                                BleConnector.sendInt8$default(BleConnector.INSTANCE, BleKey.MAC_QRCODE, BleKeyFlag.UPDATE, i + 1, false, false, 24, null);
                                DeviceFragment.this.getMacQrcodeItem().initView();
                                return Boolean.TRUE;
                            }
                        });
                        deviceFragment2.mMacQrcodePopup = xxoxoooix3;
                    }
                    xxoxoooix2 = DeviceFragment.this.mMacQrcodePopup;
                    if (xxoxoooix2 != null) {
                        DeviceFragment deviceFragment4 = DeviceFragment.this;
                        xxoxoooix2.IIX0o(BleCache.getInt$default(BleCache.INSTANCE, BleKey.MAC_QRCODE, 1, null, 4, null) - 1);
                        View rootView = deviceFragment4.getRootView();
                        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                        xxoxoooix2.OxxIIOOXO(rootView);
                    }
                }
            });
            return macQrcodeItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO standbySetItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<StandbySetItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$standbySetItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final StandbySetItem invoke() {
            StandbySetItem standbySetItem = new StandbySetItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            standbySetItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$standbySetItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix;
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    xxoxoooix = DeviceFragment.this.mStandbySetPopup;
                    if (xxoxoooix == null) {
                        DeviceFragment deviceFragment2 = DeviceFragment.this;
                        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix3 = new com.sma.smartv3.pop.xxOXOOoIX(DeviceFragment.this.getMActivity(), R.array.enable, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
                        final DeviceFragment deviceFragment3 = DeviceFragment.this;
                        xxoxoooix3.xI(R.string.standby_set);
                        xxoxoooix3.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$standbySetItem$2$1$1$1$1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                                return invoke(num.intValue());
                            }

                            @OXOo.OOXIXo
                            public final Boolean invoke(final int i) {
                                final DeviceFragment deviceFragment4 = DeviceFragment.this;
                                return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$standbySetItem$2$1$1$1$1.1
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
                                    public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                                        BleConnector.sendInt8$default(it2, BleKey.STANDBY_SET, BleKeyFlag.UPDATE, i, false, false, 24, null);
                                        deviceFragment4.getStandbySetItem().initView();
                                    }
                                }, 1, null));
                            }
                        });
                        deviceFragment2.mStandbySetPopup = xxoxoooix3;
                    }
                    xxoxoooix2 = DeviceFragment.this.mStandbySetPopup;
                    if (xxoxoooix2 != null) {
                        DeviceFragment deviceFragment4 = DeviceFragment.this;
                        xxoxoooix2.IIX0o(BleCache.getInt$default(BleCache.INSTANCE, BleKey.STANDBY_SET, 0, null, 6, null));
                        View rootView = deviceFragment4.getRootView();
                        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                        xxoxoooix2.OxxIIOOXO(rootView);
                    }
                }
            });
            return standbySetItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO watchPasswordItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WatchPasswordItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$watchPasswordItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final WatchPasswordItem invoke() {
            WatchPasswordItem watchPasswordItem = new WatchPasswordItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            watchPasswordItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$watchPasswordItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) WatchPasswordActivity.class));
                }
            });
            return watchPasswordItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO nucleicAcidCodeItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<NucleicAcidCodeItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$nucleicAcidCodeItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final NucleicAcidCodeItem invoke() {
            NucleicAcidCodeItem nucleicAcidCodeItem = new NucleicAcidCodeItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            nucleicAcidCodeItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$nucleicAcidCodeItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    String string = deviceFragment2.getString(R.string.nucleic_acid_code);
                    kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                    QrcodeTypeInfo qrcodeTypeInfo = new QrcodeTypeInfo(0, 0, 0, string, 0L, 0, null, 112, null);
                    Bundle bundle = new Bundle();
                    bundle.putString("mArg0", null);
                    bundle.putParcelable("mArg2", null);
                    bundle.putSerializable("mArg3", qrcodeTypeInfo);
                    Intent intent = new Intent(deviceFragment2.getActivity(), (Class<?>) QrcodeSyncActivity.class);
                    intent.putExtras(bundle);
                    deviceFragment2.startActivity(intent);
                }
            });
            return nucleicAcidCodeItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO myCardCodeItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<MyCardCodeItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$myCardCodeItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final MyCardCodeItem invoke() {
            MyCardCodeItem myCardCodeItem = new MyCardCodeItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            myCardCodeItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$myCardCodeItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    Bundle bundle = new Bundle();
                    bundle.putString("mArg0", null);
                    bundle.putInt("mArg1", 2);
                    bundle.putParcelable("mArg2", null);
                    bundle.putSerializable("mArg3", null);
                    Intent intent = new Intent(deviceFragment2.getActivity(), (Class<?>) QrcodeTypeInfosActivity.class);
                    intent.putExtras(bundle);
                    deviceFragment2.startActivity(intent);
                }
            });
            return myCardCodeItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO myCardCode2Item$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<MyCardCode2Item>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$myCardCode2Item$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final MyCardCode2Item invoke() {
            MyCardCode2Item myCardCode2Item = new MyCardCode2Item();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            myCardCode2Item.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$myCardCode2Item$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) MyCardCodeActivity.class));
                }
            });
            return myCardCode2Item;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO receiptCodeItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ReceiptCodeItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$receiptCodeItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final ReceiptCodeItem invoke() {
            ReceiptCodeItem receiptCodeItem = new ReceiptCodeItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            receiptCodeItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$receiptCodeItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    Bundle bundle = new Bundle();
                    bundle.putString("mArg0", null);
                    bundle.putInt("mArg1", 1);
                    bundle.putParcelable("mArg2", null);
                    bundle.putSerializable("mArg3", null);
                    Intent intent = new Intent(deviceFragment2.getActivity(), (Class<?>) QrcodeTypeInfosActivity.class);
                    intent.putExtras(bundle);
                    deviceFragment2.startActivity(intent);
                }
            });
            return receiptCodeItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO receiptCode2Item$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ReceiptCode2Item>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$receiptCode2Item$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final ReceiptCode2Item invoke() {
            ReceiptCode2Item receiptCode2Item = new ReceiptCode2Item();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            receiptCode2Item.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$receiptCode2Item$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) ReceiptCodeActivity.class));
                }
            });
            return receiptCode2Item;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO alipaySetItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AlipaySetItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$alipaySetItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final AlipaySetItem invoke() {
            AlipaySetItem alipaySetItem = new AlipaySetItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            alipaySetItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$alipaySetItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    final DeviceFragment deviceFragment2 = DeviceFragment.this;
                    com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$alipaySetItem$2$1$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                            invoke2(bleConnector);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                            DeviceFragment deviceFragment3 = DeviceFragment.this;
                            deviceFragment3.startActivity(new Intent(deviceFragment3.getActivity(), (Class<?>) AlipaySetActivity.class));
                        }
                    }, 1, null);
                }
            });
            return alipaySetItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO logoFileItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CustomLogoItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$logoFileItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final CustomLogoItem invoke() {
            CustomLogoItem customLogoItem = new CustomLogoItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            customLogoItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$logoFileItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    final DeviceFragment deviceFragment2 = DeviceFragment.this;
                    com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$logoFileItem$2$1$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                            invoke2(bleConnector);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                            DeviceFragment deviceFragment3 = DeviceFragment.this;
                            deviceFragment3.startActivity(new Intent(deviceFragment3.getActivity(), (Class<?>) CustomLogoActivity.class));
                        }
                    }, 1, null);
                }
            });
            return customLogoItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO unpairItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<UnpairItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$unpairItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final UnpairItem invoke() {
            UnpairItem unpairItem = new UnpairItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            unpairItem.setMOnUnbindListener(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$unpairItem$2$1$1
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
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(DeviceFragment.this.getMActivity(), 0, 2, null);
                    final DeviceFragment deviceFragment3 = DeviceFragment.this;
                    ProductManager productManager = ProductManager.f20544oIX0oI;
                    if (productManager.I0oOIX() && com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24419XO, false)) {
                        xoI0Ixx0.x0xO0oo(false);
                        xoI0Ixx0.IoOoX(R.string.unbind_tip_by_update_failed);
                        com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, null, null, 2, null);
                        xoI0Ixx0.x0o(R.string.firmware_repair, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$unpairItem$2$1$1$1$1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // Oox.oIX0oI
                            @OXOo.OOXIXo
                            public final Boolean invoke() {
                                com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24620XoX, null, 2, null);
                                return Boolean.TRUE;
                            }
                        });
                    } else {
                        xoI0Ixx0.IoOoX(productManager.OXXoIoXI() ? R.string.unbind_tip2 : R.string.unbind_tip);
                        com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
                        xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$unpairItem$2$1$1$1$2
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // Oox.oIX0oI
                            @OXOo.OOXIXo
                            public final Boolean invoke() {
                                DeviceFragment.this.whenUnbind();
                                return Boolean.TRUE;
                            }
                        });
                    }
                    deviceFragment2.setMUnbindPopup(xoI0Ixx0);
                    com.sma.smartv3.pop.XoI0Ixx0 mUnbindPopup = DeviceFragment.this.getMUnbindPopup();
                    if (mUnbindPopup != null) {
                        View rootView = DeviceFragment.this.getRootView();
                        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                        mUnbindPopup.OxxIIOOXO(rootView);
                    }
                }
            });
            return unpairItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO musicControlItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<MusicControlItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$musicControlItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final MusicControlItem invoke() {
            MusicControlItem musicControlItem = new MusicControlItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            musicControlItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$musicControlItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    BleConnector bleConnector = BleConnector.INSTANCE;
                    if (bleConnector.getMHidState() == 0) {
                        DeviceFragment.this.showHIDPopup();
                    }
                    BleConnector.sendData$default(bleConnector, BleKey.HID, BleKeyFlag.READ, null, false, false, 28, null);
                }
            });
            return musicControlItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO stockMarketItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<StockMarketItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$stockMarketItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final StockMarketItem invoke() {
            StockMarketItem stockMarketItem = new StockMarketItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            stockMarketItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$stockMarketItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
                    SPUtils XO2 = xo0.XO();
                    Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
                    Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
                    if (fromJson != null) {
                        appUser = fromJson;
                    }
                    AppUser appUser2 = (AppUser) appUser;
                    if (xo0.XO().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24363IO, true) && appUser2.getIdentity().length() > 0) {
                        DeviceFragment deviceFragment2 = DeviceFragment.this;
                        deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) StockMarketActivity.class));
                    } else {
                        DeviceFragment deviceFragment3 = DeviceFragment.this;
                        deviceFragment3.startActivity(new Intent(deviceFragment3.getActivity(), (Class<?>) LoginReminderActivity.class));
                    }
                }
            });
            return stockMarketItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO worldClockItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WorldClockItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$worldClockItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final WorldClockItem invoke() {
            WorldClockItem worldClockItem = new WorldClockItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            worldClockItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$worldClockItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) WorldClockActivity.class));
                }
            });
            return worldClockItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO navigationItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<NavigationItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$navigationItem$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final NavigationItem invoke() {
            NavigationItem navigationItem = new NavigationItem();
            navigationItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$navigationItem$2$1$1
                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24595OX00O0xII, null, 2, null);
                }
            });
            return navigationItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO voiceItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<VoiceItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$voiceItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final VoiceItem invoke() {
            VoiceItem voiceItem = new VoiceItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            voiceItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$voiceItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    ProductManager productManager = ProductManager.f20544oIX0oI;
                    if (!productManager.xIx0XO() && !productManager.oO0OX0() && TextUtils.isEmpty(productManager.I0Io()) && !productManager.XOx()) {
                        UtilsKt.XOxIOxOx(DeviceFragment.this.getMActivity());
                        return;
                    }
                    if (productManager.oo00()) {
                        VoiceManager voiceManager = VoiceManager.INSTANCE;
                        if (voiceManager.isExpired()) {
                            Activity mActivity = DeviceFragment.this.getMActivity();
                            View rootView = DeviceFragment.this.getRootView();
                            final DeviceFragment deviceFragment2 = DeviceFragment.this;
                            voiceManager.checkBaiduAuth(mActivity, rootView, new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$voiceItem$2$1$1.1
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
                                        DeviceFragment deviceFragment3 = DeviceFragment.this;
                                        deviceFragment3.startActivity(new Intent(deviceFragment3.getActivity(), (Class<?>) VoiceActivity.class));
                                    } else {
                                        DeviceFragment deviceFragment4 = DeviceFragment.this;
                                        deviceFragment4.startActivity(new Intent(deviceFragment4.getActivity(), (Class<?>) VoiceSetActivity.class));
                                    }
                                }
                            });
                            return;
                        }
                        DeviceFragment deviceFragment3 = DeviceFragment.this;
                        deviceFragment3.startActivity(new Intent(deviceFragment3.getActivity(), (Class<?>) VoiceActivity.class));
                        return;
                    }
                    DeviceFragment deviceFragment4 = DeviceFragment.this;
                    deviceFragment4.startActivity(new Intent(deviceFragment4.getActivity(), (Class<?>) VoiceActivity.class));
                }
            });
            return voiceItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO dialogueTranslation$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TranslationDialogueItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$dialogueTranslation$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final TranslationDialogueItem invoke() {
            TranslationDialogueItem translationDialogueItem = new TranslationDialogueItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            translationDialogueItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$dialogueTranslation$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    final DeviceFragment deviceFragment2 = DeviceFragment.this;
                    com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$dialogueTranslation$2$1$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                            invoke2(bleConnector);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                            DeviceFragment deviceFragment3 = DeviceFragment.this;
                            deviceFragment3.startActivity(new Intent(deviceFragment3.getActivity(), (Class<?>) DialogueTranslationActivity.class));
                        }
                    }, 1, null);
                }
            });
            return translationDialogueItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO simultaneousTranslation$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TranslationSimultaneousItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$simultaneousTranslation$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final TranslationSimultaneousItem invoke() {
            TranslationSimultaneousItem translationSimultaneousItem = new TranslationSimultaneousItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            translationSimultaneousItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$simultaneousTranslation$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    final DeviceFragment deviceFragment2 = DeviceFragment.this;
                    com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$simultaneousTranslation$2$1$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                            invoke2(bleConnector);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                            DeviceFragment deviceFragment3 = DeviceFragment.this;
                            deviceFragment3.startActivity(new Intent(deviceFragment3.getActivity(), (Class<?>) SimultaneousInterpretationActivity.class));
                        }
                    }, 1, null);
                }
            });
            return translationSimultaneousItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO musicManagerItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<MusicManagerItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$musicManagerItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final MusicManagerItem invoke() {
            MusicManagerItem musicManagerItem = new MusicManagerItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            musicManagerItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$musicManagerItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    final DeviceFragment deviceFragment2 = DeviceFragment.this;
                    com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$musicManagerItem$2$1$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                            invoke2(bleConnector);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                            DeviceFragment deviceFragment3 = DeviceFragment.this;
                            deviceFragment3.startActivity(new Intent(deviceFragment3.getActivity(), (Class<?>) MusicManagerV2Activity.class));
                        }
                    }, 1, null);
                }
            });
            return musicManagerItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ebookManagerItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EBookManagerItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$ebookManagerItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final EBookManagerItem invoke() {
            EBookManagerItem eBookManagerItem = new EBookManagerItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            eBookManagerItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$ebookManagerItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    final DeviceFragment deviceFragment2 = DeviceFragment.this;
                    com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$ebookManagerItem$2$1$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                            invoke2(bleConnector);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                            DeviceFragment deviceFragment3 = DeviceFragment.this;
                            deviceFragment3.startActivity(new Intent(deviceFragment3.getActivity(), (Class<?>) EBookManagerActivity.class));
                        }
                    }, 1, null);
                }
            });
            return eBookManagerItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO sosManagerItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SOSManagerItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$sosManagerItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final SOSManagerItem invoke() {
            SOSManagerItem sOSManagerItem = new SOSManagerItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            sOSManagerItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$sosManagerItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) SOSSettingsActivity.class));
                }
            });
            return sOSManagerItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO fallManagerItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<FallManagerItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$fallManagerItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final FallManagerItem invoke() {
            FallManagerItem fallManagerItem = new FallManagerItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            fallManagerItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$fallManagerItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix;
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    xxoxoooix = DeviceFragment.this.mAntiLostSetPopup;
                    if (xxoxoooix == null) {
                        DeviceFragment deviceFragment2 = DeviceFragment.this;
                        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix3 = new com.sma.smartv3.pop.xxOXOOoIX(DeviceFragment.this.getMActivity(), R.array.enable, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
                        final DeviceFragment deviceFragment3 = DeviceFragment.this;
                        xxoxoooix3.xI(R.string.fall_tips);
                        xxoxoooix3.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$fallManagerItem$2$1$1$1$1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                                return invoke(num.intValue());
                            }

                            @OXOo.OOXIXo
                            public final Boolean invoke(final int i) {
                                final DeviceFragment deviceFragment4 = DeviceFragment.this;
                                return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$fallManagerItem$2$1$1$1$1.1
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
                                    public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                                        BleConnector.sendInt8$default(it2, BleKey.FALL_SET, BleKeyFlag.UPDATE, i, false, false, 24, null);
                                        deviceFragment4.getFallManagerItem().initView();
                                    }
                                }, 1, null));
                            }
                        });
                        deviceFragment2.mAntiLostSetPopup = xxoxoooix3;
                    }
                    xxoxoooix2 = DeviceFragment.this.mAntiLostSetPopup;
                    if (xxoxoooix2 != null) {
                        DeviceFragment deviceFragment4 = DeviceFragment.this;
                        xxoxoooix2.IIX0o(BleCache.getInt$default(BleCache.INSTANCE, BleKey.FALL_SET, 0, null, 6, null));
                        View rootView = deviceFragment4.getRootView();
                        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                        xxoxoooix2.OxxIIOOXO(rootView);
                    }
                }
            });
            return fallManagerItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO memoryManagerItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<MemoryManagerItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$memoryManagerItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final MemoryManagerItem invoke() {
            MemoryManagerItem memoryManagerItem = new MemoryManagerItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            memoryManagerItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$memoryManagerItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) MemoryManagerActivity.class));
                }
            });
            return memoryManagerItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO smsQuickReplyItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SMSQuickReplyItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$smsQuickReplyItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final SMSQuickReplyItem invoke() {
            SMSQuickReplyItem sMSQuickReplyItem = new SMSQuickReplyItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            sMSQuickReplyItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$smsQuickReplyItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    PermissionUtils permission = PermissionUtils.permission(PermissionConstants.SMS);
                    kotlin.jvm.internal.IIX0o.oO(permission, "permission(...)");
                    final DeviceFragment deviceFragment2 = DeviceFragment.this;
                    oOXoIIIo.X0o0xo.I0Io(permission, null, null, new Oox.oOoXoXO<PermissionStatus, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$smsQuickReplyItem$2$1$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                            invoke2(permissionStatus);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo PermissionStatus it2) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                            if (it2 != PermissionStatus.GRANTED) {
                                DeviceFragment.this.noPermissionRemind();
                            } else {
                                final DeviceFragment deviceFragment3 = DeviceFragment.this;
                                com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment.smsQuickReplyItem.2.1.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // Oox.oOoXoXO
                                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                                        invoke2(bleConnector);
                                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@OXOo.OOXIXo BleConnector it3) {
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(it3, "it");
                                        DeviceFragment deviceFragment4 = DeviceFragment.this;
                                        deviceFragment4.startActivity(new Intent(deviceFragment4.getActivity(), (Class<?>) SMSQuickReplyActivity.class));
                                    }
                                }, 1, null);
                            }
                        }
                    }, 3, null);
                }
            });
            return sMSQuickReplyItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO powerSaveModeItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PowerSaveModeItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$powerSaveModeItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final PowerSaveModeItem invoke() {
            PowerSaveModeItem powerSaveModeItem = new PowerSaveModeItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            powerSaveModeItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$powerSaveModeItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix;
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    xxoxoooix = DeviceFragment.this.mPowerSaveModeSetPopup;
                    if (xxoxoooix == null) {
                        DeviceFragment deviceFragment2 = DeviceFragment.this;
                        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix3 = new com.sma.smartv3.pop.xxOXOOoIX(DeviceFragment.this.getMActivity(), R.array.enable, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
                        final DeviceFragment deviceFragment3 = DeviceFragment.this;
                        xxoxoooix3.xI(R.string.power_save_mode);
                        xxoxoooix3.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$powerSaveModeItem$2$1$1$1$1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                                return invoke(num.intValue());
                            }

                            @OXOo.OOXIXo
                            public final Boolean invoke(final int i) {
                                final DeviceFragment deviceFragment4 = DeviceFragment.this;
                                return Boolean.valueOf(com.sma.smartv3.ble.I0Io.oIX0oI(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$powerSaveModeItem$2$1$1$1$1.1
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
                                    public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                                        BleConnector.sendInt8$default(it2, BleKey.POWER_SAVE_MODE, BleKeyFlag.UPDATE, i, false, false, 24, null);
                                        deviceFragment4.getPowerSaveModeItem().initView();
                                    }
                                }));
                            }
                        });
                        deviceFragment2.mPowerSaveModeSetPopup = xxoxoooix3;
                    }
                    xxoxoooix2 = DeviceFragment.this.mPowerSaveModeSetPopup;
                    if (xxoxoooix2 != null) {
                        DeviceFragment deviceFragment4 = DeviceFragment.this;
                        xxoxoooix2.IIX0o(BleCache.getInt$default(BleCache.INSTANCE, BleKey.POWER_SAVE_MODE, 0, null, 6, null));
                        View rootView = deviceFragment4.getRootView();
                        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                        xxoxoooix2.OxxIIOOXO(rootView);
                    }
                }
            });
            return powerSaveModeItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO scheduleItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ScheduleItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$scheduleItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final ScheduleItem invoke() {
            ScheduleItem scheduleItem = new ScheduleItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            scheduleItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$scheduleItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) SchedulesActivity.class));
                }
            });
            return scheduleItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO recordingItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecordingItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$recordingItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final RecordingItem invoke() {
            RecordingItem recordingItem = new RecordingItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            recordingItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$recordingItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) RecordingListActivity.class));
                }
            });
            return recordingItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO hardWareAlipay$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<HardWareAlipayItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$hardWareAlipay$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final HardWareAlipayItem invoke() {
            HardWareAlipayItem hardWareAlipayItem = new HardWareAlipayItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            hardWareAlipayItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$hardWareAlipay$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) HardWareAlipayActivity.class));
                }
            });
            return hardWareAlipayItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO appStoreItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AppStoreItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$appStoreItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final AppStoreItem invoke() {
            AppStoreItem appStoreItem = new AppStoreItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            appStoreItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$appStoreItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) AppStoreActivity.class));
                }
            });
            return appStoreItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO audioBookLearnItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AudioBookLearnItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$audioBookLearnItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final AudioBookLearnItem invoke() {
            AudioBookLearnItem audioBookLearnItem = new AudioBookLearnItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            audioBookLearnItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$audioBookLearnItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    Bundle bundle = new Bundle();
                    bundle.putString("mArg0", null);
                    bundle.putInt("mArg1", 0);
                    bundle.putParcelable("mArg2", null);
                    bundle.putSerializable("mArg3", null);
                    Intent intent = new Intent(deviceFragment2.getActivity(), (Class<?>) AudioBookLearnActivity.class);
                    intent.putExtras(bundle);
                    deviceFragment2.startActivity(intent);
                }
            });
            return audioBookLearnItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO learnCardItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LearnCardItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$learnCardItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final LearnCardItem invoke() {
            LearnCardItem learnCardItem = new LearnCardItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            learnCardItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$learnCardItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    Bundle bundle = new Bundle();
                    bundle.putString("mArg0", null);
                    bundle.putInt("mArg1", 1);
                    bundle.putParcelable("mArg2", null);
                    bundle.putSerializable("mArg3", null);
                    Intent intent = new Intent(deviceFragment2.getActivity(), (Class<?>) AudioBookLearnActivity.class);
                    intent.putExtras(bundle);
                    deviceFragment2.startActivity(intent);
                }
            });
            return learnCardItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO qiblaItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<QiblaItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$qiblaItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final QiblaItem invoke() {
            QiblaItem qiblaItem = new QiblaItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            qiblaItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$qiblaItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                    deviceFragment2.startActivity(new Intent(deviceFragment2.getActivity(), (Class<?>) QiblaSettingsActivity.class));
                }
            });
            return qiblaItem;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO earphoneItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EarphoneItem>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$earphoneItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final EarphoneItem invoke() {
            EarphoneItem earphoneItem = new EarphoneItem();
            final DeviceFragment deviceFragment = DeviceFragment.this;
            earphoneItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$earphoneItem$2$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                    invoke2(view);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    final DeviceFragment deviceFragment2 = DeviceFragment.this;
                    com.sma.smartv3.ble.I0Io.I0Io(new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$earphoneItem$2$1$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                            invoke2(bleConnector);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo BleConnector it2) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it2, "it");
                            DeviceFragment deviceFragment3 = DeviceFragment.this;
                            deviceFragment3.startActivity(new Intent(deviceFragment3.getActivity(), (Class<?>) SoundEffectsSampleActivity.class));
                        }
                    });
                }
            });
            return earphoneItem;
        }
    });

    @OXOo.OOXIXo
    private final X0o0xo mBleHandleCallback = new X0o0xo();

    @OXOo.OOXIXo
    private final I0Io bleHandleCallback = new I0Io();

    /* loaded from: classes12.dex */
    public static final class I0Io implements BleHandleCallback {
        public I0Io() {
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
            com.sma.smartv3.pop.xOOOX mAGpsPopup;
            com.sma.smartv3.pop.xOOOX mAGpsPopup2;
            kotlin.jvm.internal.IIX0o.x0xO0oo(bleKey, "bleKey");
            if (z && i2 > 0 && (mAGpsPopup2 = DeviceFragment.this.getMAGpsPopup()) != null) {
                mAGpsPopup2.XIxXXX0x0((i3 * 100) / i2);
            }
            if ((!z || i2 == i3) && (mAGpsPopup = DeviceFragment.this.getMAGpsPopup()) != null && mAGpsPopup.isShowing()) {
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

    @kotlin.jvm.internal.XX({"SMAP\nTimer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Timer.kt\nkotlin/concurrent/TimersKt$timerTask$1\n+ 2 DeviceFragment.kt\ncom/sma/smartv3/ui/device/DeviceFragment\n*L\n1#1,148:1\n2578#2,2:149\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class II0xO0 extends TimerTask {
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24649x0o, null, 2, null);
        }
    }

    /* loaded from: classes12.dex */
    public static final class X0o0xo implements BleHandleCallback {
        public X0o0xo() {
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
            if (DeviceFragment.this.isScanQrcode()) {
                if (z) {
                    com.sma.smartv3.ble.II0xO0.f20317oIX0oI.XIxXXX0x0();
                    return;
                }
                DeviceFragment.this.setScanQrcode(false);
                com.sma.smartv3.pop.x0xO mConfirmPopup = DeviceFragment.this.getMConfirmPopup();
                if (mConfirmPopup != null) {
                    mConfirmPopup.dismiss();
                }
                BleConnector.INSTANCE.closeConnection(true);
            }
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
        public void onReadFirmwareVersion(@OXOo.OOXIXo String version) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(version, "version");
            if (DeviceFragment.this.isScanQrcode()) {
                com.sma.smartv3.pop.x0xO mConfirmPopup = DeviceFragment.this.getMConfirmPopup();
                if (mConfirmPopup != null) {
                    mConfirmPopup.dismiss();
                }
                com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24400OxI, false);
                ProductManager productManager = ProductManager.f20544oIX0oI;
                if (productManager.OOOI()) {
                    if (!ProjectManager.f19822oIX0oI.o0oIxOo()) {
                        BleConnector.INSTANCE.connectClassic();
                    }
                } else if (productManager.xoIXOxX()) {
                    BleConnector.INSTANCE.connectHID();
                }
                DeviceFragment.this.bindDone();
            }
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
            if (DeviceFragment.this.isScanQrcode() && !z) {
                DeviceFragment.this.setScanQrcode(false);
                com.sma.smartv3.pop.x0xO mConfirmPopup = DeviceFragment.this.getMConfirmPopup();
                if (mConfirmPopup != null) {
                    mConfirmPopup.dismiss();
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

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    /* loaded from: classes12.dex */
    public static final class oxoX implements com.sma.smartv3.biz.II0XooXoX<FirmwareVersion> {
        public oxoX() {
        }

        @Override // com.sma.smartv3.biz.II0XooXoX
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@OXOo.oOoXoXO FirmwareVersion firmwareVersion) {
            if (firmwareVersion != null) {
                DeviceFragment.this.toFirmwareUpgrade();
            } else {
                DeviceInfoChecker.f19983oIX0oI.I0Io(DeviceFragment.this.getMActivity());
            }
        }

        @Override // com.sma.smartv3.biz.II0XooXoX
        public void onFailure(@OXOo.OOXIXo String error) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
            DeviceInfoChecker.f19983oIX0oI.I0Io(DeviceFragment.this.getMActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bindDone() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("bindDone");
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.o0Oo() || productManager.XXoO0oX()) {
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24571IIxOXoOo0, null, 2, null);
        }
        new Timer().schedule(new II0xO0(), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkVersionByClickFirmware() {
        DeviceInfoChecker.XO(DeviceInfoChecker.f19983oIX0oI, new oxoX(), null, 2, null);
    }

    private final void conntectDevice(String str, String str2) {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("conntectDevice -> " + str + " , " + str2);
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.IXoIo(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("mArg0", str2);
            bundle.putParcelable("mArg2", null);
            bundle.putSerializable("mArg3", null);
            Intent intent = new Intent(getActivity(), (Class<?>) AutoBindActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
            return;
        }
        com.sma.smartv3.pop.x0xO x0xo = this.mConfirmPopup;
        if (x0xo != null && x0xo.isShowing()) {
            return;
        }
        BleConnector.INSTANCE.setAddress(str2).connect(true);
        final com.sma.smartv3.pop.x0xO x0xo2 = new com.sma.smartv3.pop.x0xO(getMActivity());
        x0xo2.xXxxox0I(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$conntectDevice$1$1

            @kotlin.jvm.internal.XX({"SMAP\nTimer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Timer.kt\nkotlin/concurrent/TimersKt$timerTask$1\n+ 2 DeviceFragment.kt\ncom/sma/smartv3/ui/device/DeviceFragment$conntectDevice$1$1\n*L\n1#1,148:1\n2609#2,2:149\n*E\n"})
            /* loaded from: classes12.dex */
            public static final class oIX0oI extends TimerTask {
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    BleConnector.INSTANCE.closeConnection(true);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                DeviceFragment.this.setScanQrcode(false);
                x0xo2.dismiss();
                BleConnector.sendInt8$default(BleConnector.INSTANCE, BleKey.IDENTITY, BleKeyFlag.UPDATE, 16, false, false, 24, null);
                new Timer().schedule(new oIX0oI(), 200L);
            }
        });
        x0xo2.XIxXXX0x0().setImageResource(productManager.XO(str));
        this.mConfirmPopup = x0xo2;
        View rootView = getRootView();
        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
        x0xo2.OxxIIOOXO(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fourPopup() {
        new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.IoOoX
            @Override // java.lang.Runnable
            public final void run() {
                com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24591OO, null, 2, null);
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void noPermissionRemind() {
        if (this.mPermissionPopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(getMActivity(), 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.permission_set_remind);
            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.settings, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$noPermissionRemind$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    PermissionUtils.launchAppDetailsSettings();
                    return Boolean.TRUE;
                }
            });
            this.mPermissionPopup = xoI0Ixx0;
        }
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = this.mPermissionPopup;
        if (xoI0Ixx02 != null) {
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xoI0Ixx02.OxxIIOOXO(rootView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActivityResult$lambda$7(DeviceFragment this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.updatePairState(false);
        this$0.twoPopup(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCodePairChange$lambda$9(DeviceFragment this$0) {
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0;
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        try {
            if (this$0.getRootView() != null && (xoI0Ixx0 = this$0.mBindDeviceRemindPopup) != null) {
                View rootView = this$0.getRootView();
                kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                xoI0Ixx0.OxxIIOOXO(rootView);
            }
        } catch (Exception e) {
            this$0.fourPopup();
            e.printStackTrace();
        }
    }

    private final com.sma.smartv3.pop.xOOOX setProgressBackCallBack(com.sma.smartv3.pop.xOOOX xooox) {
        if (xooox == null) {
            com.sma.smartv3.pop.xOOOX xooox2 = new com.sma.smartv3.pop.xOOOX(getMActivity(), 0, 2, null);
            xooox2.IXxxXO(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$setProgressBackCallBack$1$1
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
                    DeviceFragment.I0Io i0Io;
                    BleConnector bleConnector = BleConnector.INSTANCE;
                    i0Io = DeviceFragment.this.bleHandleCallback;
                    bleConnector.addHandleCallback(i0Io);
                }
            });
            xooox2.Oo(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$setProgressBackCallBack$1$2
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
                    DeviceFragment.I0Io i0Io;
                    BleConnector bleConnector = BleConnector.INSTANCE;
                    i0Io = DeviceFragment.this.bleHandleCallback;
                    bleConnector.removeHandleCallback(i0Io);
                }
            });
            return xooox2;
        }
        return xooox;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showHIDPopup() {
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = this.mHIDPopup;
        if (xoI0Ixx0 != null && xoI0Ixx0.isShowing()) {
            return;
        }
        if (this.mHIDPopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = new com.sma.smartv3.pop.XoI0Ixx0(getMActivity(), 0, 2, null);
            xoI0Ixx02.IoOoX(R.string.hid_remind);
            xoI0Ixx02.x0xO0oo(false);
            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx02, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx02.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$showHIDPopup$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    BleConnector.INSTANCE.connectHID();
                    return Boolean.TRUE;
                }
            });
            this.mHIDPopup = xoI0Ixx02;
        }
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx03 = this.mHIDPopup;
        if (xoI0Ixx03 != null) {
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xoI0Ixx03.OxxIIOOXO(rootView);
        }
    }

    private final void showList() {
        List<DslAdapterItem> items;
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.xIx()) {
            items = getRingItems();
        } else if (productManager.xxxI()) {
            items = getBCItems();
        } else {
            items = getItems();
        }
        this.showList = items;
        renderAdapter(new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$showList$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapter dslAdapter) {
                invoke2(dslAdapter);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo final DslAdapter renderAdapter) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                renderAdapter.clearAllItems();
                DslAdapter.setAdapterStatus$default(renderAdapter, 2, null, 2, null);
                DslViewHolder dslViewHolder = DeviceFragment.this.getDslViewHolder();
                final DeviceFragment deviceFragment = DeviceFragment.this;
                dslViewHolder.postDelay(300L, new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$showList$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        List<DslAdapterItem> list;
                        List list2;
                        list = DeviceFragment.this.showList;
                        if (list == null) {
                            kotlin.jvm.internal.IIX0o.XOxIOxOx("showList");
                            list = null;
                        }
                        for (DslAdapterItem dslAdapterItem : list) {
                            if (dslAdapterItem instanceof BaseDslItem) {
                                try {
                                    ((BaseDslItem) dslAdapterItem).initView();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        list2 = DeviceFragment.this.showList;
                        if (list2 == null) {
                            kotlin.jvm.internal.IIX0o.XOxIOxOx("showList");
                            list2 = null;
                        }
                        Iterator it = list2.iterator();
                        while (it.hasNext()) {
                            DslAdapterExKt.IXxxXO(renderAdapter, (DslAdapterItem) it.next(), null, 2, null);
                        }
                        DslAdapter.render$default(renderAdapter, false, null, new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment.showList.1.1.1
                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapter dslAdapter) {
                                invoke2(dslAdapter);
                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OXOo.OOXIXo DslAdapter render) {
                                kotlin.jvm.internal.IIX0o.x0xO0oo(render, "$this$render");
                                DslAdapter.setAdapterStatus$default(render, 0, null, 2, null);
                            }
                        }, 3, null);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void threePopup(boolean z) {
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.XIXIX() && productManager.IOOoXo0Ix()) {
            DeviceInfoChecker.Oo(DeviceInfoChecker.f19983oIX0oI, new com.sma.smartv3.biz.II0XooXoX<ExtraPackageData[]>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$threePopup$1
                @Override // com.sma.smartv3.biz.II0XooXoX
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void onSuccess(@OXOo.oOoXoXO ExtraPackageData[] extraPackageDataArr) {
                    boolean z2;
                    if (extraPackageDataArr != null) {
                        if (extraPackageDataArr.length == 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(DeviceFragment.this.getMActivity(), 0, 2, null);
                            final DeviceFragment deviceFragment = DeviceFragment.this;
                            xoI0Ixx0.IoOoX(R.string.watch_language_set);
                            xoI0Ixx0.xI(Integer.valueOf(R.string.language_set_remind));
                            xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$threePopup$1$onSuccess$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // Oox.oIX0oI
                                @OXOo.OOXIXo
                                public final Boolean invoke() {
                                    DeviceFragment.this.fourPopup();
                                    return Boolean.TRUE;
                                }
                            });
                            xoI0Ixx0.x0o(R.string.settings, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$threePopup$1$onSuccess$1$2
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // Oox.oIX0oI
                                @OXOo.OOXIXo
                                public final Boolean invoke() {
                                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                                    Bundle bundle = new Bundle();
                                    bundle.putString("mArg0", null);
                                    bundle.putInt("mArg1", R.string.watch_language_set);
                                    bundle.putParcelable("mArg2", null);
                                    bundle.putSerializable("mArg3", null);
                                    Intent intent = new Intent(deviceFragment2.getActivity(), (Class<?>) LanguageListActivity.class);
                                    intent.putExtras(bundle);
                                    deviceFragment2.startActivity(intent);
                                    DeviceFragment.this.fourPopup();
                                    return Boolean.TRUE;
                                }
                            });
                            View rootView = DeviceFragment.this.getRootView();
                            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                            xoI0Ixx0.OxxIIOOXO(rootView);
                            return;
                        }
                    }
                    DeviceFragment.this.fourPopup();
                }

                @Override // com.sma.smartv3.biz.II0XooXoX
                public void onFailure(@OXOo.OOXIXo String error) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                    DeviceFragment.this.fourPopup();
                }
            }, null, 2, null);
        } else {
            fourPopup();
        }
    }

    public static /* synthetic */ void toAddDevice$default(DeviceFragment deviceFragment, String str, String str2, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = "";
            }
            deviceFragment.toAddDevice(str, str2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toAddDevice");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toFirmwareUpgrade() {
        BleCache bleCache = BleCache.INSTANCE;
        String mPlatform = bleCache.getMPlatform();
        switch (mPlatform.hashCode()) {
            case 76676:
                if (mPlatform.equals(BleDeviceInfo.PLATFORM_MTK)) {
                    startActivity(new Intent(getActivity(), (Class<?>) FirmwareUpgradeMActivity.class));
                    return;
                }
                break;
            case 2755709:
                if (mPlatform.equals(BleDeviceInfo.PLATFORM_ZKLX)) {
                    startActivity(new Intent(getActivity(), (Class<?>) FirmwareUpgradeZActivity.class));
                    return;
                }
                break;
            case 78896685:
                if (mPlatform.equals(BleDeviceInfo.PLATFORM_SIFLI)) {
                    startActivity(new Intent(getActivity(), (Class<?>) FirmwareUpgradeSActivity.class));
                    return;
                }
                break;
            case 2138586828:
                if (mPlatform.equals(BleDeviceInfo.PLATFORM_GOODIX)) {
                    if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_R3Q)) {
                        DeviceInfoChecker.f19983oIX0oI.oxoX(getMActivity());
                        return;
                    } else {
                        startActivity(new Intent(getActivity(), (Class<?>) FirmwareUpgradeGActivity.class));
                        return;
                    }
                }
                break;
        }
        if (ProductManager.f20544oIX0oI.xx0X0()) {
            DeviceInfoChecker.f19983oIX0oI.oxoX(getMActivity());
        } else {
            startActivity(new Intent(getActivity(), (Class<?>) FirmwareUpgradeNActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toSyncAGPS() {
        com.sma.smartv3.pop.xOOOX progressBackCallBack = setProgressBackCallBack(this.mAGpsPopup);
        this.mAGpsPopup = progressBackCallBack;
        if (progressBackCallBack != null) {
            progressBackCallBack.xxX(R.string.downloading);
            progressBackCallBack.XIxXXX0x0(0);
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            progressBackCallBack.OxxIIOOXO(rootView);
        }
        AGPSInitializer.f20674XO.OxxIIOOXO(false, this.mAGpsPopup);
    }

    public static /* synthetic */ void updatePairState$default(DeviceFragment deviceFragment, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            deviceFragment.updatePairState(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updatePairState");
    }

    public final void checkAppAvailable() {
        DeviceInfoChecker.f19983oIX0oI.oIX0oI(new DeviceFragment$checkAppAvailable$1(this));
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24619XoI0Ixx0)
    public final void checkFirmware(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("checkFirmware -> update check");
        twoPopup(false);
        DeviceInfoChecker.f19983oIX0oI.oI0IIXIo();
    }

    public final boolean checkNotificationPermission() {
        boolean X0o0xo2 = MyNotificationListenerService.f20319OxI.X0o0xo(getMActivity());
        if (!X0o0xo2) {
            if (this.mNotificationPopup == null) {
                final com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(getMActivity(), 0, 2, null);
                String string = getString(R.string.allow_notification_access, getString(R.string.app_name));
                kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                xoI0Ixx0.Xx000oIo(string);
                com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, null, null, 2, null);
                xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$checkNotificationPermission$1$1$1
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
                View rootView = getRootView();
                kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                xoI0Ixx02.OxxIIOOXO(rootView);
            }
        }
        return X0o0xo2;
    }

    public final void doScanResult(@OXOo.OOXIXo String result) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(result, "result");
        try {
            Uri parse = Uri.parse(result);
            String queryParameter = parse.getQueryParameter("name");
            String queryParameter2 = parse.getQueryParameter("mac");
            if (TextUtils.isEmpty(queryParameter2)) {
                queryParameter2 = parse.getQueryParameter("MAC");
            }
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("doScanResult -> " + queryParameter + ", " + queryParameter2);
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2)) {
                Toast.makeText(getMActivity(), R.string.qrcode_failed, 1).show();
            } else {
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(queryParameter2);
                toAddDevice(queryParameter, queryParameter2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getMActivity(), R.string.qrcode_failed, 1).show();
        }
    }

    @OXOo.OOXIXo
    public final AGPSUpgradeItem getAGPSUpgradeItem() {
        return (AGPSUpgradeItem) this.aGPSUpgradeItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final AlarmClockItem getAlarmClockItem() {
        return (AlarmClockItem) this.alarmClockItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getAlipaySetItem() {
        return (BaseDeviceItem) this.alipaySetItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getAntiLostItem() {
        return (BaseDeviceItem) this.antiLostItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final AppStoreItem getAppStoreItem() {
        return (AppStoreItem) this.appStoreItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final AudioBookLearnItem getAudioBookLearnItem() {
        return (AudioBookLearnItem) this.audioBookLearnItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public List<DslAdapterItem> getBCItems() {
        return CollectionsKt__CollectionsKt.XOxIOxOx(getInfoItem(), new SplitLine4DPItem(), getHrMonitoringItem(), getBloodOxyGenItem(), getPressureItem(), new SplitLine4DPItem(), getFirmwareItem(), getResetItem(), getShutdownItem(), getUnpairItem());
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getBackLightItem() {
        return (BaseDeviceItem) this.backLightItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BloodOxyGenItem getBloodOxyGenItem() {
        return (BloodOxyGenItem) this.bloodOxyGenItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final ClassicPairItem getClassicPairItem() {
        return (ClassicPairItem) this.classicPairItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getDateFormatItem() {
        return (BaseDeviceItem) this.dateFormatItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final DialItem getDialItem() {
        return (DialItem) this.dialItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final TranslationDialogueItem getDialogueTranslation() {
        return (TranslationDialogueItem) this.dialogueTranslation$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final DoubleClickScreenItem getDoubleClickScreenItem() {
        return (DoubleClickScreenItem) this.doubleClickScreenItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final DrinkWaterItem getDrinkWaterItem() {
        return (DrinkWaterItem) this.drinkWaterItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final EarphoneItem getEarphoneItem() {
        return (EarphoneItem) this.earphoneItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final EBookManagerItem getEbookManagerItem() {
        return (EBookManagerItem) this.ebookManagerItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getEcgMonitoringItem() {
        return (BaseDeviceItem) this.ecgMonitoringItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getFallManagerItem() {
        return (BaseDeviceItem) this.fallManagerItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final FindWatchItem getFindWatchItem() {
        return (FindWatchItem) this.findWatchItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final FirmwareItem getFirmwareItem() {
        return (FirmwareItem) this.firmwareItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final GameSettingsItem getGameSettingsItem() {
        return (GameSettingsItem) this.gameSettingsItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final GameStoreItem getGameStoreItem() {
        return (GameStoreItem) this.gameStoreItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getGameTimeSetItem() {
        return (BaseDeviceItem) this.gameTimeSetItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getGestureWake2Item() {
        return (BaseDeviceItem) this.gestureWake2Item$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getGestureWakeItem() {
        return (BaseDeviceItem) this.gestureWakeItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getGirlCareItem() {
        return (BaseDeviceItem) this.girlCareItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final HardWareAlipayItem getHardWareAlipay() {
        return (HardWareAlipayItem) this.hardWareAlipay$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getHrMonitoringItem() {
        return (BaseDeviceItem) this.hrMonitoringItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getIncomingCallItem() {
        return (BaseDeviceItem) this.incomingCallItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getIncomingCallRingItem() {
        return (BaseDeviceItem) this.incomingCallRingItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getIncomingCallRingVibrationItem() {
        return (BaseDeviceItem) this.incomingCallRingVibrationItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final InfoItem getInfoItem() {
        return (InfoItem) this.infoItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public List<DslAdapterItem> getItems() {
        return CollectionsKt__CollectionsKt.XOxIOxOx(getInfoItem(), getEarphoneItem(), getGameStoreItem(), getClassicPairItem(), getQiblaItem(), getDialItem(), getMessagePushItem(), new SplitLine4DPItem(), getIncomingCallItem(), getAntiLostItem(), getNoDisturbItem(), getNoDisturb2Item(), getDoubleClickScreenItem(), getAlarmClockItem(), getGameTimeSetItem(), getMedicationAlarmItem(), getSedentarinessItem(), getDrinkWaterItem(), getBloodOxyGenItem(), getRelaxReminderItem(), getWashItem(), getMeasureUnitItem(), getDateFormatItem(), getTimeFormatItem(), getPressureItem(), getStandbyWatchFaceItem(), new SplitLine4DPItem(), getShockItem(), getShockSettingsItem(), getBackLightItem(), getGestureWakeItem(), getGestureWake2Item(), getWearWayItem(), getHrMonitoringItem(), getEcgMonitoringItem(), getTempMonitoringItem(), getMusicControlItem(), getAppStoreItem(), getAudioBookLearnItem(), getLearnCardItem(), getGameSettingsItem(), getFindWatchItem(), getSmsQuickReplyItem(), new SplitLine4DPItem(), getScheduleItem(), getRecordingItem(), getGirlCareItem(), getSosManagerItem(), getMemoryManagerItem(), getRemoteCameraItem(), getLanguageItem(), getTouchSetItem(), getFirmwareItem(), getAGPSUpgradeItem(), getSyncContactItem(), getMacQrcodeItem(), getStockMarketItem(), getWorldClockItem(), getLogoFileItem(), getWatchPasswordItem(), getPowerSaveModeItem(), getStandbySetItem(), getAlipaySetItem(), getHardWareAlipay(), getNavigationItem(), getVoiceItem(), getDialogueTranslation(), getSimultaneousTranslation(), getMusicManagerItem(), getEbookManagerItem(), getIncomingCallRingItem(), getNfcGuideItem(), getNotificationLightScreenItem(), getIncomingCallRingVibrationItem(), getResetItem(), new SplitLine4DPItem(), getNucleicAcidCodeItem(), getMyCardCodeItem(), getMyCardCode2Item(), getReceiptCodeItem(), getReceiptCode2Item(), getUnpairItem());
    }

    @OXOo.OOXIXo
    public final LanguageItem getLanguageItem() {
        return (LanguageItem) this.languageItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final LearnCardItem getLearnCardItem() {
        return (LearnCardItem) this.learnCardItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getLogoFileItem() {
        return (BaseDeviceItem) this.logoFileItem$delegate.getValue();
    }

    @OXOo.oOoXoXO
    public final com.sma.smartv3.pop.xOOOX getMAGpsPopup() {
        return this.mAGpsPopup;
    }

    @OXOo.oOoXoXO
    public final com.sma.smartv3.pop.x0xO getMConfirmPopup() {
        return this.mConfirmPopup;
    }

    @OXOo.oOoXoXO
    public com.sma.smartv3.pop.XoI0Ixx0 getMUnbindPopup() {
        return this.mUnbindPopup;
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getMacQrcodeItem() {
        return (BaseDeviceItem) this.macQrcodeItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final MeasureUnitItem getMeasureUnitItem() {
        return (MeasureUnitItem) this.measureUnitItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final MedicationAlarmItem getMedicationAlarmItem() {
        return (MedicationAlarmItem) this.medicationAlarmItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final MemoryManagerItem getMemoryManagerItem() {
        return (MemoryManagerItem) this.memoryManagerItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final MessagePushItem getMessagePushItem() {
        return (MessagePushItem) this.messagePushItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getMusicControlItem() {
        return (BaseDeviceItem) this.musicControlItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final MusicManagerItem getMusicManagerItem() {
        return (MusicManagerItem) this.musicManagerItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getMyCardCode2Item() {
        return (BaseDeviceItem) this.myCardCode2Item$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getMyCardCodeItem() {
        return (BaseDeviceItem) this.myCardCodeItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final NavigationItem getNavigationItem() {
        return (NavigationItem) this.navigationItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final NFCGuideItem getNfcGuideItem() {
        return (NFCGuideItem) this.nfcGuideItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final NoDisturb2Item getNoDisturb2Item() {
        return (NoDisturb2Item) this.noDisturb2Item$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final NoDisturbItem getNoDisturbItem() {
        return (NoDisturbItem) this.noDisturbItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getNotificationLightScreenItem() {
        return (BaseDeviceItem) this.notificationLightScreenItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getNucleicAcidCodeItem() {
        return (BaseDeviceItem) this.nucleicAcidCodeItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getPowerSaveModeItem() {
        return (BaseDeviceItem) this.powerSaveModeItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final PressureItem getPressureItem() {
        return (PressureItem) this.pressureItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final QiblaItem getQiblaItem() {
        return (QiblaItem) this.qiblaItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getReceiptCode2Item() {
        return (BaseDeviceItem) this.receiptCode2Item$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getReceiptCodeItem() {
        return (BaseDeviceItem) this.receiptCodeItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final RecordingItem getRecordingItem() {
        return (RecordingItem) this.recordingItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final RelaxReminderItem getRelaxReminderItem() {
        return (RelaxReminderItem) this.relaxReminderItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final RemoteCameraItem getRemoteCameraItem() {
        return (RemoteCameraItem) this.remoteCameraItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final ResetItem getResetItem() {
        return (ResetItem) this.resetItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public List<DslAdapterItem> getRingItems() {
        return CollectionsKt__CollectionsKt.XOxIOxOx(getInfoItem(), new SplitLine4DPItem(), getGameStoreItem(), getHrMonitoringItem(), getBloodOxyGenItem(), getPressureItem(), new SplitLine4DPItem(), getTouchSetItem(), getFirmwareItem(), getResetItem(), getShutdownItem(), getUnpairItem());
    }

    public View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final ScheduleItem getScheduleItem() {
        return (ScheduleItem) this.scheduleItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final SedentarinessItem getSedentarinessItem() {
        return (SedentarinessItem) this.sedentarinessItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getShockItem() {
        return (BaseDeviceItem) this.shockItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final ShockSettingsItem getShockSettingsItem() {
        return (ShockSettingsItem) this.shockSettingsItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final ShutdownItem getShutdownItem() {
        return (ShutdownItem) this.shutdownItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final TranslationSimultaneousItem getSimultaneousTranslation() {
        return (TranslationSimultaneousItem) this.simultaneousTranslation$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final SMSQuickReplyItem getSmsQuickReplyItem() {
        return (SMSQuickReplyItem) this.smsQuickReplyItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final SOSManagerItem getSosManagerItem() {
        return (SOSManagerItem) this.sosManagerItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getStandbySetItem() {
        return (BaseDeviceItem) this.standbySetItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final StandbyWatchFaceItem getStandbyWatchFaceItem() {
        return (StandbyWatchFaceItem) this.standbyWatchFaceItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final StockMarketItem getStockMarketItem() {
        return (StockMarketItem) this.stockMarketItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final SyncContactItem getSyncContactItem() {
        return (SyncContactItem) this.syncContactItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getTempMonitoringItem() {
        return (BaseDeviceItem) this.tempMonitoringItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getTimeFormatItem() {
        return (BaseDeviceItem) this.timeFormatItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final TouchSetItem getTouchSetItem() {
        return (TouchSetItem) this.touchSetItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final UnpairItem getUnpairItem() {
        return (UnpairItem) this.unpairItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final VoiceItem getVoiceItem() {
        return (VoiceItem) this.voiceItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final WashItem getWashItem() {
        return (WashItem) this.washItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final WatchPasswordItem getWatchPasswordItem() {
        return (WatchPasswordItem) this.watchPasswordItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseDeviceItem getWearWayItem() {
        return (BaseDeviceItem) this.wearWayItem$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final WorldClockItem getWorldClockItem() {
        return (WorldClockItem) this.worldClockItem$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        BleConnector.INSTANCE.addHandleCallback(this.mBleHandleCallback);
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getRecyclerView().setItemViewCacheSize(200);
        getRecyclerView().setItemAnimator(null);
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        if (xo0.oxoX().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24406X00IoxXI, false)) {
            xo0.oxoX().put(com.sma.smartv3.util.XoI0Ixx0.f24406X00IoxXI, false);
            if (!BleConnector.INSTANCE.isBound()) {
                toAddDevice$default(this, null, null, 3, null);
            }
        }
        checkAppAvailable();
    }

    public final boolean isBindDevice() {
        return this.isBindDevice;
    }

    public final boolean isScanQrcode() {
        return this.isScanQrcode;
    }

    public int layoutId() {
        return R.layout.fragment_rv;
    }

    public final void multiChoiceIncomingCallRing() {
        if (this.mMultiRingVibrationPopup == null) {
            com.sma.smartv3.pop.xoxXI xoxxi = new com.sma.smartv3.pop.xoxXI(getMActivity(), R.array.ring_vibration);
            xoxxi.IoOoX(R.string.incoming_call_ring_vibration);
            xoxxi.oo(new Oox.oOoXoXO<Set<? extends Integer>, Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$multiChoiceIncomingCallRing$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Set<? extends Integer> set) {
                    return invoke2((Set<Integer>) set);
                }

                @OXOo.OOXIXo
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Boolean invoke2(@OXOo.OOXIXo final Set<Integer> picked) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(picked, "picked");
                    final DeviceFragment deviceFragment = DeviceFragment.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$multiChoiceIncomingCallRing$1$1.1
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
                            BleConnector.sendObject$default(it, BleKey.RING_VIBRATION_SET, BleKeyFlag.UPDATE, new BleRingVibrationSettings(oOXoIIIo.I0Io.I0Io(picked.contains(0)), oOXoIIIo.I0Io.I0Io(picked.contains(1))), false, false, 24, null);
                            deviceFragment.getIncomingCallRingVibrationItem().initView();
                        }
                    }, 1, null));
                }
            });
            this.mMultiRingVibrationPopup = xoxxi;
        }
        com.sma.smartv3.pop.xoxXI xoxxi2 = this.mMultiRingVibrationPopup;
        if (xoxxi2 != null) {
            BleRingVibrationSettings bleRingVibrationSettings = (BleRingVibrationSettings) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.RING_VIBRATION_SET, BleRingVibrationSettings.class, null, null, 12, null);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (bleRingVibrationSettings.getMVibration() == 1) {
                linkedHashSet.add(0);
            }
            if (bleRingVibrationSettings.getMRing() == 1) {
                linkedHashSet.add(1);
            }
            xoxxi2.oo0xXOI0I(linkedHashSet);
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xoxxi2.OxxIIOOXO(rootView);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        boolean z;
        super.onActivityResult(i, i2, intent);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("device -> onActivityResult: " + i2 + ", " + i);
        if (i == 7 || (i == 2 && i2 == 0)) {
            if (i2 != -1) {
                z = true;
            } else {
                z = false;
            }
            this.isTipAppGuideActivity = z;
            if (ProjectManager.f19822oIX0oI.I0oOoX()) {
                ProductManager.f20544oIX0oI.oIxOXo(getMActivity());
                return;
            }
        }
        if (i2 == -1) {
            if (i != 1) {
                if (i != 2 && i != 3) {
                    if (i != 5) {
                        if (i != 7) {
                            return;
                        }
                    } else {
                        showPairTypePop();
                        return;
                    }
                } else if (ProjectManager.f19822oIX0oI.I0oOoX()) {
                    ProductManager.f20544oIX0oI.oIxOXo(getMActivity());
                    return;
                } else {
                    new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.xI
                        @Override // java.lang.Runnable
                        public final void run() {
                            DeviceFragment.onActivityResult$lambda$7(DeviceFragment.this);
                        }
                    }, 200L);
                    return;
                }
            }
            this.isBindDevice = false;
            onCodePairChange(new Object());
        }
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24649x0o)
    public final void onCodePairChange(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("onCodePairChange isScanQrcode=" + this.isScanQrcode);
        this.isScanQrcode = false;
        if (ProjectManager.f19822oIX0oI.o0oIxOo()) {
            if (this.isTipAppGuideActivity) {
                FragmentActivity activity = getActivity();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(activity);
                startActivityForResult(new Intent(activity, (Class<?>) AppGuideActivity.class), 2);
            } else {
                this.isTipAppGuideActivity = true;
            }
        } else {
            if (this.mBindDeviceRemindPopup == null) {
                com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(getMActivity(), 0, 2, null);
                xoI0Ixx0.IoOoX(R.string.use_reminder);
                xoI0Ixx0.xI(Integer.valueOf(R.string.android_bind_remind));
                xoI0Ixx0.x0xO0oo(false);
                com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, null, null, 2, null);
                xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$onCodePairChange$1$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        DeviceFragment.this.twoPopup(true);
                        return Boolean.TRUE;
                    }
                });
                this.mBindDeviceRemindPopup = xoI0Ixx0;
            }
            new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.oo0xXOI0I
                @Override // java.lang.Runnable
                public final void run() {
                    DeviceFragment.onCodePairChange$lambda$9(DeviceFragment.this);
                }
            }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
        RequestCommonMethod.INSTANCE.updateDeviceInfo(new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$onCodePairChange$3
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str) {
            }
        });
        DeviceInfoChecker.f19983oIX0oI.oI0IIXIo();
        updatePairState$default(this, false, 1, null);
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        BleConnector.INSTANCE.removeHandleCallback(this.mBleHandleCallback);
        super.onDestroy();
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        showList();
    }

    @Override // androidx.fragment.app.Fragment
    public void onMultiWindowModeChanged(boolean z) {
        super.onMultiWindowModeChanged(z);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("test onMultiWindowModeChanged " + z);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.lastClickTime = 0L;
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24565I0oOoX)
    public final void onRebind(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24614XX, Boolean.TRUE);
        toAddDevice$default(this, null, null, 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.lastClickTime = 0L;
        if (this.isBindDevice) {
            this.isBindDevice = false;
            updatePairState$default(this, false, 1, null);
        }
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int refreshLayoutId() {
        return 0;
    }

    public final void scanQrcode() {
        com.sma.smartv3.util.XIo0oOXIx.f24335oIX0oI.xoIox(getMActivity(), false, new Oox.oOoXoXO<String, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$scanQrcode$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(String str) {
                invoke2(str);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.oOoXoXO String str) {
                if (str != null) {
                    DeviceFragment.this.doScanResult(str);
                } else {
                    ToastUtils.showLong(R.string.qrcode_failed);
                }
            }
        });
    }

    public final void setBindDevice(boolean z) {
        this.isBindDevice = z;
    }

    public final void setMAGpsPopup(@OXOo.oOoXoXO com.sma.smartv3.pop.xOOOX xooox) {
        this.mAGpsPopup = xooox;
    }

    public final void setMConfirmPopup(@OXOo.oOoXoXO com.sma.smartv3.pop.x0xO x0xo) {
        this.mConfirmPopup = x0xo;
    }

    public void setMUnbindPopup(@OXOo.oOoXoXO com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0) {
        this.mUnbindPopup = xoI0Ixx0;
    }

    public final void setScanQrcode(boolean z) {
        this.isScanQrcode = z;
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24561I0)
    public final void showDeviceUnbindPopup(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("showDeviceUnbindPopup");
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(getMActivity(), 0, 2, null);
        xoI0Ixx0.x0xO0oo(false);
        xoI0Ixx0.IoOoX(R.string.device_unbind_tip);
        com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, null, null, 2, null);
        xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$showDeviceUnbindPopup$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Boolean invoke() {
                return Boolean.TRUE;
            }
        });
        View rootView = getRootView();
        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
        xoI0Ixx0.OxxIIOOXO(rootView);
    }

    public void showPairTypePop() {
        if (!PermissionUtils.isGranted(PermissionConstants.LOCATION)) {
            PermissionHelper.xoIox(PermissionHelper.f24522oIX0oI, getMActivity(), false, new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$showPairTypePop$1
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
                        DeviceFragment.this.showPairTypePop();
                    }
                }
            }, 2, null);
            return;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            PermissionHelper permissionHelper = PermissionHelper.f24522oIX0oI;
            if (!permissionHelper.OxxIIOOXO(getMActivity())) {
                permissionHelper.oxoX(getMActivity(), new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$showPairTypePop$2
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
                            DeviceFragment.this.showPairTypePop();
                        }
                    }
                });
                return;
            }
        }
        if (!BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            try {
                oOXoIIIo.oIX0oI.Oxx0xo(this, "android.bluetooth.adapter.action.REQUEST_ENABLE", 5, 0, 4, null);
                return;
            } catch (Exception e) {
                ToastUtils.showLong("Please turn on bluetooth", new Object[0]);
                OI0.oIX0oI.f1507oIX0oI.II0xO0("requestEnableBluetooth -> " + e.getMessage());
                return;
            }
        }
        if (!UtilsKt.oo()) {
            startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 6);
            return;
        }
        if (this.mSelectPairPopup == null) {
            final com.sma.smartv3.pop.XIXIxO xIXIxO = new com.sma.smartv3.pop.XIXIxO(getMActivity());
            xIXIxO.ooXIXxIX(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$showPairTypePop$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    PermissionUtils permission = PermissionUtils.permission(PermissionConstants.CAMERA);
                    kotlin.jvm.internal.IIX0o.oO(permission, "permission(...)");
                    String string = DeviceFragment.this.getString(R.string.camera_explain_title);
                    kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                    String string2 = DeviceFragment.this.getString(R.string.camera_explain_content);
                    kotlin.jvm.internal.IIX0o.oO(string2, "getString(...)");
                    final DeviceFragment deviceFragment = DeviceFragment.this;
                    final com.sma.smartv3.pop.XIXIxO xIXIxO2 = xIXIxO;
                    oOXoIIIo.X0o0xo.II0xO0(permission, string, string2, new Oox.oOoXoXO<PermissionStatus, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$showPairTypePop$3$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            com.sma.smartv3.pop.XIXIxO xIXIxO3;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            if (it == PermissionStatus.GRANTED) {
                                xIXIxO3 = DeviceFragment.this.mSelectPairPopup;
                                if (xIXIxO3 != null) {
                                    xIXIxO3.dismiss();
                                }
                                DeviceFragment.this.scanQrcode();
                                return;
                            }
                            if (it == PermissionStatus.DENIED_FOREVER) {
                                com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(xIXIxO2.Oxx0IOOO(), 0, 2, null);
                                DeviceFragment deviceFragment2 = DeviceFragment.this;
                                xoI0Ixx0.x0xO0oo(false);
                                xoI0Ixx0.IoOoX(R.string.camera_explain_title);
                                xoI0Ixx0.xI(Integer.valueOf(R.string.camera_explain_content));
                                com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
                                xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$showPairTypePop$3$1$1$1$1
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // Oox.oIX0oI
                                    @OXOo.OOXIXo
                                    public final Boolean invoke() {
                                        PermissionUtils.launchAppDetailsSettings();
                                        return Boolean.TRUE;
                                    }
                                });
                                View rootView = deviceFragment2.getRootView();
                                kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                                xoI0Ixx0.OxxIIOOXO(rootView);
                            }
                        }
                    });
                }
            });
            xIXIxO.xI(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$showPairTypePop$3$2
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
                    com.sma.smartv3.pop.XIXIxO xIXIxO2;
                    xIXIxO2 = DeviceFragment.this.mSelectPairPopup;
                    if (xIXIxO2 != null) {
                        xIXIxO2.dismiss();
                    }
                    DeviceFragment.toAddDevice$default(DeviceFragment.this, null, null, 3, null);
                }
            });
            this.mSelectPairPopup = xIXIxO;
        }
        com.sma.smartv3.pop.XIXIxO xIXIxO2 = this.mSelectPairPopup;
        if (xIXIxO2 != null) {
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xIXIxO2.OxxIIOOXO(rootView);
        }
    }

    public final void singleChoiceIncomingCallRing() {
        if (this.mRingVibrationPopup == null) {
            com.sma.smartv3.pop.xxOXOOoIX xxoxoooix = new com.sma.smartv3.pop.xxOXOOoIX(getMActivity(), R.array.ring_vibration_s, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
            xxoxoooix.xI(R.string.incoming_call_ring_vibration);
            xxoxoooix.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$singleChoiceIncomingCallRing$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i) {
                    final DeviceFragment deviceFragment = DeviceFragment.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$singleChoiceIncomingCallRing$1$1.1
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
                            int i2 = i;
                            int i3 = 1;
                            int i4 = 0;
                            if (i2 != 1) {
                                if (i2 != 2) {
                                    if (i2 != 3) {
                                        i3 = 0;
                                    }
                                }
                                BleConnector.sendObject$default(it, BleKey.RING_VIBRATION_SET, BleKeyFlag.UPDATE, new BleRingVibrationSettings(i3, i4), false, false, 24, null);
                                deviceFragment.getIncomingCallRingVibrationItem().initView();
                            }
                            i3 = 0;
                            i4 = 1;
                            BleConnector.sendObject$default(it, BleKey.RING_VIBRATION_SET, BleKeyFlag.UPDATE, new BleRingVibrationSettings(i3, i4), false, false, 24, null);
                            deviceFragment.getIncomingCallRingVibrationItem().initView();
                        }
                    }, 1, null));
                }
            });
            this.mRingVibrationPopup = xxoxoooix;
        }
        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2 = this.mRingVibrationPopup;
        if (xxoxoooix2 != null) {
            BleRingVibrationSettings bleRingVibrationSettings = (BleRingVibrationSettings) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.RING_VIBRATION_SET, BleRingVibrationSettings.class, null, null, 12, null);
            int i = 1;
            if (bleRingVibrationSettings.getMVibration() == 1 && bleRingVibrationSettings.getMRing() == 1) {
                i = 3;
            } else if (bleRingVibrationSettings.getMVibration() == 1 && bleRingVibrationSettings.getMRing() == 0) {
                i = 2;
            } else if (bleRingVibrationSettings.getMVibration() != 0 || bleRingVibrationSettings.getMRing() != 1) {
                i = 0;
            }
            xxoxoooix2.IIX0o(i);
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xxoxoooix2.OxxIIOOXO(rootView);
        }
    }

    public final void toAddDevice(@OXOo.oOoXoXO String str, @OXOo.OOXIXo String mac) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(mac, "mac");
        if (TextUtils.isEmpty(mac)) {
            this.isScanQrcode = false;
            this.isBindDevice = true;
            FragmentActivity activity = getActivity();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(activity);
            startActivityForResult(new Intent(activity, (Class<?>) AddDeviceActivity.class), 1);
            return;
        }
        this.isScanQrcode = true;
        conntectDevice(str, mac);
    }

    public void twoPopup(final boolean z) {
        BleCache bleCache = BleCache.INSTANCE;
        if (BleCache.getString$default(bleCache, BleKey.FIRMWARE_VERSION, null, null, 6, null).length() == 0 && BleCache.getString$default(bleCache, BleKey.UI_PACK_VERSION, null, null, 6, null).length() == 0) {
            return;
        }
        DeviceInfoChecker.XO(DeviceInfoChecker.f19983oIX0oI, new com.sma.smartv3.biz.II0XooXoX<FirmwareVersion>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$twoPopup$1
            @Override // com.sma.smartv3.biz.II0XooXoX
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@OXOo.oOoXoXO final FirmwareVersion firmwareVersion) {
                com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24613XOxIOxOx, null, 2, null);
                if (firmwareVersion != null) {
                    if (firmwareVersion.getFlag() == 3) {
                        if (z) {
                            this.threePopup(false);
                            return;
                        }
                        return;
                    }
                    com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this.getMActivity(), 0, 2, null);
                    final boolean z2 = z;
                    final DeviceFragment deviceFragment = this;
                    xoI0Ixx0.IoOoX(R.string.new_version_remind);
                    xoI0Ixx0.x0xO0oo(false);
                    if (firmwareVersion.getFlag() == 1) {
                        com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, null, null, 2, null);
                    } else {
                        xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.upgrade_later), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$twoPopup$1$onSuccess$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // Oox.oIX0oI
                            @OXOo.OOXIXo
                            public final Boolean invoke() {
                                if (z2) {
                                    deviceFragment.threePopup(false);
                                }
                                return Boolean.TRUE;
                            }
                        });
                    }
                    xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$twoPopup$1$onSuccess$1$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // Oox.oIX0oI
                        @OXOo.OOXIXo
                        public final Boolean invoke() {
                            final FirmwareVersion firmwareVersion2 = FirmwareVersion.this;
                            final DeviceFragment deviceFragment2 = deviceFragment;
                            final boolean z3 = z2;
                            com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$twoPopup$1$onSuccess$1$2.1
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
                                    if (com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().getInt(com.sma.smartv3.util.XoI0Ixx0.f24396Oo, 0) >= (FirmwareVersion.this.getFlag() == 1 ? 20 : 50)) {
                                        deviceFragment2.toFirmwareUpgrade();
                                        return;
                                    }
                                    ToastUtils.showLong(R.string.firmware_upgrade_tip_toast);
                                    if (z3) {
                                        deviceFragment2.threePopup(false);
                                    }
                                }
                            }, 1, null);
                            return Boolean.TRUE;
                        }
                    });
                    xoI0Ixx0.IIXOooo();
                    return;
                }
                DeviceInfoChecker.f19983oIX0oI.I0Io(this.getMActivity());
                if (z) {
                    this.threePopup(false);
                }
            }

            @Override // com.sma.smartv3.biz.II0XooXoX
            public void onFailure(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24613XOxIOxOx, null, 2, null);
                DeviceInfoChecker.f19983oIX0oI.I0Io(this.getMActivity());
                if (z) {
                    this.threePopup(false);
                }
            }
        }, null, 2, null);
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24572IO)
    public final void updatePairState(boolean z) {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("updatePairState " + z);
        showList();
        this.mBacklightPopup = null;
    }

    public void whenUnbind() {
        com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24614XX, Boolean.TRUE);
    }
}
