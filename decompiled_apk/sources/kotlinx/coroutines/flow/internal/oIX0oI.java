package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Result;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.flow.IIXOooo;
import kotlinx.coroutines.flow.internal.I0Io;

@XX({"SMAP\nAbstractSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,132:1\n28#2,4:133\n28#2,4:138\n28#2,4:144\n20#3:137\n20#3:142\n20#3:148\n1#4:143\n13579#5,2:149\n*S KotlinDebug\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n*L\n30#1:133,4\n45#1:138,4\n76#1:144,4\n30#1:137\n45#1:142\n76#1:148\n95#1:149,2\n*E\n"})
/* loaded from: classes6.dex */
public abstract class oIX0oI<S extends I0Io<?>> {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f30192IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public int f30193Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public oO f30194Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public S[] f30195XO;

    public static final /* synthetic */ I0Io[] Oxx0IOOO(oIX0oI oix0oi) {
        return oix0oi.f30195XO;
    }

    public static final /* synthetic */ int XO(oIX0oI oix0oi) {
        return oix0oi.f30193Oo;
    }

    @OXOo.OOXIXo
    public final S II0XooXoX() {
        S s;
        oO oOVar;
        synchronized (this) {
            try {
                S[] sArr = this.f30195XO;
                if (sArr == null) {
                    sArr = xoIox(2);
                    this.f30195XO = sArr;
                } else if (this.f30193Oo >= sArr.length) {
                    Object[] copyOf = Arrays.copyOf(sArr, sArr.length * 2);
                    IIX0o.oO(copyOf, "copyOf(this, newSize)");
                    this.f30195XO = (S[]) ((I0Io[]) copyOf);
                    sArr = (S[]) ((I0Io[]) copyOf);
                }
                int i = this.f30192IXxxXO;
                do {
                    s = sArr[i];
                    if (s == null) {
                        s = xxIXOIIO();
                        sArr[i] = s;
                    }
                    i++;
                    if (i >= sArr.length) {
                        i = 0;
                    }
                    IIX0o.x0XOIxOo(s, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!s.oIX0oI(this));
                this.f30192IXxxXO = i;
                this.f30193Oo++;
                oOVar = this.f30194Oxx0xo;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (oOVar != null) {
            oOVar.XX0(1);
        }
        return s;
    }

    public final void OOXIXo(@OXOo.OOXIXo Oox.oOoXoXO<? super S, oXIO0o0XI> oooxoxo) {
        I0Io[] i0IoArr;
        if (this.f30193Oo != 0 && (i0IoArr = this.f30195XO) != null) {
            for (I0Io i0Io : i0IoArr) {
                if (i0Io != null) {
                    oooxoxo.invoke(i0Io);
                }
            }
        }
    }

    public final void oOoXoXO(@OXOo.OOXIXo S s) {
        oO oOVar;
        int i;
        kotlin.coroutines.I0Io<oXIO0o0XI>[] II0xO02;
        synchronized (this) {
            try {
                int i2 = this.f30193Oo - 1;
                this.f30193Oo = i2;
                oOVar = this.f30194Oxx0xo;
                if (i2 == 0) {
                    this.f30192IXxxXO = 0;
                }
                IIX0o.x0XOIxOo(s, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                II0xO02 = s.II0xO0(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (kotlin.coroutines.I0Io<oXIO0o0XI> i0Io : II0xO02) {
            if (i0Io != null) {
                Result.oIX0oI oix0oi = Result.Companion;
                i0Io.resumeWith(Result.m287constructorimpl(oXIO0o0XI.f29392oIX0oI));
            }
        }
        if (oOVar != null) {
            oOVar.XX0(-1);
        }
    }

    public final int ooOOo0oXI() {
        return this.f30193Oo;
    }

    @OXOo.OOXIXo
    public final IIXOooo<Integer> oxoX() {
        oO oOVar;
        synchronized (this) {
            oOVar = this.f30194Oxx0xo;
            if (oOVar == null) {
                oOVar = new oO(this.f30193Oo);
                this.f30194Oxx0xo = oOVar;
            }
        }
        return oOVar;
    }

    @OXOo.oOoXoXO
    public final S[] x0XOIxOo() {
        return this.f30195XO;
    }

    @OXOo.OOXIXo
    public abstract S[] xoIox(int i);

    @OXOo.OOXIXo
    public abstract S xxIXOIIO();
}
