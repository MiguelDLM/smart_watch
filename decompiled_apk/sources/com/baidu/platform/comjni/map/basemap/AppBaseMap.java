package com.baidu.platform.comjni.map.basemap;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Surface;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes8.dex */
public class AppBaseMap {
    private NABaseMap b;

    /* renamed from: a, reason: collision with root package name */
    private long f9979a = 0;
    private final ReadWriteLock c = new ReentrantReadWriteLock(true);

    public AppBaseMap() {
        this.b = null;
        this.b = new NABaseMap();
    }

    public static void renderClearShaderCache(String str) {
        NABaseMap.renderClearShaderCache(str);
    }

    public void AddItemData(Bundle bundle) {
        AddItemData(bundle, false);
    }

    public long AddLayer(int i, int i2, String str) {
        return this.b.addLayer(i, i2, str);
    }

    public void AddPopupData(Bundle bundle) {
        this.b.addPopupData(bundle);
    }

    public void AddRtPopData(Bundle bundle) {
        this.b.addRtPopData(bundle);
    }

    public void AddStreetCustomMarker(Bundle bundle, Bitmap bitmap) {
        if (this.f9979a != 0) {
            this.b.addStreetCustomMarker(bundle, bitmap);
        }
    }

    public void BeginLocationLayerAnimation() {
        this.b.beginLocationLayerAnimation();
    }

    public void ClearLayer(long j) {
        this.b.clearLayer(j);
    }

    public void ClearLocationLayerData(Bundle bundle) {
        this.b.clearLocationLayerData(bundle);
    }

    public void ClearMistmapLayer() {
        this.b.clearMistmapLayer();
    }

    public void ClearSDKLayer(long j) {
        this.b.clearSDKLayer(j);
    }

    public boolean CloseCache() {
        return this.b.closeCache();
    }

    public boolean Create() {
        try {
            this.c.writeLock().lock();
            this.f9979a = this.b.create();
            this.c.writeLock().unlock();
            return true;
        } catch (Throwable th) {
            this.c.writeLock().unlock();
            throw th;
        }
    }

    public boolean CreateByDuplicate(long j) {
        long createByDuplicate = this.b.createByDuplicate(j);
        this.f9979a = createByDuplicate;
        if (createByDuplicate != 0) {
            return true;
        }
        return false;
    }

    public long CreateDuplicate() {
        return this.b.createDuplicate();
    }

    public int Draw() {
        if (this.f9979a != 0) {
            return this.b.draw();
        }
        return 0;
    }

    public String GeoPtToScrPoint(int i, int i2) {
        return this.b.geoPtToScrPoint(i, i2);
    }

    public float GetAdapterZoomUnitsEx() {
        return this.b.getAdapterZoomUnitsEx();
    }

    public int GetCacheSize(int i) {
        return this.b.getCacheSize(i);
    }

    public String GetCityInfoByID(int i) {
        return this.b.getCityInfoByID(i);
    }

    public Bundle GetDrawingMapStatus() {
        return this.b.getDrawingMapStatus();
    }

    public float GetFZoomToBoundF(Bundle bundle, Bundle bundle2) {
        return this.b.getFZoomToBoundF(bundle, bundle2);
    }

    public String GetFocusedBaseIndoorMapInfo() {
        if (this.f9979a != 0) {
            return this.b.getFocusedBaseIndoorMapInfo();
        }
        return null;
    }

    public long GetId() {
        return this.f9979a;
    }

    public int GetMapRenderType() {
        return this.b.getMapRenderType();
    }

    public Bundle GetMapStatus(boolean z) {
        return this.b.getMapStatus(z);
    }

    public String GetNearlyObjID(long j, int i, int i2, int i3) {
        return this.b.getNearlyObjID(j, i, i2, i3);
    }

    public int GetVMPMapCityInfo(Bundle bundle) {
        return this.b.getVMPMapCityInfo(bundle);
    }

