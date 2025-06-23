package com.baidu.navisdk.comapi.geolocate;

import com.baidu.navisdk.model.datastruct.g;

/* loaded from: classes7.dex */
public interface b {
    void onGpsStatusChange(boolean z, boolean z2);

    void onLocationChange(g gVar);

    void onWGS84LocationChange(g gVar, g gVar2);
}
