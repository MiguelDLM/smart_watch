package com.baidu.ar;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.ar.baidumap.MapDuMix;
import com.baidu.ar.baidumap.MapDuMixParams;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.camera.CameraHandlerThread;
import com.baidu.ar.camera.CameraManager;
import com.baidu.ar.camera.DuMixRenderer;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class i implements SurfaceTexture.OnFrameAvailableListener {
    private DuMixInput ax;
    private DuMixOutput ay;
    private DuMixRenderer cA;
    private boolean cD;
    private String cE;
    private a cF;
    private IMockFrameAvailable cG;
    private NavigationController cw;
    private SurfaceTexture cx;
    private CameraHandlerThread cy;
    private GLSurfaceView d;
    private MapDuMix l;
    private Context mContext;
    private boolean cz = false;
    private int cB = 1280;
    private int cC = CameraManager.DEFAULTHEIGHT;
    private MapDuMixParams p = null;
    private boolean isDebug = false;

    /* loaded from: classes7.dex */
    public interface a {
        void a(MapDuMix mapDuMix);
    }

    public i(Context context, MapDuMix mapDuMix, NavigationController navigationController) {
        this.cw = navigationController;
        this.l = mapDuMix;
        this.mContext = context;
    }

    private void aa() {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.release();
            this.l = null;
        }
    }

    private DuMixRenderer.a ab() {
        return new DuMixRenderer.a() { // from class: com.baidu.ar.i.2
            @Override // com.baidu.ar.camera.DuMixRenderer.a
            public void a(SurfaceTexture surfaceTexture, SurfaceTexture surfaceTexture2) {
                i.this.a(surfaceTexture, false);
                i.this.cx = surfaceTexture;
                i iVar = i.this;
                iVar.ax = new DuMixInput(surfaceTexture, iVar.cB, i.this.cC);
                i.this.ax.setFrontCamera(i.this.cz);
                i iVar2 = i.this;
                iVar2.ay = new DuMixOutput(surfaceTexture2, iVar2.cB, i.this.cC);
                surfaceTexture2.setOnFrameAvailableListener(i.this);
            }

            @Override // com.baidu.ar.camera.DuMixRenderer.a
            public void onSurfaceChanged(int i, int i2) {
                if (i.this.p == null || i.this.ay == null) {
                    return;
                }
                i.this.ay.setOutputWidth(i);
                i.this.ay.setOutputHeight(i2);
                i.this.p.setShareContext(null);
                i.this.p.setUseTextureIO(false);
                i.this.p.setHeight(i.this.cC);
                i.this.p.setWidth(i.this.cB);
                i iVar = i.this;
                iVar.l = iVar.ac();
                if (i.this.cF != null && !i.this.cD) {
                    i.this.cF.a(i.this.l);
                    i.this.l.setup(i.this.ax, i.this.ay, i.this.cw.createMapDuMixCallback());
                    i.this.cD = true;
                }
                i.this.l.changeOutputSize(i, i2);
            }
        };
    }

    public void Z() {
        CameraHandlerThread cameraHandlerThread = this.cy;
        if (cameraHandlerThread != null) {
            cameraHandlerThread.stopPreview();
            this.cy.releaseCamera();
            this.cy.destoryThread();
            this.cy = null;
        }
        DuMixRenderer duMixRenderer = this.cA;
        if (duMixRenderer != null) {
            duMixRenderer.release();
            this.cA = null;
        }
        SurfaceTexture surfaceTexture = this.cx;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.cx = null;
        }
        aa();
    }

    public MapDuMix ac() {
        if (this.l == null) {
            MapDuMix mapDuMix = MapDuMix.getInstance(this.mContext, this.p);
            this.l = mapDuMix;
            mapDuMix.addLuaMsgListener(this.cw);
        }
        return this.l;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        GLSurfaceView gLSurfaceView = this.d;
        if (gLSurfaceView != null) {
            gLSurfaceView.requestRender();
        }
    }

    public void onPause() {
        CameraHandlerThread cameraHandlerThread = this.cy;
        if (cameraHandlerThread != null) {
            cameraHandlerThread.stopPreview();
            this.cy.releaseCamera();
        }
    }

    public void onResume() {
        SurfaceTexture surfaceTexture = this.cx;
        if (surfaceTexture != null) {
            a(surfaceTexture, false);
        }
    }

    public void setDebug(boolean z) {
        this.isDebug = z;
    }

    public void setFrameAvailableListener(IMockFrameAvailable iMockFrameAvailable) {
        this.cG = iMockFrameAvailable;
    }

    public void b(int i, int i2) {
        this.cB = i;
        this.cC = i2;
    }

    public void b(String str, boolean z) {
        MapDuMix mapDuMix;
        String navigation3DofARKey;
        this.cE = str;
        if (this.l != null) {
            if (TextUtils.isEmpty(str)) {
                mapDuMix = this.l;
                navigation3DofARKey = ARConfig.getNavigation3DofARKey();
            } else {
                mapDuMix = this.l;
                navigation3DofARKey = this.cE;
            }
            mapDuMix.loadCase(navigation3DofARKey);
        }
        if (z) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "3DOF-NPC");
            hashMap.put("cuid", ARConfig.getCUID());
            StatisticApi.onEvent(StatisticConstants.NAVIGATION_START_SUCCESS, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SurfaceTexture surfaceTexture, boolean z) {
        if (this.isDebug) {
            CameraHandlerThread cameraHandlerThread = this.cy;
            if (cameraHandlerThread != null) {
                cameraHandlerThread.stopPreview();
                this.cy.releaseCamera();
                this.cy.destoryThread();
            }
            this.cG.onSurfaceTextureCreated(surfaceTexture, this.cB, this.cC);
            return;
        }
        if (this.cy == null) {
            this.cy = new CameraHandlerThread();
        }
        this.cy.stopPreview();
        int rotation = ((Activity) this.mContext).getWindowManager().getDefaultDisplay().getRotation();
        if (z) {
            CameraHandlerThread cameraHandlerThread2 = this.cy;
            boolean z2 = this.cz;
            cameraHandlerThread2.switchCamera(z2 ? 1 : 0, this.cB, this.cC);
        } else {
            CameraHandlerThread cameraHandlerThread3 = this.cy;
            boolean z3 = this.cz;
            cameraHandlerThread3.openCamera(z3 ? 1 : 0, this.cB, this.cC, rotation);
        }
        this.cy.setPreviewSurface(surfaceTexture);
        this.cy.startPreview();
    }

    public void a(GLSurfaceView gLSurfaceView, MapDuMixParams mapDuMixParams, a aVar) {
        this.p = mapDuMixParams;
        this.cF = aVar;
        this.d = gLSurfaceView;
        DuMixRenderer duMixRenderer = new DuMixRenderer(ab());
        this.cA = duMixRenderer;
        this.d.setRenderer(duMixRenderer);
        this.d.setRenderMode(0);
        this.d.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.ar.i.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (i.this.l != null) {
                    return i.this.l.onTouch(view, motionEvent);
                }
                return false;
            }
        });
    }
}
