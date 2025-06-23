package skin.support.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import xxoXO.I0Io;
import xxoXO.II0XooXoX;
import xxoXO.Oxx0IOOO;
import xxoXO.oIX0oI;

/* loaded from: classes6.dex */
public class SkinCompatAutoCompleteTextView extends AppCompatAutoCompleteTextView implements Oxx0IOOO {
    private static final int[] TINT_ATTRS = {R.attr.popupBackground};
    private oIX0oI mBackgroundTintHelper;
    private int mDropDownBackgroundResId;
    private II0XooXoX mTextHelper;

    public SkinCompatAutoCompleteTextView(Context context) {
        this(context, null);
    }

    private void applyDropDownBackgroundResource() {
        Drawable oIX0oI2;
        int II0xO02 = I0Io.II0xO0(this.mDropDownBackgroundResId);
        this.mDropDownBackgroundResId = II0xO02;
        if (II0xO02 != 0 && (oIX0oI2 = oIxOXo.II0XooXoX.oIX0oI(getContext(), this.mDropDownBackgroundResId)) != null) {
            setDropDownBackgroundDrawable(oIX0oI2);
        }
    }

    @Override // xxoXO.Oxx0IOOO
    public void applySkin() {
        oIX0oI oix0oi = this.mBackgroundTintHelper;
        if (oix0oi != null) {
            oix0oi.oIX0oI();
        }
        II0XooXoX iI0XooXoX = this.mTextHelper;
        if (iI0XooXoX != null) {
            iI0XooXoX.oIX0oI();
        }
        applyDropDownBackgroundResource();
    }

    @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        oIX0oI oix0oi = this.mBackgroundTintHelper;
        if (oix0oi != null) {
            oix0oi.oxoX(i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        II0XooXoX iI0XooXoX = this.mTextHelper;
        if (iI0XooXoX != null) {
            iI0XooXoX.xoIox(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        II0XooXoX iI0XooXoX = this.mTextHelper;
        if (iI0XooXoX != null) {
            iI0XooXoX.OOXIXo(i, i2, i3, i4);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(@DrawableRes int i) {
        super.setDropDownBackgroundResource(i);
        this.mDropDownBackgroundResId = i;
        applyDropDownBackgroundResource();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        setTextAppearance(getContext(), i);
    }

    public SkinCompatAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, skin.support.appcompat.R.attr.autoCompleteTextViewStyle);
    }

    @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        II0XooXoX iI0XooXoX = this.mTextHelper;
        if (iI0XooXoX != null) {
            iI0XooXoX.oOoXoXO(context, i);
        }
    }

    public SkinCompatAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDropDownBackgroundResId = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, TINT_ATTRS, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            this.mDropDownBackgroundResId = obtainStyledAttributes.getResourceId(0, 0);
        }
        obtainStyledAttributes.recycle();
        applyDropDownBackgroundResource();
        oIX0oI oix0oi = new oIX0oI(this);
        this.mBackgroundTintHelper = oix0oi;
        oix0oi.I0Io(attributeSet, i);
        II0XooXoX Oxx0IOOO2 = II0XooXoX.Oxx0IOOO(this);
        this.mTextHelper = Oxx0IOOO2;
        Oxx0IOOO2.xxIXOIIO(attributeSet, i);
    }
}
