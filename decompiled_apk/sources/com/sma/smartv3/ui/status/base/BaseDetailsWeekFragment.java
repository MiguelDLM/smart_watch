package com.sma.smartv3.ui.status.base;

import OXOo.OOXIXo;
import com.sma.smartv3.util.O00XxXI;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.xoIox;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public abstract class BaseDetailsWeekFragment<T> extends BaseDetailsFragment<T> {

    @OOXIXo
    private List<O00XxXI> weekDay = xoIox.XI0IXoo(getMCalendar().getTimeInMillis());

    @OOXIXo
    private final TimePeriod mTimePeriod = TimePeriod.WEEK;

    @Override // com.sma.smartv3.ui.status.base.BaseStatusFragment
    @OOXIXo
    public TimePeriod getMTimePeriod() {
        return this.mTimePeriod;
    }

    @OOXIXo
    public final List<O00XxXI> getWeekDay() {
        return this.weekDay;
    }

    public final void setWeekDay(@OOXIXo List<O00XxXI> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.weekDay = list;
    }
}
