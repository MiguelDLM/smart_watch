package com.baidu.navisdk.module.newguide.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.framework.message.bean.t;
import com.baidu.navisdk.model.datastruct.p;
import com.baidu.navisdk.ui.widget.nestedscroll.BlankLinearLayout;
import com.baidu.navisdk.ui.widget.nestedscroll.FlingHelper;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class RGOutScrollView extends NestedScrollView implements a.InterfaceC0201a {
    private OverScroller A;

    /* renamed from: a, reason: collision with root package name */
    protected boolean f7361a;
    protected VelocityTracker b;
    protected FlingHelper c;
    private int d;
    protected Field e;
    protected Field f;
    private boolean g;
    private BlankLinearLayout h;
    private LinearLayout i;
    protected p j;
    protected boolean k;
    protected int l;
    protected int m;
    protected int n;
    private int o;
    private int p;
    private int q;
    private int r;
    protected int s;
    protected int t;
    protected boolean u;
    protected boolean v;
    private View w;
    private final Rect x;
    private c y;
    private d z;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RGOutScrollView rGOutScrollView = RGOutScrollView.this;
            if (rGOutScrollView.j == p.TOP) {
                rGOutScrollView.scrollTo(0, rGOutScrollView.getScrollToTopValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7363a;

        static {
            int[] iArr = new int[p.values().length];
            f7363a = iArr;
            try {
                iArr[p.BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7363a[p.SPECIFIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7363a[p.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(p pVar, p pVar2, boolean z);

        void e(int i);
    }

    /* loaded from: classes7.dex */
    public interface d {
        void E();

        void O();

        void S();

        void Y();

        void d0();
    }

    public RGOutScrollView(Context context) {
        this(context, null);
    }

    private void d() {
        int i = this.n;
        int i2 = this.l;
        int i3 = i - i2;
        int i4 = this.m;
        int i5 = i4 - i;
        int i6 = i4 - i2;
        this.o = ((i3 - getScrollToBottomValue()) / 3) + getScrollToBottomValue();
        this.p = ((i6 - getScrollToBottomValue()) / 3) + getScrollToBottomValue();
        this.r = (((i6 - getScrollToBottomValue()) * 2) / 3) + getScrollToBottomValue();
        this.q = ((i5 - getScrollToBottomValue()) / 2) + getScrollToBottomValue() + i5;
    }

    private void e() {
        if (this.b == null) {
            this.b = VelocityTracker.obtain();
        }
    }

    private void f() {
        VelocityTracker velocityTracker = this.b;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.b = null;
        }
    }

    private int getMiddleStatusScrollVal() {
        return getScrollToMiddleValue() - getScrollToBottomValue();
    }

    private OverScroller getOverScroller() {
        Object obj;
        if (this.e == null) {
            this.e = FlingHelper.getDeclaredField(this, "mScroller");
        }
        try {
            Field field = this.e;
            if (field != null) {
                obj = field.get(this);
            } else {
                obj = null;
            }
            if (!(obj instanceof OverScroller)) {
                return null;
            }
            return (OverScroller) obj;
        } catch (IllegalAccessException e) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                LogUtil.printException("RGOuterScrollView fling  IllegalAccessException!", e);
            }
            if (!gVar.d()) {
                return null;
            }
            gVar.e("RGOuterScrollView", "getOverScroller: " + e);
            return null;
        }
    }

    public boolean a(int i) {
        return false;
    }

    public void b(int i) {
        this.h.setMinHeight(i - this.l);
        this.h.requestLayout();
    }

    public boolean c() {
        return this.k;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        int i = 0;
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            bottom -= scrollY;
        } else if (scrollY > max) {
            bottom += scrollY - max;
        }
        this.s = bottom;
        BlankLinearLayout blankLinearLayout = this.h;
        if (blankLinearLayout != null) {
            i = blankLinearLayout.getMeasuredHeight();
            LinearLayout linearLayout = this.i;
            if (linearLayout != null && linearLayout.getChildAt(1) != null) {
                i += this.i.getChildAt(1).getMeasuredHeight();
            }
        }
        if (i > 0) {
            this.s = i;
        }
        return this.s;
    }

    @Override // androidx.core.widget.NestedScrollView
    public void fling(int i) {
        int i2;
        int i3;
        int scrollToTopValue;
        int scrollToTopValue2;
        if (!this.v) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGOuterScrollView", "fling() --> 1 --> velocityY = " + i);
            }
            super.fling(i);
            return;
        }
        if (this.f == null) {
            this.f = FlingHelper.getDeclaredField(this, "mLastScrollerY");
        }
        if (this.A != null && this.f != null) {
            try {
                if (getChildCount() > 0) {
                    startNestedScroll(2, 1);
                    if (this.v) {
                        if (this.j == p.SPECIFIC) {
                            scrollToTopValue = getScrollToMiddleValue();
                            scrollToTopValue2 = getScrollToMiddleValue();
                        } else if (i > 0) {
                            scrollToTopValue = getScrollToTopValue();
                            scrollToTopValue2 = getScrollToTopValue();
                        } else {
                            i2 = 0;
                            i3 = 0;
                        }
                        i2 = scrollToTopValue;
                        i3 = scrollToTopValue2;
                    } else {
                        i2 = Integer.MIN_VALUE;
                        i3 = Integer.MAX_VALUE;
                    }
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("RGOuterScrollView", "fling() --> getScrollX = " + getScrollX() + ", getScrollY = " + getScrollY() + " velocityY = " + i + ", minY = " + i2 + ", maxY = " + i3);
                    }
                    this.A.fling(getScrollX(), getScrollY(), 0, i, 0, 0, i2, i3, 0, 0);
                    this.f.set(this, Integer.valueOf(getScrollY()));
                    ViewCompat.postInvalidateOnAnimation(this);
                    return;
                }
                return;
            } catch (IllegalAccessException e) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.printException("RGOuterScrollView fling  IllegalAccessException!", e);
                }
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RGOuterScrollView", "fling() --> 3 --> velocityY = " + i);
                }
                super.fling(i);
                return;
            }
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGOuterScrollView", "fling() --> 4 --> velocityY = " + i);
        }
        super.fling(i);
    }

    public int getBottomStatusContentHeight() {
        return this.l;
    }

    public LinearLayout getContentLayout() {
        return this.i;
    }

    public int getMaxScrollVal() {
        return getScrollToTopValue() - getScrollToBottomValue();
    }

    public String getName() {
        return "RGOuterScrollView-OnEvent";
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGOuterScrollView", "getNestedScrollAxes");
        }
        return super.getNestedScrollAxes();
    }

    public int getScrollToBottomValue() {
        return 0;
    }

    public int getScrollToMiddleValue() {
        return this.n - this.l;
    }

    public int getScrollToTopValue() {
        return this.m - this.l;
    }

    public p getStatus() {
        return this.j;
    }

    public int getTopStatusContentHeight() {
        return this.m;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.navisdk.framework.message.a.a().a(this, t.class, new Class[0]);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.navisdk.framework.message.a.a().a((a.InterfaceC0201a) this);
        f();
    }

    @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
    public void onEvent(Object obj) {
        View childAt;
        if (obj instanceof t) {
            BlankLinearLayout blankLinearLayout = this.h;
            if (blankLinearLayout != null) {
                blankLinearLayout.requestLayout();
            }
            LinearLayout linearLayout = this.i;
            if (linearLayout != null && (childAt = linearLayout.getChildAt(1)) != null) {
                childAt.requestLayout();
            }
            if (this.j == p.TOP) {
                post(new a());
            }
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean a2;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGOuterScrollView", "onInterceptTouchEvent() --> event = " + motionEvent);
        }
        if (this.h == null) {
            a2 = false;
        } else {
            a2 = a(motionEvent, this.w);
        }
        if (!a2 && this.z != null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    this.z.Y();
                }
            } else {
                this.z.O();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.t = i4 - i2;
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f, float f2, boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGOuterScrollView", "onNestedFling() --> target = " + view + ", velocityX = " + f + ", velocityY = " + f2 + ", consumed = " + z);
        }
        return super.onNestedFling(view, f, f2, z);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f, float f2) {
        int maxScrollVal;
        p pVar;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGOuterScrollView", "onNestedPreFling() --> target = " + view + ", velocityX = " + f + ", velocityY = " + f2);
        }
        p pVar2 = this.j;
        p pVar3 = p.SPECIFIC;
        if (pVar2 != pVar3) {
            if (f2 > 0.0f && view.canScrollVertically(1)) {
                return false;
            }
            if (f2 < 0.0f && view.canScrollVertically(-1)) {
                return false;
            }
        }
        this.u = true;
        if (view.getScrollY() != 0 && (pVar = this.j) != p.BOTTOM && pVar != pVar3) {
            return super.onNestedPreFling(view, f, f2);
        }
        if (this.v) {
            int i = -((int) f2);
            p a2 = a(i, getScrollY());
            if (a2 != p.NULL) {
                a(a2, true, i, true);
            }
        } else {
            if (f2 < 0.0f) {
                maxScrollVal = getScrollY();
            } else {
                maxScrollVal = getMaxScrollVal() - getScrollY();
            }
            int max = ((int) Math.max(Math.abs(f2), Math.abs(this.c.getVelocityByDistance(maxScrollVal)))) + 500;
            if (f2 < 0.0f) {
                max = -max;
            }
            fling(max);
        }
        return true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i, int i2, @NonNull int[] iArr) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGOuterScrollView", "onNestedPreScroll() --> target = " + view + ", dx = " + i + ", dy = " + i2 + ", consumed = " + Arrays.toString(iArr));
        }
        if (this.j == p.SPECIFIC) {
            scrollBy(0, i2);
            iArr[1] = i2;
        } else {
            boolean z = i2 > 0 && getScrollY() < getScrollToTopValue();
            boolean z2 = i2 < 0 && getScrollY() >= 0 && !view.canScrollVertically(-1);
            if (z || z2) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RGOuterScrollView", "onNestedPreScroll() --> scroll scrollview!");
                }
                scrollBy(0, i2);
                iArr[1] = i2;
            }
        }
        super.onNestedPreScroll(view, i, i2, iArr);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i, int i2, int i3, int i4) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGOuterScrollView", "onNestedScroll() --> target = " + view + ", dxConsumed = " + i + ", dyConsumed = " + i2 + ", dxUnconsumed = " + i3 + ", dyUnconsumed = " + i4);
        }
        super.onNestedScroll(view, i, i2, i3, i4);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGOuterScrollView", "onNestedScrollAccepted() --> child = " + view + ", target = " + view2 + ", axes = " + i);
        }
        super.onNestedScrollAccepted(view, view2, i);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        c cVar = this.y;
        if (cVar != null) {
            cVar.e(i2);
        }
        boolean a2 = a(i2);
        if (i2 == 0 || a2) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGOuterScrollView", "onScrollChanged abortAnimation " + i2 + ",scroll_height: " + this.s + ", view_height:" + this.t);
            }
            a();
        }
        super.onScrollChanged(i, i2, i3, i4);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGOuterScrollView", "onStartNestedScroll() --> child = " + view + ", target = " + view2 + ", axes = " + i + ", scrollAvailable = " + this.f7361a);
        }
        if (this.f7361a && getScrollY() == getMaxScrollVal()) {
            return super.onStartNestedScroll(view, view2, i);
        }
        return false;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        p a2;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGOuterScrollView", "onStopNestedScroll() --> target = " + view + ", isStartNestFling = " + this.u);
        }
        if (this.u) {
            this.u = false;
        } else if (this.v && (a2 = a(0, getScrollY())) != p.NULL) {
            a(a2, true, 0, true);
        }
        super.onStopNestedScroll(view);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean a2;
        d dVar;
        d dVar2;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGOuterScrollView", "onTouchEvent() --> scrollAvailable = " + this.f7361a + ", event = " + motionEvent);
        }
        if (!this.f7361a) {
            return false;
        }
        OverScroller overScroller = this.A;
        if (overScroller != null && !overScroller.isFinished()) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGOuterScrollView", "onTouchEvent: mOverScroller not finished");
            }
            return true;
        }
        int action = motionEvent.getAction();
        if (this.z != null) {
            int action2 = motionEvent.getAction();
            if (action2 != 0) {
                if (action2 == 1) {
                    this.z.S();
                }
            } else {
                this.z.E();
            }
        }
        if (this.h == null) {
            a2 = false;
        } else {
            a2 = a(motionEvent, this.w);
        }
        if (a2) {
            if (this.j == p.BOTTOM || (dVar2 = this.z) == null) {
                return false;
            }
            dVar2.d0();
            return true;
        }
        if (motionEvent.getAction() == 0 && (dVar = this.z) != null) {
            dVar.O();
        }
        e();
        this.b.addMovement(motionEvent);
        if (action == 1 || action == 3) {
            if (this.v) {
                this.b.computeCurrentVelocity(1000, this.d);
                int yVelocity = (int) this.b.getYVelocity();
                p a3 = a(yVelocity, getScrollY());
                if (a3 != p.NULL) {
                    a(a3, true, yVelocity, true);
                }
                f();
                return true;
            }
            f();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void scrollTo(int i, int i2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGOuterScrollView", "scrollTo --> x = " + i + ", y = " + i2 + ", getScrollToBottomValue() = " + getScrollToBottomValue() + ", getScrollToTopValue() = " + getScrollToTopValue());
        }
        if (i2 < getScrollToBottomValue()) {
            i2 = getScrollToBottomValue();
        }
        if (i2 > getScrollToTopValue()) {
            i2 = getScrollToTopValue();
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGOuterScrollView", "scrollTo contentLayout height:: " + this.i.getHeight());
        }
        super.scrollTo(i, i2);
    }

    public void setBottomStatusContentHeight(int i) {
        this.l = i;
        if (this.n > i) {
            this.k = true;
        }
        d();
    }

    public void setMiddleStatusContentHeight(int i) {
        this.n = i;
        if (i > this.l) {
            this.k = true;
        }
        d();
    }

    public void setOnScrollViewTouchListener(d dVar) {
        this.z = dVar;
    }

    public void setScrollAvailable(boolean z) {
        this.f7361a = z;
    }

    public void setScrollChangeListener(c cVar) {
        this.y = cVar;
    }

    public void setStatus(p pVar) {
        this.j = pVar;
    }

    public void setTopStatusContentHeight(int i) {
        this.m = i;
        d();
    }

    public RGOutScrollView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        LayoutInflater.from(getContext()).inflate(R.layout.nsdk_layout_out_scroll_view, this);
        this.h = (BlankLinearLayout) findViewById(R.id.ll_blank);
        this.i = (LinearLayout) findViewById(R.id.ll_content);
        this.c = new FlingHelper(context);
        this.d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.A = getOverScroller();
    }

    public RGOutScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7361a = true;
        this.g = false;
        this.j = p.BOTTOM;
        this.k = false;
        this.s = 0;
        this.t = 0;
        this.u = false;
        this.v = true;
        this.x = new Rect();
        a(context);
    }

    public boolean b() {
        return getScrollY() > getScrollToBottomValue();
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view, int i, int i2, int i3, int i4, int i5, @NonNull int[] iArr) {
        iArr[0] = iArr[0] + i3;
        iArr[1] = iArr[1] + i4;
        super.onNestedScroll(view, i, i2, i3, i5, i4);
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i, int i2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGOuterScrollView", "onStartNestedScroll() --> child = " + view + ", target = " + view2 + ", axes = " + i + ", scrollAvailable = " + this.f7361a);
        }
        if (i2 == 0 && this.f7361a && getScrollY() == getMaxScrollVal()) {
            return super.onStartNestedScroll(view, view2, i, i2);
        }
        return false;
    }

    private boolean a(MotionEvent motionEvent, View view) {
        if (view == null) {
            return true;
        }
        if (motionEvent.getAction() == 1) {
            this.g = false;
            return false;
        }
        boolean a2 = a(motionEvent.getX(), motionEvent.getY(), view);
        boolean z = !a2;
        if (motionEvent.getAction() == 0) {
            this.g = z;
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGOuterScrollView", "canMoveMap inside: " + z + ",isDownOnMap: " + this.g + ", " + motionEvent.getAction());
        }
        return (!this.g || a2 || motionEvent.getAction() == 1) ? false : true;
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View view, int i) {
        p a2;
        if (i != 0) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGOuterScrollView", "onStopNestedScroll() --> target = " + view + ", isStartNestFling = " + this.u);
        }
        if (this.u) {
            this.u = false;
        } else if (this.v && (a2 = a(0, getScrollY())) != p.NULL) {
            a(a2, true, 0, true);
        }
        super.onStopNestedScroll(view, i);
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull View view, int i, int i2, @NonNull int[] iArr, int i3) {
        if (i3 != 0) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGOuterScrollView", "onNestedPreScroll() --> target = " + view + ", dx = " + i + ", dy = " + i2 + ", consumed = " + Arrays.toString(iArr));
        }
        if (this.j == p.SPECIFIC) {
            scrollBy(0, i2);
            iArr[1] = i2;
        } else {
            boolean z = i2 > 0 && getScrollY() < getScrollToTopValue();
            boolean z2 = i2 < 0 && getScrollY() >= 0 && !view.canScrollVertically(-1);
            if (z || z2) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RGOuterScrollView", "onNestedPreScroll() --> scroll scrollview!");
                }
                scrollBy(0, i2);
                iArr[1] = i2;
            }
        }
        super.onNestedPreScroll(view, i, i2, iArr, i3);
    }

    private boolean a(float f, float f2, View view) {
        a(view);
        Rect rect = this.x;
        return f2 > ((float) rect.top) && f2 < ((float) rect.bottom) && f >= ((float) rect.left) && f < ((float) rect.right);
    }

    public p a(int i, int i2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGOuterScrollView", "calculateNextStatus() --> velocityY = " + i + ", scrollY = " + i2 + ", scrollToMiddleValue = " + this.p + ", mStatus = " + this.j);
        }
        int i3 = b.f7363a[this.j.ordinal()];
        if (i3 == 1) {
            if (this.k) {
                if (i2 > getScrollToMiddleValue()) {
                    return p.TOP;
                }
                if ((i < 0 && Math.abs(i) > 1000) || i2 > this.o) {
                    return p.SPECIFIC;
                }
                return p.BOTTOM;
            }
            if ((i < 0 && Math.abs(i) > 1000) || i2 > this.p) {
                return p.TOP;
            }
            return p.BOTTOM;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                return p.BOTTOM;
            }
            if (i <= 500 && i2 >= this.r) {
                return p.TOP;
            }
            return p.BOTTOM;
        }
        if ((i < 0 && Math.abs(i) > 1000) || i2 > this.q) {
            return p.TOP;
        }
        if ((i > 0 && Math.abs(i) > 1000) || i2 < this.o) {
            return p.BOTTOM;
        }
        return p.SPECIFIC;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0017, code lost:
    
        if (r0 == com.baidu.navisdk.model.datastruct.p.SPECIFIC) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001f, code lost:
    
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x001c, code lost:
    
        if (r0 == com.baidu.navisdk.model.datastruct.p.TOP) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(boolean r6) {
        /*
            r5 = this;
            com.baidu.navisdk.model.datastruct.p r0 = r5.j
            com.baidu.navisdk.model.datastruct.p r1 = com.baidu.navisdk.model.datastruct.p.BOTTOM
            r2 = 0
            if (r0 != r1) goto L8
            return r2
        L8:
            com.baidu.navisdk.model.datastruct.p r3 = com.baidu.navisdk.model.datastruct.p.NULL
            boolean r4 = r5.k
            if (r4 == 0) goto L1a
            com.baidu.navisdk.model.datastruct.p r4 = com.baidu.navisdk.model.datastruct.p.TOP
            if (r0 != r4) goto L15
            com.baidu.navisdk.model.datastruct.p r1 = com.baidu.navisdk.model.datastruct.p.SPECIFIC
            goto L20
        L15:
            com.baidu.navisdk.model.datastruct.p r4 = com.baidu.navisdk.model.datastruct.p.SPECIFIC
            if (r0 != r4) goto L1f
            goto L20
        L1a:
            com.baidu.navisdk.model.datastruct.p r4 = com.baidu.navisdk.model.datastruct.p.TOP
            if (r0 != r4) goto L1f
            goto L20
        L1f:
            r1 = r3
        L20:
            if (r1 == r3) goto L27
            r5.a(r1, r6)
            r6 = 1
            return r6
        L27:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.module.newguide.widgets.RGOutScrollView.a(boolean):boolean");
    }

    public void a(p pVar, boolean z) {
        p pVar2 = p.BOTTOM;
        if (pVar != pVar2 && !this.f7361a) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGOuterScrollView", "updateStatus: " + pVar + ",scrollAvailable: " + this.f7361a);
                return;
            }
            return;
        }
        p pVar3 = this.j;
        if (pVar != pVar3) {
            if (!this.k && pVar == p.SPECIFIC) {
                if (pVar3 == pVar2) {
                    pVar = p.TOP;
                } else if (pVar3 == p.TOP) {
                    pVar = pVar2;
                }
            }
            a(pVar, z, 0, false);
        }
    }

    public void a(p pVar, boolean z, int i, boolean z2) {
        int i2;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGOuterScrollView", "updateStatus() --> status = " + pVar + ", smooth = " + z + ", velocityY = " + i);
        }
        c cVar = this.y;
        if (cVar != null) {
            cVar.a(this.j, pVar, z2);
        }
        p pVar2 = this.j;
        this.j = pVar;
        a();
        int i3 = b.f7363a[pVar.ordinal()];
        if (i3 == 1) {
            if (z) {
                int scrollY = getScrollY();
                if (i > 0) {
                    i = 0;
                }
                int velocityByDistance = (int) (this.c.getVelocityByDistance(scrollY) * 2.2d);
                int i4 = -Math.max(Math.abs(i), Math.abs(velocityByDistance));
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RGOuterScrollView", "updateBottomStatus() --> velocityY = " + i + ", scrollDistance = " + scrollY + ", needVelocity = " + velocityByDistance + ", finalVelocity = " + i4);
                }
                if (velocityByDistance > 0) {
                    fling(i4);
                    return;
                }
                return;
            }
            scrollTo(0, getScrollToBottomValue());
            return;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                return;
            }
            if (z) {
                int maxScrollVal = getMaxScrollVal() - getScrollY();
                if (i < 0) {
                    i = 0;
                }
                int velocityByDistance2 = (int) (this.c.getVelocityByDistance(maxScrollVal) * 2.2d);
                int max = Math.max(Math.abs(i), Math.abs(velocityByDistance2));
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RGOuterScrollView", "updateTopStatus() --> velocityY = " + i + ", scrollDistance = " + maxScrollVal + ", needVelocity = " + velocityByDistance2 + ", finalVelocity = " + max);
                }
                if (velocityByDistance2 > 0) {
                    fling(max);
                    return;
                }
                return;
            }
            scrollTo(0, getScrollToTopValue());
            return;
        }
        if (z) {
            int abs = Math.abs(getMiddleStatusScrollVal() - getScrollY());
            int velocityByDistance3 = (int) (this.c.getVelocityByDistance(abs) * 2.2d);
            if (pVar2 == p.BOTTOM) {
                if (i < 0) {
                    i = 0;
                }
                i2 = Math.max(Math.abs(i), Math.abs(velocityByDistance3));
            } else {
                if (i > 0) {
                    i = 0;
                }
                i2 = -Math.max(Math.abs(i), Math.abs(velocityByDistance3));
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGOuterScrollView", "updateSpecific() --> velocityY = " + i + ", scrollDistance = " + abs + ", needVelocity = " + velocityByDistance3 + ", finalVelocity = " + i2);
            }
            if (velocityByDistance3 > 0) {
                fling(i2);
                return;
            }
            return;
        }
        scrollTo(0, getScrollToMiddleValue());
    }

    public void a() {
        OverScroller overScroller = this.A;
        if (overScroller != null) {
            overScroller.abortAnimation();
            return;
        }
        try {
            if (this.e == null) {
                this.e = FlingHelper.getDeclaredField(this, "mScroller");
            }
            Field field = this.e;
            Object obj = field != null ? field.get(this) : null;
            if (obj == null) {
                return;
            }
            obj.getClass().getMethod("abortAnimation", null).invoke(obj, null);
        } catch (IllegalAccessException e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("RGOuterScrollView abortAnimation IllegalAccessException!", e);
            }
        } catch (NoSuchMethodException e2) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("RGOuterScrollView abortAnimation NoSuchMethodException!", e2);
            }
        } catch (InvocationTargetException e3) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("RGOuterScrollView abortAnimation InvocationTargetException!", e3);
            }
        }
    }

    public void a(View view, int i, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams == null) {
            marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, this.m);
            view.setLayoutParams(marginLayoutParams);
        }
        marginLayoutParams.leftMargin = i;
        marginLayoutParams.rightMargin = i2;
        marginLayoutParams.height = this.m;
        this.w = view;
        this.i.addView(view);
    }

    private void a(View view) {
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            Rect rect = this.x;
            int i = iArr[0];
            rect.left = i;
            rect.right = i + view.getWidth();
            Rect rect2 = this.x;
            int i2 = iArr[1];
            rect2.top = i2;
            rect2.bottom = i2 + view.getHeight();
        }
    }

    public boolean a(p pVar) {
        return this.j == pVar;
    }
}
