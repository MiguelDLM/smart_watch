package com.kwad.components.ad.interstitial.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes11.dex */
public final class g extends com.kwad.components.ad.interstitial.e.b {
    private static int kS = 4;
    private c jK;
    private a kQ = new a();
    private b kR = new b();
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    /* loaded from: classes11.dex */
    public static class a {
        private ImageView kT;
        private TextView kU;
        private TextView kV;
        private KsPriceView kW;
    }

    /* loaded from: classes11.dex */
    public static class b {
        private String appIconUrl;
        private String kX;
        private CharSequence kY;
        private String kZ;
        private String la;
        private String price;

        public final void a(CharSequence charSequence) {
            this.kY = charSequence;
        }

        public final String dA() {
            return this.kZ;
        }

        public final String dB() {
            return this.la;
        }

        public final String dy() {
            return this.kX;
        }

        public final CharSequence dz() {
            return this.kY;
        }

        public final String getAppIconUrl() {
            return this.appIconUrl;
        }

        public final String getPrice() {
            return this.price;
        }

        public final void r(String str) {
            this.appIconUrl = str;
        }

        public final void s(String str) {
            this.kX = str;
        }

        public final void t(String str) {
            this.kZ = str;
        }

        public final void u(String str) {
            this.price = str;
        }

        public final void v(String str) {
            this.la = str;
        }
    }

    private void a(a aVar, b bVar, AdInfo adInfo, AdTemplate adTemplate) {
        ImageView imageView = aVar.kT;
        if (!TextUtils.isEmpty(bVar.getAppIconUrl())) {
            imageView.setVisibility(0);
            if (com.kwad.sdk.core.response.b.a.ca(adInfo) == 2) {
                KSImageLoader.loadCircleIcon(imageView, bVar.getAppIconUrl(), getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon));
            } else {
                imageView.setImageResource(R.drawable.ksad_default_app_icon);
                KSImageLoader.loadWithRadius(imageView, bVar.getAppIconUrl(), adTemplate, kS);
            }
        } else {
            imageView.setVisibility(8);
        }
        aVar.kU.setText(bVar.dy());
        if (com.kwad.components.ad.interstitial.b.b.cL() && com.kwad.sdk.core.response.b.a.ca(adInfo) == 3) {
            aVar.kW.d(bVar.getPrice(), bVar.dA(), true);
            aVar.kW.setVisibility(0);
            aVar.kV.setVisibility(8);
            dx();
        } else {
            aVar.kV.setText(bVar.dz());
        }
        this.jK.jL.f(bVar.dB(), 0);
    }

    private void d(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.ca(adInfo) == 2) {
            this.kR.r(com.kwad.sdk.core.response.b.a.cJ(adInfo));
            this.kR.s(com.kwad.sdk.core.response.b.a.cf(adInfo));
            CharSequence b2 = com.kwad.sdk.core.response.b.a.b(adInfo, com.kwad.components.core.widget.e.adc);
            if (TextUtils.isEmpty(b2)) {
                b2 = com.kwad.sdk.core.response.b.a.cI(adInfo);
            }
            this.kR.a(b2);
            if (com.kwad.sdk.core.response.b.a.cF(adInfo)) {
                this.kR.v(com.kwad.components.ad.d.b.X());
                return;
            } else {
                this.kR.v(com.kwad.components.ad.d.b.aa());
                return;
            }
        }
        if (com.kwad.components.ad.interstitial.b.b.cL() && com.kwad.sdk.core.response.b.a.ca(adInfo) == 3) {
            AdProductInfo cQ = com.kwad.sdk.core.response.b.a.cQ(adInfo);
            this.kR.r(cQ.icon);
            this.kR.s(cQ.name);
            this.kR.t(cQ.originPrice);
            this.kR.u(cQ.price);
            this.kR.v(com.kwad.components.ad.d.b.Y());
            return;
        }
        if (com.kwad.sdk.core.response.b.a.aE(adInfo)) {
            this.kR.r(com.kwad.sdk.core.response.b.a.cg(adInfo));
            if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.au(adInfo))) {
                this.kR.s(com.kwad.sdk.core.response.b.a.au(adInfo));
            } else if (!TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
                this.kR.s(adInfo.advertiserInfo.adAuthorText);
            } else {
                this.kR.s(getContext().getString(R.string.ksad_ad_default_username_normal));
            }
            this.kR.a(com.kwad.sdk.core.response.b.a.at(adInfo));
            this.kR.v(com.kwad.sdk.core.response.b.a.aD(adInfo));
            return;
        }
        this.kR.r(com.kwad.sdk.core.response.b.a.cg(adInfo));
        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aw(adInfo))) {
            this.kR.s(com.kwad.sdk.core.response.b.a.aw(adInfo));
        } else if (!TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
            this.kR.s(adInfo.advertiserInfo.adAuthorText);
        } else {
            this.kR.s(getContext().getString(R.string.ksad_ad_default_username_normal));
        }
        this.kR.a(com.kwad.sdk.core.response.b.a.at(adInfo));
        this.kR.v(com.kwad.sdk.core.response.b.a.aD(adInfo));
    }

    private void dx() {
        View findViewById = this.jK.jL.findViewById(R.id.ksad_ad_desc_layout);
        View findViewById2 = this.jK.jL.findViewById(R.id.ksad_space);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.weight = 2.68f;
        findViewById.setLayoutParams(layoutParams);
        findViewById2.setVisibility(8);
    }

    @Override // com.kwad.components.ad.interstitial.e.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        c cVar = (c) Kf();
        this.jK = cVar;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        this.kQ.kT = (ImageView) this.jK.jL.findViewById(R.id.ksad_app_icon);
        this.kQ.kU = (TextView) this.jK.jL.findViewById(R.id.ksad_app_title);
        this.kQ.kV = (TextView) this.jK.jL.findViewById(R.id.ksad_app_desc);
        this.kQ.kW = (KsPriceView) this.jK.jL.findViewById(R.id.ksad_product_price);
        d(this.mAdInfo);
        a(this.kQ, this.kR, this.mAdInfo, this.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
