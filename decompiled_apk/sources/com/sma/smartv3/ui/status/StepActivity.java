package com.sma.smartv3.ui.status;

import android.view.View;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.status.base.StatusBaseActivity;
import com.sma.smartv3.ui.status.fragment.StepDayFragment;
import com.sma.smartv3.ui.status.fragment.StepMonthFragment;
import com.sma.smartv3.ui.status.fragment.StepWeekFragment;
import com.sma.smartv3.ui.status.fragment.v2.StepDayV2Fragment;
import com.sma.smartv3.ui.status.fragment.v2.StepMonthV2Fragment;
import com.sma.smartv3.ui.status.fragment.v2.StepWeekV2Fragment;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class StepActivity extends StatusBaseActivity {
    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    public void initFragment() {
        if (ProjectManager.f19822oIX0oI.IIOIX()) {
            setDayFragment(new StepDayV2Fragment());
            setWeeFragment(new StepWeekV2Fragment());
            setMonthFragment(new StepMonthV2Fragment());
        } else {
            setDayFragment(new StepDayFragment());
            setWeeFragment(new StepWeekFragment());
            setMonthFragment(new StepMonthFragment());
        }
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity, com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        if (ProjectManager.f19822oIX0oI.IIOIX()) {
            setStatusBarColor(this, oIxOXo.oxoX.I0Io(getMContext(), R.color.statusBarColor_v2));
            getTable().setBackgroundColor(oIxOXo.oxoX.I0Io(getMContext(), R.color.view_page_tablayout_bg_v2));
            View findViewById = findViewById(R.id.top_line);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        if (ProjectManager.f19822oIX0oI.IIOIX()) {
            return R.layout.activity_status_info_v3;
        }
        return R.layout.activity_status_info;
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    @OXOo.OOXIXo
    public String setTitle() {
        String string = getString(R.string.steps);
        IIX0o.oO(string, "getString(...)");
        return string;
    }
}
