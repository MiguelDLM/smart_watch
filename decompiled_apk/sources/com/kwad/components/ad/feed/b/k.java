package com.kwad.components.ad.feed.b;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* loaded from: classes11.dex */
public final class k extends a implements View.OnClickListener, com.kwad.sdk.widget.c {
    private TextView eB;
    private ImageView eD;
    private DownloadProgressView eI;
    private RoundAngleImageView fv;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private KsLogoView mLogoView;

    public k(@NonNull Context context) {
        super(context);
    }

    private void be() {
        this.mLogoView.aE(this.mAdTemplate);
        this.eI.aj(this.mAdTemplate);
        com.kwad.sdk.c.a.a.a(this, this.eB, this.fv, this.eI);
        new com.kwad.sdk.widget.f(getContext(), this.eB, this);
        new com.kwad.sdk.widget.f(getContext(), this.fv, this);
        new com.kwad.sdk.widget.f(getContext(), this.eI, this);
        if (com.kwad.sdk.core.response.b.a.aE(this.mAdInfo)) {
            com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, this.eI.getAppDownloadListener());
            this.mApkDownloadHelper = cVar;
            cVar.d(this.eI.getAppDownloadListener());
            this.mApkDownloadHelper.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            bb();
        }
    }

    private void c(View view, final int i) {
        int i2;
        if (view == this.eD) {
            tO();
            return;
        }
        boolean z = true;
        if (view == this.eI) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        a.C0788a an = new a.C0788a(getContext()).al(5).am(i).ar(this.mAdTemplate).b(this.mApkDownloadHelper).an(i2);
        if (view != this.eI) {
            z = false;
        }
        com.kwad.components.core.e.d.a.a(an.ao(z).a(new a.b() { // from class: com.kwad.components.ad.feed.b.k.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                k.this.aL(i);
            }
        }));
    }

    @Override // com.kwad.components.core.widget.b
    public final void b(@NonNull AdResultData adResultData) {
        super.b((k) adResultData);
        this.eB.setText(com.kwad.components.ad.feed.f.c(this.mAdTemplate));
        List<String> aZ = com.kwad.sdk.core.response.b.a.aZ(this.mAdInfo);
        if (aZ.size() > 0) {
            this.ey = SystemClock.elapsedRealtime();
            KSImageLoader.loadFeeImage(this.fv, aZ.get(0), this.mAdTemplate, this.ez);
        } else {
            com.kwad.sdk.core.e.c.e("FeedTextLeftImageView", "getImageUrlList size less than one");
        }
        be();
        this.eD.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bc() {
        this.eB = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.6600000262260437d);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_ad_image);
        this.fv = roundAngleImageView;
        roundAngleImageView.setRadius(com.kwad.sdk.c.a.a.a(getContext(), 3.0f));
        this.eD = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.eI = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bf() {
        super.bf();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.eI.getAppDownloadListener());
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_text_left_image;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        if (view == this.eB) {
            i = 25;
        } else if (view == this.fv) {
            i = 100;
        } else if (view == this.eI) {
            i = 1;
        } else {
            i = 35;
        }
        c(view, i);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        onClick(view);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dH(this.mAdTemplate)) {
            c(view, 153);
        }
    }
}
