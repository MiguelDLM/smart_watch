package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.util.SparseIntArray;
import com.blankj.utilcode.util.LogUtils;
import com.github.mikephil.charting.data.BarEntry;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.Sleep;
import com.szabh.smable3.entity.BleSleep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nSleepData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SleepData.kt\ncom/sma/smartv3/model/SleepDataParse\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,174:1\n1559#2:175\n1590#2,4:176\n*S KotlinDebug\n*F\n+ 1 SleepData.kt\ncom/sma/smartv3/model/SleepDataParse\n*L\n31#1:175\n31#1:176,4\n*E\n"})
/* loaded from: classes12.dex */
public final class SleepDataParse {

    @OOXIXo
    public static final SleepDataParse INSTANCE = new SleepDataParse();

    private SleepDataParse() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SleepDayData filterData$default(SleepDataParse sleepDataParse, List list, float f, List list2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 100.0f;
        }
        if ((i & 4) != 0) {
            list2 = null;
        }
        return sleepDataParse.filterData(list, f, list2);
    }

    @OOXIXo
    public final SleepDayData filterData(@OOXIXo List<Sleep> data, float f, @oOoXoXO List<BarEntry> list) {
        SparseIntArray sleepStatusDuration;
        int i;
        int mTime;
        float[] fArr;
        IIX0o.x0xO0oo(data, "data");
        if (data.isEmpty()) {
            return new SleepDayData(0, 0, null, null, 15, null);
        }
        int mAlgorithmType = data.get(0).getMAlgorithmType();
        List<Sleep> list2 = data;
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list2, 10));
        int i2 = 0;
        for (Object obj : list2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            Sleep sleep = (Sleep) obj;
            if (sleep.getMMode() == 17) {
                mAlgorithmType = sleep.getMAlgorithmType();
            }
            arrayList.add(new BleSleep((int) (sleep.getMTime() / 1000), sleep.getMMode(), sleep.getMSoft(), sleep.getMStrong()));
            i2 = i3;
        }
        LogUtils.d("source " + mAlgorithmType + TokenParser.SP + arrayList);
        List<BleSleep> analyseSleep = BleSleep.Companion.analyseSleep(arrayList, mAlgorithmType);
        if (analyseSleep.isEmpty()) {
            return new SleepDayData(0, 0, null, null, 15, null);
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < analyseSleep.size() - 1) {
            BleSleep bleSleep = analyseSleep.get(i4);
            if (i4 == 0) {
                mTime = bleSleep.getMTime() / 60;
            } else {
                mTime = (bleSleep.getMTime() / 60) + 1;
            }
            i4++;
            int mTime2 = analyseSleep.get(i4).getMTime() / 60;
            if (mTime <= mTime2) {
                while (true) {
                    int mMode = bleSleep.getMMode();
                    if (mMode != 1) {
                        if (mMode != 2) {
                            fArr = new float[]{0.0f, 0.0f, f};
                        } else {
                            fArr = new float[]{0.0f, f, 0.0f};
                        }
                    } else {
                        fArr = new float[]{f, 0.0f, 0.0f};
                    }
                    if (list != null) {
                        list.add(new BarEntry(i5, fArr));
                    }
                    i5++;
                    if (mTime != mTime2) {
                        mTime++;
                    }
                }
            }
        }
        if (mAlgorithmType == 1) {
            sleepStatusDuration = BleSleep.Companion.getSleepStatusDuration(analyseSleep, arrayList);
            i = sleepStatusDuration.get(4);
        } else {
            sleepStatusDuration = BleSleep.Companion.getSleepStatusDuration(analyseSleep);
            i = sleepStatusDuration.get(2) + sleepStatusDuration.get(1) + sleepStatusDuration.get(3);
        }
        return new SleepDayData(i, ((BleSleep) CollectionsKt___CollectionsKt.O0OOX0IIx(analyseSleep)).getMTime(), sleepStatusDuration, null, 8, null);
    }

    public final int filterDayData(@OOXIXo Context context, @OOXIXo List<Sleep> data, @OOXIXo LinkedHashMap<Long, ArrayList<Sleep>> monthData, @OOXIXo List<SleepDayData> sleepDayDataList, @OOXIXo List<BarEntry> values) {
        int i = 1;
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(data, "data");
        IIX0o.x0xO0oo(monthData, "monthData");
        IIX0o.x0xO0oo(sleepDayDataList, "sleepDayDataList");
        IIX0o.x0xO0oo(values, "values");
        if (data.isEmpty()) {
            return 0;
        }
        for (Sleep sleep : data) {
            Iterator<Map.Entry<Long, ArrayList<Sleep>>> it = monthData.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<Long, ArrayList<Sleep>> next = it.next();
                    long longValue = next.getKey().longValue();
                    ArrayList<Sleep> value = next.getValue();
                    if (sleep.getMTime() <= longValue) {
                        value.add(sleep);
                        break;
                    }
                }
            }
        }
        Iterator<Map.Entry<Long, ArrayList<Sleep>>> it2 = monthData.entrySet().iterator();
        while (it2.hasNext()) {
            ArrayList<Sleep> value2 = it2.next().getValue();
            SleepDayData sleepDayData = new SleepDayData(0, 0, null, null, 15, null);
            if (!value2.isEmpty()) {
                sleepDayData = filterData$default(this, value2, 0.0f, null, 6, null);
                if (sleepDayData.getTotal() > 60) {
                    if (sleepDayData.getTotal() > 540) {
                        String string = context.getString(R.string.sleepyhead);
                        IIX0o.oO(string, "getString(...)");
                        sleepDayData.setEvaluation(string);
                    } else if (sleepDayData.getTotal() > 420) {
                        if (sleepDayData.getStatus().get(1) >= 120) {
                            String string2 = context.getString(R.string.good);
                            IIX0o.oO(string2, "getString(...)");
                            sleepDayData.setEvaluation(string2);
                        } else if (sleepDayData.getStatus().get(1) >= 60) {
                            String string3 = context.getString(R.string.general);
                            IIX0o.oO(string3, "getString(...)");
                            sleepDayData.setEvaluation(string3);
                        } else {
                            String string4 = context.getString(R.string.bad);
                            IIX0o.oO(string4, "getString(...)");
                            sleepDayData.setEvaluation(string4);
                        }
                    } else {
                        String string5 = context.getString(R.string.bad);
                        IIX0o.oO(string5, "getString(...)");
                        sleepDayData.setEvaluation(string5);
                    }
                } else {
                    sleepDayData.setTotal(0);
                    sleepDayData.setEvaluation(HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
                }
            }
            sleepDayDataList.add(sleepDayData);
        }
        float f = 0.0f;
        int i2 = 0;
        int i3 = 0;
        for (SleepDayData sleepDayData2 : sleepDayDataList) {
            values.add(new BarEntry(f, sleepDayData2.getTotal() / 60.0f));
            f += 1.0f;
            if (sleepDayData2.getTotal() != 0) {
                i2 += sleepDayData2.getTotal();
                i3++;
            }
        }
        LogUtils.d(" sleep " + i2);
        if (i3 != 0) {
            i = i3;
        }
        return i2 / i;
    }
}
