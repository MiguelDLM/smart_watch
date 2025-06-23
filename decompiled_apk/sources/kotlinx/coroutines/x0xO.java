package kotlinx.coroutines;

@kotlin.jvm.internal.XX({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoop\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n1#2:544\n*E\n"})
/* loaded from: classes6.dex */
public abstract class x0xO extends CoroutineDispatcher {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public kotlin.collections.xxIXOIIO<XX0<?>> f30463IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f30464Oo;

    /* renamed from: XO, reason: collision with root package name */
    public long f30465XO;

    public static /* synthetic */ void XxX0x0xxx(x0xO x0xo, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            x0xo.xxX(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public static /* synthetic */ void xoXoI(x0xO x0xo, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            x0xo.IIXOooo(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    public final void IIXOooo(boolean z) {
        long o002 = this.f30465XO - o00(z);
        this.f30465XO = o002;
        if (o002 <= 0 && this.f30464Oo) {
            shutdown();
        }
    }

    public final boolean IO() {
        XX0<?> oO2;
        kotlin.collections.xxIXOIIO<XX0<?>> xxixoiio = this.f30463IXxxXO;
        if (xxixoiio == null || (oO2 = xxixoiio.oO()) == null) {
            return false;
        }
        oO2.run();
        return true;
    }

    public long X00IoxXI() {
        if (!IO()) {
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    public final void X0IIOO(@OXOo.OOXIXo XX0<?> xx02) {
        kotlin.collections.xxIXOIIO<XX0<?>> xxixoiio = this.f30463IXxxXO;
        if (xxixoiio == null) {
            xxixoiio = new kotlin.collections.xxIXOIIO<>();
            this.f30463IXxxXO = xxixoiio;
        }
        xxixoiio.addLast(xx02);
    }

    public long XIxXXX0x0() {
        kotlin.collections.xxIXOIIO<XX0<?>> xxixoiio = this.f30463IXxxXO;
        if (xxixoiio == null || xxixoiio.isEmpty()) {
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    public final boolean Xx000oIo() {
        kotlin.collections.xxIXOIIO<XX0<?>> xxixoiio = this.f30463IXxxXO;
        if (xxixoiio != null) {
            return xxixoiio.isEmpty();
        }
        return true;
    }

    public final boolean isActive() {
        if (this.f30465XO > 0) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @OXOo.OOXIXo
    public final CoroutineDispatcher limitedParallelism(int i) {
        kotlinx.coroutines.internal.oI0IIXIo.oIX0oI(i);
        return this;
    }

    public final long o00(boolean z) {
        return z ? 4294967296L : 1L;
    }

    public final boolean oo0xXOI0I() {
        if (this.f30465XO >= o00(true)) {
            return true;
        }
        return false;
    }

    public boolean ooXIXxIX() {
        return Xx000oIo();
    }

    public void shutdown() {
    }

    public boolean xII() {
        return false;
    }

    public final void xxX(boolean z) {
        this.f30465XO += o00(z);
        if (!z) {
            this.f30464Oo = true;
        }
    }
}
