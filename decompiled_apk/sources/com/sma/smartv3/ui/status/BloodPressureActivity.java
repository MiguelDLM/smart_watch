package com.sma.smartv3.ui.status;

import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.status.base.StatusBaseActivity;
import com.sma.smartv3.ui.status.fragment.BloodPressureDayFragment;
import com.sma.smartv3.ui.status.fragment.BloodPressureMonthFragment;
import com.sma.smartv3.ui.status.fragment.BloodPressureWeekFragment;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class BloodPressureActivity extends StatusBaseActivity {
    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    public void initFragment() {
        setDayFragment(new BloodPressureDayFragment());
        setWeeFragment(new BloodPressureWeekFragment());
        setMonthFragment(new BloodPressureMonthFragment());
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    @OXOo.OOXIXo
    public String setTitle() {
        String string = getString(R.string.blood_pressure);
        IIX0o.oO(string, "getString(...)");
        return string;
    }
}
