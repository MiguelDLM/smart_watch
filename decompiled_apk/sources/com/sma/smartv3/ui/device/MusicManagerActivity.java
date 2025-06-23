package com.sma.smartv3.ui.device;

import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslAdapterStatusItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.extension.PermissionStatus;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.jieli.jl_filebrowse.FileBrowseManager;
import com.jieli.jl_filebrowse.bean.FileStruct;
import com.jieli.jl_filebrowse.bean.Folder;
import com.jieli.jl_filebrowse.bean.SDCardBean;
import com.jieli.jl_filebrowse.interfaces.DeleteCallback;
import com.jieli.jl_filebrowse.interfaces.FileObserver;
import com.jieli.jl_filebrowse.interfaces.SimpleFileObserver;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.dsl.AdapterStatusItem;
import com.sma.smartv3.initializer.BleInitializer;
import com.sma.smartv3.ui.device.DeviceFileManager;
import com.sma.smartv3.ui.device.MusicManagerActivity;
import com.sma.smartv3.ui.device.MusicManagerActivity$mDeviceFileCallback$2;
import com.sma.smartv3.ui.me.WebViewActivity;
import com.sma.smartv3.ui.musicpicker.MusicPicker;
import com.sma.smartv3.ui.musicpicker.MusicResult;
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
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

@kotlin.jvm.internal.XX({"SMAP\nMusicManagerActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MusicManagerActivity.kt\ncom/sma/smartv3/ui/device/MusicManagerActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,670:1\n1549#2:671\n1620#2,3:672\n87#3,7:675\n94#3,3:683\n70#3,7:686\n97#3:693\n1#4:682\n*S KotlinDebug\n*F\n+ 1 MusicManagerActivity.kt\ncom/sma/smartv3/ui/device/MusicManagerActivity\n*L\n397#1:671\n397#1:672,3\n667#1:675,7\n667#1:683,3\n667#1:686,7\n667#1:693\n667#1:682\n*E\n"})
/* loaded from: classes12.dex */
public class MusicManagerActivity extends BaseDSLRecyclerActivity {
    private int mDownSuccessSize;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mErrorPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.I0X0x0oIo mLoadingPopup;

