package com.sma.smartv3.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.AIManager;
import com.sma.smartv3.biz.OrderManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.BloodGlucose2Dao;
import com.sma.smartv3.db.dao.BloodOxygenDao;
import com.sma.smartv3.db.dao.BloodPressureDao;
import com.sma.smartv3.db.dao.HealthyReportDao;
import com.sma.smartv3.db.dao.HeartRateDao;
import com.sma.smartv3.db.dao.PressureDao;
import com.sma.smartv3.db.dao.SleepDao;
import com.sma.smartv3.db.dao.WeightDao;
import com.sma.smartv3.db.dao.WorkoutDao;
import com.sma.smartv3.db.entity.BloodGlucose2;
import com.sma.smartv3.db.entity.HealthyReport;
import com.sma.smartv3.db.entity.HeartRate;
import com.sma.smartv3.db.entity.Sleep;
import com.sma.smartv3.db.entity.Weight;
import com.sma.smartv3.db.entity.Workout;
import com.sma.smartv3.model.AIAnswer;
import com.sma.smartv3.model.AIFunction;
import com.sma.smartv3.model.AIFunctionDataKt;
import com.sma.smartv3.model.AIFunctionType;
import com.sma.smartv3.model.AIQuestion;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.HeathItemReports;
import com.sma.smartv3.model.SleepAllDayData;
import com.sma.smartv3.model.SleepAllDayDataParse;
import com.sma.smartv3.model.TodayData;
import com.sma.smartv3.model.TodayHealthyDataKt;
import com.sma.smartv3.ui.ai.AIChatActivity;
import com.sma.smartv3.ui.me.GoogleWebViewActivity;
import com.sma.smartv3.ui.status.HeathReportsGenerateActivity;
import com.sma.smartv3.ui.status.HistoryReportsActivity;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.oXIO0o0XI;

