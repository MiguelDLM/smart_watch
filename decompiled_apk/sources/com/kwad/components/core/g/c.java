package com.kwad.components.core.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.components.core.g.a;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public final class c implements ImageLoadingListener {
    private b Mh;

    @Nullable
    private a Mi;
    private long Ml;
    private long hj;
    private int Mj = 1;
    private int Mk = 16;
    private List<h> Mm = new CopyOnWriteArrayList();

    /* renamed from: com.kwad.components.core.g.c$6, reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType;

        static {
            int[] iArr = new int[FailReason.FailType.values().length];
            $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType = iArr;
            try {
                iArr[FailReason.FailType.IO_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.DECODING_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.NETWORK_DENIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.OUT_OF_MEMORY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public c() {
        a aVar = new a(new Handler(Looper.getMainLooper()));
        this.Mi = aVar;
        aVar.a(new a.InterfaceC0789a() { // from class: com.kwad.components.core.g.c.1
            private boolean Mn = false;
            private boolean Mo = false;

            private void lc() {
                if (!this.Mn) {
                    c.this.b(new com.kwad.sdk.f.a<h>() { // from class: com.kwad.components.core.g.c.1.2
                        private static void e(h hVar) {
                            hVar.onMediaPlayCompleted();
                        }

                        @Override // com.kwad.sdk.f.a
                        public final /* synthetic */ void accept(h hVar) {
                            e(hVar);
                        }
                    });
                    this.Mn = true;
                }
            }

            private void pc() {
                if (!this.Mo) {
                    com.kwad.sdk.core.e.c.d("KSImagePlayer", "onFirstFrame: ");
                    this.Mo = true;
                    c.this.b(new com.kwad.sdk.f.a<h>() { // from class: com.kwad.components.core.g.c.1.3
                        private static void e(h hVar) {
                            hVar.onMediaPlayStart();
                        }

                        @Override // com.kwad.sdk.f.a
                        public final /* synthetic */ void accept(h hVar) {
                            e(hVar);
                        }
                    });
                }
            }

            @Override // com.kwad.components.core.g.a.InterfaceC0789a
            public final void y(final long j) {
                com.kwad.sdk.core.e.c.d("KSImagePlayer", "onTimerProgress: " + j);
                if (j == 0) {
                    pc();
                }
                c.this.hj = j;
                c.this.b(new com.kwad.sdk.f.a<h>() { // from class: com.kwad.components.core.g.c.1.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.f.a
                    /* renamed from: e, reason: merged with bridge method [inline-methods] */
                    public void accept(h hVar) {
                        hVar.onMediaPlayProgress(c.this.Ml, j);
                    }
                });
                if (c.this.hj >= c.this.Ml && c.this.Ml > 0) {
                    lc();
                }
            }
        });
    }

    public static /* synthetic */ int a(c cVar, FailReason.FailType failType) {
        return a(failType);
    }

    private void pb() {
        b bVar = this.Mh;
        if (bVar != null) {
            bVar.setImageGravity(this.Mj | this.Mk);
        }
    }

    public final void c(h hVar) {
        if (hVar != null) {
            this.Mm.add(hVar);
        }
    }

    public final void d(h hVar) {
        if (hVar != null) {
            this.Mm.remove(hVar);
        }
    }

    public final void destroy() {
        this.Mm.clear();
        b bVar = this.Mh;
        if (bVar != null && bVar.getParent() != null) {
            ((ViewGroup) this.Mh.getParent()).removeView(this.Mh);
        }
        this.Mh = null;
        a aVar = this.Mi;
        if (aVar != null) {
            aVar.destroy();
            this.Mi = null;
        }
    }

    public final FrameLayout getImagePlayerView(Context context) {
        if (this.Mh == null) {
            this.Mh = new b(context);
        }
        return this.Mh;
    }

    public final long getPlayDuration() {
        return this.hj;
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
        return false;
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingCancelled(String str, View view) {
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingFailed(String str, View view, final FailReason failReason) {
        b(new com.kwad.sdk.f.a<h>() { // from class: com.kwad.components.core.g.c.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.f.a
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public void accept(h hVar) {
                hVar.onMediaPlayError(-1, c.a(c.this, failReason.getType()));
            }
        });
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingStarted(String str, View view) {
    }

    public final void pause() {
        a aVar = this.Mi;
        if (aVar != null) {
            aVar.pause();
        }
        b(new com.kwad.sdk.f.a<h>() { // from class: com.kwad.components.core.g.c.2
            private static void e(h hVar) {
                hVar.onMediaPlayPaused();
            }

            @Override // com.kwad.sdk.f.a
            public final /* synthetic */ void accept(h hVar) {
                e(hVar);
            }
        });
    }

    public final void play() {
        a aVar = this.Mi;
        if (aVar != null) {
            aVar.start();
        }
    }

    public final void resume() {
        a aVar = this.Mi;
        if (aVar != null) {
            aVar.resume();
            b(new com.kwad.sdk.f.a<h>() { // from class: com.kwad.components.core.g.c.3
                private static void e(h hVar) {
                    hVar.onMediaPlaying();
                }

                @Override // com.kwad.sdk.f.a
                public final /* synthetic */ void accept(h hVar) {
                    e(hVar);
                }
            });
        }
    }

    public final void setHorizontalGravity(int i) {
        this.Mk = com.kwad.components.core.b.c.aj(i);
        pb();
    }

    public final void setImageScaleType(ImageView.ScaleType scaleType) {
        b bVar = this.Mh;
        if (bVar != null) {
            bVar.setImageScaleType(scaleType);
        }
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        b bVar = this.Mh;
        if (bVar != null) {
            bVar.setRadius(f, f2, f3, f4);
        }
    }

    public final void setURLs(List<String> list) {
        if (list != null && list.size() != 0) {
            String str = list.get(0);
            b bVar = this.Mh;
            if (bVar != null) {
                bVar.a(str, this);
            }
        }
    }

    public final void setVerticalGravity(int i) {
        this.Mk = com.kwad.components.core.b.c.ai(i);
        pb();
    }

    public final void skipToEnd() {
        b(new com.kwad.sdk.f.a<h>() { // from class: com.kwad.components.core.g.c.4
            private static void e(h hVar) {
                hVar.onMediaPlayCompleted();
            }

            @Override // com.kwad.sdk.f.a
            public final /* synthetic */ void accept(h hVar) {
                e(hVar);
            }
        });
    }

    public final void stop() {
        a aVar = this.Mi;
        if (aVar != null) {
            aVar.stop();
        }
    }

    public final void z(long j) {
        this.Ml = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void b(com.kwad.sdk.f.a<h> aVar) {
        List<h> list;
        if (aVar == null || (list = this.Mm) == null) {
            return;
        }
        Iterator<h> it = list.iterator();
        while (it.hasNext()) {
            aVar.accept(it.next());
        }
    }

    private static int a(FailReason.FailType failType) {
        int i = AnonymousClass6.$SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[failType.ordinal()];
        if (i == 1) {
            return -2;
        }
        if (i == 2) {
            return -3;
        }
        if (i != 3) {
            return i != 4 ? -1 : -5;
        }
        return -4;
    }
}
