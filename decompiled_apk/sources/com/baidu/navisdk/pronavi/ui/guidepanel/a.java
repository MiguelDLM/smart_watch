package com.baidu.navisdk.pronavi.ui.guidepanel;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.view.View;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.style.c;
import com.baidu.navisdk.pronavi.style.f;
import com.baidu.navisdk.util.common.g;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.pronavi.style.i.a f7915a;
    private final String b;
    private View c;
    private int d;

    /* renamed from: com.baidu.navisdk.pronavi.ui.guidepanel.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0352a {
        private C0352a() {
        }

        public /* synthetic */ C0352a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends c {
        public b(Integer[] numArr) {
            super(numArr);
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        @OOXIXo
        public String a() {
            return a.this.b;
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void b(@oOoXoXO String str) {
            a.this.b();
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void c() {
            a(a.this.c);
        }
    }

    static {
        new C0352a(null);
    }

    @xoIox
    public a(@OOXIXo String str, @oOoXoXO View view) {
        this(str, view, 0, 4, null);
    }

    @xoIox
    public a(@OOXIXo String name, @oOoXoXO View view, int i) {
        IIX0o.x0xO0oo(name, "name");
        this.b = name;
        this.c = view;
        this.d = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        View view = this.c;
        if (view != null) {
            com.baidu.navisdk.ui.util.b.a(view, this.d);
        }
    }

    public final void a(@oOoXoXO View view) {
        this.c = view;
    }

    public /* synthetic */ a(String str, View view, int i, int i2, IIXOooo iIXOooo) {
        this(str, view, (i2 & 4) != 0 ? R.drawable.bn_bg_rg_new_simple_guide_view : i);
    }

    public final void a() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSimpleGuideChangeStyle", "registerChangeStyleHelper: " + this.b);
        }
        if (this.f7915a == null) {
            b bVar = new b(new Integer[0]);
            this.f7915a = bVar;
            f.b.a("NormalSimpleGuidePanel", bVar);
        }
    }
}
