package com.baidu.mapapi.search.weather;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.n;

/* loaded from: classes7.dex */
public class WeatherSearch extends n {

    /* renamed from: a, reason: collision with root package name */
    com.baidu.platform.core.i.a f6004a = new com.baidu.platform.core.i.e();

    public static WeatherSearch newInstance() {
        BMapManager.init();
        return new WeatherSearch();
    }

    public void destroy() {
        com.baidu.platform.core.i.a aVar = this.f6004a;
        if (aVar != null) {
            aVar.a();
        }
        BMapManager.destroy();
    }

    public boolean request(WeatherSearchOption weatherSearchOption) {
        com.baidu.platform.core.i.a aVar = this.f6004a;
        if (aVar != null) {
            if (weatherSearchOption != null) {
                return aVar.a(weatherSearchOption);
            }
            throw new IllegalArgumentException("BDMapSDKException: option can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
    }

    public void setWeatherSearchResultListener(OnGetWeatherResultListener onGetWeatherResultListener) {
        com.baidu.platform.core.i.a aVar = this.f6004a;
        if (aVar != null) {
            if (onGetWeatherResultListener != null) {
                aVar.a(onGetWeatherResultListener);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
    }
}
