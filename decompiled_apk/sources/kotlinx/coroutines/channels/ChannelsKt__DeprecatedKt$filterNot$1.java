package kotlinx.coroutines.channels;

import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;

@IXIxx0.oxoX(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNot$1", f = "Deprecated.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class ChannelsKt__DeprecatedKt$filterNot$1 extends SuspendLambda implements Oox.x0xO0oo<Object, kotlin.coroutines.I0Io<? super Boolean>, Object> {
    final /* synthetic */ Oox.x0xO0oo<Object, kotlin.coroutines.I0Io<? super Boolean>, Object> $predicate;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$filterNot$1(Oox.x0xO0oo<Object, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> x0xo0oo, kotlin.coroutines.I0Io<? super ChannelsKt__DeprecatedKt$filterNot$1> i0Io) {
        super(2, i0Io);
        this.$predicate = x0xo0oo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        ChannelsKt__DeprecatedKt$filterNot$1 channelsKt__DeprecatedKt$filterNot$1 = new ChannelsKt__DeprecatedKt$filterNot$1(this.$predicate, i0Io);
        channelsKt__DeprecatedKt$filterNot$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filterNot$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                I0oOoX.x0XOIxOo(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            I0oOoX.x0XOIxOo(obj);
            Object obj2 = this.L$0;
            Oox.x0xO0oo<Object, kotlin.coroutines.I0Io<? super Boolean>, Object> x0xo0oo = this.$predicate;
            this.label = 1;
            obj = x0xo0oo.invoke(obj2, this);
            if (obj == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return IXIxx0.oIX0oI.oIX0oI(!((Boolean) obj).booleanValue());
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(Object obj, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super Boolean> i0Io) {
        return ((ChannelsKt__DeprecatedKt$filterNot$1) create(obj, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
