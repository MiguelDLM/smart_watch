package kotlinx.coroutines.selects;

import Oox.IXxxXO;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public /* synthetic */ class OnTimeout$selectClause$1 extends FunctionReferenceImpl implements IXxxXO<OnTimeout, xoIox<?>, Object, oXIO0o0XI> {
    public static final OnTimeout$selectClause$1 INSTANCE = new OnTimeout$selectClause$1();

    public OnTimeout$selectClause$1() {
        super(3, OnTimeout.class, "register", "register(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // Oox.IXxxXO
    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(OnTimeout onTimeout, xoIox<?> xoiox, Object obj) {
        invoke2(onTimeout, xoiox, obj);
        return oXIO0o0XI.f29392oIX0oI;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@OXOo.OOXIXo OnTimeout onTimeout, @OXOo.OOXIXo xoIox<?> xoiox, @OXOo.oOoXoXO Object obj) {
        onTimeout.oxoX(xoiox, obj);
    }
}
