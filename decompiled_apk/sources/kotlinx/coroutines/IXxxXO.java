package kotlinx.coroutines;

/* loaded from: classes6.dex */
public final class IXxxXO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f29699I0Io = 2;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f29700II0xO0 = 1;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public static final kotlinx.coroutines.internal.x0o f29701Oxx0IOOO = new kotlinx.coroutines.internal.x0o("RESUME_TOKEN");

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f29702X0o0xo = 536870911;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f29703XO = 536870911;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f29704oIX0oI = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f29705oxoX = 29;

    public static final int I0Io(int i) {
        return i & 536870911;
    }

    public static final int II0xO0(int i) {
        return i >> 29;
    }

    public static final int oIX0oI(int i, int i2) {
        return (i << 29) + i2;
    }
}
