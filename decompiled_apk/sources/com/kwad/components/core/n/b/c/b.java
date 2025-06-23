package com.kwad.components.core.n.b.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.video.BaseKsMediaPlayerView;
import com.kwad.components.offline.api.core.video.IKsMediaPlayer;
import com.kwad.components.offline.api.core.video.IKsMediaPlayerView;
import com.kwad.sdk.utils.aq;

/* loaded from: classes11.dex */
final class b extends BaseKsMediaPlayerView {
    private DetailVideoView Ob;

    public b(Context context) {
        super(context);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void adaptVideoSize(int i, int i2) {
        this.Ob.adaptVideoSize(i, i2);
    }

    public final b b(@NonNull DetailVideoView detailVideoView) {
        aq.checkNotNull(detailVideoView);
        addView(detailVideoView);
        this.Ob = detailVideoView;
        return this;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void fixWidth(boolean z) {
        this.Ob.fixWidth(z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final int getTextureViewGravity() {
        return this.Ob.getTextureViewGravity();
    }

    public final DetailVideoView pw() {
        return this.Ob;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setAd(boolean z) {
        this.Ob.setAd(z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setClickListener(final IKsMediaPlayerView.VideoViewClickListener videoViewClickListener) {
        DetailVideoView.a aVar;
        DetailVideoView detailVideoView = this.Ob;
        if (videoViewClickListener == null) {
            aVar = null;
        } else {
            aVar = new DetailVideoView.a() { // from class: com.kwad.components.core.n.b.c.b.1
                @Override // com.kwad.components.core.video.DetailVideoView.a
                public final void onClickRootView() {
                    videoViewClickListener.onClickRootView();
                }

                @Override // com.kwad.components.core.video.DetailVideoView.a
                public final void onClickVideoView() {
                    videoViewClickListener.onClickVideoView();
                }
            };
        }
        detailVideoView.setClickListener(aVar);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setForce(boolean z) {
        this.Ob.setForce(z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setHorizontalVideo(boolean z) {
        this.Ob.setHorizontalVideo(z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setMediaPlayer(IKsMediaPlayer iKsMediaPlayer) {
        if (iKsMediaPlayer instanceof a) {
            this.Ob.setMediaPlayer(((a) iKsMediaPlayer).pu());
            return;
        }
        throw new IllegalArgumentException("mediaPlayer not instanceof KsMediaPlayer");
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setRadius(float f) {
        this.Ob.setRadius(f);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void updateTextureViewGravity(int i) {
        this.Ob.updateTextureViewGravity(i);
    }
}
