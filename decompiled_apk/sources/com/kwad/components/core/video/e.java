package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.bs;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes11.dex */
public final class e extends a implements bs.a {
    private View Vt;
    private final AtomicBoolean Vu;
    private boolean Vv;
    private boolean Vw;
    private final KsAdVideoPlayConfig dU;
    private final bs hh;

    public e(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(context, adTemplate, cVar);
        this.hh = new bs(this);
        this.Vu = new AtomicBoolean(true);
        this.Vw = true;
        this.Vt = this;
        this.dU = ksAdVideoPlayConfig;
    }

    private void ac() {
        if (this.Vu.getAndSet(false)) {
            com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onViewAttached");
            this.hh.sendEmptyMessage(1);
        }
    }

    private boolean sn() {
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
                if (kSAdVideoPlayConfigImpl.isDataFlowAutoStart()) {
                    return ah.isNetworkConnected(this.mContext);
                }
                return ah.isWifiConnected(this.mContext);
            }
        }
        if (com.kwad.sdk.core.response.b.a.bV(this.mAdInfo)) {
            return ah.isNetworkConnected(this.mContext);
        }
        if (!com.kwad.sdk.core.response.b.a.bW(this.mAdInfo)) {
            return false;
        }
        return ah.isWifiConnected(this.mContext);
    }

    @Override // com.kwad.sdk.utils.bs.a
    public final void a(Message message) {
        if (!this.Uf && message.what == 1) {
            if (br.o(this.Vt, 30)) {
                if (!this.Vv) {
                    rR();
                }
            } else {
                rT();
            }
            this.hh.sendEmptyMessageDelayed(1, 500L);
        }
    }

    public final void ad() {
        if (!this.Vu.getAndSet(true)) {
            com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onViewDetached");
            this.hh.removeCallbacksAndMessages(null);
            if (this.Vw) {
                release();
            } else {
                this.aCR.pause();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onAttachedToWindow");
        ac();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onDetachedFromWindow");
        ad();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onFinishTemporaryDetach");
        ac();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onStartTemporaryDetach");
        ad();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    @Override // com.kwad.components.core.video.a
    public final void rR() {
        if (this.aCR.isIdle()) {
            com.kwad.components.core.video.a.a aVar = this.Ut;
            if (aVar != null) {
                aVar.onStart();
            }
            if (!ah.isNetworkConnected(this.mContext)) {
                rN();
                return;
            }
            rO();
            if (this.Uf) {
                rS();
                this.aCR.start();
                return;
            } else if (sn()) {
                rS();
                this.aCR.start();
                return;
            } else if (this.Ud) {
                rS();
                this.aCR.start();
                return;
            } else {
                rP();
                return;
            }
        }
        if (this.aCR.isPaused() || this.aCR.GT()) {
            rS();
            this.aCR.restart();
        }
    }

    public final void setAutoRelease(boolean z) {
        this.Vw = z;
    }

    public final void sm() {
        this.hh.removeCallbacksAndMessages(null);
        if (this.Vw) {
            release();
        } else {
            this.aCR.pause();
        }
    }

    public final void so() {
        this.aCR.pause();
        this.Vv = true;
    }

    public final void sp() {
        rR();
        this.Vv = false;
    }

    public final void sq() {
        this.Vv = false;
    }
}
