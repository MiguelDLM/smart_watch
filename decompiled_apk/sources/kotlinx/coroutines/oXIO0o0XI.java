package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes6.dex */
public interface oXIO0o0XI extends CoroutineContext.oIX0oI {

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final II0xO0 f30343xxIXOIIO = II0xO0.f30344XO;

    /* loaded from: classes6.dex */
    public static final class II0xO0 implements CoroutineContext.II0xO0<oXIO0o0XI> {

        /* renamed from: XO, reason: collision with root package name */
        public static final /* synthetic */ II0xO0 f30344XO = new II0xO0();
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public static /* synthetic */ boolean I0Io(oXIO0o0XI oxio0o0xi, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return oxio0o0xi.oIX0oI(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        @OXOo.OOXIXo
        public static CoroutineContext II0XooXoX(@OXOo.OOXIXo oXIO0o0XI oxio0o0xi, @OXOo.OOXIXo CoroutineContext.II0xO0<?> iI0xO0) {
            return CoroutineContext.oIX0oI.C1106oIX0oI.I0Io(oxio0o0xi, iI0xO0);
        }

        public static /* synthetic */ void II0xO0(oXIO0o0XI oxio0o0xi, CancellationException cancellationException, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    cancellationException = null;
                }
                oxio0o0xi.II0xO0(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static /* synthetic */ I0oOIX Oxx0IOOO(oXIO0o0XI oxio0o0xi, boolean z, boolean z2, Oox.oOoXoXO oooxoxo, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                if ((i & 2) != 0) {
                    z2 = true;
                }
                return oxio0o0xi.O0xOxO(z, z2, oooxoxo);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        @OXOo.oOoXoXO
        public static <E extends CoroutineContext.oIX0oI> E X0o0xo(@OXOo.OOXIXo oXIO0o0XI oxio0o0xi, @OXOo.OOXIXo CoroutineContext.II0xO0<E> iI0xO0) {
            return (E) CoroutineContext.oIX0oI.C1106oIX0oI.II0xO0(oxio0o0xi, iI0xO0);
        }

        @XI0oooXX
        public static /* synthetic */ void XO() {
        }

        @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
        public static /* synthetic */ void oIX0oI(oXIO0o0XI oxio0o0xi) {
            oxio0o0xi.II0xO0(null);
        }

        public static <R> R oxoX(@OXOo.OOXIXo oXIO0o0XI oxio0o0xi, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super CoroutineContext.oIX0oI, ? extends R> x0xo0oo) {
            return (R) CoroutineContext.oIX0oI.C1106oIX0oI.oIX0oI(oxio0o0xi, r, x0xo0oo);
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @OXOo.OOXIXo
        public static oXIO0o0XI xoIox(@OXOo.OOXIXo oXIO0o0XI oxio0o0xi, @OXOo.OOXIXo oXIO0o0XI oxio0o0xi2) {
            return oxio0o0xi2;
        }

        @OXOo.OOXIXo
        public static CoroutineContext xxIXOIIO(@OXOo.OOXIXo oXIO0o0XI oxio0o0xi, @OXOo.OOXIXo CoroutineContext coroutineContext) {
            return CoroutineContext.oIX0oI.C1106oIX0oI.oxoX(oxio0o0xi, coroutineContext);
        }
    }

    void II0xO0(@OXOo.oOoXoXO CancellationException cancellationException);

    @OXOo.OOXIXo
    @OX00O0xII
    I0oOIX O0xOxO(boolean z, boolean z2, @OXOo.OOXIXo Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo);

    @OXOo.OOXIXo
    I0oOIX Oo(@OXOo.OOXIXo Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo);

    @OXOo.OOXIXo
    kotlinx.coroutines.selects.I0Io OxI();

    @OXOo.OOXIXo
    @OX00O0xII
    IIXOooo XI0IXoo(@OXOo.OOXIXo o00 o00Var);

    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    @OXOo.oOoXoXO
    oXIO0o0XI getParent();

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean oIX0oI(Throwable th);

    @OXOo.oOoXoXO
    Object oOXoIIIo(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> i0Io);

    boolean start();

    @OXOo.OOXIXo
    @OX00O0xII
    CancellationException xI();

    @OXOo.OOXIXo
    kotlin.sequences.ooOOo0oXI<oXIO0o0XI> xXxxox0I();

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @OXOo.OOXIXo
    oXIO0o0XI xoIox(@OXOo.OOXIXo oXIO0o0XI oxio0o0xi);
}