    public float GetZoomToBound(Bundle bundle, int i, int i2) {
        return this.b.getZoomToBound(bundle, i, i2);
    }

    public float GetZoomToBoundF(Bundle bundle) {
        return this.b.getZoomToBoundF(bundle);
    }

    @Deprecated
    public boolean Init(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2) {
        if (this.f9979a != 0 && this.b.init(str, str2, str3, str4, str5, str6, str7, i, i2, i3, i4, i5, i6, i7, z, z2)) {
            return true;
        }
        return false;
    }

    public boolean IsBaseIndoorMapMode() {
        if (this.f9979a != 0 && this.b.isBaseIndoorMapMode()) {
            return true;
        }
        return false;
    }

    public boolean IsPointInFocusBarBorder(double d, double d2, double d3) {
        if (this.f9979a != 0 && this.b.isPointInFocusBarBorder(d, d2, d3)) {
            return true;
        }
        return false;
    }

    public boolean IsPointInFocusIDRBorder(double d, double d2) {
        if (this.f9979a != 0 && this.b.isPointInFocusIDRBorder(d, d2)) {
            return true;
        }
        return false;
    }

    public boolean IsStreetArrowShown() {
        return this.b.isStreetArrowShown();
    }

    public boolean IsStreetCustomMarkerShown() {
        return this.b.isStreetCustomMarkerShown();
    }

    public boolean IsStreetPOIMarkerShown() {
        if (this.f9979a != 0 && this.b.isStreetPOIMarkerShown()) {
            return true;
        }
        return false;
    }

    public boolean IsStreetRoadClickable() {
        return this.b.isStreetRoadClickable();
    }

    public boolean LayersIsShow(long j) {
        return this.b.layersIsShow(j);
    }

    public void MoveToScrPoint(int i, int i2) {
        this.b.moveToScrPoint(i, i2);
    }

    public void OnBackground() {
        try {
            this.c.readLock().lock();
            if (this.f9979a != 0) {
                this.b.onBackground();
            }
        } finally {
            this.c.readLock().unlock();
        }
    }

    public void OnForeground() {
        try {
            this.c.readLock().lock();
            if (this.f9979a != 0) {
                this.b.onForeground();
            }
        } finally {
            this.c.readLock().unlock();
        }
    }

    public String OnHotcityGet() {
        return this.b.onHotcityGet();
    }

    public void OnPause() {
        try {
            this.c.readLock().lock();
            if (this.f9979a != 0) {
                this.b.onPause();
            }
        } finally {
            this.c.readLock().unlock();
        }
    }

    public boolean OnRecordAdd(int i) {
        return this.b.onRecordAdd(i);
    }

    public String OnRecordGetAll() {
        return this.b.onRecordGetAll();
    }

    public String OnRecordGetAt(int i) {
        return this.b.onRecordGetAt(i);
    }

    public boolean OnRecordImport(boolean z, boolean z2) {
        return this.b.onRecordImport(z, z2);
    }

    public boolean OnRecordReload(int i, boolean z) {
        return this.b.onRecordReload(i, z);
    }

    public boolean OnRecordRemove(int i, boolean z) {
        return this.b.onRecordRemove(i, z);
    }

    public boolean OnRecordStart(int i, boolean z, int i2) {
        return this.b.onRecordStart(i, z, i2);
    }

    public boolean OnRecordSuspend(int i, boolean z, int i2) {
        return this.b.onRecordSuspend(i, z, i2);
    }

    public void OnResume() {
        try {
            this.c.readLock().lock();
            if (this.f9979a != 0) {
                this.b.onResume();
            }
        } finally {
            this.c.readLock().unlock();
        }
    }

    public String OnSchcityGet(String str) {
        return this.b.onSchcityGet(str);
    }

    public boolean OnUsrcityMsgInterval(int i) {
        return this.b.onUsrcityMsgInterval(i);
    }

    public int OnWifiRecordAdd(int i) {
        return this.b.onWifiRecordAdd(i);
    }

