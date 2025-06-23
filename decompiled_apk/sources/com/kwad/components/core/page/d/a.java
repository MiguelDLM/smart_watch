package com.kwad.components.core.page.d;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.j;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public final class a implements com.kwad.components.core.l.a.a {
    private b HU;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;

    /* renamed from: no, reason: collision with root package name */
    private boolean f18461no;
    private l nq;
    private String xM;
    private boolean xO = false;
    private final List<h.a> xP = new ArrayList();
    private OfflineOnAudioConflictListener xR = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.page.d.a.1
        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            a.a(a.this, true);
            if (a.this.HU != null) {
                a.this.HU.setAudioEnabled(false);
            }
            synchronized (a.this.xP) {
                try {
                    Iterator it = a.this.xP.iterator();
                    while (it.hasNext()) {
                        ((h.a) it.next()).onAudioBeOccupied();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
            synchronized (a.this.xP) {
                try {
                    Iterator it = a.this.xP.iterator();
                    while (it.hasNext()) {
                        ((h.a) it.next()).onAudioBeReleased();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };

    public a(@NonNull final AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mAdTemplate = adTemplate;
        Context context = detailVideoView.getContext();
        this.mContext = context;
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        this.xM = j.f(context, adTemplate);
        this.mDetailVideoView = detailVideoView;
        this.HU = new b(detailVideoView, adTemplate);
        aL();
        l lVar = new l() { // from class: com.kwad.components.core.page.d.a.2
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i, int i2) {
                super.onMediaPlayError(i, i2);
                com.kwad.components.core.o.a.qI().c(adTemplate, i, i2);
            }
        };
        this.nq = lVar;
        this.HU.c(lVar);
        this.HU.a(new c.e() { // from class: com.kwad.components.core.page.d.a.3
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(c cVar) {
                try {
                    a.this.HU.start();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        com.kwad.components.core.s.a.as(this.mContext).a(this.xR);
    }

    private void aL() {
        this.HU.a(new b.a(this.mAdTemplate).da(this.xM).db(com.kwad.sdk.core.response.b.h.b(e.dT(this.mAdTemplate))).a(this.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.bF(this.mAdTemplate)).BJ(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.HU.prepareAsync();
    }

    private void pause() {
        SceneImpl sceneImpl;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate.mXiaomiAppStoreDetailViewOpen && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2) {
            return;
        }
        this.HU.pause();
    }

    private void resume() {
        this.HU.resume();
    }

    private void setAudioEnabled(boolean z, boolean z2) {
        this.f18461no = z;
        this.HU.setAudioEnabled(z);
    }

    @Override // com.kwad.components.core.l.a.a
    public final void c(com.kwad.components.core.proxy.c cVar) {
        resume();
    }

    @Override // com.kwad.components.core.l.a.a
    public final void d(com.kwad.components.core.proxy.c cVar) {
        pause();
    }

    @Override // com.kwad.components.core.l.a.a
    public final void fQ() {
        this.xO = false;
        if (this.HU.rW() == null) {
            aL();
        }
    }

    @Override // com.kwad.components.core.l.a.a
    public final void fR() {
        this.xO = false;
        com.kwad.components.core.video.b bVar = this.HU;
        if (bVar != null) {
            bVar.d(this.nq);
            this.HU.release();
        }
    }

    @MainThread
    public final void release() {
        com.kwad.components.core.video.b bVar = this.HU;
        if (bVar != null) {
            bVar.clear();
            this.HU.release();
        }
        com.kwad.components.core.s.a.as(this.mContext).b(this.xR);
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.xO = true;
        return true;
    }

    @MainThread
    public final void b(k kVar) {
        if (kVar == null) {
            return;
        }
        this.HU.d(kVar);
    }

    @MainThread
    public final void a(k kVar) {
        if (kVar == null) {
            return;
        }
        this.HU.c(kVar);
    }
}
