package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.h;
import com.kwad.components.ad.reward.k.r;
import com.kwad.components.ad.reward.n.p;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.i.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.tachikoma.c.e;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.bo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class g extends com.kwad.components.core.l.a {
    public boolean fP;
    private Handler fS;
    public boolean gt;
    public boolean jY;
    public AdResultData mAdResultData;

    @NonNull
    public com.kwad.components.ad.reward.e.d mAdRewardStepListener;

    @Nullable
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public boolean mCheckExposureResult;
    public long mPageEnterTime;

    @Nullable
    public JSONObject mReportExtData;
    private boolean mRewardVerifyCalled;

    @NonNull
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public bn mTimerHelper;

    @NonNull
    public KsVideoPlayConfig mVideoPlayConfig;

    /* renamed from: oI, reason: collision with root package name */
    public boolean f18441oI;

    @NonNull
    public com.kwad.components.ad.reward.e.b oJ;
    public com.kwad.components.ad.reward.m.e oK;

    @Nullable
    public IAdLiveOfflineView oL;

    @Nullable
    public com.kwad.components.core.playable.a oM;

    @NonNull
    public RewardActionBarControl oN;

    /* renamed from: oO, reason: collision with root package name */
    @Nullable
    public j f18442oO;

    @Nullable
    public com.kwad.components.ad.l.a oP;

    @Nullable
    public d oQ;
    private final PriorityQueue<com.kwad.components.ad.reward.e.g> oR;
    public final List<com.kwad.components.ad.reward.k.a> oS;
    private final List<r> oT;
    private final List<com.kwad.components.ad.reward.m.c> oU;
    public Set<com.kwad.components.ad.reward.e.e> oV;

    @Nullable
    private com.kwad.components.core.webview.tachikoma.e.a oW;

    /* renamed from: oX, reason: collision with root package name */
    private boolean f18443oX;
    private boolean oY;
    public boolean oZ;
    public boolean pA;
    public boolean pB;

    @NonNull
    public LoadStrategy pC;
    private RewardRenderResult pD;
    private List<a> pE;
    private List<b> pF;
    private List<a.InterfaceC0793a> pG;
    public boolean pa;
    public boolean pb;
    public boolean pc;
    private boolean pd;
    public boolean pe;
    public boolean pf;
    public List<Integer> pg;
    public int ph;
    public boolean pi;

    @Nullable
    public p pj;
    public boolean pk;

    @Nullable
    private PlayableSource pl;
    private boolean pm;
    public long pn;
    private List<DialogInterface.OnDismissListener> po;

    @Nullable
    public com.kwad.components.ad.reward.e.o pp;
    public boolean pq;

    @Nullable
    public com.kwad.components.ad.reward.l.b.a pr;

    @Nullable
    public com.kwad.components.ad.reward.l.a.a ps;
    public int pt;
    private int pu;
    public long pv;
    public long pw;
    public boolean px;
    private boolean py;
    private boolean pz;

    /* loaded from: classes11.dex */
    public interface a {
        void fV();

        void fW();

        void fX();

        void fY();
    }

    /* loaded from: classes11.dex */
    public interface b {
        boolean interceptPlayCardResume();
    }

    public g(com.kwad.components.core.l.b<?> bVar) {
        super(bVar);
        this.f18441oI = false;
        this.oR = new PriorityQueue<>();
        this.oS = new CopyOnWriteArrayList();
        this.oT = new CopyOnWriteArrayList();
        this.oU = new CopyOnWriteArrayList();
        this.oV = new HashSet();
        this.f18443oX = false;
        this.oY = false;
        this.pa = false;
        this.pb = false;
        this.pc = false;
        this.pd = false;
        this.pe = false;
        this.mRewardVerifyCalled = false;
        this.pf = false;
        this.pg = new ArrayList();
        this.mCheckExposureResult = true;
        this.ph = 0;
        this.pi = false;
        this.pk = false;
        this.pl = null;
        this.pm = false;
        this.gt = false;
        this.po = new CopyOnWriteArrayList();
        this.fS = new Handler(Looper.getMainLooper());
        this.pq = false;
        this.pu = 2;
        this.py = false;
        this.pz = false;
        this.pA = false;
        this.pB = false;
        this.pC = LoadStrategy.FULL_TK;
        this.pE = new CopyOnWriteArrayList();
        this.pF = new CopyOnWriteArrayList();
        this.pG = new CopyOnWriteArrayList();
        this.MU.add(new com.kwad.components.core.l.a.a() { // from class: com.kwad.components.ad.reward.g.1
            @Override // com.kwad.components.core.l.a.a
            public final void c(com.kwad.components.core.proxy.c cVar) {
                g.this.fv();
            }

            @Override // com.kwad.components.core.l.a.a
            public final void d(com.kwad.components.core.proxy.c cVar) {
                g.this.fw();
            }

            @Override // com.kwad.components.core.l.a.a
            public final void fQ() {
                g.this.fu();
            }

            @Override // com.kwad.components.core.l.a.a
            public final void fR() {
                g.this.fx();
            }
        });
    }

    public static boolean F(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.F(adTemplate);
    }

    public static boolean G(AdTemplate adTemplate) {
        if (com.kwad.sdk.core.response.b.a.cS(com.kwad.sdk.core.response.b.e.dS(adTemplate))) {
            return false;
        }
        if (!E(adTemplate) && !F(adTemplate)) {
            return false;
        }
        return true;
    }

    private void fB() {
        this.oR.clear();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        j jVar = this.f18442oO;
        if (jVar != null) {
            jVar.release();
        }
        d dVar = this.oQ;
        if (dVar != null) {
            dVar.release();
        }
        Set<com.kwad.components.ad.reward.e.e> set = this.oV;
        if (set != null) {
            set.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fD() {
        try {
            int size = this.oR.size();
            for (int i = 0; i < size; i++) {
                com.kwad.components.ad.reward.e.g poll = this.oR.poll();
                if (poll != null) {
                    poll.bL();
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fu() {
        Iterator<a> it = this.pE.iterator();
        while (it.hasNext()) {
            it.next().fV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx() {
        Iterator<a> it = this.pE.iterator();
        while (it.hasNext()) {
            it.next().fY();
        }
    }

    private static boolean isMainThread() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public final void A(boolean z) {
        this.pz = z;
    }

    public final void B(boolean z) {
        this.pm = true;
    }

    public final void C(boolean z) {
        this.py = true;
    }

    public final void D(boolean z) {
        this.f18443oX = z;
    }

    public final void E(final boolean z) {
        if (z != this.mRewardVerifyCalled) {
            a(this.oT, new com.kwad.sdk.f.a<r>() { // from class: com.kwad.components.ad.reward.g.11
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.f.a
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void accept(r rVar) {
                    rVar.aa(z);
                }
            });
        }
        this.mRewardVerifyCalled = z;
    }

    public final void L(int i) {
        this.pu = i;
    }

    public final void b(a aVar) {
        this.pE.remove(aVar);
    }

    public final void d(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.n(adResultData);
    }

    @Nullable
    public final String fA() {
        TKAdLiveShopItemInfo tKAdLiveShopItemInfo = this.mAdTemplate.tkLiveShopItemInfo;
        if (tKAdLiveShopItemInfo == null) {
            return null;
        }
        return tKAdLiveShopItemInfo.itemId;
    }

    public final void fC() {
        if (isMainThread()) {
            fD();
        } else {
            this.fS.post(new az() { // from class: com.kwad.components.ad.reward.g.6
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    g.this.fD();
                }
            });
        }
    }

    public final boolean fE() {
        return this.pz;
    }

    public final void fF() {
        com.kwad.components.core.webview.tachikoma.e.a aVar = this.oW;
        if (aVar == null) {
            return;
        }
        aVar.jb();
    }

    public final boolean fG() {
        return this.pd;
    }

    @Nullable
    public final PlayableSource fH() {
        return this.pl;
    }

    public final boolean fI() {
        return this.pm;
    }

    public final List<a.InterfaceC0793a> fJ() {
        return this.pG;
    }

    public final RewardRenderResult fK() {
        return this.pD;
    }

    public final boolean fL() {
        return RewardRenderResult.NEO_TK.equals(this.pD);
    }

    public final boolean fM() {
        return this.py;
    }

    public final boolean fN() {
        return this.f18443oX;
    }

    public final boolean fO() {
        return this.mRewardVerifyCalled;
    }

    public final void fP() {
        int i;
        long j = this.pw;
        if (j != 0) {
            i = (int) (j / 1000);
        } else {
            i = 0;
        }
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.sdk.core.adlog.c.e(adTemplate, com.kwad.sdk.core.response.b.a.ad(com.kwad.sdk.core.response.b.e.dS(adTemplate)), i);
    }

    public final void fv() {
        if (!this.oY && !this.f18443oX && !this.py) {
            Iterator<b> it = this.pF.iterator();
            boolean z = false;
            while (it.hasNext()) {
                z |= it.next().interceptPlayCardResume();
            }
            if (z) {
                return;
            }
            Iterator<a> it2 = this.pE.iterator();
            while (it2.hasNext()) {
                it2.next().fW();
            }
        }
    }

    public final void fw() {
        Iterator<a> it = this.pE.iterator();
        while (it.hasNext()) {
            it.next().fX();
        }
    }

    public final boolean fy() {
        return this.oY;
    }

    public final void fz() {
        a(this.oU, new com.kwad.sdk.f.a<com.kwad.components.ad.reward.m.c>() { // from class: com.kwad.components.ad.reward.g.5
            private static void c(com.kwad.components.ad.reward.m.c cVar) {
                cVar.ir();
            }

            @Override // com.kwad.sdk.f.a
            public final /* synthetic */ void accept(com.kwad.components.ad.reward.m.c cVar) {
                c(cVar);
            }
        });
    }

    @Override // com.kwad.components.core.l.a, com.kwad.sdk.mvp.a
    public final void release() {
        fB();
        com.kwad.components.ad.reward.m.e eVar = this.oK;
        if (eVar != null) {
            eVar.release();
        }
    }

    public final void y(String str) {
        int i = -1;
        try {
            if (com.kwad.sdk.core.config.d.zz()) {
                i = com.kwad.components.ad.reward.j.a.a(getActivity());
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
        com.kwad.components.ad.reward.j.b.a(this.mContext, this.mAdTemplate, str, i, this.mReportExtData);
    }

    public final void z(boolean z) {
        this.oY = z;
        if (z) {
            fw();
        } else {
            fv();
        }
    }

    public static boolean g(AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.b.g(adInfo) && !com.kwad.components.ad.reward.a.b.k(adInfo);
    }

    public final void a(a aVar) {
        this.pE.add(aVar);
    }

    public final void b(b bVar) {
        this.pF.remove(bVar);
    }

    @MainThread
    public final void c(com.kwad.components.ad.reward.e.g gVar) {
        this.oR.remove(gVar);
    }

    private static com.kwad.components.ad.reward.k.a.b c(g gVar) {
        e.b bVar = new e.b();
        bVar.d(gVar.mAdResultData);
        bVar.aX(com.kwad.sdk.core.response.b.b.dw(gVar.mAdTemplate));
        bVar.aW(false);
        bVar.aX(true);
        return com.kwad.components.ad.reward.k.a.b.a(gVar, bVar);
    }

    public final void a(b bVar) {
        this.pF.add(bVar);
    }

    public final void b(com.kwad.components.ad.reward.k.a aVar) {
        this.oS.remove(aVar);
    }

    public final void d(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.po.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
    }

    public static boolean E(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.dS(adTemplate)));
    }

    public final void a(com.kwad.components.ad.reward.k.a aVar) {
        this.oS.add(aVar);
    }

    public final void b(r rVar) {
        this.oT.remove(rVar);
    }

    public final void a(r rVar) {
        this.oT.add(rVar);
    }

    public final void b(com.kwad.components.ad.reward.m.c cVar) {
        if (cVar != null) {
            this.oU.remove(cVar);
        }
    }

    public final void d(@Nullable PlayableSource playableSource) {
        this.pl = playableSource;
    }

    public final void a(com.kwad.components.ad.reward.m.c cVar) {
        if (cVar != null) {
            this.oU.add(cVar);
        }
    }

    @MainThread
    public final void b(com.kwad.components.ad.reward.e.g gVar) {
        this.oR.offer(gVar);
    }

    public final void d(final boolean z, final boolean z2) {
        if (this.oK.jN()) {
            bo.runOnUiThreadDelay(new az() { // from class: com.kwad.components.ad.reward.g.2
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    com.kwad.components.ad.reward.f.a jO = g.this.oK.jO();
                    if (jO != null) {
                        jO.setAudioEnabled(z, z2);
                    }
                }
            }, 500L);
        }
    }

    public static <T> void a(List<T> list, com.kwad.sdk.f.a<T> aVar) {
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                aVar.accept(it.next());
            }
        }
    }

    public final void b(int i, Context context, int i2, int i3) {
        a(i, context, i2, i3, 0L, false, null);
    }

    private static com.kwad.components.ad.reward.k.a.b d(g gVar) {
        if (com.kwad.sdk.core.response.b.a.cc(com.kwad.sdk.core.response.b.e.dS(gVar.mAdTemplate)) == 4 || com.kwad.sdk.core.response.b.a.cc(com.kwad.sdk.core.response.b.e.dS(gVar.mAdTemplate)) == 3) {
            return c(gVar);
        }
        return null;
    }

    public final void b(DialogInterface.OnDismissListener onDismissListener) {
        this.po.remove(onDismissListener);
    }

    public final void a(long j, long j2, int i) {
        Iterator<com.kwad.components.ad.reward.e.e> it = this.oV.iterator();
        while (it.hasNext()) {
            it.next().ce();
        }
    }

    public final void b(com.kwad.components.ad.reward.c.b bVar) {
        com.kwad.components.ad.reward.c.a.gM().a(this.mAdTemplate, bVar);
    }

    public final void b(final com.kwad.components.core.i.c cVar) {
        final com.kwad.components.core.i.d J = com.kwad.components.ad.reward.e.f.J(this.mAdTemplate.getUniqueId());
        bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.reward.g.10
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                com.kwad.components.core.i.d dVar = J;
                if (dVar != null) {
                    dVar.d(cVar);
                }
            }
        });
    }

    public final void a(int i, Context context, int i2, int i3) {
        b(i, context, i2, i3);
    }

    public final void a(int i, Context context, int i2, int i3, long j) {
        a(1, context, 40, 1, j, false, null);
    }

    public final void a(int i, Context context, final int i2, int i3, long j, boolean z, final com.kwad.sdk.core.adlog.c.b bVar) {
        com.kwad.components.core.e.d.a.a(new a.C0788a(context).ar(this.mAdTemplate).b(this.mApkDownloadHelper).ao(false).an(i3).v(j).am(i2).al(i).ag(fA()).a(new Callable<String>() { // from class: com.kwad.components.ad.reward.g.8
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: fT, reason: merged with bridge method [inline-methods] */
            public String call() {
                com.kwad.components.ad.reward.m.e eVar = g.this.oK;
                if (eVar != null) {
                    return eVar.jO().getCurrentShowShopItemInfo().itemId;
                }
                return null;
            }
        }).a(new a.b() { // from class: com.kwad.components.ad.reward.g.7
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                try {
                    g.this.a(i2, bVar);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }));
    }

    public final void b(a.InterfaceC0793a interfaceC0793a) {
        List<a.InterfaceC0793a> list = this.pG;
        if (list != null) {
            list.remove(interfaceC0793a);
        }
    }

    public static boolean b(g gVar) {
        return gVar.f18443oX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(g gVar, h.c cVar, h.a aVar) {
        boolean b2 = b(gVar);
        com.kwad.sdk.core.e.c.d("RewardCallerContext", "showNativeCloseDialog isCloseDialogShowing: " + b2);
        if (b2) {
            return;
        }
        h.a(gVar.getActivity(), gVar.mAdTemplate, cVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.cK(i);
        bVar.f(this.mRootContainer.getTouchCoords());
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, (String) null, (String) null, bVar, this.mReportExtData);
        com.kwad.components.ad.reward.c.a.gM().c(this.mAdTemplate, com.kwad.components.ad.reward.c.b.STATUS_NONE);
        this.oJ.bJ();
    }

    public final void a(DialogInterface.OnDismissListener onDismissListener) {
        this.po.add(onDismissListener);
    }

    public final void a(@Nullable com.kwad.components.ad.reward.e.o oVar) {
        this.pp = oVar;
    }

    public final void a(com.kwad.components.core.webview.tachikoma.e.a aVar) {
        this.oW = aVar;
    }

    public final void a(final com.kwad.components.core.i.c cVar) {
        final com.kwad.components.core.i.d J = com.kwad.components.ad.reward.e.f.J(this.mAdTemplate.getUniqueId());
        bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.reward.g.9
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                com.kwad.components.core.i.d dVar = J;
                if (dVar != null) {
                    dVar.c(cVar);
                }
            }
        });
    }

    public final void a(a.InterfaceC0793a interfaceC0793a) {
        List<a.InterfaceC0793a> list = this.pG;
        if (list != null) {
            list.add(interfaceC0793a);
        }
    }

    @Nullable
    public static com.kwad.components.core.i.c a(List<com.kwad.components.core.i.c> list, long j) {
        if (j >= 0 && list != null) {
            for (com.kwad.components.core.i.c cVar : list) {
                if (com.kwad.sdk.core.response.b.e.ec(cVar.getAdTemplate()) == j) {
                    return cVar;
                }
            }
        }
        return null;
    }

    public final void a(RewardRenderResult rewardRenderResult) {
        this.pD = rewardRenderResult;
    }

    public static void a(Context context, g gVar, ViewGroup viewGroup) {
        IAdLiveOfflineView iAdLiveOfflineView;
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(gVar.mAdTemplate);
        com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class);
        if (aVar != null && aVar.pj() && com.kwad.sdk.core.response.b.a.cM(com.kwad.sdk.core.response.b.e.dS(gVar.mAdTemplate))) {
            try {
                iAdLiveOfflineView = com.kwad.components.ad.j.b.a(aVar, context, com.kwad.sdk.core.response.b.a.be(dS) == 8 ? 1 : 0);
            } catch (Throwable unused) {
                iAdLiveOfflineView = null;
            }
            IAdLiveOfflineView iAdLiveOfflineView2 = iAdLiveOfflineView;
            if (iAdLiveOfflineView2 != null) {
                View view = iAdLiveOfflineView2.getView();
                gVar.oL = iAdLiveOfflineView2;
                viewGroup.addView(view);
                gVar.oK.a(2, new com.kwad.components.ad.reward.f.a(gVar.mAdTemplate, aVar.getAdLivePlayModule(iAdLiveOfflineView2, ServiceProvider.getAppId(), String.valueOf(com.kwad.sdk.core.response.b.a.ch(dS)), com.kwad.sdk.core.response.b.a.ci(dS), com.kwad.sdk.core.response.b.a.cj(dS))));
            }
        }
    }

    public static long a(long j, AdInfo adInfo) {
        return Math.min(com.kwad.sdk.core.response.b.a.af(adInfo), j);
    }

    public static void a(g gVar, final h.c cVar, final h.a aVar) {
        if (!gVar.oK.jN()) {
            AdInfo dS = com.kwad.sdk.core.response.b.e.dS(gVar.mAdTemplate);
            r1 = (com.kwad.components.ad.reward.a.b.j(dS) || com.kwad.sdk.core.response.b.a.cc(dS) == 2) ? c(gVar) : null;
            if (r1 == null) {
                r1 = d(gVar);
            }
        }
        com.kwad.components.ad.reward.k.a.b bVar = r1;
        if (bVar != null) {
            com.kwad.components.ad.reward.k.a.b.a(bVar, gVar.getActivity(), gVar.oK.getPlayDuration(), aVar, new e.a() { // from class: com.kwad.components.ad.reward.g.12
                @Override // com.kwad.components.core.webview.tachikoma.c.e.a
                public final boolean fU() {
                    g.b(g.this, cVar, aVar);
                    return true;
                }
            });
        } else {
            b(gVar, cVar, aVar);
        }
    }

    public static void a(Activity activity, g gVar) {
        com.kwad.sdk.core.e.c.d("RewardCallerContext", "showExtraDialog");
        com.kwad.components.ad.reward.k.a.b.a(gVar, activity, gVar.oK.getPlayDuration(), new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.reward.g.3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                g.this.d(dialogInterface);
                com.kwad.sdk.core.c.b.En();
                Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
                if (currentActivity != null && currentActivity.equals(g.this.getActivity())) {
                    g.this.oK.resume();
                }
            }
        }, new h.b() { // from class: com.kwad.components.ad.reward.g.4
            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void fS() {
                g.this.oK.pause();
            }
        });
    }
}
