package xxoXO;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.core.widget.CompoundButtonCompat;
import skin.support.appcompat.R;

/* loaded from: classes6.dex */
public class II0xO0 extends I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public final CompoundButton f35534I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f35536oxoX = 0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f35535X0o0xo = 0;

    public II0xO0(CompoundButton compoundButton) {
        this.f35534I0Io = compoundButton;
        oIxOXo.oxoX.f31821II0XooXoX = compoundButton.isInEditMode();
    }

    public void I0Io(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f35534I0Io.getContext().obtainStyledAttributes(attributeSet, R.styleable.CompoundButton, i, 0);
        try {
            int i2 = R.styleable.CompoundButton_android_button;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.f35536oxoX = obtainStyledAttributes.getResourceId(i2, 0);
            }
            int i3 = R.styleable.CompoundButton_buttonTint;
            if (obtainStyledAttributes.hasValue(i3)) {
                this.f35535X0o0xo = obtainStyledAttributes.getResourceId(i3, 0);
            }
            obtainStyledAttributes.recycle();
            oIX0oI();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // xxoXO.I0Io
    public void oIX0oI() {
        int II0xO02 = I0Io.II0xO0(this.f35536oxoX);
        this.f35536oxoX = II0xO02;
        if (II0xO02 != 0) {
            CompoundButton compoundButton = this.f35534I0Io;
            compoundButton.setButtonDrawable(oIxOXo.II0XooXoX.oIX0oI(compoundButton.getContext(), this.f35536oxoX));
        }
        int II0xO03 = I0Io.II0xO0(this.f35535X0o0xo);
        this.f35535X0o0xo = II0xO03;
        if (II0xO03 != 0) {
            CompoundButton compoundButton2 = this.f35534I0Io;
            CompoundButtonCompat.setButtonTintList(compoundButton2, oIxOXo.oxoX.X0o0xo(compoundButton2.getContext(), this.f35535X0o0xo));
        }
    }

    public void oxoX(int i) {
        this.f35536oxoX = i;
        oIX0oI();
    }
}
