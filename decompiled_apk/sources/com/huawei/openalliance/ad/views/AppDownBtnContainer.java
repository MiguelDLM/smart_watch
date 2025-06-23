package com.huawei.openalliance.ad.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.download.app.k;
import com.huawei.openalliance.ad.utils.w;
import com.huawei.openalliance.ad.views.ProgressButton;

/* loaded from: classes10.dex */
public abstract class AppDownBtnContainer extends RelativeLayout implements View.OnClickListener, ProgressButton.a {
    protected boolean B;
    private RelativeLayout.LayoutParams D;
    private ImageView F;
    protected a I;
    private int L;
    private ProgressButton S;
    protected String V;

    /* renamed from: a, reason: collision with root package name */
    private boolean f17413a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;

    public AppDownBtnContainer(Context context) {
        super(context);
        this.V = "AppDownBtn_" + hashCode();
        this.f17413a = false;
        this.b = true;
        this.g = false;
        this.h = false;
        Code(context, null, false);
    }

    private void I(int i) {
        if (this.b || this.e <= 0) {
            int i2 = this.c;
            if ((i2 <= 0 || i <= i2) && ((i2 = this.d) <= 0 || i >= i2)) {
                this.e = i;
            } else {
                this.e = i2;
            }
        }
    }

    private void V() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.f;
            layoutParams.width = this.e;
            setLayoutParams(layoutParams);
        }
        if (this.g) {
            V(this.f);
        }
    }

    private Drawable getCancelBtnDrawable() {
        a aVar = this.I;
        return aVar == null ? getContext().getResources().getDrawable(R.drawable.hiad_app_down_cancel_btn) : aVar.C;
    }

    @Override // com.huawei.openalliance.ad.views.ProgressButton.a
    public void Code(int i, int i2) {
        fb.Code("AppDownBtn", "on size reset: %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i <= 0 || i2 <= 0) {
            return;
        }
        if (this.h) {
            this.e = i;
            this.h = false;
        } else {
            I(i);
        }
        this.f = i2;
        V();
    }

    public int getProgress() {
        return this.S.getProgress();
    }

    public Drawable getProgressDrawable() {
        return this.S.getProgressDrawable();
    }

    public Rect getPromptRect() {
        return this.S.getPromptRect();
    }

    public abstract k getStatus();

    public CharSequence getText() {
        return this.S.getText();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        ProgressButton progressButton = this.S;
        if (progressButton != null && this.f17413a) {
            ViewGroup.LayoutParams layoutParams = progressButton.getLayoutParams();
            layoutParams.height = View.MeasureSpec.getSize(i2);
            layoutParams.width = View.MeasureSpec.getSize(i);
            int i4 = this.f;
            if (i4 > 0) {
                layoutParams.height = i4;
            }
            if (this.b && (i3 = this.e) > 0) {
                layoutParams.width = i3;
            }
            int i5 = this.c;
            if (i5 > 0 && layoutParams.width > i5) {
                layoutParams.width = i5;
            }
            int i6 = this.d;
            if (i6 > 0 && layoutParams.width < i6) {
                layoutParams.width = i6;
            }
            if (layoutParams.width > 0 && layoutParams.height > 0) {
                this.S.setLayoutParams(layoutParams);
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCancelBtnClickListener(View.OnClickListener onClickListener) {
        this.F.setOnClickListener(onClickListener);
    }

    public void setFixedWidth(boolean z) {
        this.S.setFixedWidth(z);
    }

    public void setFontFamily(String str) {
        this.S.setFontFamily(str);
    }

    public void setLayoutParamsSkipSizeReset(ViewGroup.LayoutParams layoutParams) {
        this.h = true;
        setLayoutParams(layoutParams);
    }

    public void setMax(int i) {
        this.S.setMax(i);
    }

    public void setMaxWidth(int i) {
        this.S.setMaxWidth(i);
    }

    public void setMinWidth(int i) {
        this.S.setMinWidth(i);
    }

    public void setPaintTypeface(Typeface typeface) {
        this.S.setPaintTypeface(typeface);
    }

    public void setProgress(int i) {
        this.S.setProgress(i);
    }

    public void setProgressDrawable(Drawable drawable) {
        this.S.setProgressDrawable(drawable);
    }

    public void setResetWidth(boolean z) {
        this.b = z;
        this.S.setResetWidth(z);
    }

    public void setText(CharSequence charSequence) {
        this.S.Code(charSequence, this.g);
    }

    public void setTextColor(int i) {
        this.S.setTextColor(i);
    }

    public void setTextSize(float f) {
        this.S.setTextSize(f);
    }

    public void setVisibilityInner(int i) {
        this.S.setVisibility(i);
    }

    @AllApi
    public void updateLayoutHeight() {
        this.S.V();
    }

    public AppDownBtnContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.V = "AppDownBtn_" + hashCode();
        this.f17413a = false;
        this.b = true;
        this.g = false;
        this.h = false;
        Code(context, attributeSet, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i) {
        this.L = i < w.V(getContext(), 40.0f) ? w.V(getContext(), 12.0f) : w.V(getContext(), 16.0f);
        fb.Code("AppDownBtn", "btnHeight: %s, cancelBtnSize: %s", Integer.valueOf(i), Integer.valueOf(this.L));
        RelativeLayout.LayoutParams layoutParams = this.D;
        layoutParams.height = i;
        layoutParams.width = i;
        layoutParams.setMarginEnd(0);
        int i2 = this.L;
        int i3 = (i - i2) / 2;
        if (i3 <= 0) {
            RelativeLayout.LayoutParams layoutParams2 = this.D;
            layoutParams2.height = i2;
            layoutParams2.width = i2;
            layoutParams2.setMarginEnd(w.V(getContext(), 12.0f));
            i3 = 0;
        }
        this.F.setPaddingRelative(i3, i3, i3, i3);
        if (this.B) {
            this.S.f = this.L;
            this.F.setBackground(this.I.Z().Code());
        }
        try {
            if (this.F.getParent() != this) {
                addView(this.F, this.D);
            }
        } catch (Throwable th) {
            fb.I("AppDownBtn", "add cancel btn ex: %s", th.getClass().getSimpleName());
        }
    }

    public void Code(int i, int i2, int i3, int i4) {
        this.S.setPadding(i, i2, i3, i4);
    }

    public AppDownBtnContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.V = "AppDownBtn_" + hashCode();
        this.f17413a = false;
        this.b = true;
        this.g = false;
        this.h = false;
        Code(context, attributeSet, false);
    }

    private void Code(Context context) {
        if (context == null) {
            return;
        }
        this.F = new ImageView(context);
        this.L = w.V(context, 16.0f);
        this.F.setImageDrawable(context.getResources().getDrawable(R.drawable.hiad_app_down_cancel_btn));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.D = layoutParams;
        layoutParams.addRule(19, this.S.getId());
        this.D.addRule(15);
    }

    public void V(int i, int i2, int i3, int i4) {
        this.S.setPaddingRelative(i, i2, i3, i4);
    }

    @SuppressLint({"NewApi"})
    public AppDownBtnContainer(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.V = "AppDownBtn_" + hashCode();
        this.f17413a = false;
        this.b = true;
        this.g = false;
        this.h = false;
        Code(context, attributeSet, false);
    }

    private void Code(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return;
        }
        this.f17413a = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.hiad_progress_button);
        try {
            this.b = obtainStyledAttributes.getBoolean(R.styleable.hiad_progress_button_hiad_resetWidth, true);
            this.c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.hiad_progress_button_hiad_maxWidth, 0);
            this.d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.hiad_progress_button_hiad_minWidth, 0);
        } finally {
            try {
            } finally {
            }
        }
    }

    public void V(k kVar) {
        if (kVar == null) {
            return;
        }
        this.g = Code(kVar);
        fb.Code("AppDownBtn", "configCancelBtn, status: %s", kVar);
        if (this.g) {
            this.F.setImageDrawable(getCancelBtnDrawable());
            this.S.e = this.g;
            int measuredHeight = getMeasuredHeight();
            if (measuredHeight <= 0) {
                post(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownBtnContainer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        fb.Code("AppDownBtn", "post run");
                        AppDownBtnContainer appDownBtnContainer = AppDownBtnContainer.this;
                        appDownBtnContainer.V(appDownBtnContainer.getMeasuredHeight());
                    }
                });
                return;
            } else {
                V(measuredHeight);
                return;
            }
        }
        try {
            if (this.F.getParent() == this) {
                this.S.e = this.g;
                removeView(this.F);
            }
        } catch (Throwable th) {
            fb.I("AppDownBtn", "remove cancel btn ex: %s", th.getClass().getSimpleName());
        }
    }

    public AppDownBtnContainer(Context context, Boolean bool) {
        super(context);
        this.V = "AppDownBtn_" + hashCode();
        this.f17413a = false;
        this.b = true;
        this.g = false;
        this.h = false;
        Code(context, null, (bool == null ? Boolean.TRUE : bool).booleanValue());
    }

    private void Code(Context context, AttributeSet attributeSet, boolean z) {
        Code(context, attributeSet);
        fb.Code("AppDownBtn", "init, create with attrs: %s", Boolean.valueOf(this.f17413a));
        this.S = z ? new ProgressButtonForNarrowBounds(context, attributeSet) : new ProgressButton(context, attributeSet);
        fb.V(this.V, "progressBtn: %s", Integer.valueOf(this.S.hashCode()));
        this.S.setId(R.id.haid_down_btn_progress);
        setOnClickListener(this);
        this.S.setResetListener(this);
        this.S.setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        addView(this.S, layoutParams);
        this.B = z;
        Code(context);
    }

    public void Code(Drawable drawable, int i) {
        this.S.Code(drawable, i);
    }

    public void Code(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
        this.S.setOnClickListener(onClickListener);
    }

    public boolean Code() {
        return this.S.Code();
    }

    private static boolean Code(k kVar) {
        return k.PAUSE == kVar || k.WAITING_FOR_WIFI == kVar;
    }
}
