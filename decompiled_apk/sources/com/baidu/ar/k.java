package com.baidu.ar;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.Log;
import com.baidu.ar.arrender.Texture;
import com.baidu.ar.bean.Size;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes7.dex */
public class k implements GLSurfaceView.Renderer {
    private Texture ei;
    private j ej;
    private float[] ek;
    private float[] el;
    private j em;
    private SurfaceTexture en;
    private int eo = -1;
    private boolean ep = true;
    private boolean eq = false;
    private a er;
    private int es;
    private int et;
    private int mWindowHeight;
    private int mWindowWidth;

    /* loaded from: classes7.dex */
    public interface a {
        void onDrawFrame();

        void onSurfaceChanged(int i, int i2);

        void onSurfaceCreated(Texture texture);

        void onSurfaceCreated(Texture texture, SurfaceTexture surfaceTexture, int i, int i2);
    }

    private Size a(int i, int i2, int i3, int i4) {
        Size size = new Size(i, i2);
        if (i > 0 && i2 > 0 && i3 > 0 && i4 > 0) {
            float f = i;
            float f2 = i2;
            float f3 = f / f2;
            float f4 = i3 / i4;
            if (f3 > f4) {
                size.setWidth((int) (f2 * f4));
                size.setHeight(i2);
            } else if (f3 < f4) {
                size.setWidth(i);
                size.setHeight((int) (f / f4));
            }
        }
        return size;
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

    public void b(int i, int i2) {
        this.es = i;
        this.et = i2;
    }

    public void g(boolean z) {
        this.eq = z;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        GLES20.glClear(16640);
        a aVar = this.er;
        if (aVar != null) {
            aVar.onDrawFrame();
        }
        try {
            if (this.eq) {
                SurfaceTexture surfaceTexture = this.en;
                if (surfaceTexture == null || this.eo <= -1) {
                    return;
                }
                surfaceTexture.updateTexImage();
                this.em.a(null, null, this.eo, 0);
                return;
            }
            if (this.ei != null) {
                if (this.el == null) {
                    float[] fArr = new float[16];
                    this.el = fArr;
                    Matrix.setIdentityM(fArr, 0);
                    Matrix.scaleM(this.el, 0, (((this.es / a(this.et, this.es, this.mWindowWidth, this.mWindowHeight).getWidth()) - 1.0f) / 2.0f) + 1.0f, 1.0f, 1.0f);
                }
                if (this.ek == null) {
                    float[] fArr2 = new float[16];
                    this.ek = fArr2;
                    Matrix.setIdentityM(fArr2, 0);
                    Matrix.rotateM(this.ek, 0, 270.0f, 0.0f, 0.0f, 1.0f);
                    Matrix.translateM(this.ek, 0, -1.0f, 0.0f, 0.0f);
                }
                this.ej.a(this.el, this.ek, this.ei.getId(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        Log.d("VpasRenderer", "onSurfaceChanged() width * " + i + " * " + i2);
        GLES20.glViewport(0, 0, i, i2);
        this.mWindowWidth = i;
        this.mWindowHeight = i2;
        j jVar = this.ej;
        if (jVar != null) {
            jVar.c(i, i2);
        }
        j jVar2 = this.em;
        if (jVar2 != null) {
            jVar2.c(i, i2);
        }
        a aVar = this.er;
        if (aVar != null) {
            if (!this.ep) {
                aVar.onSurfaceChanged(i, i2);
            } else {
                aVar.onSurfaceCreated(this.ei, this.en, i, i2);
                this.ep = false;
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Log.d("VpasRenderer", "onSurfaceCreated()");
        this.ei = new Texture(c(36197), 36197);
        this.ej = new j(36197, 0);
        this.eo = c(36197);
        this.en = new SurfaceTexture(this.eo);
        this.em = new j(36197, 0);
        a aVar = this.er;
        if (aVar != null) {
            aVar.onSurfaceCreated(this.ei);
        }
    }

    public void release() {
        this.ej = null;
        this.em = null;
        this.ei = null;
        SurfaceTexture surfaceTexture = this.en;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.en = null;
        }
        this.ek = null;
        this.el = null;
        this.er = null;
    }

    public void a(a aVar) {
        this.er = aVar;
    }
}
