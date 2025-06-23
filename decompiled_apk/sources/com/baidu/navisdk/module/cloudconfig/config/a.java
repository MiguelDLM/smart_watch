package com.baidu.navisdk.module.cloudconfig.config;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.baidu.navisdk.model.datastruct.e;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private LinkedHashMap<Integer, e> f7093a = new LinkedHashMap<>();

    public a() {
        e eVar = new e(1, "优选", "优选", "", "");
        this.f7093a.put(Integer.valueOf(eVar.a()), eVar);
        e eVar2 = new e(2, "特斯拉超充", "超充", "https://lbsnavi.cdn.bcebos.com/base/online/20220317170359/ne_brand_icon_tesla_white.png", "https://lbsnavi.cdn.bcebos.com/base/online/20220330155501/ne_brand_icon_tesla.png");
        this.f7093a.put(Integer.valueOf(eVar2.a()), eVar2);
        e eVar3 = new e(4, "蔚来换电", "换电", "https://lbsnavi.cdn.bcebos.com/base/online/20220317170439/ne_brand_icon_weilai_white.png", "https://lbsnavi.cdn.bcebos.com/base/online/20220317170420/ne_brand_icon_weilai.png");
        this.f7093a.put(Integer.valueOf(eVar3.a()), eVar3);
        e eVar4 = new e(8, "小鹏超充", "超充", "https://lbsnavi.cdn.bcebos.com/base/online/20220317170535/ne_brand_icon_xiaopeng_white.png", "https://lbsnavi.cdn.bcebos.com/base/online/20220317170519/ne_brand_icon_xiaopeng.png");
        this.f7093a.put(Integer.valueOf(eVar4.a()), eVar4);
    }

    public final synchronized void a(@OOXIXo LinkedHashMap<Integer, e> preferMap) {
        IIX0o.x0xO0oo(preferMap, "preferMap");
        this.f7093a = preferMap;
    }

    @oOoXoXO
    public final synchronized e a(int i) {
        return this.f7093a.get(Integer.valueOf(i));
    }
}
