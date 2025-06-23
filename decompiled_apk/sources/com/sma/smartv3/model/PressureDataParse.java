package com.sma.smartv3.model;

import OXOo.OOXIXo;
import android.content.Context;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.Pressure;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import xx0o0O.x0XOIxOo;

/* loaded from: classes12.dex */
public final class PressureDataParse {

    @OOXIXo
    public static final PressureDataParse INSTANCE = new PressureDataParse();

    private PressureDataParse() {
    }

    public final void filterDayData(@OOXIXo Context context, @OOXIXo List<Pressure> data, @OOXIXo LinkedHashMap<Long, ArrayList<Pressure>> weekData, @OOXIXo List<PressureDayData> pressureDayDataList, @OOXIXo List<BarEntry> values) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(data, "data");
        IIX0o.x0xO0oo(weekData, "weekData");
        IIX0o.x0xO0oo(pressureDayDataList, "pressureDayDataList");
        IIX0o.x0xO0oo(values, "values");
        for (Pressure pressure : data) {
            Iterator<Map.Entry<Long, ArrayList<Pressure>>> it = weekData.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<Long, ArrayList<Pressure>> next = it.next();
                    long longValue = next.getKey().longValue();
                    ArrayList<Pressure> value = next.getValue();
                    if (pressure.getMTime() <= longValue) {
                        value.add(pressure);
                        break;
                    }
                }
            }
        }
        pressureDayDataList.clear();
        Iterator<Map.Entry<Long, ArrayList<Pressure>>> it2 = weekData.entrySet().iterator();
        while (it2.hasNext()) {
            ArrayList<Pressure> value2 = it2.next().getValue();
            PressureDayData pressureDayData = new PressureDayData(0, 0, 0, null, 15, null);
            if (value2.size() != 0) {
                Iterator<Pressure> it3 = value2.iterator();
                int i = 0;
                while (it3.hasNext()) {
                    Pressure next2 = it3.next();
                    if (pressureDayData.getMin() == 0 || pressureDayData.getMin() > next2.getMValue()) {
                        pressureDayData.setMin(next2.getMValue());
                    }
                    if (pressureDayData.getMax() < next2.getMValue()) {
                        pressureDayData.setMax(next2.getMValue());
                    }
                    i += next2.getMValue();
                }
                pressureDayData.setAvg(i / value2.size());
                if (pressureDayData.getAvg() < 25) {
                    String string = context.getString(R.string.pressure_level_relax);
                    IIX0o.oO(string, "getString(...)");
                    pressureDayData.setStatus(string);
                } else if (pressureDayData.getAvg() < 50) {
                    String string2 = context.getString(R.string.pressure_level_normal);
                    IIX0o.oO(string2, "getString(...)");
                    pressureDayData.setStatus(string2);
                } else if (pressureDayData.getAvg() < 75) {
                    String string3 = context.getString(R.string.pressure_level_moderate_stress);
                    IIX0o.oO(string3, "getString(...)");
                    pressureDayData.setStatus(string3);
                } else {
                    String string4 = context.getString(R.string.pressure_level_overstress);
                    IIX0o.oO(string4, "getString(...)");
                    pressureDayData.setStatus(string4);
                }
            }
            pressureDayDataList.add(pressureDayData);
        }
        float f = 0.0f;
        for (PressureDayData pressureDayData2 : pressureDayDataList) {
            int min = pressureDayData2.getMin();
            if (pressureDayData2.getMin() == pressureDayData2.getMax()) {
                min = 0;
            }
            float f2 = min;
            values.add(new BarEntry(f, new float[]{f2, pressureDayData2.getMax() - f2}, PressureDataKt.getBarColors(context, pressureDayData2.getAvg())));
            f += 1.0f;
        }
    }

    @OOXIXo
    public final PressureDayData filterHourData(@OOXIXo Context context, @OOXIXo List<Pressure> data, @OOXIXo LinkedHashMap<Long, ArrayList<Pressure>> hourData, @OOXIXo List<PressureDayData> pressureHourDataList, @OOXIXo List<BarEntry> values) {
        int size;
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(data, "data");
        IIX0o.x0xO0oo(hourData, "hourData");
        IIX0o.x0xO0oo(pressureHourDataList, "pressureHourDataList");
        IIX0o.x0xO0oo(values, "values");
        for (Pressure pressure : data) {
            Iterator<Map.Entry<Long, ArrayList<Pressure>>> it = hourData.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<Long, ArrayList<Pressure>> next = it.next();
                    long longValue = next.getKey().longValue();
                    ArrayList<Pressure> value = next.getValue();
                    if (pressure.getMTime() <= longValue) {
                        value.add(pressure);
                        break;
                    }
                }
            }
        }
        pressureHourDataList.clear();
        Iterator<Map.Entry<Long, ArrayList<Pressure>>> it2 = hourData.entrySet().iterator();
        while (it2.hasNext()) {
            ArrayList<Pressure> value2 = it2.next().getValue();
            PressureDayData pressureDayData = new PressureDayData(0, 0, 0, null, 15, null);
            if (value2.size() != 0) {
                Iterator<Pressure> it3 = value2.iterator();
                int i = 0;
                while (it3.hasNext()) {
                    Pressure next2 = it3.next();
                    if (pressureDayData.getMin() == 0 || pressureDayData.getMin() > next2.getMValue()) {
                        pressureDayData.setMin(next2.getMValue());
                    }
                    if (pressureDayData.getMax() < next2.getMValue()) {
                        pressureDayData.setMax(next2.getMValue());
                    }
                    i += next2.getMValue();
                }
                pressureDayData.setAvg(i / value2.size());
                if (pressureDayData.getAvg() < 25) {
                    String string = context.getString(R.string.pressure_level_relax);
                    IIX0o.oO(string, "getString(...)");
                    pressureDayData.setStatus(string);
                } else if (pressureDayData.getAvg() < 50) {
                    String string2 = context.getString(R.string.pressure_level_normal);
                    IIX0o.oO(string2, "getString(...)");
                    pressureDayData.setStatus(string2);
                } else if (pressureDayData.getAvg() < 75) {
                    String string3 = context.getString(R.string.pressure_level_moderate_stress);
                    IIX0o.oO(string3, "getString(...)");
                    pressureDayData.setStatus(string3);
                } else {
                    String string4 = context.getString(R.string.pressure_level_overstress);
                    IIX0o.oO(string4, "getString(...)");
                    pressureDayData.setStatus(string4);
                }
            }
            pressureHourDataList.add(pressureDayData);
        }
        float f = 0.0f;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (PressureDayData pressureDayData2 : pressureHourDataList) {
            float min = pressureDayData2.getMin();
            float max = pressureDayData2.getMax();
            values.add(new BarEntry(f, new float[]{0.0f, pressureDayData2.getAvg()}, PressureDataKt.getBarColors(context, pressureDayData2.getAvg())));
            if (i2 < max) {
                i2 = (int) max;
            }
            if (i3 == 0) {
                i3 = pressureDayData2.getAvg();
            }
            if (min != 0.0f && i3 > min) {
                i3 = (int) min;
            }
            i4 += pressureDayData2.getAvg();
            f += 1.0f;
        }
        if (values.size() == 0) {
            size = 0;
        } else {
            size = i4 / values.size();
        }
        return new PressureDayData(i2, i3, size, null, 8, null);
    }

    @OOXIXo
    public final PressureDayData filterMinuteData(@OOXIXo long[] range, @OOXIXo List<Pressure> pressures, @OOXIXo List<Entry> values) {
        int size;
        IIX0o.x0xO0oo(range, "range");
        IIX0o.x0xO0oo(pressures, "pressures");
        IIX0o.x0xO0oo(values, "values");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long j = range[0];
        long oxoX2 = x0XOIxOo.oxoX(j, range[1], 60000L);
        if (j <= oxoX2) {
            while (true) {
                linkedHashMap.put(Long.valueOf(j), new PressureMinuteData(0, 0));
                if (j == oxoX2) {
                    break;
                }
                j += 60000;
            }
        }
        for (Pressure pressure : pressures) {
            Iterator it = linkedHashMap.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    long longValue = ((Number) entry.getKey()).longValue();
                    PressureMinuteData pressureMinuteData = (PressureMinuteData) entry.getValue();
                    if (pressure.getMTime() <= longValue) {
                        pressureMinuteData.setTotal(pressureMinuteData.getTotal() + pressure.getMValue());
                        pressureMinuteData.setNum(pressureMinuteData.getNum() + 1);
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
            PressureMinuteData pressureMinuteData2 = (PressureMinuteData) ((Map.Entry) it2.next()).getValue();
            if (pressureMinuteData2.getNum() != 0 && pressureMinuteData2.getTotal() != 0) {
                int total = pressureMinuteData2.getTotal() / pressureMinuteData2.getNum();
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
        return new PressureDayData(i2, i3, size, null, 8, null);
    }
}
