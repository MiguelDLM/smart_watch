package com.sma.smartv3.model;

import OXOo.OOXIXo;
import android.content.Context;
import com.github.mikephil.charting.data.Entry;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.BloodGlucose;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import xx0o0O.x0XOIxOo;

/* loaded from: classes12.dex */
public final class BloodGlucoseDataParse {

    @OOXIXo
    public static final BloodGlucoseDataParse INSTANCE = new BloodGlucoseDataParse();

    private BloodGlucoseDataParse() {
    }

    public final void filterDayData(@OOXIXo Context context, @OOXIXo List<BloodGlucose> data, @OOXIXo LinkedHashMap<Long, ArrayList<BloodGlucose>> weekData, @OOXIXo List<BloodGlucoseDayData> bloodGlucoseDayDataList, @OOXIXo List<Entry> values) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(data, "data");
        IIX0o.x0xO0oo(weekData, "weekData");
        IIX0o.x0xO0oo(bloodGlucoseDayDataList, "bloodGlucoseDayDataList");
        IIX0o.x0xO0oo(values, "values");
        for (BloodGlucose bloodGlucose : data) {
            Iterator<Map.Entry<Long, ArrayList<BloodGlucose>>> it = weekData.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<Long, ArrayList<BloodGlucose>> next = it.next();
                    long longValue = next.getKey().longValue();
                    ArrayList<BloodGlucose> value = next.getValue();
                    if (bloodGlucose.getMTime() < longValue) {
                        value.add(bloodGlucose);
                        break;
                    }
                }
            }
        }
        bloodGlucoseDayDataList.clear();
        Iterator<Map.Entry<Long, ArrayList<BloodGlucose>>> it2 = weekData.entrySet().iterator();
        while (it2.hasNext()) {
            ArrayList<BloodGlucose> value2 = it2.next().getValue();
            BloodGlucoseDayData bloodGlucoseDayData = new BloodGlucoseDayData(0, 0, 0, null, 15, null);
            if (value2.size() != 0) {
                Iterator<BloodGlucose> it3 = value2.iterator();
                int i = 0;
                while (it3.hasNext()) {
                    BloodGlucose next2 = it3.next();
                    if (bloodGlucoseDayData.getMin() == 0 || bloodGlucoseDayData.getMin() > next2.getMValue()) {
                        bloodGlucoseDayData.setMin(next2.getMValue());
                    }
                    if (bloodGlucoseDayData.getMax() < next2.getMValue()) {
                        bloodGlucoseDayData.setMax(next2.getMValue());
                    }
                    i += next2.getMValue();
                }
                bloodGlucoseDayData.setAvg(i / value2.size());
                if (bloodGlucoseDayData.getAvg() < 33) {
                    String string = context.getString(R.string.low);
                    IIX0o.oO(string, "getString(...)");
                    bloodGlucoseDayData.setStatus(string);
                } else if (bloodGlucoseDayData.getAvg() > 70) {
                    String string2 = context.getString(R.string.high);
                    IIX0o.oO(string2, "getString(...)");
                    bloodGlucoseDayData.setStatus(string2);
                } else {
                    String string3 = context.getString(R.string.normal);
                    IIX0o.oO(string3, "getString(...)");
                    bloodGlucoseDayData.setStatus(string3);
                }
            }
            bloodGlucoseDayDataList.add(bloodGlucoseDayData);
        }
        Iterator<BloodGlucoseDayData> it4 = bloodGlucoseDayDataList.iterator();
        float f = 0.0f;
        while (it4.hasNext()) {
            if (it4.next().getAvg() != 0) {
                values.add(new Entry(f, r11.getAvg()));
            }
            f += 1.0f;
        }
    }

    @OOXIXo
    public final BloodGlucoseDayData filterMinuteData(@OOXIXo long[] range, @OOXIXo List<BloodGlucose> bloodGlucoses, @OOXIXo List<Entry> values) {
        int size;
        IIX0o.x0xO0oo(range, "range");
        IIX0o.x0xO0oo(bloodGlucoses, "bloodGlucoses");
        IIX0o.x0xO0oo(values, "values");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long j = range[0];
        long oxoX2 = x0XOIxOo.oxoX(j, range[1], 60000L);
        if (j <= oxoX2) {
            while (true) {
                linkedHashMap.put(Long.valueOf(j), new BloodGlucoseMinuteData(0, 0));
                if (j == oxoX2) {
                    break;
                }
                j += 60000;
            }
        }
        for (BloodGlucose bloodGlucose : bloodGlucoses) {
            Iterator it = linkedHashMap.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    long longValue = ((Number) entry.getKey()).longValue();
                    BloodGlucoseMinuteData bloodGlucoseMinuteData = (BloodGlucoseMinuteData) entry.getValue();
                    if (bloodGlucose.getMTime() <= longValue) {
                        bloodGlucoseMinuteData.setTotal(bloodGlucoseMinuteData.getTotal() + bloodGlucose.getMValue());
                        bloodGlucoseMinuteData.setNum(bloodGlucoseMinuteData.getNum() + 1);
                        break;
                    }
                }
            }
        }
        Iterator it2 = linkedHashMap.entrySet().iterator();
        float f = 0.0f;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (it2.hasNext()) {
            BloodGlucoseMinuteData bloodGlucoseMinuteData2 = (BloodGlucoseMinuteData) ((Map.Entry) it2.next()).getValue();
            if (bloodGlucoseMinuteData2.getNum() != 0 && bloodGlucoseMinuteData2.getTotal() != 0) {
                int total = bloodGlucoseMinuteData2.getTotal() / bloodGlucoseMinuteData2.getNum();
                values.add(new Entry(f, total));
                if (i2 < total) {
                    i2 = total;
                }
                if (i3 == 0) {
                    i3 = total;
                }
                if (1 <= total && total < i3) {
                    i3 = total;
                }
                i += total;
            }
            f += 1.0f;
        }
        if (values.size() == 0) {
            size = 0;
        } else {
            size = i / values.size();
        }
        return new BloodGlucoseDayData(i2, i3, size, null, 8, null);
    }
}
