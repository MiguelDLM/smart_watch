package com.baidu.navisdk.pronavi.hd.hdnavi;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.heatmonitor.h;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.i0;
import com.baidu.navisdk.util.common.g;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class a implements com.baidu.navisdk.framework.interfaces.pronavi.hd.b, a.InterfaceC0201a {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.framework.interfaces.pronavi.hd.e f7726a;
    private boolean b;

    /* renamed from: com.baidu.navisdk.pronavi.hd.hdnavi.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0317a {
        private C0317a() {
        }

        public /* synthetic */ C0317a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements i0.f {
        public b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            com.baidu.navisdk.framework.interfaces.pronavi.hd.e eVar = a.this.f7726a;
            if (eVar != null) {
                eVar.b();
            }
        }
    }

    static {
        new C0317a(null);
    }

    private final void c() {
        if (!this.b) {
            com.baidu.navisdk.framework.message.a.a().b(this, h.class, new Class[0]);
            this.b = true;
        }
    }

    private final void d() {
        this.b = false;
        com.baidu.navisdk.framework.message.a.a().a((a.InterfaceC0201a) this);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void b(int i, int i2, boolean z, @OOXIXo com.baidu.navisdk.framework.interfaces.pronavi.hd.f params) {
        IIX0o.x0xO0oo(params, "params");
        c();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void e(int i, int i2, boolean z, @OOXIXo com.baidu.navisdk.framework.interfaces.pronavi.hd.f params) {
        IIX0o.x0xO0oo(params, "params");
        c();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void f(int i, int i2, boolean z, @OOXIXo com.baidu.navisdk.framework.interfaces.pronavi.hd.f params) {
        IIX0o.x0xO0oo(params, "params");
        d();
        s.T().e(135);
    }

    @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
    public void onEvent(@oOoXoXO Object obj) {
        if ((obj instanceof h) && ((h) obj).a() == 3) {
            b();
        }
    }

    public final void a(@OOXIXo com.baidu.navisdk.framework.interfaces.pronavi.hd.e viewCallback) {
        IIX0o.x0xO0oo(viewCallback, "viewCallback");
        this.f7726a = viewCallback;
    }

    public final void b() {
        if (s.T().l(135)) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDHotAlertView", "showQuitAlert is showing");
                return;
            }
            return;
        }
        com.baidu.navisdk.framework.interfaces.pronavi.hd.e eVar = this.f7726a;
        if (eVar != null && !eVar.c()) {
            g gVar2 = g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGHDHotAlertView", "showQuitAlert canShow false");
                return;
            }
            return;
        }
        if (!s.T().b(135)) {
            g gVar3 = g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGHDHotAlertView", "showQuitAlert false");
                return;
            }
            return;
        }
        x.b().k(135).D(100).v(10000).y(true).d(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_rg_hd_overheat_icon)).a("您的手机发热严重，建议您退出车道级导航").g("退出车道级").f(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_negative)).z(2).a(new b()).y();
        com.baidu.navisdk.framework.interfaces.pronavi.hd.e eVar2 = this.f7726a;
        if (eVar2 != null) {
            eVar2.a();
        }
    }

    public final void a() {
        d();
        s.T().e(135);
    }
}
