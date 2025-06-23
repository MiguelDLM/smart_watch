package com.sma.smartv3.ui.status;

import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.status.base.StatusBaseActivity;
import com.sma.smartv3.ui.status.fragment.BloodOxyGenDayFragment;
import com.sma.smartv3.ui.status.fragment.BloodOxyGenMonthFragment;
import com.sma.smartv3.ui.status.fragment.BloodOxyGenWeekFragment;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class BloodOxyGenActivity extends StatusBaseActivity {
    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    public void initFragment() {
        setDayFragment(new BloodOxyGenDayFragment());
        setWeeFragment(new BloodOxyGenWeekFragment());
        setMonthFragment(new BloodOxyGenMonthFragment());
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    @OXOo.OOXIXo
    public String setTitle() {
        String string = getString(R.string.blood_oxygen);
        IIX0o.oO(string, "getString(...)");
        return string;
    }
}
