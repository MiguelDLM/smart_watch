package com.sma.smartv3.ui.device.dial;

import Xx000oIo.oxoX;
import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.core.widget.NestedScrollView;
import com.angcyo.dsladapter.LibExKt;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.realsil.sdk.dfu.image.constants.SubBinId;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.ResourcesIdInfo;
import com.sma.smartv3.pop.dial.DialPointerPopup;
import com.sma.smartv3.ui.device.watchface.oIX0oI;
import com.sma.smartv3.util.permission.PermissionHelper;
import com.sma.smartv3.view.ImageViewRound;
import com.sma.smartv3.view.bubbleview.ArrowDirection;
import com.sma.smartv3.view.bubbleview.BubbleLayout;
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
import com.szabh.smable3.watchface.Element;
import com.szabh.smable3.watchface.WatchFaceBuilder;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.Util;

@kotlin.jvm.internal.XX({"SMAP\nBaseDialCustomizeActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseDialCustomizeActivity.kt\ncom/sma/smartv3/ui/device/dial/BaseDialCustomizeActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 View.kt\nandroidx/core/view/ViewKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1932:1\n50#2,3:1933\n53#2:1939\n55#2,2:1941\n1549#3:1936\n1620#3,2:1937\n1622#3:1940\n254#4:1943\n254#4:1944\n254#4:1945\n254#4:1946\n254#4:1947\n254#4:1977\n254#4:1978\n254#4:1979\n254#4:1980\n254#4:1983\n254#4:1984\n254#4:1985\n254#4:1986\n254#4:1989\n254#4:1990\n254#4:1991\n254#4:1992\n37#5,2:1948\n37#5,2:1951\n37#5,2:1953\n37#5,2:1955\n37#5,2:1957\n37#5,2:1959\n37#5,2:1961\n37#5,2:1963\n37#5,2:1965\n37#5,2:1967\n37#5,2:1969\n37#5,2:1971\n37#5,2:1973\n37#5,2:1975\n37#5,2:1981\n37#5,2:1987\n1#6:1950\n*S KotlinDebug\n*F\n+ 1 BaseDialCustomizeActivity.kt\ncom/sma/smartv3/ui/device/dial/BaseDialCustomizeActivity\n*L\n505#1:1933,3\n505#1:1939\n505#1:1941,2\n505#1:1936\n505#1:1937,2\n505#1:1940\n631#1:1943\n728#1:1944\n731#1:1945\n771#1:1946\n774#1:1947\n1231#1:1977\n1245#1:1978\n1259#1:1979\n1273#1:1980\n1295#1:1983\n1310#1:1984\n1325#1:1985\n1340#1:1986\n1617#1:1989\n1626#1:1990\n1630#1:1991\n1858#1:1992\n786#1:1948,2\n834#1:1951,2\n878#1:1953,2\n914#1:1955,2\n942#1:1957,2\n950#1:1959,2\n987#1:1961,2\n1024#1:1963,2\n1056#1:1965,2\n1120#1:1967,2\n1129#1:1969,2\n1169#1:1971,2\n1209#1:1973,2\n1229#1:1975,2\n1293#1:1981,2\n1383#1:1987,2\n*E\n"})
/* loaded from: classes12.dex */
public abstract class BaseDialCustomizeActivity extends BaseActivity {

    @OXOo.OOXIXo
    private final String CALORIES_DIR;

    @OXOo.OOXIXo
    private final String CONTROL_DIR;

    @OXOo.OOXIXo
    private final Object DIAL_CUSTOMIZE_DIR;

    @OXOo.OOXIXo
    private final String DIGITAL_AM_DIR;

    @OXOo.OOXIXo
    private final String DIGITAL_DATE_DIR;

    @OXOo.OOXIXo
    private final String DIGITAL_DIR;

    @OXOo.OOXIXo
    private final String DIGITAL_HOUR_MINUTE_DIR;

    @OXOo.OOXIXo
    private final String DIGITAL_WEEK_DIR;

    @OXOo.OOXIXo
    private final String DISTANCE_DIR;

    @OXOo.OOXIXo
    private final String HEART_RATE_DIR;

    @OXOo.OOXIXo
    private final String POINTER_DIR;

    @OXOo.OOXIXo
    private final String POINTER_HOUR;

    @OXOo.OOXIXo
    private final String POINTER_MINUTE;

    @OXOo.OOXIXo
    private final String POINTER_SECOND;

    @OXOo.OOXIXo
    private final String STEP_DIR;

    @OXOo.OOXIXo
    private final String TIME_DIR;

    @OXOo.OOXIXo
    private final String VALUE_DIR;
    private float amLeftX;
    private float amTopY;

    @OXOo.oOoXoXO
    private String bgFile;
    private int borderSize;
    private float caloriesValueCenterX;
    private float caloriesValueCenterY;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO colors$delegate;
    private int controlValueInterval;

    @OXOo.oOoXoXO
    private DialPickerPopup dialPickerPopup;
    private float digitalDateDayLeftX;
    private float digitalDateDayTopY;
    private float digitalDateMonthLeftX;
    private float digitalDateMonthTopY;
    private float digitalDateSymbolLeftX;
    private float digitalDateSymbolTopY;
    private float digitalTimeHourLeftX;
    private float digitalTimeHourTopY;
    private float digitalTimeMinuteLeftX;
    private float digitalTimeMinuteRightX;
    private float digitalTimeMinuteTopY;
    private float digitalTimeSymbolLeftX;
    private float digitalTimeSymbolTopY;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO digitalTimes$delegate;
    private int digitalValueColor;
    private float digitalWeekLeftX;
    private float digitalWeekTopY;
    private float distanceValueCenterX;
    private float distanceValueCenterY;
    private float heartRateValueCenterX;
    private float heartRateValueCenterY;
    private int ignoreBlack;

    @OXOo.OOXIXo
    private final String is2DAcceleration;
    private boolean isSupportConvertPng;

    @OXOo.oOoXoXO
    private String mAiBgFile;

    @OXOo.oOoXoXO
    private DialBgFilePickerPopup mBgFilePickerPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.dial.II0xO0 mBgPopup;

    @OXOo.OOXIXo
    private final I0Io mBleHandleCallback;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.dial.I0Io mControlPopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mCrop$delegate;

    @OXOo.oOoXoXO
    private byte[] mCurSendBytes;
    private int mCurSyncDevicePosition;
    private int mCurSyncDialId;

    @OXOo.OOXIXo
    private final List<Integer> mDialIds;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.dial.oxoX mDigitalPopup;

    @OXOo.oOoXoXO
    private PopupWindow mDragPopup;

    @OXOo.oOoXoXO
    private DialPointerPopup mPointerPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xOOOX mProgressPop;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xx0X0 mSelectAvatarPopup;

    @OXOo.OOXIXo
    private final String paramName;
    private int pointerSelectNumber;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO pointers$delegate;
    private float roundCornerRadius;
    private int scaleSelectNumber;

