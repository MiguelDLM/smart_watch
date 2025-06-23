package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.webview.tachikoma.a.k;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class a {
    private static List<WeakReference<k.b>> KR;

    /* renamed from: com.kwad.components.core.e.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0788a {
        private boolean KS;
        private boolean KT;
        private boolean KU;
        private boolean KV;
        private boolean KW;
        private boolean KX;
        private boolean KY;
        private b KZ;
        private c La;
        private boolean Lb;
        private boolean Lc;
        private long Ld;
        private boolean Le;
        private boolean Lf;
        public String Lh;
        public a.C0845a Li;
        private JSONObject Ll;
        private boolean Ln;
        private int Lo;
        private int Lp;
        private int Lq;
        private int Lr;
        private Callable<String> Ls;
        private String Lt;
        private AdTemplate adTemplate;
        private final Context context;
        private int kj;
        private int kl;
        public ac.a kn;
        public long vA;
        public int Lg = -1;
        public int Lj = 0;
        public int Lk = -1;
        private boolean Lm = false;

        public C0788a(Context context) {
            this.context = context;
        }

        public final C0788a a(@Nullable Callable<String> callable) {
            this.Ls = callable;
            return this;
        }

        public final C0788a ag(String str) {
            this.Lt = str;
            return this;
        }

        public final C0788a ah(String str) {
            this.Lh = str;
            return this;
        }

        public final void ak(boolean z) {
            this.Lc = true;
        }

        public final C0788a al(int i) {
            this.Lr = i;
            return this;
        }

        public final C0788a am(int i) {
            this.kl = i;
            return this;
        }

        public final C0788a an(boolean z) {
            this.KW = true;
            return this;
        }

        public final C0788a ao(boolean z) {
            this.Lb = z;
            return this;
        }

        public final C0788a ap(boolean z) {
            this.Le = z;
            return this;
        }

        public final C0788a aq(boolean z) {
            this.Lf = z;
            return this;
        }

        public final C0788a ar(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final C0788a as(boolean z) {
            this.KT = z;
            return this;
        }

        public final C0788a at(boolean z) {
            this.KV = true;
            return this;
        }

        public final C0788a au(boolean z) {
            this.KS = z;
            return this;
        }

        public final C0788a av(boolean z) {
            this.Ln = z;
            return this;
        }

        public final C0788a aw(boolean z) {
            this.KU = true;
            return this;
        }

        public final C0788a b(c cVar) {
            this.La = cVar;
            return this;
        }

        public final C0788a c(JSONObject jSONObject) {
            this.Ll = jSONObject;
            return this;
        }

        public final int cV() {
            return this.kj;
        }

        public final int cY() {
            return this.kl;
        }

        public final C0788a d(ac.a aVar) {
            this.kn = aVar;
            return this;
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final Context getContext() {
            return this.context;
        }

        public final c ha() {
            return this.La;
        }

        public final JSONObject ho() {
            return this.Ll;
        }

        public final String nX() {
            return this.Lt;
        }

        public final Callable<String> nY() {
            return this.Ls;
        }

        public final boolean nZ() {
            return this.Lc;
        }

        public final int oa() {
            return this.Lp;
        }

        public final b ob() {
            return this.KZ;
        }

        public final boolean oc() {
            return this.KW;
        }

        public final int od() {
            return this.Lr;
        }

        public final boolean oe() {
            return this.KX;
        }

        public final boolean of() {
            return this.KY;
        }

        public final boolean og() {
            return this.Lb;
        }

        public final long oh() {
            return this.Ld;
        }

        public final boolean oi() {
            return this.Le;
        }

        public final boolean oj() {
            return this.Lf;
        }

        public final com.kwad.sdk.core.adlog.c.a ok() {
            return com.kwad.sdk.core.adlog.c.a.BZ().cE(this.kl).dl(this.Lh).e(this.kn).cF(this.Lj).cG(this.Lk).am(this.vA).a(this.Li).cH(this.Lg);
        }

        public final boolean ol() {
            return this.Lm;
        }

        public final boolean om() {
            return this.KT;
        }

        public final boolean on() {
            return this.KV;
        }

        public final boolean oo() {
            return this.KS;
        }

        public final boolean op() {
            return this.Ln;
        }

        public final int oq() {
            return this.Lo;
        }

        public final int or() {
            return this.Lq;
        }

        public final boolean os() {
            return this.KU;
        }

        public final C0788a v(long j) {
            this.Ld = j;
            return this;
        }

        public final C0788a w(long j) {
            this.vA = j;
            return this;
        }

        public final C0788a a(b bVar) {
            this.KZ = bVar;
            return this;
        }

        public final void ak(int i) {
            this.Lp = i;
        }

        public final C0788a al(boolean z) {
            this.KX = z;
            return this;
        }

        public final C0788a am(boolean z) {
            this.KY = true;
            return this;
        }

        public final C0788a an(int i) {
            this.kj = i;
            return this;
        }

        public final C0788a ao(int i) {
            this.Lj = i;
            return this;
        }

        public final C0788a ap(int i) {
            this.Lk = i;
            return this;
        }

        public final C0788a aq(int i) {
            this.Lo = i;
            return this;
        }

        public final C0788a ar(boolean z) {
            this.Lm = z;
            return this;
        }

        public final C0788a a(String str, String str2, com.kwad.sdk.f.a<AdTrackLog> aVar) {
            if (this.Li == null) {
                this.Li = new a.C0845a();
            }
            this.Li.a(this.adTemplate, null, null, null);
            return this;
        }

        public final C0788a ar(int i) {
            this.Lq = i;
            return this;
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        void onAdClicked();
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable c cVar, boolean z, boolean z2, boolean z3, boolean z4) {
        com.kwad.sdk.commercial.d.a.f(adTemplate, true);
        adTemplate.converted = true;
        d.ax(false);
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
        C0788a ar = new C0788a(context).ar(adTemplate).a(bVar).b(cVar).ao(z).ap(z2).al(z4).ar(false);
        int am = com.kwad.sdk.core.response.b.a.am(dS);
        if (!z3 && ar.or() != 2 && ar.or() != 1 && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aR(dS)) && !ar.on()) {
            if (am == 1) {
                if (com.kwad.sdk.core.response.b.a.bg(dS)) {
                    return k(ar);
                }
                return l(ar);
            }
            if (am == 2) {
                int h = h(ar);
                if (h == 1) {
                    return 13;
                }
                if (h == 2) {
                    return 16;
                }
                if (com.kwad.sdk.core.response.b.a.bg(dS)) {
                    return k(ar);
                }
                return l(ar);
            }
        }
        int h2 = h(ar);
        if (h2 == 1) {
            return 13;
        }
        if (h2 == 2) {
            return 16;
        }
        if (!com.kwad.sdk.core.response.b.a.aE(dS)) {
            if (j(ar)) {
                return 11;
            }
            return l(ar);
        }
        int m = m(ar);
        int i = dS.status;
        if (i != 2 && i != 3) {
            e(ar);
        }
        return m;
    }

    private static int b(C0788a c0788a) {
        Context context = c0788a.getContext();
        AdTemplate adTemplate = c0788a.getAdTemplate();
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        Activity dB = l.dB(context);
        if (dB != null && com.kwad.sdk.core.response.b.a.U(dS) && !c0788a.nZ() && !c0788a.oe()) {
            c0788a.ak(2);
            com.kwad.components.core.e.e.e.a(dB, c0788a);
            d(adTemplate, 19);
            return 19;
        }
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0799a().au(com.kwad.sdk.core.response.b.b.cD(adTemplate)).at(adTemplate).aD(true).pK());
        d(adTemplate, 20);
        return 20;
    }

    private static boolean c(C0788a c0788a) {
        if (com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dS(c0788a.getAdTemplate()))) {
            if (c0788a.op() || c.A(c0788a) != 3) {
                return false;
            }
            return true;
        }
        if (d(c0788a) != 1) {
            return false;
        }
        return true;
    }

    private static int d(C0788a c0788a) {
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(c0788a.getAdTemplate());
        if (dS.unDownloadConf.unDownloadRegionConf == null) {
            return 0;
        }
        int cV = c0788a.cV();
        if (cV == 2) {
            return dS.unDownloadConf.unDownloadRegionConf.describeBarType;
        }
        if (cV != 3) {
            return dS.unDownloadConf.unDownloadRegionConf.actionBarType;
        }
        return dS.unDownloadConf.unDownloadRegionConf.materialJumpType;
    }

    private static void e(C0788a c0788a) {
        if (c0788a.nZ()) {
            return;
        }
        g(c0788a);
        f(c0788a);
        if (c0788a.ob() != null) {
            try {
                c0788a.ob().onAdClicked();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        com.kwad.sdk.commercial.d.a.bd(c0788a.getAdTemplate());
    }

    private static void f(C0788a c0788a) {
        if (c0788a.oj()) {
            com.kwad.sdk.core.adlog.c.a(c0788a.adTemplate, c0788a.ok(), c0788a.ho());
        }
    }

    private static void g(C0788a c0788a) {
        k.b bVar;
        List<WeakReference<k.b>> list = KR;
        if (list != null && !list.isEmpty() && c0788a.adTemplate != null) {
            for (WeakReference<k.b> weakReference : KR) {
                if (weakReference != null && (bVar = weakReference.get()) != null) {
                    bVar.L(com.kwad.sdk.core.response.b.e.ec(c0788a.adTemplate));
                }
            }
        }
    }

    private static int h(C0788a c0788a) {
        AdTemplate adTemplate = c0788a.getAdTemplate();
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        int a2 = d.a(c0788a, 1);
        if (a2 == 1) {
            d.ax(true);
            e(c0788a);
            if ((com.kwad.sdk.core.response.b.a.cL(dS) || com.kwad.sdk.core.response.b.a.cM(dS)) && !c0788a.os()) {
                com.kwad.sdk.core.adlog.c.m(c0788a.getAdTemplate(), (int) Math.ceil(((float) c0788a.oh()) / 1000.0f));
            }
            d(adTemplate, 13);
        } else if (a2 == 2) {
            e(c0788a);
            d(adTemplate, 16);
        }
        return a2;
    }

    private static int i(C0788a c0788a) {
        Context context = c0788a.getContext();
        AdTemplate adTemplate = c0788a.getAdTemplate();
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(c0788a.getAdTemplate());
        Activity dB = l.dB(c0788a.getContext());
        if (dB != null && com.kwad.sdk.core.response.b.a.T(dS) && !c0788a.nZ() && e.E(dS) && !c0788a.oe()) {
            c0788a.ak(1);
            com.kwad.components.core.e.e.e.a(dB, c0788a);
            e(c0788a);
            d(adTemplate, 17);
            return 2;
        }
        int d = e.d(context, adTemplate);
        if (d == 1) {
            e(c0788a);
            d(adTemplate, 12);
        }
        return d;
    }

    private static boolean j(C0788a c0788a) {
        AdTemplate adTemplate = c0788a.getAdTemplate();
        boolean h = com.kwad.sdk.utils.d.h(c0788a.getContext(), adTemplate);
        if (h) {
            e(c0788a);
            com.kwad.sdk.core.adlog.c.k(adTemplate, 0);
            d(adTemplate, 11);
        }
        return h;
    }

    private static int k(C0788a c0788a) {
        e(c0788a);
        AdTemplate adTemplate = c0788a.getAdTemplate();
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(c0788a.getAdTemplate());
        Activity dB = l.dB(c0788a.getContext());
        if (dB != null && com.kwad.sdk.core.response.b.a.U(dS) && !c0788a.nZ() && !c0788a.oe()) {
            c0788a.ak(2);
            com.kwad.components.core.e.e.e.a(dB, c0788a);
            d(adTemplate, 19);
            return 19;
        }
        AdWebViewVideoActivityProxy.launch(c0788a.getContext(), adTemplate);
        d(adTemplate, 15);
        return 15;
    }

    private static int l(C0788a c0788a) {
        e(c0788a);
        Context context = c0788a.getContext();
        AdTemplate adTemplate = c0788a.getAdTemplate();
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        Activity dB = l.dB(context);
        if (dB != null && com.kwad.sdk.core.response.b.a.U(dS) && !c0788a.nZ() && !c0788a.oe()) {
            c0788a.ak(2);
            com.kwad.components.core.e.e.e.a(dB, c0788a);
            d(adTemplate, 19);
            return 19;
        }
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0799a().au(com.kwad.sdk.core.response.b.b.cD(adTemplate)).at(adTemplate).aE(c0788a.oc()).az(1).pK());
        d(adTemplate, 14);
        return 14;
    }

    private static int m(C0788a c0788a) {
        c ha = c0788a.ha();
        if (ha == null) {
            ha = new c(c0788a.adTemplate);
            c0788a.b(ha);
        }
        int r = ha.r(c0788a);
        d(c0788a.getAdTemplate(), r);
        return r;
    }

    private static int n(C0788a c0788a) {
        AdTemplate adTemplate = c0788a.getAdTemplate();
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        if (j(c0788a)) {
            return 11;
        }
        if (com.kwad.sdk.core.response.b.a.b(dS, com.kwad.sdk.core.config.d.CB()) && !adTemplate.mAdWebVideoPageShowing) {
            return k(c0788a);
        }
        return l(c0788a);
    }

    private static void d(AdTemplate adTemplate, int i) {
        switch (i) {
            case 0:
                com.kwad.sdk.commercial.d.a.bt(adTemplate);
                return;
            case 1:
                com.kwad.sdk.commercial.d.a.bi(adTemplate);
                return;
            case 2:
                com.kwad.sdk.commercial.d.a.bs(adTemplate);
                return;
            case 3:
                com.kwad.sdk.commercial.d.a.bk(adTemplate);
                return;
            case 4:
                com.kwad.sdk.commercial.d.a.bq(adTemplate);
                return;
            case 5:
                com.kwad.sdk.commercial.d.a.br(adTemplate);
                return;
            case 6:
                com.kwad.sdk.commercial.d.a.bl(adTemplate);
                return;
            case 7:
                com.kwad.sdk.commercial.d.a.bm(adTemplate);
                return;
            case 8:
                com.kwad.sdk.commercial.d.a.bn(adTemplate);
                return;
            case 9:
                com.kwad.sdk.commercial.d.a.bp(adTemplate);
                return;
            case 10:
                com.kwad.sdk.commercial.d.a.bo(adTemplate);
                return;
            case 11:
                com.kwad.sdk.commercial.d.a.bh(adTemplate);
                return;
            case 12:
                com.kwad.sdk.commercial.d.a.bg(adTemplate);
                return;
            case 13:
                com.kwad.sdk.commercial.d.a.bf(adTemplate);
                return;
            case 14:
                com.kwad.sdk.commercial.d.a.be(adTemplate);
                return;
            case 15:
                com.kwad.sdk.commercial.d.a.bj(adTemplate);
                return;
            case 16:
                com.kwad.sdk.commercial.d.a.bv(adTemplate);
                return;
            case 17:
                com.kwad.sdk.commercial.d.a.by(adTemplate);
                return;
            case 18:
                com.kwad.sdk.commercial.d.a.bu(adTemplate);
                return;
            case 19:
                com.kwad.sdk.commercial.d.a.bw(adTemplate);
                return;
            case 20:
                com.kwad.sdk.commercial.d.a.bx(adTemplate);
                return;
            default:
                return;
        }
    }

    public static void b(k.b bVar) {
        if (KR == null) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= KR.size()) {
                i = -1;
                break;
            }
            WeakReference<k.b> weakReference = KR.get(i);
            if (weakReference != null && weakReference.get() != null && bVar == weakReference.get()) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            KR.remove(i);
        }
    }

    public static int a(C0788a c0788a) {
        Context context = c0788a.getContext();
        AdTemplate adTemplate = c0788a.getAdTemplate();
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        d.ax(false);
        if (c0788a.of()) {
            return b(c0788a);
        }
        if (c0788a.oo()) {
            return a(context, adTemplate, c0788a.ob(), c0788a.ha(), c0788a.Lb, c0788a.oi(), false, c0788a.oe());
        }
        com.kwad.sdk.commercial.d.a.f(adTemplate, false);
        if (c(c0788a)) {
            d(adTemplate, 1);
            return 1;
        }
        adTemplate.converted = true;
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
        int am = com.kwad.sdk.core.response.b.a.am(dS);
        if (c0788a.or() != 2 && c0788a.or() != 1 && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aR(dS)) && !c0788a.on()) {
            if (am == 1) {
                if (com.kwad.sdk.core.response.b.a.bg(dS)) {
                    return k(c0788a);
                }
                return l(c0788a);
            }
            if (am == 2) {
                int h = h(c0788a);
                if (h == 1) {
                    return 13;
                }
                if (h == 2) {
                    return 16;
                }
                if (com.kwad.sdk.core.response.b.a.bg(dS)) {
                    return k(c0788a);
                }
                return l(c0788a);
            }
        }
        int h2 = h(c0788a);
        if (h2 == 1) {
            return 13;
        }
        if (h2 == 2) {
            return 16;
        }
        int i = i(c0788a);
        if (i == 1) {
            return 12;
        }
        if (i == 2) {
            return 17;
        }
        if (c0788a.om() && !com.kwad.sdk.core.response.b.a.aE(dS)) {
            return n(c0788a);
        }
        if (!com.kwad.sdk.core.response.b.a.aE(dS)) {
            if (adTemplate.isWebViewDownload) {
                return m(c0788a);
            }
            if (j(c0788a)) {
                return 11;
            }
            return l(c0788a);
        }
        if (c0788a.or() != 2 && c0788a.or() != 1) {
            if (c0788a.om() && com.kwad.sdk.core.response.b.a.b(dS, com.kwad.sdk.core.config.d.CB()) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aR(dS)) && !AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity) {
                int q = c0788a.ha().q(c0788a);
                if (q == 0) {
                    return k(c0788a);
                }
                e(c0788a);
                d(adTemplate, q);
                return q;
            }
            e(c0788a);
            c0788a.ar(true);
            return m(c0788a);
        }
        c0788a.ar(false);
        e(c0788a);
        return m(c0788a);
    }

    public static void a(k.b bVar) {
        if (KR == null) {
            KR = new CopyOnWriteArrayList();
        }
        KR.add(new WeakReference<>(bVar));
    }
}
