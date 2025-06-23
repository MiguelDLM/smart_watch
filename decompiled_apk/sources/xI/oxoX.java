package xI;

import IOI.xOOOX;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class oxoX {

    /* renamed from: oxoX, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f34116oxoX = new oIX0oI(null);

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f34117I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f34118II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f34119oIX0oI;

    /* loaded from: classes8.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        @oOoXoXO
        public final oxoX oIX0oI(double d) {
            IIXOooo iIXOooo = null;
            if (Double.isInfinite(d) || Double.isNaN(d)) {
                return null;
            }
            double floor = Math.floor(d);
            double floor2 = Math.floor((d - floor) * 60.0d);
            double d2 = 60;
            return new oxoX((int) floor, (int) floor2, (int) Math.floor((d - ((floor2 / 60.0d) + floor)) * d2 * d2), iIXOooo);
        }

        public oIX0oI() {
        }
    }

    public /* synthetic */ oxoX(int i, int i2, int i3, IIXOooo iIXOooo) {
        this(i, i2, i3);
    }

    public final int I0Io() {
        return this.f34118II0xO0;
    }

    public final int II0xO0() {
        return this.f34119oIX0oI;
    }

    @OOXIXo
    public final xOOOX oIX0oI(@OOXIXo I0Io date) {
        IIX0o.x0xO0oo(date, "date");
        return II0xO0.f34114oIX0oI.II0xO0(new xOOOX(date.I0Io(), date.II0xO0(), date.oIX0oI(), 0, this.f34118II0xO0, this.f34117I0Io, 0, 64, (IIXOooo) null), this.f34119oIX0oI, IOI.oOoXoXO.Companion.I0Io());
    }

    public final int oxoX() {
        return this.f34117I0Io;
    }

    public oxoX(int i, int i2, int i3) {
        this.f34119oIX0oI = i;
        this.f34118II0xO0 = i2;
        this.f34117I0Io = i3;
    }
}
