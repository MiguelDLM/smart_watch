package com.airbnb.lottie;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;
import oI0IIXIo.II0xO0;
import oI0IIXIo.Oxx0IOOO;
import oI0IIXIo.XO;
import oI0IIXIo.oxoX;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class X0o0xo {

    /* renamed from: I0Io  reason: collision with root package name */
    public static final int f823I0Io = 20;

    /* renamed from: II0XooXoX  reason: collision with root package name */
    public static int f824II0XooXoX = 0;

    /* renamed from: II0xO0  reason: collision with root package name */
    public static final String f825II0xO0 = "LOTTIE";

    /* renamed from: OOXIXo  reason: collision with root package name */
    public static volatile Oxx0IOOO f826OOXIXo = null;

    /* renamed from: Oxx0IOOO  reason: collision with root package name */
    public static int f827Oxx0IOOO = 0;

    /* renamed from: X0o0xo  reason: collision with root package name */
    public static String[] f828X0o0xo = null;

    /* renamed from: XO  reason: collision with root package name */
    public static long[] f829XO = null;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static boolean f830oIX0oI = false;

    /* renamed from: oOoXoXO  reason: collision with root package name */
    public static volatile XO f831oOoXoXO = null;

    /* renamed from: oxoX  reason: collision with root package name */
    public static boolean f832oxoX = false;

    /* renamed from: xoIox  reason: collision with root package name */
    public static oxoX f833xoIox;

    /* renamed from: xxIXOIIO  reason: collision with root package name */
    public static oI0IIXIo.X0o0xo f834xxIXOIIO;

    public class oIX0oI implements oxoX {

        /* renamed from: oIX0oI  reason: collision with root package name */
        public final /* synthetic */ Context f835oIX0oI;

        public oIX0oI(Context context) {
            this.f835oIX0oI = context;
        }

        @NonNull
        public File oIX0oI() {
            return new File(this.f835oIX0oI.getCacheDir(), "lottie_network_cache");
        }
    }

    @NonNull
    public static XO I0Io(@NonNull Context context) {
        XO xo2 = f831oOoXoXO;
        if (xo2 == null) {
            synchronized (XO.class) {
                try {
                    xo2 = f831oOoXoXO;
                    if (xo2 == null) {
                        oxoX oxox = f833xoIox;
                        if (oxox == null) {
                            oxox = new oIX0oI(context);
                        }
                        xo2 = new XO(oxox);
                        f831oOoXoXO = xo2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return xo2;
    }

    public static float II0xO0(String str) {
        int i = f824II0XooXoX;
        if (i > 0) {
            f824II0XooXoX = i - 1;
            return 0.0f;
        } else if (!f832oxoX) {
            return 0.0f;
        } else {
            int i2 = f827Oxx0IOOO - 1;
            f827Oxx0IOOO = i2;
            if (i2 == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            } else if (str.equals(f828X0o0xo[i2])) {
                TraceCompat.endSection();
                return ((float) (System.nanoTime() - f829XO[f827Oxx0IOOO])) / 1000000.0f;
            } else {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f828X0o0xo[f827Oxx0IOOO] + FileUtils.FILE_EXTENSION_SEPARATOR);
            }
        }
    }

    public static void Oxx0IOOO(boolean z) {
        if (f832oxoX != z) {
            f832oxoX = z;
            if (z) {
                f828X0o0xo = new String[20];
                f829XO = new long[20];
            }
        }
    }

    public static void X0o0xo(oxoX oxox) {
        f833xoIox = oxox;
    }

    public static void XO(oI0IIXIo.X0o0xo x0o0xo) {
        f834xxIXOIIO = x0o0xo;
    }

    public static void oIX0oI(String str) {
        if (f832oxoX) {
            int i = f827Oxx0IOOO;
            if (i == 20) {
                f824II0XooXoX++;
                return;
            }
            f828X0o0xo[i] = str;
            f829XO[i] = System.nanoTime();
            TraceCompat.beginSection(str);
            f827Oxx0IOOO++;
        }
    }

    @NonNull
    public static Oxx0IOOO oxoX(@NonNull Context context) {
        Oxx0IOOO oxx0IOOO = f826OOXIXo;
        if (oxx0IOOO == null) {
            synchronized (Oxx0IOOO.class) {
                try {
                    oxx0IOOO = f826OOXIXo;
                    if (oxx0IOOO == null) {
                        XO I0Io2 = I0Io(context);
                        oI0IIXIo.X0o0xo x0o0xo = f834xxIXOIIO;
                        if (x0o0xo == null) {
                            x0o0xo = new II0xO0();
                        }
                        oxx0IOOO = new Oxx0IOOO(I0Io2, x0o0xo);
                        f826OOXIXo = oxx0IOOO;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return oxx0IOOO;
    }
}
