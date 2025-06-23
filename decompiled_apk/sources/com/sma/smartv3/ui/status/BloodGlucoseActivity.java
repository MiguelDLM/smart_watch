package com.sma.smartv3.ui.status;

import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.status.base.StatusBaseActivity;
import com.sma.smartv3.ui.status.fragment.BloodGlucoseDayFragment;
import com.sma.smartv3.ui.status.fragment.BloodGlucoseMonthFragment;
import com.sma.smartv3.ui.status.fragment.BloodGlucoseWeekFragment;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class BloodGlucoseActivity extends StatusBaseActivity {
    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    public void initFragment() {
        setDayFragment(new BloodGlucoseDayFragment());
        setWeeFragment(new BloodGlucoseWeekFragment());
        setMonthFragment(new BloodGlucoseMonthFragment());
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    @OXOo.OOXIXo
    public String setTitle() {
        String string = getString(R.string.blood_glucose);
        IIX0o.oO(string, "getString(...)");
        return string;
    }
}
