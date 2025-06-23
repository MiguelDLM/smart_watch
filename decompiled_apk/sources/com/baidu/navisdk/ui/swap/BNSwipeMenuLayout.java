package com.baidu.navisdk.ui.swap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.baidu.navisdk.embed.R;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class BNSwipeMenuLayout extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<View> f9191a;
    private int b;
    private int c;
    private int d;
    private View e;
    private View f;
    private View g;
    private ViewGroup.MarginLayoutParams h;
    private boolean i;
    private PointF j;
    private PointF k;
    private float l;
    private boolean m;
    private boolean n;
    private int o;
    private Scroller p;
    private BNSwipeMenuLayout q;
    private com.baidu.navisdk.ui.swap.a r;
    private a s;
    private float t;
    com.baidu.navisdk.ui.swap.a u;

    /* loaded from: classes8.dex */
    public interface a {
        void a(com.baidu.navisdk.ui.swap.a aVar, com.baidu.navisdk.ui.swap.a aVar2);
    }

    public BNSwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        this.o = ViewConfiguration.get(context).getScaledTouchSlop();
        this.p = new Scroller(context);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.BNSwipeMenuLayout, i, 0);
        try {
            try {
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i2 = 0; i2 < indexCount; i2++) {
                    int index = obtainStyledAttributes.getIndex(i2);
                    int i3 = R.styleable.BNSwipeMenuLayout_leftMenuView;
                    if (index == i3) {
                        this.b = obtainStyledAttributes.getResourceId(i3, -1);
                    } else {
                        int i4 = R.styleable.BNSwipeMenuLayout_rightMenuView;
                        if (index == i4) {
                            this.c = obtainStyledAttributes.getResourceId(i4, -1);
                        } else {
                            int i5 = R.styleable.BNSwipeMenuLayout_contentView;
                            if (index == i5) {
                                this.d = obtainStyledAttributes.getResourceId(i5, -1);
                            } else {
                                int i6 = R.styleable.BNSwipeMenuLayout_canLeftSwipe;
                                if (index == i6) {
                                    this.m = obtainStyledAttributes.getBoolean(i6, true);
                                } else {
                                    int i7 = R.styleable.BNSwipeMenuLayout_canRightSwipe;
                                    if (index == i7) {
                                        this.n = obtainStyledAttributes.getBoolean(i7, true);
                                    } else {
                                        int i8 = R.styleable.BNSwipeMenuLayout_fraction;
                                        if (index == i8) {
                                            this.l = obtainStyledAttributes.getFloat(i8, 0.5f);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.p.computeScrollOffset()) {
            scrollTo(this.p.getCurrX(), this.p.getCurrY());
            invalidate();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000e, code lost:
    
        if (r0 != 3) goto L53;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.swap.BNSwipeMenuLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public float getFraction() {
        return this.l;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(this.r);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(com.baidu.navisdk.ui.swap.a.CLOSE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000b, code lost:
    
        if (r0 != 3) goto L16;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            int r0 = r4.getAction()
            r1 = 1
            if (r0 == r1) goto L1c
            r2 = 2
            if (r0 == r2) goto Le
            r2 = 3
            if (r0 == r2) goto L1c
            goto L27
        Le:
            float r0 = r3.t
            float r0 = java.lang.Math.abs(r0)
            int r2 = r3.o
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L27
            return r1
        L1c:
            boolean r0 = r3.i
            if (r0 == 0) goto L27
            r4 = 0
            r3.i = r4
            r4 = 0
            r3.t = r4
            return r1
        L27:
            boolean r4 = super.onInterceptTouchEvent(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.swap.BNSwipeMenuLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (this.e == null && childAt.getId() == this.b) {
                this.e = childAt;
                childAt.setClickable(true);
            } else if (this.f == null && childAt.getId() == this.c) {
                this.f = childAt;
                childAt.setClickable(true);
            } else if (this.g == null && childAt.getId() == this.d) {
                this.g = childAt;
                childAt.setClickable(true);
            }
        }
        View view = this.g;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            this.h = marginLayoutParams;
            int i6 = marginLayoutParams.topMargin + paddingTop;
            int i7 = paddingLeft + marginLayoutParams.leftMargin;
            this.g.layout(i7, i6, this.g.getMeasuredWidth() + i7, this.g.getMeasuredHeight() + i6);
            View view2 = this.e;
            if (view2 != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                int i8 = marginLayoutParams2.topMargin + paddingTop;
                int measuredWidth = (0 - this.e.getMeasuredWidth()) + marginLayoutParams2.leftMargin;
                int i9 = marginLayoutParams2.rightMargin;
                this.e.layout(measuredWidth + i9, i8, 0 - i9, this.e.getMeasuredHeight() + i8);
            }
            View view3 = this.f;
            if (view3 != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
                int i10 = paddingTop + marginLayoutParams3.topMargin;
                int right = this.g.getRight() + this.h.rightMargin + marginLayoutParams3.leftMargin;
                this.f.layout(right, i10, this.f.getMeasuredWidth() + right, this.f.getMeasuredHeight() + i10);
                return;
            }
            return;
        }
        throw new IllegalStateException("未配置内容区域");
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        boolean z;
        int childMeasureSpec;
        int childMeasureSpec2;
        super.onMeasure(i, i2);
        setClickable(true);
        int childCount = getChildCount();
        if (View.MeasureSpec.getMode(i) == 1073741824 && View.MeasureSpec.getMode(i2) == 1073741824) {
            z = false;
        } else {
            z = true;
        }
        this.f9191a.clear();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                measureChildWithMargins(childAt, i, 0, i2, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                i3 = Math.max(i3, childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
                i5 = Math.max(i5, childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                i4 = View.combineMeasuredStates(i4, childAt.getMeasuredState());
                if (z && (marginLayoutParams.width == -1 || marginLayoutParams.height == -1)) {
                    this.f9191a.add(childAt);
                }
            }
        }
        int i7 = i4;
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i3, getSuggestedMinimumWidth()), i, i7), View.resolveSizeAndState(Math.max(i5, getSuggestedMinimumHeight()), i2, i7 << 16));
        int size = this.f9191a.size();
        if (size > 1) {
            for (int i8 = 0; i8 < size; i8++) {
                View view = this.f9191a.get(i8);
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int i9 = marginLayoutParams2.width;
                if (i9 == -1) {
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getMeasuredWidth() - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin), 1073741824);
                } else {
                    childMeasureSpec = ViewGroup.getChildMeasureSpec(i, marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin, i9);
                }
                int i10 = marginLayoutParams2.height;
                if (i10 == -1) {
                    childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getMeasuredHeight() - marginLayoutParams2.topMargin) - marginLayoutParams2.bottomMargin), 1073741824);
                } else {
                    childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin, i10);
                }
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }
    }

    public void setCanLeftSwipe(boolean z) {
        this.m = z;
    }

    public void setCanRightSwipe(boolean z) {
        this.n = z;
    }

    public void setFraction(float f) {
        this.l = f;
    }

    public void setOnStateChangeListener(a aVar) {
        this.s = aVar;
    }

    public BNSwipeMenuLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9191a = new ArrayList<>(1);
        this.l = 0.3f;
        this.m = true;
        this.n = true;
        this.r = com.baidu.navisdk.ui.swap.a.CLOSE;
        a(context, attributeSet, i);
    }

    private void a(com.baidu.navisdk.ui.swap.a aVar) {
        com.baidu.navisdk.ui.swap.a aVar2 = this.r;
        if (aVar == com.baidu.navisdk.ui.swap.a.LEFT_OPEN) {
            this.p.startScroll(getScrollX(), 0, this.e.getLeft() - getScrollX(), 0);
            this.q = this;
            this.r = aVar;
        } else if (aVar == com.baidu.navisdk.ui.swap.a.RIGHT_OPEN) {
            this.q = this;
            this.p.startScroll(getScrollX(), 0, ((this.f.getRight() - this.g.getRight()) - this.h.rightMargin) - getScrollX(), 0);
            this.r = aVar;
        } else {
            this.p.startScroll(getScrollX(), 0, -getScrollX(), 0);
            this.r = com.baidu.navisdk.ui.swap.a.CLOSE;
        }
        com.baidu.navisdk.ui.swap.a aVar3 = this.r;
        a aVar4 = this.s;
        if (aVar4 != null && aVar3 != aVar2) {
            aVar4.a(aVar2, aVar3);
        }
        invalidate();
    }

    private com.baidu.navisdk.ui.swap.a a(int i) {
        View view;
        View view2;
        if (this.o >= Math.abs(this.t)) {
            return this.r;
        }
        float f = this.t;
        if (f < 0.0f) {
            if (getScrollX() < 0 && (view2 = this.e) != null && Math.abs(view2.getWidth() * this.l) < Math.abs(getScrollX())) {
                return com.baidu.navisdk.ui.swap.a.LEFT_OPEN;
            }
            if (getScrollX() > 0 && this.f != null) {
                return com.baidu.navisdk.ui.swap.a.CLOSE;
            }
        } else if (f > 0.0f) {
            if (getScrollX() > 0 && (view = this.f) != null && Math.abs(view.getWidth() * this.l) < Math.abs(getScrollX())) {
                return com.baidu.navisdk.ui.swap.a.RIGHT_OPEN;
            }
            if (getScrollX() < 0 && this.e != null) {
                return com.baidu.navisdk.ui.swap.a.CLOSE;
            }
        }
        return com.baidu.navisdk.ui.swap.a.CLOSE;
    }
}