@kotlin.jvm.internal.XX({"SMAP\nHeathReportsUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HeathReportsUtils.kt\ncom/sma/smartv3/util/HeathReportsUtils\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,736:1\n69#2,3:737\n72#2,5:741\n1#3:740\n1#3:774\n1549#4:746\n1620#4,3:747\n1549#4:752\n1620#4,3:753\n1549#4:758\n1620#4,3:759\n1549#4:767\n1620#4,2:768\n1622#4:771\n1549#4:778\n1620#4,2:779\n1622#4:782\n19#5:750\n15#5:751\n19#5:756\n15#5:757\n19#5:762\n15#5:763\n50#5,3:764\n53#5:770\n55#5,2:772\n50#5,3:775\n53#5:781\n55#5,2:783\n35#5,2:785\n*S KotlinDebug\n*F\n+ 1 HeathReportsUtils.kt\ncom/sma/smartv3/util/HeathReportsUtils\n*L\n140#1:737,3\n140#1:741,5\n140#1:740\n225#1:746\n225#1:747,3\n329#1:752\n329#1:753,3\n459#1:758\n459#1:759,3\n631#1:767\n631#1:768,2\n631#1:771\n676#1:778\n676#1:779,2\n676#1:782\n251#1:750\n251#1:751\n449#1:756\n449#1:757\n576#1:762\n576#1:763\n631#1:764,3\n631#1:770\n631#1:772,2\n676#1:775,3\n676#1:781\n676#1:783,2\n690#1:785,2\n*E\n"})
/* loaded from: classes12.dex */
public final class HeathReportsUtils {

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static com.sma.smartv3.pop.XoI0Ixx0 f24213OOXIXo;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f24222x0XOIxOo = 0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final HeathReportsUtils f24217oIX0oI = new HeathReportsUtils();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f24212II0xO0 = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<HeartRateDao>() { // from class: com.sma.smartv3.util.HeathReportsUtils$mHeartRateDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final HeartRateDao invoke() {
            return MyDb.INSTANCE.getMDatabase().heartRateDao();
        }
    });

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f24210I0Io = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<BloodPressureDao>() { // from class: com.sma.smartv3.util.HeathReportsUtils$mBloodPressureDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final BloodPressureDao invoke() {
            return MyDb.INSTANCE.getMDatabase().bloodPressureDao();
        }
    });

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f24221oxoX = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<BloodOxygenDao>() { // from class: com.sma.smartv3.util.HeathReportsUtils$mBloodOxygenDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final BloodOxygenDao invoke() {
            return MyDb.INSTANCE.getMDatabase().bloodOxygenDao();
        }
    });

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f24215X0o0xo = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SleepDao>() { // from class: com.sma.smartv3.util.HeathReportsUtils$mSleepDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final SleepDao invoke() {
            return MyDb.INSTANCE.getMDatabase().sleepDao();
        }
    });

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f24216XO = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PressureDao>() { // from class: com.sma.smartv3.util.HeathReportsUtils$mPressureDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final PressureDao invoke() {
            return MyDb.INSTANCE.getMDatabase().pressureDao();
        }
    });

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f24214Oxx0IOOO = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<BloodGlucose2Dao>() { // from class: com.sma.smartv3.util.HeathReportsUtils$mBloodGlucose2Dao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final BloodGlucose2Dao invoke() {
            return MyDb.INSTANCE.getMDatabase().bloodGlucose2Dao();
        }
    });

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f24211II0XooXoX = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WeightDao>() { // from class: com.sma.smartv3.util.HeathReportsUtils$mWeightDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final WeightDao invoke() {
            return MyDb.INSTANCE.getMDatabase().weightDao();
        }
    });

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f24224xxIXOIIO = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WorkoutDao>() { // from class: com.sma.smartv3.util.HeathReportsUtils$mWorkoutDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final WorkoutDao invoke() {
            return MyDb.INSTANCE.getMDatabase().workoutDao();
        }
    });

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f24223xoIox = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<HealthyReportDao>() { // from class: com.sma.smartv3.util.HeathReportsUtils$mHealthyReportDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final HealthyReportDao invoke() {
            return MyDb.INSTANCE.getMDatabase().healthyReportDao();
        }
    });

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24219oOoXoXO = "HeathReportsUtils";

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24220ooOOo0oXI = "WeeklyExerciseStatistics";

    /* renamed from: oO, reason: collision with root package name */
    public static final int f24218oO = 1;

    public static /* synthetic */ String O0xOxO(HeathReportsUtils heathReportsUtils, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 50;
        }
        return heathReportsUtils.OxI(str, str2, str3, i);
    }

    public static final void OI0(View btn) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(btn, "$btn");
        btn.setEnabled(false);
    }

    public static /* synthetic */ void OOXIXo(HeathReportsUtils heathReportsUtils, List list, int i, int i2, long j, String str, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            str = "";
        }
        heathReportsUtils.xoIox(list, i, i2, j, str);
    }

    public static /* synthetic */ void Oo(HeathReportsUtils heathReportsUtils, Activity activity, Oox.oOoXoXO oooxoxo, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = f24222x0XOIxOo;
        }
        heathReportsUtils.x0xO0oo(activity, oooxoxo, i);
    }

    public static final void XOxIOxOx(Activity activity, final View btn, String mAiQuestion, TextView tv, String itemType, long j, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "$activity");
        kotlin.jvm.internal.IIX0o.x0xO0oo(btn, "$btn");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mAiQuestion, "$mAiQuestion");
        kotlin.jvm.internal.IIX0o.x0xO0oo(tv, "$tv");
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemType, "$itemType");
        activity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.util.xxX
            @Override // java.lang.Runnable
            public final void run() {
                HeathReportsUtils.OI0(btn);
            }
        });
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(f24219oOoXoXO + " setOnClickListener");
        f24217oIX0oI.xXOx(activity, new HeathReportsUtils$itemLayoutClickListener$1$2(activity, mAiQuestion, btn, tv, itemType, j), f24222x0XOIxOo);
    }

    public static /* synthetic */ void XX0(HeathReportsUtils heathReportsUtils, Activity activity, Oox.oOoXoXO oooxoxo, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = f24222x0XOIxOo;
        }
        heathReportsUtils.xXOx(activity, oooxoxo, i);
    }

    public static /* synthetic */ void XoX(HeathReportsUtils heathReportsUtils, Activity activity, int i, int i2, int i3, int i4, Oox.oOoXoXO oooxoxo, int i5, int i6, Object obj) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        if ((i6 & 2) != 0) {
            i7 = R.string.tip;
        } else {
            i7 = i;
        }
        if ((i6 & 4) != 0) {
            i8 = R.string.points_insufficient_tip;
        } else {
            i8 = i2;
        }
        if ((i6 & 8) != 0) {
            i9 = R.string.cancel;
        } else {
            i9 = i3;
        }
        if ((i6 & 16) != 0) {
            i10 = R.string.confirm;
        } else {
            i10 = i4;
        }
        if ((i6 & 64) != 0) {
            i11 = f24222x0XOIxOo;
        } else {
            i11 = i5;
        }
        heathReportsUtils.oxxXoxO(activity, i7, i8, i9, i10, oooxoxo, i11);
    }

    public static final void o0(Activity activity, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "$activity");
        AIFunctionDataKt.toAIFunction(activity, new AIFunction(AIFunctionType.HEALTH_QA, UtilsKt.oI0IIXIo(R.string.health_qa), R.drawable.ai_function_health_qa_bg, UtilsKt.oI0IIXIo(R.string.health_qa_desc), R.drawable.icon_ai_function_health_qa, 0, null, null, null, null, true, new Intent(Utils.getApp(), (Class<?>) AIChatActivity.class), 992, null));
    }

    public static /* synthetic */ void oO(HeathReportsUtils heathReportsUtils, List list, float f, float f2, long j, String str, int i, Object obj) {
        if ((i & 16) != 0) {
            str = "";
        }
        heathReportsUtils.x0XOIxOo(list, f, f2, j, str);
    }

    public static /* synthetic */ void oo(HeathReportsUtils heathReportsUtils, List list, List list2, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 0;
        }
        heathReportsUtils.oo0xXOI0I(list, list2, j);
    }

    public static /* synthetic */ void ooOOo0oXI(HeathReportsUtils heathReportsUtils, List list, int i, int i2, long j, String str, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            str = "";
        }
        heathReportsUtils.oOoXoXO(list, i, i2, j, str);
    }

    public static /* synthetic */ void xo0x(HeathReportsUtils heathReportsUtils, String str, int i, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        if ((i2 & 2) != 0) {
            i = 50;
        }
        heathReportsUtils.oxXx0IX(str, i, oooxoxo);
    }

    public static /* synthetic */ void xxIXOIIO(HeathReportsUtils heathReportsUtils, List list, double d, long j, String str, int i, Object obj) {
        if ((i & 8) != 0) {
            str = "";
        }
        heathReportsUtils.II0XooXoX(list, d, j, str);
    }

    public final String I0oOoX(String str) {
        return kotlin.text.OxI.IIOIX(str, "\n", ",", false, 4, null);
    }

    public final void II0XooXoX(@OXOo.OOXIXo List<TodayData> list, double d, long j, @OXOo.OOXIXo String mExtraInfo) {
        String oI0IIXIo2;
        int i;
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mExtraInfo, "mExtraInfo");
        if (d >= 6.9d) {
            oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.lightness_high);
            i = 3;
        } else if (d < 6.1d) {
            oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.data_lower);
            i = 1;
        } else {
            oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.pressure_level_normal);
            i = 2;
        }
        list.add(new TodayData(j, UtilsKt.oI0IIXIo(R.string.blood_glucose), d + UtilsKt.oI0IIXIo(R.string.bg_unit), oI0IIXIo2, i, ProductManager.X0OXIOxX, 0, mExtraInfo, (float) d, 0.0f, 576, null));
    }

    public final SleepDao IIX0o() {
        return (SleepDao) f24215X0o0xo.getValue();
    }

    @OXOo.OOXIXo
    public final List<HealthyReport> IIXOooo() {
        return xxX().getListASC();
    }

    public final void IO(@OXOo.oOoXoXO List<TodayData> list, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        List<TodayData> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            SPUtils XO2 = Xo0.f24349oIX0oI.XO();
            Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
            Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
            if (fromJson != null) {
                appUser = fromJson;
            }
            AppUser appUser2 = (AppUser) appUser;
            long currentTimeMillis = System.currentTimeMillis();
            HealthyReport healthyReport = new HealthyReport(0, 0, 0.0f, 0.0f, 0L, null, 0, 0L, 0, null, 0L, 0, 0, null, 0L, 0, null, 0L, 0.0f, 0.0f, null, 0L, 0, null, 0L, 0.0f, null, 0L, 0.0f, null, 0L, 0, 0, null, 0, -1, 7, null);
            healthyReport.setMUserGender(appUser2.getGender());
            healthyReport.setMUserWeight(appUser2.getWeight());
            healthyReport.setMUserHeight(appUser2.getHeight());
            healthyReport.setMTime(currentTimeMillis);
            String format = xoIox.I0Io().format(Long.valueOf(currentTimeMillis));
            kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
            healthyReport.setMLocalTime(format);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(list);
            List<TodayData> list3 = list;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list3, 10));
            int i = 0;
            for (TodayData todayData : list3) {
                if (todayData.getStateColor() != 2) {
                    i++;
                }
                String dataType = todayData.getDataType();
                if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(dataType, "heart_rate")) {
                    healthyReport.setMHeartRateTime(todayData.getTime());
                    healthyReport.setMHeartRateValue((int) todayData.getValue1());
                    healthyReport.setMHeartRateAIRecords(todayData.getMExtraInfo());
                } else if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(dataType, ProductManager.xxI0XIO)) {
                    healthyReport.setMBloodPressureTime(todayData.getTime());
                    healthyReport.setMSystolicValue((int) todayData.getValue1());
                    healthyReport.setMDiastolicValue((int) todayData.getValue2());
                    healthyReport.setMBloodPressureAIRecords(todayData.getMExtraInfo());
                } else if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(dataType, ProductManager.IO0xO)) {
                    healthyReport.setMBloodOxygenTime(todayData.getTime());
                    healthyReport.setMBloodOxygenValue((int) todayData.getValue1());
                    healthyReport.setMBloodOxygenAIRecords(todayData.getMExtraInfo());
                } else if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(dataType, "sleep")) {
                    healthyReport.setMSleepTime(todayData.getTime());
                    healthyReport.setMSleepDeepLengthTime(todayData.getValue1());
                    healthyReport.setMSleepPiecemealTime(todayData.getValue2());
                    healthyReport.setMSleepAIRecords(todayData.getMExtraInfo());
                } else if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(dataType, ProductManager.oXoxo0x)) {
                    healthyReport.setMPressureTime(todayData.getTime());
                    healthyReport.setMPressureValue((int) todayData.getValue1());
                    healthyReport.setMPressureAIRecords(todayData.getMExtraInfo());
                } else if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(dataType, ProductManager.X0OXIOxX)) {
                    healthyReport.setMBloodGlucose2Time(todayData.getTime());
                    healthyReport.setMBloodGlucose2Value(todayData.getValue1());
                    healthyReport.setMBloodGlucose2AIRecords(todayData.getMExtraInfo());
                } else if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(dataType, "weight")) {
                    healthyReport.setMWeightTime(todayData.getTime());
                    healthyReport.setMWeightValue(todayData.getValue1());
                    healthyReport.setMWeightAIRecords(todayData.getMExtraInfo());
                } else if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(dataType, f24220ooOOo0oXI)) {
                    healthyReport.setMWeekSportsTime(todayData.getTime());
                    healthyReport.setMWeekSportsNumber((int) todayData.getValue1());
                    healthyReport.setMWeekSportsAllTime((int) todayData.getValue2());
                    healthyReport.setMWeekSportsAIRecords(todayData.getMExtraInfo());
                }
                arrayList.add(oXIO0o0XI.f29392oIX0oI);
            }
            healthyReport.setMIsSync(0);
            healthyReport.setMAbnormalNumber(i);
            action.invoke(Long.valueOf(xxX().insert(healthyReport)));
            return;
        }
        action.invoke(0L);
    }

    public final void IXxxXO(@OXOo.OOXIXo List<BloodGlucose2> bloodGlucose2List, @OXOo.OOXIXo List<TodayData> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bloodGlucose2List, "bloodGlucose2List");
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        if (!bloodGlucose2List.isEmpty()) {
            BloodGlucose2 bloodGlucose2 = (BloodGlucose2) CollectionsKt___CollectionsKt.O0O0Io00X(bloodGlucose2List);
            xxIXOIIO(this, list, bloodGlucose2.getMUpperBound(), bloodGlucose2.getMTime(), null, 8, null);
        }
    }

    public final void Io(@OXOo.OOXIXo String itemType, long j, @OXOo.OOXIXo View btn, @OXOo.OOXIXo TextView tv, @OXOo.OOXIXo View layoutTip, @OXOo.OOXIXo View questionsBtn, @OXOo.OOXIXo final Activity activity) {
        Collection ooXIXxIX2;
        Object obj;
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemType, "itemType");
        kotlin.jvm.internal.IIX0o.x0xO0oo(btn, "btn");
        kotlin.jvm.internal.IIX0o.x0xO0oo(tv, "tv");
        kotlin.jvm.internal.IIX0o.x0xO0oo(layoutTip, "layoutTip");
        kotlin.jvm.internal.IIX0o.x0xO0oo(questionsBtn, "questionsBtn");
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        try {
            JsonArray asJsonArray = JsonParser.parseString(Xo0.f24349oIX0oI.oIX0oI().getString(XoI0Ixx0.f24389OO0)).getAsJsonArray();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(asJsonArray);
            ooXIXxIX2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(asJsonArray, 10));
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                ooXIXxIX2.add(new Gson().fromJson(it.next(), HeathItemReports.class));
            }
        } catch (Exception unused) {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        if (ooXIXxIX2 == null) {
            ooXIXxIX2 = new ArrayList();
        }
        btn.setEnabled(false);
        Iterator it2 = ooXIXxIX2.iterator();
        while (true) {
            if (it2.hasNext()) {
                obj = it2.next();
                if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(((HeathItemReports) obj).getDataType(), itemType)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        HeathItemReports heathItemReports = (HeathItemReports) obj;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(f24219oOoXoXO + " itemLayoutNumberControl item = " + heathItemReports);
        if (heathItemReports == null) {
            tv.setVisibility(8);
            layoutTip.setVisibility(8);
            btn.setEnabled(true);
        } else if (j != heathItemReports.getTime() && heathItemReports.getNumber() < 20) {
            btn.setEnabled(true);
            layoutTip.setVisibility(0);
            tv.setVisibility(0);
            tv.setText(heathItemReports.getAiExtraInfo());
        } else {
            layoutTip.setVisibility(0);
            tv.setVisibility(0);
            tv.setText(heathItemReports.getAiExtraInfo());
        }
        questionsBtn.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.util.XIxXXX0x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HeathReportsUtils.o0(activity, view);
            }
        });
    }

    @OXOo.OOXIXo
    public final String IoOoX() {
        return f24220ooOOo0oXI;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0053, code lost:
    
        if (r40.equals(com.sma.smartv3.ble.ProductManager.X0OXIOxX) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005d, code lost:
    
        if (r40.equals(com.sma.smartv3.ble.ProductManager.xxI0XIO) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008a, code lost:
    
        if (r40.equals(com.sma.smartv3.ble.ProductManager.IO0xO) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x013a, code lost:
    
        if (r40.equals(com.sma.smartv3.ble.ProductManager.oXoxo0x) != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0049, code lost:
    
        if (r40.equals("heart_rate") == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:?, code lost:
    
        return java.lang.String.valueOf(com.blankj.utilcode.util.Utils.getApp().getString(com.sma.smartv3.co_fit.R.string.ai_heath_question1, r41, r2, r41, r2, r9));
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x003e. Please report as an issue. */
    @OXOo.OOXIXo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String OxI(@OXOo.OOXIXo java.lang.String r40, @OXOo.OOXIXo java.lang.String r41, @OXOo.OOXIXo java.lang.String r42, int r43) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.util.HeathReportsUtils.OxI(java.lang.String, java.lang.String, java.lang.String, int):java.lang.String");
    }

    @OXOo.OOXIXo
    public final HealthyReport Oxx0xo(long j) {
        return xxX().getHealthyReport(j);
    }

    public final int OxxIIOOXO() {
        return f24218oO;
    }

    @OXOo.OOXIXo
    public final List<TodayData> X00IoxXI(@OXOo.oOoXoXO HealthyReport healthyReport) {
        ArrayList arrayList = new ArrayList();
        if (healthyReport != null) {
            if (healthyReport.getMHeartRateValue() > 0) {
                TodayHealthyDataKt.addHealthyDataHeart(arrayList, healthyReport.getMHeartRateValue(), healthyReport.getMHeartRateTime(), healthyReport.getMHeartRateAIRecords());
            }
            if (healthyReport.getMSystolicValue() > 0 && healthyReport.getMDiastolicValue() > 0) {
                TodayHealthyDataKt.addHealthyDataBloodPressure(arrayList, healthyReport.getMSystolicValue(), healthyReport.getMDiastolicValue(), healthyReport.getMBloodPressureTime(), healthyReport.getMBloodPressureAIRecords());
            }
            if (healthyReport.getMBloodOxygenTime() > 0) {
                TodayHealthyDataKt.addHealthyDataBloodOxy(arrayList, healthyReport.getMBloodOxygenValue(), healthyReport.getMBloodOxygenTime(), healthyReport.getMBloodOxygenAIRecords());
            }
            if (healthyReport.getMSleepTime() > 0) {
                xoIox(arrayList, (int) healthyReport.getMSleepDeepLengthTime(), (int) healthyReport.getMSleepPiecemealTime(), healthyReport.getMSleepTime(), healthyReport.getMSleepAIRecords());
            }
            if (healthyReport.getMPressureValue() > 0) {
                TodayHealthyDataKt.addHealthyDataPressure(arrayList, healthyReport.getMPressureValue(), healthyReport.getMPressureTime(), healthyReport.getMPressureAIRecords());
            }
            if (healthyReport.getMBloodGlucose2Value() > 0.0f) {
                II0XooXoX(arrayList, healthyReport.getMBloodGlucose2Value(), healthyReport.getMBloodGlucose2Time(), healthyReport.getMBloodGlucose2AIRecords());
            }
            if (healthyReport.getMWeightValue() > 0.0f) {
                x0XOIxOo(arrayList, healthyReport.getMWeightValue(), healthyReport.getMUserHeight(), healthyReport.getMWeightTime(), healthyReport.getMWeightAIRecords());
            }
            if (healthyReport.getMWeekSportsAllTime() > 0) {
                oOoXoXO(arrayList, healthyReport.getMWeekSportsNumber(), healthyReport.getMWeekSportsAllTime(), healthyReport.getMWeekSportsTime(), healthyReport.getMWeekSportsAIRecords());
            }
        }
        return arrayList;
    }

    public final BloodGlucose2Dao X0IIOO() {
        return (BloodGlucose2Dao) f24214Oxx0IOOO.getValue();
    }

    public final BloodOxygenDao XI0IXoo() {
        return (BloodOxygenDao) f24221oxoX.getValue();
    }

    public final BloodPressureDao XIxXXX0x0() {
        return (BloodPressureDao) f24210I0Io.getValue();
    }

    public final void XX(String str, long j, String str2) {
        Collection ooXIXxIX2;
        Object obj;
        try {
            JsonArray asJsonArray = JsonParser.parseString(Xo0.f24349oIX0oI.oIX0oI().getString(XoI0Ixx0.f24389OO0)).getAsJsonArray();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(asJsonArray);
            ooXIXxIX2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(asJsonArray, 10));
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                ooXIXxIX2.add(new Gson().fromJson(it.next(), HeathItemReports.class));
            }
        } catch (Exception unused) {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        List o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
        if (o0Xo0XII == null) {
            o0Xo0XII = new ArrayList();
        }
        Iterator it2 = o0Xo0XII.iterator();
        while (true) {
            if (it2.hasNext()) {
                obj = it2.next();
                if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(((HeathItemReports) obj).getDataType(), str)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        HeathItemReports heathItemReports = (HeathItemReports) obj;
        if (heathItemReports == null) {
            o0Xo0XII.add(new HeathItemReports(j, str, 1, str2));
        } else {
            if (xII(j, heathItemReports.getTime())) {
                heathItemReports.setNumber(heathItemReports.getNumber() + 1);
                heathItemReports.setTime(j);
            } else {
                heathItemReports.setNumber(1);
                heathItemReports.setTime(j);
            }
            heathItemReports.setAiExtraInfo(str2);
        }
        Xo0.f24349oIX0oI.oIX0oI().put(XoI0Ixx0.f24389OO0, new Gson().toJson(o0Xo0XII));
    }

    public final void Xx000oIo(@OXOo.OOXIXo List<Weight> weightList, @OXOo.OOXIXo List<TodayData> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(weightList, "weightList");
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        if (!weightList.isEmpty()) {
            Weight weight = (Weight) CollectionsKt___CollectionsKt.O0O0Io00X(weightList);
            SPUtils XO2 = Xo0.f24349oIX0oI.XO();
            Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
            Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
            if (fromJson != null) {
                appUser = fromJson;
            }
            oO(this, list, weight.getMWeight(), ((AppUser) appUser).getHeight(), weight.getMTime(), null, 16, null);
        }
    }

    public final HeartRateDao XxX0x0xxx() {
        return (HeartRateDao) f24212II0xO0.getValue();
    }

    public final String o00(String str) {
        switch (str.hashCode()) {
            case -1276242363:
                if (str.equals(ProductManager.oXoxo0x)) {
                    return UtilsKt.oI0IIXIo(R.string.pressure);
                }
                break;
            case -791592328:
                if (str.equals("weight")) {
                    return UtilsKt.oI0IIXIo(R.string.weight);
                }
                break;
            case -240915579:
                if (str.equals(ProductManager.IO0xO)) {
                    return UtilsKt.oI0IIXIo(R.string.blood_oxygen);
                }
                break;
            case 109522647:
                if (str.equals("sleep")) {
                    return UtilsKt.oI0IIXIo(R.string.sleep);
                }
                break;
            case 560044778:
                if (str.equals(ProductManager.xxI0XIO)) {
                    return UtilsKt.oI0IIXIo(R.string.blood_pressure);
                }
                break;
            case 1467734697:
                if (str.equals(ProductManager.X0OXIOxX)) {
                    return UtilsKt.oI0IIXIo(R.string.blood_glucose);
                }
                break;
            case 1930449209:
                if (str.equals("heart_rate")) {
                    return UtilsKt.oI0IIXIo(R.string.heart_rate);
                }
                break;
        }
        return UtilsKt.oI0IIXIo(R.string.health_data);
    }

    public final int oI0IIXIo() {
        return f24222x0XOIxOo;
    }

    public final void oOXoIIIo(long j, @OXOo.OOXIXo List<Workout> workoutList, @OXOo.OOXIXo List<TodayData> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(workoutList, "workoutList");
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        List<Workout> list2 = workoutList;
        ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list2, 10));
        Iterator<T> it = list2.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Workout) it.next()).getMDuration();
            arrayList.add(oXIO0o0XI.f29392oIX0oI);
        }
        if (i > 0) {
            ooOOo0oXI(this, list, workoutList.size(), i, j, null, 16, null);
        }
    }

    public final void oOoXoXO(@OXOo.OOXIXo List<TodayData> list, int i, int i2, long j, @OXOo.OOXIXo String mExtraInfo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mExtraInfo, "mExtraInfo");
        list.add(new TodayData(j, UtilsKt.oI0IIXIo(R.string.heath_week_sport_title), i + UtilsKt.oI0IIXIo(R.string.times) + '\n' + UtilsKt.oI0IIXIo(R.string.heath_week_sport_alltime) + ':' + (i2 / 3600) + 'H', "", 2, f24220ooOOo0oXI, 0, mExtraInfo, i, i2, 64, null));
    }

    public final void oo0xXOI0I(List<Sleep> list, List<TodayData> list2, long j) {
        if (!list.isEmpty()) {
            SleepAllDayData filterData = SleepAllDayDataParse.INSTANCE.filterData(list, 100.0f, null, j);
            LogUtils.d(filterData.toString());
            int i = filterData.getStatus().get(1) + filterData.getStatus().get(2) + filterData.getStatus().get(3);
            int i2 = filterData.getStatus().get(8);
            if (i != 0) {
                List<Sleep> list3 = list;
                ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list3, 10));
                long j2 = 0;
                for (Sleep sleep : list3) {
                    if (sleep.getMMode() == 17 && j2 == 0) {
                        j2 = sleep.getMTime();
                    }
                    arrayList.add(oXIO0o0XI.f29392oIX0oI);
                }
                OOXIXo(this, list2, i, i2, j2, null, 16, null);
            }
        }
    }

    public final WeightDao ooXIXxIX() {
        return (WeightDao) f24211II0XooXoX.getValue();
    }

    public final void oxXx0IX(@OXOo.OOXIXo String mAiQuestion, int i, @OXOo.OOXIXo final Oox.oOoXoXO<? super String, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(mAiQuestion, "mAiQuestion");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        AIManager.oo0xXOI0I(AIManager.f19833oIX0oI, new AIQuestion(AIFunctionType.HEALTH_QA_ANALYZE, mAiQuestion, null, null, false, 28, null), new xxxI.II0xO0<AIAnswer>() { // from class: com.sma.smartv3.util.HeathReportsUtils$startAIAnalyze$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.II0xO0("startAIAnalyze handleError error = " + error);
                action.invoke("");
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO AIAnswer aIAnswer) {
                if (aIAnswer != null && aIAnswer.getEnded() == 1) {
                    action.invoke(aIAnswer.getText());
                } else if (aIAnswer == null) {
                    OI0.oIX0oI.f1507oIX0oI.II0xO0("startAIAnalyze handleResponse error ");
                    action.invoke("");
                }
            }
        }, false, false, i, 0, 40, null);
    }

    public final void oxxXoxO(final Activity activity, int i, int i2, int i3, final int i4, final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo, final int i5) {
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0;
        if (f24213OOXIXo == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = new com.sma.smartv3.pop.XoI0Ixx0(activity, 0, 2, null);
            xoI0Ixx02.IoOoX(i);
            xoI0Ixx02.xI(Integer.valueOf(i2));
            xoI0Ixx02.oo0xXOI0I(1);
            xoI0Ixx02.X00IoxXI(Integer.valueOf(i3), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.util.HeathReportsUtils$showTipPopup$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    oooxoxo.invoke(Boolean.FALSE);
                    return Boolean.TRUE;
                }
            });
            xoI0Ixx02.x0o(i4, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.util.HeathReportsUtils$showTipPopup$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    int i6 = i4;
                    if (i6 == R.string.agree) {
                        int i7 = i5;
                        HeathReportsUtils heathReportsUtils = HeathReportsUtils.f24217oIX0oI;
                        if (i7 != heathReportsUtils.oI0IIXIo()) {
                            HeathReportsUtils.f24213OOXIXo = null;
                            Xo0.f24349oIX0oI.oIX0oI().put(XoI0Ixx0.f24430XoIxOXIXo, true);
                            heathReportsUtils.x0xO0oo(activity, oooxoxo, i5);
                        } else {
                            oooxoxo.invoke(Boolean.TRUE);
                        }
                    } else if (i6 == R.string.confirm) {
                        Activity activity2 = activity;
                        String IIX0o2 = OrderManager.IIX0o(OrderManager.f20130oIX0oI, null, null, 3, null);
                        Bundle bundle = new Bundle();
                        bundle.putString("mArg0", IIX0o2);
                        bundle.putInt("mArg1", 2);
                        bundle.putParcelable("mArg2", null);
                        bundle.putSerializable("mArg3", null);
                        Intent intent = new Intent(activity2, (Class<?>) GoogleWebViewActivity.class);
                        intent.putExtras(bundle);
                        activity2.startActivity(intent);
                    } else if (i6 == R.string.heath_reports_history_btn) {
                        Activity activity3 = activity;
                        activity3.startActivity(new Intent(activity3, (Class<?>) HistoryReportsActivity.class));
                    }
                    return Boolean.TRUE;
                }
            });
            f24213OOXIXo = xoI0Ixx02;
        }
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx03 = f24213OOXIXo;
        if ((xoI0Ixx03 == null || !xoI0Ixx03.isShowing()) && (xoI0Ixx0 = f24213OOXIXo) != null) {
            xoI0Ixx0.IIXOooo();
        }
    }

    public final void x0XOIxOo(@OXOo.OOXIXo List<TodayData> list, float f, float f2, long j, @OXOo.OOXIXo String mExtraInfo) {
        String oI0IIXIo2;
        int i;
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mExtraInfo, "mExtraInfo");
        float f3 = f / ((f2 * f2) / 10000);
        double d = f3;
        if (d >= 29.9d) {
            oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.too_heavy);
            i = 3;
        } else if (d > 24.9d) {
            oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.too_heavy);
            i = 1;
        } else if (d > 18.4d) {
            oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.normal);
            i = 2;
        } else {
            oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.thin);
            i = 0;
        }
        list.add(new TodayData(j, UtilsKt.oI0IIXIo(R.string.weight), f + UtilsKt.oI0IIXIo(R.string.kg) + '\n' + UtilsKt.oI0IIXIo(R.string.bmi) + ':' + TextConvertKt.Oxx0IOOO(f, f2), oI0IIXIo2, i, "weight", 0, mExtraInfo, f, f3, 64, null));
    }

    public final void x0o(@OXOo.OOXIXo View layout, @OXOo.OOXIXo final View btn, @OXOo.OOXIXo final TextView tv, @OXOo.OOXIXo final Activity activity, @OXOo.OOXIXo final String itemType, @OXOo.OOXIXo String query, final long j) {
        int i;
        kotlin.jvm.internal.IIX0o.x0xO0oo(layout, "layout");
        kotlin.jvm.internal.IIX0o.x0xO0oo(btn, "btn");
        kotlin.jvm.internal.IIX0o.x0xO0oo(tv, "tv");
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemType, "itemType");
        kotlin.jvm.internal.IIX0o.x0xO0oo(query, "query");
        final String O0xOxO2 = O0xOxO(this, itemType, o00(itemType), query, 0, 8, null);
        if (ProjectManager.f19822oIX0oI.IoIOOxIIo()) {
            btn.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.util.XI0IXoo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HeathReportsUtils.XOxIOxOx(activity, btn, O0xOxO2, tv, itemType, j, view);
                }
            });
            i = 0;
        } else {
            i = 8;
        }
        layout.setVisibility(i);
    }

    public final void x0xO0oo(Activity activity, Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo, int i) {
        int i2;
        if (i == f24222x0XOIxOo) {
            oooxoxo.invoke(Boolean.TRUE);
            return;
        }
        long[] OxI2 = xoIox.OxI(null, TimePeriod.DAY, 0, 5, null);
        List<HeartRate> heartRates = XxX0x0xxx().getHeartRates(OxI2[0], OxI2[1]);
        long j = Xo0.f24349oIX0oI.oIX0oI().getLong(XoI0Ixx0.f24436o0IXXIx, 0L);
        if (!heartRates.isEmpty() && j + xoIox.f24684IO <= System.currentTimeMillis()) {
            oooxoxo.invoke(Boolean.FALSE);
            activity.startActivity(new Intent(activity, (Class<?>) HeathReportsGenerateActivity.class));
        } else {
            if (heartRates.isEmpty()) {
                i2 = R.string.heath_reports_lack_of_data_tip;
            } else {
                i2 = R.string.heath_reports_unchanged_of_data_tip;
            }
            oxxXoxO(activity, R.string.guide_warm_title, i2, R.string.game_detail_guidance_knew, R.string.heath_reports_history_btn, oooxoxo, i);
        }
    }

    public final WorkoutDao xI() {
        return (WorkoutDao) f24224xxIXOIIO.getValue();
    }

    public final boolean xII(long j, long j2) {
        Instant ofEpochMilli;
        ZoneId systemDefault;
        ZonedDateTime atZone;
        LocalDate localDate;
        Instant ofEpochMilli2;
        ZoneId systemDefault2;
        ZonedDateTime atZone2;
        LocalDate localDate2;
        boolean isEqual;
        if (Build.VERSION.SDK_INT >= 26) {
            ofEpochMilli = Instant.ofEpochMilli(j);
            systemDefault = ZoneId.systemDefault();
            atZone = ofEpochMilli.atZone(systemDefault);
            localDate = atZone.toLocalDate();
            ofEpochMilli2 = Instant.ofEpochMilli(j2);
            systemDefault2 = ZoneId.systemDefault();
            atZone2 = ofEpochMilli2.atZone(systemDefault2);
            localDate2 = atZone2.toLocalDate();
            isEqual = localDate.isEqual(O0xOxO.oIX0oI(localDate2));
            return isEqual;
        }
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(xoIox.xoIxX().format(Long.valueOf(j)), xoIox.xoIxX().format(Long.valueOf(j2)));
    }

    public final void xXOx(@OXOo.OOXIXo Activity activity, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, oXIO0o0XI> action, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.XooIO0oo0()) {
            ProjectManager projectManager = ProjectManager.f19822oIX0oI;
            if (!projectManager.IxIo() && !productManager.oO0OX0() && !productManager.XXoO0oX()) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("startHeathAnalyze NO AI inlineSupport = " + productManager.XooIO0oo0() + " , isUserMember = " + projectManager.IxIo() + ",  userMemberLatestDateTime = " + projectManager.xI() + " isSupportSparkChainAI = " + productManager.oO0OX0());
                XoX(this, activity, 0, R.string.ai_benefit_buy_tip, 0, 0, action, i, 26, null);
                return;
            }
        }
        if (Xo0.f24349oIX0oI.oIX0oI().getBoolean(XoI0Ixx0.f24430XoIxOXIXo, false)) {
            x0xO0oo(activity, action, i);
        } else {
            oxxXoxO(activity, R.string.information_authorization, R.string.information_authorization_content, R.string.dis_agree, R.string.agree, action, i);
        }
    }

    public final PressureDao xXxxox0I() {
        return (PressureDao) f24216XO.getValue();
    }

    public final void xoIox(@OXOo.OOXIXo List<TodayData> list, int i, int i2, long j, @OXOo.OOXIXo String mExtraInfo) {
        String str;
        int i3;
        String oI0IIXIo2;
        int i4;
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mExtraInfo, "mExtraInfo");
        if (i2 != 0) {
            i3 = i + i2;
            str = UtilsKt.oI0IIXIo(R.string.night_sleep) + ':' + (i / 60) + UtilsKt.oI0IIXIo(R.string.h) + (i % 60) + UtilsKt.oI0IIXIo(R.string.h_m) + '\n' + UtilsKt.oI0IIXIo(R.string.piecemeal) + ':' + (i2 / 60) + UtilsKt.oI0IIXIo(R.string.h) + (i2 % 60) + UtilsKt.oI0IIXIo(R.string.h_m);
        } else {
            str = UtilsKt.oI0IIXIo(R.string.night_sleep) + ':' + (i / 60) + UtilsKt.oI0IIXIo(R.string.h) + (i % 60) + UtilsKt.oI0IIXIo(R.string.h_m);
            i3 = i;
        }
        String str2 = str;
        int i5 = i3 / 60;
        if (i5 >= 9) {
            oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.lightness_high);
            i4 = 3;
        } else if (i5 >= 7 && i5 < 9) {
            oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.general);
            i4 = 2;
        } else {
            oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.data_lower);
            i4 = 1;
        }
        list.add(new TodayData(j, UtilsKt.oI0IIXIo(R.string.sleep), str2, oI0IIXIo2, i4, "sleep", 0, mExtraInfo, i, i2, 64, null));
    }

    @OXOo.OOXIXo
    public final List<TodayData> xoXoI() {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - xoIox.f24684IO;
        TodayHealthyDataKt.getHealthyDataHeart(XxX0x0xxx().getHeartRates(j, currentTimeMillis), arrayList);
        TodayHealthyDataKt.getBloodPressureDataHeart(XIxXXX0x0().getBloodPressures(j, currentTimeMillis), arrayList);
        TodayHealthyDataKt.getBloodOxyDataHeart(XI0IXoo().getBloodOxygen(j, currentTimeMillis), arrayList);
        oo0xXOI0I(IIX0o().getSleeps(j, currentTimeMillis), arrayList, currentTimeMillis);
        TodayHealthyDataKt.getHealthyDataPressure(xXxxox0I().getPressures(j, currentTimeMillis), arrayList);
        IXxxXO(X0IIOO().getList(j, currentTimeMillis), arrayList);
        Xx000oIo(ooXIXxIX().getWeightsASC(j, currentTimeMillis), arrayList);
        long j2 = currentTimeMillis - 604800000;
        oOXoIIIo(j2, WorkoutDao.DefaultImpls.getListDESC$default(xI(), j2, currentTimeMillis, 0, 4, (Object) null), arrayList);
        return arrayList;
    }

    public final HealthyReportDao xxX() {
        return (HealthyReportDao) f24223xoIox.getValue();
    }
}
