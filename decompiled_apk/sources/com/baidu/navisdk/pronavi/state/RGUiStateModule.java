package com.baidu.navisdk.pronavi.state;

import android.os.Bundle;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.framework.func.Func;
import com.baidu.navisdk.module.pronavi.msg.c;
import com.baidu.navisdk.pronavi.state.b;
import com.baidu.navisdk.uiframe.UiModule;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public abstract class RGUiStateModule<C extends b> extends UiModule<C> implements a, com.baidu.navisdk.module.pronavi.b, c, BNMapObserver {
    public RGUiStateModule(@NonNull C c) {
        super(c);
    }

    private boolean y() {
        return getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED);
    }

    public void a(boolean z) {
    }

    @Override // com.baidu.navisdk.pronavi.state.a
    public void b(String str, String str2, Bundle bundle) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "enter --> cur = " + str2 + ", uiHasLoaded = " + y());
        }
        if (!Func.a.f6808a || y()) {
            c(str, str2, bundle);
        }
    }

    public void c(String str, String str2, Bundle bundle) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "onEnter: " + str + ", " + str2 + "," + bundle);
        }
    }

    public void d(String str, String str2, Bundle bundle) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "onExit: " + str + ", " + str2 + "," + bundle);
        }
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
    }

    @Override // com.baidu.navisdk.comapi.base.b
    public void update(com.baidu.navisdk.comapi.base.c cVar, int i, int i2, Object obj) {
    }

    public void x() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "disposeCutoutSafetyPadding: ");
        }
    }

    public int[] a() {
        return null;
    }

    @Override // com.baidu.navisdk.pronavi.state.a
    public void a(String str, String str2, Bundle bundle) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "exit --> cur = " + str2 + ", uiHasLoaded = " + y());
        }
        if (!Func.a.f6808a || y()) {
            d(str, str2, bundle);
        }
    }

    @Override // com.baidu.navisdk.module.pronavi.b
    public boolean b(Message message) {
        g gVar = g.PRO_NAV;
        if (!gVar.d()) {
            return false;
        }
        gVar.e(this.g, "receiveNaviSubStatus: " + message.what + "," + message.arg1 + ", " + message.arg2 + ", " + message.obj);
        return false;
    }

    public void a(Message message) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "receiveMsg: " + message.what + "," + message.arg1 + ", " + message.arg2 + ", " + message.obj);
        }
    }
}
