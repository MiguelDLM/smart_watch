package com.baidu.navisdk.b4nav.func.bindroute;

/* loaded from: classes7.dex */
public class a extends com.baidu.navisdk.b4nav.framework.repository.a {
    private com.baidu.navisdk.b4nav.framework.a b;

    @Override // com.baidu.navisdk.b4nav.framework.repository.a
    public void a() {
    }

    public com.baidu.navisdk.b4nav.framework.a b() {
        return this.b;
    }

    public boolean c() {
        return ((Boolean) this.f6568a.a("is_in_driving_mode", Boolean.FALSE)).booleanValue();
    }

    public void a(boolean z) {
        this.f6568a.b("is_in_driving_mode", Boolean.valueOf(z));
    }
}
