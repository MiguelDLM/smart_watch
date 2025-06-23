package com.kwad.components.core.page.c;

import android.app.Activity;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;

/* loaded from: classes11.dex */
public final class e extends c {
    private com.kwad.components.core.page.d.a mPlayModule;
    private k mVideoPlayStateListener = new l() { // from class: com.kwad.components.core.page.c.e.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i, int i2) {
            Activity activity = e.this.Pe.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
        }
    };

    @Override // com.kwad.components.core.page.c.c, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.core.page.d.a aVar = this.Pe.mPlayModule;
        this.mPlayModule = aVar;
        aVar.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mPlayModule.b(this.mVideoPlayStateListener);
    }
}
