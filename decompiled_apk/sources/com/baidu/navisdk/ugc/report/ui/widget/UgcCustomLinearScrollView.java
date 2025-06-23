package com.baidu.navisdk.ugc.report.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public class UgcCustomLinearScrollView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private boolean f8309a;
    private int b;
    private int c;
    private int d;
    private Scroller e;
    private boolean f;
    private VelocityTracker g;
    private b h;
    int i;
    int j;
    int k;
    boolean l;
    boolean m;
    int n;
    boolean o;
    private boolean p;
    boolean q;
    private a r;

    /* loaded from: classes8.dex */
    public interface a {
        void onEventCatch(MotionEvent motionEvent);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void onStatusChange(int i);
    }

    public UgcCustomLinearScrollView(Context context) {
        this(context, null);
    }

    private void a() {
        VelocityTracker velocityTracker = this.g;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.g = null;
        }
    }

    private int getVelocity() {
        this.g.computeCurrentVelocity(1000);
        return (int) this.g.getYVelocity();
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.e.computeScrollOffset()) {
            scrollTo(0, this.e.getCurrY());
            invalidate();
            return;
        }
        if (this.l) {
            if (getScrollY() < (-this.i) / 2) {
                b bVar = this.h;
                if (bVar != null && !this.p) {
                    bVar.onStatusChange(1);
                }
                this.k = 1;
            } else {
                b bVar2 = this.h;
                if (bVar2 != null && !this.p) {
                    bVar2.onStatusChange(0);
                }
                this.k = 0;
            }
            this.l = false;
        }
        this.f = false;
        if (this.o) {
            if (this.k == 1) {
                scrollTo(0, -this.i);
            } else {
                scrollTo(0, 0);
            }
            this.o = false;
            if (this.f8309a) {
                this.l = true;
            }
        }
        this.p = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar = this.r;
        if (aVar != null) {
            aVar.onEventCatch(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getCurStatus() {
        return this.k;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptHoverEvent(MotionEvent motionEvent) {
        return this.q;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = R.id.ugc_sub_fade_layer;
        if (findViewById(i5) != null) {
            int i6 = R.id.ugc_sub_scroll_layout;
            if (findViewById(i6) != null) {
                this.i = findViewById(i6).getHeight();
                this.n = findViewById(i5).getHeight();
                this.j = getHeight() - this.n;
            }
        }
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_Others", "UgcCustomLinearScrollView: onLayout bottomHight:" + this.i + " button:" + this.n + "topHight: " + this.j);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.m) {
            super.onTouchEvent(motionEvent);
            return true;
        }
        if (this.f) {
            super.onTouchEvent(motionEvent);
            return true;
        }
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        a(motionEvent);
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (!this.e.isFinished()) {
                        this.e.abortAnimation();
                    }
                    int i = this.d - y;
                    int scrollY = getScrollY();
                    if (i > 0 && i + scrollY > 0) {
                        g.UGC.e("UgcCustomLinearScrollView: break move1", " " + i + "  " + scrollY);
                    } else if ((-(scrollY + i)) > this.i) {
                        g.UGC.e("UgcCustomLinearScrollView: break move2", " " + i + "  " + scrollY);
                    } else {
                        scrollBy(0, i);
                        this.d = y;
                    }
                }
            } else if (this.q) {
                this.q = false;
                int scrollY2 = getScrollY();
                this.c = scrollY2;
                int i2 = scrollY2 - this.b;
                g gVar = g.UGC;
                if (gVar.d()) {
                    gVar.e("UgcModule_Others", "UgcCustomLinearScrollView: ACTION_UP " + this.c + "  " + this.b + "  " + i2);
                }
                if (this.k == 0) {
                    if ((-(this.c - this.b)) > this.i / 3) {
                        this.e.startScroll(0, getScrollY(), 0, -(this.i + i2));
                        if (gVar.d()) {
                            gVar.e("UgcModule_Others", "UgcCustomLinearScrollView: up 1");
                        }
                        this.k = 1;
                        this.l = true;
                        this.o = true;
                    } else {
                        this.e.startScroll(0, getScrollY(), 0, -i2);
                        this.o = true;
                        if (gVar.d()) {
                            gVar.e("UgcModule_Others", "UgcCustomLinearScrollView: up 2");
                        }
                    }
                } else if (this.c - this.b > (this.j - this.i) / 3) {
                    this.k = 0;
                    this.l = true;
                    this.o = true;
                    this.e.startScroll(0, getScrollY(), 0, this.i - i2);
                    if (gVar.d()) {
                        gVar.e("UgcModule_Others", "UgcCustomLinearScrollView: up 3");
                    }
                } else {
                    this.e.startScroll(0, getScrollY(), 0, -i2);
                    this.o = true;
                    if (gVar.d()) {
                        gVar.e("UgcModule_Others", "UgcCustomLinearScrollView: up 4");
                    }
                }
                this.f = true;
                postInvalidate();
                a();
            }
        } else {
            int scrollY3 = getScrollY();
            this.b = scrollY3;
            int i3 = this.i;
            if (scrollY3 < (-i3) / 2) {
                this.k = 1;
            } else {
                this.k = 0;
            }
            if (this.k == 1) {
                if (y < i3 + this.n) {
                    g.UGC.e("UgcCustomLinearScrollView: return status_bottom", " " + y);
                    return false;
                }
            } else if (y < this.n) {
                g.UGC.e("UgcCustomLinearScrollView: return status_top", " " + y);
                return false;
            }
            g.UGC.e("UgcCustomLinearScrollView: ACTION_DOWN ", " " + this.k + "  " + this.b + "  ");
            this.q = true;
            this.d = y;
        }
        return true;
    }

    public void setNeedStatusChange(boolean z) {
        this.f8309a = z;
    }

    public void setOnEventCatchListener(a aVar) {
        this.r = aVar;
    }

    public void setOnStatusChangeListener(b bVar) {
        this.h = bVar;
    }

    public void setScrollSupport(boolean z) {
        this.m = z;
    }

    public UgcCustomLinearScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8309a = false;
        this.i = 0;
        this.k = 0;
        this.l = false;
        this.m = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = null;
        this.e = new Scroller(context);
    }

    private void a(MotionEvent motionEvent) {
        if (this.g == null) {
            this.g = VelocityTracker.obtain();
        }
        this.g.addMovement(motionEvent);
    }

    public UgcCustomLinearScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8309a = false;
        this.i = 0;
        this.k = 0;
        this.l = false;
        this.m = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = null;
        this.e = new Scroller(context);
    }
}
