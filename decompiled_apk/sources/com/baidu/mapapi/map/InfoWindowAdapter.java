package com.baidu.mapapi.map;

import android.view.View;

/* loaded from: classes7.dex */
public interface InfoWindowAdapter {
    InfoWindow getInfoWindow(Marker marker);

    View getInfoWindowView(Marker marker);

    int getInfoWindowViewYOffset();
}
