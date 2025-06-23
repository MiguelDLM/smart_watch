package com.sma.smartv3.ui.device;

import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
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
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.UriUtils;
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
import com.sma.smartv3.ui.device.DeviceFileManager;
import com.sma.smartv3.ui.device.EBookManagerActivity;
import com.sma.smartv3.ui.device.EBookManagerActivity$mDeviceFileCallback$2;
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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;

@kotlin.jvm.internal.XX({"SMAP\nEBookManagerActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EBookManagerActivity.kt\ncom/sma/smartv3/ui/device/EBookManagerActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,687:1\n1#2:688\n*E\n"})
/* loaded from: classes12.dex */
public final class EBookManagerActivity extends BaseDSLRecyclerActivity {

    @OXOo.oOoXoXO
    private File cacheFile;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mErrorPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.I0X0x0oIo mLoadingPopup;

    @OXOo.oOoXoXO
    private SDCardBean mSDCardBean;
    private int onFileReceiverSize;
    private int retryFrequency;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvTotalProgress$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.EBookManagerActivity$tvTotalProgress$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) EBookManagerActivity.this.findViewById(R.id.tv_total_progress);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvName$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.EBookManagerActivity$tvName$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) EBookManagerActivity.this.findViewById(R.id.tv_name);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvProgress$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.EBookManagerActivity$tvProgress$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) EBookManagerActivity.this.findViewById(R.id.tv_progress);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvProgressTip$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.EBookManagerActivity$tvProgressTip$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) EBookManagerActivity.this.findViewById(R.id.tv_progress_tip);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO pbProgress$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ProgressBar>() { // from class: com.sma.smartv3.ui.device.EBookManagerActivity$pbProgress$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ProgressBar invoke() {
            return (ProgressBar) EBookManagerActivity.this.findViewById(R.id.pb_progress);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO taskPanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.EBookManagerActivity$taskPanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return EBookManagerActivity.this.findViewById(R.id.task_panel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvCancel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.EBookManagerActivity$tvCancel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return EBookManagerActivity.this.findViewById(R.id.tv_cancel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvRetry$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.EBookManagerActivity$tvRetry$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return EBookManagerActivity.this.findViewById(R.id.tv_retry);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvFreeSpace$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.EBookManagerActivity$tvFreeSpace$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) EBookManagerActivity.this.findViewById(R.id.tv_free_space);
        }
    });

    @OXOo.OOXIXo
    private final String TAG = "EBookManagerActivity";

    @OXOo.OOXIXo
    private final List<FileStruct> mFiles = new ArrayList();
    private final int loadTimeOut = 255;

    @OXOo.OOXIXo
    private Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.sma.smartv3.ui.device.XX
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            boolean mHandler$lambda$0;
            mHandler$lambda$0 = EBookManagerActivity.mHandler$lambda$0(EBookManagerActivity.this, message);
            return mHandler$lambda$0;
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mDeviceFileCallback$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EBookManagerActivity$mDeviceFileCallback$2.oIX0oI>() { // from class: com.sma.smartv3.ui.device.EBookManagerActivity$mDeviceFileCallback$2

        /* loaded from: classes12.dex */
        public static final class oIX0oI implements DeviceFileManager.oIX0oI {

            /* renamed from: oIX0oI, reason: collision with root package name */
            public final /* synthetic */ EBookManagerActivity f21767oIX0oI;

            public oIX0oI(EBookManagerActivity eBookManagerActivity) {
                this.f21767oIX0oI = eBookManagerActivity;
            }

            @Override // com.sma.smartv3.ui.device.DeviceFileManager.oIX0oI
            public void I0Io(int i) {
                this.f21767oIX0oI.refreshTaskPanel(i, 0);
            }

            @Override // com.sma.smartv3.ui.device.DeviceFileManager.oIX0oI
            public void II0xO0(int i, int i2, @OXOo.OOXIXo String msg) {
                View tvCancel;
                View tvRetry;
                TextView tvProgressTip;
                ProgressBar pbProgress;
                kotlin.jvm.internal.IIX0o.x0xO0oo(msg, "msg");
                tvCancel = this.f21767oIX0oI.getTvCancel();
                tvCancel.setVisibility(8);
                tvRetry = this.f21767oIX0oI.getTvRetry();
                tvRetry.setVisibility(0);
                tvProgressTip = this.f21767oIX0oI.getTvProgressTip();
                tvProgressTip.setText(R.string.ebook_transfer_task_failed_tip);
                pbProgress = this.f21767oIX0oI.getPbProgress();
                pbProgress.setProgress(0);
                ToastUtils.showLong(DeviceFileManager.f21743oIX0oI.xoXoI().get(i).XO() + '\n' + i2 + ':' + msg, new Object[0]);
            }

            @Override // com.sma.smartv3.ui.device.DeviceFileManager.oIX0oI
            public void X0o0xo(int i, boolean z) {
                EBookManagerActivity.oxoX oxox;
                EBookManagerActivity.oxoX oxox2;
                View taskPanel;
                if (z) {
                    taskPanel = this.f21767oIX0oI.getTaskPanel();
                    taskPanel.setVisibility(8);
                    this.f21767oIX0oI.getSDCardInfo();
                }
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f21767oIX0oI.TAG + " onFileTransferFinish");
                if (this.f21767oIX0oI.getMFiles().size() == 0) {
                    FileBrowseManager fileBrowseManager = FileBrowseManager.getInstance();
                    oxox = this.f21767oIX0oI.mFileObserver;
                    fileBrowseManager.removeFileObserver(oxox);
                    DeviceFileManager deviceFileManager = DeviceFileManager.f21743oIX0oI;
                    deviceFileManager.IXxxXO();
                    Application application = this.f21767oIX0oI.getApplication();
                    kotlin.jvm.internal.IIX0o.oO(application, "getApplication(...)");
                    deviceFileManager.o00(application);
                    FileBrowseManager fileBrowseManager2 = FileBrowseManager.getInstance();
                    oxox2 = this.f21767oIX0oI.mFileObserver;
                    fileBrowseManager2.addFileObserver(oxox2);
                    this.f21767oIX0oI.showLoadPopup(false);
                    deviceFileManager.oO();
                } else if (this.f21767oIX0oI.getOnFileReceiverSize() > 30) {
                    EBookManagerActivity eBookManagerActivity = this.f21767oIX0oI;
                    eBookManagerActivity.loadMore(eBookManagerActivity.getMSDCardBean());
                } else {
                    EBookManagerActivity eBookManagerActivity2 = this.f21767oIX0oI;
                    eBookManagerActivity2.browToDir(eBookManagerActivity2.getMSDCardBean(), "music");
                }
                if (this.f21767oIX0oI.getCacheFile() != null) {
                    File cacheFile = this.f21767oIX0oI.getCacheFile();
                    if (cacheFile != null) {
                        cacheFile.delete();
                    }
                    this.f21767oIX0oI.setCacheFile(null);
                }
            }

            @Override // com.sma.smartv3.ui.device.DeviceFileManager.oIX0oI
            public void XO(int i) {
                View taskPanel;
                taskPanel = this.f21767oIX0oI.getTaskPanel();
                taskPanel.setVisibility(8);
            }

            @Override // com.sma.smartv3.ui.device.DeviceFileManager.oIX0oI
            public void oIX0oI(int i) {
                DeviceFileManager.oIX0oI.C0943oIX0oI.oIX0oI(this, i);
                if (DeviceFileManager.f21743oIX0oI.OxI()) {
                    this.f21767oIX0oI.dismissLoadPopup();
                }
            }

            @Override // com.sma.smartv3.ui.device.DeviceFileManager.oIX0oI
            public void oxoX(int i, int i2) {
                this.f21767oIX0oI.refreshTaskPanel(i, i2);
            }
        }

        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final oIX0oI invoke() {
            return new oIX0oI(EBookManagerActivity.this);
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
            EBookManagerActivity.this.showFreeSpace();
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
            EBookManagerActivity.this.showFreeSpace();
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
        public final /* synthetic */ int f21765II0xO0;

        public II0xO0(int i) {
            this.f21765II0xO0 = i;
        }

        @Override // com.jieli.jl_filebrowse.interfaces.DeleteCallback
        public void onError(int i, @OXOo.OOXIXo FileStruct file) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(file, "file");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(EBookManagerActivity.this.TAG + " -> onDeviceFileDeleteError " + i + ", " + file);
            EBookManagerActivity.this.dismissLoadPopup();
            ToastUtils.showLong(i + '-' + file.getName() + EBookManagerActivity.this.getString(R.string.failed_to_delete), new Object[0]);
        }

        @Override // com.jieli.jl_filebrowse.interfaces.DeleteCallback
        public void onFinish() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(EBookManagerActivity.this.TAG + " -> onDeviceFileDeleteFinish");
            EBookManagerActivity.this.getMFiles().remove(this.f21765II0xO0);
            EBookManagerActivity.this.showList();
        }

        @Override // com.jieli.jl_filebrowse.interfaces.DeleteCallback
        public void onSuccess(@OXOo.OOXIXo FileStruct p0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(p0, "p0");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(EBookManagerActivity.this.TAG + " -> onDeviceFileDelete " + p0);
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends SimpleFileObserver {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ String f21768I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ SDCardBean f21769II0xO0;

        public oIX0oI(SDCardBean sDCardBean, String str) {
            this.f21769II0xO0 = sDCardBean;
            this.f21768I0Io = str;
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
            EBookManagerActivity.this.browToDir(this.f21769II0xO0, this.f21768I0Io);
        }

        @Override // com.jieli.jl_filebrowse.interfaces.SimpleFileObserver, com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onSdCardStatusChange(@OXOo.OOXIXo List<? extends SDCardBean> onLineCards) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(onLineCards, "onLineCards");
            super.onSdCardStatusChange(onLineCards);
            FileBrowseManager.getInstance().removeFileObserver(this);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nEBookManagerActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EBookManagerActivity.kt\ncom/sma/smartv3/ui/device/EBookManagerActivity$mFileObserver$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,687:1\n766#2:688\n857#2,2:689\n1#3:691\n*S KotlinDebug\n*F\n+ 1 EBookManagerActivity.kt\ncom/sma/smartv3/ui/device/EBookManagerActivity$mFileObserver$1\n*L\n185#1:688\n185#1:689,2\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class oxoX implements FileObserver {
        public oxoX() {
        }

        @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
        public void OnFlayCallback(boolean z) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(EBookManagerActivity.this.TAG + " -> OnFlayCallback " + z);
        }

        @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onFileReadFailed(int i) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(EBookManagerActivity.this.TAG + " -> onFileReadFailed " + i);
        }

        @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onFileReadStart() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(EBookManagerActivity.this.TAG + " -> onFileReadStart");
        }

        @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onFileReadStop(boolean z) {
            Folder currentReadFile = FileBrowseManager.getInstance().getCurrentReadFile(EBookManagerActivity.this.getMSDCardBean());
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(EBookManagerActivity.this.TAG + " -> onFileReadStop " + z + TokenParser.SP + currentReadFile.getName());
            if (!z) {
                EBookManagerActivity eBookManagerActivity = EBookManagerActivity.this;
                eBookManagerActivity.loadMore(eBookManagerActivity.getMSDCardBean());
            } else if (kotlin.text.OxI.oX0I0O(currentReadFile.getName(), "music", true)) {
                EBookManagerActivity.this.showList();
            }
        }

        @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
        public void onFileReceiver(@OXOo.OOXIXo List<FileStruct> fileStructs) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(fileStructs, "fileStructs");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(EBookManagerActivity.this.TAG + " -> onFileReceiver size:" + fileStructs.size() + ", " + fileStructs);
            EBookManagerActivity.this.setOnFileReceiverSize(fileStructs.size());
            List<FileStruct> mFiles = EBookManagerActivity.this.getMFiles();
            ArrayList arrayList = new ArrayList();
            for (Object obj : fileStructs) {
                FileStruct fileStruct = (FileStruct) obj;
                String name = fileStruct.getName();
                kotlin.jvm.internal.IIX0o.oO(name, "getName(...)");
                if (!StringsKt__StringsKt.ooO0oXxI(name, ".tmp", true)) {
                    String name2 = fileStruct.getName();
                    kotlin.jvm.internal.IIX0o.oO(name2, "getName(...)");
                    if (!StringsKt__StringsKt.ooO0oXxI(name2, ".mp3", true)) {
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
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(EBookManagerActivity.this.TAG + " -> onSdCardStatusChange " + list);
            EBookManagerActivity eBookManagerActivity = EBookManagerActivity.this;
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
            eBookManagerActivity.setMSDCardBean((SDCardBean) obj);
            EBookManagerActivity.this.getMFiles().clear();
            EBookManagerActivity eBookManagerActivity2 = EBookManagerActivity.this;
            eBookManagerActivity2.getCurrentInfo(eBookManagerActivity2.getMSDCardBean());
        }
    }

    private final void add() {
        if (!DeviceFileManager.f21743oIX0oI.OxI()) {
            showErrorPop();
        } else {
            doTransfer(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.EBookManagerActivity$add$1
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
                    EBookManagerActivity.this.pickFile();
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

    private final Uri copyCacheFile(Uri uri) {
        String absolutePath = com.sma.smartv3.initializer.IXxxXO.XO(X00IoxXI.oIX0oI.f3233oIX0oI).getAbsolutePath();
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(absolutePath + "/utf_8.txt");
        file2.createNewFile();
        InputStream openInputStream = getContentResolver().openInputStream(uri);
        InputStreamReader inputStreamReader = new InputStreamReader(openInputStream, getFileCharsetSimple(uri));
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file2), "UTF-8");
        this.cacheFile = file2;
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            bufferedWriter.write(readLine + '\n');
        }
        bufferedWriter.flush();
        if (openInputStream != null) {
            openInputStream.close();
        }
        bufferedWriter.close();
        bufferedReader.close();
        Uri file2Uri = UriUtils.file2Uri(file2);
        kotlin.jvm.internal.IIX0o.oO(file2Uri, "file2Uri(...)");
        return file2Uri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteFile(int i) {
        Integer num;
        FileBrowseManager fileBrowseManager = FileBrowseManager.getInstance();
        SDCardBean sDCardBean = this.mSDCardBean;
        boolean z = true;
        List<FileStruct> XOxIOxOx2 = CollectionsKt__CollectionsKt.XOxIOxOx(this.mFiles.get(i));
        SDCardBean sDCardBean2 = this.mSDCardBean;
        if (sDCardBean2 != null) {
            num = Integer.valueOf(sDCardBean2.getType());
        } else {
            num = null;
        }
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(num);
        if (num.intValue() <= 1) {
            z = false;
        }
        fileBrowseManager.deleteFile(sDCardBean, XOxIOxOx2, z, new II0xO0(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissLoadPopup() {
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = this.mLoadingPopup;
        if (i0X0x0oIo != null) {
            i0X0x0oIo.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean doTransfer(Oox.oIX0oI<kotlin.oXIO0o0XI> oix0oi) {
        if (DeviceFileManager.f21743oIX0oI.X0IIOO()) {
            ToastUtils.showLong(getString(R.string.transfering), new Object[0]);
            return false;
        }
        oix0oi.invoke();
        return true;
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

    private final EBookManagerActivity$mDeviceFileCallback$2.oIX0oI getMDeviceFileCallback() {
        return (EBookManagerActivity$mDeviceFileCallback$2.oIX0oI) this.mDeviceFileCallback$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProgressBar getPbProgress() {
        return (ProgressBar) this.pbProgress$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getSDCardInfo() {
        if (ProductManager.f20544oIX0oI.OXxx0OO()) {
            BleConnector.sendData$default(BleConnector.INSTANCE, BleKey.SDCARD_INFO, BleKeyFlag.READ, null, false, false, 28, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getTaskPanel() {
        return (View) this.taskPanel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getTvCancel() {
        return (View) this.tvCancel$delegate.getValue();
    }

    private final TextView getTvFreeSpace() {
        return (TextView) this.tvFreeSpace$delegate.getValue();
    }

    private final TextView getTvName() {
        return (TextView) this.tvName$delegate.getValue();
    }

    private final TextView getTvProgress() {
        return (TextView) this.tvProgress$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvProgressTip() {
        return (TextView) this.tvProgressTip$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getTvRetry() {
        return (View) this.tvRetry$delegate.getValue();
    }

    private final TextView getTvTotalProgress() {
        return (TextView) this.tvTotalProgress$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$1(EBookManagerActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        showLoadPopup$default(this$0, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMore(SDCardBean sDCardBean) {
        int loadMore = FileBrowseManager.getInstance().loadMore(sDCardBean);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> loadMoreFile " + loadMore);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mHandler$lambda$0(EBookManagerActivity this$0, Message it) {
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
        Intent intent = new Intent();
        intent.setType("text/plain");
        intent.setAction("android.intent.action.GET_CONTENT");
        startActivityForResult(intent, 990);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshTaskPanel(int i, int i2) {
        getTvProgressTip().setText(R.string.ebook_transfer_task_tip);
        getTvCancel().setVisibility(0);
        getTvRetry().setVisibility(8);
        getTaskPanel().setVisibility(0);
        TextView tvName = getTvName();
        DeviceFileManager deviceFileManager = DeviceFileManager.f21743oIX0oI;
        tvName.setText(deviceFileManager.xoXoI().get(i).XO());
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
            xoI0Ixx02.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.EBookManagerActivity$showErrorPop$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    return Boolean.TRUE;
                }
            });
            xoI0Ixx02.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.EBookManagerActivity$showErrorPop$1$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    EBookManagerActivity.oxoX oxox;
                    EBookManagerActivity.oxoX oxox2;
                    EBookManagerActivity.showLoadPopup$default(EBookManagerActivity.this, false, 1, null);
                    EBookManagerActivity eBookManagerActivity = EBookManagerActivity.this;
                    eBookManagerActivity.setRetryFrequency(eBookManagerActivity.getRetryFrequency() + 1);
                    if (EBookManagerActivity.this.getRetryFrequency() > 2) {
                        EBookManagerActivity.this.setRetryFrequency(0);
                        FileBrowseManager fileBrowseManager = FileBrowseManager.getInstance();
                        oxox = EBookManagerActivity.this.mFileObserver;
                        fileBrowseManager.removeFileObserver(oxox);
                        DeviceFileManager deviceFileManager = DeviceFileManager.f21743oIX0oI;
                        deviceFileManager.IXxxXO();
                        Application application = EBookManagerActivity.this.getApplication();
                        kotlin.jvm.internal.IIX0o.oO(application, "getApplication(...)");
                        deviceFileManager.o00(application);
                        FileBrowseManager fileBrowseManager2 = FileBrowseManager.getInstance();
                        oxox2 = EBookManagerActivity.this.mFileObserver;
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
    public final void showFreeSpace() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void showList() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("showList -> size:" + this.mFiles.size() + ", " + this.mFiles);
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
            renderAdapter(new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.EBookManagerActivity$showList$1
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
                    EBookManagerActivity.this.findViewById(R.id.empty).setVisibility(8);
                    EBookManagerActivity.this.getRecyclerView().setVisibility(0);
                    for (final FileStruct fileStruct : EBookManagerActivity.this.getMFiles()) {
                        DslAdapter dslAdapter = EBookManagerActivity.this.getDslAdapter();
                        final EBookManagerActivity eBookManagerActivity = EBookManagerActivity.this;
                        DslAdapterExKt.oO(dslAdapter, R.layout.item_music, new Oox.oOoXoXO<DslAdapterItem, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.EBookManagerActivity$showList$1.1

                            /* renamed from: com.sma.smartv3.ui.device.EBookManagerActivity$showList$1$1$1, reason: invalid class name and collision with other inner class name */
                            /* loaded from: classes12.dex */
                            public static final class C09461 extends Lambda implements Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, kotlin.oXIO0o0XI> {
                                final /* synthetic */ FileStruct $item;
                                final /* synthetic */ EBookManagerActivity this$0;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                public C09461(FileStruct fileStruct, EBookManagerActivity eBookManagerActivity) {
                                    super(4);
                                    this.$item = fileStruct;
                                    this.this$0 = eBookManagerActivity;
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final void invoke$lambda$0(final EBookManagerActivity this$0, final int i, View view) {
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                                    this$0.doTransfer(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: INVOKE 
                                          (r0v0 'this$0' com.sma.smartv3.ui.device.EBookManagerActivity)
                                          (wrap:Oox.oIX0oI<kotlin.oXIO0o0XI>:0x0007: CONSTRUCTOR (r0v0 'this$0' com.sma.smartv3.ui.device.EBookManagerActivity A[DONT_INLINE]), (r1v0 'i' int A[DONT_INLINE]) A[MD:(com.sma.smartv3.ui.device.EBookManagerActivity, int):void (m), WRAPPED] (LINE:8) call: com.sma.smartv3.ui.device.EBookManagerActivity$showList$1$1$1$1$1.<init>(com.sma.smartv3.ui.device.EBookManagerActivity, int):void type: CONSTRUCTOR)
                                         DIRECT call: com.sma.smartv3.ui.device.EBookManagerActivity.doTransfer(Oox.oIX0oI):boolean A[MD:(Oox.oIX0oI<kotlin.oXIO0o0XI>):boolean (m), WRAPPED] (LINE:1) in method: com.sma.smartv3.ui.device.EBookManagerActivity.showList.1.1.1.invoke$lambda$0(com.sma.smartv3.ui.device.EBookManagerActivity, int, android.view.View):void, file: classes12.dex
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
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.EBookManagerActivity$showList$1$1$1$1$1, state: NOT_LOADED
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
                                        com.sma.smartv3.ui.device.EBookManagerActivity$showList$1$1$1$1$1 r2 = new com.sma.smartv3.ui.device.EBookManagerActivity$showList$1$1$1$1$1
                                        r2.<init>(r0, r1)
                                        com.sma.smartv3.ui.device.EBookManagerActivity.access$doTransfer(r0, r2)
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.EBookManagerActivity$showList$1.AnonymousClass1.C09461.invoke$lambda$0(com.sma.smartv3.ui.device.EBookManagerActivity, int, android.view.View):void");
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
                                        final EBookManagerActivity eBookManagerActivity = this.this$0;
                                        img.setOnClickListener(
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0032: INVOKE 
                                              (r2v1 'img' android.widget.ImageView)
                                              (wrap:android.view.View$OnClickListener:0x002f: CONSTRUCTOR 
                                              (r4v5 'eBookManagerActivity' com.sma.smartv3.ui.device.EBookManagerActivity A[DONT_INLINE])
                                              (r3v0 'i' int A[DONT_INLINE])
                                             A[MD:(com.sma.smartv3.ui.device.EBookManagerActivity, int):void (m), WRAPPED] call: com.sma.smartv3.ui.device.oxxXoxO.<init>(com.sma.smartv3.ui.device.EBookManagerActivity, int):void type: CONSTRUCTOR)
                                             VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] in method: com.sma.smartv3.ui.device.EBookManagerActivity.showList.1.1.1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List<? extends java.lang.Object>):void, file: classes12.dex
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
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.oxxXoxO, state: NOT_LOADED
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
                                            com.sma.smartv3.ui.device.EBookManagerActivity r4 = r1.this$0
                                            com.sma.smartv3.ui.device.oxxXoxO r5 = new com.sma.smartv3.ui.device.oxxXoxO
                                            r5.<init>(r4, r3)
                                            r2.setOnClickListener(r5)
                                        L35:
                                            return
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.EBookManagerActivity$showList$1.AnonymousClass1.C09461.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List):void");
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
                                    dslItem.setItemBindOverride(new C09461(FileStruct.this, eBookManagerActivity));
                                }
                            });
                        }
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
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

        public static /* synthetic */ void showLoadPopup$default(EBookManagerActivity eBookManagerActivity, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = true;
            }
            eBookManagerActivity.showLoadPopup(z);
        }

        @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
        @OXOo.OOXIXo
        public DslAdapterStatusItem adapterStatusItem() {
            setAdapterStatus(new AdapterStatusItem());
            return getAdapterStatus();
        }

        @OXOo.oOoXoXO
        public final File getCacheFile() {
            return this.cacheFile;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:16:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0068 A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Type inference failed for: r5v10 */
        @OXOo.OOXIXo
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.String getFileCharsetSimple(@OXOo.OOXIXo android.net.Uri r5) {
            /*
                r4 = this;
                java.lang.String r0 = "sourcePath"
                kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r0)
                r0 = 0
                android.content.ContentResolver r1 = r4.getContentResolver()     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3f
                java.io.InputStream r5 = r1.openInputStream(r5)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3f
                java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L35
                r1.<init>(r5)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L35
                int r0 = r1.read()     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L2e
                int r0 = r0 << 8
                int r2 = r1.read()     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L2e
                int r0 = r0 + r2
                r1.close()     // Catch: java.io.IOException -> L27
                if (r5 == 0) goto L58
                r5.close()     // Catch: java.io.IOException -> L27
                goto L58
            L27:
                r5 = move-exception
                r5.printStackTrace()
                goto L58
            L2c:
                r0 = move-exception
                goto L6b
            L2e:
                r0 = move-exception
                goto L43
            L30:
                r1 = move-exception
                r3 = r1
                r1 = r0
                r0 = r3
                goto L6b
            L35:
                r1 = move-exception
                r3 = r1
                r1 = r0
                r0 = r3
                goto L43
            L3a:
                r5 = move-exception
                r1 = r0
                r0 = r5
                r5 = r1
                goto L6b
            L3f:
                r5 = move-exception
                r1 = r0
                r0 = r5
                r5 = r1
            L43:
                r0.printStackTrace()     // Catch: java.lang.Throwable -> L2c
                if (r1 == 0) goto L4e
                r1.close()     // Catch: java.io.IOException -> L4c
                goto L4e
            L4c:
                r5 = move-exception
                goto L54
            L4e:
                if (r5 == 0) goto L57
                r5.close()     // Catch: java.io.IOException -> L4c
                goto L57
            L54:
                r5.printStackTrace()
            L57:
                r0 = 0
            L58:
                r5 = 65279(0xfeff, float:9.1475E-41)
                if (r0 == r5) goto L68
                r5 = 65534(0xfffe, float:9.1833E-41)
                if (r0 == r5) goto L65
                java.lang.String r5 = "GBK"
                goto L6a
            L65:
                java.lang.String r5 = "Unicode"
                goto L6a
            L68:
                java.lang.String r5 = "UTF-16BE"
            L6a:
                return r5
            L6b:
                if (r1 == 0) goto L73
                r1.close()     // Catch: java.io.IOException -> L71
                goto L73
            L71:
                r5 = move-exception
                goto L79
            L73:
                if (r5 == 0) goto L7c
                r5.close()     // Catch: java.io.IOException -> L71
                goto L7c
            L79:
                r5.printStackTrace()
            L7c:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.EBookManagerActivity.getFileCharsetSimple(android.net.Uri):java.lang.String");
        }

        @OXOo.OOXIXo
        public final List<FileStruct> getMFiles() {
            return this.mFiles;
        }

        @OXOo.oOoXoXO
        public final SDCardBean getMSDCardBean() {
            return this.mSDCardBean;
        }

        public final int getOnFileReceiverSize() {
            return this.onFileReceiverSize;
        }

        public final int getRetryFrequency() {
            return this.retryFrequency;
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
            this.mHandler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.I0oOoX
                @Override // java.lang.Runnable
                public final void run() {
                    EBookManagerActivity.init$lambda$1(EBookManagerActivity.this);
                }
            }, 600L);
            deviceFileManager.oO();
        }

        @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity, com.bestmafen.androidbase.base.oIX0oI
        public void initView() {
            super.initView();
            ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.ebook_manager);
            getSDCardInfo();
            showFreeSpace();
        }

        @Override // com.bestmafen.androidbase.base.oIX0oI
        public int layoutId() {
            return R.layout.activity_ebook_manager;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v16, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r7v18, types: [T, java.lang.String] */
        @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
        public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
            Uri uri;
            super.onActivityResult(i, i2, intent);
            if (i2 == -1 && i == 990) {
                T t = 0;
                if (intent != null) {
                    uri = intent.getData();
                } else {
                    uri = null;
                }
                ContentResolver contentResolver = getContentResolver();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(uri);
                Cursor query = contentResolver.query(uri, null, null, null, null);
                if (query != null) {
                    query.moveToFirst();
                }
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                if (query != null) {
                    t = query.getString(query.getColumnIndex("_display_name"));
                }
                objectRef.element = t;
                if (query != null) {
                    query.close();
                }
                T t2 = objectRef.element;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(t2);
                if (((String) t2).length() < 4) {
                    objectRef.element = "watch_" + ((String) objectRef.element);
                }
                if (((String) objectRef.element).length() > 50) {
                    StringBuilder sb = new StringBuilder();
                    String substring = ((String) objectRef.element).substring(0, 50);
                    kotlin.jvm.internal.IIX0o.oO(substring, "substring(...)");
                    sb.append(substring);
                    sb.append(".txt");
                    objectRef.element = sb.toString();
                }
                if (FileUtils.isUtf8(UriUtils.uri2File(uri))) {
                    DeviceFileManager deviceFileManager = DeviceFileManager.f21743oIX0oI;
                    String uri2 = uri.toString();
                    String uri3 = uri.toString();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("ebook");
                    T t3 = objectRef.element;
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(t3);
                    sb2.append((String) t3);
                    deviceFileManager.IoOoX(new ox0I(uri2, uri3, sb2.toString()));
                    deviceFileManager.Xx000oIo(this.mSDCardBean);
                    return;
                }
                Uri copyCacheFile = copyCacheFile(uri);
                DeviceFileManager deviceFileManager2 = DeviceFileManager.f21743oIX0oI;
                String uri4 = copyCacheFile.toString();
                String uri5 = copyCacheFile.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("ebook");
                T t4 = objectRef.element;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(t4);
                sb3.append((String) t4);
                deviceFileManager2.IoOoX(new ox0I(uri4, uri5, sb3.toString()));
                deviceFileManager2.Xx000oIo(this.mSDCardBean);
            }
        }

        @Override // androidx.activity.ComponentActivity, android.app.Activity
        public void onBackPressed() {
            if (doTransfer(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.EBookManagerActivity$onBackPressed$1
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
            add();
        }

        public final void onCancel(@OXOo.OOXIXo View view) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(getMContext(), 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.cancel_ebook_task_tip);
            xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.EBookManagerActivity$onCancel$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    return Boolean.TRUE;
                }
            });
            xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.EBookManagerActivity$onCancel$1$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    View taskPanel;
                    DeviceFileManager.f21743oIX0oI.IO();
                    taskPanel = EBookManagerActivity.this.getTaskPanel();
                    taskPanel.setVisibility(8);
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
            super.onDestroy();
        }

        public final void onRetry(@OXOo.OOXIXo View view) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
            DeviceFileManager.f21743oIX0oI.xXxxox0I();
        }

        public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
            doTransfer(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.EBookManagerActivity$onTitleLeftClick$1
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
                    EBookManagerActivity.this.finish();
                }
            });
        }

        @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
        public int recyclerViewId() {
            return R.id.rv;
        }

        @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
        public int refreshLayoutId() {
            return 0;
        }

        public final void setCacheFile(@OXOo.oOoXoXO File file) {
            this.cacheFile = file;
        }

        public final void setMSDCardBean(@OXOo.oOoXoXO SDCardBean sDCardBean) {
            this.mSDCardBean = sDCardBean;
        }

        public final void setOnFileReceiverSize(int i) {
            this.onFileReceiverSize = i;
        }

        public final void setRetryFrequency(int i) {
            this.retryFrequency = i;
        }
    }
