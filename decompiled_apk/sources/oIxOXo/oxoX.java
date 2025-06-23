package oIxOXo;

import IIXOxIxOo.I0Io;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static boolean f31821II0XooXoX = false;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static volatile oxoX f31822Oxx0IOOO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Resources f31827oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public I0Io.InterfaceC0010I0Io f31828oxoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f31824II0xO0 = "";

    /* renamed from: I0Io, reason: collision with root package name */
    public String f31823I0Io = "";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f31825X0o0xo = true;

    /* renamed from: XO, reason: collision with root package name */
    public List<xxIXOIIO> f31826XO = new ArrayList();

    public static int I0Io(Context context, int i) {
        return II0XooXoX().xxIXOIIO(context, i);
    }

    public static oxoX II0XooXoX() {
        if (f31822Oxx0IOOO == null) {
            synchronized (oxoX.class) {
                try {
                    if (f31822Oxx0IOOO == null) {
                        f31822Oxx0IOOO = new oxoX();
                    }
                } finally {
                }
            }
        }
        return f31822Oxx0IOOO;
    }

    public static Drawable Oxx0IOOO(Context context, int i) {
        return II0XooXoX().OOXIXo(context, i);
    }

    public static void Oxx0xo(Context context, @IXo.I0Io int i, TypedValue typedValue, boolean z) {
        II0XooXoX().x0XOIxOo(context, i, typedValue, z);
    }

    public static ColorStateList X0o0xo(Context context, int i) {
        return II0XooXoX().xoIox(context, i);
    }

    public static XmlResourceParser oI0IIXIo(Context context, int i) {
        return II0XooXoX().oO(context, i);
    }

    @Deprecated
    public int II0xO0(int i) {
        return I0Io(IIXOxIxOo.I0Io.IXxxXO().x0XOIxOo(), i);
    }

    public void IIXOooo() {
        xoXoI(IIXOxIxOo.I0Io.IXxxXO().OxxIIOOXO().get(-1));
    }

    public int IXxxXO(Context context, int i) {
        String str;
        try {
            I0Io.InterfaceC0010I0Io interfaceC0010I0Io = this.f31828oxoX;
            if (interfaceC0010I0Io != null) {
                str = interfaceC0010I0Io.oIX0oI(context, this.f31823I0Io, i);
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                str = context.getResources().getResourceEntryName(i);
            }
            return this.f31827oIX0oI.getIdentifier(str, context.getResources().getResourceTypeName(i), this.f31824II0xO0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public final Drawable OOXIXo(Context context, int i) {
        int IXxxXO2;
        Drawable I0Io2;
        Drawable oI0IIXIo2;
        ColorStateList Oxx0xo2;
        if (!XO.x0XOIxOo().o00() && (Oxx0xo2 = XO.x0XOIxOo().Oxx0xo(i)) != null) {
            return new ColorDrawable(Oxx0xo2.getDefaultColor());
        }
        if (!XO.x0XOIxOo().OxI() && (oI0IIXIo2 = XO.x0XOIxOo().oI0IIXIo(i)) != null) {
            return oI0IIXIo2;
        }
        I0Io.InterfaceC0010I0Io interfaceC0010I0Io = this.f31828oxoX;
        if (interfaceC0010I0Io != null && (I0Io2 = interfaceC0010I0Io.I0Io(context, this.f31823I0Io, i)) != null) {
            return I0Io2;
        }
        if (!this.f31825X0o0xo && (IXxxXO2 = IXxxXO(context, i)) != 0) {
            return this.f31827oIX0oI.getDrawable(IXxxXO2, null);
        }
        return context.getResources().getDrawable(i, context.getTheme());
    }

    public Drawable Oo(Context context, int i) {
        I0Io.InterfaceC0010I0Io interfaceC0010I0Io = this.f31828oxoX;
        if (interfaceC0010I0Io != null) {
            return interfaceC0010I0Io.I0Io(context, this.f31823I0Io, i);
        }
        return null;
    }

    public boolean OxxIIOOXO() {
        return this.f31825X0o0xo;
    }

    @Deprecated
    public Drawable XO(int i) {
        return Oxx0IOOO(IIXOxIxOo.I0Io.IXxxXO().x0XOIxOo(), i);
    }

    public void o00(Resources resources, String str, String str2, I0Io.InterfaceC0010I0Io interfaceC0010I0Io) {
        if (resources != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.f31827oIX0oI = resources;
            this.f31824II0xO0 = str;
            this.f31823I0Io = str2;
            this.f31828oxoX = interfaceC0010I0Io;
            this.f31825X0o0xo = false;
            XO.x0XOIxOo().xxIXOIIO();
            Iterator<xxIXOIIO> it = this.f31826XO.iterator();
            while (it.hasNext()) {
                it.next().clear();
            }
            return;
        }
        xoXoI(interfaceC0010I0Io);
    }

    public void oIX0oI(xxIXOIIO xxixoiio) {
        this.f31826XO.add(xxixoiio);
    }

    public final XmlResourceParser oO(Context context, int i) {
        int IXxxXO2;
        if (!this.f31825X0o0xo && (IXxxXO2 = IXxxXO(context, i)) != 0) {
            return this.f31827oIX0oI.getXml(IXxxXO2);
        }
        return context.getResources().getXml(i);
    }

    public String oOoXoXO() {
        return this.f31824II0xO0;
    }

    public Resources ooOOo0oXI() {
        return this.f31827oIX0oI;
    }

    @Deprecated
    public ColorStateList oxoX(int i) {
        return X0o0xo(IIXOxIxOo.I0Io.IXxxXO().x0XOIxOo(), i);
    }

    public final void x0XOIxOo(Context context, @IXo.I0Io int i, TypedValue typedValue, boolean z) {
        int IXxxXO2;
        if (!this.f31825X0o0xo && (IXxxXO2 = IXxxXO(context, i)) != 0) {
            this.f31827oIX0oI.getValue(IXxxXO2, typedValue, z);
        } else {
            context.getResources().getValue(i, typedValue, z);
        }
    }

    public I0Io.InterfaceC0010I0Io x0xO0oo() {
        return this.f31828oxoX;
    }

    public final ColorStateList xoIox(Context context, int i) {
        ColorStateList colorStateList;
        int IXxxXO2;
        ColorStateList X0o0xo2;
        ColorStateList Oxx0xo2;
        if (!f31821II0XooXoX) {
            if (!XO.x0XOIxOo().o00() && (Oxx0xo2 = XO.x0XOIxOo().Oxx0xo(i)) != null) {
                return Oxx0xo2;
            }
            I0Io.InterfaceC0010I0Io interfaceC0010I0Io = this.f31828oxoX;
            if (interfaceC0010I0Io != null && (X0o0xo2 = interfaceC0010I0Io.X0o0xo(context, this.f31823I0Io, i)) != null) {
                return X0o0xo2;
            }
            if (!this.f31825X0o0xo && (IXxxXO2 = IXxxXO(context, i)) != 0) {
                return this.f31827oIX0oI.getColorStateList(IXxxXO2);
            }
            if (Build.VERSION.SDK_INT >= 23) {
                colorStateList = context.getResources().getColorStateList(i, context.getTheme());
                return colorStateList;
            }
        }
        return context.getResources().getColorStateList(i);
    }

    public void xoXoI(I0Io.InterfaceC0010I0Io interfaceC0010I0Io) {
        this.f31827oIX0oI = IIXOxIxOo.I0Io.IXxxXO().x0XOIxOo().getResources();
        this.f31824II0xO0 = "";
        this.f31823I0Io = "";
        this.f31828oxoX = interfaceC0010I0Io;
        this.f31825X0o0xo = true;
        XO.x0XOIxOo().xxIXOIIO();
        Iterator<xxIXOIIO> it = this.f31826XO.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    public final int xxIXOIIO(Context context, int i) {
        int color;
        int IXxxXO2;
        ColorStateList II0xO02;
        ColorStateList Oxx0xo2;
        if (!f31821II0XooXoX) {
            if (!XO.x0XOIxOo().o00() && (Oxx0xo2 = XO.x0XOIxOo().Oxx0xo(i)) != null) {
                return Oxx0xo2.getDefaultColor();
            }
            I0Io.InterfaceC0010I0Io interfaceC0010I0Io = this.f31828oxoX;
            if (interfaceC0010I0Io != null && (II0xO02 = interfaceC0010I0Io.II0xO0(context, this.f31823I0Io, i)) != null) {
                return II0xO02.getDefaultColor();
            }
            if (!this.f31825X0o0xo && (IXxxXO2 = IXxxXO(context, i)) != 0) {
                return this.f31827oIX0oI.getColor(IXxxXO2);
            }
            if (Build.VERSION.SDK_INT >= 23) {
                color = context.getResources().getColor(i, context.getTheme());
                return color;
            }
        }
        return context.getResources().getColor(i);
    }
}
