package com.baidu.mshield.x6.e;

import android.content.Context;

/* loaded from: classes7.dex */
public final class m extends com.baidu.mshield.x6.e.a.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6449a;
    public final /* synthetic */ Context b;

    public m(int i, Context context) {
        this.f6449a = i;
        this.b = context;
    }

    @Override // com.baidu.mshield.x6.e.a.a
    public void a() {
        try {
            com.baidu.mshield.b.c.a.a("token respone order trigger token delay : " + this.f6449a);
            Thread.sleep((long) (this.f6449a * 1000));
            com.baidu.mshield.x6.d.i.a(this.b).a(7);
        } catch (Throwable th) {
            f.a(th);
        }
    }
}
