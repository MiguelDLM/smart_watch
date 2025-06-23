package skin.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import oIxOXo.II0XooXoX;
import skin.support.design.R;
import xxoXO.I0Io;
import xxoXO.Oxx0IOOO;
import xxoXO.oIX0oI;

/* loaded from: classes6.dex */
public class SkinMaterialCollapsingToolbarLayout extends CollapsingToolbarLayout implements Oxx0IOOO {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public oIX0oI f33649IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public int f33650Oo;

    /* renamed from: XO, reason: collision with root package name */
    public int f33651XO;

    public SkinMaterialCollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    public final void II0xO0() {
        Drawable oIX0oI2;
        int II0xO02 = I0Io.II0xO0(this.f33650Oo);
        this.f33650Oo = II0xO02;
        if (II0xO02 != 0 && (oIX0oI2 = II0XooXoX.oIX0oI(getContext(), this.f33650Oo)) != null) {
            setStatusBarScrim(oIX0oI2);
        }
    }

    @Override // xxoXO.Oxx0IOOO
    public void applySkin() {
        oIX0oI();
        II0xO0();
        oIX0oI oix0oi = this.f33649IXxxXO;
        if (oix0oi != null) {
            oix0oi.oIX0oI();
        }
    }

    public final void oIX0oI() {
        Drawable oIX0oI2;
        int II0xO02 = I0Io.II0xO0(this.f33651XO);
        this.f33651XO = II0xO02;
        if (II0xO02 != 0 && (oIX0oI2 = II0XooXoX.oIX0oI(getContext(), this.f33651XO)) != null) {
            setContentScrim(oIX0oI2);
        }
    }

    public SkinMaterialCollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinMaterialCollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33651XO = 0;
        this.f33650Oo = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout, i, R.style.Widget_Design_CollapsingToolbar);
        this.f33651XO = obtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_contentScrim, 0);
        this.f33650Oo = obtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_statusBarScrim, 0);
        obtainStyledAttributes.recycle();
        oIX0oI();
        II0xO0();
        oIX0oI oix0oi = new oIX0oI(this);
        this.f33649IXxxXO = oix0oi;
        oix0oi.I0Io(attributeSet, 0);
    }
}
