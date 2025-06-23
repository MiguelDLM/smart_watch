package com.baidu.navisdk.model.datastruct.destrec;

import com.baidu.entity.pb.TabPoiInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private String f6922a;
    private final List<d> b = new ArrayList();
    private final List<f> c = new ArrayList();
    private final List<com.baidu.navisdk.model.datastruct.b> d = new ArrayList();
    private final List<f> e = new ArrayList();
    private final List<com.baidu.navisdk.model.datastruct.b> f = new ArrayList();
    private final List<f> g = new ArrayList();
    private final List<com.baidu.navisdk.model.datastruct.b> h = new ArrayList();
    private boolean i;

    public static g a(TabPoiInfo tabPoiInfo, int i) {
        if (tabPoiInfo == null || tabPoiInfo.getRecMultiPoisCount() <= 0) {
            return null;
        }
        g gVar = new g();
        gVar.f6922a = tabPoiInfo.getTabName().toStringUtf8();
        for (int i2 = 0; i2 < tabPoiInfo.getRecMultiPoisCount(); i2++) {
            d a2 = d.a(tabPoiInfo.getRecMultiPois(i2), i, i2);
            if (a2 != null) {
                gVar.b.add(a2);
                gVar.e.addAll(a2.b());
                gVar.f.addAll(a2.a());
            }
        }
        for (int i3 = 0; i3 < tabPoiInfo.getSurroundingRecPoiInfoCount(); i3++) {
            f a3 = f.a(tabPoiInfo.getSurroundingRecPoiInfo(i3), i, tabPoiInfo.getRecMultiPoisCount() + 1, i3);
            if (i3 == 0) {
                a3.a(1);
            } else {
                a3.a(2);
            }
            gVar.g.add(a3);
            if (a3.f() != null) {
                gVar.h.add(a3.f());
            }
        }
        gVar.d.addAll(gVar.f);
        gVar.d.addAll(gVar.h);
        gVar.c.addAll(gVar.e);
        gVar.c.addAll(gVar.g);
        if (gVar.b.isEmpty()) {
            return null;
        }
        return gVar;
    }

    public List<f> b() {
        return this.e;
    }

    public String toString() {
        return "DestRecTabData{title='" + this.f6922a + "', multiPoiDataList=" + this.b + ", allPoiDataList=" + this.c + ", allMapGData=" + this.d + ", selected=" + this.i + '}';
    }

    public List<com.baidu.navisdk.model.datastruct.b> a() {
        return this.f;
    }

    public void a(boolean z) {
        this.i = z;
    }
}
