package com.sma.smartv3.biz.voice;

import Oox.IXxxXO;
import android.app.Activity;
import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.text.TextUtils;
import android.view.View;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.androidnetworking.interfaces.UploadProgressListener;
import com.baidu.ai.speech.realtime.full.connection.Runner;
import com.baidu.ai.speech.realtime.full.download.Result;
import com.baidu.ai.speech.realtime.full.download.SimpleDownloader;
import com.baidu.mobads.sdk.internal.an;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PathUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.huawei.openalliance.ad.utils.bc;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.AIManager;
import com.sma.smartv3.biz.AISparkChainManager;
import com.sma.smartv3.biz.AIWatchFaceManager;
import com.sma.smartv3.biz.VoiceService;
import com.sma.smartv3.biz.ai.AIBase;
import com.sma.smartv3.biz.ai.AIError;
import com.sma.smartv3.biz.dcs.DcsToken;
import com.sma.smartv3.biz.voice.OpusManager;
import com.sma.smartv3.biz.voice.RecordingManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AIAnswer;
import com.sma.smartv3.model.AIFunctionType;
import com.sma.smartv3.model.AIQuestion;
import com.sma.smartv3.model.AISpeech;
import com.sma.smartv3.model.AITranslation;
import com.sma.smartv3.model.DeviceKeyManager;
import com.sma.smartv3.model.LanguageTranslationData;
import com.sma.smartv3.model.LanguageTranslationKt;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.GetAIAudioToText;
import com.sma.smartv3.network.GetDcsToken;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.util.IoOoo;
import com.sma.smartv3.util.MicrosoftSDKManage;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.x0xO0oo;
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
import com.szabh.smable3.entity.BleVoice;
import com.szabh.smable3.entity.BleWatchFaceId;
import com.szabh.smable3.entity.BleWatchFaceIndex;
import com.szabh.smable3.entity.BleWorkout;
import com.szabh.smable3.entity.BleWorkout2;
import com.szabh.smable3.entity.BleWorkout3;
import com.szabh.smable3.entity.BleWorldClock;
import com.szabh.smable3.entity.Languages;
import com.szabh.smable3.entity.MusicCommand;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

@kotlin.OOXIXo(message = "")
@XX({"SMAP\nVoiceManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceManager.kt\ncom/sma/smartv3/biz/voice/VoiceManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 6 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,2150:1\n1#2:2151\n39#3,3:2152\n42#3:2158\n44#3,2:2160\n31#3,2:2162\n15#3:2164\n39#3,3:2165\n42#3:2171\n44#3,2:2173\n31#3,2:2177\n18#3,2:2212\n15#3:2214\n1549#4:2155\n1620#4,2:2156\n1622#4:2159\n1549#4:2168\n1620#4,2:2169\n1622#4:2172\n1855#4,2:2175\n151#5,11:2179\n171#5:2198\n158#5,4:2199\n171#5:2211\n208#6,7:2190\n226#6:2197\n208#6,7:2203\n226#6:2210\n*S KotlinDebug\n*F\n+ 1 VoiceManager.kt\ncom/sma/smartv3/biz/voice/VoiceManager\n*L\n414#1:2152,3\n414#1:2158\n414#1:2160,2\n418#1:2162,2\n841#1:2164\n1076#1:2165,3\n1076#1:2171\n1076#1:2173,2\n1084#1:2177,2\n1335#1:2212,2\n1335#1:2214\n414#1:2155\n414#1:2156,2\n414#1:2159\n1076#1:2168\n1076#1:2169,2\n1076#1:2172\n1079#1:2175,2\n1274#1:2179,11\n1274#1:2198\n1308#1:2199,4\n1308#1:2211\n1274#1:2190,7\n1274#1:2197\n1308#1:2203,7\n1308#1:2210\n*E\n"})
/* loaded from: classes12.dex */
public final class VoiceManager {

    @OXOo.OOXIXo
    private static final String TAG = "AIManager VoiceManager";

    @OXOo.OOXIXo
    private static final String TAG_OPENAICHATCOMPLETION = "openAiChatCompletion";
    private static boolean isActivityData;
    private static boolean isAiTaskRunning;
    private static volatile boolean isRealTimeRunning;
    private static boolean isSendResults;
    private static boolean isSpeechRecRunning;
    private static Application mApp;

    @OXOo.oOoXoXO
    private static ThreadUtils.SimpleTask<Void> mDuserTask;

    @OXOo.oOoXoXO
    private static Runner mFullRunner;

    @OXOo.oOoXoXO
    private static PipedInputStream mInputStream;

    @OXOo.oOoXoXO
    private static IXxxXO<? super Integer, ? super Integer, ? super Integer, Boolean> mListener;

    @OXOo.oOoXoXO
    private static ThreadUtils.SimpleTask<Void> mOpenAiTask;

    @OXOo.oOoXoXO
    private static OpusManager mOpusManager;

    @OXOo.oOoXoXO
    private static PipedOutputStream mOutputStream;
    private static int mVoiceMode;
    private static boolean resetCallBack;

    @OXOo.OOXIXo
    public static final VoiceManager INSTANCE = new VoiceManager();

    @OXOo.OOXIXo
    private static final File mOpusFile = new File(PathUtils.getExternalAppDataPath() + "/files/record.opus");

    @OXOo.OOXIXo
    private static String mSavePcmTime = "";

    @OXOo.OOXIXo
    private static final File mPcmFile = new File(PathUtils.getExternalAppDataPath() + "/files/record.pcm");

    @OXOo.OOXIXo
    private static final File mWavFile = new File(PathUtils.getExternalAppDataPath() + "/files/record.wav");
    private static int mLanguage = -1;
    private static int mToLanguage = -1;
    private static int mAIMode = -1;

