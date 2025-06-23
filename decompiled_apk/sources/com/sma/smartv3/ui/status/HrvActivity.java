package com.sma.smartv3.ui.status;

import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.status.base.StatusBaseActivity;
import com.sma.smartv3.ui.status.fragment.HrvDayFragment;
import com.sma.smartv3.ui.status.fragment.HrvMonthFragment;
import com.sma.smartv3.ui.status.fragment.HrvWeekFragment;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class HrvActivity extends StatusBaseActivity {
    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    public void initFragment() {
        setDayFragment(new HrvDayFragment());
        setWeeFragment(new HrvWeekFragment());
        setMonthFragment(new HrvMonthFragment());
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    @OXOo.OOXIXo
    public String setTitle() {
        String string = getString(R.string.hrv);
        IIX0o.oO(string, "getString(...)");
        return string;
    }
}
