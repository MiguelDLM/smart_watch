package kotlinx.coroutines.channels;

import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;

/* JADX INFO: Add missing generic type declarations: [E] */
@IXIxx0.oxoX(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNull$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class ChannelsKt__DeprecatedKt$filterNotNull$1<E> extends SuspendLambda implements Oox.x0xO0oo<E, kotlin.coroutines.I0Io<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public ChannelsKt__DeprecatedKt$filterNotNull$1(kotlin.coroutines.I0Io<? super ChannelsKt__DeprecatedKt$filterNotNull$1> i0Io) {
        super(2, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        ChannelsKt__DeprecatedKt$filterNotNull$1 channelsKt__DeprecatedKt$filterNotNull$1 = new ChannelsKt__DeprecatedKt$filterNotNull$1(i0Io);
        channelsKt__DeprecatedKt$filterNotNull$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filterNotNull$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // Oox.x0xO0oo
    public /* bridge */ /* synthetic */ Object invoke(Object obj, kotlin.coroutines.I0Io<? super Boolean> i0Io) {
        return invoke2((ChannelsKt__DeprecatedKt$filterNotNull$1<E>) obj, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        boolean z;
        kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        if (this.label == 0) {
            I0oOoX.x0XOIxOo(obj);
            if (this.L$0 != null) {
                z = true;
            } else {
                z = false;
            }
            return IXIxx0.oIX0oI.oIX0oI(z);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @OXOo.oOoXoXO
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@OXOo.oOoXoXO E e, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super Boolean> i0Io) {
        return ((ChannelsKt__DeprecatedKt$filterNotNull$1) create(e, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
