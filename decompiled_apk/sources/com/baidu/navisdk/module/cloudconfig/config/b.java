package com.baidu.navisdk.module.cloudconfig.config;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.util.SparseArray;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private SparseArray<a> f7094a = new SparseArray<>();

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final SparseArray<String> f7095a = new SparseArray<>();

        public final void a(@oOoXoXO String str) {
        }

        public final void a(int i, @OOXIXo String iconUrl) {
            IIX0o.x0xO0oo(iconUrl, "iconUrl");
            this.f7095a.put(i, iconUrl);
        }

        @oOoXoXO
        public final String a(int i) {
            String str = this.f7095a.get(i);
            return (str == null || str.length() == 0) ? this.f7095a.get(0) : str;
        }
    }

    public b() {
        a aVar = new a();
        aVar.a("");
        aVar.a(1, "https://lbsnavi.cdn.bcebos.com/base/online/20211215101849/nsdk_ne_bottom_tip_battery_green.png");
        aVar.a(2, "https://lbsnavi.cdn.bcebos.com/base/online/20211215102324/nsdk_ne_bottom_tip_battery_yellow.png");
        aVar.a(3, "https://lbsnavi.cdn.bcebos.com/base/online/20211215101912/nsdk_ne_bottom_tip_battery_red.png");
        this.f7094a.put(0, aVar);
        a aVar2 = new a();
        aVar2.a("https://lbsnavi.cdn.bcebos.com/base/online/20220317170359/ne_brand_icon_tesla_white.png");
        aVar2.a(1, "https://lbsnavi.cdn.bcebos.com/base/online/20220329115959/ne_bottom_tip_tesla_green.png");
        aVar2.a(2, "https://lbsnavi.cdn.bcebos.com/base/online/20220329120032/ne_bottom_tip_tesla_yellow.png");
        aVar2.a(3, "https://lbsnavi.cdn.bcebos.com/base/online/20220329120017/ne_bottom_tip_tesla_red.png");
        this.f7094a.put(1, aVar2);
        a aVar3 = new a();
        aVar3.a("https://lbsnavi.cdn.bcebos.com/base/online/20220317170439/ne_brand_icon_weilai_white.png");
        aVar3.a(1, "https://lbsnavi.cdn.bcebos.com/base/online/20220329120059/ne_bottom_tip_weilai_green.png");
        aVar3.a(2, "https://lbsnavi.cdn.bcebos.com/base/online/20220329120132/ne_bottom_tip_weilai_yellow.png");
        aVar3.a(3, "https://lbsnavi.cdn.bcebos.com/base/online/20220329120115/ne_bottom_tip_weilai_red.png");
        this.f7094a.put(2, aVar3);
        a aVar4 = new a();
        aVar4.a("https://lbsnavi.cdn.bcebos.com/base/online/20220317170439/ne_brand_icon_weilai_white.png");
        aVar4.a(1, "https://lbsnavi.cdn.bcebos.com/base/online/20220329120145/ne_bottom_tip_xiaopeng_green.png");
        aVar4.a(2, "https://lbsnavi.cdn.bcebos.com/base/online/20220329120207/ne_bottom_tip_xiaopeng_yellow.png");
        aVar4.a(3, "https://lbsnavi.cdn.bcebos.com/base/online/20220329120156/ne_bottom_tip_xiaopeng_red.png");
        this.f7094a.put(3, aVar4);
    }

    public final synchronized void a(@OOXIXo SparseArray<a> brandIconMap) {
        IIX0o.x0xO0oo(brandIconMap, "brandIconMap");
        this.f7094a = brandIconMap;
    }

    @OOXIXo
    public final synchronized a a(int i) {
        a aVar;
        aVar = this.f7094a.get(i);
        if (aVar == null) {
            aVar = new a();
            aVar.a("");
            aVar.a(1, "https://lbsnavi.cdn.bcebos.com/base/online/20211215101849/nsdk_ne_bottom_tip_battery_green.png");
            aVar.a(2, "https://lbsnavi.cdn.bcebos.com/base/online/20211215102324/nsdk_ne_bottom_tip_battery_yellow.png");
            aVar.a(3, "https://lbsnavi.cdn.bcebos.com/base/online/20211215101912/nsdk_ne_bottom_tip_battery_red.png");
        }
        return aVar;
    }
}
