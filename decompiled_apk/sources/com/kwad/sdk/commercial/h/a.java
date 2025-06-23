package com.kwad.sdk.commercial.h;

import android.content.Context;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ksad.annotation.invoker.InvokeBy;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.core.c.b;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.h.g;
import com.kwad.sdk.h.h;
import com.kwad.sdk.m.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.az;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes11.dex */
public final class a implements com.kwad.sdk.core.e.a.a {
    private final AtomicBoolean Kc;

    /* renamed from: com.kwad.sdk.commercial.h.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C0842a {
        private static final a apK = new a(0);
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static a Bz() {
        return C0842a.apK;
    }

    @InvokeBy(invokerClass = c.class, methodId = "registerLogger")
    public static void register() {
        c.a(Bz());
    }

    public final void cM(String str) {
        try {
            if (this.Kc.get()) {
                return;
            }
            Context Lw = ServiceProvider.Lw();
            final f fVar = (f) ServiceProvider.get(f.class);
            h.JN().a(str, g.JI().ga(ServiceProvider.Lx().appId).gb(ServiceProvider.getSdkVersion()).gc(aw.getOaid()).gf(aw.cI(Lw)).gd(aw.getDeviceId()).ge(aw.cJ(Lw)).m(fVar.zd()).bE(com.kwad.sdk.components.f.encryptDisable()).gg(fVar.zc()).h(fVar.zf()).n(fVar.ze()), new com.kwad.sdk.h.f() { // from class: com.kwad.sdk.commercial.h.a.1
                @Override // com.kwad.sdk.h.f
                public final void a(String str2, Map<String, String> map, String str3) {
                    fVar.a(str2, map, str3);
                }

                @Override // com.kwad.sdk.h.f
                public final String am(String str2) {
                    return fVar.am(str2);
                }
            });
            b.En();
            b.a(new d() { // from class: com.kwad.sdk.commercial.h.a.2
                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                public final void onBackToBackground() {
                    super.onBackToBackground();
                }

                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                public final void onBackToForeground() {
                    super.onBackToForeground();
                    com.kwad.sdk.utils.g.schedule(new az() { // from class: com.kwad.sdk.commercial.h.a.2.1
                        @Override // com.kwad.sdk.utils.az
                        public final void doTask() {
                            h.JN().JO();
                        }
                    }, 3L, TimeUnit.SECONDS);
                }
            });
            this.Kc.set(true);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void d(String str, String str2) {
        h.JN().f("d", str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void e(String str, String str2) {
        h.JN().f(e.TAG, str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void i(String str, String str2) {
        h.JN().f("i", str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void printStackTraceOnly(Throwable th) {
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void v(String str, String str2) {
        h.JN().f(t.c, str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void w(String str, String str2) {
        h.JN().f(IAdInterListener.AdReqParam.WIDTH, str, str2);
    }

    private a() {
        this.Kc = new AtomicBoolean(false);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void v(String str, String str2, boolean z) {
        h.JN().f(t.c, str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void w(String str, String str2, boolean z) {
        h.JN().f(IAdInterListener.AdReqParam.WIDTH, str, str2);
    }
}
