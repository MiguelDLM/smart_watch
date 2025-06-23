package com.huawei.openalliance.ad.media;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.media.listener.MediaStateListener;
import com.huawei.openalliance.ad.utils.am;
import com.huawei.openalliance.ad.utils.bh;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes10.dex */
public class c implements IMultiMediaPlayingManager {
    private static final String Code = "c";
    private static final byte[] I = new byte[0];
    private static c V;
    private MediaPlayerAgent B;
    private Context S;
    private final byte[] Z = new byte[0];
    private Queue<a> C = new ConcurrentLinkedQueue();
    private MediaStateListener F = new MediaStateListener() { // from class: com.huawei.openalliance.ad.media.c.1
        private void Code() {
            synchronized (c.this.Z) {
                try {
                    if (fb.Code()) {
                        fb.Code(c.Code, "checkAndPlayNext current player: %s", c.this.B);
                    }
                    if (c.this.B == null) {
                        c.this.V();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
        public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i) {
            if (fb.Code()) {
                fb.Code(c.Code, "onMediaCompletion: %s", mediaPlayerAgent);
            }
            c.this.V();
        }

        @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
        public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i) {
            if (fb.Code()) {
                fb.Code(c.Code, "onMediaPause: %s", mediaPlayerAgent);
            }
            Code();
        }

        @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
        public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i) {
        }

        @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
        public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i) {
            if (fb.Code()) {
                fb.Code(c.Code, "onMediaStop: %s", mediaPlayerAgent);
            }
            Code();
        }

        @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
        public void onProgress(int i, int i2) {
        }
    };
    private com.huawei.openalliance.ad.media.listener.c D = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.media.c.2
        @Override // com.huawei.openalliance.ad.media.listener.c
        public void Code(MediaPlayerAgent mediaPlayerAgent, int i, int i2, int i3) {
            if (fb.Code()) {
                fb.Code(c.Code, "onError: %s", mediaPlayerAgent);
            }
            synchronized (c.this.Z) {
                mediaPlayerAgent.V(this);
            }
            c.this.V();
        }
    };

    /* loaded from: classes10.dex */
    public static class a {
        final String Code;
        final MediaPlayerAgent V;

        public a(String str, MediaPlayerAgent mediaPlayerAgent) {
            this.Code = str;
            this.V = mediaPlayerAgent;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            a aVar = (a) obj;
            return TextUtils.equals(this.Code, aVar.Code) && this.V == aVar.V;
        }

        public int hashCode() {
            String str = this.Code;
            int hashCode = str != null ? str.hashCode() : -1;
            MediaPlayerAgent mediaPlayerAgent = this.V;
            return hashCode & super.hashCode() & (mediaPlayerAgent != null ? mediaPlayerAgent.hashCode() : -1);
        }

        public String toString() {
            return "Task [" + bh.Code(this.Code) + "]";
        }
    }

    private c(Context context) {
        this.S = context.getApplicationContext();
    }

    public static c Code(Context context) {
        c cVar;
        synchronized (I) {
            try {
                if (V == null) {
                    V = new c(context);
                }
                cVar = V;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void Z(String str, MediaPlayerAgent mediaPlayerAgent) {
        if (TextUtils.isEmpty(str) || mediaPlayerAgent == null) {
            return;
        }
        synchronized (this.Z) {
            try {
                if (fb.Code()) {
                    fb.Code(Code, "pause - url: %s player: %s currentPlayer: %s", bh.Code(str), mediaPlayerAgent, this.B);
                }
                if (mediaPlayerAgent == this.B) {
                    fb.V(Code, "pause current");
                    mediaPlayerAgent.I(str);
                } else {
                    fb.V(Code, "pause - remove from queue");
                    this.C.remove(new a(str, mediaPlayerAgent));
                    V(mediaPlayerAgent);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        if (am.I(this.S)) {
            synchronized (this.Z) {
                try {
                    a poll = this.C.poll();
                    if (fb.Code()) {
                        fb.Code(Code, "playNextTask - task: %s currentPlayer: %s", poll, this.B);
                    }
                    if (poll != null) {
                        if (fb.Code()) {
                            fb.Code(Code, "playNextTask - play: %s", poll.V);
                        }
                        poll.V.Code(this.F);
                        poll.V.Code(this.D);
                        poll.V.Code(poll.Code);
                        this.B = poll.V;
                    } else {
                        this.B = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void I(String str, MediaPlayerAgent mediaPlayerAgent) {
        if (TextUtils.isEmpty(str) || mediaPlayerAgent == null) {
            return;
        }
        synchronized (this.Z) {
            try {
                if (fb.Code()) {
                    fb.Code(Code, "stop - url: %s player: %s currentPlayer: %s", bh.Code(str), mediaPlayerAgent, this.B);
                }
                if (mediaPlayerAgent == this.B) {
                    fb.V(Code, "stop current");
                    this.B = null;
                    mediaPlayerAgent.V(str);
                } else {
                    fb.V(Code, "stop - remove from queue");
                    this.C.remove(new a(str, mediaPlayerAgent));
                    V(mediaPlayerAgent);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void Code(MediaPlayerAgent mediaPlayerAgent) {
        if (mediaPlayerAgent == null) {
            return;
        }
        synchronized (this.Z) {
            try {
                MediaPlayerAgent mediaPlayerAgent2 = this.B;
                if (mediaPlayerAgent == mediaPlayerAgent2) {
                    V(mediaPlayerAgent2);
                    this.B = null;
                }
                Iterator<a> it = this.C.iterator();
                while (it.hasNext()) {
                    MediaPlayerAgent mediaPlayerAgent3 = it.next().V;
                    if (mediaPlayerAgent3 == mediaPlayerAgent) {
                        V(mediaPlayerAgent3);
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void V(MediaPlayerAgent mediaPlayerAgent) {
        synchronized (this.Z) {
            if (mediaPlayerAgent != null) {
                try {
                    mediaPlayerAgent.V(this.F);
                    mediaPlayerAgent.V(this.D);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void Code(String str, MediaPlayerAgent mediaPlayerAgent) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str) || mediaPlayerAgent == null) {
            return;
        }
        synchronized (this.Z) {
            try {
                if (fb.Code()) {
                    fb.Code(Code, "autoPlay - url: %s player: %s, currentPlayer: %s", bh.Code(str), mediaPlayerAgent, this.B);
                }
                MediaPlayerAgent mediaPlayerAgent2 = this.B;
                if (mediaPlayerAgent != mediaPlayerAgent2 && mediaPlayerAgent2 != null) {
                    a aVar = new a(str, mediaPlayerAgent);
                    this.C.remove(aVar);
                    this.C.add(aVar);
                    str2 = Code;
                    str3 = "autoPlay - add to queue";
                    fb.V(str2, str3);
                }
                mediaPlayerAgent.Code(this.F);
                mediaPlayerAgent.Code(this.D);
                mediaPlayerAgent.Code(str);
                this.B = mediaPlayerAgent;
                str2 = Code;
                str3 = "autoPlay - play directly";
                fb.V(str2, str3);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void V(String str, MediaPlayerAgent mediaPlayerAgent) {
        if (TextUtils.isEmpty(str) || mediaPlayerAgent == null) {
            return;
        }
        synchronized (this.Z) {
            try {
                if (fb.Code()) {
                    fb.Code(Code, "manualPlay - url: %s player: %s currentPlayer: %s", bh.Code(str), mediaPlayerAgent, this.B);
                }
                MediaPlayerAgent mediaPlayerAgent2 = this.B;
                if (mediaPlayerAgent2 != null && mediaPlayerAgent != mediaPlayerAgent2) {
                    mediaPlayerAgent2.Code();
                    fb.V(Code, "manualPlay - stop other");
                }
                fb.V(Code, "manualPlay - play new");
                mediaPlayerAgent.Code(this.F);
                mediaPlayerAgent.Code(this.D);
                mediaPlayerAgent.Code(str);
                this.B = mediaPlayerAgent;
                this.C.remove(new a(str, mediaPlayerAgent));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
