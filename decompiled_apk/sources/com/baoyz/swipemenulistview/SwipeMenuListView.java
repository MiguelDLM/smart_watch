package com.baoyz.swipemenulistview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ListAdapter;
import android.widget.ListView;

/* loaded from: classes8.dex */
public class SwipeMenuListView extends ListView {

    /* renamed from: IIX0o, reason: collision with root package name */
    public static final int f10261IIX0o = 1;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final int f10262XxX0x0xxx = 1;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public static final int f10263ooXIXxIX = -1;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final int f10264xXxxox0I = 2;

    /* renamed from: xxX, reason: collision with root package name */
    public static final int f10265xxX = 0;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f10266IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f10267IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public II0xO0 f10268O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public int f10269Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public IIX0o.I0Io f10270OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public float f10271Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f10272OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public I0Io f10273X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public Interpolator f10274XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public Interpolator f10275XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public int f10276XO;

    /* renamed from: o00, reason: collision with root package name */
    public oxoX f10277o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public float f10278oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public SwipeMenuLayout f10279xoXoI;

    /* loaded from: classes8.dex */
    public interface I0Io {
        void II0xO0(int i);

        void oIX0oI(int i);
    }

    /* loaded from: classes8.dex */
    public interface II0xO0 {
        boolean oIX0oI(int i, IIX0o.II0xO0 iI0xO0, int i2);
    }

    /* loaded from: classes8.dex */
    public class oIX0oI extends com.baoyz.swipemenulistview.oIX0oI {
        public oIX0oI(Context context, ListAdapter listAdapter) {
            super(context, listAdapter);
        }

        @Override // com.baoyz.swipemenulistview.oIX0oI
        public void II0xO0(IIX0o.II0xO0 iI0xO0) {
            if (SwipeMenuListView.this.f10270OxI != null) {
                SwipeMenuListView.this.f10270OxI.oIX0oI(iI0xO0);
            }
        }

