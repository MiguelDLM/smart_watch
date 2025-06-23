package com.kwad.components.ad.reward.widget.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;

/* loaded from: classes11.dex */
public class ActionBarAppPortrait extends LinearLayout implements c {
    private AppScoreView Bs;
    private TextProgressBar Bt;
    private View Bu;
    private a Bx;
    private KsAppDownloadListener cx;
    private ImageView dE;
    private TextView dF;
    private TextView dH;
    private TextView eF;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* loaded from: classes11.dex */
    public interface a {
        void N(boolean z);
    }

    public ActionBarAppPortrait(Context context) {
        this(context, null);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.cx == null) {
            this.cx = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    ActionBarAppPortrait.this.Bt.e(com.kwad.sdk.core.response.b.a.aD(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.Bu.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    ActionBarAppPortrait.this.Bt.e(com.kwad.sdk.core.response.b.a.ca(ActionBarAppPortrait.this.mAdTemplate), 0);
                    ActionBarAppPortrait.this.Bu.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    ActionBarAppPortrait.this.Bt.e(com.kwad.sdk.core.response.b.a.aD(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.Bu.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    ActionBarAppPortrait.this.Bt.e(com.kwad.sdk.core.response.b.a.ab(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.Bu.setVisibility(0);
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    ActionBarAppPortrait.this.Bt.e(com.kwad.sdk.core.response.b.a.dn(i), i);
                    ActionBarAppPortrait.this.Bu.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    ActionBarAppPortrait.this.Bt.e(com.kwad.sdk.core.response.b.a.dm(i), i);
                    ActionBarAppPortrait.this.Bu.setVisibility(8);
                }
            };
        }
        return this.cx;
    }

    private void initView() {
        l.inflate(getContext(), R.layout.ksad_video_actionbar_app_portrait, this);
        this.dE = (ImageView) findViewById(R.id.ksad_app_icon);
        this.dF = (TextView) findViewById(R.id.ksad_app_title);
        this.eF = (TextView) findViewById(R.id.ksad_app_desc);
        this.Bs = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.dH = (TextView) findViewById(R.id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.Bt = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.c.a.a.a(getContext(), 16.0f));
        this.Bt.setTextColor(-1);
        this.Bu = findViewById(R.id.ksad_download_bar_cover);
    }

    private void ki() {
        boolean z;
        String ay = com.kwad.sdk.core.response.b.a.ay(this.mAdInfo);
        boolean isEmpty = TextUtils.isEmpty(ay);
        float az = com.kwad.sdk.core.response.b.a.az(this.mAdInfo);
        if (az >= 3.0f) {
            z = true;
        } else {
            z = false;
        }
        if (!isEmpty && z) {
            ((LinearLayout.LayoutParams) this.dF.getLayoutParams()).bottomMargin = com.kwad.sdk.c.a.a.a(getContext(), 1.0f);
            ((LinearLayout.LayoutParams) this.Bs.getLayoutParams()).bottomMargin = com.kwad.sdk.c.a.a.a(getContext(), 1.0f);
            this.dH.setText(ay);
            this.dH.setVisibility(0);
            this.Bs.setVisibility(0);
            this.Bs.setScore(az);
            this.eF.setVisibility(8);
            return;
        }
        if (!isEmpty) {
            this.dH.setText(ay);
            this.dH.setVisibility(0);
            this.Bs.setVisibility(8);
            this.eF.setVisibility(8);
            return;
        }
        if (z) {
            this.dH.setVisibility(8);
            this.Bs.setScore(az);
            this.Bs.setVisibility(0);
            this.eF.setVisibility(8);
            return;
        }
        this.eF.setText(com.kwad.sdk.core.response.b.a.at(this.mAdInfo));
        this.dH.setVisibility(8);
        this.Bs.setVisibility(8);
        this.eF.setVisibility(0);
    }

    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.components.core.e.d.c cVar, a aVar) {
        this.mAdTemplate = adTemplate;
        AdInfo dS = e.dS(adTemplate);
        this.mAdInfo = dS;
        this.Bx = aVar;
        this.mApkDownloadHelper = cVar;
        KSImageLoader.loadAppIcon(this.dE, com.kwad.sdk.core.response.b.a.cg(dS), adTemplate, 12);
        this.dF.setText(com.kwad.sdk.core.response.b.a.cd(this.mAdInfo));
        ki();
        this.Bt.e(com.kwad.sdk.core.response.b.a.aD(this.mAdInfo), 0);
        com.kwad.components.core.e.d.c cVar2 = this.mApkDownloadHelper;
        if (cVar2 != null) {
            cVar2.b(getAppDownloadListener());
        }
        setClickable(true);
        new f(this, this);
        new f(this.Bu, this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (d.dH(this.mAdTemplate)) {
            b(view, false);
        }
    }

    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void b(View view, final boolean z) {
        int i = view == this.Bu ? 1 : 2;
        com.kwad.components.core.e.d.a.a(new a.C0788a(view.getContext()).ar(this.mAdTemplate).b(this.mApkDownloadHelper).al(1).am(i).ao(view == this.Bt).an(i).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (ActionBarAppPortrait.this.Bx != null) {
                    ActionBarAppPortrait.this.Bx.N(z);
                }
            }
        }));
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }
}
