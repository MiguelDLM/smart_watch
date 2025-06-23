package com.baidu.mapapi.map;

import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.map.e;

/* loaded from: classes7.dex */
class ag implements e.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CustomMapStyleCallBack f5883a;
    final /* synthetic */ MapCustomStyleOptions b;
    final /* synthetic */ TextureMapView c;

    public ag(TextureMapView textureMapView, CustomMapStyleCallBack customMapStyleCallBack, MapCustomStyleOptions mapCustomStyleOptions) {
        this.c = textureMapView;
        this.f5883a = customMapStyleCallBack;
        this.b = mapCustomStyleOptions;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.e.a
    public void a(String str) {
        CustomMapStyleCallBack customMapStyleCallBack = this.f5883a;
        if (customMapStyleCallBack == null || !customMapStyleCallBack.onPreLoadLastCustomMapStyle(str)) {
            this.c.a(str, this.b);
            this.c.C = true;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.e.a
    public void a(boolean z, String str) {
        CustomMapStyleCallBack customMapStyleCallBack = this.f5883a;
        if ((customMapStyleCallBack == null || !customMapStyleCallBack.onCustomMapStyleLoadSuccess(z, str)) && !TextUtils.isEmpty(str)) {
            this.c.a(str, "");
            this.c.setMapCustomStyleEnable(true);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.e.a
    public void a(int i, String str, String str2) {
        boolean z;
        CustomMapStyleCallBack customMapStyleCallBack = this.f5883a;
        if (customMapStyleCallBack == null || !customMapStyleCallBack.onCustomMapStyleLoadFailed(i, str, str2)) {
            z = this.c.C;
            if (z) {
                return;
            }
            this.c.a(str2, this.b);
        }
    }
}
