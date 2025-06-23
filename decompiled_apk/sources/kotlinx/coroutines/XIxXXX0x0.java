package kotlinx.coroutines;

import com.goodix.ble.libcomx.util.HexStringBuilder;

@kotlin.jvm.internal.XX({"SMAP\nCancellableContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CompletedContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,662:1\n1#2:663\n*E\n"})
/* loaded from: classes6.dex */
public final class XIxXXX0x0 {

    /* renamed from: I0Io, reason: collision with root package name */
    @XO0OX.XO
    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<Throwable, kotlin.oXIO0o0XI> f29760I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @XO0OX.XO
    @OXOo.oOoXoXO
    public final ooOOo0oXI f29761II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @XO0OX.XO
    @OXOo.oOoXoXO
    public final Throwable f29762X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @XO0OX.XO
    @OXOo.oOoXoXO
    public final Object f29763oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @XO0OX.XO
    @OXOo.oOoXoXO
    public final Object f29764oxoX;

    /* JADX WARN: Multi-variable type inference failed */
    public XIxXXX0x0(@OXOo.oOoXoXO Object obj, @OXOo.oOoXoXO ooOOo0oXI ooooo0oxi, @OXOo.oOoXoXO Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo, @OXOo.oOoXoXO Object obj2, @OXOo.oOoXoXO Throwable th) {
        this.f29763oIX0oI = obj;
        this.f29761II0xO0 = ooooo0oxi;
        this.f29760I0Io = oooxoxo;
        this.f29764oxoX = obj2;
        this.f29762X0o0xo = th;
    }

    public static /* synthetic */ XIxXXX0x0 Oxx0IOOO(XIxXXX0x0 xIxXXX0x0, Object obj, ooOOo0oXI ooooo0oxi, Oox.oOoXoXO oooxoxo, Object obj2, Throwable th, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = xIxXXX0x0.f29763oIX0oI;
        }
        if ((i & 2) != 0) {
            ooooo0oxi = xIxXXX0x0.f29761II0xO0;
        }
        ooOOo0oXI ooooo0oxi2 = ooooo0oxi;
        if ((i & 4) != 0) {
            oooxoxo = xIxXXX0x0.f29760I0Io;
        }
        Oox.oOoXoXO oooxoxo2 = oooxoxo;
        if ((i & 8) != 0) {
            obj2 = xIxXXX0x0.f29764oxoX;
        }
        Object obj4 = obj2;
        if ((i & 16) != 0) {
            th = xIxXXX0x0.f29762X0o0xo;
        }
        return xIxXXX0x0.XO(obj, ooooo0oxi2, oooxoxo2, obj4, th);
    }

    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<Throwable, kotlin.oXIO0o0XI> I0Io() {
        return this.f29760I0Io;
    }

    public final boolean II0XooXoX() {
        if (this.f29762X0o0xo != null) {
            return true;
        }
        return false;
    }

    @OXOo.oOoXoXO
    public final ooOOo0oXI II0xO0() {
        return this.f29761II0xO0;
    }

    @OXOo.oOoXoXO
    public final Throwable X0o0xo() {
        return this.f29762X0o0xo;
    }

    @OXOo.OOXIXo
    public final XIxXXX0x0 XO(@OXOo.oOoXoXO Object obj, @OXOo.oOoXoXO ooOOo0oXI ooooo0oxi, @OXOo.oOoXoXO Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo, @OXOo.oOoXoXO Object obj2, @OXOo.oOoXoXO Throwable th) {
        return new XIxXXX0x0(obj, ooooo0oxi, oooxoxo, obj2, th);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XIxXXX0x0)) {
            return false;
        }
        XIxXXX0x0 xIxXXX0x0 = (XIxXXX0x0) obj;
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f29763oIX0oI, xIxXXX0x0.f29763oIX0oI) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f29761II0xO0, xIxXXX0x0.f29761II0xO0) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f29760I0Io, xIxXXX0x0.f29760I0Io) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f29764oxoX, xIxXXX0x0.f29764oxoX) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f29762X0o0xo, xIxXXX0x0.f29762X0o0xo);
    }

    public int hashCode() {
        Object obj = this.f29763oIX0oI;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        ooOOo0oXI ooooo0oxi = this.f29761II0xO0;
        int hashCode2 = (hashCode + (ooooo0oxi == null ? 0 : ooooo0oxi.hashCode())) * 31;
        Oox.oOoXoXO<Throwable, kotlin.oXIO0o0XI> oooxoxo = this.f29760I0Io;
        int hashCode3 = (hashCode2 + (oooxoxo == null ? 0 : oooxoxo.hashCode())) * 31;
        Object obj2 = this.f29764oxoX;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f29762X0o0xo;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    @OXOo.oOoXoXO
    public final Object oIX0oI() {
        return this.f29763oIX0oI;
    }

    @OXOo.oOoXoXO
    public final Object oxoX() {
        return this.f29764oxoX;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "CompletedContinuation(result=" + this.f29763oIX0oI + ", cancelHandler=" + this.f29761II0xO0 + ", onCancellation=" + this.f29760I0Io + ", idempotentResume=" + this.f29764oxoX + ", cancelCause=" + this.f29762X0o0xo + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final void xxIXOIIO(@OXOo.OOXIXo x0xO0oo<?> x0xo0oo, @OXOo.OOXIXo Throwable th) {
        ooOOo0oXI ooooo0oxi = this.f29761II0xO0;
        if (ooooo0oxi != null) {
            x0xo0oo.ooOOo0oXI(ooooo0oxi, th);
        }
        Oox.oOoXoXO<Throwable, kotlin.oXIO0o0XI> oooxoxo = this.f29760I0Io;
        if (oooxoxo != null) {
            x0xo0oo.oO(oooxoxo, th);
        }
    }

    public /* synthetic */ XIxXXX0x0(Object obj, ooOOo0oXI ooooo0oxi, Oox.oOoXoXO oooxoxo, Object obj2, Throwable th, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(obj, (i & 2) != 0 ? null : ooooo0oxi, (i & 4) != 0 ? null : oooxoxo, (i & 8) != 0 ? null : obj2, (i & 16) != 0 ? null : th);
    }
}
