package com.sma.smartv3.ui.status;

import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.status.base.StatusBaseActivity;
import com.sma.smartv3.ui.status.fragment.TemperatureDayFragment;
import com.sma.smartv3.ui.status.fragment.TemperatureMonthFragment;
import com.sma.smartv3.ui.status.fragment.TemperatureWeekFragment;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class TemperatureActivity extends StatusBaseActivity {
    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    public void initFragment() {
        setDayFragment(new TemperatureDayFragment());
        setWeeFragment(new TemperatureWeekFragment());
        setMonthFragment(new TemperatureMonthFragment());
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    @OXOo.OOXIXo
    public String setTitle() {
        String string = getString(R.string.temperature);
        IIX0o.oO(string, "getString(...)");
        return string;
    }
}
