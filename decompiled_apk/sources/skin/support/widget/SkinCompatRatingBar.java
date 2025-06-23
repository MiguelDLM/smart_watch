package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRatingBar;
import skin.support.appcompat.R;
import xxoXO.Oxx0IOOO;
import xxoXO.X0o0xo;

/* loaded from: classes6.dex */
public class SkinCompatRatingBar extends AppCompatRatingBar implements Oxx0IOOO {
    private X0o0xo mSkinCompatProgressBarHelper;

    public SkinCompatRatingBar(Context context) {
        this(context, null);
    }

    @Override // xxoXO.Oxx0IOOO
    public void applySkin() {
        X0o0xo x0o0xo = this.mSkinCompatProgressBarHelper;
        if (x0o0xo != null) {
            x0o0xo.oIX0oI();
        }
    }

    public SkinCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ratingBarStyle);
    }

    public SkinCompatRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        X0o0xo x0o0xo = new X0o0xo(this);
        this.mSkinCompatProgressBarHelper = x0o0xo;
        x0o0xo.X0o0xo(attributeSet, i);
    }
}
