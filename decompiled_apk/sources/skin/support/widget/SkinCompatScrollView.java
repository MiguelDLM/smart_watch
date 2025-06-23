package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import androidx.annotation.DrawableRes;
import xxoXO.Oxx0IOOO;
import xxoXO.oIX0oI;

/* loaded from: classes6.dex */
public class SkinCompatScrollView extends ScrollView implements Oxx0IOOO {

    /* renamed from: XO, reason: collision with root package name */
    public oIX0oI f33673XO;

    public SkinCompatScrollView(Context context) {
        this(context, null);
    }

    @Override // xxoXO.Oxx0IOOO
    public void applySkin() {
        oIX0oI oix0oi = this.f33673XO;
        if (oix0oi != null) {
            oix0oi.oIX0oI();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        oIX0oI oix0oi = this.f33673XO;
        if (oix0oi != null) {
            oix0oi.oxoX(i);
        }
    }

    public SkinCompatScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinCompatScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        oIX0oI oix0oi = new oIX0oI(this);
        this.f33673XO = oix0oi;
        oix0oi.I0Io(attributeSet, i);
    }
}
