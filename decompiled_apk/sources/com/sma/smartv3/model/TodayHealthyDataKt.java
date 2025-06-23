package com.sma.smartv3.model;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import com.baidu.ar.camera.CameraManager;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.goodix.ble.libcomx.ptmodel.PtStep;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.WorkoutDao;
import com.sma.smartv3.db.entity.BloodGlucose;
import com.sma.smartv3.db.entity.BloodOxygen;
import com.sma.smartv3.db.entity.BloodPressure;
import com.sma.smartv3.db.entity.HeartRate;
import com.sma.smartv3.db.entity.Hrv;
import com.sma.smartv3.db.entity.Pressure;
import com.sma.smartv3.db.entity.Sleep;
import com.sma.smartv3.db.entity.Temperature;
import com.sma.smartv3.db.entity.Workout;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.xoIox;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.o00;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import org.apache.log4j.helpers.x0XOIxOo;
import xX0ox.Oxx0IOOO;

@XX({"SMAP\nTodayHealthyData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TodayHealthyData.kt\ncom/sma/smartv3/model/TodayHealthyDataKt\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,473:1\n19#2:474\n15#2:475\n1855#3,2:476\n1002#3,2:478\n1864#3,3:480\n1864#3,3:483\n*S KotlinDebug\n*F\n+ 1 TodayHealthyData.kt\ncom/sma/smartv3/model/TodayHealthyDataKt\n*L\n60#1:474\n60#1:475\n73#1:476,2\n168#1:478,2\n391#1:480,3\n434#1:483,3\n*E\n"})
/* loaded from: classes12.dex */
public final class TodayHealthyDataKt {
    private static final void addDeepLengthData(int i, List<Sleep> list, List<TodayData> list2, int i2, oOoXoXO<? super Integer, oXIO0o0XI> oooxoxo, SleepAllDayData sleepAllDayData) {
        int i3 = 0;
        if (i != 0) {
            long j = 0;
            long j2 = 0;
            int i4 = 0;
            for (Object obj : list) {
                int i5 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.XoX();
                }
                Sleep sleep = (Sleep) obj;
                if (sleep.getMMode() == 17 && j2 == 0) {
                    j2 = sleep.getMTime();
                    i4 = i3;
                } else if (sleep.getMMode() == 34 && j2 != 0 && j == 0) {
                    if (i4 + 1 != i3) {
                        j = sleep.getMTime();
                    } else {
                        j2 = 0;
                    }
                }
                i3 = i5;
            }
            list2.add(new TodayData(j, UtilsKt.oI0IIXIo(R.string.night_sleep), "", (i / 60) + UtilsKt.oI0IIXIo(R.string.h) + (i % 60) + UtilsKt.oI0IIXIo(R.string.h_m), 0, "sleep", 0, null, i2, 0.0f, CameraManager.DEFAULTHEIGHT, null));
            oooxoxo.invoke(Integer.valueOf(sleepAllDayData.getTotal()));
            return;
        }
        oooxoxo.invoke(0);
    }

    public static final void addHealthyDataBloodOxy(@OOXIXo List<TodayData> list, int i, long j, @OOXIXo String mExtraInfo) {
        String oI0IIXIo2;
        int i2;
        IIX0o.x0xO0oo(list, "list");
        IIX0o.x0xO0oo(mExtraInfo, "mExtraInfo");
        if (i >= 92) {
            oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.pressure_level_normal);
            i2 = 2;
        } else {
            oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.data_lower);
            i2 = 1;
        }
        String oI0IIXIo3 = UtilsKt.oI0IIXIo(R.string.blood_oxygen);
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(x0XOIxOo.f33309xxIXOIIO);
        list.add(new TodayData(j, oI0IIXIo3, sb.toString(), oI0IIXIo2, i2, ProductManager.IO0xO, 0, mExtraInfo, i, 0.0f, 576, null));
    }

    public static /* synthetic */ void addHealthyDataBloodOxy$default(List list, int i, long j, String str, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str = "";
        }
        addHealthyDataBloodOxy(list, i, j, str);
    }

    public static final void addHealthyDataBloodPressure(@OOXIXo List<TodayData> list, int i, int i2, long j, @OOXIXo String mExtraInfo) {
        String oI0IIXIo2;
        int i3;
        IIX0o.x0xO0oo(list, "list");
        IIX0o.x0xO0oo(mExtraInfo, "mExtraInfo");
        if (i >= 130) {
            oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.lightness_high);
            i3 = 3;
        } else if (i >= 90) {
            oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.pressure_level_normal);
            i3 = 2;
        } else {
            oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.data_lower);
            i3 = 1;
        }
        list.add(new TodayData(j, UtilsKt.oI0IIXIo(R.string.blood_oxygen), UtilsKt.oI0IIXIo(R.string.systolic_pressure) + ':' + i + '\n' + UtilsKt.oI0IIXIo(R.string.diastolic_pressure) + ':' + i2, oI0IIXIo2, i3, ProductManager.xxI0XIO, 0, mExtraInfo, i, i2, 64, null));
    }

    public static /* synthetic */ void addHealthyDataBloodPressure$default(List list, int i, int i2, long j, String str, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            str = "";
        }
        addHealthyDataBloodPressure(list, i, i2, j, str);
    }

    public static final void addHealthyDataHeart(@OOXIXo List<TodayData> list, int i, long j, @OOXIXo String mExtraInfo) {
        String oI0IIXIo2;
        int i2;
        IIX0o.x0xO0oo(list, "list");
        IIX0o.x0xO0oo(mExtraInfo, "mExtraInfo");
        if (i >= 0 && i < 61) {
            oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.data_lower);
            i2 = 1;
        } else if (61 <= i && i < 101) {
            oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.pressure_level_normal);
            i2 = 2;
        } else {
            oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.data_high);
            i2 = 3;
        }
        list.add(new TodayData(j, UtilsKt.oI0IIXIo(R.string.heart_rate), i + UtilsKt.oI0IIXIo(R.string.bpm), oI0IIXIo2, i2, "heart_rate", 0, mExtraInfo, i, 0.0f, 576, null));
    }

    public static /* synthetic */ void addHealthyDataHeart$default(List list, int i, long j, String str, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str = "";
        }
        addHealthyDataHeart(list, i, j, str);
    }

    public static final void addHealthyDataPressure(@OOXIXo List<TodayData> list, int i, long j, @OOXIXo String mExtraInfo) {
        String str;
        int i2;
        IIX0o.x0xO0oo(list, "list");
        IIX0o.x0xO0oo(mExtraInfo, "mExtraInfo");
        String oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.pressure_level_overstress);
        if (i < 25) {
            str = UtilsKt.oI0IIXIo(R.string.pressure_level_relax);
            i2 = 2;
        } else if (i < 50) {
            str = UtilsKt.oI0IIXIo(R.string.pressure_level_normal);
            i2 = 1;
        } else if (i < 75) {
            str = UtilsKt.oI0IIXIo(R.string.pressure_level_moderate_stress);
            i2 = 0;
        } else {
            str = oI0IIXIo2;
            i2 = 3;
        }
        list.add(new TodayData(j, UtilsKt.oI0IIXIo(R.string.pressure), String.valueOf(i), str, i2, ProductManager.oXoxo0x, 0, mExtraInfo, i, 0.0f, 576, null));
    }

    public static /* synthetic */ void addHealthyDataPressure$default(List list, int i, long j, String str, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str = "";
        }
        addHealthyDataPressure(list, i, j, str);
    }

    private static final void addPiecemealData(int i, List<Sleep> list, List<TodayData> list2) {
        if (ProductManager.f20544oIX0oI.x0oxIIIX() && i != 0) {
            int i2 = 0;
            long j = 0;
            long j2 = 0;
            int i3 = 0;
            for (Object obj : list) {
                int i4 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.XoX();
                }
                Sleep sleep = (Sleep) obj;
                if (sleep.getMMode() == 17 && j == 0) {
                    j = sleep.getMTime();
                    i3 = i2;
                } else if (sleep.getMMode() == 34 && j != 0) {
                    j2 = sleep.getMTime();
                } else if (i3 + 1 == i2 && j2 == 0) {
                    j = 0;
                }
                i2 = i4;
            }
            addPiecemealTime(j, j2, list2, i);
        }
    }

    private static final void addPiecemealTime(long j, long j2, List<TodayData> list, int i) {
        if (j != 0 && j2 != 0) {
            list.add(new TodayData(j2, UtilsKt.oI0IIXIo(R.string.piecemeal), "", (i / 60) + UtilsKt.oI0IIXIo(R.string.h) + (i % 60) + UtilsKt.oI0IIXIo(R.string.h_m), 0, "sleep", 0, null, i, (float) j, 208, null));
        }
    }

    private static final void addWorkList(Workout workout, List<TodayData> list, AppUser appUser) {
        String str;
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (ProductManager.IXX(productManager, workout.getMMode(), false, 2, null)) {
            str = TextConvertKt.ooOOo0oXI(workout.getMDistance(), appUser.getUnit(), false, 4, null) + UtilsKt.oI0IIXIo(TextConvertKt.oI0IIXIo(appUser.getUnit())) + TokenParser.SP + (workout.getMCalorie() / 1000) + UtilsKt.oI0IIXIo(R.string.kcal);
        } else {
            str = (workout.getMCalorie() / 1000) + UtilsKt.oI0IIXIo(R.string.kcal);
        }
        list.add(new TodayData(workout.getMEnd(), productManager.xIXX(workout.getMMode()), str, xoIox.IoOoX(workout.getMDuration() * 1000), 0, "sportRecord", workout.getMId(), null, 0.0f, 0.0f, 896, null));
    }

    public static final void getBloodOxyDataHeart(@OOXIXo List<BloodOxygen> bloodOxygenList, @OOXIXo List<TodayData> list) {
        IIX0o.x0xO0oo(bloodOxygenList, "bloodOxygenList");
        IIX0o.x0xO0oo(list, "list");
        if (!bloodOxygenList.isEmpty()) {
            BloodOxygen bloodOxygen = (BloodOxygen) CollectionsKt___CollectionsKt.O0O0Io00X(bloodOxygenList);
            addHealthyDataBloodOxy$default(list, bloodOxygen.getMValue(), bloodOxygen.getMTime(), null, 8, null);
        }
    }

    public static final void getBloodPressureDataHeart(@OOXIXo List<BloodPressure> bloodPressureList, @OOXIXo List<TodayData> list) {
        IIX0o.x0xO0oo(bloodPressureList, "bloodPressureList");
        IIX0o.x0xO0oo(list, "list");
        if (!bloodPressureList.isEmpty()) {
            BloodPressure bloodPressure = (BloodPressure) CollectionsKt___CollectionsKt.O0O0Io00X(bloodPressureList);
            addHealthyDataBloodPressure$default(list, bloodPressure.getMSystolic(), bloodPressure.getMDiastolic(), bloodPressure.getMTime(), null, 16, null);
        }
    }

    public static final void getHealthyDataHeart(@OOXIXo List<HeartRate> heartList, @OOXIXo List<TodayData> list) {
        IIX0o.x0xO0oo(heartList, "heartList");
        IIX0o.x0xO0oo(list, "list");
        if (!heartList.isEmpty()) {
            HeartRate heartRate = (HeartRate) CollectionsKt___CollectionsKt.O0O0Io00X(heartList);
            addHealthyDataHeart$default(list, heartRate.getMBpm(), heartRate.getMTime(), null, 8, null);
        }
    }

    public static final void getHealthyDataPressure(@OOXIXo List<Pressure> pressureList, @OOXIXo List<TodayData> list) {
        IIX0o.x0xO0oo(pressureList, "pressureList");
        IIX0o.x0xO0oo(list, "list");
        if (!pressureList.isEmpty()) {
            Pressure pressure = (Pressure) CollectionsKt___CollectionsKt.O0O0Io00X(pressureList);
            addHealthyDataPressure$default(list, pressure.getMValue(), pressure.getMTime(), null, 8, null);
        }
    }

    @OOXIXo
    public static final List<TodayData> getItemHealthyData(boolean z, @OOXIXo oOoXoXO<? super Integer, oXIO0o0XI> callback) {
        boolean z2;
        String oI0IIXIo2;
        int i;
        IIX0o.x0xO0oo(callback, "callback");
        ArrayList arrayList = new ArrayList();
        long[] OxI2 = xoIox.OxI(null, TimePeriod.DAY, 0, 5, null);
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        AppUser appUser2 = (AppUser) appUser;
        MyDb myDb = MyDb.INSTANCE;
        getHealthyDataHeart(myDb.getMDatabase().heartRateDao().getHeartRates(OxI2[0], OxI2[1]), arrayList);
        getBloodOxyDataHeart(myDb.getMDatabase().bloodOxygenDao().getBloodOxygen(OxI2[0], OxI2[1]), arrayList);
        List listDESC$default = WorkoutDao.DefaultImpls.getListDESC$default(myDb.getMDatabase().workoutDao(), OxI2[0], OxI2[1], 0, 4, (Object) null);
        if (!listDESC$default.isEmpty()) {
            Iterator it = listDESC$default.iterator();
            while (it.hasNext()) {
                addWorkList((Workout) it.next(), arrayList, appUser2);
            }
        }
        MyDb myDb2 = MyDb.INSTANCE;
        getHealthyDataPressure(myDb2.getMDatabase().pressureDao().getPressures(OxI2[0], OxI2[1]), arrayList);
        getSleepList(myDb2.getMDatabase().sleepDao().getSleeps(OxI2[0] - 28800000, OxI2[1]), arrayList, OxI2[0], callback);
        List<Hrv> hrv = myDb2.getMDatabase().hrvDao().getHrv(OxI2[0], OxI2[1]);
        if (!hrv.isEmpty()) {
            Hrv hrv2 = (Hrv) CollectionsKt___CollectionsKt.O0O0Io00X(hrv);
            arrayList.add(new TodayData(hrv2.getMTime(), UtilsKt.oI0IIXIo(R.string.hrv), hrv2.getMValue() + UtilsKt.oI0IIXIo(R.string.ms), null, 0, ProductManager.oIIX, 0, null, hrv2.getMValue(), 0.0f, PtStep.EVT_JUDGE_UPDATED, null));
        }
        List<BloodPressure> bloodPressures = myDb2.getMDatabase().bloodPressureDao().getBloodPressures(OxI2[0], OxI2[1]);
        if (!bloodPressures.isEmpty()) {
            BloodPressure bloodPressure = (BloodPressure) CollectionsKt___CollectionsKt.O0O0Io00X(bloodPressures);
            if (bloodPressure.getMDiastolic() < 140 && bloodPressure.getMSystolic() < 90) {
                if (bloodPressure.getMDiastolic() < 90 && bloodPressure.getMSystolic() < 60) {
                    oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.data_lower);
                    i = 1;
                } else {
                    oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.pressure_level_normal);
                    i = 2;
                }
            } else {
                oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.data_high);
                i = 3;
            }
            long mTime = bloodPressure.getMTime();
            String oI0IIXIo3 = UtilsKt.oI0IIXIo(R.string.blood_pressure);
            StringBuilder sb = new StringBuilder();
            sb.append(bloodPressure.getMSystolic());
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append(bloodPressure.getMDiastolic());
            arrayList.add(new TodayData(mTime, oI0IIXIo3, sb.toString(), oI0IIXIo2, i, ProductManager.xxI0XIO, 0, null, bloodPressure.getMSystolic(), bloodPressure.getMDiastolic(), 192, null));
        }
        List<Temperature> listDesc = myDb2.getMDatabase().temperatureDao().getListDesc(OxI2[0], OxI2[1]);
        if (!listDesc.isEmpty()) {
            Temperature temperature = (Temperature) CollectionsKt___CollectionsKt.O0O0Io00X(listDesc);
            float mTemperature = temperature.getMTemperature() / 10.0f;
            if (TextConvertKt.XI0IXoo(appUser2.getUnit()) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new TodayData(temperature.getMTime(), UtilsKt.oI0IIXIo(R.string.temperature), String.valueOf(TextConvertKt.XIxXXX0x0(mTemperature, z2)), null, 0, "temperature", 0, null, temperature.getMTemperature(), 0.0f, PtStep.EVT_JUDGE_UPDATED, null));
        }
        List<BloodGlucose> listDesc2 = myDb2.getMDatabase().bloodGlucoseDao().getListDesc(OxI2[0], OxI2[1]);
        if (!listDesc2.isEmpty()) {
            BloodGlucose bloodGlucose = (BloodGlucose) CollectionsKt___CollectionsKt.O0O0Io00X(listDesc2);
            arrayList.add(new TodayData(bloodGlucose.getMTime(), UtilsKt.oI0IIXIo(R.string.blood_glucose), String.valueOf(bloodGlucose.getMValue()), null, 0, ProductManager.ooIIx, 0, null, bloodGlucose.getMValue(), 0.0f, PtStep.EVT_JUDGE_UPDATED, null));
        }
        if (arrayList.size() > 1) {
            o00.OO0x0xX(arrayList, new Comparator() { // from class: com.sma.smartv3.model.TodayHealthyDataKt$getItemHealthyData$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return Oxx0IOOO.oOoXoXO(Long.valueOf(-((TodayData) t).getTime()), Long.valueOf(-((TodayData) t2).getTime()));
                }
            });
        }
        if (!z && arrayList.size() > 3) {
            return CollectionsKt___CollectionsKt.o0Xo0XII(CollectionsKt___CollectionsKt.O0o000XOX(arrayList, 3));
        }
        return arrayList;
    }

    public static /* synthetic */ List getItemHealthyData$default(boolean z, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return getItemHealthyData(z, oooxoxo);
    }

    private static final void getSleepList(List<Sleep> list, List<TodayData> list2, long j, oOoXoXO<? super Integer, oXIO0o0XI> oooxoxo) {
        if (!list.isEmpty()) {
            LogUtils.d("getSleepList==" + ProductManager.f20544oIX0oI.x0oxIIIX());
            SleepAllDayData filterData = SleepAllDayDataParse.INSTANCE.filterData(list, 100.0f, null, j);
            LogUtils.d(filterData.toString());
            int i = filterData.getStatus().get(1) + filterData.getStatus().get(2) + filterData.getStatus().get(3);
            int i2 = filterData.getStatus().get(8);
            addPiecemealData(i2, list, list2);
            addDeepLengthData(i, list, list2, i2, oooxoxo, filterData);
        }
    }

    public static /* synthetic */ void getSleepList$default(List list, List list2, long j, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 0;
        }
        getSleepList(list, list2, j, oooxoxo);
    }
}
