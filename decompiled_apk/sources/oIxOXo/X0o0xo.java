package oIxOXo;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;

/* loaded from: classes6.dex */
public class X0o0xo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f31770oIX0oI = new ThreadLocal<>();

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int[] f31765II0xO0 = {-16842910};

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int[] f31763I0Io = {R.attr.state_enabled};

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int[] f31774oxoX = {R.attr.state_window_focused};

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int[] f31768X0o0xo = {R.attr.state_focused};

    /* renamed from: XO, reason: collision with root package name */
    public static final int[] f31769XO = {R.attr.state_activated};

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int[] f31767Oxx0IOOO = {R.attr.state_accelerated};

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int[] f31764II0XooXoX = {R.attr.state_hovered};

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int[] f31778xxIXOIIO = {R.attr.state_drag_can_accept};

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int[] f31777xoIox = {R.attr.state_drag_hovered};

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int[] f31766OOXIXo = {R.attr.state_pressed};

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int[] f31772oOoXoXO = {R.attr.state_checked};

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int[] f31773ooOOo0oXI = {R.attr.state_selected};

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int[] f31775x0XOIxOo = {-16842919, -16842908};

    /* renamed from: oO, reason: collision with root package name */
    public static final int[] f31771oO = new int[0];

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int[] f31776x0xO0oo = new int[1];

    public static int I0Io(Context context) {
        return II0xO0(context, new int[]{R.attr.textColorPrimary});
    }

    public static int II0XooXoX(Context context) {
        return II0xO0(context, new int[]{R.attr.windowBackground});
    }

    public static int II0xO0(Context context, int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static TypedValue Oxx0IOOO() {
        ThreadLocal<TypedValue> threadLocal = f31770oIX0oI;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    public static int X0o0xo(Context context, int i, float f) {
        return IxOIO.I0Io.oIX0oI(oxoX(context, i), Math.round(Color.alpha(r0) * f));
    }

    public static ColorStateList XO(Context context, int i) {
        int[] iArr = f31776x0xO0oo;
        iArr[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            if (resourceId == 0) {
                return null;
            }
            return oxoX.X0o0xo(context, resourceId);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int oIX0oI(Context context, int i) {
        ColorStateList XO2 = XO(context, i);
        if (XO2 != null && XO2.isStateful()) {
            return XO2.getColorForState(f31765II0xO0, XO2.getDefaultColor());
        }
        TypedValue Oxx0IOOO2 = Oxx0IOOO();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, Oxx0IOOO2, true);
        return X0o0xo(context, i, Oxx0IOOO2.getFloat());
    }

    public static int oxoX(Context context, int i) {
        int[] iArr = f31776x0xO0oo;
        iArr[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            if (resourceId == 0) {
                return 0;
            }
            return oxoX.I0Io(context, resourceId);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
