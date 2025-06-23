package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;

/* loaded from: classes13.dex */
public final class MenstrualPeriod {

    @OOXIXo
    public static final MenstrualPeriod INSTANCE = new MenstrualPeriod();

    private MenstrualPeriod() {
    }

    @OOXIXo
    public final List<MenstrualPeriodResults> menstrualPeriodCalculation(@OOXIXo String lastMenstrualPeriod, int i, int i2) {
        int i3;
        IIX0o.x0xO0oo(lastMenstrualPeriod, "lastMenstrualPeriod");
        ArrayList arrayList = new ArrayList();
        if (i < 1 || i > 8) {
            return arrayList;
        }
        Date parse = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(lastMenstrualPeriod);
        int i4 = 0;
        while (i4 < i2) {
            if (i4 < i) {
                i3 = 0;
            } else if (i4 >= 9 && i4 < 18) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            Calendar calendar = Calendar.getInstance();
            ArrayList arrayList2 = arrayList;
            calendar.setTimeInMillis(parse.getTime() + (TimeUnit.DAYS.toMillis(1L) * i4));
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            String format = String.format("%d%02d%02d", Arrays.copyOf(new Object[]{Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5))}, 3));
            IIX0o.oO(format, "format(...)");
            arrayList2.add(new MenstrualPeriodResults(format, i3));
            i4++;
            arrayList = arrayList2;
        }
        return arrayList;
    }
}
