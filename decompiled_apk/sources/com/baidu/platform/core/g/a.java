package com.baidu.platform.core.g;

import com.baidu.mapapi.search.share.LocationShareURLOption;
import com.baidu.mapapi.search.share.OnGetShareUrlResultListener;
import com.baidu.mapapi.search.share.PoiDetailShareURLOption;
import com.baidu.mapapi.search.share.RouteShareURLOption;

/* loaded from: classes8.dex */
public interface a {
    void a();

    void a(OnGetShareUrlResultListener onGetShareUrlResultListener);

    boolean a(LocationShareURLOption locationShareURLOption);

    boolean a(PoiDetailShareURLOption poiDetailShareURLOption);

    boolean a(RouteShareURLOption routeShareURLOption);
}
