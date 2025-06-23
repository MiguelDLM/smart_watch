package com.airbnb.lottie;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class X0o0xo {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f4817I0Io = 20;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static int f4818II0XooXoX = 0;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f4819II0xO0 = "LOTTIE";

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static volatile oI0IIXIo.Oxx0IOOO f4820OOXIXo = null;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static int f4821Oxx0IOOO = 0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static String[] f4822X0o0xo = null;

    /* renamed from: XO, reason: collision with root package name */
    public static long[] f4823XO = null;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static boolean f4824oIX0oI = false;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static volatile oI0IIXIo.XO f4825oOoXoXO = null;

    /* renamed from: oxoX, reason: collision with root package name */
    public static boolean f4826oxoX = false;

    /* renamed from: xoIox, reason: collision with root package name */
    public static oI0IIXIo.oxoX f4827xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static oI0IIXIo.X0o0xo f4828xxIXOIIO;

    /* loaded from: classes.dex */
    public class oIX0oI implements oI0IIXIo.oxoX {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ Context f4829oIX0oI;

        public oIX0oI(Context context) {
            this.f4829oIX0oI = context;
        }

        @Override // oI0IIXIo.oxoX
        @NonNull
        public File oIX0oI() {
            return new File(this.f4829oIX0oI.getCacheDir(), "lottie_network_cache");
        }
    }

    @NonNull
    public static oI0IIXIo.XO I0Io(@NonNull Context context) {
        oI0IIXIo.XO xo2 = f4825oOoXoXO;
        if (xo2 == null) {
            synchronized (oI0IIXIo.XO.class) {
                try {
                    xo2 = f4825oOoXoXO;
                    if (xo2 == null) {
                        oI0IIXIo.oxoX oxox = f4827xoIox;
                        if (oxox == null) {
                            oxox = new oIX0oI(context);
                        }
                        xo2 = new oI0IIXIo.XO(oxox);
                        f4825oOoXoXO = xo2;
                    }
                } finally {
                }
            }
        }
        return xo2;
    }

    public static float II0xO0(String str) {
        int i = f4818II0XooXoX;
        if (i > 0) {
            f4818II0XooXoX = i - 1;
            return 0.0f;
        }
        if (!f4826oxoX) {
            return 0.0f;
        }
        int i2 = f4821Oxx0IOOO - 1;
        f4821Oxx0IOOO = i2;
        if (i2 != -1) {
            if (str.equals(f4822X0o0xo[i2])) {
                TraceCompat.endSection();
                return ((float) (System.nanoTime() - f4823XO[f4821Oxx0IOOO])) / 1000000.0f;
            }
            throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f4822X0o0xo[f4821Oxx0IOOO] + FileUtils.FILE_EXTENSION_SEPARATOR);
        }
        throw new IllegalStateException("Can't end trace section. There are none.");
    }

    public static void Oxx0IOOO(boolean z) {
        if (f4826oxoX == z) {
            return;
        }
        f4826oxoX = z;
        if (z) {
            f4822X0o0xo = new String[20];
            f4823XO = new long[20];
        }
    }

    public static void X0o0xo(oI0IIXIo.oxoX oxox) {
        f4827xoIox = oxox;
    }

    public static void XO(oI0IIXIo.X0o0xo x0o0xo) {
        f4828xxIXOIIO = x0o0xo;
    }

    public static void oIX0oI(String str) {
        if (!f4826oxoX) {
            return;
        }
        int i = f4821Oxx0IOOO;
        if (i == 20) {
            f4818II0XooXoX++;
            return;
        }
        f4822X0o0xo[i] = str;
        f4823XO[i] = System.nanoTime();
        TraceCompat.beginSection(str);
        f4821Oxx0IOOO++;
    }

    @NonNull
    public static oI0IIXIo.Oxx0IOOO oxoX(@NonNull Context context) {
        oI0IIXIo.Oxx0IOOO oxx0IOOO = f4820OOXIXo;
        if (oxx0IOOO == null) {
            synchronized (oI0IIXIo.Oxx0IOOO.class) {
                try {
                    oxx0IOOO = f4820OOXIXo;
                    if (oxx0IOOO == null) {
                        oI0IIXIo.XO I0Io2 = I0Io(context);
                        oI0IIXIo.X0o0xo x0o0xo = f4828xxIXOIIO;
                        if (x0o0xo == null) {
                            x0o0xo = new oI0IIXIo.II0xO0();
                        }
                        oxx0IOOO = new oI0IIXIo.Oxx0IOOO(I0Io2, x0o0xo);
                        f4820OOXIXo = oxx0IOOO;
                    }
                } finally {
                }
            }
        }
        return oxx0IOOO;
    }
}
