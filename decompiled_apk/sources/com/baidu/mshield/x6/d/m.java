package com.baidu.mshield.x6.d;

import android.content.Context;

/* loaded from: classes7.dex */
public class m extends com.baidu.mshield.x6.e.a.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6441a;
    public final /* synthetic */ int b;
    public final /* synthetic */ i c;

    public m(i iVar, int i, int i2) {
        this.c = iVar;
        this.f6441a = i;
        this.b = i2;
    }

    @Override // com.baidu.mshield.x6.e.a.a
    public void a() {
        Context context;
        context = this.c.e;
        new e(context, this.f6441a, this.b).a();
    }
}
