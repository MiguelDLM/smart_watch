package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import skin.support.appcompat.R;
import xxoXO.Oxx0IOOO;
import xxoXO.XO;

/* loaded from: classes6.dex */
public class SkinCompatSeekBar extends AppCompatSeekBar implements Oxx0IOOO {
    private XO mSkinCompatSeekBarHelper;

    public SkinCompatSeekBar(Context context) {
        this(context, null);
    }

    @Override // xxoXO.Oxx0IOOO
    public void applySkin() {
        XO xo2 = this.mSkinCompatSeekBarHelper;
        if (xo2 != null) {
            xo2.oIX0oI();
        }
    }

    public SkinCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarStyle);
    }

    public SkinCompatSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        XO xo2 = new XO(this);
        this.mSkinCompatSeekBarHelper = xo2;
        xo2.X0o0xo(attributeSet, i);
    }
}
