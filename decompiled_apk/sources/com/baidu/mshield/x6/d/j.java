package com.baidu.mshield.x6.d;

import android.content.Context;

/* loaded from: classes7.dex */
public class j extends com.baidu.mshield.x6.e.a.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6438a;
    public final /* synthetic */ i b;

    public j(i iVar, int i) {
        this.b = iVar;
        this.f6438a = i;
    }

    @Override // com.baidu.mshield.x6.e.a.a
    public void a() {
        Context context;
        context = this.b.e;
        new c(context, this.f6438a).a();
    }
}
