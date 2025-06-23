package com.kwad.components.ad.reward.presenter.g;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.c;
import com.kwad.components.ad.reward.n.e;
import com.kwad.components.ad.reward.n.q;
import com.kwad.sdk.R;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.v;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.f;

/* loaded from: classes11.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements c.a, com.kwad.sdk.app.a, com.kwad.sdk.core.webview.d.a.a, com.kwad.sdk.widget.c {
    private static float wQ = 0.4548105f;
    private AdInfo mAdInfo;
    private com.kwad.components.ad.reward.l.b.a pr;

    @Nullable
    private ViewGroup wJ;

    @Nullable
    private q wK;
    private ViewGroup wL;
    private e wM;
    private c wN;

    @Nullable
    private c wO;
    private int wR = 15;
    private long wS = -1;
    private boolean wT = false;
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.g.b.3
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (b.this.wN != null && g.G(b.this.qp.mAdTemplate)) {
                b.this.wN.jR();
            }
            if (b.this.wO != null) {
                b.this.wO.jR();
            }
        }
    };
    private com.kwad.sdk.core.c.c wU = new d() { // from class: com.kwad.components.ad.reward.presenter.g.b.4
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            b.this.W(false);
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            b.this.W(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void W(boolean z) {
        com.kwad.components.ad.reward.l.b.a aVar;
        com.kwad.components.ad.reward.l.b.a.a(this.pr, getContext(), this.qp.mAdTemplate);
        if (this.pr.jH()) {
            if (z) {
                boolean je = je();
                if (je && (aVar = this.pr) != null) {
                    aVar.jG();
                    com.kwad.components.ad.reward.b.fc().notifyRewardVerify();
                    this.qp.oJ.onRewardVerify();
                }
                X(je);
                return;
            }
            this.wS = System.currentTimeMillis();
            return;
        }
        if (z) {
            X(false);
        }
    }

    private void X(boolean z) {
        String str;
        com.kwad.sdk.core.e.c.d("LaunchAppTaskPresenter", "showTaskToast hasShowCompletedToast: " + this.wT + " completed: " + z);
        if (this.wT) {
            return;
        }
        if (z) {
            str = "恭喜！任务达标啦，成功获取奖励~";
        } else {
            str = "哎呀，差一点就达标啦，再试一次~";
        }
        v.c(getContext(), str, 0);
        if (z) {
            this.wT = true;
        }
    }

    private void Y(boolean z) {
        int i;
        if (z) {
            i = 1;
        } else {
            i = 153;
        }
        this.qp.a(1, getContext(), i, 1);
    }

    private boolean je() {
        com.kwad.sdk.core.e.c.d("LaunchAppTaskPresenter", "checkUseAppTime appBackgroundTimestamp: " + this.wS);
        if (this.wS < 0 || System.currentTimeMillis() - this.wS <= this.wR * 1000) {
            return false;
        }
        return true;
    }

    @Override // com.kwad.sdk.app.a
    public final void O(String str) {
        if (!TextUtils.equals(com.kwad.sdk.core.response.b.a.ax(this.mAdInfo), str)) {
            return;
        }
        g gVar = this.qp;
        if (gVar.pr != null && g.E(gVar.mAdTemplate)) {
            this.qp.pr.jE();
            com.kwad.sdk.core.c.b.En();
            if (!com.kwad.sdk.core.c.b.isAppOnForeground()) {
                this.wS = System.currentTimeMillis();
            }
        }
    }

    @Override // com.kwad.sdk.app.a
    public final void P(String str) {
    }

    @Override // com.kwad.sdk.core.webview.d.a.a
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.sdk.core.e.c.d("LaunchAppTaskPresenter", "onBind");
        if (!g.E(this.qp.mAdTemplate)) {
            return;
        }
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dS(this.qp.mAdTemplate);
        this.wR = com.kwad.components.ad.reward.a.b.gs();
        com.kwad.sdk.core.c.b.En();
        com.kwad.sdk.core.c.b.a(this.wU);
        com.kwad.components.ad.reward.b.fc().a(this.mRewardVerifyListener);
        com.kwad.components.ad.reward.l.b.a jz = com.kwad.components.ad.reward.l.d.jz();
        this.pr = jz;
        this.qp.pr = jz;
        com.kwad.components.ad.reward.l.b.a.a(jz, getContext(), this.qp.mAdTemplate);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_activity_apk_info_area_native);
        this.wJ = viewGroup;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
            c cVar = new c(this.wJ);
            this.wO = cVar;
            cVar.a(this.qp.mApkDownloadHelper);
            this.wO.a(this);
            this.wO.c(this.qp.mAdTemplate, false);
            ((KSFrameLayout) findViewById(R.id.ksad_right_area_webview_container)).setWidthBasedRatio(false);
            q qVar = new q((KsAdWebView) findViewById(R.id.ksad_right_area_webview), this.wJ, this.qp.mApkDownloadHelper, this);
            this.wK = qVar;
            qVar.a(this.qp.mAdTemplate, adBaseFrameLayout);
        }
        com.kwad.sdk.app.b.AW().a(this);
        a(adBaseFrameLayout);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.e.c.d("LaunchAppTaskPresenter", "onUnbind");
        com.kwad.sdk.core.c.b.En();
        com.kwad.sdk.core.c.b.b(this.wU);
        com.kwad.components.ad.reward.b.fc().b(this.mRewardVerifyListener);
        com.kwad.sdk.app.b.AW().b(this);
        e eVar = this.wM;
        if (eVar != null) {
            eVar.jT();
            this.wM = null;
        }
        c cVar = this.wO;
        if (cVar != null) {
            cVar.jQ();
        }
        this.qp.pr = null;
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dH(this.qp.mAdTemplate)) {
            Y(false);
        }
    }

    @Override // com.kwad.components.ad.reward.n.c.a
    public final void d(boolean z, int i) {
        this.qp.b(1, getContext(), z ? 1 : 153, 1);
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        getContext();
        if (!aj.ML()) {
            com.kwad.sdk.core.e.c.d("LaunchAppTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) findViewById(R.id.ksad_reward_apk_info_stub)).inflate();
        int i = R.id.ksad_reward_apk_info_card_native_container;
        ViewGroup viewGroup = (ViewGroup) findViewById(i);
        this.wL = viewGroup;
        viewGroup.setClickable(true);
        new f(this.wL, this);
        final KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.ksad_reward_apk_info_card_root);
        kSFrameLayout.setRadius(getContext().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_step_icon_radius));
        final float dimension = getContext().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_height);
        kSFrameLayout.post(new az() { // from class: com.kwad.components.ad.reward.presenter.g.b.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                kSFrameLayout.getHeight();
            }
        });
        ViewGroup viewGroup2 = (ViewGroup) findViewById(i);
        this.wL = viewGroup2;
        c cVar = new c(viewGroup2);
        this.wN = cVar;
        cVar.a(this.qp.mApkDownloadHelper);
        this.wN.a(this);
        this.wN.c(this.qp.mAdTemplate, false);
        e eVar = new e((KsAdWebView) findViewById(R.id.ksad_reward_apk_info_card_h5), this.wL, this.qp.mApkDownloadHelper, this);
        this.wM = eVar;
        eVar.a(new com.kwad.components.ad.reward.n.f() { // from class: com.kwad.components.ad.reward.presenter.g.b.2
            @Override // com.kwad.components.ad.reward.n.f
            public final void i(String str, int i2) {
                com.kwad.sdk.core.e.c.d("LaunchAppTaskPresenter", "onUpdateDownloadProgress downloadStatus: " + com.kwad.sdk.core.response.b.e.dS(b.this.qp.mAdTemplate).status);
                b.this.wN.j(str, i2);
            }
        });
        this.wM.a(this.qp.mAdTemplate, adBaseFrameLayout);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        Y(true);
    }
}
