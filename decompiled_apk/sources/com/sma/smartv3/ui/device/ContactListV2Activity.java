package com.sma.smartv3.ui.device;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.angcyo.dsladapter.SwipeMenuHelper;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity;
import com.bestmafen.baseble.data.ByteArrayExtKt;
import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.Contact;
import com.sma.smartv3.ui.contactpicker.ContactPicker;
import com.sma.smartv3.ui.contactpicker.ContactResult;
import com.sma.smartv3.ui.contactpicker.LimitColumn;
import com.sma.smartv3.ui.contactpicker.PhoneNumber;
import com.sma.smartv3.util.II0XooXoX;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.view.ContactSideBar;
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
import com.szabh.smable3.entity.BleContactSort;
import com.szabh.smable3.entity.BleContactSortItem;
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
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

@kotlin.jvm.internal.XX({"SMAP\nContactListV2Activity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactListV2Activity.kt\ncom/sma/smartv3/ui/device/ContactListV2Activity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,442:1\n73#2,5:443\n78#2:451\n80#2,2:453\n73#2,5:458\n78#2:466\n80#2,2:468\n1549#3:448\n1620#3,2:449\n1622#3:452\n766#3:455\n857#3,2:456\n1549#3:463\n1620#3,2:464\n1622#3:467\n1855#3,2:470\n1855#3,2:491\n1855#3,2:493\n1855#3,2:495\n65#4,16:472\n93#4,3:488\n*S KotlinDebug\n*F\n+ 1 ContactListV2Activity.kt\ncom/sma/smartv3/ui/device/ContactListV2Activity\n*L\n125#1:443,5\n125#1:451\n125#1:453,2\n131#1:458,5\n131#1:466\n131#1:468,2\n125#1:448\n125#1:449,2\n125#1:452\n125#1:455\n125#1:456,2\n131#1:463\n131#1:464,2\n131#1:467\n237#1:470,2\n349#1:491,2\n392#1:493,2\n422#1:495,2\n284#1:472,16\n284#1:488,3\n*E\n"})
/* loaded from: classes12.dex */
public final class ContactListV2Activity extends BaseDSLRecyclerActivity {
    private boolean deleting;

