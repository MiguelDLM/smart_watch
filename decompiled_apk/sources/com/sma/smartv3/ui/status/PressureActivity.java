package com.sma.smartv3.ui.status;

import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.status.base.StatusBaseActivity;
import com.sma.smartv3.ui.status.fragment.PressureDayFragment;
import com.sma.smartv3.ui.status.fragment.PressureMonthFragment;
import com.sma.smartv3.ui.status.fragment.PressureWeekFragment;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class PressureActivity extends StatusBaseActivity {
    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    public void initFragment() {
        setDayFragment(new PressureDayFragment());
        setWeeFragment(new PressureWeekFragment());
        setMonthFragment(new PressureMonthFragment());
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    @OXOo.OOXIXo
    public String setTitle() {
        String string = getString(R.string.pressure);
        IIX0o.oO(string, "getString(...)");
        return string;
    }
}
