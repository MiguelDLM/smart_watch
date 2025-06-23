package com.baidu.mapapi.search.busline;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.n;
import com.baidu.platform.core.busline.IBusLineSearch;
import com.baidu.platform.core.busline.c;

/* loaded from: classes7.dex */
public class BusLineSearch extends n {
    private boolean b = false;

    /* renamed from: a, reason: collision with root package name */
    IBusLineSearch f5933a = new c();

    public static BusLineSearch newInstance() {
        BMapManager.init();
        return new BusLineSearch();
    }

    public void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.f5933a.a();
        BMapManager.destroy();
    }

    public boolean searchBusLine(BusLineSearchOption busLineSearchOption) {
        IBusLineSearch iBusLineSearch = this.f5933a;
        if (iBusLineSearch != null) {
            if (busLineSearchOption != null && busLineSearchOption.mCity != null && busLineSearchOption.mUid != null) {
                return iBusLineSearch.a(busLineSearchOption);
            }
            throw new IllegalArgumentException("BDMapSDKException: option or city or uid can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
    }

    public void setOnGetBusLineSearchResultListener(OnGetBusLineSearchResultListener onGetBusLineSearchResultListener) {
        IBusLineSearch iBusLineSearch = this.f5933a;
        if (iBusLineSearch != null) {
            if (onGetBusLineSearchResultListener != null) {
                iBusLineSearch.a(onGetBusLineSearchResultListener);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
    }
}
