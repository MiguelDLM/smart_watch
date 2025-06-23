package kotlinx.coroutines.channels;

import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Add missing generic type declarations: [E] */
/* loaded from: classes6.dex */
public /* synthetic */ class BufferedChannelKt$createSegmentFunction$1<E> extends FunctionReferenceImpl implements Oox.x0xO0oo<Long, OOXIXo<E>, OOXIXo<E>> {
    public static final BufferedChannelKt$createSegmentFunction$1 INSTANCE = new BufferedChannelKt$createSegmentFunction$1();

    public BufferedChannelKt$createSegmentFunction$1() {
        super(2, BufferedChannelKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
    }

    @Override // Oox.x0xO0oo
    public /* bridge */ /* synthetic */ Object invoke(Long l, Object obj) {
        return invoke(l.longValue(), (OOXIXo) obj);
    }

    @OXOo.OOXIXo
    public final OOXIXo<E> invoke(long j, @OXOo.OOXIXo OOXIXo<E> oOXIXo) {
        OOXIXo<E> o002;
        o002 = BufferedChannelKt.o00(j, oOXIXo);
        return o002;
    }
}
