package com.huawei.openalliance.ad.views;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.huawei.hms.ads.dv;
import com.huawei.hms.ads.dz;
import com.huawei.hms.ads.kv;
import com.huawei.openalliance.ad.media.MediaPlayerAgent;
import com.huawei.openalliance.ad.utils.t;
import java.lang.ref.WeakReference;
import java.util.Set;

/* loaded from: classes10.dex */
public class d {
    private dz B;
    private SurfaceTexture C;
    private final Set<WeakReference<kv>> D;
    private Surface F;
    private dv I;
    private SurfaceTexture.OnFrameAvailableListener L;
    private int S;
    private final t V;
    private MediaPlayerAgent Z;

    public synchronized SurfaceTexture B() {
        return this.C;
    }

    public synchronized dz C() {
        return this.B;
    }

    public synchronized void Code() {
        try {
        } finally {
        }
        if (this.B != null) {
            return;
        }
        dz dzVar = new dz();
        this.B = dzVar;
        this.S = dzVar.V();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.S);
        this.C = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this.L);
        Surface surface = new Surface(this.C);
        this.F = surface;
        this.Z.Code(surface);
    }

    public void D() {
        dz dzVar = this.B;
        if (dzVar != null) {
            dzVar.Code();
            this.B = null;
        }
        dv dvVar = this.I;
        if (dvVar != null) {
            dvVar.V();
            this.I.Code();
            this.I = null;
        }
        SurfaceTexture surfaceTexture = this.C;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    public synchronized Surface I() {
        return this.F;
    }

    public synchronized dv S() {
        return this.I;
    }

    public synchronized void V() {
        if (this.I != null) {
            return;
        }
        this.I = new dv();
    }

    public synchronized int Z() {
        return this.S;
    }

    public void finalize() {
        super.finalize();
        this.V.V();
    }

    public void Code(Runnable runnable) {
        this.V.Code(runnable);
    }

    public void V(kv kvVar) {
        WeakReference<kv> weakReference = null;
        for (WeakReference<kv> weakReference2 : this.D) {
            if (weakReference2.get() == kvVar) {
                weakReference = weakReference2;
            }
        }
        if (weakReference != null) {
            this.D.remove(weakReference);
        }
    }
}
