package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioGroup;
import xxoXO.Oxx0IOOO;
import xxoXO.oIX0oI;

/* loaded from: classes6.dex */
public class SkinCompatRadioGroup extends RadioGroup implements Oxx0IOOO {

    /* renamed from: XO, reason: collision with root package name */
    public oIX0oI f33671XO;

    public SkinCompatRadioGroup(Context context) {
        this(context, null);
    }

    @Override // xxoXO.Oxx0IOOO
    public void applySkin() {
        oIX0oI oix0oi = this.f33671XO;
        if (oix0oi != null) {
            oix0oi.oIX0oI();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        oIX0oI oix0oi = this.f33671XO;
        if (oix0oi != null) {
            oix0oi.oxoX(i);
        }
    }

    public SkinCompatRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        oIX0oI oix0oi = new oIX0oI(this);
        this.f33671XO = oix0oi;
        oix0oi.I0Io(attributeSet, 0);
    }
}