    public boolean Release() {
        try {
            this.c.writeLock().lock();
            long j = this.f9979a;
            if (j != 0) {
                BaseMapCallback.release(j);
                this.b.dispose();
                this.f9979a = 0L;
                this.c.writeLock().unlock();
                return true;
            }
            this.c.writeLock().unlock();
            return false;
        } catch (Throwable th) {
            this.c.writeLock().unlock();
            throw th;
        }
    }

    public void Remo() {
    }

    public boolean RemoveItemData(Bundle bundle) {
        return this.b.removeItemData(bundle);
    }

    public void RemoveLayer(long j) {
        this.b.removeLayer(j);
    }

    public void RemoveStreetAllCustomMarker() {
        this.b.removeStreetAllCustomMarker();
    }

    public void RemoveStreetCustomMaker(String str) {
        this.b.removeStreetCustomMaker(str);
    }

    public void ResetImageRes() {
        if (this.f9979a != 0) {
            this.b.resetImageRes();
        }
    }

    public boolean ResumeCache() {
        return this.b.resumeCache();
    }

    public boolean SaveCache() {
        try {
            return this.b.saveCache();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void SaveScreenToLocal(String str, String str2) {
        this.b.saveScreenToLocal(str, str2);
    }

    public String ScrPtToGeoPoint(int i, int i2) {
        return this.b.scrPtToGeoPoint(i, i2);
    }

    public void SetAllStreetCustomMarkerVisibility(boolean z) {
        if (this.f9979a != 0) {
            this.b.setAllStreetCustomMarkerVisibility(z);
        }
    }

    public boolean SetCallback(a aVar) {
        if (aVar != null) {
            long j = this.f9979a;
            if (j != 0 && BaseMapCallback.setMapCallback(j, aVar)) {
                return true;
            }
        }
        return false;
    }

    public void SetFocus(long j, long j2, boolean z, Bundle bundle) {
        this.b.setFocus(j, j2, z, bundle);
    }

    public boolean SetItsPreTime(int i, int i2, int i3) {
        return this.b.setItsPreTime(i, i2, i3);
    }

    public boolean SetLayerSceneMode(long j, int i) {
        return this.b.setLayerSceneMode(j, i);
    }

    public void SetLayersClickable(long j, boolean z) {
        this.b.setLayersClickable(j, z);
    }

    public void SetLocationLayerData(Bundle bundle) {
        this.b.setLocationLayerData(bundle);
    }

    public int SetMapControlMode(int i) {
        return this.b.setMapControlMode(i);
    }

    public void SetMapStatus(Bundle bundle) {
        this.b.setMapStatus(bundle);
    }

    public void SetNewMapStatus(Bundle bundle) {
        this.b.setNewMapStatus(bundle);
    }

    public boolean SetSDKLayerCallback(com.baidu.mapsdkplatform.comjni.a.a.a aVar) {
        if (aVar != null) {
            long j = this.f9979a;
            if (j != 0 && BaseMapCallback.setMapSDKCallback(j, aVar)) {
                return true;
            }
        }
        return false;
    }

    public void SetStreetArrowShow(boolean z) {
        this.b.setStreetArrowShow(z);
    }

    public void SetStreetMarkerClickable(String str, boolean z) {
        this.b.setStreetMarkerClickable(str, z);
    }

    public void SetStreetRoadClickable(boolean z) {
        this.b.setStreetRoadClickable(z);
    }

    public void SetStyleMode(int i) {
        this.b.setStyleMode(i);
    }

    public void SetTargetStreetCustomMarkerVisibility(boolean z, String str) {
        if (this.f9979a != 0) {
            this.b.setTargetStreetCustomMarkerVisibility(z, str);
        }
    }

    public void ShowBaseIndoorMap(boolean z) {
        this.b.showBaseIndoorMap(z);
    }

    public void ShowHotMap(boolean z, int i) {
        this.b.showHotMap(z, i);
    }

    public void ShowLayers(long j, boolean z) {
        if (this.f9979a != 0) {
            this.b.showLayers(j, z);
        }
    }

    public void ShowMistMap(boolean z, String str) {
        this.b.showMistMap(z, str);
    }

    public void ShowSatelliteMap(boolean z) {
        this.b.showSatelliteMap(z);
    }

    public void ShowStreetPOIMarker(boolean z) {
        if (this.f9979a != 0) {
            this.b.showStreetPOIMarker(z);
        }
    }

    public void ShowStreetRoadMap(boolean z) {
        this.b.showStreetRoadMap(z);
    }

    public void ShowTrafficMap(boolean z) {
        this.b.showTrafficMap(z);
    }

    public void StartIndoorAnimation() {
        this.b.startIndoorAnimation();
    }

    public boolean SwitchBaseIndoorMapFloor(String str, String str2) {
        return this.b.switchBaseIndoorMapFloor(str, str2);
    }

    public boolean SwitchLayer(long j, long j2) {
        return this.b.switchLayer(j, j2);
    }

    public void UpdateLayers(long j) {
        this.b.updateLayers(j);
    }

    public void add3DModelIDForFilterList(String str) {
        this.b.add3DModelIDForFilterList(str);
    }

    public boolean addBmLayerBelow(long j, long j2, int i, int i2) {
        return this.b.addBmLayerBelow(j, j2, i, i2);
    }

    public void addOneOverlayItem(Bundle bundle) {
        this.b.addOneOverlayItem(bundle);
    }

    public void addOverlayItems(Bundle[] bundleArr, int i) {
        this.b.addOverlayItems(bundleArr, i);
    }

    public boolean addSDKTileData(Bundle bundle) {
        return this.b.nativeAddTileOverlay(this.f9979a, bundle);
    }

    public void cancelPreload(int i) {
        this.b.cancelPreload(i);
    }

    public boolean cleanCache(int i, boolean z) {
        return this.b.cleanCache(i, z);
    }

    public boolean cleanSDKTileDataCache(long j) {
        return this.b.nativeCleanSDKTileDataCache(this.f9979a, j);
    }

    public void clearFullscreenMaskColor() {
        this.b.clearFullscreenMaskColor();
    }

    public void clearHeatMapLayerCache(long j) {
        NABaseMap nABaseMap = this.b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.clearHeatMapLayerCache(j);
    }

    public void clearUniversalLayer() {
        this.b.clearUniversalLayer();
    }

    public void closeParticleEffect(String str) {
        this.b.closeParticleEffect(str);
    }

    public void closeParticleEffectByType(int i) {
        this.b.closeParticleEffectByType(i);
    }

    public boolean customParticleEffectByType(int i, Bundle bundle) {
        return this.b.customParticleEffectByType(i, bundle);
    }

    public void enablePOIAnimation(boolean z) {
        try {
            this.c.readLock().lock();
            this.b.enablePOIAnimation(z);
        } finally {
            this.c.readLock().unlock();
        }
    }

    public void entryFeedTopic(int i, String str, String str2) {
        this.b.entrySearchTopic(i, str, str2);
    }

    public void entrySearchTopic(int i) {
        this.b.entrySearchTopic(i, "", "");
    }

    public void exitSearchTopic() {
        this.b.exitSearchTopic();
    }

    public void focusTrafficUGCLabel() {
        this.b.focusTrafficUGCLabel();
    }

    public String geoPt3ToScrPoint(int i, int i2, int i3) {
        return this.b.geoPt3ToScrPoint(i, i2, i3);
    }

    public boolean get3DModelEnable() {
        return this.b.get3DModelEnable();
    }

    public boolean getDEMEnable() {
        return this.b.getDEMEnable();
    }

    public float getDpiScale() {
        return this.b.getDpiScale();
    }

    public boolean getDrawHouseHeightEnable() {
        NABaseMap nABaseMap = this.b;
        if (nABaseMap == null) {
            return false;
        }
        return nABaseMap.getDrawHouseHeightEnable();
    }

    public int getFontSizeLevel() {
        return this.b.getFontSizeLevel();
    }

    public long getLayerIDByTag(String str) {
        NABaseMap nABaseMap = this.b;
        if (nABaseMap == null) {
            return 0L;
        }
        return nABaseMap.getLayerIDByTag(str);
    }

    public boolean getMapBarData(Bundle bundle) {
        return this.b.getMapBarData(bundle);
    }

    public int getMapLanguage() {
        NABaseMap nABaseMap = this.b;
        if (nABaseMap == null) {
            return 0;
        }
        return nABaseMap.getMapLanguage();
    }

    public int getMapScene() {
        return this.b.getMapScene();
    }

    public int getMapSceneAttr() {
        return this.b.getMapSceneAttr();
    }

    public Bundle getMapStatusLimits() {
        NABaseMap nABaseMap = this.b;
        if (nABaseMap == null) {
            return null;
        }
        return nABaseMap.getMapStatusLimits();
    }

    public boolean getMapStatusLimitsLevel(int[] iArr) {
        return this.b.getMapStatusLimitsLevel(iArr);
    }

    public int getMapTheme() {
        return this.b.getMapTheme();
    }

    public String getPoiMarkData(int i, int i2, int i3, int i4, boolean z) {
        return this.b.getPoiMarkData(i, i2, i3, i4, z);
    }

    public boolean getPoiTagEnable(int i) {
        return this.b.getPoiTagEnable(i);
    }

    public float[] getProjectionMatrix() {
        NABaseMap nABaseMap = this.b;
        if (nABaseMap == null) {
            return null;
        }
        float[] fArr = new float[16];
        nABaseMap.getProjectMatrix(fArr);
        return fArr;
    }

    public String getProjectionPt(String str) {
        return this.b.getProjectionPt(str);
    }

    public int getScaleLevel(int i, int i2) {
        return this.b.getScaleLevel(i, i2);
    }

    public int getSkyboxStyle() {
        return this.b.getSkyboxStyle();
    }

    public String getStreetRoadNearPointFromCenter(double d, double d2, int i) {
        return this.b.getStreetRoadNearPointFromCenter(d, d2, i);
    }

    public float[] getViewMatrix() {
        NABaseMap nABaseMap = this.b;
        if (nABaseMap == null) {
            return null;
        }
        float[] fArr = new float[16];
        nABaseMap.getViewMatrix(fArr);
        return fArr;
    }

    public boolean importMapTheme(int i) {
        return this.b.importMapTheme(i);
    }

    public boolean initCustomStyle(String str, String str2) {
        NABaseMap nABaseMap = this.b;
        if (nABaseMap == null) {
            return false;
        }
        return nABaseMap.initCustomStyle(str, str2);
    }

    public void initHeatMapData(long j, Bundle bundle) {
        NABaseMap nABaseMap = this.b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.initHeatMapData(j, bundle);
    }

    public boolean initWithOptions(Bundle bundle, boolean z) {
        if (this.f9979a != 0 && this.b.initWithOptions(bundle, z)) {
            return true;
        }
        return false;
    }

    public boolean isAnimationRunning() {
        return this.b.isAnimationRunning();
    }

    public boolean isEnableIndoor3D() {
        return this.b.isEnableIndoor3D();
    }

    public boolean isNaviMode() {
        return this.b.isNaviMode();
    }

    public boolean moveLayerBelowTo(long j, int i) {
        return this.b.moveLayerBelowTo(j, i);
    }

    public boolean performAction(String str) {
        return this.b.performAction(str);
    }

    public boolean preLoad(int i, List<com.baidu.platform.comapi.map.n> list) {
        return this.b.preLoad(i, list);
    }

    public byte[] readMapResData(String str) {
        return this.b.readMapResData(str);
    }

    public void recycleMemory(int i) {
        this.b.recycleMemory(i);
    }

    public boolean releaseFromOfflineMap() {
        try {
            this.c.writeLock().lock();
            if (this.f9979a != 0) {
                this.b.dispose();
                this.f9979a = 0L;
                this.c.writeLock().unlock();
                return true;
            }
            this.c.writeLock().unlock();
            return false;
        } catch (Throwable th) {
            this.c.writeLock().unlock();
            throw th;
        }
    }

    public void remove3DModelIDForFilterList(String str) {
        this.b.remove3DModelIDForFilterList(str);
    }

    public void removeBmLayer(long j) {
        this.b.removeBmLayer(j);
    }

    public void removeOneOverlayItem(Bundle bundle) {
        this.b.removeOneOverlayItem(bundle);
    }

    public void removeOverlayItems(Bundle[] bundleArr) {
        this.b.removeOneOverlayItems(bundleArr);
    }

    public void renderDone() {
        try {
            this.c.readLock().lock();
            this.b.renderDone();
        } finally {
            this.c.readLock().unlock();
        }
    }

    public void renderInit(int i, int i2, Surface surface, int i3) {
        try {
            this.c.readLock().lock();
            this.b.renderInit(i, i2, surface, i3);
        } finally {
            this.c.readLock().unlock();
        }
    }

    public int renderRender() {
        try {
            this.c.readLock().lock();
            return this.b.renderRender();
        } finally {
            this.c.readLock().unlock();
        }
    }

    public void renderResize(int i, int i2) {
        try {
            this.c.readLock().lock();
            this.b.renderResize(i, i2);
        } finally {
            this.c.readLock().unlock();
        }
    }

    public void resize(int i, int i2) {
        if (this.f9979a != 0) {
            this.b.renderResize(i, i2);
        }
    }

    public void set3DModelEnable(boolean z) {
        this.b.set3DModelEnable(z);
    }

    public void setBackgroundColor(int i) {
        this.b.setBackgroundColor(i);
    }

    public void setCustomStyleEnable(boolean z) {
        NABaseMap nABaseMap = this.b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.setCustomStyleEnable(z);
    }

    public void setDEMEnable(boolean z) {
        this.b.setDEMEnable(z);
    }

    public void setDpiScale(float f) {
        this.b.setDpiScale(f);
    }

    public void setDrawHouseHeightEnable(boolean z) {
        NABaseMap nABaseMap = this.b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.setDrawHouseHeightEnable(z);
    }

    public void setEnableIndoor3D(boolean z) {
        this.b.setEnableIndoor3D(z);
    }

    public void setFontSizeLevel(int i) {
        this.b.setFontSizeLevel(i);
    }

    public void setFullscreenMaskColor(int i) {
        this.b.setFullscreenMaskColor(i);
    }

    public void setGlobalLightEnable(boolean z) {
        this.b.setGlobalLightEnable(z);
    }

    public void setHeatMapFrameAnimationIndex(long j, int i) {
        NABaseMap nABaseMap = this.b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.setHeatMapFrameAnimationIndex(j, i);
    }

    public void setMapBackgroundImage(Bundle bundle) {
        this.b.setMapBackgroundImage(bundle);
    }

    public void setMapLanguage(int i) {
        NABaseMap nABaseMap = this.b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.setMapLanguage(i);
    }

    public void setMapScene(int i) {
        this.b.setMapScene(i);
    }

    public boolean setMapSceneAttr(int i) {
        return this.b.setMapSceneAttr(i);
    }

    public void setMapStatusLimits(Bundle bundle) {
        NABaseMap nABaseMap = this.b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.setMapStatusLimits(bundle);
    }

    public boolean setMapStatusLimitsLevel(int i, int i2) {
        return this.b.setMapStatusLimitsLevel(i, i2);
    }

    public boolean setMapTheme(int i, Bundle bundle) {
        return this.b.setMapTheme(i, bundle);
    }

    public boolean setMapThemeScene(int i, int i2, Bundle bundle) {
        return this.b.setMapThemeScene(i, i2, bundle);
    }

    public void setMaxAndMinZoomLevel(Bundle bundle) {
        NABaseMap nABaseMap = this.b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.setMaxAndMinZoomLevel(bundle);
    }

    public void setPoiTagEnable(int i, boolean z) {
        this.b.setPoiTagEnable(i, z);
    }

    public void setRecommendPOIScene(int i) {
        this.b.setRecommendPOIScene(i);
    }

    public void setSkyboxStyle(int i) {
        this.b.setSkyboxStyle(i);
    }

    public void setStreetLayerNewDesignFlag(boolean z) {
        this.b.setStreetLayerNewDesignFlag(z);
    }

    public boolean setTestSwitch(boolean z) {
        return this.b.setTestSwitch(z);
    }

    public void setTrafficUGCData(String str) {
        this.b.setTrafficUGCData(str);
    }

    public void setUniversalFilter(String str) {
        this.b.setUniversalFilter(str);
    }

    public void showFootMarkGrid(boolean z, String str) {
        this.b.showFootMarkGrid(z, str);
    }

    public boolean showParticleEffect(int i) {
        return this.b.showParticleEffect(i);
    }

    public boolean showParticleEffectByName(String str, boolean z) {
        return this.b.showParticleEffectByName(str, z);
    }

    public boolean showParticleEffectByType(int i) {
        return this.b.showParticleEffectByType(i);
    }

    public boolean showParticleEffectByTypeAndPos(int i, float f, float f2, float f3) {
        return this.b.showParticleEffectByTypeAndPos(i, f, f2, f3);
    }

    public boolean showParticleEffectByTypeAndStyleID(int i, int i2) {
        return this.b.showParticleEffectByTypeAndStyleID(i, i2);
    }

    public void showStreetPopup(boolean z) {
        this.b.showStreetPopup(z);
    }

    public void showTrafficUGCMap(boolean z) {
        this.b.showTrafficUGCMap(z);
    }

    public void showUniversalLayer(Bundle bundle) {
        this.b.showUniversalLayer(bundle);
    }

    public void startHeatMapFrameAnimation(long j) {
        NABaseMap nABaseMap = this.b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.startHeatMapFrameAnimation(j);
    }

    public void stopHeatMapFrameAnimation(long j) {
        NABaseMap nABaseMap = this.b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.stopHeatMapFrameAnimation(j);
    }

    public void surfaceDestroyed(Surface surface) {
        try {
            this.c.readLock().lock();
            this.b.surfaceDestroyed(surface);
        } finally {
            this.c.readLock().unlock();
        }
    }

    public void unFocusTrafficUGCLabel() {
        this.b.unFocusTrafficUGCLabel();
    }

    public void updateBaseLayers() {
        this.b.updateBaseLayers();
    }

    public void updateDrawFPS() {
        this.b.updateDrawFPS();
    }

    public void updateFootMarkGrid() {
        this.b.updateFootMarkGrid();
    }

    public void updateHeatMapData(long j, Bundle bundle) {
        NABaseMap nABaseMap = this.b;
        if (nABaseMap == null) {
            return;
        }
        nABaseMap.updateHeatMapData(j, bundle);
    }

    public void updateOneOverlayItem(Bundle bundle) {
        this.b.updateOneOverlayItem(bundle);
    }

    public boolean updateSDKTile(Bundle bundle) {
        return this.b.nativeUpdateSDKTile(this.f9979a, bundle);
    }

    public String worldPointToScreenPoint(float f, float f2, float f3) {
        return this.b.worldPointToScreenPoint(f, f2, f3);
    }

    public void AddItemData(Bundle bundle, boolean z) {
        this.b.addItemData(bundle, z);
    }

    public Bundle GetMapStatus() {
        return this.b.getMapStatus(true);
    }

    public void ShowHotMap(boolean z, int i, String str) {
        this.b.showHotMap(z, i, str);
    }
}
