package com.sma.smartv3.ui.me;

import android.os.Bundle;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.WeatherInitializer;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;

/* loaded from: classes11.dex */
public final class DeveloperWeatherTestActivity extends BaseActivity {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mMapView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextureMapView>() { // from class: com.sma.smartv3.ui.me.DeveloperWeatherTestActivity$mMapView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextureMapView invoke() {
            return (TextureMapView) DeveloperWeatherTestActivity.this.findViewById(R.id.mapView);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mMap$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<BaiduMap>() { // from class: com.sma.smartv3.ui.me.DeveloperWeatherTestActivity$mMap$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final BaiduMap invoke() {
            TextureMapView mMapView;
            mMapView = DeveloperWeatherTestActivity.this.getMMapView();
            return mMapView.getMap();
        }
    });

    private final BaiduMap getMMap() {
        return (BaiduMap) this.mMap$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextureMapView getMMapView() {
        return (TextureMapView) this.mMapView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(LatLng latLng) {
        ToastUtils.showLong(latLng.toString(), new Object[0]);
        BleCache bleCache = BleCache.INSTANCE;
        BleCache.remove$default(bleCache, BleKey.WEATHER_REALTIME, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.WEATHER_FORECAST, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.WEATHER_REALTIME2, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.WEATHER_FORECAST2, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.WEATHER_REALTIME3, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.WEATHER_FORECAST3, null, 2, null);
        WeatherInitializer weatherInitializer = WeatherInitializer.f20909XO;
        WeatherInitializer.oO(weatherInitializer, latLng.longitude, latLng.latitude, XIXIX.OOXIXo.f3760XO, 4, null);
        weatherInitializer.ooOOo0oXI(latLng.longitude, latLng.latitude);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        getMMap().setOnMapLongClickListener(new BaiduMap.OnMapLongClickListener() { // from class: com.sma.smartv3.ui.me.xIxooxXX
            @Override // com.baidu.mapapi.map.BaiduMap.OnMapLongClickListener
            public final void onMapLongClick(LatLng latLng) {
                DeveloperWeatherTestActivity.initView$lambda$0(latLng);
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_developer_weater_test;
    }
}
