package com.sma.smartv3.ui.status;

import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.status.base.StatusBaseActivity;
import com.sma.smartv3.ui.status.fragment.CaloriesDayFragment;
import com.sma.smartv3.ui.status.fragment.CaloriesMonthFragment;
import com.sma.smartv3.ui.status.fragment.CaloriesWeekFragment;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class CaloriesActivity extends StatusBaseActivity {
    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    public void initFragment() {
        setDayFragment(new CaloriesDayFragment());
        setWeeFragment(new CaloriesWeekFragment());
        setMonthFragment(new CaloriesMonthFragment());
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    @OXOo.OOXIXo
    public String setTitle() {
        String string = getString(R.string.calories);
        IIX0o.oO(string, "getString(...)");
        return string;
    }
}
