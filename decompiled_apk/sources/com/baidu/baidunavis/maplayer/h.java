package com.baidu.baidunavis.maplayer;

import androidx.annotation.NonNull;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/* loaded from: classes7.dex */
public class h {
    @NonNull
    public static GeoPoint a(com.baidu.nplatform.comapi.basestruct.c cVar) {
        if (cVar == null) {
            cVar = new com.baidu.nplatform.comapi.basestruct.c();
        }
        return new GeoPoint(cVar.b(), cVar.a());
    }
}
