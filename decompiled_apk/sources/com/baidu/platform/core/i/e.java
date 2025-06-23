package com.baidu.platform.core.i;

import com.baidu.mapapi.search.weather.OnGetWeatherResultListener;
import com.baidu.mapapi.search.weather.WeatherSearchOption;
import com.baidu.platform.base.SearchType;

/* loaded from: classes8.dex */
public class e extends com.baidu.platform.base.a implements a {
    private OnGetWeatherResultListener b;

    @Override // com.baidu.platform.core.i.a
    public boolean a(WeatherSearchOption weatherSearchOption) {
        b bVar = new b();
        bVar.a(SearchType.WEATHER_SEARCH);
        return a(new c(weatherSearchOption), this.b, bVar);
    }

    @Override // com.baidu.platform.core.i.a
    public void a(OnGetWeatherResultListener onGetWeatherResultListener) {
        this.f9526a.lock();
        this.b = onGetWeatherResultListener;
        this.f9526a.unlock();
    }

    @Override // com.baidu.platform.core.i.a
    public void a() {
        this.f9526a.lock();
        this.b = null;
        this.f9526a.unlock();
    }
}
