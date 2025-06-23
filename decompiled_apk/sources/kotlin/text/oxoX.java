package kotlin.text;

import java.nio.charset.Charset;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class oxoX {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public static final Charset f29579I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static volatile Charset f29580II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public static final Charset f29581II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public static final Charset f29582Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public static final Charset f29583X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public static final Charset f29584XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oxoX f29585oIX0oI = new oxoX();

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public static final Charset f29586oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static volatile Charset f29587xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static volatile Charset f29588xxIXOIIO;

    static {
        Charset forName = Charset.forName("UTF-8");
        IIX0o.oO(forName, "forName(...)");
        f29581II0xO0 = forName;
        Charset forName2 = Charset.forName("UTF-16");
        IIX0o.oO(forName2, "forName(...)");
        f29579I0Io = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        IIX0o.oO(forName3, "forName(...)");
        f29586oxoX = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        IIX0o.oO(forName4, "forName(...)");
        f29583X0o0xo = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        IIX0o.oO(forName5, "forName(...)");
        f29584XO = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        IIX0o.oO(forName6, "forName(...)");
        f29582Oxx0IOOO = forName6;
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "UTF32_LE")
    public final Charset I0Io() {
        Charset charset = f29588xxIXOIIO;
        if (charset == null) {
            Charset forName = Charset.forName("UTF-32LE");
            IIX0o.oO(forName, "forName(...)");
            f29588xxIXOIIO = forName;
            return forName;
        }
        return charset;
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "UTF32_BE")
    public final Charset II0xO0() {
        Charset charset = f29587xoIox;
        if (charset == null) {
            Charset forName = Charset.forName("UTF-32BE");
            IIX0o.oO(forName, "forName(...)");
            f29587xoIox = forName;
            return forName;
        }
        return charset;
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "UTF32")
    public final Charset oIX0oI() {
        Charset charset = f29580II0XooXoX;
        if (charset == null) {
            Charset forName = Charset.forName("UTF-32");
            IIX0o.oO(forName, "forName(...)");
            f29580II0XooXoX = forName;
            return forName;
        }
        return charset;
    }
}
