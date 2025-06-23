package com.kwad.components.core.playable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.be;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.tachikoma.a.f;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.b;
import com.kwad.sdk.utils.bo;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public final class a implements n {
    private final KsAdWebView Ru;
    private long Rv;
    private int Rw;
    private PlayableSource Rx = PlayableSource.UNKNOWN_TRYPLAY_ENTRY_SOURCE;
    private List<aq.b> Ry = new CopyOnWriteArrayList();
    private List<KsAdWebView.e> Rz = new CopyOnWriteArrayList();

    @Nullable
    private com.kwad.components.core.webview.a cN;
    private aw cQ;

    @Nullable
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;
    private Context mContext;
    private AdBaseFrameLayout mRootContainer;

    /* renamed from: com.kwad.components.core.playable.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0804a implements be.b {
        private final WeakReference<a> RB;

        public C0804a(a aVar) {
            this.RB = new WeakReference<>(aVar);
        }

        @Override // com.kwad.components.core.webview.jshandler.be.b
        public final void Q(int i) {
            a aVar = this.RB.get();
            if (aVar != null) {
                aVar.aC(i);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public a(KsAdWebView ksAdWebView) {
        this.Ru = ksAdWebView;
        ksAdWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.playable.a.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.this.Rv = SystemClock.elapsedRealtime();
                    a.this.Ru.getClientConfig().bu(true);
                    return false;
                }
                return false;
            }
        });
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().ek(this.mAdTemplate).b(ik()));
        a(ksAdWebView);
    }

    private void aA() {
        com.kwad.components.core.webview.a aVar = this.cN;
        if (aVar != null) {
            aVar.destroy();
            this.cN = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(int i) {
        if (getAdTemplate() == null) {
            return;
        }
        long Da = d.Da();
        if (Da > 0 && SystemClock.elapsedRealtime() - this.Rv > Da) {
            return;
        }
        com.kwad.components.core.e.d.a.a(new a.C0788a(this.mContext).ar(this.mAdTemplate).b(this.mApkDownloadHelper).ao(false).am(i).d(this.mRootContainer.getTouchCoords()).aq(true));
    }

    @Nullable
    private AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    private String getUrl() {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null) {
            return "";
        }
        return com.kwad.sdk.core.response.b.a.bO(e.dS(adTemplate));
    }

    private KsAdWebView.e ik() {
        return new KsAdWebView.e() { // from class: com.kwad.components.core.playable.a.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                Iterator it = a.this.Rz.iterator();
                while (it.hasNext()) {
                    ((KsAdWebView.e) it.next()).onPageFinished();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
                Iterator it = a.this.Rz.iterator();
                while (it.hasNext()) {
                    ((KsAdWebView.e) it.next()).onPageStart();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
                Iterator it = a.this.Rz.iterator();
                while (it.hasNext()) {
                    ((KsAdWebView.e) it.next()).onReceivedHttpError(i, str, str2);
                }
            }
        };
    }

    private void qd() {
        if (com.kwad.sdk.core.response.b.a.bK(e.dS(this.mAdTemplate)) > 0) {
            bo.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.playable.a.4
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public final void run() {
                    a.this.Ru.getClientConfig().bu(true);
                }
            }, com.kwad.sdk.core.response.b.a.bK(e.dS(this.mAdTemplate)));
        }
        if (com.kwad.sdk.core.response.b.a.bK(e.dS(this.mAdTemplate)) == 0) {
            this.Ru.getClientConfig().bu(true);
        }
    }

    public final void e(PlayableSource playableSource) {
        if (playableSource != null) {
            this.Rx = playableSource;
        }
        if (this.Ru == null) {
            return;
        }
        qd();
        com.kwad.sdk.core.e.c.d("PlayableViewHelper", "showPlayable");
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sV();
        }
        this.Ru.setVisibility(0);
        aw awVar2 = this.cQ;
        if (awVar2 != null) {
            awVar2.sW();
        }
    }

    public final long getLoadTime() {
        KsAdWebView ksAdWebView = this.Ru;
        if (ksAdWebView != null) {
            return ksAdWebView.getLoadTime();
        }
        return -1L;
    }

    public final void hA() {
        com.kwad.sdk.core.e.c.d("PlayableViewHelper", "showPlayable");
        if (this.Ru == null) {
            return;
        }
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sX();
        }
        this.Ru.setVisibility(8);
        aw awVar2 = this.cQ;
        if (awVar2 != null) {
            awVar2.sY();
        }
        this.Ru.reload();
    }

    public final void qD() {
        com.kwad.components.core.webview.a aVar = this.cN;
        if (aVar != null) {
            aVar.destroy();
            this.cN = null;
        }
    }

    public final void qE() {
        KsAdWebView ksAdWebView;
        if (this.mAdTemplate != null && (ksAdWebView = this.Ru) != null) {
            ksAdWebView.getClientConfig().bu(false);
            String url = getUrl();
            if (!TextUtils.isEmpty(url)) {
                this.Ru.loadUrl(url);
            }
            com.kwad.sdk.core.adlog.c.bS(this.mAdTemplate);
        }
    }

    public final boolean qF() {
        if (this.Ru != null && this.Rw == 1) {
            return true;
        }
        return false;
    }

    public final void b(@Nullable aq.b bVar) {
        this.Ry.remove(bVar);
    }

    private static void a(KsAdWebView ksAdWebView) {
        if (d.CZ()) {
            ksAdWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    public final void a(AdTemplate adTemplate, AdBaseFrameLayout adBaseFrameLayout, c cVar) {
        if (this.Ru == null) {
            com.kwad.sdk.core.e.c.w("PlayableViewHelper", "registerJsBridge mPlayableView is null");
            return;
        }
        this.mContext = adBaseFrameLayout.getContext();
        this.mRootContainer = adBaseFrameLayout;
        this.mAdTemplate = adTemplate;
        this.mApkDownloadHelper = cVar;
        this.Rw = -1;
        b bVar = new b();
        bVar.setAdTemplate(adTemplate);
        bVar.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout2 = this.mRootContainer;
        bVar.aEW = adBaseFrameLayout2;
        bVar.Ph = adBaseFrameLayout2;
        bVar.OA = this.Ru;
        aA();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.Ru);
        this.cN = aVar;
        a(bVar, aVar, cVar);
        this.Ru.addJavascriptInterface(this.cN, "KwaiAd");
    }

    public final void a(@Nullable aq.b bVar) {
        this.Ry.add(bVar);
    }

    public final void a(@Nullable KsAdWebView.e eVar) {
        this.Rz.add(eVar);
    }

    private void a(b bVar, com.kwad.components.core.webview.a aVar, c cVar) {
        aVar.a(new be(bVar, cVar, new C0804a(this)));
        aVar.a(new aq(new aq.b() { // from class: com.kwad.components.core.playable.a.3
            @Override // com.kwad.components.core.webview.jshandler.aq.b
            public final void a(aq.a aVar2) {
                a.this.Rw = aVar2.status;
                if (aVar2.status == 1 && a.this.mAdTemplate != null) {
                    com.kwad.sdk.core.adlog.c.bR(a.this.mAdTemplate);
                }
                Iterator it = a.this.Ry.iterator();
                while (it.hasNext()) {
                    ((aq.b) it.next()).a(aVar2);
                }
            }
        }, getUrl()));
        aVar.a(new ak(bVar));
        aVar.b(new m(bVar));
        aVar.b(new l(bVar));
        this.cQ = new aw();
        aVar.a(new af());
        aVar.a(new ae(bVar));
        aVar.a(new f());
        aVar.a(this.cQ);
        aVar.a(new h(this));
    }

    @Override // com.kwad.components.core.webview.jshandler.n
    public final void a(h hVar, String str) {
        AdTemplate adTemplate;
        if ("playableSrc".equals(str)) {
            hVar.f(this.Rx);
        }
        if (!"getAdType".equals(str) || (adTemplate = this.mAdTemplate) == null) {
            return;
        }
        hVar.aO(adTemplate.adStyle);
    }
}
