package com.sma.smartv3.ui.status;

import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.status.base.StatusBaseActivity;
import com.sma.smartv3.ui.status.fragment.DistanceDayFragment;
import com.sma.smartv3.ui.status.fragment.DistanceMonthFragment;
import com.sma.smartv3.ui.status.fragment.DistanceWeekFragment;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class DistanceActivity extends StatusBaseActivity {
    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    public void initFragment() {
        setDayFragment(new DistanceDayFragment());
        setWeeFragment(new DistanceWeekFragment());
        setMonthFragment(new DistanceMonthFragment());
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    @OXOo.OOXIXo
    public String setTitle() {
        String string = getString(R.string.distance);
        IIX0o.oO(string, "getString(...)");
        return string;
    }
}
