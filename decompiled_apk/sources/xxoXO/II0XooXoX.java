package xxoXO;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import skin.support.R;

/* loaded from: classes6.dex */
public class II0XooXoX extends I0Io {

    /* renamed from: xoIox, reason: collision with root package name */
    public static final String f35526xoIox = "II0XooXoX";

    /* renamed from: I0Io, reason: collision with root package name */
    public final TextView f35527I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f35532oxoX = 0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f35530X0o0xo = 0;

    /* renamed from: XO, reason: collision with root package name */
    public int f35531XO = 0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f35529Oxx0IOOO = 0;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f35528II0XooXoX = 0;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f35533xxIXOIIO = 0;

    public II0XooXoX(TextView textView) {
        this.f35527I0Io = textView;
        oIxOXo.oxoX.f31821II0XooXoX = textView.isInEditMode();
    }

    public static II0XooXoX Oxx0IOOO(TextView textView) {
        return new xxIXOIIO(textView);
    }

    public void I0Io() {
        oxoX();
    }

    public int II0XooXoX() {
        return this.f35532oxoX;
    }

    public void OOXIXo(@DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        this.f35529Oxx0IOOO = i;
        this.f35533xxIXOIIO = i2;
        this.f35528II0XooXoX = i3;
        this.f35531XO = i4;
        oxoX();
    }

    public final void X0o0xo() {
        int II0xO02 = I0Io.II0xO0(this.f35530X0o0xo);
        this.f35530X0o0xo = II0xO02;
        if (II0xO02 != 0) {
            try {
                this.f35527I0Io.setHintTextColor(oIxOXo.oxoX.X0o0xo(this.f35527I0Io.getContext(), this.f35530X0o0xo));
            } catch (Exception unused) {
            }
        }
    }

    public final void XO() {
        int II0xO02 = I0Io.II0xO0(this.f35532oxoX);
        this.f35532oxoX = II0xO02;
        if (II0xO02 != 0) {
            try {
                this.f35527I0Io.setTextColor(oIxOXo.oxoX.X0o0xo(this.f35527I0Io.getContext(), this.f35532oxoX));
            } catch (Exception unused) {
            }
        }
    }

    @Override // xxoXO.I0Io
    public void oIX0oI() {
        I0Io();
        XO();
        X0o0xo();
    }

    public void oOoXoXO(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.SkinTextAppearance);
        int i2 = R.styleable.SkinTextAppearance_android_textColor;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.f35532oxoX = obtainStyledAttributes.getResourceId(i2, 0);
        }
        int i3 = R.styleable.SkinTextAppearance_android_textColorHint;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.f35530X0o0xo = obtainStyledAttributes.getResourceId(i3, 0);
        }
        obtainStyledAttributes.recycle();
        XO();
        X0o0xo();
    }

    public void oxoX() {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        int II0xO02 = I0Io.II0xO0(this.f35529Oxx0IOOO);
        this.f35529Oxx0IOOO = II0xO02;
        Drawable drawable4 = null;
        if (II0xO02 != 0) {
            drawable = oIxOXo.II0XooXoX.oIX0oI(this.f35527I0Io.getContext(), this.f35529Oxx0IOOO);
        } else {
            drawable = null;
        }
        int II0xO03 = I0Io.II0xO0(this.f35533xxIXOIIO);
        this.f35533xxIXOIIO = II0xO03;
        if (II0xO03 != 0) {
            drawable2 = oIxOXo.II0XooXoX.oIX0oI(this.f35527I0Io.getContext(), this.f35533xxIXOIIO);
        } else {
            drawable2 = null;
        }
        int II0xO04 = I0Io.II0xO0(this.f35528II0XooXoX);
        this.f35528II0XooXoX = II0xO04;
        if (II0xO04 != 0) {
            drawable3 = oIxOXo.II0XooXoX.oIX0oI(this.f35527I0Io.getContext(), this.f35528II0XooXoX);
        } else {
            drawable3 = null;
        }
        int II0xO05 = I0Io.II0xO0(this.f35531XO);
        this.f35531XO = II0xO05;
        if (II0xO05 != 0) {
            drawable4 = oIxOXo.II0XooXoX.oIX0oI(this.f35527I0Io.getContext(), this.f35531XO);
        }
        if (this.f35529Oxx0IOOO != 0 || this.f35533xxIXOIIO != 0 || this.f35528II0XooXoX != 0 || this.f35531XO != 0) {
            this.f35527I0Io.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    public void xoIox(@DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        this.f35529Oxx0IOOO = i;
        this.f35533xxIXOIIO = i2;
        this.f35528II0XooXoX = i3;
        this.f35531XO = i4;
        I0Io();
    }

    public void xxIXOIIO(AttributeSet attributeSet, int i) {
        Context context = this.f35527I0Io.getContext();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SkinCompatTextHelper, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SkinCompatTextHelper_android_textAppearance, 0);
        int i2 = R.styleable.SkinCompatTextHelper_android_drawableLeft;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.f35529Oxx0IOOO = obtainStyledAttributes.getResourceId(i2, 0);
        }
        int i3 = R.styleable.SkinCompatTextHelper_android_drawableTop;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.f35533xxIXOIIO = obtainStyledAttributes.getResourceId(i3, 0);
        }
        int i4 = R.styleable.SkinCompatTextHelper_android_drawableRight;
        if (obtainStyledAttributes.hasValue(i4)) {
            this.f35528II0XooXoX = obtainStyledAttributes.getResourceId(i4, 0);
        }
        int i5 = R.styleable.SkinCompatTextHelper_android_drawableBottom;
        if (obtainStyledAttributes.hasValue(i5)) {
            this.f35531XO = obtainStyledAttributes.getResourceId(i5, 0);
        }
        obtainStyledAttributes.recycle();
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, R.styleable.SkinTextAppearance);
            int i6 = R.styleable.SkinTextAppearance_android_textColor;
            if (obtainStyledAttributes2.hasValue(i6)) {
                this.f35532oxoX = obtainStyledAttributes2.getResourceId(i6, 0);
            }
            int i7 = R.styleable.SkinTextAppearance_android_textColorHint;
            if (obtainStyledAttributes2.hasValue(i7)) {
                this.f35530X0o0xo = obtainStyledAttributes2.getResourceId(i7, 0);
            }
            obtainStyledAttributes2.recycle();
        }
        TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, R.styleable.SkinTextAppearance, i, 0);
        int i8 = R.styleable.SkinTextAppearance_android_textColor;
        if (obtainStyledAttributes3.hasValue(i8)) {
            this.f35532oxoX = obtainStyledAttributes3.getResourceId(i8, 0);
        }
        int i9 = R.styleable.SkinTextAppearance_android_textColorHint;
        if (obtainStyledAttributes3.hasValue(i9)) {
            this.f35530X0o0xo = obtainStyledAttributes3.getResourceId(i9, 0);
        }
        obtainStyledAttributes3.recycle();
        oIX0oI();
    }
}
