package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ad;

/* loaded from: classes11.dex */
public class SplashPlayDefaultInfoView extends FrameLayout {
    private KSCornerImageView Fu;
    private ImageView Fv;
    private TextView Fw;
    private TextView hz;
    private TextView lw;

    public SplashPlayDefaultInfoView(@NonNull Context context) {
        super(context);
        mb();
    }

    private void mb() {
        View.inflate(getContext(), R.layout.ksad_play_card_default_info, this);
        this.Fu = (KSCornerImageView) findViewById(R.id.ksad_splash_default_icon);
        this.hz = (TextView) findViewById(R.id.ksad_splash_default_title);
        this.Fv = (ImageView) findViewById(R.id.ksad_splash_default_img);
        this.lw = (TextView) findViewById(R.id.ksad_splash_default_desc);
        this.Fw = (TextView) findViewById(R.id.ksad_splash_default_tips);
    }

    public final void a(AdTemplate adTemplate, float f) {
        c lZ;
        AdInfo dS = e.dS(adTemplate);
        if (com.kwad.sdk.core.response.b.a.dg(dS)) {
            lZ = c.c(f);
        } else {
            lZ = c.lZ();
        }
        a(lZ);
        this.Fu.setRadius(com.kwad.sdk.c.a.a.a(getContext(), lZ.ma()));
        KSImageLoader.loadImage(this.Fu, com.kwad.sdk.core.response.b.a.cg(dS), adTemplate);
        this.hz.setText(com.kwad.sdk.core.response.b.a.cd(dS));
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.at(dS))) {
            this.lw.setVisibility(8);
        } else {
            this.lw.setText(com.kwad.sdk.core.response.b.a.at(dS));
        }
    }

    public SplashPlayDefaultInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        mb();
    }

    public SplashPlayDefaultInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mb();
    }

    @RequiresApi(api = 21)
    public SplashPlayDefaultInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        mb();
    }

    private void a(c cVar) {
        ad.a(this, cVar.S(getContext()));
        ad.a(this.Fu, cVar.T(getContext()));
        ad.a(this.hz, cVar.U(getContext()));
        ad.a(this.Fv, cVar.V(getContext()));
        ad.a(this.lw, cVar.W(getContext()));
        ad.a(this.Fw, cVar.X(getContext()));
        this.hz.setTextSize(0, cVar.Y(getContext()));
        this.lw.setTextSize(0, cVar.Z(getContext()));
        this.Fw.setTextSize(0, cVar.aa(getContext()));
    }
}
