package com.kwad.components.core.page.c.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: classes11.dex */
public final class e extends a {
    private LinearLayout OC;
    private TextView OD;
    private ImageView OE;

    private void pZ() {
        this.OC = (LinearLayout) findViewById(R.id.ksad_web_tip_bar);
        if (!TextUtils.isEmpty(this.Pk.mPageTitle)) {
            this.OC.setVisibility(8);
            return;
        }
        this.OD = (TextView) findViewById(R.id.ksad_web_tip_bar_textview);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_web_tip_close_btn);
        this.OE = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.a.e.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.OC.setVisibility(8);
            }
        });
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(this.Pk.mAdTemplate);
        boolean bx = com.kwad.sdk.core.response.b.a.bx(dS);
        String bt = com.kwad.sdk.core.response.b.a.bt(dS);
        if (bx) {
            this.OC.setVisibility(0);
            this.OD.setText(bt);
            this.OD.setSelected(true);
        } else {
            this.OC.setVisibility(8);
        }
        this.Pk.a(qa());
    }

    @NonNull
    private KsAdWebView.c qa() {
        return new KsAdWebView.c() { // from class: com.kwad.components.core.page.c.a.e.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.c
            public final void qb() {
                if (e.this.Pk.pH() && e.this.OC.getVisibility() == 0) {
                    e.this.OC.setVisibility(8);
                }
            }
        };
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        pZ();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
