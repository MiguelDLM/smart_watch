package com.baidu.mshield.x6.e.a;

import android.annotation.TargetApi;
import com.baidu.mshield.x6.e.f;

@TargetApi(9)
/* loaded from: classes7.dex */
public abstract class a implements e<a> {
    public int d;

    public a() {
        this(5);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        try {
            return aVar.d - this.d;
        } catch (Throwable th) {
            f.a(th);
            return 0;
        }
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        a();
    }

    public a(int i) {
        this.d = i;
    }
}
