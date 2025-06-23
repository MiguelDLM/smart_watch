package skin.support.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import xxoXO.I0Io;
import xxoXO.II0XooXoX;
import xxoXO.Oxx0IOOO;
import xxoXO.oIX0oI;

/* loaded from: classes6.dex */
public class SkinCompatCheckedTextView extends AppCompatCheckedTextView implements Oxx0IOOO {
    private static final int[] TINT_ATTRS = {R.attr.checkMark};
    private oIX0oI mBackgroundTintHelper;
    private int mCheckMarkResId;
    private II0XooXoX mTextHelper;

    public SkinCompatCheckedTextView(Context context) {
        this(context, null);
    }

    private void applyCheckMark() {
        int II0xO02 = I0Io.II0xO0(this.mCheckMarkResId);
        this.mCheckMarkResId = II0xO02;
        if (II0xO02 != 0) {
            setCheckMarkDrawable(oIxOXo.II0XooXoX.oIX0oI(getContext(), this.mCheckMarkResId));
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
        applyCheckMark();
    }

    @Override // androidx.appcompat.widget.AppCompatCheckedTextView, android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        oIX0oI oix0oi = this.mBackgroundTintHelper;
        if (oix0oi != null) {
            oix0oi.oxoX(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckedTextView, android.widget.CheckedTextView
    public void setCheckMarkDrawable(@DrawableRes int i) {
        this.mCheckMarkResId = i;
        applyCheckMark();
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

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        setTextAppearance(getContext(), i);
    }

    public SkinCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, skin.support.appcompat.R.attr.checkedTextViewStyle);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckedTextView, android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        II0XooXoX iI0XooXoX = this.mTextHelper;
        if (iI0XooXoX != null) {
            iI0XooXoX.oOoXoXO(context, i);
        }
    }

    public SkinCompatCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckMarkResId = 0;
        oIX0oI oix0oi = new oIX0oI(this);
        this.mBackgroundTintHelper = oix0oi;
        oix0oi.I0Io(attributeSet, i);
        II0XooXoX Oxx0IOOO2 = II0XooXoX.Oxx0IOOO(this);
        this.mTextHelper = Oxx0IOOO2;
        Oxx0IOOO2.xxIXOIIO(attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, TINT_ATTRS, i, 0);
        this.mCheckMarkResId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        applyCheckMark();
    }
}
