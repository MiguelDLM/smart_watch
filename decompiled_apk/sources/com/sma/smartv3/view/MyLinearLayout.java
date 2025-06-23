package com.sma.smartv3.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.sma.smartv3.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import skin.support.widget.SkinCompatLinearLayout;

@XX({"SMAP\nMyLinearLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyLinearLayout.kt\ncom/sma/smartv3/view/MyLinearLayout\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,46:1\n172#2,2:47\n*S KotlinDebug\n*F\n+ 1 MyLinearLayout.kt\ncom/sma/smartv3/view/MyLinearLayout\n*L\n43#1:47,2\n*E\n"})
/* loaded from: classes12.dex */
public final class MyLinearLayout extends SkinCompatLinearLayout {

    /* renamed from: Oo, reason: collision with root package name */
    public int f25076Oo;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public MyLinearLayout(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    @Override // skin.support.widget.SkinCompatLinearLayout, xxoXO.Oxx0IOOO
    public void applySkin() {
        super.applySkin();
        if (this.f25076Oo != 0) {
            TypedValue typedValue = new TypedValue();
            oIxOXo.oxoX.Oxx0xo(getContext(), this.f25076Oo, typedValue, true);
            int dimension = (int) typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            setPadding(dimension, dimension, dimension, dimension);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public MyLinearLayout(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ MyLinearLayout(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public MyLinearLayout(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SkinTintHelper, i, 0);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            if (obtainStyledAttributes.hasValue(0)) {
                this.f25076Oo = obtainStyledAttributes.getResourceId(0, 0);
            }
            obtainStyledAttributes.recycle();
            applySkin();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
