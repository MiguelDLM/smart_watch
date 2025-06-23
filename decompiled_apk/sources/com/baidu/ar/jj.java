package com.baidu.ar;

import android.graphics.Bitmap;
import com.baidu.ar.track2d.ITrack2D;
import com.baidu.ar.track2d.ITrack2DStateChangedListener;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class jj extends e implements ITrack2D {
    private ITrack2DStateChangedListener Ap;
    private WeakReference<ITrack2D> nz;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.ar.e
    public void a(d dVar) {
        if (dVar instanceof ITrack2D) {
            ITrack2D iTrack2D = (ITrack2D) dVar;
            this.nz = new WeakReference<>(iTrack2D);
            ITrack2DStateChangedListener iTrack2DStateChangedListener = this.Ap;
            if (iTrack2DStateChangedListener != null) {
                iTrack2D.setStateChangedListener(iTrack2DStateChangedListener);
            }
        }
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public Bitmap getTargetBitmap() {
        WeakReference<ITrack2D> weakReference = this.nz;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.nz.get().getTargetBitmap();
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void haltTrack() {
        WeakReference<ITrack2D> weakReference = this.nz;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.nz.get().haltTrack();
    }

    @Override // com.baidu.ar.e
    public void release() {
        WeakReference<ITrack2D> weakReference = this.nz;
        if (weakReference != null) {
            weakReference.clear();
            this.nz = null;
        }
        this.Ap = null;
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void resumeTrack() {
        WeakReference<ITrack2D> weakReference = this.nz;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.nz.get().resumeTrack();
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void setStateChangedListener(ITrack2DStateChangedListener iTrack2DStateChangedListener) {
        WeakReference<ITrack2D> weakReference;
        this.Ap = iTrack2DStateChangedListener;
        if (iTrack2DStateChangedListener == null || (weakReference = this.nz) == null || weakReference.get() == null) {
            return;
        }
        this.nz.get().setStateChangedListener(this.Ap);
    }
}
