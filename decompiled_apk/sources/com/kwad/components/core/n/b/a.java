package com.kwad.components.core.n.b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes11.dex */
public abstract class a<T extends IOfflineCompo<?>> {
    private long Fe;
    private String MZ = "";

    private void am(final Context context) {
        if (com.kwad.components.core.a.IW.booleanValue()) {
            c.d(getTag(), "init start disableOffline");
            a(context, false, getClass().getClassLoader());
            return;
        }
        com.kwad.library.solder.lib.c.b pk = pk();
        c.d(getTag(), "load component start pluginInfo: " + pk);
        com.kwad.library.solder.a.a.a(context, pk, new b.a() { // from class: com.kwad.components.core.n.b.a.1
            long Na;

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0836b, com.kwad.library.solder.lib.ext.b
            public void b(com.kwad.library.solder.lib.b.a aVar) {
                super.b((AnonymousClass1) aVar);
                c.d(a.this.getTag(), "install component resource start");
                com.kwad.components.core.n.c.a.b(a.this.pn(), a.this.getDuration(), a.this.MZ);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0836b, com.kwad.library.solder.lib.ext.b
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(com.kwad.library.solder.lib.b.a aVar) {
                super.a((AnonymousClass1) aVar);
                c.d(a.this.getTag(), "install component resource success");
                com.kwad.components.core.n.c.a.c(a.this.pn(), a.this.getDuration(), a.this.MZ);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0836b, com.kwad.library.solder.lib.ext.b
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void e(com.kwad.library.solder.lib.b.a aVar) {
                super.e((AnonymousClass1) aVar);
                this.Na = SystemClock.elapsedRealtime();
                a.this.MZ = aVar.xY() ? "ASSETS" : "NETWORK";
                c.d(a.this.getTag(), "update component resource start");
                com.kwad.components.core.n.c.c.d(a.this.pn(), a.this.getDuration(), a.this.MZ);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0836b, com.kwad.library.solder.lib.ext.b
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public void c(com.kwad.library.solder.lib.b.a aVar) {
                super.c((AnonymousClass1) aVar);
                c.d(a.this.getTag(), "load component resource start");
                a.this.MZ = "LOCAL";
                com.kwad.components.core.n.c.a.b(a.this.pn(), a.this.getDuration(), aVar.xP().xC().yd());
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0836b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.a aVar, com.kwad.library.b.a aVar2) {
                super.a((AnonymousClass1) aVar, (com.kwad.library.solder.lib.b.a) aVar2);
                c.d(a.this.getTag(), "load component resource success");
                com.kwad.components.core.n.c.a.a(a.this.pn(), a.this.getDuration(), a.this.MZ);
                a.this.a(context, !"LOCAL".equals(r4.MZ), aVar2.xy());
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0836b, com.kwad.library.solder.lib.ext.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void d(com.kwad.library.solder.lib.b.a aVar) {
                super.d((AnonymousClass1) aVar);
                c.d(a.this.getTag(), "update component resource success");
                com.kwad.components.core.n.c.c.a(a.this.pn(), a.this.getDuration(), SystemClock.elapsedRealtime() - this.Na, a.this.MZ);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0836b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.a aVar, PluginError pluginError) {
                super.a((AnonymousClass1) aVar, pluginError);
                if (aVar.getState() == 1) {
                    com.kwad.components.core.n.c.c.b(a.this.pn(), a.this.getDuration(), pluginError.getCode(), a.this.MZ, pluginError.getMessage());
                }
                com.kwad.components.core.n.c.a.a(a.this.pn(), a.this.getDuration(), pluginError.getCode(), "cmp_load_error " + pluginError.getMessage(), a.this.MZ);
                c.d(a.this.getTag(), "load component resource failed error: " + pluginError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getDuration() {
        return SystemClock.elapsedRealtime() - this.Fe;
    }

    private com.kwad.library.solder.lib.c.b pk() {
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        bVar.akV = po();
        bVar.JE = true;
        bVar.akZ = false;
        bVar.akW = com.kwad.sdk.core.network.idc.a.EE().ee(pq());
        bVar.version = pp();
        bVar.akY = pr();
        if (com.kwad.components.core.a.IZ.booleanValue()) {
            bVar.aky = ps();
            bVar.akz = true;
        }
        if (TextUtils.isEmpty(pr()) || TextUtils.isEmpty(po()) || TextUtils.isEmpty(pp()) || TextUtils.isEmpty(pq())) {
            com.kwad.components.core.n.c.a.a(pn(), getDuration(), 6001, "buildRemotePlugInfo error", this.MZ);
        }
        return bVar;
    }

    private void pl() {
        c.d(getTag(), "init component start cost: " + getDuration());
        com.kwad.components.core.n.c.a.d(pn(), getDuration());
    }

    public abstract void a(Context context, boolean z, T t);

    public final void au(int i) {
        c.d(getTag(), "init component error time: " + getDuration());
        com.kwad.components.core.n.c.a.a(pn(), getDuration(), 5001, "cmp_init_error, errorCode:" + i, this.MZ);
    }

    public abstract String getTag();

    public final void init(Context context) {
        try {
            if (isEnabled()) {
                this.Fe = SystemClock.elapsedRealtime();
                com.kwad.components.core.n.c.a.c(pn(), getDuration());
                c.d(getTag(), "init start");
                am(context);
                return;
            }
            try {
                c.d(getTag(), "del start");
                com.kwad.library.solder.a.a.k(context, po());
            } catch (Throwable unused) {
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public abstract boolean isEnabled();

    public final void pm() {
        c.d(getTag(), "init component success cost: " + getDuration());
        com.kwad.components.core.n.c.a.c(pn(), getDuration(), i.xI().xC().yd());
    }

    public abstract String pn();

    public abstract String po();

    public abstract String pp();

    public abstract String pq();

    public abstract String pr();

    public abstract String ps();

    public abstract String pt();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(Context context, boolean z, ClassLoader classLoader) {
        pl();
        String pt = pt();
        try {
            IOfflineCompo iOfflineCompo = (IOfflineCompo) classLoader.loadClass(pt).newInstance();
            c.d(getTag(), "load component instance success: " + iOfflineCompo.getClass().getName() + ", loadFromNet:" + z + ", classLoader:" + classLoader);
            a(context, z, (boolean) iOfflineCompo);
        } catch (Throwable th) {
            com.kwad.components.core.n.c.a.a(pn(), getDuration(), 4005, "loadClass error", this.MZ);
            c.e(getTag(), "loadClass or instance failed: " + pt, th);
        }
    }
}
