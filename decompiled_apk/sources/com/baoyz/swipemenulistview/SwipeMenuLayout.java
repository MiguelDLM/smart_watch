package com.baoyz.swipemenulistview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.widget.ScrollerCompat;

/* loaded from: classes8.dex */
public class SwipeMenuLayout extends FrameLayout {

    /* renamed from: IIX0o, reason: collision with root package name */
    public static final int f10240IIX0o = 2;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public static final int f10241ooXIXxIX = 0;

    /* renamed from: xI, reason: collision with root package name */
    public static final int f10242xI = 1;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final int f10243xXxxox0I = 1;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public GestureDetector.OnGestureListener f10244IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public SwipeMenuView f10245IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public ScrollerCompat f10246O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public View f10247Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public int f10248OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f10249Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public GestureDetectorCompat f10250OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public ScrollerCompat f10251X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f10252XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public int f10253XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public int f10254XO;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public Interpolator f10255XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public int f10256o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f10257oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public boolean f10258xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public Interpolator f10259xxX;

    /* loaded from: classes8.dex */
    public class oIX0oI extends GestureDetector.SimpleOnGestureListener {
        public oIX0oI() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            SwipeMenuLayout.this.f10258xoXoI = false;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > SwipeMenuLayout.this.f10256o00 && f < SwipeMenuLayout.this.f10248OxI) {
                SwipeMenuLayout.this.f10258xoXoI = true;
            }
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    public SwipeMenuLayout(View view, SwipeMenuView swipeMenuView) {
        this(view, swipeMenuView, null, null);
    }

