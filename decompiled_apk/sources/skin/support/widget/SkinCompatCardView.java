package skin.support.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;
import oIxOXo.oxoX;
import xxoXO.I0Io;
import xxoXO.Oxx0IOOO;

/* loaded from: classes6.dex */
public class SkinCompatCardView extends CardView implements Oxx0IOOO {
    private static final int[] COLOR_BACKGROUND_ATTR = {R.attr.colorBackground};
    private int mBackgroundColorResId;
    private int mThemeColorBackgroundResId;

    public SkinCompatCardView(Context context) {
        this(context, null);
    }

    private void applyBackgroundColorResource() {
        int color;
        this.mBackgroundColorResId = I0Io.II0xO0(this.mBackgroundColorResId);
        int II0xO02 = I0Io.II0xO0(this.mThemeColorBackgroundResId);
        this.mThemeColorBackgroundResId = II0xO02;
        if (this.mBackgroundColorResId != 0) {
            setCardBackgroundColor(oxoX.X0o0xo(getContext(), this.mBackgroundColorResId));
            return;
        }
        if (II0xO02 != 0) {
            float[] fArr = new float[3];
            Color.colorToHSV(oxoX.I0Io(getContext(), this.mThemeColorBackgroundResId), fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(skin.support.cardview.R.color.cardview_light_background);
            } else {
                color = getResources().getColor(skin.support.cardview.R.color.cardview_dark_background);
            }
            setCardBackgroundColor(ColorStateList.valueOf(color));
        }
    }

    @Override // xxoXO.Oxx0IOOO
    public void applySkin() {
        applyBackgroundColorResource();
    }

    public SkinCompatCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinCompatCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mThemeColorBackgroundResId = 0;
        this.mBackgroundColorResId = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, skin.support.cardview.R.styleable.CardView, i, skin.support.cardview.R.style.CardView);
        int i2 = skin.support.cardview.R.styleable.CardView_cardBackgroundColor;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.mBackgroundColorResId = obtainStyledAttributes.getResourceId(i2, 0);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            this.mThemeColorBackgroundResId = obtainStyledAttributes2.getResourceId(0, 0);
            obtainStyledAttributes2.recycle();
        }
        obtainStyledAttributes.recycle();
        applyBackgroundColorResource();
    }
}
