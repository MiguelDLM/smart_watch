package com.kwad.components.ad.reward.n;

import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.ad.reward.h;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes11.dex */
public final class j extends d implements View.OnClickListener {
    private AdTemplate adTemplate;
    private TextView hz;
    private KSCornerImageView lv;
    private TextView lw;
    private TextView lx;
    private h.a pQ;
    private ViewGroup sA;
    private View vp;
    private DialogFragment zc;
    private TextView zd;
    private View ze;
    private View zf;

    public j(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, ViewGroup viewGroup, h.a aVar) {
        this.zc = dialogFragment;
        this.adTemplate = adTemplate;
        this.pQ = aVar;
        this.sA = (ViewGroup) layoutInflater.inflate(R.layout.ksad_reward_jinniu_dialog, viewGroup, false);
        initView();
    }

    private void initView() {
        this.lv = (KSCornerImageView) this.sA.findViewById(R.id.ksad_reward_jinniu_dialog_icon);
        this.hz = (TextView) this.sA.findViewById(R.id.ksad_reward_jinniu_dialog_title);
        this.lw = (TextView) this.sA.findViewById(R.id.ksad_reward_jinniu_dialog_desc);
        this.zd = (TextView) this.sA.findViewById(R.id.ksad_reward_jinniu_dialog_play_time_tips);
        this.lx = (TextView) this.sA.findViewById(R.id.ksad_reward_jinniu_dialog_detail);
        this.vp = this.sA.findViewById(R.id.ksad_reward_jinniu_dialog_btn_close);
        this.ze = this.sA.findViewById(R.id.ksad_reward_jinniu_dialog_btn_deny);
        this.zf = this.sA.findViewById(R.id.ksad_reward_jinniu_dialog_btn_continue);
        this.vp.setOnClickListener(this);
        this.ze.setOnClickListener(this);
        this.zf.setOnClickListener(this);
        this.lv.setOnClickListener(this);
        this.hz.setOnClickListener(this);
        this.lw.setOnClickListener(this);
        this.lx.setOnClickListener(this);
    }

    public final void a(h.c cVar) {
        KSImageLoader.loadAppIcon(this.lv, cVar.gg(), this.adTemplate, 4);
        this.hz.setText(cVar.getTitle());
        this.lw.setText(cVar.gh());
        this.zd.setText(cVar.gj());
        if (com.kwad.sdk.core.response.b.a.cd(this.adTemplate)) {
            this.lx.setText(String.format("%s >", com.kwad.sdk.core.response.b.a.aD(com.kwad.sdk.core.response.b.e.dS(this.adTemplate))));
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup gG() {
        return this.sA;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        h.a aVar;
        if (view.equals(this.vp)) {
            this.zc.dismiss();
            h.a aVar2 = this.pQ;
            if (aVar2 != null) {
                aVar2.gb();
                return;
            }
            return;
        }
        if (view.equals(this.ze)) {
            this.zc.dismiss();
            h.a aVar3 = this.pQ;
            if (aVar3 != null) {
                aVar3.F(false);
                return;
            }
            return;
        }
        if (view.equals(this.zf)) {
            this.zc.dismiss();
            h.a aVar4 = this.pQ;
            if (aVar4 != null) {
                aVar4.gb();
                return;
            }
            return;
        }
        if (view.equals(this.lv)) {
            h.a aVar5 = this.pQ;
            if (aVar5 != null) {
                aVar5.g(127, 2);
                return;
            }
            return;
        }
        if (view.equals(this.hz)) {
            h.a aVar6 = this.pQ;
            if (aVar6 != null) {
                aVar6.g(128, 2);
                return;
            }
            return;
        }
        if (view.equals(this.lw)) {
            h.a aVar7 = this.pQ;
            if (aVar7 != null) {
                aVar7.g(129, 2);
                return;
            }
            return;
        }
        if (view.equals(this.lx) && (aVar = this.pQ) != null) {
            aVar.g(131, 2);
        }
    }
}
