package kotlinx.coroutines.channels;

import kotlin.oXIO0o0XI;
import kotlinx.coroutines.internal.I0oOoX;
import kotlinx.coroutines.internal.x0o;

/* loaded from: classes6.dex */
public final class BufferedChannelKt {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f29826I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0o f29827II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    @XO0OX.XO
    public static final int f29828II0xO0;

    /* renamed from: IIX0o, reason: collision with root package name */
    public static final long f29829IIX0o = 1152921504606846975L;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f29830IIXOooo = 4;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f29831IXxxXO = 0;

    /* renamed from: O0xOxO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0o f29832O0xOxO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0o f29833OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0o f29834Oo;

    /* renamed from: OxI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0o f29835OxI;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0o f29836Oxx0IOOO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f29837Oxx0xo = 1;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f29838OxxIIOOXO = 3;

    /* renamed from: X0IIOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0o f29839X0IIOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final long f29840X0o0xo = Long.MAX_VALUE;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final int f29841XI0IXoo = 0;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final int f29842XIxXXX0x0 = 1;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public static final x0o f29843XO;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final int f29844XxX0x0xxx = 3;

    /* renamed from: o00, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0o f29845o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f29846oI0IIXIo = 2;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final OOXIXo<Object> f29847oIX0oI = new OOXIXo<>(-1, null, null, 0);

    /* renamed from: oO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0o f29848oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0o f29849oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0o f29850ooOOo0oXI;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public static final long f29851ooXIXxIX = 4611686018427387904L;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final long f29852oxoX = 0;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0o f29853x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0o f29854x0xO0oo;

    /* renamed from: xI, reason: collision with root package name */
    public static final long f29855xI = 4611686018427387903L;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final int f29856xXxxox0I = 60;

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0o f29857xoIox;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f29858xoXoI = 5;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0o f29859xxIXOIIO;

    /* renamed from: xxX, reason: collision with root package name */
    public static final int f29860xxX = 2;

    static {
        int X0o0xo2;
        int X0o0xo3;
        X0o0xo2 = I0oOoX.X0o0xo("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);
        f29828II0xO0 = X0o0xo2;
        X0o0xo3 = I0oOoX.X0o0xo("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);
        f29826I0Io = X0o0xo3;
        f29843XO = new x0o("BUFFERED");
        f29836Oxx0IOOO = new x0o("SHOULD_BUFFER");
        f29827II0XooXoX = new x0o("S_RESUMING_BY_RCV");
        f29859xxIXOIIO = new x0o("RESUMING_BY_EB");
        f29857xoIox = new x0o("POISONED");
        f29833OOXIXo = new x0o("DONE_RCV");
        f29849oOoXoXO = new x0o("INTERRUPTED_SEND");
        f29850ooOOo0oXI = new x0o("INTERRUPTED_RCV");
        f29853x0XOIxOo = new x0o("CHANNEL_CLOSED");
        f29848oO = new x0o("SUSPEND");
        f29854x0xO0oo = new x0o("SUSPEND_NO_WAITER");
        f29834Oo = new x0o("FAILED");
        f29845o00 = new x0o("NO_RECEIVE_RESULT");
        f29835OxI = new x0o("CLOSE_HANDLER_CLOSED");
        f29832O0xOxO = new x0o("CLOSE_HANDLER_INVOKED");
        f29839X0IIOO = new x0o("NO_CLOSE_CAUSE");
    }

    public static /* synthetic */ boolean IIX0o(kotlinx.coroutines.oO oOVar, Object obj, Oox.oOoXoXO oooxoxo, int i, Object obj2) {
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        return xXxxox0I(oOVar, obj, oooxoxo);
    }

    public static final long IIXOooo(long j, boolean z) {
        return (z ? 4611686018427387904L : 0L) + j;
    }

    @OXOo.OOXIXo
    public static final x0o O0xOxO() {
        return f29853x0XOIxOo;
    }

    @OXOo.OOXIXo
    public static final <E> kotlin.reflect.xxIXOIIO<OOXIXo<E>> OxI() {
        return BufferedChannelKt$createSegmentFunction$1.INSTANCE;
    }

    public static final long X0IIOO(long j) {
        return j & 4611686018427387903L;
    }

    public static final boolean XI0IXoo(long j) {
        return (j & 4611686018427387904L) != 0;
    }

    public static final int XIxXXX0x0(long j) {
        return (int) (j >> 60);
    }

    public static final long XxX0x0xxx(int i) {
        if (i == 0) {
            return 0L;
        }
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        return Long.MAX_VALUE;
    }

    public static final <E> OOXIXo<E> o00(long j, OOXIXo<E> oOXIXo) {
        return new OOXIXo<>(j, oOXIXo, oOXIXo.xoXoI(), 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean xXxxox0I(kotlinx.coroutines.oO<? super T> oOVar, T t, Oox.oOoXoXO<? super Throwable, oXIO0o0XI> oooxoxo) {
        Object OI02 = oOVar.OI0(t, null, oooxoxo);
        if (OI02 != null) {
            oOVar.XIxXXX0x0(OI02);
            return true;
        }
        return false;
    }

    public static final long xoXoI(long j, int i) {
        return (i << 60) + j;
    }

    public static final long xxX(long j) {
        return j & f29829IIX0o;
    }
}
