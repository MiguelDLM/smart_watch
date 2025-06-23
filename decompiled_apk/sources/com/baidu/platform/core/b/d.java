package com.baidu.platform.core.b;

import com.baidu.mapapi.search.district.DistrictSearchOption;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;
import com.baidu.platform.base.SearchType;

/* loaded from: classes8.dex */
public class d extends com.baidu.platform.base.a implements e {
    private OnGetDistricSearchResultListener b = null;

    @Override // com.baidu.platform.core.b.e
    public boolean a(DistrictSearchOption districtSearchOption) {
        b bVar = new b();
        bVar.a(SearchType.DISTRICT_SEARCH);
        return a(new a(districtSearchOption), this.b, bVar);
    }

    @Override // com.baidu.platform.core.b.e
    public void a(OnGetDistricSearchResultListener onGetDistricSearchResultListener) {
        this.f9526a.lock();
        this.b = onGetDistricSearchResultListener;
        this.f9526a.unlock();
    }

    @Override // com.baidu.platform.core.b.e
    public void a() {
        this.f9526a.lock();
        this.b = null;
        this.f9526a.unlock();
    }
}
