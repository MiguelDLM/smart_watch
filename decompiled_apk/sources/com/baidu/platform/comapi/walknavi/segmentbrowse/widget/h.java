package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class h extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public static int f9840a = 600;
    private d b;
    private d c;
    private d d;
    private int e;
    private Scroller f;
    private boolean g;
    private a h;
    private int i;
    private ArrayList<d> j;
    private boolean k;
    private boolean l;
    private int m;
    private boolean n;
    private int o;
    private float p;
    private VelocityTracker q;

    /* loaded from: classes8.dex */
    public interface a {
        void a(String str);
    }

    public void a() {
        d dVar = this.b;
        if (dVar != null) {
            dVar.a();
        }
        d dVar2 = this.c;
        if (dVar2 != null) {
            dVar2.a();
        }
        d dVar3 = this.d;
        if (dVar3 != null) {
            dVar3.a();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "computeScroll--->" + this.f.computeScrollOffset());
        if (this.f.computeScrollOffset()) {
            com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", this.f.getCurrX() + "======" + this.f.getCurrY());
            scrollTo(this.f.getCurrX(), this.f.getCurrY());
            postInvalidate();
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "istime:isGoToNext:" + this.k + "isGoToLast:" + this.l);
        if (this.k) {
            this.k = false;
            this.h.a("next");
        }
        if (this.l) {
            this.l = false;
            this.h.a("last");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!this.g) {
            if (getChildCount() == 2) {
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g()) {
                    this.j.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.m(), 0, 0, this.m);
                    this.j.get(1).layout(0, 0, this.e, this.m);
                    return;
                }
                if (this.e == com.baidu.platform.comapi.walknavi.segmentbrowse.c.n()) {
                    this.j.get(0).layout(0, 0, this.e, this.m);
                } else {
                    com.baidu.platform.comapi.wnplatform.d.a.a("on layout true", ViewHierarchyConstants.DIMENSION_WIDTH_KEY + this.e);
                    this.j.get(0).layout(0, 0, this.e, this.m);
                }
                d dVar = this.j.get(1);
                int i5 = this.e;
                dVar.layout(i5, 0, ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.k() * this.i)) + i5, this.m);
                return;
            }
            this.j.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.m(), 0, 0, this.m);
            if (this.e == com.baidu.platform.comapi.walknavi.segmentbrowse.c.n()) {
                this.j.get(1).layout(0, 0, this.e, this.m);
            } else {
                com.baidu.platform.comapi.wnplatform.d.a.a("on layout true", ViewHierarchyConstants.DIMENSION_WIDTH_KEY + this.e);
                this.j.get(1).layout(0, 0, this.e, this.m);
            }
            d dVar2 = this.j.get(2);
            int i6 = this.e;
            dVar2.layout(i6, 0, ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.k() * this.i)) + i6, this.m);
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("on layout false", ViewHierarchyConstants.DIMENSION_WIDTH_KEY + this.e);
        if (getChildCount() == 2) {
            com.baidu.platform.comapi.wnplatform.d.a.a("getchild cur uid", "uid" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.b());
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g()) {
                this.j.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.m(), 0, 0, this.m);
                this.j.get(1).layout(0, 0, com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), this.m);
                return;
            } else {
                this.j.get(0).layout(this.e - ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.p() * this.i)), 0, this.e, this.m);
                d dVar3 = this.j.get(1);
                int i7 = this.e;
                dVar3.layout(i7, 0, ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.k() * this.i)) + i7, this.m);
                return;
            }
        }
        this.j.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.m(), 0, 0, this.m);
        this.j.get(1).layout(this.e - ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.p() * this.i)), 0, this.e, this.m);
        d dVar4 = this.j.get(2);
        int i8 = this.e;
        dVar4.layout(i8, 0, ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.k() * this.i)) + i8, this.m);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.q == null) {
            this.q = VelocityTracker.obtain();
        }
        this.q.addMovement(motionEvent);
        float x = motionEvent.getX();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        this.o = 0;
                    }
                } else {
                    int i = (int) (this.p - x);
                    this.n = true;
                    if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.f() && i < 0) {
                        this.n = false;
                    }
                    if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g() && i > 0) {
                        this.n = false;
                    }
                    if (this.n) {
                        scrollBy(1, 0);
                        this.p = x;
                    }
                }
            } else {
                VelocityTracker velocityTracker = this.q;
                velocityTracker.computeCurrentVelocity(1000);
                int xVelocity = (int) velocityTracker.getXVelocity();
                if (xVelocity > f9840a) {
                    com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent width" + this.e);
                    this.n = true;
                    if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.f()) {
                        this.n = false;
                    }
                    if (this.n) {
                        this.l = true;
                        int scrollX = (-com.baidu.platform.comapi.walknavi.segmentbrowse.c.m()) - getScrollX();
                        com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent up startScroll---------------");
                        this.f.startScroll(getScrollX(), 0, scrollX, 0, 1000);
                        invalidate();
                    }
                } else if (xVelocity < 0) {
                    this.n = true;
                    if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g()) {
                        this.n = false;
                    }
                    com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent width" + this.e);
                    com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent getscrollx" + getScrollX());
                    com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent isNeedMove" + this.n);
                    if (this.n) {
                        this.k = true;
                        com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent down startScroll---------------");
                        this.f.startScroll(getScrollX(), 0, this.e - getScrollX(), 0, 500);
                        invalidate();
                    }
                }
                VelocityTracker velocityTracker2 = this.q;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.q = null;
                }
                this.o = 0;
            }
        } else {
            Scroller scroller = this.f;
            if (scroller != null && !scroller.isFinished()) {
                this.f.abortAnimation();
            }
            this.p = x;
        }
        return false;
    }
}
