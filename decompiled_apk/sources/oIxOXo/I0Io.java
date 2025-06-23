package oIxOXo;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import androidx.annotation.NonNull;

/* loaded from: classes6.dex */
public class I0Io {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f31738oIX0oI = "android.graphics.drawable.VectorDrawable";

    public static void I0Io(Drawable drawable) {
        int[] state = drawable.getState();
        if (state != null && state.length != 0) {
            drawable.setState(X0o0xo.f31771oO);
        } else {
            drawable.setState(X0o0xo.f31772oOoXoXO);
        }
        drawable.setState(state);
    }

    public static void II0xO0(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            I0Io(drawable);
        }
    }

    public static boolean oIX0oI(@NonNull Drawable drawable) {
        Drawable drawable2;
        if (drawable instanceof DrawableContainer) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState instanceof DrawableContainer.DrawableContainerState) {
                for (Drawable drawable3 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                    if (!oIX0oI(drawable3)) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        if (oX0O.XO.Oxx0IOOO(drawable)) {
            return oIX0oI(oX0O.XO.oIX0oI(drawable));
        }
        if (oX0O.XO.II0XooXoX(drawable)) {
            return oIX0oI(oX0O.XO.II0xO0(drawable));
        }
        if (oX0O.XO.xxIXOIIO(drawable)) {
            return oIX0oI(oX0O.XO.I0Io(drawable));
        }
        if ((drawable instanceof ScaleDrawable) && (drawable2 = ((ScaleDrawable) drawable).getDrawable()) != null) {
            return oIX0oI(drawable2);
        }
        return true;
    }
}
