package com.baidu.mshield.x0.b.a;

import android.annotation.TargetApi;

@TargetApi(9)
/* loaded from: classes7.dex */
public abstract class b implements a<b> {
    public int b;

    public b() {
        this(5);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        try {
            return bVar.b - this.b;
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
            return 0;
        }
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        a();
    }

    public b(int i) {
        this.b = i;
    }
}
