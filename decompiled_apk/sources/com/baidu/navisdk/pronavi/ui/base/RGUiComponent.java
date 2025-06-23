package com.baidu.navisdk.pronavi.ui.base;

import android.content.res.Configuration;
import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.framework.interfaces.y;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.pronavi.base.a;
import com.baidu.navisdk.pronavi.state.RGUiStateModule;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public abstract class RGUiComponent<C extends com.baidu.navisdk.pronavi.base.a> extends RGUiStateModule<C> implements y {
    protected int o;

    public RGUiComponent(@NonNull C c) {
        super(c);
        this.o = 1;
    }

    private void d(Message message) {
        int i = message.arg1;
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 12) {
                        return;
                    }
                } else {
                    y();
                    return;
                }
            } else {
                z();
                return;
            }
        }
        if (!f.c().c.j0) {
            A();
        }
    }

    public void A() {
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    public void a(Configuration configuration) {
        super.a(configuration);
        this.o = configuration.orientation;
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    public View b(int i, @Nullable View view) {
        this.o = i;
        return super.b(i, view);
    }

    public void c(Message message) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "onNaviSightChanged: " + message.toString());
        }
    }

    @Override // com.baidu.navisdk.pronavi.state.RGUiStateModule, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        ((com.baidu.navisdk.pronavi.base.a) this.i).a(this);
        this.o = ((com.baidu.navisdk.pronavi.base.a) this.i).o();
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        ((com.baidu.navisdk.pronavi.base.a) this.i).b(this);
    }

    public void y() {
    }

    public void z() {
    }

    @Override // com.baidu.navisdk.pronavi.state.RGUiStateModule, com.baidu.navisdk.module.pronavi.b
    public boolean b(Message message) {
        super.b(message);
        int i = message.what;
        if (i != 4098) {
            if (i != 4474 || !f.c().c.j0) {
                return false;
            }
            A();
            return false;
        }
        d(message);
        c(message);
        return false;
    }
}
