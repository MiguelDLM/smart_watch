package com.sma.smartv3.ui.status;

import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.status.base.StatusBaseActivity;
import com.sma.smartv3.ui.status.fragment.SleepAllDayDayFragment;
import com.sma.smartv3.ui.status.fragment.SleepAllDayMonthFragment;
import com.sma.smartv3.ui.status.fragment.SleepAllDayWeekFragment;
import com.sma.smartv3.ui.status.fragment.SleepDayFragment;
import com.sma.smartv3.ui.status.fragment.SleepMonthFragment;
import com.sma.smartv3.ui.status.fragment.SleepWeekFragment;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class SleepActivity extends StatusBaseActivity {
    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    public void initFragment() {
        StringBuilder sb = new StringBuilder();
        sb.append("initFragment -> ");
        ProductManager productManager = ProductManager.f20544oIX0oI;
        sb.append(productManager.x0oxIIIX());
        LogUtils.d(sb.toString());
        if (productManager.x0oxIIIX()) {
            setDayFragment(new SleepAllDayDayFragment());
            setWeeFragment(new SleepAllDayWeekFragment());
            setMonthFragment(new SleepAllDayMonthFragment());
        } else {
            setDayFragment(new SleepDayFragment());
            setWeeFragment(new SleepWeekFragment());
            setMonthFragment(new SleepMonthFragment());
        }
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    @OXOo.OOXIXo
    public String setTitle() {
        String string = getString(R.string.sleep);
        IIX0o.oO(string, "getString(...)");
        return string;
    }
}
