package com.kwad.components.ad.reward.m;

import android.content.Context;
import androidx.annotation.MainThread;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.j;
import com.kwad.components.core.video.l;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes11.dex */
public final class d extends com.kwad.components.ad.k.b implements g.a {
    private boolean kI;
    private Context mContext;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;

    /* renamed from: no, reason: collision with root package name */
    private boolean f18447no;
    private l nq;
    private g qp;
    private String xM;
    private AtomicBoolean xN;
    private boolean xO;
    private final List<h.a> xP;
    private final List<Object> xQ;
    private OfflineOnAudioConflictListener xR;

    public d(g gVar, DetailVideoView detailVideoView) {
        super(gVar.mAdTemplate, detailVideoView);
        this.xN = new AtomicBoolean(false);
        this.xO = false;
        this.kI = false;
        this.xP = new ArrayList();
        this.xQ = new ArrayList();
        this.xR = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.reward.m.d.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                d.a(d.this, true);
                if (d.this.HU != null) {
                    d.this.HU.setAudioEnabled(false);
                }
                synchronized (d.this.xP) {
                    try {
                        Iterator it = d.this.xP.iterator();
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
                synchronized (d.this.xP) {
                    try {
                        Iterator it = d.this.xP.iterator();
                        while (it.hasNext()) {
                            ((h.a) it.next()).onAudioBeReleased();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
        this.qp = gVar;
        this.mContext = gVar.mContext;
        this.mVideoPlayConfig = gVar.mVideoPlayConfig;
        this.mVideoPlayerStatus = this.mAdTemplate.mVideoPlayerStatus;
        this.xM = getVideoUrl();
    }

    private void aL() {
        if (jL()) {
            return;
        }
        this.HU.a(new b.a(this.mAdTemplate).da(this.xM).db(com.kwad.sdk.core.response.b.h.b(com.kwad.sdk.core.response.b.e.dT(this.mAdTemplate))).a(this.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.bF(this.mAdTemplate)).BJ(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.HU.prepareAsync();
    }

    private String getVideoUrl() {
        if (jL()) {
            return "";
        }
        return j.f(this.mContext, this.mAdTemplate);
    }

    private boolean jL() {
        if (com.kwad.sdk.core.response.b.a.cM(com.kwad.sdk.core.response.b.e.dS(this.mAdTemplate))) {
            return true;
        }
        return false;
    }

    private void stop() {
        pause();
        this.kI = true;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fV() {
        this.xO = false;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fW() {
        if (this.kI) {
            return;
        }
        resume();
        if (this.f18447no || (com.kwad.components.ad.reward.a.b.gt() && this.xO)) {
            com.kwad.components.core.s.a.as(this.mContext).aN(com.kwad.components.ad.reward.a.b.gt());
            if (com.kwad.components.ad.reward.a.b.gt() && this.xO) {
                this.xO = false;
                this.f18447no = true;
                setAudioEnabled(true, false);
            } else if (!this.qp.f18441oI && com.kwad.components.core.s.a.as(this.mContext).rA()) {
                this.f18447no = false;
                setAudioEnabled(false, false);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fX() {
        pause();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fY() {
        com.kwad.components.core.video.b bVar;
        this.xO = false;
        if (this.xN.get() && (bVar = this.HU) != null) {
            bVar.d(this.nq);
            this.HU.release();
        }
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final long getPlayDuration() {
        if (this.xN.get()) {
            return super.getPlayDuration();
        }
        return 0L;
    }

    public final void jJ() {
        if (this.xN.get()) {
            return;
        }
        this.xN.set(true);
        aL();
        l lVar = new l() { // from class: com.kwad.components.ad.reward.m.d.2
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i, int i2) {
                super.onMediaPlayError(i, i2);
                com.kwad.components.core.o.a.qI().c(d.this.mAdTemplate, i, i2);
            }
        };
        this.nq = lVar;
        this.HU.c(lVar);
        this.HU.a(new c.e() { // from class: com.kwad.components.ad.reward.m.d.3
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    com.kwad.sdk.core.c.b.En();
                    if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        d.this.HU.start();
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        this.HU.start();
        com.kwad.components.core.s.a.as(this.mContext).a(this.xR);
    }

    public final void jK() {
        Iterator<Object> it = this.xQ.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void pause() {
        if (this.xN.get() && this.HU != null && !jL()) {
            super.pause();
        }
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    @MainThread
    public final void release() {
        super.release();
        com.kwad.components.core.s.a.as(this.mContext).b(this.xR);
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void resume() {
        this.kI = false;
        if (!this.xN.get() || this.HU == null || jL() || g.b(this.qp)) {
            return;
        }
        super.resume();
    }

    @Override // com.kwad.components.ad.k.a
    public final void setAudioEnabled(boolean z, boolean z2) {
        this.f18447no = z;
        if (this.xN.get() && this.HU != null) {
            if (z && z2) {
                com.kwad.components.core.s.a.as(this.mContext).aN(true);
            }
            this.HU.setAudioEnabled(z);
        }
    }

    @Override // com.kwad.components.ad.k.a
    @Deprecated
    public final void skipToEnd() {
        com.kwad.components.core.video.b bVar;
        if (this.xN.get() && (bVar = this.HU) != null) {
            bVar.onPlayStateChanged(9);
            stop();
        }
    }

    public static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.xO = true;
        return true;
    }

    public final void b(h.a aVar) {
        this.xP.remove(aVar);
    }

    public final void a(h.a aVar) {
        this.xP.add(aVar);
    }
}