    @OXOo.oOoXoXO
    private com.sma.smartv3.util.xoIxX pinyinComparator;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.ContactListV2Activity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ContactListV2Activity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.ContactListV2Activity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) ContactListV2Activity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private List<ContactResult> mList = new ArrayList();

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mEditText$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.device.ContactListV2Activity$mEditText$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) ContactListV2Activity.this.findViewById(R.id.contact_list_et);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mContactBar$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ContactSideBar>() { // from class: com.sma.smartv3.ui.device.ContactListV2Activity$mContactBar$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ContactSideBar invoke() {
            return (ContactSideBar) ContactListV2Activity.this.findViewById(R.id.contact_list_contact_sidebar);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mLinearLayout$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.device.ContactListV2Activity$mLinearLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) ContactListV2Activity.this.findViewById(R.id.ll_data);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mEmptyLayout$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.device.ContactListV2Activity$mEmptyLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) ContactListV2Activity.this.findViewById(R.id.empty);
        }
    });

    @OXOo.OOXIXo
    private final ArrayList<ContactResult> tmps = new ArrayList<>();

    @OXOo.OOXIXo
    private final ArrayList<String> tipBars = new ArrayList<>();

    @OXOo.OOXIXo
    private final List<ContactResult> lastData = new ArrayList();

    @OXOo.OOXIXo
    private final oIX0oI bleHandleCallback = new oIX0oI();

    @kotlin.jvm.internal.XX({"SMAP\nContactListV2Activity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactListV2Activity.kt\ncom/sma/smartv3/ui/device/ContactListV2Activity$initView$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,442:1\n1864#2,3:443\n*S KotlinDebug\n*F\n+ 1 ContactListV2Activity.kt\ncom/sma/smartv3/ui/device/ContactListV2Activity$initView$1\n*L\n273#1:443,3\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class I0Io implements ContactSideBar.II0xO0 {
        public I0Io() {
        }

        @Override // com.sma.smartv3.view.ContactSideBar.II0xO0
        public void oIX0oI(@OXOo.oOoXoXO String str) {
            if (str != null && str.length() > 0 && ContactListV2Activity.this.tipBars.contains(str)) {
                List list = ContactListV2Activity.this.mList;
                ContactListV2Activity contactListV2Activity = ContactListV2Activity.this;
                int i = 0;
                for (Object obj : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt__CollectionsKt.XoX();
                    }
                    if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(((ContactResult) obj).getItemGroups(), str) && contactListV2Activity.tipBars.indexOf(str) > -1) {
                        contactListV2Activity.getRecyclerView().scrollToPosition(i + contactListV2Activity.tipBars.indexOf(str));
                        return;
                    }
                    i = i2;
                }
            }
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 ContactListV2Activity.kt\ncom/sma/smartv3/ui/device/ContactListV2Activity\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 5 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n286#2:98\n287#2,5:102\n766#3:99\n857#3,2:100\n71#4:107\n77#5:108\n*S KotlinDebug\n*F\n+ 1 ContactListV2Activity.kt\ncom/sma/smartv3/ui/device/ContactListV2Activity\n*L\n286#1:99\n286#1:100,2\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class II0xO0 implements TextWatcher {
        public II0xO0() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
            List list = ContactListV2Activity.this.mList;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                String displayName = ((ContactResult) obj).getDisplayName();
                kotlin.jvm.internal.IIX0o.oO(displayName, "getDisplayName(...)");
                if (StringsKt__StringsKt.o00xOoIO(displayName, String.valueOf(editable), false, 2, null)) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                ContactListV2Activity.this.showData(CollectionsKt___CollectionsKt.o0Xo0XII(arrayList));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nContactListV2Activity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactListV2Activity.kt\ncom/sma/smartv3/ui/device/ContactListV2Activity$bleHandleCallback$1\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,442:1\n63#2,6:443\n63#2,6:449\n*S KotlinDebug\n*F\n+ 1 ContactListV2Activity.kt\ncom/sma/smartv3/ui/device/ContactListV2Activity$bleHandleCallback$1\n*L\n100#1:443,6\n112#1:449,6\n*E\n"})
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
            kotlin.jvm.internal.IIX0o.x0xO0oo(bleKey, "bleKey");
            kotlin.jvm.internal.IIX0o.x0xO0oo(bleKeyFlag, "bleKeyFlag");
            if (bleKey == BleKey.CONTACT && bleKeyFlag == BleKeyFlag.DELETE) {
                LogUtils.d(" onCommandReply");
                ContactListV2Activity.this.mList.clear();
                ContactListV2Activity contactListV2Activity = ContactListV2Activity.this;
                contactListV2Activity.showData(contactListV2Activity.filledData(contactListV2Activity.mList));
                SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
                List list = ContactListV2Activity.this.mList;
                String str = ContactResult.class.getName() + oOXoIIIo.XO.f32008oIX0oI;
                String json = new Gson().toJson(list);
                kotlin.jvm.internal.IIX0o.oO(json, "toJson(...)");
                byte[] bytes = json.getBytes(kotlin.text.oxoX.f29581II0xO0);
                kotlin.jvm.internal.IIX0o.oO(bytes, "getBytes(...)");
                XO2.put(str, EncodeUtils.base64Encode2String(bytes));
            }
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
            kotlin.jvm.internal.IIX0o.x0xO0oo(bleKey, "bleKey");
            if (bleKey == BleKey.CONTACT) {
                ContactListV2Activity contactListV2Activity = ContactListV2Activity.this;
                contactListV2Activity.sendContactSortStream(contactListV2Activity.lastData);
                return;
            }
            if (bleKey == BleKey.CONTACT_SORT) {
                if (!z || i2 == i3) {
                    LogUtils.d(" onStreamProgress " + ContactListV2Activity.this.tmps.size());
                    ContactListV2Activity.this.mList.clear();
                    ContactListV2Activity.this.mList.addAll(ContactListV2Activity.this.tmps);
                    ContactListV2Activity contactListV2Activity2 = ContactListV2Activity.this;
                    contactListV2Activity2.showData(contactListV2Activity2.filledData(contactListV2Activity2.mList));
                    SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
                    List list = ContactListV2Activity.this.mList;
                    String str = ContactResult.class.getName() + oOXoIIIo.XO.f32008oIX0oI;
                    String json = new Gson().toJson(list);
                    kotlin.jvm.internal.IIX0o.oO(json, "toJson(...)");
                    byte[] bytes = json.getBytes(kotlin.text.oxoX.f29581II0xO0);
                    kotlin.jvm.internal.IIX0o.oO(bytes, "getBytes(...)");
                    XO2.put(str, EncodeUtils.base64Encode2String(bytes));
                }
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void filterData(List<ContactResult> list) {
        for (ContactResult contactResult : list) {
            List<PhoneNumber> phoneNumbers = contactResult.getPhoneNumbers();
            kotlin.jvm.internal.IIX0o.oO(phoneNumbers, "getPhoneNumbers(...)");
            if (!phoneNumbers.isEmpty()) {
                String number = contactResult.getPhoneNumbers().get(0).getNumber();
                String displayName = contactResult.getDisplayName();
                if (number != null && number.length() > 0) {
                    number = TextConvertKt.XX(number);
                }
                if (displayName != null && displayName.length() > 0) {
                    displayName = TextConvertKt.o0(displayName);
                }
                contactResult.setDisplayName(displayName);
                contactResult.getPhoneNumbers().get(0).setNumber(number);
            }
        }
    }

    private final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    private final ContactSideBar getMContactBar() {
        return (ContactSideBar) this.mContactBar$delegate.getValue();
    }

    private final EditText getMEditText() {
        return (EditText) this.mEditText$delegate.getValue();
    }

    private final LinearLayout getMEmptyLayout() {
        return (LinearLayout) this.mEmptyLayout$delegate.getValue();
    }

    private final LinearLayout getMLinearLayout() {
        return (LinearLayout) this.mLinearLayout$delegate.getValue();
    }

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(final ContactListV2Activity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.ContactListV2Activity$initView$3$1
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
                ContactListV2Activity.this.tmps.addAll(ContactListV2Activity.this.mList);
                ContactListV2Activity contactListV2Activity = ContactListV2Activity.this;
                contactListV2Activity.syncContact(contactListV2Activity.tmps);
            }
        }, 1, null);
    }

    private final void pickContact() {
        new ContactPicker.Builder(this).hideScrollbar(false).setMaxSelectCount(ProductManager.f20544oIX0oI.OI0()).showTrack(true).searchIconColor(-1).setChoiceMode(0).bubbleTextColor(-1).setTitleText(getString(R.string.picker_title)).setLoadingType(1).setSelectedContacts(new ArrayList<>(this.mList)).limitToColumn(LimitColumn.PHONE).showPickerForResult(991);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendContactSortStream(List<? extends ContactResult> list) {
        int i;
        ArrayList arrayList = new ArrayList();
        String str = "";
        loop0: while (true) {
            i = 1;
            for (ContactResult contactResult : list) {
                if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(str, contactResult.getItemGroups())) {
                    i++;
                } else {
                    if (str.length() > 0) {
                        arrayList.add(new BleContactSortItem(str, i));
                    }
                    str = contactResult.getItemGroups();
                    kotlin.jvm.internal.IIX0o.oO(str, "getItemGroups(...)");
                }
            }
            break loop0;
        }
        if (str.length() > 0) {
            arrayList.add(new BleContactSortItem(str, i));
        }
        BleConnector.sendStream$default(BleConnector.INSTANCE, BleKey.CONTACT_SORT, new BleContactSort(1, arrayList).toByteArray(), 0, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncContact(List<? extends ContactResult> list) {
        try {
            if (!list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                this.lastData.clear();
                this.lastData.addAll(list);
                for (ContactResult contactResult : list) {
                    List<PhoneNumber> phoneNumbers = contactResult.getPhoneNumbers();
                    kotlin.jvm.internal.IIX0o.oO(phoneNumbers, "getPhoneNumbers(...)");
                    if (!phoneNumbers.isEmpty()) {
                        String displayName = contactResult.getDisplayName();
                        kotlin.jvm.internal.IIX0o.oO(displayName, "getDisplayName(...)");
                        String number = contactResult.getPhoneNumbers().get(0).getNumber();
                        kotlin.jvm.internal.IIX0o.oO(number, "getNumber(...)");
                        arrayList.add(new Contact(displayName, number));
                    }
                }
                LogUtils.d(" contact " + arrayList.size() + TokenParser.SP + arrayList);
                byte[] bArr = new byte[arrayList.size() * 40];
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    byte[] bytes = ((Contact) arrayList.get(i)).getName().getBytes(kotlin.text.oxoX.f29581II0xO0);
                    kotlin.jvm.internal.IIX0o.oO(bytes, "getBytes(...)");
                    int length = bytes.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 < 24) {
                            bArr[(i * 40) + i2] = bytes[i2];
                        }
                    }
                    byte[] bytes2 = ((Contact) arrayList.get(i)).getPhone().getBytes(kotlin.text.oxoX.f29581II0xO0);
                    kotlin.jvm.internal.IIX0o.oO(bytes2, "getBytes(...)");
                    int length2 = bytes2.length;
                    for (int i3 = 0; i3 < length2; i3++) {
                        if (i3 < 16) {
                            bArr[(i * 40) + 24 + i3] = bytes2[i3];
                        }
                    }
                }
                LogUtils.d(ByteArrayExtKt.getMHexString(bArr));
                BleConnector.sendStream$default(BleConnector.INSTANCE, BleKey.CONTACT, bArr, 0, 4, (Object) null);
                return;
            }
            BleConnector bleConnector = BleConnector.INSTANCE;
            BleKey bleKey = BleKey.CONTACT_SORT;
            BleKeyFlag bleKeyFlag = BleKeyFlag.DELETE;
            BleConnector.sendData$default(bleConnector, bleKey, bleKeyFlag, null, false, false, 28, null);
            BleConnector.sendData$default(bleConnector, BleKey.CONTACT, bleKeyFlag, null, false, false, 28, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OXOo.OOXIXo
    public final List<ContactResult> filledData(@OXOo.OOXIXo List<ContactResult> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        for (ContactResult contactResult : list) {
            II0XooXoX.oIX0oI oix0oi = com.sma.smartv3.util.II0XooXoX.f24231I0Io;
            String displayName = contactResult.getDisplayName();
            kotlin.jvm.internal.IIX0o.oO(displayName, "getDisplayName(...)");
            String II0xO02 = oix0oi.II0xO0(displayName);
            if (II0xO02.length() > 0) {
                String substring = II0xO02.substring(0, 1);
                kotlin.jvm.internal.IIX0o.oO(substring, "substring(...)");
                Locale locale = Locale.getDefault();
                kotlin.jvm.internal.IIX0o.oO(locale, "getDefault(...)");
                String upperCase = substring.toUpperCase(locale);
                kotlin.jvm.internal.IIX0o.oO(upperCase, "toUpperCase(...)");
                if (new Regex("[A-Z]").matches(upperCase)) {
                    Locale locale2 = Locale.getDefault();
                    kotlin.jvm.internal.IIX0o.oO(locale2, "getDefault(...)");
                    String upperCase2 = upperCase.toUpperCase(locale2);
                    kotlin.jvm.internal.IIX0o.oO(upperCase2, "toUpperCase(...)");
                    contactResult.setItemGroups(upperCase2);
                } else {
                    contactResult.setItemGroups(OoOoXO0.xoXoI.f2670oxoX);
                }
            } else {
                contactResult.setItemGroups(OoOoXO0.xoXoI.f2670oxoX);
            }
        }
        Collections.sort(list, this.pinyinComparator);
        return list;
    }

    public final boolean getDeleting() {
        return this.deleting;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        BleConnector.INSTANCE.addHandleCallback(this.bleHandleCallback);
        this.pinyinComparator = new com.sma.smartv3.util.xoIxX();
    }

    @OXOo.OOXIXo
    public final List<ContactResult> initList() {
        Collection ooXIXxIX2;
        Collection ooXIXxIX3;
        try {
            try {
                byte[] base64Decode = EncodeUtils.base64Decode(com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().getString(ContactResult.class.getName() + oOXoIIIo.XO.f32008oIX0oI));
                kotlin.jvm.internal.IIX0o.oO(base64Decode, "base64Decode(...)");
                JsonArray asJsonArray = JsonParser.parseString(new String(base64Decode, kotlin.text.oxoX.f29581II0xO0)).getAsJsonArray();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(asJsonArray);
                ooXIXxIX3 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(asJsonArray, 10));
                Iterator<JsonElement> it = asJsonArray.iterator();
                while (it.hasNext()) {
                    ooXIXxIX3.add(new Gson().fromJson(it.next(), ContactResult.class));
                }
            } catch (Exception unused) {
                ooXIXxIX3 = CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : ooXIXxIX3) {
                List<PhoneNumber> phoneNumbers = ((ContactResult) obj).getPhoneNumbers();
                kotlin.jvm.internal.IIX0o.oO(phoneNumbers, "getPhoneNumbers(...)");
                if (!phoneNumbers.isEmpty()) {
                    arrayList.add(obj);
                }
            }
            return CollectionsKt___CollectionsKt.o0Xo0XII(arrayList);
        } catch (Exception unused2) {
            try {
                byte[] base64Decode2 = EncodeUtils.base64Decode(com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().getString(ContactResult.class.getName() + oOXoIIIo.XO.f32008oIX0oI));
                kotlin.jvm.internal.IIX0o.oO(base64Decode2, "base64Decode(...)");
                JsonArray asJsonArray2 = JsonParser.parseString(new String(base64Decode2, kotlin.text.oxoX.f29581II0xO0)).getAsJsonArray();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(asJsonArray2);
                ooXIXxIX2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(asJsonArray2, 10));
                Iterator<JsonElement> it2 = asJsonArray2.iterator();
                while (it2.hasNext()) {
                    ooXIXxIX2.add(new Gson().fromJson(it2.next(), ContactResult.class));
                }
            } catch (Exception unused3) {
                ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            return CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
        }
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.sync_contact);
        getAbhTitleRight().setVisibility(0);
        getAbhTitleRight().setImageResource(R.drawable.ic_coaching_add);
        getAbhTitleRight().setImageTintList(oIxOXo.oxoX.X0o0xo(this, R.color.text_color));
        View findViewById = findViewById(R.id.contact_search_layout);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        UtilsKt.x0o(findViewById, 20.0f);
        List<ContactResult> initList = initList();
        this.mList = initList;
        showData(filledData(initList));
        getMContactBar().setOnTouchingLetterChangedListener(new I0Io());
        EditText mEditText = getMEditText();
        kotlin.jvm.internal.IIX0o.oO(mEditText, "<get-mEditText>(...)");
        mEditText.addTextChangedListener(new II0xO0());
        if (!this.mList.isEmpty()) {
            getRootView().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.XI0IXoo
                @Override // java.lang.Runnable
                public final void run() {
                    ContactListV2Activity.initView$lambda$4(ContactListV2Activity.this);
                }
            }, 500L);
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_contact_list_v2;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO final Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 991) {
            com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.ContactListV2Activity$onActivityResult$1
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
                    ContactListV2Activity.this.tmps.clear();
                    ContactListV2Activity.this.tmps.addAll(ContactPicker.obtainResult(intent));
                    ContactListV2Activity contactListV2Activity = ContactListV2Activity.this;
                    contactListV2Activity.filterData(contactListV2Activity.tmps);
                    if (ContactListV2Activity.this.mList.size() == 0) {
                        ContactListV2Activity.this.mList.addAll(ContactListV2Activity.this.tmps);
                    }
                    ContactListV2Activity contactListV2Activity2 = ContactListV2Activity.this;
                    contactListV2Activity2.syncContact(contactListV2Activity2.filledData(contactListV2Activity2.tmps));
                }
            }, 1, null);
        }
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        pickContact();
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        BleConnector.INSTANCE.removeHandleCallback(this.bleHandleCallback);
        super.onDestroy();
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        getRecyclerView().setLayoutManager(new LinearLayoutManager(this));
        SwipeMenuHelper.Companion.oIX0oI((RecyclerView) getDslViewHolder().v(recyclerViewId()));
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void onTitleRightClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        pickContact();
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int refreshLayoutId() {
        return 0;
    }

    public final void setDeleting(boolean z) {
        this.deleting = z;
    }

    public final void showData(@OXOo.OOXIXo final List<ContactResult> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        this.tipBars.clear();
        renderAdapter(new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.ContactListV2Activity$showData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                DslViewHolder dslViewHolder = ContactListV2Activity.this.getDslViewHolder();
                final List<ContactResult> list2 = list;
                final ContactListV2Activity contactListV2Activity = ContactListV2Activity.this;
                dslViewHolder.post(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.ContactListV2Activity$showData$1.1
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
                        List<ContactResult> list3 = list2;
                        final ContactListV2Activity contactListV2Activity2 = contactListV2Activity;
                        final DslAdapter dslAdapter = renderAdapter;
                        for (final ContactResult contactResult : list3) {
                            if (!contactListV2Activity2.tipBars.contains(contactResult.getItemGroups())) {
                                contactListV2Activity2.tipBars.add(contactResult.getItemGroups());
                                DslAdapterExKt.oO(contactListV2Activity2.getDslAdapter(), R.layout.item_contact_v2_groups, new Oox.oOoXoXO<DslAdapterItem, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.ContactListV2Activity$showData$1$1$1$1
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
                                        dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(ContactResult.this.getItemGroups()));
                                        dslItem.setItemIsHover(true);
                                        final ContactResult contactResult2 = ContactResult.this;
                                        dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.ContactListV2Activity$showData$1$1$1$1.1
                                            {
                                                super(4);
                                            }

                                            @Override // Oox.Oxx0xo
                                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list4) {
                                                invoke(dslViewHolder2, num.intValue(), dslAdapterItem, list4);
                                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                                            }

                                            public final void invoke(@OXOo.OOXIXo DslViewHolder viewHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list4) {
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "viewHolder");
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(list4, "<anonymous parameter 3>");
                                                TextView textView = (TextView) viewHolder.v(R.id.tv_name);
                                                if (textView == null) {
                                                    return;
                                                }
                                                textView.setText(ContactResult.this.getItemGroups());
                                            }
                                        });
                                    }
                                });
                            }
                            DslAdapterExKt.oO(contactListV2Activity2.getDslAdapter(), R.layout.item_contact_v2, new Oox.oOoXoXO<DslAdapterItem, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.ContactListV2Activity$showData$1$1$1$2

                                /* renamed from: com.sma.smartv3.ui.device.ContactListV2Activity$showData$1$1$1$2$1, reason: invalid class name */
                                /* loaded from: classes12.dex */
                                public static final class AnonymousClass1 extends Lambda implements Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, kotlin.oXIO0o0XI> {
                                    final /* synthetic */ ContactResult $it;
                                    final /* synthetic */ DslAdapterItem $this_dslItem;
                                    final /* synthetic */ DslAdapter $this_renderAdapter;
                                    final /* synthetic */ ContactListV2Activity this$0;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    public AnonymousClass1(ContactResult contactResult, DslAdapterItem dslAdapterItem, DslAdapter dslAdapter, ContactListV2Activity contactListV2Activity) {
                                        super(4);
                                        this.$it = contactResult;
                                        this.$this_dslItem = dslAdapterItem;
                                        this.$this_renderAdapter = dslAdapter;
                                        this.this$0 = contactListV2Activity;
                                    }

                                    /* JADX INFO: Access modifiers changed from: private */
                                    public static final void invoke$lambda$0(final DslAdapterItem this_dslItem, DslAdapter this_renderAdapter, final ContactListV2Activity this$0, final int i, final ContactResult it, final DslViewHolder viewHolder, View view) {
                                        List<DslAdapterItem> dataItems;
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(this_dslItem, "$this_dslItem");
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(this_renderAdapter, "$this_renderAdapter");
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "$it");
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "$viewHolder");
                                        com.sma.smartv3.ble.I0Io.II0xO0(false, 
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0027: INVOKE 
                                              false
                                              (wrap:Oox.oOoXoXO<com.szabh.smable3.component.BleConnector, kotlin.oXIO0o0XI>:0x0021: CONSTRUCTOR 
                                              (r8v0 'this$0' com.sma.smartv3.ui.device.ContactListV2Activity A[DONT_INLINE])
                                              (r9v0 'i' int A[DONT_INLINE])
                                              (r10v0 'it' com.sma.smartv3.ui.contactpicker.ContactResult A[DONT_INLINE])
                                              (r6v0 'this_dslItem' com.angcyo.dsladapter.DslAdapterItem A[DONT_INLINE])
                                              (r11v0 'viewHolder' com.angcyo.dsladapter.DslViewHolder A[DONT_INLINE])
                                             A[MD:(com.sma.smartv3.ui.device.ContactListV2Activity, int, com.sma.smartv3.ui.contactpicker.ContactResult, com.angcyo.dsladapter.DslAdapterItem, com.angcyo.dsladapter.DslViewHolder):void (m), WRAPPED] (LINE:34) call: com.sma.smartv3.ui.device.ContactListV2Activity$showData$1$1$1$2$1$1$1.<init>(com.sma.smartv3.ui.device.ContactListV2Activity, int, com.sma.smartv3.ui.contactpicker.ContactResult, com.angcyo.dsladapter.DslAdapterItem, com.angcyo.dsladapter.DslViewHolder):void type: CONSTRUCTOR)
                                              (1 int)
                                              (null java.lang.Object)
                                             STATIC call: com.sma.smartv3.ble.I0Io.II0xO0(boolean, Oox.oOoXoXO, int, java.lang.Object):boolean A[MD:(boolean, Oox.oOoXoXO, int, java.lang.Object):boolean (m)] (LINE:40) in method: com.sma.smartv3.ui.device.ContactListV2Activity$showData$1$1$1$2.1.invoke$lambda$0(com.angcyo.dsladapter.DslAdapterItem, com.angcyo.dsladapter.DslAdapter, com.sma.smartv3.ui.device.ContactListV2Activity, int, com.sma.smartv3.ui.contactpicker.ContactResult, com.angcyo.dsladapter.DslViewHolder, android.view.View):void, file: classes12.dex
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
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.ContactListV2Activity$showData$1$1$1$2$1$1$1, state: NOT_LOADED
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
                                            java.lang.String r12 = "$this_dslItem"
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(r6, r12)
                                            java.lang.String r12 = "$this_renderAdapter"
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r12)
                                            java.lang.String r12 = "this$0"
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(r8, r12)
                                            java.lang.String r12 = "$it"
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(r10, r12)
                                            java.lang.String r12 = "$viewHolder"
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(r11, r12)
                                            com.sma.smartv3.ui.device.ContactListV2Activity$showData$1$1$1$2$1$1$1 r12 = new com.sma.smartv3.ui.device.ContactListV2Activity$showData$1$1$1$2$1$1$1
                                            r0 = r12
                                            r1 = r8
                                            r2 = r9
                                            r3 = r10
                                            r4 = r6
                                            r5 = r11
                                            r0.<init>(r1, r2, r3, r4, r5)
                                            r8 = 0
                                            r9 = 1
                                            r10 = 0
                                            com.sma.smartv3.ble.I0Io.II0xO0(r8, r12, r9, r10)
                                            com.angcyo.dsladapter.DslAdapter r6 = r6.getItemDslAdapter()
                                            if (r6 == 0) goto L40
                                            java.util.List r6 = r6.getDataItems()
                                            if (r6 == 0) goto L40
                                            int r6 = r6.size()
                                            if (r6 != 0) goto L40
                                            r6 = 2
                                            com.angcyo.dsladapter.DslAdapter.setAdapterStatus$default(r7, r9, r10, r6, r10)
                                        L40:
                                            return
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.ContactListV2Activity$showData$1$1$1$2.AnonymousClass1.invoke$lambda$0(com.angcyo.dsladapter.DslAdapterItem, com.angcyo.dsladapter.DslAdapter, com.sma.smartv3.ui.device.ContactListV2Activity, int, com.sma.smartv3.ui.contactpicker.ContactResult, com.angcyo.dsladapter.DslViewHolder, android.view.View):void");
                                    }

                                    /* JADX INFO: Access modifiers changed from: private */
                                    public static final boolean invoke$lambda$2$lambda$1(DslViewHolder viewHolder, View view, MotionEvent motionEvent) {
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "$viewHolder");
                                        return viewHolder.itemView.onTouchEvent(motionEvent);
                                    }

                                    @Override // Oox.Oxx0xo
                                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                        invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                                    }

                                    public final void invoke(@OXOo.OOXIXo final DslViewHolder viewHolder, final int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                        TextView textView;
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "viewHolder");
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                        TextView textView2 = (TextView) viewHolder.v(R.id.tv_name);
                                        if (textView2 != null) {
                                            textView2.setText(this.$it.getDisplayName());
                                        }
                                        List<PhoneNumber> phoneNumbers = this.$it.getPhoneNumbers();
                                        kotlin.jvm.internal.IIX0o.oO(phoneNumbers, "getPhoneNumbers(...)");
                                        if (!phoneNumbers.isEmpty() && (textView = (TextView) viewHolder.v(R.id.tv_number)) != null) {
                                            textView.setText(this.$it.getPhoneNumbers().get(0).getNumber());
                                        }
                                        final DslAdapterItem dslAdapterItem2 = this.$this_dslItem;
                                        final DslAdapter dslAdapter = this.$this_renderAdapter;
                                        final ContactListV2Activity contactListV2Activity = this.this$0;
                                        final ContactResult contactResult = this.$it;
                                        viewHolder.click(R.id.bt_delete_sport_record, 
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006b: INVOKE 
                                              (r8v0 'viewHolder' com.angcyo.dsladapter.DslViewHolder)
                                              (wrap:int:SGET  A[WRAPPED] com.sma.smartv3.co_fit.R.id.bt_delete_sport_record int)
                                              (wrap:android.view.View$OnClickListener:0x0065: CONSTRUCTOR 
                                              (r1v0 'dslAdapterItem2' com.angcyo.dsladapter.DslAdapterItem A[DONT_INLINE])
                                              (r2v0 'dslAdapter' com.angcyo.dsladapter.DslAdapter A[DONT_INLINE])
                                              (r3v0 'contactListV2Activity' com.sma.smartv3.ui.device.ContactListV2Activity A[DONT_INLINE])
                                              (r9v0 'i' int A[DONT_INLINE])
                                              (r5v0 'contactResult' com.sma.smartv3.ui.contactpicker.ContactResult A[DONT_INLINE])
                                              (r8v0 'viewHolder' com.angcyo.dsladapter.DslViewHolder A[DONT_INLINE])
                                             A[MD:(com.angcyo.dsladapter.DslAdapterItem, com.angcyo.dsladapter.DslAdapter, com.sma.smartv3.ui.device.ContactListV2Activity, int, com.sma.smartv3.ui.contactpicker.ContactResult, com.angcyo.dsladapter.DslViewHolder):void (m), WRAPPED] call: com.sma.smartv3.ui.device.XIxXXX0x0.<init>(com.angcyo.dsladapter.DslAdapterItem, com.angcyo.dsladapter.DslAdapter, com.sma.smartv3.ui.device.ContactListV2Activity, int, com.sma.smartv3.ui.contactpicker.ContactResult, com.angcyo.dsladapter.DslViewHolder):void type: CONSTRUCTOR)
                                             VIRTUAL call: com.angcyo.dsladapter.DslViewHolder.click(int, android.view.View$OnClickListener):void A[MD:(int, android.view.View$OnClickListener):void (m)] in method: com.sma.smartv3.ui.device.ContactListV2Activity$showData$1$1$1$2.1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List<? extends java.lang.Object>):void, file: classes12.dex
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
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.XIxXXX0x0, state: NOT_LOADED
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
                                            this = this;
                                            java.lang.String r0 = "viewHolder"
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(r8, r0)
                                            java.lang.String r0 = "<anonymous parameter 2>"
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(r10, r0)
                                            java.lang.String r10 = "<anonymous parameter 3>"
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(r11, r10)
                                            r10 = 2131368381(0x7f0a19bd, float:1.835671E38)
                                            android.view.View r10 = r8.v(r10)
                                            android.widget.TextView r10 = (android.widget.TextView) r10
                                            if (r10 != 0) goto L1c
                                            goto L25
                                        L1c:
                                            com.sma.smartv3.ui.contactpicker.ContactResult r11 = r7.$it
                                            java.lang.String r11 = r11.getDisplayName()
                                            r10.setText(r11)
                                        L25:
                                            com.sma.smartv3.ui.contactpicker.ContactResult r10 = r7.$it
                                            java.util.List r10 = r10.getPhoneNumbers()
                                            java.lang.String r11 = "getPhoneNumbers(...)"
                                            kotlin.jvm.internal.IIX0o.oO(r10, r11)
                                            java.util.Collection r10 = (java.util.Collection) r10
                                            boolean r10 = r10.isEmpty()
                                            if (r10 != 0) goto L58
                                            r10 = 2131368396(0x7f0a19cc, float:1.835674E38)
                                            android.view.View r10 = r8.v(r10)
                                            android.widget.TextView r10 = (android.widget.TextView) r10
                                            if (r10 != 0) goto L44
                                            goto L58
                                        L44:
                                            com.sma.smartv3.ui.contactpicker.ContactResult r11 = r7.$it
                                            java.util.List r11 = r11.getPhoneNumbers()
                                            r0 = 0
                                            java.lang.Object r11 = r11.get(r0)
                                            com.sma.smartv3.ui.contactpicker.PhoneNumber r11 = (com.sma.smartv3.ui.contactpicker.PhoneNumber) r11
                                            java.lang.String r11 = r11.getNumber()
                                            r10.setText(r11)
                                        L58:
                                            com.angcyo.dsladapter.DslAdapterItem r1 = r7.$this_dslItem
                                            com.angcyo.dsladapter.DslAdapter r2 = r7.$this_renderAdapter
                                            com.sma.smartv3.ui.device.ContactListV2Activity r3 = r7.this$0
                                            com.sma.smartv3.ui.contactpicker.ContactResult r5 = r7.$it
                                            com.sma.smartv3.ui.device.XIxXXX0x0 r10 = new com.sma.smartv3.ui.device.XIxXXX0x0
                                            r0 = r10
                                            r4 = r9
                                            r6 = r8
                                            r0.<init>(r1, r2, r3, r4, r5, r6)
                                            r9 = 2131363392(0x7f0a0640, float:1.8346592E38)
                                            r8.click(r9, r10)
                                            r9 = 2131365907(0x7f0a1013, float:1.8351693E38)
                                            android.view.View r9 = r8.view(r9)
                                            if (r9 == 0) goto L7f
                                            com.sma.smartv3.ui.device.xxX r10 = new com.sma.smartv3.ui.device.xxX
                                            r10.<init>(r8)
                                            r9.setOnTouchListener(r10)
                                        L7f:
                                            return
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.ContactListV2Activity$showData$1$1$1$2.AnonymousClass1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List):void");
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
                                    dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(ContactResult.this.getItemGroups()));
                                    dslItem.setItemBindOverride(new AnonymousClass1(ContactResult.this, dslItem, dslAdapter, contactListV2Activity2));
                                }
                            });
                        }
                        DslAdapter.render$default(renderAdapter, false, null, new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.ContactListV2Activity.showData.1.1.2
                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapter dslAdapter2) {
                                invoke2(dslAdapter2);
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
        if (list.isEmpty()) {
            getMContactBar().setVisibility(8);
            getMLinearLayout().setVisibility(8);
            getMEmptyLayout().setVisibility(0);
        } else {
            getMContactBar().setVisibility(0);
            getMLinearLayout().setVisibility(0);
            getMEmptyLayout().setVisibility(8);
        }
        this.deleting = false;
    }
}
