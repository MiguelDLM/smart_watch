package com.baidu.nplatform.comapi.map.v2.mapswitch;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.opengl.GLES20;
import android.view.SurfaceHolder;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.drivertool.d;
import com.baidu.navisdk.util.drivertool.e;
import com.baidu.platform.comapi.map.SurfaceRenderer;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class MapSwitchRendererV2 implements SurfaceRenderer {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    public static final String TAG = "MapSwitchRendererV2";
    private int h_old;
    private boolean mMiniMapCreated;
    private int resize_tries;
    private int surfaceHeight;
    private int surfaceWidth;
    private int w_old;

    /* loaded from: classes8.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }
    }

    public final void onDestroyed() {
        if (this.mMiniMapCreated) {
            BNMapController.getInstance().destroyMiniMapControl();
            this.mMiniMapCreated = false;
        }
    }

    @Override // com.baidu.platform.comapi.map.SurfaceRenderer
    public void onDrawFrame(@OOXIXo Object obj) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "onDrawFrame--->");
        }
        if (this.mMiniMapCreated) {
            JNIBaseMap.GLDrawMinimap();
        }
        try {
            if (d.e && d.b) {
                e.l().a(this.surfaceWidth, this.surfaceHeight, 3);
            }
            if (com.baidu.navisdk.debug.d.c()) {
                com.baidu.navisdk.debug.d.g().a(this.surfaceWidth, this.surfaceHeight, 2);
            }
        } catch (Exception e) {
            d.a(false);
            e.printStackTrace();
        }
    }

    @Override // com.baidu.platform.comapi.map.SurfaceRenderer
    public void onSurfaceChanged(int i, int i2) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "onSurfaceChanged: " + i + ':' + i2);
        }
        this.surfaceWidth = i;
        this.surfaceHeight = i2;
        if (this.mMiniMapCreated) {
            BNMapController.getInstance().SetMinimapWinSize(i, i2);
        }
        if (d.b || com.baidu.navisdk.debug.d.c()) {
            GLES20.glViewport(0, 0, i, i2);
        }
    }

    @Override // com.baidu.platform.comapi.map.SurfaceRenderer
    public void onSurfaceCreated(@oOoXoXO SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "onSurfaceCreated: " + i + ':' + i2 + ", " + i3);
        }
        Thread currentThread = Thread.currentThread();
        currentThread.setName("MiniWinGL" + currentThread.getId());
        if (!this.mMiniMapCreated) {
            BNMapController.getInstance().createMiniMapControl();
            BNMapController.getInstance().initMiniRenderEngine(0, this.surfaceWidth, this.surfaceHeight);
            this.mMiniMapCreated = true;
            return;
        }
        BNMapController.getInstance().initMiniRenderEngine(0, this.surfaceWidth, this.surfaceHeight);
    }

    @Override // com.baidu.platform.comapi.map.SurfaceRenderer
    public void onSurfaceDestroyed(@oOoXoXO SurfaceHolder surfaceHolder) {
    }

    public final void setGLResizeParams(int i, int i2, int i3) {
        this.w_old = i;
        this.h_old = i2;
        this.resize_tries = i3;
    }
}
