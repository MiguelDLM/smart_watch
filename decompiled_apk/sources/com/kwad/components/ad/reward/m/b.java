package com.kwad.components.ad.reward.m;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes11.dex */
public final class b extends com.kwad.components.ad.k.a<h> implements g.a {
    private com.kwad.components.core.g.c xL;

    public b(@NonNull AdTemplate adTemplate) {
        super(adTemplate);
        long M = com.kwad.sdk.core.response.b.a.M(com.kwad.sdk.core.response.b.e.dS(adTemplate));
        com.kwad.components.core.g.c cVar = new com.kwad.components.core.g.c();
        this.xL = cVar;
        cVar.z(M);
    }

    public final FrameLayout O(Context context) {
        FrameLayout imagePlayerView = this.xL.getImagePlayerView(context);
        this.xL.setImageScaleType(ImageView.ScaleType.FIT_CENTER);
        return imagePlayerView;
    }

    @Override // com.kwad.components.ad.k.a
    public final void a(h hVar) {
        this.xL.d(hVar);
    }

    @Override // com.kwad.components.ad.k.a
    public final void b(h hVar) {
        this.xL.c(hVar);
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fV() {
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fW() {
        resume();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fX() {
        pause();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fY() {
        this.xL.destroy();
    }

    @Override // com.kwad.components.ad.k.a
    public final long getPlayDuration() {
        return this.xL.getPlayDuration();
    }

    public final void jJ() {
        this.xL.setURLs(com.kwad.sdk.core.response.b.a.aZ(com.kwad.sdk.core.response.b.e.dS(this.mAdTemplate)));
        this.xL.play();
    }

    @Override // com.kwad.components.ad.k.a
    public final void pause() {
        this.xL.pause();
    }

    @Override // com.kwad.components.ad.k.a
    public final void release() {
        super.release();
        this.xL.destroy();
    }

    @Override // com.kwad.components.ad.k.a
    public final void resume() {
        this.xL.resume();
    }

    @Override // com.kwad.components.ad.k.a
    public final void skipToEnd() {
        this.xL.skipToEnd();
    }
}
