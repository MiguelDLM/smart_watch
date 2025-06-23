package com.sma.smartv3.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.sma.smartv3.co_fit.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes12.dex */
public class MarqueeTextView extends FrameLayout implements xxoXO.Oxx0IOOO {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public long f25054IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public TextView f25055IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public I0Io f25056O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public TextView f25057Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public xxoXO.oIX0oI f25058OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public List<String> f25059Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public long f25060OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public final Runnable f25061X0IIOO;

    /* renamed from: XO, reason: collision with root package name */
    public Context f25062XO;

    /* renamed from: o00, reason: collision with root package name */
    public boolean f25063o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f25064oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public Handler f25065xoXoI;

    /* loaded from: classes12.dex */
    public interface I0Io {
        void oIX0oI(int position);
    }

    /* loaded from: classes12.dex */
    public class II0xO0 extends AnimatorListenerAdapter {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ int f25067XO;

        public II0xO0(final int val$nextIndex) {
            this.f25067XO = val$nextIndex;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            TextView textView = MarqueeTextView.this.f25057Oo;
            MarqueeTextView marqueeTextView = MarqueeTextView.this;
            marqueeTextView.f25057Oo = marqueeTextView.f25055IXxxXO;
            MarqueeTextView.this.f25055IXxxXO = textView;
            MarqueeTextView marqueeTextView2 = MarqueeTextView.this;
            marqueeTextView2.f25064oI0IIXIo = this.f25067XO;
            marqueeTextView2.f25055IXxxXO.setTranslationY(MarqueeTextView.this.getHeight());
            if (MarqueeTextView.this.f25056O0xOxO != null) {
                MarqueeTextView.this.f25056O0xOxO.oIX0oI(MarqueeTextView.this.f25064oI0IIXIo);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class oIX0oI implements Runnable {
        public oIX0oI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MarqueeTextView.this.xxIXOIIO();
            MarqueeTextView.this.f25065xoXoI.postDelayed(this, MarqueeTextView.this.f25060OxxIIOOXO);
        }
    }

    public MarqueeTextView(@NonNull Context context) {
        this(context, null);
    }

    public final float OOXIXo(float px) {
        return px / this.f25062XO.getResources().getDisplayMetrics().scaledDensity;
    }

    @Override // xxoXO.Oxx0IOOO
    public void applySkin() {
        xxoXO.oIX0oI oix0oi = this.f25058OxI;
        if (oix0oi != null) {
            oix0oi.oIX0oI();
        }
    }

    public TextView getCurrentView() {
        return this.f25057Oo;
    }

    public TextView getNextView() {
        return this.f25055IXxxXO;
    }

    public void oOoXoXO() {
        if (!this.f25063o00 && this.f25059Oxx0xo.size() > 1) {
            this.f25063o00 = true;
            this.f25065xoXoI.postDelayed(this.f25061X0IIOO, this.f25060OxxIIOOXO);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.f25063o00) {
            oOoXoXO();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ooOOo0oXI();
    }

    public void ooOOo0oXI() {
        if (!this.f25063o00) {
            return;
        }
        this.f25063o00 = false;
        this.f25065xoXoI.removeCallbacks(this.f25061X0IIOO);
    }

    @Override // android.view.View
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        xxoXO.oIX0oI oix0oi = this.f25058OxI;
        if (oix0oi != null) {
            oix0oi.oxoX(resId);
        }
    }

    public void setCurrentView(TextView currentView) {
        this.f25057Oo = currentView;
    }

    public void setMarqueeListener(I0Io listener) {
        this.f25056O0xOxO = listener;
    }

    public void setNextView(TextView nextView) {
        this.f25055IXxxXO = nextView;
    }

    public void setTextList(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.f25059Oxx0xo.clear();
            this.f25059Oxx0xo.addAll(list);
            this.f25064oI0IIXIo = 0;
            this.f25057Oo.setText(this.f25059Oxx0xo.get(0));
            I0Io i0Io = this.f25056O0xOxO;
            if (i0Io != null) {
                i0Io.oIX0oI(this.f25064oI0IIXIo);
            }
        }
    }

    public final TextView xoIox(float textSize, int textColor) {
        TextView textView = new TextView(this.f25062XO);
        textView.setTextSize(OOXIXo(textSize));
        textView.setTextColor(textColor);
        textView.setSingleLine(true);
        textView.setTextColor(oIxOXo.oxoX.I0Io(this.f25062XO, R.color.text_color));
        textView.setEllipsize(TextUtils.TruncateAt.END);
        return textView;
    }

    public final void xxIXOIIO() {
        int size = (this.f25064oI0IIXIo + 1) % this.f25059Oxx0xo.size();
        this.f25055IXxxXO.setText(this.f25059Oxx0xo.get(size));
        this.f25055IXxxXO.setTranslationY(getHeight());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f25057Oo, "translationY", 0.0f, -getHeight());
        ofFloat.setDuration(this.f25054IIXOooo);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f25055IXxxXO, "translationY", getHeight(), 0.0f);
        ofFloat2.setDuration(this.f25054IIXOooo);
        ofFloat.start();
        ofFloat2.start();
        ofFloat2.addListener(new II0xO0(size));
    }

    public MarqueeTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MarqueeTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f25059Oxx0xo = new ArrayList();
        this.f25064oI0IIXIo = 0;
        this.f25060OxxIIOOXO = 3000L;
        this.f25054IIXOooo = 500L;
        this.f25065xoXoI = new Handler();
        this.f25063o00 = false;
        this.f25061X0IIOO = new oIX0oI();
        xxoXO.oIX0oI oix0oi = new xxoXO.oIX0oI(this);
        this.f25058OxI = oix0oi;
        oix0oi.I0Io(attrs, defStyleAttr);
        this.f25062XO = context;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, com.sma.smartv3.R.styleable.MarqueTextView, 0, 0);
        this.f25060OxxIIOOXO = obtainStyledAttributes.getInt(1, (int) this.f25060OxxIIOOXO);
        this.f25054IIXOooo = obtainStyledAttributes.getInt(0, (int) this.f25054IIXOooo);
        float dimension = obtainStyledAttributes.getDimension(3, 16.0f);
        int color = obtainStyledAttributes.getColor(2, -13421773);
        obtainStyledAttributes.recycle();
        this.f25057Oo = xoIox(dimension, color);
        this.f25055IXxxXO = xoIox(dimension, color);
        addView(this.f25057Oo, new FrameLayout.LayoutParams(-1, -2));
        addView(this.f25055IXxxXO, new FrameLayout.LayoutParams(-1, -2));
        this.f25055IXxxXO.setTranslationY(getHeight());
    }
}
