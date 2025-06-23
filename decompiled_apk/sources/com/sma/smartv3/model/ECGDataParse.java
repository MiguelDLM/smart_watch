package com.sma.smartv3.model;

import OXOo.OOXIXo;
import android.content.Context;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.Electrocardiogram;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import xx0o0O.x0XOIxOo;

/* loaded from: classes12.dex */
public final class ECGDataParse {

    @OOXIXo
    public static final ECGDataParse INSTANCE = new ECGDataParse();

    private ECGDataParse() {
    }

    public final void filterDayData(@OOXIXo Context context, @OOXIXo List<Electrocardiogram> data, @OOXIXo LinkedHashMap<Long, ArrayList<Electrocardiogram>> weekData, @OOXIXo List<ECGDayData> ecgDayDataList, @OOXIXo List<BarEntry> values) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(data, "data");
        IIX0o.x0xO0oo(weekData, "weekData");
        IIX0o.x0xO0oo(ecgDayDataList, "ecgDayDataList");
        IIX0o.x0xO0oo(values, "values");
        for (Electrocardiogram electrocardiogram : data) {
            Iterator<Map.Entry<Long, ArrayList<Electrocardiogram>>> it = weekData.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<Long, ArrayList<Electrocardiogram>> next = it.next();
                    long longValue = next.getKey().longValue();
                    ArrayList<Electrocardiogram> value = next.getValue();
                    if (electrocardiogram.getMTime() <= longValue) {
                        value.add(electrocardiogram);
                        break;
                    }
                }
            }
        }
        ecgDayDataList.clear();
        Iterator<Map.Entry<Long, ArrayList<Electrocardiogram>>> it2 = weekData.entrySet().iterator();
        while (it2.hasNext()) {
            ArrayList<Electrocardiogram> value2 = it2.next().getValue();
            ECGDayData eCGDayData = new ECGDayData(0, 0, 0, null, 15, null);
            if (value2.size() != 0) {
                Iterator<Electrocardiogram> it3 = value2.iterator();
                int i = 0;
                while (it3.hasNext()) {
                    Electrocardiogram next2 = it3.next();
                    if (eCGDayData.getMin() == 0 || eCGDayData.getMin() > next2.getMValue()) {
                        eCGDayData.setMin(next2.getMValue());
                    }
                    if (eCGDayData.getMax() < next2.getMValue()) {
                        eCGDayData.setMax(next2.getMValue());
                    }
                    i += next2.getMValue();
                }
                eCGDayData.setAvg(i / value2.size());
                if (eCGDayData.getAvg() < 60) {
                    String string = context.getString(R.string.low);
                    IIX0o.oO(string, "getString(...)");
                    eCGDayData.setStatus(string);
                } else if (eCGDayData.getAvg() > 100) {
                    String string2 = context.getString(R.string.high);
                    IIX0o.oO(string2, "getString(...)");
                    eCGDayData.setStatus(string2);
                } else {
                    String string3 = context.getString(R.string.normal);
                    IIX0o.oO(string3, "getString(...)");
                    eCGDayData.setStatus(string3);
                }
            }
            ecgDayDataList.add(eCGDayData);
        }
        float f = 0.0f;
        for (ECGDayData eCGDayData2 : ecgDayDataList) {
            values.add(new BarEntry(f, new float[]{eCGDayData2.getMin(), eCGDayData2.getMax() - eCGDayData2.getMin()}));
            f += 1.0f;
        }
    }

    @OOXIXo
    public final ECGDayData filterMinuteData(@OOXIXo long[] range, @OOXIXo List<Electrocardiogram> heartRates, @OOXIXo List<Entry> values) {
        int size;
        IIX0o.x0xO0oo(range, "range");
        IIX0o.x0xO0oo(heartRates, "heartRates");
        IIX0o.x0xO0oo(values, "values");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long j = range[0];
        long oxoX2 = x0XOIxOo.oxoX(j, range[1], 1000L);
        if (j <= oxoX2) {
            while (true) {
                linkedHashMap.put(Long.valueOf(j), new ECGMinuteData(0, 0));
                if (j == oxoX2) {
                    break;
                }
                j += 1000;
            }
        }
        int i = 0;
        int i2 = 0;
        for (Electrocardiogram electrocardiogram : heartRates) {
            Iterator it = linkedHashMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                long longValue = ((Number) entry.getKey()).longValue();
                ECGMinuteData eCGMinuteData = (ECGMinuteData) entry.getValue();
                if (electrocardiogram.getMTime() <= longValue) {
                    eCGMinuteData.setTotal(eCGMinuteData.getTotal() + electrocardiogram.getMValue());
                    eCGMinuteData.setNum(eCGMinuteData.getNum() + 1);
                    break;
                }
            }
            if (i < electrocardiogram.getMValue()) {
                i = electrocardiogram.getMValue();
            }
            if (i2 == 0 || i2 > electrocardiogram.getMValue()) {
                i2 = electrocardiogram.getMValue();
            }
        }
        Iterator it2 = linkedHashMap.entrySet().iterator();
        float f = 0.0f;
        int i3 = 0;
        while (it2.hasNext()) {
            ECGMinuteData eCGMinuteData2 = (ECGMinuteData) ((Map.Entry) it2.next()).getValue();
            if (eCGMinuteData2.getNum() != 0 && eCGMinuteData2.getTotal() != 0) {
                int total = eCGMinuteData2.getTotal() / eCGMinuteData2.getNum();
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
        return new ECGDayData(i, i2, size, null, 8, null);
    }
}
