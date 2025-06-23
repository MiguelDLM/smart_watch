package oIxOXo;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.content.res.AppCompatResources;

/* loaded from: classes6.dex */
public class II0XooXoX implements xxIXOIIO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static II0XooXoX f31739oIX0oI;

    public II0XooXoX() {
        oxoX.II0XooXoX().oIX0oI(this);
    }

    public static II0XooXoX II0xO0() {
        if (f31739oIX0oI == null) {
            synchronized (II0XooXoX.class) {
                try {
                    if (f31739oIX0oI == null) {
                        f31739oIX0oI = new II0XooXoX();
                    }
                } finally {
                }
            }
        }
        return f31739oIX0oI;
    }

    public static Drawable oIX0oI(Context context, int i) {
        return II0xO0().I0Io(context, i);
    }

    public final Drawable I0Io(Context context, int i) {
        int IXxxXO2;
        Drawable oI0IIXIo2;
        ColorStateList Oxx0xo2;
        Drawable oI0IIXIo3;
        ColorStateList Oxx0xo3;
        if (!oxoX.f31821II0XooXoX) {
            if (AppCompatDelegate.isCompatVectorFromResourcesEnabled()) {
                if (!oxoX.II0XooXoX().OxxIIOOXO()) {
                    try {
                        return II0xO0.oO().Oo(context, i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (!XO.x0XOIxOo().o00() && (Oxx0xo3 = XO.x0XOIxOo().Oxx0xo(i)) != null) {
                    return new ColorDrawable(Oxx0xo3.getDefaultColor());
                }
                if (!XO.x0XOIxOo().OxI() && (oI0IIXIo3 = XO.x0XOIxOo().oI0IIXIo(i)) != null) {
                    return oI0IIXIo3;
                }
                Drawable Oo2 = oxoX.II0XooXoX().Oo(context, i);
                if (Oo2 != null) {
                    return Oo2;
                }
                return AppCompatResources.getDrawable(context, i);
            }
            if (!XO.x0XOIxOo().o00() && (Oxx0xo2 = XO.x0XOIxOo().Oxx0xo(i)) != null) {
                return new ColorDrawable(Oxx0xo2.getDefaultColor());
            }
            if (!XO.x0XOIxOo().OxI() && (oI0IIXIo2 = XO.x0XOIxOo().oI0IIXIo(i)) != null) {
                return oI0IIXIo2;
            }
            Drawable Oo3 = oxoX.II0XooXoX().Oo(context, i);
            if (Oo3 != null) {
                return Oo3;
            }
            if (!oxoX.II0XooXoX().OxxIIOOXO() && (IXxxXO2 = oxoX.II0XooXoX().IXxxXO(context, i)) != 0) {
                return oxoX.II0XooXoX().ooOOo0oXI().getDrawable(IXxxXO2, null);
            }
            return AppCompatResources.getDrawable(context, i);
        }
        return AppCompatResources.getDrawable(context, i);
    }

    @Override // oIxOXo.xxIXOIIO
    public void clear() {
        II0xO0.oO().XO();
    }
}
