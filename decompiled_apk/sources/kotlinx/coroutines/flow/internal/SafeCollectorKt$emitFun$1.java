package kotlinx.coroutines.flow.internal;

import Oox.IXxxXO;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public /* synthetic */ class SafeCollectorKt$emitFun$1 extends FunctionReferenceImpl implements IXxxXO<kotlinx.coroutines.flow.XO<? super Object>, Object, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object>, IXIxx0.xoIox {
    public static final SafeCollectorKt$emitFun$1 INSTANCE = new SafeCollectorKt$emitFun$1();

    public SafeCollectorKt$emitFun$1() {
        super(3, kotlinx.coroutines.flow.XO.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // Oox.IXxxXO
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.flow.XO<? super Object> xo2, Object obj, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return invoke2((kotlinx.coroutines.flow.XO<Object>) xo2, obj, i0Io);
    }

    @OXOo.oOoXoXO
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@OXOo.OOXIXo kotlinx.coroutines.flow.XO<Object> xo2, @OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return xo2.emit(obj, i0Io);
    }
}
