package com.kwad.components.core.n.b.c;

import android.media.TimedText;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.h;
import com.kwad.components.core.video.k;
import com.kwad.components.offline.api.core.video.IMediaPlayer;
import com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener;
import com.kwad.components.offline.api.core.video.listener.OfflineVideoPlayStateListener;
import com.kwad.components.offline.api.core.video.listener.ReleaseCallback;
import com.kwad.components.offline.api.core.video.mdoel.KsPlayerLogParams;
import com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes11.dex */
public final class d {
    public static com.kwad.sdk.contentalliance.a.a.b a(PlayVideoInfo playVideoInfo) {
        if (playVideoInfo == null) {
            return null;
        }
        return new b.a(playVideoInfo.videoUrl).db(playVideoInfo.manifest).b(a(playVideoInfo.ksplayerLogParams)).a(playVideoInfo.videoPlayerStatus).bl(playVideoInfo.isNoCache).BJ();
    }

    public static com.kwad.sdk.contentalliance.a.a.a a(KsPlayerLogParams ksPlayerLogParams) {
        if (ksPlayerLogParams == null) {
            return null;
        }
        com.kwad.sdk.contentalliance.a.a.a aVar = new com.kwad.sdk.contentalliance.a.a.a();
        aVar.photoId = ksPlayerLogParams.photoId;
        aVar.clickTime = ksPlayerLogParams.clickTime;
        aVar.adStyle = ksPlayerLogParams.adStyle;
        aVar.contentType = ksPlayerLogParams.contentType;
        return aVar;
    }

    public static c.e a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnPreparedListener onPreparedListener) {
        if (onPreparedListener == null) {
            return null;
        }
        return new c.e() { // from class: com.kwad.components.core.n.b.c.d.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    IMediaPlayer.OnPreparedListener.this.onPrepared(iMediaPlayer);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
    }

    public static c.b a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnCompletionListener onCompletionListener) {
        if (onCompletionListener == null) {
            return null;
        }
        return new c.b() { // from class: com.kwad.components.core.n.b.c.d.4
            @Override // com.kwad.sdk.core.video.a.c.b
            public final void py() {
                IMediaPlayer.OnCompletionListener.this.onCompletion(iMediaPlayer);
            }
        };
    }

    public static c.a a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        if (onBufferingUpdateListener == null) {
            return null;
        }
        return new c.a() { // from class: com.kwad.components.core.n.b.c.d.5
            @Override // com.kwad.sdk.core.video.a.c.a
            public final void av(int i) {
                IMediaPlayer.OnBufferingUpdateListener.this.onBufferingUpdate(iMediaPlayer, i);
            }
        };
    }

    public static c.g a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        if (onSeekCompleteListener == null) {
            return null;
        }
        return new c.g() { // from class: com.kwad.components.core.n.b.c.d.6
            @Override // com.kwad.sdk.core.video.a.c.g
            public final void pz() {
                IMediaPlayer.OnSeekCompleteListener.this.onSeekComplete(iMediaPlayer);
            }
        };
    }

    public static c.i a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener == null) {
            return null;
        }
        return new c.i() { // from class: com.kwad.components.core.n.b.c.d.7
            @Override // com.kwad.sdk.core.video.a.c.i
            public final void k(int i, int i2) {
                IMediaPlayer.OnVideoSizeChangedListener.this.onVideoSizeChanged(iMediaPlayer, i, i2);
            }
        };
    }

    public static c.InterfaceC0859c a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnErrorListener onErrorListener) {
        if (onErrorListener == null) {
            return null;
        }
        return new c.InterfaceC0859c() { // from class: com.kwad.components.core.n.b.c.d.8
            @Override // com.kwad.sdk.core.video.a.c.InterfaceC0859c
            public final boolean l(int i, int i2) {
                return IMediaPlayer.OnErrorListener.this.onError(iMediaPlayer, i, i2);
            }
        };
    }

    public static c.d a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnInfoListener onInfoListener) {
        if (onInfoListener == null) {
            return null;
        }
        return new c.d() { // from class: com.kwad.components.core.n.b.c.d.9
            @Override // com.kwad.sdk.core.video.a.c.d
            public final boolean m(int i, int i2) {
                return IMediaPlayer.OnInfoListener.this.onInfo(iMediaPlayer, i, i2);
            }
        };
    }

    public static c.h a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        if (onTimedTextListener == null) {
            return null;
        }
        return new c.h() { // from class: com.kwad.components.core.n.b.c.d.10
            @Override // com.kwad.sdk.core.video.a.c.h
            public final void a(TimedText timedText) {
                IMediaPlayer.OnTimedTextListener.this.onTimedText(iMediaPlayer, timedText);
            }
        };
    }

    public static k a(final OfflineVideoPlayStateListener offlineVideoPlayStateListener) {
        if (offlineVideoPlayStateListener == null) {
            return null;
        }
        return new k() { // from class: com.kwad.components.core.n.b.c.d.11
            @Override // com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                OfflineVideoPlayStateListener.this.onMediaPlayCompleted();
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPlayError(int i, int i2) {
                OfflineVideoPlayStateListener.this.onMediaPlayError(i, i2);
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPlayPaused() {
                OfflineVideoPlayStateListener.this.onMediaPlayPaused();
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j, long j2) {
                OfflineVideoPlayStateListener.this.onMediaPlayProgress(j, j2);
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                OfflineVideoPlayStateListener.this.onMediaPlayStart();
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPlaying() {
                OfflineVideoPlayStateListener.this.onMediaPlaying();
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPrepared() {
                OfflineVideoPlayStateListener.this.onMediaPrepared();
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPreparing() {
                OfflineVideoPlayStateListener.this.onMediaPreparing();
            }

            @Override // com.kwad.components.core.video.k
            public final void onVideoPlayBufferingPaused() {
                OfflineVideoPlayStateListener.this.onVideoPlayBufferingPaused();
            }

            @Override // com.kwad.components.core.video.k
            public final void onVideoPlayBufferingPlaying() {
                OfflineVideoPlayStateListener.this.onVideoPlayBufferingPlaying();
            }
        };
    }

    public static h a(final OfflineMediaPlayStateListener offlineMediaPlayStateListener) {
        if (offlineMediaPlayStateListener == null) {
            return null;
        }
        return new h() { // from class: com.kwad.components.core.n.b.c.d.2
            @Override // com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                OfflineMediaPlayStateListener.this.onMediaPlayCompleted();
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPlayError(int i, int i2) {
                OfflineMediaPlayStateListener.this.onMediaPlayError(i, i2);
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPlayPaused() {
                OfflineMediaPlayStateListener.this.onMediaPlayPaused();
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j, long j2) {
                OfflineMediaPlayStateListener.this.onMediaPlayProgress(j, j2);
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                OfflineMediaPlayStateListener.this.onMediaPlayStart();
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPlaying() {
                OfflineMediaPlayStateListener.this.onMediaPlaying();
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPrepared() {
                OfflineMediaPlayStateListener.this.onMediaPrepared();
            }

            @Override // com.kwad.components.core.video.h
            public final void onMediaPreparing() {
                OfflineMediaPlayStateListener.this.onMediaPreparing();
            }
        };
    }

    public static b.a a(final ReleaseCallback releaseCallback) {
        if (releaseCallback == null) {
            return null;
        }
        return new b.a() { // from class: com.kwad.components.core.n.b.c.d.3
            @Override // com.kwad.components.core.video.b.a
            public final void onReleaseSuccess() {
                ReleaseCallback.this.onReleaseSuccess();
            }
        };
    }
}
