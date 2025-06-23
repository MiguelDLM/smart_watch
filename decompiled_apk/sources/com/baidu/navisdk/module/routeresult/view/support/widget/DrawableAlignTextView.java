package com.baidu.navisdk.module.routeresult.view.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.navisdk.embed.R;

/* loaded from: classes7.dex */
public class DrawableAlignTextView extends AppCompatTextView {

    /* renamed from: a, reason: collision with root package name */
    private int f7504a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private int j;

    public DrawableAlignTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TextViewDrawable);
        this.f7504a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextViewDrawable_drawableLeftWidth, 0);
        this.e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextViewDrawable_drawableLeftHeight, 0);
        this.b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextViewDrawable_drawableTopWidth, 0);
        this.f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextViewDrawable_drawableTopHeight, 0);
        this.c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextViewDrawable_drawableRightWidth, 0);
        this.g = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextViewDrawable_drawableRightHeight, 0);
        this.d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextViewDrawable_drawableBottomWidth, 0);
        this.h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextViewDrawable_drawableBottomHeight, 0);
        this.i = obtainStyledAttributes.getBoolean(R.styleable.TextViewDrawable_isAliganCenter, true);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.j = i;
        Drawable[] compoundDrawables = getCompoundDrawables();
        Drawable drawable = compoundDrawables[0];
        Drawable drawable2 = compoundDrawables[1];
        Drawable drawable3 = compoundDrawables[2];
        Drawable drawable4 = compoundDrawables[3];
        if (drawable != null) {
            a(drawable, 0, this.f7504a, this.e);
        }
        if (drawable2 != null) {
            a(drawable2, 1, this.b, this.f);
        }
        if (drawable3 != null) {
            a(drawable3, 2, this.c, this.g);
        }
        if (drawable4 != null) {
            a(drawable4, 3, this.d, this.h);
        }
        setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.j = i;
        Drawable[] compoundDrawables = getCompoundDrawables();
        Drawable drawable = compoundDrawables[0];
        Drawable drawable2 = compoundDrawables[1];
        Drawable drawable3 = compoundDrawables[2];
        Drawable drawable4 = compoundDrawables[3];
        if (drawable != null) {
            a(drawable, 0, this.f7504a, this.e);
        }
        if (drawable2 != null) {
            a(drawable2, 1, this.b, this.f);
        }
        if (drawable3 != null) {
            a(drawable3, 2, this.c, this.g);
        }
        if (drawable4 != null) {
            a(drawable4, 3, this.d, this.h);
        }
        setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    public DrawableAlignTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = true;
        a(context, attributeSet, i);
    }

    public void a(Drawable drawable, int i, int i2, int i3) {
        int lineHeight;
        if (i2 == 0) {
            i2 = drawable.getIntrinsicWidth();
        }
        if (i3 == 0) {
            i3 = drawable.getIntrinsicHeight();
        }
        int i4 = 0;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        lineHeight = 0;
                        i2 = 0;
                        i3 = 0;
                        drawable.setBounds(i4, lineHeight, i2, i3);
                        requestLayout();
                    }
                }
            }
            int i5 = this.i ? 0 : ((-this.j) / 2) + (i2 / 2);
            i2 += i5;
            i4 = i5;
            lineHeight = 0;
            drawable.setBounds(i4, lineHeight, i2, i3);
            requestLayout();
        }
        lineHeight = this.i ? 0 : (((-getLineCount()) * getLineHeight()) / 2) + (getLineHeight() / 2);
        i3 += lineHeight;
        drawable.setBounds(i4, lineHeight, i2, i3);
        requestLayout();
    }
}
