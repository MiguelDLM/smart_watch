package kotlinx.coroutines.channels;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.kwad.sdk.m.e;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;

@IXIxx0.oxoX(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {211, 212, 212}, m = "invokeSuspend", n = {"$this$produce", MapBundleKey.MapObjKey.OBJ_SL_INDEX, "$this$produce", e.TAG, MapBundleKey.MapObjKey.OBJ_SL_INDEX, "$this$produce", MapBundleKey.MapObjKey.OBJ_SL_INDEX}, s = {"L$0", "I$0", "L$0", "L$2", "I$0", "L$0", "I$0"})
/* loaded from: classes6.dex */
public final class ChannelsKt__DeprecatedKt$filterIndexed$1 extends SuspendLambda implements Oox.x0xO0oo<IXxxXO<Object>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ Oox.IXxxXO<Integer, Object, kotlin.coroutines.I0Io<? super Boolean>, Object> $predicate;
    final /* synthetic */ ReceiveChannel<Object> $this_filterIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$filterIndexed$1(ReceiveChannel<Object> receiveChannel, Oox.IXxxXO<? super Integer, Object, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> iXxxXO, kotlin.coroutines.I0Io<? super ChannelsKt__DeprecatedKt$filterIndexed$1> i0Io) {
        super(2, i0Io);
        this.$this_filterIndexed = receiveChannel;
        this.$predicate = iXxxXO;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        ChannelsKt__DeprecatedKt$filterIndexed$1 channelsKt__DeprecatedKt$filterIndexed$1 = new ChannelsKt__DeprecatedKt$filterIndexed$1(this.$this_filterIndexed, this.$predicate, i0Io);
        channelsKt__DeprecatedKt$filterIndexed$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filterIndexed$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
    
        r7 = r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00af  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@OXOo.OOXIXo java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r1 = r11.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L49
            if (r1 == r5) goto L3b
            if (r1 == r4) goto L28
            if (r1 != r3) goto L20
            int r1 = r11.I$0
            java.lang.Object r6 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r11.L$0
            kotlinx.coroutines.channels.IXxxXO r7 = (kotlinx.coroutines.channels.IXxxXO) r7
            kotlin.I0oOoX.x0XOIxOo(r12)
            goto L5a
        L20:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L28:
            int r1 = r11.I$0
            java.lang.Object r6 = r11.L$2
            java.lang.Object r7 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r8 = r11.L$0
            kotlinx.coroutines.channels.IXxxXO r8 = (kotlinx.coroutines.channels.IXxxXO) r8
            kotlin.I0oOoX.x0XOIxOo(r12)
            r10 = r7
            r7 = r6
            r6 = r10
            goto L94
        L3b:
            int r1 = r11.I$0
            java.lang.Object r6 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r11.L$0
            kotlinx.coroutines.channels.IXxxXO r7 = (kotlinx.coroutines.channels.IXxxXO) r7
            kotlin.I0oOoX.x0XOIxOo(r12)
            goto L6b
        L49:
            kotlin.I0oOoX.x0XOIxOo(r12)
            java.lang.Object r12 = r11.L$0
            kotlinx.coroutines.channels.IXxxXO r12 = (kotlinx.coroutines.channels.IXxxXO) r12
            kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r1 = r11.$this_filterIndexed
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r6 = 0
            r7 = r12
            r6 = r1
            r1 = 0
        L5a:
            r11.L$0 = r7
            r11.L$1 = r6
            r11.L$2 = r2
            r11.I$0 = r1
            r11.label = r5
            java.lang.Object r12 = r6.I0Io(r11)
            if (r12 != r0) goto L6b
            return r0
        L6b:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto Laf
            java.lang.Object r12 = r6.next()
            Oox.IXxxXO<java.lang.Integer, java.lang.Object, kotlin.coroutines.I0Io<? super java.lang.Boolean>, java.lang.Object> r8 = r11.$predicate
            int r9 = r1 + 1
            java.lang.Integer r1 = IXIxx0.oIX0oI.XO(r1)
            r11.L$0 = r7
            r11.L$1 = r6
            r11.L$2 = r12
            r11.I$0 = r9
            r11.label = r4
            java.lang.Object r1 = r8.invoke(r1, r12, r11)
            if (r1 != r0) goto L90
            return r0
        L90:
            r8 = r7
            r7 = r12
            r12 = r1
            r1 = r9
        L94:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto Lad
            r11.L$0 = r8
            r11.L$1 = r6
            r11.L$2 = r2
            r11.I$0 = r1
            r11.label = r3
            java.lang.Object r12 = r8.XOxIOxOx(r7, r11)
            if (r12 != r0) goto Lad
            return r0
        Lad:
            r7 = r8
            goto L5a
        Laf:
            kotlin.oXIO0o0XI r12 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo IXxxXO<Object> iXxxXO, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((ChannelsKt__DeprecatedKt$filterIndexed$1) create(iXxxXO, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
