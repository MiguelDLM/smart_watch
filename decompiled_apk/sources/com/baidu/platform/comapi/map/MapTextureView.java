package com.baidu.platform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.jieli.jl_bt_ota.constant.ErrorCode;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* loaded from: classes8.dex */
public class MapTextureView extends GLTextureView implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, MapRenderModeChangeListener, MapViewInterface, aj {

    /* renamed from: a, reason: collision with root package name */
    int f9624a;
    int b;
    private List<BmLayer> c;
    private c d;
    protected List<Overlay> innerOverlayList;
    protected com.baidu.mapsdkplatform.comapi.map.c mBaseMapInner;
    protected GestureDetector mGestureDetector;
    protected MapController mMapController;
    protected k mProjection;
    protected ab mapRenderStableListener;
    protected o mapRenderer;
    protected ae overlayMapCallBack;
    protected am simpleGestureAdapter;

    /* loaded from: classes8.dex */
    public class a implements GLSurfaceView.EGLContextFactory {
        private int b;

        private a() {
            this.b = 12440;
        }

        public void a(String str, int i) {
            throw new RuntimeException(b(str, i));
        }

        public String b(String str, int i) {
            return str + " failed: " + a(i);
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{this.b, 2, 12344});
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                a("eglDestroyContex", egl10.eglGetError());
            }
            MapTextureView.this.onRecycle();
        }

        private String b(int i) {
            return HexStringBuilder.DEFAULT_PREFIX + Integer.toHexString(i);
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
            MapController mapController = MapTextureView.this.mMapController;
            if (mapController != null && mapController.getBaseMap() != null) {
                MapController mapController2 = MapTextureView.this.mMapController;
                if (mapController2.mIsMapLoadFinish) {
                    String GetNearlyObjID = mapController2.getBaseMap().GetNearlyObjID(-1L, (int) motionEvent.getX(), (int) motionEvent.getY(), MapTextureView.this.mMapController.nearlyRadius);
                    GeoPoint geoPoint = null;
                    if (GetNearlyObjID != null && !GetNearlyObjID.equals("")) {
                        MapTextureView mapTextureView = MapTextureView.this;
                        if (mapTextureView.mMapController.mListeners != null) {
                            if (mapTextureView.getProjection() != null) {
                                geoPoint = MapTextureView.this.getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY());
                            }
                            for (ak akVar : MapTextureView.this.mMapController.mListeners) {
                                if (akVar != null) {
                                    if (akVar.b(GetNearlyObjID)) {
                                        MapTextureView.this.mMapController.mHasMapObjDraging = true;
                                    } else if (geoPoint != null) {
                                        akVar.c(geoPoint);
                                    }
                                }
                            }
                            return;
                        }
                        return;
                    }
                    MapTextureView mapTextureView2 = MapTextureView.this;
                    if (mapTextureView2.mMapController.mListeners != null) {
                        if (mapTextureView2.getProjection() != null) {
                            geoPoint = MapTextureView.this.getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY());
                        }
                        if (geoPoint == null) {
                            return;
                        }
                        for (ak akVar2 : MapTextureView.this.mMapController.mListeners) {
                            if (akVar2 != null) {
                                akVar2.c(geoPoint);
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(int i);
    }

    public MapTextureView(Context context) {
        super(context);
        this.mMapController = null;
        this.overlayMapCallBack = null;
        this.mProjection = null;
        this.mapRenderer = null;
        this.c = new ArrayList();
        this.innerOverlayList = new ArrayList();
        a(context);
    }

    private void a(Context context) {
        setEGLContextClientVersion(3);
        this.simpleGestureAdapter = new am();
        this.mGestureDetector = new GestureDetector(context, this.simpleGestureAdapter);
        this.simpleGestureAdapter.a(new b());
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("BasicMap surfaceView initView");
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean addBmLayer(BmLayer bmLayer) {
        return a(0L, bmLayer);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean addBmLayerBelow(Overlay overlay, BmLayer bmLayer) {
        if (overlay != null) {
            return a(overlay.mLayerID, bmLayer);
        }
        return a(0L, bmLayer);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean addOverlay(Overlay overlay) {
        MapController mapController;
        AppBaseMap baseMap;
        if (overlay == null || (mapController = this.mMapController) == null || (baseMap = mapController.getBaseMap()) == null) {
            return false;
        }
        if (overlay instanceof InnerOverlay) {
            InnerOverlay innerOverlay = (InnerOverlay) overlay;
            if (innerOverlay.mBaseMap == null) {
                innerOverlay.mBaseMap = getController().getBaseMap();
            }
            if (!innerOverlay.addedToMapView()) {
                return false;
            }
            this.innerOverlayList.add(overlay);
            this.overlayMapCallBack.a(innerOverlay);
            return true;
        }
        if (overlay instanceof ItemizedOverlay) {
            ItemizedOverlay itemizedOverlay = (ItemizedOverlay) overlay;
            long AddLayer = baseMap.AddLayer(itemizedOverlay.getUpdateType(), 0, "item");
            overlay.mLayerID = AddLayer;
            if (AddLayer == 0) {
                return false;
            }
            this.innerOverlayList.add(overlay);
            itemizedOverlay.a();
            baseMap.SetLayersClickable(overlay.mLayerID, true);
            baseMap.ShowLayers(overlay.mLayerID, true);
            baseMap.UpdateLayers(overlay.mLayerID);
            return true;
        }
        return false;
    }

    public void animateTo(MapStatus mapStatus, int i) {
        MapController mapController = this.mMapController;
        if (mapController != null) {
            mapController.setMapStatusWithAnimation(mapStatus, i);
        }
    }

    public void attachBaseMapController(MapController mapController) {
        o oVar = new o(this, this);
        this.mapRenderer = oVar;
        this.mMapController = mapController;
        oVar.a(mapController.getBaseMap());
        setEGLContextFactory(new a());
        setRenderer(this.mapRenderer);
        setRenderMode(0);
        this.mapRenderer.a(true);
        ae aeVar = new ae(this.mMapController.getBaseMap());
        this.overlayMapCallBack = aeVar;
        this.mMapController.setOverlayMapCallBack(aeVar);
        this.mMapController.setMapViewInterface(this);
        initInnerOverlays();
        this.mMapController.setMapRenderModeChangeListener(this);
        this.mProjection = new k(this.mMapController);
        this.simpleGestureAdapter.a(this.mMapController);
    }

    public void clearInnerOverlays() {
        MapController mapController = this.mMapController;
        if (mapController == null || mapController.getBaseMap() == null || this.overlayMapCallBack == null) {
            return;
        }
        this.innerOverlayList.clear();
        this.overlayMapCallBack.a();
    }

    public void destroyForMultiViews() {
        MapController mapController = this.mMapController;
        if (mapController != null) {
            mapController.unInitForMultiTextureView();
            this.mMapController = null;
        }
        ae aeVar = this.overlayMapCallBack;
        if (aeVar != null) {
            aeVar.a();
            this.overlayMapCallBack = null;
        }
        this.mProjection = null;
    }

    public void doCaptureMapView(com.baidu.platform.comapi.map.c cVar, int i, int i2, Bitmap.Config config) {
        this.mapRenderer.a(cVar, i, i2, config);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean enable3D() {
        return false;
    }

    public com.baidu.mapsdkplatform.comapi.map.c getBaseMap() {
        return this.mBaseMapInner;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public List<BmLayer> getBmlayers() {
        return this.c;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapController getController() {
        return this.mMapController;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus getCurrentMapStatus() {
        MapController mapController = this.mMapController;
        if (mapController != null) {
            return mapController.getCurrentMapStatus();
        }
        return null;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getCurrentZoomLevel() {
        MapController mapController = this.mMapController;
        if (mapController != null) {
            return mapController.getCurrentZoomLevel();
        }
        return 0.0f;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus.GeoBound getGeoRound() {
        MapController mapController = this.mMapController;
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
        MapController mapController = this.mMapController;
        if (mapController == null) {
            return null;
        }
        MapStatus mapStatus = mapController.getMapStatus();
        return new GeoPoint(mapStatus.centerPtY, mapStatus.centerPtX);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getMapRotation() {
        MapController mapController = this.mMapController;
        if (mapController == null) {
            return 0;
        }
        return mapController.getMapStatus().rotation;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus getMapStatus() {
        MapController mapController = this.mMapController;
        if (mapController != null) {
            return mapController.getMapStatus();
        }
        return null;
    }

    public synchronized Overlay getOverlay(int i) {
        for (Overlay overlay : this.innerOverlayList) {
            if (overlay.mType == i) {
                return overlay;
            }
        }
        return null;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public List<Overlay> getOverlays() {
        return this.innerOverlayList;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getOverlooking() {
        MapController mapController = this.mMapController;
        if (mapController == null) {
            return 0;
        }
        return mapController.getMapStatus().overlooking;
    }

    public Overlay getPopupOverlay() {
        return null;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public Projection getProjection() {
        return this.mProjection;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus.WinRound getWinRound() {
        MapController mapController = this.mMapController;
        if (mapController == null) {
            return null;
        }
        return mapController.getMapStatus().winRound;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomLevel() {
        MapController mapController = this.mMapController;
        if (mapController != null) {
            return mapController.getZoomLevel();
        }
        return 0.0f;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBound(MapBound mapBound) {
        return getZoomToBound(mapBound, this.f9624a, this.b);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBoundF(MapBound mapBound, int i, int i2) {
        if (this.mMapController == null) {
            return 0.0f;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("left", mapBound.leftBottomPt.getIntX());
        bundle.putInt("bottom", mapBound.leftBottomPt.getIntY());
        bundle.putInt("right", mapBound.rightTopPt.getIntX());
        bundle.putInt("top", mapBound.rightTopPt.getIntY());
        return this.mMapController.getZoomToBoundF(bundle);
    }

    public void initInnerOverlays() {
        MapController mapController = this.mMapController;
        if (mapController == null || mapController.getBaseMap() == null) {
            return;
        }
        clearInnerOverlays();
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isBaseIndoorMap() {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isSatellite() {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isStreetRoad() {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isTraffic() {
        return false;
    }

    public void listenMapRenderMessage(c cVar) {
        this.d = cVar;
    }

    public void onDestroy() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.mBaseMapInner;
        if (cVar != null) {
            List<ak> list = cVar.h;
            if (list != null) {
                for (ak akVar : list) {
                    if (akVar != null) {
                        akVar.d();
                    }
                }
            }
            this.mBaseMapInner.M();
            this.mBaseMapInner = null;
        }
        this.mMapController.unInit();
        this.mMapController = null;
        this.overlayMapCallBack.a();
        this.overlayMapCallBack = null;
        this.mProjection = null;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        MapController mapController = this.mMapController;
        if (mapController != null && mapController.getBaseMap() != null) {
            MapController mapController2 = this.mMapController;
            if (mapController2.mIsMapLoadFinish) {
                String GetNearlyObjID = mapController2.getBaseMap().GetNearlyObjID(-1L, (int) motionEvent.getX(), (int) motionEvent.getY(), this.mMapController.nearlyRadius);
                GeoPoint geoPoint = null;
                if (GetNearlyObjID != null && !GetNearlyObjID.equals("")) {
                    if (this.mMapController.mListeners != null) {
                        if (getProjection() != null) {
                            geoPoint = getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY());
                        }
                        for (ak akVar : this.mMapController.mListeners) {
                            if (akVar != null) {
                                if (akVar.b(GetNearlyObjID)) {
                                    this.mMapController.mHasMapObjDraging = true;
                                } else if (geoPoint != null) {
                                    akVar.c(geoPoint);
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                if (this.mMapController.mListeners != null) {
                    if (getProjection() != null) {
                        geoPoint = getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY());
                    }
                    if (geoPoint == null) {
                        return;
                    }
                    for (ak akVar2 : this.mMapController.mListeners) {
                        if (akVar2 != null) {
                            akVar2.c(geoPoint);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.MapRenderModeChangeListener
    public void onMapRenderModeChange(int i) {
        ab abVar;
        c cVar = this.d;
        if (cVar != null) {
            cVar.a(i);
        }
        if (i == 1) {
            requestRender();
            return;
        }
        if (i == 0) {
            if (getRenderMode() != 0) {
                setRenderMode(0);
            }
        } else if (i == 2 && (abVar = this.mapRenderStableListener) != null) {
            abVar.a();
        }
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView
    public void onPause() {
        MapController mapController = this.mMapController;
        if (mapController != null) {
            mapController.getBaseMap().OnPause();
        }
        super.onPause();
    }

    public void onRecycle() {
        MapController mapController = this.mMapController;
        if (mapController != null && mapController.getBaseMap() != null) {
            this.mMapController.getBaseMap().ResetImageRes();
        }
    }

    @Override // com.baidu.platform.comapi.map.MapRenderModeChangeListener
    public void onRequestRender() {
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView
    public void onResume() {
        MapController mapController = this.mMapController;
        if (mapController != null) {
            mapController.getBaseMap().OnResume();
        }
        super.onResume();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        super.onSurfaceTextureAvailable(surfaceTexture, i, i2);
        this.f9624a = i;
        this.b = i2;
        MapController mapController = this.mMapController;
        if (mapController != null) {
            if (mapController.getMapViewSurfaceListener() != null) {
                this.mMapController.getMapViewSurfaceListener().onSurfaceChanged(i, i2);
            }
            MapStatus mapStatus = getMapStatus();
            MapStatus.WinRound winRound = mapStatus.winRound;
            this.f9624a = Math.abs(winRound.right - winRound.left);
            MapStatus.WinRound winRound2 = mapStatus.winRound;
            this.b = Math.abs(winRound2.bottom - winRound2.top);
        }
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.mBaseMapInner;
        if (cVar != null) {
            cVar.a(this.f9624a, this.b);
        }
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        super.onSurfaceTextureDestroyed(surfaceTexture);
        return true;
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        super.onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        this.f9624a = i;
        this.b = i2;
        o oVar = this.mapRenderer;
        oVar.f9668a = i;
        oVar.b = i2;
        oVar.c = 0;
        if (this.mMapController != null) {
            MapStatus mapStatus = getMapStatus();
            MapStatus.WinRound winRound = mapStatus.winRound;
            winRound.left = 0;
            winRound.top = 0;
            winRound.bottom = i2;
            winRound.right = i;
            this.mMapController.setMapStatusWithAnimation(mapStatus, 4, 0);
            if (this.mMapController.getMapViewSurfaceListener() != null) {
                this.mMapController.getMapViewSurfaceListener().onSurfaceChanged(i, i2);
            }
            MapStatus mapStatus2 = getMapStatus();
            MapStatus.WinRound winRound2 = mapStatus2.winRound;
            int abs = Math.abs(winRound2.right - winRound2.left);
            MapStatus.WinRound winRound3 = mapStatus2.winRound;
            int abs2 = Math.abs(winRound3.bottom - winRound3.top);
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("MapTextureView winRoundWidth = " + abs + ";winRoundHeight = " + abs2 + ";mWidth = " + this.f9624a + ";mHeight = " + this.b);
            }
            if (abs > 0 && abs2 > 0) {
                this.f9624a = abs;
                this.b = abs2;
            }
            this.mMapController.setScreenSize(this.f9624a, this.b);
        }
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.mBaseMapInner;
        if (cVar != null) {
            cVar.a(this.f9624a, this.b);
        }
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        super.onSurfaceTextureUpdated(surfaceTexture);
    }

    @Override // android.view.View, com.baidu.platform.comapi.map.MapViewInterface
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MapStatus mapStatus = getMapStatus();
        if (mapStatus == null) {
            return false;
        }
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int x = (int) motionEvent.getX(i);
            int y = (int) motionEvent.getY(i);
            MapStatus.WinRound winRound = mapStatus.winRound;
            if (x < winRound.left || x > winRound.right || y < winRound.top || y > winRound.bottom) {
                return false;
            }
        }
        try {
            GestureDetector gestureDetector = this.mGestureDetector;
            if (gestureDetector != null && gestureDetector.onTouchEvent(motionEvent)) {
                return true;
            }
            MapController mapController = this.mMapController;
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

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void refresh(Overlay overlay) {
        if (overlay != null && this.mMapController != null) {
            if (overlay instanceof ItemizedOverlay) {
                ItemizedOverlay itemizedOverlay = (ItemizedOverlay) overlay;
                if (itemizedOverlay.b()) {
                    if (itemizedOverlay.getAllItem().size() <= 0) {
                        this.mMapController.getBaseMap().ClearLayer(overlay.mLayerID);
                        this.mMapController.getBaseMap().ShowLayers(overlay.mLayerID, false);
                        this.mMapController.getBaseMap().UpdateLayers(overlay.mLayerID);
                    } else {
                        this.mMapController.getBaseMap().ShowLayers(overlay.mLayerID, true);
                        this.mMapController.getBaseMap().UpdateLayers(overlay.mLayerID);
                    }
                    itemizedOverlay.a(false);
                }
            }
            MapController mapController = this.mMapController;
            if (mapController != null && mapController.getBaseMap() != null) {
                this.mMapController.getBaseMap().UpdateLayers(overlay.mLayerID);
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public synchronized boolean removeBmLayer(BmLayer bmLayer) {
        if (bmLayer != null) {
            MapController mapController = this.mMapController;
            if (mapController != null) {
                AppBaseMap baseMap = mapController.getBaseMap();
                if (baseMap == null) {
                    return false;
                }
                baseMap.removeBmLayer(bmLayer.e());
                synchronized (this) {
                    this.c.remove(bmLayer);
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean removeOverlay(Overlay overlay) {
        MapController mapController;
        AppBaseMap baseMap;
        if (overlay == null || (mapController = this.mMapController) == null || (baseMap = mapController.getBaseMap()) == null) {
            return false;
        }
        baseMap.ClearLayer(overlay.mLayerID);
        baseMap.ShowLayers(overlay.mLayerID, false);
        baseMap.UpdateLayers(overlay.mLayerID);
        baseMap.RemoveLayer(overlay.mLayerID);
        if (overlay instanceof ItemizedOverlay) {
            this.innerOverlayList.remove(overlay);
        } else if (overlay instanceof InnerOverlay) {
            this.innerOverlayList.remove(overlay);
            this.overlayMapCallBack.a(overlay);
        }
        overlay.mLayerID = 0L;
        return true;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void saveScreenToLocal(String str) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setBaseIndoorMap(boolean z) {
    }

    public void setBaseMap(com.baidu.mapsdkplatform.comapi.map.c cVar) {
        this.mBaseMapInner = cVar;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setGeoRound(MapStatus.GeoBound geoBound) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapCenter(GeoPoint geoPoint) {
        MapController mapController = this.mMapController;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.centerPtX = geoPoint.getLongitude();
            mapStatus.centerPtY = geoPoint.getLatitude();
            this.mMapController.setMapStatus(mapStatus);
        }
    }

    public void setMapRenderStableListener(ab abVar) {
        this.mapRenderStableListener = abVar;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapStatus(MapStatus mapStatus) {
        MapController mapController = this.mMapController;
        if (mapController != null) {
            mapController.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapTo2D(boolean z) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setOverlooking(int i) {
        MapController mapController = this.mMapController;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.overlooking = i;
            this.mMapController.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setRotation(int i) {
        MapController mapController = this.mMapController;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.rotation = i;
            this.mMapController.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setSatellite(boolean z) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setStreetRoad(boolean z) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setTraffic(boolean z) {
        AppBaseMap baseMap;
        MapController mapController = this.mMapController;
        if (mapController != null && (baseMap = mapController.getBaseMap()) != null) {
            baseMap.ShowTrafficMap(z);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setWinRound(MapStatus.WinRound winRound) {
        MapController mapController = this.mMapController;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.winRound = winRound;
            this.mMapController.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setZoomLevel(float f) {
        if (this.mMapController == null) {
            return;
        }
        getController().getFocusedBaseIndoorMapInfo();
        if (f < 4.0f) {
            f = 4.0f;
        } else if (f > 22) {
            f = 22.0f;
        }
        MapStatus mapStatus = getMapStatus();
        if (mapStatus != null) {
            mapStatus.level = f;
            animateTo(mapStatus, 300);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean switchOverlay(Overlay overlay, Overlay overlay2) {
        MapController mapController;
        AppBaseMap baseMap;
        if (overlay == null || overlay2 == null || (mapController = this.mMapController) == null || (baseMap = mapController.getBaseMap()) == null) {
            return false;
        }
        return baseMap.SwitchLayer(overlay.mLayerID, overlay2.mLayerID);
    }

    public void unListenMapRenderMessage() {
        this.d = null;
    }

    public void doCaptureMapView(com.baidu.platform.comapi.map.c cVar, Rect rect, Bitmap.Config config) {
        if (rect != null) {
            int i = rect.left;
            int i2 = this.b;
            int i3 = rect.bottom;
            int i4 = i2 < i3 ? 0 : i2 - i3;
            int width = rect.width();
            int height = rect.height();
            if (i < 0 || i4 < 0 || width <= 0 || height <= 0) {
                return;
            }
            if (width > this.f9624a) {
                width = Math.abs(rect.width()) - (rect.right - this.f9624a);
            }
            int i5 = width;
            int abs = height > this.b ? Math.abs(rect.height()) - (rect.bottom - this.b) : height;
            if (i > SysOSUtil.getScreenSizeX() || i4 > SysOSUtil.getScreenSizeY()) {
                return;
            }
            this.mapRenderer.a(cVar, i, i4, i5, abs, config);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBound(MapBound mapBound, int i, int i2) {
        if (this.mMapController == null) {
            return 0.0f;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("left", mapBound.leftBottomPt.getIntX());
        bundle.putInt("bottom", mapBound.leftBottomPt.getIntY());
        bundle.putInt("right", mapBound.rightTopPt.getIntX());
        bundle.putInt("top", mapBound.rightTopPt.getIntY());
        return this.mMapController.getZoomToBound(bundle, i, i2);
    }

    public boolean addBmLayerBelow(long j, BmLayer bmLayer) {
        return a(j, bmLayer);
    }

    public synchronized Overlay getOverlay(Class<?> cls) {
        for (Overlay overlay : this.innerOverlayList) {
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

    private synchronized boolean a(long j, BmLayer bmLayer) {
        if (bmLayer != null) {
            MapController mapController = this.mMapController;
            if (mapController != null) {
                AppBaseMap baseMap = mapController.getBaseMap();
                if (baseMap == null) {
                    return false;
                }
                synchronized (this) {
                    if (this.c.contains(bmLayer)) {
                        return false;
                    }
                    this.c.add(bmLayer);
                    return baseMap.addBmLayerBelow(j, bmLayer.e(), 1, 0);
                }
            }
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBoundF(MapBound mapBound) {
        return getZoomToBoundF(mapBound, this.f9624a, this.b);
    }

    public MapTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMapController = null;
        this.overlayMapCallBack = null;
        this.mProjection = null;
        this.mapRenderer = null;
        this.c = new ArrayList();
        this.innerOverlayList = new ArrayList();
        a(context);
    }

    public MapTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMapController = null;
        this.overlayMapCallBack = null;
        this.mProjection = null;
        this.mapRenderer = null;
        this.c = new ArrayList();
        this.innerOverlayList = new ArrayList();
        a(context);
    }
}
