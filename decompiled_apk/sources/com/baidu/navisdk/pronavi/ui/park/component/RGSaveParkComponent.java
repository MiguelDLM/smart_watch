package com.baidu.navisdk.pronavi.ui.park.component;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.baidu.mapframework.widget.MProgressDialog;
import com.baidu.navisdk.pronavi.ui.base.RGUiComponent;
import com.baidu.navisdk.pronavi.ui.park.bottom.a;
import com.baidu.navisdk.pronavi.ui.park.bottom.b;
import com.baidu.navisdk.ugc.dialog.g;
import com.baidu.navisdk.ugc.pictures.previews.c;
import com.baidu.navisdk.ui.routeguide.control.d;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.c0;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class RGSaveParkComponent extends RGUiComponent<com.baidu.navisdk.pronavi.ui.base.b> implements com.baidu.navisdk.pronavi.ui.park.bottom.b, c.e {
    private String p;
    private com.baidu.navisdk.pronavi.ui.park.bottom.c q;
    private com.baidu.navisdk.module.park.a r;
    private com.baidu.navisdk.ugc.listener.b s;
    private c t;

    /* loaded from: classes7.dex */
    public static final class a implements a.InterfaceC0357a {
        public a() {
        }

        @Override // com.baidu.navisdk.pronavi.ui.park.bottom.a.InterfaceC0357a
        public void a(int i, @oOoXoXO String str, @oOoXoXO Throwable th) {
            a.InterfaceC0357a.C0358a.a(this, i, str, th);
            MProgressDialog.dismiss();
            TipTool.toast("保存失败，请稍后再试");
        }

        @Override // com.baidu.navisdk.pronavi.ui.park.bottom.a.InterfaceC0357a
        public void onStart() {
            com.baidu.navisdk.pronavi.ui.base.b mContext = RGSaveParkComponent.b(RGSaveParkComponent.this);
            IIX0o.oO(mContext, "mContext");
            MProgressDialog.show((FragmentActivity) mContext.e(), (String) null, "加载中", (DialogInterface.OnCancelListener) null);
        }

        @Override // com.baidu.navisdk.pronavi.ui.park.bottom.a.InterfaceC0357a
        public void onSuccess() {
            MProgressDialog.dismiss();
            RGSaveParkComponent.this.D();
            d.e.b(RGSaveParkComponent.this.r);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGSaveParkComponent(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
        g.e().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        com.baidu.navisdk.pronavi.ui.park.bottom.c cVar = this.q;
        if (cVar != null) {
            cVar.c();
        }
    }

    private final void E() {
        if (this.s == null) {
            this.s = new b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F() {
        com.baidu.navisdk.pronavi.ui.base.b context = (com.baidu.navisdk.pronavi.ui.base.b) n();
        IIX0o.oO(context, "context");
        Context a2 = context.a();
        com.baidu.navisdk.pronavi.ui.base.b context2 = (com.baidu.navisdk.pronavi.ui.base.b) n();
        IIX0o.oO(context2, "context");
        ViewGroup H = context2.H();
        com.baidu.navisdk.pronavi.ui.base.b context3 = (com.baidu.navisdk.pronavi.ui.base.b) n();
        IIX0o.oO(context3, "context");
        com.baidu.navisdk.pronavi.ui.park.bottom.c cVar = new com.baidu.navisdk.pronavi.ui.park.bottom.c(a2, H, context3.w());
        this.q = cVar;
        cVar.a(this);
    }

    private final boolean G() {
        CharSequence format = DateFormat.format(DateFormatUtils.YYYY_MM_DD_HH_MM, System.currentTimeMillis());
        if (format != null) {
            String str = (String) format;
            com.baidu.navisdk.module.park.a aVar = this.r;
            if (aVar != null) {
                aVar.b(str);
            }
            com.baidu.navisdk.module.park.a aVar2 = this.r;
            if (aVar2 != null && aVar2.n()) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final void H() {
        if (this.t == null) {
            this.t = new c(this);
        }
        String str = this.p;
        if (str != null) {
            c cVar = this.t;
            IIX0o.ooOOo0oXI(cVar);
            com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V, "BNavigator.getInstance()");
            cVar.a(V.b(), str, 5);
        }
    }

    private final void I() {
        if (this.q == null) {
            F();
            E();
            g.e().a(this.s);
        }
        boolean b2 = com.baidu.navisdk.ui.routeguide.utils.b.b("savePark", false);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "showSaveParkPanel : exitHDNavi: " + b2);
        }
        com.baidu.navisdk.pronavi.ui.park.bottom.c cVar = this.q;
        if (cVar != null) {
            com.baidu.navisdk.module.park.a aVar = this.r;
            IIX0o.ooOOo0oXI(aVar);
            cVar.a(aVar);
        }
    }

    public static final /* synthetic */ com.baidu.navisdk.pronavi.ui.base.b b(RGSaveParkComponent rGSaveParkComponent) {
        return (com.baidu.navisdk.pronavi.ui.base.b) rGSaveParkComponent.i;
    }

    @Override // com.baidu.navisdk.framework.interfaces.y
    @oOoXoXO
    public View[] B() {
        return null;
    }

    @Override // com.baidu.navisdk.pronavi.ui.park.bottom.b
    public void e() {
        b.a.b(this);
        com.baidu.navisdk.module.park.a aVar = this.r;
        if (aVar == null) {
            return;
        }
        this.p = null;
        IIX0o.ooOOo0oXI(aVar);
        aVar.a("");
        com.baidu.navisdk.module.park.a aVar2 = this.r;
        IIX0o.ooOOo0oXI(aVar2);
        aVar2.a((Bitmap) null);
        com.baidu.navisdk.pronavi.ui.park.bottom.c cVar = this.q;
        if (cVar != null) {
            com.baidu.navisdk.module.park.a aVar3 = this.r;
            IIX0o.ooOOo0oXI(aVar3);
            cVar.a(aVar3);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.park.bottom.b
    public void f() {
        b.a.d(this);
        com.baidu.navisdk.pronavi.ui.park.bottom.a.f7950a.a(this.r, new a());
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        c cVar = this.t;
        if (cVar != null) {
            IIX0o.ooOOo0oXI(cVar);
            cVar.c();
            this.t = null;
        }
    }

    @Override // com.baidu.navisdk.framework.func.Func
    @OOXIXo
    public String o() {
        return "RGSaveParkComponent";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.navisdk.pronavi.ui.park.bottom.b
    public void c() {
        b.a.a(this);
        g e = g.e();
        com.baidu.navisdk.pronavi.ui.base.b context = (com.baidu.navisdk.pronavi.ui.base.b) n();
        IIX0o.oO(context, "context");
        e.a(context.e(), 1, this.s, 5);
    }

    @Override // com.baidu.navisdk.pronavi.ui.park.bottom.b
    public void d() {
        b.a.c(this);
        if (this.r == null || TextUtils.isEmpty(this.p)) {
            return;
        }
        H();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
    
        if (r0.a() == true) goto L12;
     */
    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.baidu.navisdk.apicenter.h a(@OXOo.OOXIXo com.baidu.navisdk.apicenter.a r3) {
        /*
            r2 = this;
            java.lang.String r0 = "api"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            int r0 = r3.d()
            r1 = 0
            switch(r0) {
                case 10001: goto L30;
                case 10002: goto L2c;
                case 10003: goto L12;
                default: goto Ld;
            }
        Ld:
            com.baidu.navisdk.apicenter.h r3 = super.a(r3)
            return r3
        L12:
            com.baidu.navisdk.apicenter.h r3 = com.baidu.navisdk.apicenter.h.a()
            com.baidu.navisdk.pronavi.ui.park.bottom.c r0 = r2.q
            if (r0 == 0) goto L22
            boolean r0 = r0.a()
            r1 = 1
            if (r0 != r1) goto L22
            goto L23
        L22:
            r1 = 0
        L23:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            com.baidu.navisdk.apicenter.h r3 = r3.a(r0)
            return r3
        L2c:
            r2.D()
            return r1
        L30:
            java.lang.String r0 = com.baidu.navisdk.framework.b.e()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L3b
            return r1
        L3b:
            java.lang.String r0 = "paramA"
            java.lang.Object r3 = r3.a(r0)
            if (r3 == 0) goto L58
            com.baidu.navisdk.module.park.a r3 = (com.baidu.navisdk.module.park.a) r3
            r2.r = r3
            boolean r3 = r2.G()
            if (r3 != 0) goto L54
            java.lang.String r3 = "当前未获取到车位数据，请稍后再试"
            com.baidu.navisdk.ui.util.TipTool.toast(r3)
            return r1
        L54:
            r2.I()
            return r1
        L58:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type com.baidu.navisdk.module.park.BNRouteSaveParkData"
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.pronavi.ui.park.component.RGSaveParkComponent.a(com.baidu.navisdk.apicenter.a):com.baidu.navisdk.apicenter.h");
    }

    /* loaded from: classes7.dex */
    public static final class b implements com.baidu.navisdk.ugc.listener.b {
        public b() {
        }

        @Override // com.baidu.navisdk.ugc.listener.b
        public void a(@oOoXoXO c0.a aVar) {
            if (aVar == null) {
                return;
            }
            RGSaveParkComponent rGSaveParkComponent = RGSaveParkComponent.this;
            Bitmap bitmap = aVar.b;
            IIX0o.oO(bitmap, "mPicProcessResInfo.bitmap");
            rGSaveParkComponent.a(bitmap);
            RGSaveParkComponent.this.C();
            RGSaveParkComponent.this.p = aVar.f9222a;
            com.baidu.navisdk.module.park.a aVar2 = RGSaveParkComponent.this.r;
            if (aVar2 != null) {
                aVar2.a(aVar.f9222a);
                aVar2.a(aVar.b);
            }
        }

        @Override // com.baidu.navisdk.ugc.listener.b
        public void a(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "str");
            RGSaveParkComponent.this.C();
            RGSaveParkComponent.this.p = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule
    public void a(@OOXIXo Configuration newConfig) {
        IIX0o.x0xO0oo(newConfig, "newConfig");
        super.a(newConfig);
        com.baidu.navisdk.pronavi.ui.park.bottom.c cVar = this.q;
        if (cVar != null) {
            com.baidu.navisdk.pronavi.ui.base.b context = (com.baidu.navisdk.pronavi.ui.base.b) n();
            IIX0o.oO(context, "context");
            cVar.b(context.H(), newConfig.orientation);
        }
        c e = c.e();
        this.t = e;
        if (e != null) {
            IIX0o.ooOOo0oXI(e);
            if (e.b()) {
                c cVar2 = this.t;
                IIX0o.ooOOo0oXI(cVar2);
                cVar2.a(this, (com.baidu.navisdk.ugc.listener.c) null);
            }
        }
        com.baidu.navisdk.pronavi.ui.park.bottom.c cVar3 = this.q;
        if (cVar3 == null || !cVar3.a()) {
            return;
        }
        I();
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    public void a(int i, int i2, @oOoXoXO Intent intent) {
        super.a(i, i2, intent);
        if (g.e().a(i)) {
            g.e().a(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Bitmap bitmap) {
        com.baidu.navisdk.module.park.a aVar = this.r;
        if (aVar == null) {
            return;
        }
        IIX0o.ooOOo0oXI(aVar);
        aVar.a(bitmap);
        com.baidu.navisdk.pronavi.ui.park.bottom.c cVar = this.q;
        if (cVar != null) {
            com.baidu.navisdk.module.park.a aVar2 = this.r;
            IIX0o.ooOOo0oXI(aVar2);
            cVar.a(aVar2);
        }
    }

    @Override // com.baidu.navisdk.ugc.pictures.previews.c.e
    public void a(@oOoXoXO String str) {
        com.baidu.navisdk.module.park.a aVar = this.r;
        if (aVar == null) {
            return;
        }
        this.p = null;
        IIX0o.ooOOo0oXI(aVar);
        aVar.a("");
        com.baidu.navisdk.module.park.a aVar2 = this.r;
        IIX0o.ooOOo0oXI(aVar2);
        aVar2.a((Bitmap) null);
        com.baidu.navisdk.pronavi.ui.park.bottom.c cVar = this.q;
        if (cVar != null) {
            com.baidu.navisdk.module.park.a aVar3 = this.r;
            IIX0o.ooOOo0oXI(aVar3);
            cVar.a(aVar3);
        }
    }
}
