package com.baidu.ar;

import android.text.TextUtils;
import com.baidu.ar.face.FaceListener;
import com.baidu.ar.face.IFace;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class ei extends e implements IFace {
    private String al;
    private WeakReference<IFace> rk;
    private FaceListener rl;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.ar.e
    public void a(d dVar) {
        if (dVar == 0) {
            WeakReference<IFace> weakReference = this.rk;
            if (weakReference != null) {
                weakReference.clear();
                this.rk = null;
                return;
            }
            return;
        }
        if (dVar instanceof IFace) {
            this.rk = new WeakReference<>((IFace) dVar);
            if (!TextUtils.isEmpty(this.al)) {
                this.rk.get().setFaceModelPath(this.al);
            }
        }
        if (this.rl != null) {
            this.rk.get().setFaceListener(this.rl);
        }
    }

    @Override // com.baidu.ar.e
    public void release() {
        WeakReference<IFace> weakReference = this.rk;
        if (weakReference != null) {
            weakReference.clear();
            this.rk = null;
        }
        this.rl = null;
    }

    @Override // com.baidu.ar.face.IFace
    public void setFaceListener(FaceListener faceListener) {
        this.rl = faceListener;
        WeakReference<IFace> weakReference = this.rk;
        if (weakReference != null) {
            weakReference.get().setFaceListener(this.rl);
        }
    }

    @Override // com.baidu.ar.face.IFace
    public void setFaceModelPath(String str) {
        this.al = str;
        WeakReference<IFace> weakReference = this.rk;
        if (weakReference != null) {
            weakReference.get().setFaceModelPath(str);
        }
    }
}
