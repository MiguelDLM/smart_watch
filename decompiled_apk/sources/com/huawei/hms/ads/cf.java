package com.huawei.hms.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.openalliance.ad.media.MediaPlayerAgent;
import com.huawei.openalliance.ad.media.listener.MediaStateListener;
import com.huawei.openalliance.ad.media.listener.c;

/* loaded from: classes10.dex */
public class cf extends MediaPlayerAgent implements MediaStateListener, c {
    private static final String Code = "MediaPlayerAgentProxy";
    private MediaStateListener I;
    private com.huawei.hms.ads.uiengine.a V;
    private c Z;

    public cf(Context context, com.huawei.hms.ads.uiengine.a aVar) {
        super(context);
        this.V = aVar;
    }

    @Override // com.huawei.openalliance.ad.media.MediaPlayerAgent
    public void Code() {
        try {
            this.V.V();
        } catch (Throwable th) {
            fb.V(Code, "stop err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.media.MediaPlayerAgent
    public void I(String str) {
        try {
            this.V.I(str);
        } catch (Throwable th) {
            fb.V(Code, "pauseWhenUrlMatchs er: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.media.MediaPlayerAgent
    public void V(MediaStateListener mediaStateListener) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBinder("listener", (IBinder) ObjectWrapper.wrap(this));
            this.V.I(bundle);
        } catch (Throwable th) {
            fb.V(Code, "removeMediaErrorListener err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
    public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i) {
        MediaStateListener mediaStateListener = this.I;
        if (mediaStateListener != null) {
            mediaStateListener.onMediaCompletion(this, i);
        }
    }

    @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
    public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i) {
        MediaStateListener mediaStateListener = this.I;
        if (mediaStateListener != null) {
            mediaStateListener.onMediaPause(this, i);
        }
    }

    @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
    public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i) {
        MediaStateListener mediaStateListener = this.I;
        if (mediaStateListener != null) {
            mediaStateListener.onMediaStart(this, i);
        }
    }

    @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
    public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i) {
        MediaStateListener mediaStateListener = this.I;
        if (mediaStateListener != null) {
            mediaStateListener.onMediaStop(this, i);
        }
    }

    @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
    public void onProgress(int i, int i2) {
        MediaStateListener mediaStateListener = this.I;
        if (mediaStateListener != null) {
            mediaStateListener.onProgress(i, i2);
        }
    }

    @Override // com.huawei.openalliance.ad.media.listener.c
    public void Code(MediaPlayerAgent mediaPlayerAgent, int i, int i2, int i3) {
        c cVar = this.Z;
        if (cVar != null) {
            cVar.Code(this, i, i2, i3);
        }
    }

    @Override // com.huawei.openalliance.ad.media.MediaPlayerAgent
    public void V(c cVar) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBinder("listener", (IBinder) ObjectWrapper.wrap(this));
            this.V.Z(bundle);
        } catch (Throwable th) {
            fb.V(Code, "removeMediaErrorListener err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.media.MediaPlayerAgent
    public void Code(MediaStateListener mediaStateListener) {
        this.I = mediaStateListener;
        try {
            Bundle bundle = new Bundle();
            bundle.putBinder("listener", (IBinder) ObjectWrapper.wrap(this));
            this.V.Code(bundle);
        } catch (Throwable th) {
            fb.V(Code, "addMediaStateListener err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.media.MediaPlayerAgent
    public void V(String str) {
        try {
            this.V.V(str);
        } catch (Throwable th) {
            fb.V(Code, "stopWhenUrlMatchs err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.media.MediaPlayerAgent
    public void Code(c cVar) {
        this.Z = cVar;
        try {
            Bundle bundle = new Bundle();
            bundle.putBinder("listener", (IBinder) ObjectWrapper.wrap(this));
            this.V.V(bundle);
        } catch (Throwable th) {
            fb.V(Code, "addMediaErrorListener err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.media.MediaPlayerAgent
    public void Code(String str) {
        try {
            this.V.Code(str);
        } catch (Throwable th) {
            fb.V(Code, "playWhenUrlMatchs err: %s", th.getClass().getSimpleName());
        }
    }
}
