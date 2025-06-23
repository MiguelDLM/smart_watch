package kotlinx.coroutines.flow;

import kotlin.X00IoxXI;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.OOXIxO0;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;
import kotlinx.coroutines.xII;

@XX({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,415:1\n1#2:416\n*E\n"})
/* loaded from: classes6.dex */
public final /* synthetic */ class FlowKt__DelayKt {
    @OXOo.OOXIXo
    @OOXIxO0
    public static final <T> X0o0xo<T> I0Io(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, long j) {
        return Oxx0IOOO.oxXx0IX(x0o0xo, DelayKt.X0o0xo(j));
    }

    @OXOo.OOXIXo
    @OOXIxO0
    public static final <T> X0o0xo<T> II0XooXoX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, long j) {
        if (j > 0) {
            return FlowCoroutineKt.II0xO0(new FlowKt__DelayKt$sample$2(j, x0o0xo, null));
        }
        throw new IllegalArgumentException("Sample period should be positive");
    }

    @OXOo.OOXIXo
    @X00IoxXI
    @OOXIxO0
    public static final <T> X0o0xo<T> II0xO0(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Long> oooxoxo) {
        return X0o0xo(x0o0xo, oooxoxo);
    }

    public static final <T> X0o0xo<T> OOXIXo(X0o0xo<? extends T> x0o0xo, long j) {
        return FlowCoroutineKt.II0xO0(new FlowKt__DelayKt$timeoutInternal$1(j, x0o0xo, null));
    }

    public static /* synthetic */ ReceiveChannel Oxx0IOOO(xII xii, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        return Oxx0IOOO.OOXIxO0(xii, j, j2);
    }

    public static final <T> X0o0xo<T> X0o0xo(X0o0xo<? extends T> x0o0xo, Oox.oOoXoXO<? super T, Long> oooxoxo) {
        return FlowCoroutineKt.II0xO0(new FlowKt__DelayKt$debounceInternal$1(oooxoxo, x0o0xo, null));
    }

    @OXOo.OOXIXo
    public static final ReceiveChannel<oXIO0o0XI> XO(@OXOo.OOXIXo xII xii, long j, long j2) {
        if (j >= 0) {
            if (j2 >= 0) {
                return ProduceKt.XO(xii, null, 0, new FlowKt__DelayKt$fixedPeriodTicker$3(j2, j, null), 1, null);
            }
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j2 + " ms").toString());
        }
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + j + " ms").toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    @OOXIxO0
    public static final <T> X0o0xo<T> oIX0oI(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, final long j) {
        if (j >= 0) {
            if (j == 0) {
                return x0o0xo;
            }
            return X0o0xo(x0o0xo, new Oox.oOoXoXO<T, Long>() { // from class: kotlinx.coroutines.flow.FlowKt__DelayKt$debounce$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oOoXoXO
                @OXOo.OOXIXo
                public final Long invoke(T t) {
                    return Long.valueOf(j);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Long invoke(Object obj) {
                    return invoke((FlowKt__DelayKt$debounce$2<T>) obj);
                }
            });
        }
        throw new IllegalArgumentException("Debounce timeout should not be negative");
    }

    @OXOo.OOXIXo
    @OOXIxO0
    @XO0OX.xxIXOIIO(name = "debounceDuration")
    @X00IoxXI
    public static final <T> X0o0xo<T> oxoX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo final Oox.oOoXoXO<? super T, kotlin.time.oxoX> oooxoxo) {
        return X0o0xo(x0o0xo, new Oox.oOoXoXO<T, Long>() { // from class: kotlinx.coroutines.flow.FlowKt__DelayKt$debounce$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ Long invoke(Object obj) {
                return invoke((FlowKt__DelayKt$debounce$3<T>) obj);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final Long invoke(T t) {
                return Long.valueOf(DelayKt.X0o0xo(oooxoxo.invoke(t).IIxOXoOo0()));
            }
        });
    }

    @OXOo.OOXIXo
    @OOXIxO0
    public static final <T> X0o0xo<T> xoIox(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, long j) {
        return OOXIXo(x0o0xo, j);
    }

    @OXOo.OOXIXo
    @OOXIxO0
    public static final <T> X0o0xo<T> xxIXOIIO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, long j) {
        return Oxx0IOOO.OIx00oxx(x0o0xo, DelayKt.X0o0xo(j));
    }
}
