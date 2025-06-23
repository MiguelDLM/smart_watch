package com.sma.smartv3.model;

import OXOo.OOXIXo;
import com.github.mikephil.charting.data.BarEntry;
import com.sma.smartv3.db.entity.Temperature;
import com.sma.smartv3.util.TextConvertKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class TemperatureDataParse {

    @OOXIXo
    public static final TemperatureDataParse INSTANCE = new TemperatureDataParse();

    private TemperatureDataParse() {
    }

    public final void filterDayData(boolean z, @OOXIXo List<Temperature> data, @OOXIXo LinkedHashMap<Long, ArrayList<Temperature>> weekData, @OOXIXo List<TemperatureDayData> tempDayDataList, @OOXIXo List<BarEntry> values) {
        float f;
        IIX0o.x0xO0oo(data, "data");
        IIX0o.x0xO0oo(weekData, "weekData");
        IIX0o.x0xO0oo(tempDayDataList, "tempDayDataList");
        IIX0o.x0xO0oo(values, "values");
        for (Temperature temperature : data) {
            Iterator<Map.Entry<Long, ArrayList<Temperature>>> it = weekData.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<Long, ArrayList<Temperature>> next = it.next();
                    long longValue = next.getKey().longValue();
                    ArrayList<Temperature> value = next.getValue();
                    if (temperature.getMTime() <= longValue) {
                        value.add(temperature);
                        break;
                    }
                }
            }
        }
        tempDayDataList.clear();
        Iterator<Map.Entry<Long, ArrayList<Temperature>>> it2 = weekData.entrySet().iterator();
        while (true) {
            f = 0.0f;
            if (!it2.hasNext()) {
                break;
            }
            ArrayList<Temperature> value2 = it2.next().getValue();
            TemperatureDayData temperatureDayData = new TemperatureDayData(0.0f, 0.0f, 0.0f, 7, null);
            if (value2.size() != 0) {
                Iterator<Temperature> it3 = value2.iterator();
                float f2 = 0.0f;
                while (it3.hasNext()) {
                    float Oxx0xo2 = TextConvertKt.Oxx0xo(it3.next().getMTemperature(), z);
                    if (temperatureDayData.getMin() == 0.0f || temperatureDayData.getMin() > Oxx0xo2) {
                        temperatureDayData.setMin(Oxx0xo2);
                    }
                    if (temperatureDayData.getMax() < Oxx0xo2) {
                        temperatureDayData.setMax(Oxx0xo2);
                    }
                    f2 += Oxx0xo2;
                }
                temperatureDayData.setAvg(f2 / value2.size());
            }
            tempDayDataList.add(temperatureDayData);
        }
        for (TemperatureDayData temperatureDayData2 : tempDayDataList) {
            if (temperatureDayData2.getMax() == temperatureDayData2.getMin() && temperatureDayData2.getMin() > 30.0f) {
                temperatureDayData2.setMax(temperatureDayData2.getMax() + 0.01f);
            }
            values.add(new BarEntry(f, new float[]{temperatureDayData2.getMin(), temperatureDayData2.getMax() - temperatureDayData2.getMin()}));
            f += 1.0f;
        }
    }
}
