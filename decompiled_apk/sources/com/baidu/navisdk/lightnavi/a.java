package com.baidu.navisdk.lightnavi;

import com.baidu.navisdk.lightnavi.asr.c;
import com.baidu.navisdk.lightnavi.utils.b;

/* loaded from: classes7.dex */
public class a implements com.baidu.navisdk.framework.interfaces.lightnavi.a {
    @Override // com.baidu.navisdk.framework.interfaces.lightnavi.a
    public void Y() {
        b.a(com.baidu.navisdk.framework.a.c().b()).b();
    }

    @Override // com.baidu.navisdk.framework.interfaces.lightnavi.a
    public void a(boolean z) {
        com.baidu.navisdk.lightnavi.controller.a.getInstance().c(z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.lightnavi.a
    public void e0() {
        b.a(com.baidu.navisdk.framework.a.c().b()).a();
    }

    @Override // com.baidu.navisdk.framework.interfaces.lightnavi.a
    public void g(boolean z) {
        c.b().b(z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.lightnavi.a
    public void m(boolean z) {
        com.baidu.navisdk.lightnavi.controller.b.c().a(z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.lightnavi.a
    public void p(boolean z) {
        c.b().c(z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.lightnavi.a
    public boolean t0() {
        return com.baidu.navisdk.lightnavi.controller.a.getInstance().i();
    }

    @Override // com.baidu.navisdk.framework.interfaces.lightnavi.a
    public boolean x() {
        return com.baidu.navisdk.lightnavi.controller.b.c().a();
    }
}