    @OXOo.OOXIXo
    private final List<ResourcesIdInfo> scales;
    private int screenHeight;
    private int screenPreviewHeight;
    private int screenPreviewWidth;
    private int screenReservedBoundary;
    private int screenWidth;
    private float stepValueCenterX;
    private float stepValueCenterY;
    private int valueColor;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return BaseDialCustomizeActivity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleCenter$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) BaseDialCustomizeActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO saveDial$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity$saveDial$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) BaseDialCustomizeActivity.this.findViewById(R.id.saveDial);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO nestedScrollView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<NestedScrollView>() { // from class: com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity$nestedScrollView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final NestedScrollView invoke() {
            return (NestedScrollView) BaseDialCustomizeActivity.this.findViewById(R.id.nestedScrollView);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO customizeDialBg$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageViewRound>() { // from class: com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity$customizeDialBg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageViewRound invoke() {
            return (ImageViewRound) BaseDialCustomizeActivity.this.findViewById(R.id.customizeDialBg);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO controlViewStep$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DialElementView>() { // from class: com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity$controlViewStep$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DialElementView invoke() {
            return (DialElementView) BaseDialCustomizeActivity.this.findViewById(R.id.controlViewStep);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO controlViewHr$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DialElementView>() { // from class: com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity$controlViewHr$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DialElementView invoke() {
            return (DialElementView) BaseDialCustomizeActivity.this.findViewById(R.id.controlViewHr);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO controlViewCa$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DialElementView>() { // from class: com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity$controlViewCa$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DialElementView invoke() {
            return (DialElementView) BaseDialCustomizeActivity.this.findViewById(R.id.controlViewCa);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO controlViewDis$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DialElementView>() { // from class: com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity$controlViewDis$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DialElementView invoke() {
            return (DialElementView) BaseDialCustomizeActivity.this.findViewById(R.id.controlViewDis);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO timeDigitalView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DialElementView>() { // from class: com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity$timeDigitalView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DialElementView invoke() {
            return (DialElementView) BaseDialCustomizeActivity.this.findViewById(R.id.timeDigitalView);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO timePointView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity$timePointView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) BaseDialCustomizeActivity.this.findViewById(R.id.timePointView);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO timeScaleView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity$timeScaleView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) BaseDialCustomizeActivity.this.findViewById(R.id.timeScaleView);
        }
    });
    private boolean isRound = true;
    private int controlValueRange = 9;

    @OXOo.OOXIXo
    private String fileFormat = "png";
    private int imageFormat = 1;
    private int X_CENTER = 4;
    private int Y_CENTER = 32;

    @kotlin.jvm.internal.XX({"SMAP\nBaseDialCustomizeActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseDialCustomizeActivity.kt\ncom/sma/smartv3/ui/device/dial/BaseDialCustomizeActivity$mBleHandleCallback$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1932:1\n1855#2,2:1933\n*S KotlinDebug\n*F\n+ 1 BaseDialCustomizeActivity.kt\ncom/sma/smartv3/ui/device/dial/BaseDialCustomizeActivity$mBleHandleCallback$1\n*L\n327#1:1933,2\n*E\n"})
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
            kotlin.jvm.internal.IIX0o.x0xO0oo(bleKey, "bleKey");
            kotlin.jvm.internal.IIX0o.x0xO0oo(bleKeyFlag, "bleKeyFlag");
            if (bleKey == BleKey.WATCH_FACE) {
                BaseDialCustomizeActivity.syncFailed$default(BaseDialCustomizeActivity.this, 0, 1, null);
            }
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
        public void onReadWatchFaceId(@OXOo.OOXIXo BleWatchFaceId watchFaceId) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(watchFaceId, "watchFaceId");
            BaseDialCustomizeActivity.this.mDialIds.clear();
            List<Integer> mIdList = watchFaceId.getMIdList();
            BaseDialCustomizeActivity baseDialCustomizeActivity = BaseDialCustomizeActivity.this;
            Iterator<T> it = mIdList.iterator();
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                if (intValue <= 0) {
                    baseDialCustomizeActivity.mDialIds.add(0);
                } else {
                    baseDialCustomizeActivity.mDialIds.add(Integer.valueOf(intValue));
                }
            }
            LogUtils.d("mDialIds -> " + BaseDialCustomizeActivity.this.mDialIds);
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
            BaseDialCustomizeActivity.syncFailed$default(BaseDialCustomizeActivity.this, 0, 1, null);
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
                com.sma.smartv3.pop.xOOOX xooox = BaseDialCustomizeActivity.this.mProgressPop;
                if (xooox != null) {
                    xooox.XIxXXX0x0((int) ((i3 / i2) * 100));
                }
                if (i2 == i3) {
                    com.sma.smartv3.pop.xOOOX xooox2 = BaseDialCustomizeActivity.this.mProgressPop;
                    if (xooox2 != null) {
                        xooox2.dismiss();
                    }
                    BaseDialCustomizeActivity.this.mProgressPop = null;
                    ToastUtils.showLong(R.string.dial_sync_done);
                    BaseDialCustomizeActivity.this.mDialIds.set(BaseDialCustomizeActivity.this.mCurSyncDevicePosition, Integer.valueOf(BaseDialCustomizeActivity.this.mCurSyncDialId));
                    com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put("syncId", 0);
                    BaseDialCustomizeActivity.this.saveRecord();
                    return;
                }
                return;
            }
            BaseDialCustomizeActivity.this.syncFailed(i);
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
            BaseDialCustomizeActivity.this.syncDial();
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
    public static final class II0xO0 implements com.sma.smartv3.util.OOXIXo<Integer> {
        public II0xO0() {
        }

        public void II0xO0(int i) {
            BaseDialCustomizeActivity.this.getControlViewStep().setTextColor(BaseDialCustomizeActivity.this.getColors().get(i).getSecondaryId());
            BaseDialCustomizeActivity.this.getControlViewHr().setTextColor(BaseDialCustomizeActivity.this.getColors().get(i).getSecondaryId());
            BaseDialCustomizeActivity.this.getControlViewCa().setTextColor(BaseDialCustomizeActivity.this.getColors().get(i).getSecondaryId());
            BaseDialCustomizeActivity.this.getControlViewDis().setTextColor(BaseDialCustomizeActivity.this.getColors().get(i).getSecondaryId());
            BaseDialCustomizeActivity.this.setValueColor(i);
        }

        @Override // com.sma.smartv3.util.OOXIXo
        public /* bridge */ /* synthetic */ void oIX0oI(Integer num) {
            II0xO0(num.intValue());
        }
    }

    /* loaded from: classes12.dex */
    public static final class X0o0xo implements com.sma.smartv3.util.oOoXoXO<Integer> {
        public X0o0xo() {
        }

        public void I0Io(int i) {
            BaseDialCustomizeActivity.this.getTimeDigitalView().setVisibility(8);
            BaseDialCustomizeActivity.this.getTimePointView().setVisibility(0);
            BaseDialCustomizeActivity.this.getTimePointView().setImageResource(BaseDialCustomizeActivity.this.getPointers().get(i).getResId());
            BaseDialCustomizeActivity.this.setPointerSelectNumber(i);
        }

        @Override // com.sma.smartv3.util.oOoXoXO
        public /* bridge */ /* synthetic */ void II0xO0(Integer num) {
            oxoX(num.intValue());
        }

        @Override // com.sma.smartv3.util.oOoXoXO
        public /* bridge */ /* synthetic */ void oIX0oI(Integer num) {
            I0Io(num.intValue());
        }

        public void oxoX(int i) {
            BaseDialCustomizeActivity.this.getTimeDigitalView().setVisibility(8);
            BaseDialCustomizeActivity.this.getTimeScaleView().setVisibility(0);
            BaseDialCustomizeActivity.this.getTimeScaleView().setImageResource(BaseDialCustomizeActivity.this.getScales().get(i).getResId());
            BaseDialCustomizeActivity.this.setScaleSelectNumber(i);
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements OxI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ List<String> f22154II0xO0;

        public oIX0oI(List<String> list) {
            this.f22154II0xO0 = list;
        }

        @Override // com.sma.smartv3.ui.device.dial.OxI
        public void oIX0oI(int i) {
            BaseDialCustomizeActivity baseDialCustomizeActivity = BaseDialCustomizeActivity.this;
            Uri fromFile = Uri.fromFile(new File(this.f22154II0xO0.get(i)));
            kotlin.jvm.internal.IIX0o.oO(fromFile, "fromFile(...)");
            baseDialCustomizeActivity.toCropPic(fromFile);
        }
    }

    /* loaded from: classes12.dex */
    public static final class oxoX implements com.sma.smartv3.util.OOXIXo<Integer> {
        public oxoX() {
        }

        public void II0xO0(int i) {
            BaseDialCustomizeActivity.this.getTimeDigitalView().setVisibility(0);
            BaseDialCustomizeActivity.this.getTimePointView().setVisibility(8);
            BaseDialCustomizeActivity.this.getTimeScaleView().setVisibility(8);
            BaseDialCustomizeActivity.this.getTimeDigitalView().setImageRes(BaseDialCustomizeActivity.this.getDigitalTimes().get(i).getResId());
            com.sma.smartv3.pop.dial.oxoX oxox = BaseDialCustomizeActivity.this.mDigitalPopup;
            if (oxox != null) {
                oxox.ooXIXxIX(BaseDialCustomizeActivity.this.getColors().get(i).getSecondaryId());
            }
            BaseDialCustomizeActivity.this.setDigitalValueColor(i);
        }

        @Override // com.sma.smartv3.util.OOXIXo
        public /* bridge */ /* synthetic */ void oIX0oI(Integer num) {
            II0xO0(num.intValue());
        }
    }

    public BaseDialCustomizeActivity() {
        String str;
        Object customizeDir = customizeDir();
        this.DIAL_CUSTOMIZE_DIR = customizeDir;
        String str2 = customizeDir + "/control";
        this.CONTROL_DIR = str2;
        this.STEP_DIR = str2 + "/step";
        this.CALORIES_DIR = str2 + "/calories";
        this.DISTANCE_DIR = str2 + "/distance";
        this.HEART_RATE_DIR = str2 + "/heart_rate";
        this.VALUE_DIR = customizeDir + "/value";
        String str3 = customizeDir + "/time";
        this.TIME_DIR = str3;
        this.DIGITAL_DIR = str3 + "/digital";
        this.POINTER_DIR = str3 + "/pointer";
        this.DIGITAL_AM_DIR = "am_pm";
        this.DIGITAL_DATE_DIR = o0oIxXOx.XIxXXX0x0.f31178xoIox;
        this.DIGITAL_HOUR_MINUTE_DIR = "hour_minute";
        this.DIGITAL_WEEK_DIR = "week";
        this.POINTER_HOUR = "pointer/hour";
        this.POINTER_MINUTE = "pointer/minute";
        this.POINTER_SECOND = "pointer/second";
        if (ProductManager.f20544oIX0oI.XxIo()) {
            str = "/2d/";
        } else {
            str = "/default/";
        }
        this.is2DAcceleration = str;
        this.paramName = BleCache.INSTANCE.getMPrototype() + IOUtils.DIR_SEPARATOR_UNIX;
        this.colors$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<List<? extends ResourcesIdInfo>>() { // from class: com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity$colors$2
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final List<? extends ResourcesIdInfo> invoke() {
                return Util.immutableListOf(new ResourcesIdInfo(R.drawable.shape_circle_0, BaseDialCustomizeActivity.this.getResources().getColor(R.color.dial_customize_control_0), true), new ResourcesIdInfo(R.drawable.shape_circle_1, BaseDialCustomizeActivity.this.getResources().getColor(R.color.dial_customize_control_1), false, 4, null), new ResourcesIdInfo(R.drawable.shape_circle_2, BaseDialCustomizeActivity.this.getResources().getColor(R.color.dial_customize_control_2), false, 4, null), new ResourcesIdInfo(R.drawable.shape_circle_3, BaseDialCustomizeActivity.this.getResources().getColor(R.color.dial_customize_control_3), false, 4, null), new ResourcesIdInfo(R.drawable.shape_circle_4, BaseDialCustomizeActivity.this.getResources().getColor(R.color.dial_customize_control_4), false, 4, null), new ResourcesIdInfo(R.drawable.shape_circle_5, BaseDialCustomizeActivity.this.getResources().getColor(R.color.dial_customize_control_5), false, 4, null), new ResourcesIdInfo(R.drawable.shape_circle_6, BaseDialCustomizeActivity.this.getResources().getColor(R.color.dial_customize_control_6), false, 4, null));
            }
        });
        this.digitalTimes$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<List<? extends ResourcesIdInfo>>() { // from class: com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity$digitalTimes$2
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final List<? extends ResourcesIdInfo> invoke() {
                return Util.immutableListOf(new ResourcesIdInfo(R.drawable.digital_time_0, 0, false, 6, null), new ResourcesIdInfo(R.drawable.digital_time_1, 0, false, 6, null), new ResourcesIdInfo(R.drawable.digital_time_2, 0, false, 6, null), new ResourcesIdInfo(R.drawable.digital_time_3, 0, false, 6, null), new ResourcesIdInfo(R.drawable.digital_time_4, 0, false, 6, null), new ResourcesIdInfo(R.drawable.digital_time_5, 0, false, 6, null), new ResourcesIdInfo(R.drawable.digital_time_6, 0, false, 6, null));
            }
        });
        this.pointers$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<List<? extends ResourcesIdInfo>>() { // from class: com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity$pointers$2
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final List<? extends ResourcesIdInfo> invoke() {
                return Util.immutableListOf(new ResourcesIdInfo(R.drawable.dial_customize_point_2_0, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_point_2_1, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_point_2_2, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_point_2_3, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_point_2_4, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_point_2_5, 0, false, 6, null));
            }
        });
        this.scales = scalesList();
        this.mCrop$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Xx000oIo.oxoX>() { // from class: com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity$mCrop$2

            /* loaded from: classes12.dex */
            public static final class oIX0oI implements oxoX.II0xO0 {

                /* renamed from: I0Io, reason: collision with root package name */
                public final /* synthetic */ BaseDialCustomizeActivity f22151I0Io;

                /* renamed from: II0xO0, reason: collision with root package name */
                @OXOo.OOXIXo
                public final Uri f22152II0xO0;

                /* renamed from: oIX0oI, reason: collision with root package name */
                @OXOo.OOXIXo
                public final Uri f22153oIX0oI;

                public oIX0oI(BaseDialCustomizeActivity baseDialCustomizeActivity) {
                    this.f22151I0Io = baseDialCustomizeActivity;
                    X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
                    this.f22153oIX0oI = oix0oi.oxoX(com.sma.smartv3.initializer.IXxxXO.XIxXXX0x0(oix0oi));
                    Uri fromFile = Uri.fromFile(com.sma.smartv3.initializer.IXxxXO.xoXoI(oix0oi));
                    kotlin.jvm.internal.IIX0o.oO(fromFile, "fromFile(...)");
                    this.f22152II0xO0 = fromFile;
                }

                @Override // Xx000oIo.oxoX.II0xO0
                public void II0xO0(@OXOo.OOXIXo Uri uri) {
                    com.sma.smartv3.pop.xx0X0 xx0x0;
                    Bitmap roundCorner;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(uri, "uri");
                    LogUtils.d("onCropped => " + uri);
                    xx0x0 = this.f22151I0Io.mSelectAvatarPopup;
                    if (xx0x0 != null) {
                        xx0x0.dismiss();
                    }
                    X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
                    if (com.sma.smartv3.initializer.IXxxXO.xoXoI(oix0oi).exists()) {
                        Bitmap bitmap = ImageUtils.getBitmap(com.sma.smartv3.initializer.IXxxXO.xoXoI(oix0oi));
                        if (this.f22151I0Io.isRound()) {
                            roundCorner = ImageUtils.toRound(bitmap);
                        } else {
                            roundCorner = ImageUtils.toRoundCorner(bitmap, this.f22151I0Io.getRoundCornerRadius());
                        }
                        this.f22151I0Io.getCustomizeDialBg().setImageBitmap(roundCorner);
                    }
                }

                @Override // Xx000oIo.oxoX.II0xO0
                @OXOo.OOXIXo
                public Uri getResult() {
                    return this.f22152II0xO0;
                }

                @Override // Xx000oIo.oxoX.II0xO0
                @OXOo.OOXIXo
                public Uri oIX0oI() {
                    return this.f22153oIX0oI;
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
                mContext = BaseDialCustomizeActivity.this.getMContext();
                return new Xx000oIo.oxoX(mContext, new oIX0oI(BaseDialCustomizeActivity.this));
            }
        });
        this.mBleHandleCallback = new I0Io();
        this.mDialIds = CollectionsKt__CollectionsKt.XOxIOxOx(0);
    }

    private final Pair<Float, Float> addControlBitmap(String str, DialElementView dialElementView, String str2, String str3, Canvas canvas, float f, float f2, boolean z) {
        if (dialElementView.getVisibility() == 0) {
            LogUtils.d("test addControlBitmap " + str + " , " + dialElementView.getX() + TokenParser.SP + dialElementView.getY() + TokenParser.SP + f + TokenParser.SP + f2);
            Bitmap bitmap = ImageUtils.getBitmap(getResources().getAssets().open(str));
            float x = dialElementView.getX() * f;
            float y = dialElementView.getY() * f2;
            canvas.drawBitmap(bitmap, x, y, (Paint) null);
            float width = ((float) (bitmap.getWidth() / 2)) + x;
            float height = y + ((float) bitmap.getHeight()) + ((float) this.controlValueInterval);
            float width2 = width - ((float) ((((ImageUtils.getBitmap(getResources().getAssets().open(str2 + str3.charAt(0) + '.' + this.fileFormat)).getWidth() * str3.length()) + str3.length()) - 1) / 2));
            if (z) {
                int length = str3.length();
                for (int i = 0; i < length; i++) {
                    Bitmap bitmap2 = ImageUtils.getBitmap(getResources().getAssets().open(str2 + str3.charAt(i) + ".png"));
                    canvas.drawBitmap(bitmap2, ((float) i) + width2 + ((float) (bitmap2.getWidth() * i)), height, (Paint) null);
                }
            }
            return new Pair<>(Float.valueOf(width), Float.valueOf(height + (r7.getHeight() / 2)));
        }
        return new Pair<>(Float.valueOf(0.0f), Float.valueOf(0.0f));
    }

    private final void addDigitalTime(String str, float f, float f2, Canvas canvas, boolean z) {
        float x = getTimeDigitalView().getX() * f;
        float y = f2 * getTimeDigitalView().getY();
        LogUtils.d("test timeLeft=" + x + ",  timeTop=" + y + ", timeDigitalView.width=" + getTimeDigitalView().getWidth() + " ,scaleWidth =" + f);
        AssetManager assets = getResources().getAssets();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(this.DIGITAL_AM_DIR);
        sb.append("/pm.png");
        Bitmap bitmap = ImageUtils.getBitmap(assets.open(sb.toString()));
        Pair<Bitmap, Float> addDigitalTimeParam = addDigitalTimeParam(str, this.DIGITAL_HOUR_MINUTE_DIR, "08:30", y, bitmap.getHeight(), canvas, x, z);
        float floatValue = addDigitalTimeParam(str, this.DIGITAL_DATE_DIR, "07/08", addDigitalTimeParam.component2().floatValue(), addDigitalTimeParam.component1().getHeight(), canvas, x, z).component2().floatValue();
        if (z) {
            canvas.drawBitmap(bitmap, this.digitalTimeMinuteRightX - bitmap.getWidth(), y, (Paint) null);
        }
        this.amLeftX = this.digitalTimeMinuteRightX - bitmap.getWidth();
        this.amTopY = y;
        Bitmap bitmap2 = ImageUtils.getBitmap(getResources().getAssets().open(str + this.DIGITAL_WEEK_DIR + "/4.png"));
        if (z) {
            canvas.drawBitmap(bitmap2, this.digitalTimeMinuteRightX - bitmap2.getWidth(), floatValue, (Paint) null);
        }
        this.digitalWeekLeftX = this.digitalTimeMinuteRightX - bitmap2.getWidth();
        this.digitalWeekTopY = floatValue;
    }

    private final Pair<Bitmap, Float> addDigitalTimeParam(String str, String str2, String str3, float f, int i, Canvas canvas, float f2, boolean z) {
        int i2;
        int i3;
        Bitmap bitmap = ImageUtils.getBitmap(getResources().getAssets().open(str + str2 + "/symbol.png"));
        AssetManager assets = getResources().getAssets();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        int i4 = 0;
        sb.append(str3.charAt(0));
        sb.append(".png");
        Bitmap bitmap2 = ImageUtils.getBitmap(assets.open(sb.toString()));
        float f3 = 6;
        float f4 = f + i + f3;
        int i5 = 2;
        float height = ((bitmap2.getHeight() - bitmap.getHeight()) / 2) + f4;
        if (StringsKt__StringsKt.o00xOoIO(str2, this.DIGITAL_HOUR_MINUTE_DIR, false, 2, null)) {
            this.digitalTimeHourLeftX = f2;
            this.digitalTimeHourTopY = f4;
            this.digitalTimeSymbolLeftX = (bitmap2.getWidth() * 2) + f2;
            this.digitalTimeSymbolTopY = height;
            float width = (bitmap2.getWidth() * 2) + f2 + bitmap.getWidth();
            this.digitalTimeMinuteLeftX = width;
            this.digitalTimeMinuteTopY = f4;
            this.digitalTimeMinuteRightX = (width + (bitmap2.getWidth() * 2)) - f3;
        } else if (StringsKt__StringsKt.o00xOoIO(str2, this.DIGITAL_DATE_DIR, false, 2, null)) {
            this.digitalDateMonthLeftX = f2;
            this.digitalDateMonthTopY = f4;
            this.digitalDateSymbolLeftX = (bitmap2.getWidth() * 2) + f2;
            this.digitalDateSymbolTopY = height;
            this.digitalDateDayLeftX = (bitmap2.getWidth() * 2) + f2 + bitmap.getWidth();
            this.digitalDateDayTopY = f4;
        }
        if (this.screenReservedBoundary == 0) {
            int length = str3.length();
            int i6 = 0;
            int i7 = 0;
            while (i4 < length) {
                if (i4 == i5) {
                    canvas.drawBitmap(bitmap, (bitmap2.getWidth() * i6) + f2, height, (Paint) null);
                    i3 = length;
                    i7 = bitmap.getWidth();
                } else {
                    if (z) {
                        i3 = length;
                        canvas.drawBitmap(ImageUtils.getBitmap(getResources().getAssets().open(str + str2 + IOUtils.DIR_SEPARATOR_UNIX + str3.charAt(i4) + ".png")), (bitmap2.getWidth() * i6) + f2 + i7, f4, (Paint) null);
                    } else {
                        i3 = length;
                    }
                    i6++;
                }
                i4++;
                i5 = 2;
                length = i3;
            }
        } else if (z) {
            int length2 = str3.length();
            int i8 = 0;
            int i9 = 0;
            while (i4 < length2) {
                if (i4 == 2) {
                    canvas.drawBitmap(bitmap, (bitmap2.getWidth() * i8) + f2, height, (Paint) null);
                    i9 = bitmap.getWidth();
                    i2 = length2;
                } else {
                    AssetManager assets2 = getResources().getAssets();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(str2);
                    sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
                    sb2.append(str3.charAt(i4));
                    sb2.append('.');
                    i2 = length2;
                    sb2.append(this.fileFormat);
                    canvas.drawBitmap(ImageUtils.getBitmap(assets2.open(sb2.toString())), (bitmap2.getWidth() * i8) + f2 + i9, f4, (Paint) null);
                    i8++;
                }
                i4++;
                length2 = i2;
            }
        }
        return new Pair<>(bitmap2, Float.valueOf(f4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bgOnClick$lambda$3$lambda$2(com.sma.smartv3.pop.dial.II0xO0 this_apply, BaseDialCustomizeActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this_apply, "$this_apply");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this_apply.dismiss();
        this$0.selectImagePopup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bgOnClick$lambda$5$lambda$4(DialBgFilePickerPopup this_apply, BaseDialCustomizeActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this_apply, "$this_apply");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this_apply.dismiss();
        this$0.selectImagePopup();
    }

    private final void controlChangeStatus(DialElementView dialElementView, ImageView imageView) {
        if (dialElementView.getVisibility() == 0) {
            dialElementView.setVisibility(8);
            imageView.setImageResource(R.drawable.dial_control_add);
        } else {
            dialElementView.setVisibility(0);
            imageView.setImageResource(R.drawable.dial_control_already_add);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void controlOnClick$lambda$16$lambda$11(com.sma.smartv3.pop.dial.I0Io this_apply, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this_apply, "$this_apply");
        this_apply.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void controlOnClick$lambda$16$lambda$12(BaseDialCustomizeActivity this$0, com.sma.smartv3.pop.dial.I0Io this_apply, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this_apply, "$this_apply");
        DialElementView controlViewStep = this$0.getControlViewStep();
        kotlin.jvm.internal.IIX0o.oO(controlViewStep, "<get-controlViewStep>(...)");
        this$0.controlChangeStatus(controlViewStep, this_apply.IIX0o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void controlOnClick$lambda$16$lambda$13(BaseDialCustomizeActivity this$0, com.sma.smartv3.pop.dial.I0Io this_apply, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this_apply, "$this_apply");
        DialElementView controlViewHr = this$0.getControlViewHr();
        kotlin.jvm.internal.IIX0o.oO(controlViewHr, "<get-controlViewHr>(...)");
        this$0.controlChangeStatus(controlViewHr, this_apply.ooXIXxIX());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void controlOnClick$lambda$16$lambda$14(BaseDialCustomizeActivity this$0, com.sma.smartv3.pop.dial.I0Io this_apply, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this_apply, "$this_apply");
        DialElementView controlViewCa = this$0.getControlViewCa();
        kotlin.jvm.internal.IIX0o.oO(controlViewCa, "<get-controlViewCa>(...)");
        this$0.controlChangeStatus(controlViewCa, this_apply.xI());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void controlOnClick$lambda$16$lambda$15(BaseDialCustomizeActivity this$0, com.sma.smartv3.pop.dial.I0Io this_apply, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this_apply, "$this_apply");
        DialElementView controlViewDis = this$0.getControlViewDis();
        kotlin.jvm.internal.IIX0o.oO(controlViewDis, "<get-controlViewDis>(...)");
        this$0.controlChangeStatus(controlViewDis, this_apply.oo0xXOI0I());
    }

    private final byte[] convertPng(File file, boolean z, boolean z2) {
        return com.sma.smartv3.ui.device.watchface.oIX0oI.f22830XI0oooXX.I0Io(file, z, z2);
    }

    public static /* synthetic */ byte[] convertPng$default(BaseDialCustomizeActivity baseDialCustomizeActivity, File file, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            return baseDialCustomizeActivity.convertPng(file, z, z2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: convertPng");
    }

    private final byte[] getBg() {
        byte[] convertPng$default;
        Bitmap bgBitmap$default = getBgBitmap$default(this, false, 0, 2, null);
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        ImageUtils.save(bgBitmap$default, com.sma.smartv3.initializer.IXxxXO.xoXoI(oix0oi), Bitmap.CompressFormat.PNG);
        if (this.isSupportConvertPng && (convertPng$default = convertPng$default(this, com.sma.smartv3.initializer.IXxxXO.xoXoI(oix0oi), false, false, 4, null)) != null) {
            return convertPng$default;
        }
        return bitmap2Bytes(bgBitmap$default);
    }

    private final Bitmap getBgBitmap(boolean z, int i) {
        Bitmap bitmap$default;
        Bitmap roundCorner;
        float f;
        float f2;
        Canvas canvas;
        if (this.isRound) {
            bitmap$default = ImageUtils.view2Bitmap(getCustomizeDialBg());
        } else {
            Drawable drawable = getCustomizeDialBg().getDrawable();
            kotlin.jvm.internal.IIX0o.oO(drawable, "getDrawable(...)");
            bitmap$default = DrawableKt.toBitmap$default(drawable, 0, 0, null, 7, null);
        }
        float width = this.screenWidth / bitmap$default.getWidth();
        float height = (this.screenHeight - this.screenReservedBoundary) / bitmap$default.getHeight();
        LogUtils.d("test getBgBitmap = " + bitmap$default.getWidth() + "- " + bitmap$default.getHeight() + " ; " + width + " - " + height + TokenParser.SP);
        Bitmap scale = ImageUtils.scale(bitmap$default, width, height);
        if (this.isRound) {
            roundCorner = ImageUtils.toRound(scale, this.borderSize, getResources().getColor(i));
        } else {
            roundCorner = ImageUtils.toRoundCorner(scale, this.roundCornerRadius, 0.0f, getResources().getColor(i));
        }
        Bitmap bitmap = roundCorner;
        if (!this.isRound) {
            f = this.screenWidth / getCustomizeDialBg().getWidth();
            f2 = (this.screenHeight - this.screenReservedBoundary) / getCustomizeDialBg().getHeight();
        } else {
            f = width;
            f2 = height;
        }
        Canvas canvas2 = new Canvas(bitmap);
        String str = this.STEP_DIR + "/step_0.png";
        DialElementView controlViewStep = getControlViewStep();
        kotlin.jvm.internal.IIX0o.oO(controlViewStep, "<get-controlViewStep>(...)");
        float f3 = f;
        float f4 = f2;
        Pair<Float, Float> addControlBitmap = addControlBitmap(str, controlViewStep, this.VALUE_DIR + IOUtils.DIR_SEPARATOR_UNIX + this.valueColor + IOUtils.DIR_SEPARATOR_UNIX, "18564", canvas2, f3, f4, z);
        float floatValue = addControlBitmap.component1().floatValue();
        float floatValue2 = addControlBitmap.component2().floatValue();
        this.stepValueCenterX = floatValue;
        this.stepValueCenterY = floatValue2;
        String str2 = this.CALORIES_DIR + "/calories_0.png";
        DialElementView controlViewCa = getControlViewCa();
        kotlin.jvm.internal.IIX0o.oO(controlViewCa, "<get-controlViewCa>(...)");
        Pair<Float, Float> addControlBitmap2 = addControlBitmap(str2, controlViewCa, this.VALUE_DIR + IOUtils.DIR_SEPARATOR_UNIX + this.valueColor + IOUtils.DIR_SEPARATOR_UNIX, "50", canvas2, f3, f4, z);
        float floatValue3 = addControlBitmap2.component1().floatValue();
        float floatValue4 = addControlBitmap2.component2().floatValue();
        this.caloriesValueCenterX = floatValue3;
        this.caloriesValueCenterY = floatValue4;
        String str3 = this.DISTANCE_DIR + "/distance_0.png";
        DialElementView controlViewDis = getControlViewDis();
        kotlin.jvm.internal.IIX0o.oO(controlViewDis, "<get-controlViewDis>(...)");
        Pair<Float, Float> addControlBitmap3 = addControlBitmap(str3, controlViewDis, this.VALUE_DIR + IOUtils.DIR_SEPARATOR_UNIX + this.valueColor + IOUtils.DIR_SEPARATOR_UNIX, "6", canvas2, f3, f4, z);
        float floatValue5 = addControlBitmap3.component1().floatValue();
        float floatValue6 = addControlBitmap3.component2().floatValue();
        this.distanceValueCenterX = floatValue5;
        this.distanceValueCenterY = floatValue6;
        String str4 = this.HEART_RATE_DIR + "/heart_rate_0.png";
        DialElementView controlViewHr = getControlViewHr();
        kotlin.jvm.internal.IIX0o.oO(controlViewHr, "<get-controlViewHr>(...)");
        Pair<Float, Float> addControlBitmap4 = addControlBitmap(str4, controlViewHr, this.VALUE_DIR + IOUtils.DIR_SEPARATOR_UNIX + this.valueColor + IOUtils.DIR_SEPARATOR_UNIX, "90", canvas2, f3, f4, z);
        float floatValue7 = addControlBitmap4.component1().floatValue();
        float floatValue8 = addControlBitmap4.component2().floatValue();
        this.heartRateValueCenterX = floatValue7;
        this.heartRateValueCenterY = floatValue8;
        DialElementView timeDigitalView = getTimeDigitalView();
        kotlin.jvm.internal.IIX0o.oO(timeDigitalView, "<get-timeDigitalView>(...)");
        if (timeDigitalView.getVisibility() == 0) {
            addDigitalTime(this.DIGITAL_DIR + IOUtils.DIR_SEPARATOR_UNIX + this.digitalValueColor + IOUtils.DIR_SEPARATOR_UNIX, f, f2, canvas2, z);
        }
        ImageView timeScaleView = getTimeScaleView();
        kotlin.jvm.internal.IIX0o.oO(timeScaleView, "<get-timeScaleView>(...)");
        if (timeScaleView.getVisibility() == 0) {
            ImageView timeScaleView2 = getTimeScaleView();
            kotlin.jvm.internal.IIX0o.oO(timeScaleView2, "<get-timeScaleView>(...)");
            canvas = canvas2;
            getPointerBg(timeScaleView2, true, canvas);
        } else {
            canvas = canvas2;
        }
        ImageView timePointView = getTimePointView();
        kotlin.jvm.internal.IIX0o.oO(timePointView, "<get-timePointView>(...)");
        if (timePointView.getVisibility() == 0) {
            ImageView timePointView2 = getTimePointView();
            kotlin.jvm.internal.IIX0o.oO(timePointView2, "<get-timePointView>(...)");
            getPointerBg(timePointView2, z, canvas);
        }
        if (i == R.color.dark) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(bitmap);
            return getFinalBgBitmap(bitmap);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight() + 1, Bitmap.Config.ARGB_8888);
        kotlin.jvm.internal.IIX0o.oO(createBitmap, "createBitmap(...)");
        new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, new Paint());
        return createBitmap;
    }

    public static /* synthetic */ Bitmap getBgBitmap$default(BaseDialCustomizeActivity baseDialCustomizeActivity, boolean z, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = R.color.dark;
            }
            return baseDialCustomizeActivity.getBgBitmap(z, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBgBitmap");
    }

    private final void getControl(ArrayList<Element> arrayList) {
        char c;
        Triple<Integer, Integer, ArrayList<byte[]>> numberBuffers = getNumberBuffers(this.VALUE_DIR + IOUtils.DIR_SEPARATOR_UNIX + this.valueColor + IOUtils.DIR_SEPARATOR_UNIX, this.controlValueRange);
        int intValue = numberBuffers.getFirst().intValue();
        int intValue2 = numberBuffers.getSecond().intValue();
        byte[][] bArr = (byte[][]) numberBuffers.getThird().toArray(new byte[0]);
        DialElementView controlViewStep = getControlViewStep();
        kotlin.jvm.internal.IIX0o.oO(controlViewStep, "<get-controlViewStep>(...)");
        if (controlViewStep.getVisibility() == 0) {
            c = 0;
            arrayList.add(new Element(14, 0, intValue, intValue2, this.X_CENTER | this.Y_CENTER, this.ignoreBlack, (int) this.stepValueCenterX, (int) this.stepValueCenterY, 0, 0, 0, bArr, 1794, null));
        } else {
            c = 0;
        }
        DialElementView controlViewHr = getControlViewHr();
        kotlin.jvm.internal.IIX0o.oO(controlViewHr, "<get-controlViewHr>(...)");
        if (controlViewHr.getVisibility() == 0) {
            arrayList.add(new Element(15, 0, intValue, intValue2, this.X_CENTER | this.Y_CENTER, this.ignoreBlack, (int) this.heartRateValueCenterX, (int) this.heartRateValueCenterY, 0, 0, 0, bArr, 1794, null));
        }
        DialElementView controlViewCa = getControlViewCa();
        kotlin.jvm.internal.IIX0o.oO(controlViewCa, "<get-controlViewCa>(...)");
        if (controlViewCa.getVisibility() == 0) {
            arrayList.add(new Element(16, 0, intValue, intValue2, this.X_CENTER | this.Y_CENTER, this.ignoreBlack, (int) this.caloriesValueCenterX, (int) this.caloriesValueCenterY, 0, 0, 0, bArr, 1794, null));
        }
        DialElementView controlViewDis = getControlViewDis();
        kotlin.jvm.internal.IIX0o.oO(controlViewDis, "<get-controlViewDis>(...)");
        if (controlViewDis.getVisibility() == 0) {
            Element element = new Element(17, 0, intValue, intValue2, this.X_CENTER | this.Y_CENTER, this.ignoreBlack, (int) this.distanceValueCenterX, (int) this.distanceValueCenterY, 0, 0, 0, bArr, 1794, null);
            Object[] objArr = new Object[1];
            objArr[c] = "test distanceValueCenterX=" + this.distanceValueCenterX + "  distanceValueCenterY=" + this.distanceValueCenterY;
            LogUtils.d(objArr);
            arrayList.add(element);
        }
    }

    private final void getControl2(ArrayList<Element> arrayList) {
        char c;
        Triple<Integer, Integer, ArrayList<byte[]>> numberBuffers2 = getNumberBuffers2(this.VALUE_DIR + IOUtils.DIR_SEPARATOR_UNIX + this.valueColor + IOUtils.DIR_SEPARATOR_UNIX, this.controlValueRange);
        int intValue = numberBuffers2.getFirst().intValue();
        int intValue2 = numberBuffers2.getSecond().intValue();
        byte[][] bArr = (byte[][]) numberBuffers2.getThird().toArray(new byte[0]);
        DialElementView controlViewStep = getControlViewStep();
        kotlin.jvm.internal.IIX0o.oO(controlViewStep, "<get-controlViewStep>(...)");
        if (controlViewStep.getVisibility() == 0) {
            c = 0;
            arrayList.add(new Element(14, 1, intValue, intValue2, this.X_CENTER | this.Y_CENTER, this.ignoreBlack, (int) this.stepValueCenterX, (int) this.stepValueCenterY, 0, 0, 0, bArr, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
        } else {
            c = 0;
        }
        DialElementView controlViewHr = getControlViewHr();
        kotlin.jvm.internal.IIX0o.oO(controlViewHr, "<get-controlViewHr>(...)");
        if (controlViewHr.getVisibility() == 0) {
            arrayList.add(new Element(15, 1, intValue, intValue2, this.X_CENTER | this.Y_CENTER, this.ignoreBlack, (int) this.heartRateValueCenterX, (int) this.heartRateValueCenterY, 0, 0, 0, bArr, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
        }
        DialElementView controlViewCa = getControlViewCa();
        kotlin.jvm.internal.IIX0o.oO(controlViewCa, "<get-controlViewCa>(...)");
        if (controlViewCa.getVisibility() == 0) {
            arrayList.add(new Element(16, 1, intValue, intValue2, this.X_CENTER | this.Y_CENTER, this.ignoreBlack, (int) this.caloriesValueCenterX, (int) this.caloriesValueCenterY, 0, 0, 0, bArr, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
        }
        DialElementView controlViewDis = getControlViewDis();
        kotlin.jvm.internal.IIX0o.oO(controlViewDis, "<get-controlViewDis>(...)");
        if (controlViewDis.getVisibility() == 0) {
            Element element = new Element(17, 1, intValue, intValue2, this.X_CENTER | this.Y_CENTER, this.ignoreBlack, (int) this.distanceValueCenterX, (int) this.distanceValueCenterY, 0, 0, 0, bArr, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null);
            Object[] objArr = new Object[1];
            objArr[c] = "test distanceValueCenterX=" + this.distanceValueCenterX + "  distanceValueCenterY=" + this.distanceValueCenterY;
            LogUtils.d(objArr);
            arrayList.add(element);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Xx000oIo.oxoX getMCrop() {
        return (Xx000oIo.oxoX) this.mCrop$delegate.getValue();
    }

    private final Triple<Integer, Integer, ArrayList<byte[]>> getNumberBuffers(String str, int i) {
        int i2;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        if (i >= 0) {
            int i4 = 0;
            i2 = 0;
            while (true) {
                if (i3 == 0) {
                    Bitmap bitmap = ImageUtils.getBitmap(getResources().getAssets().open(str + i4 + '.' + this.fileFormat));
                    int width = bitmap.getWidth();
                    i2 = bitmap.getHeight();
                    i3 = width;
                }
                InputStream open = getResources().getAssets().open(str + i4 + '.' + this.fileFormat);
                try {
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(open);
                    byte[] x0xO0oo2 = kotlin.io.oIX0oI.x0xO0oo(open);
                    kotlin.io.II0xO0.oIX0oI(open, null);
                    arrayList.add(com.sma.smartv3.util.oxoX.II0xO0(this.fileFormat, x0xO0oo2, i3, 0, 0, false, 56, null));
                    if (i4 == i) {
                        break;
                    }
                    i4++;
                } finally {
                }
            }
        } else {
            i2 = 0;
        }
        return new Triple<>(Integer.valueOf(i3), Integer.valueOf(i2), arrayList);
    }

    public static /* synthetic */ Triple getNumberBuffers$default(BaseDialCustomizeActivity baseDialCustomizeActivity, String str, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 9;
            }
            return baseDialCustomizeActivity.getNumberBuffers(str, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNumberBuffers");
    }

    private final Triple<Integer, Integer, ArrayList<byte[]>> getNumberBuffers2(String str, int i) {
        int i2;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        if (i >= 0) {
            int i4 = 0;
            i2 = 0;
            while (true) {
                String str2 = str + i3 + '.' + this.fileFormat;
                if (i4 == 0) {
                    Bitmap bitmap = ImageUtils.getBitmap(getResources().getAssets().open(str2));
                    int width = bitmap.getWidth();
                    i2 = bitmap.getHeight();
                    i4 = width;
                }
                InputStream open = getResources().getAssets().open(str2);
                try {
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(open);
                    byte[] x0xO0oo2 = kotlin.io.oIX0oI.x0xO0oo(open);
                    kotlin.io.II0xO0.oIX0oI(open, null);
                    File file = new File(com.sma.smartv3.initializer.IXxxXO.IoOoX(X00IoxXI.oIX0oI.f3233oIX0oI), str2);
                    FileIOUtils.writeFileFromBytesByStream(file, x0xO0oo2);
                    byte[] convertPng$default = convertPng$default(this, file, false, false, 6, null);
                    if (convertPng$default != null) {
                        arrayList.add(convertPng$default);
                    }
                    if (i3 == i) {
                        break;
                    }
                    i3++;
                } finally {
                }
            }
            i3 = i4;
        } else {
            i2 = 0;
        }
        return new Triple<>(Integer.valueOf(i3), Integer.valueOf(i2), arrayList);
    }

    public static /* synthetic */ Triple getNumberBuffers2$default(BaseDialCustomizeActivity baseDialCustomizeActivity, String str, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 9;
            }
            return baseDialCustomizeActivity.getNumberBuffers2(str, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNumberBuffers2");
    }

    private final void getPointer(int i, String str, ArrayList<Element> arrayList) {
        int i2;
        int i3;
        ArrayList arrayList2 = new ArrayList();
        Bitmap bitmap = ImageUtils.getBitmap(getResources().getAssets().open(this.POINTER_DIR + IOUtils.DIR_SEPARATOR_UNIX + str + IOUtils.DIR_SEPARATOR_UNIX + this.pointerSelectNumber + '.' + this.fileFormat));
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        InputStream open = getResources().getAssets().open(this.POINTER_DIR + IOUtils.DIR_SEPARATOR_UNIX + str + IOUtils.DIR_SEPARATOR_UNIX + this.pointerSelectNumber + '.' + this.fileFormat);
        try {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(open);
            byte[] x0xO0oo2 = kotlin.io.oIX0oI.x0xO0oo(open);
            kotlin.io.II0xO0.oIX0oI(open, null);
            arrayList2.add(com.sma.smartv3.util.oxoX.II0xO0(this.fileFormat, x0xO0oo2, width, 0, 0, false, 56, null));
            int i4 = this.ignoreBlack;
            int i5 = (this.screenWidth / 2) - 1;
            int i6 = (this.screenHeight / 2) - 1;
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.fileFormat, "png")) {
                i2 = 0;
            } else {
                i2 = height / 2;
            }
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.fileFormat, "png")) {
                i3 = 0;
            } else {
                i3 = width / 2;
            }
            arrayList.add(new Element(i, 0, width, height, 9, i4, i5, i6, 0, i2, i3, (byte[][]) arrayList2.toArray(new byte[0]), 258, null));
        } finally {
        }
    }

    private final void getPointer2(int i, String str, ArrayList<Element> arrayList) {
        String str2 = this.POINTER_DIR + IOUtils.DIR_SEPARATOR_UNIX + str + IOUtils.DIR_SEPARATOR_UNIX + this.pointerSelectNumber + '.' + this.fileFormat;
        ArrayList arrayList2 = new ArrayList();
        Bitmap bitmap = ImageUtils.getBitmap(getResources().getAssets().open(str2));
        int width = bitmap.getWidth();
        int height = (int) (bitmap.getHeight() * 0.6f);
        int[] iArr = new int[bitmap.getHeight() * bitmap.getWidth()];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        oIX0oI.C0962oIX0oI c0962oIX0oI = com.sma.smartv3.ui.device.watchface.oIX0oI.f22830XI0oooXX;
        int i2 = 1;
        int OOXIXo2 = ((((width * 3) + c0962oIX0oI.OOXIXo()) - 1) / c0962oIX0oI.OOXIXo()) * c0962oIX0oI.OOXIXo();
        int i3 = OOXIXo2 * height;
        byte[] bArr = new byte[i3];
        for (int i4 = 0; i4 < height; i4 += i2) {
            byte[] bArr2 = new byte[OOXIXo2];
            for (int i5 = 0; i5 < width; i5++) {
                int oIX0oI2 = com.sma.smartv3.ui.device.watchface.oIX0oI.f22830XI0oooXX.oIX0oI(iArr[(i4 * width) + i5]);
                int i6 = i5 * 3;
                bArr2[i6 + 2] = (byte) (oIX0oI2 & 255);
                bArr2[i6 + 1] = (byte) ((oIX0oI2 >> 8) & 255);
                bArr2[i6] = (byte) ((oIX0oI2 >> 16) & 255);
                i2 = 1;
            }
            System.arraycopy(bArr2, 0, bArr, i4 * OOXIXo2, OOXIXo2);
        }
        LogUtils.d("getPointer2 -> w=" + width + ", h=" + height + ", rowSize=" + OOXIXo2 + ", data=" + i3);
        arrayList2.add(bArr);
        arrayList.add(new Element(i, 1, width, height, 9, 1, this.screenWidth / 2, this.screenHeight / 2, 0, height - (bitmap.getHeight() / 2), width / 2, (byte[][]) arrayList2.toArray(new byte[0]), 256, null));
    }

    private final void getPointer3(int i, String str, ArrayList<Element> arrayList) {
        String str2 = this.POINTER_DIR + IOUtils.DIR_SEPARATOR_UNIX + str + IOUtils.DIR_SEPARATOR_UNIX + this.pointerSelectNumber + '.' + this.fileFormat;
        InputStream open = getResources().getAssets().open(str2);
        try {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(open);
            byte[] x0xO0oo2 = kotlin.io.oIX0oI.x0xO0oo(open);
            kotlin.io.II0xO0.oIX0oI(open, null);
            File file = new File(com.sma.smartv3.initializer.IXxxXO.IoOoX(X00IoxXI.oIX0oI.f3233oIX0oI), str2);
            FileIOUtils.writeFileFromBytesByStream(file, x0xO0oo2);
            ArrayList arrayList2 = new ArrayList();
            Bitmap bitmap = ImageUtils.getBitmap(x0xO0oo2, 0);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            byte[] convertPng$default = convertPng$default(this, file, false, true, 2, null);
            if (convertPng$default != null) {
                arrayList2.add(convertPng$default);
            }
            arrayList.add(new Element(i, 1, width, height, 9, this.ignoreBlack, this.screenWidth / 2, this.screenHeight / 2, 0, height - (bitmap.getHeight() / 2), width / 2, (byte[][]) arrayList2.toArray(new byte[0]), 256, null));
        } finally {
        }
    }

    private final void getPointerBg(ImageView imageView, boolean z, Canvas canvas) {
        Bitmap bitmap$default;
        Bitmap roundCorner;
        if (this.isRound) {
            bitmap$default = ImageUtils.view2Bitmap(imageView);
        } else {
            Drawable drawable = imageView.getDrawable();
            kotlin.jvm.internal.IIX0o.oO(drawable, "getDrawable(...)");
            bitmap$default = DrawableKt.toBitmap$default(drawable, 0, 0, null, 7, null);
        }
        int left = imageView.getLeft();
        int top = imageView.getTop();
        float width = this.screenWidth / (bitmap$default.getWidth() + (left * 2));
        float height = (this.screenHeight - this.screenReservedBoundary) / (bitmap$default.getHeight() + (top * 2));
        Bitmap scale = ImageUtils.scale(bitmap$default, width, height);
        if (this.isRound) {
            roundCorner = ImageUtils.toRound(scale, 0, 0);
        } else {
            roundCorner = ImageUtils.toRoundCorner(scale, this.roundCornerRadius);
        }
        if (z) {
            canvas.drawBitmap(roundCorner, left * width, top * height, (Paint) null);
        }
    }

    private final byte[] getPreview(int i) {
        Bitmap roundCorner;
        byte[] convertPng$default;
        float width = this.screenPreviewWidth / r0.getWidth();
        Bitmap scale = ImageUtils.scale(getBgBitmap$default(this, true, 0, 2, null), width, this.screenPreviewHeight / r0.getHeight());
        if (this.isRound) {
            roundCorner = ImageUtils.toRound(scale, this.borderSize, getResources().getColor(i));
        } else {
            roundCorner = ImageUtils.toRoundCorner(scale, this.roundCornerRadius * width, this.borderSize, getResources().getColor(i));
        }
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        ImageUtils.save(roundCorner, com.sma.smartv3.initializer.IXxxXO.xxX(oix0oi), Bitmap.CompressFormat.PNG);
        if (this.isSupportConvertPng && (convertPng$default = convertPng$default(this, com.sma.smartv3.initializer.IXxxXO.xxX(oix0oi), false, false, 4, null)) != null) {
            return convertPng$default;
        }
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(roundCorner);
        return bitmap2Bytes(roundCorner);
    }

    public static /* synthetic */ byte[] getPreview$default(BaseDialCustomizeActivity baseDialCustomizeActivity, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = R.color.dark;
            }
            return baseDialCustomizeActivity.getPreview(i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPreview");
    }

    private final void getSymbol(String str, int i, int i2, int i3, ArrayList<Element> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Bitmap bitmap = ImageUtils.getBitmap(getResources().getAssets().open(str + "/symbol." + this.fileFormat));
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        String str2 = this.fileFormat;
        InputStream open = getResources().getAssets().open(str + "/symbol." + this.fileFormat);
        try {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(open);
            byte[] x0xO0oo2 = kotlin.io.oIX0oI.x0xO0oo(open);
            kotlin.io.II0xO0.oIX0oI(open, null);
            arrayList2.add(com.sma.smartv3.util.oxoX.II0xO0(str2, x0xO0oo2, width, 0, 0, false, 56, null));
            arrayList.add(new Element(i, 0, width, height, 9, this.ignoreBlack, i2, i3, 0, 0, 0, (byte[][]) arrayList2.toArray(new byte[0]), 1794, null));
        } finally {
        }
    }

    private final void getSymbol2(String str, int i, int i2, int i3, ArrayList<Element> arrayList) {
        String str2 = str + "/symbol." + this.fileFormat;
        ArrayList arrayList2 = new ArrayList();
        Bitmap bitmap = ImageUtils.getBitmap(getResources().getAssets().open(str2));
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        InputStream open = getResources().getAssets().open(str2);
        try {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(open);
            byte[] x0xO0oo2 = kotlin.io.oIX0oI.x0xO0oo(open);
            kotlin.io.II0xO0.oIX0oI(open, null);
            File file = new File(com.sma.smartv3.initializer.IXxxXO.IoOoX(X00IoxXI.oIX0oI.f3233oIX0oI), str2);
            FileIOUtils.writeFileFromBytesByStream(file, x0xO0oo2);
            byte[] convertPng$default = convertPng$default(this, file, false, false, 6, null);
            if (convertPng$default != null) {
                arrayList2.add(convertPng$default);
            }
            arrayList.add(new Element(i, 1, width, height, 9, this.ignoreBlack, i2, i3, 0, 0, 0, (byte[][]) arrayList2.toArray(new byte[0]), SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
        } finally {
        }
    }

    private final void getTimeDigital(ArrayList<Element> arrayList) {
        Object obj;
        int i;
        ArrayList arrayList2 = new ArrayList();
        Bitmap bitmap = ImageUtils.getBitmap(getResources().getAssets().open(this.DIGITAL_DIR + IOUtils.DIR_SEPARATOR_UNIX + this.digitalValueColor + IOUtils.DIR_SEPARATOR_UNIX + this.DIGITAL_AM_DIR + "/am." + this.fileFormat));
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        InputStream open = getResources().getAssets().open(this.DIGITAL_DIR + IOUtils.DIR_SEPARATOR_UNIX + this.digitalValueColor + IOUtils.DIR_SEPARATOR_UNIX + this.DIGITAL_AM_DIR + "/am." + this.fileFormat);
        try {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(open);
            byte[] x0xO0oo2 = kotlin.io.oIX0oI.x0xO0oo(open);
            kotlin.io.II0xO0.oIX0oI(open, null);
            open = getResources().getAssets().open(this.DIGITAL_DIR + IOUtils.DIR_SEPARATOR_UNIX + this.digitalValueColor + IOUtils.DIR_SEPARATOR_UNIX + this.DIGITAL_AM_DIR + "/pm." + this.fileFormat);
            try {
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(open);
                byte[] x0xO0oo3 = kotlin.io.oIX0oI.x0xO0oo(open);
                kotlin.io.II0xO0.oIX0oI(open, null);
                arrayList2.add(com.sma.smartv3.util.oxoX.II0xO0(this.fileFormat, x0xO0oo2, width, 0, 0, false, 56, null));
                arrayList2.add(com.sma.smartv3.util.oxoX.II0xO0(this.fileFormat, x0xO0oo3, width, 0, 0, false, 56, null));
                arrayList.add(new Element(12, 0, width, height, 9, this.ignoreBlack, (int) this.amLeftX, (int) this.amTopY, 0, 0, 0, (byte[][]) arrayList2.toArray(new byte[0]), 1794, null));
                Triple numberBuffers$default = getNumberBuffers$default(this, this.DIGITAL_DIR + IOUtils.DIR_SEPARATOR_UNIX + this.digitalValueColor + IOUtils.DIR_SEPARATOR_UNIX + this.DIGITAL_HOUR_MINUTE_DIR + IOUtils.DIR_SEPARATOR_UNIX, 0, 2, null);
                int intValue = ((Number) numberBuffers$default.getFirst()).intValue();
                int intValue2 = ((Number) numberBuffers$default.getSecond()).intValue();
                byte[][] bArr = (byte[][]) ((Collection) numberBuffers$default.getThird()).toArray(new byte[0]);
                arrayList.add(new Element(9, 0, intValue, intValue2, 9, this.ignoreBlack, (int) this.digitalTimeHourLeftX, (int) this.digitalTimeHourTopY, 0, 0, 0, bArr, 1794, null));
                arrayList.add(new Element(10, 0, intValue, intValue2, 9, this.ignoreBlack, (int) this.digitalTimeMinuteLeftX, (int) this.digitalTimeMinuteTopY, 0, 0, 0, bArr, 1794, null));
                if (this.screenReservedBoundary != 0) {
                    i = 0;
                    obj = null;
                    getSymbol(this.DIGITAL_DIR + IOUtils.DIR_SEPARATOR_UNIX + this.digitalValueColor + IOUtils.DIR_SEPARATOR_UNIX + this.DIGITAL_HOUR_MINUTE_DIR, 20, (int) this.digitalTimeSymbolLeftX, (int) this.digitalTimeSymbolTopY, arrayList);
                } else {
                    obj = null;
                    i = 0;
                }
                Triple numberBuffers$default2 = getNumberBuffers$default(this, this.DIGITAL_DIR + IOUtils.DIR_SEPARATOR_UNIX + this.digitalValueColor + IOUtils.DIR_SEPARATOR_UNIX + this.DIGITAL_DATE_DIR + IOUtils.DIR_SEPARATOR_UNIX, i, 2, obj);
                int intValue3 = ((Number) numberBuffers$default2.getFirst()).intValue();
                int intValue4 = ((Number) numberBuffers$default2.getSecond()).intValue();
                byte[][] bArr2 = (byte[][]) ((Collection) numberBuffers$default2.getThird()).toArray(new byte[i]);
                arrayList.add(new Element(7, 0, intValue3, intValue4, 9, this.ignoreBlack, (int) this.digitalDateMonthLeftX, (int) this.digitalDateMonthTopY, 0, 0, 0, bArr2, 1794, null));
                arrayList.add(new Element(8, 0, intValue3, intValue4, 9, this.ignoreBlack, (int) this.digitalDateDayLeftX, (int) this.digitalDateDayTopY, 0, 0, 0, bArr2, 1794, null));
                if (this.screenReservedBoundary != 0) {
                    getSymbol(this.DIGITAL_DIR + IOUtils.DIR_SEPARATOR_UNIX + this.digitalValueColor + IOUtils.DIR_SEPARATOR_UNIX + this.DIGITAL_DATE_DIR, 21, (int) this.digitalDateSymbolLeftX, (int) this.digitalDateSymbolTopY, arrayList);
                }
                Triple<Integer, Integer, ArrayList<byte[]>> numberBuffers = getNumberBuffers(this.DIGITAL_DIR + IOUtils.DIR_SEPARATOR_UNIX + this.digitalValueColor + IOUtils.DIR_SEPARATOR_UNIX + this.DIGITAL_WEEK_DIR + IOUtils.DIR_SEPARATOR_UNIX, 6);
                arrayList.add(new Element(13, 0, numberBuffers.getFirst().intValue(), numberBuffers.getSecond().intValue(), 9, this.ignoreBlack, (int) this.digitalWeekLeftX, (int) this.digitalWeekTopY, 0, 0, 0, (byte[][]) numberBuffers.getThird().toArray(new byte[i]), 1794, null));
            } finally {
            }
        } finally {
            try {
                throw th;
            } finally {
            }
        }
    }

    private final void getTimeDigital2(ArrayList<Element> arrayList) {
        int i;
        String str = this.DIGITAL_DIR + IOUtils.DIR_SEPARATOR_UNIX + this.digitalValueColor + IOUtils.DIR_SEPARATOR_UNIX + this.DIGITAL_AM_DIR + "/am." + this.fileFormat;
        String str2 = this.DIGITAL_DIR + IOUtils.DIR_SEPARATOR_UNIX + this.digitalValueColor + IOUtils.DIR_SEPARATOR_UNIX + this.DIGITAL_AM_DIR + "/pm." + this.fileFormat;
        ArrayList arrayList2 = new ArrayList();
        Bitmap bitmap = ImageUtils.getBitmap(getResources().getAssets().open(str));
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        InputStream open = getResources().getAssets().open(str);
        try {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(open);
            byte[] x0xO0oo2 = kotlin.io.oIX0oI.x0xO0oo(open);
            kotlin.io.II0xO0.oIX0oI(open, null);
            open = getResources().getAssets().open(str2);
            try {
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(open);
                byte[] x0xO0oo3 = kotlin.io.oIX0oI.x0xO0oo(open);
                kotlin.io.II0xO0.oIX0oI(open, null);
                X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
                File file = new File(com.sma.smartv3.initializer.IXxxXO.IoOoX(oix0oi), str);
                FileIOUtils.writeFileFromBytesByStream(file, x0xO0oo2);
                File file2 = new File(com.sma.smartv3.initializer.IXxxXO.IoOoX(oix0oi), str2);
                FileIOUtils.writeFileFromBytesByStream(file2, x0xO0oo3);
                byte[] convertPng$default = convertPng$default(this, file, false, false, 6, null);
                if (convertPng$default != null) {
                    arrayList2.add(convertPng$default);
                }
                byte[] convertPng$default2 = convertPng$default(this, file2, false, false, 6, null);
                if (convertPng$default2 != null) {
                    arrayList2.add(convertPng$default2);
                }
                arrayList.add(new Element(12, 1, width, height, 9, this.ignoreBlack, (int) this.amLeftX, (int) this.amTopY, 0, 0, 0, (byte[][]) arrayList2.toArray(new byte[0]), SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
                Triple numberBuffers2$default = getNumberBuffers2$default(this, this.DIGITAL_DIR + IOUtils.DIR_SEPARATOR_UNIX + this.digitalValueColor + IOUtils.DIR_SEPARATOR_UNIX + this.DIGITAL_HOUR_MINUTE_DIR + IOUtils.DIR_SEPARATOR_UNIX, 0, 2, null);
                int intValue = ((Number) numberBuffers2$default.getFirst()).intValue();
                int intValue2 = ((Number) numberBuffers2$default.getSecond()).intValue();
                byte[][] bArr = (byte[][]) ((Collection) numberBuffers2$default.getThird()).toArray(new byte[0]);
                arrayList.add(new Element(9, 1, intValue, intValue2, 9, this.ignoreBlack, (int) this.digitalTimeHourLeftX, (int) this.digitalTimeHourTopY, 0, 0, 0, bArr, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
                arrayList.add(new Element(10, 1, intValue, intValue2, 9, this.ignoreBlack, (int) this.digitalTimeMinuteLeftX, (int) this.digitalTimeMinuteTopY, 0, 0, 0, bArr, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
                if (this.screenReservedBoundary != 0) {
                    i = 0;
                    getSymbol2(this.DIGITAL_DIR + IOUtils.DIR_SEPARATOR_UNIX + this.digitalValueColor + IOUtils.DIR_SEPARATOR_UNIX + this.DIGITAL_HOUR_MINUTE_DIR, 20, (int) this.digitalTimeSymbolLeftX, (int) this.digitalTimeSymbolTopY, arrayList);
                } else {
                    i = 0;
                }
                Triple numberBuffers2$default2 = getNumberBuffers2$default(this, this.DIGITAL_DIR + IOUtils.DIR_SEPARATOR_UNIX + this.digitalValueColor + IOUtils.DIR_SEPARATOR_UNIX + this.DIGITAL_DATE_DIR + IOUtils.DIR_SEPARATOR_UNIX, i, 2, null);
                int intValue3 = ((Number) numberBuffers2$default2.getFirst()).intValue();
                int intValue4 = ((Number) numberBuffers2$default2.getSecond()).intValue();
                byte[][] bArr2 = (byte[][]) ((Collection) numberBuffers2$default2.getThird()).toArray(new byte[i]);
                arrayList.add(new Element(7, 1, intValue3, intValue4, 9, this.ignoreBlack, (int) this.digitalDateMonthLeftX, (int) this.digitalDateMonthTopY, 0, 0, 0, bArr2, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
                arrayList.add(new Element(8, 1, intValue3, intValue4, 9, this.ignoreBlack, (int) this.digitalDateDayLeftX, (int) this.digitalDateDayTopY, 0, 0, 0, bArr2, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
                if (this.screenReservedBoundary != 0) {
                    getSymbol2(this.DIGITAL_DIR + IOUtils.DIR_SEPARATOR_UNIX + this.digitalValueColor + IOUtils.DIR_SEPARATOR_UNIX + this.DIGITAL_DATE_DIR, 21, (int) this.digitalDateSymbolLeftX, (int) this.digitalDateSymbolTopY, arrayList);
                }
                Triple<Integer, Integer, ArrayList<byte[]>> numberBuffers2 = getNumberBuffers2(this.DIGITAL_DIR + IOUtils.DIR_SEPARATOR_UNIX + this.digitalValueColor + IOUtils.DIR_SEPARATOR_UNIX + this.DIGITAL_WEEK_DIR + IOUtils.DIR_SEPARATOR_UNIX, 6);
                arrayList.add(new Element(13, 1, numberBuffers2.getFirst().intValue(), numberBuffers2.getSecond().intValue(), 9, this.ignoreBlack, (int) this.digitalWeekLeftX, (int) this.digitalWeekTopY, 0, 0, 0, (byte[][]) numberBuffers2.getThird().toArray(new byte[i]), SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, null));
            } finally {
            }
        } finally {
            try {
                throw th;
            } finally {
            }
        }
    }

    private final byte[] getTransparentBitmapByteArray() {
        Bitmap roundCorner;
        Bitmap scale = ImageUtils.scale(getBgBitmap(true, R.color.transparent), this.screenPreviewWidth / r0.getWidth(), this.screenPreviewHeight / r0.getHeight());
        if (this.isRound) {
            roundCorner = ImageUtils.toRound(scale, this.borderSize, getResources().getColor(R.color.transparent));
        } else {
            roundCorner = ImageUtils.toRoundCorner(scale, 30.0f, this.borderSize, getResources().getColor(R.color.transparent));
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        roundCorner.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        kotlin.jvm.internal.IIX0o.oO(byteArray, "toByteArray(...)");
        return byteArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(final BaseDialCustomizeActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity$initView$2$1

            /* loaded from: classes12.dex */
            public static final class oIX0oI implements xIXX {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public final /* synthetic */ BaseDialCustomizeActivity f22150oIX0oI;

                public oIX0oI(BaseDialCustomizeActivity baseDialCustomizeActivity) {
                    this.f22150oIX0oI = baseDialCustomizeActivity;
                }

                @Override // com.sma.smartv3.ui.device.dial.xIXX
                public void oIX0oI(int i) {
                    this.f22150oIX0oI.mCurSyncDevicePosition = i;
                    BaseDialCustomizeActivity baseDialCustomizeActivity = this.f22150oIX0oI;
                    baseDialCustomizeActivity.mCurSyncDialId = baseDialCustomizeActivity.mCurSyncDevicePosition + 10000000;
                    BleConnector.sendInt32$default(BleConnector.INSTANCE, BleKey.WATCHFACE_ID, BleKeyFlag.UPDATE, this.f22150oIX0oI.mCurSyncDialId, null, false, false, 56, null);
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
                DialPickerPopup dialPickerPopup;
                DialPickerPopup dialPickerPopup2;
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                BaseDialCustomizeActivity.this.disableOrientation();
                if (ProductManager.f20544oIX0oI.OOoOoO0o()) {
                    dialPickerPopup = BaseDialCustomizeActivity.this.dialPickerPopup;
                    if (dialPickerPopup == null || !dialPickerPopup.isShowing()) {
                        BaseDialCustomizeActivity baseDialCustomizeActivity = BaseDialCustomizeActivity.this;
                        BaseDialCustomizeActivity baseDialCustomizeActivity2 = BaseDialCustomizeActivity.this;
                        baseDialCustomizeActivity.dialPickerPopup = new DialPickerPopup(baseDialCustomizeActivity2, baseDialCustomizeActivity2.mDialIds, 0, new oIX0oI(BaseDialCustomizeActivity.this));
                        dialPickerPopup2 = BaseDialCustomizeActivity.this.dialPickerPopup;
                        if (dialPickerPopup2 != null) {
                            View rootView = BaseDialCustomizeActivity.this.getRootView();
                            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                            dialPickerPopup2.OxxIIOOXO(rootView);
                            return;
                        }
                        return;
                    }
                    return;
                }
                BaseDialCustomizeActivity.this.mCurSyncDevicePosition = 0;
                BaseDialCustomizeActivity baseDialCustomizeActivity3 = BaseDialCustomizeActivity.this;
                baseDialCustomizeActivity3.mCurSyncDialId = baseDialCustomizeActivity3.mCurSyncDevicePosition + 10000000;
                BaseDialCustomizeActivity.this.syncDial();
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(BaseDialCustomizeActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.showDragTip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void numberOnClick$lambda$10$lambda$8(com.sma.smartv3.pop.dial.oxoX this_apply, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this_apply, "$this_apply");
        this_apply.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void numberOnClick$lambda$10$lambda$9(BaseDialCustomizeActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getTimeDigitalView().setVisibility(0);
        this$0.getTimePointView().setVisibility(8);
        this$0.getTimeScaleView().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pointerOnClick$lambda$7$lambda$6(DialPointerPopup this_apply, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this_apply, "$this_apply");
        this_apply.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveRecord() {
        String str;
        if (this.mCurSendBytes == null) {
            return;
        }
        String str2 = BleCache.INSTANCE.getMBleName() + '_' + this.mCurSyncDialId + '_' + System.currentTimeMillis();
        if (TextUtils.isEmpty(this.mAiBgFile)) {
            str = this.paramName + this.is2DAcceleration + str2;
        } else {
            str = this.paramName + "/AI/" + str2;
        }
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        FileIOUtils.writeFileFromBytesByStream(new File(com.sma.smartv3.initializer.IXxxXO.oOXoIIIo(oix0oi), str + ".png"), getTransparentBitmapByteArray());
        FileIOUtils.writeFileFromBytesByStream(new File(com.sma.smartv3.initializer.IXxxXO.oOXoIIIo(oix0oi), str), this.mCurSendBytes);
        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24584O00XxXI, null, 2, null);
    }

    private final void selectImagePopup() {
        if (this.mSelectAvatarPopup == null) {
            com.sma.smartv3.pop.xx0X0 xx0x0 = new com.sma.smartv3.pop.xx0X0(this);
            xx0x0.xI(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity$selectImagePopup$1$1
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
                    mContext = BaseDialCustomizeActivity.this.getMContext();
                    final BaseDialCustomizeActivity baseDialCustomizeActivity = BaseDialCustomizeActivity.this;
                    permissionHelper.X0o0xo(mContext, new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity$selectImagePopup$1$1.1
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
                                mCrop = BaseDialCustomizeActivity.this.getMCrop();
                                mCrop.I0Io();
                            }
                        }
                    });
                }
            });
            xx0x0.ooXIXxIX(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity$selectImagePopup$1$2
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
                    mCrop = BaseDialCustomizeActivity.this.getMCrop();
                    mCrop.OOXIXo();
                }
            });
            this.mSelectAvatarPopup = xx0x0;
        }
        com.sma.smartv3.pop.xx0X0 xx0x02 = this.mSelectAvatarPopup;
        if (xx0x02 != null) {
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xx0x02.OxxIIOOXO(rootView);
        }
    }

    private final void showDragTip() {
        PopupWindow popupWindow = this.mDragPopup;
        if (popupWindow != null && popupWindow.isShowing()) {
            return;
        }
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_bubble, (ViewGroup) null);
        kotlin.jvm.internal.IIX0o.x0XOIxOo(inflate, "null cannot be cast to non-null type com.sma.smartv3.view.bubbleview.BubbleLayout");
        BubbleLayout bubbleLayout = (BubbleLayout) inflate;
        bubbleLayout.measure(0, 0);
        ((TextView) bubbleLayout.findViewById(R.id.tv)).setText(R.string.custom_dial_drag_tip);
        bubbleLayout.requestLayout();
        this.mDragPopup = OxO.II0xO0.oIX0oI(getMContext(), bubbleLayout);
        bubbleLayout.X0o0xo(ArrowDirection.BOTTOM);
        PopupWindow popupWindow2 = this.mDragPopup;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(popupWindow2);
        popupWindow2.setOutsideTouchable(true);
        PopupWindow popupWindow3 = this.mDragPopup;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(popupWindow3);
        popupWindow3.setWidth(getCustomizeDialBg().getMeasuredWidth() - SizeUtils.dp2px(20.0f));
        int dp2px = SizeUtils.dp2px(10.0f);
        int measuredHeight = ((-getCustomizeDialBg().getMeasuredHeight()) / 2) - bubbleLayout.getMeasuredHeight();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(this.mDragPopup);
        bubbleLayout.Oxx0IOOO((r3.getWidth() - bubbleLayout.getArrowWidth()) / 2.0f);
        PopupWindow popupWindow4 = this.mDragPopup;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(popupWindow4);
        popupWindow4.showAsDropDown(getCustomizeDialBg(), dp2px, measuredHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncDial() {
        if (this.mProgressPop == null) {
            com.sma.smartv3.pop.xOOOX xooox = new com.sma.smartv3.pop.xOOOX(this, 0, 2, null);
            xooox.xxX(R.string.dial_generated_start);
            xooox.XIxXXX0x0(0);
            this.mProgressPop = xooox;
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xooox.OxxIIOOXO(rootView);
            ArrayList<Element> arrayList = new ArrayList<>();
            if (this.isSupportConvertPng) {
                arrayList.add(new Element(1, 0, this.screenPreviewWidth, this.screenPreviewHeight, 0, this.ignoreBlack, 0, 0, 0, 0, 0, new byte[][]{getPreview$default(this, 0, 1, null)}, 1794, null));
                arrayList.add(new Element(2, 0, this.screenWidth, this.screenHeight + 1, 9, this.ignoreBlack, 0, 0, 0, 0, 0, new byte[][]{getBg()}, 1794, null));
                getControl2(arrayList);
                DialElementView timeDigitalView = getTimeDigitalView();
                kotlin.jvm.internal.IIX0o.oO(timeDigitalView, "<get-timeDigitalView>(...)");
                if (timeDigitalView.getVisibility() == 0) {
                    getTimeDigital2(arrayList);
                }
                ImageView timePointView = getTimePointView();
                kotlin.jvm.internal.IIX0o.oO(timePointView, "<get-timePointView>(...)");
                if (timePointView.getVisibility() == 0) {
                    if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPlatform(), BleDeviceInfo.PLATFORM_JL)) {
                        getPointer2(3, this.POINTER_HOUR, arrayList);
                        getPointer2(4, this.POINTER_MINUTE, arrayList);
                        getPointer2(5, this.POINTER_SECOND, arrayList);
                    } else {
                        getPointer3(3, this.POINTER_HOUR, arrayList);
                        getPointer3(4, this.POINTER_MINUTE, arrayList);
                        getPointer3(5, this.POINTER_SECOND, arrayList);
                    }
                }
            } else {
                arrayList.add(new Element(1, 0, this.screenPreviewWidth, this.screenPreviewHeight, this.X_CENTER | this.Y_CENTER, 0, this.screenWidth / 2, (this.screenHeight / 2) + 2, 0, 0, 0, new byte[][]{getPreview$default(this, 0, 1, null)}, 1826, null));
                byte[] bg = getBg();
                int i = this.screenWidth;
                int i2 = this.screenHeight;
                arrayList.add(new Element(2, 0, i, i2, this.X_CENTER | this.Y_CENTER, 0, i / 2, i2 / 2, 0, 0, 0, new byte[][]{bg}, 1826, null));
                getControl(arrayList);
                DialElementView timeDigitalView2 = getTimeDigitalView();
                kotlin.jvm.internal.IIX0o.oO(timeDigitalView2, "<get-timeDigitalView>(...)");
                if (timeDigitalView2.getVisibility() == 0) {
                    getTimeDigital(arrayList);
                }
                ImageView timePointView2 = getTimePointView();
                kotlin.jvm.internal.IIX0o.oO(timePointView2, "<get-timePointView>(...)");
                if (timePointView2.getVisibility() == 0) {
                    getPointer(3, this.POINTER_HOUR, arrayList);
                    getPointer(4, this.POINTER_MINUTE, arrayList);
                    getPointer(5, this.POINTER_SECOND, arrayList);
                }
            }
            com.sma.smartv3.pop.xOOOX xooox2 = this.mProgressPop;
            if (xooox2 != null) {
                xooox2.xxX(R.string.dial_generated_sync);
            }
            Iterator<Element> it = arrayList.iterator();
            while (it.hasNext()) {
                Element next = it.next();
                LogUtils.d("customize dial length: " + (((((byte[]) ArraysKt___ArraysKt.XXOXXx(next.getImageBuffers())).length * 10) / 1024) / 10.0d) + " KB");
            }
            byte[] build = WatchFaceBuilder.INSTANCE.build((Element[]) arrayList.toArray(new Element[0]), this.imageFormat);
            this.mCurSendBytes = build;
            X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
            File xxX2 = com.sma.smartv3.initializer.IXxxXO.xxX(oix0oi);
            File IoOoX2 = com.sma.smartv3.initializer.IXxxXO.IoOoX(oix0oi);
            StringBuilder sb = new StringBuilder();
            BleCache bleCache = BleCache.INSTANCE;
            sb.append(bleCache.getMPrototype());
            sb.append('_');
            sb.append(bleCache.getMBleName());
            sb.append('_');
            sb.append(this.mCurSyncDialId);
            sb.append(".png");
            FileUtils.copy(xxX2, new File(IoOoX2, sb.toString()));
            LogUtils.d(this.mCurSyncDevicePosition + " customize dial bytes size  " + build.length);
            BleConnector.INSTANCE.sendStream(BleKey.WATCH_FACE, build, this.mCurSyncDevicePosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncFailed(int i) {
        com.sma.smartv3.pop.xOOOX xooox = this.mProgressPop;
        if (xooox != null) {
            xooox.dismiss();
        }
        this.mProgressPop = null;
        ToastUtils.showLong(com.sma.smartv3.util.oO.f24511oIX0oI.I0Io(i), new Object[0]);
    }

    public static /* synthetic */ void syncFailed$default(BaseDialCustomizeActivity baseDialCustomizeActivity, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = 0;
            }
            baseDialCustomizeActivity.syncFailed(i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: syncFailed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toCropPic(Uri uri) {
        int i = this.screenWidth;
        int i2 = this.screenHeight;
        if (i < 320) {
            i *= 2;
            i2 *= 2;
        }
        int i3 = i;
        int i4 = i2;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("toCropPic outputX:" + i3 + " outputY:" + i4 + TokenParser.SP + uri);
        getMCrop().X0o0xo(uri, 1.0d, ((double) i3) / ((double) i4), i3, i4);
    }

    public final void bgOnClick(@OXOo.OOXIXo View view) {
        List ooXIXxIX2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (TextUtils.isEmpty(this.mAiBgFile)) {
            if (this.mBgPopup == null) {
                final com.sma.smartv3.pop.dial.II0xO0 iI0xO0 = new com.sma.smartv3.pop.dial.II0xO0(this);
                iI0xO0.xXxxox0I().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.o00
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        BaseDialCustomizeActivity.bgOnClick$lambda$3$lambda$2(com.sma.smartv3.pop.dial.II0xO0.this, this, view2);
                    }
                });
                customizeDialBgItemClick(iI0xO0);
                this.mBgPopup = iI0xO0;
            }
            com.sma.smartv3.pop.dial.II0xO0 iI0xO02 = this.mBgPopup;
            if (iI0xO02 != null) {
                View rootView = getRootView();
                kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                iI0xO02.OxxIIOOXO(rootView);
                return;
            }
            return;
        }
        SPUtils oxoX2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX();
        String path = com.sma.smartv3.initializer.IXxxXO.Oxx0IOOO(X00IoxXI.oIX0oI.f3233oIX0oI).getPath();
        kotlin.jvm.internal.IIX0o.oO(path, "getPath(...)");
        try {
            JsonArray asJsonArray = JsonParser.parseString(oxoX2.getString(path)).getAsJsonArray();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(asJsonArray);
            ooXIXxIX2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(asJsonArray, 10));
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                ooXIXxIX2.add(new Gson().fromJson(it.next(), String.class));
            }
        } catch (Exception unused) {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        if (this.mBgFilePickerPopup == null) {
            final DialBgFilePickerPopup dialBgFilePickerPopup = new DialBgFilePickerPopup(this, ooXIXxIX2, new oIX0oI(ooXIXxIX2));
            dialBgFilePickerPopup.O0xOxO().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.ooOOo0oXI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BaseDialCustomizeActivity.bgOnClick$lambda$5$lambda$4(DialBgFilePickerPopup.this, this, view2);
                }
            });
            this.mBgFilePickerPopup = dialBgFilePickerPopup;
        }
        DialBgFilePickerPopup dialBgFilePickerPopup2 = this.mBgFilePickerPopup;
        if (dialBgFilePickerPopup2 != null) {
            View rootView2 = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView2, "<get-rootView>(...)");
            dialBgFilePickerPopup2.OxxIIOOXO(rootView2);
        }
    }

    @OXOo.OOXIXo
    public byte[] bitmap2Bytes(@OXOo.OOXIXo Bitmap finalBgBitMap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(finalBgBitMap, "finalBgBitMap");
        byte[] bitmap2Bytes = ImageUtils.bitmap2Bytes(finalBgBitMap);
        kotlin.jvm.internal.IIX0o.oO(bitmap2Bytes, "bitmap2Bytes(...)");
        return bitmap2Bytes;
    }

    public final void controlOnClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mControlPopup == null) {
            final com.sma.smartv3.pop.dial.I0Io i0Io = new com.sma.smartv3.pop.dial.I0Io(this, getColors(), new II0xO0());
            i0Io.XI0IXoo().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.Oxx0xo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BaseDialCustomizeActivity.controlOnClick$lambda$16$lambda$11(com.sma.smartv3.pop.dial.I0Io.this, view2);
                }
            });
            i0Io.XIxXXX0x0().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.oI0IIXIo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BaseDialCustomizeActivity.controlOnClick$lambda$16$lambda$12(BaseDialCustomizeActivity.this, i0Io, view2);
                }
            });
            i0Io.xxX().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.OxxIIOOXO
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BaseDialCustomizeActivity.controlOnClick$lambda$16$lambda$13(BaseDialCustomizeActivity.this, i0Io, view2);
                }
            });
            i0Io.XxX0x0xxx().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.IIXOooo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BaseDialCustomizeActivity.controlOnClick$lambda$16$lambda$14(BaseDialCustomizeActivity.this, i0Io, view2);
                }
            });
            i0Io.xXxxox0I().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.xoXoI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BaseDialCustomizeActivity.controlOnClick$lambda$16$lambda$15(BaseDialCustomizeActivity.this, i0Io, view2);
                }
            });
            this.mControlPopup = i0Io;
        }
        com.sma.smartv3.pop.dial.I0Io i0Io2 = this.mControlPopup;
        if (i0Io2 != null) {
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            i0Io2.OxxIIOOXO(rootView);
        }
    }

    public abstract void customizeDialBgItemClick(@OXOo.OOXIXo com.sma.smartv3.pop.dial.II0xO0 iI0xO0);

    @OXOo.OOXIXo
    public abstract Object customizeDir();

    public final PFMedium getAbhTitleCenter() {
        return (PFMedium) this.abhTitleCenter$delegate.getValue();
    }

    public final float getAmLeftX() {
        return this.amLeftX;
    }

    public final float getAmTopY() {
        return this.amTopY;
    }

    @OXOo.oOoXoXO
    public final String getBgFile() {
        return this.bgFile;
    }

    public final int getBorderSize() {
        return this.borderSize;
    }

    public final float getCaloriesValueCenterX() {
        return this.caloriesValueCenterX;
    }

    public final float getCaloriesValueCenterY() {
        return this.caloriesValueCenterY;
    }

    @OXOo.OOXIXo
    public final List<ResourcesIdInfo> getColors() {
        return (List) this.colors$delegate.getValue();
    }

    public final int getControlValueInterval() {
        return this.controlValueInterval;
    }

    public final int getControlValueRange() {
        return this.controlValueRange;
    }

    public final DialElementView getControlViewCa() {
        return (DialElementView) this.controlViewCa$delegate.getValue();
    }

    public final DialElementView getControlViewDis() {
        return (DialElementView) this.controlViewDis$delegate.getValue();
    }

    public final DialElementView getControlViewHr() {
        return (DialElementView) this.controlViewHr$delegate.getValue();
    }

    public final DialElementView getControlViewStep() {
        return (DialElementView) this.controlViewStep$delegate.getValue();
    }

    public final ImageViewRound getCustomizeDialBg() {
        return (ImageViewRound) this.customizeDialBg$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final String getDIGITAL_AM_DIR() {
        return this.DIGITAL_AM_DIR;
    }

    @OXOo.OOXIXo
    public final String getDIGITAL_DATE_DIR() {
        return this.DIGITAL_DATE_DIR;
    }

    @OXOo.OOXIXo
    public final String getDIGITAL_HOUR_MINUTE_DIR() {
        return this.DIGITAL_HOUR_MINUTE_DIR;
    }

    @OXOo.OOXIXo
    public final String getDIGITAL_WEEK_DIR() {
        return this.DIGITAL_WEEK_DIR;
    }

    public final float getDigitalDateDayLeftX() {
        return this.digitalDateDayLeftX;
    }

    public final float getDigitalDateDayTopY() {
        return this.digitalDateDayTopY;
    }

    public final float getDigitalDateMonthLeftX() {
        return this.digitalDateMonthLeftX;
    }

    public final float getDigitalDateMonthTopY() {
        return this.digitalDateMonthTopY;
    }

    public final float getDigitalDateSymbolLeftX() {
        return this.digitalDateSymbolLeftX;
    }

    public final float getDigitalDateSymbolTopY() {
        return this.digitalDateSymbolTopY;
    }

    public final float getDigitalTimeHourLeftX() {
        return this.digitalTimeHourLeftX;
    }

    public final float getDigitalTimeHourTopY() {
        return this.digitalTimeHourTopY;
    }

    public final float getDigitalTimeMinuteLeftX() {
        return this.digitalTimeMinuteLeftX;
    }

    public final float getDigitalTimeMinuteRightX() {
        return this.digitalTimeMinuteRightX;
    }

    public final float getDigitalTimeMinuteTopY() {
        return this.digitalTimeMinuteTopY;
    }

    public final float getDigitalTimeSymbolLeftX() {
        return this.digitalTimeSymbolLeftX;
    }

    public final float getDigitalTimeSymbolTopY() {
        return this.digitalTimeSymbolTopY;
    }

    @OXOo.OOXIXo
    public final List<ResourcesIdInfo> getDigitalTimes() {
        return (List) this.digitalTimes$delegate.getValue();
    }

    public final int getDigitalValueColor() {
        return this.digitalValueColor;
    }

    public final float getDigitalWeekLeftX() {
        return this.digitalWeekLeftX;
    }

    public final float getDigitalWeekTopY() {
        return this.digitalWeekTopY;
    }

    public final float getDistanceValueCenterX() {
        return this.distanceValueCenterX;
    }

    public final float getDistanceValueCenterY() {
        return this.distanceValueCenterY;
    }

    @OXOo.OOXIXo
    public final String getFileFormat() {
        return this.fileFormat;
    }

    @OXOo.OOXIXo
    public abstract Bitmap getFinalBgBitmap(@OXOo.OOXIXo Bitmap bitmap);

    public final float getHeartRateValueCenterX() {
        return this.heartRateValueCenterX;
    }

    public final float getHeartRateValueCenterY() {
        return this.heartRateValueCenterY;
    }

    public final int getIgnoreBlack() {
        return this.ignoreBlack;
    }

    public final int getImageFormat() {
        return this.imageFormat;
    }

    @OXOo.oOoXoXO
    public final byte[] getMCurSendBytes() {
        return this.mCurSendBytes;
    }

    public final NestedScrollView getNestedScrollView() {
        return (NestedScrollView) this.nestedScrollView$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final String getPOINTER_HOUR() {
        return this.POINTER_HOUR;
    }

    @OXOo.OOXIXo
    public final String getPOINTER_MINUTE() {
        return this.POINTER_MINUTE;
    }

    @OXOo.OOXIXo
    public final String getPOINTER_SECOND() {
        return this.POINTER_SECOND;
    }

    @OXOo.OOXIXo
    public final String getParamName() {
        return this.paramName;
    }

    public final int getPointerSelectNumber() {
        return this.pointerSelectNumber;
    }

    @OXOo.OOXIXo
    public List<ResourcesIdInfo> getPointers() {
        return (List) this.pointers$delegate.getValue();
    }

    public final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    public final float getRoundCornerRadius() {
        return this.roundCornerRadius;
    }

    public final Button getSaveDial() {
        return (Button) this.saveDial$delegate.getValue();
    }

    public final int getScaleSelectNumber() {
        return this.scaleSelectNumber;
    }

    @OXOo.OOXIXo
    public final List<ResourcesIdInfo> getScales() {
        return this.scales;
    }

    public final int getScreenHeight() {
        return this.screenHeight;
    }

    public final int getScreenPreviewHeight() {
        return this.screenPreviewHeight;
    }

    public final int getScreenPreviewWidth() {
        return this.screenPreviewWidth;
    }

    public final int getScreenReservedBoundary() {
        return this.screenReservedBoundary;
    }

    public final int getScreenWidth() {
        return this.screenWidth;
    }

    public final float getStepValueCenterX() {
        return this.stepValueCenterX;
    }

    public final float getStepValueCenterY() {
        return this.stepValueCenterY;
    }

    public final DialElementView getTimeDigitalView() {
        return (DialElementView) this.timeDigitalView$delegate.getValue();
    }

    public final ImageView getTimePointView() {
        return (ImageView) this.timePointView$delegate.getValue();
    }

    public final ImageView getTimeScaleView() {
        return (ImageView) this.timeScaleView$delegate.getValue();
    }

    public final int getValueColor() {
        return this.valueColor;
    }

    public final int getX_CENTER() {
        return this.X_CENTER;
    }

    public final int getY_CENTER() {
        return this.Y_CENTER;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        BleConnector bleConnector = BleConnector.INSTANCE;
        bleConnector.addHandleCallback(this.mBleHandleCallback);
        LogUtils.d("BaseDialCustomizeActivity -> init -> " + LibExKt.x0xO0oo(this));
        if (ProductManager.f20544oIX0oI.OOoOoO0o()) {
            BleConnector.sendData$default(bleConnector, BleKey.WATCHFACE_ID, BleKeyFlag.READ, null, false, false, 28, null);
        }
    }

    public void initView() {
        getAbhTitleCenter().setText(R.string.dial_customize);
        getMCrop().ooOOo0oXI(this, new Oox.oOoXoXO<Uri, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dial.BaseDialCustomizeActivity$initView$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Uri uri) {
                invoke2(uri);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo Uri it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                BaseDialCustomizeActivity.this.toCropPic(it);
            }
        });
        DialElementView controlViewStep = getControlViewStep();
        NestedScrollView nestedScrollView = getNestedScrollView();
        kotlin.jvm.internal.IIX0o.oO(nestedScrollView, "<get-nestedScrollView>(...)");
        controlViewStep.setScrollView(nestedScrollView);
        DialElementView controlViewHr = getControlViewHr();
        NestedScrollView nestedScrollView2 = getNestedScrollView();
        kotlin.jvm.internal.IIX0o.oO(nestedScrollView2, "<get-nestedScrollView>(...)");
        controlViewHr.setScrollView(nestedScrollView2);
        DialElementView controlViewCa = getControlViewCa();
        NestedScrollView nestedScrollView3 = getNestedScrollView();
        kotlin.jvm.internal.IIX0o.oO(nestedScrollView3, "<get-nestedScrollView>(...)");
        controlViewCa.setScrollView(nestedScrollView3);
        DialElementView controlViewDis = getControlViewDis();
        NestedScrollView nestedScrollView4 = getNestedScrollView();
        kotlin.jvm.internal.IIX0o.oO(nestedScrollView4, "<get-nestedScrollView>(...)");
        controlViewDis.setScrollView(nestedScrollView4);
        DialElementView timeDigitalView = getTimeDigitalView();
        NestedScrollView nestedScrollView5 = getNestedScrollView();
        kotlin.jvm.internal.IIX0o.oO(nestedScrollView5, "<get-nestedScrollView>(...)");
        timeDigitalView.setScrollView(nestedScrollView5);
        getControlViewStep().setIsRangeCircle(this.isRound);
        getControlViewHr().setIsRangeCircle(this.isRound);
        getControlViewCa().setIsRangeCircle(this.isRound);
        getControlViewDis().setIsRangeCircle(this.isRound);
        getTimeDigitalView().setIsRangeCircle(this.isRound);
        getSaveDial().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.oOoXoXO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseDialCustomizeActivity.initView$lambda$0(BaseDialCustomizeActivity.this, view);
            }
        });
        String stringExtra = getIntent().getStringExtra("bgFile");
        this.mAiBgFile = stringExtra;
        if (stringExtra != null) {
            Uri fromFile = Uri.fromFile(new File(this.mAiBgFile));
            kotlin.jvm.internal.IIX0o.oO(fromFile, "fromFile(...)");
            toCropPic(fromFile);
        }
        if (ProductManager.f20544oIX0oI.xIXIOX()) {
            new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.dial.oO
                @Override // java.lang.Runnable
                public final void run() {
                    BaseDialCustomizeActivity.initView$lambda$1(BaseDialCustomizeActivity.this);
                }
            }, 500L);
        }
    }

    @OXOo.OOXIXo
    public final String is2DAcceleration() {
        return this.is2DAcceleration;
    }

    public final boolean isRound() {
        return this.isRound;
    }

    public final boolean isSupportConvertPng() {
        return this.isSupportConvertPng;
    }

    public final void numberOnClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mDigitalPopup == null) {
            final com.sma.smartv3.pop.dial.oxoX oxox = new com.sma.smartv3.pop.dial.oxoX(this, getColors(), new oxoX());
            oxox.XI0IXoo().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.x0xO0oo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BaseDialCustomizeActivity.numberOnClick$lambda$10$lambda$8(com.sma.smartv3.pop.dial.oxoX.this, view2);
                }
            });
            oxox.XIxXXX0x0().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.IXxxXO
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BaseDialCustomizeActivity.numberOnClick$lambda$10$lambda$9(BaseDialCustomizeActivity.this, view2);
                }
            });
            this.mDigitalPopup = oxox;
        }
        com.sma.smartv3.pop.dial.oxoX oxox2 = this.mDigitalPopup;
        if (oxox2 != null) {
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            oxox2.OxxIIOOXO(rootView);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        Uri uri;
        super.onActivityResult(i, i2, intent);
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityResult ");
        sb.append(i);
        sb.append(TokenParser.SP);
        sb.append(i2);
        sb.append(TokenParser.SP);
        if (intent != null) {
            uri = intent.getData();
        } else {
            uri = null;
        }
        sb.append(uri);
        LogUtils.d(sb.toString());
        int i3 = this.screenWidth;
        int i4 = this.screenHeight;
        if (i3 < 320) {
            i3 *= 2;
            i4 *= 2;
        }
        int i5 = i3;
        int i6 = i4;
        LogUtils.d("onActivityResult outputX:" + i5 + " outputY:" + i6);
        getMCrop().Oxx0IOOO(i, i2, intent, 1.0d, ((double) i5) / ((double) i6), i5, i6);
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
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mProgressPop != null) {
            ToastUtils.showLong(R.string.syncing);
        } else {
            finish();
        }
    }

    public void pointerOnClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mPointerPopup == null) {
            final DialPointerPopup dialPointerPopup = new DialPointerPopup(this, getPointers(), this.scales, new X0o0xo());
            dialPointerPopup.O0xOxO().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.x0XOIxOo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BaseDialCustomizeActivity.pointerOnClick$lambda$7$lambda$6(DialPointerPopup.this, view2);
                }
            });
            this.mPointerPopup = dialPointerPopup;
        }
        DialPointerPopup dialPointerPopup2 = this.mPointerPopup;
        if (dialPointerPopup2 != null) {
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            dialPointerPopup2.OxxIIOOXO(rootView);
        }
    }

    @OXOo.OOXIXo
    public abstract List<ResourcesIdInfo> scalesList();

    public final void setAmLeftX(float f) {
        this.amLeftX = f;
    }

    public final void setAmTopY(float f) {
        this.amTopY = f;
    }

    public final void setBgFile(@OXOo.oOoXoXO String str) {
        this.bgFile = str;
    }

    public final void setBorderSize(int i) {
        this.borderSize = i;
    }

    public final void setCaloriesValueCenterX(float f) {
        this.caloriesValueCenterX = f;
    }

    public final void setCaloriesValueCenterY(float f) {
        this.caloriesValueCenterY = f;
    }

    public final void setControlValueInterval(int i) {
        this.controlValueInterval = i;
    }

    public final void setControlValueRange(int i) {
        this.controlValueRange = i;
    }

    public final void setDigitalDateDayLeftX(float f) {
        this.digitalDateDayLeftX = f;
    }

    public final void setDigitalDateDayTopY(float f) {
        this.digitalDateDayTopY = f;
    }

    public final void setDigitalDateMonthLeftX(float f) {
        this.digitalDateMonthLeftX = f;
    }

    public final void setDigitalDateMonthTopY(float f) {
        this.digitalDateMonthTopY = f;
    }

    public final void setDigitalDateSymbolLeftX(float f) {
        this.digitalDateSymbolLeftX = f;
    }

    public final void setDigitalDateSymbolTopY(float f) {
        this.digitalDateSymbolTopY = f;
    }

    public final void setDigitalTimeHourLeftX(float f) {
        this.digitalTimeHourLeftX = f;
    }

    public final void setDigitalTimeHourTopY(float f) {
        this.digitalTimeHourTopY = f;
    }

    public final void setDigitalTimeMinuteLeftX(float f) {
        this.digitalTimeMinuteLeftX = f;
    }

    public final void setDigitalTimeMinuteRightX(float f) {
        this.digitalTimeMinuteRightX = f;
    }

    public final void setDigitalTimeMinuteTopY(float f) {
        this.digitalTimeMinuteTopY = f;
    }

    public final void setDigitalTimeSymbolLeftX(float f) {
        this.digitalTimeSymbolLeftX = f;
    }

    public final void setDigitalTimeSymbolTopY(float f) {
        this.digitalTimeSymbolTopY = f;
    }

    public final void setDigitalValueColor(int i) {
        this.digitalValueColor = i;
    }

    public final void setDigitalWeekLeftX(float f) {
        this.digitalWeekLeftX = f;
    }

    public final void setDigitalWeekTopY(float f) {
        this.digitalWeekTopY = f;
    }

    public final void setDistanceValueCenterX(float f) {
        this.distanceValueCenterX = f;
    }

    public final void setDistanceValueCenterY(float f) {
        this.distanceValueCenterY = f;
    }

    public final void setFileFormat(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.fileFormat = str;
    }

    public final void setHeartRateValueCenterX(float f) {
        this.heartRateValueCenterX = f;
    }

    public final void setHeartRateValueCenterY(float f) {
        this.heartRateValueCenterY = f;
    }

    public final void setIgnoreBlack(int i) {
        this.ignoreBlack = i;
    }

    public final void setImageFormat(int i) {
        this.imageFormat = i;
    }

    public final void setMCurSendBytes(@OXOo.oOoXoXO byte[] bArr) {
        this.mCurSendBytes = bArr;
    }

    public final void setPointerSelectNumber(int i) {
        this.pointerSelectNumber = i;
    }

    public final void setRound(boolean z) {
        this.isRound = z;
    }

    public final void setRoundCornerRadius(float f) {
        this.roundCornerRadius = f;
    }

    public final void setScaleSelectNumber(int i) {
        this.scaleSelectNumber = i;
    }

    public final void setScreenHeight(int i) {
        this.screenHeight = i;
    }

    public final void setScreenPreviewHeight(int i) {
        this.screenPreviewHeight = i;
    }

    public final void setScreenPreviewWidth(int i) {
        this.screenPreviewWidth = i;
    }

    public final void setScreenReservedBoundary(int i) {
        this.screenReservedBoundary = i;
    }

    public final void setScreenWidth(int i) {
        this.screenWidth = i;
    }

    public final void setStepValueCenterX(float f) {
        this.stepValueCenterX = f;
    }

    public final void setStepValueCenterY(float f) {
        this.stepValueCenterY = f;
    }

    public final void setSupportConvertPng(boolean z) {
        this.isSupportConvertPng = z;
    }

    public final void setValueColor(int i) {
        this.valueColor = i;
    }

    public final void setX_CENTER(int i) {
        this.X_CENTER = i;
    }

    public final void setY_CENTER(int i) {
        this.Y_CENTER = i;
    }
}
