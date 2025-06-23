package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes6.dex */
public final class XOxIOxOx {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f29767I0Io = "auto";

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final boolean f29768II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f29769II0xO0 = "kotlinx.coroutines.stacktrace.recovery";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final boolean f29770Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f29771X0o0xo = "off";

    /* renamed from: XO, reason: collision with root package name */
    public static final boolean f29772XO = false;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f29773oIX0oI = "kotlinx.coroutines.debug";

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f29774oxoX = "on";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicLong f29775xxIXOIIO;

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        if (r0.equals(kotlinx.coroutines.XOxIOxOx.f29774oxoX) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0040, code lost:
    
        if (r0.equals("") != false) goto L23;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = kotlinx.coroutines.internal.o0.oxoX(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L2f
            int r3 = r0.hashCode()
            if (r3 == 0) goto L3a
            r4 = 3551(0xddf, float:4.976E-42)
            if (r3 == r4) goto L31
            r4 = 109935(0x1ad6f, float:1.54052E-40)
            if (r3 == r4) goto L27
            r4 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r3 != r4) goto L44
            java.lang.String r3 = "auto"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L44
            goto L2f
        L27:
            java.lang.String r3 = "off"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L44
        L2f:
            r0 = 0
            goto L64
        L31:
            java.lang.String r3 = "on"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L44
            goto L42
        L3a:
            java.lang.String r3 = ""
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L44
        L42:
            r0 = 1
            goto L64
        L44:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
            r2.append(r3)
            r2.append(r0)
            r0 = 39
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L64:
            kotlinx.coroutines.XOxIOxOx.f29770Oxx0IOOO = r0
            if (r0 == 0) goto L71
            java.lang.String r0 = "kotlinx.coroutines.stacktrace.recovery"
            boolean r0 = kotlinx.coroutines.internal.o0.XO(r0, r1)
            if (r0 == 0) goto L71
            goto L72
        L71:
            r1 = 0
        L72:
            kotlinx.coroutines.XOxIOxOx.f29768II0XooXoX = r1
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = 0
            r0.<init>(r1)
            kotlinx.coroutines.XOxIOxOx.f29775xxIXOIIO = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.XOxIOxOx.<clinit>():void");
    }

    @OXOo.OOXIXo
    public static final AtomicLong I0Io() {
        return f29775xxIXOIIO;
    }

    public static final boolean II0xO0() {
        return f29772XO;
    }

    public static final void Oxx0IOOO() {
        f29775xxIXOIIO.set(0L);
    }

    public static final boolean X0o0xo() {
        return f29768II0XooXoX;
    }

    @kotlin.o0
    public static /* synthetic */ void XO() {
    }

    public static final boolean oxoX() {
        return f29770Oxx0IOOO;
    }

    @xx0o0O.XO
    public static final void oIX0oI(Oox.oIX0oI<Boolean> oix0oi) {
    }
}
