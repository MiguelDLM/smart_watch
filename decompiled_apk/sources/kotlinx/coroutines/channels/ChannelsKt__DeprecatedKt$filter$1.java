package kotlinx.coroutines.channels;

import com.kwad.sdk.m.e;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;

/* JADX INFO: Add missing generic type declarations: [E] */
@IXIxx0.oxoX(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {198, 199, 199}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", e.TAG, "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
/* loaded from: classes6.dex */
public final class ChannelsKt__DeprecatedKt$filter$1<E> extends SuspendLambda implements Oox.x0xO0oo<IXxxXO<? super E>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ Oox.x0xO0oo<E, kotlin.coroutines.I0Io<? super Boolean>, Object> $predicate;
    final /* synthetic */ ReceiveChannel<E> $this_filter;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$filter$1(ReceiveChannel<? extends E> receiveChannel, Oox.x0xO0oo<? super E, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> x0xo0oo, kotlin.coroutines.I0Io<? super ChannelsKt__DeprecatedKt$filter$1> i0Io) {
        super(2, i0Io);
        this.$this_filter = receiveChannel;
        this.$predicate = x0xo0oo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        ChannelsKt__DeprecatedKt$filter$1 channelsKt__DeprecatedKt$filter$1 = new ChannelsKt__DeprecatedKt$filter$1(this.$this_filter, this.$predicate, i0Io);
        channelsKt__DeprecatedKt$filter$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filter$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0051, code lost:
    
        r6 = r7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@OXOo.OOXIXo java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r1 = r9.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L43
            if (r1 == r5) goto L37
            if (r1 == r4) goto L26
            if (r1 != r3) goto L1e
            java.lang.Object r1 = r9.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r9.L$0
            kotlinx.coroutines.channels.IXxxXO r6 = (kotlinx.coroutines.channels.IXxxXO) r6
            kotlin.I0oOoX.x0XOIxOo(r10)
            goto L51
        L1e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L26:
            java.lang.Object r1 = r9.L$2
            java.lang.Object r6 = r9.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r9.L$0
            kotlinx.coroutines.channels.IXxxXO r7 = (kotlinx.coroutines.channels.IXxxXO) r7
            kotlin.I0oOoX.x0XOIxOo(r10)
            r8 = r6
            r6 = r1
            r1 = r8
            goto L81
        L37:
            java.lang.Object r1 = r9.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r9.L$0
            kotlinx.coroutines.channels.IXxxXO r6 = (kotlinx.coroutines.channels.IXxxXO) r6
            kotlin.I0oOoX.x0XOIxOo(r10)
            goto L60
        L43:
            kotlin.I0oOoX.x0XOIxOo(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.channels.IXxxXO r10 = (kotlinx.coroutines.channels.IXxxXO) r10
            kotlinx.coroutines.channels.ReceiveChannel<E> r1 = r9.$this_filter
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r6 = r10
        L51:
            r9.L$0 = r6
            r9.L$1 = r1
            r9.L$2 = r2
            r9.label = r5
            java.lang.Object r10 = r1.I0Io(r9)
            if (r10 != r0) goto L60
            return r0
        L60:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L9a
            java.lang.Object r10 = r1.next()
            Oox.x0xO0oo<E, kotlin.coroutines.I0Io<? super java.lang.Boolean>, java.lang.Object> r7 = r9.$predicate
            r9.L$0 = r6
            r9.L$1 = r1
            r9.L$2 = r10
            r9.label = r4
            java.lang.Object r7 = r7.invoke(r10, r9)
            if (r7 != r0) goto L7d
            return r0
        L7d:
            r8 = r6
            r6 = r10
            r10 = r7
            r7 = r8
        L81:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L98
            r9.L$0 = r7
            r9.L$1 = r1
            r9.L$2 = r2
            r9.label = r3
            java.lang.Object r10 = r7.XOxIOxOx(r6, r9)
            if (r10 != r0) goto L98
            return r0
        L98:
            r6 = r7
            goto L51
        L9a:
            kotlin.oXIO0o0XI r10 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo IXxxXO<? super E> iXxxXO, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((ChannelsKt__DeprecatedKt$filter$1) create(iXxxXO, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
