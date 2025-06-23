package com.baidu.navisdk.pronavi.ui.bubble;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.ui.base.RGUiComponent;
import com.baidu.navisdk.pronavi.ui.base.b;
import com.baidu.navisdk.ui.bubble.a;
import com.baidu.navisdk.ui.bubble.b;
import com.baidu.navisdk.ui.bubble.e;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public class RGBubbleBaseComponent<C extends b> extends RGUiComponent<C> {
    protected com.baidu.navisdk.ui.bubble.a p;

    /* loaded from: classes7.dex */
    public class a implements e {
        public a(RGBubbleBaseComponent rGBubbleBaseComponent) {
        }

        @Override // com.baidu.navisdk.ui.bubble.e
        public void a(com.baidu.navisdk.ui.bubble.b bVar) {
        }

        @Override // com.baidu.navisdk.ui.bubble.e
        public void b(com.baidu.navisdk.ui.bubble.b bVar) {
        }

        @Override // com.baidu.navisdk.ui.bubble.e
        public boolean a() {
            return true;
        }
    }

    public RGBubbleBaseComponent(@NonNull C c) {
        super(c);
    }

    private View E() {
        h a2 = ((b) this.i).j().e("RGBucketGroupComponent").a(1019).a();
        if (a2 == null) {
            return null;
        }
        return (View) a2.a("resultA", (String) null);
    }

    @Override // com.baidu.navisdk.framework.interfaces.y
    public View[] B() {
        return null;
    }

    public com.baidu.navisdk.ui.bubble.b C() {
        com.baidu.navisdk.ui.bubble.b bVar = new com.baidu.navisdk.ui.bubble.b();
        bVar.d(1);
        bVar.b(3);
        bVar.c(160);
        bVar.a("护航模式开启中");
        bVar.a(E());
        bVar.a(5000);
        b.a aVar = new b.a(bVar);
        aVar.a(0);
        bVar.a(aVar);
        bVar.a(new a(this));
        return bVar;
    }

    public void D() {
        if (this.k == null) {
            ViewGroup s0 = x.b().s0();
            try {
                this.k = ((ViewStub) s0.findViewById(R.id.nsdk_layout_rg_bubble_container_stub)).inflate();
            } catch (Exception e) {
                g gVar = g.PRO_NAV;
                if (gVar.c()) {
                    gVar.c(this.g, "onContentViewCreate: " + e);
                }
            }
            if (this.k == null) {
                this.k = s0.findViewById(R.id.bnav_rg_bubble_container);
            }
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule
    public void a(Configuration configuration) {
        super.a(configuration);
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule
    public View b(int i, @Nullable View view) {
        g gVar = g.PRO_NAV;
        if (!gVar.d()) {
            return null;
        }
        gVar.e(this.g, "onContentViewCreate: ");
        return null;
    }

    @Override // com.baidu.navisdk.pronavi.state.RGUiStateModule
    public void c(String str, String str2, Bundle bundle) {
        super.c(str, str2, bundle);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "onEnter: " + str + "," + str2 + ", " + bundle);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.pronavi.state.RGUiStateModule, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void i() {
        super.i();
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void j() {
        super.j();
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void k() {
        super.k();
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void l() {
        super.l();
        b(-1);
    }

    @Override // com.baidu.navisdk.framework.func.Func
    public String o() {
        return "RGBubbleComponent";
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    public boolean p() {
        return false;
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    public String[] t() {
        return new String[]{"onCreate"};
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    public h a(@NonNull com.baidu.navisdk.apicenter.a aVar) {
        int d = aVar.d();
        if (d == 3001) {
            b(aVar.a("paramA", -1));
            return null;
        }
        if (d != 3002) {
            return super.a(aVar);
        }
        c(aVar.a("paramA", -1));
        return null;
    }

    public void b(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "hideBubbleNew: " + i);
        }
        com.baidu.navisdk.ui.bubble.a aVar = this.p;
        if (aVar == null) {
            return;
        }
        if (i == -1 || aVar.a(i)) {
            this.p.a();
            this.p = null;
        }
    }

    public void c(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "showBubble: " + i);
        }
        com.baidu.navisdk.ui.bubble.a aVar = this.p;
        if (aVar == null || !aVar.a(i)) {
            D();
            a.C0403a c0403a = new a.C0403a(((com.baidu.navisdk.pronavi.ui.base.b) this.i).a(), (FrameLayout) this.k);
            if (i != 1) {
                c0403a = null;
            } else {
                c0403a.a(C());
            }
            if (c0403a != null) {
                this.p = c0403a.b();
            }
        }
    }
}
