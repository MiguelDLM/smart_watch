package com.baidu.ar;

import android.content.Context;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arrender.IGLRenderer;
import com.baidu.ar.arrender.Texture;

/* loaded from: classes7.dex */
public class bc extends bb implements IGLRenderer {
    private String jl;
    private String jm;

    public bc(Context context, Looper looper, fs fsVar, EGLContext eGLContext, String str) {
        super(context, looper, fsVar, eGLContext, str);
        this.jl = "";
        this.jm = "";
        this.jl = Build.HARDWARE.toLowerCase();
        this.jm = Build.BOARD.toLowerCase();
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void bindTargetSurface(Surface surface) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.jH.getARPRenderer().bindTargetSurface(surface);
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public Texture createTexture(int i, int i2, int i3) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return null;
        }
        Texture texture = new Texture();
        long createTexture = this.jH.getARPRenderer().createTexture(i, i2, i3);
        texture.setHandle(createTexture);
        texture.setId(this.jH.getARPRenderer().getTextureId(createTexture));
        texture.setType(i);
        return texture;
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void destroyTexture(Texture texture) {
        ARPEngine aRPEngine;
        if (texture == null || (aRPEngine = this.jH) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.jH.getARPRenderer().destroyTexture(texture.getHandle());
    }

    @Override // com.baidu.ar.bb, com.baidu.ar.bd, com.baidu.ar.arplay.core.renderer.OnRenderFinishedListener
    public void onRenderFinished(long j) {
        super.onRenderFinished(j);
        if (TextUtils.isEmpty(this.jl) || !this.jl.contains("qcom") || TextUtils.isEmpty(this.jm)) {
            return;
        }
        if (this.jm.contains("msm8953") || this.jm.contains("sdm632")) {
            GLES20.glFinish();
        }
    }

    @Override // com.baidu.ar.bb, com.baidu.ar.bd, com.baidu.ar.be
    public void release() {
        super.release();
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void runSyncOnIOContext(Runnable runnable) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null || runnable == null) {
            return;
        }
        this.jH.getARPRenderer().runSyncOnIOContext(runnable);
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void setInputTexture(int i, int i2, int i3, int i4) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.jH.getARPRenderer().setInputTexture(i, i2, i3, i4);
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void swapBuffer() {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.jH.getARPRenderer().swapBuffer();
    }
}
