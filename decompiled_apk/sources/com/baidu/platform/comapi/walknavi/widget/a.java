package com.baidu.platform.comapi.walknavi.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.baidu.platform.comapi.wnplatform.f;

/* loaded from: classes8.dex */
public class a extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f9842a = true;
    public static int b = 600;
    private static final String e = "a";
    private Context c;
    private com.baidu.platform.comapi.walknavi.segmentbrowse.widget.d d;
    private int f;
    private Scroller g;
    private InterfaceC0539a h;
    private boolean i;
    private boolean j;
    private int k;
    private boolean l;
    private boolean m;
    private float n;
    private VelocityTracker o;

    /* renamed from: com.baidu.platform.comapi.walknavi.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0539a {
        void a(String str);
    }

    public a(Context context, int i) {
        super(context);
        this.f = 0;
        this.i = false;
        this.j = false;
        this.k = 0;
        this.l = false;
        this.n = 0.0f;
        this.o = null;
        this.c = context;
        a(i);
    }

    public boolean a() {
        return this.l;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.g.computeScrollOffset()) {
            scrollTo(this.g.getCurrX(), this.g.getCurrY());
            postInvalidate();
            return;
        }
        if (this.i) {
            this.i = false;
            InterfaceC0539a interfaceC0539a = this.h;
            if (interfaceC0539a != null) {
                interfaceC0539a.a("next");
            }
        }
        if (this.j) {
            this.j = false;
            InterfaceC0539a interfaceC0539a2 = this.h;
            if (interfaceC0539a2 != null) {
                interfaceC0539a2.a("last");
            }
        }
        f9842a = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        this.l = true;
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.l = false;
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ((com.baidu.platform.comapi.walknavi.segmentbrowse.widget.d) getChildAt(0)).layout(0, 0, this.f, this.k);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (f.a().c()) {
            return false;
        }
        if (this.o == null) {
            this.o = VelocityTracker.obtain();
        }
        this.o.addMovement(motionEvent);
        float x = motionEvent.getX();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i = (int) (this.n - x);
                    this.m = true;
                    if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.f() && i < 0) {
                        this.m = false;
                    }
                    if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g() && i > 0) {
                        this.m = false;
                    }
                    if (this.m) {
                        scrollBy(1, 0);
                        this.n = x;
                    }
                }
            } else {
                VelocityTracker velocityTracker = this.o;
                velocityTracker.computeCurrentVelocity(1000);
                f9842a = false;
                int xVelocity = (int) velocityTracker.getXVelocity();
                if (xVelocity > b) {
                    this.m = true;
                    if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.f()) {
                        this.m = false;
                    }
                    if (this.m) {
                        this.j = true;
                        this.g.startScroll(getScrollX(), 0, (-com.baidu.platform.comapi.walknavi.segmentbrowse.c.m()) - getScrollX(), 0, 1000);
                        invalidate();
                    }
                } else if (xVelocity < 0) {
                    this.m = true;
                    if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g()) {
                        this.m = false;
                    }
                    if (this.m) {
                        this.i = true;
                        this.g.startScroll(getScrollX(), 0, this.f - getScrollX(), 0, 500);
                        invalidate();
                    }
                }
                VelocityTracker velocityTracker2 = this.o;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.o = null;
                }
            }
        } else {
            Scroller scroller = this.g;
            if (scroller != null && !scroller.isFinished()) {
                this.g.abortAnimation();
            }
            this.n = x;
        }
        return false;
    }

    public void a(InterfaceC0539a interfaceC0539a) {
        this.h = interfaceC0539a;
    }

    public void a(int i) {
        this.g = new Scroller(this.c);
        this.f = com.baidu.platform.comapi.walknavi.segmentbrowse.c.q();
        com.baidu.platform.comapi.walknavi.segmentbrowse.widget.f.a().a(this.f);
        this.k = com.baidu.platform.comapi.walknavi.segmentbrowse.widget.b.a(this.c, 95.0f);
        com.baidu.platform.comapi.walknavi.segmentbrowse.widget.d dVar = new com.baidu.platform.comapi.walknavi.segmentbrowse.widget.d(this.c, com.baidu.platform.comapi.walknavi.segmentbrowse.c.e(com.baidu.platform.comapi.walknavi.segmentbrowse.c.b()), this.f);
        this.d = dVar;
        addView(dVar);
    }

    public void a(String str) {
        ((com.baidu.platform.comapi.walknavi.segmentbrowse.widget.d) getChildAt(0)).a(com.baidu.platform.comapi.walknavi.segmentbrowse.c.e(com.baidu.platform.comapi.walknavi.segmentbrowse.c.b()), str);
    }
}
