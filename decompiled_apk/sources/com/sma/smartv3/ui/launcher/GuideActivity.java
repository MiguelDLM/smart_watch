package com.sma.smartv3.ui.launcher;

import OXOo.oOoXoXO;
import android.os.Bundle;
import com.bestmafen.androidbase.base.BaseActivity;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public final class GuideActivity extends BaseActivity {
    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ProjectManager.f19822oIX0oI.xoX(getMContext());
        finish();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_launcher;
    }
}
