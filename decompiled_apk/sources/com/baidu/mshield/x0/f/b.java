package com.baidu.mshield.x0.f;

import android.content.Context;
import com.baidu.mshield.x6.EngineImpl;

/* loaded from: classes7.dex */
public class b extends com.baidu.mshield.x0.b.a.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6416a;
    public final /* synthetic */ long c;
    public final /* synthetic */ Context d;
    public final /* synthetic */ int e;

    public b(a aVar, int i, long j, Context context, int i2) {
        this.f6416a = i;
        this.c = j;
        this.d = context;
        this.e = i2;
    }

    @Override // com.baidu.mshield.x0.b.a.b
    public void a() {
        long j;
        long j2;
        try {
            if (this.f6416a == 1) {
                synchronized (a.class) {
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        j = a.f6415a;
                        if (j != 0) {
                            j2 = a.f6415a;
                            if (currentTimeMillis - j2 < this.c) {
                                return;
                            }
                        }
                        long unused = a.f6415a = currentTimeMillis;
                        EngineImpl.getInstance(this.d).uccs(this.e, this.f6416a);
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            EngineImpl.getInstance(this.d).uccs(this.e, this.f6416a);
        } catch (Throwable th2) {
            com.baidu.mshield.x0.b.d.a(th2);
        }
    }
}
