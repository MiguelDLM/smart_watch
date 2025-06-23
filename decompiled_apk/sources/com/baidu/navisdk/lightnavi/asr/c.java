package com.baidu.navisdk.lightnavi.asr;

import com.baidu.navisdk.asr.f;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public class c {
    private static c d;

    /* renamed from: a, reason: collision with root package name */
    private boolean f6872a = true;
    private boolean b = true;
    private boolean c = true;

    public static c b() {
        if (d == null) {
            d = new c();
        }
        return d;
    }

    public boolean a() {
        return com.baidu.navisdk.asr.d.B().q();
    }

    public void c(boolean z) {
        a(z, this.b, this.c);
    }

    private void a(boolean z, boolean z2, boolean z3) {
        g.ASR.g("XDVoice", "setWakeUpEnableInner : tempEnable = " + z + " powerEnable = " + z2 + " calRouteEnable = " + z3 + " isWakeUpEnable = " + a());
        f.d();
        this.f6872a = z;
        this.b = z2;
        this.c = z3;
        boolean z4 = z2 && z && z3;
        if (a() == z4) {
            return;
        }
        com.baidu.navisdk.asr.d.B().b(z4);
    }

    public void b(boolean z) {
        a(this.f6872a, z, this.c);
    }

    public void a(boolean z) {
        a(this.f6872a, this.b, z);
    }
}
