package com.baidu.navisdk.adapter;

import android.view.ViewGroup;
import com.baidu.mapapi.map.MapView;
import com.baidu.navisdk.adapter.struct.BNLocationData;
import com.baidu.navisdk.adapter.struct.BNMapStatus;

/* loaded from: classes7.dex */
public interface IBNMapManager {
    void attach(ViewGroup viewGroup);

    void detach(ViewGroup viewGroup);

    BNMapStatus getMapStatus();

    MapView getMapView();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    int getZoomLevel();

    void onPause();

    void onResume();

    void setDpiScale(float f);

    void setMapStatus(BNMapStatus bNMapStatus);

    void setMyLocationData(BNLocationData bNLocationData);

    void zoomIn();

    void zoomOut();
}
