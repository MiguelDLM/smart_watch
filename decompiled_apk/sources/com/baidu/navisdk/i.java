package com.baidu.navisdk;

import com.baidu.navisdk.util.common.x;

/* loaded from: classes7.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static i f6859a = new i();

    private i() {
    }

    public static i b() {
        if (f6859a == null) {
            f6859a = new i();
        }
        return f6859a;
    }

    public void a() {
        com.baidu.navisdk.framework.interfaces.pronavi.n n;
        if (!j.d() && (n = x.n()) != null) {
            n.j();
        }
    }
}
