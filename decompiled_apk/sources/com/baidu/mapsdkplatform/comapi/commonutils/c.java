package com.baidu.mapsdkplatform.comapi.commonutils;

import com.baidu.mapsdkplatform.comapi.commonutils.b;
import com.baidu.platform.comjni.engine.NAEngine;

/* loaded from: classes7.dex */
class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b.EnumC0140b f6160a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ b d;

    public c(b bVar, b.EnumC0140b enumC0140b, String str, String str2) {
        this.d = bVar;
        this.f6160a = enumC0140b;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        NAEngine.a(this.f6160a.ordinal(), this.b, this.c);
    }
}
