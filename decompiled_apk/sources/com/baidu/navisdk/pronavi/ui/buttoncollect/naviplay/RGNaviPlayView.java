package com.baidu.navisdk.pronavi.ui.buttoncollect.naviplay;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.widget.RGImageTextBtn;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class RGNaviPlayView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<RGImageTextBtn> f7904a;
    private final ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> b;
    private b c;
    private final Rect d;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(@OOXIXo com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar, @OOXIXo View view);
    }

    /* loaded from: classes7.dex */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View it) {
            RGNaviPlayView rGNaviPlayView = RGNaviPlayView.this;
            IIX0o.oO(it, "it");
            rGNaviPlayView.a(it);
        }
    }

    static {
        new a(null);
    }

    @xoIox
    public RGNaviPlayView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    private final Pair<Integer, Integer> b(int i) {
        if (i == 2) {
            return new Pair<>(Integer.valueOf(JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_btn_collect_btn_land_height)), -1);
        }
        return new Pair<>(Integer.valueOf(JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_btn_collect_btn_port_height)), -1);
    }

    @OOXIXo
    public final Rect getLayoutBgShadow() {
        Drawable background = getBackground();
        if (background != null) {
            background.getPadding(this.d);
        }
        return this.d;
    }

    public final void setOnClickListener(@OOXIXo b onClickListener) {
        IIX0o.x0xO0oo(onClickListener, "onClickListener");
        this.c = onClickListener;
    }

    @xoIox
    public RGNaviPlayView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    public final void a(@OOXIXo ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> btnList, int i) {
        IIX0o.x0xO0oo(btnList, "btnList");
        this.b.clear();
        this.b.addAll(btnList);
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            RGImageTextBtn rGImageTextBtn = (RGImageTextBtn) CollectionsKt___CollectionsKt.OIoxIx(this.f7904a, i2);
            if (rGImageTextBtn == null) {
                com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar = this.b.get(i2);
                IIX0o.oO(aVar, "mBtnDataList.get(index)");
                RGImageTextBtn a2 = a(aVar, i);
                addView(a2);
                this.f7904a.add(a2);
                a2.setOnClickListener(new c());
                if (i2 != size - 1) {
                    addView(a());
                }
            } else {
                a(rGImageTextBtn, this.b.get(i2));
            }
        }
    }

    public /* synthetic */ RGNaviPlayView(Context context, AttributeSet attributeSet, int i, int i2, int i3, IIXOooo iIXOooo) {
        this(context, attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public RGNaviPlayView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        IIX0o.x0xO0oo(context, "context");
        setOrientation(0);
        this.f7904a = new ArrayList<>(3);
        this.b = new ArrayList<>(3);
        this.d = new Rect();
    }

    public final void a(int i) {
        for (RGImageTextBtn rGImageTextBtn : this.f7904a) {
            Pair<Integer, Integer> b2 = b(i);
            rGImageTextBtn.a(i, b2.component1().intValue(), b2.component2().intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(View view) {
        int ox0I2 = CollectionsKt___CollectionsKt.ox0I(this.f7904a, view);
        b bVar = this.c;
        if (bVar != null) {
            com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar = this.b.get(ox0I2);
            IIX0o.oO(aVar, "mBtnDataList.get(index)");
            bVar.a(aVar, view);
        }
    }

    private final RGImageTextBtn a(com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar, int i) {
        Pair<Integer, Integer> b2 = b(i);
        int intValue = b2.component1().intValue();
        int intValue2 = b2.component2().intValue();
        RGImageTextBtn.a aVar2 = RGImageTextBtn.b;
        Context context = getContext();
        IIX0o.oO(context, "context");
        RGImageTextBtn a2 = aVar2.a(context, aVar.b(), aVar.f(), i, R.drawable.transparent, intValue, intValue2, aVar.g());
        a2.setTag(aVar.e());
        return a2;
    }

    private final View a() {
        View view = new View(getContext());
        com.baidu.navisdk.ui.util.b.a(view, R.color.bnav_rg_btn_collect_divider_color);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(1, -1);
        int dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_10dp);
        marginLayoutParams.topMargin = dimensionPixelSize;
        marginLayoutParams.bottomMargin = dimensionPixelSize;
        view.setLayoutParams(marginLayoutParams);
        return view;
    }

    private final void a(RGImageTextBtn rGImageTextBtn, com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar) {
        if (rGImageTextBtn != null) {
            if (aVar == null) {
                rGImageTextBtn = null;
            }
            if (rGImageTextBtn != null) {
                IIX0o.ooOOo0oXI(aVar);
                rGImageTextBtn.setIcon(aVar.b());
                rGImageTextBtn.setTextContent(aVar.f());
                rGImageTextBtn.setTextColor(aVar.g());
                rGImageTextBtn.setTag(aVar.e());
            }
        }
    }
}
