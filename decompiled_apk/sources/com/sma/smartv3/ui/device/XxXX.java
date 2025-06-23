package com.sma.smartv3.ui.device;

import com.szabh.smable3.entity.BleSchedule;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes12.dex */
public final class XxXX {
    @OXOo.OOXIXo
    public static final Date oIX0oI(@OXOo.OOXIXo BleSchedule bleSchedule) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bleSchedule, "<this>");
        Calendar calendar = Calendar.getInstance();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(calendar);
        oOXoIIIo.II0xO0.XI0IXoo(calendar, bleSchedule.getMYear());
        oOXoIIIo.II0xO0.o00(calendar, bleSchedule.getMMonth());
        oOXoIIIo.II0xO0.IXxxXO(calendar, bleSchedule.getMDay());
        oOXoIIIo.II0xO0.oI0IIXIo(calendar, bleSchedule.getMHour());
        oOXoIIIo.II0xO0.IIXOooo(calendar, bleSchedule.getMMinute());
        Date time = calendar.getTime();
        kotlin.jvm.internal.IIX0o.oO(time, "getTime(...)");
        return time;
    }
}
