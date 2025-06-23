package skin.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import skin.support.design.R;
import xxoXO.I0Io;
import xxoXO.Oxx0IOOO;
import xxoXO.oxoX;

/* loaded from: classes6.dex */
public class SkinMaterialFloatingActionButton extends FloatingActionButton implements Oxx0IOOO {
    private int mBackgroundTintResId;
    private oxoX mImageHelper;
    private int mRippleColorResId;

    public SkinMaterialFloatingActionButton(Context context) {
        this(context, null);
    }

    private void applyBackgroundTintResource() {
        int II0xO02 = I0Io.II0xO0(this.mBackgroundTintResId);
        this.mBackgroundTintResId = II0xO02;
        if (II0xO02 != 0) {
            setBackgroundTintList(oIxOXo.oxoX.X0o0xo(getContext(), this.mBackgroundTintResId));
        }
    }

    private void applyRippleColorResource() {
        int II0xO02 = I0Io.II0xO0(this.mRippleColorResId);
        this.mRippleColorResId = II0xO02;
        if (II0xO02 != 0) {
            setRippleColor(oIxOXo.oxoX.I0Io(getContext(), this.mRippleColorResId));
        }
    }

    @Override // xxoXO.Oxx0IOOO
    public void applySkin() {
        applyBackgroundTintResource();
        applyRippleColorResource();
        oxoX oxox = this.mImageHelper;
        if (oxox != null) {
            oxox.oIX0oI();
        }
    }

    public SkinMaterialFloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinMaterialFloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRippleColorResId = 0;
        this.mBackgroundTintResId = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton, i, R.style.Widget_Design_FloatingActionButton);
        this.mBackgroundTintResId = obtainStyledAttributes.getResourceId(R.styleable.FloatingActionButton_backgroundTint, 0);
        this.mRippleColorResId = obtainStyledAttributes.getResourceId(R.styleable.FloatingActionButton_rippleColor, 0);
        obtainStyledAttributes.recycle();
        applyBackgroundTintResource();
        applyRippleColorResource();
        oxoX oxox = new oxoX(this);
        this.mImageHelper = oxox;
        oxox.I0Io(attributeSet, i);
    }
}
