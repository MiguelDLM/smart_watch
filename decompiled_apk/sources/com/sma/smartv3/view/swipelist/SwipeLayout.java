package com.sma.smartv3.view.swipelist;

import XIXIX.OOXIXo;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import com.blankj.utilcode.util.SizeUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.swipelist.SwipeLayout;

/* loaded from: classes12.dex */
public class SwipeLayout extends LinearLayout {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f25758IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f25759IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public VelocityTracker f25760O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public View f25761Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public II0xO0 f25762OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f25763Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public double f25764OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public View f25765XO;

    /* renamed from: o00, reason: collision with root package name */
    public ObjectAnimator f25766o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f25767oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f25768xoXoI;

    /* loaded from: classes12.dex */
    public interface II0xO0 {
        void onClick();

        void onDelete();
    }

    /* loaded from: classes12.dex */
    public class oIX0oI implements ValueAnimator.AnimatorUpdateListener {
        public oIX0oI() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            SwipeLayout.this.f25759IXxxXO = (int) ((Float) animation.getAnimatedValue()).floatValue();
            SwipeLayout.this.f25765XO.setTranslationX((SwipeLayout.this.f25759IXxxXO * 3.0f) / 4.0f);
        }
    }

    public SwipeLayout(Context context) {
        this(context, null);
    }

    public void X0o0xo(boolean isClose) {
        float f;
        View view = this.f25761Oo;
        float translationX = view.getTranslationX();
        if (isClose) {
            f = 0.0f;
        } else {
            f = this.f25763Oxx0xo;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationX", translationX, f).setDuration(100L);
        this.f25766o00 = duration;
        duration.addUpdateListener(new oIX0oI());
        this.f25766o00.start();
    }

    public final /* synthetic */ void XO(View view) {
        II0xO0 iI0xO0 = this.f25762OxI;
        if (iI0xO0 == null) {
            return;
        }
        iI0xO0.onDelete();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f25760O0xOxO = VelocityTracker.obtain();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f25760O0xOxO.recycle();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() == 1) {
            this.f25765XO = getChildAt(0);
            View inflate = View.inflate(getContext(), R.layout.layout_swipe_delete, null);
            this.f25761Oo = inflate;
            inflate.setOnClickListener(new View.OnClickListener() { // from class: X00xOoXI.oIX0oI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SwipeLayout.this.XO(view);
                }
            });
            addView(this.f25761Oo, new LinearLayout.LayoutParams(SizeUtils.dp2px(72.0f), -1));
            return;
        }
        throw new IllegalStateException("SwipeDeleteLayout must host only one direct child");
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.f25763Oxx0xo = -this.f25761Oo.getMeasuredWidth();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        this.f25760O0xOxO.addMovement(event);
        int action = event.getAction();
        boolean z = false;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3 && this.f25759IXxxXO != 0) {
                        X0o0xo(true);
                    }
                } else {
                    this.f25764OxxIIOOXO += Math.abs(x - this.f25767oI0IIXIo);
                    this.f25760O0xOxO.computeCurrentVelocity(1000);
                    float xVelocity = this.f25760O0xOxO.getXVelocity();
                    float yVelocity = this.f25760O0xOxO.getYVelocity();
                    int i = this.f25759IXxxXO + (x - this.f25767oI0IIXIo);
                    this.f25759IXxxXO = i;
                    int i2 = this.f25763Oxx0xo;
                    if (i < i2) {
                        this.f25759IXxxXO = i2;
                    }
                    if (this.f25759IXxxXO > 0) {
                        this.f25759IXxxXO = 0;
                    }
                    if (this.f25764OxxIIOOXO >= this.f25758IIXOooo || (Math.abs(xVelocity) > this.f25768xoXoI && Math.abs(xVelocity) > Math.abs(yVelocity) * 2.0f)) {
                        this.f25761Oo.setTranslationX(this.f25759IXxxXO);
                        this.f25765XO.setTranslationX((this.f25759IXxxXO * 3.0f) / 4.0f);
                        requestDisallowInterceptTouchEvent(true);
                    }
                }
            } else if (this.f25764OxxIIOOXO < this.f25758IIXOooo) {
                if (this.f25759IXxxXO == this.f25763Oxx0xo) {
                    X0o0xo(true);
                } else {
                    II0xO0 iI0xO0 = this.f25762OxI;
                    if (iI0xO0 != null) {
                        iI0xO0.onClick();
                        X0o0xo(true);
                    }
                }
            } else {
                int i3 = this.f25759IXxxXO;
                if (i3 != this.f25763Oxx0xo && i3 != 0) {
                    this.f25760O0xOxO.computeCurrentVelocity(1000);
                    float xVelocity2 = this.f25760O0xOxO.getXVelocity();
                    if (xVelocity2 > this.f25768xoXoI || (xVelocity2 >= (-r3) && this.f25759IXxxXO > this.f25763Oxx0xo / 2)) {
                        z = true;
                    }
                    X0o0xo(z);
                }
            }
        } else {
            this.f25764OxxIIOOXO = OOXIXo.f3760XO;
            ObjectAnimator objectAnimator = this.f25766o00;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            requestDisallowInterceptTouchEvent(false);
        }
        this.f25767oI0IIXIo = x;
        return true;
    }

    public void setSwipeListener(II0xO0 listener) {
        this.f25762OxI = listener;
    }

    public SwipeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwipeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f25758IIXOooo = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f25768xoXoI = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
    }
}
