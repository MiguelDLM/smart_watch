package com.sma.smartv3.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public class ExpandableLayout extends LinearLayout {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f24890IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public ValueAnimator f24891IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public View f24892O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public int f24893Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public I0Io f24894OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public ValueAnimator f24895Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f24896OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public oO f24897XO;

    /* renamed from: o00, reason: collision with root package name */
    public x0XOIxOo f24898o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public AnimatorSet f24899oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public boolean f24900xoXoI;

    /* loaded from: classes12.dex */
    public interface I0Io {
        void oIX0oI(boolean expanded);
    }

    /* loaded from: classes12.dex */
    public class II0xO0 extends AnimatorListenerAdapter {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ int f24902Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ int f24903XO;

        public II0xO0(final int val$endHeight, final int val$startHeight) {
            this.f24903XO = val$endHeight;
            this.f24902Oo = val$startHeight;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            if (this.f24903XO - this.f24902Oo < 0) {
                ExpandableLayout.this.f24893Oo = 0;
                if (ExpandableLayout.this.f24894OxI != null) {
                    ExpandableLayout.this.f24894OxI.oIX0oI(false);
                    return;
                }
                return;
            }
            ExpandableLayout.this.f24893Oo = 1;
            if (ExpandableLayout.this.f24894OxI != null) {
                ExpandableLayout.this.f24894OxI.oIX0oI(true);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class oIX0oI implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ View f24905XO;

        public oIX0oI(final View val$target) {
            this.f24905XO = val$target;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            this.f24905XO.getLayoutParams().height = ((Integer) animation.getAnimatedValue()).intValue();
            this.f24905XO.requestLayout();
        }
    }

    public ExpandableLayout(Context context) {
        super(context);
        this.f24890IIXOooo = true;
        this.f24900xoXoI = true;
        XO(null);
    }

    private int getParentScrollDistance() {
        if (this.f24898o00 == null) {
            return 0;
        }
        int y = (int) (((getY() + getMeasuredHeight()) + this.f24896OxxIIOOXO) - this.f24898o00.f25772oIX0oI.getMeasuredHeight());
        for (int i = 0; i < this.f24898o00.f25771II0xO0; i++) {
            y = (int) (y + ((ViewGroup) getParent()).getY());
        }
        return y;
    }

    public void I0Io() {
        xoIox(this.f24896OxxIIOOXO, 0);
    }

    public final void II0XooXoX() {
        if (this.f24892O0xOxO == null) {
            this.f24892O0xOxO = findViewById(R.id.switcher);
        }
        View view = this.f24892O0xOxO;
        if (view != null) {
            this.f24892O0xOxO.startAnimation(oxoX(view, this.f24897XO.f25479oIX0oI));
        }
    }

    public boolean Oxx0IOOO() {
        if (this.f24893Oo == 1) {
            return true;
        }
        return false;
    }

    public void X0o0xo() {
        xoIox(0, this.f24896OxxIIOOXO);
    }

    public final void XO(AttributeSet attrs) {
        setClickable(true);
        setOrientation(1);
        setClipChildren(false);
        setClipToPadding(false);
        this.f24893Oo = -1;
        this.f24897XO = new oO();
        if (attrs != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, com.sma.smartv3.R.styleable.ExpandableLayout);
            this.f24897XO.f25479oIX0oI = obtainStyledAttributes.getInt(0, 300);
            this.f24897XO.f25478II0xO0 = obtainStyledAttributes.getBoolean(2, false);
            this.f24897XO.f25477I0Io = obtainStyledAttributes.getBoolean(1, true);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f24891IXxxXO;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f24891IXxxXO.cancel();
            this.f24891IXxxXO.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.f24895Oxx0xo;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.f24895Oxx0xo.cancel();
            this.f24895Oxx0xo.removeAllUpdateListeners();
        }
        AnimatorSet animatorSet = this.f24899oI0IIXIo;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getChildCount() == 2) {
            if (this.f24890IIXOooo) {
                ((ViewGroup.MarginLayoutParams) getChildAt(0).getLayoutParams()).bottomMargin = 0;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getChildAt(1).getLayoutParams();
                marginLayoutParams.bottomMargin = 0;
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.height = 0;
                this.f24896OxxIIOOXO = getChildAt(1).getMeasuredHeight();
                this.f24890IIXOooo = false;
                this.f24893Oo = 0;
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                return;
            }
            return;
        }
        throw new IllegalStateException("ExpandableLayout must has two child view !");
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (this.f24897XO.f25478II0xO0) {
            this.f24898o00 = oI0IIXIo.II0xO0(this);
        }
    }

    public final RotateAnimation oxoX(final View view, int duration) {
        float f;
        int width = view.getWidth() >> 1;
        int height = view.getHeight() >> 1;
        int i = this.f24893Oo;
        float f2 = -180.0f;
        if (i == 2) {
            f = 0.0f;
        } else {
            f = -180.0f;
        }
        if (i != 2) {
            f2 = 0.0f;
        }
        RotateAnimation rotateAnimation = new RotateAnimation(f, f2, width, height);
        rotateAnimation.setDuration(duration);
        rotateAnimation.setFillAfter(true);
        return rotateAnimation;
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.f24900xoXoI) {
            xxIXOIIO();
        }
        return super.performClick();
    }

    public void setExpand(boolean z) {
        int i;
        if (this.f24893Oo == -1) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getChildAt(1).getLayoutParams();
        if (z) {
            i = this.f24896OxxIIOOXO;
        } else {
            i = 0;
        }
        layoutParams.height = i;
        requestLayout();
        this.f24893Oo = z ? 1 : 0;
    }

    public void setExpandDuration(int expandDuration) {
        this.f24897XO.f25479oIX0oI = expandDuration;
    }

    public void setExpandEnable(boolean isExpandEnable) {
        this.f24900xoXoI = isExpandEnable;
    }

    public void setExpandScrollTogether(boolean expandScrollTogether) {
        this.f24897XO.f25477I0Io = expandScrollTogether;
    }

    public void setExpandWithParentScroll(boolean expandWithParentScroll) {
        this.f24897XO.f25478II0xO0 = expandWithParentScroll;
    }

    public void setOnExpandListener(I0Io onExpandListener) {
        this.f24894OxI = onExpandListener;
    }

    public void setSwitcher(View switcher) {
        this.f24892O0xOxO = switcher;
    }

    public final void xoIox(final int startHeight, final int endHeight) {
        int i;
        int parentScrollDistance = getParentScrollDistance();
        View childAt = getChildAt(1);
        ValueAnimator ofInt = ValueAnimator.ofInt(startHeight, endHeight);
        this.f24891IXxxXO = ofInt;
        ofInt.addUpdateListener(new oIX0oI(childAt));
        this.f24891IXxxXO.addListener(new II0xO0(endHeight, startHeight));
        if (this.f24893Oo == 1) {
            i = 3;
        } else {
            i = 2;
        }
        this.f24893Oo = i;
        this.f24891IXxxXO.setDuration(this.f24897XO.f25479oIX0oI);
        if (this.f24893Oo == 2) {
            if (this.f24897XO.f25478II0xO0 && parentScrollDistance > 0) {
                this.f24895Oxx0xo = oI0IIXIo.oIX0oI(this.f24898o00.f25772oIX0oI, parentScrollDistance, r7.f25479oIX0oI);
                AnimatorSet animatorSet = new AnimatorSet();
                this.f24899oI0IIXIo = animatorSet;
                if (this.f24897XO.f25477I0Io) {
                    animatorSet.playTogether(this.f24891IXxxXO, this.f24895Oxx0xo);
                } else {
                    animatorSet.playSequentially(this.f24891IXxxXO, this.f24895Oxx0xo);
                }
                this.f24899oI0IIXIo.start();
                return;
            }
        }
        this.f24891IXxxXO.start();
    }

    public void xxIXOIIO() {
        int i = this.f24893Oo;
        if (i == 1) {
            I0Io();
        } else if (i == 0) {
            X0o0xo();
        }
        II0XooXoX();
    }

    public ExpandableLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f24890IIXOooo = true;
        this.f24900xoXoI = true;
        XO(attrs);
    }

    public ExpandableLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f24890IIXOooo = true;
        this.f24900xoXoI = true;
    }
}
