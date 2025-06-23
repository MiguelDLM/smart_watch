package skin.support.design.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import oIxOXo.oxoX;
import xxoXO.I0Io;
import xxoXO.Oxx0IOOO;
import xxoXO.oIX0oI;

/* loaded from: classes6.dex */
public class SkinMaterialBottomNavigationView extends BottomNavigationView implements Oxx0IOOO {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f33645IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public int f33646Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f33647Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public oIX0oI f33648XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int[] f33644oI0IIXIo = {-16842910};

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int[] f33643OxxIIOOXO = {R.attr.state_checked};

    public SkinMaterialBottomNavigationView(@NonNull Context context) {
        this(context, null);
    }

    private ColorStateList I0Io(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList X0o0xo2 = oxoX.X0o0xo(getContext(), typedValue.resourceId);
        int I0Io2 = oxoX.I0Io(getContext(), this.f33647Oxx0xo);
        int defaultColor = X0o0xo2.getDefaultColor();
        int[] iArr = f33644oI0IIXIo;
        return new ColorStateList(new int[][]{iArr, f33643OxxIIOOXO, FrameLayout.EMPTY_STATE_SET}, new int[]{X0o0xo2.getColorForState(iArr, defaultColor), I0Io2, defaultColor});
    }

    public final void II0xO0() {
        int II0xO02 = I0Io.II0xO0(this.f33646Oo);
        this.f33646Oo = II0xO02;
        if (II0xO02 != 0) {
            setItemTextColor(oxoX.X0o0xo(getContext(), this.f33646Oo));
            return;
        }
        int II0xO03 = I0Io.II0xO0(this.f33647Oxx0xo);
        this.f33647Oxx0xo = II0xO03;
        if (II0xO03 != 0) {
            setItemTextColor(I0Io(R.attr.textColorSecondary));
        }
    }

    @Override // xxoXO.Oxx0IOOO
    public void applySkin() {
        oIX0oI oix0oi = this.f33648XO;
        if (oix0oi != null) {
            oix0oi.oIX0oI();
        }
        oIX0oI();
        II0xO0();
    }

    public final void oIX0oI() {
        int II0xO02 = I0Io.II0xO0(this.f33645IXxxXO);
        this.f33645IXxxXO = II0xO02;
        if (II0xO02 != 0) {
            setItemIconTintList(oxoX.X0o0xo(getContext(), this.f33645IXxxXO));
            return;
        }
        int II0xO03 = I0Io.II0xO0(this.f33647Oxx0xo);
        this.f33647Oxx0xo = II0xO03;
        if (II0xO03 != 0) {
            setItemIconTintList(I0Io(R.attr.textColorSecondary));
        }
    }

    public final int oxoX() {
        return 0;
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        oIX0oI oix0oi = this.f33648XO;
        if (oix0oi != null) {
            oix0oi.oxoX(i);
        }
    }

    public SkinMaterialBottomNavigationView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinMaterialBottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33646Oo = 0;
        this.f33645IXxxXO = 0;
        this.f33647Oxx0xo = 0;
        oIX0oI oix0oi = new oIX0oI(this);
        this.f33648XO = oix0oi;
        oix0oi.I0Io(attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, skin.support.design.R.styleable.BottomNavigationView, i, skin.support.design.R.style.Widget_Design_BottomNavigationView);
        int i2 = skin.support.design.R.styleable.BottomNavigationView_itemIconTint;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.f33645IXxxXO = obtainStyledAttributes.getResourceId(i2, 0);
        } else {
            this.f33647Oxx0xo = oxoX();
        }
        int i3 = skin.support.design.R.styleable.BottomNavigationView_itemTextColor;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.f33646Oo = obtainStyledAttributes.getResourceId(i3, 0);
        } else {
            this.f33647Oxx0xo = oxoX();
        }
        obtainStyledAttributes.recycle();
        oIX0oI();
        II0xO0();
    }
}
