package com.sma.smartv3.ui.status.base;

import OXOo.OOXIXo;
import com.sma.smartv3.util.TimePeriod;

/* loaded from: classes12.dex */
public abstract class BaseDetailsMonthFragment<T> extends BaseDetailsFragment<T> {

    @OOXIXo
    private final TimePeriod mTimePeriod = TimePeriod.MONTH;

    @Override // com.sma.smartv3.ui.status.base.BaseStatusFragment
    @OOXIXo
    public TimePeriod getMTimePeriod() {
        return this.mTimePeriod;
    }
}
