package com.baidu.ar.camera;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes7.dex */
public class DuMixRenderer implements GLSurfaceView.Renderer {
    private static final String TAG = "DuMixRenderer";
    private SurfaceTexture cx;
    private DuMixDrawer ng;
    private SurfaceTexture nh;
    private a nj;
    private int nf = -1;
    private int ni = -1;
    private boolean nk = true;

    /* loaded from: classes7.dex */
    public interface a {
        void a(SurfaceTexture surfaceTexture, SurfaceTexture surfaceTexture2);

        void onSurfaceChanged(int i, int i2);
    }

    public DuMixRenderer(a aVar) {
        this.nj = aVar;
    }

    private int c(int i) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(i, iArr[0]);
        GLES20.glTexParameterf(i, 10241, 9729.0f);
        GLES20.glTexParameterf(i, 10240, 9729.0f);
        GLES20.glTexParameteri(i, 10242, 33071);
        GLES20.glTexParameteri(i, 10243, 33071);
        return iArr[0];
    }

    private void cA() {
        if (this.nk) {
            try {
                this.nh.detachFromGLContext();
            } catch (Exception e) {
                Log.e(TAG, "onSurfaceChanged attachToGLContext error!!!");
                e.printStackTrace();
            }
            try {
                this.cx.detachFromGLContext();
            } catch (Exception e2) {
                Log.e(TAG, "onSurfaceChanged attachToGLContext error!!!");
                e2.printStackTrace();
            }
            try {
                this.nh.attachToGLContext(this.ni);
            } catch (Exception e3) {
                Log.e(TAG, "onSurfaceChanged attachToGLContext error!!!");
                e3.printStackTrace();
            }
            this.nk = false;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        cA();
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        GLES20.glClear(16640);
        try {
            SurfaceTexture surfaceTexture = this.nh;
            if (surfaceTexture != null) {
                surfaceTexture.updateTexImage();
                float[] fArr = new float[16];
                this.nh.getTransformMatrix(fArr);
                this.ng.draw(fArr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
        a aVar = this.nj;
        if (aVar != null) {
            aVar.onSurfaceChanged(i, i2);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.nf = c(3553);
        this.cx = new SurfaceTexture(this.nf);
        this.ni = c(3553);
        this.nh = new SurfaceTexture(this.ni);
        this.ng = new DuMixDrawer(this.ni, 3553);
        a aVar = this.nj;
        if (aVar != null) {
            aVar.a(this.cx, this.nh);
        }
    }

    public void release() {
        this.ng = null;
        SurfaceTexture surfaceTexture = this.cx;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.cx = null;
        }
        SurfaceTexture surfaceTexture2 = this.nh;
        if (surfaceTexture2 != null) {
            surfaceTexture2.release();
            this.nh = null;
        }
        this.nj = null;
    }
}
