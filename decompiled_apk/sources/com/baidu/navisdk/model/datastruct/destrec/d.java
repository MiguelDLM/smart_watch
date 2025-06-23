package com.baidu.navisdk.model.datastruct.destrec;

import com.baidu.entity.pb.RecMultiPoiInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final List<f> f6918a = new ArrayList();
    private final List<com.baidu.navisdk.model.datastruct.b> b = new ArrayList();
    private int c;

    public static d a(RecMultiPoiInfo recMultiPoiInfo, int i, int i2) {
        if (recMultiPoiInfo == null) {
            return null;
        }
        d dVar = new d();
        int recPoisCount = recMultiPoiInfo.getRecPoisCount();
        if (recPoisCount <= 0) {
            return null;
        }
        for (int i3 = 0; i3 < recPoisCount; i3++) {
            f a2 = f.a(recMultiPoiInfo.getRecPois(i3), i, i2, i3);
            if (a2 != null) {
                if (recPoisCount == 1) {
                    a2.a(0);
                } else if (i3 == 0) {
                    a2.a(1);
                } else if (i3 == recPoisCount - 1) {
                    a2.a(3);
                } else {
                    a2.a(2);
                }
                dVar.f6918a.add(a2);
                if (a2.f() != null) {
                    dVar.b.add(a2.f());
                }
                dVar.c += a2.d();
            }
        }
        if (dVar.f6918a.isEmpty()) {
            return null;
        }
        dVar.c += dVar.f6918a.size() - 1;
        return dVar;
    }

    public List<f> b() {
        return this.f6918a;
    }

    public String toString() {
        return "DestRecMultiPoiData{poiDataList=" + this.f6918a + ", mapGDataList=" + this.b + ", height=" + this.c + '}';
    }

    public List<com.baidu.navisdk.model.datastruct.b> a() {
        return this.b;
    }
}
