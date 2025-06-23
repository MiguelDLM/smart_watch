package com.kwad.components.ad.interstitial.g;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.g;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class b extends g implements View.OnClickListener {
    private static boolean lA;
    private TextView hz;
    private com.kwad.components.ad.interstitial.e.c jK;
    private KSCornerImageView lv;
    private TextView lw;
    private TextView lx;
    private TextView ly;
    private TextView lz;
    private AdTemplate mAdTemplate;

    public static void e(com.kwad.components.ad.interstitial.e.c cVar) {
        if (lA) {
            return;
        }
        lA = true;
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_TEMPLATE", cVar.mAdTemplate.toJson().toString());
        bVar.setArguments(bundle);
        bVar.f(cVar);
        bVar.show(cVar.f18436io.getOwnerActivity().getFragmentManager(), "interstitialCloseDialog");
    }

    private void f(com.kwad.components.ad.interstitial.e.c cVar) {
        this.jK = cVar;
    }

    private void i(View view) {
        this.lv = (KSCornerImageView) view.findViewById(R.id.ksad_interstitial_intercept_app_icon);
        this.hz = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_app_title);
        this.lw = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_desc);
        this.lx = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_detail);
        this.ly = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_btn_continue);
        TextView textView = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_btn_deny);
        this.lz = textView;
        com.kwad.sdk.c.a.a.a(this, this.lv, this.hz, this.lw, this.lx, this.ly, textView);
    }

    private void initData() {
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(this.mAdTemplate);
        KSImageLoader.loadAppIcon(this.lv, com.kwad.sdk.core.response.b.a.cg(dS), this.mAdTemplate, 12);
        this.hz.setText(com.kwad.sdk.core.response.b.a.cd(dS));
        this.lw.setText(com.kwad.sdk.core.response.b.a.at(dS));
        if (com.kwad.sdk.core.response.b.a.cd(this.mAdTemplate)) {
            this.lx.setText(com.kwad.sdk.core.response.b.a.aD(dS));
        }
    }

    @Override // com.kwad.components.core.proxy.g
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        String string = getArguments().getString("KEY_TEMPLATE");
        try {
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(string));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        View inflate = layoutInflater.inflate(R.layout.ksad_interstitial_exit_intercept_dialog, viewGroup);
        i(inflate);
        initData();
        return inflate;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }
        getDialog().setCanceledOnTouchOutside(false);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setCancelable(false);
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null) {
            com.kwad.sdk.core.adlog.c.d(cVar.mAdTemplate, new JSONObject(), new com.kwad.sdk.core.adlog.c.b().cM(149).cR(9));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.jK != null) {
            if (view.equals(this.lv)) {
                com.kwad.components.ad.interstitial.e.c cVar = this.jK;
                cVar.a(cVar.f18436io.getContext(), 127, 2, 9);
            } else if (view.equals(this.hz)) {
                com.kwad.components.ad.interstitial.e.c cVar2 = this.jK;
                cVar2.a(cVar2.f18436io.getContext(), 128, 2, 9);
            } else if (view.equals(this.lw)) {
                com.kwad.components.ad.interstitial.e.c cVar3 = this.jK;
                cVar3.a(cVar3.f18436io.getContext(), 129, 2, 9);
            } else if (view.equals(this.lx)) {
                com.kwad.components.ad.interstitial.e.c cVar4 = this.jK;
                cVar4.a(cVar4.f18436io.getContext(), 131, 2, 9);
            } else if (view.equals(this.ly)) {
                com.kwad.sdk.core.adlog.c.c(this.jK.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cR(9));
            } else if (view.equals(this.lz)) {
                com.kwad.components.ad.interstitial.e.c cVar5 = this.jK;
                cVar5.a(false, -1, cVar5.eN);
                this.jK.f18436io.dismiss();
                com.kwad.sdk.core.adlog.c.e(this.jK.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cM(151).cR(9));
            }
        }
        dismiss();
        lA = false;
    }
}
