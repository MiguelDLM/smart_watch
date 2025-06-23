package com.kwad.components.ad.reward.n;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes11.dex */
public final class k extends d implements com.kwad.sdk.widget.c {
    private TextView hz;
    private KSCornerImageView lv;
    private TextView lw;
    private com.kwad.components.ad.reward.g qp;
    private KsPriceView yI;
    private TextView yL;
    private TextView yM;
    private View yN;
    private ViewStub zg;
    private ViewGroup zh;
    private KsStyledTextButton zi;
    private KsStyledTextButton zj;

    public k(com.kwad.components.ad.reward.g gVar, ViewStub viewStub) {
        this.zg = viewStub;
        this.qp = gVar;
    }

    private void d(View view, boolean z) {
        int i = 153;
        if (view.equals(this.zj)) {
            com.kwad.components.ad.reward.g gVar = this.qp;
            Context context = view.getContext();
            if (z) {
                i = 38;
            }
            gVar.a(2, context, i, 1);
            return;
        }
        if (view.equals(this.zi)) {
            com.kwad.components.ad.reward.g gVar2 = this.qp;
            Context context2 = view.getContext();
            if (z) {
                i = 37;
            }
            gVar2.a(2, context2, i, 1);
            return;
        }
        if (view.equals(this.zh)) {
            com.kwad.components.ad.reward.g gVar3 = this.qp;
            Context context3 = view.getContext();
            if (z) {
                i = 2;
            }
            gVar3.a(2, context3, i, 2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(rVar.getAdTemplate(), com.kwad.components.ad.reward.model.a.I(rVar.getAdTemplate()));
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dH(this.qp.mAdTemplate)) {
            d(view, false);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup gG() {
        return this.zh;
    }

    public final void hide() {
        ViewGroup viewGroup = this.zh;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public k(com.kwad.components.ad.reward.g gVar, ViewGroup viewGroup) {
        this.zh = viewGroup;
        this.qp = gVar;
    }

    private void a(AdTemplate adTemplate, com.kwad.components.ad.reward.model.a aVar) {
        KSImageLoader.loadAppIcon(this.lv, aVar.gg(), adTemplate, 8);
        this.hz.setText(aVar.getTitle());
        this.lw.setText(aVar.gh());
        int dimensionPixelSize = this.zh.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_end_origin_text_size);
        this.yI.getConfig().ae(dimensionPixelSize).ag(dimensionPixelSize).af(this.zh.getResources().getColor(R.color.ksad_jinniu_end_origin_color));
        this.yI.d(aVar.getPrice(), aVar.getOriginPrice(), true);
        String gX = aVar.gX();
        this.yN.setVisibility(TextUtils.isEmpty(gX) ? 8 : 0);
        if (gX != null) {
            this.yL.setText(gX);
        }
        this.yM.setText(aVar.gY());
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        d(view, true);
    }
}
