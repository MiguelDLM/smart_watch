package com.baidu.navisdk.pronavi.state;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.framework.func.Func;
import com.baidu.navisdk.module.pronavi.msg.c;
import com.baidu.navisdk.pronavi.state.b;
import com.baidu.navisdk.uiframe.UiModule;
import com.baidu.navisdk.uiframe.UiModuleGroup;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public abstract class RGUiStateModuleGroup<C extends b> extends UiModuleGroup<C> implements a, com.baidu.navisdk.module.pronavi.b, c, BNMapObserver {
    public RGUiStateModuleGroup(C c) {
        super(c);
    }

    private boolean z() {
        return getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED);
    }

    public void a(com.baidu.navisdk.comapi.base.c cVar, int i, int i2, Object obj) {
    }

    @Override // com.baidu.navisdk.pronavi.state.a
    public final void b(String str, String str2, Bundle bundle) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "enter: " + str + "," + str2 + "," + bundle + ",uiHasLoaded:" + z());
        }
        if (!Func.a.f6808a || z()) {
            c(str, str2, bundle);
            for (UiModule uiModule : this.o.values()) {
                if (uiModule != null && uiModule.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                    if (uiModule instanceof RGUiStateModule) {
                        ((RGUiStateModule) uiModule).b(str, str2, bundle);
                    } else if (uiModule instanceof RGUiStateModuleGroup) {
                        ((RGUiStateModuleGroup) uiModule).b(str, str2, bundle);
                    }
                }
            }
        }
    }

    public void c(String str, String str2, Bundle bundle) {
    }

    public void d(String str, String str2, Bundle bundle) {
    }

    @Override // com.baidu.navisdk.comapi.base.b
    public void update(com.baidu.navisdk.comapi.base.c cVar, int i, int i2, Object obj) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "update: " + cVar + ",type:" + i + ",event: " + i2 + ", arg:" + obj);
        }
        if (!z()) {
            return;
        }
        a(cVar, i, i2, obj);
        for (UiModule uiModule : this.o.values()) {
            if (uiModule != null && uiModule.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                if (uiModule instanceof RGUiStateModule) {
                    ((RGUiStateModule) uiModule).update(cVar, i, i2, obj);
                } else if (uiModule instanceof RGUiStateModuleGroup) {
                    ((RGUiStateModuleGroup) uiModule).update(cVar, i, i2, obj);
                }
            }
        }
    }

    public void x() {
        if (!z()) {
            return;
        }
        y();
        for (UiModule uiModule : this.o.values()) {
            if (uiModule != null && uiModule.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                if (uiModule instanceof RGUiStateModule) {
                    ((RGUiStateModule) uiModule).x();
                } else if (uiModule instanceof RGUiStateModuleGroup) {
                    ((RGUiStateModuleGroup) uiModule).x();
                }
            }
        }
    }

    public void y() {
    }

    public RGUiStateModuleGroup(C c, View view) {
        super(c, view);
    }

    public int[] a() {
        return null;
    }

    public boolean c(Message message) {
        return false;
    }

    @Override // com.baidu.navisdk.pronavi.state.a
    public final void a(String str, String str2, Bundle bundle) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "exit: " + str + "," + str2 + "," + bundle + ",uiHasLoaded:" + z());
        }
        if (!Func.a.f6808a || z()) {
            d(str, str2, bundle);
            for (UiModule uiModule : this.o.values()) {
                if (uiModule != null && uiModule.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                    if (uiModule instanceof RGUiStateModule) {
                        ((RGUiStateModule) uiModule).a(str, str2, bundle);
                    } else if (uiModule instanceof RGUiStateModuleGroup) {
                        ((RGUiStateModuleGroup) uiModule).a(str, str2, bundle);
                    }
                }
            }
        }
    }

    @Override // com.baidu.navisdk.module.pronavi.b
    public boolean b(Message message) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "receiveNaviSubStatus: " + message + ",uiHasLoaded" + z());
        }
        if (!z()) {
            return false;
        }
        c(message);
        for (UiModule uiModule : this.o.values()) {
            if (uiModule != null && uiModule.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                if (uiModule instanceof RGUiStateModule) {
                    ((RGUiStateModule) uiModule).b(message);
                } else if (uiModule instanceof RGUiStateModuleGroup) {
                    ((RGUiStateModuleGroup) uiModule).b(message);
                }
            }
        }
        return false;
    }

    public void a(Message message) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "receiveMsg: " + message);
        }
    }

    public void a(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "onUpdateStyle: " + z);
        }
        if (z()) {
            for (UiModule uiModule : this.o.values()) {
                if (uiModule != null && uiModule.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                    if (uiModule instanceof RGUiStateModule) {
                        ((RGUiStateModule) uiModule).a(z);
                    } else if (uiModule instanceof RGUiStateModuleGroup) {
                        ((RGUiStateModuleGroup) uiModule).a(z);
                    }
                }
            }
        }
    }
}
