package com.baidu.mshield.x0;

import java.util.Timer;

/* loaded from: classes7.dex */
public class b extends com.baidu.mshield.x0.b.a.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EngineImpl f6399a;

    public b(EngineImpl engineImpl) {
        this.f6399a = engineImpl;
    }

    @Override // com.baidu.mshield.x0.b.a.b
    public void a() {
        com.baidu.mshield.x0.j.a aVar;
        try {
            com.baidu.mshield.b.c.a.b("setAliveDate");
            com.baidu.mshield.x0.b.d.g(EngineImpl.mContext);
            com.baidu.mshield.x0.b.d.a(EngineImpl.mContext.getApplicationContext(), d.d, d.f6411a, EngineImpl.sLoadVersion, "1001003", "1001002");
            aVar = this.f6399a.pref;
            if (aVar.c("1001003").equals("")) {
                new Timer().schedule(new c(this), 60000L);
            } else {
                com.baidu.mshield.x0.b.d.k(EngineImpl.mContext);
            }
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
        }
    }
}
