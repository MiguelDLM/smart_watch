package com.baidu.platform.core.d;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mapapi.search.poi.PoiIndoorOption;
import com.baidu.platform.comapi.map.MapBundleKey;

/* loaded from: classes8.dex */
public class c extends com.baidu.platform.base.e {
    public c(PoiIndoorOption poiIndoorOption) {
        a(poiIndoorOption);
    }

    private void a(PoiIndoorOption poiIndoorOption) {
        this.f9530a.a("qt", "indoor_s");
        this.f9530a.a("x", "0");
        this.f9530a.a("y", "0");
        this.f9530a.a(TypedValues.TransitionType.S_FROM, "android_map_sdk");
        String str = poiIndoorOption.bid;
        if (str != null && !str.equals("")) {
            this.f9530a.a(MapBundleKey.MapObjKey.OBJ_BID, str);
        }
        String str2 = poiIndoorOption.wd;
        if (str2 != null && !str2.equals("")) {
            this.f9530a.a("wd", str2);
        }
        String str3 = poiIndoorOption.floor;
        if (str3 != null && !str3.equals("")) {
            this.f9530a.a("floor", str3);
        }
        this.f9530a.a("current", poiIndoorOption.currentPage + "");
        this.f9530a.a("pageSize", poiIndoorOption.pageSize + "");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.c();
    }
}
