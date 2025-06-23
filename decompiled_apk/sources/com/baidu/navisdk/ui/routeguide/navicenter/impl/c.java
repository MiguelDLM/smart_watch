package com.baidu.navisdk.ui.routeguide.navicenter.impl;

import android.text.TextUtils;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public abstract class c implements com.baidu.navisdk.framework.interfaces.pronavi.g {
    private void b() {
        if (a()) {
            com.baidu.navisdk.module.asr.i.b(JarUtils.getResources().getString(R.string.nsdk_string_rg_route_plan_fail));
        }
    }

    private void c() {
        if (a()) {
            String b = com.baidu.navisdk.module.routepreference.i.j().b();
            if (TextUtils.isEmpty(b)) {
                return;
            }
            com.baidu.navisdk.module.asr.i.b(JarUtils.getResources().getString(R.string.asr_rg_prefer_calc_route_success, b));
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.g
    public void a(int i, int i2) {
        if (a()) {
            com.baidu.navisdk.ui.routeguide.asr.c.n().l();
        }
        if (i == 0) {
            c();
            return;
        }
        if (i == -1) {
            b();
            return;
        }
        if (i == 2) {
            String string = JarUtils.getResources().getString(R.string.asr_rg_pref_offline_not_use_voice_text);
            s.T().a(JarUtils.getResources().getString(R.string.asr_rg_pref_offline_not_use_text), false);
            if (a()) {
                com.baidu.navisdk.module.asr.i.c(string);
                return;
            }
            return;
        }
        if (i == 1) {
            String string2 = JarUtils.getResources().getString(R.string.asr_rg_pref_change_same, com.baidu.navisdk.module.routepreference.i.j().b());
            s.T().a(string2, false);
            if (a()) {
                com.baidu.navisdk.module.asr.i.c(string2);
            }
        }
    }

    public abstract boolean a();
}
