package com.kwad.components.ad.interstitial.e;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.interstitial.e.c;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class f extends b implements com.kwad.sdk.widget.c {
    private List<Integer> cB;

    @NonNull
    private KsAdVideoPlayConfig dU;
    private ImageView eM;
    private com.kwad.sdk.core.video.videoview.a eN;
    private c jK;
    private KSFrameLayout kK;
    private KSFrameLayout kL;
    private com.kwad.components.core.video.f kM;
    protected AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    @NonNull
    protected Context mContext;

    @Nullable
    private boolean mIsAudioEnable = false;
    private final a.InterfaceC0807a eS = new a.InterfaceC0807a() { // from class: com.kwad.components.ad.interstitial.e.f.3
        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        @Override // com.kwad.components.core.video.a.InterfaceC0807a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a(int r11, com.kwad.sdk.utils.ac.a r12) {
            /*
                r10 = this;
                r0 = 2
                r1 = 1
                r2 = 0
                if (r11 == r1) goto L16
                if (r11 == r0) goto L13
                r3 = 3
                if (r11 == r3) goto Le
                r11 = 108(0x6c, float:1.51E-43)
            Lc:
                r3 = 2
                goto L19
            Le:
                r11 = 83
                r2 = 1
                r3 = 1
                goto L19
            L13:
                r11 = 82
                goto Lc
            L16:
                r11 = 13
                goto Lc
            L19:
                com.kwad.components.ad.interstitial.e.f r4 = com.kwad.components.ad.interstitial.e.f.this
                com.kwad.components.ad.interstitial.e.f.d(r4)
                boolean r4 = com.kwad.sdk.utils.aj.ML()
                if (r4 == 0) goto L25
                goto L26
            L25:
                r0 = 1
            L26:
                com.kwad.components.ad.interstitial.report.a r4 = com.kwad.components.ad.interstitial.report.a.dN()
                com.kwad.components.ad.interstitial.e.f r5 = com.kwad.components.ad.interstitial.e.f.this
                com.kwad.sdk.core.response.model.AdTemplate r5 = com.kwad.components.ad.interstitial.e.f.b(r5)
                r6 = 1
                long r8 = (long) r11
                r4.a(r5, r6, r8)
                com.kwad.components.core.e.d.a$a r4 = new com.kwad.components.core.e.d.a$a
                com.kwad.components.ad.interstitial.e.f r5 = com.kwad.components.ad.interstitial.e.f.this
                android.content.Context r5 = com.kwad.components.ad.interstitial.e.f.f(r5)
                r4.<init>(r5)
                com.kwad.components.ad.interstitial.e.f r5 = com.kwad.components.ad.interstitial.e.f.this
                com.kwad.sdk.core.response.model.AdTemplate r5 = com.kwad.components.ad.interstitial.e.f.b(r5)
                com.kwad.components.core.e.d.a$a r4 = r4.ar(r5)
                com.kwad.components.ad.interstitial.e.f r5 = com.kwad.components.ad.interstitial.e.f.this
                com.kwad.components.core.e.d.c r5 = com.kwad.components.ad.interstitial.e.f.e(r5)
                com.kwad.components.core.e.d.a$a r4 = r4.b(r5)
                com.kwad.components.core.e.d.a$a r3 = r4.an(r3)
                com.kwad.components.core.e.d.a$a r2 = r3.ao(r2)
                com.kwad.components.core.e.d.a$a r1 = r2.aq(r1)
                com.kwad.components.core.e.d.a$a r1 = r1.am(r11)
                com.kwad.components.core.e.d.a$a r12 = r1.d(r12)
                com.kwad.components.core.e.d.a$a r12 = r12.ao(r0)
                com.kwad.components.ad.interstitial.e.f$3$1 r0 = new com.kwad.components.ad.interstitial.e.f$3$1
                r0.<init>()
                com.kwad.components.core.e.d.a$a r11 = r12.a(r0)
                com.kwad.components.core.e.d.a.a(r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.interstitial.e.f.AnonymousClass3.a(int, com.kwad.sdk.utils.ac$a):void");
        }
    };

    /* JADX WARN: Removed duplicated region for block: B:17:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void dw() {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.interstitial.e.f.dw():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(long j) {
        c cVar = this.jK;
        cVar.jM = true;
        cVar.b(1L, j);
    }

    @Override // com.kwad.components.ad.interstitial.e.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        c cVar = (c) Kf();
        this.jK = cVar;
        this.dU = cVar.dU;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        this.mAdInfo = dS;
        List<Integer> bn = com.kwad.sdk.core.response.b.a.bn(dS);
        this.cB = bn;
        com.kwad.sdk.core.video.videoview.a aVar = this.jK.eN;
        this.eN = aVar;
        aVar.setTag(bn);
        com.kwad.components.core.video.f fVar = new com.kwad.components.core.video.f(this.mContext, this.mAdTemplate, this.eN);
        this.kM = fVar;
        fVar.setDataFlowAutoStart(this.dU.isDataFlowAutoStart());
        this.kM.setAdClickListener(this.eS);
        this.kM.rV();
        this.mApkDownloadHelper = this.jK.mApkDownloadHelper;
        dw();
        float dimension = getContext().getResources().getDimension(R.dimen.ksad_interstitial_card_radius);
        this.kL.setRadius(dimension, dimension, 0.0f, 0.0f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.kK = (KSFrameLayout) getRootView().findViewById(R.id.ksad_container);
        this.kL = (KSFrameLayout) getRootView().findViewById(R.id.ksad_video_container);
        this.eM = (ImageView) getRootView().findViewById(R.id.ksad_video_first_frame_container);
        this.kL.setVisibility(4);
        this.mContext = getContext();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.jK.jT = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.cB;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.cB.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    private c.b a(View view, boolean z) {
        return new c.b(view.getContext()).k(z).a(this.kK.getTouchCoords()).z(3).A(85);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        this.jK.a(a(view, false));
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        this.jK.a(a(view, true));
    }
}
