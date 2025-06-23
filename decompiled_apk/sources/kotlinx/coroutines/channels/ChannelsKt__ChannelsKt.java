package kotlinx.coroutines.channels;

import kotlin.DeprecationLevel;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.channels.xoIox;

@XX({"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/channels/ChannelsKt__ChannelsKt\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n*L\n1#1,61:1\n514#2,6:62\n*S KotlinDebug\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/channels/ChannelsKt__ChannelsKt\n*L\n37#1:62,6\n*E\n"})
/* loaded from: classes6.dex */
public final /* synthetic */ class ChannelsKt__ChannelsKt {
    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <E> Object II0xO0(@OXOo.OOXIXo oI0IIXIo<? super E> oi0iixio, E e) {
        Object II0xO02;
        Object x0xO0oo2 = oi0iixio.x0xO0oo(e);
        if (x0xO0oo2 instanceof xoIox.I0Io) {
            II0xO02 = kotlinx.coroutines.xxIXOIIO.II0xO0(null, new ChannelsKt__ChannelsKt$trySendBlocking$2(oi0iixio, e, null), 1, null);
            return ((xoIox) II0xO02).oO();
        }
        return xoIox.f29891II0xO0.I0Io(oXIO0o0XI.f29392oIX0oI);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'trySendBlocking'. Consider handling the result of 'trySendBlocking' explicitly and rethrow exception if necessary", replaceWith = @kotlin.XX(expression = "trySendBlocking(element)", imports = {}))
    public static final /* synthetic */ void oIX0oI(oI0IIXIo oi0iixio, Object obj) {
        if (!xoIox.ooOOo0oXI(oi0iixio.x0xO0oo(obj))) {
            kotlinx.coroutines.xxIXOIIO.II0xO0(null, new ChannelsKt__ChannelsKt$sendBlocking$1(oi0iixio, obj, null), 1, null);
        }
    }
}
