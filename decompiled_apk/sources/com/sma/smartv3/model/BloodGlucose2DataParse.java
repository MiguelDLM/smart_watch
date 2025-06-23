package com.sma.smartv3.model;

import OXOo.OOXIXo;
import android.content.Context;
import com.github.mikephil.charting.data.BarEntry;
import com.sma.smartv3.db.entity.BloodGlucose2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class BloodGlucose2DataParse {

    @OOXIXo
    public static final BloodGlucose2DataParse INSTANCE = new BloodGlucose2DataParse();

    private BloodGlucose2DataParse() {
    }

    public final void filterDayData(@OOXIXo Context context, @OOXIXo List<BloodGlucose2> data, @OOXIXo LinkedHashMap<Long, ArrayList<BloodGlucose2>> weekData, @OOXIXo List<BloodGlucose2DayData> bloodGlucoseDayDataList, @OOXIXo List<BarEntry> values) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(data, "data");
        IIX0o.x0xO0oo(weekData, "weekData");
        IIX0o.x0xO0oo(bloodGlucoseDayDataList, "bloodGlucoseDayDataList");
        IIX0o.x0xO0oo(values, "values");
        for (BloodGlucose2 bloodGlucose2 : data) {
            Iterator<Map.Entry<Long, ArrayList<BloodGlucose2>>> it = weekData.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<Long, ArrayList<BloodGlucose2>> next = it.next();
                    long longValue = next.getKey().longValue();
                    ArrayList<BloodGlucose2> value = next.getValue();
                    if (bloodGlucose2.getMTime() < longValue) {
                        value.add(bloodGlucose2);
                        break;
                    }
                }
            }
        }
        bloodGlucoseDayDataList.clear();
        Iterator<Map.Entry<Long, ArrayList<BloodGlucose2>>> it2 = weekData.entrySet().iterator();
        while (it2.hasNext()) {
            ArrayList<BloodGlucose2> value2 = it2.next().getValue();
            BloodGlucose2DayData bloodGlucose2DayData = new BloodGlucose2DayData(0, 0, null, 7, null);
            BloodGlucose2 bloodGlucose22 = (BloodGlucose2) CollectionsKt___CollectionsKt.OIoxIx(value2, 0);
            if (bloodGlucose22 != null) {
                double d = 10;
                bloodGlucose2DayData.setMin((int) (bloodGlucose22.getMLowerBound() * d));
                bloodGlucose2DayData.setMax((int) (bloodGlucose22.getMUpperBound() * d));
            }
            bloodGlucoseDayDataList.add(bloodGlucose2DayData);
        }
        float f = 0.0f;
        for (BloodGlucose2DayData bloodGlucose2DayData2 : bloodGlucoseDayDataList) {
            values.add(new BarEntry(f, new float[]{bloodGlucose2DayData2.getMin(), bloodGlucose2DayData2.getMax() - bloodGlucose2DayData2.getMin()}));
            f += 1.0f;
        }
    }

    public final void filterHourData(@OOXIXo Context context, @OOXIXo List<BloodGlucose2> data, @OOXIXo LinkedHashMap<Long, ArrayList<BloodGlucose2>> hourData, @OOXIXo List<BloodGlucose2DayData> hourDataList, @OOXIXo List<BarEntry> values) {
        BloodGlucose2 bloodGlucose2;
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(data, "data");
        IIX0o.x0xO0oo(hourData, "hourData");
        IIX0o.x0xO0oo(hourDataList, "hourDataList");
        IIX0o.x0xO0oo(values, "values");
        for (BloodGlucose2 bloodGlucose22 : data) {
            Iterator<Map.Entry<Long, ArrayList<BloodGlucose2>>> it = hourData.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<Long, ArrayList<BloodGlucose2>> next = it.next();
                    long longValue = next.getKey().longValue();
                    ArrayList<BloodGlucose2> value = next.getValue();
                    if (bloodGlucose22.getMTime() <= longValue) {
                        value.add(bloodGlucose22);
                        break;
                    }
                }
            }
        }
        hourDataList.clear();
        Iterator<Map.Entry<Long, ArrayList<BloodGlucose2>>> it2 = hourData.entrySet().iterator();
        boolean z = false;
        while (it2.hasNext()) {
            ArrayList<BloodGlucose2> value2 = it2.next().getValue();
            BloodGlucose2DayData bloodGlucose2DayData = new BloodGlucose2DayData(0, 0, null, 7, null);
            if (!z && (bloodGlucose2 = (BloodGlucose2) CollectionsKt___CollectionsKt.OIoxIx(value2, 0)) != null) {
                double d = 10;
                bloodGlucose2DayData.setMin((int) (bloodGlucose2.getMLowerBound() * d));
                bloodGlucose2DayData.setMax((int) (bloodGlucose2.getMUpperBound() * d));
                z = true;
            }
            hourDataList.add(bloodGlucose2DayData);
        }
        float f = 0.0f;
        for (BloodGlucose2DayData bloodGlucose2DayData2 : hourDataList) {
            values.add(new BarEntry(f, new float[]{bloodGlucose2DayData2.getMin(), bloodGlucose2DayData2.getMax() - bloodGlucose2DayData2.getMin()}));
            f += 1.0f;
        }
    }
}
