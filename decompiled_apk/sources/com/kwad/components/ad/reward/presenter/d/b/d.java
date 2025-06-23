package com.kwad.components.ad.reward.presenter.d.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;

/* loaded from: classes11.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, c {
    private static final String[] vX = {"未获得奖励", "已获得奖励1/2", "已获得全部奖励"};
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.d.b.d.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (g.G(d.this.qp.mAdTemplate)) {
                d.this.iI();
            }
        }
    };
    private ViewGroup vT;
    private ImageView vU;
    private ViewGroup vV;
    private TextView vW;

    private void ca() {
        com.kwad.components.ad.reward.b.fc().a(this.mRewardVerifyListener);
        int i = 0;
        this.vT.setVisibility(0);
        ViewGroup viewGroup = this.vV;
        if (!g.G(this.qp.mAdTemplate)) {
            i = 8;
        }
        viewGroup.setVisibility(i);
    }

    private void iH() {
        ImageView imageView = this.vU;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.vU.setOnClickListener(this);
        }
        ViewGroup viewGroup = this.vT;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this);
            this.vT.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iI() {
        this.vW.setText(vX[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.sdk.core.adlog.c.b cK = new com.kwad.sdk.core.adlog.c.b().f(this.qp.mRootContainer.getTouchCoords()).cK(41);
        g gVar = this.qp;
        com.kwad.components.ad.reward.j.b.a(gVar.mAdTemplate, (String) null, (String) null, cK, gVar.mReportExtData);
        this.qp.oJ.bJ();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        ca();
    }

    @Override // com.kwad.components.ad.reward.presenter.d.b.c
    public final void iF() {
        String str;
        g gVar = this.qp;
        if (gVar.pk) {
            if (com.kwad.sdk.core.response.b.a.ar(e.dS(gVar.mAdTemplate))) {
                this.vV.setVisibility(8);
            }
        } else if (!g.E(gVar.mAdTemplate) && !g.F(this.qp.mAdTemplate)) {
            if (!this.qp.fO()) {
                return;
            }
            iH();
        } else if (!this.qp.fO()) {
            TextView textView = this.vW;
            if (this.qp.pf) {
                str = vX[1];
            } else {
                str = vX[0];
            }
            textView.setText(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.vU || view == this.vT) {
            com.kwad.components.core.e.d.a.a(new a.C0788a(view.getContext()).ar(this.qp.mAdTemplate).b(this.qp.mApkDownloadHelper).ao(false).an(2).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.d.b.d.2
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    d.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vT = (ViewGroup) findViewById(R.id.ksad_end_reward_icon_layout);
        this.vU = (ImageView) findViewById(R.id.ksad_end_reward_icon);
        this.vV = (ViewGroup) findViewById(R.id.ksad_detail_reward_deep_task_view_playend);
        this.vW = (TextView) findViewById(R.id.ksad_reward_deep_task_count_down_playend);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.b.fc().b(this.mRewardVerifyListener);
        this.vT.setVisibility(8);
        this.vU.setVisibility(8);
        this.vV.setVisibility(8);
    }
}
