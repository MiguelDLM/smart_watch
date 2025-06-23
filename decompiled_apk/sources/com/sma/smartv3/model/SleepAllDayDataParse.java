package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Application;
import android.content.Context;
import android.util.SparseIntArray;
import androidx.core.content.ContextCompat;
import com.bestmafen.baseble.data.BleReadable;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.github.mikephil.charting.data.BarEntry;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.Sleep;
import com.sma.smartv3.util.xoIox;
import com.szabh.smable3.entity.BleSleep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nSleepAllDayData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SleepAllDayData.kt\ncom/sma/smartv3/model/SleepAllDayDataParse\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 SparseIntArray.kt\nandroidx/core/util/SparseIntArrayKt\n*L\n1#1,273:1\n1549#2:274\n1620#2,3:275\n1864#2,3:278\n30#3:281\n30#3:282\n30#3:283\n30#3:284\n30#3:285\n*S KotlinDebug\n*F\n+ 1 SleepAllDayData.kt\ncom/sma/smartv3/model/SleepAllDayDataParse\n*L\n41#1:274\n41#1:275,3\n51#1:278,3\n118#1:281\n119#1:282\n120#1:283\n121#1:284\n122#1:285\n*E\n"})
/* loaded from: classes12.dex */
public final class SleepAllDayDataParse {

    @OOXIXo
    public static final SleepAllDayDataParse INSTANCE = new SleepAllDayDataParse();

    private SleepAllDayDataParse() {
    }

    public static /* synthetic */ SleepAllDayData filterData$default(SleepAllDayDataParse sleepAllDayDataParse, List list, float f, List list2, long j, int i, Object obj) {
        float f2;
        if ((i & 2) != 0) {
            f2 = 100.0f;
        } else {
            f2 = f;
        }
        if ((i & 4) != 0) {
            list2 = null;
        }
        List list3 = list2;
        if ((i & 8) != 0) {
            j = 0;
        }
        return sleepAllDayDataParse.filterData(list, f2, list3, j);
    }

