package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class TailFrameView extends KSFrameLayout {
    private com.kwad.components.ad.reward.widget.tailframe.a BN;
    private g qp;

    /* loaded from: classes11.dex */
    public static class a extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.c {
        public a() {
            super(R.layout.ksad_video_tf_view_landscape_horizontal);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            KSImageLoader.loadImage(this.BE, com.kwad.sdk.core.response.b.a.W(this.mAdInfo), this.mAdTemplate);
        }
    }

    /* loaded from: classes11.dex */
    public static class b extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.c {
        private ImageView BO;
        private ImageView BP;
        private ImageView BQ;

        public b() {
            super(R.layout.ksad_video_tf_view_landscape_vertical);
        }

        private void ko() {
            KSImageLoader.loadImage(this.BO, com.kwad.sdk.core.response.b.a.W(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.BP, com.kwad.sdk.core.response.b.a.W(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.BQ, com.kwad.sdk.core.response.b.a.W(this.mAdInfo), this.mAdTemplate);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void A(Context context) {
            super.A(context);
            this.BO = (ImageView) this.BD.findViewById(R.id.ksad_video_thumb_left);
            this.BP = (ImageView) this.BD.findViewById(R.id.ksad_video_thumb_mid);
            this.BQ = (ImageView) this.BD.findViewById(R.id.ksad_video_thumb_right);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            ko();
        }
    }

    /* loaded from: classes11.dex */
    public static class c extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.c {
        private View BR;

        public c() {
            super(R.layout.ksad_video_tf_view_portrait_horizontal);
        }

        private void ko() {
            AdInfo.AdMaterialInfo.MaterialFeature aW = com.kwad.sdk.core.response.b.a.aW(this.mAdInfo);
            int i = aW.width;
            int i2 = aW.height;
            int screenWidth = com.kwad.sdk.c.a.a.getScreenWidth(this.BD.getContext());
            int i3 = (int) (screenWidth * (i2 / i));
            ViewGroup.LayoutParams layoutParams = this.BE.getLayoutParams();
            layoutParams.width = screenWidth;
            layoutParams.height = i3;
            KSImageLoader.loadImage(this.BE, aW.coverUrl, this.mAdTemplate);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void A(Context context) {
            super.A(context);
            this.BR = this.BD.findViewById(R.id.video_cover);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            if (e.F(this.mAdTemplate)) {
                this.BR.setVisibility(8);
                this.mLogoView.setVisibility(8);
                this.BD.setBackground(null);
            }
            ko();
        }
    }

    /* loaded from: classes11.dex */
    public static class d extends com.kwad.components.ad.reward.widget.tailframe.a {
        public d() {
            super(R.layout.ksad_video_tf_view_portrait_vertical);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            if (e.F(this.mAdTemplate)) {
                this.BD.setBackground(null);
                this.BE.setVisibility(8);
                this.mLogoView.setVisibility(8);
            }
            KSImageLoader.loadImage(this.BE, com.kwad.sdk.core.response.b.a.W(this.mAdInfo), this.mAdTemplate);
        }
    }

    public TailFrameView(@NonNull Context context) {
        super(context);
    }

    private void f(boolean z, boolean z2) {
        if (this.BN != null) {
            return;
        }
        if (z) {
            if (z2) {
                this.BN = new d();
                return;
            } else {
                this.BN = new c();
                return;
            }
        }
        if (z2) {
            this.BN = new b();
        } else {
            this.BN = new a();
        }
    }

    public final void a(com.kwad.components.ad.reward.widget.tailframe.b bVar) {
        this.BN.setCallerContext(this.qp);
        com.kwad.components.ad.reward.widget.tailframe.a aVar = this.BN;
        g gVar = this.qp;
        aVar.a(gVar.mAdTemplate, gVar.mReportExtData, bVar);
    }

    public final void destroy() {
        com.kwad.components.ad.reward.widget.tailframe.a aVar = this.BN;
        if (aVar != null) {
            aVar.destroy();
        }
    }

    public final void jR() {
        this.BN.jR();
    }

    public void setCallerContext(g gVar) {
        this.qp = gVar;
    }

    public TailFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TailFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a(Context context, boolean z, boolean z2) {
        f(z, z2);
        this.BN.A(context);
        this.BN.f(z, z2);
        addView(this.BN.kk(), -1, -1);
    }

    public TailFrameView(@NonNull Context context, View view) {
        super(context, view);
    }
}
