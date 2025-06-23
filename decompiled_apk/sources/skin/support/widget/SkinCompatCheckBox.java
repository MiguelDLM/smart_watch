package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatCheckBox;
import skin.support.appcompat.R;
import xxoXO.II0XooXoX;
import xxoXO.II0xO0;
import xxoXO.Oxx0IOOO;
import xxoXO.oIX0oI;

/* loaded from: classes6.dex */
public class SkinCompatCheckBox extends AppCompatCheckBox implements Oxx0IOOO {
    private oIX0oI mBackgroundTintHelper;
    private II0xO0 mCompoundButtonHelper;
    private II0XooXoX mTextHelper;

    public SkinCompatCheckBox(Context context) {
        this(context, null);
    }

    @Override // xxoXO.Oxx0IOOO
    public void applySkin() {
        II0xO0 iI0xO0 = this.mCompoundButtonHelper;
        if (iI0xO0 != null) {
            iI0xO0.oIX0oI();
        }
        oIX0oI oix0oi = this.mBackgroundTintHelper;
        if (oix0oi != null) {
            oix0oi.oIX0oI();
        }
        II0XooXoX iI0XooXoX = this.mTextHelper;
        if (iI0XooXoX != null) {
            iI0XooXoX.oIX0oI();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        oIX0oI oix0oi = this.mBackgroundTintHelper;
        if (oix0oi != null) {
            oix0oi.oxoX(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(@DrawableRes int i) {
        super.setButtonDrawable(i);
        II0xO0 iI0xO0 = this.mCompoundButtonHelper;
        if (iI0xO0 != null) {
            iI0xO0.oxoX(i);
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

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        setTextAppearance(getContext(), i);
    }

    public SkinCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkboxStyle);
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        II0XooXoX iI0XooXoX = this.mTextHelper;
        if (iI0XooXoX != null) {
            iI0XooXoX.oOoXoXO(context, i);
        }
    }

    public SkinCompatCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        II0xO0 iI0xO0 = new II0xO0(this);
        this.mCompoundButtonHelper = iI0xO0;
        iI0xO0.I0Io(attributeSet, i);
        oIX0oI oix0oi = new oIX0oI(this);
        this.mBackgroundTintHelper = oix0oi;
        oix0oi.I0Io(attributeSet, i);
        II0XooXoX Oxx0IOOO2 = II0XooXoX.Oxx0IOOO(this);
        this.mTextHelper = Oxx0IOOO2;
        Oxx0IOOO2.xxIXOIIO(attributeSet, i);
    }
}
