package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class g extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public static int f9839a = 20;
    private static String c = "MultiViewGroup";
    private Context b;
    private int d;
    private Scroller e;
    private ArrayList<View> f;
    private ArrayList<Integer> g;
    private int h;
    private int i;
    private boolean j;
    private int k;
    private com.baidu.platform.comapi.walknavi.h.b l;
    private a m;
    private int n;
    private int o;
    private float p;
    private float q;
    private VelocityTracker r;
    private int s;

    /* loaded from: classes8.dex */
    public interface a {
        void a();
    }

    public g(Context context, com.baidu.platform.comapi.walknavi.h.b bVar) {
        super(context);
        this.d = 0;
        this.e = null;
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
        this.h = 60;
        this.i = 0;
        this.j = true;
        this.k = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0.0f;
        this.q = 0.0f;
        this.r = null;
        this.s = 0;
        this.b = context;
        this.l = bVar;
        b();
    }

    private d a(d dVar, com.baidu.platform.comapi.walknavi.segmentbrowse.a aVar) {
        return dVar;
    }

    private void b() {
        com.baidu.platform.comapi.walknavi.b.a().Y().n();
        this.e = new Scroller(this.b);
        this.k = b.a(this.b, 95.0f);
        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() != 0) {
            d dVar = new d(this.b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.e(com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() - 1), -1);
            dVar.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() - 1));
            this.f.add(a(dVar, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d()));
            this.i = 0 - com.baidu.platform.comapi.walknavi.segmentbrowse.c.m();
            this.d = com.baidu.platform.comapi.walknavi.segmentbrowse.c.b();
        }
        d dVar2 = new d(this.b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.e(com.baidu.platform.comapi.walknavi.segmentbrowse.c.b()), -1);
        dVar2.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.b()));
        this.f.add(a(dVar2, com.baidu.platform.comapi.walknavi.segmentbrowse.c.c()));
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.g(com.baidu.platform.comapi.walknavi.segmentbrowse.c.b());
        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() != com.baidu.platform.comapi.walknavi.segmentbrowse.c.g()) {
            d dVar3 = new d(this.b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.e(com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() + 1), -1);
            dVar3.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() + 1));
            this.f.add(a(dVar3, com.baidu.platform.comapi.walknavi.segmentbrowse.c.e()));
        }
        for (int i = 0; i < this.f.size(); i++) {
            addView(this.f.get(i));
        }
        this.o = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.view.View
    public void computeScroll() {
        com.baidu.platform.comapi.wnplatform.d.a.a(c, "computeScroll");
        if (this.e.computeScrollOffset()) {
            com.baidu.platform.comapi.wnplatform.d.a.a(c, this.e.getCurrX() + "======" + this.e.getCurrY());
            scrollTo(this.e.getCurrX(), this.e.getCurrY());
            com.baidu.platform.comapi.wnplatform.d.a.a(c, "### getleft is " + getLeft() + " ### getRight is " + getRight());
            postInvalidate();
            return;
        }
        a aVar = this.m;
        if (aVar != null) {
            aVar.a();
        }
        this.j = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
    
        if (r0 != 3) goto L19;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            java.lang.String r0 = com.baidu.platform.comapi.walknavi.segmentbrowse.widget.g.c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onInterceptTouchEvent-slop:"
            r1.append(r2)
            int r2 = r5.o
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.baidu.platform.comapi.wnplatform.d.a.a(r0, r1)
            int r0 = r6.getAction()
            r1 = 1
            r2 = 2
            if (r0 != r2) goto L25
            int r3 = r5.n
            if (r3 == 0) goto L25
            return r1
        L25:
            float r3 = r6.getX()
            float r6 = r6.getY()
            r4 = 0
            if (r0 == 0) goto L58
            if (r0 == r1) goto L4e
            if (r0 == r2) goto L38
            r6 = 3
            if (r0 == r6) goto L4e
            goto L88
        L38:
            java.lang.String r6 = com.baidu.platform.comapi.walknavi.segmentbrowse.widget.g.c
            java.lang.String r0 = "onInterceptTouchEvent move"
            com.baidu.platform.comapi.wnplatform.d.a.a(r6, r0)
            float r6 = r5.p
            float r6 = r6 - r3
            float r6 = java.lang.Math.abs(r6)
            int r6 = (int) r6
            int r0 = r5.o
            if (r6 <= r0) goto L88
            r5.n = r1
            goto L88
        L4e:
            java.lang.String r6 = com.baidu.platform.comapi.walknavi.segmentbrowse.widget.g.c
            java.lang.String r0 = "onInterceptTouchEvent up or cancel"
            com.baidu.platform.comapi.wnplatform.d.a.a(r6, r0)
            r5.n = r4
            goto L88
        L58:
            java.lang.String r0 = com.baidu.platform.comapi.walknavi.segmentbrowse.widget.g.c
            java.lang.String r2 = "onInterceptTouchEvent down"
            com.baidu.platform.comapi.wnplatform.d.a.a(r0, r2)
            r5.p = r3
            r5.q = r6
            java.lang.String r6 = com.baidu.platform.comapi.walknavi.segmentbrowse.widget.g.c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.widget.Scroller r2 = r5.e
            boolean r2 = r2.isFinished()
            r0.append(r2)
            java.lang.String r2 = ""
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.baidu.platform.comapi.wnplatform.d.a.a(r6, r0)
            android.widget.Scroller r6 = r5.e
            boolean r6 = r6.isFinished()
            r6 = r6 ^ r1
            r5.n = r6
        L88:
            java.lang.String r6 = com.baidu.platform.comapi.walknavi.segmentbrowse.widget.g.c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r2 = r5.n
            r0.append(r2)
            java.lang.String r2 = "===="
            r0.append(r2)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.baidu.platform.comapi.wnplatform.d.a.a(r6, r0)
            int r6 = r5.n
            if (r6 == 0) goto La8
            goto La9
        La8:
            r1 = 0
        La9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.walknavi.segmentbrowse.widget.g.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.baidu.platform.comapi.wnplatform.d.a.a(c, "--- start onLayout --");
        com.baidu.platform.comapi.wnplatform.d.a.a("view count onlayout", getChildCount() + "child count");
        int childCount = getChildCount();
        com.baidu.platform.comapi.wnplatform.d.a.a(c, "--- onLayout childCount is -->" + childCount);
        if (childCount == 2) {
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g()) {
                View view = this.f.get(0);
                if (view.getVisibility() != 8 && com.baidu.platform.comapi.walknavi.segmentbrowse.c.m() != -1) {
                    int i5 = this.i;
                    view.layout(i5, 0, com.baidu.platform.comapi.walknavi.segmentbrowse.c.m() + i5, this.k);
                }
                View view2 = this.f.get(1);
                if (view2.getVisibility() != 8 && com.baidu.platform.comapi.walknavi.segmentbrowse.c.m() != -1 && com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() != -1) {
                    view2.layout(this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.m(), 0, this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.m() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), this.k);
                }
            } else {
                View view3 = this.f.get(0);
                if (view3.getVisibility() != 8 && com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() != -1) {
                    int i6 = this.i;
                    view3.layout(i6, 0, com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() + i6, this.k);
                }
                View view4 = this.f.get(1);
                if (view4.getVisibility() != 8) {
                    view4.layout(this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), this.k);
                }
            }
        }
        if (childCount == 3) {
            View view5 = this.f.get(0);
            if (view5.getVisibility() != 8 && com.baidu.platform.comapi.walknavi.segmentbrowse.c.m() != -1) {
                int i7 = this.i;
                view5.layout(i7, 0, com.baidu.platform.comapi.walknavi.segmentbrowse.c.m() + i7, this.k);
            }
            com.baidu.platform.comapi.wnplatform.d.a.a("aaa", "0**" + view5.getLeft() + "**" + view5.getRight());
            View view6 = this.f.get(1);
            if (view6.getVisibility() != 8) {
                view6.layout(this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.m(), 0, this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.m() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), this.k);
            }
            com.baidu.platform.comapi.wnplatform.d.a.a("aaa", "1**" + view6.getLeft() + "**" + view6.getRight());
            View view7 = this.f.get(2);
            if (view7.getVisibility() != 8) {
                view7.layout(this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.m() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.m() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), this.k);
            }
            com.baidu.platform.comapi.wnplatform.d.a.a("aaa", "2**" + view7.getLeft() + "**" + view7.getRight());
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        com.baidu.platform.comapi.wnplatform.d.a.a(c, "--- start onMeasure --");
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        int childCount = getChildCount();
        com.baidu.platform.comapi.wnplatform.d.a.a(c, "--- onMeasure childCount is -->" + childCount);
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(getWidth(), 200);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.baidu.platform.comapi.wnplatform.d.a.a(c, "--- onTouchEvent--> ");
        com.baidu.platform.comapi.wnplatform.d.a.a(c, "onTouchEvent start");
        if (this.r == null) {
            com.baidu.platform.comapi.wnplatform.d.a.a(c, "onTouchEvent start-------** VelocityTracker.obtain");
            this.r = VelocityTracker.obtain();
        }
        this.r.addMovement(motionEvent);
        super.onTouchEvent(motionEvent);
        float x = motionEvent.getX();
        int action = motionEvent.getAction();
        if (action != 0) {
            boolean z = true;
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        this.n = 0;
                    }
                } else if (this.j) {
                    int i = (int) (this.p - x);
                    if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.f() && i < 0) {
                        z = false;
                    }
                    if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g() && i > 0) {
                        z = false;
                    }
                    if (z) {
                        com.baidu.platform.comapi.wnplatform.d.a.a(c, "--- MotionEvent.ACTION_MOVE--> detaX is " + i);
                        this.p = x;
                    }
                }
            } else {
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE || com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING) {
                    com.baidu.platform.comapi.wnplatform.m.a.a().a("FootNaviPG.segment");
                    com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE);
                    com.baidu.platform.comapi.walknavi.b.a().K().k();
                    com.baidu.platform.comapi.walknavi.b.a().M().run("强诱导转到分段");
                }
                if (this.j) {
                    VelocityTracker velocityTracker = this.r;
                    velocityTracker.computeCurrentVelocity(1000);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    com.baidu.platform.comapi.wnplatform.d.a.a(c, "---velocityX---" + xVelocity);
                    int i2 = f9839a;
                    if (xVelocity > i2) {
                        com.baidu.platform.comapi.wnplatform.d.a.a(c, "snap left");
                        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.f()) {
                            com.baidu.platform.comapi.wnplatform.d.a.a("yang13", "该点是起点，不能左滑");
                        } else {
                            a(this.d - 1);
                        }
                    } else if (xVelocity < (-i2)) {
                        com.baidu.platform.comapi.wnplatform.d.a.a(c, "snap right");
                        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g()) {
                            com.baidu.platform.comapi.wnplatform.d.a.a("yang13", "该点是终点，不能右滑");
                        } else {
                            a(this.d + 1);
                        }
                    }
                    VelocityTracker velocityTracker2 = this.r;
                    if (velocityTracker2 != null) {
                        velocityTracker2.recycle();
                        this.r = null;
                    }
                    this.n = 0;
                }
            }
        } else if (this.j) {
            Scroller scroller = this.e;
            if (scroller != null && !scroller.isFinished()) {
                this.e.abortAnimation();
            }
            this.p = x;
        }
        return false;
    }

    public void a() {
        if (com.baidu.platform.comapi.walknavi.b.a().Y() instanceof com.baidu.platform.comapi.walknavi.h.b) {
        }
    }

    public void a(int i) {
        int m;
        int scrollX;
        com.baidu.platform.comapi.walknavi.h.a.a aVar;
        int i2 = this.d;
        boolean z = i2 != i;
        boolean z2 = i2 <= i;
        this.d = i;
        com.baidu.platform.comapi.wnplatform.d.a.a("tag", "curscreen" + this.d);
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.b(this.d);
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.g(this.d);
        a();
        com.baidu.platform.comapi.walknavi.segmentbrowse.a e = com.baidu.platform.comapi.walknavi.segmentbrowse.c.e(com.baidu.platform.comapi.walknavi.segmentbrowse.c.b());
        if (e != null && !TextUtils.isEmpty(e.a()) && !TextUtils.isEmpty(e.b())) {
            com.baidu.platform.comapi.wnplatform.d.a.a("tag", "xxx floor:" + e.a());
            com.baidu.platform.comapi.wnplatform.p.e.a(e.a(), e.b(), false);
            if ((com.baidu.platform.comapi.walknavi.b.a().Y() instanceof com.baidu.platform.comapi.walknavi.h.b) && (aVar = ((com.baidu.platform.comapi.walknavi.h.b) com.baidu.platform.comapi.walknavi.b.a().Y()).d) != null) {
                aVar.a(e.a());
            }
        }
        if (com.baidu.platform.comapi.walknavi.b.a().Y() != null) {
            com.baidu.platform.comapi.walknavi.b.a().Y().n();
        }
        if (z) {
            if (z2) {
                if (this.d == 1) {
                    d dVar = new d(this.b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.e(this.d + 1), -1);
                    dVar.setTag(Integer.valueOf(this.d + 1));
                    d a2 = a(dVar, com.baidu.platform.comapi.walknavi.segmentbrowse.c.e());
                    addView(a2);
                    this.f.add(a2);
                }
                if (this.d >= 2) {
                    this.i += com.baidu.platform.comapi.walknavi.segmentbrowse.c.l();
                    removeView(this.f.get(0));
                    this.f.remove(0);
                    com.baidu.platform.comapi.wnplatform.d.a.a("curscreen", "curscreen" + this.d);
                    if (this.d < com.baidu.platform.comapi.walknavi.segmentbrowse.c.g()) {
                        d dVar2 = new d(this.b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.e(this.d + 1), -1);
                        dVar2.setTag(Integer.valueOf(this.d + 1));
                        d a3 = a(dVar2, com.baidu.platform.comapi.walknavi.segmentbrowse.c.e());
                        addView(a3);
                        this.f.add(a3);
                    }
                }
            } else {
                if (this.d >= 1) {
                    this.i -= com.baidu.platform.comapi.walknavi.segmentbrowse.c.m();
                    if (getChildCount() == 3) {
                        removeView(this.f.get(2));
                        this.f.remove(2);
                        d dVar3 = new d(this.b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.e(this.d - 1), -1);
                        dVar3.setTag(Integer.valueOf(this.d - 1));
                        d a4 = a(dVar3, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d());
                        addView(a4);
                        this.f.add(0, a4);
                    } else if (getChildCount() == 2) {
                        d dVar4 = new d(this.b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.e(this.d - 1), -1);
                        dVar4.setTag(Integer.valueOf(this.d - 1));
                        d a5 = a(dVar4, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d());
                        addView(a5);
                        this.f.add(0, a5);
                    }
                }
                if (this.d == 0 && getChildCount() == 3) {
                    removeView(this.f.get(2));
                    this.f.remove(2);
                }
            }
        }
        if (z) {
            if (z2) {
                m = this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.m();
                scrollX = getScrollX();
            } else if (this.d == 0) {
                m = this.i;
                scrollX = getScrollX();
            } else {
                m = this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.m();
                scrollX = getScrollX();
            }
            int i3 = m - scrollX;
            com.baidu.platform.comapi.wnplatform.d.a.a("aaa", "dx******************" + i3);
            this.e.startScroll(getScrollX(), 0, i3, 0, Math.abs(i3));
            this.j = false;
        }
        invalidate();
    }

    public void a(a aVar) {
        this.m = aVar;
    }
}
