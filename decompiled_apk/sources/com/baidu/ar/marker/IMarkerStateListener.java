package com.baidu.ar.marker;

import com.baidu.ar.marker.model.LocationMarkerData;
import java.util.List;

/* loaded from: classes7.dex */
public interface IMarkerStateListener {
    void compassResult(double d);

    void onCoordinateResult(int i, double[] dArr);

    void onError(int i, String str);

    void onLocationResult(boolean z, List<LocationMarkerData> list);

    void onResuourceCreated();

    void onSessionCreated(boolean z, String str);
}
