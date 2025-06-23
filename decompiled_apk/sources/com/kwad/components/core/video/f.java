package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.bs;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes11.dex */
public final class f extends com.kwad.components.core.video.a implements bs.a {
    private boolean Es;
    private View Vt;
    private final AtomicBoolean Vu;
    private boolean Vx;
    private boolean Vy;
    private final bs hh;

    /* loaded from: classes11.dex */
    public interface a extends a.c {
        void onVideoPlayError(int i, int i2);
    }

    public f(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, adTemplate, cVar);
        this.hh = new bs(this);
        this.Vu = new AtomicBoolean(true);
        this.Es = false;
        this.Vx = false;
        this.Vy = false;
        this.Vt = this;
    }

    private void ac() {
        if (this.Vu.getAndSet(false)) {
            com.kwad.sdk.core.e.c.i("InterstitialVideoPlayerController", "onViewAttached");
            this.hh.sendEmptyMessage(1);
        }
    }

    private void ad() {
        if (!this.Vu.getAndSet(true)) {
            com.kwad.sdk.core.e.c.i("InterstitialVideoPlayerController", "onViewDetached");
            this.hh.removeCallbacksAndMessages(null);
            release();
        }
    }

    private void sr() {
        this.Es = false;
    }

    @Override // com.kwad.sdk.utils.bs.a
    public final void a(Message message) {
        if (!this.Es && message.what == 1) {
            if (this.Vy) {
                this.hh.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            if (br.o(this.Vt, 70)) {
                rR();
            } else {
                rT();
            }
            this.hh.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.components.core.video.a
    public final void ey() {
        if (this.Vx) {
            super.ey();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.e.c.i("InterstitialVideoPlayerController", "onAttachedToWindow");
        sr();
        ac();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.e.c.i("InterstitialVideoPlayerController", "onDetachedFromWindow");
        ad();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.e.c.i("InterstitialVideoPlayerController", "onFinishTemporaryDetach");
        ac();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.e.c.i("InterstitialVideoPlayerController", "onStartTemporaryDetach");
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
    public final void rL() {
        super.rL();
        ImageView imageView = this.mS;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.ksad_interstitial_video_play);
        }
        TextView textView = this.mT;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // com.kwad.components.core.video.a
    public final void rR() {
        super.rR();
    }

    @Override // com.kwad.components.core.video.a
    public final void rT() {
        super.rT();
    }

    @Override // com.kwad.components.core.video.a
    public final void release() {
        super.release();
        this.Es = true;
    }

    public final void setShowLandingPage(boolean z) {
        this.Vy = z;
    }
}
