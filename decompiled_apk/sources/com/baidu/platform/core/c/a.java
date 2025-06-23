package com.baidu.platform.core.c;

import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.platform.base.SearchType;

/* loaded from: classes8.dex */
public class a extends com.baidu.platform.base.a implements d {
    OnGetGeoCoderResultListener b = null;

    @Override // com.baidu.platform.core.c.d
    public boolean a(GeoCodeOption geoCodeOption) {
        b bVar = new b();
        com.baidu.platform.base.e cVar = new c(geoCodeOption);
        bVar.a(SearchType.GEO_CODER);
        if (geoCodeOption != null) {
            bVar.b(geoCodeOption.getAddress());
        }
        return a(cVar, this.b, bVar);
    }

    @Override // com.baidu.platform.core.c.d
    public boolean a(ReverseGeoCodeOption reverseGeoCodeOption) {
        e eVar = new e();
        f fVar = new f(reverseGeoCodeOption);
        eVar.a(SearchType.REVERSE_GEO_CODER);
        return a(fVar, this.b, eVar);
    }

    @Override // com.baidu.platform.core.c.d
    public void a(OnGetGeoCoderResultListener onGetGeoCoderResultListener) {
        this.f9526a.lock();
        this.b = onGetGeoCoderResultListener;
        this.f9526a.unlock();
    }

    @Override // com.baidu.platform.core.c.d
    public void a() {
        this.f9526a.lock();
        this.b = null;
        this.f9526a.unlock();
    }
}
