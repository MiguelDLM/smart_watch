package kotlinx.coroutines;

/* loaded from: classes6.dex */
public final class xI0oxI00 {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f30474Oxx0IOOO = 1;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f30475X0o0xo = -1;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f30476XO = 0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.coroutines.internal.x0o f30477oIX0oI = new kotlinx.coroutines.internal.x0o("COMPLETING_ALREADY");

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public static final kotlinx.coroutines.internal.x0o f30473II0xO0 = new kotlinx.coroutines.internal.x0o("COMPLETING_WAITING_CHILDREN");

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.coroutines.internal.x0o f30471I0Io = new kotlinx.coroutines.internal.x0o("COMPLETING_RETRY");

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.coroutines.internal.x0o f30478oxoX = new kotlinx.coroutines.internal.x0o("TOO_LATE_TO_CANCEL");

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.coroutines.internal.x0o f30472II0XooXoX = new kotlinx.coroutines.internal.x0o("SEALED");

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final xoIxX f30480xxIXOIIO = new xoIxX(false);

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final xoIxX f30479xoIox = new xoIxX(true);

    @OXOo.oOoXoXO
    public static final Object II0XooXoX(@OXOo.oOoXoXO Object obj) {
        xoO0xx0 xoo0xx0;
        ooOx ooox;
        if (obj instanceof xoO0xx0) {
            xoo0xx0 = (xoO0xx0) obj;
        } else {
            xoo0xx0 = null;
        }
        if (xoo0xx0 != null && (ooox = xoo0xx0.f30489oIX0oI) != null) {
            return ooox;
        }
        return obj;
    }

    @OXOo.oOoXoXO
    public static final Object Oxx0IOOO(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof ooOx) {
            return new xoO0xx0((ooOx) obj);
        }
        return obj;
    }
}
