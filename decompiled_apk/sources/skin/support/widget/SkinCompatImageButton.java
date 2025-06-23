package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatImageButton;
import xxoXO.Oxx0IOOO;
import xxoXO.oIX0oI;
import xxoXO.oxoX;

/* loaded from: classes6.dex */
public class SkinCompatImageButton extends AppCompatImageButton implements Oxx0IOOO {
    private oIX0oI mBackgroundTintHelper;
    private oxoX mImageHelper;

    public SkinCompatImageButton(Context context) {
        this(context, null);
    }

    public void applySkin() {
        oIX0oI oix0oi = this.mBackgroundTintHelper;
        if (oix0oi != null) {
            oix0oi.oIX0oI();
        }
        oxoX oxox = this.mImageHelper;
        if (oxox != null) {
            oxox.oIX0oI();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        oIX0oI oix0oi = this.mBackgroundTintHelper;
        if (oix0oi != null) {
            oix0oi.oxoX(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageResource(@DrawableRes int i) {
        oxoX oxox = this.mImageHelper;
        if (oxox != null) {
            oxox.oxoX(i);
        }
    }

    public SkinCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageButtonStyle);
    }

    public SkinCompatImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        oIX0oI oix0oi = new oIX0oI(this);
        this.mBackgroundTintHelper = oix0oi;
        oix0oi.I0Io(attributeSet, i);
        oxoX oxox = new oxoX(this);
        this.mImageHelper = oxox;
        oxox.I0Io(attributeSet, i);
    }
}
