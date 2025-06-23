package com.kwad.components.ad.l;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.a.c;

/* loaded from: classes11.dex */
public final class a {
    private KsAdWebView HZ;
    private boolean Ia;
    private boolean Ib;
    protected AdBaseFrameLayout Ic;
    private InterfaceC0749a Id;
    private c.a Ih;
    private b Ii;

    @Nullable
    private com.kwad.sdk.core.webview.d.a.a cR;
    private AdBaseFrameLayout dB;
    private FrameLayout da;
    private Activity mActivity;
    private AdTemplate mAdTemplate;
    private ImageView mBackIcon;
    private long mLastDown;
    private boolean HY = true;
    private Handler fS = new Handler(Looper.getMainLooper());
    private boolean Ie = false;
    private boolean If = false;
    private boolean Ig = false;

    /* renamed from: com.kwad.components.ad.l.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0749a {
        void R(boolean z);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void iw();
    }

    private static String B(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.a.aR(e.dS(adTemplate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bx() {
        if (this.Ig) {
            if (this.HY) {
                return false;
            }
            return true;
        }
        if (this.HY || this.Ie || this.If) {
            return false;
        }
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void fk() {
        this.da.removeAllViews();
        this.da.setVisibility(4);
        this.Ic = (AdBaseFrameLayout) ((ViewGroup) com.kwad.sdk.c.a.a.a((ViewGroup) this.da, R.layout.ksad_ad_landingpage_layout, true)).findViewById(R.id.ksad_web_card_frame);
        KsAdWebView ksAdWebView = (KsAdWebView) this.da.findViewById(R.id.ksad_web_card_webView);
        this.HZ = ksAdWebView;
        ksAdWebView.setBackgroundColor(-1);
        c.a b2 = this.HZ.getClientConfig().bu(false).bw(true).bv(false).bt(true).ek(this.mAdTemplate).a(mH()).b(ik());
        this.Ih = b2;
        this.HZ.setClientConfig(b2);
        this.HZ.setDownloadListener(new DownloadListener() { // from class: com.kwad.components.ad.l.a.1
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                a.a(a.this, true);
                if (a.this.Id != null) {
                    a.this.Id.R(a.this.bx());
                }
            }
        });
        ImageView imageView = (ImageView) this.Ic.findViewById(R.id.ksad_end_close_btn);
        this.mBackIcon = imageView;
        imageView.setVisibility(8);
        this.mBackIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.l.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (a.this.Ii != null) {
                    a.this.Ii.iw();
                }
            }
        });
    }

    private KsAdWebView.e ik() {
        return new KsAdWebView.e() { // from class: com.kwad.components.ad.l.a.3
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                if (a.this.Id != null) {
                    a.this.Id.R(a.this.bx());
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
                a.b(a.this, true);
                if (a.this.Id != null) {
                    a.this.Id.R(a.this.bx());
                }
            }
        };
    }

    private KsAdWebView.b mH() {
        return new KsAdWebView.b() { // from class: com.kwad.components.ad.l.a.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                a.c(a.this, true);
                if (a.this.Id != null) {
                    a.this.Id.R(a.this.bx());
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                a.c(a.this, true);
                if (a.this.Id != null) {
                    a.this.Id.R(a.this.bx());
                }
            }
        };
    }

    private boolean mI() {
        if (bx()) {
            FrameLayout frameLayout = this.da;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
                return true;
            }
            return true;
        }
        FrameLayout frameLayout2 = this.da;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        return false;
    }

    public final a af(boolean z) {
        this.Ib = true;
        return this;
    }

    public final boolean ar() {
        boolean mI = mI();
        this.Ig = true;
        if (mI && this.mActivity != null) {
            if (this.HZ.getClientConfig() != null) {
                this.HZ.getClientConfig().bu(true);
                this.HZ.getClientConfig().bv(true);
            }
            this.Ic.a(new View.OnTouchListener() { // from class: com.kwad.components.ad.l.a.5
                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getX() > a.this.mBackIcon.getX() && motionEvent.getX() - a.this.mBackIcon.getX() < a.this.mBackIcon.getWidth() && motionEvent.getY() > a.this.mBackIcon.getY() && motionEvent.getY() - a.this.mBackIcon.getY() < a.this.mBackIcon.getHeight()) {
                        com.kwad.sdk.core.e.c.d("LandingPageWebCard", "onClick backIcon");
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        a.this.mLastDown = SystemClock.elapsedRealtime();
                    } else if (motionEvent.getAction() == 1) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.mLastDown;
                        if (a.this.mLastDown > 0 && elapsedRealtime > 30 && elapsedRealtime < 500) {
                            com.kwad.sdk.core.adlog.c.a(a.this.mAdTemplate, 155, a.this.dB.getTouchCoords());
                            if (!a.this.Ia) {
                                a.d(a.this, true);
                                if (a.this.cR != null) {
                                    com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
                                    aVar.Yn = 3;
                                    a.this.cR.a(aVar);
                                }
                            }
                        }
                        a.this.mLastDown = 0L;
                    }
                    return false;
                }
            });
            long al = com.kwad.sdk.core.response.b.a.al(e.dS(this.mAdTemplate));
            if (al != 0 && this.Ib) {
                this.fS.postDelayed(new Runnable() { // from class: com.kwad.components.ad.l.a.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (a.this.mActivity != null && !a.this.mActivity.isFinishing()) {
                            a.this.mBackIcon.setVisibility(0);
                            a.this.mBackIcon.setAlpha(0.0f);
                            a.this.mBackIcon.animate().alpha(1.0f).setDuration(500L).start();
                        }
                    }
                }, al);
            } else {
                this.mBackIcon.setVisibility(0);
            }
            KsAdWebView ksAdWebView = this.HZ;
            if (ksAdWebView != null) {
                ksAdWebView.onActivityCreate();
            }
        }
        return mI;
    }

    public final void ay() {
        this.da.setVisibility(4);
        String B = B(this.mAdTemplate);
        if (TextUtils.isEmpty(B)) {
            return;
        }
        this.HZ.loadUrl(B);
    }

    public final void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    public static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.HY = true;
        return true;
    }

    public static /* synthetic */ boolean c(a aVar, boolean z) {
        aVar.Ie = true;
        return true;
    }

    public static /* synthetic */ boolean d(a aVar, boolean z) {
        aVar.Ia = true;
        return true;
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.If = true;
        return true;
    }

    public final void a(InterfaceC0749a interfaceC0749a) {
        this.Id = interfaceC0749a;
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate) {
        this.da = frameLayout;
        this.dB = adBaseFrameLayout;
        this.mAdTemplate = adTemplate;
        fk();
        this.HY = false;
    }

    public final void a(b bVar) {
        this.Ii = bVar;
    }

    public final void a(com.kwad.sdk.core.webview.d.a.a aVar) {
        this.cR = aVar;
    }
}