    public boolean II0XooXoX(MotionEvent motionEvent) {
        this.f10250OxxIIOOXO.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int x = (int) (this.f10249Oxx0xo - motionEvent.getX());
                    if (this.f10257oI0IIXIo == 1) {
                        x += this.f10245IXxxXO.getWidth() * this.f10254XO;
                    }
                    oOoXoXO(x);
                }
            } else if ((this.f10258xoXoI || Math.abs(this.f10249Oxx0xo - motionEvent.getX()) > this.f10245IXxxXO.getWidth() / 2) && Math.signum(this.f10249Oxx0xo - motionEvent.getX()) == this.f10254XO) {
                OOXIXo();
            } else {
                xoIox();
                return false;
            }
        } else {
            this.f10249Oxx0xo = (int) motionEvent.getX();
            this.f10258xoXoI = false;
        }
        return true;
    }

    public void OOXIXo() {
        this.f10257oI0IIXIo = 1;
        if (this.f10254XO == 1) {
            this.f10246O0xOxO.startScroll(-this.f10247Oo.getLeft(), 0, this.f10245IXxxXO.getWidth(), 0, 350);
        } else {
            this.f10246O0xOxO.startScroll(this.f10247Oo.getLeft(), 0, this.f10245IXxxXO.getWidth(), 0, 350);
        }
        postInvalidate();
    }

    public boolean Oxx0IOOO() {
        if (this.f10257oI0IIXIo == 1) {
            return true;
        }
        return false;
    }

    public final int X0o0xo(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
    }

    public final void XO() {
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        this.f10244IIXOooo = new oIX0oI();
        this.f10250OxxIIOOXO = new GestureDetectorCompat(getContext(), this.f10244IIXOooo);
        if (this.f10259xxX != null) {
            this.f10251X0IIOO = ScrollerCompat.create(getContext(), this.f10259xxX);
        } else {
            this.f10251X0IIOO = ScrollerCompat.create(getContext());
        }
        if (this.f10255XxX0x0xxx != null) {
            this.f10246O0xOxO = ScrollerCompat.create(getContext(), this.f10255XxX0x0xxx);
        } else {
            this.f10246O0xOxO = ScrollerCompat.create(getContext());
        }
        this.f10247Oo.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        if (this.f10247Oo.getId() < 1) {
            this.f10247Oo.setId(1);
        }
        this.f10245IXxxXO.setId(2);
        this.f10245IXxxXO.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        addView(this.f10247Oo);
        addView(this.f10245IXxxXO);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f10257oI0IIXIo == 1) {
            if (this.f10246O0xOxO.computeScrollOffset()) {
                oOoXoXO(this.f10246O0xOxO.getCurrX() * this.f10254XO);
                postInvalidate();
                return;
            }
            return;
        }
        if (this.f10251X0IIOO.computeScrollOffset()) {
            oOoXoXO((this.f10252XI0IXoo - this.f10251X0IIOO.getCurrX()) * this.f10254XO);
            postInvalidate();
        }
    }

    public View getContentView() {
        return this.f10247Oo;
    }

    public SwipeMenuView getMenuView() {
        return this.f10245IXxxXO;
    }

    public int getPosition() {
        return this.f10253XIxXXX0x0;
    }

    public final void oOoXoXO(int i) {
        if (Math.signum(i) != this.f10254XO) {
            i = 0;
        } else if (Math.abs(i) > this.f10245IXxxXO.getWidth()) {
            i = this.f10245IXxxXO.getWidth() * this.f10254XO;
        }
        View view = this.f10247Oo;
        int i2 = -i;
        view.layout(i2, view.getTop(), this.f10247Oo.getWidth() - i, getMeasuredHeight());
        if (this.f10254XO == 1) {
            this.f10245IXxxXO.layout(this.f10247Oo.getWidth() - i, this.f10245IXxxXO.getTop(), (this.f10247Oo.getWidth() + this.f10245IXxxXO.getWidth()) - i, this.f10245IXxxXO.getBottom());
        } else {
            SwipeMenuView swipeMenuView = this.f10245IXxxXO;
            swipeMenuView.layout((-swipeMenuView.getWidth()) - i, this.f10245IXxxXO.getTop(), i2, this.f10245IXxxXO.getBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f10247Oo.layout(0, 0, getMeasuredWidth(), this.f10247Oo.getMeasuredHeight());
        if (this.f10254XO == 1) {
            this.f10245IXxxXO.layout(getMeasuredWidth(), 0, getMeasuredWidth() + this.f10245IXxxXO.getMeasuredWidth(), this.f10247Oo.getMeasuredHeight());
        } else {
            SwipeMenuView swipeMenuView = this.f10245IXxxXO;
            swipeMenuView.layout(-swipeMenuView.getMeasuredWidth(), 0, 0, this.f10247Oo.getMeasuredHeight());
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f10245IXxxXO.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void oxoX() {
        if (this.f10251X0IIOO.computeScrollOffset()) {
            this.f10251X0IIOO.abortAnimation();
        }
        if (this.f10257oI0IIXIo == 1) {
            this.f10257oI0IIXIo = 0;
            oOoXoXO(0);
        }
    }

    public void setMenuHeight(int i) {
        Log.i("byz", "pos = " + this.f10253XIxXXX0x0 + ", height = " + i);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f10245IXxxXO.getLayoutParams();
        if (layoutParams.height != i) {
            layoutParams.height = i;
            SwipeMenuView swipeMenuView = this.f10245IXxxXO;
            swipeMenuView.setLayoutParams(swipeMenuView.getLayoutParams());
        }
    }

    public void setPosition(int i) {
        this.f10253XIxXXX0x0 = i;
        this.f10245IXxxXO.setPosition(i);
    }

    public void setSwipeDirection(int i) {
        this.f10254XO = i;
    }

    public void xoIox() {
        this.f10257oI0IIXIo = 0;
        if (this.f10254XO == 1) {
            this.f10252XI0IXoo = -this.f10247Oo.getLeft();
            this.f10251X0IIOO.startScroll(0, 0, this.f10245IXxxXO.getWidth(), 0, 350);
        } else {
            this.f10252XI0IXoo = this.f10245IXxxXO.getRight();
            this.f10251X0IIOO.startScroll(0, 0, this.f10245IXxxXO.getWidth(), 0, 350);
        }
        postInvalidate();
    }

    public void xxIXOIIO() {
        if (this.f10257oI0IIXIo == 0) {
            this.f10257oI0IIXIo = 1;
            oOoXoXO(this.f10245IXxxXO.getWidth() * this.f10254XO);
        }
    }

    public SwipeMenuLayout(View view, SwipeMenuView swipeMenuView, Interpolator interpolator, Interpolator interpolator2) {
        super(view.getContext());
        this.f10257oI0IIXIo = 0;
        this.f10256o00 = X0o0xo(15);
        this.f10248OxI = -X0o0xo(500);
        this.f10259xxX = interpolator;
        this.f10255XxX0x0xxx = interpolator2;
        this.f10247Oo = view;
        this.f10245IXxxXO = swipeMenuView;
        swipeMenuView.setLayout(this);
        XO();
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10257oI0IIXIo = 0;
        this.f10256o00 = X0o0xo(15);
        this.f10248OxI = -X0o0xo(500);
    }

    public SwipeMenuLayout(Context context) {
        super(context);
        this.f10257oI0IIXIo = 0;
        this.f10256o00 = X0o0xo(15);
        this.f10248OxI = -X0o0xo(500);
    }
}
