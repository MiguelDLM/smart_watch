package com.baidu.navisdk.pronavi.hd.hdnavi;

import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public final class c extends com.baidu.navisdk.framework.interfaces.pronavi.hd.f {
    public c() {
        super(1);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.f
    public int a() {
        if (g(true)) {
            return 0;
        }
        return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_new_control_panel_bottom_margin);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.f
    public int b(boolean z) {
        if (z) {
            return 11;
        }
        return super.b(z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.f
    public boolean d(boolean z) {
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.f
    public boolean f(boolean z) {
        if (!z && this.f6817a == 3) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.f
    public boolean h(boolean z) {
        return !z;
    }
}
