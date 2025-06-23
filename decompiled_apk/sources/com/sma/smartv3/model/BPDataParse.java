package com.sma.smartv3.model;

import OXOo.OOXIXo;
import android.content.Context;
import com.github.mikephil.charting.data.BarEntry;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.BloodPressure;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import xx0o0O.x0XOIxOo;

/* loaded from: classes12.dex */
public final class BPDataParse {

    @OOXIXo
    public static final BPDataParse INSTANCE = new BPDataParse();

    private BPDataParse() {
    }

    public final void filterDayData(@OOXIXo Context context, @OOXIXo List<BloodPressure> data, @OOXIXo LinkedHashMap<Long, ArrayList<BloodPressure>> monthData, @OOXIXo List<BPDayData> bpDayDataList, @OOXIXo List<BarEntry> values) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(data, "data");
        IIX0o.x0xO0oo(monthData, "monthData");
        IIX0o.x0xO0oo(bpDayDataList, "bpDayDataList");
        IIX0o.x0xO0oo(values, "values");
        for (BloodPressure bloodPressure : data) {
            Iterator<Map.Entry<Long, ArrayList<BloodPressure>>> it = monthData.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<Long, ArrayList<BloodPressure>> next = it.next();
                    long longValue = next.getKey().longValue();
                    ArrayList<BloodPressure> value = next.getValue();
                    if (bloodPressure.getMTime() <= longValue) {
                        value.add(bloodPressure);
                        break;
                    }
                }
            }
        }
        bpDayDataList.clear();
        Iterator<Map.Entry<Long, ArrayList<BloodPressure>>> it2 = monthData.entrySet().iterator();
        while (it2.hasNext()) {
            ArrayList<BloodPressure> value2 = it2.next().getValue();
            BPDayData bPDayData = new BPDayData(0, 0, 0, 0, null, 31, null);
            if (value2.size() != 0) {
                Iterator<BloodPressure> it3 = value2.iterator();
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (it3.hasNext()) {
                    BloodPressure next2 = it3.next();
                    if (next2.getMDiastolic() != 0 && next2.getMSystolic() != 0) {
                        if (bPDayData.getDbpMin() == 0 || bPDayData.getDbpMin() > next2.getMDiastolic()) {
                            bPDayData.setDbpMin(next2.getMDiastolic());
                        }
                        if (bPDayData.getDbpMax() < next2.getMDiastolic()) {
                            bPDayData.setDbpMax(next2.getMDiastolic());
                        }
                        if (bPDayData.getSbpMin() == 0 || bPDayData.getSbpMin() > next2.getMSystolic()) {
                            bPDayData.setSbpMin(next2.getMSystolic());
                        }
                        if (bPDayData.getSbpMax() < next2.getMSystolic()) {
                            bPDayData.setSbpMax(next2.getMSystolic());
                        }
                        i2 += next2.getMDiastolic();
                        i3 += next2.getMSystolic();
                        i++;
                    }
                }
                if (i != 0) {
                    int i4 = i2 / i;
                    int i5 = i3 / i;
                    if (i5 >= 140 && i4 >= 90) {
                        String string = context.getString(R.string.high);
                        IIX0o.oO(string, "getString(...)");
                        bPDayData.setStatus(string);
                    } else if (90 <= i5 && i5 < 140 && 60 <= i4 && i4 < 90) {
                        String string2 = context.getString(R.string.normal);
                        IIX0o.oO(string2, "getString(...)");
                        bPDayData.setStatus(string2);
                    } else {
                        String string3 = context.getString(R.string.low);
                        IIX0o.oO(string3, "getString(...)");
                        bPDayData.setStatus(string3);
                    }
                } else {
                    bPDayData.setStatus(HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
                }
            }
            bpDayDataList.add(bPDayData);
        }
        float f = 0.0f;
        for (BPDayData bPDayData2 : bpDayDataList) {
            values.add(new BarEntry(f, new float[]{bPDayData2.getDbpMin(), bPDayData2.getSbpMax() - bPDayData2.getDbpMin()}));
            f += 1.0f;
        }
    }

    public final void filterHourData(@OOXIXo long[] range, @OOXIXo List<BloodPressure> data, @OOXIXo List<BPHourData> hourData, @OOXIXo List<BarEntry> values) {
        IIX0o.x0xO0oo(range, "range");
        IIX0o.x0xO0oo(data, "data");
        IIX0o.x0xO0oo(hourData, "hourData");
        IIX0o.x0xO0oo(values, "values");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long j = range[0];
        long oxoX2 = x0XOIxOo.oxoX(j, range[1], 3600000L);
        if (j <= oxoX2) {
            while (true) {
                linkedHashMap.put(Long.valueOf(j), new BPHourData(0, 0, 0, 0, 0, 0, 0, 0, 255, null));
                if (j == oxoX2) {
                    break;
                } else {
                    j += 3600000;
                }
            }
        }
        for (BloodPressure bloodPressure : data) {
            Iterator it = linkedHashMap.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    long longValue = ((Number) entry.getKey()).longValue();
                    BPHourData bPHourData = (BPHourData) entry.getValue();
                    if (bloodPressure.getMTime() < longValue) {
                        if (bPHourData.getDbpMax() < bloodPressure.getMDiastolic()) {
                            bPHourData.setDbpMax(bloodPressure.getMDiastolic());
                        }
                        if (bPHourData.getDbpMin() > bloodPressure.getMDiastolic() || bPHourData.getDbpMin() == 0) {
                            bPHourData.setDbpMin(bloodPressure.getMDiastolic());
                        }
                        if (bPHourData.getSbpMax() < bloodPressure.getMSystolic()) {
                            bPHourData.setSbpMax(bloodPressure.getMSystolic());
                        }
                        if (bPHourData.getSbpMin() > bloodPressure.getMSystolic() || bPHourData.getSbpMin() == 0) {
                            bPHourData.setSbpMin(bloodPressure.getMSystolic());
                        }
                        bPHourData.setDbpTotal(bPHourData.getDbpTotal() + bloodPressure.getMDiastolic());
                        bPHourData.setDbpNum(bPHourData.getDbpNum() + 1);
                        bPHourData.setSbpTotal(bPHourData.getSbpTotal() + bloodPressure.getMSystolic());
                        bPHourData.setSbpNum(bPHourData.getSbpNum() + 1);
                    }
                }
            }
        }
        hourData.clear();
        Iterator it2 = linkedHashMap.entrySet().iterator();
        int i = 0;
        while (it2.hasNext()) {
            hourData.add((BPHourData) ((Map.Entry) it2.next()).getValue());
            values.add(new BarEntry(i, new float[]{r4.getDbpMin(), r4.getDbpMax() - r4.getDbpMin(), r4.getSbpMin() - r4.getDbpMax(), r4.getSbpMax() - r4.getSbpMin()}));
            i++;
        }
    }
}
