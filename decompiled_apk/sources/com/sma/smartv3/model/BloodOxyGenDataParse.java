package com.sma.smartv3.model;

import OXOo.OOXIXo;
import android.content.Context;
import com.github.mikephil.charting.data.Entry;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.BloodOxygen;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import xx0o0O.x0XOIxOo;

/* loaded from: classes12.dex */
public final class BloodOxyGenDataParse {

    @OOXIXo
    public static final BloodOxyGenDataParse INSTANCE = new BloodOxyGenDataParse();

    private BloodOxyGenDataParse() {
    }

    public final void filterDayData(@OOXIXo Context context, @OOXIXo List<BloodOxygen> data, @OOXIXo LinkedHashMap<Long, ArrayList<BloodOxygen>> weekData, @OOXIXo List<BloodOxyGenDayData> bloodOxyGenDayDataList, @OOXIXo List<Entry> values) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(data, "data");
        IIX0o.x0xO0oo(weekData, "weekData");
        IIX0o.x0xO0oo(bloodOxyGenDayDataList, "bloodOxyGenDayDataList");
        IIX0o.x0xO0oo(values, "values");
        for (BloodOxygen bloodOxygen : data) {
            Iterator<Map.Entry<Long, ArrayList<BloodOxygen>>> it = weekData.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<Long, ArrayList<BloodOxygen>> next = it.next();
                    long longValue = next.getKey().longValue();
                    ArrayList<BloodOxygen> value = next.getValue();
                    if (bloodOxygen.getMTime() < longValue) {
                        value.add(bloodOxygen);
                        break;
                    }
                }
            }
        }
        bloodOxyGenDayDataList.clear();
        Iterator<Map.Entry<Long, ArrayList<BloodOxygen>>> it2 = weekData.entrySet().iterator();
        while (it2.hasNext()) {
            ArrayList<BloodOxygen> value2 = it2.next().getValue();
            BloodOxyGenDayData bloodOxyGenDayData = new BloodOxyGenDayData(0, 0, 0, null, 15, null);
            if (value2.size() != 0) {
                Iterator<BloodOxygen> it3 = value2.iterator();
                int i = 0;
                while (it3.hasNext()) {
                    BloodOxygen next2 = it3.next();
                    if (bloodOxyGenDayData.getMin() == 0 || bloodOxyGenDayData.getMin() > next2.getMValue()) {
                        bloodOxyGenDayData.setMin(next2.getMValue());
                    }
                    if (bloodOxyGenDayData.getMax() < next2.getMValue()) {
                        bloodOxyGenDayData.setMax(next2.getMValue());
                    }
                    i += next2.getMValue();
                }
                bloodOxyGenDayData.setAvg(i / value2.size());
                if (bloodOxyGenDayData.getAvg() < 92) {
                    String string = context.getString(R.string.low);
                    IIX0o.oO(string, "getString(...)");
                    bloodOxyGenDayData.setStatus(string);
                } else {
                    String string2 = context.getString(R.string.normal);
                    IIX0o.oO(string2, "getString(...)");
                    bloodOxyGenDayData.setStatus(string2);
                }
            }
            bloodOxyGenDayDataList.add(bloodOxyGenDayData);
        }
        Iterator<BloodOxyGenDayData> it4 = bloodOxyGenDayDataList.iterator();
        float f = 0.0f;
        while (it4.hasNext()) {
            if (it4.next().getAvg() != 0) {
                values.add(new Entry(f, r11.getAvg()));
            }
            f += 1.0f;
        }
    }

    @OOXIXo
    public final BloodOxyGenDayData filterMinuteData(@OOXIXo long[] range, @OOXIXo List<BloodOxygen> bloodOxygens, @OOXIXo List<Entry> values) {
        int size;
        IIX0o.x0xO0oo(range, "range");
        IIX0o.x0xO0oo(bloodOxygens, "bloodOxygens");
        IIX0o.x0xO0oo(values, "values");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long j = range[0];
        long oxoX2 = x0XOIxOo.oxoX(j, range[1], 60000L);
        if (j <= oxoX2) {
            while (true) {
                linkedHashMap.put(Long.valueOf(j), new BloodOxyGenMinuteData(0, 0));
                if (j == oxoX2) {
                    break;
                }
                j += 60000;
            }
        }
        for (BloodOxygen bloodOxygen : bloodOxygens) {
            Iterator it = linkedHashMap.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    long longValue = ((Number) entry.getKey()).longValue();
                    BloodOxyGenMinuteData bloodOxyGenMinuteData = (BloodOxyGenMinuteData) entry.getValue();
                    if (bloodOxygen.getMTime() <= longValue) {
                        bloodOxyGenMinuteData.setTotal(bloodOxyGenMinuteData.getTotal() + bloodOxygen.getMValue());
                        bloodOxyGenMinuteData.setNum(bloodOxyGenMinuteData.getNum() + 1);
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
            BloodOxyGenMinuteData bloodOxyGenMinuteData2 = (BloodOxyGenMinuteData) ((Map.Entry) it2.next()).getValue();
            if (bloodOxyGenMinuteData2.getNum() != 0 && bloodOxyGenMinuteData2.getTotal() != 0) {
                int total = bloodOxyGenMinuteData2.getTotal() / bloodOxyGenMinuteData2.getNum();
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
        return new BloodOxyGenDayData(i2, i3, size, null, 8, null);
    }
}
