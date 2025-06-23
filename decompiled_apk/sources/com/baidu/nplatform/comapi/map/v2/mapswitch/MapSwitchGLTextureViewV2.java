package com.baidu.nplatform.comapi.map.v2.mapswitch;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.SurfaceTexture;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.r;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.c;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import com.baidu.navisdk.util.worker.g;
import com.baidu.nplatform.comapi.map.h;
import com.baidu.nplatform.comapi.map.p;
import com.baidu.platform.comapi.map.GLTextureView;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class MapSwitchGLTextureViewV2 extends GLTextureView implements h {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "MapSwitchGLTextureViewV2";
    private boolean isSetRoundCorner;
    private int mMapHeight;
    private int mMapWidth;

    @oOoXoXO
    private MapSwitchRendererV2 mRenderer;
    private final float mapRadius;
    private final f<String, String> miniMapRequestTask;

    /* loaded from: classes8.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }
    }

    public MapSwitchGLTextureViewV2(@oOoXoXO Context context) {
        super(context);
        this.mapRadius = JarUtils.getResources().getDimension(R.dimen.navi_dimens_14dp);
        final String str = "miniMapRequestTask";
        final Object obj = null;
        this.miniMapRequestTask = new f<String, String>(str, obj) { // from class: com.baidu.nplatform.comapi.map.v2.mapswitch.MapSwitchGLTextureViewV2$miniMapRequestTask$1
            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            @oOoXoXO
            public String execute() {
                MapSwitchGLTextureViewV2.this.requestRender();
                c.a().a((g) this, false);
                c.a().a(this, new e(2, 0), 1000L);
                return null;
            }
        };
        setEGLContextFactory(new p());
        setPreserveEGLContextOnPause(true);
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "MapSwitchGLTextureView: --> create instance");
        }
        setEGLContextClientVersion(2);
        try {
            if (r.a(8, 8, 8, 8, 24, 8)) {
                setEGLConfigChooser(8, 8, 8, 8, 24, 8);
            } else {
                setEGLConfigChooser(true);
            }
        } catch (IllegalArgumentException unused) {
            setEGLConfigChooser(true);
        }
        initRender();
    }

    private final void hideMapViewRoundCorner() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "hideMapViewRoundCorner: ");
        }
        if (getOutlineProvider() != null) {
            setOutlineProvider(null);
            setClipToOutline(false);
        }
    }

    private final void initRender() {
        MapSwitchRendererV2 mapSwitchRendererV2 = new MapSwitchRendererV2();
        this.mRenderer = mapSwitchRendererV2;
        setRenderer(mapSwitchRendererV2);
        setRenderMode(0);
    }

    private final void showMapViewRoundCorner(int i, int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "showMapViewRoundCorner: " + i + ':' + i2);
        }
        if (this.isSetRoundCorner && this.mMapHeight == i2 && this.mMapWidth == i) {
            return;
        }
        this.mMapWidth = i;
        this.mMapHeight = i2;
        setOutlineProvider(new ViewOutlineProvider() { // from class: com.baidu.nplatform.comapi.map.v2.mapswitch.MapSwitchGLTextureViewV2$showMapViewRoundCorner$provider$1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(@oOoXoXO View view, @oOoXoXO Outline outline) {
                int i3;
                int i4;
                float f;
                if (outline != null) {
                    i3 = MapSwitchGLTextureViewV2.this.mMapWidth;
                    i4 = MapSwitchGLTextureViewV2.this.mMapHeight;
                    f = MapSwitchGLTextureViewV2.this.mapRadius;
                    outline.setRoundRect(0, 0, i3, i4, f);
                }
            }
        });
        setClipToOutline(true);
        this.isSetRoundCorner = true;
    }

    @oOoXoXO
    public final MapSwitchRendererV2 getMRenderer() {
        return this.mRenderer;
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView, android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c.a().b(this.miniMapRequestTask, new e(2, 0), 20L);
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c.a().a((g) this.miniMapRequestTask, false);
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView
    public void onPause() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "MapSwitchGLTextureView --> onPause");
        }
        super.onPause();
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView
    public void onResume() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "MapSwitchGLTextureView --> onResume");
        }
        try {
            super.onResume();
        } catch (Exception e) {
            LogUtil.e(TAG, "onResume error:" + e.getMessage());
        }
    }

    @Override // android.view.TextureView, android.view.View
    public void onVisibilityChanged(@OOXIXo View view, int i) {
        super.onVisibilityChanged(view, i);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e("onVisibilityChanged" + i);
        }
        if (i == 0) {
            onResume();
        } else {
            onPause();
        }
    }

    public final void setMRenderer(@oOoXoXO MapSwitchRendererV2 mapSwitchRendererV2) {
        this.mRenderer = mapSwitchRendererV2;
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView
    public void surfaceChanged(@OOXIXo SurfaceTexture surfaceTexture, int i, int i2, int i3) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "MapSwitchGLTextureView --> surfaceChanged:" + surfaceTexture);
        }
        MapSwitchRendererV2 mapSwitchRendererV2 = this.mRenderer;
        if (mapSwitchRendererV2 != null) {
            mapSwitchRendererV2.setGLResizeParams(i2, i3, 0);
        }
        super.surfaceChanged(surfaceTexture, i, i2, i3);
        showMapViewRoundCorner(i2, i3);
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView
    public void surfaceCreated(@OOXIXo SurfaceTexture surfaceTexture) {
        super.surfaceCreated(surfaceTexture);
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "MapSwitchGLTextureView: --> surfaceCreated");
        }
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView
    public void surfaceDestroyed(@OOXIXo SurfaceTexture surfaceTexture) {
        super.surfaceDestroyed(surfaceTexture);
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, " MapSwitchGLTextureView --> surfaceDestroyed:" + surfaceTexture);
        }
    }

    @Override // com.baidu.nplatform.comapi.map.h
    public void unInit() {
        MapSwitchRendererV2 mapSwitchRendererV2 = this.mRenderer;
        if (mapSwitchRendererV2 != null) {
            mapSwitchRendererV2.onDestroyed();
        }
        this.mRenderer = null;
    }
}
