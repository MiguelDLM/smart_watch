package com.baidu.navisdk.pronavi.newenergy.ui.bucket.component;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Message;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.pronavi.newenergy.a;
import com.baidu.navisdk.pronavi.newenergy.logic.tips.b;
import com.baidu.navisdk.pronavi.ui.bucket.component.RGBucketGroupComponent;
import com.garmin.fit.OxXXx0X;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class RGNewEnergyBucketModuleGroup extends RGBucketGroupComponent {
    private final b t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGNewEnergyBucketModuleGroup(@OOXIXo a context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
        this.t = new b(context, this);
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.component.RGBucketGroupComponent, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    @oOoXoXO
    public h a(@OOXIXo com.baidu.navisdk.apicenter.a api) {
        IIX0o.x0xO0oo(api, "api");
        int d = api.d();
        if (d != 2015) {
            if (d != 2016) {
                return super.a(api);
            }
            this.t.a(true);
            return null;
        }
        com.baidu.navisdk.pronavi.newenergy.ui.bucket.a aVar = (com.baidu.navisdk.pronavi.newenergy.ui.bucket.a) a(35, com.baidu.navisdk.pronavi.newenergy.ui.bucket.a.class);
        if (aVar == null) {
            return null;
        }
        Object a2 = api.a("paramA");
        IIX0o.oO(a2, "api.get(Api.ParamA)");
        aVar.a((com.baidu.navisdk.pronavi.newenergy.logic.tips.a) a2);
        return null;
    }

    @Override // com.baidu.navisdk.pronavi.state.RGUiStateModuleGroup, com.baidu.navisdk.module.pronavi.msg.c
    @OOXIXo
    public int[] a() {
        ArrayList arrayList = new ArrayList(4);
        int[] a2 = super.a();
        if (a2 != null) {
            if (!(a2.length == 0)) {
                for (int i : a2) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
        }
        arrayList.add(4100);
        arrayList.add(Integer.valueOf(OxXXx0X.Xx0OXIoI));
        return CollectionsKt___CollectionsKt.o0Oox0xox(arrayList);
    }

    @Override // com.baidu.navisdk.pronavi.state.RGUiStateModuleGroup, com.baidu.navisdk.module.pronavi.msg.c
    public void a(@oOoXoXO Message message) {
        super.a(message);
        Integer valueOf = message != null ? Integer.valueOf(message.what) : null;
        if (valueOf != null && valueOf.intValue() == 4100) {
            b.a(this.t, false, 1, null);
        } else if (valueOf != null && valueOf.intValue() == 4432) {
            this.t.a(true);
        }
    }
}
