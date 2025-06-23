package com.kwad.components.ad.feed.b;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.feed.FeedDownloadActivityProxy;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* loaded from: classes11.dex */
public final class j extends a implements View.OnClickListener, com.kwad.sdk.widget.c {
    private TextView eB;
    private ImageView eC;
    private ImageView eD;
    private KsLogoView mLogoView;

    public j(@NonNull Context context) {
        super(context);
    }

    private void c(View view, int i) {
        if (view == this.eD) {
            tO();
            return;
        }
        if (com.kwad.components.core.e.d.d.a(new a.C0788a(getContext()).ar(this.mAdTemplate), 1) == 1) {
            aL(i);
        } else if (com.kwad.sdk.core.response.b.a.aE(this.mAdInfo)) {
            aL(i);
            FeedDownloadActivityProxy.launch(this.mContext, this.mAdTemplate, this.abY);
        } else {
            aL(i);
            AdWebViewActivityProxy.launch(getContext(), this.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        onClick(view);
    }

    @Override // com.kwad.components.core.widget.b
    public final void b(@NonNull AdResultData adResultData) {
        super.b((j) adResultData);
        this.eB.setText(com.kwad.components.ad.feed.f.c(this.mAdTemplate));
        List<String> aZ = com.kwad.sdk.core.response.b.a.aZ(this.mAdInfo);
        this.mLogoView.aE(this.mAdTemplate);
        if (aZ.size() > 0) {
            KSImageLoader.loadFeeImage(this.eC, aZ.get(0), this.mAdTemplate);
        } else {
            com.kwad.sdk.core.e.c.e("FeedTextImmerseImageView", "getImageUrlList size less than one");
        }
        com.kwad.sdk.c.a.a.a(this, this.eB, this.eC, this.eD);
        new com.kwad.sdk.widget.f(getContext(), this.eB, this);
        new com.kwad.sdk.widget.f(getContext(), this.eC, this);
        new com.kwad.sdk.widget.f(getContext(), this.eD, this);
        setOnClickListener(this);
        if (com.kwad.sdk.core.response.b.a.aE(this.mAdInfo)) {
            bb();
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bc() {
        ((RatioFrameLayout) findViewById(R.id.ksad_container)).setRatio(0.5600000023841858d);
        this.eB = (TextView) findViewById(R.id.ksad_ad_desc);
        this.eC = (ImageView) findViewById(R.id.ksad_ad_image);
        this.eD = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_text_immerse_image;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        if (view == this.eB) {
            i = 25;
        } else if (view == this.eC) {
            i = 100;
        } else {
            i = 35;
        }
        c(view, i);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dH(this.mAdTemplate)) {
            c(view, 153);
        }
    }
}
