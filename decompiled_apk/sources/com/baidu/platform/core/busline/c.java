package com.baidu.platform.core.busline;

import com.baidu.mapapi.search.busline.BusLineSearchOption;
import com.baidu.mapapi.search.busline.OnGetBusLineSearchResultListener;
import com.baidu.platform.base.SearchType;

/* loaded from: classes8.dex */
public class c extends com.baidu.platform.base.a implements IBusLineSearch {
    OnGetBusLineSearchResultListener b = null;

    @Override // com.baidu.platform.core.busline.IBusLineSearch
    public boolean a(BusLineSearchOption busLineSearchOption) {
        a aVar = new a();
        aVar.a(SearchType.BUS_LINE_DETAIL);
        return a(new b(busLineSearchOption), this.b, aVar);
    }

    @Override // com.baidu.platform.core.busline.IBusLineSearch
    public void a(OnGetBusLineSearchResultListener onGetBusLineSearchResultListener) {
        this.f9526a.lock();
        this.b = onGetBusLineSearchResultListener;
        this.f9526a.unlock();
    }

    @Override // com.baidu.platform.core.busline.IBusLineSearch
    public void a() {
        this.f9526a.lock();
        this.b = null;
        this.f9526a.unlock();
    }
}
