package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.internal.x0o;

@XX({"SMAP\nSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,731:1\n1#2:732\n*E\n"})
/* loaded from: classes6.dex */
public final class oO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public static final x0o f30205oIX0oI = new x0o("NO_VALUE");

    public static final /* synthetic */ Object I0Io(Object[] objArr, long j) {
        return XO(objArr, j);
    }

    public static /* synthetic */ xxIXOIIO II0xO0(int i, int i2, BufferOverflow bufferOverflow, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return oIX0oI(i, i2, bufferOverflow);
    }

    public static final void Oxx0IOOO(Object[] objArr, long j, Object obj) {
        objArr[(objArr.length - 1) & ((int) j)] = obj;
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> X0o0xo(@OXOo.OOXIXo x0XOIxOo<? extends T> x0xoixoo, @OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        if ((i == 0 || i == -3) && bufferOverflow == BufferOverflow.SUSPEND) {
            return x0xoixoo;
        }
        return new kotlinx.coroutines.flow.internal.X0o0xo(x0xoixoo, coroutineContext, i, bufferOverflow);
    }

    public static final Object XO(Object[] objArr, long j) {
        return objArr[(objArr.length - 1) & ((int) j)];
    }

    @OXOo.OOXIXo
    public static final <T> xxIXOIIO<T> oIX0oI(int i, int i2, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        if (i >= 0) {
            if (i2 >= 0) {
                if (i <= 0 && i2 <= 0 && bufferOverflow != BufferOverflow.SUSPEND) {
                    throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + bufferOverflow).toString());
                }
                int i3 = i2 + i;
                if (i3 < 0) {
                    i3 = Integer.MAX_VALUE;
                }
                return new SharedFlowImpl(i, i3, bufferOverflow);
            }
            throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + i2).toString());
        }
        throw new IllegalArgumentException(("replay cannot be negative, but was " + i).toString());
    }

    public static final /* synthetic */ void oxoX(Object[] objArr, long j, Object obj) {
        Oxx0IOOO(objArr, j, obj);
    }
}
