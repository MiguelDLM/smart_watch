package com.kwad.components.ad.k;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes11.dex */
public class b extends a<k> {
    public com.kwad.components.core.video.b HU;
    private boolean HV;
    private k HW;
    protected DetailVideoView mDetailVideoView;

    public b(@NonNull AdTemplate adTemplate, DetailVideoView detailVideoView) {
        super(adTemplate);
        this.HV = false;
        this.HW = new l() { // from class: com.kwad.components.ad.k.b.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                b.this.mAdTemplate.setmCurPlayTime(-1L);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i, int i2) {
                try {
                    super.onMediaPlayError(i, i2);
                    if (!b.this.HV) {
                        b.this.mG();
                    } else if (d.Dh()) {
                        b.this.mG();
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j, long j2) {
                b.this.mAdTemplate.setmCurPlayTime(j2);
            }
        };
        this.mDetailVideoView = detailVideoView;
        this.HU = new com.kwad.components.core.video.b(this.mDetailVideoView, adTemplate);
        mE();
    }

    private void mE() {
        this.HU.c(this.HW);
    }

    private void mF() {
        k kVar;
        com.kwad.components.core.video.b bVar = this.HU;
        if (bVar != null && (kVar = this.HW) != null) {
            bVar.d(kVar);
            this.HW = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mG() {
        com.kwad.components.core.o.a.qI().f(this.mAdTemplate, 21008);
        this.HV = true;
    }

    @Override // com.kwad.components.ad.k.a
    public long getPlayDuration() {
        com.kwad.components.core.video.b bVar = this.HU;
        if (bVar != null) {
            return bVar.getPlayDuration();
        }
        return 0L;
    }

    @Override // com.kwad.components.ad.k.a
    public void pause() {
        this.HU.pause();
    }

    @Override // com.kwad.components.ad.k.a
    @WorkerThread
    public void release() {
        super.release();
        this.HV = false;
        mF();
        com.kwad.components.core.video.b bVar = this.HU;
        if (bVar != null) {
            bVar.clear();
            this.HU.release();
        }
    }

    @Override // com.kwad.components.ad.k.a
    public void resume() {
        this.HU.resume();
    }

    @Override // com.kwad.components.ad.k.a
    @MainThread
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final void b(k kVar) {
        com.kwad.components.core.video.b bVar;
        if (kVar == null || (bVar = this.HU) == null) {
            return;
        }
        bVar.c(kVar);
    }

    @Override // com.kwad.components.ad.k.a
    @MainThread
    /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final void a(k kVar) {
        if (kVar == null) {
            return;
        }
        this.HU.d(kVar);
    }
}
