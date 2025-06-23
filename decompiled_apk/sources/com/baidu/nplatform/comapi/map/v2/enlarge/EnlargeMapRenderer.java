package com.baidu.nplatform.comapi.map.v2.enlarge;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.opengl.GLES20;
import android.os.Bundle;
import android.view.SurfaceHolder;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.drivertool.d;
import com.baidu.navisdk.util.drivertool.e;
import com.baidu.platform.comapi.map.SurfaceRenderer;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;

/* loaded from: classes8.dex */
public final class EnlargeMapRenderer implements SurfaceRenderer {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "EnlargeMap-Render";
    private int mFpsCount;
    private boolean mInit;
    private long mLastFpsTime;
    private int surfaceHeight;
    private int surfaceWidth;
    private boolean isDrawEnable = true;
    private final Object mRendererClock = new Object();
    private int mFps = -1;

    /* loaded from: classes8.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }
    }

    public final void awakeDrawWaitEvent() {
        synchronized (this.mRendererClock) {
            this.isDrawEnable = false;
            BNMapController.getInstance().awakeDrawWaitEvent();
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        }
    }

    public final void dynamicWindowShutDown() {
        BNMapController.getInstance().dynamicWindowShutDown(4617);
        this.mInit = true;
    }

    @Override // com.baidu.platform.comapi.map.SurfaceRenderer
    public void onDrawFrame(@OOXIXo Object obj) {
        if (this.isDrawEnable) {
            synchronized (this.mRendererClock) {
                if (!this.isDrawEnable) {
                    LogUtil.e(TAG, "dynamicWindowDraw:多线程导致 isDrawEnable == false! ");
                    return;
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                BNMapController.getInstance().dynamicWindowDraw(4617);
                try {
                    if (d.d && d.b) {
                        e.l().a(this.surfaceWidth, this.surfaceHeight, 2);
                    }
                    if (com.baidu.navisdk.debug.d.b()) {
                        com.baidu.navisdk.debug.d.g().a(this.surfaceWidth, this.surfaceHeight, 1);
                    }
                } catch (Exception e) {
                    d.a(false);
                    if (LogUtil.LOGGABLE) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.SurfaceRenderer
    public void onSurfaceChanged(int i, int i2) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "onSurfaceChanged: " + this.mInit + ',' + i + ':' + i2);
        }
        if (this.mInit) {
            this.mInit = false;
            Bundle bundle = new Bundle();
            bundle.putInt("x", 0);
            bundle.putInt("y", 0);
            bundle.putInt("iWidth", i);
            bundle.putInt("iHeight", i2);
            BNMapController.getInstance().dynamicWindowInit(4617, bundle);
        } else {
            BNMapController.getInstance().dynamicWindowChange(4617, i, i2);
        }
        if (!this.mInit) {
            synchronized (this.mRendererClock) {
                this.isDrawEnable = true;
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            }
        }
        this.surfaceWidth = i;
        this.surfaceHeight = i2;
        if (d.b || com.baidu.navisdk.debug.d.b()) {
            GLES20.glViewport(0, 0, i, i2);
        }
    }

    @Override // com.baidu.platform.comapi.map.SurfaceRenderer
    public void onSurfaceCreated(@oOoXoXO SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "onSurfaceCreated: " + i + ':' + i2 + ", " + i3);
        }
        this.mInit = true;
        Thread currentThread = Thread.currentThread();
        currentThread.setName("EnlargeGL" + currentThread.getId());
    }

    @Override // com.baidu.platform.comapi.map.SurfaceRenderer
    public void onSurfaceDestroyed(@oOoXoXO SurfaceHolder surfaceHolder) {
    }
}
