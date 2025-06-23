package com.kwad.components.ad.f.c;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.k.b;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.j.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.l;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.h.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ah;

/* loaded from: classes11.dex */
public final class a extends b {
    private com.kwad.components.core.widget.a.b bQ;
    private KsAdVideoPlayConfig dU;
    private final c df;
    private boolean eQ;
    private a.b eY;
    private OfflineOnAudioConflictListener fa;
    private boolean hasNoCache;
    private final AdInfo mAdInfo;
    private Context mContext;

    /* renamed from: no, reason: collision with root package name */
    private boolean f18433no;
    private boolean np;
    private l nq;

    public a(@NonNull final AdTemplate adTemplate, @NonNull com.kwad.components.core.widget.a.b bVar, @NonNull DetailVideoView detailVideoView, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        this.hasNoCache = false;
        this.df = new c() { // from class: com.kwad.components.ad.f.c.a.3
            @Override // com.kwad.sdk.core.h.c
            public final void aM() {
                com.kwad.components.core.j.a.pf().a(a.this.getCurrentVoiceItem());
                a.this.resume();
            }

            @Override // com.kwad.sdk.core.h.c
            public final void aN() {
                com.kwad.components.core.j.a.pf().c(a.this.eY);
                a.this.pause();
            }
        };
        this.fa = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.f.c.a.5
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                a.c(a.this, false);
                a.this.setAudioEnabled(false);
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.bQ = bVar;
        AdInfo dS = e.dS(this.mAdTemplate);
        this.mAdInfo = dS;
        if ((ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) && ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() != 0) {
            this.f18433no = ksAdVideoPlayConfig.isVideoSoundEnable();
        } else {
            this.f18433no = com.kwad.sdk.core.response.b.a.bU(dS);
        }
        this.dU = ksAdVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        if (ksAdVideoPlayConfig != null) {
            try {
                this.hasNoCache = ksAdVideoPlayConfig.isNoCache();
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            }
        }
        l lVar = new l() { // from class: com.kwad.components.ad.f.c.a.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i, int i2) {
                super.onMediaPlayError(i, i2);
                com.kwad.components.core.o.a.qI().c(adTemplate, i, i2);
            }
        };
        this.nq = lVar;
        this.HU.c(lVar);
        aL();
        this.HU.a(new c.e() { // from class: com.kwad.components.ad.f.c.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    if (a.this.eD() && a.this.bQ.dX()) {
                        a.this.HU.a(com.kwad.sdk.contentalliance.a.a.a.bF(a.this.mAdTemplate));
                        com.kwad.components.core.j.a.pf().a(a.this.getCurrentVoiceItem());
                        a.this.HU.start();
                    }
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }
        });
    }

    private void aL() {
        this.HU.a(new b.a(this.mAdTemplate).da(e.dU(this.mAdTemplate)).db(h.b(e.dT(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).bl(this.hasNoCache).b(com.kwad.sdk.contentalliance.a.a.a.bF(this.mAdTemplate)).BJ(), true, true, this.mDetailVideoView);
        setAudioEnabled(g(this.f18433no));
        if (!eD()) {
            return;
        }
        this.HU.prepareAsync();
        com.kwad.components.core.s.a.as(this.mContext).a(this.fa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eD() {
        if (this.np) {
            return true;
        }
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.dU;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return ah.isNetworkConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return ah.isWifiConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                if (ah.isWifiConnected(this.mContext) || (kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && ah.isMobileConnected(this.mContext))) {
                    return true;
                }
                return false;
            }
        }
        if (com.kwad.sdk.core.response.b.a.bV(this.mAdInfo) && ah.isNetworkConnected(this.mContext)) {
            return true;
        }
        if (com.kwad.sdk.core.response.b.a.bW(this.mAdInfo) && ah.isWifiConnected(this.mContext)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.eY == null) {
            this.eY = new a.b(new a.c() { // from class: com.kwad.components.ad.f.c.a.4
                @Override // com.kwad.components.core.j.a.c
                public final void bk() {
                    a aVar = a.this;
                    aVar.setAudioEnabled(aVar.g(aVar.f18433no));
                }
            });
        }
        return this.eY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioEnabled(boolean z) {
        this.HU.setAudioEnabled(z);
    }

    public final void aJ() {
        com.kwad.sdk.utils.l.en(this.mAdTemplate);
        if (this.HU.rW() == null) {
            aL();
        }
        if (eD() && this.bQ.dX()) {
            this.HU.a(com.kwad.sdk.contentalliance.a.a.a.bF(this.mAdTemplate));
            com.kwad.components.core.j.a.pf().a(getCurrentVoiceItem());
            this.HU.start();
        }
        this.bQ.a(this.df);
    }

    public final void aK() {
        com.kwad.sdk.utils.l.el(this.mAdTemplate);
        this.bQ.b(this.df);
        this.HU.release();
        com.kwad.components.core.j.a.pf().c(this.eY);
        com.kwad.components.core.s.a.as(this.mContext).b(this.fa);
    }

    public final void eE() {
        this.np = true;
        if (this.bQ.dX()) {
            com.kwad.sdk.utils.l.em(this.mAdTemplate);
            this.HU.a(com.kwad.sdk.contentalliance.a.a.a.bF(this.mAdTemplate));
            com.kwad.components.core.j.a.pf().a(getCurrentVoiceItem());
            this.HU.start();
        }
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void resume() {
        com.kwad.components.core.j.a.pf().a(getCurrentVoiceItem());
        setAudioEnabled(g(this.f18433no));
        if (!eD()) {
            return;
        }
        super.resume();
    }

    public static /* synthetic */ boolean c(a aVar, boolean z) {
        aVar.eQ = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(boolean z) {
        if (!z) {
            return false;
        }
        if (this.eY != null) {
            com.kwad.components.core.j.a.pf();
            if (!com.kwad.components.core.j.a.b(this.eY)) {
                return false;
            }
        }
        if (!d.gt()) {
            if (com.kwad.components.core.s.a.as(this.mContext).rB()) {
                return !com.kwad.components.core.s.a.as(this.mContext).rA();
            }
            return com.kwad.components.core.s.a.as(this.mContext).aN(false);
        }
        if (!this.eQ) {
            this.eQ = com.kwad.components.core.s.a.as(this.mContext).aN(true);
        }
        return this.eQ;
    }
}
