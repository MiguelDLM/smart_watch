package com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.widget.RGImageTextBtn;
import com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout;
import com.baidu.navisdk.util.common.e;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class a extends BNExpandConstraintLayout.Adapter {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> f7891a;
    private com.baidu.navisdk.pronavi.widget.a b;
    private final com.baidu.navisdk.pronavi.ui.base.b c;

    /* renamed from: com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0343a {
        private C0343a() {
        }

        public /* synthetic */ C0343a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new C0343a(null);
    }

    public a(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b uiContext) {
        IIX0o.x0xO0oo(uiContext, "uiContext");
        this.c = uiContext;
    }

    private final com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b(int i) {
        ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> arrayList = this.f7891a;
        if (arrayList != null) {
            return (com.baidu.navisdk.pronavi.ui.buttoncollect.data.a) CollectionsKt___CollectionsKt.OIoxIx(arrayList, i);
        }
        return null;
    }

    private final boolean c(int i) {
        ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> arrayList = this.f7891a;
        if (arrayList == null) {
            return false;
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.data.a) CollectionsKt___CollectionsKt.OIoxIx(arrayList, i);
        return IIX0o.Oxx0IOOO(aVar != null ? aVar.e() : null, "scenicBroadcast");
    }

    public final void a(@OOXIXo ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> btnList) {
        IIX0o.x0xO0oo(btnList, "btnList");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicBtnAdapter", "handleDynamicBtnList: " + btnList);
        }
        this.f7891a = btnList;
        onUpdateAllDynamicItem();
    }

    public final void d() {
        com.baidu.navisdk.pronavi.widget.a aVar = this.b;
        if (aVar != null) {
            aVar.d();
        }
    }

    public final void e() {
        com.baidu.navisdk.pronavi.widget.a aVar = this.b;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout.Adapter
    public int getDynamicItemSize() {
        ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> arrayList = this.f7891a;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout.Adapter
    public int getItemViewType(int i) {
        return c(i) ? 1 : 0;
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout.Adapter
    @oOoXoXO
    public View onCreateBottomFixedView(@OOXIXo Context context, @OOXIXo ViewGroup parentView, @oOoXoXO View view, boolean z, int i) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(parentView, "parentView");
        return null;
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout.Adapter
    @oOoXoXO
    public View onCreateDynamicHeadView(@OOXIXo Context context, @OOXIXo ViewGroup parentView, @oOoXoXO View view, boolean z, int i) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(parentView, "parentView");
        return null;
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout.Adapter
    @OOXIXo
    public View onCreateDynamicItemDivider(@OOXIXo Context context, @OOXIXo ViewGroup parentView, @oOoXoXO View view, boolean z, int i) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(parentView, "parentView");
        if (view == null) {
            view = new View(context);
        }
        com.baidu.navisdk.ui.util.b.a(view, R.color.bnav_rg_btn_collect_divider_color);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, 1);
        int dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_10dp);
        marginLayoutParams.leftMargin = dimensionPixelSize;
        marginLayoutParams.rightMargin = dimensionPixelSize;
        view.setLayoutParams(marginLayoutParams);
        return view;
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout.Adapter
    @oOoXoXO
    public View onCreateDynamicView(@OOXIXo Context context, @OOXIXo ViewGroup parentView, int i, @oOoXoXO View view, boolean z, int i2, int i3) {
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar;
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(parentView, "parentView");
        g gVar = g.PRO_NAV;
        String str = null;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("onCreateDynamicView: ");
            sb.append(i3);
            sb.append(", ");
            ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> arrayList = this.f7891a;
            if (arrayList != null) {
                aVar = arrayList.get(i);
            } else {
                aVar = null;
            }
            sb.append(aVar);
            gVar.e("RGDynamicBtnAdapter", sb.toString());
        }
        if (i3 == 1) {
            if (gVar.d()) {
                gVar.e("RGDynamicBtnAdapter", "onCreateDynamicView: isScenicBroadcastBtn," + i);
            }
            if (this.b == null) {
                this.b = new com.baidu.navisdk.pronavi.widget.a(this.c, R.drawable.transparent);
            }
            com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b = b(i);
            com.baidu.navisdk.pronavi.widget.a aVar2 = this.b;
            IIX0o.ooOOo0oXI(aVar2);
            View a2 = aVar2.a(parentView, i2, context);
            if (b != null) {
                str = b.e();
            }
            a2.setTag(str);
            return a2;
        }
        if (view != null) {
            a(b(i), view);
            return view;
        }
        return a(context, b(i), i2);
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout.Adapter
    public void onOrientationDynamicView(@OOXIXo Context context, @OOXIXo ViewGroup parentView, @oOoXoXO View view, int i, int i2) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(parentView, "parentView");
        if (i2 == 1) {
            com.baidu.navisdk.pronavi.widget.a aVar = this.b;
            if (aVar != null) {
                aVar.a(i);
                return;
            }
            return;
        }
        a(i, view);
    }

    public final boolean b() {
        com.baidu.navisdk.pronavi.widget.a aVar = this.b;
        return aVar != null && aVar.c();
    }

    public final void c() {
        com.baidu.navisdk.pronavi.widget.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
        }
    }

    private final void a(int i, View view) {
        if (view != null) {
            if (view instanceof RGImageTextBtn) {
                Pair<Integer, Integer> a2 = a(i);
                ((RGImageTextBtn) view).a(i, a2.component1().intValue(), a2.component2().intValue());
                return;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                Pair<Integer, Integer> a3 = a(i);
                int intValue = a3.component1().intValue();
                int intValue2 = a3.component2().intValue();
                layoutParams.width = intValue;
                layoutParams.height = intValue2;
            }
        }
    }

    private final RGImageTextBtn a(Context context, com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar, int i) {
        RGImageTextBtn a2;
        if (aVar == null) {
            return null;
        }
        Pair<Integer, Integer> a3 = a(i);
        int intValue = a3.component1().intValue();
        int intValue2 = a3.component2().intValue();
        if (aVar.c() != 0) {
            Drawable a4 = a(aVar);
            RGImageTextBtn.a aVar2 = RGImageTextBtn.b;
            IIX0o.ooOOo0oXI(a4);
            a2 = aVar2.a(context, a4, aVar.f(), i, aVar.a(), intValue, intValue2, aVar.g());
        } else {
            a2 = RGImageTextBtn.b.a(context, aVar.b(), aVar.f(), i, R.drawable.transparent, intValue, intValue2, aVar.g());
        }
        a2.setTag(aVar.e());
        return a2;
    }

    private final void a(com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar, View view) {
        if (!(view instanceof RGImageTextBtn)) {
            view = null;
        }
        RGImageTextBtn rGImageTextBtn = (RGImageTextBtn) view;
        if (rGImageTextBtn != null) {
            RGImageTextBtn rGImageTextBtn2 = aVar != null ? rGImageTextBtn : null;
            if (rGImageTextBtn2 != null) {
                IIX0o.ooOOo0oXI(aVar);
                if (aVar.c() != 0) {
                    rGImageTextBtn2.setIconDrawable(a(aVar));
                } else {
                    rGImageTextBtn2.setIcon(aVar.b());
                }
                rGImageTextBtn2.setBg(aVar.a());
                rGImageTextBtn2.setTextContent(aVar.f());
                rGImageTextBtn2.setTextColor(aVar.g());
                rGImageTextBtn2.setTag(aVar.e());
            }
        }
    }

    private final Drawable a(com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar) {
        if (aVar == null) {
            return null;
        }
        Drawable drawable = JarUtils.getResources().getDrawable(aVar.b());
        return aVar.c() != 0 ? e.a(drawable, aVar.c()) : drawable;
    }

    private final Pair<Integer, Integer> a(int i) {
        if (i == 2) {
            return new Pair<>(-1, Integer.valueOf(JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_btn_collect_btn_land_height)));
        }
        return new Pair<>(-1, Integer.valueOf(JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_btn_collect_btn_port_height)));
    }

    public final boolean a() {
        com.baidu.navisdk.pronavi.widget.a aVar = this.b;
        return aVar != null && aVar.b();
    }
}
