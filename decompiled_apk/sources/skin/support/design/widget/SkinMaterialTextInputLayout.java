package skin.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.StyleRes;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import oIxOXo.oxoX;
import skin.support.R;
import skin.support.widget.SkinCompatEditText;
import xxoXO.I0Io;
import xxoXO.Oxx0IOOO;
import xxoXO.oIX0oI;

/* loaded from: classes6.dex */
public class SkinMaterialTextInputLayout extends TextInputLayout implements Oxx0IOOO {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f33662IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public int f33663Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f33664Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f33665OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public oIX0oI f33666XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f33667oI0IIXIo;

    public SkinMaterialTextInputLayout(Context context) {
        this(context, null);
    }

    private TextView getCounterView() {
        try {
            Field declaredField = TextInputLayout.class.getDeclaredField("mCounterView");
            declaredField.setAccessible(true);
            return (TextView) declaredField.get(this);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private TextView getErrorView() {
        try {
            Field declaredField = TextInputLayout.class.getDeclaredField("mErrorView");
            declaredField.setAccessible(true);
            return (TextView) declaredField.get(this);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void setDefaultTextColor(ColorStateList colorStateList) {
        try {
            Field declaredField = TextInputLayout.class.getDeclaredField("mDefaultTextColor");
            declaredField.setAccessible(true);
            declaredField.set(this, colorStateList);
            xxIXOIIO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setFocusedTextColor(ColorStateList colorStateList) {
        try {
            Field declaredField = TextInputLayout.class.getDeclaredField("mFocusedTextColor");
            declaredField.setAccessible(true);
            declaredField.set(this, colorStateList);
            xxIXOIIO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void I0Io() {
        TextView counterView;
        int II0xO02 = I0Io.II0xO0(this.f33662IXxxXO);
        this.f33662IXxxXO = II0xO02;
        if (II0xO02 != 0 && (counterView = getCounterView()) != null) {
            counterView.setTextColor(oxoX.I0Io(getContext(), this.f33662IXxxXO));
            II0XooXoX();
        }
    }

    public final void II0XooXoX() {
        try {
            Method declaredMethod = TextInputLayout.class.getDeclaredMethod("updateEditTextBackground", null);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void Oxx0IOOO(@StyleRes int i) {
        if (i != 0) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, R.styleable.SkinTextAppearance);
            int i2 = R.styleable.SkinTextAppearance_android_textColor;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.f33664Oxx0xo = obtainStyledAttributes.getResourceId(i2, 0);
            }
            obtainStyledAttributes.recycle();
        }
        oxoX();
    }

    public final void X0o0xo() {
        int i;
        int II0xO02 = I0Io.II0xO0(this.f33667oI0IIXIo);
        this.f33667oI0IIXIo = II0xO02;
        if (II0xO02 != 0 && II0xO02 != skin.support.design.R.color.abc_hint_foreground_material_light) {
            setFocusedTextColor(oxoX.X0o0xo(getContext(), this.f33667oI0IIXIo));
            return;
        }
        if (getEditText() != null) {
            if (getEditText() instanceof SkinCompatEditText) {
                i = ((SkinCompatEditText) getEditText()).getTextColorResId();
            } else if (getEditText() instanceof SkinMaterialTextInputEditText) {
                i = ((SkinMaterialTextInputEditText) getEditText()).getTextColorResId();
            } else {
                i = 0;
            }
            int II0xO03 = I0Io.II0xO0(i);
            if (II0xO03 != 0) {
                setFocusedTextColor(oxoX.X0o0xo(getContext(), II0xO03));
            }
        }
    }

    public final void XO(@StyleRes int i) {
        if (i != 0) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, R.styleable.SkinTextAppearance);
            int i2 = R.styleable.SkinTextAppearance_android_textColor;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.f33662IXxxXO = obtainStyledAttributes.getResourceId(i2, 0);
            }
            obtainStyledAttributes.recycle();
        }
        I0Io();
    }

    @Override // xxoXO.Oxx0IOOO
    public void applySkin() {
        oxoX();
        I0Io();
        X0o0xo();
        oIX0oI oix0oi = this.f33666XO;
        if (oix0oi != null) {
            oix0oi.oIX0oI();
        }
    }

    public final void oxoX() {
        TextView errorView;
        int II0xO02 = I0Io.II0xO0(this.f33664Oxx0xo);
        this.f33664Oxx0xo = II0xO02;
        if (II0xO02 != 0 && II0xO02 != skin.support.design.R.color.design_error && (errorView = getErrorView()) != null) {
            errorView.setTextColor(oxoX.I0Io(getContext(), this.f33664Oxx0xo));
            II0XooXoX();
        }
    }

    @Override // com.google.android.material.textfield.TextInputLayout
    public void setCounterEnabled(boolean z) {
        super.setCounterEnabled(z);
        if (z) {
            I0Io();
        }
    }

    @Override // com.google.android.material.textfield.TextInputLayout
    public void setErrorEnabled(boolean z) {
        super.setErrorEnabled(z);
        if (z) {
            oxoX();
        }
    }

    @Override // com.google.android.material.textfield.TextInputLayout
    public void setErrorTextAppearance(@StyleRes int i) {
        super.setErrorTextAppearance(i);
        Oxx0IOOO(i);
    }

    public final void xxIXOIIO() {
        try {
            Method declaredMethod = TextInputLayout.class.getDeclaredMethod("updateLabelState", Boolean.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, Boolean.FALSE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SkinMaterialTextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinMaterialTextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33663Oo = 0;
        this.f33662IXxxXO = 0;
        this.f33664Oxx0xo = 0;
        this.f33667oI0IIXIo = 0;
        this.f33665OxxIIOOXO = 0;
        oIX0oI oix0oi = new oIX0oI(this);
        this.f33666XO = oix0oi;
        oix0oi.I0Io(attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, skin.support.design.R.styleable.TextInputLayout, i, skin.support.design.R.style.Widget_Design_TextInputLayout);
        int i2 = skin.support.design.R.styleable.TextInputLayout_android_textColorHint;
        if (obtainStyledAttributes.hasValue(i2)) {
            int resourceId = obtainStyledAttributes.getResourceId(i2, 0);
            this.f33667oI0IIXIo = resourceId;
            this.f33665OxxIIOOXO = resourceId;
            X0o0xo();
        }
        Oxx0IOOO(obtainStyledAttributes.getResourceId(skin.support.design.R.styleable.TextInputLayout_errorTextAppearance, 0));
        XO(obtainStyledAttributes.getResourceId(skin.support.design.R.styleable.TextInputLayout_counterTextAppearance, 0));
        this.f33663Oo = obtainStyledAttributes.getResourceId(skin.support.design.R.styleable.TextInputLayout_passwordToggleDrawable, 0);
        obtainStyledAttributes.recycle();
    }
}
