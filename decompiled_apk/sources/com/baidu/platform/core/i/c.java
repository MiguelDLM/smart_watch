package com.baidu.platform.core.i;

import android.text.TextUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.weather.WeatherDataType;
import com.baidu.mapapi.search.weather.WeatherSearchOption;
import com.baidu.mapapi.search.weather.WeatherServerType;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.szabh.smable3.entity.Languages;

/* loaded from: classes8.dex */
public class c extends com.baidu.platform.base.e {
    WeatherSearchOption b;

    public c(WeatherSearchOption weatherSearchOption) {
        this.b = weatherSearchOption;
        a(weatherSearchOption);
    }

    private void a(WeatherSearchOption weatherSearchOption) {
        if (!TextUtils.isEmpty(weatherSearchOption.getDistrictID())) {
            this.f9530a.a("district_id", weatherSearchOption.getDistrictID());
        }
        if (weatherSearchOption.getLocation() != null) {
            LatLng latLng = new LatLng(weatherSearchOption.getLocation().latitude, weatherSearchOption.getLocation().longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            this.f9530a.a("location", latLng.longitude + "," + latLng.latitude);
            this.f9530a.a("coordtype", a(CoordType.BD09LL));
        }
        if (weatherSearchOption.getDataType() != null) {
            this.f9530a.a("data_type", a(weatherSearchOption.getDataType()));
        }
        if (weatherSearchOption.getLanguageType() != null) {
            this.f9530a.a("language", a(weatherSearchOption.getLanguageType()));
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        WeatherSearchOption weatherSearchOption = this.b;
        if (weatherSearchOption == null) {
            return "";
        }
        if (weatherSearchOption.getServerType() == WeatherServerType.LANGUAGE_SERVER_TYPE_ABROAD) {
            return cVar.t();
        }
        return cVar.s();
    }

    private String a(WeatherDataType weatherDataType) {
        switch (d.f10005a[weatherDataType.ordinal()]) {
            case 1:
                return "now";
            case 2:
                return "fc";
            case 3:
                return "fc_hour";
            case 4:
                return MapBundleKey.MapObjKey.OBJ_SL_INDEX;
            case 5:
                return "alert";
            case 6:
                return TtmlNode.COMBINE_ALL;
            default:
                return "";
        }
    }

    private String a(CoordType coordType) {
        int i = d.b[coordType.ordinal()];
        if (i != 1) {
            return i != 2 ? "" : "gcj02";
        }
        return "bd09ll";
    }

    private String a(LanguageType languageType) {
        int i = d.c[languageType.ordinal()];
        if (i != 1) {
            return i != 2 ? "" : "cn";
        }
        return Languages.DEFAULT_LANGUAGE;
    }
}
