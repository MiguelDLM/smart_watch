package com.kwad.components.ad.splashscreen.d;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.ad.k.b;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.h.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public final class a extends b implements c {
    private boolean FH;
    private Context mContext;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;

    /* renamed from: no, reason: collision with root package name */
    private boolean f18451no;
    private String xM;
    private final List<h.a> xP;
    private OfflineOnAudioConflictListener xR;

    public a(@NonNull AdTemplate adTemplate, @NonNull final DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        this.xP = new ArrayList();
        this.xR = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.splashscreen.d.a.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
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
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        String aY = com.kwad.sdk.core.response.b.a.aY(e.dS(adTemplate));
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        File bZ = com.kwad.sdk.core.diskcache.b.a.DM().bZ(aY);
        if (bZ != null && bZ.exists()) {
            this.xM = bZ.getAbsolutePath();
        }
        this.HU.a(new c.e() { // from class: com.kwad.components.ad.splashscreen.d.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                com.kwad.sdk.core.e.c.d("SplashPlayModule", " onPrepared");
                detailVideoView.post(new az() { // from class: com.kwad.components.ad.splashscreen.d.a.2.1
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        boolean a2 = br.a(detailVideoView, 50, true);
                        com.kwad.sdk.core.e.c.d("SplashPlayModule", " onPrepared" + a2);
                        if (a2) {
                            a.this.HU.start();
                        }
                    }
                });
            }
        });
        com.kwad.components.core.s.a.as(this.mContext).a(this.xR);
    }

    private void aL() {
        this.HU.a(new b.a(this.mAdTemplate).a(this.mVideoPlayerStatus).da(this.xM).db(com.kwad.sdk.core.response.b.h.b(e.dT(this.mAdTemplate))).b(com.kwad.sdk.contentalliance.a.a.a.bF(this.mAdTemplate)).BJ(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.HU.prepareAsync();
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        resume();
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        pause();
    }

    public final void ae(boolean z) {
        this.FH = true;
    }

    public final long getCurrentPosition() {
        return this.HU.getCurrentPosition();
    }

    public final void mh() {
        if (this.HU.rW() == null) {
            aL();
        }
        this.HU.start();
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void release() {
        super.release();
        com.kwad.components.core.s.a.as(this.mContext).b(this.xR);
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void resume() {
        super.resume();
        if (this.f18451no && this.FH) {
            com.kwad.components.core.s.a.as(this.mContext).aN(false);
            if (com.kwad.components.core.s.a.as(this.mContext).rA()) {
                this.f18451no = false;
                setAudioEnabled(false, false);
            }
        }
    }

    @Override // com.kwad.components.ad.k.a
    public final void setAudioEnabled(boolean z, boolean z2) {
        this.f18451no = z;
        if (z && z2) {
            com.kwad.components.core.s.a.as(this.mContext).aN(true);
        }
        this.HU.setAudioEnabled(z);
    }

    public final void a(h.a aVar) {
        this.xP.add(aVar);
    }

    public final void b(h.a aVar) {
        this.xP.remove(aVar);
    }
}
