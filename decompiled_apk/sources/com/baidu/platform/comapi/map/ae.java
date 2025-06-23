package com.baidu.platform.comapi.map;

import O0IoXXOx.XO;
import android.os.Bundle;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes8.dex */
public final class ae implements com.baidu.platform.comjni.map.basemap.a {

    /* renamed from: a, reason: collision with root package name */
    static final String f9632a = "com.baidu.platform.comapi.map.ae";
    Map<Long, InnerOverlay> b = new ConcurrentHashMap();
    AppBaseMap c;

    public ae(AppBaseMap appBaseMap) {
        this.c = appBaseMap;
    }

    @Override // com.baidu.platform.comjni.map.basemap.a
    public int a(Bundle bundle, long j, int i) {
        long currentTimeMillis = y.f9677a ? System.currentTimeMillis() : 0L;
        InnerOverlay innerOverlay = this.b.get(Long.valueOf(j));
        if (innerOverlay != null && (innerOverlay instanceof com.baidu.mapsdkplatform.comapi.map.a.a)) {
            com.baidu.mapsdkplatform.comapi.map.a.a aVar = (com.baidu.mapsdkplatform.comapi.map.a.a) innerOverlay;
            if (aVar.c()) {
                bundle.putString("statusupdate", innerOverlay.getData());
                if (!aVar.b()) {
                    aVar.c(false);
                }
                return aVar.getType();
            }
        }
        if (innerOverlay == null) {
            return 0;
        }
        String data = innerOverlay.getData();
        if (this.c.LayersIsShow(j)) {
            bundle.putString("jsondata", data);
            Bundle param = innerOverlay.getParam();
            if (param != null) {
                bundle.putBundle(XO.f1160OOXIXo, param);
            }
        } else {
            bundle.putString("jsondata", null);
        }
        if (y.f9677a) {
            y.a(f9632a, "MapLayerDataReq:" + j + " tag:" + innerOverlay.getLayerTag() + " [" + (System.currentTimeMillis() - currentTimeMillis) + "ms] LayerData:" + data);
        }
        return innerOverlay.getType();
    }

    @Override // com.baidu.platform.comjni.map.basemap.a
    public boolean a(long j) {
        return this.b.containsKey(Long.valueOf(j));
    }

    public void a(InnerOverlay innerOverlay) {
        this.b.put(Long.valueOf(innerOverlay.mLayerID), innerOverlay);
        innerOverlay.SetMapParam(innerOverlay.mLayerID, this.c);
    }

    public void a(Overlay overlay) {
        this.b.remove(Long.valueOf(overlay.mLayerID));
    }

    public void a() {
        if (this.c != null) {
            for (Long l : this.b.keySet()) {
                if (l.longValue() > 0) {
                    this.c.ClearLayer(l.longValue());
                    this.c.RemoveLayer(l.longValue());
                }
            }
        }
        this.b.clear();
    }
}
