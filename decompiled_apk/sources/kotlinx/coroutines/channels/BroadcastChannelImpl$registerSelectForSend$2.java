package kotlinx.coroutines.channels;

import com.garmin.fit.X0xOO;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import kotlinx.coroutines.xII;

@IXIxx0.oxoX(c = "kotlinx.coroutines.channels.BroadcastChannelImpl$registerSelectForSend$2", f = "BroadcastChannel.kt", i = {}, l = {X0xOO.f13580O0OOX0IIx}, m = "invokeSuspend", n = {}, s = {})
@XX({"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$registerSelectForSend$2\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,414:1\n15#2:415\n1#3:416\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$registerSelectForSend$2\n*L\n304#1:415\n*E\n"})
/* loaded from: classes6.dex */
public final class BroadcastChannelImpl$registerSelectForSend$2 extends SuspendLambda implements Oox.x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ Object $element;
    final /* synthetic */ kotlinx.coroutines.selects.xoIox<?> $select;
    int label;
    final /* synthetic */ BroadcastChannelImpl<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastChannelImpl$registerSelectForSend$2(BroadcastChannelImpl<E> broadcastChannelImpl, Object obj, kotlinx.coroutines.selects.xoIox<?> xoiox, kotlin.coroutines.I0Io<? super BroadcastChannelImpl$registerSelectForSend$2> i0Io) {
        super(2, i0Io);
        this.this$0 = broadcastChannelImpl;
        this.$element = obj;
        this.$select = xoiox;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        return new BroadcastChannelImpl$registerSelectForSend$2(this.this$0, this.$element, this.$select, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        HashMap hashMap;
        Object O0xOxO2;
        HashMap hashMap2;
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        boolean z = true;
        try {
            if (i != 0) {
                if (i == 1) {
                    I0oOoX.x0XOIxOo(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                I0oOoX.x0XOIxOo(obj);
                Oxx0IOOO oxx0IOOO = this.this$0;
                Object obj2 = this.$element;
                this.label = 1;
                if (oxx0IOOO.XOxIOxOx(obj2, this) == oOoXoXO2) {
                    return oOoXoXO2;
                }
            }
        } catch (Throwable th) {
            if (this.this$0.X0IIOO() && ((th instanceof ClosedSendChannelException) || this.this$0.xoIxX() == th)) {
                z = false;
            } else {
                throw th;
            }
        }
        ReentrantLock reentrantLock = this.this$0.f29803XIxXXX0x0;
        BroadcastChannelImpl<E> broadcastChannelImpl = this.this$0;
        kotlinx.coroutines.selects.xoIox<?> xoiox = this.$select;
        reentrantLock.lock();
        try {
            hashMap = broadcastChannelImpl.f29805xXxxox0I;
            if (z) {
                O0xOxO2 = oXIO0o0XI.f29392oIX0oI;
            } else {
                O0xOxO2 = BufferedChannelKt.O0xOxO();
            }
            hashMap.put(xoiox, O0xOxO2);
            IIX0o.x0XOIxOo(xoiox, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            Object obj3 = oXIO0o0XI.f29392oIX0oI;
            if (((SelectImplementation) xoiox).oo0xXOI0I(broadcastChannelImpl, obj3) != TrySelectDetailedResult.REREGISTER) {
                hashMap2 = broadcastChannelImpl.f29805xXxxox0I;
                hashMap2.remove(xoiox);
            }
            reentrantLock.unlock();
            return obj3;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((BroadcastChannelImpl$registerSelectForSend$2) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
