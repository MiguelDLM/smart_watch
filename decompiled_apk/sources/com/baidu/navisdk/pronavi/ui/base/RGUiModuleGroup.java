package com.baidu.navisdk.pronavi.ui.base;

import android.os.Message;
import android.view.View;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.pronavi.state.RGUiStateModuleGroup;
import com.baidu.navisdk.pronavi.ui.base.b;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public abstract class RGUiModuleGroup<C extends b> extends RGUiStateModuleGroup<C> {
    public RGUiModuleGroup(C c) {
        super(c);
    }

    private void e(Message message) {
        int i = message.arg1;
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 12) {
                        return;
                    }
                } else {
                    z();
                    return;
                }
            } else {
                A();
                return;
            }
        }
        if (!f.c().c.j0) {
            C();
        }
    }

    public void A() {
    }

    public void C() {
    }

    @Override // com.baidu.navisdk.pronavi.state.RGUiStateModuleGroup
    public boolean c(Message message) {
        super.c(message);
        int i = message.what;
        if (i != 4098) {
            if (i == 4474 && f.c().c.j0) {
                C();
                return false;
            }
            return false;
        }
        e(message);
        d(message);
        return false;
    }

    public void d(Message message) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "onNaviSightChanged: " + message.toString());
        }
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        ((b) this.i).a(this);
    }

    @Override // com.baidu.navisdk.uiframe.UiModuleGroup, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        ((b) this.i).b(this);
    }

    public void z() {
    }

    public RGUiModuleGroup(C c, View view) {
        super(c, view);
    }
}
