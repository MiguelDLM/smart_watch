package kotlinx.coroutines.channels;

import com.kwad.sdk.m.e;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;

@IXIxx0.oxoX(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {269, 270, 271}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", e.TAG, "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
/* loaded from: classes6.dex */
public final class ChannelsKt__DeprecatedKt$takeWhile$1 extends SuspendLambda implements Oox.x0xO0oo<IXxxXO<Object>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ Oox.x0xO0oo<Object, kotlin.coroutines.I0Io<? super Boolean>, Object> $predicate;
    final /* synthetic */ ReceiveChannel<Object> $this_takeWhile;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$takeWhile$1(ReceiveChannel<Object> receiveChannel, Oox.x0xO0oo<Object, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> x0xo0oo, kotlin.coroutines.I0Io<? super ChannelsKt__DeprecatedKt$takeWhile$1> i0Io) {
        super(2, i0Io);
        this.$this_takeWhile = receiveChannel;
        this.$predicate = x0xo0oo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        ChannelsKt__DeprecatedKt$takeWhile$1 channelsKt__DeprecatedKt$takeWhile$1 = new ChannelsKt__DeprecatedKt$takeWhile$1(this.$this_takeWhile, this.$predicate, i0Io);
        channelsKt__DeprecatedKt$takeWhile$1.L$0 = obj;
        return channelsKt__DeprecatedKt$takeWhile$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0097 -> B:7:0x004d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@OXOo.OOXIXo java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r1 = r8.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L3f
            if (r1 == r4) goto L33
            if (r1 == r3) goto L25
            if (r1 != r2) goto L1d
            java.lang.Object r1 = r8.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r8.L$0
            kotlinx.coroutines.channels.IXxxXO r5 = (kotlinx.coroutines.channels.IXxxXO) r5
            kotlin.I0oOoX.x0XOIxOo(r9)
            goto L4d
        L1d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L25:
            java.lang.Object r1 = r8.L$2
            java.lang.Object r5 = r8.L$1
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r8.L$0
            kotlinx.coroutines.channels.IXxxXO r6 = (kotlinx.coroutines.channels.IXxxXO) r6
            kotlin.I0oOoX.x0XOIxOo(r9)
            goto L7c
        L33:
            java.lang.Object r1 = r8.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r8.L$0
            kotlinx.coroutines.channels.IXxxXO r5 = (kotlinx.coroutines.channels.IXxxXO) r5
            kotlin.I0oOoX.x0XOIxOo(r9)
            goto L5a
        L3f:
            kotlin.I0oOoX.x0XOIxOo(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.channels.IXxxXO r9 = (kotlinx.coroutines.channels.IXxxXO) r9
            kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r1 = r8.$this_takeWhile
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r5 = r9
        L4d:
            r8.L$0 = r5
            r8.L$1 = r1
            r8.label = r4
            java.lang.Object r9 = r1.I0Io(r8)
            if (r9 != r0) goto L5a
            return r0
        L5a:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L9a
            java.lang.Object r9 = r1.next()
            Oox.x0xO0oo<java.lang.Object, kotlin.coroutines.I0Io<? super java.lang.Boolean>, java.lang.Object> r6 = r8.$predicate
            r8.L$0 = r5
            r8.L$1 = r1
            r8.L$2 = r9
            r8.label = r3
            java.lang.Object r6 = r6.invoke(r9, r8)
            if (r6 != r0) goto L77
            return r0
        L77:
            r7 = r1
            r1 = r9
            r9 = r6
            r6 = r5
            r5 = r7
        L7c:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L87
            kotlin.oXIO0o0XI r9 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r9
        L87:
            r8.L$0 = r6
            r8.L$1 = r5
            r9 = 0
            r8.L$2 = r9
            r8.label = r2
            java.lang.Object r9 = r6.XOxIOxOx(r1, r8)
            if (r9 != r0) goto L97
            return r0
        L97:
            r1 = r5
            r5 = r6
            goto L4d
        L9a:
            kotlin.oXIO0o0XI r9 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo IXxxXO<Object> iXxxXO, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((ChannelsKt__DeprecatedKt$takeWhile$1) create(iXxxXO, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
