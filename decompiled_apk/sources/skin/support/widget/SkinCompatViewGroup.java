package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import xxoXO.Oxx0IOOO;
import xxoXO.oIX0oI;

/* loaded from: classes6.dex */
public abstract class SkinCompatViewGroup extends ViewGroup implements Oxx0IOOO {

    /* renamed from: XO, reason: collision with root package name */
    public oIX0oI f33675XO;

    public SkinCompatViewGroup(Context context) {
        this(context, null);
    }

    @Override // xxoXO.Oxx0IOOO
    public void applySkin() {
        oIX0oI oix0oi = this.f33675XO;
        if (oix0oi != null) {
            oix0oi.oIX0oI();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        oIX0oI oix0oi = this.f33675XO;
        if (oix0oi != null) {
            oix0oi.oxoX(i);
        }
    }

    public SkinCompatViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinCompatViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        oIX0oI oix0oi = new oIX0oI(this);
        this.f33675XO = oix0oi;
        oix0oi.I0Io(attributeSet, i);
    }
}
