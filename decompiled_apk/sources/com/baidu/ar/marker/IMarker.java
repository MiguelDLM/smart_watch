package com.baidu.ar.marker;

import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.fx;
import com.baidu.ar.fz;
import com.baidu.ar.marker.model.LocationMarkerData;
import com.baidu.ar.marker.model.Segments;
import com.baidu.ar.marker.model.TranslationPrior;
import java.util.List;

/* loaded from: classes7.dex */
public interface IMarker {
    boolean bindingCoordinate();

    void choiceOneCoordinate(LocationMarkerData locationMarkerData);

    void clearNavigationRoute();

    void clearRoute();

    float[] convertLatLngFromPosition(float f, float f2);

    float[] convertPositionFromLatlng(float[] fArr);

    void createSession();

    float[] getGeolocationByTransform();

    void hideFinalPoint();

    void hideNavigationContent();

    void initMarkerByTrackerType(TrackerType trackerType);

    float[] location2ScreenPoint(float[] fArr);

    void openDataMock();

    void openDataRecorde();

    void postARRoute(List<Vector3f> list);

    void postArrow(float f, float f2, float f3, float f4, int i);

    void postArrow(String str, int i, double[] dArr, double[] dArr2, double[] dArr3, float f, float f2);

    void postFinalArrow(String str, double[] dArr);

    void postLiftDown(double[] dArr, float f);

    void postLiftUp(double[] dArr, float f);

    void postNavigationRoute(List<Segments> list);

    void postRoute(List<double[]> list);

    void releaseMarker();

    void removeAllArrow();

    void removeArrowByArrowId(String str);

    void removeLiftDown();

    void removeLiftUp();

    void resetMarker();

    void resetNavigationController();

    void runAREngineWithNavigation(PositioningModuleAddListener positioningModuleAddListener);

    void runImuWithNavigation(PositioningModuleAddListener positioningModuleAddListener);

    void runPedometerWithNavigation(PositioningModuleAddListener positioningModuleAddListener);

    void runVpasWithNavigation(PositioningModuleAddListener positioningModuleAddListener);

    void setAvailableFrame(MarkerFrameInfo markerFrameInfo);

    void setAxisCallback(IMakerAxisCallback iMakerAxisCallback);

    void setCoordinateBoundListener(OnCoordinateBoundListener onCoordinateBoundListener);

    void setEulerAngleCallback(OnEulerAngleCallback onEulerAngleCallback);

    void setLocationTimeCallBack(IMarkerLocationTimeCallBack iMarkerLocationTimeCallBack);

    void setMarkerARSetupCallback(fz fzVar);

    void setMarkerStateListener(IMarkerStateListener iMarkerStateListener);

    void setPositionCallback(fx fxVar);

    void setTrackerSessionCallback(OnTrackerSessionCallback onTrackerSessionCallback);

    void showNavigationContent();

    void test();

    void updateHeading(float f, float f2);

    void updateImuData(float[] fArr);

    void updateLocation(float[] fArr, int i, boolean z);

    void updateMeters(float f);

    void updateMockAccelerometer(float f, float f2, float f3);

    void updateTransformData(int i, float[] fArr);

    void updateTranslationPrior(TranslationPrior translationPrior);
}
