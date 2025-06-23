package com.baidu.navisdk.pronavi.ui.newnavi.component;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.apicenter.a;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.ui.base.RGUiComponent;
import com.baidu.navisdk.pronavi.ui.base.b;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class RGNewBottomComponent extends RGUiComponent<b> {
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
        if (d != 5001) {
            if (d != 5002) {
                return super.a(api);
            }
            ViewGroup containerView = r();
            IIX0o.oO(containerView, "containerView");
            containerView.setVisibility(8);
            return null;
        }
        ViewGroup containerView2 = r();
        IIX0o.oO(containerView2, "containerView");
        containerView2.setVisibility(0);
        return null;
    }

    @Override // com.baidu.navisdk.framework.func.Func
    @OOXIXo
    public String o() {
        return "RGNewBottomComponent";
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    public int q() {
        return R.id.bn_rg_bottombar_container;
    }
}
