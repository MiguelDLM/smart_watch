package com.baidu.navisdk.pronavi.ui.newnavi.component;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.view.View;
import com.baidu.navisdk.apicenter.a;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.pronavi.ui.base.RGUiComponent;
import com.baidu.navisdk.pronavi.ui.base.b;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class RGNewRightComponent extends RGUiComponent<b> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGNewRightComponent(@OOXIXo b context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
    }

    @Override // com.baidu.navisdk.framework.interfaces.y
    @oOoXoXO
    public View[] B() {
        return null;
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    @oOoXoXO
    public h a(@OOXIXo a api) {
        IIX0o.x0xO0oo(api, "api");
        int d = api.d();
        if (d != 10001) {
            if (d == 10002) {
                return null;
            }
            return super.a(api);
        }
        return null;
    }

    @Override // com.baidu.navisdk.framework.func.Func
    @OOXIXo
    public String o() {
        return "RGNewRightComponent";
    }
}
