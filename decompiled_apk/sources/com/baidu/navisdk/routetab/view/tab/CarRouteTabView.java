package com.baidu.navisdk.routetab.view.tab;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.routetab.view.MultiTabHorizontalScrollView;
import com.baidu.navisdk.routetab.view.item.multi.CarMultiRouteExtTabItem;
import com.baidu.navisdk.routetab.view.item.multi.MultiRouteTabItem;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class CarRouteTabView extends RouteTabView {
    private LinearLayout p;
    private MultiTabHorizontalScrollView q;
    private View r;
    protected CarMultiRouteExtTabItem[] s;
    protected View[] t;
    private float u;
    private int v;
    private int w;
    private ArrayList<com.baidu.navisdk.routetab.data.a> x;
    private MultiTabHorizontalScrollView.a y;

    /* loaded from: classes7.dex */
    public class a implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MultiRouteTabItem f7984a;

        public a(MultiRouteTabItem multiRouteTabItem) {
            this.f7984a = multiRouteTabItem;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            g gVar = g.ROUTE_RESULT;
            if (gVar.d()) {
                gVar.e(CarRouteTabView.this.f7986a, "onAnimationCancel");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g gVar = g.ROUTE_RESULT;
            if (gVar.d()) {
                gVar.e(CarRouteTabView.this.f7986a, "onAnimationEnd");
            }
            this.f7984a.b();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            g gVar = g.ROUTE_RESULT;
            if (gVar.d()) {
                gVar.e(CarRouteTabView.this.f7986a, "onAnimationRepeat");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            g gVar = g.ROUTE_RESULT;
            if (gVar.d()) {
                gVar.e(CarRouteTabView.this.f7986a, "onAnimationStart");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements MultiTabHorizontalScrollView.a {
        public b() {
        }

        @Override // com.baidu.navisdk.routetab.view.MultiTabHorizontalScrollView.a
        public void a() {
            CarRouteTabView.this.setMaskViewVisibility(0);
            if (CarRouteTabView.this.y != null) {
                CarRouteTabView.this.y.a();
            }
        }

        @Override // com.baidu.navisdk.routetab.view.MultiTabHorizontalScrollView.a
        public void b() {
            CarRouteTabView.this.setMaskViewVisibility(8);
            if (CarRouteTabView.this.y != null) {
                CarRouteTabView.this.y.b();
            }
        }

        @Override // com.baidu.navisdk.routetab.view.MultiTabHorizontalScrollView.a
        public void c() {
            CarRouteTabView.this.setMaskViewVisibility(0);
            if (CarRouteTabView.this.y != null) {
                CarRouteTabView.this.y.c();
            }
        }
    }

    public CarRouteTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.u = 0.0f;
        this.v = -1;
        this.w = 4;
        this.y = null;
    }

    private void b(int i) {
        View[] viewArr = this.t;
        if (viewArr == null || viewArr.length <= 0) {
            return;
        }
        com.baidu.navisdk.routetab.data.b bVar = this.i;
        int a2 = bVar != null ? bVar.a() : 0;
        int i2 = 0;
        while (true) {
            View[] viewArr2 = this.t;
            if (i2 >= viewArr2.length) {
                return;
            }
            if (this.u > 0.0f) {
                viewArr2[i2].setVisibility(8);
            } else if (i2 == 0 && i == -1 && this.j == a2 - 1) {
                viewArr2[i2].setVisibility(8);
            } else if (i2 != i && (i2 <= 0 || i2 - 1 != i)) {
                viewArr2[i2].setVisibility(0);
            } else {
                viewArr2[i2].setVisibility(8);
            }
            i2++;
        }
    }

    private boolean d() {
        CarMultiRouteExtTabItem[] carMultiRouteExtTabItemArr;
        if (getTotalRoutTabCount() < 4 || this.u > 0.0f || (carMultiRouteExtTabItemArr = this.s) == null || carMultiRouteExtTabItemArr.length == 0 || carMultiRouteExtTabItemArr[0].getExtTabState() != 2) {
            return false;
        }
        return g();
    }

    private void e() {
        if (getTotalRoutTabCount() <= 3) {
            return;
        }
        if (this.j == 0 && this.v == -1) {
            this.q.fullScroll(17);
        } else if (this.v != -1) {
            this.q.fullScroll(66);
        }
    }

    private void f() {
        this.q.setOnScrollChangeListener(new b());
    }

    private boolean g() {
        CarMultiRouteExtTabItem[] carMultiRouteExtTabItemArr = this.s;
        if (carMultiRouteExtTabItemArr == null || carMultiRouteExtTabItemArr.length <= 0) {
            return false;
        }
        Rect rect = new Rect();
        if (this.s[0].getGlobalVisibleRect(rect) && rect.right - rect.left >= this.s[0].getWidth()) {
            return false;
        }
        return true;
    }

    private int getDefaultTabWidth() {
        if (getTotalRoutTabCount() >= 4) {
            return a(95);
        }
        return getScreenWidthMinusMargin() / getTotalRoutTabCount();
    }

    private int getMinTabWidth() {
        return (int) (getScreenWidthMinusMargin() * 0.25f);
    }

    private int getScreenWidthMinusMargin() {
        return (ScreenUtil.getInstance().getWidthPixels() - a((getTotalRoutTabCount() - 1) * 4)) - getTabViewLeftAndRightMargin();
    }

    private int getSelectedThreeTabWidth() {
        return (int) (getScreenWidthMinusMargin() * 0.36f);
    }

    private int getTabViewLeftAndRightMargin() {
        return a(8);
    }

    private int getTwoTabWidth() {
        return (int) (getScreenWidthMinusMargin() * 0.5f);
    }

    private int getUnSelectedThreeTabWidth() {
        return (int) (getScreenWidthMinusMargin() * 0.32f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskViewVisibility(int i) {
        if (i == 0 && d()) {
            if (this.r.getVisibility() != 0) {
                this.r.setVisibility(0);
            }
        } else if (this.r.getVisibility() != 8) {
            this.r.setVisibility(8);
        }
    }

    public int getMaxTabWidth() {
        return (int) (getScreenWidthMinusMargin() * 0.33f);
    }

    public int getSelectedMinTabWidth() {
        return (int) (getScreenWidthMinusMargin() * 0.32f);
    }

    @Override // com.baidu.navisdk.routetab.view.tab.RouteTabView
    public String getTAG() {
        return "CarRouteTabView";
    }

    public int getTotalRoutTabCount() {
        int i;
        CarMultiRouteExtTabItem[] carMultiRouteExtTabItemArr = this.s;
        int i2 = 0;
        if (carMultiRouteExtTabItemArr != null) {
            i = carMultiRouteExtTabItemArr.length;
        } else {
            i = 0;
        }
        com.baidu.navisdk.routetab.data.b bVar = this.i;
        if (bVar != null && bVar.a() > 0) {
            i2 = this.i.a();
        }
        int i3 = i2 + i;
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f7986a, "totalRouteCount = " + i3);
        }
        return i3;
    }

    public int getUnselectedMaxTabWidth() {
        return (int) (getScreenWidthMinusMargin() * 0.32f);
    }

    @Override // com.baidu.navisdk.routetab.view.tab.RouteTabView
    public void initView() {
        super.initView();
        this.p = (LinearLayout) findViewById(R.id.multi_ext_tabs_layout);
        this.q = (MultiTabHorizontalScrollView) findViewById(R.id.multi_tabs_horizontal_scrollView);
        this.r = findViewById(R.id.multi_tabs_horizontal_mask);
        setTag("CarRouteTabView");
        f();
    }

    @Override // com.baidu.navisdk.routetab.view.tab.RouteTabView
    public int layoutId() {
        return R.layout.nsdk_layout_car_route_tab_view;
    }

    @Override // com.baidu.navisdk.routetab.view.tab.RouteTabView
    public void setCurRouteIndex(int i) {
        super.setCurRouteIndex(i);
    }

    public void setExtTabAccessType(String str) {
    }

    public void setHorizontalScrollListener(MultiTabHorizontalScrollView.a aVar) {
        this.y = aVar;
    }

    private int a(int i) {
        return ScreenUtil.getInstance().dip2px(i);
    }

    @Override // com.baidu.navisdk.routetab.view.tab.RouteTabView
    public void a(int i, boolean z) {
        b(i, z);
        if (this.j == 0) {
            e();
        }
    }

    public CarRouteTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.u = 0.0f;
        this.v = -1;
        this.w = 4;
        this.y = null;
    }

    @Override // com.baidu.navisdk.routetab.view.tab.RouteTabView
    public int a(boolean z, int i, boolean z2) {
        int b2;
        if (getTotalRoutTabCount() == 2) {
            return getTwoTabWidth();
        }
        if (getTotalRoutTabCount() == 3) {
            if (z) {
                return getSelectedThreeTabWidth();
            }
            return getUnSelectedThreeTabWidth();
        }
        float f = this.u;
        if (f >= this.m && f > 0.0f) {
            return getDefaultTabWidth();
        }
        if (z2) {
            ArrayList<com.baidu.navisdk.routetab.data.a> arrayList = this.x;
            if (arrayList != null && arrayList.size() > 0 && this.x.get(i) != null) {
                b2 = this.s[i].b(this.x.get(i).e());
            }
            b2 = 0;
        } else {
            com.baidu.navisdk.routetab.data.b bVar = this.i;
            if (bVar != null && bVar.a(i) != null) {
                b2 = this.f[i].b(this.i.a(i).d() + "");
            }
            b2 = 0;
        }
        int minTabWidth = getMinTabWidth();
        if (z) {
            minTabWidth = getSelectedMinTabWidth();
        }
        return b2 <= minTabWidth ? minTabWidth : b2 <= getMaxTabWidth() ? b2 : getMaxTabWidth() + 24;
    }

    private void b(int i, boolean z) {
        CarMultiRouteExtTabItem[] carMultiRouteExtTabItemArr = this.s;
        if (carMultiRouteExtTabItemArr == null || carMultiRouteExtTabItemArr.length <= 0) {
            return;
        }
        this.v = i;
        int i2 = 0;
        while (true) {
            CarMultiRouteExtTabItem[] carMultiRouteExtTabItemArr2 = this.s;
            if (i2 < carMultiRouteExtTabItemArr2.length) {
                CarMultiRouteExtTabItem carMultiRouteExtTabItem = carMultiRouteExtTabItemArr2[i2];
                if (carMultiRouteExtTabItem != null) {
                    carMultiRouteExtTabItem.a(i2 == i, this.u);
                    int a2 = a(i2 == i, i2, true);
                    carMultiRouteExtTabItem.setTabItemWidth(a2);
                    ArrayList<com.baidu.navisdk.routetab.data.a> arrayList = this.x;
                    if (arrayList != null && arrayList.size() > 0) {
                        carMultiRouteExtTabItem.a(this.x.get(i2), this.k);
                    }
                    a(carMultiRouteExtTabItem, a2, z);
                }
                i2++;
            } else {
                b(i);
                return;
            }
        }
    }

    @Override // com.baidu.navisdk.routetab.view.tab.RouteTabView
    public void a(MultiRouteTabItem multiRouteTabItem, int i, boolean z) {
        if (!z) {
            super.a(multiRouteTabItem, i, false);
            return;
        }
        int width = multiRouteTabItem.getWidth() / 2;
        if (i < multiRouteTabItem.getWidth()) {
            width = multiRouteTabItem.getWidth();
        }
        ObjectAnimator ofInt = ObjectAnimator.ofInt(multiRouteTabItem, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i);
        multiRouteTabItem.setPivotX(width);
        multiRouteTabItem.setPivotY(multiRouteTabItem.getHeight());
        ofInt.setDuration(200L);
        ofInt.addListener(new a(multiRouteTabItem));
        ofInt.start();
    }

    @Override // com.baidu.navisdk.routetab.view.tab.RouteTabView
    public boolean a() {
        return this.w != 4;
    }

    @Override // com.baidu.navisdk.routetab.view.tab.RouteTabView
    public boolean a(MultiRouteTabItem multiRouteTabItem, int i) {
        com.baidu.navisdk.routetab.data.b bVar;
        return Math.abs(multiRouteTabItem.getWidth() - i) > 20 || a() || ((bVar = this.i) != null && bVar.a() == 2);
    }
}
