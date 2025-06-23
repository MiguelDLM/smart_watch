package skin.support.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import xxoXO.Oxx0IOOO;
import xxoXO.X0o0xo;

/* loaded from: classes6.dex */
public class SkinCompatProgressBar extends ProgressBar implements Oxx0IOOO {

    /* renamed from: XO, reason: collision with root package name */
    public X0o0xo f33670XO;

    public SkinCompatProgressBar(Context context) {
        this(context, null);
    }

    @Override // xxoXO.Oxx0IOOO
    public void applySkin() {
        X0o0xo x0o0xo = this.f33670XO;
        if (x0o0xo != null) {
            x0o0xo.oIX0oI();
        }
    }

    public SkinCompatProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.progressBarStyle);
    }

    public SkinCompatProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        X0o0xo x0o0xo = new X0o0xo(this);
        this.f33670XO = x0o0xo;
        x0o0xo.X0o0xo(attributeSet, i);
    }
}
