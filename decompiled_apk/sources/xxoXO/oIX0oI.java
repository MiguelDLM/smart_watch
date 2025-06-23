package xxoXO;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import skin.support.R;

/* loaded from: classes6.dex */
public class oIX0oI extends I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public final View f35544I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f35545oxoX = 0;

    public oIX0oI(View view) {
        this.f35544I0Io = view;
        oIxOXo.oxoX.f31821II0XooXoX = view.isInEditMode();
    }

    public void I0Io(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f35544I0Io.getContext().obtainStyledAttributes(attributeSet, R.styleable.SkinBackgroundHelper, i, 0);
        try {
            int i2 = R.styleable.SkinBackgroundHelper_android_background;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.f35545oxoX = obtainStyledAttributes.getResourceId(i2, 0);
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
        Drawable oIX0oI2;
        int II0xO02 = I0Io.II0xO0(this.f35545oxoX);
        this.f35545oxoX = II0xO02;
        if (II0xO02 != 0 && (oIX0oI2 = oIxOXo.II0XooXoX.oIX0oI(this.f35544I0Io.getContext(), this.f35545oxoX)) != null) {
            int paddingLeft = this.f35544I0Io.getPaddingLeft();
            int paddingTop = this.f35544I0Io.getPaddingTop();
            int paddingRight = this.f35544I0Io.getPaddingRight();
            int paddingBottom = this.f35544I0Io.getPaddingBottom();
            ViewCompat.setBackground(this.f35544I0Io, oIX0oI2);
            this.f35544I0Io.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void oxoX(int i) {
        this.f35545oxoX = i;
        oIX0oI();
    }
}
