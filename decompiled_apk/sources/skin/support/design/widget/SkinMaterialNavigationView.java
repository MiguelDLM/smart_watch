package skin.support.design.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import androidx.annotation.DrawableRes;
import androidx.annotation.StyleRes;
import com.google.android.material.navigation.NavigationView;
import oIxOXo.II0XooXoX;
import oIxOXo.X0o0xo;
import oIxOXo.oxoX;
import xxoXO.I0Io;
import xxoXO.Oxx0IOOO;
import xxoXO.oIX0oI;

/* loaded from: classes6.dex */
public class SkinMaterialNavigationView extends NavigationView implements Oxx0IOOO {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f33654IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public int f33655Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f33656Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f33657XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public oIX0oI f33658oI0IIXIo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int[] f33653OxxIIOOXO = {R.attr.state_checked};

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int[] f33652IIXOooo = {-16842910};

    public SkinMaterialNavigationView(Context context) {
        this(context, null);
    }

    private void I0Io() {
        int II0xO02 = I0Io.II0xO0(this.f33656Oxx0xo);
        this.f33656Oxx0xo = II0xO02;
        if (II0xO02 != 0) {
            setItemIconTintList(oxoX.X0o0xo(getContext(), this.f33656Oxx0xo));
            return;
        }
        int II0xO03 = I0Io.II0xO0(this.f33654IXxxXO);
        this.f33654IXxxXO = II0xO03;
        if (II0xO03 != 0) {
            setItemIconTintList(createDefaultColorStateList(R.attr.textColorSecondary));
        }
    }

    private ColorStateList createDefaultColorStateList(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList X0o0xo2 = oxoX.X0o0xo(getContext(), typedValue.resourceId);
        int I0Io2 = oxoX.I0Io(getContext(), this.f33654IXxxXO);
        int defaultColor = X0o0xo2.getDefaultColor();
        int[] iArr = f33652IIXOooo;
        return new ColorStateList(new int[][]{iArr, f33653OxxIIOOXO, FrameLayout.EMPTY_STATE_SET}, new int[]{X0o0xo2.getColorForState(iArr, defaultColor), I0Io2, defaultColor});
    }

    private void oxoX() {
        int II0xO02 = I0Io.II0xO0(this.f33655Oo);
        this.f33655Oo = II0xO02;
        if (II0xO02 != 0) {
            setItemTextColor(oxoX.X0o0xo(getContext(), this.f33655Oo));
            return;
        }
        int II0xO03 = I0Io.II0xO0(this.f33654IXxxXO);
        this.f33654IXxxXO = II0xO03;
        if (II0xO03 != 0) {
            setItemTextColor(createDefaultColorStateList(R.attr.textColorPrimary));
        }
    }

    public final void II0xO0() {
        Drawable oIX0oI2;
        int II0xO02 = I0Io.II0xO0(this.f33657XO);
        this.f33657XO = II0xO02;
        if (II0xO02 != 0 && (oIX0oI2 = II0XooXoX.oIX0oI(getContext(), this.f33657XO)) != null) {
            setItemBackground(oIX0oI2);
        }
    }

    @Override // xxoXO.Oxx0IOOO
    public void applySkin() {
        oIX0oI oix0oi = this.f33658oI0IIXIo;
        if (oix0oi != null) {
            oix0oi.oIX0oI();
        }
        I0Io();
        oxoX();
        II0xO0();
    }

    @Override // com.google.android.material.navigation.NavigationView
    public void setItemBackgroundResource(@DrawableRes int i) {
        super.setItemBackgroundResource(i);
        this.f33657XO = i;
        II0xO0();
    }

    @Override // com.google.android.material.navigation.NavigationView
    public void setItemTextAppearance(@StyleRes int i) {
        super.setItemTextAppearance(i);
        if (i != 0) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, skin.support.design.R.styleable.SkinTextAppearance);
            int i2 = skin.support.design.R.styleable.SkinTextAppearance_android_textColor;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.f33655Oo = obtainStyledAttributes.getResourceId(i2, 0);
            }
            obtainStyledAttributes.recycle();
            oxoX();
        }
    }

    public SkinMaterialNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinMaterialNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int resourceId;
        this.f33657XO = 0;
        this.f33655Oo = 0;
        this.f33654IXxxXO = 0;
        this.f33656Oxx0xo = 0;
        oIX0oI oix0oi = new oIX0oI(this);
        this.f33658oI0IIXIo = oix0oi;
        oix0oi.I0Io(attributeSet, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, skin.support.design.R.styleable.NavigationView, i, skin.support.design.R.style.Widget_Design_NavigationView);
        int i2 = skin.support.design.R.styleable.NavigationView_itemIconTint;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.f33656Oxx0xo = obtainStyledAttributes.getResourceId(i2, 0);
        } else {
            this.f33654IXxxXO = oIxOXo.Oxx0IOOO.I0Io(context);
        }
        int i3 = skin.support.design.R.styleable.NavigationView_itemTextAppearance;
        if (obtainStyledAttributes.hasValue(i3) && (resourceId = obtainStyledAttributes.getResourceId(i3, 0)) != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, skin.support.design.R.styleable.SkinTextAppearance);
            int i4 = skin.support.design.R.styleable.SkinTextAppearance_android_textColor;
            if (obtainStyledAttributes2.hasValue(i4)) {
                this.f33655Oo = obtainStyledAttributes2.getResourceId(i4, 0);
            }
            obtainStyledAttributes2.recycle();
        }
        int i5 = skin.support.design.R.styleable.NavigationView_itemTextColor;
        if (obtainStyledAttributes.hasValue(i5)) {
            this.f33655Oo = obtainStyledAttributes.getResourceId(i5, 0);
        } else {
            this.f33654IXxxXO = oIxOXo.Oxx0IOOO.I0Io(context);
        }
        if (this.f33655Oo == 0) {
            this.f33655Oo = X0o0xo.I0Io(context);
        }
        this.f33657XO = obtainStyledAttributes.getResourceId(skin.support.design.R.styleable.NavigationView_itemBackground, 0);
        obtainStyledAttributes.recycle();
        I0Io();
        oxoX();
        II0xO0();
    }
}