    @OXOo.OOXIXo
    private static final VoiceManager$mBleHandleCallback$1 mBleHandleCallback = new BleHandleCallback() { // from class: com.sma.smartv3.biz.voice.VoiceManager$mBleHandleCallback$1
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
        public void onReceiveRecordPacket(@OXOo.OOXIXo BleRecordPacket recordPacket) {
            boolean z;
            int i;
            int i2;
            int i3;
            IXxxXO<Integer, Integer, Integer, Boolean> mListener2;
            int i4;
            IIX0o.x0xO0oo(recordPacket, "recordPacket");
            if (recordPacket.getMStatus() == 5) {
                DcsTtsPlayer.INSTANCE.replayMusic();
                return;
            }
            VoiceManager voiceManager = VoiceManager.INSTANCE;
            voiceManager.setMVoiceMode(recordPacket.getMMode());
            if (!voiceManager.isSupportEarPhoneVoiceTranslation() && !voiceManager.isSupportEarPhoneVoiceAIChat()) {
                z = false;
            } else {
                z = true;
            }
            voiceManager.setRecordBluetooth(z);
            if (recordPacket.getMStatus() == 0 && ProjectManager.f19822oIX0oI.Ox0O()) {
                VoiceManager.mAIMode = -1;
                int mAIMode2 = recordPacket.getMAIMode();
                if (mAIMode2 == 0) {
                    VoiceManager.mAIMode = 0;
                } else if (mAIMode2 == 1) {
                    VoiceManager.mAIMode = 1;
                } else if (mAIMode2 == 2) {
                    VoiceManager.mAIMode = 2;
                } else if (mAIMode2 == 3) {
                    VoiceManager.mAIMode = 3;
                }
                OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                StringBuilder sb = new StringBuilder();
                sb.append("AIManager VoiceManager , mAIMode = ");
                i4 = VoiceManager.mAIMode;
                sb.append(i4);
                sb.append(TokenParser.SP);
                oix0oi.oIX0oI(sb.toString());
            }
            if (voiceManager.getMListener() != null && (mListener2 = voiceManager.getMListener()) != null) {
                mListener2.invoke(Integer.valueOf(recordPacket.getMMode()), Integer.valueOf(recordPacket.getMStatus()), Integer.valueOf(recordPacket.getMEarDirection()));
            }
            voiceManager.getAiTranslationType(recordPacket);
            VoiceManager.postEvent$default(voiceManager, x0xO0oo.f24608XIXIX, null, 2, null);
            ProductManager productManager = ProductManager.f20544oIX0oI;
            if (productManager.XI0IXoo()) {
                if (Xo0.f24349oIX0oI.oIX0oI().getBoolean(XoI0Ixx0.f24483xX, false)) {
                    return;
                }
                voiceManager.toMicrosoftIdentify(recordPacket);
                return;
            }
            if (!productManager.XOx()) {
                i = VoiceManager.mAIMode;
                if (i != 0) {
                    i2 = VoiceManager.mAIMode;
                    if (i2 != 1) {
                        i3 = VoiceManager.mAIMode;
                        if (i3 != 3) {
                            voiceManager.oldReceiveRecordPacket(recordPacket);
                            return;
                        }
                    }
                }
            }
            voiceManager.newReceiveRecordPacket(recordPacket);
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
                VoiceManager voiceManager = VoiceManager.INSTANCE;
                if (voiceManager.isSpeechRecRunning()) {
                    voiceManager.setSpeechRecRunning(false);
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
    };

    @OXOo.OOXIXo
    private static String microsoftLanguage = bc.Code;

    @OXOo.OOXIXo
    private static String microsoftTtsName = "zh-CN-XiaoxiaoNeural";

    @OXOo.OOXIXo
    private static String microsoftTtsLanguage = bc.Code;
    private static boolean isRecordBluetooth = true;

    @OXOo.OOXIXo
    private static String mContentResult = "";

    @OXOo.OOXIXo
    private static final MicrosoftSDKManage.I0Io microsoftCallBack = new MicrosoftSDKManage.I0Io() { // from class: com.sma.smartv3.biz.voice.VoiceManager$microsoftCallBack$1
        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onIdentifyResults(int i, @OXOo.OOXIXo String str) {
            IIX0o.x0xO0oo(str, "str");
            if (i == 1 && str.length() > 0) {
                VoiceManager voiceManager = VoiceManager.INSTANCE;
                if (!voiceManager.isSpeechRecRunning()) {
                    voiceManager.sendTranslationResultInput(str);
                }
            }
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            sb.append("AIManager VoiceManager microsoftCallBack stopAudioStreamInput onIdentifyResults -> status = ");
            sb.append(i);
            sb.append("  isSpeechRecRunning = ");
            VoiceManager voiceManager2 = VoiceManager.INSTANCE;
            sb.append(voiceManager2.isSpeechRecRunning());
            oix0oi.oIX0oI(sb.toString());
            if (i == 2 && str.length() > 0) {
                voiceManager2.setSendResults(false);
                voiceManager2.setMContentResult(str);
            }
            if (ProductManager.xOOxIO(ProductManager.f20544oIX0oI, null, 1, null) && i == 2) {
                voiceManager2.setSpeechRecRunning(false);
            }
            if (i == 2 && str.length() > 0 && !voiceManager2.isSpeechRecRunning()) {
                voiceManager2.setSendResults(true);
                voiceManager2.sendContentResult(str);
            }
            if (i == 2 && str.length() == 0 && !voiceManager2.isSpeechRecRunning()) {
                voiceManager2.setSendResults(true);
                DcsTtsPlayer.INSTANCE.stop();
                voiceManager2.sendTranslationResultInput(UtilsKt.oI0IIXIo(R.string.request_error));
            }
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onIdentifyResultsDetectedLanguage(int i, @OXOo.OOXIXo String str, @OXOo.OOXIXo String str2) {
            MicrosoftSDKManage.I0Io.oIX0oI.oIX0oI(this, i, str, str2);
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onStartTransmission() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager onStartTransmission ");
            VoiceManager voiceManager = VoiceManager.INSTANCE;
            voiceManager.setSendResults(false);
            voiceManager.setMContentResult("");
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onStopTransmission() {
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            sb.append("AIManager VoiceManager microsoftCallBack onStopTransmission -> mContentResult = ");
            VoiceManager voiceManager = VoiceManager.INSTANCE;
            sb.append(voiceManager.getMContentResult());
            sb.append(" isSendResults = ");
            sb.append(voiceManager.isSendResults());
            sb.append(" isSpeechRecRunning = ");
            sb.append(voiceManager.isSpeechRecRunning());
            oix0oi.oIX0oI(sb.toString());
            if (!voiceManager.isSendResults()) {
                voiceManager.setSpeechRecRunning(false);
                oix0oi.oIX0oI("AIManager VoiceManager microsoftCallBack onStopTransmission -> mContentResult = " + voiceManager.getMContentResult() + "  isSpeechRecRunning = " + voiceManager.isSpeechRecRunning());
                if (voiceManager.getMContentResult().length() > 0) {
                    voiceManager.sendContentResult(voiceManager.getMContentResult());
                } else {
                    DcsTtsPlayer.INSTANCE.stop();
                    voiceManager.sendTranslationResultInput(UtilsKt.oI0IIXIo(R.string.request_error));
                }
            }
        }
    };

    @OXOo.OOXIXo
    private static final RecordingManager.OnRecordingCallback recordingCallBack = new RecordingManager.OnRecordingCallback() { // from class: com.sma.smartv3.biz.voice.VoiceManager$recordingCallBack$1
        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onBeforeRecording() {
        }

        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onRecordResult(@OXOo.oOoXoXO final AITranslation aITranslation) {
            String text;
            String obj;
            if (aITranslation != null && (text = aITranslation.getText()) != null && (obj = StringsKt__StringsKt.oIoIXxIO(text).toString()) != null && obj.length() > 0) {
                VoiceManager voiceManager = VoiceManager.INSTANCE;
                voiceManager.sendTranslationResultInput(aITranslation.getText());
                if (voiceManager.isSupportAIVoiceWatchface()) {
                    AIWatchFaceManager.xoXoI(AIWatchFaceManager.f19897oIX0oI, aITranslation.getText(), null, 0, 6, null);
                    return;
                }
                if (!voiceManager.isSupportEarPhoneVoiceTranslation() && !voiceManager.isSupportAIVoiceTranslation()) {
                    voiceManager.aISparkChainManagerHandleResponse(aITranslation);
                    return;
                }
                Languages languages = Languages.INSTANCE;
                String formatAISparkTargetLang = languages.formatAISparkTargetLang(voiceManager.getMLanguage(), Languages.DEFAULT_LANGUAGE_ZH);
                final String formatAISparkTargetLang2 = languages.formatAISparkTargetLang(voiceManager.getMToLanguage(), Languages.DEFAULT_LANGUAGE);
                if (IIX0o.Oxx0IOOO(formatAISparkTargetLang, "cn") || IIX0o.Oxx0IOOO(formatAISparkTargetLang2, "cn")) {
                    voiceManager.translateITS(aITranslation.getText(), formatAISparkTargetLang, formatAISparkTargetLang2);
                    return;
                } else {
                    AISparkChainManager.f19871oIX0oI.OOXIxO0(aITranslation.getText(), formatAISparkTargetLang, "cn", new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$recordingCallBack$1$onRecordResult$1
                        @Override // xxxI.II0xO0
                        public void handleError(@OXOo.OOXIXo String error) {
                            IIX0o.x0xO0oo(error, "error");
                            VoiceManager.INSTANCE.sendTranslationResult(UtilsKt.oI0IIXIo(R.string.voice_assistant_common_error), UtilsKt.oI0IIXIo(R.string.failed_in_translation));
                        }

                        @Override // xxxI.II0xO0
                        public void handleResponse(@OXOo.oOoXoXO String str) {
                            if (str != null && str.length() > 0) {
                                VoiceManager.INSTANCE.translateITS(AITranslation.this.getText(), "cn", formatAISparkTargetLang2);
                            } else {
                                VoiceManager.INSTANCE.sendTranslationResult(UtilsKt.oI0IIXIo(R.string.voice_assistant_common_error), UtilsKt.oI0IIXIo(R.string.failed_in_translation));
                            }
                        }
                    });
                    return;
                }
            }
            VoiceManager.INSTANCE.sendTranslationResult(UtilsKt.oI0IIXIo(R.string.speech_recognition_error), "");
            ToastUtils.showLong(R.string.speech_recognition_error);
        }

        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onRecordResultError(@OXOo.OOXIXo String error) {
            IIX0o.x0xO0oo(error, "error");
            ToastUtils.showLong(R.string.speech_recognition_error);
            VoiceManager.INSTANCE.sendTranslationResult(UtilsKt.oI0IIXIo(R.string.speech_recognition_error), UtilsKt.oI0IIXIo(R.string.failed_in_translation));
        }

        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onRecordResultLanguage(@OXOo.oOoXoXO AISpeech aISpeech) {
            RecordingManager.OnRecordingCallback.DefaultImpls.onRecordResultLanguage(this, aISpeech);
        }

        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onStartRecording() {
        }

        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onStopRecording() {
        }
    };
    private static final long FIRST_IDENTIFY_TIME = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
    private static final long SECOND_IDENTIFY_TIME = 1000;
    private static final long CONVENTIONAL_IDENTIFY_TIME = 100;
    private static long microsoftTime = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;

    @OXOo.OOXIXo
    private static final xxxI.II0xO0<AIAnswer> mAISparkChainManagerCallback = new xxxI.II0xO0<AIAnswer>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$mAISparkChainManagerCallback$1
        private int index;
        private long lastSendTime = System.currentTimeMillis();

        @Override // xxxI.II0xO0
        public void handleError(@OXOo.OOXIXo String error) {
            IIX0o.x0xO0oo(error, "error");
            VoiceManager voiceManager = VoiceManager.INSTANCE;
            VoiceManager.isAiTaskRunning = false;
            voiceManager.sendError(UtilsKt.oI0IIXIo(R.string.voice_assistant_common_error));
        }

        /* JADX WARN: Can't wrap try/catch for region: R(10:3|(9:7|(1:9)|11|12|13|(2:16|14)|17|18|(4:20|(1:22)|23|24)(1:26))|29|11|12|13|(1:14)|17|18|(0)(0)) */
        /* JADX WARN: Code restructure failed: missing block: B:10:0x004d, code lost:
        
            if ((java.lang.System.currentTimeMillis() - r12.lastSendTime) > 500) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00c2, code lost:
        
            r4 = kotlin.collections.CollectionsKt__CollectionsKt.ooXIXxIX();
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00af A[Catch: Exception -> 0x00c2, LOOP:0: B:14:0x00a9->B:16:0x00af, LOOP_END, TRY_LEAVE, TryCatch #0 {Exception -> 0x00c2, blocks: (B:13:0x0078, B:14:0x00a9, B:16:0x00af), top: B:12:0x0078 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00d8  */
        /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        @Override // xxxI.II0xO0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void handleResponse(@OXOo.oOoXoXO com.sma.smartv3.model.AIAnswer r13) {
            /*
                Method dump skipped, instructions count: 285
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.biz.voice.VoiceManager$mAISparkChainManagerCallback$1.handleResponse(com.sma.smartv3.model.AIAnswer):void");
        }
    };

    private VoiceManager() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void aiTranscriptionsAudio$default(VoiceManager voiceManager, File file, xxxI.II0xO0 iI0xO0, int i, Object obj) {
        if ((i & 2) != 0) {
            iI0xO0 = null;
        }
        voiceManager.aiTranscriptionsAudio(file, iI0xO0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aiTranscriptionsAudio$lambda$8(long j, long j2) {
    }

    private final void aiTranscriptionsAudioFile(File file) {
        aiTranscriptionsAudio(file, new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$aiTranscriptionsAudioFile$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                VoiceManager.INSTANCE.sendError(UtilsKt.oI0IIXIo(R.string.speech_recognition_error));
            }

            @Override // xxxI.II0xO0
            public void handleResponse(@OXOo.oOoXoXO String str) {
                Collection ooXIXxIX2;
                if (str != null) {
                    VoiceManager voiceManager = VoiceManager.INSTANCE;
                    voiceManager.setSpeechRecRunning(false);
                    if (voiceManager.isSupportAIVoiceWatchface()) {
                        voiceManager.sendMsg(str);
                        AIWatchFaceManager.xoXoI(AIWatchFaceManager.f19897oIX0oI, str, null, 0, 6, null);
                        return;
                    }
                    voiceManager.senAudioTextToDevice(new BleVoice(0, System.currentTimeMillis(), str, 0, 8, null));
                    try {
                        JsonArray asJsonArray = JsonParser.parseString(Xo0.f24349oIX0oI.XO().getString(VoiceMessage.class.getName() + oOXoIIIo.XO.f32008oIX0oI)).getAsJsonArray();
                        IIX0o.ooOOo0oXI(asJsonArray);
                        ooXIXxIX2 = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
                        Iterator<JsonElement> it = asJsonArray.iterator();
                        while (it.hasNext()) {
                            ooXIXxIX2.add(new Gson().fromJson(it.next(), VoiceMessage.class));
                        }
                    } catch (Exception unused) {
                        ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
                    }
                    List o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
                    VoiceManager voiceManager2 = VoiceManager.INSTANCE;
                    VoiceManager.postEvent$default(voiceManager2, x0xO0oo.f24608XIXIX, null, 2, null);
                    o0Xo0XII.add(new VoiceMessage(0, null, 1, str, null, 0, 51, null));
                    o0Xo0XII.add(new VoiceMessage(0, null, 2, "", null, 1, 19, null));
                    Xo0.f24349oIX0oI.XO().put(VoiceMessage.class.getName() + oOXoIIIo.XO.f32008oIX0oI, new Gson().toJson(o0Xo0XII));
                    VoiceManager.postEvent$default(voiceManager2, x0xO0oo.f24655xOOOX, null, 2, null);
                    voiceManager2.AIChat(str);
                }
            }
        });
    }

    public static /* synthetic */ void checkBaiduAuth$default(VoiceManager voiceManager, Activity activity, View view, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            activity = null;
        }
        if ((i & 2) != 0) {
            view = null;
        }
        voiceManager.checkBaiduAuth(activity, view, oooxoxo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oldOpenAiChatCompletion() {
        openAiTranscriptionsAudio(mWavFile, new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$oldOpenAiChatCompletion$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                if (StringsKt__StringsKt.o00xOoIO(error, "invalid_request_error", false, 2, null)) {
                    VoiceManager.INSTANCE.sendError(UtilsKt.oI0IIXIo(R.string.invalid_api_key_tip));
                } else {
                    VoiceManager.INSTANCE.sendError(UtilsKt.oI0IIXIo(R.string.speech_recognition_error));
                }
            }

            @Override // xxxI.II0xO0
            public void handleResponse(@OXOo.oOoXoXO String str) {
                Collection ooXIXxIX2;
                if (str != null) {
                    VoiceManager voiceManager = VoiceManager.INSTANCE;
                    voiceManager.setSpeechRecRunning(false);
                    if (voiceManager.isSupportAIVoiceWatchface()) {
                        voiceManager.sendMsg(str);
                        AIWatchFaceManager.xoXoI(AIWatchFaceManager.f19897oIX0oI, str, null, 0, 6, null);
                        return;
                    }
                    voiceManager.senAudioTextToDevice(new BleVoice(0, System.currentTimeMillis(), str, 0, 8, null));
                    try {
                        JsonArray asJsonArray = JsonParser.parseString(Xo0.f24349oIX0oI.XO().getString(VoiceMessage.class.getName() + oOXoIIIo.XO.f32008oIX0oI)).getAsJsonArray();
                        IIX0o.ooOOo0oXI(asJsonArray);
                        ooXIXxIX2 = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
                        Iterator<JsonElement> it = asJsonArray.iterator();
                        while (it.hasNext()) {
                            ooXIXxIX2.add(new Gson().fromJson(it.next(), VoiceMessage.class));
                        }
                    } catch (Exception unused) {
                        ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
                    }
                    List o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
                    VoiceManager voiceManager2 = VoiceManager.INSTANCE;
                    VoiceManager.postEvent$default(voiceManager2, x0xO0oo.f24608XIXIX, null, 2, null);
                    o0Xo0XII.add(new VoiceMessage(0, null, 1, str, null, 0, 51, null));
                    o0Xo0XII.add(new VoiceMessage(0, null, 2, "", null, 1, 19, null));
                    Xo0.f24349oIX0oI.XO().put(VoiceMessage.class.getName() + oOXoIIIo.XO.f32008oIX0oI, new Gson().toJson(o0Xo0XII));
                    VoiceManager.postEvent$default(voiceManager2, x0xO0oo.f24655xOOOX, null, 2, null);
                    voiceManager2.openAiChatCompletion(str);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void openAiCheck$default(VoiceManager voiceManager, String str, xxxI.II0xO0 iI0xO0, Activity activity, View view, int i, Object obj) {
        if ((i & 2) != 0) {
            iI0xO0 = null;
        }
        if ((i & 4) != 0) {
            activity = null;
        }
        if ((i & 8) != 0) {
            view = null;
        }
        voiceManager.openAiCheck(str, iI0xO0, activity, view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void openAiTranscriptionsAudio$default(VoiceManager voiceManager, File file, xxxI.II0xO0 iI0xO0, int i, Object obj) {
        if ((i & 2) != 0) {
            iI0xO0 = null;
        }
        voiceManager.openAiTranscriptionsAudio(file, iI0xO0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openAiTranscriptionsAudio$lambda$9(long j, long j2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pcmToWav() {
        IoOoo ioOoo = new IoOoo(16000, 16, 2);
        String path = mPcmFile.getPath();
        File file = mWavFile;
        ioOoo.oIX0oI(path, file.getPath());
        INSTANCE.aiTranscriptionsAudioFile(file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pollCheckStop() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.sma.smartv3.biz.voice.VoiceManager$pollCheckStop$timerTask$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Runner runner;
                boolean z;
                Runner runner2;
                runner = VoiceManager.mFullRunner;
                if (runner != null) {
                    runner2 = VoiceManager.mFullRunner;
                    IIX0o.ooOOo0oXI(runner2);
                    if (runner2.isClosed()) {
                        VoiceManager voiceManager = VoiceManager.INSTANCE;
                        VoiceManager.isRealTimeRunning = false;
                    }
                }
                z = VoiceManager.isRealTimeRunning;
                if (!z) {
                    cancel();
                    timer.cancel();
                    VoiceManager.INSTANCE.stopRealTime();
                }
            }
        }, 500L, 500L);
    }

    public static /* synthetic */ void postEvent$default(VoiceManager voiceManager, String str, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = new Object();
        }
        voiceManager.postEvent(str, obj);
    }

    private final void savePcmFile() {
        xoIXOxX.II0xO0.I0Io(false, false, null, null, 0, VoiceManager$savePcmFile$1.INSTANCE, 31, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendContentResult(String str) {
        if (StringsKt__StringsKt.oIoIXxIO(str).toString().length() == 0) {
            sendTranslationResultInput(UtilsKt.oI0IIXIo(R.string.speech_recognition_error));
            return;
        }
        synchronized (str) {
            try {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager  sendContentResult  str");
                VoiceManager voiceManager = INSTANCE;
                voiceManager.sendTranslationResultInput(str);
                if (voiceManager.isSupportAIVoiceWatchface()) {
                    AIWatchFaceManager.xoXoI(AIWatchFaceManager.f19897oIX0oI, str, null, mAIMode, 2, null);
                } else {
                    if (!voiceManager.isSupportEarPhoneVoiceTranslation() && !voiceManager.isSupportAIVoiceTranslation()) {
                        voiceManager.toAIChatManagerHandleResponse(str);
                    }
                    String formatMicrosoftTargetLang = Languages.INSTANCE.formatMicrosoftTargetLang(mToLanguage, Languages.DEFAULT_LANGUAGE);
                    MicrosoftSDKManage.II0xO0 iI0xO0 = MicrosoftSDKManage.f24259Xx000oIo;
                    iI0xO0.oIX0oI().xoIxX();
                    iI0xO0.oIX0oI().oXxOI0oIx(str, formatMicrosoftTargetLang, new Oox.oOoXoXO<String, oXIO0o0XI>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$sendContentResult$1$1
                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(String str2) {
                            invoke2(str2);
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo String it) {
                            IIX0o.x0xO0oo(it, "it");
                            DcsTtsPlayer.INSTANCE.stop();
                            VoiceManager voiceManager2 = VoiceManager.INSTANCE;
                            voiceManager2.sendTranslationResultOutput(it);
                            MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().xI(it, voiceManager2.getMicrosoftTtsName());
                            voiceManager2.setMContentResult("");
                        }
                    });
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendError(String str) {
        isSpeechRecRunning = false;
        sendMsg(str);
    }

    public static /* synthetic */ void sendError$default(VoiceManager voiceManager, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = Utils.getApp().getString(R.string.request_error);
            IIX0o.oO(str, "getString(...)");
        }
        voiceManager.sendError(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendMsg(String str) {
        senAudioTextToDevice(new BleVoice(0, System.currentTimeMillis(), str, 0, 8, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendRealTime(byte[] bArr) {
        try {
            PipedOutputStream pipedOutputStream = mOutputStream;
            if (pipedOutputStream != null) {
                pipedOutputStream.write(bArr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ void setLanguageType$default(VoiceManager voiceManager, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = "";
        }
        voiceManager.setLanguageType(str, str2);
    }

    private final void startRealTime() {
        if (isRealTimeRunning) {
            return;
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager -> startRealTime");
        ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<Void>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$startRealTime$1
            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public void onSuccess(@OXOo.oOoXoXO Void r1) {
            }

            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            @OXOo.oOoXoXO
            public Void doInBackground() {
                PipedInputStream pipedInputStream;
                PipedInputStream pipedInputStream2;
                Runner runner;
                VoiceManager voiceManager = VoiceManager.INSTANCE;
                VoiceManager.isRealTimeRunning = true;
                VoiceManager.mInputStream = new PipedInputStream();
                pipedInputStream = VoiceManager.mInputStream;
                VoiceManager.mOutputStream = new PipedOutputStream(pipedInputStream);
                pipedInputStream2 = VoiceManager.mInputStream;
                VoiceManager.mFullRunner = new Runner(pipedInputStream2, 2);
                runner = VoiceManager.mFullRunner;
                if (runner != null) {
                    runner.run(new SimpleDownloader() { // from class: com.sma.smartv3.biz.voice.VoiceManager$startRealTime$1$doInBackground$1
                        @Override // com.baidu.ai.speech.realtime.full.download.SimpleDownloader
                        public void onFailure(@OXOo.OOXIXo String reason) {
                            IIX0o.x0xO0oo(reason, "reason");
                            OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager onFailure -> " + reason);
                            ToastUtils.showLong(UtilsKt.oI0IIXIo(R.string.speech_recognition_error) + '\n' + reason, new Object[0]);
                            VoiceManager.INSTANCE.sendError(UtilsKt.oI0IIXIo(R.string.speech_recognition_error));
                        }

                        @Override // com.baidu.ai.speech.realtime.full.download.SimpleDownloader
                        public void onMessage(@OXOo.OOXIXo Result result) {
                            boolean z;
                            Collection ooXIXxIX2;
                            Application application;
                            IIX0o.x0xO0oo(result, "result");
                            OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager onMessage -> " + result.getOrignalJsonStr());
                            VoiceManager voiceManager2 = VoiceManager.INSTANCE;
                            voiceManager2.setSpeechRecRunning(true);
                            if (!result.isError() && result.isFin()) {
                                String result2 = result.getResult();
                                if (TextUtils.isEmpty(result2)) {
                                    voiceManager2.sendError(UtilsKt.oI0IIXIo(R.string.speech_recognition_error));
                                    return;
                                }
                                if (!voiceManager2.isSupportAIVoiceWatchface()) {
                                    z = VoiceManager.isAiTaskRunning;
                                    Application application2 = null;
                                    if (z) {
                                        application = VoiceManager.mApp;
                                        if (application == null) {
                                            IIX0o.XOxIOxOx("mApp");
                                        } else {
                                            application2 = application;
                                        }
                                        String string = application2.getString(R.string.task_running_wait_tip);
                                        IIX0o.oO(string, "getString(...)");
                                        voiceManager2.sendError(string);
                                        return;
                                    }
                                    voiceManager2.setSpeechRecRunning(false);
                                    long currentTimeMillis = System.currentTimeMillis();
                                    IIX0o.ooOOo0oXI(result2);
                                    voiceManager2.senAudioTextToDevice(new BleVoice(0, currentTimeMillis, result2, 0, 8, null));
                                    try {
                                        JsonArray asJsonArray = JsonParser.parseString(Xo0.f24349oIX0oI.XO().getString(VoiceMessage.class.getName() + oOXoIIIo.XO.f32008oIX0oI)).getAsJsonArray();
                                        IIX0o.ooOOo0oXI(asJsonArray);
                                        ooXIXxIX2 = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
                                        Iterator<JsonElement> it = asJsonArray.iterator();
                                        while (it.hasNext()) {
                                            ooXIXxIX2.add(new Gson().fromJson(it.next(), VoiceMessage.class));
                                        }
                                    } catch (Exception unused) {
                                        ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
                                    }
                                    List o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
                                    VoiceManager voiceManager3 = VoiceManager.INSTANCE;
                                    VoiceManager.postEvent$default(voiceManager3, x0xO0oo.f24608XIXIX, null, 2, null);
                                    o0Xo0XII.add(new VoiceMessage(0, null, 1, result2, null, 0, 51, null));
                                    o0Xo0XII.add(new VoiceMessage(0, null, 2, "", null, 1, 19, null));
                                    Xo0.f24349oIX0oI.XO().put(VoiceMessage.class.getName() + oOXoIIIo.XO.f32008oIX0oI, new Gson().toJson(o0Xo0XII));
                                    VoiceManager.postEvent$default(voiceManager3, x0xO0oo.f24655xOOOX, null, 2, null);
                                    OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager onMessage -> start query: " + result2);
                                    voiceManager3.voiceQuery(result2);
                                    return;
                                }
                                IIX0o.ooOOo0oXI(result2);
                                voiceManager2.sendMsg(result2);
                                AIWatchFaceManager.xoXoI(AIWatchFaceManager.f19897oIX0oI, result2, null, 0, 6, null);
                            }
                        }
                    });
                }
                voiceManager.pollCheckStop();
                return null;
            }
        });
    }

    public static /* synthetic */ void startTransfer$default(VoiceManager voiceManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        voiceManager.startTransfer(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopRealTime() {
        try {
            try {
                PipedInputStream pipedInputStream = mInputStream;
                if (pipedInputStream != null) {
                    pipedInputStream.close();
                }
                PipedOutputStream pipedOutputStream = mOutputStream;
                if (pipedOutputStream != null) {
                    pipedOutputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            mInputStream = null;
            mOutputStream = null;
            mFullRunner = null;
            isRealTimeRunning = false;
        } catch (Throwable th) {
            mInputStream = null;
            mOutputStream = null;
            mFullRunner = null;
            isRealTimeRunning = false;
            throw th;
        }
    }

    private final void toAIChatManagerHandleResponse(String str) {
        Collection ooXIXxIX2;
        sendMsg(str);
        if (isSupportAIVoiceWatchface()) {
            AIWatchFaceManager.xoXoI(AIWatchFaceManager.f19897oIX0oI, str, null, 0, 6, null);
            return;
        }
        try {
            JsonArray asJsonArray = JsonParser.parseString(Xo0.f24349oIX0oI.XO().getString(VoiceMessage.class.getName() + oOXoIIIo.XO.f32008oIX0oI)).getAsJsonArray();
            IIX0o.ooOOo0oXI(asJsonArray);
            ooXIXxIX2 = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                ooXIXxIX2.add(new Gson().fromJson(it.next(), VoiceMessage.class));
            }
        } catch (Exception unused) {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        List o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
        VoiceManager voiceManager = INSTANCE;
        postEvent$default(voiceManager, x0xO0oo.f24608XIXIX, null, 2, null);
        o0Xo0XII.add(new VoiceMessage(0, null, 1, str, null, 0, 51, null));
        o0Xo0XII.add(new VoiceMessage(0, null, 2, "", null, 1, 19, null));
        Xo0.f24349oIX0oI.XO().put(VoiceMessage.class.getName() + oOXoIIIo.XO.f32008oIX0oI, new Gson().toJson(o0Xo0XII));
        postEvent$default(voiceManager, x0xO0oo.f24655xOOOX, null, 2, null);
        int i = mAIMode;
        if (i == 2) {
            AISparkChainManager.f19871oIX0oI.XOxIOxOx(str, mAISparkChainManagerCallback, ProductManager.f20544oIX0oI.xX(), true);
            return;
        }
        if (i >= 0 && i <= 3) {
            AIChat(str);
            return;
        }
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.oO0OX0()) {
            AISparkChainManager.f19871oIX0oI.XOxIOxOx(str, mAISparkChainManagerCallback, productManager.xX(), true);
            return;
        }
        if (productManager.XOx()) {
            AIChat(str);
        } else if (productManager.xIx0XO()) {
            voiceQuery(str);
        } else {
            openAiChatCompletion(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void translateITS(final String str, String str2, final String str3) {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager  translateITS leftLang = " + str2 + " , rightLang = " + str3);
        AISparkChainManager.f19871oIX0oI.OOXIxO0(str, str2, str3, new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$translateITS$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                VoiceManager.INSTANCE.sendTranslationResult(str, UtilsKt.oI0IIXIo(R.string.voice_assistant_common_error));
            }

            @Override // xxxI.II0xO0
            public void handleResponse(@OXOo.oOoXoXO String str4) {
                if (str4 != null && str4.length() > 0) {
                    VoiceManager.INSTANCE.sendTranslationResult(str, str4);
                    DcsTtsPlayer dcsTtsPlayer = DcsTtsPlayer.INSTANCE;
                    dcsTtsPlayer.initSegmentation();
                    DcsTtsPlayer.play$default(dcsTtsPlayer, str4, true, false, null, LanguageTranslationKt.getTranslationLanguageTtsName(str3), 12, null);
                    return;
                }
                VoiceManager.INSTANCE.sendTranslationResult(str, UtilsKt.oI0IIXIo(R.string.voice_assistant_common_error));
            }
        });
    }

    public static /* synthetic */ void translateITS$default(VoiceManager voiceManager, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "cn";
        }
        if ((i & 4) != 0) {
            str3 = Languages.DEFAULT_LANGUAGE;
        }
        voiceManager.translateITS(str, str2, str3);
    }

    public final void AIChat(@OXOo.OOXIXo final String query) {
        IIX0o.x0xO0oo(query, "query");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager AIChat -> " + query);
        isAiTaskRunning = true;
        AIManager.f19833oIX0oI.xI(new AIQuestion(AIFunctionType.AI, query, null, null, false, 28, null), new xxxI.II0xO0<AIAnswer>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$AIChat$1
            private int index;
            private long lastSendTime = System.currentTimeMillis();

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:13:0x007a, code lost:
            
                if (r7.equals("5002") == false) goto L26;
             */
            /* JADX WARN: Code restructure failed: missing block: B:14:0x008f, code lost:
            
                r1.postEvent(com.sma.smartv3.util.XoI0Ixx0.f24412XI, r7);
             */
            /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x0083, code lost:
            
                if (r7.equals("5001") == false) goto L26;
             */
            /* JADX WARN: Code restructure failed: missing block: B:19:0x008c, code lost:
            
                if (r7.equals("4006") == false) goto L26;
             */
            /* JADX WARN: Failed to find 'out' block for switch in B:6:0x005c. Please report as an issue. */
            @Override // xxxI.II0xO0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void handleError(@OXOo.OOXIXo java.lang.String r7) {
                /*
                    r6 = this;
                    java.lang.String r0 = "error"
                    kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r0)
                    OI0.oIX0oI r0 = OI0.oIX0oI.f1507oIX0oI
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "AIManager VoiceManager AIChat -> error:"
                    r1.append(r2)
                    r1.append(r7)
                    java.lang.String r2 = ", index:"
                    r1.append(r2)
                    int r2 = r6.index
                    r1.append(r2)
                    java.lang.String r1 = r1.toString()
                    r0.oIX0oI(r1)
                    com.sma.smartv3.biz.voice.VoiceManager r1 = com.sma.smartv3.biz.voice.VoiceManager.INSTANCE
                    r2 = 0
                    com.sma.smartv3.biz.voice.VoiceManager.access$setAiTaskRunning$p(r2)
                    java.lang.String r3 = "200"
                    r4 = 2
                    r5 = 0
                    boolean r3 = kotlin.text.StringsKt__StringsKt.o00xOoIO(r7, r3, r2, r4, r5)
                    if (r3 != 0) goto Laf
                    java.lang.String r3 = "java.net.SocketException"
                    boolean r3 = kotlin.text.OxI.IOOoXo0Ix(r7, r3, r2, r4, r5)
                    if (r3 == 0) goto L3f
                    goto Laf
                L3f:
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    com.blankj.utilcode.util.ToastUtils.showLong(r7, r2)
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "AIManager VoiceManager AIChat ->  error: 11 "
                    r2.append(r3)
                    r2.append(r7)
                    java.lang.String r2 = r2.toString()
                    r0.oIX0oI(r2)
                    int r0 = r7.hashCode()
                    switch(r0) {
                        case 1537218: goto L95;
                        case 1596802: goto L86;
                        case 1626588: goto L7d;
                        case 1626589: goto L74;
                        case 3392903: goto L60;
                        default: goto L5f;
                    }
                L5f:
                    goto L9d
                L60:
                    java.lang.String r0 = "null"
                    boolean r7 = r7.equals(r0)
                    if (r7 != 0) goto L69
                    goto L9d
                L69:
                    r7 = 2132022086(0x7f141346, float:1.9682582E38)
                    java.lang.String r7 = com.sma.smartv3.util.UtilsKt.oI0IIXIo(r7)
                    com.sma.smartv3.biz.voice.VoiceManager.access$sendError(r1, r7)
                    goto Lc5
                L74:
                    java.lang.String r0 = "5002"
                    boolean r0 = r7.equals(r0)
                    if (r0 != 0) goto L8f
                    goto L9d
                L7d:
                    java.lang.String r0 = "5001"
                    boolean r0 = r7.equals(r0)
                    if (r0 != 0) goto L8f
                    goto L9d
                L86:
                    java.lang.String r0 = "4006"
                    boolean r0 = r7.equals(r0)
                    if (r0 != 0) goto L8f
                    goto L9d
                L8f:
                    java.lang.String r0 = "AI_VOICE_TIP_MEMBER"
                    r1.postEvent(r0, r7)
                    goto Lc5
                L95:
                    java.lang.String r0 = "2004"
                    boolean r7 = r7.equals(r0)
                    if (r7 != 0) goto La8
                L9d:
                    r7 = 2132022087(0x7f141347, float:1.9682584E38)
                    java.lang.String r7 = com.sma.smartv3.util.UtilsKt.oI0IIXIo(r7)
                    com.sma.smartv3.biz.voice.VoiceManager.access$sendError(r1, r7)
                    goto Lc5
                La8:
                    r7 = 2132019400(0x7f1408c8, float:1.9677134E38)
                    com.blankj.utilcode.util.ToastUtils.showLong(r7)
                    goto Lc5
                Laf:
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    r7.<init>()
                    java.lang.String r1 = "AIManager VoiceManager AIChat -> error:, index:"
                    r7.append(r1)
                    int r1 = r6.index
                    r7.append(r1)
                    java.lang.String r7 = r7.toString()
                    r0.oIX0oI(r7)
                Lc5:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.biz.voice.VoiceManager$AIChat$1.handleError(java.lang.String):void");
            }

            /* JADX WARN: Can't wrap try/catch for region: R(10:3|(9:7|(1:9)|11|12|13|(2:16|14)|17|18|(4:20|(1:22)|23|24)(1:26))|29|11|12|13|(1:14)|17|18|(0)(0)) */
            /* JADX WARN: Code restructure failed: missing block: B:10:0x004f, code lost:
            
                if ((java.lang.System.currentTimeMillis() - r12.lastSendTime) > 120) goto L12;
             */
            /* JADX WARN: Code restructure failed: missing block: B:28:0x00c4, code lost:
            
                r4 = kotlin.collections.CollectionsKt__CollectionsKt.ooXIXxIX();
             */
            /* JADX WARN: Removed duplicated region for block: B:16:0x00b1 A[Catch: Exception -> 0x00c4, LOOP:0: B:14:0x00ab->B:16:0x00b1, LOOP_END, TRY_LEAVE, TryCatch #0 {Exception -> 0x00c4, blocks: (B:13:0x007a, B:14:0x00ab, B:16:0x00b1), top: B:12:0x007a }] */
            /* JADX WARN: Removed duplicated region for block: B:20:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
            @Override // xxxI.II0xO0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void handleResponse(@OXOo.oOoXoXO com.sma.smartv3.model.AIAnswer r13) {
                /*
                    Method dump skipped, instructions count: 287
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.biz.voice.VoiceManager$AIChat$1.handleResponse(com.sma.smartv3.model.AIAnswer):void");
            }
        }, true, false, ProductManager.f20544oIX0oI.xX(), mAIMode);
    }

    public final void aISparkChainManagerHandleResponse(@OXOo.oOoXoXO AITranslation aITranslation) {
        if (aITranslation != null) {
            toAIChatManagerHandleResponse(aITranslation.getText());
            return;
        }
        Application application = mApp;
        if (application == null) {
            IIX0o.XOxIOxOx("mApp");
            application = null;
        }
        String string = application.getString(R.string.request_error);
        IIX0o.oO(string, "getString(...)");
        sendError(string);
    }

    public final void aiTranscriptionsAudio(@OXOo.OOXIXo File file, @OXOo.oOoXoXO final xxxI.II0xO0<String> iI0xO0) {
        String language;
        IIX0o.x0xO0oo(file, "file");
        String IXxxXO2 = AIManager.f19833oIX0oI.IXxxXO(mAIMode);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        String baseUrl = netWorkUtils.getBaseUrl(GetAIAudioToText.URL);
        Application app = Utils.getApp();
        IIX0o.oO(app, "getApp(...)");
        if (UtilsKt.IO(app)) {
            language = Languages.DEFAULT_LANGUAGE_ZH;
        } else {
            language = Utils.getApp().getResources().getConfiguration().locale.getLanguage();
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager aiTranscriptionsAudio -> " + file + "  toLang = " + language + " , model = " + IXxxXO2);
        AndroidNetworking.upload(baseUrl).addHeaders(netWorkUtils.getHeadersMap()).addQueryParameter("model", IXxxXO2).addQueryParameter("toLang", language).addMultipartFile("audioFile", file).setTag((Object) "aiTranscriptionsAudio").setPriority(Priority.HIGH).build().setUploadProgressListener(new UploadProgressListener() { // from class: com.sma.smartv3.biz.voice.xxIXOIIO
            @Override // com.androidnetworking.interfaces.UploadProgressListener
            public final void onProgress(long j, long j2) {
                VoiceManager.aiTranscriptionsAudio$lambda$8(j, j2);
            }
        }).getAsJSONObject(new JSONObjectRequestListener() { // from class: com.sma.smartv3.biz.voice.VoiceManager$aiTranscriptionsAudio$2
            @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
            public void onError(@OXOo.OOXIXo ANError anError) {
                AIError aIError;
                IIX0o.x0xO0oo(anError, "anError");
                AIBase aIBase = (AIBase) anError.getErrorAsObject(AIBase.class);
                if (aIBase == null || (aIError = aIBase.getError()) == null) {
                    aIError = new AIError(String.valueOf(anError.getMessage()), null, null, null, 14, null);
                }
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("onError -> " + anError.getErrorBody() + ", " + aIError);
                AIManager.f19833oIX0oI.XIxXXX0x0(aIError);
                xxxI.II0xO0<String> iI0xO02 = iI0xO0;
                if (iI0xO02 != null) {
                    iI0xO02.handleError(aIError.getMessage());
                }
            }

            @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
            public void onResponse(@OXOo.oOoXoXO JSONObject jSONObject) {
                xxxI.II0xO0<String> iI0xO02;
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager aiTranscriptionsAudio onResponse -> " + jSONObject);
                if (jSONObject != null) {
                    try {
                        String string = jSONObject.getString("data");
                        if (string != null && (iI0xO02 = iI0xO0) != null) {
                            iI0xO02.handleResponse(string);
                        }
                    } catch (Exception unused) {
                        AIError aIError = new AIError(UtilsKt.oI0IIXIo(R.string.voice_assistant_common_error), null, null, null, 14, null);
                        AIManager.f19833oIX0oI.XIxXXX0x0(aIError);
                        xxxI.II0xO0<String> iI0xO03 = iI0xO0;
                        if (iI0xO03 != null) {
                            iI0xO03.handleError(aIError.getMessage());
                        }
                    }
                }
            }
        });
    }

    public final void checkBaiduAuth(@OXOo.oOoXoXO final Activity activity, @OXOo.oOoXoXO View view, @OXOo.OOXIXo final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> callback) {
        IIX0o.x0xO0oo(callback, "callback");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        String url = GetDcsToken.INSTANCE.getURL();
        HashMap<String, String> dcsTokenBody = RequestBodyKt.getDcsTokenBody();
        final xxxI.II0xO0<DcsToken> iI0xO0 = new xxxI.II0xO0<DcsToken>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$checkBaiduAuth$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager refreshToken onError -> " + error);
                callback.invoke(Boolean.FALSE);
            }

            @Override // xxxI.II0xO0
            public void handleResponse(@OXOo.oOoXoXO DcsToken dcsToken) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager refreshToken handleResponse -> " + dcsToken);
                if (dcsToken != null) {
                    dcsToken.setTimestamp(System.currentTimeMillis());
                    Xo0.f24349oIX0oI.XO().put(DcsToken.class.getName(), new Gson().toJson(dcsToken));
                    callback.invoke(Boolean.TRUE);
                }
            }
        };
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(activity, view);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), url);
        netWorkUtils.printParam(convertBaseUrl + url, dcsTokenBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + url;
        final xxxI.II0xO0<Response<DcsToken>> iI0xO02 = new xxxI.II0xO0<Response<DcsToken>>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$checkBaiduAuth$$inlined$post$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            public void handleResponse(@OXOo.oOoXoXO Response<DcsToken> response) {
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
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) dcsTokenBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, DcsToken.class), new ParsedRequestListener<Response<DcsToken>>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$checkBaiduAuth$$inlined$post$2
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

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onResponse(@OXOo.OOXIXo Response<DcsToken> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }
        });
    }

    public final void destroy() {
        stop();
        BleConnector.INSTANCE.removeHandleCallback(mBleHandleCallback);
        OpusManager opusManager = mOpusManager;
        if (opusManager != null) {
            opusManager.release();
        }
        mOpusManager = null;
    }

    public final void duserStreamChat(@OXOo.OOXIXo String query) {
        IIX0o.x0xO0oo(query, "query");
        isAiTaskRunning = true;
        AIManager aIManager = AIManager.f19833oIX0oI;
        aIManager.Io(true);
        aIManager.OI0(new xxxI.II0xO0<AIAnswer>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$duserStreamChat$1
            private int index;
            private long lastSendTime = System.currentTimeMillis();

            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                oix0oi.oIX0oI("AIManager VoiceManager duserStreamChat -> error:" + error);
                VoiceManager voiceManager = VoiceManager.INSTANCE;
                VoiceManager.isAiTaskRunning = false;
                if (StringsKt__StringsKt.o00xOoIO(error, "200", false, 2, null)) {
                    oix0oi.oIX0oI("AIManager VoiceManager duserStreamChat -> error:异常中断, index:" + this.index);
                    return;
                }
                ToastUtils.showLong(error, new Object[0]);
                if (IIX0o.Oxx0IOOO(error, "null")) {
                    voiceManager.sendError(UtilsKt.oI0IIXIo(R.string.voice_assistant_common_error));
                } else {
                    voiceManager.sendError(UtilsKt.oI0IIXIo(R.string.voice_assistant_network_error));
                }
            }

            /* JADX WARN: Can't wrap try/catch for region: R(10:3|(9:7|(1:9)|11|12|13|(2:16|14)|17|18|(4:20|(1:22)|23|24)(1:26))|29|11|12|13|(1:14)|17|18|(0)(0)) */
            /* JADX WARN: Code restructure failed: missing block: B:10:0x0037, code lost:
            
                if ((java.lang.System.currentTimeMillis() - r12.lastSendTime) > 500) goto L12;
             */
            /* JADX WARN: Code restructure failed: missing block: B:28:0x00ac, code lost:
            
                r4 = kotlin.collections.CollectionsKt__CollectionsKt.ooXIXxIX();
             */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0099 A[Catch: Exception -> 0x00ac, LOOP:0: B:14:0x0093->B:16:0x0099, LOOP_END, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ac, blocks: (B:13:0x0062, B:14:0x0093, B:16:0x0099), top: B:12:0x0062 }] */
            /* JADX WARN: Removed duplicated region for block: B:20:0x00c2  */
            /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
            @Override // xxxI.II0xO0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void handleResponse(@OXOo.oOoXoXO com.sma.smartv3.model.AIAnswer r13) {
                /*
                    r12 = this;
                    java.lang.String r0 = "_list"
                    java.lang.Class<com.sma.smartv3.biz.voice.VoiceMessage> r1 = com.sma.smartv3.biz.voice.VoiceMessage.class
                    if (r13 == 0) goto L106
                    int r2 = r12.index
                    r3 = 1
                    int r2 = r2 + r3
                    r12.index = r2
                    if (r2 == r3) goto L39
                    int r2 = r13.getEnded()
                    if (r2 == r3) goto L39
                    java.lang.String r2 = r13.getText()
                    java.nio.charset.Charset r4 = kotlin.text.oxoX.f29581II0xO0
                    byte[] r2 = r2.getBytes(r4)
                    java.lang.String r4 = "getBytes(...)"
                    kotlin.jvm.internal.IIX0o.oO(r2, r4)
                    int r2 = r2.length
                    com.szabh.smable3.entity.BleVoice$Companion r4 = com.szabh.smable3.entity.BleVoice.Companion
                    int r4 = r4.getCONTENT_MAX_LENGTH()
                    if (r2 >= r4) goto L5c
                    long r4 = java.lang.System.currentTimeMillis()
                    long r6 = r12.lastSendTime
                    long r4 = r4 - r6
                    r6 = 500(0x1f4, double:2.47E-321)
                    int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                    if (r2 <= 0) goto L5c
                L39:
                    com.szabh.smable3.entity.BleVoice r2 = new com.szabh.smable3.entity.BleVoice
                    long r6 = java.lang.System.currentTimeMillis()
                    java.lang.String r8 = r13.getText()
                    r10 = 8
                    r11 = 0
                    r5 = 1
                    r9 = 0
                    r4 = r2
                    r4.<init>(r5, r6, r8, r9, r10, r11)
                    com.sma.smartv3.biz.voice.VoiceManager r4 = com.sma.smartv3.biz.voice.VoiceManager.INSTANCE
                    r4.senAudioTextToDevice(r2)
                    com.szabh.smable3.component.BleConnector r2 = com.szabh.smable3.component.BleConnector.INSTANCE
                    r2.setDisableStreamLog(r3)
                    long r4 = java.lang.System.currentTimeMillis()
                    r12.lastSendTime = r4
                L5c:
                    com.sma.smartv3.util.Xo0 r2 = com.sma.smartv3.util.Xo0.f24349oIX0oI
                    com.blankj.utilcode.util.SPUtils r2 = r2.XO()
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lac
                    r4.<init>()     // Catch: java.lang.Exception -> Lac
                    java.lang.String r5 = r1.getName()     // Catch: java.lang.Exception -> Lac
                    r4.append(r5)     // Catch: java.lang.Exception -> Lac
                    r4.append(r0)     // Catch: java.lang.Exception -> Lac
                    java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> Lac
                    java.lang.String r2 = r2.getString(r4)     // Catch: java.lang.Exception -> Lac
                    com.google.gson.JsonElement r2 = com.google.gson.JsonParser.parseString(r2)     // Catch: java.lang.Exception -> Lac
                    com.google.gson.JsonArray r2 = r2.getAsJsonArray()     // Catch: java.lang.Exception -> Lac
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(r2)     // Catch: java.lang.Exception -> Lac
                    java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Exception -> Lac
                    r5 = 10
                    int r5 = kotlin.collections.OxxIIOOXO.xo0x(r2, r5)     // Catch: java.lang.Exception -> Lac
                    r4.<init>(r5)     // Catch: java.lang.Exception -> Lac
                    java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Exception -> Lac
                L93:
                    boolean r5 = r2.hasNext()     // Catch: java.lang.Exception -> Lac
                    if (r5 == 0) goto Lb0
                    java.lang.Object r5 = r2.next()     // Catch: java.lang.Exception -> Lac
                    com.google.gson.JsonElement r5 = (com.google.gson.JsonElement) r5     // Catch: java.lang.Exception -> Lac
                    com.google.gson.Gson r6 = new com.google.gson.Gson     // Catch: java.lang.Exception -> Lac
                    r6.<init>()     // Catch: java.lang.Exception -> Lac
                    java.lang.Object r5 = r6.fromJson(r5, r1)     // Catch: java.lang.Exception -> Lac
                    r4.add(r5)     // Catch: java.lang.Exception -> Lac
                    goto L93
                Lac:
                    java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.ooXIXxIX()
                Lb0:
                    java.util.Collection r4 = (java.util.Collection) r4
                    java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.o0Xo0XII(r4)
                    java.lang.Object r4 = kotlin.collections.CollectionsKt___CollectionsKt.O0O0Io00X(r2)
                    com.sma.smartv3.biz.voice.VoiceMessage r4 = (com.sma.smartv3.biz.voice.VoiceMessage) r4
                    int r5 = r4.getMStatus()
                    if (r5 != r3) goto L106
                    int r5 = r13.getEnded()
                    if (r5 != r3) goto Ld1
                    r3 = 0
                    r4.setMStatus(r3)
                    com.sma.smartv3.biz.voice.VoiceManager r5 = com.sma.smartv3.biz.voice.VoiceManager.INSTANCE
                    com.sma.smartv3.biz.voice.VoiceManager.access$setAiTaskRunning$p(r3)
                Ld1:
                    java.lang.String r13 = r13.getText()
                    r4.setMContent(r13)
                    com.sma.smartv3.util.Xo0 r13 = com.sma.smartv3.util.Xo0.f24349oIX0oI
                    com.blankj.utilcode.util.SPUtils r13 = r13.XO()
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r1 = r1.getName()
                    r3.append(r1)
                    r3.append(r0)
                    java.lang.String r0 = r3.toString()
                    com.google.gson.Gson r1 = new com.google.gson.Gson
                    r1.<init>()
                    java.lang.String r1 = r1.toJson(r2)
                    r13.put(r0, r1)
                    com.sma.smartv3.biz.voice.VoiceManager r13 = com.sma.smartv3.biz.voice.VoiceManager.INSTANCE
                    java.lang.String r0 = "SEND_VOICE"
                    r1 = 2
                    r2 = 0
                    com.sma.smartv3.biz.voice.VoiceManager.postEvent$default(r13, r0, r2, r1, r2)
                L106:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.biz.voice.VoiceManager$duserStreamChat$1.handleResponse(com.sma.smartv3.model.AIAnswer):void");
            }
        });
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.oO0OX0()) {
            AISparkChainManager.f19871oIX0oI.XOxIOxOx(query, mAISparkChainManagerCallback, productManager.xX(), true);
        } else {
            aIManager.Oxx0IOOO(query, AIFunctionType.AI, 2, productManager.xX());
        }
    }

    public final void endTransfer() {
        savePcmFile();
    }

    public final void getAiTranslationType(@OXOo.OOXIXo BleRecordPacket recordPacket) {
        IIX0o.x0xO0oo(recordPacket, "recordPacket");
        if ((isSupportAIVoiceTranslation() || isSupportEarPhoneVoiceTranslation()) && recordPacket.getMStatus() == 0) {
            mLanguage = recordPacket.getMLanguage();
            mToLanguage = recordPacket.getMToLanguage();
        }
    }

    public final long getCONVENTIONAL_IDENTIFY_TIME() {
        return CONVENTIONAL_IDENTIFY_TIME;
    }

    public final long getFIRST_IDENTIFY_TIME() {
        return FIRST_IDENTIFY_TIME;
    }

    @OXOo.OOXIXo
    public final xxxI.II0xO0<AIAnswer> getMAISparkChainManagerCallback() {
        return mAISparkChainManagerCallback;
    }

    @OXOo.OOXIXo
    public final String getMContentResult() {
        return mContentResult;
    }

    public final int getMLanguage() {
        return mLanguage;
    }

    @OXOo.oOoXoXO
    public final IXxxXO<Integer, Integer, Integer, Boolean> getMListener() {
        return mListener;
    }

    @OXOo.OOXIXo
    public final File getMOpusFile() {
        return mOpusFile;
    }

    @OXOo.OOXIXo
    public final File getMPcmFile() {
        return mPcmFile;
    }

    @OXOo.OOXIXo
    public final String getMSavePcmTime() {
        return mSavePcmTime;
    }

    public final int getMToLanguage() {
        return mToLanguage;
    }

    public final int getMVoiceMode() {
        return mVoiceMode;
    }

    @OXOo.OOXIXo
    public final File getMWavFile() {
        return mWavFile;
    }

    @OXOo.OOXIXo
    public final MicrosoftSDKManage.I0Io getMicrosoftCallBack() {
        return microsoftCallBack;
    }

    @OXOo.OOXIXo
    public final String getMicrosoftLanguage() {
        return microsoftLanguage;
    }

    public final long getMicrosoftTime() {
        return microsoftTime;
    }

    @OXOo.OOXIXo
    public final String getMicrosoftTtsLanguage() {
        return microsoftTtsLanguage;
    }

    @OXOo.OOXIXo
    public final String getMicrosoftTtsName() {
        return microsoftTtsName;
    }

    @OXOo.OOXIXo
    public final RecordingManager.OnRecordingCallback getRecordingCallBack() {
        return recordingCallBack;
    }

    public final boolean getResetCallBack() {
        return resetCallBack;
    }

    public final long getSECOND_IDENTIFY_TIME() {
        return SECOND_IDENTIFY_TIME;
    }

    public final void goOnTransfer(@OXOo.OOXIXo BleRecordPacket recordPacket) {
        IIX0o.x0xO0oo(recordPacket, "recordPacket");
        isSpeechRecRunning = true;
        FileIOUtils.writeFileFromBytesByStream(mOpusFile, recordPacket.getMPacket(), true);
    }

    public final void init(@OXOo.OOXIXo Application app) {
        IIX0o.x0xO0oo(app, "app");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager -> init");
        XO0.II0xO0.oxoX().x0XOIxOo(this);
        mApp = app;
        BleConnector.INSTANCE.addHandleCallback(mBleHandleCallback);
        if (mOpusManager == null) {
            try {
                mOpusManager = new OpusManager();
            } catch (Exception e) {
                e.printStackTrace();
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager -> opus init error！！！");
            }
        }
        RecordingManager.Companion companion = RecordingManager.Companion;
        companion.getInstance().init(app);
        companion.getInstance().registerSCOReceiver(app);
        companion.getInstance().setRecordingCallback(recordingCallBack);
        DeviceKeyManager deviceKeyManager = (DeviceKeyManager) new Gson().fromJson(Xo0.f24349oIX0oI.oIX0oI().getString(DeviceKeyManager.class.getName()), DeviceKeyManager.class);
        if (deviceKeyManager != null) {
            MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().xOoOIoI(deviceKeyManager.getFirst(), deviceKeyManager.getSecond());
        }
    }

    public final void initMicrosoftSDKManage() {
        MicrosoftSDKManage.II0xO0 iI0xO0 = MicrosoftSDKManage.f24259Xx000oIo;
        iI0xO0.oIX0oI().oxxXoxO();
        MicrosoftSDKManage oIX0oI2 = iI0xO0.oIX0oI();
        Application application = mApp;
        if (application == null) {
            IIX0o.XOxIOxOx("mApp");
            application = null;
        }
        oIX0oI2.Ioxxx(application);
        iI0xO0.oIX0oI().O0X(microsoftCallBack, TAG);
        microsoftTime = FIRST_IDENTIFY_TIME;
    }

    public final boolean isActivityData() {
        return isActivityData;
    }

    public final boolean isExpired() {
        Object fromJson = new Gson().fromJson(Xo0.f24349oIX0oI.XO().getString(DcsToken.class.getName()), (Class<Object>) DcsToken.class);
        if (fromJson == null) {
            fromJson = DcsToken.class.newInstance();
        }
        if (System.currentTimeMillis() - ((DcsToken) fromJson).getTimestamp() > r0.getExpires_in()) {
            return true;
        }
        return false;
    }

    public final boolean isRecordBluetooth() {
        return isRecordBluetooth;
    }

    public final boolean isSendResults() {
        return isSendResults;
    }

    public final boolean isSpeechRecRunning() {
        return isSpeechRecRunning;
    }

    public final boolean isSupportAIVoiceTranslation() {
        if (mVoiceMode == 2) {
            return true;
        }
        return false;
    }

    public final boolean isSupportAIVoiceWatchface() {
        if (mVoiceMode == 1 && ProductManager.f20544oIX0oI.oo0oIXo()) {
            return true;
        }
        return false;
    }

    public final boolean isSupportDevicePhoneVoiceAIChat() {
        if (mVoiceMode == 0) {
            return true;
        }
        return false;
    }

    public final boolean isSupportEarPhoneVoiceAIChat() {
        if (mVoiceMode == 3) {
            return true;
        }
        return false;
    }

    public final boolean isSupportEarPhoneVoiceTranslation() {
        if (mVoiceMode == 4) {
            return true;
        }
        return false;
    }

    public final boolean isTaskRunning() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("isTaskRunning -> " + isAiTaskRunning + ", " + isSpeechRecRunning);
        if (!isAiTaskRunning && !isSpeechRecRunning) {
            return false;
        }
        return true;
    }

    public final void newReceiveRecordPacket(@OXOo.OOXIXo BleRecordPacket recordPacket) {
        IIX0o.x0xO0oo(recordPacket, "recordPacket");
        int mStatus = recordPacket.getMStatus();
        if (mStatus != 0) {
            if (mStatus != 1) {
                if (mStatus != 2) {
                    if (mStatus != 3) {
                        return;
                    }
                } else {
                    OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                    oix0oi.oIX0oI("AIManager VoiceManager BleRecordPacket newReceiveRecordPacket END");
                    if (!isSupportEarPhoneVoiceAIChat() && !isSupportEarPhoneVoiceTranslation()) {
                        File file = mOpusFile;
                        if (!FileUtils.isFileExists(file)) {
                            oix0oi.oIX0oI("AIManager VoiceManager mOpusManager ->  FileUtils.isFileExists  false ");
                            return;
                        }
                        stop();
                        if (!IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPlatform(), BleDeviceInfo.PLATFORM_SIFLI)) {
                            OpusManager opusManager = mOpusManager;
                            if (opusManager != null) {
                                String path = file.getPath();
                                IIX0o.oO(path, "getPath(...)");
                                String path2 = mPcmFile.getPath();
                                IIX0o.oO(path2, "getPath(...)");
                                opusManager.decodeFile(path, path2, new OpusManager.OnStateCallback() { // from class: com.sma.smartv3.biz.voice.VoiceManager$newReceiveRecordPacket$1
                                    @Override // com.sma.smartv3.biz.voice.OpusManager.OnStateCallback
                                    public void onComplete(@OXOo.OOXIXo String outFilePath) {
                                        IIX0o.x0xO0oo(outFilePath, "outFilePath");
                                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager mOpusManager -> onComplete: " + outFilePath);
                                        VoiceManager voiceManager = VoiceManager.INSTANCE;
                                        if (!voiceManager.isSupportAIVoiceTranslation() || voiceManager.getMLanguage() == -1 || voiceManager.getMToLanguage() == -1) {
                                            voiceManager.pcmToWav();
                                        } else {
                                            voiceManager.sendAISparkChainTranslation();
                                        }
                                    }

                                    @Override // com.sma.smartv3.biz.voice.OpusManager.OnStateCallback
                                    public void onError(int i, @OXOo.OOXIXo String message) {
                                        IIX0o.x0xO0oo(message, "message");
                                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager mOpusManager -> onError: code = " + i + ", message = " + message);
                                        VoiceManager.INSTANCE.sendError(UtilsKt.oI0IIXIo(R.string.speech_recognition_error));
                                    }

                                    @Override // com.sma.smartv3.biz.voice.OpusManager.OnStateCallback
                                    public void onStart() {
                                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager mOpusManager -> onStart");
                                    }
                                });
                            }
                        } else {
                            OpusManager opusManager2 = mOpusManager;
                            if (opusManager2 != null) {
                                String absolutePath = file.getAbsolutePath();
                                IIX0o.oO(absolutePath, "getAbsolutePath(...)");
                                String absolutePath2 = mPcmFile.getAbsolutePath();
                                IIX0o.oO(absolutePath2, "getAbsolutePath(...)");
                                opusManager2.decodeStream(absolutePath, absolutePath2, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$newReceiveRecordPacket$2
                                    @Override // Oox.oOoXoXO
                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                                        invoke(bool.booleanValue());
                                        return oXIO0o0XI.f29392oIX0oI;
                                    }

                                    public final void invoke(boolean z) {
                                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager mOpusManager -> decodeStream  opus to pcm error " + z);
                                        if (z) {
                                            VoiceManager voiceManager = VoiceManager.INSTANCE;
                                            if (!voiceManager.isSupportAIVoiceTranslation() || voiceManager.getMLanguage() == -1 || voiceManager.getMToLanguage() == -1) {
                                                voiceManager.pcmToWav();
                                            } else {
                                                voiceManager.sendAISparkChainTranslation();
                                            }
                                        }
                                    }
                                });
                            }
                        }
                        endTransfer();
                        return;
                    }
                    RecordingManager.Companion.getInstance().stopRecording();
                    endTransfer();
                    return;
                }
            } else {
                goOnTransfer(recordPacket);
                return;
            }
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager BleRecordPacket newReceiveRecordPacket START");
        startTransfer(recordPacket.getMStatus());
    }

    public final void oldReceiveRecordPacket(@OXOo.OOXIXo BleRecordPacket recordPacket) {
        IIX0o.x0xO0oo(recordPacket, "recordPacket");
        if (IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPlatform(), BleDeviceInfo.PLATFORM_SIFLI)) {
            oldReceiveRecordPacketSC(recordPacket);
        } else {
            oldReceiveRecordPacketJL(recordPacket);
        }
    }

    public final void oldReceiveRecordPacketJL(@OXOo.OOXIXo BleRecordPacket recordPacket) {
        IIX0o.x0xO0oo(recordPacket, "recordPacket");
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (!productManager.oO0OX0() && mAIMode != 2) {
            if (productManager.xIx0XO()) {
                int mStatus = recordPacket.getMStatus();
                if (mStatus != 0) {
                    if (mStatus != 1) {
                        if (mStatus != 2) {
                            if (mStatus == 3) {
                                stopRealTime();
                                stop();
                                OpusManager opusManager = mOpusManager;
                                if (opusManager != null) {
                                    opusManager.stopDecodeStream();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager BleRecordPacket oldReceiveRecordPacketJL END");
                        isSpeechRecRunning = false;
                        if (!isSupportEarPhoneVoiceAIChat() && !isSupportEarPhoneVoiceTranslation()) {
                            OpusManager opusManager2 = mOpusManager;
                            if (opusManager2 != null) {
                                opusManager2.stopDecodeStream();
                            }
                        } else {
                            RecordingManager.Companion.getInstance().stopRecording();
                        }
                        endTransfer();
                        return;
                    }
                    isSpeechRecRunning = true;
                    OpusManager opusManager3 = mOpusManager;
                    if (opusManager3 != null) {
                        opusManager3.writeAudioStream(recordPacket.getMPacket());
                        return;
                    }
                    return;
                }
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager BleRecordPacket oldReceiveRecordPacketJL ");
                stopRealTime();
                stop();
                startRealTime();
                OpusManager opusManager4 = mOpusManager;
                if (opusManager4 != null) {
                    opusManager4.stopDecodeStream();
                }
                OpusManager opusManager5 = mOpusManager;
                if (opusManager5 != null) {
                    opusManager5.startDecodeStream(new OpusManager.OnDecodeStreamCallback() { // from class: com.sma.smartv3.biz.voice.VoiceManager$oldReceiveRecordPacketJL$2
                        @Override // com.sma.smartv3.biz.voice.OpusManager.OnStateCallback
                        public void onComplete(@OXOo.OOXIXo String p0) {
                            IIX0o.x0xO0oo(p0, "p0");
                        }

                        @Override // com.sma.smartv3.biz.voice.OpusManager.OnDecodeStreamCallback
                        public void onDecodeStream(@OXOo.OOXIXo byte[] p0) {
                            IIX0o.x0xO0oo(p0, "p0");
                            VoiceManager.INSTANCE.sendRealTime(p0);
                        }

                        @Override // com.sma.smartv3.biz.voice.OpusManager.OnStateCallback
                        public void onError(int i, @OXOo.OOXIXo String p1) {
                            IIX0o.x0xO0oo(p1, "p1");
                            OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager startDecodeStream -> onError: " + i + ", " + p1);
                        }

                        @Override // com.sma.smartv3.biz.voice.OpusManager.OnStateCallback
                        public void onStart() {
                        }
                    });
                    return;
                }
                return;
            }
            int mStatus2 = recordPacket.getMStatus();
            if (mStatus2 != 0) {
                if (mStatus2 != 1) {
                    if (mStatus2 != 2) {
                        if (mStatus2 != 3) {
                            return;
                        }
                    } else {
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager BleRecordPacket oldReceiveRecordPacketJL  openai  end");
                        if (!isSupportEarPhoneVoiceAIChat() && !isSupportEarPhoneVoiceTranslation()) {
                            File file = mOpusFile;
                            if (!FileUtils.isFileExists(file)) {
                                return;
                            }
                            stop();
                            OpusManager opusManager6 = mOpusManager;
                            if (opusManager6 != null) {
                                String path = file.getPath();
                                IIX0o.oO(path, "getPath(...)");
                                String path2 = mPcmFile.getPath();
                                IIX0o.oO(path2, "getPath(...)");
                                opusManager6.decodeFile(path, path2, new OpusManager.OnStateCallback() { // from class: com.sma.smartv3.biz.voice.VoiceManager$oldReceiveRecordPacketJL$3
                                    @Override // com.sma.smartv3.biz.voice.OpusManager.OnStateCallback
                                    public void onComplete(@OXOo.OOXIXo String outFilePath) {
                                        IIX0o.x0xO0oo(outFilePath, "outFilePath");
                                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager mOpusManager -> onComplete: " + outFilePath);
                                        IoOoo ioOoo = new IoOoo(16000, 16, 2);
                                        VoiceManager voiceManager = VoiceManager.INSTANCE;
                                        ioOoo.oIX0oI(voiceManager.getMPcmFile().getPath(), voiceManager.getMWavFile().getPath());
                                        voiceManager.oldOpenAiChatCompletion();
                                    }

                                    @Override // com.sma.smartv3.biz.voice.OpusManager.OnStateCallback
                                    public void onError(int i, @OXOo.OOXIXo String message) {
                                        IIX0o.x0xO0oo(message, "message");
                                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager mOpusManager -> onError: code = " + i + ", message = " + message);
                                        VoiceManager.INSTANCE.sendError(UtilsKt.oI0IIXIo(R.string.speech_recognition_error));
                                    }

                                    @Override // com.sma.smartv3.biz.voice.OpusManager.OnStateCallback
                                    public void onStart() {
                                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager mOpusManager -> onStart");
                                    }
                                });
                            }
                            endTransfer();
                            return;
                        }
                        RecordingManager.Companion.getInstance().stopRecording();
                        endTransfer();
                        return;
                    }
                } else {
                    goOnTransfer(recordPacket);
                    return;
                }
            }
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager BleRecordPacket oldReceiveRecordPacketJL  openai  START");
            startTransfer(recordPacket.getMStatus());
            return;
        }
        int mStatus3 = recordPacket.getMStatus();
        if (mStatus3 != 0) {
            if (mStatus3 != 1) {
                if (mStatus3 != 2) {
                    if (mStatus3 == 3) {
                        stop();
                        OpusManager opusManager7 = mOpusManager;
                        if (opusManager7 != null) {
                            opusManager7.stopDecodeStream();
                            return;
                        }
                        return;
                    }
                    return;
                }
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager BleRecordPacket oldReceiveRecordPacketJL END , isSupportSparkChainAI = " + productManager.oO0OX0());
                if (!isSupportEarPhoneVoiceAIChat() && !isSupportEarPhoneVoiceTranslation()) {
                    isSpeechRecRunning = false;
                    RecordingManager.realTimeASRend$default(RecordingManager.Companion.getInstance(), 0, 0, 3, null);
                } else {
                    RecordingManager.Companion.getInstance().stopRecording();
                }
                endTransfer();
                return;
            }
            if (!isSupportEarPhoneVoiceAIChat() && !isSupportEarPhoneVoiceTranslation()) {
                isSpeechRecRunning = true;
                OpusManager opusManager8 = mOpusManager;
                if (opusManager8 != null) {
                    opusManager8.writeAudioStream(recordPacket.getMPacket());
                    return;
                }
                return;
            }
            goOnTransfer(recordPacket);
            return;
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager BleRecordPacket oldReceiveRecordPacketJL , isSupportSparkChainAI = " + productManager.oO0OX0());
        if (!isSupportEarPhoneVoiceAIChat() && !isSupportEarPhoneVoiceTranslation()) {
            stop();
            DcsTtsPlayer.INSTANCE.deleteReplayMusic();
            RecordingManager.Companion.getInstance().startRealTimeASR();
            OpusManager opusManager9 = mOpusManager;
            if (opusManager9 != null) {
                opusManager9.startDecodeStream(new OpusManager.OnDecodeStreamCallback() { // from class: com.sma.smartv3.biz.voice.VoiceManager$oldReceiveRecordPacketJL$1
                    @Override // com.sma.smartv3.biz.voice.OpusManager.OnStateCallback
                    public void onComplete(@OXOo.OOXIXo String p0) {
                        IIX0o.x0xO0oo(p0, "p0");
                    }

                    @Override // com.sma.smartv3.biz.voice.OpusManager.OnDecodeStreamCallback
                    public void onDecodeStream(@OXOo.OOXIXo byte[] p0) {
                        IIX0o.x0xO0oo(p0, "p0");
                        RecordingManager.realTimeASRing$default(RecordingManager.Companion.getInstance(), p0, 0, p0.length, 2, null);
                        FileIOUtils.writeFileFromBytesByStream(VoiceManager.INSTANCE.getMPcmFile(), p0, true);
                    }

                    @Override // com.sma.smartv3.biz.voice.OpusManager.OnStateCallback
                    public void onError(int i, @OXOo.OOXIXo String p1) {
                        IIX0o.x0xO0oo(p1, "p1");
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager startDecodeStream -> onError: " + i + ", " + p1);
                    }

                    @Override // com.sma.smartv3.biz.voice.OpusManager.OnStateCallback
                    public void onStart() {
                    }
                });
                return;
            }
            return;
        }
        startTransfer(recordPacket.getMStatus());
    }

    public final void oldReceiveRecordPacketSC(@OXOo.OOXIXo BleRecordPacket recordPacket) {
        IIX0o.x0xO0oo(recordPacket, "recordPacket");
        int mStatus = recordPacket.getMStatus();
        if (mStatus != 0) {
            if (mStatus != 1) {
                if (mStatus != 2) {
                    if (mStatus != 3) {
                        return;
                    }
                } else {
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager BleRecordPacket oldReceiveRecordPacketSC END");
                    stop();
                    if ((ProductManager.f20544oIX0oI.oO0OX0() || mAIMode == 2) && recordPacket.getMMode() < 3) {
                        RecordingManager.realTimeASRend$default(RecordingManager.Companion.getInstance(), 0, 0, 3, null);
                        endTransfer();
                        return;
                    }
                    if (!isSupportEarPhoneVoiceAIChat() && !isSupportEarPhoneVoiceTranslation()) {
                        File file = mOpusFile;
                        if (!FileUtils.isFileExists(file)) {
                            return;
                        }
                        OpusManager opusManager = mOpusManager;
                        if (opusManager != null) {
                            String absolutePath = file.getAbsolutePath();
                            IIX0o.oO(absolutePath, "getAbsolutePath(...)");
                            String absolutePath2 = mPcmFile.getAbsolutePath();
                            IIX0o.oO(absolutePath2, "getAbsolutePath(...)");
                            opusManager.decodeStream(absolutePath, absolutePath2, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$oldReceiveRecordPacketSC$2
                                @Override // Oox.oOoXoXO
                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                                    invoke(bool.booleanValue());
                                    return oXIO0o0XI.f29392oIX0oI;
                                }

                                public final void invoke(boolean z) {
                                    OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager mOpusManager -> decodeStream  opus to pcm  " + z);
                                    if (z) {
                                        VoiceManager voiceManager = VoiceManager.INSTANCE;
                                        if (voiceManager.isSupportAIVoiceTranslation() && voiceManager.getMLanguage() != -1 && voiceManager.getMToLanguage() != -1) {
                                            voiceManager.sendAISparkChainTranslation();
                                            return;
                                        }
                                        ProductManager productManager = ProductManager.f20544oIX0oI;
                                        if (productManager.oO0OX0()) {
                                            voiceManager.sendAISparkChainIdentify();
                                        } else if (productManager.xIx0XO()) {
                                            voiceManager.recognition();
                                        } else {
                                            new IoOoo(16000, 16, 2).oIX0oI(voiceManager.getMPcmFile().getPath(), voiceManager.getMWavFile().getPath());
                                            voiceManager.oldOpenAiChatCompletion();
                                        }
                                    }
                                }
                            });
                        }
                        endTransfer();
                        return;
                    }
                    RecordingManager.Companion.getInstance().stopRecording();
                    endTransfer();
                    return;
                }
            } else {
                if ((ProductManager.f20544oIX0oI.oO0OX0() || mAIMode == 2) && recordPacket.getMMode() < 3) {
                    OpusManager opusManager2 = mOpusManager;
                    if (opusManager2 != null) {
                        opusManager2.writeAudioStream(recordPacket.getMPacket());
                    }
                    OpusManager opusManager3 = mOpusManager;
                    if (opusManager3 != null) {
                        opusManager3.startDecodeStream(new OpusManager.OnDecodeStreamCallback() { // from class: com.sma.smartv3.biz.voice.VoiceManager$oldReceiveRecordPacketSC$1
                            @Override // com.sma.smartv3.biz.voice.OpusManager.OnStateCallback
                            public void onComplete(@OXOo.OOXIXo String p0) {
                                IIX0o.x0xO0oo(p0, "p0");
                            }

                            @Override // com.sma.smartv3.biz.voice.OpusManager.OnDecodeStreamCallback
                            public void onDecodeStream(@OXOo.OOXIXo byte[] p0) {
                                IIX0o.x0xO0oo(p0, "p0");
                                RecordingManager.realTimeASRing$default(RecordingManager.Companion.getInstance(), p0, 0, p0.length, 2, null);
                                FileIOUtils.writeFileFromBytesByStream(VoiceManager.INSTANCE.getMPcmFile(), p0, true);
                            }

                            @Override // com.sma.smartv3.biz.voice.OpusManager.OnStateCallback
                            public void onError(int i, @OXOo.OOXIXo String p1) {
                                IIX0o.x0xO0oo(p1, "p1");
                            }

                            @Override // com.sma.smartv3.biz.voice.OpusManager.OnStateCallback
                            public void onStart() {
                            }
                        });
                        return;
                    }
                    return;
                }
                goOnTransfer(recordPacket);
                return;
            }
        }
        if ((ProductManager.f20544oIX0oI.oO0OX0() || mAIMode == 2) && recordPacket.getMStatus() == 0 && recordPacket.getMMode() < 3) {
            RecordingManager.Companion.getInstance().startRealTimeASR();
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager BleRecordPacket oldReceiveRecordPacketSC START");
        startTransfer(recordPacket.getMStatus());
    }

    @XO0.XO(tag = x0xO0oo.f24632oOo)
    public final void onStopVoice(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager onStopVoice");
        stop();
    }

    @XO0.XO(tag = x0xO0oo.f24636oXIO0o0XI)
    public final void onVoiceQuery(@OXOo.OOXIXo String text) {
        IIX0o.x0xO0oo(text, "text");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager onVoiceQuery -> app: " + text);
        stop();
        sendMsg(text);
        voiceQuery(text);
    }

    @kotlin.OOXIXo(message = "这种需要aikey直连openai的方式后面要废弃")
    public final void openAiChatCompletion(@OXOo.OOXIXo final String query) {
        IIX0o.x0xO0oo(query, "query");
        ThreadUtils.SimpleTask<Void> simpleTask = new ThreadUtils.SimpleTask<Void>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$openAiChatCompletion$1
            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public void onSuccess(@OXOo.oOoXoXO Void r1) {
            }

            /* JADX WARN: Code restructure failed: missing block: B:103:0x01cc, code lost:
            
                r3 = kotlin.collections.CollectionsKt__CollectionsKt.ooXIXxIX();
             */
            /* JADX WARN: Code restructure failed: missing block: B:12:0x0339, code lost:
            
                r2 = r4.string();
             */
            /* JADX WARN: Code restructure failed: missing block: B:91:0x0143, code lost:
            
                r0 = com.sma.smartv3.biz.voice.VoiceManager.INSTANCE;
                r19 = java.lang.System.currentTimeMillis();
                r5 = r4.toString();
                kotlin.jvm.internal.IIX0o.oO(r5, "toString(...)");
                r0.senAudioTextToDevice(new com.szabh.smable3.entity.BleVoice(1, r19, r5, 0, 8, null));
                r25 = com.sma.smartv3.biz.voice.DcsTtsPlayer.INSTANCE;
                r0 = r4.toString();
                kotlin.jvm.internal.IIX0o.oO(r0, "toString(...)");
                com.sma.smartv3.biz.voice.DcsTtsPlayer.play$default(r25, r0, false, false, null, null, 30, null);
             */
            /* JADX WARN: Code restructure failed: missing block: B:93:0x0184, code lost:
            
                r0 = com.google.gson.JsonParser.parseString(com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().getString(com.sma.smartv3.biz.voice.VoiceMessage.class.getName() + oOXoIIIo.XO.f32008oIX0oI)).getAsJsonArray();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(r0);
                r3 = new java.util.ArrayList(kotlin.collections.OxxIIOOXO.xo0x(r0, 10));
                r0 = r0.iterator();
             */
            /* JADX WARN: Code restructure failed: missing block: B:95:0x01b7, code lost:
            
                if (r0.hasNext() == false) goto L116;
             */
            /* JADX WARN: Code restructure failed: missing block: B:96:0x01b9, code lost:
            
                r3.add(new com.google.gson.Gson().fromJson(r0.next(), com.sma.smartv3.biz.voice.VoiceMessage.class));
             */
            /* JADX WARN: Removed duplicated region for block: B:112:0x039e  */
            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            @OXOo.oOoXoXO
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public java.lang.Void doInBackground() {
                /*
                    Method dump skipped, instructions count: 980
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.biz.voice.VoiceManager$openAiChatCompletion$1.doInBackground():java.lang.Void");
            }
        };
        mOpenAiTask = simpleTask;
        ThreadUtils.executeByIo(simpleTask);
    }

    public final void openAiCheck(@OXOo.OOXIXo String aikey, @OXOo.oOoXoXO final xxxI.II0xO0<String> iI0xO0, @OXOo.oOoXoXO Activity activity, @OXOo.oOoXoXO View view) {
        IIX0o.x0xO0oo(aikey, "aikey");
        final I0X0x0oIo i0X0x0oIo = null;
        if (view != null && activity != null) {
            i0X0x0oIo = new I0X0x0oIo(activity);
            i0X0x0oIo.OxxIIOOXO(view);
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager openAiCheck");
        ANRequest.PostRequestBuilder addHeaders = AndroidNetworking.post(AIManager.f19835ooOOo0oXI).setContentType(an.d).addHeaders("Authorization", "Bearer " + aikey);
        byte[] bytes = AIManager.Oo(AIManager.f19833oIX0oI, "hello", false, 0, 4, null).getBytes(kotlin.text.oxoX.f29581II0xO0);
        IIX0o.oO(bytes, "getBytes(...)");
        addHeaders.addByteBody(bytes).setPriority(Priority.LOW).setTag((Object) "openAiChatCompletion").build().getAsJSONObject(new JSONObjectRequestListener() { // from class: com.sma.smartv3.biz.voice.VoiceManager$openAiCheck$1
            @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
            public void onError(@OXOo.OOXIXo ANError anError) {
                AIError aIError;
                IIX0o.x0xO0oo(anError, "anError");
                I0X0x0oIo i0X0x0oIo2 = I0X0x0oIo.this;
                if (i0X0x0oIo2 != null) {
                    i0X0x0oIo2.dismiss();
                }
                AIBase aIBase = (AIBase) anError.getErrorAsObject(AIBase.class);
                if (aIBase == null || (aIError = aIBase.getError()) == null) {
                    aIError = new AIError(String.valueOf(anError.getMessage()), null, null, null, 14, null);
                }
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("onError -> " + anError.getErrorBody() + ", " + aIError);
                AIManager.f19833oIX0oI.XIxXXX0x0(aIError);
                xxxI.II0xO0<String> iI0xO02 = iI0xO0;
                if (iI0xO02 != null) {
                    iI0xO02.handleError(aIError.getMessage());
                }
            }

            @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
            public void onResponse(@OXOo.OOXIXo JSONObject result) {
                IIX0o.x0xO0oo(result, "result");
                I0X0x0oIo i0X0x0oIo2 = I0X0x0oIo.this;
                if (i0X0x0oIo2 != null) {
                    i0X0x0oIo2.dismiss();
                }
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("onResponse -> " + result);
                xxxI.II0xO0<String> iI0xO02 = iI0xO0;
                if (iI0xO02 != null) {
                    iI0xO02.handleResponse(result.toString());
                }
            }
        });
    }

    public final void openAiTranscriptionsAudio(@OXOo.OOXIXo File file, @OXOo.oOoXoXO final xxxI.II0xO0<String> iI0xO0) {
        IIX0o.x0xO0oo(file, "file");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager openAiTranscriptionsAudio -> " + file);
        AndroidNetworking.upload("https://api.openai.com/v1/audio/transcriptions").addHeaders("Authorization", "Bearer " + ProductManager.f20544oIX0oI.I0Io()).addMultipartParameter("model", "whisper-1").addMultipartFile("file", file).setTag((Object) "openAiTranscriptionsAudio").setPriority(Priority.HIGH).build().setUploadProgressListener(new UploadProgressListener() { // from class: com.sma.smartv3.biz.voice.xoIox
            @Override // com.androidnetworking.interfaces.UploadProgressListener
            public final void onProgress(long j, long j2) {
                VoiceManager.openAiTranscriptionsAudio$lambda$9(j, j2);
            }
        }).getAsJSONObject(new JSONObjectRequestListener() { // from class: com.sma.smartv3.biz.voice.VoiceManager$openAiTranscriptionsAudio$2
            @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
            public void onError(@OXOo.OOXIXo ANError anError) {
                AIError aIError;
                IIX0o.x0xO0oo(anError, "anError");
                AIBase aIBase = (AIBase) anError.getErrorAsObject(AIBase.class);
                if (aIBase == null || (aIError = aIBase.getError()) == null) {
                    aIError = new AIError(String.valueOf(anError.getMessage()), null, null, null, 14, null);
                }
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("onError -> " + anError.getErrorBody() + ", " + aIError);
                AIManager.f19833oIX0oI.XIxXXX0x0(aIError);
                xxxI.II0xO0<String> iI0xO02 = iI0xO0;
                if (iI0xO02 != null) {
                    iI0xO02.handleError(aIError.getMessage());
                }
            }

            @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
            public void onResponse(@OXOo.oOoXoXO JSONObject jSONObject) {
                String string;
                xxxI.II0xO0<String> iI0xO02;
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager openAiTranscriptionsAudio onResponse -> " + jSONObject);
                if (jSONObject != null && (string = jSONObject.getString("text")) != null && (iI0xO02 = iI0xO0) != null) {
                    iI0xO02.handleResponse(string);
                }
            }
        });
    }

    public final void postEvent(@OXOo.OOXIXo String tag, @OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(tag, "tag");
        IIX0o.x0xO0oo(data, "data");
        XO0.II0xO0.oxoX().OOXIXo(data, tag);
    }

    public final void recognition() {
        postEvent(XoI0Ixx0.f24422XOxxooXI, "手机结束流程录音");
        if (ProductManager.f20544oIX0oI.oO0OX0()) {
            sendAISparkChainIdentify();
        } else {
            ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<Void>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$recognition$1
                @Override // com.blankj.utilcode.util.ThreadUtils.Task
                public void onSuccess(@OXOo.oOoXoXO Void r1) {
                }

                @Override // com.blankj.utilcode.util.ThreadUtils.Task
                @OXOo.oOoXoXO
                public Void doInBackground() {
                    try {
                        new Runner(new FileInputStream(VoiceManager.INSTANCE.getMPcmFile()), 1).run(new SimpleDownloader() { // from class: com.sma.smartv3.biz.voice.VoiceManager$recognition$1$doInBackground$1
                            @Override // com.baidu.ai.speech.realtime.full.download.SimpleDownloader
                            public void onFailure(@OXOo.oOoXoXO String str) {
                                OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager onFailure -> " + str);
                                ToastUtils.showLong(UtilsKt.oI0IIXIo(R.string.speech_recognition_error) + '\n' + str, new Object[0]);
                                VoiceManager.INSTANCE.sendError(UtilsKt.oI0IIXIo(R.string.speech_recognition_error));
                            }

                            @Override // com.baidu.ai.speech.realtime.full.download.SimpleDownloader
                            public void onMessage(@OXOo.OOXIXo Result result) {
                                boolean z;
                                Collection ooXIXxIX2;
                                Application application;
                                IIX0o.x0xO0oo(result, "result");
                                OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager onMessage -> " + result.getOrignalJsonStr());
                                VoiceManager voiceManager = VoiceManager.INSTANCE;
                                voiceManager.setSpeechRecRunning(true);
                                if (!result.isError() && result.isFin()) {
                                    String result2 = result.getResult();
                                    voiceManager.postEvent(XoI0Ixx0.f24422XOxxooXI, "识别手机录音成功 -> " + result2);
                                    if (TextUtils.isEmpty(result2)) {
                                        voiceManager.sendError(UtilsKt.oI0IIXIo(R.string.speech_recognition_error));
                                        return;
                                    }
                                    if (!voiceManager.isSupportAIVoiceWatchface()) {
                                        z = VoiceManager.isAiTaskRunning;
                                        Application application2 = null;
                                        if (z) {
                                            application = VoiceManager.mApp;
                                            if (application == null) {
                                                IIX0o.XOxIOxOx("mApp");
                                            } else {
                                                application2 = application;
                                            }
                                            String string = application2.getString(R.string.task_running_wait_tip);
                                            IIX0o.oO(string, "getString(...)");
                                            voiceManager.sendError(string);
                                            return;
                                        }
                                        voiceManager.setSpeechRecRunning(false);
                                        long currentTimeMillis = System.currentTimeMillis();
                                        IIX0o.ooOOo0oXI(result2);
                                        voiceManager.senAudioTextToDevice(new BleVoice(0, currentTimeMillis, result2, 0, 8, null));
                                        try {
                                            JsonArray asJsonArray = JsonParser.parseString(Xo0.f24349oIX0oI.XO().getString(VoiceMessage.class.getName() + oOXoIIIo.XO.f32008oIX0oI)).getAsJsonArray();
                                            IIX0o.ooOOo0oXI(asJsonArray);
                                            ooXIXxIX2 = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
                                            Iterator<JsonElement> it = asJsonArray.iterator();
                                            while (it.hasNext()) {
                                                ooXIXxIX2.add(new Gson().fromJson(it.next(), VoiceMessage.class));
                                            }
                                        } catch (Exception unused) {
                                            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
                                        }
                                        List o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
                                        VoiceManager voiceManager2 = VoiceManager.INSTANCE;
                                        VoiceManager.postEvent$default(voiceManager2, x0xO0oo.f24608XIXIX, null, 2, null);
                                        o0Xo0XII.add(new VoiceMessage(0, null, 1, result2, null, 0, 51, null));
                                        o0Xo0XII.add(new VoiceMessage(0, null, 2, "", null, 1, 19, null));
                                        Xo0.f24349oIX0oI.XO().put(VoiceMessage.class.getName() + oOXoIIIo.XO.f32008oIX0oI, new Gson().toJson(o0Xo0XII));
                                        VoiceManager.postEvent$default(voiceManager2, x0xO0oo.f24655xOOOX, null, 2, null);
                                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager onMessage -> start query: " + result2);
                                        voiceManager2.voiceQuery(result2);
                                        return;
                                    }
                                    IIX0o.ooOOo0oXI(result2);
                                    voiceManager.sendMsg(result2);
                                    AIWatchFaceManager.xoXoI(AIWatchFaceManager.f19897oIX0oI, result2, null, 0, 6, null);
                                }
                            }
                        });
                    } catch (IOException e) {
                        OI0.oIX0oI.f1507oIX0oI.II0xO0("AIManager VoiceManager IOException e = " + e + TokenParser.SP);
                        ToastUtils.showLong(UtilsKt.oI0IIXIo(R.string.speech_recognition_error) + '\n' + e, new Object[0]);
                        VoiceManager.INSTANCE.sendError(UtilsKt.oI0IIXIo(R.string.speech_recognition_error));
                    }
                    VoiceManager.INSTANCE.pollCheckStop();
                    return null;
                }
            });
        }
    }

    public final void refreshToken(@OXOo.OOXIXo final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> callback) {
        IIX0o.x0xO0oo(callback, "callback");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager refreshToken");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        String url = GetDcsToken.INSTANCE.getURL();
        HashMap<String, String> dcsTokenBody = RequestBodyKt.getDcsTokenBody();
        final xxxI.II0xO0<DcsToken> iI0xO0 = new xxxI.II0xO0<DcsToken>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$refreshToken$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager refreshToken onError -> " + error);
                ProductManager productManager = ProductManager.f20544oIX0oI;
                if (!productManager.oo00()) {
                    VoiceManager.INSTANCE.sendError(error);
                    ToastUtils.showLong(error, new Object[0]);
                } else {
                    VoiceManager.INSTANCE.sendError("请先到App上激活" + productManager.x0OxxIOxX());
                }
                callback.invoke(Boolean.FALSE);
            }

            @Override // xxxI.II0xO0
            public void handleResponse(@OXOo.oOoXoXO DcsToken dcsToken) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager refreshToken handleResponse -> " + dcsToken);
                if (dcsToken != null) {
                    dcsToken.setTimestamp(System.currentTimeMillis());
                    Xo0.f24349oIX0oI.XO().put(DcsToken.class.getName(), new Gson().toJson(dcsToken));
                    callback.invoke(Boolean.TRUE);
                }
            }
        };
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), url);
        netWorkUtils.printParam(convertBaseUrl + url, dcsTokenBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + url;
        final xxxI.II0xO0<Response<DcsToken>> iI0xO02 = new xxxI.II0xO0<Response<DcsToken>>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$refreshToken$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            public void handleResponse(@OXOo.oOoXoXO Response<DcsToken> response) {
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
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) dcsTokenBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, DcsToken.class), new ParsedRequestListener<Response<DcsToken>>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$refreshToken$$inlined$post$default$2
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

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onResponse(@OXOo.OOXIXo Response<DcsToken> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }
        });
    }

    public final void resetPlayStatus() {
        Collection ooXIXxIX2;
        try {
            JsonArray asJsonArray = JsonParser.parseString(Xo0.f24349oIX0oI.XO().getString(VoiceMessage.class.getName() + oOXoIIIo.XO.f32008oIX0oI)).getAsJsonArray();
            IIX0o.ooOOo0oXI(asJsonArray);
            ooXIXxIX2 = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                ooXIXxIX2.add(new Gson().fromJson(it.next(), VoiceMessage.class));
            }
        } catch (Exception unused) {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        List<VoiceMessage> o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
        for (VoiceMessage voiceMessage : o0Xo0XII) {
            if (voiceMessage.getMType() == 3) {
                voiceMessage.setMStatus(0);
            }
        }
        Xo0.f24349oIX0oI.XO().put(VoiceMessage.class.getName() + oOXoIIIo.XO.f32008oIX0oI, new Gson().toJson(o0Xo0XII));
        postEvent$default(INSTANCE, x0xO0oo.f24655xOOOX, null, 2, null);
    }

    public final void senAudioTextToDevice(@OXOo.OOXIXo BleVoice voice) {
        IIX0o.x0xO0oo(voice, "voice");
        if (voice.getMCategory() == 1) {
            postEvent(XoI0Ixx0.f24422XOxxooXI, "APP-->设备 发送答案给设备");
        } else {
            postEvent(XoI0Ixx0.f24422XOxxooXI, "APP-->设备 发送问题给设备");
        }
        BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.AUDIO_TEXT, BleKeyFlag.UPDATE, voice, false, false, 24, null);
    }

    public final void sendAISparkChainIdentify() {
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI("AIManager VoiceManager sendAISparkChainIdentify  pcm -> wav");
        new IoOoo(16000, 16, 2).oIX0oI(mPcmFile.getPath(), mWavFile.getPath());
        oix0oi.oIX0oI("AIManager VoiceManager sendAISparkChainIdentify  pcm -> wav");
        ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<Void>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$sendAISparkChainIdentify$2
            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            @OXOo.oOoXoXO
            public Void doInBackground() {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager sendAISparkChainIdentify  doInBackground");
                AISparkChainManager aISparkChainManager = AISparkChainManager.f19871oIX0oI;
                String path = VoiceManager.INSTANCE.getMPcmFile().getPath();
                IIX0o.oO(path, "getPath(...)");
                aISparkChainManager.XX(path, new xxxI.II0xO0<AITranslation>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$sendAISparkChainIdentify$2$doInBackground$1
                    @Override // xxxI.II0xO0
                    public void handleError(@OXOo.OOXIXo String error) {
                        IIX0o.x0xO0oo(error, "error");
                        VoiceManager.INSTANCE.sendTranslationResult(UtilsKt.oI0IIXIo(R.string.speech_recognition_error), UtilsKt.oI0IIXIo(R.string.failed_in_translation));
                    }

                    @Override // xxxI.II0xO0
                    public void handleResponse(@OXOo.oOoXoXO AITranslation aITranslation) {
                        VoiceManager.INSTANCE.aISparkChainManagerHandleResponse(aITranslation);
                    }
                });
                return null;
            }

            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public void onSuccess(@OXOo.oOoXoXO Void r2) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager sendAISparkChainIdentify  pcm -> wav  onSuccess");
            }
        });
    }

    public final void sendAISparkChainTranslation() {
        if (ProductManager.f20544oIX0oI.oO0OX0() && mAIMode == 2) {
            postEvent(XoI0Ixx0.f24422XOxxooXI, "科大讯飞去语音识别 , 并进行翻译  ---> ");
            ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<Void>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$sendAISparkChainTranslation$1
                @Override // com.blankj.utilcode.util.ThreadUtils.Task
                public void onSuccess(@OXOo.oOoXoXO Void r1) {
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
                @Override // com.blankj.utilcode.util.ThreadUtils.Task
                @OXOo.oOoXoXO
                public Void doInBackground() {
                    final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    Languages languages = Languages.INSTANCE;
                    VoiceManager voiceManager = VoiceManager.INSTANCE;
                    String formatAISparkTargetLang$default = Languages.formatAISparkTargetLang$default(languages, voiceManager.getMLanguage(), null, 2, null);
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    objectRef.element = Languages.formatAISparkTargetLang$default(languages, voiceManager.getMToLanguage(), null, 2, null);
                    if (!IIX0o.Oxx0IOOO(formatAISparkTargetLang$default, "cn") && !IIX0o.Oxx0IOOO(objectRef.element, "cn")) {
                        objectRef.element = "cn";
                        booleanRef.element = true;
                    }
                    OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                    oix0oi.oIX0oI("AIManager VoiceManager sendAISparkChainTranslation  language = " + formatAISparkTargetLang$default + "  toLanguage = " + ((String) objectRef.element) + "  needTransit = " + booleanRef.element);
                    new IoOoo(16000, 16, 2).oIX0oI(voiceManager.getMPcmFile().getPath(), voiceManager.getMWavFile().getPath());
                    oix0oi.oIX0oI("AIManager VoiceManager sendAISparkChainIdentify  pcm -> wav  ");
                    AISparkChainManager aISparkChainManager = AISparkChainManager.f19871oIX0oI;
                    String path = voiceManager.getMPcmFile().getPath();
                    IIX0o.oO(path, "getPath(...)");
                    aISparkChainManager.Io(path, formatAISparkTargetLang$default, (String) objectRef.element, new xxxI.II0xO0<AITranslation>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$sendAISparkChainTranslation$1$doInBackground$2
                        @Override // xxxI.II0xO0
                        public void handleError(@OXOo.OOXIXo String error) {
                            IIX0o.x0xO0oo(error, "error");
                            VoiceManager.INSTANCE.sendTranslationResult(UtilsKt.oI0IIXIo(R.string.speech_recognition_error), UtilsKt.oI0IIXIo(R.string.failed_in_translation));
                        }

                        @Override // xxxI.II0xO0
                        public void handleResponse(@OXOo.oOoXoXO final AITranslation aITranslation) {
                            if (aITranslation != null) {
                                if (Ref.BooleanRef.this.element) {
                                    AISparkChainManager aISparkChainManager2 = AISparkChainManager.f19871oIX0oI;
                                    String dst = aITranslation.getDst();
                                    String formatAISparkTargetLang$default2 = Languages.formatAISparkTargetLang$default(Languages.INSTANCE, VoiceManager.INSTANCE.getMToLanguage(), null, 2, null);
                                    final Ref.ObjectRef<String> objectRef2 = objectRef;
                                    AISparkChainManager.IIxOXoOo0(aISparkChainManager2, dst, null, formatAISparkTargetLang$default2, new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$sendAISparkChainTranslation$1$doInBackground$2$handleResponse$1
                                        @Override // xxxI.II0xO0
                                        public void handleError(@OXOo.OOXIXo String error) {
                                            IIX0o.x0xO0oo(error, "error");
                                            VoiceManager.INSTANCE.sendTranslationResult(AITranslation.this.getText(), UtilsKt.oI0IIXIo(R.string.failed_in_translation));
                                        }

                                        @Override // xxxI.II0xO0
                                        public void handleResponse(@OXOo.oOoXoXO String str) {
                                            if (str != null && str.length() > 0) {
                                                VoiceManager.INSTANCE.sendTranslationResult(AITranslation.this.getText(), str);
                                                DcsTtsPlayer dcsTtsPlayer = DcsTtsPlayer.INSTANCE;
                                                dcsTtsPlayer.initSegmentation();
                                                DcsTtsPlayer.play$default(dcsTtsPlayer, str, true, false, null, LanguageTranslationKt.getTranslationLanguageTtsName(objectRef2.element), 12, null);
                                                return;
                                            }
                                            VoiceManager.INSTANCE.sendTranslationResult(AITranslation.this.getText(), UtilsKt.oI0IIXIo(R.string.failed_in_translation));
                                        }
                                    }, 2, null);
                                    return;
                                }
                                VoiceManager.INSTANCE.sendTranslationResult(aITranslation.getText(), aITranslation.getDst());
                                DcsTtsPlayer dcsTtsPlayer = DcsTtsPlayer.INSTANCE;
                                dcsTtsPlayer.initSegmentation();
                                DcsTtsPlayer.play$default(dcsTtsPlayer, aITranslation.getDst(), true, false, null, LanguageTranslationKt.getTranslationLanguageTtsName(objectRef.element), 12, null);
                            }
                        }
                    });
                    return null;
                }
            });
            return;
        }
        ToastUtils.showLong("Unauthorized", new Object[0]);
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        sb.append("AIManager VoiceManager  translation It does not support sparkAIService, need to configure the current device , ");
        BleCache bleCache = BleCache.INSTANCE;
        sb.append(bleCache.getMBleName());
        sb.append("  ");
        sb.append(bleCache.getMFirmwareFlag());
        sb.append("  ");
        sb.append(bleCache.getMBleAddress());
        sb.append(TokenParser.SP);
        oix0oi.II0xO0(sb.toString());
        sendTranslationResult("不支持翻译", "Unauthorized");
    }

    public final void sendTranslationResult(@OXOo.OOXIXo String inputText, @OXOo.OOXIXo String outputText) {
        IIX0o.x0xO0oo(inputText, "inputText");
        IIX0o.x0xO0oo(outputText, "outputText");
        sendTranslationResultInput(inputText);
        sendTranslationResultOutput(outputText);
    }

    public final void sendTranslationResultInput(@OXOo.OOXIXo String inputText) {
        IIX0o.x0xO0oo(inputText, "inputText");
        senAudioTextToDevice(new BleVoice(0, System.currentTimeMillis(), StringsKt__StringsKt.oIoIXxIO(inputText).toString(), 0, 8, null));
    }

    public final void sendTranslationResultOutput(@OXOo.OOXIXo String outputText) {
        IIX0o.x0xO0oo(outputText, "outputText");
        senAudioTextToDevice(new BleVoice(1, System.currentTimeMillis(), StringsKt__StringsKt.oIoIXxIO(outputText).toString(), 0, 8, null));
    }

    public final void setActivityData(boolean z) {
        isActivityData = z;
    }

    public final void setLanguageType(@OXOo.OOXIXo String language, @OXOo.OOXIXo String mTtsName) {
        Object obj;
        boolean z;
        IIX0o.x0xO0oo(language, "language");
        IIX0o.x0xO0oo(mTtsName, "mTtsName");
        if (IIX0o.Oxx0IOOO(language, "") && IIX0o.Oxx0IOOO(mTtsName, "")) {
            Object obj2 = null;
            if (!isSupportEarPhoneVoiceTranslation() && !isSupportAIVoiceTranslation()) {
                Application application = mApp;
                if (application == null) {
                    IIX0o.XOxIOxOx("mApp");
                    application = null;
                }
                String language2 = application.getResources().getConfiguration().locale.getLanguage();
                if (IIX0o.Oxx0IOOO(language2, Languages.DEFAULT_LANGUAGE_ZH)) {
                    microsoftLanguage = bc.Code;
                    microsoftTtsName = "zh-CN-XiaoxiaoNeural";
                    return;
                }
                Iterator<T> it = LanguageTranslationKt.getTranslationLanguageList().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (IIX0o.Oxx0IOOO(((LanguageTranslationData) next).getRtasrLanguage(), language2)) {
                        obj2 = next;
                        break;
                    }
                }
                LanguageTranslationData languageTranslationData = (LanguageTranslationData) obj2;
                if (languageTranslationData != null) {
                    microsoftLanguage = languageTranslationData.getAsrLanguage();
                    microsoftTtsName = languageTranslationData.getTtsViuceName();
                    return;
                } else {
                    microsoftLanguage = "en-US";
                    microsoftTtsName = "en-US-AvaMultilingualNeural";
                    return;
                }
            }
            Languages languages = Languages.INSTANCE;
            String formatMicrosoftTargetLang = languages.formatMicrosoftTargetLang(mLanguage, Languages.DEFAULT_LANGUAGE_ZH);
            String formatMicrosoftTargetLang2 = languages.formatMicrosoftTargetLang(mToLanguage, Languages.DEFAULT_LANGUAGE_ZH);
            Iterator<T> it2 = LanguageTranslationKt.getTranslationLanguageList().iterator();
            while (true) {
                if (it2.hasNext()) {
                    obj = it2.next();
                    if (IIX0o.Oxx0IOOO(((LanguageTranslationData) obj).getRtasrLanguage(), formatMicrosoftTargetLang)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            LanguageTranslationData languageTranslationData2 = (LanguageTranslationData) obj;
            Iterator<T> it3 = LanguageTranslationKt.getTranslationLanguageList().iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object next2 = it3.next();
                if (IIX0o.Oxx0IOOO(((LanguageTranslationData) next2).getRtasrLanguage(), formatMicrosoftTargetLang2)) {
                    obj2 = next2;
                    break;
                }
            }
            LanguageTranslationData languageTranslationData3 = (LanguageTranslationData) obj2;
            if (languageTranslationData2 != null) {
                microsoftLanguage = languageTranslationData2.getAsrLanguage();
            }
            if (languageTranslationData3 != null) {
                microsoftTtsName = languageTranslationData3.getTtsViuceName();
                microsoftTtsLanguage = languageTranslationData3.getAsrLanguage();
            }
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            sb.append("AIManager VoiceManager formatMicrosoftTargetLang language = ");
            sb.append(formatMicrosoftTargetLang);
            sb.append(" , translationLanguage = ");
            if (languageTranslationData2 == null) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            oix0oi.oIX0oI(sb.toString());
            return;
        }
        microsoftLanguage = language;
        microsoftTtsName = mTtsName;
    }

    public final void setMContentResult(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        mContentResult = str;
    }

    public final void setMLanguage(int i) {
        mLanguage = i;
    }

    public final void setMListener(@OXOo.oOoXoXO IXxxXO<? super Integer, ? super Integer, ? super Integer, Boolean> iXxxXO) {
        mListener = iXxxXO;
    }

    public final void setMSavePcmTime(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        mSavePcmTime = str;
    }

    public final void setMToLanguage(int i) {
        mToLanguage = i;
    }

    public final void setMVoiceMode(int i) {
        mVoiceMode = i;
    }

    public final void setMicrosoftCallback() {
        RecordingManager.Companion.getInstance().setRecordingCallback(recordingCallBack);
        MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().O0X(microsoftCallBack, TAG);
    }

    public final void setMicrosoftLanguage(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        microsoftLanguage = str;
    }

    public final void setMicrosoftTime(long j) {
        microsoftTime = j;
    }

    public final void setMicrosoftTtsLanguage(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        microsoftTtsLanguage = str;
    }

    public final void setMicrosoftTtsName(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        microsoftTtsName = str;
    }

    public final void setRecordBluetooth(boolean z) {
        isRecordBluetooth = z;
    }

    public final void setResetCallBack(boolean z) {
        resetCallBack = z;
    }

    public final void setSendResults(boolean z) {
        isSendResults = z;
    }

    public final void setSpeechRecRunning(boolean z) {
        isSpeechRecRunning = z;
    }

    public final void startRecord() {
        RecordingManager.Companion.getInstance().startRecord();
    }

    public final void startTransfer(int i) {
        if (i == 0) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager startTransfer delete  File  start = " + i);
            FileUtils.delete(mOpusFile);
            FileUtils.delete(mPcmFile);
            FileUtils.delete(mWavFile);
            DcsTtsPlayer.INSTANCE.deleteReplayMusic();
            String format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis()));
            IIX0o.oO(format, "format(...)");
            mSavePcmTime = format;
        }
        stop();
        if (i == 0) {
            if (!isSupportEarPhoneVoiceAIChat() && !isSupportEarPhoneVoiceTranslation()) {
                OpusManager opusManager = mOpusManager;
                if (opusManager != null) {
                    opusManager.stopDecodeStream();
                }
            } else {
                VoiceService.f20239Oo.I0Io();
                voiceRecord();
            }
        }
        if (ProductManager.f20544oIX0oI.oO0OX0()) {
            AISparkChainManager.f19871oIX0oI.IoOoo(false);
        }
    }

    public final void stop() {
        ThreadUtils.SimpleTask<Void> simpleTask;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager -> stop");
        isAiTaskRunning = false;
        isSpeechRecRunning = false;
        ThreadUtils.SimpleTask<Void> simpleTask2 = mOpenAiTask;
        if (simpleTask2 != null) {
            ThreadUtils.cancel(simpleTask2);
        }
        if (!IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMFirmwareFlag(), "BLACK_SHARK_S1_PRO") && (simpleTask = mDuserTask) != null) {
            ThreadUtils.cancel(simpleTask);
        }
        DcsTtsPlayer.INSTANCE.stop();
        AIWatchFaceManager.f19897oIX0oI.o00();
        AIManager.f19833oIX0oI.XX();
        resetPlayStatus();
    }

    public final void stopRecording() {
        RecordingManager.Companion.getInstance().stopRecording();
    }

    public final void toMicrosoftIdentify(@OXOo.OOXIXo BleRecordPacket recordPacket) {
        IIX0o.x0xO0oo(recordPacket, "recordPacket");
        int mStatus = recordPacket.getMStatus();
        if (mStatus != 0) {
            if (mStatus != 1) {
                if (mStatus != 2) {
                    if (mStatus == 3) {
                        stop();
                        OpusManager opusManager = mOpusManager;
                        if (opusManager != null) {
                            opusManager.stopDecodeStream();
                        }
                        MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().X0xxXX0();
                        return;
                    }
                    return;
                }
                isSpeechRecRunning = false;
                OpusManager opusManager2 = mOpusManager;
                if (opusManager2 != null) {
                    opusManager2.stopDecodeStream();
                }
                if (!isSupportEarPhoneVoiceAIChat() && !isSupportEarPhoneVoiceTranslation()) {
                    MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().x0();
                } else {
                    MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().x0OxxIOxX();
                }
                endTransfer();
                if (!isActivityData && mContentResult.length() > 0) {
                    isSendResults = true;
                    sendContentResult(mContentResult);
                    return;
                }
                return;
            }
            OpusManager opusManager3 = mOpusManager;
            if (opusManager3 != null) {
                opusManager3.writeAudioStream(recordPacket.getMPacket());
                return;
            }
            return;
        }
        if (isSpeechRecRunning) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager toMicrosoftIdentify isSpeechRecRunning = " + isSpeechRecRunning);
            RecordingManager.Companion companion = RecordingManager.Companion;
            if (companion.getInstance().isRecording() && ProductManager.xOOxIO(ProductManager.f20544oIX0oI, null, 1, null)) {
                companion.getInstance().playTip();
                return;
            }
            return;
        }
        stop();
        DcsTtsPlayer.INSTANCE.deleteReplayMusic();
        OpusManager opusManager4 = mOpusManager;
        if (opusManager4 != null) {
            opusManager4.stopDecodeStream();
        }
        isSpeechRecRunning = true;
        if (!isActivityData) {
            setLanguageType$default(this, null, null, 3, null);
        }
        if (!isSupportEarPhoneVoiceAIChat() && !isSupportEarPhoneVoiceTranslation()) {
            MicrosoftSDKManage.O0(MicrosoftSDKManage.f24259Xx000oIo.oIX0oI(), microsoftLanguage, false, microsoftTtsName, microsoftTtsLanguage, false, null, 32, null);
            OpusManager opusManager5 = mOpusManager;
            if (opusManager5 != null) {
                opusManager5.startDecodeStream(new OpusManager.OnDecodeStreamCallback() { // from class: com.sma.smartv3.biz.voice.VoiceManager$toMicrosoftIdentify$1
                    @Override // com.sma.smartv3.biz.voice.OpusManager.OnStateCallback
                    public void onComplete(@OXOo.OOXIXo String p0) {
                        IIX0o.x0xO0oo(p0, "p0");
                    }

                    @Override // com.sma.smartv3.biz.voice.OpusManager.OnDecodeStreamCallback
                    public void onDecodeStream(@OXOo.OOXIXo byte[] p0) {
                        IIX0o.x0xO0oo(p0, "p0");
                        MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().XX0xXo(p0);
                        FileIOUtils.writeFileFromBytesByStream(VoiceManager.INSTANCE.getMPcmFile(), p0, true);
                    }

                    @Override // com.sma.smartv3.biz.voice.OpusManager.OnStateCallback
                    public void onError(int i, @OXOo.OOXIXo String p1) {
                        IIX0o.x0xO0oo(p1, "p1");
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager startDecodeStream -> onError: " + i + ", " + p1);
                    }

                    @Override // com.sma.smartv3.biz.voice.OpusManager.OnStateCallback
                    public void onStart() {
                    }
                });
                return;
            }
            return;
        }
        MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().Ox0O(microsoftLanguage, true, microsoftTtsName, microsoftTtsLanguage, !isActivityData, "AIManager VoiceManager (phoneRecord = true");
    }

    public final void voiceQuery(@OXOo.OOXIXo final String query) {
        IIX0o.x0xO0oo(query, "query");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager VoiceManager voiceQuery -> " + query);
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.oO0OX0()) {
            AISparkChainManager.f19871oIX0oI.XOxIOxOx(query, mAISparkChainManagerCallback, productManager.xX(), true);
            return;
        }
        if (productManager.XOx()) {
            AIChat(query);
            return;
        }
        if (productManager.xIx0XO()) {
            if (isExpired()) {
                refreshToken(new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.biz.voice.VoiceManager$voiceQuery$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            VoiceManager.INSTANCE.duserStreamChat(query);
                        }
                    }
                });
                return;
            } else {
                duserStreamChat(query);
                return;
            }
        }
        if (TextUtils.isEmpty(productManager.I0Io())) {
            ToastUtils.showLong(R.string.no_ai_key);
        } else {
            openAiChatCompletion(query);
        }
    }

    public final void voiceRecord() {
        AISparkChainManager.f19871oIX0oI.ox();
        DcsTtsPlayer.INSTANCE.stop();
        RecordingManager.recordPermission$default(RecordingManager.Companion.getInstance(), recordingCallBack, false, resetCallBack, TAG, 2, null);
    }
}
