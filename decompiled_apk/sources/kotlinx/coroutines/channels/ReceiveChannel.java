package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.XI0oooXX;
import kotlinx.coroutines.internal.xII;
import kotlinx.coroutines.xo0x;

/* loaded from: classes6.dex */
public interface ReceiveChannel<E> {

    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ boolean I0Io(ReceiveChannel receiveChannel, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return receiveChannel.oIX0oI(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @XX(expression = "tryReceive().getOrNull()", imports = {}))
        @OXOo.oOoXoXO
        public static <E> E II0XooXoX(@OXOo.OOXIXo ReceiveChannel<? extends E> receiveChannel) {
            Object IIXOooo2 = receiveChannel.IIXOooo();
            if (xoIox.ooOOo0oXI(IIXOooo2)) {
                return (E) xoIox.xxIXOIIO(IIXOooo2);
            }
            Throwable XO2 = xoIox.XO(IIXOooo2);
            if (XO2 == null) {
                return null;
            }
            throw xII.oO(XO2);
        }

        public static /* synthetic */ void II0xO0(ReceiveChannel receiveChannel, CancellationException cancellationException, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    cancellationException = null;
                }
                receiveChannel.II0xO0(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        @XI0oooXX
        public static /* synthetic */ void Oxx0IOOO() {
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated in favor of onReceiveCatching extension", replaceWith = @XX(expression = "onReceiveCatching", imports = {}))
        public static /* synthetic */ void X0o0xo() {
        }

        @xo0x
        public static /* synthetic */ void XO() {
        }

        @OXOo.OOXIXo
        public static <E> kotlinx.coroutines.selects.X0o0xo<E> oxoX(@OXOo.OOXIXo ReceiveChannel<? extends E> receiveChannel) {
            IIX0o.x0XOIxOo(receiveChannel, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel<E of kotlinx.coroutines.channels.ReceiveChannel>");
            return ((BufferedChannel) receiveChannel).oI0IIXIo();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @kotlin.OOXIXo(level = kotlin.DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @kotlin.XX(expression = "receiveCatching().getOrNull()", imports = {}))
        @xx0o0O.II0XooXoX
        @OXOo.oOoXoXO
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static <E> java.lang.Object xxIXOIIO(@OXOo.OOXIXo kotlinx.coroutines.channels.ReceiveChannel<? extends E> r4, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super E> r5) {
            /*
                boolean r0 = r5 instanceof kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1
                if (r0 == 0) goto L13
                r0 = r5
                kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1 r0 = (kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1 r0 = new kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1
                r0.<init>(r5)
            L18:
                java.lang.Object r5 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L37
                if (r2 != r3) goto L2f
                kotlin.I0oOoX.x0XOIxOo(r5)
                kotlinx.coroutines.channels.xoIox r5 = (kotlinx.coroutines.channels.xoIox) r5
                java.lang.Object r4 = r5.oO()
                goto L43
            L2f:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L37:
                kotlin.I0oOoX.x0XOIxOo(r5)
                r0.label = r3
                java.lang.Object r4 = r4.o00(r0)
                if (r4 != r1) goto L43
                return r1
            L43:
                java.lang.Object r4 = kotlinx.coroutines.channels.xoIox.II0XooXoX(r4)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.xxIXOIIO(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.I0Io):java.lang.Object");
        }
    }

    void II0xO0(@OXOo.oOoXoXO CancellationException cancellationException);

    @OXOo.OOXIXo
    Object IIXOooo();

    @OXOo.OOXIXo
    kotlinx.coroutines.selects.X0o0xo<xoIox<E>> Oxx0xo();

    @OXOo.OOXIXo
    kotlinx.coroutines.selects.X0o0xo<E> Xx000oIo();

    boolean XxX0x0xxx();

    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    boolean isEmpty();

    @OXOo.OOXIXo
    ChannelIterator<E> iterator();

    @OXOo.oOoXoXO
    Object o00(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super xoIox<? extends E>> i0Io);

    @OXOo.OOXIXo
    kotlinx.coroutines.selects.X0o0xo<E> oI0IIXIo();

    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean oIX0oI(Throwable th);

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @XX(expression = "tryReceive().getOrNull()", imports = {}))
    @OXOo.oOoXoXO
    E poll();

    @OXOo.oOoXoXO
    Object xII(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super E> i0Io);

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @XX(expression = "receiveCatching().getOrNull()", imports = {}))
    @xx0o0O.II0XooXoX
    @OXOo.oOoXoXO
    Object xoXoI(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super E> i0Io);
}
