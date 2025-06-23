package com.l4digital.fastscroll;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* loaded from: classes11.dex */
public class FastScroller extends LinearLayout {

    /* renamed from: IO, reason: collision with root package name */
    public static final int f18478IO = 5;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public static final int f18479X00IoxXI = 1000;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public static final int f18480Xx000oIo = 300;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public static final int f18481oOXoIIIo = 100;

    /* renamed from: IIX0o, reason: collision with root package name */
    public ViewPropertyAnimator f18482IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f18483IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f18484IXxxXO;

    /* renamed from: IoOoX, reason: collision with root package name */
    public final RecyclerView.OnScrollListener f18485IoOoX;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public ImageView f18486O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    @ColorInt
    public int f18487Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public Drawable f18488OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f18489Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f18490OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public ImageView f18491X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public RecyclerView f18492XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public Size f18493XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    @ColorInt
    public int f18494XO;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public TextView f18495XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public Drawable f18496o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f18497oI0IIXIo;

    /* renamed from: oo, reason: collision with root package name */
    public final Runnable f18498oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public xxIXOIIO f18499oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public ViewPropertyAnimator f18500ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public II0XooXoX f18501xI;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public View f18502xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    public Drawable f18503xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public SwipeRefreshLayout f18504xxX;

    /* loaded from: classes11.dex */
    public class I0Io implements Runnable {
        public I0Io() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FastScroller fastScroller = FastScroller.this;
            fastScroller.setViewPositions(fastScroller.IIXOooo(fastScroller.f18492XI0IXoo));
        }
    }

    /* loaded from: classes11.dex */
    public interface II0XooXoX {
        void II0xO0(FastScroller fastScroller);

        void oIX0oI(FastScroller fastScroller);
    }

    /* loaded from: classes11.dex */
    public class II0xO0 extends RecyclerView.OnScrollListener {
        public II0xO0() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (FastScroller.this.isEnabled()) {
                if (i != 0) {
                    if (i == 1) {
                        FastScroller.this.getHandler().removeCallbacks(FastScroller.this.f18498oo);
                        FastScroller fastScroller = FastScroller.this;
                        fastScroller.Oxx0xo(fastScroller.f18482IIX0o);
                        FastScroller fastScroller2 = FastScroller.this;
                        if (!fastScroller2.X0IIOO(fastScroller2.f18502xXxxox0I)) {
                            FastScroller.this.xXxxox0I();
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (FastScroller.this.f18490OxxIIOOXO && !FastScroller.this.f18486O0xOxO.isSelected()) {
                    FastScroller.this.getHandler().postDelayed(FastScroller.this.f18498oo, 1000L);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int top;
            if (!FastScroller.this.f18486O0xOxO.isSelected() && FastScroller.this.isEnabled()) {
                FastScroller fastScroller = FastScroller.this;
                fastScroller.setViewPositions(fastScroller.IIXOooo(recyclerView));
            }
            if (FastScroller.this.f18504xxX != null) {
                int OxxIIOOXO2 = FastScroller.this.OxxIIOOXO(recyclerView.getLayoutManager());
                boolean z = false;
                if (recyclerView.getChildCount() == 0) {
                    top = 0;
                } else {
                    top = recyclerView.getChildAt(0).getTop();
                }
                SwipeRefreshLayout swipeRefreshLayout = FastScroller.this.f18504xxX;
                if (OxxIIOOXO2 == 0 && top >= 0) {
                    z = true;
                }
                swipeRefreshLayout.setEnabled(z);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class Oxx0IOOO extends AnimatorListenerAdapter {
        public Oxx0IOOO() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            FastScroller.this.f18502xXxxox0I.setVisibility(8);
            FastScroller.this.f18482IIX0o = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            FastScroller.this.f18502xXxxox0I.setVisibility(8);
            FastScroller.this.f18482IIX0o = null;
        }
    }

    /* loaded from: classes11.dex */
    public enum Size {
        NORMAL(R.drawable.fastscroll_bubble, R.dimen.fastscroll_bubble_text_size),
        SMALL(R.drawable.fastscroll_bubble_small, R.dimen.fastscroll_bubble_text_size_small);


        @DrawableRes
        public int drawableId;

        @DimenRes
        public int textSizeId;

        Size(@DrawableRes int i, @DimenRes int i2) {
            this.drawableId = i;
            this.textSizeId = i2;
        }

        public static Size fromOrdinal(int i) {
            if (i >= 0 && i < values().length) {
                return values()[i];
            }
            return NORMAL;
        }
    }

    /* loaded from: classes11.dex */
    public class X0o0xo extends AnimatorListenerAdapter {
        public X0o0xo() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            FastScroller.this.f18495XxX0x0xxx.setVisibility(8);
            FastScroller.this.f18500ooXIXxIX = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            FastScroller.this.f18495XxX0x0xxx.setVisibility(8);
            FastScroller.this.f18500ooXIXxIX = null;
        }
    }

    /* loaded from: classes11.dex */
    public class XO extends AnimatorListenerAdapter {
        public XO() {
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements Runnable {
        public oIX0oI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FastScroller.this.OxI();
        }
    }

    /* loaded from: classes11.dex */
    public class oxoX extends AnimatorListenerAdapter {
        public oxoX() {
        }
    }

    /* loaded from: classes11.dex */
    public interface xxIXOIIO {
        CharSequence getSectionText(int i);
    }

    public FastScroller(@NonNull Context context) {
        this(context, Size.NORMAL);
    }

    private void setHandleSelected(boolean z) {
        int i;
        this.f18486O0xOxO.setSelected(z);
        Drawable drawable = this.f18496o00;
        if (z) {
            i = this.f18494XO;
        } else {
            i = this.f18487Oo;
        }
        DrawableCompat.setTint(drawable, i);
    }

    private void setRecyclerViewPosition(float f) {
        xxIXOIIO xxixoiio;
        RecyclerView recyclerView = this.f18492XI0IXoo;
        if (recyclerView != null && recyclerView.getAdapter() != null) {
            int itemCount = this.f18492XI0IXoo.getAdapter().getItemCount();
            float f2 = 0.0f;
            if (this.f18486O0xOxO.getY() != 0.0f) {
                float y = this.f18486O0xOxO.getY() + this.f18489Oxx0xo;
                int i = this.f18497oI0IIXIo;
                if (y >= i - 5) {
                    f2 = 1.0f;
                } else {
                    f2 = f / i;
                }
            }
            int round = Math.round(f2 * itemCount);
            if (O0xOxO(this.f18492XI0IXoo.getLayoutManager())) {
                round = itemCount - round;
            }
            int xoXoI2 = xoXoI(0, itemCount - 1, round);
            this.f18492XI0IXoo.getLayoutManager().scrollToPosition(xoXoI2);
            if (this.f18483IIXOooo && (xxixoiio = this.f18499oo0xXOI0I) != null) {
                this.f18495XxX0x0xxx.setText(xxixoiio.getSectionText(xoXoI2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewPositions(float f) {
        this.f18484IXxxXO = this.f18495XxX0x0xxx.getMeasuredHeight();
        int measuredHeight = this.f18486O0xOxO.getMeasuredHeight();
        this.f18489Oxx0xo = measuredHeight;
        int i = this.f18497oI0IIXIo;
        int i2 = this.f18484IXxxXO;
        int xoXoI2 = xoXoI(0, (i - i2) - (measuredHeight / 2), (int) (f - i2));
        int xoXoI3 = xoXoI(0, this.f18497oI0IIXIo - this.f18489Oxx0xo, (int) (f - (r3 / 2)));
        if (this.f18483IIXOooo) {
            this.f18495XxX0x0xxx.setY(xoXoI2);
        }
        this.f18486O0xOxO.setY(xoXoI3);
    }

    public final void IIX0o() {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f18495XxX0x0xxx.measure(makeMeasureSpec, makeMeasureSpec);
        this.f18484IXxxXO = this.f18495XxX0x0xxx.getMeasuredHeight();
        this.f18486O0xOxO.measure(makeMeasureSpec, makeMeasureSpec);
        this.f18489Oxx0xo = this.f18486O0xOxO.getMeasuredHeight();
    }

    public final float IIXOooo(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return 0.0f;
        }
        int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        int computeVerticalScrollRange = recyclerView.computeVerticalScrollRange();
        int i = this.f18497oI0IIXIo;
        float f = computeVerticalScrollRange - i;
        float f2 = computeVerticalScrollOffset;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return i * (f2 / f);
    }

    public void IXxxXO(@NonNull RecyclerView recyclerView) {
        this.f18492XI0IXoo = recyclerView;
        if (getParent() instanceof ViewGroup) {
            setLayoutParams((ViewGroup) getParent());
        } else if (recyclerView.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) recyclerView.getParent();
            viewGroup.addView(this);
            setLayoutParams(viewGroup);
        }
        recyclerView.addOnScrollListener(this.f18485IoOoX);
        post(new I0Io());
    }

    public final boolean O0xOxO(@NonNull RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).getReverseLayout();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getReverseLayout();
        }
        return false;
    }

    public final void OxI() {
        this.f18482IIX0o = this.f18502xXxxox0I.animate().translationX(getResources().getDimensionPixelSize(R.dimen.fastscroll_scrollbar_padding_end)).alpha(0.0f).setDuration(300L).setListener(new Oxx0IOOO());
    }

    public final void Oxx0xo(ViewPropertyAnimator viewPropertyAnimator) {
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final int OxxIIOOXO(@NonNull RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
            return 0;
        }
        return ((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(null)[0];
    }

    public final boolean X0IIOO(View view) {
        if (view != null && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final void XI0IXoo(Context context, AttributeSet attributeSet) {
        XIxXXX0x0(context, attributeSet, Size.NORMAL);
    }

    public final void XIxXXX0x0(Context context, AttributeSet attributeSet, Size size) {
        float f;
        boolean z;
        boolean z2;
        TypedArray obtainStyledAttributes;
        View.inflate(context, R.layout.fast_scroller, this);
        setClipChildren(false);
        setOrientation(0);
        this.f18495XxX0x0xxx = (TextView) findViewById(R.id.fastscroll_bubble);
        this.f18486O0xOxO = (ImageView) findViewById(R.id.fastscroll_handle);
        this.f18491X0IIOO = (ImageView) findViewById(R.id.fastscroll_track);
        this.f18502xXxxox0I = findViewById(R.id.fastscroll_scrollbar);
        this.f18493XIxXXX0x0 = size;
        float dimension = getResources().getDimension(size.textSizeId);
        int i = -7829368;
        int i2 = -12303292;
        int i3 = -3355444;
        int i4 = -1;
        boolean z3 = true;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FastScroller, 0, 0)) != null) {
            try {
                i = obtainStyledAttributes.getColor(R.styleable.FastScroller_bubbleColor, -7829368);
                i2 = obtainStyledAttributes.getColor(R.styleable.FastScroller_handleColor, -12303292);
                i3 = obtainStyledAttributes.getColor(R.styleable.FastScroller_trackColor, -3355444);
                i4 = obtainStyledAttributes.getColor(R.styleable.FastScroller_bubbleTextColor, -1);
                boolean z4 = obtainStyledAttributes.getBoolean(R.styleable.FastScroller_hideScrollbar, true);
                boolean z5 = obtainStyledAttributes.getBoolean(R.styleable.FastScroller_showBubble, true);
                z2 = obtainStyledAttributes.getBoolean(R.styleable.FastScroller_showTrack, false);
                this.f18493XIxXXX0x0 = Size.fromOrdinal(obtainStyledAttributes.getInt(R.styleable.FastScroller_bubbleSize, size.ordinal()));
                f = obtainStyledAttributes.getDimension(R.styleable.FastScroller_bubbleTextSize, getResources().getDimension(this.f18493XIxXXX0x0.textSizeId));
                obtainStyledAttributes.recycle();
                z = z5;
                z3 = z4;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            f = dimension;
            z = true;
            z2 = false;
        }
        setTrackColor(i3);
        setHandleColor(i2);
        setBubbleColor(i);
        setBubbleTextColor(i4);
        setHideScrollbar(z3);
        setBubbleVisible(z);
        setTrackVisible(z2);
        this.f18495XxX0x0xxx.setTextSize(0, f);
    }

    public final void XxX0x0xxx() {
        if (!X0IIOO(this.f18495XxX0x0xxx)) {
            this.f18495XxX0x0xxx.setVisibility(0);
            this.f18500ooXIXxIX = this.f18495XxX0x0xxx.animate().alpha(1.0f).setDuration(100L).setListener(new oxoX());
        }
    }

    public final void o00() {
        if (X0IIOO(this.f18495XxX0x0xxx)) {
            this.f18500ooXIXxIX = this.f18495XxX0x0xxx.animate().alpha(0.0f).setDuration(100L).setListener(new X0o0xo());
        }
    }

    public void oI0IIXIo() {
        RecyclerView recyclerView = this.f18492XI0IXoo;
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this.f18485IoOoX);
            this.f18492XI0IXoo = null;
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f18497oI0IIXIo = i2;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return super.onTouchEvent(motionEvent);
                    }
                }
            }
            requestDisallowInterceptTouchEvent(false);
            setHandleSelected(false);
            if (this.f18490OxxIIOOXO) {
                getHandler().postDelayed(this.f18498oo, 1000L);
            }
            o00();
            II0XooXoX iI0XooXoX = this.f18501xI;
            if (iI0XooXoX != null) {
                iI0XooXoX.II0xO0(this);
            }
            return true;
        }
        if (motionEvent.getX() < this.f18486O0xOxO.getX() - ViewCompat.getPaddingStart(this.f18502xXxxox0I)) {
            return false;
        }
        requestDisallowInterceptTouchEvent(true);
        setHandleSelected(true);
        getHandler().removeCallbacks(this.f18498oo);
        Oxx0xo(this.f18482IIX0o);
        Oxx0xo(this.f18500ooXIXxIX);
        if (!X0IIOO(this.f18502xXxxox0I)) {
            xXxxox0I();
        }
        if (this.f18483IIXOooo && this.f18499oo0xXOI0I != null) {
            XxX0x0xxx();
        }
        II0XooXoX iI0XooXoX2 = this.f18501xI;
        if (iI0XooXoX2 != null) {
            iI0XooXoX2.oIX0oI(this);
        }
        float y = motionEvent.getY();
        setViewPositions(y);
        setRecyclerViewPosition(y);
        return true;
    }

    public void setBubbleColor(@ColorInt int i) {
        Drawable drawable;
        this.f18494XO = i;
        if (this.f18503xoXoI == null && (drawable = ContextCompat.getDrawable(getContext(), this.f18493XIxXXX0x0.drawableId)) != null) {
            Drawable wrap = DrawableCompat.wrap(drawable);
            this.f18503xoXoI = wrap;
            wrap.mutate();
        }
        DrawableCompat.setTint(this.f18503xoXoI, this.f18494XO);
        ViewCompat.setBackground(this.f18495XxX0x0xxx, this.f18503xoXoI);
    }

    public void setBubbleTextColor(@ColorInt int i) {
        this.f18495XxX0x0xxx.setTextColor(i);
    }

    public void setBubbleTextSize(int i) {
        this.f18495XxX0x0xxx.setTextSize(i);
    }

    public void setBubbleVisible(boolean z) {
        this.f18483IIXOooo = z;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        int i;
        super.setEnabled(z);
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        setVisibility(i);
    }

    public void setFastScrollListener(@Nullable II0XooXoX iI0XooXoX) {
        this.f18501xI = iI0XooXoX;
    }

    public void setHandleColor(@ColorInt int i) {
        Drawable drawable;
        this.f18487Oo = i;
        if (this.f18496o00 == null && (drawable = ContextCompat.getDrawable(getContext(), R.drawable.fastscroll_handle)) != null) {
            Drawable wrap = DrawableCompat.wrap(drawable);
            this.f18496o00 = wrap;
            wrap.mutate();
        }
        DrawableCompat.setTint(this.f18496o00, this.f18487Oo);
        this.f18486O0xOxO.setImageDrawable(this.f18496o00);
    }

    public void setHideScrollbar(boolean z) {
        int i;
        this.f18490OxxIIOOXO = z;
        View view = this.f18502xXxxox0I;
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        view.setVisibility(i);
    }

    @Override // android.view.View
    public void setLayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -2;
        super.setLayoutParams(layoutParams);
    }

    public void setSectionIndexer(@Nullable xxIXOIIO xxixoiio) {
        this.f18499oo0xXOI0I = xxixoiio;
    }

    public void setSwipeRefreshLayout(@Nullable SwipeRefreshLayout swipeRefreshLayout) {
        this.f18504xxX = swipeRefreshLayout;
    }

    public void setTrackColor(@ColorInt int i) {
        Drawable drawable;
        if (this.f18488OxI == null && (drawable = ContextCompat.getDrawable(getContext(), R.drawable.fastscroll_track)) != null) {
            Drawable wrap = DrawableCompat.wrap(drawable);
            this.f18488OxI = wrap;
            wrap.mutate();
        }
        DrawableCompat.setTint(this.f18488OxI, i);
        this.f18491X0IIOO.setImageDrawable(this.f18488OxI);
    }

    public void setTrackVisible(boolean z) {
        int i;
        ImageView imageView = this.f18491X0IIOO;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        imageView.setVisibility(i);
    }

    public final void xXxxox0I() {
        if (this.f18492XI0IXoo.computeVerticalScrollRange() - this.f18497oI0IIXIo > 0) {
            this.f18502xXxxox0I.setTranslationX(getResources().getDimensionPixelSize(R.dimen.fastscroll_scrollbar_padding_end));
            this.f18502xXxxox0I.setVisibility(0);
            this.f18482IIX0o = this.f18502xXxxox0I.animate().translationX(0.0f).alpha(1.0f).setDuration(300L).setListener(new XO());
        }
    }

    public final int xoXoI(int i, int i2, int i3) {
        return Math.min(Math.max(i, i3), i2);
    }

    public final void xxX(Context context, Size size) {
        XIxXXX0x0(context, null, size);
    }

    public FastScroller(@NonNull Context context, Size size) {
        super(context);
        this.f18498oo = new oIX0oI();
        this.f18485IoOoX = new II0xO0();
        xxX(context, size);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    }

    public void setLayoutParams(@NonNull ViewGroup viewGroup) {
        RecyclerView recyclerView = this.f18492XI0IXoo;
        int id = recyclerView != null ? recyclerView.getId() : -1;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.fastscroll_scrollbar_margin_top);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.fastscroll_scrollbar_margin_bottom);
        if (id != -1) {
            if (viewGroup instanceof ConstraintLayout) {
                ConstraintSet constraintSet = new ConstraintSet();
                if (this.f18492XI0IXoo.getParent() != getParent()) {
                    id = 0;
                }
                int id2 = getId();
                ConstraintLayout constraintLayout = (ConstraintLayout) viewGroup;
                constraintSet.clone(constraintLayout);
                constraintSet.connect(id2, 3, id, 3);
                constraintSet.connect(id2, 4, id, 4);
                constraintSet.connect(id2, 7, id, 7);
                constraintSet.applyTo(constraintLayout);
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
                ((ViewGroup.MarginLayoutParams) layoutParams).height = 0;
                layoutParams.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize2);
                setLayoutParams(layoutParams);
            } else if (viewGroup instanceof CoordinatorLayout) {
                CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) getLayoutParams();
                ((ViewGroup.MarginLayoutParams) layoutParams2).height = -1;
                layoutParams2.anchorGravity = GravityCompat.END;
                layoutParams2.setAnchorId(id);
                layoutParams2.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize2);
                setLayoutParams(layoutParams2);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) getLayoutParams();
                layoutParams3.height = -1;
                layoutParams3.gravity = GravityCompat.END;
                layoutParams3.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize2);
                setLayoutParams(layoutParams3);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) getLayoutParams();
                layoutParams4.height = 0;
                layoutParams4.addRule(6, id);
                layoutParams4.addRule(8, id);
                layoutParams4.addRule(19, id);
                layoutParams4.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize2);
                setLayoutParams(layoutParams4);
            } else {
                throw new IllegalArgumentException("Parent ViewGroup must be a ConstraintLayout, CoordinatorLayout, FrameLayout, or RelativeLayout");
            }
            IIX0o();
            return;
        }
        throw new IllegalArgumentException("RecyclerView must have a view ID");
    }

    public FastScroller(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FastScroller(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18498oo = new oIX0oI();
        this.f18485IoOoX = new II0xO0();
        XI0IXoo(context, attributeSet);
        setLayoutParams(generateLayoutParams(attributeSet));
    }
}
