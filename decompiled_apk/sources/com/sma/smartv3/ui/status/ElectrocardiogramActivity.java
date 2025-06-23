package com.sma.smartv3.ui.status;

import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.status.base.StatusBaseActivity;
import com.sma.smartv3.ui.status.fragment.EcgDayFragment;
import com.sma.smartv3.ui.status.fragment.EcgMonthFragment;
import com.sma.smartv3.ui.status.fragment.EcgWeekFragment;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class ElectrocardiogramActivity extends StatusBaseActivity {
    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    public void initFragment() {
        setDayFragment(new EcgDayFragment());
        setWeeFragment(new EcgWeekFragment());
        setMonthFragment(new EcgMonthFragment());
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    @OXOo.OOXIXo
    public String setTitle() {
        String string = getString(R.string.electrocardiogram);
        IIX0o.oO(string, "getString(...)");
        return string;
    }
}
