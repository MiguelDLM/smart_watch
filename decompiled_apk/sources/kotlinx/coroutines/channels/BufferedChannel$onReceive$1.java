package kotlinx.coroutines.channels;

import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public /* synthetic */ class BufferedChannel$onReceive$1 extends FunctionReferenceImpl implements Oox.IXxxXO<BufferedChannel<?>, kotlinx.coroutines.selects.xoIox<?>, Object, oXIO0o0XI> {
    public static final BufferedChannel$onReceive$1 INSTANCE = new BufferedChannel$onReceive$1();

    public BufferedChannel$onReceive$1() {
        super(3, BufferedChannel.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // Oox.IXxxXO
    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(BufferedChannel<?> bufferedChannel, kotlinx.coroutines.selects.xoIox<?> xoiox, Object obj) {
        invoke2(bufferedChannel, xoiox, obj);
        return oXIO0o0XI.f29392oIX0oI;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@OXOo.OOXIXo BufferedChannel<?> bufferedChannel, @OXOo.OOXIXo kotlinx.coroutines.selects.xoIox<?> xoiox, @OXOo.oOoXoXO Object obj) {
        bufferedChannel.xxOXOOoIX(xoiox, obj);
    }
}
