package com.baidu.ar.vps.marker;

import com.baidu.ar.marker.model.LocationMarkerData;
import java.util.List;

/* loaded from: classes7.dex */
public interface MarkerProcessCallback {
    void onAlgoEnd(boolean z);

    void onAlgoStartUp();

    void onCoordinateResult(int i, double[] dArr);

    void onCreateSessionEnd(boolean z, String str);

    void onCreateSessionStart();

    void onDownloadAlgoStart();

    void onDownloadSoResult(boolean z);

    void onFrameQueryResult(int i, String str);

    void onLocationResult(boolean z, List<LocationMarkerData> list);
}
