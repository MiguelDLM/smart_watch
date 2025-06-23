package kotlin.reflect;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.IIX0o;
import kotlin.o0;
import kotlin.oxxXoxO;

@oxxXoxO(version = "1.1")
/* loaded from: classes6.dex */
public final class OxxIIOOXO {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f29399I0Io = new oIX0oI(null);

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public static final OxxIIOOXO f29400oxoX = new OxxIIOOXO(null, null);

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final Oxx0xo f29401II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final KVariance f29402oIX0oI;

    /* loaded from: classes6.dex */
    public /* synthetic */ class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f29403oIX0oI;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f29403oIX0oI = iArr;
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @o0
        public static /* synthetic */ void oxoX() {
        }

        @OXOo.OOXIXo
        public final OxxIIOOXO I0Io() {
            return OxxIIOOXO.f29400oxoX;
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final OxxIIOOXO II0xO0(@OXOo.OOXIXo Oxx0xo type) {
            IIX0o.x0xO0oo(type, "type");
            return new OxxIIOOXO(KVariance.OUT, type);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final OxxIIOOXO X0o0xo(@OXOo.OOXIXo Oxx0xo type) {
            IIX0o.x0xO0oo(type, "type");
            return new OxxIIOOXO(KVariance.INVARIANT, type);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final OxxIIOOXO oIX0oI(@OXOo.OOXIXo Oxx0xo type) {
            IIX0o.x0xO0oo(type, "type");
            return new OxxIIOOXO(KVariance.IN, type);
        }

        public oIX0oI() {
        }
    }

    public OxxIIOOXO(@OXOo.oOoXoXO KVariance kVariance, @OXOo.oOoXoXO Oxx0xo oxx0xo) {
        boolean z;
        String str;
        this.f29402oIX0oI = kVariance;
        this.f29401II0xO0 = oxx0xo;
        if (kVariance == null) {
            z = true;
        } else {
            z = false;
        }
        if (z == (oxx0xo == null)) {
            return;
        }
        if (kVariance == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + kVariance + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final OxxIIOOXO I0Io(@OXOo.OOXIXo Oxx0xo oxx0xo) {
        return f29399I0Io.oIX0oI(oxx0xo);
    }

    public static /* synthetic */ OxxIIOOXO X0o0xo(OxxIIOOXO oxxIIOOXO, KVariance kVariance, Oxx0xo oxx0xo, int i, Object obj) {
        if ((i & 1) != 0) {
            kVariance = oxxIIOOXO.f29402oIX0oI;
        }
        if ((i & 2) != 0) {
            oxx0xo = oxxIIOOXO.f29401II0xO0;
        }
        return oxxIIOOXO.oxoX(kVariance, oxx0xo);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final OxxIIOOXO XO(@OXOo.OOXIXo Oxx0xo oxx0xo) {
        return f29399I0Io.II0xO0(oxx0xo);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final OxxIIOOXO xxIXOIIO(@OXOo.OOXIXo Oxx0xo oxx0xo) {
        return f29399I0Io.X0o0xo(oxx0xo);
    }

    @OXOo.oOoXoXO
    public final KVariance II0XooXoX() {
        return this.f29402oIX0oI;
    }

    @OXOo.oOoXoXO
    public final Oxx0xo II0xO0() {
        return this.f29401II0xO0;
    }

    @OXOo.oOoXoXO
    public final Oxx0xo Oxx0IOOO() {
        return this.f29401II0xO0;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OxxIIOOXO)) {
            return false;
        }
        OxxIIOOXO oxxIIOOXO = (OxxIIOOXO) obj;
        return this.f29402oIX0oI == oxxIIOOXO.f29402oIX0oI && IIX0o.Oxx0IOOO(this.f29401II0xO0, oxxIIOOXO.f29401II0xO0);
    }

    public int hashCode() {
        KVariance kVariance = this.f29402oIX0oI;
        int hashCode = (kVariance == null ? 0 : kVariance.hashCode()) * 31;
        Oxx0xo oxx0xo = this.f29401II0xO0;
        return hashCode + (oxx0xo != null ? oxx0xo.hashCode() : 0);
    }

    @OXOo.oOoXoXO
    public final KVariance oIX0oI() {
        return this.f29402oIX0oI;
    }

    @OXOo.OOXIXo
    public final OxxIIOOXO oxoX(@OXOo.oOoXoXO KVariance kVariance, @OXOo.oOoXoXO Oxx0xo oxx0xo) {
        return new OxxIIOOXO(kVariance, oxx0xo);
    }

    @OXOo.OOXIXo
    public String toString() {
        int i;
        KVariance kVariance = this.f29402oIX0oI;
        if (kVariance == null) {
            i = -1;
        } else {
            i = II0xO0.f29403oIX0oI[kVariance.ordinal()];
        }
        if (i != -1) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return "out " + this.f29401II0xO0;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return "in " + this.f29401II0xO0;
            }
            return String.valueOf(this.f29401II0xO0);
        }
        return "*";
    }
}
