package kotlinx.coroutines.flow.internal;

import kotlin.jvm.internal.XX;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.IIXOooo;
import kotlinx.coroutines.flow.SharedFlowImpl;

@XX({"SMAP\nAbstractSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,132:1\n28#2,4:133\n28#2,4:138\n20#3:137\n20#3:142\n*S KotlinDebug\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow\n*L\n126#1:133,4\n128#1:138,4\n126#1:137\n128#1:142\n*E\n"})
/* loaded from: classes6.dex */
public final class oO extends SharedFlowImpl<Integer> implements IIXOooo<Integer> {
    public oO(int i) {
        super(1, Integer.MAX_VALUE, BufferOverflow.DROP_OLDEST);
        I0Io(Integer.valueOf(i));
    }

    public final boolean XX0(int i) {
        boolean I0Io2;
        synchronized (this) {
            I0Io2 = I0Io(Integer.valueOf(X00IoxXI().intValue() + i));
        }
        return I0Io2;
    }

    @Override // kotlinx.coroutines.flow.IIXOooo
    @OXOo.OOXIXo
    /* renamed from: xXOx, reason: merged with bridge method [inline-methods] */
    public Integer getValue() {
        Integer valueOf;
        synchronized (this) {
            valueOf = Integer.valueOf(X00IoxXI().intValue());
        }
        return valueOf;
    }
}
