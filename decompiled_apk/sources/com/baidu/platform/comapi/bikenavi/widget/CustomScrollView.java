package com.baidu.platform.comapi.bikenavi.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import com.baidu.R;
import java.lang.reflect.Field;

/* loaded from: classes8.dex */
public class CustomScrollView extends ScrollView {
    public static final Object TAG = new Object();

    /* renamed from: a, reason: collision with root package name */
    private VelocityTracker f9554a;
    private int b;
    public int bottom;
    private int c;
    private b d;
    private b e;
    private GestureDetector f;
    private GestureDetector g;
    private int h;
    private int i;
    private LinearLayout j;
    private View k;
    private LinearLayout l;
    private boolean m;
    private com.baidu.platform.comapi.wnplatform.o.b n;
    protected Field scrollerField;
    public int top;

    /* loaded from: classes8.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return f2 > 0.0f;
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(int i);

        void a(com.baidu.platform.comapi.wnplatform.o.b bVar, com.baidu.platform.comapi.wnplatform.o.b bVar2);
    }

    /* loaded from: classes8.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        public c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(f2) > Math.abs(f)) {
                return true;
            }
            return false;
        }
    }

    public CustomScrollView(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        setTag(TAG);
        this.f = new GestureDetector(context, new c());
        this.g = new GestureDetector(context, new a());
        setFadingEdgeLength(0);
        setVerticalScrollBarEnabled(false);
        this.top = com.baidu.platform.comapi.wnplatform.p.h.c(context) - com.baidu.platform.comapi.wnplatform.p.h.d(context);
        this.bottom = 0;
        this.c = 3;
        com.baidu.platform.comapi.wnplatform.p.a.a.a((Activity) getContext(), R.layout.wsdk_layout_custom_scroll_view, this);
        this.j = (LinearLayout) findViewById(R.id.ll_blank);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_content);
        this.l = linearLayout;
        linearLayout.setMinimumHeight(this.top);
    }

    public static Field getDeclaredField(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public void addContentView(View view) {
        this.l.addView(view);
    }

    @Override // android.widget.ScrollView, android.view.View
    public int computeVerticalScrollRange() {
        int computeVerticalScrollRange = super.computeVerticalScrollRange();
        this.h = computeVerticalScrollRange;
        return computeVerticalScrollRange;
    }

    public com.baidu.platform.comapi.wnplatform.o.b getStatus() {
        return this.n;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            a();
        }
        if (super.onInterceptTouchEvent(motionEvent) && this.f.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.i = i4 - i2;
        }
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        boolean z;
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(i2);
        }
        b bVar2 = this.e;
        if (bVar2 != null) {
            bVar2.a(i2);
        }
        if (this.h - this.i == i2) {
            z = true;
        } else {
            z = false;
        }
        if (i2 == 0 || z) {
            try {
                if (this.scrollerField == null) {
                    this.scrollerField = getDeclaredField(this, "mScroller");
                }
                Object obj = this.scrollerField.get(this);
                if (obj != null && (obj instanceof Scroller)) {
                    ((Scroller) obj).abortAnimation();
                }
                return;
            } catch (Exception unused) {
            }
        }
        super.onScrollChanged(i, i2, i3, i4);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean a2;
        ViewConfiguration.get(getContext());
        this.b = ViewConfiguration.getMaximumFlingVelocity();
        View view = this.k;
        if (view == null) {
            a2 = false;
        } else {
            a2 = a(motionEvent, view);
        }
        if (a2 && this.n == com.baidu.platform.comapi.wnplatform.o.b.BOTTOM) {
            return false;
        }
        a(motionEvent);
        if (motionEvent.getAction() == 1) {
            VelocityTracker velocityTracker = this.f9554a;
            velocityTracker.computeCurrentVelocity(1000, this.b);
            com.baidu.platform.comapi.wnplatform.o.b a3 = a((int) velocityTracker.getYVelocity(), getScrollY());
            if (a3 != com.baidu.platform.comapi.wnplatform.o.b.NULL) {
                updateStatus(a3, true);
                return true;
            }
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public void removeContentView(View view) {
        LinearLayout linearLayout = this.l;
        if (linearLayout != null) {
            linearLayout.removeView(view);
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (view2 != null && ((view2 instanceof WebView) || (view2 instanceof ListView) || (view2 instanceof ScrollView))) {
            return;
        }
        super.requestChildFocus(view, view2);
    }

    public void setBlankHeight(int i) {
        this.j.removeAllViews();
        this.k = new View(getContext());
        this.k.setLayoutParams(new AbsListView.LayoutParams(0, i));
        this.j.addView(this.k);
    }

    public void setCustomOnScrollChangeListener(b bVar) {
        this.e = bVar;
    }

    public void setOnScrollChangeListener(b bVar) {
        this.d = bVar;
    }

    public void setStatusHeight(int i, int i2) {
        this.l.setMinimumHeight(i);
        this.top = i;
        this.bottom = i2;
        this.c = 3;
    }

    public void updateStatus(com.baidu.platform.comapi.wnplatform.o.b bVar, boolean z) {
        b bVar2 = this.d;
        if (bVar2 != null) {
            bVar2.a(this.n, bVar);
        }
        b bVar3 = this.e;
        if (bVar3 != null) {
            bVar3.a(this.n, bVar);
        }
        this.n = bVar;
        int i = g.f9565a[bVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (z) {
                    smoothScrollTo(0, this.top);
                    return;
                } else {
                    scrollTo(0, this.top);
                    return;
                }
            }
            return;
        }
        if (z) {
            smoothScrollTo(0, this.bottom);
        } else {
            scrollTo(0, this.bottom);
        }
    }

    public CustomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = 0;
        this.i = 0;
        this.m = false;
        this.n = com.baidu.platform.comapi.wnplatform.o.b.BOTTOM;
        a(context);
    }

    public CustomScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = 0;
        this.i = 0;
        this.m = false;
        this.n = com.baidu.platform.comapi.wnplatform.o.b.BOTTOM;
        a(context);
    }

    private com.baidu.platform.comapi.wnplatform.o.b a(int i, int i2) {
        int i3 = g.f9565a[this.n.ordinal()];
        if (i3 == 1) {
            if ((i < 0 && Math.abs(i) > 1000) || i2 > this.c) {
                return com.baidu.platform.comapi.wnplatform.o.b.TOP;
            }
            return com.baidu.platform.comapi.wnplatform.o.b.BOTTOM;
        }
        if (i3 != 2) {
            return com.baidu.platform.comapi.wnplatform.o.b.BOTTOM;
        }
        if (i <= 1000 && i2 >= this.c) {
            if (i2 > this.top) {
                return com.baidu.platform.comapi.wnplatform.o.b.NULL;
            }
            return com.baidu.platform.comapi.wnplatform.o.b.TOP;
        }
        return com.baidu.platform.comapi.wnplatform.o.b.BOTTOM;
    }

    private void a(MotionEvent motionEvent) {
        if (this.f9554a == null) {
            this.f9554a = VelocityTracker.obtain();
        }
        this.f9554a.addMovement(motionEvent);
    }

    private boolean a(MotionEvent motionEvent, View view) {
        boolean a2 = a(motionEvent.getY(), view);
        if (motionEvent.getAction() == 0) {
            if (a2) {
                this.m = true;
            } else {
                this.m = false;
            }
        }
        if (motionEvent.getAction() == 1) {
            this.m = false;
        }
        return this.m && a2 && motionEvent.getAction() != 1;
    }

    private boolean a(float f, View view) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        return f > ((float) rect.top) && f < ((float) (rect.bottom - getScrollY()));
    }

    private void a() {
        try {
            if (this.scrollerField == null) {
                this.scrollerField = getDeclaredField(this, "mScroller");
            }
            Object obj = this.scrollerField.get(this);
            if (obj == null) {
                return;
            }
            obj.getClass().getMethod("abortAnimation", null).invoke(obj, null);
        } catch (Exception unused) {
        }
    }
}
