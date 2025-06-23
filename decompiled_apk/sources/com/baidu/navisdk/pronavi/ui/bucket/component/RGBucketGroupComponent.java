package com.baidu.navisdk.pronavi.ui.bucket.component;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.pronavi.ui.base.RGUiModuleGroup;
import com.baidu.navisdk.pronavi.ui.bucket.RGLeftBucketComponent;
import com.baidu.navisdk.pronavi.ui.bucket.RGRightBucketComponent;
import com.baidu.navisdk.pronavi.ui.bucket.item.concrete.e;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.util.common.g;
import kotlin.LazyThreadSafetyMode;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public class RGBucketGroupComponent extends RGUiModuleGroup<com.baidu.navisdk.pronavi.ui.base.b> {

    @oOoXoXO
    private RGLeftBucketComponent p;

    @oOoXoXO
    private RGRightBucketComponent q;
    private final X0IIOO r;
    private final X0IIOO s;

    /* loaded from: classes7.dex */
    public static final class a extends Lambda implements oIX0oI<C0336a> {

        /* renamed from: com.baidu.navisdk.pronavi.ui.bucket.component.RGBucketGroupComponent$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0336a implements com.baidu.navisdk.pronavi.logic.ugc.a {
            public C0336a() {
            }

            @Override // com.baidu.navisdk.pronavi.logic.ugc.a
            public void a(int i, @OOXIXo String title, int i2) {
                IIX0o.x0xO0oo(title, "title");
                RGBucketGroupComponent.this.a(i, title, i2);
            }
        }

        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final C0336a invoke() {
            return new C0336a();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends Lambda implements oIX0oI<com.baidu.navisdk.pronavi.logic.ugc.b> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f7851a = new b();

        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.pronavi.logic.ugc.b invoke() {
            return new com.baidu.navisdk.pronavi.logic.ugc.b();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGBucketGroupComponent(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b uiContext) {
        super(uiContext);
        IIX0o.x0xO0oo(uiContext, "uiContext");
        this.r = XIxXXX0x0.I0Io(LazyThreadSafetyMode.NONE, b.f7851a);
        this.s = XIxXXX0x0.oIX0oI(new a());
    }

    private final com.baidu.navisdk.pronavi.logic.ugc.a D() {
        return (com.baidu.navisdk.pronavi.logic.ugc.a) this.s.getValue();
    }

    private final com.baidu.navisdk.pronavi.logic.ugc.b E() {
        return (com.baidu.navisdk.pronavi.logic.ugc.b) this.r.getValue();
    }

    private final boolean F() {
        if (((e) a(40, e.class)) != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void G() {
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b bVar;
        if (F() && (bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b) ((com.baidu.navisdk.pronavi.ui.base.b) n()).c(com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b.class)) != null) {
            bVar.g();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void H() {
        com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b bVar;
        if (F() && (bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b) ((com.baidu.navisdk.pronavi.ui.base.b) n()).c(com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b.class)) != null) {
            bVar.k();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiModuleGroup
    public void A() {
        super.A();
        H();
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiModuleGroup
    public void C() {
        super.C();
        e eVar = (e) a(40, e.class);
        if (eVar != null) {
            eVar.b(false);
        }
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    @oOoXoXO
    public View b(int i, @oOoXoXO View view) {
        return view;
    }

    @Override // com.baidu.navisdk.pronavi.state.RGUiStateModuleGroup
    public void c(@oOoXoXO String str, @oOoXoXO String str2, @oOoXoXO Bundle bundle) {
        boolean z;
        super.c(str, str2, bundle);
        String str3 = null;
        if (bundle != null) {
            z = bundle.getBoolean(RGFSMTable.FsmParamsKey.ORIENTATION_CHANGE);
            str3 = bundle.getString(RGFSMTable.FsmParamsKey.RUN_EVENT, null);
        } else {
            z = false;
        }
        if (z) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(this.g, "onEnter: isOrientationChange");
                return;
            }
            return;
        }
        if (TextUtils.equals(str, str2) && IIX0o.Oxx0IOOO(RGFSMTable.FsmState.BrowseMap, str) && !IIX0o.Oxx0IOOO(RGFSMTable.FsmEvent.VOICE_STATE_EXIT, str3)) {
            g gVar2 = g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e(this.g, "onEnter: org == dest(" + str + ")," + str3);
                return;
            }
            return;
        }
        g gVar3 = g.PRO_NAV;
        if (gVar3.d()) {
            gVar3.e(this.g, "onEnter: " + str + org.apache.commons.text.oIX0oI.f33048oxoX + str2 + ", " + str3);
        }
        RGLeftBucketComponent rGLeftBucketComponent = this.p;
        if (rGLeftBucketComponent != null) {
            rGLeftBucketComponent.J();
        }
        RGRightBucketComponent rGRightBucketComponent = this.q;
        if (rGRightBucketComponent != null) {
            rGRightBucketComponent.J();
        }
        e eVar = (e) a(40, e.class);
        if (eVar != null) {
            eVar.a(str2, str);
        }
        H();
        G();
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiModuleGroup
    public void d(@OOXIXo Message msg) {
        IIX0o.x0xO0oo(msg, "msg");
        super.d(msg);
        boolean z = false;
        if (msg.arg2 != 5) {
            b(false);
            return;
        }
        if (msg.arg1 != 11) {
            z = true;
        }
        b(z);
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiModuleGroup, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        this.p = (RGLeftBucketComponent) d("RGLeftBucketComponent");
        this.q = (RGRightBucketComponent) d("RGRightBucketComponent");
        E().b();
        E().a(D());
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiModuleGroup, com.baidu.navisdk.uiframe.UiModuleGroup, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        E().a();
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void j() {
        super.j();
    }

    @Override // com.baidu.navisdk.framework.func.Func
    @OOXIXo
    public String o() {
        return "RGBucketGroupComponent";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final h b(com.baidu.navisdk.apicenter.a aVar) {
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b bVar;
        if (!F()) {
            return null;
        }
        int d = aVar.d();
        if (d == 1001) {
            com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b bVar2 = (com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b) ((com.baidu.navisdk.pronavi.ui.base.b) n()).c(com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b.class);
            if (bVar2 != null) {
                bVar2.a(0);
            }
        } else if (d == 1002) {
            com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b bVar3 = (com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b) ((com.baidu.navisdk.pronavi.ui.base.b) n()).c(com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b.class);
            if (bVar3 != null) {
                bVar3.c(0);
            }
        } else if (d == 1005) {
            G();
            H();
        } else if (d == 1017) {
            c(aVar);
        } else if (d == 2003 && (bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b) ((com.baidu.navisdk.pronavi.ui.base.b) n()).c(com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b.class)) != null) {
            bVar.e(aVar.b("paramA"));
        }
        return null;
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    @oOoXoXO
    public h a(@OOXIXo com.baidu.navisdk.apicenter.a api) {
        IIX0o.x0xO0oo(api, "api");
        h b2 = b(api);
        if (b2 != null) {
            return b2;
        }
        RGLeftBucketComponent rGLeftBucketComponent = this.p;
        h a2 = rGLeftBucketComponent != null ? rGLeftBucketComponent.a(api) : null;
        RGRightBucketComponent rGRightBucketComponent = this.q;
        return a2 != null ? a2 : rGRightBucketComponent != null ? rGRightBucketComponent.a(api) : null;
    }

    @oOoXoXO
    public final <T> T a(int i, @OOXIXo Class<T> cls) {
        IIX0o.x0xO0oo(cls, "cls");
        RGLeftBucketComponent rGLeftBucketComponent = this.p;
        Object a2 = rGLeftBucketComponent != null ? rGLeftBucketComponent.a(i, cls) : null;
        if (a2 != null) {
            return (T) a2;
        }
        RGRightBucketComponent rGRightBucketComponent = this.q;
        if (rGRightBucketComponent != null) {
            return (T) rGRightBucketComponent.a(i, cls);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a(int i, String str, int i2) {
        if (F()) {
            com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b) ((com.baidu.navisdk.pronavi.ui.base.b) n()).c(com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b.class);
            if (bVar != null) {
                bVar.a(i, str, i2);
            }
            com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b bVar2 = (com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b) ((com.baidu.navisdk.pronavi.ui.base.b) n()).c(com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b.class);
            if (bVar2 != null) {
                bVar2.a(i, str, i2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void b(boolean z) {
        com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b bVar;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            String str = this.g;
            StringBuilder sb = new StringBuilder();
            sb.append("refreshFuzzyGuideView:");
            sb.append(z);
            sb.append(",last:");
            com.baidu.navisdk.ui.routeguide.mapmode.a b2 = x.b();
            IIX0o.oO(b2, "RGViewController.getInstance()");
            sb.append(b2.f2());
            gVar.e(str, sb.toString());
        }
        if (!z) {
            com.baidu.navisdk.ui.routeguide.mapmode.a b3 = x.b();
            IIX0o.oO(b3, "RGViewController.getInstance()");
            if (!b3.f2()) {
                return;
            }
        }
        RGRightBucketComponent rGRightBucketComponent = this.q;
        if (rGRightBucketComponent != null) {
            rGRightBucketComponent.d(z);
        }
        if (!F() || (bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b) ((com.baidu.navisdk.pronavi.ui.base.b) n()).c(com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b.class)) == null) {
            return;
        }
        bVar.k();
    }

    private final void c(com.baidu.navisdk.apicenter.a aVar) {
        int c = aVar.c("paramA");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "refreshBtnVisible: " + com.baidu.navisdk.ui.routeguide.utils.b.a(c));
        }
        if (c != 22) {
            return;
        }
        H();
    }
}
