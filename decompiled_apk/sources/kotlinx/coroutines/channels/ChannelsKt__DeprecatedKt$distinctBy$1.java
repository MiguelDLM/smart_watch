package kotlinx.coroutines.channels;

import com.garmin.fit.IXXIXx00I;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;

/* JADX INFO: Add missing generic type declarations: [E] */
@IXIxx0.oxoX(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {IXXIXx00I.f11718X0xxXX0, IXXIXx00I.f11682IO0XoXxO, 390}, m = "invokeSuspend", n = {"$this$produce", "keys", "$this$produce", "keys", e.TAG, "$this$produce", "keys", t.f18411a}, s = {"L$0", "L$1", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
/* loaded from: classes6.dex */
public final class ChannelsKt__DeprecatedKt$distinctBy$1<E> extends SuspendLambda implements Oox.x0xO0oo<IXxxXO<? super E>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ Oox.x0xO0oo<E, kotlin.coroutines.I0Io<? super K>, Object> $selector;
    final /* synthetic */ ReceiveChannel<E> $this_distinctBy;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$distinctBy$1(ReceiveChannel<? extends E> receiveChannel, Oox.x0xO0oo<? super E, ? super kotlin.coroutines.I0Io<? super K>, ? extends Object> x0xo0oo, kotlin.coroutines.I0Io<? super ChannelsKt__DeprecatedKt$distinctBy$1> i0Io) {
        super(2, i0Io);
        this.$this_distinctBy = receiveChannel;
        this.$selector = x0xo0oo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        ChannelsKt__DeprecatedKt$distinctBy$1 channelsKt__DeprecatedKt$distinctBy$1 = new ChannelsKt__DeprecatedKt$distinctBy$1(this.$this_distinctBy, this.$selector, i0Io);
        channelsKt__DeprecatedKt$distinctBy$1.L$0 = obj;
        return channelsKt__DeprecatedKt$distinctBy$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0078 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bd  */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00a1 -> B:8:0x00ba). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00b4 -> B:7:0x00b6). Please report as a decompilation issue!!! */
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
            if (r1 == 0) goto L51
            if (r1 == r4) goto L41
            if (r1 == r3) goto L2c
            if (r1 != r2) goto L24
            java.lang.Object r1 = r10.L$3
            java.lang.Object r5 = r10.L$2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r10.L$1
            java.util.HashSet r6 = (java.util.HashSet) r6
            java.lang.Object r7 = r10.L$0
            kotlinx.coroutines.channels.IXxxXO r7 = (kotlinx.coroutines.channels.IXxxXO) r7
            kotlin.I0oOoX.x0XOIxOo(r11)
            goto Lb6
        L24:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L2c:
            java.lang.Object r1 = r10.L$3
            java.lang.Object r5 = r10.L$2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r10.L$1
            java.util.HashSet r6 = (java.util.HashSet) r6
            java.lang.Object r7 = r10.L$0
            kotlinx.coroutines.channels.IXxxXO r7 = (kotlinx.coroutines.channels.IXxxXO) r7
            kotlin.I0oOoX.x0XOIxOo(r11)
            r9 = r5
            r5 = r1
            r1 = r9
            goto L9d
        L41:
            java.lang.Object r1 = r10.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r10.L$1
            java.util.HashSet r5 = (java.util.HashSet) r5
            java.lang.Object r6 = r10.L$0
            kotlinx.coroutines.channels.IXxxXO r6 = (kotlinx.coroutines.channels.IXxxXO) r6
            kotlin.I0oOoX.x0XOIxOo(r11)
            goto L79
        L51:
            kotlin.I0oOoX.x0XOIxOo(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.channels.IXxxXO r11 = (kotlinx.coroutines.channels.IXxxXO) r11
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            kotlinx.coroutines.channels.ReceiveChannel<E> r5 = r10.$this_distinctBy
            kotlinx.coroutines.channels.ChannelIterator r5 = r5.iterator()
            r6 = r11
            r9 = r5
            r5 = r1
            r1 = r9
        L67:
            r10.L$0 = r6
            r10.L$1 = r5
            r10.L$2 = r1
            r11 = 0
            r10.L$3 = r11
            r10.label = r4
            java.lang.Object r11 = r1.I0Io(r10)
            if (r11 != r0) goto L79
            return r0
        L79:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto Lbd
            java.lang.Object r11 = r1.next()
            Oox.x0xO0oo<E, kotlin.coroutines.I0Io<? super K>, java.lang.Object> r7 = r10.$selector
            r10.L$0 = r6
            r10.L$1 = r5
            r10.L$2 = r1
            r10.L$3 = r11
            r10.label = r3
            java.lang.Object r7 = r7.invoke(r11, r10)
            if (r7 != r0) goto L98
            return r0
        L98:
            r9 = r5
            r5 = r11
            r11 = r7
            r7 = r6
            r6 = r9
        L9d:
            boolean r8 = r6.contains(r11)
            if (r8 != 0) goto Lba
            r10.L$0 = r7
            r10.L$1 = r6
            r10.L$2 = r1
            r10.L$3 = r11
            r10.label = r2
            java.lang.Object r5 = r7.XOxIOxOx(r5, r10)
            if (r5 != r0) goto Lb4
            return r0
        Lb4:
            r5 = r1
            r1 = r11
        Lb6:
            r6.add(r1)
            r1 = r5
        Lba:
            r5 = r6
            r6 = r7
            goto L67
        Lbd:
            kotlin.oXIO0o0XI r11 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo IXxxXO<? super E> iXxxXO, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((ChannelsKt__DeprecatedKt$distinctBy$1) create(iXxxXO, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
