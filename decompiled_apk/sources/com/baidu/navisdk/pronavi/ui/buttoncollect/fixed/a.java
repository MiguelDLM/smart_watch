package com.baidu.navisdk.pronavi.ui.buttoncollect.fixed;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    private com.baidu.navisdk.pronavi.ui.buttoncollect.data.a f7893a;
    private ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> b;

    /* renamed from: com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0345a {
        private C0345a() {
        }

        public /* synthetic */ C0345a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new C0345a(null);
    }

    private final Drawable b(com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar) {
        if (aVar == null) {
            return null;
        }
        Drawable drawable = JarUtils.getResources().getDrawable(aVar.b());
        return aVar.c() != 0 ? e.a(drawable, aVar.c()) : drawable;
    }

    private final com.baidu.navisdk.pronavi.ui.buttoncollect.data.a c(int i) {
        ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> arrayList = this.b;
        if (arrayList != null) {
            return (com.baidu.navisdk.pronavi.ui.buttoncollect.data.a) CollectionsKt___CollectionsKt.OIoxIx(arrayList, i);
        }
        return null;
    }

    public final void a(@OOXIXo com.baidu.navisdk.pronavi.ui.buttoncollect.data.a btn) {
        IIX0o.x0xO0oo(btn, "btn");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFixedBtnAdapter", "handleBottomFixedBtn: " + btn);
        }
        this.f7893a = btn;
        onUpdateBottomFixedView();
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout.Adapter
    public long getAnimationDuration() {
        return 300L;
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout.Adapter
    public int getDynamicItemSize() {
        ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> arrayList = this.b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout.Adapter
    @oOoXoXO
    public View onCreateBottomFixedView(@OOXIXo Context context, @OOXIXo ViewGroup parentView, @oOoXoXO View view, boolean z, int i) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(parentView, "parentView");
        if (view != null) {
            a(this.f7893a, view);
            return view;
        }
        return a(context, this.f7893a, i);
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout.Adapter
    @oOoXoXO
    public View onCreateDynamicHeadView(@OOXIXo Context context, @OOXIXo ViewGroup parentView, @oOoXoXO View view, boolean z, int i) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(parentView, "parentView");
        if (view == null) {
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            com.baidu.navisdk.ui.util.b.a(imageView, R.drawable.bnav_rg_2_whippletree);
            imageView.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, b(i)));
            return imageView;
        }
        return view;
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
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(parentView, "parentView");
        if (view != null) {
            a(c(i), view);
            return view;
        }
        return a(context, c(i), i2);
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout.Adapter
    public void onOrientationBottomFixedView(@OOXIXo Context context, @OOXIXo ViewGroup parentView, @oOoXoXO View view, int i) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(parentView, "parentView");
        a(i, view);
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout.Adapter
    public void onOrientationDynamicHeadView(@OOXIXo Context context, @OOXIXo ViewGroup parentView, @oOoXoXO View view, int i) {
        ViewGroup.LayoutParams layoutParams;
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(parentView, "parentView");
        if (view != null && (layoutParams = view.getLayoutParams()) != null) {
            layoutParams.height = b(i);
        }
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout.Adapter
    public void onOrientationDynamicView(@OOXIXo Context context, @OOXIXo ViewGroup parentView, @oOoXoXO View view, int i, int i2) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(parentView, "parentView");
        a(i, view);
    }

    private final int b(int i) {
        if (i == 2) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_24dp);
        }
        return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_26dp);
    }

    public final void a(@OOXIXo ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> btnList) {
        IIX0o.x0xO0oo(btnList, "btnList");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFixedBtnAdapter", "handleDynamicBtnList: " + btnList);
        }
        this.b = btnList;
        onUpdateAllDynamicItem();
    }

    public final void a(@OOXIXo Pair<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a, Integer> pair) {
        IIX0o.x0xO0oo(pair, "pair");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFixedBtnAdapter", "updateDynamicBtn: " + pair);
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a first = pair.getFirst();
        onUpdateDynamicItem(first != null ? first.e() : null, pair.getSecond().intValue());
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
            Drawable b = b(aVar);
            RGImageTextBtn.a aVar2 = RGImageTextBtn.b;
            IIX0o.ooOOo0oXI(b);
            a2 = aVar2.a(context, b, aVar.f(), i, R.drawable.transparent, intValue, intValue2, aVar.g());
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
                    rGImageTextBtn2.setIconDrawable(b(aVar));
                } else {
                    rGImageTextBtn2.setIcon(aVar.b());
                }
                rGImageTextBtn2.setTextContent(aVar.f());
                rGImageTextBtn2.setTextColor(aVar.g());
                rGImageTextBtn2.setTag(aVar.e());
            }
        }
    }

    private final Pair<Integer, Integer> a(int i) {
        if (i == 2) {
            return new Pair<>(-1, Integer.valueOf(JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_btn_collect_btn_land_height)));
        }
        return new Pair<>(-1, Integer.valueOf(JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_btn_collect_btn_port_height)));
    }
}