    @OOXIXo
    public final SleepAllDayData filterData(@OOXIXo List<Sleep> data, float f, @oOoXoXO List<BarEntry> list, long j) {
        long mLocalTime;
        float[] fArr;
        BleSleep bleSleep;
        IIX0o.x0xO0oo(data, "data");
        if (data.isEmpty()) {
            return new SleepAllDayData(0, 0, 0, null, null, null, 63, null);
        }
        BleSleep.Companion companion = BleSleep.Companion;
        List<Sleep> list2 = data;
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list2, 10));
        for (Sleep sleep : list2) {
            arrayList.add(new BleSleep((int) BleReadable.Companion.millisToTime(sleep.getMTime()), sleep.getMMode(), sleep.getMSoft(), sleep.getMStrong()));
        }
        List<BleSleep> analyseSleepAllDay = companion.analyseSleepAllDay(arrayList, j);
        List<BleSleep> sleepAllDayViewDatas = BleSleep.Companion.getSleepAllDayViewDatas(analyseSleepAllDay);
        int i = 0;
        for (Object obj : sleepAllDayViewDatas) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("analyseSleepAllDayView -> " + i + TokenParser.SP + ((BleSleep) obj));
            i = i2;
        }
        if (sleepAllDayViewDatas.isEmpty()) {
            return new SleepAllDayData(0, 0, 0, null, null, null, 63, null);
        }
        float f2 = f / 4;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = 2;
            if (i3 >= sleepAllDayViewDatas.size() - 1) {
                break;
            }
            BleSleep bleSleep2 = sleepAllDayViewDatas.get(i3);
            if (i3 == 0) {
                mLocalTime = (bleSleep2.getMLocalTime() / 1000) / 60;
            } else {
                mLocalTime = ((bleSleep2.getMLocalTime() / 1000) / 60) + 1;
            }
            i3++;
            BleSleep bleSleep3 = sleepAllDayViewDatas.get(i3);
            long mLocalTime2 = (bleSleep3.getMLocalTime() / 1000) / 60;
            if (mLocalTime <= mLocalTime2) {
                while (true) {
                    int mMode = bleSleep2.getMMode();
                    if (mMode == 1) {
                        fArr = new float[i5];
                        fArr[0] = 0.0f;
                        fArr[1] = f2;
                    } else if (mMode == i5) {
                        fArr = new float[i5];
                        fArr[0] = f2;
                        fArr[1] = f2;
                    } else if (mMode == 3) {
                        fArr = new float[i5];
                        fArr[0] = i5 * f2;
                        fArr[1] = f2;
                    } else if (mMode == 8) {
                        fArr = new float[i5];
                        fArr[0] = 0.0f;
                        fArr[1] = 3 * f2;
                    } else if (mMode == 9) {
                        fArr = new float[i5];
                        float f3 = i5 * f2;
                        fArr[0] = f3;
                        fArr[1] = f3;
                    } else if (mMode != 17) {
                        fArr = new float[i5];
                        fArr[0] = 0.0f;
                        fArr[1] = f;
                    } else if (bleSleep3.getMMode() == 8) {
                        fArr = new float[i5];
                        fArr[0] = 0.0f;
                        fArr[1] = 3 * f2;
                    } else {
                        fArr = new float[i5];
                        fArr[0] = 0.0f;
                        fArr[1] = f;
                    }
                    if (list != null) {
                        Application app = Utils.getApp();
                        IIX0o.oO(app, "getApp(...)");
                        bleSleep = bleSleep3;
                        list.add(new BarEntry(i4, fArr, getBarColors(app, bleSleep2.getMMode(), bleSleep3.getMMode())));
                    } else {
                        bleSleep = bleSleep3;
                    }
                    i4++;
                    if (mLocalTime != mLocalTime2) {
                        mLocalTime++;
                        bleSleep3 = bleSleep;
                        i5 = 2;
                    }
                }
            }
        }
        HashMap<Integer, Integer> sleepAllDayStatus = BleSleep.Companion.getSleepAllDayStatus(analyseSleepAllDay);
        SparseIntArray sparseIntArray = new SparseIntArray();
        Integer num = sleepAllDayStatus.get(2);
        if (num == null) {
            num = 0;
        }
        sparseIntArray.put(2, num.intValue());
        Integer num2 = sleepAllDayStatus.get(1);
        if (num2 == null) {
            num2 = 0;
        }
        sparseIntArray.put(1, num2.intValue());
        Integer num3 = sleepAllDayStatus.get(3);
        if (num3 == null) {
            num3 = 0;
        }
        sparseIntArray.put(3, num3.intValue());
        Integer num4 = sleepAllDayStatus.get(9);
        if (num4 == null) {
            num4 = 0;
        }
        sparseIntArray.put(9, num4.intValue());
        Integer num5 = sleepAllDayStatus.get(8);
        if (num5 == null) {
            num5 = 0;
        }
        sparseIntArray.put(8, num5.intValue());
        long j2 = 1000;
        return new SleepAllDayData(sparseIntArray.get(2) + sparseIntArray.get(1) + sparseIntArray.get(3) + sparseIntArray.get(9) + sparseIntArray.get(8), (int) (((BleSleep) CollectionsKt___CollectionsKt.O0OOX0IIx(sleepAllDayViewDatas)).getMLocalTime() / j2), (int) (((BleSleep) CollectionsKt___CollectionsKt.O0O0Io00X(sleepAllDayViewDatas)).getMLocalTime() / j2), sparseIntArray, null, analyseSleepAllDay, 16, null);
    }

    public final int filterDayData(@OOXIXo Context context, @OOXIXo List<Sleep> data, @OOXIXo LinkedHashMap<Long, ArrayList<Sleep>> monthData, @OOXIXo List<SleepAllDayData> sleepDayDataList, @OOXIXo List<BarEntry> values) {
        int i = 1;
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(data, "data");
        IIX0o.x0xO0oo(monthData, "monthData");
        IIX0o.x0xO0oo(sleepDayDataList, "sleepDayDataList");
        IIX0o.x0xO0oo(values, "values");
        if (!data.isEmpty()) {
            Iterator<Sleep> it = data.iterator();
            while (true) {
                long j = 1;
                if (!it.hasNext()) {
                    break;
                }
                Sleep next = it.next();
                for (Map.Entry<Long, ArrayList<Sleep>> entry : monthData.entrySet()) {
                    long longValue = entry.getKey().longValue();
                    ArrayList<Sleep> value = entry.getValue();
                    if (next.getMTime() >= (longValue - TimeUnit.DAYS.toMillis(j)) - xoIox.f24684IO && next.getMTime() <= longValue) {
                        value.add(next);
                    }
                    j = 1;
                }
            }
            for (Map.Entry<Long, ArrayList<Sleep>> entry2 : monthData.entrySet()) {
                long longValue2 = entry2.getKey().longValue();
                ArrayList<Sleep> value2 = entry2.getValue();
                long millis = longValue2 - TimeUnit.DAYS.toMillis(1L);
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("zeroClockTime -> " + xoIox.OO0x0xX().format(Long.valueOf(millis)) + ", " + value2.size());
                SleepAllDayData sleepAllDayData = new SleepAllDayData(0, 0, 0, null, null, null, 63, null);
                if (!value2.isEmpty()) {
                    sleepAllDayData = filterData$default(this, value2, 0.0f, null, millis, 6, null);
                    if (sleepAllDayData.getTotal() > 60) {
                        if (sleepAllDayData.getTotal() > 540) {
                            String string = context.getString(R.string.sleepyhead);
                            IIX0o.oO(string, "getString(...)");
                            sleepAllDayData.setEvaluation(string);
                        } else if (sleepAllDayData.getTotal() > 420) {
                            if (sleepAllDayData.getStatus().get(1) >= 120) {
                                String string2 = context.getString(R.string.good);
                                IIX0o.oO(string2, "getString(...)");
                                sleepAllDayData.setEvaluation(string2);
                            } else if (sleepAllDayData.getStatus().get(1) >= 60) {
                                String string3 = context.getString(R.string.general);
                                IIX0o.oO(string3, "getString(...)");
                                sleepAllDayData.setEvaluation(string3);
                            } else {
                                String string4 = context.getString(R.string.bad);
                                IIX0o.oO(string4, "getString(...)");
                                sleepAllDayData.setEvaluation(string4);
                            }
                        } else {
                            String string5 = context.getString(R.string.bad);
                            IIX0o.oO(string5, "getString(...)");
                            sleepAllDayData.setEvaluation(string5);
                        }
                    } else {
                        sleepAllDayData.setTotal(0);
                        sleepAllDayData.setEvaluation(HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
                    }
                }
                sleepDayDataList.add(sleepAllDayData);
            }
            float f = 0.0f;
            int i2 = 0;
            int i3 = 0;
            for (SleepAllDayData sleepAllDayData2 : sleepDayDataList) {
                values.add(new BarEntry(f, sleepAllDayData2.getTotal() / 60.0f));
                f += 1.0f;
                if (sleepAllDayData2.getTotal() != 0) {
                    i3 += sleepAllDayData2.getTotal();
                    i2++;
                }
            }
            LogUtils.d(" sleep " + i3);
            if (i2 != 0) {
                i = i2;
            }
            return i3 / i;
        }
        return 0;
    }

    @OOXIXo
    public final int[] getBarColors(@OOXIXo Context context, int i, int i2) {
        IIX0o.x0xO0oo(context, "context");
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 8) {
                        if (i != 9) {
                            if (i != 17) {
                                return new int[]{ContextCompat.getColor(context, R.color.transparent), ContextCompat.getColor(context, R.color.transparent)};
                            }
                            if (i2 == 8) {
                                return new int[]{ContextCompat.getColor(context, R.color.sleep_show_8), ContextCompat.getColor(context, R.color.sleep_show_8)};
                            }
                            return new int[]{ContextCompat.getColor(context, R.color.transparent), ContextCompat.getColor(context, R.color.transparent)};
                        }
                        return new int[]{ContextCompat.getColor(context, R.color.sleep_show_10), ContextCompat.getColor(context, R.color.sleep_show_10)};
                    }
                    return new int[]{ContextCompat.getColor(context, R.color.sleep_show_8), ContextCompat.getColor(context, R.color.sleep_show_8)};
                }
                return new int[]{ContextCompat.getColor(context, R.color.sleep_show_1), ContextCompat.getColor(context, R.color.sleep_show_1)};
            }
            return new int[]{ContextCompat.getColor(context, R.color.sleep_show_3), ContextCompat.getColor(context, R.color.sleep_show_3)};
        }
        return new int[]{ContextCompat.getColor(context, R.color.sleep_show_5), ContextCompat.getColor(context, R.color.sleep_show_5)};
    }
}
