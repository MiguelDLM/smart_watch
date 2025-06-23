package com.baidu.navisdk.jni.nativeif;

import android.os.Bundle;
import com.baidu.nplatform.comjni.map.basemap.BaseMapCallback;
import com.baidu.nplatform.comjni.map.basemap.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class JNIBaseMap {
    private BaseMapCallback mCallback;

    public JNIBaseMap() {
        this.mCallback = null;
        BaseMapCallback baseMapCallback = new BaseMapCallback();
        this.mCallback = baseMapCallback;
        SetCallback(baseMapCallback);
    }

    public static native void ColladaDraw();

    public static native void ColladaEnable(boolean z);

    public static native void ColladaInit(int i, int i2, int i3, int i4);

    public static native boolean ColladaModuleInit(String str);

    public static native void ColladaModuleUnload();

    public static native void ColladaResize(int i, int i2);

    public static native int GLDraw();

    public static native int GLDrawMinimap();

    public static native void GLInit();

    public static native void GLResize(int i, int i2, int i3, int i4, int i5);

    public static native void MinimapGLResize(int i, int i2, int i3, int i4, int i5);

    @Deprecated
    public static native void UpdateNeedRender(boolean z);

    public static native void initMiniMapControl(int i, int i2);

    public static native void notifyOrientation(boolean z);

    public static native void setDynamicEffects(boolean z);

    public native void AddItemData(Object obj);

    public native int AddLayer(int i, int i2, String str);

    public native boolean AddPopupData(Object obj);

    public native boolean AnimationTo(int i, boolean z, int i2, int i3, int i4, int i5, int i6);

    public native boolean CancelMapJump();

    public native int CleanAfterDBClick(float f, float f2);

    public native boolean ClearLayer(int i);

    public native boolean ClearLayerByID(int i);

    public native void DragMap(int i, int i2, int i3, int i4, long j, long j2);

    public native boolean EnterStreetScapeMap();

    public native boolean EnterStreetScapeWaitingMode();

    public native boolean ExitStreetScapeMap();

    public native boolean FocusItem(int i, int i2, boolean z);

    public native String GetCurrentStreetId();

    public native boolean GetCurrentStreetInfo(Object obj, String str);

    public native boolean GetGeoPosByScreenPos(int i, int i2, int[] iArr, int[] iArr2);

    public boolean GetMapStatus(Object obj) {
        return GetMapStatus(obj, true);
    }

    public native boolean GetMapStatus(Object obj, boolean z);

    public native boolean GetNearlyObjIDStreet(int i, long j, long j2, Object obj, int i2);

    public native boolean GetScreenMask(int i, int i2, int i3, int i4, boolean z, Object obj);

    public native boolean GetScreenPosByGeoPos(int i, int i2, int[] iArr, int[] iArr2);

    public native boolean GetScreenShot(int i, int i2, int i3, Object obj);

    public native float GetZoomLevel();

    public native float GetZoomToBound(Object obj, float f, float f2);

    public native boolean ImportVmpMapRecord();

    public native boolean IsInStreepScapeMode();

    public native boolean LayerIsShow(int i);

    public native boolean Locate(int i, int i2);

    public native int MapProc(int i, int i2, int i3, int i4, int i5, double d, double d2, double d3, double d4);

    public native boolean MouseEvent(int i, int i2, int i3);

    public native boolean Move(int i, int i2, int i3, int i4);

    public native boolean MoveTo(int i, int i2);

    public native void OnPause();

    public native void OnResume();

    public native boolean QueryThumbImage(String str);

    public native boolean ReleaseSharedMapData(int i, int i2);

    public native boolean RemoveItemData(Object obj);

    public native int RemoveLayer(int i);

    public native boolean RemoveVmpMapRecord(int i);

    public native boolean ResetCompassPosition(int i, int i2, int i3);

    public native void ResetGLHandleWhenCreateOrDestroyContext(boolean z);

    public native boolean ResetImageRes();

    public native boolean ResetScalePosition(int i, int i2);

    public native void SaveCache();

    public native boolean SaveScreen(String str);

    public native boolean SaveScreenToBuffer();

    public native String ScrPtToGeoPoint(int i, int i2);

    public native Object SelectItem(int i, int i2, int i3);

    public native boolean SetAnimationGlobalSwitch(boolean z);

    public native int SetCallback(Object obj);

    public native boolean SetCarLogoVisible(boolean z);

    public native boolean SetCharsetEncodeType(boolean z);

    public native void SetCompassVisible(boolean z);

    public native boolean SetDrawHouse(boolean z, boolean z2);

    public native void SetDrawNaviLogo(boolean z);

    public native void SetEnlargedStatus(boolean z);

    public native void SetIfInterruptAutoLevel(boolean z);

    public native boolean SetLevel(float f);

    public native void SetMapFuncInfo(int i, Bundle bundle);

    public native boolean SetMapFuncTruckUgcInfo(int[] iArr, boolean z);

    public boolean SetMapLayerDataCallback(a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.mCallback.SetMapCallback(aVar);
    }

    public native boolean SetMapStatus(Object obj);

    public native void SetMemoryScale(int i);

    public native boolean SetMinimapWinSize(int i, int i2);

    public native boolean SetPreRoutePlanStatus(boolean z);

    public native void SetShowTrackBrake(boolean z);

    public native void SetShowTrackCurve(boolean z);

    public native void SetShowTrackMaxSpeed(boolean z);

    public native void SetShowTrackOverSpeed(boolean z);

    public native void SetShowTrackRapidAcc(boolean z);

    public native void SetStrategyVisible(boolean z);

    public native boolean SetStreetPOIUID(String str);

    @Deprecated
    public native boolean SetStyleMode(int i);

    public native boolean ShowLayer(int i, boolean z);

    public native boolean ShowLayerByID(int i, boolean z);

    public native void ShowTrafficMap(boolean z, boolean z2);

    public native void StartMapDataRequest();

    public native void StopMapDataRequest();

    public native void SwitchITSMode(boolean z);

    public native boolean SwitchStreetScapeWithStreedId(String str);

    public native boolean SwitchToStreetScapeWithUID(String str, String str2);

    public native boolean UpdataBaseLayers();

    public native void UpdateChosenMultiRouteID(int i);

    public native boolean UpdateLayer(int i);

    public native boolean UpdateLayerByID(int i);

    public native boolean UpdateShareMapData(int i, int i2);

    public native boolean Zoom(float f);

    public native boolean ZoomIn();

    public native boolean ZoomInByPos(int i, int i2);

    public native boolean ZoomOut();

    public native boolean ZoomOutByPos(int i, int i2);

    public native boolean ZoomToBound(Object obj);

    public native void ZoomToFullView(Object obj);

    public native boolean ZoomToTrajectory();

    public native boolean allViewSerialAnimation();

    public native void awakeDrawWaitEvent();

    public native boolean checkMapViewCameraAvailable(long j);

    public native int clearCarImage();

    public native void createMiniMapControl();

    public native void destroyMiniMapControl();

    public native void dynamicWindowChange(int i, int i2, int i3);

    public native void dynamicWindowDraw(int i);

    public native boolean dynamicWindowInit(int i, Bundle bundle);

    public native void dynamicWindowShutDown(int i);

    public native void enterCarPlayMode(long j);

    public native void exitCarPlayMode();

    public native void focusMGDataset(int i, int i2, long[] jArr, int[] iArr);

    public native void focusMGDatasetBySid(int i, int i2, String[] strArr);

    public native float getDpiScale(long j);

    public native boolean getRouteInfoInUniform(Bundle bundle);

    public native boolean getScreenShotImage(Bundle bundle);

    public native int getStyleMode();

    public native boolean initMiniRenderEngine(int i, int i2, int i3);

    public native void mapClickEvent(int i);

    public native boolean preNextRouteDetail(boolean z);

    public native boolean resetRouteDetailIndex(boolean z);

    public native void sendCommandToMapEngine(int i, Bundle bundle);

    public native int set2DCarLogo(int i);

    public native boolean set3DCarLogoToMap(String str, String str2);

    public native boolean set3DCarToMap(List<Bundle> list);

    public native boolean setACEParkViewMode(int i);

    public native void setAutoLevelEnable(boolean z);

    public native boolean setBarrageInfo(Bundle bundle);

    public native int setCarImageToMap(int i, int i2, int i3, byte[] bArr, int i4);

    @Deprecated
    public native void setClientBoardLength(int i);

    public native boolean setDIYDataToMap(int i, String str, String str2);

    public native boolean setDIYImageToMap(List<Bundle> list, int[] iArr);

    @Deprecated
    public native boolean setDefaultCarLogo();

    public native void setDpiScale(long j, float f);

    public native boolean setDragMapStatus(boolean z);

    public native boolean setDynamicLayerShowKeys(int[] iArr);

    public native void setDynamicWindowShowSize(int i, int i2, int i3, int i4, int i5);

    public native void setEndNodeIconVisible(boolean z);

    public native boolean setEndNodeNameVisible(boolean z);

    public native boolean setHdDataToMap(Bundle bundle);

    public native void setHighLightRoute(int i, int i2);

    public native boolean setInterruptOverviewAutoZoom(boolean z);

    public native void setLabelBreathing(int i, boolean z);

    public native boolean setLimitFrame(int i);

    public native void setMGDataset(int i, ArrayList<Bundle> arrayList);

    public native void setMap2DLook(boolean z);

    public native boolean setMapClickInfo(boolean z);

    public native void setMapDrawScreenRect(Object obj);

    public native boolean setMapForceSwitchStrategy(boolean z);

    public native boolean setMapFuncInfoFastRoute(boolean z, int i, int i2, int i3);

    public native boolean setMapFuncInfoMapClass(int i, Bundle bundle);

    public native boolean setMapFuncInfoMapStrategy(int i, Bundle bundle);

    public native boolean setMapFuncInfoPartRouteZoom(boolean z, int i, int i2, int i3);

    public native boolean setMapFuncTruckLimitInfo(int[] iArr, boolean z);

    public native boolean setMapJamClickInfo(boolean z, int i, int i2, String str, String str2);

    public native boolean setMapJamClickInfoToMap(Bundle bundle);

    public native void setMapPoiScene(boolean z);

    public native void setMapShowScreenRect(long j, long j2, long j3, long j4);

    public native boolean setMapTrafficLightClickInfo(boolean z, String str, int i);

    public native boolean setNaviCarPos();

    public native boolean setNaviMapMode(int i);

    public native boolean setNaviStatus(boolean z);

    public native boolean setNightMode(boolean z);

    public native boolean setPreFinishStatus(boolean z);

    public native boolean setQuitMossPartZoom(boolean z);

    public native void setRealGraphInfo(Bundle bundle);

    public native boolean setRedLineRender(boolean z);

    public native boolean setRouteDetailIndex(int i);

    public native boolean setRouteSearchStatus(boolean z);

    public native boolean setScreenShotParam(int i, int i2, int i3, long j, long j2, int i4);

    public native boolean setScreenShow(Bundle bundle);

    public native boolean setSimpleModeGuide(boolean z);

    public native void setSlightModeZoomToFullView();

    public native boolean setSlightScreenStatus(int i);

    @Deprecated
    public native void setTranslucentHeight(int i);

    public native boolean setUIViewBound(ArrayList<Bundle> arrayList, int i);

    public native void showMGDataset(int i, int i2, long[] jArr, int[] iArr);

    public native void showMGDatasetBySid(int i, int i2, String[] strArr);

    public native boolean stopAllAnimation();

    public native void zoomMGDataset(int i, int i2, long[] jArr, int[] iArr, int i3, int i4);

    public native void zoomMGDatasetBySid(int i, int i2, String[] strArr, int[] iArr, int i3, int i4);

    public native void zoomToSlightNaviFullView(Bundle bundle, boolean z);

    public JNIBaseMap(Boolean bool) {
        this.mCallback = null;
    }
}
