package com.kwad.sdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.d.a;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.config.item.o;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.report.s;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class j {

    /* loaded from: classes11.dex */
    public static class a implements com.kwad.sdk.service.a.a {
        private a() {
        }

        @Override // com.kwad.sdk.service.a.a
        public final void g(Context context, AdTemplate adTemplate) {
            com.kwad.components.core.e.d.a.a(new a.C0788a(context).ar(adTemplate).aq(true));
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    /* loaded from: classes11.dex */
    public static class b implements com.kwad.sdk.service.a.f {
        private b() {
        }

        @Override // com.kwad.sdk.service.a.f
        public final void a(String str, Map<String, String> map, String str2) {
            com.kwad.sdk.core.a.d.a(str, map, str2);
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean aG(AdTemplate adTemplate) {
            com.kwad.components.a.a.a aVar = (com.kwad.components.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
            if (aVar != null && aVar.ug()) {
                return true;
            }
            return false;
        }

        @Override // com.kwad.sdk.service.a.f
        public final String am(String str) {
            return com.kwad.sdk.core.a.d.am(str);
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getApiVersion() {
            return l.zJ().getApiVersion();
        }

        @Override // com.kwad.sdk.service.a.f
        public final int getApiVersionCode() {
            return l.zJ().getApiVersionCode();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getAppId() {
            return ServiceProvider.getAppId();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getAppName() {
            return ServiceProvider.getAppName();
        }

        @Override // com.kwad.sdk.service.a.f
        public final Context getContext() {
            return ServiceProvider.getContext();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getSDKVersion() {
            l.zJ();
            return l.getSDKVersion();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean pj() {
            com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class);
            if (aVar != null) {
                return aVar.pj();
            }
            return false;
        }

        @Override // com.kwad.sdk.service.a.f
        public final com.kwad.sdk.core.response.b.g uh() {
            com.kwad.components.a.a.a aVar = (com.kwad.components.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
            if (aVar != null) {
                return aVar.uh();
            }
            return null;
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean yV() {
            return l.zJ().yV();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean yW() {
            return l.zJ().yW();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean yX() {
            return l.zJ().yX();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean yY() {
            return l.zJ().yY();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String yZ() {
            return com.kwad.sdk.kgeo.a.yZ();
        }

        @Override // com.kwad.sdk.service.a.f
        public final com.kwad.sdk.core.b za() {
            return com.kwad.sdk.kgeo.a.JD();
        }

        @Override // com.kwad.sdk.service.a.f
        public final List<AdTemplate> zb() {
            return com.kwad.sdk.core.download.b.DO().zb();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String zc() {
            return h.yF();
        }

        @Override // com.kwad.sdk.service.a.f
        public final JSONObject zd() {
            return com.kwad.components.core.o.a.qI().m("", "").toJson();
        }

        @Override // com.kwad.sdk.service.a.f
        public final JSONObject ze() {
            return new com.kwad.sdk.core.report.f((List<com.kwad.sdk.core.report.n>) null).getBodyParams();
        }

        @Override // com.kwad.sdk.service.a.f
        public final Map<String, String> zf() {
            return new com.kwad.sdk.core.report.f((List<com.kwad.sdk.core.report.n>) null).getHeader();
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    /* loaded from: classes11.dex */
    public static class c implements com.kwad.sdk.service.a.h {
        private c() {
        }

        @Override // com.kwad.sdk.service.a.h
        public final int aD(Context context) {
            return com.kwad.sdk.core.config.item.c.bg(context);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean ab(long j) {
            return com.kwad.sdk.core.config.d.ab(j);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean ca(String str) {
            return com.kwad.sdk.core.config.a.ca(str);
        }

        @Override // com.kwad.sdk.service.a.h
        public final int cb(String str) {
            return com.kwad.sdk.core.config.d.cb(str);
        }

        @Override // com.kwad.sdk.service.a.h
        public final <T> T getAppConfigData(T t, com.kwad.sdk.f.b<JSONObject, T> bVar) {
            return (T) com.kwad.sdk.core.config.d.CK().getAppConfigData(null, bVar);
        }

        @Override // com.kwad.sdk.service.a.h
        public final String getAppId() {
            return ServiceProvider.getAppId();
        }

        @Override // com.kwad.sdk.service.a.h
        public final String getUserAgent() {
            return com.kwad.sdk.core.config.d.getUserAgent();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean xn() {
            return com.kwad.sdk.core.config.d.xn();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int zA() {
            return com.kwad.sdk.core.config.d.zA();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zB() {
            return com.kwad.sdk.core.config.d.zB();
        }

        @Override // com.kwad.sdk.service.a.h
        public final String zC() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.auh);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zD() {
            return com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.aul);
        }

        @Override // com.kwad.sdk.service.a.h
        public final String zE() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aur);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zg() {
            return com.kwad.sdk.core.config.d.zg();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zh() {
            return com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.asA);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zi() {
            return com.kwad.sdk.core.config.d.zi();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zj() {
            return com.kwad.sdk.core.config.d.zj();
        }

        @Override // com.kwad.sdk.service.a.h
        public final String zk() {
            return com.kwad.sdk.core.config.d.zk();
        }

        @Override // com.kwad.sdk.service.a.h
        public final String zl() {
            return com.kwad.sdk.core.config.d.zl();
        }

        @Override // com.kwad.sdk.service.a.h
        public final List<String> zm() {
            return com.kwad.sdk.core.config.d.zm();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zn() {
            return com.kwad.sdk.core.config.d.zn();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zo() {
            return com.kwad.sdk.core.config.d.zo();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zp() {
            return com.kwad.sdk.core.config.d.CP();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zq() {
            return com.kwad.sdk.core.config.d.zq();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zr() {
            return com.kwad.sdk.core.config.d.zr();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int zs() {
            return com.kwad.sdk.core.config.d.zs();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int zt() {
            return com.kwad.sdk.core.config.d.zt();
        }

        @Override // com.kwad.sdk.service.a.h
        public final double zu() {
            return com.kwad.sdk.core.config.d.zu();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zv() {
            return com.kwad.sdk.core.config.d.zv();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zw() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.atY);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zx() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.atZ);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zy() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aua);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zz() {
            return com.kwad.sdk.core.config.d.zz();
        }

        public /* synthetic */ c(byte b) {
            this();
        }
    }

    public static void yP() {
        byte b2 = 0;
        ServiceProvider.put(com.kwad.sdk.service.a.f.class, new b(b2));
        ServiceProvider.put(com.kwad.sdk.service.a.h.class, new c(b2));
        ServiceProvider.put(com.kwad.sdk.service.a.e.class, new com.kwad.sdk.service.a.e() { // from class: com.kwad.sdk.j.1
            @Override // com.kwad.sdk.service.a.e
            public final void G(String str, String str2) {
                com.kwad.components.core.d.a.j(str, str2);
            }

            @Override // com.kwad.sdk.service.a.e
            public final void a(final com.kwad.sdk.service.a.c cVar) {
                com.kwad.components.core.d.a.a(new a.b() { // from class: com.kwad.sdk.j.1.1
                    @Override // com.kwad.components.core.d.a.b
                    public final String getKey() {
                        com.kwad.sdk.service.a.c cVar2 = cVar;
                        if (cVar2 != null) {
                            return cVar2.getKey();
                        }
                        return null;
                    }

                    @Override // com.kwad.components.core.d.a.b
                    public final JSONObject getValue() {
                        com.kwad.sdk.service.a.c cVar2 = cVar;
                        if (cVar2 != null) {
                            return cVar2.getValue();
                        }
                        return null;
                    }
                });
            }

            @Override // com.kwad.sdk.service.a.e
            public final void gatherException(Throwable th) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th);
            }

            @Override // com.kwad.sdk.service.a.e
            public final void a(final com.kwad.sdk.service.a.g gVar) {
                com.kwad.components.core.d.a.a(new a.c() { // from class: com.kwad.sdk.j.1.2
                    @Override // com.kwad.components.core.d.a.c
                    public final void onCrashOccur(int i, String str) {
                        com.kwad.sdk.service.a.g gVar2 = gVar;
                        if (gVar2 != null) {
                            gVar2.l(i, str);
                        }
                    }
                });
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.a.d.class, new com.kwad.sdk.service.a.d() { // from class: com.kwad.sdk.j.2
            @Override // com.kwad.sdk.service.a.d
            public final void a(boolean z, String str, String str2, String str3) {
                com.kwad.sdk.core.diskcache.b.a.DM().dB(str);
            }

            @Override // com.kwad.sdk.service.a.d
            public final File bZ(String str) {
                return com.kwad.sdk.core.diskcache.b.a.DM().bZ(str);
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.a.j.class, new com.kwad.sdk.service.a.j() { // from class: com.kwad.sdk.j.3
            @Override // com.kwad.sdk.service.a.j
            public final boolean rd() {
                com.kwad.components.core.p.b.rc();
                return com.kwad.components.core.p.b.rd();
            }

            @Override // com.kwad.sdk.service.a.j
            public final int re() {
                com.kwad.components.core.p.b.rc();
                return com.kwad.components.core.p.b.re();
            }

            @Override // com.kwad.sdk.service.a.j
            public final int rf() {
                return com.kwad.components.core.p.b.rc().rf();
            }

            @Override // com.kwad.sdk.service.a.j
            public final InputStream wrapInputStream(InputStream inputStream) {
                com.kwad.components.core.p.b.rc();
                return com.kwad.components.core.p.b.wrapInputStream(inputStream);
            }
        });
        ServiceProvider.put(com.kwad.sdk.core.network.k.class, new com.kwad.sdk.core.network.k() { // from class: com.kwad.sdk.j.4
            @Override // com.kwad.sdk.core.network.k
            public final void a(com.kwad.sdk.core.network.j jVar) {
                com.kwad.sdk.commercial.b.b(jVar);
            }

            @Override // com.kwad.sdk.core.network.k
            public final com.kwad.sdk.core.b yQ() {
                return com.kwad.components.core.request.model.b.rb();
            }

            @Override // com.kwad.sdk.core.network.k
            public final void a(com.kwad.sdk.core.network.i iVar) {
                com.kwad.sdk.commercial.b.b(iVar);
            }
        });
        ImageLoaderProxy imageLoaderProxy = ImageLoaderProxy.INSTANCE;
        ServiceProvider.put(com.kwad.sdk.service.a.i.class, imageLoaderProxy);
        int a2 = com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.atO);
        if (a2 > 0) {
            imageLoaderProxy.setCacheSize(a2);
        }
        ServiceProvider.put(com.kwad.sdk.service.a.b.class, new com.kwad.sdk.service.a.b() { // from class: com.kwad.sdk.j.5
            @Override // com.kwad.sdk.service.a.b
            public final void H(String str, String str2) {
                com.kwad.sdk.core.e.c.e("image_load_failed_info", "errorMsg:" + str2 + "\nurl:" + str);
            }

            @Override // com.kwad.sdk.service.a.b
            public final void aF(AdTemplate adTemplate) {
                com.kwad.components.core.o.a.qI().f(adTemplate, 21007);
            }

            @Override // com.kwad.sdk.service.a.b
            public final void e(@NonNull JSONObject jSONObject, int i) {
                com.kwad.components.core.o.a.qI().e(jSONObject, i);
            }

            @Override // com.kwad.sdk.service.a.b
            public final void yR() {
                com.kwad.components.core.o.a.qI().ap(ServiceProvider.getContext());
            }
        });
        ServiceProvider.put(s.class, new s() { // from class: com.kwad.sdk.j.6
            @Override // com.kwad.sdk.core.report.s
            public final boolean aa(long j) {
                o oVar = com.kwad.sdk.core.config.c.asn;
                return o.aa(j);
            }

            @Override // com.kwad.sdk.core.report.s
            public final int ue() {
                com.kwad.components.a.a.a aVar = (com.kwad.components.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
                if (aVar != null) {
                    return aVar.ue();
                }
                return 0;
            }

            @Override // com.kwad.sdk.core.report.s
            public final int yS() {
                return com.kwad.sdk.core.config.d.yS();
            }
        });
        ServiceProvider.put(com.kwad.sdk.core.video.a.f.class, new com.kwad.sdk.core.video.a.f() { // from class: com.kwad.sdk.j.7
            @Override // com.kwad.sdk.core.video.a.f
            public final boolean uf() {
                return ((com.kwad.components.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class)).uf();
            }

            @Override // com.kwad.sdk.core.video.a.f
            public final boolean yT() {
                return com.kwad.sdk.core.config.d.yT();
            }

            @Override // com.kwad.sdk.core.video.a.f
            public final boolean yU() {
                return com.kwad.sdk.core.config.d.yU();
            }
        });
        ServiceProvider.put(com.kwad.sdk.utils.b.b.class, new com.kwad.sdk.utils.b.b() { // from class: com.kwad.sdk.j.8
            @Override // com.kwad.sdk.utils.b.b
            public final void a(com.kwad.sdk.utils.b.a aVar) {
                if (aVar == null) {
                    return;
                }
                com.kwad.sdk.commercial.b.b(aVar);
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.a.a.class, new a(b2));
    }
}
