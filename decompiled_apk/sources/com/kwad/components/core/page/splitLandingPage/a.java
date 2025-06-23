package com.kwad.components.core.page.splitLandingPage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.page.c.b;
import com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView;
import com.kwad.components.core.page.splitLandingPage.view.a;
import com.kwad.components.core.proxy.e;
import com.kwad.components.core.s.n;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.az;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class a extends e {
    private FeedVideoView OB;
    private LinearLayout OC;
    private SplitScrollWebView QF;
    private Presenter QG;
    private com.kwad.components.core.page.splitLandingPage.view.a QH;
    private com.kwad.components.core.page.c.a QI;
    private boolean QJ;
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;

    public static a au(AdTemplate adTemplate) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("key_photo", adTemplate.toJson().toString());
        bundle.putBoolean("key_report", adTemplate.mPvReported);
        aVar.setArguments(bundle);
        return aVar;
    }

    private void initView() {
        com.kwad.components.core.page.recycle.e eVar = new com.kwad.components.core.page.recycle.e(this.mAdTemplate, this.mApkDownloadHelper, null);
        this.QG.k(eVar);
        com.kwad.components.core.page.splitLandingPage.view.a aVar = new com.kwad.components.core.page.splitLandingPage.view.a(this.mContext, new com.kwad.components.core.page.splitLandingPage.a.a(eVar.adTemplate, eVar.La));
        this.QH = aVar;
        aVar.a(new a.InterfaceC0802a() { // from class: com.kwad.components.core.page.splitLandingPage.a.3
            @Override // com.kwad.components.core.page.splitLandingPage.view.a.InterfaceC0802a
            public final boolean qx() {
                return a.this.qu();
            }
        });
        this.OB.post(new az() { // from class: com.kwad.components.core.page.splitLandingPage.a.4
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                a.this.QF.setTranslationY(a.this.QF.getTranslationY() + a.this.OB.getHeight());
            }
        });
        this.QF.setSplitScrollWebViewListener(new SplitScrollWebView.a() { // from class: com.kwad.components.core.page.splitLandingPage.a.5
            @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.a
            public final void f(float f) {
                a.this.QF.setTranslationY(a.this.QF.getTranslationY() - f);
            }

            @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.a
            public final boolean qy() {
                if (!a.this.QH.qz() && d.Cd() == 2) {
                    return false;
                }
                AnimatorSet animatorSet = new AnimatorSet();
                Animator a2 = n.a((View) a.this.QF, (Interpolator) null, a.this.QF.getTranslationY(), 0.0f);
                if (d.Cd() == 2) {
                    if (!a.this.OB.isComplete()) {
                        animatorSet.playSequentially(a2, a.this.QH.aH(true));
                    } else {
                        animatorSet.playTogether(a2);
                    }
                } else if (d.Cd() == 1) {
                    animatorSet.playTogether(a2);
                }
                animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.page.splitLandingPage.a.5.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.OB.qw();
                        if (d.Cd() == 2 && !a.this.OB.isComplete()) {
                            a.this.QH.qA();
                        }
                    }
                });
                animatorSet.start();
                return true;
            }
        });
    }

    private void j(ViewGroup viewGroup) {
        Presenter presenter = new Presenter();
        this.QG = presenter;
        presenter.G(viewGroup);
        b bVar = new b();
        bVar.G(this.QF);
        com.kwad.components.core.page.c.a aVar = new com.kwad.components.core.page.c.a();
        this.QI = aVar;
        aVar.G(this.OB);
        this.QG.a(bVar);
        this.QG.a(this.QI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qu() {
        SplitScrollWebView splitScrollWebView = this.QF;
        if (splitScrollWebView == null || splitScrollWebView.getTranslationY() != 0.0f || this.QJ) {
            return false;
        }
        this.QF.setDisableAnimation(false);
        this.QJ = true;
        SplitScrollWebView splitScrollWebView2 = this.QF;
        Animator a2 = n.a((View) splitScrollWebView2, (Interpolator) null, 0.0f, splitScrollWebView2.getTranslationY() + this.OB.getHeight());
        AnimatorSet animatorSet = new AnimatorSet();
        if (d.Cd() == 2 && this.QH.isVisible()) {
            this.QH.qw();
            animatorSet.playSequentially(this.QH.aH(false), a2);
        } else {
            animatorSet.play(a2);
        }
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.page.splitLandingPage.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.qv();
                a.this.OB.qA();
                a.a(a.this, false);
            }
        });
        animatorSet.start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qv() {
        this.QI.mw();
        this.QI.G(this.OB);
        this.QI.k(new com.kwad.components.core.page.recycle.e(this.mAdTemplate, this.mApkDownloadHelper, null));
    }

    private void w(View view) {
        this.OC = (LinearLayout) view.findViewById(R.id.ksad_web_tip_bar);
        TextView textView = (TextView) view.findViewById(R.id.ksad_web_tip_bar_textview);
        ((ImageView) view.findViewById(R.id.ksad_web_tip_close_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.splitLandingPage.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.this.OC.setVisibility(8);
            }
        });
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(this.mAdTemplate);
        boolean bx = com.kwad.sdk.core.response.b.a.bx(dS);
        String bt = com.kwad.sdk.core.response.b.a.bt(dS);
        if (bx) {
            this.OC.setVisibility(0);
            textView.setText(bt);
            textView.setSelected(true);
            return;
        }
        this.OC.setVisibility(8);
    }

    @Override // com.kwad.components.core.proxy.e, com.kwad.sdk.l.a.b
    public final boolean onBackPressed() {
        SplitScrollWebView splitScrollWebView = this.QF;
        if (splitScrollWebView != null && splitScrollWebView.canGoBack()) {
            this.QF.goBack();
            return true;
        }
        if (qu()) {
            return true;
        }
        FeedVideoView feedVideoView = this.OB;
        if (feedVideoView != null) {
            return feedVideoView.tU();
        }
        return false;
    }

    @Override // com.kwad.components.core.proxy.e, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String string = getArguments().getString("key_photo");
        AdTemplate adTemplate = new AdTemplate();
        if (string != null) {
            try {
                adTemplate.parseJson(new JSONObject(string));
            } catch (JSONException e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
        }
        this.mAdTemplate = adTemplate;
        adTemplate.mPvReported = getArguments().getBoolean("key_report", false);
        this.mAdTemplate.mAdWebVideoPageShowing = true;
    }

    @Override // com.kwad.components.core.proxy.e, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroy() {
        super.onDestroy();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.mAdWebVideoPageShowing = false;
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.OB = (FeedVideoView) findViewById(R.id.ksad_split_land_ad_feed_video);
        this.QF = (SplitScrollWebView) findViewById(R.id.ksad_video_webView);
        w(view);
        j(this.lD);
        initView();
    }

    @Override // com.kwad.components.core.proxy.e
    public final int pB() {
        return R.layout.ksad_split_land_page;
    }

    public final void qw() {
        this.OB.qw();
    }

    public final void setApkDownloadHelper(c cVar) {
        this.mApkDownloadHelper = cVar;
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.QJ = false;
        return false;
    }
}
