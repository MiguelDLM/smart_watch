package com.sma.smartv3.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.sma.smartv3.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import skin.support.widget.SkinCompatImageView;

/* loaded from: classes12.dex */
public final class TintImageView extends SkinCompatImageView {
    private int mTintResId;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public TintImageView(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    @Override // skin.support.widget.SkinCompatImageView, xxoXO.Oxx0IOOO
    public void applySkin() {
        super.applySkin();
        if (this.mTintResId != 0) {
            setImageTintList(oIxOXo.oxoX.X0o0xo(getContext(), this.mTintResId));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public TintImageView(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ TintImageView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public TintImageView(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SkinTintHelper, i, 0);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            if (obtainStyledAttributes.hasValue(1)) {
                this.mTintResId = obtainStyledAttributes.getResourceId(1, 0);
            }
            obtainStyledAttributes.recycle();
            applySkin();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
