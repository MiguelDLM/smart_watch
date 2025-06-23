package kotlinx.coroutines.channels;

import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;

/* JADX INFO: Add missing generic type declarations: [R] */
@IXIxx0.oxoX(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {344, 345, 345}, m = "invokeSuspend", n = {"$this$produce", MapBundleKey.MapObjKey.OBJ_SL_INDEX, "$this$produce", MapBundleKey.MapObjKey.OBJ_SL_INDEX, "$this$produce", MapBundleKey.MapObjKey.OBJ_SL_INDEX}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
/* loaded from: classes6.dex */
public final class ChannelsKt__DeprecatedKt$mapIndexed$1<R> extends SuspendLambda implements Oox.x0xO0oo<IXxxXO<? super R>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ ReceiveChannel<E> $this_mapIndexed;
    final /* synthetic */ Oox.IXxxXO<Integer, E, kotlin.coroutines.I0Io<? super R>, Object> $transform;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$mapIndexed$1(ReceiveChannel<? extends E> receiveChannel, Oox.IXxxXO<? super Integer, ? super E, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> iXxxXO, kotlin.coroutines.I0Io<? super ChannelsKt__DeprecatedKt$mapIndexed$1> i0Io) {
        super(2, i0Io);
        this.$this_mapIndexed = receiveChannel;
        this.$transform = iXxxXO;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        ChannelsKt__DeprecatedKt$mapIndexed$1 channelsKt__DeprecatedKt$mapIndexed$1 = new ChannelsKt__DeprecatedKt$mapIndexed$1(this.$this_mapIndexed, this.$transform, i0Io);
        channelsKt__DeprecatedKt$mapIndexed$1.L$0 = obj;
        return channelsKt__DeprecatedKt$mapIndexed$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00a5 -> B:7:0x0058). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@OXOo.OOXIXo java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r1 = r10.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L48
            if (r1 == r4) goto L3a
            if (r1 == r3) goto L28
            if (r1 != r2) goto L20
            int r1 = r10.I$0
            java.lang.Object r5 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r10.L$0
            kotlinx.coroutines.channels.IXxxXO r6 = (kotlinx.coroutines.channels.IXxxXO) r6
            kotlin.I0oOoX.x0XOIxOo(r11)
            r11 = r6
            goto L58
        L20:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L28:
            int r1 = r10.I$0
            java.lang.Object r5 = r10.L$2
            kotlinx.coroutines.channels.IXxxXO r5 = (kotlinx.coroutines.channels.IXxxXO) r5
            java.lang.Object r6 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r10.L$0
            kotlinx.coroutines.channels.IXxxXO r7 = (kotlinx.coroutines.channels.IXxxXO) r7
            kotlin.I0oOoX.x0XOIxOo(r11)
            goto L93
        L3a:
            int r1 = r10.I$0
            java.lang.Object r5 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r10.L$0
            kotlinx.coroutines.channels.IXxxXO r6 = (kotlinx.coroutines.channels.IXxxXO) r6
            kotlin.I0oOoX.x0XOIxOo(r11)
            goto L6a
        L48:
            kotlin.I0oOoX.x0XOIxOo(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.channels.IXxxXO r11 = (kotlinx.coroutines.channels.IXxxXO) r11
            kotlinx.coroutines.channels.ReceiveChannel<E> r1 = r10.$this_mapIndexed
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r5 = 0
            r5 = r1
            r1 = 0
        L58:
            r10.L$0 = r11
            r10.L$1 = r5
            r10.I$0 = r1
            r10.label = r4
            java.lang.Object r6 = r5.I0Io(r10)
            if (r6 != r0) goto L67
            return r0
        L67:
            r9 = r6
            r6 = r11
            r11 = r9
        L6a:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto La8
            java.lang.Object r11 = r5.next()
            Oox.IXxxXO<java.lang.Integer, E, kotlin.coroutines.I0Io<? super R>, java.lang.Object> r7 = r10.$transform
            int r8 = r1 + 1
            java.lang.Integer r1 = IXIxx0.oIX0oI.XO(r1)
            r10.L$0 = r6
            r10.L$1 = r5
            r10.L$2 = r6
            r10.I$0 = r8
            r10.label = r3
            java.lang.Object r11 = r7.invoke(r1, r11, r10)
            if (r11 != r0) goto L8f
            return r0
        L8f:
            r7 = r6
            r1 = r8
            r6 = r5
            r5 = r7
        L93:
            r10.L$0 = r7
            r10.L$1 = r6
            r8 = 0
            r10.L$2 = r8
            r10.I$0 = r1
            r10.label = r2
            java.lang.Object r11 = r5.XOxIOxOx(r11, r10)
            if (r11 != r0) goto La5
            return r0
        La5:
            r5 = r6
            r11 = r7
            goto L58
        La8:
            kotlin.oXIO0o0XI r11 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo IXxxXO<? super R> iXxxXO, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((ChannelsKt__DeprecatedKt$mapIndexed$1) create(iXxxXO, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
