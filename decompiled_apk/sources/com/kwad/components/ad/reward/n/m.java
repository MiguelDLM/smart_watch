package com.kwad.components.ad.reward.n;

import android.app.DialogFragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.h;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes11.dex */
public final class m extends d implements View.OnClickListener {
    private ImageView fq;
    private TextView hz;
    private h.a pQ;
    private DialogFragment zc;
    private View zf;
    private ViewGroup zu;
    private View zv;
    private TextView zw;
    private TextView zx;
    private TextView zy;
    private View zz;

    public m(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, ViewGroup viewGroup, h.a aVar) {
        this.zc = dialogFragment;
        this.pQ = aVar;
        if (com.kwad.sdk.core.response.b.a.cM(com.kwad.sdk.core.response.b.e.dS(adTemplate))) {
            this.zu = (ViewGroup) layoutInflater.inflate(R.layout.ksad_live_origin_dialog, viewGroup, false);
            s(true);
        } else {
            this.zu = (ViewGroup) layoutInflater.inflate(R.layout.ksad_live_subscribe_dialog, viewGroup, false);
            s(false);
        }
    }

    private void s(boolean z) {
        this.zv = this.zu.findViewById(R.id.ksad_live_subscribe_dialog_btn_close);
        this.hz = (TextView) this.zu.findViewById(R.id.ksad_live_subscribe_dialog_title);
        this.fq = (ImageView) this.zu.findViewById(R.id.ksad_live_subscribe_dialog_icon);
        this.zx = (TextView) this.zu.findViewById(R.id.ksad_live_subscribe_dialog_content_txt);
        this.zw = (TextView) this.zu.findViewById(R.id.ksad_live_subscribe_dialog_content);
        this.zf = this.zu.findViewById(R.id.ksad_live_subscribe_dialog_btn_continue);
        this.zz = this.zu.findViewById(R.id.ksad_live_subscribe_dialog_btn_deny);
        this.zy = (TextView) this.zu.findViewById(R.id.ksad_live_subscribe_dialog_vide_detail);
        if (z) {
            this.zv.setVisibility(8);
        }
        this.zv.setOnClickListener(this);
        this.zf.setOnClickListener(this);
        this.zz.setOnClickListener(this);
        this.zy.setOnClickListener(this);
    }

    public final void a(h.c cVar) {
        KSImageLoader.loadCircleIcon(this.fq, cVar.gg(), this.zu.getContext().getResources().getDrawable(R.drawable.ksad_ic_default_user_avatar));
        String title = cVar.getTitle();
        if (this.hz != null && title != null) {
            SpannableString spannableString = new SpannableString(title);
            int color = gG().getResources().getColor(R.color.ksad_reward_main_color);
            spannableString.setSpan(new ForegroundColorSpan(color), 2, 4, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = title.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            this.hz.setText(spannableString);
        }
        this.zw.setText(cVar.gh());
        this.zx.setText(cVar.gi());
        this.zy.setText(String.format("%s", cVar.pZ));
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup gG() {
        return this.zu;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        h.a aVar;
        if (view.equals(this.zv)) {
            this.zc.dismiss();
            h.a aVar2 = this.pQ;
            if (aVar2 != null) {
                aVar2.gb();
                return;
            }
            return;
        }
        if (view.equals(this.zf)) {
            this.zc.dismiss();
            h.a aVar3 = this.pQ;
            if (aVar3 != null) {
                aVar3.gb();
                return;
            }
            return;
        }
        if (view.equals(this.zz)) {
            this.zc.dismiss();
            h.a aVar4 = this.pQ;
            if (aVar4 != null) {
                aVar4.F(false);
                return;
            }
            return;
        }
        if (view.equals(this.zy) && (aVar = this.pQ) != null) {
            aVar.g(131, 2);
        }
    }
}
