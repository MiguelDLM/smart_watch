package kotlinx.coroutines;

/* loaded from: classes6.dex */
public final class xxIO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f30493I0Io = 1;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f30495II0xO0 = 0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final long f30496Oxx0IOOO = 4611686018427387903L;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final long f30497X0o0xo = 1000000;

    /* renamed from: XO, reason: collision with root package name */
    public static final long f30498XO = 9223372036854L;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f30500oxoX = 2;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.coroutines.internal.x0o f30499oIX0oI = new kotlinx.coroutines.internal.x0o("REMOVED_TASK");

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.coroutines.internal.x0o f30494II0XooXoX = new kotlinx.coroutines.internal.x0o("CLOSED_EMPTY");

    public static final long I0Io(long j) {
        return j / 1000000;
    }

    public static final long oxoX(long j) {
        if (j <= 0) {
            return 0L;
        }
        if (j >= f30498XO) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j;
    }
}
