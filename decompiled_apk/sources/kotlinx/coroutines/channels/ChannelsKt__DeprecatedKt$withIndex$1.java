package kotlinx.coroutines.channels;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.garmin.fit.IXXIXx00I;
import kotlin.collections.xI;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;

@IXIxx0.oxoX(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {IXXIXx00I.f11791xxOXOOoIX, IXXIXx00I.f11780xXoOI00O}, m = "invokeSuspend", n = {"$this$produce", MapBundleKey.MapObjKey.OBJ_SL_INDEX, "$this$produce", MapBundleKey.MapObjKey.OBJ_SL_INDEX}, s = {"L$0", "I$0", "L$0", "I$0"})
/* loaded from: classes6.dex */
public final class ChannelsKt__DeprecatedKt$withIndex$1 extends SuspendLambda implements Oox.x0xO0oo<IXxxXO<? super xI<Object>>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $this_withIndex;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$withIndex$1(ReceiveChannel<Object> receiveChannel, kotlin.coroutines.I0Io<? super ChannelsKt__DeprecatedKt$withIndex$1> i0Io) {
        super(2, i0Io);
        this.$this_withIndex = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        ChannelsKt__DeprecatedKt$withIndex$1 channelsKt__DeprecatedKt$withIndex$1 = new ChannelsKt__DeprecatedKt$withIndex$1(this.$this_withIndex, i0Io);
        channelsKt__DeprecatedKt$withIndex$1.L$0 = obj;
        return channelsKt__DeprecatedKt$withIndex$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x007b -> B:6:0x0044). Please report as a decompilation issue!!! */
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
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L36
            if (r1 == r3) goto L28
            if (r1 != r2) goto L20
            int r1 = r10.I$0
            java.lang.Object r4 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r10.L$0
            kotlinx.coroutines.channels.IXxxXO r5 = (kotlinx.coroutines.channels.IXxxXO) r5
            kotlin.I0oOoX.x0XOIxOo(r11)
            r11 = r5
            r8 = r4
            r4 = r1
            r1 = r8
            goto L44
        L20:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L28:
            int r1 = r10.I$0
            java.lang.Object r4 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r10.L$0
            kotlinx.coroutines.channels.IXxxXO r5 = (kotlinx.coroutines.channels.IXxxXO) r5
            kotlin.I0oOoX.x0XOIxOo(r11)
            goto L59
        L36:
            kotlin.I0oOoX.x0XOIxOo(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.channels.IXxxXO r11 = (kotlinx.coroutines.channels.IXxxXO) r11
            kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r1 = r10.$this_withIndex
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r4 = 0
        L44:
            r10.L$0 = r11
            r10.L$1 = r1
            r10.I$0 = r4
            r10.label = r3
            java.lang.Object r5 = r1.I0Io(r10)
            if (r5 != r0) goto L53
            return r0
        L53:
            r8 = r5
            r5 = r11
            r11 = r8
            r9 = r4
            r4 = r1
            r1 = r9
        L59:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L7f
            java.lang.Object r11 = r4.next()
            kotlin.collections.xI r6 = new kotlin.collections.xI
            int r7 = r1 + 1
            r6.<init>(r1, r11)
            r10.L$0 = r5
            r10.L$1 = r4
            r10.I$0 = r7
            r10.label = r2
            java.lang.Object r11 = r5.XOxIOxOx(r6, r10)
            if (r11 != r0) goto L7b
            return r0
        L7b:
            r1 = r4
            r11 = r5
            r4 = r7
            goto L44
        L7f:
            kotlin.oXIO0o0XI r11 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo IXxxXO<? super xI<Object>> iXxxXO, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((ChannelsKt__DeprecatedKt$withIndex$1) create(iXxxXO, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
