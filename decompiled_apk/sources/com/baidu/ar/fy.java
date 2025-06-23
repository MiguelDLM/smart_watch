package com.baidu.ar;

import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.marker.IMakerAxisCallback;
import com.baidu.ar.marker.IMarker;
import com.baidu.ar.marker.IMarkerLocationTimeCallBack;
import com.baidu.ar.marker.IMarkerStateListener;
import com.baidu.ar.marker.MarkerFrameInfo;
import com.baidu.ar.marker.OnCoordinateBoundListener;
import com.baidu.ar.marker.OnEulerAngleCallback;
import com.baidu.ar.marker.OnTrackerSessionCallback;
import com.baidu.ar.marker.PositioningModuleAddListener;
import com.baidu.ar.marker.TrackerType;
import com.baidu.ar.marker.model.LocationMarkerData;
import com.baidu.ar.marker.model.Segments;
import com.baidu.ar.marker.model.TranslationPrior;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes7.dex */
public class fy extends e implements IMarker {
    private OnEulerAngleCallback cP;
    private OnCoordinateBoundListener df;
    private PositioningModuleAddListener ds;
    private IMarkerLocationTimeCallBack iMarkerLocationTimeCallBack;
    private fx iMarkerPositionCallback;
    private IMarkerStateListener iMarkerStateListener;
    private OnTrackerSessionCallback mOnTrackerSessionCallback;
    private WeakReference<IMarker> tO;
    private IMakerAxisCallback tP;
    private fz tQ;
    private int tR;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.ar.e
    public void a(d dVar) {
        WeakReference<IMarker> weakReference;
        if (dVar instanceof IMarker) {
            WeakReference<IMarker> weakReference2 = new WeakReference<>((IMarker) dVar);
            this.tO = weakReference2;
            if (this.iMarkerStateListener != null) {
                weakReference2.get().setMarkerStateListener(this.iMarkerStateListener);
            }
            if (this.mOnTrackerSessionCallback != null) {
                this.tO.get().setTrackerSessionCallback(this.mOnTrackerSessionCallback);
            }
            if (this.tP != null) {
                this.tO.get().setAxisCallback(this.tP);
            }
            if (this.iMarkerLocationTimeCallBack != null) {
                this.tO.get().setLocationTimeCallBack(this.iMarkerLocationTimeCallBack);
            }
            if (this.cP != null) {
                this.tO.get().setEulerAngleCallback(this.cP);
            }
            if (this.ds != null) {
                int i = this.tR;
                if (i == 1) {
                    this.tO.get().runAREngineWithNavigation(this.ds);
                } else if (i == 2) {
                    this.tO.get().runVpasWithNavigation(this.ds);
                } else if (i == 3) {
                    this.tO.get().runImuWithNavigation(this.ds);
                } else if (i == 4) {
                    this.tO.get().runPedometerWithNavigation(this.ds);
                }
            }
            if (this.tQ != null) {
                this.tO.get().setMarkerARSetupCallback(this.tQ);
            }
            if (this.iMarkerPositionCallback != null) {
                this.tO.get().setPositionCallback(this.iMarkerPositionCallback);
            }
            if (this.df == null || (weakReference = this.tO) == null || weakReference.get() == null) {
                return;
            }
            this.tO.get().setCoordinateBoundListener(this.df);
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public boolean bindingCoordinate() {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return this.tO.get().bindingCoordinate();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void choiceOneCoordinate(LocationMarkerData locationMarkerData) {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().choiceOneCoordinate(locationMarkerData);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void clearNavigationRoute() {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().clearNavigationRoute();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void clearRoute() {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().clearRoute();
    }

    @Override // com.baidu.ar.marker.IMarker
    public float[] convertLatLngFromPosition(float f, float f2) {
        WeakReference<IMarker> weakReference = this.tO;
        return (weakReference == null || weakReference.get() == null) ? new float[2] : this.tO.get().convertLatLngFromPosition(f, f2);
    }

    @Override // com.baidu.ar.marker.IMarker
    public float[] convertPositionFromLatlng(float[] fArr) {
        WeakReference<IMarker> weakReference = this.tO;
        return (weakReference == null || weakReference.get() == null) ? new float[2] : this.tO.get().convertPositionFromLatlng(fArr);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void createSession() {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().createSession();
    }

    @Override // com.baidu.ar.marker.IMarker
    public float[] getGeolocationByTransform() {
        WeakReference<IMarker> weakReference = this.tO;
        return (weakReference == null || weakReference.get() == null) ? new float[2] : this.tO.get().getGeolocationByTransform();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void hideFinalPoint() {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().hideFinalPoint();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void hideNavigationContent() {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().hideNavigationContent();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void initMarkerByTrackerType(TrackerType trackerType) {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().initMarkerByTrackerType(trackerType);
    }

    @Override // com.baidu.ar.marker.IMarker
    public float[] location2ScreenPoint(float[] fArr) {
        WeakReference<IMarker> weakReference = this.tO;
        return (weakReference == null || weakReference.get() == null) ? new float[0] : this.tO.get().location2ScreenPoint(fArr);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void openDataMock() {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().openDataMock();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void openDataRecorde() {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().openDataRecorde();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postARRoute(List<Vector3f> list) {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().postARRoute(list);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postArrow(float f, float f2, float f3, float f4, int i) {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().postArrow(f, f2, f3, f4, i);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postFinalArrow(String str, double[] dArr) {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().postFinalArrow(str, dArr);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postLiftDown(double[] dArr, float f) {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().postLiftDown(dArr, f);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postLiftUp(double[] dArr, float f) {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().postLiftUp(dArr, f);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postNavigationRoute(List<Segments> list) {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().postNavigationRoute(list);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postRoute(List<double[]> list) {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().postRoute(list);
    }

    @Override // com.baidu.ar.e
    public void release() {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.clear();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void releaseMarker() {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().releaseMarker();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void removeAllArrow() {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().removeAllArrow();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void removeArrowByArrowId(String str) {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().removeArrowByArrowId(str);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void removeLiftDown() {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().removeLiftDown();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void removeLiftUp() {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().removeLiftUp();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void resetMarker() {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().resetMarker();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void resetNavigationController() {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().resetNavigationController();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void runAREngineWithNavigation(PositioningModuleAddListener positioningModuleAddListener) {
        this.tR = 1;
        this.ds = positioningModuleAddListener;
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().runAREngineWithNavigation(positioningModuleAddListener);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void runImuWithNavigation(PositioningModuleAddListener positioningModuleAddListener) {
        this.tR = 3;
        this.ds = positioningModuleAddListener;
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().runImuWithNavigation(positioningModuleAddListener);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void runPedometerWithNavigation(PositioningModuleAddListener positioningModuleAddListener) {
        this.tR = 4;
        this.ds = positioningModuleAddListener;
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().runPedometerWithNavigation(positioningModuleAddListener);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void runVpasWithNavigation(PositioningModuleAddListener positioningModuleAddListener) {
        this.ds = positioningModuleAddListener;
        this.tR = 2;
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().runVpasWithNavigation(positioningModuleAddListener);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setAvailableFrame(MarkerFrameInfo markerFrameInfo) {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().setAvailableFrame(markerFrameInfo);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setAxisCallback(IMakerAxisCallback iMakerAxisCallback) {
        this.tP = iMakerAxisCallback;
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().setAxisCallback(iMakerAxisCallback);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setCoordinateBoundListener(OnCoordinateBoundListener onCoordinateBoundListener) {
        this.df = onCoordinateBoundListener;
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().setCoordinateBoundListener(onCoordinateBoundListener);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setEulerAngleCallback(OnEulerAngleCallback onEulerAngleCallback) {
        this.cP = onEulerAngleCallback;
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().setEulerAngleCallback(onEulerAngleCallback);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setLocationTimeCallBack(IMarkerLocationTimeCallBack iMarkerLocationTimeCallBack) {
        this.iMarkerLocationTimeCallBack = iMarkerLocationTimeCallBack;
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().setLocationTimeCallBack(this.iMarkerLocationTimeCallBack);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setMarkerARSetupCallback(fz fzVar) {
        this.tQ = fzVar;
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().setMarkerARSetupCallback(fzVar);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setMarkerStateListener(IMarkerStateListener iMarkerStateListener) {
        this.iMarkerStateListener = iMarkerStateListener;
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().setMarkerStateListener(iMarkerStateListener);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setPositionCallback(fx fxVar) {
        this.iMarkerPositionCallback = fxVar;
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().setPositionCallback(fxVar);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setTrackerSessionCallback(OnTrackerSessionCallback onTrackerSessionCallback) {
        this.mOnTrackerSessionCallback = onTrackerSessionCallback;
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().setTrackerSessionCallback(onTrackerSessionCallback);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void showNavigationContent() {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().showNavigationContent();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void test() {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().test();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void updateHeading(float f, float f2) {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().updateHeading(f, f2);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void updateImuData(float[] fArr) {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().updateImuData(fArr);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void updateLocation(float[] fArr, int i, boolean z) {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().updateLocation(fArr, i, z);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void updateMeters(float f) {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().updateMeters(f);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void updateMockAccelerometer(float f, float f2, float f3) {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().updateMockAccelerometer(f, f2, f3);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void updateTransformData(int i, float[] fArr) {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().updateTransformData(i, fArr);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void updateTranslationPrior(TranslationPrior translationPrior) {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().updateTranslationPrior(translationPrior);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postArrow(String str, int i, double[] dArr, double[] dArr2, double[] dArr3, float f, float f2) {
        WeakReference<IMarker> weakReference = this.tO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tO.get().postArrow(str, i, dArr, dArr2, dArr3, f, f2);
    }
}
