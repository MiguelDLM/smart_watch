package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class InterstitialAggregateManualTipsView extends LinearLayout implements View.OnClickListener {
    private ImageView iR;
    private ImageView iS;
    private ImageView iT;
    private int iU;
    private int iV;
    private final ViewPager.OnPageChangeListener iW;
    private TransViewPager iv;
    private AdTemplate mAdTemplate;
    private final Context mContext;

    public InterstitialAggregateManualTipsView(Context context) {
        this(context, null);
    }

    private void cz() {
        int i = this.iU;
        if (i < this.iV - 1) {
            this.iv.setCurrentItem(i + 1, true);
        }
    }

    private void initView() {
        l.inflate(this.mContext, R.layout.ksad_interstitial_aggregate_manual_tips, this);
        this.iR = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_cut);
        this.iS = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_refresh);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_convert);
        this.iT = imageView;
        com.kwad.sdk.c.a.a.a(this, this.iR, this.iS, imageView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.components.ad.interstitial.g.c y;
        if (view.equals(this.iR)) {
            cz();
            com.kwad.sdk.core.adlog.c.p(this.mAdTemplate, 162);
        } else if (view.equals(this.iS)) {
            cz();
            com.kwad.sdk.core.adlog.c.p(this.mAdTemplate, 36);
        } else if (view.equals(this.iT) && (y = this.iv.y(this.iU)) != null) {
            y.ec();
        }
    }

    public InterstitialAggregateManualTipsView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InterstitialAggregateManualTipsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iW = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.InterstitialAggregateManualTipsView.1
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i2) {
                InterstitialAggregateManualTipsView.this.iU = i2;
                if (InterstitialAggregateManualTipsView.this.iU == InterstitialAggregateManualTipsView.this.iV - 1) {
                    InterstitialAggregateManualTipsView.this.iR.setAlpha(0.5f);
                    InterstitialAggregateManualTipsView.this.iS.setAlpha(0.5f);
                } else {
                    InterstitialAggregateManualTipsView.this.iR.setAlpha(1.0f);
                    InterstitialAggregateManualTipsView.this.iS.setAlpha(1.0f);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public final void a(@NonNull AdTemplate adTemplate, @NonNull TransViewPager transViewPager) {
        this.mAdTemplate = adTemplate;
        this.iv = transViewPager;
        this.iU = transViewPager.getCurrentItem();
        a aVar = (a) transViewPager.getAdapter();
        if (aVar == null) {
            return;
        }
        this.iV = aVar.getCount();
        new d(this.iv.getContext()).a(this.iv);
        this.iv.addOnPageChangeListener(this.iW);
        AdInfo dS = e.dS(adTemplate);
        String dw = com.kwad.sdk.core.response.b.b.dw(dS);
        String dx = com.kwad.sdk.core.response.b.b.dx(dS);
        String dy = com.kwad.sdk.core.response.b.b.dy(dS);
        if (!TextUtils.isEmpty(dw) && !TextUtils.isEmpty(dx) && !TextUtils.isEmpty(dy)) {
            KSImageLoader.loadImage(this.iR, dw);
            KSImageLoader.loadImage(this.iS, dx);
            KSImageLoader.loadImage(this.iT, dy);
            com.kwad.sdk.core.adlog.c.b(adTemplate, 162, (JSONObject) null);
            return;
        }
        setVisibility(8);
    }
}
