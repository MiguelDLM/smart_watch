package com.sma.smartv3.model;

import OXOo.OOXIXo;
import android.content.Context;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.HeartRate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import xx0o0O.x0XOIxOo;

/* loaded from: classes12.dex */
public final class HRDataParse {

    @OOXIXo
    public static final HRDataParse INSTANCE = new HRDataParse();

    private HRDataParse() {
    }

    public final void filterDayData(@OOXIXo Context context, @OOXIXo List<HeartRate> data, @OOXIXo LinkedHashMap<Long, ArrayList<HeartRate>> weekData, @OOXIXo List<HRDayData> hrDayDataList, @OOXIXo List<BarEntry> values) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(data, "data");
        IIX0o.x0xO0oo(weekData, "weekData");
        IIX0o.x0xO0oo(hrDayDataList, "hrDayDataList");
        IIX0o.x0xO0oo(values, "values");
        for (HeartRate heartRate : data) {
            Iterator<Map.Entry<Long, ArrayList<HeartRate>>> it = weekData.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<Long, ArrayList<HeartRate>> next = it.next();
                    long longValue = next.getKey().longValue();
                    ArrayList<HeartRate> value = next.getValue();
                    if (heartRate.getMTime() <= longValue) {
                        value.add(heartRate);
                        break;
                    }
                }
            }
        }
        hrDayDataList.clear();
        Iterator<Map.Entry<Long, ArrayList<HeartRate>>> it2 = weekData.entrySet().iterator();
        while (it2.hasNext()) {
            ArrayList<HeartRate> value2 = it2.next().getValue();
            HRDayData hRDayData = new HRDayData(0, 0, 0, null, 15, null);
            if (value2.size() != 0) {
                Iterator<HeartRate> it3 = value2.iterator();
                int i = 0;
                while (it3.hasNext()) {
                    HeartRate next2 = it3.next();
                    if (hRDayData.getMin() == 0 || hRDayData.getMin() > next2.getMBpm()) {
                        hRDayData.setMin(next2.getMBpm());
                    }
                    if (hRDayData.getMax() < next2.getMBpm()) {
                        hRDayData.setMax(next2.getMBpm());
                    }
                    i += next2.getMBpm();
                }
                hRDayData.setAvg(i / value2.size());
                if (hRDayData.getAvg() < 60) {
                    String string = context.getString(R.string.low);
                    IIX0o.oO(string, "getString(...)");
                    hRDayData.setStatus(string);
                } else if (hRDayData.getAvg() > 100) {
                    String string2 = context.getString(R.string.high);
                    IIX0o.oO(string2, "getString(...)");
                    hRDayData.setStatus(string2);
                } else {
                    String string3 = context.getString(R.string.normal);
                    IIX0o.oO(string3, "getString(...)");
                    hRDayData.setStatus(string3);
                }
            }
            hrDayDataList.add(hRDayData);
        }
        float f = 0.0f;
        for (HRDayData hRDayData2 : hrDayDataList) {
            values.add(new BarEntry(f, new float[]{hRDayData2.getMin(), hRDayData2.getMax() - hRDayData2.getMin()}));
            f += 1.0f;
        }
    }

    @OOXIXo
    public final HRDayData filterMinuteData(@OOXIXo long[] range, @OOXIXo List<HeartRate> heartRates, @OOXIXo List<Entry> values) {
        int size;
        IIX0o.x0xO0oo(range, "range");
        IIX0o.x0xO0oo(heartRates, "heartRates");
        IIX0o.x0xO0oo(values, "values");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long j = range[0];
        long oxoX2 = x0XOIxOo.oxoX(j, range[1], 60000L);
        if (j <= oxoX2) {
            while (true) {
                linkedHashMap.put(Long.valueOf(j), new HRMinuteData(0, 0));
                if (j == oxoX2) {
                    break;
                }
                j += 60000;
            }
        }
        int i = 0;
        int i2 = 0;
        for (HeartRate heartRate : heartRates) {
            Iterator it = linkedHashMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                long longValue = ((Number) entry.getKey()).longValue();
                HRMinuteData hRMinuteData = (HRMinuteData) entry.getValue();
                if (heartRate.getMTime() <= longValue) {
                    hRMinuteData.setTotal(hRMinuteData.getTotal() + heartRate.getMBpm());
                    hRMinuteData.setNum(hRMinuteData.getNum() + 1);
                    break;
                }
            }
            if (i < heartRate.getMBpm()) {
                i = heartRate.getMBpm();
            }
            if (i2 == 0 || i2 > heartRate.getMBpm()) {
                i2 = heartRate.getMBpm();
            }
        }
        Iterator it2 = linkedHashMap.entrySet().iterator();
        float f = 0.0f;
        int i3 = 0;
        while (it2.hasNext()) {
            HRMinuteData hRMinuteData2 = (HRMinuteData) ((Map.Entry) it2.next()).getValue();
            if (hRMinuteData2.getNum() != 0 && hRMinuteData2.getTotal() != 0) {
                int total = hRMinuteData2.getTotal() / hRMinuteData2.getNum();
                values.add(new Entry(f, total));
                i3 += total;
            }
            f += 1.0f;
        }
        if (values.size() == 0) {
            size = 0;
        } else {
            size = i3 / values.size();
        }
        return new HRDayData(i, i2, size, null, 8, null);
    }
}
