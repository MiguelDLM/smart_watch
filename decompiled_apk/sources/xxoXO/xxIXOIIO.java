package xxoXO;

import android.annotation.TargetApi;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;
import skin.support.R;

@RequiresApi(17)
@TargetApi(17)
/* loaded from: classes6.dex */
public class xxIXOIIO extends II0XooXoX {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f35551OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f35552oOoXoXO;

    public xxIXOIIO(TextView textView) {
        super(textView);
        this.f35551OOXIXo = 0;
        this.f35552oOoXoXO = 0;
    }

    @Override // xxoXO.II0XooXoX
    public void I0Io() {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        int II0xO02 = I0Io.II0xO0(this.f35529Oxx0IOOO);
        this.f35529Oxx0IOOO = II0xO02;
        Drawable drawable6 = null;
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
        } else {
            drawable4 = null;
        }
        if (this.f35551OOXIXo != 0) {
            drawable5 = oIxOXo.II0XooXoX.oIX0oI(this.f35527I0Io.getContext(), this.f35551OOXIXo);
        } else {
            drawable5 = null;
        }
        if (drawable5 != null) {
            drawable = drawable5;
        }
        if (this.f35552oOoXoXO != 0) {
            drawable6 = oIxOXo.II0XooXoX.oIX0oI(this.f35527I0Io.getContext(), this.f35552oOoXoXO);
        }
        if (drawable6 != null) {
            drawable3 = drawable6;
        }
        if (this.f35529Oxx0IOOO != 0 || this.f35533xxIXOIIO != 0 || this.f35528II0XooXoX != 0 || this.f35531XO != 0 || this.f35551OOXIXo != 0 || this.f35552oOoXoXO != 0) {
            this.f35527I0Io.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    @Override // xxoXO.II0XooXoX
    public void xoIox(@DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        this.f35551OOXIXo = i;
        this.f35533xxIXOIIO = i2;
        this.f35552oOoXoXO = i3;
        this.f35531XO = i4;
        I0Io();
    }

    @Override // xxoXO.II0XooXoX
    public void xxIXOIIO(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f35527I0Io.getContext().obtainStyledAttributes(attributeSet, R.styleable.SkinCompatTextHelper, i, 0);
        int i2 = R.styleable.SkinCompatTextHelper_android_drawableStart;
        if (obtainStyledAttributes.hasValue(i2)) {
            int resourceId = obtainStyledAttributes.getResourceId(i2, 0);
            this.f35551OOXIXo = resourceId;
            this.f35551OOXIXo = I0Io.II0xO0(resourceId);
        }
        int i3 = R.styleable.SkinCompatTextHelper_android_drawableEnd;
        if (obtainStyledAttributes.hasValue(i3)) {
            int resourceId2 = obtainStyledAttributes.getResourceId(i3, 0);
            this.f35552oOoXoXO = resourceId2;
            this.f35552oOoXoXO = I0Io.II0xO0(resourceId2);
        }
        obtainStyledAttributes.recycle();
        super.xxIXOIIO(attributeSet, i);
    }
}
