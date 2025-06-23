package com.baidu.navisdk.behavrules;

import android.text.TextUtils;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private e f6637a = new e();

    public com.baidu.navisdk.behavrules.scene.b a(String str, a aVar) {
        return a(str, aVar, true);
    }

    public com.baidu.navisdk.behavrules.scene.b a(String str, a aVar, boolean z) {
        com.baidu.navisdk.behavrules.scene.b a2 = this.f6637a.a(str, aVar);
        if (a2 == null) {
            return null;
        }
        com.baidu.navisdk.behavrules.scene.b a3 = c.c().a(a2.f6654a);
        if (a(a2, a3)) {
            return z ? a3 : a2;
        }
        if (a3 != null) {
            a3.b();
        }
        return a2;
    }

    public boolean a(com.baidu.navisdk.behavrules.scene.b bVar, com.baidu.navisdk.behavrules.scene.b bVar2) {
        return (bVar2 == null || bVar == null || !TextUtils.equals(bVar2.b, bVar.b)) ? false : true;
    }
}
