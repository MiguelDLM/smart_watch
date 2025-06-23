package com.sma.smartv3.ui.me;

import android.bluetooth.BluetoothDevice;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.SPUtils;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.BleInitializer;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.view.chart.MyMarkerView;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.FilesKt__FileReadWriteKt;

@kotlin.jvm.internal.XX({"SMAP\nDeveloperGsensorActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperGsensorActivity.kt\ncom/sma/smartv3/ui/me/DeveloperGsensorActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,175:1\n19#2:176\n15#2:177\n1549#3:178\n1620#3,3:179\n1549#3:182\n1620#3,3:183\n*S KotlinDebug\n*F\n+ 1 DeveloperGsensorActivity.kt\ncom/sma/smartv3/ui/me/DeveloperGsensorActivity\n*L\n43#1:176\n43#1:177\n81#1:178\n81#1:179,3\n82#1:182\n82#1:183,3\n*E\n"})
/* loaded from: classes11.dex */
public final class DeveloperGsensorActivity extends BaseActivity implements BleHandleCallback {

    @OXOo.OOXIXo
    private final AppUser mAppUser;

    @OXOo.oOoXoXO
    private File mGsensorFile;

    @OXOo.oOoXoXO
    private File mHrFile;
    private boolean mState;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO lineChart$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LineChart>() { // from class: com.sma.smartv3.ui.me.DeveloperGsensorActivity$lineChart$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LineChart invoke() {
            return (LineChart) DeveloperGsensorActivity.this.findViewById(R.id.line_chart);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btn$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.me.DeveloperGsensorActivity$btn$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) DeveloperGsensorActivity.this.findViewById(R.id.btn_start);
        }
    });

    @OXOo.OOXIXo
    private final LinkedList<List<BleGSensorRaw>> mData = new LinkedList<>();

    @OXOo.OOXIXo
    private final LinkedList<List<BleGSensorMotion>> mMotionData = new LinkedList<>();

    public DeveloperGsensorActivity() {
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.mAppUser = (AppUser) (fromJson != null ? fromJson : appUser);
    }

    private final Button getBtn() {
        Object value = this.btn$delegate.getValue();
        kotlin.jvm.internal.IIX0o.oO(value, "getValue(...)");
        return (Button) value;
    }

    private final LineChart getLineChart() {
        Object value = this.lineChart$delegate.getValue();
        kotlin.jvm.internal.IIX0o.oO(value, "getValue(...)");
        return (LineChart) value;
    }

    private final void updateGsensor() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<List<BleGSensorRaw>> it = this.mData.iterator();
        while (it.hasNext()) {
            for (BleGSensorRaw bleGSensorRaw : it.next()) {
                arrayList.add(new Entry(arrayList.size(), bleGSensorRaw.getMX()));
                arrayList2.add(new Entry(arrayList2.size(), bleGSensorRaw.getMY()));
                arrayList3.add(new Entry(arrayList3.size(), bleGSensorRaw.getMZ()));
            }
        }
        LineDataSet lineDataSet = new LineDataSet(arrayList, "X");
        lineDataSet.Oxo00O(false);
        lineDataSet.OX(Color.parseColor("#ff0000"));
        LineDataSet.Mode mode = LineDataSet.Mode.HORIZONTAL_BEZIER;
        lineDataSet.xox(mode);
        LineDataSet lineDataSet2 = new LineDataSet(arrayList2, Api.Y);
        lineDataSet2.Oxo00O(false);
        lineDataSet2.OX(Color.parseColor("#00ff00"));
        lineDataSet2.xox(mode);
        LineDataSet lineDataSet3 = new LineDataSet(arrayList3, "Z");
        lineDataSet3.Oxo00O(false);
        lineDataSet3.OX(Color.parseColor("#0000ff"));
        lineDataSet3.xox(mode);
        getLineChart().setData(new o0xxxXXxX.ooOOo0oXI(lineDataSet, lineDataSet2, lineDataSet3));
        getLineChart().invalidate();
    }

    private final void updateMotion() {
        ArrayList arrayList = new ArrayList();
        Iterator<List<BleGSensorMotion>> it = this.mMotionData.iterator();
        while (it.hasNext()) {
            Iterator<BleGSensorMotion> it2 = it.next().iterator();
            while (it2.hasNext()) {
                arrayList.add(new Entry(arrayList.size(), it2.next().getMMotion()));
            }
        }
        LineDataSet lineDataSet = new LineDataSet(arrayList, "motion");
        lineDataSet.OX(Color.parseColor("#ff0000"));
        lineDataSet.oIX0oI(true);
        lineDataSet.xox(LineDataSet.Mode.HORIZONTAL_BEZIER);
        lineDataSet.Oxo00O(false);
        getLineChart().setData(new o0xxxXXxX.ooOOo0oXI(lineDataSet));
        getLineChart().invalidate();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        setRequestedOrientation(0);
        BleConnector.INSTANCE.addHandleCallback(this);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        MyMarkerView myMarkerView = new MyMarkerView(this, R.layout.marker_view_developer_gsensor);
        myMarkerView.setChartView(getLineChart());
        getLineChart().setMarker(myMarkerView);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_developer_gsensor;
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

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        BleConnector bleConnector = BleConnector.INSTANCE;
        bleConnector.removeHandleCallback(this);
        if (this.mState) {
            BleConnector.sendBoolean$default(bleConnector, BleKey.GSENSOR_OUTPUT, BleKeyFlag.UPDATE, false, false, false, 24, null);
        }
        super.onDestroy();
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
    public void onReceiveGSensorMotion(@OXOo.OOXIXo List<BleGSensorMotion> gSensorMotions) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(gSensorMotions, "gSensorMotions");
        if (this.mState) {
            this.mMotionData.add(gSensorMotions);
            if (this.mMotionData.size() > 60) {
                this.mMotionData.removeFirst();
            }
            updateMotion();
        }
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReceiveGSensorRaw(@OXOo.OOXIXo List<BleGSensorRaw> gSensorRaws) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(gSensorRaws, "gSensorRaws");
        if (this.mState) {
            List<BleGSensorRaw> list = gSensorRaws;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Short.valueOf(((BleGSensorRaw) it.next()).getMX()));
            }
            double oo002 = CollectionsKt___CollectionsKt.oo00(arrayList);
            ArrayList arrayList2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Short.valueOf(((BleGSensorRaw) it2.next()).getMY()));
            }
            double oo003 = CollectionsKt___CollectionsKt.oo00(arrayList2);
            double sqrt = Math.sqrt((oo002 * oo002) + (oo003 * oo003));
            OI0.oIX0oI.f1507oIX0oI.Oxx0IOOO("onReceiveGSensorRaw -> xAvg=" + oo002 + ", yAvg=" + oo003 + ", p=" + sqrt + ", a=" + ((90 * sqrt) / 512));
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
            String IIOIX2 = kotlin.text.OxI.IIOIX(CollectionsKt___CollectionsKt.OoIXo(list, null, null, null, 0, null, new Oox.oOoXoXO<BleGSensorRaw, CharSequence>() { // from class: com.sma.smartv3.ui.me.DeveloperGsensorActivity$onReceiveGSensorRaw$gsensorText$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                @OXOo.OOXIXo
                public final CharSequence invoke(@OXOo.OOXIXo BleGSensorRaw it3) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it3, "it");
                    return simpleDateFormat.format(new Date()) + ',' + ((int) it3.getMX()) + ',' + ((int) it3.getMY()) + ',' + ((int) it3.getMZ()) + '\n';
                }
            }, 31, null), ", ", "", false, 4, null);
            File file = this.mGsensorFile;
            if (file != null) {
                FilesKt__FileReadWriteKt.xxIXOIIO(file, IIOIX2, null, 2, null);
            }
            this.mData.add(gSensorRaws);
            if (this.mData.size() > 60) {
                this.mData.removeFirst();
            }
            updateGsensor();
        }
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReceiveGSensorSHSY(@OXOo.OOXIXo List<BleGSensorSHSY> list) {
        BleHandleCallback.DefaultImpls.onReceiveGSensorSHSY(this, list);
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReceiveHRRaw(@OXOo.OOXIXo List<BleHRRaw> hrRaws) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(hrRaws, "hrRaws");
        if (this.mState) {
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
            String IIOIX2 = kotlin.text.OxI.IIOIX(CollectionsKt___CollectionsKt.OoIXo(hrRaws, null, null, null, 0, null, new Oox.oOoXoXO<BleHRRaw, CharSequence>() { // from class: com.sma.smartv3.ui.me.DeveloperGsensorActivity$onReceiveHRRaw$hrText$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                @OXOo.OOXIXo
                public final CharSequence invoke(@OXOo.OOXIXo BleHRRaw it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    return simpleDateFormat.format(new Date()) + ',' + it.getMPpg() + '\n';
                }
            }, 31, null), ", ", "", false, 4, null);
            File file = this.mHrFile;
            if (file != null) {
                FilesKt__FileReadWriteKt.xxIXOIIO(file, IIOIX2, null, 2, null);
            }
        }
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

    public final void toggle(@OXOo.OOXIXo View view) {
        String str;
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        this.mState = !this.mState;
        Button btn = getBtn();
        if (this.mState) {
            str = "Pause";
        } else {
            str = "Start";
        }
        btn.setText(str);
        BleConnector.sendBoolean$default(BleConnector.INSTANCE, BleKey.GSENSOR_OUTPUT, BleKeyFlag.UPDATE, this.mState, false, false, 24, null);
        if (this.mState) {
            BleInitializer bleInitializer = BleInitializer.f20700XO;
            bleInitializer.xI0oxI00(0L);
            bleInitializer.IoIOOxIIo(0L);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
            X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
            this.mGsensorFile = com.sma.smartv3.initializer.IXxxXO.Xo0(oix0oi, this.mAppUser.getNickname() + "_GSensor_" + simpleDateFormat.format(new Date()) + ".csv");
            this.mHrFile = com.sma.smartv3.initializer.IXxxXO.XoI0Ixx0(oix0oi, this.mAppUser.getNickname() + "_HR_" + simpleDateFormat.format(new Date()) + ".csv");
        }
    }

    @Override // com.szabh.smable3.component.BleHandleCallback
    public void onReadStock(boolean z) {
        BleHandleCallback.DefaultImpls.onReadStock(this, z);
    }
}
