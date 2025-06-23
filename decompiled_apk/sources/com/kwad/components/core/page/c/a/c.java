package com.kwad.components.core.page.c.a;

import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bo;

/* loaded from: classes11.dex */
public final class c extends a {
    private LinearLayout Pr;
    private TextView Ps;
    private TextView Pt;
    private TextView Pu;
    private TextView Pv;
    private int Pw;
    private boolean Px = false;
    private boolean Py = false;
    private Runnable Pz = new Runnable() { // from class: com.kwad.components.core.page.c.a.c.1
        @Override // java.lang.Runnable
        public final void run() {
            if (c.this.Px) {
                bo.runOnUiThreadDelay(this, 500L);
                return;
            }
            if (c.this.Pw > 0) {
                c.this.pV();
                bo.runOnUiThreadDelay(this, 1000L);
            } else {
                c.this.Ps.setText("任务已完成");
                c.this.Pt.setVisibility(8);
                c.this.Pu.setVisibility(8);
                c.this.Pv.setVisibility(8);
                com.kwad.components.ad.b.g gVar = (com.kwad.components.ad.b.g) com.kwad.sdk.components.c.f(com.kwad.components.ad.b.g.class);
                if (gVar != null && !c.this.Py) {
                    gVar.notifyRewardVerify();
                }
            }
            c.i(c.this);
        }
    };
    private final com.kwad.sdk.core.c.c wU = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.page.c.a.c.2
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityPaused */
        public final void c(Activity activity) {
            super.c(activity);
            c.this.Px = true;
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityResumed */
        public final void d(Activity activity) {
            super.d(activity);
            c.this.Px = false;
        }
    };

    public static /* synthetic */ int i(c cVar) {
        int i = cVar.Pw;
        cVar.Pw = i - 1;
        return i;
    }

    private void pU() {
        this.Pr.setVisibility(0);
        if (this.Pk.mAdTemplate.mRewardVerifyCalled) {
            this.Ps.setText("任务已完成");
            this.Pt.setVisibility(8);
            this.Pu.setVisibility(8);
            this.Pv.setVisibility(8);
            return;
        }
        pV();
        bo.runOnUiThreadDelay(this.Pz, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pV() {
        this.Pt.setText(pW());
        this.Pv.setText(pX());
    }

    private String pW() {
        int i = this.Pw / 60;
        if (i >= 10) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            return sb.toString();
        }
        return "0" + i;
    }

    private String pX() {
        int i = this.Pw % 60;
        if (i >= 10) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            return sb.toString();
        }
        return "0" + i;
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.sdk.core.c.b.En();
        com.kwad.sdk.core.c.b.a(this.wU);
        this.Pw = com.kwad.sdk.core.config.d.CQ();
        pU();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Pr = (LinearLayout) findViewById(R.id.ksad_reward_land_page_open_tip);
        this.Ps = (TextView) findViewById(R.id.ksad_reward_land_page_open_desc);
        this.Pt = (TextView) findViewById(R.id.ksad_reward_land_page_open_minute);
        this.Pu = (TextView) findViewById(R.id.ksad_reward_land_page_open_colon);
        this.Pv = (TextView) findViewById(R.id.ksad_reward_land_page_open_second);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.c.b.En();
        com.kwad.sdk.core.c.b.b(this.wU);
        bo.c(this.Pz);
    }
}
