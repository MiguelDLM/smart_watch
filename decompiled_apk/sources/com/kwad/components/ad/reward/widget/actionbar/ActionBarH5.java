package com.kwad.components.ad.reward.widget.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;

/* loaded from: classes11.dex */
public class ActionBarH5 extends FrameLayout implements c {
    private a BA;
    private View BB;
    private TextView Bz;
    private TextView dM;
    private AdTemplate mAdTemplate;

    /* loaded from: classes11.dex */
    public interface a {
        void N(boolean z);
    }

    public ActionBarH5(Context context) {
        super(context);
        A(context);
    }

    private void A(Context context) {
        l.inflate(context, R.layout.ksad_video_actionbar_h5, this);
        this.Bz = (TextView) findViewById(R.id.ksad_h5_ad_desc);
        this.dM = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.BB = findViewById(R.id.ksad_download_bar_cover);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (d.dH(this.mAdTemplate)) {
            b(view, false);
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        this.BA = aVar;
        AdInfo dS = e.dS(adTemplate);
        this.Bz.setText(com.kwad.sdk.core.response.b.a.at(dS));
        this.dM.setText(com.kwad.sdk.core.response.b.a.aD(dS));
        setClickable(true);
        this.BB.setClickable(true);
        new f(this.BB, this);
        new f(this, this);
    }

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        A(context);
    }

    private void b(View view, final boolean z) {
        com.kwad.components.core.e.d.a.a(new a.C0788a(view.getContext()).ar(this.mAdTemplate).an(view == this.BB ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (ActionBarH5.this.BA != null) {
                    ActionBarH5.this.BA.N(z);
                }
            }
        }));
    }

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        A(context);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }
}
