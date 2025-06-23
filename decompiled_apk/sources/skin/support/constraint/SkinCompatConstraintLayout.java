package skin.support.constraint;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import xxoXO.Oxx0IOOO;
import xxoXO.oIX0oI;

/* loaded from: classes6.dex */
public class SkinCompatConstraintLayout extends ConstraintLayout implements Oxx0IOOO {
    private final oIX0oI mBackgroundTintHelper;

    public SkinCompatConstraintLayout(Context context) {
        this(context, null);
    }

    @Override // xxoXO.Oxx0IOOO
    public void applySkin() {
        oIX0oI oix0oi = this.mBackgroundTintHelper;
        if (oix0oi != null) {
            oix0oi.oIX0oI();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        oIX0oI oix0oi = this.mBackgroundTintHelper;
        if (oix0oi != null) {
            oix0oi.oxoX(i);
        }
    }

    public SkinCompatConstraintLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinCompatConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        oIX0oI oix0oi = new oIX0oI(this);
        this.mBackgroundTintHelper = oix0oi;
        oix0oi.I0Io(attributeSet, i);
    }
}
