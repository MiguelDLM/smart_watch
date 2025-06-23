package com.kwad.components.ad.reward.n;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.components.ad.reward.widget.KsAuthorIconView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aj;

/* loaded from: classes11.dex */
public final class o extends s implements View.OnClickListener {
    private TextView lw;
    private com.kwad.components.ad.reward.g qp;
    private KsLogoView zL;
    private KsLogoView zM;
    private KsAuthorIconView zN;
    private RelativeLayout zO;
    private String zQ;
    private TextView zl;
    private TextView zm;
    private boolean zP = false;
    private Runnable zR = new Runnable() { // from class: com.kwad.components.ad.reward.n.o.2
        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.kwad.sdk.c.a.a.a(o.this.lw, o.this.zQ, KsLogoView.a(o.this.zL));
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                o.this.lw.setText(o.this.zQ);
                o.this.lw.setVisibility(0);
            }
        }
    };

    public o(com.kwad.components.ad.reward.g gVar) {
        this.qp = gVar;
    }

    private static void h(View view, int i) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = 85;
            layoutParams2.bottomMargin = com.kwad.sdk.c.a.a.a(view.getContext(), 20.0f);
            view.requestLayout();
        }
    }

    private void initView() {
        ViewGroup viewGroup = this.sA;
        if (viewGroup == null) {
            return;
        }
        this.zN = (KsAuthorIconView) viewGroup.findViewById(R.id.ksad_live_author_icon);
        this.zl = (TextView) this.sA.findViewById(R.id.kwad_actionbar_title);
        this.lw = (TextView) this.sA.findViewById(R.id.kwad_actionbar_des_text);
        this.zm = (TextView) this.sA.findViewById(R.id.ksad_live_actionbar_btn);
        this.zM = (KsLogoView) this.sA.findViewById(R.id.ksad_reward_live_kwai_logo);
        if (!this.zP) {
            this.zO = (RelativeLayout) this.sA.findViewById(R.id.ksad_reward_origin_live_relative);
        }
        this.sA.setOnClickListener(this);
        this.zm.setOnClickListener(this);
        this.zN.setOnClickListener(this);
        this.lw.setOnClickListener(this);
        this.zl.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void ab(boolean z) {
        super.ab(z);
        Context context = this.sA.getContext();
        if (!aj.ML()) {
            if (!this.zP) {
                this.sA.findViewById(R.id.ksad_reward_origin_live_base1).setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.zO.getLayoutParams();
                Resources resources = context.getResources();
                int i = R.dimen.ksad_live_subscribe_card_width_horizontal;
                layoutParams.width = resources.getDimensionPixelSize(i);
                this.zO.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.zm.getLayoutParams();
                layoutParams2.width = context.getResources().getDimensionPixelSize(i);
                this.zm.setLayoutParams(layoutParams2);
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = this.sA.getLayoutParams();
            layoutParams3.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
            this.sA.setLayoutParams(layoutParams3);
            h(this.sA, 85);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.zm)) {
            this.qp.a(1, view.getContext(), 29, 1);
            return;
        }
        if (view.equals(this.zN)) {
            this.qp.a(1, view.getContext(), 30, 1);
            return;
        }
        if (view.equals(this.lw)) {
            this.qp.a(1, view.getContext(), 32, 1);
        } else if (view.equals(this.zl)) {
            this.qp.a(1, view.getContext(), 31, 1);
        } else if (view.equals(this.sA)) {
            this.qp.a(1, view.getContext(), 53, 2);
        }
    }

    private void b(AdTemplate adTemplate) {
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        this.zl.setText(com.kwad.sdk.core.response.b.a.cd(dS));
        com.kwad.components.core.widget.e eVar = new com.kwad.components.core.widget.e();
        this.zN.setVisibility(0);
        this.zN.b(adTemplate);
        this.zN.a(eVar);
        this.zm.setText(com.kwad.sdk.core.response.b.a.aD(dS));
        if (com.kwad.sdk.core.response.b.a.be(dS) == 8) {
            this.zM.setVisibility(0);
            this.zM.aE(adTemplate);
            this.lw.setText(com.kwad.sdk.core.response.b.a.at(dS));
        } else {
            this.zQ = com.kwad.sdk.core.response.b.a.at(dS);
            KsLogoView ksLogoView = new KsLogoView(this.sA.getContext(), false);
            this.zL = ksLogoView;
            ksLogoView.setLogoLoadFinishListener(new KsLogoView.a() { // from class: com.kwad.components.ad.reward.n.o.1
                @Override // com.kwad.components.core.widget.KsLogoView.a
                public final void kd() {
                    o.this.lw.post(o.this.zR);
                }
            });
            this.zL.aE(adTemplate);
            this.zM.setVisibility(8);
        }
    }

    public final void a(ViewGroup viewGroup, int i) {
        if (i == 8) {
            super.a(viewGroup, R.id.ksad_reward_origin_live_shop_stub, R.id.ksad_reward_origin_live_root);
            this.zP = true;
        } else {
            super.a(viewGroup, R.id.ksad_reward_origin_live_base_stub, R.id.ksad_reward_origin_live_root);
            this.zP = false;
        }
        initView();
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        b(rVar.getAdTemplate());
    }
}
