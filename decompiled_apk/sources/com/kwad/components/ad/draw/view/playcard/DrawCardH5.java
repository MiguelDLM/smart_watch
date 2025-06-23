package com.kwad.components.ad.draw.view.playcard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.s.n;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import com.kwad.sdk.utils.k;

/* loaded from: classes11.dex */
public class DrawCardH5 extends FrameLayout implements View.OnClickListener {
    private ValueAnimator du;
    private a dw;
    private ImageView dx;
    private TextView dy;
    private TextView dz;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private int mHeight;
    private KsLogoView mLogoView;

    /* loaded from: classes11.dex */
    public interface a {
        void av();

        void aw();
    }

    public DrawCardH5(Context context) {
        super(context);
        A(context);
    }

    private void A(Context context) {
        this.mContext = context;
        l.inflate(context, R.layout.ksad_draw_card_h5, this);
        this.dx = (ImageView) findViewById(R.id.ksad_card_close);
        this.dy = (TextView) findViewById(R.id.ksad_card_ad_desc);
        this.dz = (TextView) findViewById(R.id.ksad_card_h5_open_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_draw_h5_logo);
    }

    private void aG() {
        ValueAnimator valueAnimator = this.du;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.du.cancel();
        }
    }

    private void aQ() {
        d(this.mHeight, 0);
    }

    private void d(int i, int i2) {
        aG();
        ValueAnimator b = n.b(this, i, i2);
        this.du = b;
        b.setInterpolator(new DecelerateInterpolator(2.0f));
        this.du.setDuration(300L);
        this.du.start();
    }

    public final void aO() {
        d(0, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dx) {
            aQ();
            a aVar = this.dw;
            if (aVar != null) {
                aVar.av();
                return;
            }
            return;
        }
        com.kwad.components.core.e.d.a.a(new a.C0788a(getContext()).ar(this.mAdTemplate).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardH5.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (DrawCardH5.this.dw != null) {
                    DrawCardH5.this.dw.aw();
                }
            }
        }));
    }

    public final void release() {
        aG();
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        AdInfo dS = e.dS(adTemplate);
        this.dw = aVar;
        this.dy.setText(com.kwad.sdk.core.response.b.a.at(dS));
        this.dz.setText(com.kwad.sdk.core.response.b.a.aD(dS));
        this.dx.setOnClickListener(this);
        this.dz.setOnClickListener(this);
        this.mLogoView.aE(adTemplate);
        setOnClickListener(this);
        this.dy.measure(View.MeasureSpec.makeMeasureSpec((k.getScreenWidth(this.mContext) - (com.kwad.sdk.c.a.a.a(this.mContext, 16.0f) * 2)) - (com.kwad.sdk.c.a.a.a(this.mContext, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mHeight = com.kwad.sdk.c.a.a.a(this.mContext, 100.0f) + this.dy.getMeasuredHeight();
    }

    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        A(context);
    }

    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        A(context);
    }
}
