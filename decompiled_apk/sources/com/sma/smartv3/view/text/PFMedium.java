package com.sma.smartv3.view.text;

import OOxOI.oIX0oI;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.core.widget.TextViewCompat;
import com.sma.smartv3.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import oIxOXo.oxoX;
import skin.support.widget.SkinCompatTextView;

/* loaded from: classes12.dex */
public class PFMedium extends SkinCompatTextView {
    private int mDrawableTintResId;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @xoIox
    public PFMedium(@OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public void applyCustomFont(@oOoXoXO Context context) {
        if (context != null) {
            setTypeface(oIX0oI.f1804oIX0oI.oIX0oI(MyTypeface.PF_MEDIUM, context));
        }
    }

    @Override // skin.support.widget.SkinCompatTextView, xxoXO.Oxx0IOOO
    public void applySkin() {
        super.applySkin();
        if (this.mDrawableTintResId != 0) {
            TextViewCompat.setCompoundDrawableTintList(this, oxoX.X0o0xo(getContext(), this.mDrawableTintResId));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @xoIox
    public PFMedium(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ PFMedium(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public PFMedium(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        applyCustomFont(context);
        setFontFeatureSettings("\"liga\"=0");
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SkinTintHelper, i, 0);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            if (obtainStyledAttributes.hasValue(3)) {
                this.mDrawableTintResId = obtainStyledAttributes.getResourceId(3, 0);
            }
            obtainStyledAttributes.recycle();
            applySkin();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
