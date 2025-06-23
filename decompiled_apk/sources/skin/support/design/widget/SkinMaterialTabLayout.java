package skin.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.tabs.TabLayout;
import oIxOXo.oxoX;
import skin.support.design.R;
import xxoXO.I0Io;
import xxoXO.Oxx0IOOO;

/* loaded from: classes6.dex */
public class SkinMaterialTabLayout extends TabLayout implements Oxx0IOOO {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f33659IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public int f33660Oo;

    /* renamed from: XO, reason: collision with root package name */
    public int f33661XO;

    public SkinMaterialTabLayout(Context context) {
        this(context, null);
    }

    @Override // xxoXO.Oxx0IOOO
    public void applySkin() {
        int II0xO02 = I0Io.II0xO0(this.f33661XO);
        this.f33661XO = II0xO02;
        if (II0xO02 != 0) {
            setSelectedTabIndicatorColor(oxoX.I0Io(getContext(), this.f33661XO));
        }
        int II0xO03 = I0Io.II0xO0(this.f33660Oo);
        this.f33660Oo = II0xO03;
        if (II0xO03 != 0) {
            setTabTextColors(oxoX.X0o0xo(getContext(), this.f33660Oo));
        }
        int II0xO04 = I0Io.II0xO0(this.f33659IXxxXO);
        this.f33659IXxxXO = II0xO04;
        if (II0xO04 != 0) {
            int I0Io2 = oxoX.I0Io(getContext(), this.f33659IXxxXO);
            if (getTabTextColors() != null) {
                setTabTextColors(getTabTextColors().getDefaultColor(), I0Io2);
            }
        }
    }

    public SkinMaterialTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinMaterialTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33661XO = 0;
        this.f33660Oo = 0;
        this.f33659IXxxXO = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TabLayout, i, 0);
        this.f33661XO = obtainStyledAttributes.getResourceId(R.styleable.TabLayout_tabIndicatorColor, 0);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(obtainStyledAttributes.getResourceId(R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab), R.styleable.SkinTextAppearance);
        try {
            this.f33660Oo = obtainStyledAttributes2.getResourceId(R.styleable.SkinTextAppearance_android_textColor, 0);
            obtainStyledAttributes2.recycle();
            int i2 = R.styleable.TabLayout_tabTextColor;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.f33660Oo = obtainStyledAttributes.getResourceId(i2, 0);
            }
            int i3 = R.styleable.TabLayout_tabSelectedTextColor;
            if (obtainStyledAttributes.hasValue(i3)) {
                this.f33659IXxxXO = obtainStyledAttributes.getResourceId(i3, 0);
            }
            obtainStyledAttributes.recycle();
            applySkin();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }
}
