package kotlinx.coroutines.channels;

import kotlin.I0oOoX;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.xII;

@IXIxx0.oxoX(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", f = "Channels.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
@XX({"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/channels/ChannelsKt__ChannelsKt$trySendBlocking$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
/* loaded from: classes6.dex */
public final class ChannelsKt__ChannelsKt$trySendBlocking$2 extends SuspendLambda implements Oox.x0xO0oo<xII, kotlin.coroutines.I0Io<? super xoIox<? extends oXIO0o0XI>>, Object> {
    final /* synthetic */ E $element;
    final /* synthetic */ oI0IIXIo<E> $this_trySendBlocking;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__ChannelsKt$trySendBlocking$2(oI0IIXIo<? super E> oi0iixio, E e, kotlin.coroutines.I0Io<? super ChannelsKt__ChannelsKt$trySendBlocking$2> i0Io) {
        super(2, i0Io);
        this.$this_trySendBlocking = oi0iixio;
        this.$element = e;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        ChannelsKt__ChannelsKt$trySendBlocking$2 channelsKt__ChannelsKt$trySendBlocking$2 = new ChannelsKt__ChannelsKt$trySendBlocking$2(this.$this_trySendBlocking, this.$element, i0Io);
        channelsKt__ChannelsKt$trySendBlocking$2.L$0 = obj;
        return channelsKt__ChannelsKt$trySendBlocking$2;
    }

    @Override // Oox.x0xO0oo
    public /* bridge */ /* synthetic */ Object invoke(xII xii, kotlin.coroutines.I0Io<? super xoIox<? extends oXIO0o0XI>> i0Io) {
        return invoke2(xii, (kotlin.coroutines.I0Io<? super xoIox<oXIO0o0XI>>) i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        Object m287constructorimpl;
        Object oIX0oI2;
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    I0oOoX.x0XOIxOo(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                I0oOoX.x0XOIxOo(obj);
                oI0IIXIo<E> oi0iixio = this.$this_trySendBlocking;
                E e = this.$element;
                Result.oIX0oI oix0oi = Result.Companion;
                this.label = 1;
                if (oi0iixio.XOxIOxOx(e, this) == oOoXoXO2) {
                    return oOoXoXO2;
                }
            }
            m287constructorimpl = Result.m287constructorimpl(oXIO0o0XI.f29392oIX0oI);
        } catch (Throwable th) {
            Result.oIX0oI oix0oi2 = Result.Companion;
            m287constructorimpl = Result.m287constructorimpl(I0oOoX.oIX0oI(th));
        }
        if (Result.m294isSuccessimpl(m287constructorimpl)) {
            oIX0oI2 = xoIox.f29891II0xO0.I0Io(oXIO0o0XI.f29392oIX0oI);
        } else {
            oIX0oI2 = xoIox.f29891II0xO0.oIX0oI(Result.m290exceptionOrNullimpl(m287constructorimpl));
        }
        return xoIox.II0xO0(oIX0oI2);
    }

    @OXOo.oOoXoXO
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super xoIox<oXIO0o0XI>> i0Io) {
        return ((ChannelsKt__ChannelsKt$trySendBlocking$2) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
