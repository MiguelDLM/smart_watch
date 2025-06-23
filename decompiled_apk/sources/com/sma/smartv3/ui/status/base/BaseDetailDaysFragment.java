package com.sma.smartv3.ui.status.base;

import OXOo.OOXIXo;
import com.sma.smartv3.util.TimePeriod;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public abstract class BaseDetailDaysFragment<T> extends BaseDetailsFragment<T> {

    @OOXIXo
    private final TimePeriod mTimePeriod = TimePeriod.DAY;
    public long[] range;

    @Override // com.sma.smartv3.ui.status.base.BaseStatusFragment
    @OOXIXo
    public TimePeriod getMTimePeriod() {
        return this.mTimePeriod;
    }

    @OOXIXo
    public final long[] getRange() {
        long[] jArr = this.range;
        if (jArr != null) {
            return jArr;
        }
        IIX0o.XOxIOxOx("range");
        return null;
    }

    public final void setRange(@OOXIXo long[] jArr) {
        IIX0o.x0xO0oo(jArr, "<set-?>");
        this.range = jArr;
    }
}