        @Override // com.baoyz.swipemenulistview.oIX0oI, com.baoyz.swipemenulistview.SwipeMenuView.oIX0oI
        public void oIX0oI(SwipeMenuView swipeMenuView, IIX0o.II0xO0 iI0xO0, int i) {
            boolean z;
            if (SwipeMenuListView.this.f10268O0xOxO != null) {
                z = SwipeMenuListView.this.f10268O0xOxO.oIX0oI(swipeMenuView.getPosition(), iI0xO0, i);
            } else {
                z = false;
            }
            if (SwipeMenuListView.this.f10279xoXoI != null && !z) {
                SwipeMenuListView.this.f10279xoXoI.xoIox();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface oxoX {
        void II0xO0(int i);

        void oIX0oI(int i);
    }

    public SwipeMenuListView(Context context) {
        super(context);
        this.f10276XO = 1;
        this.f10269Oo = 5;
        this.f10267IXxxXO = 3;
        X0o0xo();
    }

    public void Oxx0IOOO(int i) {
        if (i >= getFirstVisiblePosition() && i <= getLastVisiblePosition()) {
            View childAt = getChildAt(i - getFirstVisiblePosition());
            if (childAt instanceof SwipeMenuLayout) {
                this.f10266IIXOooo = i;
                SwipeMenuLayout swipeMenuLayout = this.f10279xoXoI;
                if (swipeMenuLayout != null && swipeMenuLayout.Oxx0IOOO()) {
                    this.f10279xoXoI.xoIox();
                }
                SwipeMenuLayout swipeMenuLayout2 = (SwipeMenuLayout) childAt;
                this.f10279xoXoI = swipeMenuLayout2;
                swipeMenuLayout2.setSwipeDirection(this.f10276XO);
                this.f10279xoXoI.OOXIXo();
            }
        }
    }

    public final void X0o0xo() {
        this.f10267IXxxXO = oxoX(this.f10267IXxxXO);
        this.f10269Oo = oxoX(this.f10269Oo);
        this.f10272OxxIIOOXO = 0;
    }

    public void XO() {
        SwipeMenuLayout swipeMenuLayout = this.f10279xoXoI;
        if (swipeMenuLayout != null && swipeMenuLayout.Oxx0IOOO()) {
            this.f10279xoXoI.xoIox();
        }
    }

    public Interpolator getCloseInterpolator() {
        return this.f10274XI0IXoo;
    }

    public Interpolator getOpenInterpolator() {
        return this.f10275XIxXXX0x0;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        SwipeMenuLayout swipeMenuLayout;
        I0Io i0Io;
        if (motionEvent.getAction() != 0 && this.f10279xoXoI == null) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float abs = Math.abs(motionEvent.getY() - this.f10278oI0IIXIo);
                    float abs2 = Math.abs(motionEvent.getX() - this.f10271Oxx0xo);
                    int i = this.f10272OxxIIOOXO;
                    if (i == 1) {
                        SwipeMenuLayout swipeMenuLayout2 = this.f10279xoXoI;
                        if (swipeMenuLayout2 != null) {
                            swipeMenuLayout2.II0XooXoX(motionEvent);
                        }
                        getSelector().setState(new int[]{0});
                        motionEvent.setAction(3);
                        super.onTouchEvent(motionEvent);
                        return true;
                    }
                    if (i == 0) {
                        if (Math.abs(abs) > this.f10269Oo) {
                            this.f10272OxxIIOOXO = 2;
                        } else if (abs2 > this.f10267IXxxXO) {
                            this.f10272OxxIIOOXO = 1;
                            oxoX oxox = this.f10277o00;
                            if (oxox != null) {
                                oxox.oIX0oI(this.f10266IIXOooo);
                            }
                        }
                    }
                }
            } else if (this.f10272OxxIIOOXO == 1) {
                SwipeMenuLayout swipeMenuLayout3 = this.f10279xoXoI;
                if (swipeMenuLayout3 != null) {
                    boolean Oxx0IOOO2 = swipeMenuLayout3.Oxx0IOOO();
                    this.f10279xoXoI.II0XooXoX(motionEvent);
                    boolean Oxx0IOOO3 = this.f10279xoXoI.Oxx0IOOO();
                    if (Oxx0IOOO2 != Oxx0IOOO3 && (i0Io = this.f10273X0IIOO) != null) {
                        if (Oxx0IOOO3) {
                            i0Io.II0xO0(this.f10266IIXOooo);
                        } else {
                            i0Io.oIX0oI(this.f10266IIXOooo);
                        }
                    }
                    if (!Oxx0IOOO3) {
                        this.f10266IIXOooo = -1;
                        this.f10279xoXoI = null;
                    }
                }
                oxoX oxox2 = this.f10277o00;
                if (oxox2 != null) {
                    oxox2.II0xO0(this.f10266IIXOooo);
                }
                motionEvent.setAction(3);
                super.onTouchEvent(motionEvent);
                return true;
            }
        } else {
            int i2 = this.f10266IIXOooo;
            this.f10271Oxx0xo = motionEvent.getX();
            this.f10278oI0IIXIo = motionEvent.getY();
            this.f10272OxxIIOOXO = 0;
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            this.f10266IIXOooo = pointToPosition;
            if (pointToPosition == i2 && (swipeMenuLayout = this.f10279xoXoI) != null && swipeMenuLayout.Oxx0IOOO()) {
                this.f10272OxxIIOOXO = 1;
                this.f10279xoXoI.II0XooXoX(motionEvent);
                return true;
            }
            View childAt = getChildAt(this.f10266IIXOooo - getFirstVisiblePosition());
            SwipeMenuLayout swipeMenuLayout4 = this.f10279xoXoI;
            if (swipeMenuLayout4 != null && swipeMenuLayout4.Oxx0IOOO()) {
                this.f10279xoXoI.xoIox();
                this.f10279xoXoI = null;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                onTouchEvent(obtain);
                I0Io i0Io2 = this.f10273X0IIOO;
                if (i0Io2 != null) {
                    i0Io2.oIX0oI(i2);
                }
                return true;
            }
            if (childAt instanceof SwipeMenuLayout) {
                SwipeMenuLayout swipeMenuLayout5 = (SwipeMenuLayout) childAt;
                this.f10279xoXoI = swipeMenuLayout5;
                swipeMenuLayout5.setSwipeDirection(this.f10276XO);
            }
            SwipeMenuLayout swipeMenuLayout6 = this.f10279xoXoI;
            if (swipeMenuLayout6 != null) {
                swipeMenuLayout6.II0XooXoX(motionEvent);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final int oxoX(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
    }

    public void setCloseInterpolator(Interpolator interpolator) {
        this.f10274XI0IXoo = interpolator;
    }

    public void setMenuCreator(IIX0o.I0Io i0Io) {
        this.f10270OxI = i0Io;
    }

    public void setOnMenuItemClickListener(II0xO0 iI0xO0) {
        this.f10268O0xOxO = iI0xO0;
    }

    public void setOnMenuStateChangeListener(I0Io i0Io) {
        this.f10273X0IIOO = i0Io;
    }

    public void setOnSwipeListener(oxoX oxox) {
        this.f10277o00 = oxox;
    }

    public void setOpenInterpolator(Interpolator interpolator) {
        this.f10275XIxXXX0x0 = interpolator;
    }

    public void setSwipeDirection(int i) {
        this.f10276XO = i;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) new oIX0oI(getContext(), listAdapter));
    }

    public SwipeMenuListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10276XO = 1;
        this.f10269Oo = 5;
        this.f10267IXxxXO = 3;
        X0o0xo();
    }

    public SwipeMenuListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10276XO = 1;
        this.f10269Oo = 5;
        this.f10267IXxxXO = 3;
        X0o0xo();
    }
}
