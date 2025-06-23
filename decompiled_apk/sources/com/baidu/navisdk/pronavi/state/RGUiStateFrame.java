package com.baidu.navisdk.pronavi.state;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.module.pronavi.msg.c;
import com.baidu.navisdk.pronavi.state.b;
import com.baidu.navisdk.uiframe.ModularUiFrame;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public abstract class RGUiStateFrame<C extends b> extends ModularUiFrame<C> implements a, com.baidu.navisdk.module.pronavi.b, c, BNMapObserver {
    public RGUiStateFrame(String str, @NonNull C c, View view) {
        super(str, c, view);
    }

    public void a(com.baidu.navisdk.comapi.base.c cVar, int i, int i2, Object obj) {
    }

    @Override // com.baidu.navisdk.pronavi.state.a
    public final void b(String str, String str2, Bundle bundle) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.f9211a, "enter: " + str + "," + str2 + "," + bundle);
        }
        c(str, str2, bundle);
        ((RGUiStateModuleGroup) c()).b(str, str2, bundle);
    }

    public void c(String str, String str2, Bundle bundle) {
    }

    public void d(String str, String str2, Bundle bundle) {
    }

    @Override // com.baidu.navisdk.uiframe.ModularUiFrame
    public void e() {
        super.e();
    }

    @Override // com.baidu.navisdk.uiframe.ModularUiFrame
    public void f() {
        super.f();
    }

    @Override // com.baidu.navisdk.uiframe.ModularUiFrame
    public void g() {
        super.g();
    }

    @Override // com.baidu.navisdk.uiframe.ModularUiFrame
    public void h() {
        super.h();
    }

    @Override // com.baidu.navisdk.uiframe.ModularUiFrame
    public void i() {
        super.i();
    }

    @Override // com.baidu.navisdk.uiframe.ModularUiFrame
    public void j() {
        super.j();
    }

    public void k() {
        l();
        ((RGUiStateModuleGroup) c()).x();
    }

    public void l() {
    }

    @Override // com.baidu.navisdk.comapi.base.b
    public void update(com.baidu.navisdk.comapi.base.c cVar, int i, int i2, Object obj) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.f9211a, "update: " + cVar + ",type:" + i + ",event: " + i2 + ", arg:" + obj);
        }
        a(cVar, i, i2, obj);
        ((RGUiStateModuleGroup) c()).update(cVar, i, i2, obj);
    }

    @Override // com.baidu.navisdk.module.pronavi.msg.c
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
            gVar.e(this.f9211a, "exit: " + str + "," + str2 + "," + bundle);
        }
        d(str, str2, bundle);
        ((RGUiStateModuleGroup) c()).a(str, str2, bundle);
    }

    @Override // com.baidu.navisdk.module.pronavi.b
    public boolean b(Message message) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.f9211a, "receiveNaviSubStatus: " + message);
        }
        c(message);
        ((RGUiStateModuleGroup) c()).b(message);
        return false;
    }

    @Override // com.baidu.navisdk.module.pronavi.msg.c
    public void a(Message message) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.f9211a, "receiveMsg: " + message);
        }
    }

    public void a(boolean z) {
        ((RGUiStateModuleGroup) c()).a(z);
    }
}
