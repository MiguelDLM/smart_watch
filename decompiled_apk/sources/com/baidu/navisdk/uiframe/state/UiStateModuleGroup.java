package com.baidu.navisdk.uiframe.state;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import com.baidu.navisdk.framework.func.Func;
import com.baidu.navisdk.framework.statemachine.b;
import com.baidu.navisdk.uiframe.UiModule;
import com.baidu.navisdk.uiframe.UiModuleGroup;
import com.baidu.navisdk.uiframe.state.a;
import com.baidu.navisdk.util.common.g;
import java.util.Stack;

/* loaded from: classes8.dex */
public abstract class UiStateModuleGroup<C extends a> extends UiModuleGroup<C> {
    public final void a(b bVar, b bVar2, b bVar3, com.baidu.navisdk.framework.statemachine.a aVar) {
        if (Func.a.f6808a && !getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            return;
        }
        b(bVar, bVar2, bVar3, aVar);
        for (UiModule uiModule : this.o.values()) {
            if (uiModule != null && uiModule.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                if (uiModule instanceof UiStateModule) {
                    ((UiStateModule) uiModule).a(bVar, bVar2, bVar3, aVar);
                } else if (uiModule instanceof UiStateModuleGroup) {
                    ((UiStateModuleGroup) uiModule).a(bVar, bVar2, bVar3, aVar);
                }
            }
        }
    }

    public void b(b bVar, b bVar2, b bVar3, com.baidu.navisdk.framework.statemachine.a aVar) {
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    public void v() {
        super.v();
        if (!Func.a.f6808a) {
            return;
        }
        b l = ((a) this.i).l();
        Stack stack = new Stack();
        stack.add(l);
        b bVar = l;
        while (((a) this.i).a(bVar) != null) {
            bVar = ((a) this.i).a(bVar);
            stack.add(bVar);
        }
        g gVar = g.NAV_RESULT;
        if (gVar.d()) {
            gVar.e(this.g, "onPostUiInit --> stack = " + stack);
        }
        while (!stack.isEmpty()) {
            a(null, l, (b) stack.pop(), null);
        }
    }

    @LayoutRes
    public int x() {
        return -1;
    }

    @IdRes
    public int y() {
        return -1;
    }

    public View z() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.navisdk.uiframe.UiModule
    @SuppressLint({"ResourceType"})
    public View b(int i, @Nullable View view) {
        View z = z();
        if (z != null) {
            return z;
        }
        if (x() <= 0) {
            View z2 = z();
            return (z2 != null || view == null || y() <= 0) ? z2 : view.findViewById(y());
        }
        g gVar = g.B4NAV;
        if (gVar.d()) {
            ((a) this.i).b(o(), "main thread inflate " + o() + " layout!");
        }
        View inflate = LayoutInflater.from(((a) n()).a()).inflate(x(), (ViewGroup) null, false);
        if (gVar.d()) {
            ((a) this.i).a(o(), "main thread inflate " + o() + " layout!");
        }
        return inflate;
    }
}
