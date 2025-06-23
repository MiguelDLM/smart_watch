package xxx;

import IIXOxIxOo.I0Io;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import oX0O.II0XooXoX;

/* loaded from: classes6.dex */
public abstract class XO implements I0Io.InterfaceC0010I0Io {
    @Override // IIXOxIxOo.I0Io.InterfaceC0010I0Io
    public Drawable I0Io(Context context, String str, int i) {
        return null;
    }

    @Override // IIXOxIxOo.I0Io.InterfaceC0010I0Io
    public ColorStateList II0xO0(Context context, String str, int i) {
        return null;
    }

    @Override // IIXOxIxOo.I0Io.InterfaceC0010I0Io
    public ColorStateList X0o0xo(Context context, String str, int i) {
        return null;
    }

    public abstract String XO(Context context, String str);

    @Override // IIXOxIxOo.I0Io.InterfaceC0010I0Io
    public String oIX0oI(Context context, String str, int i) {
        return null;
    }

    @Override // IIXOxIxOo.I0Io.InterfaceC0010I0Io
    public String oxoX(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String XO2 = XO(context, str);
        if (II0XooXoX.I0Io(XO2)) {
            String Oxx0xo2 = IIXOxIxOo.I0Io.IXxxXO().Oxx0xo(XO2);
            Resources oI0IIXIo2 = IIXOxIxOo.I0Io.IXxxXO().oI0IIXIo(XO2);
            if (oI0IIXIo2 != null && !TextUtils.isEmpty(Oxx0xo2)) {
                oIxOXo.oxoX.II0XooXoX().o00(oI0IIXIo2, Oxx0xo2, str, this);
                return str;
            }
            return null;
        }
        return null;
    }
}
