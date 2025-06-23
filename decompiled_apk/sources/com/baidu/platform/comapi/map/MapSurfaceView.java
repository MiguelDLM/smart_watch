package com.baidu.platform.comapi.map;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.ah;
import com.baidu.platform.comapi.map.f;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.jieli.jl_bt_ota.constant.ErrorCode;
import com.jieli.jl_rcsp.constant.Command;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class MapSurfaceView extends ai implements View.OnKeyListener, MapRenderModeChangeListener, MapViewInterface, aj {
    private static final ExecutorService A = Executors.newSingleThreadExecutor();
    private static int s;
    private int B;
    private int C;
    private int D;

    /* renamed from: a, reason: collision with root package name */
    protected MapController f9621a;
    protected ae b;
    protected k c;
    protected o d;
    protected volatile boolean e;
    protected boolean f;
    protected am g;
    protected GestureDetector h;
    protected ab i;
    protected com.baidu.mapsdkplatform.comapi.map.c j;
    private volatile boolean l;
    private volatile boolean m;
    private volatile boolean n;
    private volatile boolean o;
    private boolean p;
    private boolean q;
    private LocationOverlay r;
    private boolean t;
    private List<BmLayer> u;
    private List<Overlay> v;
    private int w;
    private int x;
    private HashSet<aa> y;
    private boolean z;

    /* loaded from: classes8.dex */
    public class a implements f.InterfaceC0529f {
        private int b;

        private a() {
            this.b = 12440;
        }

        @Override // com.baidu.platform.comapi.map.f.InterfaceC0529f
        public EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{this.b, 2, 12344});
        }

        public String b(String str, int i) {
            return str + " failed: " + a(i);
        }

        private String b(int i) {
            return HexStringBuilder.DEFAULT_PREFIX + Integer.toHexString(i);
        }

        public /* synthetic */ a(MapSurfaceView mapSurfaceView, s sVar) {
            this();
        }

        @Override // com.baidu.platform.comapi.map.f.InterfaceC0529f
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (eGLContext != null && eGLDisplay != null) {
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
                if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                    Log.e("MapContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                    a("eglDestroyContex", egl10.eglGetError());
                }
            }
            MapSurfaceView.this.onRecycle();
        }

        public void a(String str, int i) {
            throw new RuntimeException(b(str, i));
        }

        private String a(int i) {
            switch (i) {
                case 12288:
                    return "EGL_SUCCESS";
                case 12289:
                    return "EGL_NOT_INITIALIZED";
                case 12290:
                    return "EGL_BAD_ACCESS";
                case 12291:
                    return "EGL_BAD_ALLOC";
                case 12292:
                    return "EGL_BAD_ATTRIBUTE";
                case 12293:
                    return "EGL_BAD_CONFIG";
                case 12294:
                    return "EGL_BAD_CONTEXT";
                case ErrorCode.SUB_ERR_SEND_TIMEOUT /* 12295 */:
                    return "EGL_BAD_CURRENT_SURFACE";
                case ErrorCode.SUB_ERR_RESPONSE_BAD_STATUS /* 12296 */:
                    return "EGL_BAD_DISPLAY";
                case 12297:
                    return "EGL_BAD_MATCH";
                case ErrorCode.SUB_ERR_RESPONSE_BAD_RESULT /* 12298 */:
                    return "EGL_BAD_NATIVE_PIXMAP";
                case ErrorCode.SUB_ERR_WAITING_COMMAND_TIMEOUT /* 12299 */:
                    return "EGL_BAD_NATIVE_WINDOW";
                case 12300:
                    return "EGL_BAD_PARAMETER";
                case 12301:
                    return "EGL_BAD_SURFACE";
                case 12302:
                    return "EGL_CONTEXT_LOST";
                default:
                    return b(i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            super.onLongPress(motionEvent);
            MapController mapController = MapSurfaceView.this.f9621a;
            if (mapController != null && mapController.getBaseMap() != null) {
                MapController mapController2 = MapSurfaceView.this.f9621a;
                if (mapController2.mIsMapLoadFinish) {
                    String GetNearlyObjID = mapController2.getBaseMap().GetNearlyObjID(-1L, (int) motionEvent.getX(), (int) motionEvent.getY(), MapSurfaceView.this.f9621a.nearlyRadius);
                    GeoPoint geoPoint = null;
                    if (GetNearlyObjID != null && !GetNearlyObjID.equals("")) {
                        MapSurfaceView mapSurfaceView = MapSurfaceView.this;
                        if (mapSurfaceView.f9621a.mListeners != null) {
                            if (mapSurfaceView.getProjection() != null) {
                                geoPoint = MapSurfaceView.this.getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY());
                            }
                            for (ak akVar : MapSurfaceView.this.f9621a.mListeners) {
                                if (akVar != null) {
                                    if (akVar.b(GetNearlyObjID)) {
                                        MapSurfaceView.this.f9621a.mHasMapObjDraging = true;
                                    } else if (geoPoint != null) {
                                        akVar.c(geoPoint);
                                    }
                                }
                            }
                            return;
                        }
                        return;
                    }
                    MapSurfaceView mapSurfaceView2 = MapSurfaceView.this;
                    if (mapSurfaceView2.f9621a.mListeners != null) {
                        if (mapSurfaceView2.getProjection() != null) {
                            geoPoint = MapSurfaceView.this.getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY());
                        }
                        if (geoPoint == null) {
                            return;
                        }
                        for (ak akVar2 : MapSurfaceView.this.f9621a.mListeners) {
                            if (akVar2 != null) {
                                akVar2.c(geoPoint);
                            }
                        }
                    }
                }
            }
        }

        public /* synthetic */ b(MapSurfaceView mapSurfaceView, s sVar) {
            this();
        }
    }

    public MapSurfaceView(Context context) {
        super(context);
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = true;
        this.q = true;
        this.f9621a = null;
        this.b = null;
        this.c = null;
        this.e = false;
        this.t = true;
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.w = 0;
        this.x = 0;
        this.y = new HashSet<>();
        this.f = true;
        this.z = true;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        s++;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean addBmLayer(BmLayer bmLayer) {
        return addBmLayerBelow(0L, bmLayer);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean addBmLayerBelow(Overlay overlay, BmLayer bmLayer) {
        if (overlay != null) {
            return addBmLayerBelow(overlay.mLayerID, bmLayer);
        }
        return addBmLayerBelow(0L, bmLayer);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public synchronized boolean addOverlay(Overlay overlay) {
        if (overlay != null) {
            MapController mapController = this.f9621a;
            if (mapController != null) {
                AppBaseMap baseMap = mapController.getBaseMap();
                if (baseMap == null) {
                    return false;
                }
                if (overlay instanceof ao) {
                    return ((InnerOverlay) overlay).addedToMapView();
                }
                if (overlay instanceof InnerOverlay) {
                    if (((InnerOverlay) overlay).mBaseMap == null) {
                        ((InnerOverlay) overlay).mBaseMap = getController().getBaseMap();
                    }
                    if (!((InnerOverlay) overlay).addedToMapView()) {
                        return false;
                    }
                    synchronized (this) {
                        this.v.add(overlay);
                        this.b.a((InnerOverlay) overlay);
                    }
                    return true;
                }
                if (!(overlay instanceof ItemizedOverlay)) {
                    return false;
                }
                long AddLayer = baseMap.AddLayer(((ItemizedOverlay) overlay).getUpdateType(), 0, "item");
                overlay.mLayerID = AddLayer;
                if (AddLayer == 0) {
                    return false;
                }
                synchronized (this) {
                    this.v.add(overlay);
                    ((ItemizedOverlay) overlay).a();
                    baseMap.SetLayersClickable(overlay.mLayerID, true);
                    baseMap.ShowLayers(overlay.mLayerID, true);
                    baseMap.UpdateLayers(overlay.mLayerID);
                }
                return true;
            }
        }
        return false;
    }

    public void addSimpleOnGestureListener(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        this.g.a(simpleOnGestureListener);
    }

    public void addStateListener(aa aaVar) {
        if (aaVar != null) {
            this.y.add(aaVar);
        }
    }

    public void animateTo(MapStatus mapStatus, int i) {
        MapController mapController = this.f9621a;
        if (mapController != null) {
            mapController.setMapStatusWithAnimation(mapStatus, i);
        }
    }

    public void beginLocationLayerAnimation() {
        LocationOverlay locationOverlay = this.r;
        if (locationOverlay != null) {
            locationOverlay.beginLocationLayerAnimation();
        }
    }

    @Override // com.baidu.platform.comapi.map.ai
    public /* bridge */ /* synthetic */ Bitmap captureImageFromSurface(int i, int i2, int i3, int i4, Object obj, Bitmap.Config config) {
        return super.captureImageFromSurface(i, i2, i3, i4, obj, config);
    }

    public void clearDefaultLocationLayerData(Bundle bundle) {
        this.r.clearLocationLayerData(bundle);
    }

    public void doCaptureMapView(c cVar, int i, int i2) {
        this.d.a(cVar, i, i2);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean enable3D() {
        return true;
    }

    public void forceSetTraffic(boolean z) {
        if (this.f9621a != null) {
            this.l = z;
        }
        A.submit(new t(this));
    }

    public com.baidu.mapsdkplatform.comapi.map.c getBaseMap() {
        return this.j;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public List<BmLayer> getBmlayers() {
        return this.u;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapController getController() {
        return this.f9621a;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus getCurrentMapStatus() {
        MapController mapController = this.f9621a;
        if (mapController != null) {
            return mapController.getCurrentMapStatus();
        }
        return null;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getCurrentZoomLevel() {
        MapController mapController = this.f9621a;
        if (mapController != null) {
            return mapController.getCurrentZoomLevel();
        }
        return 0.0f;
    }

    @Override // com.baidu.platform.comapi.map.ai
    public /* bridge */ /* synthetic */ int getDebugFlags() {
        return super.getDebugFlags();
    }

    public LocationOverlay getDefaultLocationLay() {
        return this.r;
    }

    public int getFPS() {
        return this.k.e();
    }

    public float getFZoomToBoundF(MapBound mapBound, MapBound mapBound2) {
        if (this.f9621a == null) {
            return 0.0f;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("left", mapBound.leftBottomPt.getIntX());
        bundle.putInt("bottom", mapBound.leftBottomPt.getIntY());
        bundle.putInt("right", mapBound.rightTopPt.getIntX());
        bundle.putInt("top", mapBound.rightTopPt.getIntY());
        Bundle bundle2 = new Bundle();
        bundle2.putInt("left", mapBound2.leftBottomPt.getIntX());
        bundle2.putInt("bottom", mapBound2.leftBottomPt.getIntY());
        bundle2.putInt("right", mapBound2.rightTopPt.getIntX());
        bundle2.putInt("top", mapBound2.rightTopPt.getIntY());
        return this.f9621a.GetFZoomToBoundF(bundle, bundle2);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus.GeoBound getGeoRound() {
        MapController mapController = this.f9621a;
        if (mapController == null) {
            return null;
        }
        return mapController.getMapStatus().geoRound;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getLatitudeSpan() {
        MapStatus mapStatus = getMapStatus();
        k kVar = (k) getProjection();
        MapStatus.WinRound winRound = mapStatus.winRound;
        GeoPoint fromPixels = kVar.fromPixels(winRound.left, winRound.top);
        MapStatus.WinRound winRound2 = mapStatus.winRound;
        return (int) Math.abs(fromPixels.getLatitude() - kVar.fromPixels(winRound2.right - 1, winRound2.bottom - 1).getLatitude());
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getLongitudeSpan() {
        MapStatus mapStatus = getMapStatus();
        k kVar = (k) getProjection();
        MapStatus.WinRound winRound = mapStatus.winRound;
        GeoPoint fromPixels = kVar.fromPixels(winRound.left, winRound.top);
        MapStatus.WinRound winRound2 = mapStatus.winRound;
        return (int) Math.abs(kVar.fromPixels(winRound2.right - 1, winRound2.bottom - 1).getLongitude() - fromPixels.getLongitude());
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public GeoPoint getMapCenter() {
        MapController mapController = this.f9621a;
        if (mapController == null) {
            return null;
        }
        MapStatus mapStatus = mapController.getMapStatus();
        return new GeoPoint(mapStatus.centerPtY, mapStatus.centerPtX);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getMapRotation() {
        MapController mapController = this.f9621a;
        if (mapController == null) {
            return 0;
        }
        return mapController.getMapStatus().rotation;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus getMapStatus() {
        MapController mapController = this.f9621a;
        if (mapController != null) {
            return mapController.getMapStatus();
        }
        return null;
    }

    public MapViewListener getMapViewListener() {
        MapController mapController = this.f9621a;
        if (mapController != null) {
            return mapController.getMapViewListener();
        }
        return null;
    }

    public OnLongPressListener getOnLongPressListener() {
        return this.g.a();
    }

    public synchronized Overlay getOverlay(int i) {
        if (i == 21) {
            return null;
        }
        for (Overlay overlay : this.v) {
            if (overlay.mType == i) {
                return overlay;
            }
        }
        return null;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public List<Overlay> getOverlays() {
        return this.v;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getOverlooking() {
        MapController mapController = this.f9621a;
        if (mapController == null) {
            return 0;
        }
        return mapController.getMapStatus().overlooking;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public Projection getProjection() {
        return this.c;
    }

    @Override // com.baidu.platform.comapi.map.ai
    public /* bridge */ /* synthetic */ ag getRenderControl() {
        return super.getRenderControl();
    }

    @Override // com.baidu.platform.comapi.map.ai
    public /* bridge */ /* synthetic */ int getRenderMode() {
        return super.getRenderMode();
    }

    public ExecutorService getSingleThreadPool() {
        return A;
    }

    @Override // com.baidu.platform.comapi.map.ai
    public /* bridge */ /* synthetic */ ah.a getViewType() {
        return super.getViewType();
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus.WinRound getWinRound() {
        MapController mapController = this.f9621a;
        if (mapController == null) {
            return null;
        }
        return mapController.getMapStatus().winRound;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomLevel() {
        MapController mapController = this.f9621a;
        if (mapController != null) {
            return mapController.getZoomLevel();
        }
        return 0.0f;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBound(MapBound mapBound) {
        SysOSUtil sysOSUtil = SysOSUtil.getInstance();
        return getZoomToBound(mapBound, sysOSUtil.getScreenWidth(), sysOSUtil.getScreenHeight());
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBoundF(MapBound mapBound, int i, int i2) {
        if (this.f9621a == null) {
            return 0.0f;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("left", mapBound.leftBottomPt.getIntX());
        bundle.putInt("bottom", mapBound.leftBottomPt.getIntY());
        bundle.putInt("right", mapBound.rightTopPt.getIntX());
        bundle.putInt("top", mapBound.rightTopPt.getIntY());
        return this.f9621a.getZoomToBoundF(bundle);
    }

    public boolean inRangeOfView(float f, float f2) {
        float f3 = 0;
        if (f < f3 || f > this.w || f2 < f3 || f2 > this.x) {
            return false;
        }
        return true;
    }

    public synchronized boolean insertOverlay(Overlay overlay, int i) {
        MapController mapController;
        try {
            if ((overlay instanceof InnerOverlay) && (mapController = this.f9621a) != null) {
                if (((InnerOverlay) overlay).mBaseMap == null) {
                    ((InnerOverlay) overlay).mBaseMap = mapController.getBaseMap();
                }
                this.v.add(overlay);
                this.b.a((InnerOverlay) overlay);
            }
        } catch (Throwable th) {
            throw th;
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isBaseIndoorMap() {
        return this.o;
    }

    public boolean isPredictTraffic() {
        if (this.B <= 0 && this.C <= 0 && this.D <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isSatellite() {
        return this.m;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isStreetRoad() {
        return this.n;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isTraffic() {
        return this.l;
    }

    @Override // com.baidu.platform.comapi.map.ai, android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MapController mapController = this.f9621a;
        if (mapController != null) {
            mapController.updateDrawFPS();
        }
    }

    public void onBackground() {
        if (this.q) {
            return;
        }
        MapController mapController = this.f9621a;
        if (mapController != null && mapController.getBaseMap() != null) {
            this.f9621a.getBaseMap().OnBackground();
        }
        this.q = true;
    }

    @Override // com.baidu.platform.comapi.map.ai, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        MapController mapController = this.f9621a;
        if (mapController != null) {
            mapController.updateDrawFPS();
        }
        super.onDetachedFromWindow();
    }

    public void onForeground() {
        if (this.q) {
            MapController mapController = this.f9621a;
            if (mapController != null && mapController.getBaseMap() != null) {
                this.f9621a.getBaseMap().OnForeground();
            }
            this.q = false;
            if (this.k.b() == ah.a.VULKAN) {
                o oVar = this.d;
                if (oVar != null) {
                    oVar.a();
                }
                super.onResume();
            }
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this != view || keyEvent.getAction() != 0) {
            return false;
        }
        switch (i) {
            case 19:
                this.f9621a.scrollBy(0, -50);
                return true;
            case 20:
                this.f9621a.scrollBy(0, 50);
                return true;
            case 21:
                this.f9621a.scrollBy(-50, 0);
                return true;
            case 22:
                this.f9621a.scrollBy(50, 0);
                return true;
            default:
                return false;
        }
    }

    @Override // com.baidu.platform.comapi.map.MapRenderModeChangeListener
    public void onMapRenderModeChange(int i) {
        ab abVar;
        if (i == 1) {
            requestRender();
            return;
        }
        if (i == 0) {
            if (getRenderMode() != 0) {
                setRenderMode(0);
            }
        } else if (i == 2 && (abVar = this.i) != null) {
            abVar.a();
        }
    }

    @Override // com.baidu.platform.comapi.map.ai
    public void onPause() {
        if (this.p) {
            return;
        }
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("BasicMap onPause");
        }
        o oVar = this.d;
        if (oVar != null) {
            oVar.b();
        }
        MapController mapController = this.f9621a;
        if (mapController != null) {
            mapController.onPause();
        }
        Iterator<aa> it = this.y.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        super.onPause();
        this.p = true;
    }

    public void onRecycle() {
        MapController mapController = this.f9621a;
        if (mapController != null && mapController.getBaseMap() != null) {
            this.f9621a.getBaseMap().ResetImageRes();
        }
    }

    @Override // com.baidu.platform.comapi.map.MapRenderModeChangeListener
    public void onRequestRender() {
        requestRender();
    }

    @Override // com.baidu.platform.comapi.map.ai
    public void onResume() {
        if (this.p) {
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("BasicMap onResume isInited = " + this.e);
            }
            if (!this.e) {
                return;
            }
            o oVar = this.d;
            if (oVar != null) {
                oVar.a();
            }
            MapController mapController = this.f9621a;
            if (mapController != null) {
                mapController.onResume();
            }
            Iterator<aa> it = this.y.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
            setRenderMode(1);
            super.onResume();
            this.p = false;
        }
    }

    @Override // android.view.View, com.baidu.platform.comapi.map.MapViewInterface
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MapStatus mapStatus = getMapStatus();
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int x = (int) motionEvent.getX(i);
            int y = (int) motionEvent.getY(i);
            if (mapStatus != null) {
                MapStatus.WinRound winRound = mapStatus.winRound;
                if (x >= winRound.left && x <= winRound.right && y >= winRound.top && y <= winRound.bottom) {
                }
            }
            return false;
        }
        try {
            GestureDetector gestureDetector = this.h;
            if (gestureDetector != null && gestureDetector.onTouchEvent(motionEvent)) {
                return true;
            }
            MapController mapController = this.f9621a;
            if (mapController != null) {
                if (mapController.handleTouchEvent(motionEvent)) {
                    return true;
                }
            }
            return super.onTouchEvent(motionEvent);
        } catch (Exception unused) {
            return super.onTouchEvent(motionEvent);
        }
    }

    @Override // com.baidu.platform.comapi.map.ai
    public /* bridge */ /* synthetic */ void queueEvent(Runnable runnable) {
        super.queueEvent(runnable);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void refresh(Overlay overlay) {
        if (overlay != null && this.f9621a != null) {
            if (overlay instanceof ItemizedOverlay) {
                ItemizedOverlay itemizedOverlay = (ItemizedOverlay) overlay;
                if (itemizedOverlay.b()) {
                    if (itemizedOverlay.getAllItem().size() <= 0) {
                        this.f9621a.getBaseMap().ClearLayer(overlay.mLayerID);
                        this.f9621a.getBaseMap().ShowLayers(overlay.mLayerID, false);
                        this.f9621a.getBaseMap().UpdateLayers(overlay.mLayerID);
                    } else {
                        this.f9621a.getBaseMap().ShowLayers(overlay.mLayerID, true);
                        this.f9621a.getBaseMap().UpdateLayers(overlay.mLayerID);
                    }
                    itemizedOverlay.a(false);
                }
            }
            MapController mapController = this.f9621a;
            if (mapController != null && mapController.getBaseMap() != null) {
                this.f9621a.getBaseMap().UpdateLayers(overlay.mLayerID);
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public synchronized boolean removeBmLayer(BmLayer bmLayer) {
        if (bmLayer != null) {
            MapController mapController = this.f9621a;
            if (mapController != null) {
                AppBaseMap baseMap = mapController.getBaseMap();
                if (baseMap == null) {
                    return false;
                }
                baseMap.removeBmLayer(bmLayer.e());
                synchronized (this) {
                    this.u.remove(bmLayer);
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public synchronized boolean removeOverlay(Overlay overlay) {
        if (overlay != null) {
            MapController mapController = this.f9621a;
            if (mapController != null) {
                AppBaseMap baseMap = mapController.getBaseMap();
                if (baseMap == null) {
                    return false;
                }
                baseMap.ClearLayer(overlay.mLayerID);
                baseMap.ShowLayers(overlay.mLayerID, false);
                baseMap.UpdateLayers(overlay.mLayerID);
                baseMap.RemoveLayer(overlay.mLayerID);
                synchronized (this) {
                    try {
                        if (overlay instanceof ItemizedOverlay) {
                            this.v.remove(overlay);
                        } else if (overlay instanceof InnerOverlay) {
                            this.v.remove(overlay);
                            this.b.a(overlay);
                        }
                        overlay.mLayerID = 0L;
                    } finally {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void removeSimpleOnGestureListener(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        this.g.b(simpleOnGestureListener);
    }

    public void removeStateListener(aa aaVar) {
        if (aaVar != null) {
            this.y.remove(aaVar);
        }
    }

    @Override // com.baidu.platform.comapi.map.ai
    public /* bridge */ /* synthetic */ void requestRender() {
        super.requestRender();
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void saveScreenToLocal(String str) {
        MapController mapController = this.f9621a;
        if (mapController != null) {
            mapController.saveScreenToLocal(str);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setBaseIndoorMap(boolean z) {
        if (this.f9621a != null) {
            this.o = z;
        }
        A.submit(new w(this, z));
    }

    public void setBaseMap(com.baidu.mapsdkplatform.comapi.map.c cVar) {
        this.j = cVar;
    }

    @Override // com.baidu.platform.comapi.map.ai
    public /* bridge */ /* synthetic */ void setDebugFlags(int i) {
        super.setDebugFlags(i);
    }

    public void setDefaultLocationLayerData(List<OverlayLocationData> list) {
        this.r.setLocationLayerData(list);
    }

    public void setFPS(int i) {
        this.k.a(i);
    }

    public void setFirstFrameListener(e eVar) {
        o oVar = this.d;
        if (oVar != null) {
            oVar.a(eVar);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setGeoRound(MapStatus.GeoBound geoBound) {
    }

    public boolean setItsPreTime(int i, int i2, int i3) {
        AppBaseMap baseMap;
        if (this.B == i && this.C == i2 && this.D == i3) {
            return true;
        }
        MapController mapController = this.f9621a;
        if (mapController != null && (baseMap = mapController.getBaseMap()) != null) {
            this.B = i;
            this.C = i2;
            this.D = i3;
            return baseMap.SetItsPreTime(i, i2, i3);
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapCenter(GeoPoint geoPoint) {
        MapController mapController = this.f9621a;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.centerPtX = geoPoint.getLongitude();
            mapStatus.centerPtY = geoPoint.getLatitude();
            this.f9621a.setMapStatus(mapStatus);
        }
    }

    public void setMapController(MapController mapController) {
        if (this.f9621a != null) {
            return;
        }
        this.f9621a = mapController;
        this.d.a(mapController.getBaseMap());
        this.d.a(true);
        ae aeVar = new ae(this.f9621a.getBaseMap());
        this.b = aeVar;
        this.f9621a.setOverlayMapCallBack(aeVar);
        this.f9621a.setMapViewInterface(this);
        b();
        this.f9621a.setMapRenderModeChangeListener(this);
        this.e = true;
        this.c = new k(this.f9621a);
        this.g.a(this.f9621a);
    }

    public void setMapRenderStableListener(ab abVar) {
        this.i = abVar;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapStatus(MapStatus mapStatus) {
        MapController mapController = this.f9621a;
        if (mapController != null) {
            mapController.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapTo2D(boolean z) {
    }

    public void setOnLongPressListener(OnLongPressListener onLongPressListener) {
        this.g.a(onLongPressListener);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setOverlooking(int i) {
        MapController mapController = this.f9621a;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.overlooking = i;
            this.f9621a.setMapStatus(mapStatus);
        }
    }

    public void setPixelFormatTransparent(boolean z) {
        if (z) {
            getHolder().setFormat(-3);
        } else {
            getHolder().setFormat(-1);
        }
    }

    @Override // com.baidu.platform.comapi.map.ai
    public /* bridge */ /* synthetic */ void setRenderMode(int i) {
        super.setRenderMode(i);
    }

    @Override // com.baidu.platform.comapi.map.ai
    public /* bridge */ /* synthetic */ void setRenderer(SurfaceRenderer surfaceRenderer) {
        super.setRenderer(surfaceRenderer);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setRotation(int i) {
        MapController mapController = this.f9621a;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.rotation = i;
            this.f9621a.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setSatellite(boolean z) {
        if (this.f9621a != null) {
            this.m = z;
        }
        A.submit(new s(this));
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setStreetRoad(boolean z) {
        if (this.f9621a != null) {
            this.n = z;
        }
        A.submit(new v(this));
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setTraffic(boolean z) {
        if (this.l == z) {
            return;
        }
        if (this.f9621a != null) {
            this.l = z;
        }
        A.submit(new u(this));
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setWinRound(MapStatus.WinRound winRound) {
        MapController mapController = this.f9621a;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.winRound = winRound;
            this.f9621a.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setZoomLevel(float f) {
        if (this.f9621a == null) {
            return;
        }
        getController().getFocusedBaseIndoorMapInfo();
        if (f < 4.0f) {
            f = 4.0f;
        } else {
            float f2 = 22;
            if (f > f2) {
                f = f2;
            }
        }
        MapStatus mapStatus = getMapStatus();
        if (mapStatus != null) {
            mapStatus.level = f;
            animateTo(mapStatus, 300);
        }
    }

    @Override // com.baidu.platform.comapi.map.ai, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        MapController mapController = this.f9621a;
        if (mapController != null) {
            mapController.updateDrawFPS();
        }
        o oVar = this.d;
        if (oVar != null) {
            oVar.f9668a = i2;
            oVar.b = i3;
            oVar.c = 0;
        }
        this.w = i2;
        this.x = i3;
        super.surfaceChanged(surfaceHolder, i, i2, i3);
        if (this.f9621a != null) {
            MapStatus mapStatus = getMapStatus();
            if (mapStatus != null) {
                MapStatus.WinRound winRound = mapStatus.winRound;
                winRound.left = 0;
                winRound.top = 0;
                winRound.bottom = i3;
                winRound.right = i2;
                if (!this.t) {
                    this.f9621a.setMapStatus(mapStatus, false);
                } else {
                    this.t = false;
                    this.f9621a.setMapStatusWithAnimation(mapStatus, 4, 0);
                }
                if (this.f9621a.getMapViewSurfaceListener() != null) {
                    this.f9621a.getMapViewSurfaceListener().onSurfaceChanged(i2, i3);
                }
            }
            MapStatus mapStatus2 = getMapStatus();
            MapStatus.WinRound winRound2 = mapStatus2.winRound;
            int abs = Math.abs(winRound2.right - winRound2.left);
            MapStatus.WinRound winRound3 = mapStatus2.winRound;
            int abs2 = Math.abs(winRound3.bottom - winRound3.top);
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("MapSurfaceView winRoundWidth = " + abs + ";winRoundHeight = " + abs2 + ";mWidth = " + this.w + ";mHeight = " + this.x);
            }
            if (abs > 0 && abs2 > 0) {
                this.w = abs;
                this.x = abs2;
            }
            this.f9621a.setScreenSize(this.w, this.x);
            if (this.f9621a.isNaviMode() && this.f9621a.getNaviMapViewListener() != null) {
                this.f9621a.getNaviMapViewListener().resizeScreen(i2, i3);
            }
        }
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar != null) {
            cVar.a(this.w, this.x);
        }
    }

    @Override // com.baidu.platform.comapi.map.ai, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        MapController mapController = this.f9621a;
        if (mapController != null) {
            mapController.updateDrawFPS();
        }
        super.surfaceCreated(surfaceHolder);
        if (surfaceHolder != null && !surfaceHolder.getSurface().isValid()) {
            surfaceDestroyed(surfaceHolder);
        }
    }

    @Override // com.baidu.platform.comapi.map.ai, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        MapController mapController = this.f9621a;
        if (mapController != null) {
            mapController.updateDrawFPS();
        }
        super.surfaceDestroyed(surfaceHolder);
    }

    @Override // com.baidu.platform.comapi.map.ai, android.view.SurfaceHolder.Callback2
    @Deprecated
    public /* bridge */ /* synthetic */ void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        super.surfaceRedrawNeeded(surfaceHolder);
    }

    @Override // com.baidu.platform.comapi.map.ai, android.view.SurfaceHolder.Callback2
    @TargetApi(26)
    public /* bridge */ /* synthetic */ void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        super.surfaceRedrawNeededAsync(surfaceHolder, runnable);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean switchOverlay(Overlay overlay, Overlay overlay2) {
        MapController mapController;
        AppBaseMap baseMap;
        if (overlay == null || overlay2 == null || (mapController = this.f9621a) == null || (baseMap = mapController.getBaseMap()) == null) {
            return false;
        }
        return baseMap.SwitchLayer(overlay.mLayerID, overlay2.mLayerID);
    }

    public void unInit() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar != null) {
            List<ak> list = cVar.h;
            if (list != null) {
                for (ak akVar : list) {
                    if (akVar != null) {
                        akVar.d();
                    }
                }
            }
            this.j.M();
            this.j = null;
        }
        this.f9621a.unInit();
        this.f9621a = null;
        this.b.a();
        this.b = null;
        this.c = null;
        this.d = null;
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("BasicMap surfaceView unInit");
        }
    }

    @Override // com.baidu.platform.comapi.map.ai
    public ag a(ah.a aVar, boolean z, Context context) {
        ag a2 = super.a(aVar, z, context);
        if (a2 instanceof f) {
            f fVar = (f) a2;
            if (this.z) {
                fVar.a(new a(this, null));
            }
        }
        return a2;
    }

    public void b() {
        MapController mapController = this.f9621a;
        if (mapController == null || mapController.getBaseMap() == null) {
            return;
        }
        a();
    }

    public void doCaptureMapView(c cVar, int i, int i2, Bitmap.Config config) {
        this.d.a(cVar, i, i2, config);
    }

    public synchronized boolean addBmLayerBelow(long j, BmLayer bmLayer) {
        if (bmLayer != null) {
            MapController mapController = this.f9621a;
            if (mapController != null) {
                AppBaseMap baseMap = mapController.getBaseMap();
                if (baseMap == null) {
                    return false;
                }
                synchronized (this) {
                    if (this.u.contains(bmLayer)) {
                        return false;
                    }
                    this.u.add(bmLayer);
                    return baseMap.addBmLayerBelow(j, bmLayer.e(), 1, 0);
                }
            }
        }
        return false;
    }

    public void animateTo(MapStatus mapStatus, int i, int i2) {
        MapController mapController = this.f9621a;
        if (mapController != null) {
            mapController.setMapStatusWithAnimation(mapStatus, i, i2);
        }
    }

    public void doCaptureMapView(c cVar, Rect rect, Bitmap.Config config) {
        if (rect != null) {
            int i = rect.left;
            int i2 = this.x;
            int i3 = rect.bottom;
            int i4 = i2 < i3 ? 0 : i2 - i3;
            int width = rect.width();
            int height = rect.height();
            if (i < 0 || i4 < 0 || width <= 0 || height <= 0) {
                return;
            }
            if (width > this.w) {
                width = Math.abs(rect.width()) - (rect.right - this.w);
            }
            int i5 = width;
            int abs = height > this.x ? Math.abs(rect.height()) - (rect.bottom - this.x) : height;
            if (i > com.baidu.mapapi.common.SysOSUtil.getScreenSizeX() || i4 > com.baidu.mapapi.common.SysOSUtil.getScreenSizeY()) {
                return;
            }
            this.d.a(cVar, i, i4, i5, abs, config);
            requestRender();
        }
    }

    public void saveScreenToLocal(String str, Rect rect) {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null || cVar.a() == null) {
            return;
        }
        String str2 = null;
        if (rect != null) {
            int i = rect.left;
            int i2 = this.x;
            int i3 = rect.bottom;
            int i4 = i2 < i3 ? 0 : i2 - i3;
            int width = rect.width();
            int height = rect.height();
            if (i < 0 || i4 < 0 || width <= 0 || height <= 0) {
                return;
            }
            if (width > this.w) {
                width = Math.abs(rect.width()) - (rect.right - this.w);
            }
            if (height > this.x) {
                height = Math.abs(rect.height()) - (rect.bottom - this.x);
            }
            if (i <= com.baidu.mapapi.common.SysOSUtil.getScreenSizeX() && i4 <= com.baidu.mapapi.common.SysOSUtil.getScreenSizeY()) {
                if (width != 0 && height != 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("x", i);
                        jSONObject.put("y", i4);
                        jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, width);
                        jSONObject.put("height", height);
                        str2 = jSONObject.toString();
                    } catch (Exception unused) {
                    }
                }
                this.j.a().SaveScreenToLocal(str, str2);
                return;
            }
            this.j.a().SaveScreenToLocal(str, null);
            return;
        }
        this.j.a().SaveScreenToLocal(str, null);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBound(MapBound mapBound, int i, int i2) {
        if (this.f9621a == null) {
            return 0.0f;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("left", mapBound.leftBottomPt.getIntX());
        bundle.putInt("bottom", mapBound.leftBottomPt.getIntY());
        bundle.putInt("right", mapBound.rightTopPt.getIntX());
        bundle.putInt("top", mapBound.rightTopPt.getIntY());
        return this.f9621a.getZoomToBound(bundle, i, i2);
    }

    public synchronized Overlay getOverlay(Class<?> cls) {
        for (Overlay overlay : this.v) {
            if (overlay.getClass() == cls) {
                return overlay;
            }
        }
        return null;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setZoomLevel(int i) {
        setZoomLevel(i);
    }

    @Override // com.baidu.platform.comapi.map.ai
    public void a(Context context, ah.a aVar, boolean z) {
        super.a(context, aVar, z);
        setBackgroundColor(Color.rgb(244, Command.CMD_NOTIFY_FILE_STRUCTURE_CHANGE, 240));
        setPixelFormatTransparent(false);
        this.g = new am();
        this.h = new GestureDetector(context, this.g);
        o oVar = new o((WeakReference<MapSurfaceView>) new WeakReference(this), this);
        this.d = oVar;
        setRenderer(oVar);
        setRenderMode(1);
        this.g.a(new b(this, null));
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("BasicMap surfaceView initView");
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBoundF(MapBound mapBound) {
        SysOSUtil sysOSUtil = SysOSUtil.getInstance();
        return getZoomToBoundF(mapBound, sysOSUtil.getScreenWidth(), sysOSUtil.getScreenHeight());
    }

    public void a() {
        MapController mapController = this.f9621a;
        if (mapController == null || mapController.getBaseMap() == null || this.b == null) {
            return;
        }
        this.v.clear();
        this.b.a();
    }

    public MapSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = true;
        this.q = true;
        this.f9621a = null;
        this.b = null;
        this.c = null;
        this.e = false;
        this.t = true;
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.w = 0;
        this.x = 0;
        this.y = new HashSet<>();
        this.f = true;
        this.z = true;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        s++;
    }

    public MapSurfaceView(Context context, ah.a aVar) {
        super(context, aVar);
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = true;
        this.q = true;
        this.f9621a = null;
        this.b = null;
        this.c = null;
        this.e = false;
        this.t = true;
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.w = 0;
        this.x = 0;
        this.y = new HashSet<>();
        this.f = true;
        this.z = true;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        s++;
    }

    public MapSurfaceView(Context context, ah.a aVar, boolean z) {
        super(context, aVar, z);
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = true;
        this.q = true;
        this.f9621a = null;
        this.b = null;
        this.c = null;
        this.e = false;
        this.t = true;
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.w = 0;
        this.x = 0;
        this.y = new HashSet<>();
        this.f = true;
        this.z = true;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        s++;
    }

    public MapSurfaceView(Context context, boolean z) {
        super(context, z);
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = true;
        this.q = true;
        this.f9621a = null;
        this.b = null;
        this.c = null;
        this.e = false;
        this.t = true;
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.w = 0;
        this.x = 0;
        this.y = new HashSet<>();
        this.f = true;
        this.z = true;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        s++;
    }
}