    @OXOo.oOoXoXO
    private SDCardBean mSDCardBean;
    private int retryFrequency;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.MusicManagerActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) MusicManagerActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvTotalProgress$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.MusicManagerActivity$tvTotalProgress$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) MusicManagerActivity.this.findViewById(R.id.tv_total_progress);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvName$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.MusicManagerActivity$tvName$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) MusicManagerActivity.this.findViewById(R.id.tv_name);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvProgress$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.MusicManagerActivity$tvProgress$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) MusicManagerActivity.this.findViewById(R.id.tv_progress);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvProgressTip$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.MusicManagerActivity$tvProgressTip$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) MusicManagerActivity.this.findViewById(R.id.tv_progress_tip);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO pbProgress$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ProgressBar>() { // from class: com.sma.smartv3.ui.device.MusicManagerActivity$pbProgress$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ProgressBar invoke() {
            return (ProgressBar) MusicManagerActivity.this.findViewById(R.id.pb_progress);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO taskPanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.MusicManagerActivity$taskPanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return MusicManagerActivity.this.findViewById(R.id.task_panel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvCancel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.MusicManagerActivity$tvCancel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return MusicManagerActivity.this.findViewById(R.id.tv_cancel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvRetry$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.MusicManagerActivity$tvRetry$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return MusicManagerActivity.this.findViewById(R.id.tv_retry);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvFreeSpace$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.MusicManagerActivity$tvFreeSpace$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) MusicManagerActivity.this.findViewById(R.id.tv_free_space);
        }
    });
    private int mMusicItemLayout = R.layout.item_music;

    @OXOo.OOXIXo
    private final String TAG = "MusicManagerActivity";
    private int isTransferTip = R.string.transfering;
    private final int loadTimeOut = 255;

    @OXOo.OOXIXo
    private Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.sma.smartv3.ui.device.O0xxXxI
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            boolean mHandler$lambda$0;
            mHandler$lambda$0 = MusicManagerActivity.mHandler$lambda$0(MusicManagerActivity.this, message);
            return mHandler$lambda$0;
        }
    });

    @OXOo.OOXIXo
    private final List<FileStruct> mFiles = new ArrayList();

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mDeviceFileCallback$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<MusicManagerActivity$mDeviceFileCallback$2.oIX0oI>() { // from class: com.sma.smartv3.ui.device.MusicManagerActivity$mDeviceFileCallback$2

        /* loaded from: classes12.dex */
        public static final class oIX0oI implements DeviceFileManager.oIX0oI {

            /* renamed from: oIX0oI, reason: collision with root package name */
            public final /* synthetic */ MusicManagerActivity f21951oIX0oI;

            public oIX0oI(MusicManagerActivity musicManagerActivity) {
                this.f21951oIX0oI = musicManagerActivity;
            }

            @Override // com.sma.smartv3.ui.device.DeviceFileManager.oIX0oI
            public void I0Io(int i) {
                this.f21951oIX0oI.refreshTaskPanel(i, 0);
            }

            @Override // com.sma.smartv3.ui.device.DeviceFileManager.oIX0oI
            public void II0xO0(int i, int i2, @OXOo.OOXIXo String msg) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(msg, "msg");
                this.f21951oIX0oI.getTvCancel().setVisibility(8);
                this.f21951oIX0oI.getTvRetry().setVisibility(0);
                this.f21951oIX0oI.getTvProgressTip().setText(R.string.music_transfer_task_failed_tip);
                this.f21951oIX0oI.getPbProgress().setProgress(0);
                ToastUtils.showLong(DeviceFileManager.f21743oIX0oI.xoXoI().get(i).XO() + '\n' + i2 + ':' + msg, new Object[0]);
            }

            @Override // com.sma.smartv3.ui.device.DeviceFileManager.oIX0oI
            public void X0o0xo(int i, boolean z) {
                if (z) {
                    this.f21951oIX0oI.getTaskPanel().setVisibility(8);
                    this.f21951oIX0oI.onMusicFileTransferStop();
                    this.f21951oIX0oI.getSDCardInfo();
                }
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f21951oIX0oI.getTAG() + " onFileTransferFinish");
                this.f21951oIX0oI.getDeviceFileList();
            }

            @Override // com.sma.smartv3.ui.device.DeviceFileManager.oIX0oI
            public void XO(int i) {
                this.f21951oIX0oI.getTaskPanel().setVisibility(8);
                this.f21951oIX0oI.onMusicFileTransferStop();
            }

            @Override // com.sma.smartv3.ui.device.DeviceFileManager.oIX0oI
            public void oIX0oI(int i) {
                DeviceFileManager.oIX0oI.C0943oIX0oI.oIX0oI(this, i);
                if (DeviceFileManager.f21743oIX0oI.OxI()) {
                    this.f21951oIX0oI.dismissLoadPopup();
                }
                this.f21951oIX0oI.getSDCardInfo();
            }

            @Override // com.sma.smartv3.ui.device.DeviceFileManager.oIX0oI
            public void oxoX(int i, int i2) {
                this.f21951oIX0oI.refreshTaskPanel(i, i2);
            }
        }

        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final oIX0oI invoke() {
            return new oIX0oI(MusicManagerActivity.this);
        }
    });

    @OXOo.OOXIXo
    private final oxoX mFileObserver = new oxoX();

    @OXOo.OOXIXo
    private I0Io mBleHandleCallback = new I0Io();

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
        public void onReadSDCardInfo(@OXOo.OOXIXo BleSDCardInfo sdCardInfo) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(sdCardInfo, "sdCardInfo");
            MusicManagerActivity.this.showFreeSpace();
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
        public void onSDCardInfoUpdate(@OXOo.OOXIXo BleSDCardInfo sdCardInfo) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(sdCardInfo, "sdCardInfo");
            MusicManagerActivity.this.showFreeSpace();
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
    public static final class II0xO0 implements DeleteCallback {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ int f21949II0xO0;

        public II0xO0(int i) {
            this.f21949II0xO0 = i;
        }

        @Override // com.jieli.jl_filebrowse.interfaces.DeleteCallback
        public void onError(int i, @OXOo.OOXIXo FileStruct file) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(file, "file");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(MusicManagerActivity.this.getTAG() + " -> onDeviceFileDeleteError " + i + ", " + file);
            MusicManagerActivity.this.dismissLoadPopup();
            ToastUtils.showLong(i + '-' + file.getName() + MusicManagerActivity.this.getString(R.string.failed_to_delete), new Object[0]);
        }

        @Override // com.jieli.jl_filebrowse.interfaces.DeleteCallback
        public void onFinish() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(MusicManagerActivity.this.getTAG() + " -> onDeviceFileDeleteFinish");
            MusicManagerActivity.this.getMFiles().remove(this.f21949II0xO0);
            MusicManagerActivity.this.showList();
        }

        @Override // com.jieli.jl_filebrowse.interfaces.DeleteCallback
        public void onSuccess(@OXOo.OOXIXo FileStruct p0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(p0, "p0");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(MusicManagerActivity.this.getTAG() + " -> onDeviceFileDelete " + p0);
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends SimpleFileObserver {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ String f21952I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ SDCardBean f21953II0xO0;

        public oIX0oI(SDCardBean sDCardBean, String str) {
            this.f21953II0xO0 = sDCardBean;
            this.f21952I0Io = str;
        }

        @Override // com.jieli.jl_filebrowse.interfaces.SimpleFileObserver, com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onFileReadFailed(int i) {
            super.onFileReadFailed(i);
            FileBrowseManager.getInstance().removeFileObserver(this);
        }

        @Override // com.jieli.jl_filebrowse.interfaces.SimpleFileObserver, com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onFileReadStop(boolean z) {
            super.onFileReadStop(z);
            FileBrowseManager.getInstance().removeFileObserver(this);
            MusicManagerActivity.this.browToDir(this.f21953II0xO0, this.f21952I0Io);
        }

        @Override // com.jieli.jl_filebrowse.interfaces.SimpleFileObserver, com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onSdCardStatusChange(@OXOo.OOXIXo List<? extends SDCardBean> onLineCards) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(onLineCards, "onLineCards");
            super.onSdCardStatusChange(onLineCards);
            FileBrowseManager.getInstance().removeFileObserver(this);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nMusicManagerActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MusicManagerActivity.kt\ncom/sma/smartv3/ui/device/MusicManagerActivity$mFileObserver$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,670:1\n766#2:671\n857#2,2:672\n1#3:674\n*S KotlinDebug\n*F\n+ 1 MusicManagerActivity.kt\ncom/sma/smartv3/ui/device/MusicManagerActivity$mFileObserver$1\n*L\n207#1:671\n207#1:672,2\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class oxoX implements FileObserver {
        public oxoX() {
        }

        @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
        public void OnFlayCallback(boolean z) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(MusicManagerActivity.this.getTAG() + " -> OnFlayCallback " + z);
        }

        @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onFileReadFailed(int i) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(MusicManagerActivity.this.getTAG() + " -> onFileReadFailed " + i);
        }

        @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onFileReadStart() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(MusicManagerActivity.this.getTAG() + " -> onFileReadStart");
        }

        @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onFileReadStop(boolean z) {
            Folder currentReadFile = FileBrowseManager.getInstance().getCurrentReadFile(MusicManagerActivity.this.getMSDCardBean());
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(MusicManagerActivity.this.getTAG() + " -> onFileReadStop " + z + TokenParser.SP + currentReadFile.getName());
            if (!z) {
                MusicManagerActivity musicManagerActivity = MusicManagerActivity.this;
                musicManagerActivity.loadMore(musicManagerActivity.getMSDCardBean());
            } else if (kotlin.text.OxI.oX0I0O(currentReadFile.getName(), "music", true)) {
                try {
                    MusicManagerActivity.this.showList();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onFileReceiver(@OXOo.OOXIXo List<FileStruct> fileStructs) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(fileStructs, "fileStructs");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(MusicManagerActivity.this.getTAG() + " -> onFileReceiver size:" + fileStructs.size() + ", " + fileStructs);
            List<FileStruct> mFiles = MusicManagerActivity.this.getMFiles();
            ArrayList arrayList = new ArrayList();
            for (Object obj : fileStructs) {
                FileStruct fileStruct = (FileStruct) obj;
                String name = fileStruct.getName();
                kotlin.jvm.internal.IIX0o.oO(name, "getName(...)");
                if (!StringsKt__StringsKt.ooO0oXxI(name, ".tmp", true)) {
                    String name2 = fileStruct.getName();
                    kotlin.jvm.internal.IIX0o.oO(name2, "getName(...)");
                    if (!StringsKt__StringsKt.ooO0oXxI(name2, ".txt", true)) {
                        arrayList.add(obj);
                    }
                }
            }
            mFiles.addAll(arrayList);
        }

        @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onSdCardStatusChange(@OXOo.OOXIXo List<SDCardBean> list) {
            Object obj;
            kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(MusicManagerActivity.this.getTAG() + " -> onSdCardStatusChange " + list);
            MusicManagerActivity musicManagerActivity = MusicManagerActivity.this;
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((SDCardBean) obj).isOnline()) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            musicManagerActivity.setMSDCardBean((SDCardBean) obj);
            MusicManagerActivity.this.getMFiles().clear();
            MusicManagerActivity musicManagerActivity2 = MusicManagerActivity.this;
            musicManagerActivity2.getCurrentInfo(musicManagerActivity2.getMSDCardBean());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void add() {
        if (!DeviceFileManager.f21743oIX0oI.OxI()) {
            showErrorPop();
        } else {
            doTransfer(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.MusicManagerActivity$add$1
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
                    MusicManagerActivity.this.pickFile();
                }
            });
        }
    }

    private final void append(SDCardBean sDCardBean, FileStruct fileStruct) {
        int appenBrowse = FileBrowseManager.getInstance().appenBrowse(fileStruct, sDCardBean);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> appendToDir " + appenBrowse);
        if (appenBrowse == 0) {
            this.mFiles.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void browToDir(SDCardBean sDCardBean, String str) {
        Object obj;
        Folder currentReadFile = FileBrowseManager.getInstance().getCurrentReadFile(sDCardBean);
        if (currentReadFile == null) {
            return;
        }
        while (currentReadFile.getParent() != null) {
            FileBrowseManager.getInstance().backBrowse(sDCardBean, false);
            currentReadFile = FileBrowseManager.getInstance().getCurrentReadFile(sDCardBean);
            kotlin.jvm.internal.IIX0o.oO(currentReadFile, "getCurrentReadFile(...)");
        }
        List<FileStruct> childFileStructs = currentReadFile.getChildFileStructs();
        kotlin.jvm.internal.IIX0o.oO(childFileStructs, "getChildFileStructs(...)");
        Iterator<T> it = childFileStructs.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                FileStruct fileStruct = (FileStruct) obj;
                if (!fileStruct.isFile() && kotlin.text.OxI.oX0I0O(fileStruct.getName(), str, true)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        FileStruct fileStruct2 = (FileStruct) obj;
        if (fileStruct2 != null) {
            append(sDCardBean, fileStruct2);
            return;
        }
        if (!currentReadFile.isLoadFinished(false)) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> browseToDir add simpleFileObserver");
            oIX0oI oix0oi = new oIX0oI(sDCardBean, str);
            FileBrowseManager.getInstance().addFileObserver(oix0oi);
            FileBrowseManager.getInstance().setPageSize(30);
            if (FileBrowseManager.getInstance().loadMore(sDCardBean) != 0) {
                FileBrowseManager.getInstance().removeFileObserver(oix0oi);
            }
        }
    }

    private final boolean canLoadMore(SDCardBean sDCardBean) {
        Folder currentReadFile = FileBrowseManager.getInstance().getCurrentReadFile(sDCardBean);
        if (currentReadFile == null || currentReadFile.isLoadFinished(false)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteFile(int i) {
        Integer num;
        boolean z = false;
        if (this.mFiles.size() == 0) {
            showList();
            dismissLoadPopup();
            ToastUtils.showLong(getString(R.string.failed_to_delete), new Object[0]);
            return;
        }
        FileBrowseManager fileBrowseManager = FileBrowseManager.getInstance();
        SDCardBean sDCardBean = this.mSDCardBean;
        List<FileStruct> XOxIOxOx2 = CollectionsKt__CollectionsKt.XOxIOxOx(this.mFiles.get(i));
        SDCardBean sDCardBean2 = this.mSDCardBean;
        if (sDCardBean2 != null) {
            num = Integer.valueOf(sDCardBean2.getType());
        } else {
            num = null;
        }
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(num);
        if (num.intValue() > 1) {
            z = true;
        }
        fileBrowseManager.deleteFile(sDCardBean, XOxIOxOx2, z, new II0xO0(i));
    }

    private final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getCurrentInfo(SDCardBean sDCardBean) {
        Folder currentReadFile = FileBrowseManager.getInstance().getCurrentReadFile(sDCardBean);
        if (currentReadFile == null) {
            return;
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> getCurrentInfo folder " + currentReadFile.getName());
        if (kotlin.text.OxI.oX0I0O(currentReadFile.getName(), "music", true) && currentReadFile.getLevel() == 1) {
            if (!currentReadFile.isLoadFinished(false) && currentReadFile.getChildFileStructs().size() < 1) {
                loadMore(sDCardBean);
                return;
            } else {
                currentReadFile.isLoadFinished(false);
                return;
            }
        }
        browToDir(sDCardBean, "music");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDeviceFileList$lambda$1(MusicManagerActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.mFiles.size() == 0) {
            this$0.browToDirDeviceFile();
        } else {
            this$0.loadMore(this$0.mSDCardBean);
        }
    }

    private final MusicManagerActivity$mDeviceFileCallback$2.oIX0oI getMDeviceFileCallback() {
        return (MusicManagerActivity$mDeviceFileCallback$2.oIX0oI) this.mDeviceFileCallback$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getSDCardInfo() {
        if (ProductManager.f20544oIX0oI.OXxx0OO()) {
            BleConnector.sendData$default(BleConnector.INSTANCE, BleKey.SDCARD_INFO, BleKeyFlag.READ, null, false, false, 28, null);
        }
    }

    private final TextView getTvName() {
        return (TextView) this.tvName$delegate.getValue();
    }

    private final TextView getTvProgress() {
        return (TextView) this.tvProgress$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$2(MusicManagerActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        showLoadPopup$default(this$0, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMore(SDCardBean sDCardBean) {
        int loadMore = FileBrowseManager.getInstance().loadMore(sDCardBean);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> loadMoreFile " + loadMore);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mHandler$lambda$0(MusicManagerActivity this$0, Message it) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
        if (it.what == this$0.loadTimeOut) {
            this$0.dismissLoadPopup();
            if (!DeviceFileManager.f21743oIX0oI.OxI()) {
                this$0.showErrorPop();
            }
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.TAG + " loadTimeOut retryFrequency=" + this$0.retryFrequency);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pickFile() {
        new MusicPicker.Builder(this).hideScrollbar(false).setMaxSelectCount(0).showTrack(true).searchIconColor(-1).setChoiceMode(0).bubbleTextColor(-1).setTitleText(getString(R.string.picker_music_title)).setLoadingType(1).showPickerForResult(990);
    }

    public static /* synthetic */ void preventUse$default(MusicManagerActivity musicManagerActivity, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            musicManagerActivity.preventUse(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preventUse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshTaskPanel(int i, int i2) {
        getTvProgressTip().setText(R.string.music_transfer_task_tip);
        getTvCancel().setVisibility(0);
        getTvRetry().setVisibility(8);
        DeviceFileManager deviceFileManager = DeviceFileManager.f21743oIX0oI;
        if (deviceFileManager.X0IIOO()) {
            getTaskPanel().setVisibility(0);
        }
        getTvName().setText(deviceFileManager.xoXoI().get(i).XO());
        TextView tvTotalProgress = getTvTotalProgress();
        StringBuilder sb = new StringBuilder();
        sb.append(i + 1);
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb.append(deviceFileManager.xoXoI().size());
        tvTotalProgress.setText(sb.toString());
        getPbProgress().setProgress(i2);
        TextView tvProgress = getTvProgress();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i2);
        sb2.append(org.apache.log4j.helpers.x0XOIxOo.f33309xxIXOIIO);
        tvProgress.setText(sb2.toString());
    }

    private final void showErrorPop() {
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0;
        if (this.mErrorPopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = new com.sma.smartv3.pop.XoI0Ixx0(getMContext(), 0, 2, null);
            xoI0Ixx02.IoOoX(R.string.bt3_connect_error);
            xoI0Ixx02.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.MusicManagerActivity$showErrorPop$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    MusicManagerActivity.this.preventUse(true);
                    return Boolean.TRUE;
                }
            });
            xoI0Ixx02.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.MusicManagerActivity$showErrorPop$1$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    MusicManagerActivity.oxoX oxox;
                    MusicManagerActivity.oxoX oxox2;
                    MusicManagerActivity.showLoadPopup$default(MusicManagerActivity.this, false, 1, null);
                    MusicManagerActivity musicManagerActivity = MusicManagerActivity.this;
                    musicManagerActivity.setRetryFrequency(musicManagerActivity.getRetryFrequency() + 1);
                    if (MusicManagerActivity.this.getRetryFrequency() > 2) {
                        MusicManagerActivity.this.setRetryFrequency(0);
                        FileBrowseManager fileBrowseManager = FileBrowseManager.getInstance();
                        oxox = MusicManagerActivity.this.mFileObserver;
                        fileBrowseManager.removeFileObserver(oxox);
                        DeviceFileManager deviceFileManager = DeviceFileManager.f21743oIX0oI;
                        deviceFileManager.IXxxXO();
                        Application application = MusicManagerActivity.this.getApplication();
                        kotlin.jvm.internal.IIX0o.oO(application, "getApplication(...)");
                        deviceFileManager.o00(application);
                        FileBrowseManager fileBrowseManager2 = FileBrowseManager.getInstance();
                        oxox2 = MusicManagerActivity.this.mFileObserver;
                        fileBrowseManager2.addFileObserver(oxox2);
                    }
                    DeviceFileManager.f21743oIX0oI.oO();
                    return Boolean.TRUE;
                }
            });
            this.mErrorPopup = xoI0Ixx02;
        }
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx03 = this.mErrorPopup;
        if ((xoI0Ixx03 == null || !xoI0Ixx03.isShowing()) && (xoI0Ixx0 = this.mErrorPopup) != null) {
            xoI0Ixx0.IIXOooo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showList() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("showList -> size:" + this.mFiles.size() + ", " + this.mFiles);
        preventUse(false);
        this.mHandler.removeMessages(this.loadTimeOut);
        dismissLoadPopup();
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = this.mErrorPopup;
        if (xoI0Ixx0 != null) {
            xoI0Ixx0.dismiss();
        }
        if (this.mFiles.isEmpty()) {
            getRecyclerView().setVisibility(4);
            findViewById(R.id.empty).setVisibility(0);
        } else {
            getDslAdapter().resetItem(new ArrayList());
            renderAdapter(new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.MusicManagerActivity$showList$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapter dslAdapter) {
                    invoke2(dslAdapter);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo DslAdapter renderAdapter) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                    MusicManagerActivity.this.findViewById(R.id.empty).setVisibility(8);
                    MusicManagerActivity.this.getRecyclerView().setVisibility(0);
                    for (final FileStruct fileStruct : MusicManagerActivity.this.getMFiles()) {
                        DslAdapter dslAdapter = MusicManagerActivity.this.getDslAdapter();
                        int mMusicItemLayout = MusicManagerActivity.this.getMMusicItemLayout();
                        final MusicManagerActivity musicManagerActivity = MusicManagerActivity.this;
                        DslAdapterExKt.oO(dslAdapter, mMusicItemLayout, new Oox.oOoXoXO<DslAdapterItem, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.MusicManagerActivity$showList$1.1

                            /* renamed from: com.sma.smartv3.ui.device.MusicManagerActivity$showList$1$1$1, reason: invalid class name and collision with other inner class name */
                            /* loaded from: classes12.dex */
                            public static final class C09491 extends Lambda implements Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, kotlin.oXIO0o0XI> {
                                final /* synthetic */ FileStruct $item;
                                final /* synthetic */ MusicManagerActivity this$0;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                public C09491(FileStruct fileStruct, MusicManagerActivity musicManagerActivity) {
                                    super(4);
                                    this.$item = fileStruct;
                                    this.this$0 = musicManagerActivity;
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final void invoke$lambda$0(final MusicManagerActivity this$0, final int i, View view) {
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                                    this$0.doTransfer(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: INVOKE 
                                          (r0v0 'this$0' com.sma.smartv3.ui.device.MusicManagerActivity)
                                          (wrap:Oox.oIX0oI<kotlin.oXIO0o0XI>:0x0007: CONSTRUCTOR (r0v0 'this$0' com.sma.smartv3.ui.device.MusicManagerActivity A[DONT_INLINE]), (r1v0 'i' int A[DONT_INLINE]) A[MD:(com.sma.smartv3.ui.device.MusicManagerActivity, int):void (m), WRAPPED] (LINE:8) call: com.sma.smartv3.ui.device.MusicManagerActivity$showList$1$1$1$1$1.<init>(com.sma.smartv3.ui.device.MusicManagerActivity, int):void type: CONSTRUCTOR)
                                         VIRTUAL call: com.sma.smartv3.ui.device.MusicManagerActivity.doTransfer(Oox.oIX0oI):boolean A[MD:(Oox.oIX0oI<kotlin.oXIO0o0XI>):boolean (m)] (LINE:11) in method: com.sma.smartv3.ui.device.MusicManagerActivity.showList.1.1.1.invoke$lambda$0(com.sma.smartv3.ui.device.MusicManagerActivity, int, android.view.View):void, file: classes12.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.MusicManagerActivity$showList$1$1$1$1$1, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                        	... 15 more
                                        */
                                    /*
                                        java.lang.String r2 = "this$0"
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(r0, r2)
                                        com.sma.smartv3.ui.device.MusicManagerActivity$showList$1$1$1$1$1 r2 = new com.sma.smartv3.ui.device.MusicManagerActivity$showList$1$1$1$1$1
                                        r2.<init>(r0, r1)
                                        r0.doTransfer(r2)
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.MusicManagerActivity$showList$1.AnonymousClass1.C09491.invoke$lambda$0(com.sma.smartv3.ui.device.MusicManagerActivity, int, android.view.View):void");
                                }

                                @Override // Oox.Oxx0xo
                                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                    invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                                }

                                public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, final int i, @OXOo.OOXIXo DslAdapterItem adapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(adapterItem, "adapterItem");
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                    TextView tv = itemHolder.tv(R.id.tv);
                                    if (tv != null) {
                                        tv.setText(this.$item.getName());
                                    }
                                    ImageView img = itemHolder.img(R.id.btn_delete);
                                    if (img != null) {
                                        final MusicManagerActivity musicManagerActivity = this.this$0;
                                        img.setOnClickListener(
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0032: INVOKE 
                                              (r2v1 'img' android.widget.ImageView)
                                              (wrap:android.view.View$OnClickListener:0x002f: CONSTRUCTOR 
                                              (r4v5 'musicManagerActivity' com.sma.smartv3.ui.device.MusicManagerActivity A[DONT_INLINE])
                                              (r3v0 'i' int A[DONT_INLINE])
                                             A[MD:(com.sma.smartv3.ui.device.MusicManagerActivity, int):void (m), WRAPPED] call: com.sma.smartv3.ui.device.IxX00.<init>(com.sma.smartv3.ui.device.MusicManagerActivity, int):void type: CONSTRUCTOR)
                                             VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] in method: com.sma.smartv3.ui.device.MusicManagerActivity.showList.1.1.1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List<? extends java.lang.Object>):void, file: classes12.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.IxX00, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                            	... 23 more
                                            */
                                        /*
                                            this = this;
                                            java.lang.String r0 = "itemHolder"
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
                                            java.lang.String r0 = "adapterItem"
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
                                            java.lang.String r4 = "<anonymous parameter 3>"
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r4)
                                            r4 = 2131368123(0x7f0a18bb, float:1.8356187E38)
                                            android.widget.TextView r4 = r2.tv(r4)
                                            if (r4 != 0) goto L19
                                            goto L22
                                        L19:
                                            com.jieli.jl_filebrowse.bean.FileStruct r5 = r1.$item
                                            java.lang.String r5 = r5.getName()
                                            r4.setText(r5)
                                        L22:
                                            r4 = 2131363436(0x7f0a066c, float:1.834668E38)
                                            android.widget.ImageView r2 = r2.img(r4)
                                            if (r2 == 0) goto L35
                                            com.sma.smartv3.ui.device.MusicManagerActivity r4 = r1.this$0
                                            com.sma.smartv3.ui.device.IxX00 r5 = new com.sma.smartv3.ui.device.IxX00
                                            r5.<init>(r4, r3)
                                            r2.setOnClickListener(r5)
                                        L35:
                                            return
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.MusicManagerActivity$showList$1.AnonymousClass1.C09491.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List):void");
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // Oox.oOoXoXO
                                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                    invoke2(dslAdapterItem);
                                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                    dslItem.setItemBindOverride(new C09491(FileStruct.this, musicManagerActivity));
                                }
                            });
                        }
                    }
                });
            }
        }

        public static /* synthetic */ void showLoadPopup$default(MusicManagerActivity musicManagerActivity, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = true;
                }
                musicManagerActivity.showLoadPopup(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoadPopup");
        }

        @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
        @OXOo.OOXIXo
        public DslAdapterStatusItem adapterStatusItem() {
            setAdapterStatus(new AdapterStatusItem());
            return getAdapterStatus();
        }

        public final void browToDirDeviceFile() {
            if (this.mFiles.size() >= 30) {
                loadMore(this.mSDCardBean);
            } else {
                browToDir(this.mSDCardBean, "music");
            }
        }

        public final void dismissLoadPopup() {
            com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = this.mLoadingPopup;
            if (i0X0x0oIo != null) {
                i0X0x0oIo.dismiss();
            }
        }

        public boolean doTransfer(@OXOo.OOXIXo Oox.oIX0oI<kotlin.oXIO0o0XI> action) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
            if (DeviceFileManager.f21743oIX0oI.X0IIOO()) {
                ToastUtils.showLong(getString(this.isTransferTip), new Object[0]);
                return false;
            }
            action.invoke();
            return true;
        }

        public void getDeviceFileList() {
            this.mHandler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.oxOXxoXII
                @Override // java.lang.Runnable
                public final void run() {
                    MusicManagerActivity.getDeviceFileList$lambda$1(MusicManagerActivity.this);
                }
            }, 300L);
        }

        public final int getMDownSuccessSize() {
            return this.mDownSuccessSize;
        }

        @OXOo.OOXIXo
        public final List<FileStruct> getMFiles() {
            return this.mFiles;
        }

        public final int getMMusicItemLayout() {
            return this.mMusicItemLayout;
        }

        @OXOo.oOoXoXO
        public final SDCardBean getMSDCardBean() {
            return this.mSDCardBean;
        }

        public final ProgressBar getPbProgress() {
            return (ProgressBar) this.pbProgress$delegate.getValue();
        }

        public final int getRetryFrequency() {
            return this.retryFrequency;
        }

        @OXOo.OOXIXo
        public final String getTAG() {
            return this.TAG;
        }

        public final View getTaskPanel() {
            return (View) this.taskPanel$delegate.getValue();
        }

        public final View getTvCancel() {
            return (View) this.tvCancel$delegate.getValue();
        }

        public final TextView getTvFreeSpace() {
            return (TextView) this.tvFreeSpace$delegate.getValue();
        }

        public final TextView getTvProgressTip() {
            return (TextView) this.tvProgressTip$delegate.getValue();
        }

        public final View getTvRetry() {
            return (View) this.tvRetry$delegate.getValue();
        }

        public final TextView getTvTotalProgress() {
            return (TextView) this.tvTotalProgress$delegate.getValue();
        }

        @Override // com.bestmafen.androidbase.base.oIX0oI
        public void init(@OXOo.oOoXoXO Bundle bundle) {
            BleConnector.INSTANCE.addHandleCallback(this.mBleHandleCallback);
            DeviceFileManager deviceFileManager = DeviceFileManager.f21743oIX0oI;
            Application application = getApplication();
            kotlin.jvm.internal.IIX0o.oO(application, "getApplication(...)");
            deviceFileManager.o00(application);
            FileBrowseManager.getInstance().addFileObserver(this.mFileObserver);
            deviceFileManager.x0XOIxOo(getMDeviceFileCallback());
            this.mHandler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.xOOxIO
                @Override // java.lang.Runnable
                public final void run() {
                    MusicManagerActivity.init$lambda$2(MusicManagerActivity.this);
                }
            }, 600L);
            deviceFileManager.oO();
        }

        @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity, com.bestmafen.androidbase.base.oIX0oI
        public void initView() {
            super.initView();
            BleInitializer.f20700XO.xx0X0(true);
            ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.music_manager);
            showRightIcon();
            showFreeSpace();
        }

        public final int isTransferTip() {
            return this.isTransferTip;
        }

        @Override // com.bestmafen.androidbase.base.oIX0oI
        public int layoutId() {
            return R.layout.activity_music_manager;
        }

        @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
        public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
            String OOXIXo2;
            super.onActivityResult(i, i2, intent);
            if (i2 == -1 && i == 990) {
                DeviceFileManager deviceFileManager = DeviceFileManager.f21743oIX0oI;
                ArrayList<MusicResult> II0xO02 = MusicPicker.II0xO0(intent);
                kotlin.jvm.internal.IIX0o.oO(II0xO02, "obtainResult(...)");
                ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(II0xO02, 10));
                for (MusicResult musicResult : II0xO02) {
                    if (musicResult.OOXIXo().length() > 50) {
                        StringBuilder sb = new StringBuilder();
                        String OOXIXo3 = musicResult.OOXIXo();
                        kotlin.jvm.internal.IIX0o.oO(OOXIXo3, "getTitle(...)");
                        String substring = OOXIXo3.substring(0, 50);
                        kotlin.jvm.internal.IIX0o.oO(substring, "substring(...)");
                        sb.append(substring);
                        sb.append(".mp3");
                        OOXIXo2 = sb.toString();
                    } else {
                        OOXIXo2 = musicResult.OOXIXo();
                    }
                    String ooOOo0oXI2 = musicResult.ooOOo0oXI();
                    String oOoXoXO2 = musicResult.oOoXoXO();
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(OOXIXo2);
                    arrayList.add(new ox0I(ooOOo0oXI2, oOoXoXO2, OOXIXo2));
                }
                deviceFileManager.oOXoIIIo(arrayList);
                DeviceFileManager.f21743oIX0oI.X00IoxXI(this.mSDCardBean);
                onMusicFileTransferStart();
            }
        }

        @Override // androidx.activity.ComponentActivity, android.app.Activity
        public void onBackPressed() {
            if (doTransfer(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.MusicManagerActivity$onBackPressed$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // Oox.oIX0oI
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
                    invoke2();
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }
            })) {
                super.onBackPressed();
            }
        }

        public final void onBottomClick(@OXOo.OOXIXo View view) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
            if (Build.VERSION.SDK_INT >= 33) {
                PermissionUtils permission = PermissionUtils.permission("android.permission.READ_MEDIA_AUDIO");
                kotlin.jvm.internal.IIX0o.oO(permission, "permission(...)");
                oOXoIIIo.X0o0xo.I0Io(permission, null, null, new Oox.oOoXoXO<PermissionStatus, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.MusicManagerActivity$onBottomClick$1
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
                        if (it == PermissionStatus.GRANTED) {
                            MusicManagerActivity.this.add();
                        }
                    }
                }, 3, null);
            } else {
                PermissionUtils permission2 = PermissionUtils.permission(PermissionConstants.STORAGE);
                kotlin.jvm.internal.IIX0o.oO(permission2, "permission(...)");
                oOXoIIIo.X0o0xo.I0Io(permission2, null, null, new Oox.oOoXoXO<PermissionStatus, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.MusicManagerActivity$onBottomClick$2
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
                        if (it == PermissionStatus.GRANTED) {
                            MusicManagerActivity.this.add();
                        }
                    }
                }, 3, null);
            }
        }

        public void onCancel(@OXOo.OOXIXo View view) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(getMContext(), 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.cancel_transfer);
            xoI0Ixx0.xI(Integer.valueOf(R.string.cancel_transfer_music_tip));
            xoI0Ixx0.oo0xXOI0I(1);
            xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.MusicManagerActivity$onCancel$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    return Boolean.TRUE;
                }
            });
            xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.MusicManagerActivity$onCancel$1$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    DeviceFileManager.f21743oIX0oI.IO();
                    MusicManagerActivity.this.getTaskPanel().setVisibility(8);
                    MusicManagerActivity.this.onMusicFileTransferStop();
                    return Boolean.TRUE;
                }
            });
            xoI0Ixx0.IIXOooo();
        }

        @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onDestroy() {
            this.mHandler.removeCallbacksAndMessages(null);
            BleConnector.INSTANCE.removeHandleCallback(this.mBleHandleCallback);
            FileBrowseManager.getInstance().removeFileObserver(this.mFileObserver);
            DeviceFileManager deviceFileManager = DeviceFileManager.f21743oIX0oI;
            deviceFileManager.XxX0x0xxx(getMDeviceFileCallback());
            deviceFileManager.IXxxXO();
            BleInitializer.f20700XO.xx0X0(false);
            super.onDestroy();
        }

        public void onMusicFileTransferStart() {
        }

        public void onMusicFileTransferStop() {
        }

        public final void onRetry(@OXOo.OOXIXo View view) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
            DeviceFileManager.f21743oIX0oI.xXxxox0I();
        }

        public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
            doTransfer(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.MusicManagerActivity$onTitleLeftClick$1
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
                    MusicManagerActivity.this.finish();
                }
            });
        }

        public final void onTitleRightClick(@OXOo.OOXIXo View view) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
            Bundle bundle = new Bundle();
            bundle.putString("mArg0", "https://api.iot-solution.net/web/help/help_music.html");
            bundle.putInt("mArg1", 2);
            bundle.putParcelable("mArg2", null);
            bundle.putSerializable("mArg3", null);
            Intent intent = new Intent(this, (Class<?>) WebViewActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }

        public void preventUse(boolean z) {
        }

        @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
        public int recyclerViewId() {
            return R.id.rv;
        }

        @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
        public int refreshLayoutId() {
            return 0;
        }

        public final void setMDownSuccessSize(int i) {
            this.mDownSuccessSize = i;
        }

        public final void setMMusicItemLayout(int i) {
            this.mMusicItemLayout = i;
        }

        public final void setMSDCardBean(@OXOo.oOoXoXO SDCardBean sDCardBean) {
            this.mSDCardBean = sDCardBean;
        }

        public final void setRetryFrequency(int i) {
            this.retryFrequency = i;
        }

        public final void setTransferTip(int i) {
            this.isTransferTip = i;
        }

        public void showFreeSpace() {
            int i;
            TextView tvFreeSpace = getTvFreeSpace();
            if (ProductManager.f20544oIX0oI.OXxx0OO()) {
                i = 0;
            } else {
                i = 8;
            }
            tvFreeSpace.setVisibility(i);
            getTvFreeSpace().setText(getString(R.string.watch_free_space, TextConvertKt.OO0x0xX((BleSDCardInfo) BleCache.getObject$default(BleCache.INSTANCE, BleKey.SDCARD_INFO, BleSDCardInfo.class, null, 4, null), false, 2, null)));
        }

        public final void showLoadPopup(boolean z) {
            if (this.mLoadingPopup == null) {
                this.mLoadingPopup = new com.sma.smartv3.pop.I0X0x0oIo(this);
            }
            com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = this.mLoadingPopup;
            if (i0X0x0oIo != null) {
                if (z) {
                    i0X0x0oIo.xXxxox0I(R.string.music_transfer_load_title);
                    i0X0x0oIo.xxX(Integer.valueOf(R.string.music_transfer_load_tip));
                    this.mHandler.sendEmptyMessageDelayed(this.loadTimeOut, 25000L);
                } else {
                    i0X0x0oIo.xXxxox0I(0);
                    i0X0x0oIo.xxX(null);
                }
            }
            com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo2 = this.mLoadingPopup;
            if (i0X0x0oIo2 != null) {
                i0X0x0oIo2.IIXOooo();
            }
        }

        public final void showRightIcon() {
            getAbhTitleRight().setVisibility(0);
            getAbhTitleRight().setImageResource(R.drawable.understand_situation_icon2);
            getAbhTitleRight().setImageTintList(oIxOXo.oxoX.X0o0xo(this, R.color.text_color));
        }
    }
