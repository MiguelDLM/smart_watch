package kotlinx.coroutines.channels;

import com.garmin.fit.X0xOO;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;

@IXIxx0.oxoX(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1", f = "Deprecated.kt", i = {0, 1, 2}, l = {X0xOO.f13592OIxI0O, X0xOO.f13558IXX, X0xOO.f13558IXX}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
/* loaded from: classes6.dex */
public final class ChannelsKt__DeprecatedKt$flatMap$1 extends SuspendLambda implements Oox.x0xO0oo<IXxxXO<Object>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $this_flatMap;
    final /* synthetic */ Oox.x0xO0oo<Object, kotlin.coroutines.I0Io<? super ReceiveChannel<Object>>, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$flatMap$1(ReceiveChannel<Object> receiveChannel, Oox.x0xO0oo<Object, ? super kotlin.coroutines.I0Io<? super ReceiveChannel<Object>>, ? extends Object> x0xo0oo, kotlin.coroutines.I0Io<? super ChannelsKt__DeprecatedKt$flatMap$1> i0Io) {
        super(2, i0Io);
        this.$this_flatMap = receiveChannel;
        this.$transform = x0xo0oo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        ChannelsKt__DeprecatedKt$flatMap$1 channelsKt__DeprecatedKt$flatMap$1 = new ChannelsKt__DeprecatedKt$flatMap$1(this.$this_flatMap, this.$transform, i0Io);
        channelsKt__DeprecatedKt$flatMap$1.L$0 = obj;
        return channelsKt__DeprecatedKt$flatMap$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0082  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x007f -> B:7:0x004b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@OXOo.OOXIXo java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r1 = r7.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L3d
            if (r1 == r4) goto L31
            if (r1 == r3) goto L25
            if (r1 != r2) goto L1d
            java.lang.Object r1 = r7.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r7.L$0
            kotlinx.coroutines.channels.IXxxXO r5 = (kotlinx.coroutines.channels.IXxxXO) r5
            kotlin.I0oOoX.x0XOIxOo(r8)
            goto L4b
        L1d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L25:
            java.lang.Object r1 = r7.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r7.L$0
            kotlinx.coroutines.channels.IXxxXO r5 = (kotlinx.coroutines.channels.IXxxXO) r5
            kotlin.I0oOoX.x0XOIxOo(r8)
            goto L73
        L31:
            java.lang.Object r1 = r7.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r7.L$0
            kotlinx.coroutines.channels.IXxxXO r5 = (kotlinx.coroutines.channels.IXxxXO) r5
            kotlin.I0oOoX.x0XOIxOo(r8)
            goto L58
        L3d:
            kotlin.I0oOoX.x0XOIxOo(r8)
            java.lang.Object r8 = r7.L$0
            kotlinx.coroutines.channels.IXxxXO r8 = (kotlinx.coroutines.channels.IXxxXO) r8
            kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r1 = r7.$this_flatMap
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r5 = r8
        L4b:
            r7.L$0 = r5
            r7.L$1 = r1
            r7.label = r4
            java.lang.Object r8 = r1.I0Io(r7)
            if (r8 != r0) goto L58
            return r0
        L58:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L82
            java.lang.Object r8 = r1.next()
            Oox.x0xO0oo<java.lang.Object, kotlin.coroutines.I0Io<? super kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object>>, java.lang.Object> r6 = r7.$transform
            r7.L$0 = r5
            r7.L$1 = r1
            r7.label = r3
            java.lang.Object r8 = r6.invoke(r8, r7)
            if (r8 != r0) goto L73
            return r0
        L73:
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            r7.L$0 = r5
            r7.L$1 = r1
            r7.label = r2
            java.lang.Object r8 = kotlinx.coroutines.channels.oOoXoXO.I0X0x0oIo(r8, r5, r7)
            if (r8 != r0) goto L4b
            return r0
        L82:
            kotlin.oXIO0o0XI r8 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo IXxxXO<Object> iXxxXO, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((ChannelsKt__DeprecatedKt$flatMap$1) create(iXxxXO, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
