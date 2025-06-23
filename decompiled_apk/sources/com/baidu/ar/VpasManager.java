package com.baidu.ar;

import com.baidu.ar.baidumap.MapDuMix;
import com.baidu.ar.marker.model.LocationMarkerData;
import java.util.List;

/* loaded from: classes7.dex */
public class VpasManager {
    private NavigationController cw;
    private MapDuMix l;

    public VpasManager(NavigationController navigationController) {
        this.cw = navigationController;
        this.l = navigationController.getMapDuMixInstance();
    }

    public boolean chioceOneCoordinate(LocationMarkerData locationMarkerData) {
        MapDuMix mapDuMix;
        kf.b("VpasManager", "chioceOneCoordinate");
        NavigationController navigationController = this.cw;
        if (navigationController == null || !navigationController.mMapDuMixSetuped || (mapDuMix = this.l) == null || mapDuMix.getMarkerManager() == null) {
            return false;
        }
        this.l.getMarkerManager().choiceOneCoordinate(locationMarkerData);
        this.cw.choseFloor();
        return true;
    }

    public boolean clearRoute() {
        NavigationController navigationController;
        kf.b("VpasManager", "clearRoute");
        if (this.l == null || (navigationController = this.cw) == null || !navigationController.resourceIsCreate() || this.l.getMarkerManager() == null) {
            return false;
        }
        this.l.getMarkerManager().clearRoute();
        this.cw.updateUIByClearRoute();
        return true;
    }

    public boolean hideFinalPoi() {
        NavigationController navigationController;
        kf.b("VpasManager", "hideFinalPoi");
        if (this.l == null || (navigationController = this.cw) == null || !navigationController.resourceIsCreate() || this.l.getMarkerManager() == null) {
            return false;
        }
        this.l.getMarkerManager().hideFinalPoint();
        return true;
    }

    public boolean hideNavigationContent() {
        NavigationController navigationController;
        if (this.l == null || (navigationController = this.cw) == null || !navigationController.resourceIsCreate() || this.l.getMarkerManager() == null) {
            return false;
        }
        this.l.getMarkerManager().hideNavigationContent();
        return true;
    }

    public boolean mockArrow(float f, float f2, float f3, float f4, int i) {
        NavigationController navigationController;
        if (this.l == null || (navigationController = this.cw) == null || !navigationController.resourceIsCreate()) {
            return false;
        }
        this.l.getMarkerManager().postArrow(f, f2, f3, f4, i);
        return false;
    }

    public boolean postArrow(String str, int i, double[] dArr, double[] dArr2, double[] dArr3, float f, float f2) {
        NavigationController navigationController;
        kf.b("VpasManager", "postArrow");
        if (this.l == null || (navigationController = this.cw) == null || !navigationController.resourceIsCreate() || this.l.getMarkerManager() == null) {
            return false;
        }
        this.l.getMarkerManager().postArrow(str, i, dArr, dArr2, dArr3, f, f2);
        return true;
    }

    public boolean postFinalArrow(String str, double[] dArr) {
        NavigationController navigationController;
        kf.b("VpasManager", "postFinalArrow");
        if (this.l == null || (navigationController = this.cw) == null || !navigationController.resourceIsCreate() || this.l.getMarkerManager() == null) {
            return false;
        }
        this.l.getMarkerManager().postFinalArrow(str, dArr);
        return true;
    }

    public boolean postLiftDown(double[] dArr, float f) {
        kf.b("VpasManager", "postLiftDown");
        if (this.l == null || !this.cw.resourceIsCreate() || this.l.getMarkerManager() == null) {
            return false;
        }
        this.l.getMarkerManager().postLiftDown(dArr, f);
        return true;
    }

    public boolean postLiftUp(double[] dArr, float f) {
        NavigationController navigationController;
        kf.b("VpasManager", "postLiftUp");
        if (this.l == null || (navigationController = this.cw) == null || !navigationController.resourceIsCreate() || this.l.getMarkerManager() == null) {
            return false;
        }
        this.l.getMarkerManager().postLiftUp(dArr, f);
        return true;
    }

    public boolean postRouteByList(List<double[]> list) {
        NavigationController navigationController;
        if (list == null || list.size() <= 0 || this.l == null || (navigationController = this.cw) == null || !navigationController.resourceIsCreate() || this.l.getMarkerManager() == null) {
            return false;
        }
        this.l.getMarkerManager().postRoute(list);
        return true;
    }

    public boolean removeAllArrow() {
        NavigationController navigationController;
        kf.b("VpasManager", "removeAllArrow");
        if (this.l == null || (navigationController = this.cw) == null || !navigationController.resourceIsCreate() || this.l.getMarkerManager() == null) {
            return false;
        }
        this.l.getMarkerManager().removeAllArrow();
        return true;
    }

    public boolean removeArrowByArrowId(String str) {
        NavigationController navigationController;
        kf.b("VpasManager", "removeArrowByArrowId");
        if (this.l == null || (navigationController = this.cw) == null || !navigationController.resourceIsCreate() || this.l.getMarkerManager() == null) {
            return false;
        }
        this.l.getMarkerManager().removeArrowByArrowId(str);
        return true;
    }

    public boolean removeLiftDown() {
        NavigationController navigationController;
        if (this.l == null || (navigationController = this.cw) == null || !navigationController.resourceIsCreate() || this.l.getMarkerManager() == null) {
            return false;
        }
        this.l.getMarkerManager().removeLiftDown();
        return true;
    }

    public boolean removeLiftUp() {
        NavigationController navigationController;
        kf.b("VpasManager", "removeLiftUp");
        if (this.l == null || (navigationController = this.cw) == null || !navigationController.resourceIsCreate() || this.l.getMarkerManager() == null) {
            return false;
        }
        this.l.getMarkerManager().removeLiftUp();
        return true;
    }

    public void resetMarkerAR() {
        NavigationController navigationController;
        if (this.l == null || (navigationController = this.cw) == null || !navigationController.resourceIsCreate() || this.l.getMarkerManager() == null) {
            return;
        }
        this.l.getMarkerManager().resetMarker();
    }

    public boolean showNavigationContent() {
        NavigationController navigationController;
        if (this.l == null || (navigationController = this.cw) == null || !navigationController.resourceIsCreate() || this.l.getMarkerManager() == null) {
            return false;
        }
        this.l.getMarkerManager().showNavigationContent();
        return true;
    }
}
