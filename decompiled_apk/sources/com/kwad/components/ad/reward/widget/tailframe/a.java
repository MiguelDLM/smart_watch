package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public abstract class a implements c {
    protected View BD;
    protected ImageView BE;
    private com.kwad.components.ad.widget.tailframe.appbar.a BF;
    private TailFrameBarH5View BG;
    private b BH;
    private TextProgressBar BI;
    private View BJ;
    private int BK;
    private TextView dM;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    protected KsLogoView mLogoView;
    private JSONObject mReportExtData;
    private g qp;

    public a(int i) {
        this.BK = i;
    }

    private void bindDownloadListener() {
        this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate, this.mReportExtData, new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.reward.widget.tailframe.a.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.BF.D(a.this.mAdInfo);
                a.this.BI.e(com.kwad.sdk.core.response.b.a.aD(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.BF.D(a.this.mAdInfo);
                a.this.BI.e(com.kwad.sdk.core.response.b.a.ca(a.this.mAdTemplate), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a.this.BF.D(a.this.mAdInfo);
                a.this.BI.e(com.kwad.sdk.core.response.b.a.aD(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.BF.D(a.this.mAdInfo);
                a.this.BI.e(com.kwad.sdk.core.response.b.a.ab(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                a.this.BF.D(a.this.mAdInfo);
                a.this.BI.e(com.kwad.sdk.core.response.b.a.dn(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                a.this.BF.D(a.this.mAdInfo);
                a.this.BI.e(com.kwad.sdk.core.response.b.a.dm(i), i);
            }
        });
    }

    private void kj() {
        this.BD.setOnClickListener(null);
        this.mApkDownloadHelper = null;
    }

    private void kl() {
        if (!com.kwad.sdk.core.response.b.a.aE(this.mAdInfo) && !e.F(this.mAdTemplate)) {
            this.BG.b(this.mAdTemplate);
            TextView h5OpenBtn = this.BG.getH5OpenBtn();
            this.dM = h5OpenBtn;
            h5OpenBtn.setClickable(true);
            this.BG.setVisibility(0);
            new f(this.dM, this);
            return;
        }
        this.BF.b(this.mAdTemplate);
        this.BF.setVisibility(0);
        this.BI = this.BF.getTextProgressBar();
        if (!e.F(this.mAdTemplate)) {
            this.BI.setClickable(true);
            new f(this.BI, this);
            bindDownloadListener();
        } else {
            View btnInstallContainer = this.BF.getBtnInstallContainer();
            this.BJ = btnInstallContainer;
            btnInstallContainer.setClickable(true);
            new f(this.BJ, this);
        }
    }

    public void A(Context context) {
        View a2 = l.a(context, this.BK, null, false);
        this.BD = a2;
        this.BE = (ImageView) a2.findViewById(R.id.ksad_video_thumb_img);
        this.mLogoView = (KsLogoView) this.BD.findViewById(R.id.ksad_video_tf_logo);
        this.BF = (com.kwad.components.ad.widget.tailframe.appbar.a) this.BD.findViewById(R.id.ksad_video_app_tail_frame);
        this.BG = (TailFrameBarH5View) this.BD.findViewById(R.id.ksad_video_h5_tail_frame);
    }

    public final void destroy() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.BF;
        if (aVar != null) {
            aVar.kn();
            this.BF.setVisibility(8);
        }
        TailFrameBarH5View tailFrameBarH5View = this.BG;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.kn();
            this.BG.setVisibility(8);
        }
        kj();
    }

    public final void f(boolean z, boolean z2) {
        this.BG.g(z, z2);
    }

    public final void jR() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.BF;
        if (aVar != null) {
            aVar.kn();
        }
        TailFrameBarH5View tailFrameBarH5View = this.BG;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.kn();
        }
    }

    public final View kk() {
        return this.BD;
    }

    public final void setCallerContext(g gVar) {
        this.qp = gVar;
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.dS(adTemplate);
        this.mReportExtData = jSONObject;
        this.BH = bVar;
        this.mLogoView.aE(this.mAdTemplate);
        kl();
        this.BD.setClickable(true);
        new f(this.BD, this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (d.dH(this.mAdTemplate)) {
            b(view, false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        r1 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(android.view.View r6, final boolean r7) {
        /*
            r5 = this;
            com.kwad.sdk.core.response.model.AdTemplate r0 = r5.mAdTemplate
            boolean r0 = com.kwad.sdk.core.response.b.e.F(r0)
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L21
            if (r7 == 0) goto Le
            r7 = 1
            goto L10
        Le:
            r7 = 153(0x99, float:2.14E-43)
        L10:
            com.kwad.components.ad.reward.g r0 = r5.qp
            android.view.View r3 = r5.BD
            android.content.Context r3 = r3.getContext()
            android.view.View r4 = r5.BJ
            if (r6 != r4) goto L1d
            r1 = 1
        L1d:
            r0.a(r2, r3, r7, r1)
            return
        L21:
            com.kwad.sdk.core.response.model.AdInfo r0 = r5.mAdInfo
            boolean r0 = com.kwad.sdk.core.response.b.a.aE(r0)
            if (r0 == 0) goto L2f
            com.kwad.components.core.page.widget.TextProgressBar r0 = r5.BI
            if (r6 != r0) goto L34
        L2d:
            r1 = 1
            goto L34
        L2f:
            android.widget.TextView r0 = r5.dM
            if (r6 != r0) goto L34
            goto L2d
        L34:
            com.kwad.components.core.e.d.a$a r0 = new com.kwad.components.core.e.d.a$a
            android.content.Context r3 = r6.getContext()
            r0.<init>(r3)
            com.kwad.sdk.core.response.model.AdTemplate r3 = r5.mAdTemplate
            com.kwad.components.core.e.d.a$a r0 = r0.ar(r3)
            com.kwad.components.core.e.d.c r3 = r5.mApkDownloadHelper
            com.kwad.components.core.e.d.a$a r0 = r0.b(r3)
            r3 = 0
            if (r1 != r2) goto L4e
            r4 = 1
            goto L4f
        L4e:
            r4 = 0
        L4f:
            com.kwad.components.core.e.d.a$a r0 = r0.am(r4)
            com.kwad.components.core.e.d.a$a r0 = r0.al(r2)
            com.kwad.components.core.page.widget.TextProgressBar r4 = r5.BI
            if (r6 != r4) goto L5c
            goto L5d
        L5c:
            r2 = 0
        L5d:
            com.kwad.components.core.e.d.a$a r6 = r0.ao(r2)
            com.kwad.components.core.e.d.a$a r6 = r6.an(r1)
            com.kwad.components.ad.reward.widget.tailframe.a$2 r0 = new com.kwad.components.ad.reward.widget.tailframe.a$2
            r0.<init>()
            com.kwad.components.core.e.d.a$a r6 = r6.a(r0)
            com.kwad.components.core.e.d.a.a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.widget.tailframe.a.b(android.view.View, boolean):void");
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }
}
