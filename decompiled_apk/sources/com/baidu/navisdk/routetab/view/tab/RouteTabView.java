package com.baidu.navisdk.routetab.view.tab;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.LayoutRes;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem;
import com.baidu.navisdk.routetab.view.item.single.SingleRouteTabItem;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNRelativeLayout;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import com.facebook.appevents.internal.ViewHierarchyConstants;

/* loaded from: classes7.dex */
public abstract class RouteTabView extends BNRelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    protected final String f7986a;
    protected View b;
    protected View c;
    protected View d;
    protected View e;
    protected MultiRouteTabItem[] f;
    protected SingleRouteTabItem g;
    protected com.baidu.navisdk.routetab.b h;
    protected com.baidu.navisdk.routetab.data.b i;
    protected int j;
    protected boolean k;
    protected boolean l;
    protected float m;
    private int n;
    private float o;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RouteTabView.this.a(view, 0);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RouteTabView.this.a(view, 1);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RouteTabView.this.a(view, 2);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RouteTabView.this.a(view, 0);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MultiRouteTabItem f7991a;

        public e(MultiRouteTabItem multiRouteTabItem) {
            this.f7991a = multiRouteTabItem;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            g gVar = g.ROUTE_RESULT;
            if (gVar.d()) {
                gVar.e(RouteTabView.this.f7986a, "onAnimationCancel");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g gVar = g.ROUTE_RESULT;
            if (gVar.d()) {
                gVar.e(RouteTabView.this.f7986a, "onAnimationEnd");
            }
            this.f7991a.b();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            g gVar = g.ROUTE_RESULT;
            if (gVar.d()) {
                gVar.e(RouteTabView.this.f7986a, "onAnimationRepeat");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            g gVar = g.ROUTE_RESULT;
            if (gVar.d()) {
                gVar.e(RouteTabView.this.f7986a, "onAnimationStart");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MultiRouteTabItem f7992a;

        public f(MultiRouteTabItem multiRouteTabItem) {
            this.f7992a = multiRouteTabItem;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f7992a.b();
            RouteTabView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public RouteTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7986a = getTAG();
        this.m = 30.0f;
        this.o = 0.0f;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(layoutId(), (ViewGroup) this, true);
        initView();
        c();
    }

    public void a(int i, boolean z) {
    }

    public void c() {
        this.f[0].setOnClickListener(new a());
        this.f[1].setOnClickListener(new b());
        this.f[2].setOnClickListener(new c());
        this.g.setOnClickListener(new d());
    }

    public abstract String getTAG();

    public void initView() {
        this.b = findViewById(R.id.multi_tabs_container);
        this.c = findViewById(R.id.multi_tabs_line1);
        this.d = findViewById(R.id.multi_tabs_line2);
        this.e = findViewById(R.id.single_tab_container);
        MultiRouteTabItem[] multiRouteTabItemArr = new MultiRouteTabItem[3];
        this.f = multiRouteTabItemArr;
        multiRouteTabItemArr[0] = (MultiRouteTabItem) findViewById(R.id.multi_tabs_one);
        this.f[1] = (MultiRouteTabItem) findViewById(R.id.multi_tabs_two);
        this.f[2] = (MultiRouteTabItem) findViewById(R.id.multi_tabs_three);
        this.g = (SingleRouteTabItem) findViewById(R.id.single_tab);
    }

    @LayoutRes
    public abstract int layoutId();

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f7986a, "onDetachedFromWindow()");
        }
    }

    public void setCurRouteIndex(int i) {
        boolean z;
        com.baidu.navisdk.routetab.data.b bVar;
        boolean z2;
        boolean z3;
        g gVar = g.ROUTE_RESULT;
        if (gVar.d()) {
            gVar.e(this.f7986a, "setCurRouteIndex --> curRouteIndex = " + i + ", routeTabData = " + this.i);
        }
        this.j = i;
        int i2 = -1;
        if (a()) {
            a(-1, true);
        }
        com.baidu.navisdk.routetab.data.b bVar2 = this.i;
        if (bVar2 != null) {
            i2 = bVar2.a();
        }
        if (i2 > 0 && i2 <= 3) {
            a(i2);
            if (this.e != null && this.b != null && this.f != null && this.g != null) {
                if (i2 <= 1 && !a()) {
                    z = false;
                } else {
                    z = true;
                }
                this.l = z;
                if (z) {
                    int i3 = 0;
                    while (true) {
                        MultiRouteTabItem[] multiRouteTabItemArr = this.f;
                        if (i3 >= multiRouteTabItemArr.length) {
                            break;
                        }
                        MultiRouteTabItem multiRouteTabItem = multiRouteTabItemArr[i3];
                        if (multiRouteTabItem != null && (bVar = this.i) != null && bVar.a(i3) != null) {
                            if (i3 == i) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            multiRouteTabItem.a(z2, this.o);
                            if (this.o == 0.0f) {
                                if (i3 == i) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                int a2 = a(z3, i3, false);
                                if (a(multiRouteTabItem, a2)) {
                                    multiRouteTabItem.e(this.i.a(i3));
                                    multiRouteTabItem.a(this.i.a(i3), this.k);
                                    multiRouteTabItem.setTabItemWidth(a2);
                                    multiRouteTabItem.d(this.i.a(i3));
                                    if (a2 < multiRouteTabItem.getTabItemWidth()) {
                                        a2 = multiRouteTabItem.getTabItemWidth();
                                    }
                                    a(multiRouteTabItem, a2, true);
                                }
                            } else {
                                multiRouteTabItem.e(this.i.a(i3));
                                multiRouteTabItem.a(this.i.a(i3), this.k);
                                multiRouteTabItem.d(this.i.a(i3));
                            }
                        }
                        i3++;
                    }
                    com.baidu.navisdk.routetab.data.b bVar3 = this.i;
                    if (bVar3 != null) {
                        setDivideLineVisible(bVar3.a());
                        return;
                    }
                    return;
                }
                this.g.setSelected(true);
                return;
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e(this.f7986a, "setCurRouteIndex --> layout inflate错误!");
                return;
            }
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f7986a, "setCurRouteIndex --> routeCount错误!");
        }
    }

    public void setDivideLineVisible(int i) {
        View view = this.c;
        if (view != null && this.d != null) {
            if (this.o > 0.0f) {
                if (view.getVisibility() == 0) {
                    this.c.setVisibility(8);
                }
                if (this.d.getVisibility() == 0) {
                    this.d.setVisibility(8);
                    return;
                }
                return;
            }
            if (i == 3) {
                int i2 = this.j;
                if (i2 == 0) {
                    view.setVisibility(8);
                    this.d.setVisibility(0);
                    return;
                } else if (i2 == 2) {
                    view.setVisibility(0);
                    this.d.setVisibility(8);
                    return;
                } else {
                    view.setVisibility(8);
                    this.d.setVisibility(8);
                    return;
                }
            }
            view.setVisibility(8);
            this.d.setVisibility(8);
        }
    }

    public void setExtItemSelectListener(com.baidu.navisdk.routetab.a aVar) {
    }

    public void setItemSelectListener(com.baidu.navisdk.routetab.b bVar) {
        this.h = bVar;
    }

    public void setMidStatusScrollProgress(float f2) {
        this.m = f2;
        if (this.l) {
            MultiRouteTabItem[] multiRouteTabItemArr = this.f;
            if (multiRouteTabItemArr != null) {
                for (MultiRouteTabItem multiRouteTabItem : multiRouteTabItemArr) {
                    if (multiRouteTabItem != null) {
                        multiRouteTabItem.setMidStatusScrollProgress(f2);
                    }
                }
                return;
            }
            return;
        }
        SingleRouteTabItem singleRouteTabItem = this.g;
        if (singleRouteTabItem != null) {
            singleRouteTabItem.setMidStatusScrollProgress(f2);
        }
    }

    public boolean a() {
        return false;
    }

    private void a(int i) {
        this.n = (ScreenUtil.getInstance().getWidthPixels() - ScreenUtil.getInstance().dip2px(22)) / i;
    }

    public RouteTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7986a = getTAG();
        this.m = 30.0f;
        this.o = 0.0f;
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, int i) {
        com.baidu.navisdk.routetab.data.b bVar = this.i;
        com.baidu.navisdk.routetab.b bVar2 = this.h;
        if (bVar2 != null && bVar != null) {
            boolean a2 = bVar2.a(view, bVar.a(i), i);
            g gVar = g.ROUTE_RESULT;
            if (gVar.d()) {
                gVar.e(this.f7986a, "click route tab --> index = " + i + ", isSelectSuccess = " + a2);
            }
            if (!a2) {
                TipTool.onCreateToastDialog(getContext(), "切换失败，请刷新路线后重试");
                return;
            } else {
                setCurRouteIndex(i);
                return;
            }
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f7986a, "click route tab --> mItemSelectListener is null!");
        }
        TipTool.onCreateToastDialog(getContext(), "切换失败，请刷新路线后重试");
    }

    public void a(MultiRouteTabItem multiRouteTabItem, int i, boolean z) {
        g gVar = g.ROUTE_RESULT;
        if (gVar.d()) {
            gVar.e(this.f7986a, "current tab width = " + i);
        }
        if (z) {
            ObjectAnimator ofInt = ObjectAnimator.ofInt(multiRouteTabItem, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i);
            multiRouteTabItem.setPivotX(multiRouteTabItem.getWidth() / 2);
            multiRouteTabItem.setPivotY(multiRouteTabItem.getHeight());
            ofInt.setDuration(200L);
            ofInt.addListener(new e(multiRouteTabItem));
            ofInt.start();
            return;
        }
        multiRouteTabItem.setWidth(i);
        getViewTreeObserver().addOnGlobalLayoutListener(new f(multiRouteTabItem));
    }

    public int a(boolean z, int i, boolean z2) {
        return a(z);
    }

    public int a(boolean z) {
        int dip2px = ScreenUtil.getInstance().dip2px(25.0f);
        int i = this.n;
        if (z) {
            return i + dip2px;
        }
        if (this.f[2].getVisibility() == 0) {
            dip2px /= 2;
        }
        return i - dip2px;
    }

    public boolean a(MultiRouteTabItem multiRouteTabItem, int i) {
        return Math.abs(multiRouteTabItem.getWidth() - i) > 20;
    }
}
